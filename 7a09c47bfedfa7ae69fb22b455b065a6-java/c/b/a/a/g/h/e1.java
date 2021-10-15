package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class e1 {

    /* renamed from: b  reason: collision with root package name */
    public static volatile e1 f3867b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile e1 f3868c;

    /* renamed from: d  reason: collision with root package name */
    public static final e1 f3869d = new e1(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, t1.f<?, ?>> f3870a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f3871a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3872b;

        public a(Object obj, int i) {
            this.f3871a = obj;
            this.f3872b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3871a == aVar.f3871a && this.f3872b == aVar.f3872b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f3871a) * 65535) + this.f3872b;
        }
    }

    public e1() {
        this.f3870a = new HashMap();
    }

    public e1(boolean z) {
        this.f3870a = Collections.emptyMap();
    }

    public static e1 a() {
        e1 e1Var = f3867b;
        if (e1Var == null) {
            synchronized (e1.class) {
                e1Var = f3867b;
                if (e1Var == null) {
                    e1Var = f3869d;
                    f3867b = e1Var;
                }
            }
        }
        return e1Var;
    }
}
