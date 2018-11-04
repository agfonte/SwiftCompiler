package traductor;

import exceptions.RuntimeExceptions;
import org.apache.bcel.Const;
import org.apache.bcel.generic.*;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Extension of the {@link InstructionFactory} for the Swift Language
 * Created by Razor on 4/4/2017.
 */
public class SwiftInstructionFactory extends InstructionFactory {

    public SwiftInstructionFactory(ClassGen cg) {
        super(cg);
    }

    /**
     * Creates an {@link InstructionList} to perform an assignation
     *
     * @param type  {@link Type} of the assignation var
     * @param index Index of the corresponding local variable
     * @param exp   Expression that is going to be assigned
     * @return The necessary instructions to perform the assignation.
     */
    public InstructionList createASSIGN(Type type, int index, InstructionList exp) {
        InstructionList il = new InstructionList();
        il.append(exp);
        il.append(createStore(type, index));
        return il;
    }

    public InstructionList createOUT(Type type, InstructionList exp, boolean ln) {
        ObjectType outputstr = new ObjectType(PrintStream.class.getTypeName());
        InstructionList il = new InstructionList();
        il.append(createGetStatic(System.class.getTypeName(), "out", outputstr));
        il.append(exp);
        Type t = type;
        if (type.getType() == Const.T_OBJECT) {
            t = Type.OBJECT;
        } else if (type.getType() == Const.T_ARRAY) {
            if (!Utils.isReferenceType(((ArrayType) type).getElementType())) {
                il.append(createInvoke(Arrays.class.getTypeName(), "toString", Type.STRING, new Type[]{new ArrayType(((ArrayType) type).getBasicType(), 1)}, Const.INVOKESTATIC));
            } else {
                il.append(createInvoke(Arrays.class.getTypeName(), "deepToString", Type.STRING, new Type[]{new ArrayType(Type.OBJECT, 1)}, Const.INVOKESTATIC));
            }
            t = Type.STRING;
        }
        il.append(createInvoke(outputstr.getClassName(), ln ? "println" : "print", Type.VOID, new Type[]{t}, Const.INVOKEVIRTUAL));
        return il;
    }

    public InstructionList createINDXDICTIONARY(Type valueType, Type returnType, InstructionList idx) {
        ObjectType hashmap = new ObjectType(HashMap.class.getTypeName());
        InstructionList il = new InstructionList();
        il.append(createCastToObject(valueType, idx));
        il.append(createInvoke(hashmap.getClassName(), "get", Type.OBJECT, new Type[]{Type.OBJECT}, Const.INVOKEVIRTUAL));
        il.append(createCastObjectToType(returnType));
        return il;
    }

    public InstructionList createFUNCTION_CALL(String name, Type[] types, InstructionList[] params, Type returnType) {
        InstructionList il = new InstructionList();
        for (InstructionList param : params) {
            il.append(param);
        }
        il.append(createInvoke("Swift", name, returnType, types, Const.INVOKESTATIC));
        return il;
    }

    public InstructionList createRETURN(Type type, InstructionList exp) {
        InstructionList il = new InstructionList();
        il.append(exp);
        il.append(createReturn(type));
        return il;
    }

    public InstructionList createCHECKCAST(Type s, Type d) {
        InstructionList l = new InstructionList();
        switch (s.getType()) {
            case Const.T_INT:
                break;
            case Const.T_FLOAT:
                break;
            case Const.T_BOOLEAN:
                break;
            case Const.CONSTANT_String:
                break;
            case Const.T_CHAR:
                break;
            case Const.T_UNKNOWN:
                break;
            case Const.T_ARRAY:
                break;
            default:
                if (s instanceof DictionaryType) {

                }
                break;

        }
        return null;
    }

    public InstructionList createRANGE_ARRAY(boolean include_last, int lower, int upper) {
        InstructionList il = new InstructionList();
        int size = upper - lower + ((include_last) ? 1 : 0);
        il.append(createConstant(size));
        il.append(createNewArray(Type.INT, (short) 1));
        for (int i = 0; i < size; i++) {
            il.append(InstructionConst.DUP);
            il.append(createConstant(i));
            il.append(createConstant(lower + i));
            il.append(IASTORE);
        }
        return il;
    }

