package e.y;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class a extends ObjectInputStream {
    public a(b bVar, InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        Class<?> cls = Class.forName(objectStreamClass.getName(), false, a.class.getClassLoader());
        return cls != null ? cls : super.resolveClass(objectStreamClass);
    }
}
