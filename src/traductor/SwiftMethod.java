package traductor;

import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.MethodGen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Convenience class to wrap the {@link MethodGen} class with new properties
 * from the Swift Language.
 * Created by Razor on 7/4/2017.
 *
 * @author Razor
 */
public class SwiftMethod {

    private MethodGen javaM;
    private String[] externalNames;
    private boolean[] argsConst;
    private LinkedList<HashMap<String, BCELNode>> symbols_table;
    private int locals;
    private LinkedList<String> functionPendingSignatures;

    /**
     * Builds a {@link SwiftMethod} with basic Swift features.
     *
     * @param javaM         the {@link MethodGen} that wrap the equivalent Java method.
     * @param argsConst     false if the ith parameter is a constant, true otherwise.
     * @param symbols_table reference to the a {@link HashMap} that represent the SymbolTable for the method,
     *                      should extends all the symbols from his parent method.
     */
    public SwiftMethod(MethodGen javaM, boolean[] argsConst, HashMap<String, BCELNode> symbols_table) {
        this.javaM = javaM;
        this.argsConst = argsConst;
        this.symbols_table = new LinkedList<>();
        this.symbols_table.addFirst(symbols_table);
        locals = argsConst.length;
        externalNames = new String[argsConst.length];
        functionPendingSignatures = new LinkedList<>();
    }

    /**
     * Get a signature list of pending functions(or methods) calls,
     * at the end of a method if it still has pending function calls declarations
     * the compiler should rise an error
     *
     * @return A {@link LinkedList} with the signature of the pending functions
     */
    public LinkedList<String> getFunctionPendingSignatures() {
        return functionPendingSignatures;
    }

    /**
     * Add a pending function signature, this happens when we found a function call but
     * it hasn't be declared before, we still have to wait to finish processing this method
     *
     * @param functionSignature The function signature to add.
     */
    public void addPendingSignature(String functionSignature) {
        functionPendingSignatures.add(functionSignature);
    }

    /**
     * Remove a pending function signature, this happens when we found the declaration of
     * a function that we have on the pending function call list.
     *
     * @param functionSignature The function signature to remove.
     * @return True if has been removed, false otherwise.
     */
    public boolean removePendingSignature(String functionSignature) {
        return functionPendingSignatures.remove(functionSignature);
    }


    public Method getMethod() {
        return javaM.getMethod();
    }

    public boolean isConst(int index) {
        return argsConst[index];
    }

    public boolean isConst(String externalName) {
        int i;
        if ((i = getIndexByName(externalName)) == -1) {
            throw new RuntimeException("Can't the find the external name " + externalName);
        }
        return argsConst[i];
    }

    public int getIndexByName(String externalName) {
        for (int i = 0; i < externalNames.length; i++) {
            if (externalNames[i].equals(externalName)) {
                return i;
            }
        }
        return -1;
    }

    public HashMap<String, BCELNode> getSymbols_table() {
        return symbols_table.getFirst();
    }

    /**
     * @return The amount of locals variables.
     */
    public int getLocals() {
        return locals;
    }

    /**
     * Increment the amount of locals variables, then return the incremented value.
     * The opposite of {@link SwiftMethod}.incLocalsAfter().
     *
     * @return The value after been incremented.
     */
    public int incLocalsBefore() {
        return ++locals;
    }

    /**
     * Return the amount of locals variable, then increment the value.
     * The opposite of {@link SwiftMethod}.incLocalsBefore().
     *
     * @return The value before been incremented.
     */
    public int incLocalsAfter() {
        return locals++;
    }

    public BCELNode getSymbol(String key) {
        return symbols_table.getFirst().get(key);
    }

    public BCELNode addSymbol(String key, BCELNode node) {
        return symbols_table.get(0).put(key, node);
    }

    public void generateTableSymbolCopy() {
        symbols_table.addFirst((HashMap<String, BCELNode>) symbols_table.getFirst().clone());
    }

    public void removeTableSymbolCopy() {
        if (symbols_table.size() > 1) {
            symbols_table.removeFirst();
        } else {
            throw new RuntimeException("Can't remove the initial symbol table");
        }
    }

    public MethodGen getMethodGen() {
        return javaM;
    }

    public String[] getExternalNames() {
        return externalNames;
    }

    public boolean[] getArgsConst() {
        return argsConst;
    }

    @Override
    public String toString() {
        return javaM.getSignature();
    }

    public String callSignature() {
        return javaM.getName() + ":" + Arrays.toString(javaM.getArgumentTypes());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SwiftMethod) {
            return ((SwiftMethod) obj).callSignature().equals(callSignature());
        }
        return false;
    }

    public void prepare() {
        javaM.setMaxLocals();
        javaM.setMaxStack();
    }
}
