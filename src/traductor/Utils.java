package traductor;

import org.apache.bcel.Const;
import org.apache.bcel.generic.InstructionConst;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Razor on 7/4/2017.
 * SwiftCompiler
 */
public class Utils {
    public static boolean isNumericType(Type type) {
        return type.getType() == Const.T_INT || type.getType() == Const.T_FLOAT;//|| type.getType() == Const.T_CHAR;
    }

    public static boolean isReferenceType(Type type) {
        return type.getType() == Type.STRING.getType() || type.getType() == Const.T_ARRAY;
    }

    public static boolean isLogicType(Type type) {
        return type.getType() == Const.T_BOOLEAN;
    }

    public static boolean isStringType(Type type) {
        return type.getType() == Const.CONSTANT_String;
    }

    public static boolean castAllowed(Type src, Type dest) {
        byte d = dest.getType();
        switch (src.getType()) {
            case Const.T_ARRAY:
                return false;
            case Const.T_BOOLEAN:
                return d == Const.T_BOOLEAN || d == Const.T_INT || d == Const.T_FLOAT;
//            case Const.T_CHAR:
//                return d == Const.T_BOOLEAN || d == Const.T_INT || d == Const.T_FLOAT;
            case Const.T_FLOAT:
                return d == Const.T_BOOLEAN || d == Const.T_INT || d == Const.T_FLOAT;
            case Const.T_INT:
                return d == Const.T_BOOLEAN || d == Const.T_INT || d == Const.T_FLOAT;
            case Const.T_REFERENCE:
                return false;
            case Const.T_UNKNOWN:
                return false;

        }
        return false;

    }

    public static boolean supportAssig(Type var) {
        return var.equals(Type.UNKNOWN);
    }

    public static boolean supportINC_DEC(Type var) {
        return !(var.equals(Type.UNKNOWN) || var.equals(Type.STRING) || var.equals(Type.BOOLEAN) || var instanceof DictionaryType);
    }

    public static boolean supportADD_SUB(Type type, String text) {
        if (text.equals("+")) {
            switch (type.getType()) {
                case Const.T_INT:
                case Const.T_FLOAT:
                    return true;
                default:
                    if (type.equals(Type.STRING)) {
                        return true;
                    } else {
                        return false;
                    }
            }
        } else {
            switch (type.getType()) {
                case Const.T_INT:
                case Const.T_FLOAT:
                    return true;
                default:
                    return false;
            }
        }
    }

    public static boolean isStringRef(Type t) {
        return t.equals(Type.STRING);
    }


    public static void resolveBreaks(InstructionList il, Stack<ArrayList<InstructionHandle>> breakHandles,
                                     SwiftInstructionFactory factory) {
        InstructionHandle handle = il.append(InstructionConst.NOP);
        for (InstructionHandle ha : breakHandles.pop()) {
            il.insert(ha, factory.createGOTO(handle));
        }
    }

    public static boolean isString(Type t) {
        return isStringRef(t) || isStringType(t);

    }

    public static void appendCase(Stack<int[]> cases, Stack<InstructionHandle[]> handles, int i, InstructionHandle tar) {

        int[] tmp = new int[cases.peek().length + 1];
        InstructionHandle[] htmp = new InstructionHandle[cases.peek().length + 1];
        System.arraycopy(cases.peek(), 0, tmp, 0, cases.peek().length);
        tmp[cases.peek().length] = i;
        cases.pop();
        cases.push(tmp);
        System.arraycopy(handles.peek(), 0, htmp, 0, handles.peek().length);
        htmp[handles.peek().length] = tar;
        handles.pop();
        handles.push(htmp);
    }
}
