package e.r;

import e.r.q;
import f.a.a.a.a;
import java.util.HashMap;

public class r {
    public static final HashMap<Class<?>, String> b = new HashMap<>();
    public final HashMap<String, q<? extends j>> a = new HashMap<>();

    public static String b(Class<? extends q> cls) {
        HashMap<Class<?>, String> hashMap = b;
        String str = hashMap.get(cls);
        if (str == null) {
            q.b bVar = (q.b) cls.getAnnotation(q.b.class);
            str = bVar != null ? bVar.value() : null;
            if (d(str)) {
                hashMap.put(cls, str);
            } else {
                StringBuilder i2 = a.i("No @Navigator.Name annotation found for ");
                i2.append(cls.getSimpleName());
                throw new IllegalArgumentException(i2.toString());
            }
        }
        return str;
    }

    public static boolean d(String str) {
        return str != null && !str.isEmpty();
    }

    public final q<? extends j> a(q<? extends j> qVar) {
        String b2 = b(qVar.getClass());
        if (d(b2)) {
            return this.a.put(b2, qVar);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public <T extends q<?>> T c(String str) {
        if (d(str)) {
            q<? extends j> qVar = this.a.get(str);
            if (qVar != null) {
                return qVar;
            }
            throw new IllegalStateException(a.d("Could not find Navigator with name \"", str, "\". You must call NavController.addNavigator() for each navigation type."));
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }
}
