package traductor;

import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.Type;

import java.util.HashMap;

/**
 * Created by Razor on 9/4/2017.
 * SwiftCompiler
 */
public class DictionaryType extends ObjectType {

    private Type keyType;
    private Type valueType;

    public DictionaryType(Type keyType, Type valueType) {
        super(HashMap.class.getTypeName());
        this.keyType = keyType;
        this.valueType = valueType;
    }

    public Type getKeyType() {
        return keyType;
    }

    public Type getValueType() {
        return valueType;
    }

    @Override
    public boolean equals(Object type) {
        DictionaryType otype;
        if (type instanceof DictionaryType) {
            otype = ((DictionaryType) type);
            return super.equals(otype) && keyType.equals(otype.keyType) && valueType.equals(otype.valueType);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Dictionary" + "<" + keyType + "," + valueType + ">";
    }
}
