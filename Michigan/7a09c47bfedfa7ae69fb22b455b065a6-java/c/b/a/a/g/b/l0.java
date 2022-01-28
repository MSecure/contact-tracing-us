package c.b.a.a.g.b;

import java.util.Collections;
import java.util.HashMap;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static final l0 f3339a = new l0(true);

    static {
        try {
            Class.forName("c.b.d.v");
        } catch (ClassNotFoundException unused) {
        }
    }

    public l0() {
        new HashMap();
    }

    public l0(boolean z) {
        Collections.emptyMap();
    }

    public static l0 a() {
        Class<?> cls = k0.f3331a;
        if (cls != null) {
            try {
                return (l0) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return f3339a;
    }
}
