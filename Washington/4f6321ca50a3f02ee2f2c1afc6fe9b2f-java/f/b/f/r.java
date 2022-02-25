package f.b.f;

import f.b.f.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class r {
    public static volatile r b;
    public static final r c = new r(true);
    public final Map<a, z.e<?, ?>> a;

    public static final class a {
        public final Object a;
        public final int b;

        public a(Object obj, int i2) {
            this.a = obj;
            this.b = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    public r() {
        this.a = new HashMap();
    }

    public r(boolean z) {
        this.a = Collections.emptyMap();
    }

    public static r a() {
        r rVar = b;
        if (rVar == null) {
            synchronized (r.class) {
                rVar = b;
                if (rVar == null) {
                    Class<?> cls = q.a;
                    r rVar2 = null;
                    if (cls != null) {
                        try {
                            rVar2 = (r) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    if (rVar2 == null) {
                        rVar2 = c;
                    }
                    b = rVar2;
                    rVar = rVar2;
                }
            }
        }
        return rVar;
    }
}
