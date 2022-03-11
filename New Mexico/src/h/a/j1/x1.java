package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import f.b.b.a.t;
import g.b.a.c.c.d;
import h.a.c1;
import h.a.j1.n2;
import h.a.o0;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class x1 {
    public final Map<String, a> a;
    public final Map<String, a> b;
    public final n2.x c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f4348d;

    /* loaded from: classes.dex */
    public static final class a {
        public final Long a;
        public final Boolean b;
        public final Integer c;

        /* renamed from: d  reason: collision with root package name */
        public final Integer f4349d;

        /* renamed from: e  reason: collision with root package name */
        public final o2 f4350e;

        /* renamed from: f  reason: collision with root package name */
        public final s0 f4351f;

        public a(Map<String, ?> map, boolean z, int i2, int i3) {
            Boolean bool;
            o2 o2Var;
            s0 s0Var;
            this.a = i1.h(map, "timeout");
            int i4 = i1.b;
            if (!map.containsKey("waitForReady")) {
                bool = null;
            } else {
                Object obj = map.get("waitForReady");
                if (obj instanceof Boolean) {
                    bool = (Boolean) obj;
                } else {
                    throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, "waitForReady", map));
                }
            }
            this.b = bool;
            Integer e2 = i1.e(map, "maxResponseMessageBytes");
            this.c = e2;
            if (e2 != null) {
                b.t(e2.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", e2);
            }
            Integer e3 = i1.e(map, "maxRequestMessageBytes");
            this.f4349d = e3;
            if (e3 != null) {
                b.t(e3.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", e3);
            }
            Map<String, ?> f2 = z ? i1.f(map, "retryPolicy") : null;
            if (f2 == null) {
                o2Var = o2.f4268f;
            } else {
                Integer e4 = i1.e(f2, "maxAttempts");
                b.A(e4, "maxAttempts cannot be empty");
                int intValue = e4.intValue();
                b.r(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
                int min = Math.min(intValue, i2);
                Long h2 = i1.h(f2, "initialBackoff");
                b.A(h2, "initialBackoff cannot be empty");
                long longValue = h2.longValue();
                b.s(longValue > 0, "initialBackoffNanos must be greater than 0: %s", longValue);
                Long h3 = i1.h(f2, "maxBackoff");
                b.A(h3, "maxBackoff cannot be empty");
                long longValue2 = h3.longValue();
                b.s(longValue2 > 0, "maxBackoff must be greater than 0: %s", longValue2);
                Double d2 = i1.d(f2, "backoffMultiplier");
                b.A(d2, "backoffMultiplier cannot be empty");
                double doubleValue = d2.doubleValue();
                b.t(doubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", Double.valueOf(doubleValue));
                Set<c1.b> n = d.n(f2, "retryableStatusCodes");
                b.x1(n != null, "%s is required in retry policy", "retryableStatusCodes");
                b.x1(!n.isEmpty(), "%s must not be empty", "retryableStatusCodes");
                b.x1(!n.contains(c1.b.OK), "%s must not contain OK", "retryableStatusCodes");
                o2Var = new o2(min, longValue, longValue2, doubleValue, n);
            }
            this.f4350e = o2Var;
            Map<String, ?> f3 = z ? i1.f(map, "hedgingPolicy") : null;
            if (f3 == null) {
                s0Var = s0.f4329d;
            } else {
                Integer e5 = i1.e(f3, "maxAttempts");
                b.A(e5, "maxAttempts cannot be empty");
                int intValue2 = e5.intValue();
                b.r(intValue2 >= 2, "maxAttempts must be greater than 1: %s", intValue2);
                int min2 = Math.min(intValue2, i3);
                Long h4 = i1.h(f3, "hedgingDelay");
                b.A(h4, "hedgingDelay cannot be empty");
                long longValue3 = h4.longValue();
                b.s(longValue3 >= 0, "hedgingDelay must not be negative: %s", longValue3);
                Set<c1.b> n2 = d.n(f3, "nonFatalStatusCodes");
                if (n2 == null) {
                    n2 = Collections.unmodifiableSet(EnumSet.noneOf(c1.b.class));
                } else {
                    b.x1(!n2.contains(c1.b.OK), "%s must not contain OK", "nonFatalStatusCodes");
                }
                s0Var = new s0(min2, longValue3, n2);
            }
            this.f4351f = s0Var;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return b.n0(this.a, aVar.a) && b.n0(this.b, aVar.b) && b.n0(this.c, aVar.c) && b.n0(this.f4349d, aVar.f4349d) && b.n0(this.f4350e, aVar.f4350e) && b.n0(this.f4351f, aVar.f4351f);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.f4349d, this.f4350e, this.f4351f});
        }

        public String toString() {
            k u1 = b.u1(this);
            u1.d("timeoutNanos", this.a);
            u1.d("waitForReady", this.b);
            u1.d("maxInboundMessageSize", this.c);
            u1.d("maxOutboundMessageSize", this.f4349d);
            u1.d("retryPolicy", this.f4350e);
            u1.d("hedgingPolicy", this.f4351f);
            return u1.toString();
        }
    }

    public x1(Map<String, a> map, Map<String, a> map2, n2.x xVar, Object obj) {
        this.a = Collections.unmodifiableMap(new HashMap(map));
        this.b = Collections.unmodifiableMap(new HashMap(map2));
        this.c = xVar;
        this.f4348d = obj;
    }

    public static x1 a(Map<String, ?> map, boolean z, int i2, int i3, Object obj) {
        n2.x xVar;
        Map<String, ?> f2;
        if (!z || map == null || (f2 = i1.f(map, "retryThrottling")) == null) {
            xVar = null;
        } else {
            float floatValue = i1.d(f2, "maxTokens").floatValue();
            float floatValue2 = i1.d(f2, "tokenRatio").floatValue();
            b.G(floatValue > 0.0f, "maxToken should be greater than zero");
            b.G(floatValue2 > 0.0f, "tokenRatio should be greater than zero");
            xVar = new n2.x(floatValue, floatValue2);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        List<?> b = i1.b(map, "methodConfig");
        if (b == null) {
            b = null;
        } else {
            i1.a(b);
        }
        if (b == null) {
            return new x1(hashMap, hashMap2, xVar, obj);
        }
        Iterator<?> it = b.iterator();
        while (it.hasNext()) {
            Map map2 = (Map) it.next();
            a aVar = new a(map2, z, i2, i3);
            List<?> b2 = i1.b(map2, "name");
            if (b2 == null) {
                b2 = null;
            } else {
                i1.a(b2);
            }
            b.t(b2 != null && !b2.isEmpty(), "no names in method config %s", map2);
            Iterator<?> it2 = b2.iterator();
            while (it2.hasNext()) {
                Map map3 = (Map) it2.next();
                String g2 = i1.g(map3, "service");
                b.p(!t.a(g2), "missing service name");
                String g3 = i1.g(map3, "method");
                if (t.a(g3)) {
                    b.t(!hashMap2.containsKey(g2), "Duplicate service %s", g2);
                    hashMap2.put(g2, aVar);
                } else {
                    String a2 = o0.a(g2, g3);
                    b.t(!hashMap.containsKey(a2), "Duplicate method name %s", a2);
                    hashMap.put(a2, aVar);
                }
            }
        }
        return new x1(hashMap, hashMap2, xVar, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x1.class != obj.getClass()) {
            return false;
        }
        x1 x1Var = (x1) obj;
        return b.n0(this.a, x1Var.a) && b.n0(this.b, x1Var.b) && b.n0(this.c, x1Var.c) && b.n0(this.f4348d, x1Var.f4348d);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.f4348d});
    }

    public String toString() {
        k u1 = b.u1(this);
        u1.d("serviceMethodMap", this.a);
        u1.d("serviceMap", this.b);
        u1.d("retryThrottling", this.c);
        u1.d("loadBalancingConfig", this.f4348d);
        return u1.toString();
    }
}