    public InstructionList createINDXARRAY(Type arrayType, InstructionList idx) {
        InstructionList il = new InstructionList();
        il.append(idx);
        ArrayInstruction arrayInstruction;
        switch (arrayType.getType()) {
            case Const.T_BOOLEAN:
            case Const.T_CHAR:
            case Const.T_BYTE:
            case Const.T_SHORT:
            case Const.T_INT:
                arrayInstruction = IALOAD;
                break;
            case Const.T_FLOAT:
                arrayInstruction = FALOAD;
                break;
            case Const.T_DOUBLE:
                arrayInstruction = DALOAD;
                break;
            case Const.T_LONG:
                arrayInstruction = LALOAD;
                break;
            case Const.T_ARRAY:
            case Const.T_OBJECT:
                arrayInstruction = AALOAD;
                break;
            default:
                throw new RuntimeException("Invalid type " + arrayType);
        }
        il.append(arrayInstruction);
        return il;
    }

    public InstructionList createARRAY_ASSIG(Type t, InstructionList indexExp, InstructionList exp) {
        return new InstructionList();
    }

    public InstructionList createLITERALARRAY(Type type, InstructionList[] exps) {
        InstructionList il = new InstructionList();
        il.append(createConstant(exps.length));
        il.append(createNewArray(type, (short) 1));
        int c = 0;
        for (InstructionList exp : exps) {
            il.append(InstructionConst.DUP);
            il.append(createConstant(c));
            il.append(exp);
            switch (type.getType()) {
                case Const.T_BOOLEAN:
                case Const.T_CHAR:
                case Const.T_BYTE:
                case Const.T_SHORT:
                case Const.T_INT:
                    il.append(IASTORE);
                    break;
                case Const.T_FLOAT:
                    il.append(FASTORE);
                    break;
                case Const.T_DOUBLE:
                    il.append(DASTORE);
                    break;
                case Const.T_LONG:
                    il.append(LASTORE);
                    break;
                case Const.T_ARRAY:
                case Const.T_OBJECT:
                    il.append(AASTORE);
                    break;
                default:
                    throw new RuntimeException("Invalid type " + type);
            }
            c++;
        }
        return il;
    }

    public InstructionList createLITERDIC(Type kt, InstructionList[] keys, Type vt, InstructionList[] values) {
        InstructionList il = new InstructionList();
        ObjectType hashmap = new ObjectType(HashMap.class.getTypeName());
        il.append(createNew(hashmap));
        il.append(InstructionConst.DUP);
        il.append(createInvoke(hashmap.getClassName(), "<init>", Type.VOID, Type.NO_ARGS, Const.INVOKESPECIAL));
        for (int i = 0; i < keys.length; i++) {
            il.append(DUP);
            il.append(createCastToObject(kt, keys[i]));
            il.append(createCastToObject(vt, values[i]));
            il.append(createInvoke(hashmap.getClassName(), "put",
                    Type.OBJECT, new Type[]{Type.OBJECT, Type.OBJECT}, Const.INVOKEVIRTUAL));
            il.append(POP);
        }
        return il;
    }

