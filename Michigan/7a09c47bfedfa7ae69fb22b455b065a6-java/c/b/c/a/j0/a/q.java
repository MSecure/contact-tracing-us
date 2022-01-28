package c.b.c.a.j0.a;

import c.b.c.a.j0.a.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class q {

    /* renamed from: b  reason: collision with root package name */
    public static volatile q f5009b;

    /* renamed from: c  reason: collision with root package name */
    public static final q f5010c = new q(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, y.e<?, ?>> f5011a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f5012a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5013b;

        public a(Object obj, int i) {
            this.f5012a = obj;
            this.f5013b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5012a == aVar.f5012a && this.f5013b == aVar.f5013b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f5012a) * 65535) + this.f5013b;
        }
    }

    public q() {
        this.f5011a = new HashMap();
    }

    public q(boolean z) {
        this.f5011a = Collections.emptyMap();
    }

    public static q a() {
        q qVar = f5009b;
        if (qVar == null) {
            synchronized (q.class) {
                qVar = f5009b;
                if (qVar == null) {
                    Class<?> cls = p.f5000a;
                    q qVar2 = null;
                    if (cls != null) {
                        try {
                            qVar2 = (q) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    if (qVar2 == null) {
                        qVar2 = f5010c;
                    }
                    f5009b = qVar2;
                    qVar = qVar2;
                }
            }
        }
        return qVar;
    }
}
