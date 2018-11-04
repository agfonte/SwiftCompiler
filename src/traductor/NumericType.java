package traductor;

import org.apache.bcel.generic.Type;

public class NumericType extends Type {
    protected NumericType(byte t, String s) {
        super(t, s);
    }

    public NumericType() {
        super((byte) 0, "");
    }

    @Override
    public String toString() {
        return "Int,Double";
    }
}
