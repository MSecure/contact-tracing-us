package h.a;

import f.b.b.a.k;
import h.a.a;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public abstract class q0 {

    public static final class a {
        public final int a;
        public final y0 b;
        public final g1 c;

        /* renamed from: d  reason: collision with root package name */
        public final g f4226d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f4227e;

        /* renamed from: f  reason: collision with root package name */
        public final e f4228f;

        /* renamed from: g  reason: collision with root package name */
        public final Executor f4229g;

        public a(Integer num, y0 y0Var, g1 g1Var, g gVar, ScheduledExecutorService scheduledExecutorService, e eVar, Executor executor, p0 p0Var) {
            f.b.a.c.b.o.b.z(num, "defaultPort not set");
            this.a = num.intValue();
            f.b.a.c.b.o.b.z(y0Var, "proxyDetector not set");
            this.b = y0Var;
            f.b.a.c.b.o.b.z(g1Var, "syncContext not set");
            this.c = g1Var;
            f.b.a.c.b.o.b.z(gVar, "serviceConfigParser not set");
            this.f4226d = gVar;
            this.f4227e = scheduledExecutorService;
            this.f4228f = eVar;
            this.f4229g = executor;
        }

        public String toString() {
            k q1 = f.b.a.c.b.o.b.q1(this);
            q1.a("defaultPort", this.a);
            q1.d("proxyDetector", this.b);
            q1.d("syncContext", this.c);
            q1.d("serviceConfigParser", this.f4226d);
            q1.d("scheduledExecutorService", this.f4227e);
            q1.d("channelLogger", this.f4228f);
            q1.d("executor", this.f4229g);
            return q1.toString();
        }
    }

    public static final class b {
        public final c1 a;
        public final Object b;

        public b(c1 c1Var) {
            this.b = null;
            f.b.a.c.b.o.b.z(c1Var, "status");
            this.a = c1Var;
            f.b.a.c.b.o.b.s(!c1Var.e(), "cannot use OK status: %s", c1Var);
        }

        public b(Object obj) {
            f.b.a.c.b.o.b.z(obj, "config");
            this.b = obj;
            this.a = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return f.b.a.c.b.o.b.m0(this.a, bVar.a) && f.b.a.c.b.o.b.m0(this.b, bVar.b);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b});
        }

        public String toString() {
            if (this.b != null) {
                k q1 = f.b.a.c.b.o.b.q1(this);
                q1.d("config", this.b);
                return q1.toString();
            }
            k q12 = f.b.a.c.b.o.b.q1(this);
            q12.d("error", this.a);
            return q12.toString();
        }
    }

    public static abstract class c {
        @Deprecated
        public static final a.c<Integer> a = new a.c<>("params-default-port");
        @Deprecated
        public static final a.c<y0> b = new a.c<>("params-proxy-detector");
        @Deprecated
        public static final a.c<g1> c = new a.c<>("params-sync-context");
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public static final a.c<g> f4230d = new a.c<>("params-parser");

        public class a extends d {
            public final /* synthetic */ a a;

            public a(c cVar, a aVar) {
                this.a = aVar;
            }
        }

        public abstract String a();

        public q0 b(URI uri, a aVar) {
            a aVar2 = new a(this, aVar);
            a.b a2 = a.a();
            a.c<Integer> cVar = a;
            a2.b(cVar, Integer.valueOf(aVar2.a.a));
            a.c<y0> cVar2 = b;
            a2.b(cVar2, aVar2.a.b);
            a.c<g1> cVar3 = c;
            a2.b(cVar3, aVar2.a.c);
            a.c<g> cVar4 = f4230d;
            a2.b(cVar4, new r0(this, aVar2));
            a a3 = a2.a();
            Integer valueOf = Integer.valueOf(((Integer) a3.a.get(cVar)).intValue());
            y0 y0Var = (y0) a3.a.get(cVar2);
            Objects.requireNonNull(y0Var);
            g1 g1Var = (g1) a3.a.get(cVar3);
            Objects.requireNonNull(g1Var);
            g gVar = (g) a3.a.get(cVar4);
            Objects.requireNonNull(gVar);
            return b(uri, new a(valueOf, y0Var, g1Var, gVar, null, null, null, null));
        }
    }

    @Deprecated
    public static abstract class d {
    }

    public static abstract class e {
        public abstract void a(c1 c1Var);

        public abstract void b(f fVar);
    }

    public static final class f {
        public final List<v> a;
        public final a b;
        public final b c;

        public f(List<v> list, a aVar, b bVar) {
            this.a = Collections.unmodifiableList(new ArrayList(list));
            f.b.a.c.b.o.b.z(aVar, "attributes");
            this.b = aVar;
            this.c = bVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return f.b.a.c.b.o.b.m0(this.a, fVar.a) && f.b.a.c.b.o.b.m0(this.b, fVar.b) && f.b.a.c.b.o.b.m0(this.c, fVar.c);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
        }

        public String toString() {
            k q1 = f.b.a.c.b.o.b.q1(this);
            q1.d("addresses", this.a);
            q1.d("attributes", this.b);
            q1.d("serviceConfig", this.c);
            return q1.toString();
        }
    }

    public static abstract class g {
        public abstract b a(Map<String, ?> map);
    }

    public abstract String a();

    public abstract void b();

    public abstract void c();

    public abstract void d(e eVar);
}