    public InstructionList createCastToObject(Type src, InstructionList value) {
        InstructionList il = new InstructionList();
        switch (src.getType()) {
            case Const.T_BOOLEAN:
            case Const.T_CHAR:
            case Const.T_BYTE:
            case Const.T_SHORT:
            case Const.T_INT:
                il.append(createNew(new ObjectType(Integer.class.getTypeName())));
                il.append(DUP);
                il.append(value);
                il.append(createInvoke(Integer.class.getTypeName(), "<init>", Type.VOID, new Type[]{Type.INT}, Const.INVOKESPECIAL));
                break;
            case Const.T_FLOAT:
                il.append(createNew(new ObjectType(Float.class.getTypeName())));
                il.append(DUP);
                il.append(value);
                il.append(createInvoke(Float.class.getTypeName(), "<init>", Type.VOID, new Type[]{Type.FLOAT}, Const.INVOKESPECIAL));
                break;
            case Const.T_DOUBLE:
                il.append(createNew(new ObjectType(Double.class.getTypeName())));
                il.append(DUP);
                il.append(value);
                il.append(createInvoke(Double.class.getTypeName(), "<init>", Type.DOUBLE, new Type[]{Type.DOUBLE}, Const.INVOKESPECIAL));
                break;
            case Const.T_LONG:
                il.append(createNew(new ObjectType(Long.class.getTypeName())));
                il.append(DUP);
                il.append(value);
                il.append(createInvoke(Long.class.getTypeName(), "<init>", Type.VOID, new Type[]{Type.LONG}, Const.INVOKESPECIAL));
                break;
            case Const.T_ARRAY:
            case Const.T_OBJECT:
                il.append(value);
                break;
            default:
                throw new RuntimeException("Invalid type " + src);
        }
        return il;
    }

    public InstructionList createCastObjectToType(Type destType) {
        InstructionList il = new InstructionList();
        switch (destType.getType()) {
            case Const.T_BOOLEAN:
            case Const.T_CHAR:
            case Const.T_BYTE:
            case Const.T_SHORT:
            case Const.T_INT:
                il.append(createCast(Type.OBJECT, new ObjectType(Integer.class.getTypeName())));
                il.append(createInvoke(Integer.class.getTypeName(), "intValue", Type.INT, Type.NO_ARGS, Const.INVOKEVIRTUAL));
                break;
            case Const.T_FLOAT:
                il.append(createCast(Type.OBJECT, new ObjectType(Float.class.getTypeName())));
                il.append(createInvoke(Float.class.getTypeName(), "floatValue", Type.FLOAT, Type.NO_ARGS, Const.INVOKEVIRTUAL));
                break;
            case Const.T_DOUBLE:
                il.append(createCast(Type.OBJECT, new ObjectType(Double.class.getTypeName())));
                il.append(createInvoke(Double.class.getTypeName(), "doubleValue", Type.DOUBLE, Type.NO_ARGS, Const.INVOKEVIRTUAL));
                break;
            case Const.T_LONG:
                il.append(createCast(Type.OBJECT, new ObjectType(Long.class.getTypeName())));
                il.append(createInvoke(Long.class.getTypeName(), "longValue", Type.LONG, Type.NO_ARGS, Const.INVOKEVIRTUAL));
                break;
            case Const.T_ARRAY:
            case Const.T_OBJECT:
                il.append(createCast(Type.OBJECT, destType));
                break;
            default:
                throw new RuntimeException("Invalid type " + destType);
        }
        return il;
    }

    /**********************************************************************************************
     *
     *
     *
     *
     *
     *
     *
     ***********************************************************************************************/

    public InstructionList createINC_DEC(Type t, char op, int varPos) {
        InstructionList il = new InstructionList();
        Instruction i;
        int inc = 1;
        if (op != '+') {
            inc = -1;
        }
        if (Type.INT.equals(t)) {
            i = new IINC(varPos, inc);
            il.append(i);
            il.append(createLoad(t, varPos));
        } else if (Type.FLOAT.equals(t)) {
            il.append(createLoad(t, varPos));
            if (inc == -1)
                il.append(createConstant(-1f));
            else {
                il.append(createConstant(1f));
            }
            il.append(createBinaryOperation("+", t));
        } else {
            new RuntimeExceptions().incompatibleTypes(Type.INT, t);
        }
        return il;
    }

