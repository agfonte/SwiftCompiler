package exceptions; /**
 * Created by JOKER on 4/15/2015.
 * Class necessary to unified errors message
 */

import org.apache.bcel.generic.Type;

public class RuntimeExceptions {
    /**
     * Launch an error with a incompatible types message
     *
     * @param expected The type expected
     * @param found    The type found
     */
    public void incompatibleTypes(Type expected, Type found) {
        throw new RuntimeException("Incompatible types.\nRequired :" + expected.toString() + "\nFound: " + found.toString());
    }

    /**
     * Method for variables or methods not declared
     *
     * @param id Name of the variable or method
     */
    public void symbolNotFound(String id) {
        throw new RuntimeException("Unable to resolve " + id + " variable");
    }

    /**
     * Method for modifications of constant variables
     *
     * @param var The variable that is attempted to be changed
     */
    public void attempToChangeConstant(String var) {
        throw new RuntimeException("The " + var + " symbol is constant  and is already  initialized,therefore cannot be changed");
    }

    public void opTypeMismatch(String op, String expression1, String expression2) {
        throw new RuntimeException("Can't resolve " + (expression1 != null ? expression1 : "") + op + expression2 + " expression (Invalid type)");
    }

    public void notAstatement(String st) {
        throw new RuntimeException("[ " + st + " ]" + "is not a statement.");
    }

    public void unsuportedOperation(Type type, Type type1, String s) {
        throw new RuntimeException("Unsuported operation" + "[" + s + "]" + " between " + type + " " + type1);
    }

    public void castNotAllowed(Type type, Type type1) {
        throw new RuntimeException("Cast not Supported.\nFrom " + type + " : To " + type1);
    }

    public void continueOutOfCicle(String s) {
        throw new RuntimeException(s + " sentence out of Cicle instruction");
    }
}
