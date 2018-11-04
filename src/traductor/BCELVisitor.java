package traductor;

import exceptions.RuntimeExceptions;
import org.apache.bcel.Const;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.*;
import parser.swiftBaseVisitor;
import parser.swiftParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * SwiftCompiler
 */
public class BCELVisitor extends swiftBaseVisitor<BCELNode> {

    private ClassGen classGen;
    private SwiftInstructionFactory factory;
    private SwiftMethodList swiftMethod;
    private RuntimeExceptions err = new RuntimeExceptions();
    private ArrayList<SwiftMethod> declaredMethods;
    private Stack<InstructionHandle> continueHandles = new Stack<>();
    private Stack<ArrayList<InstructionHandle>> breakHandles = new Stack<>();
    private String className;
    private Stack<int[]> cases_cte = new Stack<>();
    private Stack<InstructionHandle[]> targets = new Stack<>();
    private Stack<InstructionHandle> target_default = new Stack<>();

    public BCELVisitor(String className, ArrayList<SwiftMethod> methods) {
        this.className = className;
        declaredMethods = methods;
        classGen = new ClassGen(className, Object.class.getTypeName(), null, Const.ACC_PUBLIC, null);
        factory = new SwiftInstructionFactory(classGen);
        MethodGen mainGen = new MethodGen(Const.ACC_STATIC | Const.ACC_PUBLIC, Type.VOID,
                new Type[]{new ArrayType(Type.STRING, 1)}, new String[]{"args"}, "main", this.className,
                new InstructionList(), classGen.getConstantPool());
        SwiftMethod main = new SwiftMethod(mainGen, new boolean[1], new HashMap<>());
        swiftMethod = new SwiftMethodList(main);
    }

    public JavaClass getJavaClass() {
        return classGen.getJavaClass();
    }

    @Override
    public BCELNode visitTop_level(swiftParser.Top_levelContext ctx) {
        BCELNode code = visit(ctx.statements());
        MethodGen main = swiftMethod.getCurrentMethod().getMethodGen();
        code.il.append(InstructionConst.RETURN);
        main.getInstructionList().append(code.il);
        main.setMaxStack();
        main.setMaxLocals();
        classGen.addMethod(main.getMethod());
        return null;
    }

    @Override
    public BCELNode visitVariable_declaration(swiftParser.Variable_declarationContext ctx) {
        String ident = ctx.TK_IDENT().getText();
        BCELNode type = null;
        BCELNode exp = null;
        if (ctx.type() != null) {
            type = visit(ctx.type());
        }
        if (ctx.expression() != null) {
            exp = visit(ctx.expression());
        }
        SwiftMethod current = swiftMethod.getCurrentMethod();
        BCELNode res = new BCELNode((type == null) ? Type.UNKNOWN : type.type, current.getLocals(), false);
        if (exp != null) {
            if (type == null) {
                type = new BCELNode(exp.type);
                res.type = exp.type;
            }
            if (!exp.type.equals(type.type)) {
                err.incompatibleTypes(type.type, exp.type);
            }
            res.initialized = true;
            res.il = new InstructionList();
            res.il.append(factory.createASSIGN(type.type, current.getLocals(), exp.il));
        }
        current.incLocalsAfter();
        current.addSymbol(ident, res);
        return new BCELNode(null, res.il, true);
    }

    @Override
    public BCELNode visitConstant_declaration(swiftParser.Constant_declarationContext ctx) {
        String ident = ctx.TK_IDENT().getText();
        BCELNode type = null;
        BCELNode exp = null;
        if (ctx.type() != null) {
            type = visit(ctx.type());
        }
        if (ctx.expression() != null) {
            exp = visit(ctx.expression());
        }
        SwiftMethod current = swiftMethod.getCurrentMethod();
        BCELNode res = new BCELNode((type == null) ? Type.UNKNOWN : type.type, current.getLocals(), true);
        if (exp != null) {
            if (type == null) {
                type = new BCELNode(exp.type);
                res.type = exp.type;
            } else if (!exp.type.equals(type.type)) {
                err.incompatibleTypes(type.type, exp.type);
            }
            res.initialized = true;
            current.getMethodGen().getInstructionList().append(
                    factory.createASSIGN(type.type, current.getLocals(), exp.il));
        }
        current.incLocalsAfter();
        current.addSymbol(ident, res);
        return new BCELNode(null, exp.il, true);
    }

