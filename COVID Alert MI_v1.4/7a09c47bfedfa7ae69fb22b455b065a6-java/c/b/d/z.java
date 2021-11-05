package c.b.d;

import c.b.d.k0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class z {

    /* renamed from: b  reason: collision with root package name */
    public static volatile z f5941b;

    /* renamed from: c  reason: collision with root package name */
    public static final z f5942c = new z(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, k0.d<?, ?>> f5943a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f5944a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5945b;

        public a(Object obj, int i) {
            this.f5944a = obj;
            this.f5945b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5944a == aVar.f5944a && this.f5945b == aVar.f5945b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f5944a) * 65535) + this.f5945b;
        }
    }

    public z() {
        this.f5943a = new HashMap();
    }

    public z(z zVar) {
        this.f5943a = zVar == f5942c ? Collections.emptyMap() : Collections.unmodifiableMap(zVar.f5943a);
    }

    public z(boolean z) {
        this.f5943a = Collections.emptyMap();
    }

    public static z a() {
        z zVar = f5941b;
        if (zVar == null) {
            synchronized (z.class) {
                zVar = f5941b;
                if (zVar == null) {
                    Class<?> cls = y.f5937a;
                    z zVar2 = null;
                    if (cls != null) {
                        try {
                            zVar2 = (z) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    if (zVar2 == null) {
                        zVar2 = f5942c;
                    }
                    f5941b = zVar2;
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
