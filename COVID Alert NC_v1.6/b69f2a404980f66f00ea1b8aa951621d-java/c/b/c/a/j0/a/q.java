package c.b.c.a.j0.a;

import c.b.c.a.j0.a.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class q {

    /* renamed from: b  reason: collision with root package name */
    public static volatile q f3630b;

    /* renamed from: c  reason: collision with root package name */
    public static final q f3631c = new q(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, y.e<?, ?>> f3632a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f3633a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3634b;

        public a(Object obj, int i) {
            this.f3633a = obj;
            this.f3634b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3633a == aVar.f3633a && this.f3634b == aVar.f3634b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f3633a) * 65535) + this.f3634b;
        }
    }

    public q() {
        this.f3632a = new HashMap();
    }

    public q(boolean z) {
        this.f3632a = Collections.emptyMap();
    }

    public static q a() {
        q qVar = f3630b;
        if (qVar == null) {
            synchronized (q.class) {
                qVar = f3630b;
                if (qVar == null) {
                    Class<?> cls = p.f3623a;
                    q qVar2 = null;
                    if (cls != null) {
                        try {
                            qVar2 = (q) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    if (qVar2 == null) {
                        qVar2 = f3631c;
                    }
                    f3630b = qVar2;
                    qVar = qVar2;
                }
            }
        }
        return qVar;
    }
}
