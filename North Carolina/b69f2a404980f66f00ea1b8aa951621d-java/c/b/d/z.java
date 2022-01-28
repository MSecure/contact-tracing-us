package c.b.d;

import c.b.d.j0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class z {

    /* renamed from: b  reason: collision with root package name */
    public static volatile z f4414b;

    /* renamed from: c  reason: collision with root package name */
    public static final z f4415c = new z(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, j0.d<?, ?>> f4416a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f4417a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4418b;

        public a(Object obj, int i) {
            this.f4417a = obj;
            this.f4418b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4417a == aVar.f4417a && this.f4418b == aVar.f4418b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f4417a) * 65535) + this.f4418b;
        }
    }

    public z() {
        this.f4416a = new HashMap();
    }

    public z(z zVar) {
        this.f4416a = zVar == f4415c ? Collections.emptyMap() : Collections.unmodifiableMap(zVar.f4416a);
    }

    public z(boolean z) {
        this.f4416a = Collections.emptyMap();
    }

    public static z a() {
        z zVar = f4414b;
        if (zVar == null) {
            synchronized (z.class) {
                zVar = f4414b;
                if (zVar == null) {
                    Class<?> cls = y.f4392a;
                    z zVar2 = null;
                    if (cls != null) {
                        try {
                            zVar2 = (z) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    if (zVar2 == null) {
                        zVar2 = f4415c;
                    }
                    f4414b = zVar2;
                    zVar = zVar2;
                }
            }
        }
        return zVar;
    }

    public static boolean b() {
        return false;
    }
}
