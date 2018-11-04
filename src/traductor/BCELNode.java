package traductor;

import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

/**
 * SwiftCompiler
 */
public class BCELNode implements Cloneable {

    public InstructionList il;
    public Type type;
    public int num = -1;
    public boolean cons;
    public boolean initialized = false;
    public String localName;
    public String externalName;
    public Object value;
    public boolean sent = false;

    BCELNode(Type type) {
        this.type = type;
    }

    BCELNode(Type type, InstructionList il) {
        this(type);
        this.il = il;
    }

    BCELNode(Type type, int num, boolean cons) {
        this(type);
        this.num = num;
        this.cons = cons;
    }

    public BCELNode(Type type, InstructionList il, boolean sent) {
        this(type);
        this.il = il;
        this.num = num;
        this.sent = sent;
    }

    private BCELNode(InstructionList il, Type type, int num, boolean cons, boolean initialized, String localName, boolean sent, Object value) {
        this.il = il;
        this.type = type;
        this.num = num;
        this.cons = cons;
        this.initialized = initialized;
        this.localName = localName;
        this.sent = sent;
        this.value = value;
    }

    public boolean isLocal() {
        return num >= 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        InstructionList newil = new InstructionList();
        for (int i = 0; i < il.getLength(); i++) {
            newil.append(il.getInstructions()[i]);
        }
        return new BCELNode(newil, type, num, cons, initialized, localName, sent, value);
    }
}
