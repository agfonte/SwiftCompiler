package traductor;

import exceptions.RuntimeExceptions;
import org.apache.bcel.Const;
import org.apache.bcel.generic.*;
import parser.swiftBaseVisitor;
import parser.swiftParser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Razor on 11/06/2017.
 * SwiftCompiler
 */
public class MethodAnalizer extends swiftBaseVisitor<BCELNode> {

    public ArrayList<SwiftMethod> declaredMethods = new ArrayList<>();
    private String className;
    private RuntimeExceptions err = new RuntimeExceptions();

    public MethodAnalizer(String classname) {
        className = classname;
    }

    @Override
    public BCELNode visitFunction_declaration(swiftParser.Function_declarationContext ctx) {
        BCELNode type = (ctx.type() != null) ? visit(ctx.type()) : new BCELNode(Type.VOID);
        Type[] parametersType = new Type[ctx.func_parameter().size()];
        String[] parametersName = new String[parametersType.length];
        boolean[] parameterCons = new boolean[parametersType.length];
        int c = 0;
        HashMap<String, BCELNode> symbolTable = new HashMap<>();
        for (swiftParser.Func_parameterContext parameter : ctx.func_parameter()) {
            BCELNode n = visit(parameter);
            parametersType[c] = n.type;
            parametersName[c] = n.localName;
            parameterCons[c] = n.cons;
            symbolTable.put(n.localName, new BCELNode(n.type, c++, n.cons));
        }
        String name = ctx.TK_IDENT().getText();
        //Create the new function generator
        MethodGen method = new MethodGen(Const.ACC_PUBLIC | Const.ACC_STATIC, type.type, parametersType,
                parametersName, name, className, new InstructionList(), new ConstantPoolGen());
        //Make the new swift function and makes it the current method
        declaredMethods.add(new SwiftMethod(method,
                parameterCons, symbolTable));
        return null;
    }

    @Override
    public BCELNode visitFunc_parameter(swiftParser.Func_parameterContext ctx) {
        BCELNode node = visit(ctx.type());
        node.localName = ctx.TK_IDENT().getText();
        node.cons = (ctx.cons == null || ctx.cons.getText().equals("let"));
        node.initialized = node.cons;
        return node;
    }

    @Override
    public BCELNode visitType_ARRAY(swiftParser.Type_ARRAYContext ctx) {
        BCELNode type = visit(ctx.type());
        if (type.type.getType() == Const.T_ARRAY) {
            err.incompatibleTypes(new Type((byte) 0, null) {
                @Override
                public String toString() {
                    return "Int,Float,Char,Bool";
                }
            }, type.type);
        }
        return new BCELNode(new ArrayType(type.type, 1));
    }

    @Override
    public BCELNode visitType_DIC(swiftParser.Type_DICContext ctx) {
        return new BCELNode(new DictionaryType(visit(ctx.dic_type().ftype().type()).type,
                visit(ctx.dic_type().ltype().type()).type));
    }

    @Override
    public BCELNode visitType_BOOL(swiftParser.Type_BOOLContext ctx) {
        return new BCELNode(Type.BOOLEAN);
    }

    @Override
    public BCELNode visitType_FLOAT(swiftParser.Type_FLOATContext ctx) {
        return new BCELNode(Type.FLOAT);
    }

    @Override
    public BCELNode visitType_INT(swiftParser.Type_INTContext ctx) {
        return new BCELNode(Type.INT);
    }

    @Override
    public BCELNode visitType_STRING(swiftParser.Type_STRINGContext ctx) {
        return new BCELNode(Type.STRING);
    }

}