    public InstructionList createCASTtoBOOL(Type t) {
        InstructionList il = new InstructionList();
        if (t.getType() != Const.T_BOOLEAN) {
            if (t.getType() == Const.T_INT) {
                InstructionHandle h = il.append(InstructionConst.NOP);

                il.append(createConstant(1));
                InstructionHandle h1 = il.append(createConstant(0));
                InstructionHandle nop = il.append(InstructionConst.NOP);

                il.insert(h, this.createBranchInstruction(Const.IFEQ, h1));
                il.insert(h1, createBranchInstruction(Const.GOTO, nop));
            } else {
                if (t.getType() == Const.T_FLOAT) {
                    il.append(createConstant(0.0f));

                    il.append(InstructionConst.FCMPL);

                    InstructionHandle fm = il.append(InstructionConst.NOP);

                    il.append(createConstant(1));
                    InstructionHandle cons = il.append(InstructionConst.NOP);

                    InstructionHandle h = il.append(createConstant(0));
                    InstructionHandle nop = il.append(InstructionConst.NOP);
                    il.insert(fm, createBranchInstruction(Const.IFEQ, h));
                    il.insert(cons, createBranchInstruction(Const.GOTO, nop));
                } else {
                    throw new RuntimeException("Invalid type " + t);
                }
            }
        }
        return il;
    }

    public InstructionList createPROMOTE_UPPER(Type t) {
        InstructionList il = new InstructionList();
        if (t.getType() == Const.T_INT) {
            il.append(InstructionConst.I2F);
        }
        return il;
    }

    public InstructionList createCOMP_OP(Type t, short op) {
        InstructionList il = new InstructionList();
        if (t.getType() == Const.T_INT) {
            InstructionHandle h = il.append(InstructionConst.NOP);

            il.append(createConstant(1));
            InstructionHandle h1 = il.append(createConstant(0));
            InstructionHandle nop = il.append(InstructionConst.NOP);

            il.insert(h, this.createBranchInstruction(op, h1));
            il.insert(h1, createBranchInstruction(Const.GOTO, nop));
        } else {
            if (t.getType() == Const.T_FLOAT) {
                il.append(InstructionConst.FCMPL);

                InstructionHandle fm = il.append(InstructionConst.NOP);

                il.append(createConstant(1));
                InstructionHandle cons = il.append(InstructionConst.NOP);

                InstructionHandle h = il.append(createConstant(0));
                InstructionHandle nop = il.append(InstructionConst.NOP);
                il.insert(fm, createBranchInstruction(op, h));
                il.insert(cons, createBranchInstruction(Const.GOTO, nop));
            } else {
                throw new RuntimeException("Invalid type " + t);
            }
        }
        return il;
    }

    public InstructionList createADD_STRINGINI(BCELNode var, BCELNode var1) {
        InstructionList il = new InstructionList();
        il.append(createNew("java.lang.StringBuffer"));
        il.append(InstructionConst.DUP);
        il.append(createInvoke("java.lang.StringBuffer", "<init>", Type.VOID, new Type[]{}, Const.INVOKESPECIAL));
        il.append(var.il);
        il.append(createInvoke("java.lang.StringBuffer", "append", Type.STRINGBUFFER, new Type[]{var.type}, Const.INVOKEVIRTUAL));
        il.append(var1.il);
        il.append(createInvoke("java.lang.StringBuffer", "append", Type.STRINGBUFFER, new Type[]{var1.type}, Const.INVOKEVIRTUAL));
        il.append(createInvoke("java.lang.StringBuffer", "toString", Type.STRING, new Type[]{}, Const.INVOKEVIRTUAL));
        return il;
    }


    public InstructionList createAPPENDARRAYS_DIC(Type type, InstructionList exp1, InstructionList exp2) {
        InstructionList il = new InstructionList();
        if (type.getType() == Const.T_ARRAY) {
            il.append(exp1.copy());
            il.append(InstructionConst.DUP);
            il.append(InstructionConst.ARRAYLENGTH);
            il.append(exp2.copy());
            il.append(InstructionConst.DUP_X2);
            il.append(InstructionConst.ARRAYLENGTH);
            il.append(InstructionConst.DUP_X2);
            il.append(InstructionConst.IADD);

            il.append(createInvoke(Arrays.class.getTypeName(), "copyOf", type,
                    new Type[]{type, Type.INT}, Const.INVOKESTATIC));
            il.append(createConstant(0));
            il.append(InstructionConst.SWAP);

            il.append(InstructionConst.DUP_X2);  //This is to leave the final reference in the top of the stack

            il.append(exp1);
            il.append(InstructionConst.ARRAYLENGTH);
            il.append(exp2);
            il.append(InstructionConst.ARRAYLENGTH);
            il.append(createInvoke(System.class.getTypeName(), "arraycopy", Type.VOID,
                    new Type[]{Type.OBJECT, Type.INT, Type.OBJECT, Type.INT, Type.INT}, Const.INVOKESTATIC));
        } else {
            il.append(exp1);
            il.append(InstructionConst.DUP);
            il.append(exp2);
            il.append(createInvoke(HashMap.class.getTypeName(), "putAll", Type.VOID,
                    new Type[]{new ObjectType(Map.class.getTypeName())}, Const.INVOKEVIRTUAL));
        }
        return il;
    }