    @Override
    public BCELNode visitFunction_declaration(swiftParser.Function_declarationContext ctx) {
        if (swiftMethod.getSize() == 1) {
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
                    parametersName, name, className, new InstructionList(), classGen.getConstantPool());
            //Make the new swift function and makes it the current method
            swiftMethod.addSwiftMethod(new SwiftMethod(method,
                    parameterCons, symbolTable));
            //Visit function code
            BCELNode code = visit(ctx.code_block());
            swiftMethod.getCurrentMethod().getMethodGen().getInstructionList().append(code.il);
            if (swiftMethod.getCurrentMethod().getMethodGen().getReturnType().getType() == Const.T_VOID) {
                swiftMethod.getCurrentMethod().getMethodGen().getInstructionList().append(InstructionConst.RETURN);
            }
            swiftMethod.getCurrentMethod().prepare();
            classGen.addMethod(swiftMethod.getCurrentMethod().getMethod());
            swiftMethod.closeCurrent();
            return null;
        }
        throw new RuntimeException("Can't declare a function inside another");
    }

    @Override
    public BCELNode visitFunc_parameter(swiftParser.Func_parameterContext ctx) {
        BCELNode node = visit(ctx.type());
        node.localName = ctx.TK_IDENT().getText();
        node.cons = (ctx.cons == null || ctx.cons.getText().equals("let"));
        node.initialized = node.cons;
        //node.externalName = (ctx.external_name() == null) ? null : ctx.external_name().getText();
        return node;
    }

    @Override
    public BCELNode visitType_ARRAY(swiftParser.Type_ARRAYContext ctx) {
        BCELNode type = visit(ctx.type());
        if (type.type.getType() == Const.T_ARRAY) {
            err.incompatibleTypes(new Type((byte) 0, null) {
                @Override
                public String toString() {
                    return "Int,Float,Bool";
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

    @Override
    public BCELNode visitUNARY_OP(swiftParser.UNARY_OPContext ctx) {
        BCELNode node = visit(ctx.expression());
        InstructionList il = new InstructionList();
        il.append(node.il);
        if (Utils.isNumericType(node.type)) {
            if (ctx.op.getText().equals("-")) {
                if (node.type.normalizeForStackOrLocal().getType() == Const.T_INT) {
                    il.append(InstructionConst.INEG);
                } else {
                    il.append(InstructionConst.FNEG);
                }
            }
            return new BCELNode(node.type, il);
        }
        err.opTypeMismatch("-", null, ctx.expression().getText());
        return null;
    }

    @Override
    public BCELNode visitMUL_DIV_MOD_OP(swiftParser.MUL_DIV_MOD_OPContext ctx) {
        BCELNode exp1 = visit(ctx.expression(0));
        BCELNode exp2 = visit(ctx.expression(1));
        InstructionList il = new InstructionList();
        String op = ctx.op.getText();
        il.append(exp1.il);
        il.append(exp2.il);
        if (Utils.isNumericType(exp1.type) && Utils.isNumericType(exp2.type)) {
            Type castType;
            if (!exp1.type.equals(exp2.type)) {
                if (exp1.type.getType() == Const.T_FLOAT) {
                    il.append(factory.createCast(exp2.type, exp1.type));
                    castType = Type.FLOAT;
                } else if (exp2.type.getType() == Const.T_FLOAT) {
                    il.append(InstructionConst.SWAP);
                    il.append(factory.createCast(exp1.type, exp2.type));
                    il.append(InstructionConst.SWAP);
                    castType = Type.FLOAT;
                } else {
                    castType = Type.INT;
                }
            } else {
                castType = exp1.type;
            }
            il.append(SwiftInstructionFactory.createBinaryOperation(op, castType));
            return new BCELNode(castType, il);
        }
        err.opTypeMismatch(op, ctx.expression(0).getText(), ctx.expression(1).getText());
        return null;
    }

    @Override
    public BCELNode visitPrint_call(swiftParser.Print_callContext ctx) {
        BCELNode exp = visit(ctx.expression());
        InstructionList il = new InstructionList();
        il.append(factory.createOUT(exp.type, exp.il, (ctx.op.getText().equals("println"))));
        return new BCELNode(null, il, true);
    }

    @Override
    public BCELNode visitCTE_BIN(swiftParser.CTE_BINContext ctx) {
        InstructionList il = new InstructionList();
        int cte = Integer.parseInt(ctx.getText().replaceAll("_+", "").substring(2), 2);
        il.append(factory.createConstant(cte));
        BCELNode bcelNode = new BCELNode(Type.INT, il);
        bcelNode.value = cte;
        return bcelNode;
    }

    @Override
    public BCELNode visitCTE_DEC(swiftParser.CTE_DECContext ctx) {
        InstructionList il = new InstructionList();
        int cte = Integer.parseInt(ctx.getText().replaceAll("_+", ""));
        il.append(factory.createConstant(cte));
        BCELNode bcelNode = new BCELNode(Type.INT, il);
        bcelNode.value = cte;
        return bcelNode;
    }

    @Override
    public BCELNode visitCTE_PURE_DEC(swiftParser.CTE_PURE_DECContext ctx) {
        InstructionList il = new InstructionList();
        int cte = Integer.parseInt(ctx.getText());
        il.append(factory.createConstant(cte));
        BCELNode bcelNode = new BCELNode(Type.INT, il);
        bcelNode.value = cte;
        return bcelNode;
    }

    @Override
    public BCELNode visitCTE_OCT(swiftParser.CTE_OCTContext ctx) {
        InstructionList il = new InstructionList();
        int cte = Integer.parseInt(ctx.getText().replaceAll("_+", "").substring(2), 8);
        il.append(factory.createConstant(cte));
        BCELNode bcelNode = new BCELNode(Type.INT, il);
        bcelNode.value = cte;
        return bcelNode;
    }

    @Override
    public BCELNode visitCTE_HEX(swiftParser.CTE_HEXContext ctx) {
        InstructionList il = new InstructionList();
        int cte = Integer.parseInt(ctx.getText().replaceAll("_+", "").substring(2), 16);
        il.append(factory.createConstant(cte));
        BCELNode bcelNode = new BCELNode(Type.INT, il);
        bcelNode.value = cte;
        return bcelNode;
    }

    @Override
    public BCELNode visitCTE_FLOAT(swiftParser.CTE_FLOATContext ctx) {
        InstructionList il = new InstructionList();
        float cte = Float.parseFloat(ctx.getText().replaceAll("_+", ""));
        il.append(factory.createConstant(cte));
        BCELNode bcelNode = new BCELNode(Type.FLOAT, il);
        bcelNode.value = cte;
        return bcelNode;
    }

    @Override
    public BCELNode visitArray_literal(swiftParser.Array_literalContext ctx) {
        InstructionList il = new InstructionList();
        BCELNode[] exps = new BCELNode[ctx.expression_list().expression().size()];
        InstructionList[] ils = new InstructionList[exps.length];
        int c = 0;
        Type type = null;
        for (swiftParser.ExpressionContext exp : ctx.expression_list().expression()) {
            exps[c] = visit(exp);
            if (type != null && !type.equals(exps[c].type)) {
                err.incompatibleTypes(type, exps[c].type);
            }
            type = exps[c].type;
            ils[c] = exps[c].il;
            c++;
        }
        il.append(factory.createLITERALARRAY(type, ils));
        return new BCELNode(new ArrayType(type, 1), il);
    }

    @Override
    public BCELNode visitDic_literal(swiftParser.Dic_literalContext ctx) {
        InstructionList il = new InstructionList();
        BCELNode[] exps = new BCELNode[ctx.dic_item_list().dic_item().size()];
        InstructionList[] expil = new InstructionList[exps.length];
        BCELNode[] keys = new BCELNode[exps.length];
        InstructionList[] kil = new InstructionList[exps.length];
        int c = 0;
        Type ext = null;
        Type kt = null;
        for (swiftParser.Dic_itemContext dic_item : ctx.dic_item_list().dic_item()) {
            keys[c] = visit(dic_item.expression(0));
            exps[c] = visit(dic_item.expression(1));
            if (ext != null && !ext.equals(exps[c].type)) {
                err.incompatibleTypes(ext, exps[c].type);
            }
            if (kt != null && !kt.equals(keys[c].type)) {
                err.incompatibleTypes(kt, keys[c].type);
            }
            ext = exps[c].type;
            kt = keys[c].type;
            expil[c] = exps[c].il;
            kil[c] = keys[c].il;
            c++;
        }
        il.append(factory.createLITERDIC(kt, kil, ext, expil));
        return new BCELNode(new DictionaryType(kt, ext), il);
    }

    @Override
    public BCELNode visitBoolean_literal(swiftParser.Boolean_literalContext ctx) {
        InstructionList il = new InstructionList();
        il.append(factory.createConstant(ctx.TK_TRUE() != null));
        return new BCELNode(Type.BOOLEAN, il);
    }

    @Override
    public BCELNode visitString_literal(swiftParser.String_literalContext ctx) {
        InstructionList il = new InstructionList();
        String str = ctx.getText();
        il.append(factory.createConstant(new String(str.substring(1, str.length() - 1))));
        return new BCELNode(Type.STRING, il);
    }

    @Override
    public BCELNode visitREFERENCE(swiftParser.REFERENCEContext ctx) {
        SwiftMethod current = swiftMethod.getCurrentMethod();
        String id = ctx.TK_IDENT().getText();
        if (current.getSymbols_table().containsKey(id)) {
            BCELNode ref = current.getSymbol(id);
            InstructionList il = new InstructionList();
            if (ref.type.getType() != Const.T_UNKNOWN) {
                il.append(SwiftInstructionFactory.createLoad(ref.type, ref.num));
                return new BCELNode(ref.type, il);
            }
        }
        err.symbolNotFound(id);
        return null;
    }

    @Override
    public BCELNode visitINDX_REFERENCE(swiftParser.INDX_REFERENCEContext ctx) {
        BCELNode ref = visit(ctx.expression(0));
        boolean isArr;
        if ((isArr = ref.type.getType() == Const.T_ARRAY) || Utils.isReferenceType(ref.type)) {
            BCELNode indx = visit(ctx.expression(1));
            InstructionList il = new InstructionList();
            il.append(ref.il);
            Type t;
            if (isArr) {
                if (indx.type.normalizeForStackOrLocal().getType() == Const.T_INT) {
                    il.append(factory.createINDXARRAY(((ArrayType) ref.type).getElementType(), indx.il));
                    t = ((ArrayType) ref.type).getElementType();
                } else {
                    err.incompatibleTypes(Type.INT, indx.type);
                    return null;
                }
            } else {
                if (indx.type.equals(((DictionaryType) ref.type).getKeyType())) {
                    t = ((DictionaryType) ref.type).getValueType();
                    il.append(factory.createINDXDICTIONARY(((DictionaryType) ref.type).getKeyType(), t, indx.il));
                } else {
                    err.incompatibleTypes(((DictionaryType) ref.type).getKeyType(), indx.type);
                    return null;
                }
            }
            return new BCELNode(t, il);
        }
        err.opTypeMismatch("[]", ctx.expression(0).getText(), ctx.expression(1).getText());
        return null;
    }

    @Override
    public BCELNode visitFUNC_CALL(swiftParser.FUNC_CALLContext ctx) {
        String name = ctx.TK_IDENT().getText();
        int c = 0;
        Type[] types = new Type[(ctx.expression_list() != null) ? ctx.expression_list().expression().size() : 0];
        InstructionList[] param = new InstructionList[types.length];
        if (ctx.expression_list() != null) {
            for (swiftParser.ExpressionContext expressionContext : ctx.expression_list().expression()) {
                BCELNode exp = visit(expressionContext);
                param[c] = exp.il;
                types[c++] = exp.type;
            }
        }
        SwiftMethod calledMeth = new SwiftMethod(
                new MethodGen(0, Type.VOID, types, new String[types.length], name, "Swift",
                        new InstructionList(), classGen.getConstantPool()), new boolean[types.length], new HashMap<>());
        String signature = calledMeth.callSignature();
        Type returnType;
        for (SwiftMethod declaredMethod : declaredMethods) {
            if (declaredMethod.callSignature().equals(signature)) {
                returnType = declaredMethod.getMethodGen().getReturnType();
                if (returnType.getType() == Const.T_VOID) {
                    throw new RuntimeException("Method " + signature + " return VOID");
                }
                InstructionList il = factory.createFUNCTION_CALL(name, types, param, returnType);
                return new BCELNode(returnType, il);
            }
        }
        throw new RuntimeException("Undeclared Function!!" + "Method " + signature);
    }

    @Override
    public BCELNode visitFUNC_ST(swiftParser.FUNC_STContext ctx) {
        String name = ctx.function_call().TK_IDENT().getText();
        int c = 0;
        Type[] types = new Type[(ctx.function_call().expression_list() != null)
                ? ctx.function_call().expression_list().expression().size()
                : 0];
        InstructionList[] param = new InstructionList[types.length];
        if ((ctx.function_call().expression_list() != null)) {
            for (swiftParser.ExpressionContext expressionContext : ctx.function_call().expression_list().expression()) {
                BCELNode exp = visit(expressionContext);
                param[c] = exp.il;
                types[c++] = exp.type;
            }
        }
        SwiftMethod calledMeth = new SwiftMethod(
                new MethodGen(0, Type.VOID, types, new String[types.length], name, "Swift",
                        new InstructionList(), classGen.getConstantPool()), new boolean[types.length], new HashMap<>());
        String signature = calledMeth.callSignature();
        Type returnType;
        for (SwiftMethod declaredMethod : declaredMethods) {
            if (declaredMethod.callSignature().equals(signature)) {
                returnType = declaredMethod.getMethodGen().getReturnType();
                InstructionList il = factory.createFUNCTION_CALL(name, types, param, returnType);
                return new BCELNode(returnType, il);
            }
        }
        throw new RuntimeException("Undeclared Function!!" + "Method " + signature);
    }

    @Override
    public BCELNode visitReturn_statement(swiftParser.Return_statementContext ctx) {
        if (ctx.expression() != null) {
            BCELNode exp = visit(ctx.expression());
            if (!swiftMethod.getCurrentMethod().getMethodGen().getReturnType().equals(exp.type)) {
                err.incompatibleTypes(swiftMethod.getCurrentMethod().getMethodGen().getReturnType(), exp.type);
                return null;
            }
        }
        BCELNode exp = (ctx.expression() != null) ? visit(ctx.expression()) : new BCELNode(Type.VOID, new InstructionList());
        return new BCELNode(exp.type, factory.createRETURN(exp.type, exp.il));
    }

    @Override
    public BCELNode visitLOCAL_INFER(swiftParser.LOCAL_INFERContext ctx) {
        SwiftMethod current = swiftMethod.getCurrentMethod();
        BCELNode numb = visit(ctx.integer_literal());
        int idx = ((Integer) numb.value);
        if (current.getMethodGen().getArgumentTypes().length > idx) {
            InstructionList il = new InstructionList();
            il.append(SwiftInstructionFactory.createLoad(current.getMethodGen().getArgumentType(idx), idx));
            return new BCELNode(current.getMethodGen().getArgumentType(idx), il);
        }
        throw new RuntimeException("Argument out of bounds:\nRequired: " +
                (current.getMethodGen().getArgumentTypes().length - 1)
                + " or less \nFounded: " + idx);
    }

    /**************************************
     * ************************************
     * ******** MY CODE ANONYMOUS *********
     * ************************************
     **************************************/

    /**
     * OK
     **/
    @Override
    public BCELNode visitASSIG_OP(swiftParser.ASSIG_OPContext ctx) {
        String id = ctx.TK_IDENT().getText();
        SwiftMethod current = swiftMethod.getCurrentMethod();
        InstructionList il = new InstructionList();
        BCELNode var = current.getSymbol(id);
        BCELNode val = visit(ctx.expression().get(ctx.expression().size() > 1 ? 1 : 0));
        if (var == null) {
            err.symbolNotFound(id);
            return null;
        }
        Type var_type = var.type;
        Type val_type = val.type;
        if (var.cons && var.initialized) {
            err.attempToChangeConstant(id);
        } else {
            if (!var.cons) {
                var.cons = true;
            }
        }
        if (ctx.expression().size() > 1) {
            if (var_type instanceof DictionaryType) {
                BCELNode exp = visit(ctx.expression().get(0));
                il.append(factory.createLoad(var.type, var.num));
                il.append(factory.createCastToObject(exp.type, exp.il));
                il.append(factory.createCastToObject(val_type, val.il.copy()));
                il.append(factory.createInvoke(HashMap.class.getTypeName(), "put", Type.OBJECT,
                        new Type[]{Type.OBJECT, Type.OBJECT}, Const.INVOKEVIRTUAL));
                il.append(InstructionConst.POP);
                il.append(val.il);
            } else {
                if (var_type.getType() == val_type.getType()) {
                    BCELNode exp = visit(ctx.expression().get(0));
                    il.append(factory.createLoad(var.type, var.num));
                    il.append(InstructionConst.DUP);
                    il.append(exp.il);
                    il.append(val.il);
                    il.append(factory.createArrayStore(((ArrayType) var_type).getElementType()));
                    il.append(factory.createINDXARRAY(((ArrayType) var_type).getElementType(), visit(ctx.expression().get(0)).il));
                }
                if (Utils.castAllowed(val_type, ((ArrayType) var_type).getElementType())) {
                    BCELNode exp = visit(ctx.expression().get(0));
                    il.append(factory.createLoad(var.type, var.num));
                    il.append(InstructionConst.DUP);
                    il.append(exp.il);
                    il.append(val.il);
                    if (Utils.castAllowed(val_type, ((ArrayType) var_type).getElementType()) && val_type.getType() != ((ArrayType) var_type).getElementType().getType()) {
                        il.append(factory.createCast(val_type, ((ArrayType) var_type).getElementType()));
                    } else {
                        if (!Utils.castAllowed(val_type, ((ArrayType) var_type).getElementType())) {
                            err.incompatibleTypes(val_type, ((ArrayType) var_type).getElementType());
                        }
                    }
                    il.append(factory.createArrayStore(((ArrayType) var_type).getElementType()));
                    il.append(factory.createINDXARRAY(((ArrayType) var_type).getElementType(), visit(ctx.expression().get(0)).il));
                } else {
                    err.castNotAllowed(val_type, var_type);
                }
                return new BCELNode(((ArrayType) var_type).getElementType(), il, true);
            }
            return new BCELNode(((DictionaryType) var_type).getValueType(), il, true);
        } else {

            if (var_type.equals(val_type)) {
                il.append(factory.createASSIGN(var_type, var.num, val.il));
            } else {
                if (Utils.castAllowed(val_type, var_type)) {
                    il.append(val.il);
                    il.append(factory.createCast(val_type, var_type));
                    il.append(factory.createASSIGN(var_type, var.num, val.il));
                } else {
                    err.castNotAllowed(var_type, val_type);
                }
            }

            il.append(factory.createLoad(var.type, var.num));
            return new BCELNode(var_type, il, true);
        }

    }

    /**
     * OK
     **/
    @Override
    public BCELNode visitDo_statement(swiftParser.Do_statementContext ctx) {
        breakHandles.push(new ArrayList<InstructionHandle>());
        InstructionList il = new InstructionList();
        swiftMethod.getCurrentMethod().generateTableSymbolCopy();
        continueHandles.push(il.append(InstructionConst.NOP));
        InstructionHandle h = continueHandles.peek();
        il.append(visit(ctx.code_block()).il);
        BCELNode exp = visit(ctx.expression());
        il.append(InstructionConst.NOP);
        il.append(exp.il);
        il.append(factory.createBranchInstruction(Const.IFNE, h));
        continueHandles.pop();
        Utils.resolveBreaks(il, breakHandles, factory);
        swiftMethod.getCurrentMethod().removeTableSymbolCopy();
        return new BCELNode(null, il, true);
    }

    /**
     * OK
     **/
    @Override
    public BCELNode visitINC_DEC_LEFT(swiftParser.INC_DEC_LEFTContext ctx) {
        String id = ctx.TK_IDENT().getText();
        InstructionList il = new InstructionList();
        SwiftMethod meth = swiftMethod.getCurrentMethod();
        BCELNode var = meth.getSymbol(id);

        if (var == null) {
            err.symbolNotFound(id);
        }
        Type t = var.type;
        if (!Utils.supportINC_DEC(var.type)) {
            err.incompatibleTypes(new Type(((byte) 0), null) {
                @Override
                public String toString() {
                    return "int,float ";
                }
            }, var.type);
        }
        if (var.type.getType() == Const.T_ARRAY) {
            ArrayType s = (ArrayType) var.type;
            if (!Utils.supportINC_DEC(s.getElementType())) {
                err.incompatibleTypes(new Type(((byte) 0), null) {
                    @Override
                    public String toString() {
                        return "int,float ";
                    }
                }, var.type);
            }
            //Cargo el index
            BCELNode indx = visit(ctx.expression());
            if (indx.type.normalizeForStackOrLocal().getType() == Const.T_INT) {
                il.append(factory.createLoad(var.type, var.num));
                il.append(indx.il);
                il.append(InstructionConst.DUP2);
                il.append(factory.createLoad(var.type, var.num));
                il.append(factory.createINDXARRAY(((ArrayType) var.type).getElementType(), visit(ctx.expression()).il));
                t = ((ArrayType) var.type).getElementType();
            } else {
                err.incompatibleTypes(Type.INT, indx.type);
                return null;
            }
            il.append(factory.createConstant(1));
            if (ctx.op.getText().trim().equals("++")) {
                il.append(factory.createBinaryOperation("+", s.getElementType()));
            } else {
                il.append(factory.createBinaryOperation("-", s.getElementType()));
            }
            il.append(factory.createArrayStore(s.getElementType()));
            il.append(factory.createINDXARRAY(s.getElementType(), new InstructionList()));
        } else {
            if (ctx.op.getText().trim().equals("++")) {
                //il.append(factory.createLoad(var.type, var.num));
                il.append(factory.createINC_DEC(var.type, '+', var.num));
            } else {
                // il.append(factory.createLoad(var.type, var.num));
                il.append(factory.createINC_DEC(var.type, '-', var.num));
            }
            il.append(factory.createStore(var.type, var.num));
            il.append(factory.createLoad(var.type, var.num));
        }
        return new BCELNode(t, il, true);
    }

    /**
     * OK
     **/
    @Override
    public BCELNode visitINC_DEC_RIGTH(swiftParser.INC_DEC_RIGTHContext ctx) {
        String id = ctx.TK_IDENT().getText();
        InstructionList il = new InstructionList();
        SwiftMethod meth = swiftMethod.getCurrentMethod();
        BCELNode var = meth.getSymbol(id);

        if (var == null) {
            err.symbolNotFound(id);
        }
        Type t = var.type;
        if (!Utils.supportINC_DEC(var.type)) {
            err.incompatibleTypes(new Type(((byte) 0), null) {
                @Override
                public String toString() {
                    return "int,float ";
                }
            }, var.type);
        }
        if (var.type.getType() == Const.T_ARRAY) {
            ArrayType s = (ArrayType) var.type;
            if (!Utils.supportINC_DEC(s.getElementType())) {
                err.incompatibleTypes(new Type(((byte) 0), null) {
                    @Override
                    public String toString() {
                        return "int,float ";
                    }
                }, var.type);
            }
            //Cargo el index
            BCELNode indx = visit(ctx.expression());
            if (indx.type.normalizeForStackOrLocal().getType() == Const.T_INT) {
                il.append(factory.createLoad(var.type, var.num));
                il.append(factory.createINDXARRAY(s.getElementType(), indx.il));
                il.append(factory.createLoad(var.type, var.num));
                il.append(visit(ctx.expression()).il);
                il.append(factory.createLoad(var.type, var.num));
                il.append(factory.createINDXARRAY(s.getElementType(), visit(ctx.expression()).il));
                t = ((ArrayType) var.type).getElementType();
            } else {
                err.incompatibleTypes(Type.INT, indx.type);
                return null;
            }
            il.append(factory.createConstant(1));
            if (ctx.op.getText().trim().equals("++")) {
                il.append(factory.createBinaryOperation("+", s.getElementType()));
            } else {
                il.append(factory.createBinaryOperation("-", s.getElementType()));
            }
            il.append(factory.createArrayStore(s.getElementType()));
        } else {
            if (ctx.op.getText().trim().equals("++")) {
                il.append(factory.createLoad(var.type, var.num));
                il.append(factory.createINC_DEC(var.type, '+', var.num));
            } else {
                il.append(factory.createLoad(var.type, var.num));
                il.append(factory.createINC_DEC(var.type, '-', var.num));
            }
            il.append(factory.createStore(var.type, var.num));
        }
        return new BCELNode(t, il, true);
    }

    /**
     * OK
     **/
    @Override
    public BCELNode visitCHECK_TYPE_OP(swiftParser.CHECK_TYPE_OPContext ctx) {
        //instanceof !!
        BCELNode exp = visit(ctx.expression());
        BCELNode type = visit(ctx.type());
        InstructionList il = new InstructionList();
        il.append(factory.createConstant(exp.type.equals(type.type)));
        return new BCELNode(Type.BOOLEAN, il);
    }

    /**
     * OK
     **/
    @Override
    public BCELNode visitBINARY_OP(swiftParser.BINARY_OPContext ctx) {
        String op = ctx.op.getText().trim();
        InstructionList il = new InstructionList();
        BCELNode el = visit(ctx.expression(0));
        BCELNode er = visit(ctx.expression(1));
        if (Utils.isNumericType(el.type) && Utils.isNumericType(er.type)) {
            if (el.type.getType() != er.type.getType()) {
                if (el.type.getType() == Const.T_INT) {
                    il.append(el.il);
                    il.append(er.il);
                    il.append(factory.createCast(er.type, Type.INT));
                } else {
                    il.append(el.il);
                    il.append(factory.createCast(el.type, Type.INT));
                    il.append(er.il);
                }

            } else {
                if (el.type.getType() != Const.T_INT) {
                    il.append(el.il);
                    il.append(factory.createCast(el.type, Type.INT));
                    il.append(er.il);
                    il.append(factory.createCast(er.type, Type.INT));
                } else {
                    il.append(el.il);
                    il.append(er.il);
                }

            }
            il.append(factory.createBinaryOperation(op.trim(), Type.INT));
        } else {
            err.incompatibleTypes(new Type(((byte) 0), null) {
                @Override
                public String toString() {
                    return "Int,Float";
                }
            }, Utils.isNumericType(el.type) ? er.type : el.type);
        }
        return new BCELNode(Type.INT, il);
    }

    /**
     * OK
     **/
    @Override
    public BCELNode visitAND_OR_OP(swiftParser.AND_OR_OPContext ctx) {
        InstructionList il = new InstructionList();
        BCELNode el = visit(ctx.expression(0));
        BCELNode er = visit(ctx.expression(1));
        if (!Utils.castAllowed(el.type, Type.BOOLEAN) || !Utils.castAllowed(el.type, Type.BOOLEAN)) {
            err.incompatibleTypes(Type.BOOLEAN, !Utils.castAllowed(el.type, Type.BOOLEAN) ? el.type : er.type);
        }
        if (el.type.equals(Type.BOOLEAN) && er.type.equals(Type.BOOLEAN)) {
            il.append(el.il);
            il.append(er.il);
        } else {
            il.append(el.il);
            if (el.type.getType() != Const.T_BOOLEAN) {
                il.append(factory.createCASTtoBOOL(el.type));
            }
            il.append(er.il);
            if (er.type.getType() != Const.T_BOOLEAN) {
                il.append(factory.createCASTtoBOOL(er.type));
            }
        }
        il.append(factory.createBinaryOperation(ctx.op.getText(), Type.INT));
        return new BCELNode(Type.BOOLEAN, il);
    }

    /**
     * OK
     **/
    @Override
    public BCELNode visitPLUS_SUB_EQOP(swiftParser.PLUS_SUB_EQOPContext ctx) {
        String id = ctx.TK_IDENT().getText();
        BCELNode var = swiftMethod.getCurrentMethod().getSymbol(id);
        BCELNode exp = visit(ctx.expression().size() > 1 ? ctx.expression().get(1) : ctx.expression().get(0));
        InstructionList il = new InstructionList();
        if (var == null) {
            err.symbolNotFound(id);
        } else {
            if (var.cons) {
                err.attempToChangeConstant(id);
            } else {
                if (var.type.equals(Type.BOOLEAN) || var.type instanceof DictionaryType) {
                    err.unsuportedOperation(var.type, exp.type, ctx.op.getText());
                }
                if (var.type.getType() == Const.T_ARRAY) {
                    ArrayType t = ((ArrayType) var.type);
                    if (Utils.castAllowed(exp.type, t.getElementType())) {

                        BCELNode index = visit(ctx.expression().get(0));

                        il.append(factory.createLoad(var.type, var.num));
                        il.append(index.il);
                        il.append(InstructionConst.DUP2);
                        il.append(factory.createLoad(var.type, var.num));
                        index = visit(ctx.expression().get(0));
                        il.append(factory.createINDXARRAY(t.getElementType(), index.il));
                        il.append(exp.il);
                        if (exp.type.getType() != t.getElementType().getType()) {
                            il.append(factory.createCast(exp.type, t.getElementType()));
                        }
                        ArithmeticInstruction il1 = factory.createBinaryOperation(ctx.op.getText().equals("+=") ? "+" : "-", t.getElementType());
                        il.append(il1);
                        il.append(factory.createArrayStore(t.getElementType()));
                        index = visit(ctx.expression().get(0));
                        il.append(InstructionConst.POP);
                        il.append(factory.createINDXARRAY(t.getElementType(), index.il));
                        return new BCELNode(t.getElementType(), il, true);
                    } else {
                        err.incompatibleTypes(t.getElementType(), exp.type);
                    }
                } else if (var.type instanceof DictionaryType) {
                    err.unsuportedOperation(var.type, exp.type, ctx.op.getText());
                } else {
                    il.append(factory.createLoad(var.type, var.num));
                    if (var.type.equals(Type.STRING)) {
                        if (ctx.op.getText().equals("-=")) {
                            err.unsuportedOperation(var.type, exp.type, "-=");
                        }
                        il.append(factory.createNew("java.lang.StringBuffer"));
                        il.append(InstructionConst.DUP);
                        il.append(factory.createInvoke("java.lang.StringBuffer", "<init>", Type.VOID, new Type[]{}, Const.INVOKESPECIAL));
                        il.append(factory.createLoad(var.type, var.num));
                        il.append(factory.createInvoke("java.lang.StringBuffer", "append", Type.STRINGBUFFER, new Type[]{Type.STRING}, Const.INVOKEVIRTUAL));
                        il.append(exp.il);
                        il.append(factory.createInvoke("java.lang.StringBuffer", "append", Type.STRINGBUFFER, new Type[]{exp.type}, Const.INVOKEVIRTUAL));
                        il.append(factory.createInvoke("java.lang.StringBuffer", "toString", Type.STRING, new Type[]{}, Const.INVOKEVIRTUAL));
                    } else {
                        if (!var.type.equals(exp.type)) {
                            il.append(exp.il);
                            Instruction l = factory.createCast(exp.type, var.type);
                            il.append(l);
                            il.append(factory.createBinaryOperation(ctx.op.getText().equals("+=") ?
                                    "+" : "-", var.type));

                        }

                    }

                    il.append(factory.createStore(var.type, var.num));
                    il.append(factory.createLoad(var.type, var.num));
                }
            }

        }
        return new BCELNode(var.type, il, true);
    }

    /***
     * OK
     * **/
    @Override
    public BCELNode visitCOMP_OP(swiftParser.COMP_OPContext ctx) {
        InstructionList il = new InstructionList();
        BCELNode expl = visit(ctx.expression(0));
        BCELNode expr = visit(ctx.expression(1));
        Type t = Type.INT;
        if (Utils.isNumericType(expl.type) && Utils.isNumericType(expr.type)) {
            il.append(expl.il);
            if (expl.type != expr.type) {
                t = Type.FLOAT;
                il.append(factory.createPROMOTE_UPPER(expl.type));
                il.append(expr.il);
                il.append(factory.createPROMOTE_UPPER(expr.type));
            } else {
                t = expr.type;
                il.append(expr.il);
            }

        } else {
            err.incompatibleTypes(new Type((byte) 0, null) {
                @Override
                public String toString() {
                    return "int,float";
                }
            }, Utils.isNumericType(expl.type) ? expr.type : expl.type);
        }
        short op = -1;
        short type = t.getType();

        switch (ctx.op.getText()) {
            case ">":
                op = type == Const.T_INT ? Const.IF_ICMPLE : Const.IFLE;
                break;
            case ">=":
                op = type == Const.T_INT ? Const.IF_ICMPLT : Const.IFLT;
                break;
            case "<":
                op = type == Const.T_INT ? Const.IF_ICMPGE : Const.IFGE;
                break;
            case "<=":
                op = type == Const.T_INT ? Const.IF_ICMPGT : Const.IFGT;
                break;
        }

        il.append(factory.createCOMP_OP(t, op));
        return new BCELNode(Type.BOOLEAN, il, false);
    }

    @Override
    public BCELNode visitEXP_ST(swiftParser.EXP_STContext ctx) {
        BCELNode sent = visit(ctx.expression());
        InstructionList i = sent.il;
        if (sent != null && !sent.sent) {
            err.notAstatement(ctx.expression().getText());
        }
        if (sent != null) {
            sent.il.append(new POP());
        }
        return sent;
    }

    @Override
    public BCELNode visitCode_block(swiftParser.Code_blockContext ctx) {
        swiftMethod.getCurrentMethod().generateTableSymbolCopy();
        BCELNode r = visit(ctx.statements());
        swiftMethod.getCurrentMethod().removeTableSymbolCopy();
        return r;
    }

    @Override
    public BCELNode visitIf_statement(swiftParser.If_statementContext ctx) {
        swiftMethod.getCurrentMethod().generateTableSymbolCopy();
        BCELNode con = visit(ctx.expression());
        InstructionList il = new InstructionList();
        il.append(con.il);

        InstructionList codeBlock = visit(ctx.code_block()).il;
        BCELNode elses = null;
        if (ctx.else_clause() != null) {
            elses = visit(ctx.else_clause());
            elses.il.append(new NOP());
            codeBlock.append(factory.createBranchInstruction(Const.GOTO, elses.il.getEnd()));


        }
        codeBlock.append(new NOP());
        InstructionHandle h = codeBlock.getEnd();
        il.append(factory.createBranchInstruction(Const.IFEQ, h));
        il.append(codeBlock);
        if (elses != null) {
            il.append(elses.il);
        }
        swiftMethod.getCurrentMethod().removeTableSymbolCopy();
        return new BCELNode(null, il, true);
    }

    @Override
    public BCELNode visitStatements(swiftParser.StatementsContext ctx) {
        InstructionList il = new InstructionList();
        for (swiftParser.StatementContext statementContext : ctx.statement()) {
            BCELNode node = visit(statementContext);
            if (node != null) {
                il.append(node.il);
            }
        }
        return new BCELNode(null, il, true);
    }

    @Override
    public BCELNode visitPARENTESIS(swiftParser.PARENTESISContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public BCELNode visitEnd_for(swiftParser.End_forContext ctx) {
        return ctx.expression() != null ? visit(ctx.expression()) : null;
    }

    @Override
    public BCELNode visitFor_statement(swiftParser.For_statementContext ctx) {
        swiftMethod.getCurrentMethod().generateTableSymbolCopy();
        breakHandles.push(new ArrayList<>());
        InstructionList il = new InstructionList();

        BCELNode for_init = ctx.for_init() != null ? visit(ctx.for_init()) : null;
        BCELNode cond = ctx.expression() != null ? visit(ctx.expression()) : null;
        BCELNode endf = visit(ctx.end_for());


        InstructionList t = new InstructionList(InstructionConst.NOP);
        il.append(for_init == null ? t : for_init.il);
        InstructionHandle c = il.append(InstructionConst.NOP);
        il.append(cond == null ? new InstructionList(factory.createConstant(1)) : cond.il);
        InstructionHandle d = il.append(InstructionConst.NOP);

        InstructionHandle h = null;
        if (endf != null) {
            h = il.append(InstructionConst.NOP);
            il.append(endf.il);
            if (endf.sent) {
                il.append(InstructionConst.POP);
            }
        }
        continueHandles.push(h);
        if (ctx.code_block() != null) {
            BCELNode code = visit(ctx.code_block());
            if (h == null) {
                il.append(code.il);
            } else {
                il.insert(h, code.il);
            }
        }


        il.append(factory.createBranchInstruction(Const.GOTO, c));
        InstructionHandle fin = il.append(InstructionConst.NOP);
        il.insert(d, factory.createBranchInstruction(Const.IFEQ, fin));

        Utils.resolveBreaks(il, breakHandles, factory);
        swiftMethod.getCurrentMethod().removeTableSymbolCopy();
        continueHandles.pop();
        return new BCELNode(Type.VOID, il, true);
    }

    @Override
    public BCELNode visitFor_init(swiftParser.For_initContext ctx) {
        BCELNode var;
        if (ctx.variable_declaration() == null) {
            var = visit(ctx.expression_list());
            var.sent = false;
        } else {
            var = visit(ctx.variable_declaration());
            var.sent = true;
        }
        return var;
    }

    @Override
    public BCELNode visitExpression_list(swiftParser.Expression_listContext ctx) {
        InstructionList il = new InstructionList();
        for (swiftParser.ExpressionContext e : ctx.expression()) {
            BCELNode ex = visit(e);
            il.append(ex.il);
            if (Utils.isNumericType(ex.type) || Utils.isReferenceType(ex.type) || Utils.isLogicType(ex.type) || Utils.isStringType(ex.type)) {
                il.append(InstructionConst.POP);
            }
        }
        return new BCELNode(Type.VOID, il);
    }

    @Override
    public BCELNode visitWhile_statement(swiftParser.While_statementContext ctx) {
        InstructionList il = new InstructionList();
        swiftMethod.getCurrentMethod().generateTableSymbolCopy();
        continueHandles.push(il.append(InstructionConst.NOP));
        breakHandles.push(new ArrayList<>());
        BCELNode ex = visit(ctx.expression());
        BCELNode code = visit(ctx.code_block());

        //cargo cond
        InstructionHandle h2 = il.append(InstructionConst.NOP);
        il.append(ex.il);

        InstructionHandle h = il.append(InstructionConst.NOP);
        if (Utils.castAllowed(ex.type, Type.BOOLEAN)) {
            il.append(factory.createCASTtoBOOL(ex.type));
            h = il.append(InstructionConst.NOP);
        } else {
            err.incompatibleTypes(Type.BOOLEAN, ex.type);
        }
        //cargo code
        il.append(code.il);
        il.append(factory.createBranchInstruction(Const.GOTO, h2));
        InstructionHandle h1 = il.append(InstructionConst.NOP);
        il.insert(h, factory.createBranchInstruction(Const.IFEQ, h1));
        swiftMethod.getCurrentMethod().removeTableSymbolCopy();
        continueHandles.pop();
        Utils.resolveBreaks(il, breakHandles, factory);
        return new BCELNode(Type.VOID, il, true);
    }

    @Override
    public BCELNode visitADD_SUB_OP(swiftParser.ADD_SUB_OPContext ctx) {
        InstructionList il = new InstructionList();

        BCELNode el = visit(ctx.expression().get(0));
        BCELNode er = visit(ctx.expression().get(1));
        Type t = el.type;

        if (Utils.isNumericType(el.type) && Utils.isNumericType(er.type)) {
            il.append(el.il);
            if (el.type.getType() == Const.T_FLOAT || er.type.getType() == Const.T_FLOAT) {
                il.append(factory.createPROMOTE_UPPER(el.type));
                t = Type.FLOAT;
            }
            il.append(er.il);
            if (el.type.getType() == Const.T_FLOAT || er.type.getType() == Const.T_FLOAT) {
                il.append(factory.createPROMOTE_UPPER(er.type));
            }
            il.append(factory.createBinaryOperation(ctx.op.getText(), t));
        } else {
            if ((Utils.isStringRef(el.type) || Utils.isStringRef(er.type))) {
                if (Utils.supportADD_SUB(el.type, ctx.op.getText()) && Utils.supportADD_SUB(er.type, ctx.op.getText())) {
                    if (Utils.isStringRef(el.type)) {
                        il.append(factory.createADD_STRINGINI(el, er));
                    } else {
                        il.append(factory.createADD_STRINGINI(el, er));
                    }
                }
                t = Type.STRING;
            } else {
                err.opTypeMismatch(ctx.op.getText(), ctx.expression().get(0).getText(), ctx.expression().get(0).getText());
            }
        }
        return new BCELNode(t, il);
    }

    @Override
    public BCELNode visitMUL_DIV_MOD_EQOP(swiftParser.MUL_DIV_MOD_EQOPContext ctx) {
        InstructionList il = new InstructionList();
        BCELNode var = swiftMethod.getCurrentMethod().getSymbol(ctx.TK_IDENT().getText());
        if (var == null) {
            err.symbolNotFound(ctx.getText());
        }
        if (var.cons && var.initialized) {
            err.attempToChangeConstant(ctx.TK_IDENT().getText());
        }
        BCELNode el = null;
        BCELNode er;
        if (ctx.expression().size() > 1) {
            er = visit(ctx.expression().get(1));
            el = visit(ctx.expression().get(0));
        } else {
            er = visit(ctx.expression().get(0));
        }
        Type t = var.type;
        if (var.type instanceof DictionaryType) {
            err.unsuportedOperation(var.type, er.type, ctx.op.getText());
        }
        if (el == null) {
            if (Utils.isNumericType(er.type) && Utils.isNumericType(var.type)) {
                il.append(factory.createLoad(var.type, var.num));
                if (var.type.getType() == Const.T_FLOAT || er.type.getType() == Const.T_FLOAT) {
                    il.append(factory.createPROMOTE_UPPER(var.type));
                    t = Type.FLOAT;
                }
                il.append(er.il);
                if (var.type.getType() == Const.T_FLOAT || er.type.getType() == Const.T_FLOAT) {
                    il.append(factory.createPROMOTE_UPPER(er.type));
                }
                il.append(factory.createBinaryOperation(ctx.op.getText(), t));
                il.append(InstructionConst.DUP);
                il.append(factory.createStore(var.type, var.num));
            } else {
                err.opTypeMismatch(ctx.op.getText(), ctx.expression().get(0).getText(), ctx.expression().get(0).getText());
            }
        } else {
            ArrayType at = ((ArrayType) t);
            if (el.type.getType() != Const.T_INT) {
                err.incompatibleTypes(Type.INT, el.type);
            }
            t = at.getElementType();
            if (Utils.isNumericType(er.type) && Utils.isNumericType(at.getElementType())) {
                il.append(factory.createLoad(var.type, var.num));
                il.append(el.il);
                il.append(InstructionConst.DUP2);
                il.append(InstructionConst.POP);
                el = visit(ctx.expression(0));
                il.append(factory.createINDXARRAY(at.getElementType(), el.il));
                if (at.getElementType().getType() == Const.T_FLOAT || er.type.getType() == Const.T_FLOAT) {
                    il.append(factory.createPROMOTE_UPPER(at.getElementType()));
                    t = Type.FLOAT;
                }
                il.append(er.il);
                if (at.getElementType().getType() == Const.T_FLOAT || er.type.getType() == Const.T_FLOAT) {
                    il.append(factory.createPROMOTE_UPPER(er.type));
                }
                il.append(factory.createBinaryOperation(ctx.op.getText(), t));
                il.append(factory.createArrayStore(at.getElementType()));
                il.append(factory.createLoad(var.type, var.num));
                il.append(visit(ctx.expression(0)).il);
                il.append(factory.createArrayLoad(at.getElementType()));
            } else {
                err.opTypeMismatch(ctx.op.getText(), ctx.expression().get(0).getText(), ctx.expression().get(0).getText());
            }
        }
        return new BCELNode(t, il, true);
    }

    @Override
    public BCELNode visitNOT_OP(swiftParser.NOT_OPContext ctx) {
        InstructionList il = new InstructionList();
        BCELNode exp = visit(ctx.expression());
        il.append(exp.il);
        il.append(factory.createNOT(exp.type));
        return new BCELNode(Type.BOOLEAN, il);
    }

    @Override
    public BCELNode visitAND_OR_EQOP(swiftParser.AND_OR_EQOPContext ctx) {
        InstructionList il = new InstructionList();
        BCELNode var = swiftMethod.getCurrentMethod().getSymbol(ctx.TK_IDENT().getText());
        if (var == null) {
            err.symbolNotFound(ctx.getText());
        }
        Type res = var.type;
        String op;
        if (ctx.op.getText().equals("&=")) {
            op = "&";
        } else {
            op = "|";
        }
        BCELNode el = null;
        BCELNode er = null;
        if (var.type instanceof DictionaryType) {
            err.unsuportedOperation(var.type, er.type, ctx.op.getText());
        }
        if (ctx.expression().size() > 1) {
            el = visit(ctx.expression(0));
            if (el.type.getType() != Const.T_INT) {
                err.incompatibleTypes(Type.INT, el.type);
            }
            er = visit(ctx.expression(1));
        } else {
            er = visit(ctx.expression(0));
        }
        if (el == null) {
            if (var.type.getType() != Const.T_INT || er.type.getType() != Const.T_INT) {
                err.incompatibleTypes(Type.INT, var.type.getType() != Const.T_INT ? var.type : er.type);
            }
            if (var.type.getType() == er.type.getType()) {
                il.append(factory.createLoad(var.type, var.num));
                il.append(er.il);
                il.append(factory.createBinaryOperation(op, var.type));
                il.append(InstructionConst.DUP);
                il.append(factory.createStore(var.type, var.num));
            } else {
                err.opTypeMismatch(op + "=", ctx.TK_IDENT().getText(), ctx.expression(0).toString());
            }
        } else {
            ArrayType t = ((ArrayType) var.type);
            if (!Utils.isNumericType(t.getElementType()) || !Utils.isNumericType(er.type)) {
                err.incompatibleTypes(new NumericType(), !Utils.isNumericType(t.getElementType()) ? t.getElementType() : er.type);
            }
            res = t.getElementType();
            il.append(factory.createLoad(var.type, var.num));
            il.append(visit(ctx.expression(0)).il);
            il.append(InstructionConst.DUP2);
            il.append(InstructionConst.POP);
            il.append(factory.createINDXARRAY(((ArrayType) var.type).getElementType(), el.il));
            il.append(er.il);
            //il.append(visit(ctx.expression(0)).il);
            il.append(factory.createBinaryOperation(op, Type.INT));
            il.append(factory.createArrayStore(((ArrayType) var.type).getElementType()));
            il.append(factory.createLoad(var.type, var.num));
            il.append(factory.createINDXARRAY(t.getElementType(), visit(ctx.expression(0)).il));
        }

        return new BCELNode(res, il, true);
    }

    @Override
    public BCELNode visitContinue_statement(swiftParser.Continue_statementContext ctx) {
        InstructionList il = new InstructionList();
        if (continueHandles.isEmpty()) {
            err.continueOutOfCicle("Continue");
        }
        il.append(factory.createBranchInstruction(Const.GOTO, continueHandles.peek()));
        return new BCELNode(Type.VOID, il, true);
    }

    @Override
    public BCELNode visitBreak_statement(swiftParser.Break_statementContext ctx) {
        InstructionList il = new InstructionList();
        if (breakHandles.isEmpty()) {
            err.continueOutOfCicle("Break");
        }
        breakHandles.peek().add(il.append(InstructionConst.NOP));
        return new BCELNode(Type.VOID, il, true);
    }

    @Override
    public BCELNode visitSwitch_statement(swiftParser.Switch_statementContext ctx) {
        InstructionList il = new InstructionList();
        breakHandles.push(new ArrayList<>());
        BCELNode exp = visit(ctx.expression());
        cases_cte.push(new int[0]);
        targets.push(new InstructionHandle[0]);
        il.append(exp.il);
        InstructionHandle swExp = il.append(InstructionConst.NOP);
        if (exp.type.getType() != Const.T_INT) {
            err.incompatibleTypes(Type.INT, exp.type);
        }
        int size = ctx.default_label() != null ? ctx.code_block().size() - 1 : ctx.code_block().size();
        for (int i = 0; i < size; i++) {
            BCELNode caseCmp = visit(ctx.case_label(i));
            BCELNode caseSt = visit(ctx.code_block(i));
            if (caseCmp.type.getType() != Const.T_INT) {
                err.incompatibleTypes(Type.INT, exp.type);
            }
            InstructionHandle h = il.append(InstructionConst.NOP);
            il.append(caseSt.il);
            Utils.appendCase(cases_cte, targets, (Integer) caseCmp.value, h);
        }
        BCELNode def = ctx.default_label() == null ? null : visit(ctx.code_block(ctx.code_block().size() - 1));
        InstructionHandle h = il.append(InstructionConst.NOP);
        if (def != null) {
            il.append(def.il);
            target_default.push(h);
        }
        il.insert(swExp, new LOOKUPSWITCH(cases_cte.pop(), targets.pop(), h));
        Utils.resolveBreaks(il, breakHandles, factory);
        return new BCELNode(Type.VOID, il, true);
    }

    @Override
    public BCELNode visitCase_label(swiftParser.Case_labelContext ctx) {
        return visit(ctx.integer_literal());
    }

    @Override
    public BCELNode visitTERNARY_OP(swiftParser.TERNARY_OPContext ctx) {
        BCELNode ex = visit(ctx.expression(0));
        BCELNode ext = visit(ctx.expression(1));
        BCELNode exf = visit(ctx.expression(2));
        InstructionList il = new InstructionList();

        if (Utils.castAllowed(ex.type, Type.BOOLEAN)) {
            il.append(ex.il);
            il.append(factory.createCASTtoBOOL(ex.type));
            InstructionHandle h = il.append(InstructionConst.NOP);
            il.append(ext.il);
            InstructionHandle h2 = il.append(InstructionConst.NOP);
            InstructionHandle h1 = il.append(InstructionConst.NOP);
            il.append(exf.il);
            il.insert(h, factory.createBranchInstruction(Const.IFEQ, h1));
            InstructionHandle h3 = il.append(InstructionConst.NOP);
            il.insert(h2, factory.createBranchInstruction(Const.GOTO, h3));
        } else {
            err.incompatibleTypes(new NumericType(), ex.type);
        }
        return new BCELNode(ext.type, il);
    }

    @Override
    public BCELNode visitRANGE_OP(swiftParser.RANGE_OPContext ctx) {
        BCELNode exp1 = visit(ctx.range_ops(0).integer_literal());
        BCELNode exp2 = visit(ctx.range_ops(1).integer_literal());
        if (exp1.type.getType() == Const.T_INT && exp2.type.getType() == Const.T_INT) {
            int ex1 = (int) exp1.value * ((ctx.range_ops(0).SUB() == null) ? 1 : -1);
            int ex2 = (int) exp2.value * ((ctx.range_ops(1).SUB() == null) ? 1 : -1);
            boolean inc = ctx.RANGE() == null;
            if ((ex2 > ex1 && !inc) || (ex2 >= ex1 && inc)) {
                InstructionList instructionList = factory.createRANGE_ARRAY(inc, ex1, ex2);
                return new BCELNode(new ArrayType(Type.INT, 1), instructionList);
            }
            throw new RuntimeException("Bad range " + ctx.range_ops(0).getText() + "->" + ctx.range_ops(1).getText());
        }
        err.incompatibleTypes(Type.INT, (exp1.type.getType() != Const.T_INT) ? exp1.type : exp2.type);
        return null;
    }

    @Override
    public BCELNode visitCAST_OP(swiftParser.CAST_OPContext ctx) {
        BCELNode exp = visit(ctx.expression());
        BCELNode type = visit(ctx.type());
        InstructionList il = new InstructionList();
        if (!exp.type.equals(type.type)) {
            switch (type.type.getType()) {
                case Const.T_INT:
                    switch (exp.type.getType()) {
                        case Const.T_FLOAT:
                            il.append(exp.il);
                            il.append(InstructionConst.F2I);
                            break;
                        case Const.T_BOOLEAN:
                            return new BCELNode(Type.INT, exp.il);
                        default:
                            err.castNotAllowed(exp.type, type.type);
                            return null;
                    }
                    return new BCELNode(Type.INT, il);
                case Const.T_FLOAT:
                    switch (exp.type.getType()) {
                        case Const.T_INT:
                        case Const.T_BOOLEAN:
                            il.append(exp.il);
                            il.append(InstructionConst.I2F);
                            break;
                        default:
                            err.castNotAllowed(exp.type, type.type);
                            return null;
                    }
                    return new BCELNode(Type.FLOAT, il);
                case Const.T_BOOLEAN:
                    il.append(exp.il);
                    il.append(factory.createCASTtoBOOL(exp.type));
                    return new BCELNode(Type.BOOLEAN, il);
                default:
                    err.castNotAllowed(exp.type, type.type);
                    return null;
            }
        }
        return exp;
    }

    @Override
    public BCELNode visitCOUNT(swiftParser.COUNTContext ctx) {
        BCELNode exp = visit(ctx.expression());
        InstructionList il = new InstructionList();
        il.append(exp.il);
        if (exp.type.equals(Type.STRING)) {
            il.append(factory.createInvoke(String.class.getTypeName(), "length", Type.INT
                    , Type.NO_ARGS, Const.INVOKEVIRTUAL));
            return new BCELNode(Type.INT, il);
        } else if (exp.type.getType() == Const.T_ARRAY) {
            il.append(InstructionConst.ARRAYLENGTH);
            return new BCELNode(Type.INT, il);
        } else if (exp.type instanceof DictionaryType) {
            il.append(factory.createInvoke(HashMap.class.getTypeName(), "size", Type.INT
                    , Type.NO_ARGS, Const.INVOKEVIRTUAL));
            return new BCELNode(Type.INT, il);
        }
        err.incompatibleTypes(Type.OBJECT, exp.type);
        return null;
    }

    @Override
    public BCELNode visitAPPEND(swiftParser.APPENDContext ctx) {
        BCELNode exp1 = visit(ctx.expression(0));
        BCELNode exp2 = visit(ctx.expression(1));
        InstructionList il = new InstructionList();
        if (exp1.type.equals(exp2.type)) {
            if (exp1.type.equals(Type.STRING)) {
                il.append(factory.createADD_STRINGINI(exp1, exp2));
                return new BCELNode(Type.STRING, il);
            } else if (exp1.type.getType() == Const.T_ARRAY || exp1.type instanceof DictionaryType) {
                il.append(factory.createAPPENDARRAYS_DIC(exp1.type, exp1.il, exp2.il));
                return new BCELNode(exp1.type, il);
            }
        }
        throw new RuntimeException("To make an append both expression must be of the same type and one of this ARRAY, STRING or DICTIONARY");
    }

    @Override
    public BCELNode visitNEW_ARRAY(swiftParser.NEW_ARRAYContext ctx) {
        BCELNode type = visit(ctx.type());
        InstructionList il = new InstructionList();
        if (ctx.expression() != null) {
            BCELNode count = visit(ctx.expression(0));
            BCELNode value = visit(ctx.expression(1));
            if (count.type.getType() == Const.T_INT && value.type.equals(type.type)) {
                il.append(count.il);
                il.append(factory.createNewArray(type.type, (short) 1));
                il.append(InstructionConst.DUP);
                il.append(value.il);
                il.append(factory.createInvoke(Arrays.class.getTypeName(), "fill", Type.VOID,
                        new Type[]{new ArrayType(type.type, 1), value.type}, Const.INVOKESTATIC));
            }
        } else {
            il.append(factory.createConstant(0));
            il.append(factory.createNewArray(type.type, (short) 1));
        }
        return new BCELNode(new ArrayType(type.type, 1), il);
    }

    @Override
    public BCELNode visitEQ_DIST_OP(swiftParser.EQ_DIST_OPContext ctx) {
        InstructionList il = new InstructionList();
        BCELNode exl = visit(ctx.expression(0));
        BCELNode exr = visit(ctx.expression(1));
        if (exl.type instanceof DictionaryType || exr.type instanceof DictionaryType) {
            err.unsuportedOperation(exl.type, exr.type, ctx.op.getText());
        }
        if (exl.type.getType() == Const.T_ARRAY || exr.type.getType() == Const.T_ARRAY) {
            err.unsuportedOperation(exl.type, exr.type, ctx.op.getText());
        }
        if (exr.type.getType() == exl.type.getType()) {
            if (Utils.isString(exl.type)) {
                il.append(exl.il);
                il.append(exr.il);
                il.append(factory.createInvoke("java.lang.String", "equals", Type.BOOLEAN, new Type[]{Type.OBJECT}, Const.INVOKEVIRTUAL));
            } else {
                il.append(exl.il);
                il.append(exr.il);
                il.append(factory.createEQ(exl.type));
            }
        } else {
            if (Utils.isString(exl.type) || Utils.isString(exr.type)) {
                System.out.println(exl.type + " " + exr.type);
                il.append(Utils.isString(exl.type) ? exl.il : exr.il);
                //il.append(Utils.isString(exl.type) ? exr.il : exl.il);
                il.append(factory.createCASTtoSTRING(Utils.isString(exl.type) ? exr : exl, Utils.isString(exl.type) ? exr.type : exl.type));
                il.append(factory.createInvoke("java.lang.String", "equals", Type.BOOLEAN, new Type[]{Type.OBJECT}, Const.INVOKEVIRTUAL));
            } else {
                il.append(exl.il);
                il.append(factory.createPROMOTE_UPPER(exl.type));
                il.append(exr.il);
                il.append(factory.createPROMOTE_UPPER(exr.type));
                il.append(factory.createEQ(Type.FLOAT));
            }
        }
        if (ctx.op.getText().equals("!=")) {
            il.append(factory.createNEG());
        }
        return new BCELNode(Type.BOOLEAN, il);
    }
}