    public InstructionList createNOT(Type t) {
        InstructionList il = new InstructionList();
        if (Utils.castAllowed(t, Type.BOOLEAN)) {
            if (t.getType() != Type.BOOLEAN.getType()) {
                il.append(createCASTtoBOOL(t));
            }
            InstructionHandle h = il.append(InstructionConst.NOP);
            il.append(createConstant(1));
            InstructionHandle h1 = il.append(createConstant(0));
            InstructionHandle nop = il.append(InstructionConst.NOP);
            il.insert(h, this.createBranchInstruction(Const.IFNE, h1));
            il.insert(h1, createBranchInstruction(Const.GOTO, nop));
        } else {
            new RuntimeExceptions().incompatibleTypes(Type.BOOLEAN, t);
        }
        return il;
    }

    public BranchInstruction createGOTO(InstructionHandle handle) {
        return createBranchInstruction(Const.GOTO, handle);
    }

    public InstructionList createCASTtoSTRING(BCELNode exp, Type t) {
        if (exp.type instanceof DictionaryType || exp.type.getType() == Const.T_ARRAY) {
            new RuntimeException();
        }
        InstructionList il = new InstructionList();
        if (!Utils.isString(exp.type)) {
            il.append(createNew("java.lang.StringBuffer"));
            il.append(InstructionConst.DUP);
            il.append(createInvoke("java.lang.StringBuffer", "<init>", Type.VOID, new Type[]{}, Const.INVOKESPECIAL));
            il.append(exp.il);
            il.append(createInvoke("java.lang.StringBuffer", "append", Type.STRINGBUFFER, new Type[]{t}, Const.INVOKEVIRTUAL));
            il.append(createInvoke("java.lang.StringBuffer", "toString", Type.STRING, new Type[]{}, Const.INVOKEVIRTUAL));
        }
        return il;
    }

    public InstructionList createNEG() {
        InstructionList il = new InstructionList();
        InstructionHandle h = il.append(InstructionConst.NOP);
        il.append(createConstant(1));
        InstructionHandle h1 = il.append(InstructionConst.NOP);
        InstructionHandle h2 = il.append(createConstant(0));
        InstructionHandle h3 = il.append(InstructionConst.NOP);
        il.insert(h, createBranchInstruction(Const.IFNE, h2));
        il.insert(h1, createBranchInstruction(Const.GOTO, h3));
        return il;
    }

    public InstructionList createEQ(Type t) {
        InstructionList il = new InstructionList();
        InstructionHandle h = il.append(InstructionConst.NOP);
        il.append(createConstant(1));
        InstructionHandle h1 = il.append(InstructionConst.NOP);
        InstructionHandle h2 = il.append(createConstant(0));
        InstructionHandle h3 = il.append(InstructionConst.NOP);
        if (t.getType() == Const.T_INT) {
            il.insert(h, createBranchInstruction(Const.IF_ICMPNE, h2));
            il.insert(h1, createBranchInstruction(Const.GOTO, h3));
        } else {
            InstructionHandle h5 = il.insert(h, InstructionConst.FCMPL);
            il.insert(h5.getNext(), createBranchInstruction(Const.IFNE, h2));
            il.insert(h1, createBranchInstruction(Const.GOTO, h3));
        }
        return il;
    }
}
