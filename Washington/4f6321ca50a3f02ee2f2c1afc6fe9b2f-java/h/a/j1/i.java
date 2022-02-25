package h.a.j1;

import f.b.b.a.k;
import h.a.c1;
import h.a.e;
import h.a.h0;
import h.a.i0;
import h.a.j0;
import h.a.q0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public final class i {
    public final j0 a;
    public final String b;

    public final class b {
        public final h0.d a;
        public h0 b;
        public i0 c;

        public b(h0.d dVar) {
            this.a = dVar;
            i0 a2 = i.this.a.a(i.this.b);
            this.c = a2;
            if (a2 != null) {
                this.b = a2.a(dVar);
                return;
            }
            throw new IllegalStateException(f.a.a.a.a.e(f.a.a.a.a.h("Could not find policy '"), i.this.b, "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files."));
        }
    }

    public static final class c extends h0.i {
        public c() {
        }

        public c(a aVar) {
        }

        @Override // h.a.h0.i
        public h0.e a(h0.f fVar) {
            return h0.e.f3540e;
        }

        public String toString() {
            return new k(c.class.getSimpleName(), null).toString();
        }
    }

    public static final class d extends h0.i {
        public final c1 a;

        public d(c1 c1Var) {
            this.a = c1Var;
        }

        @Override // h.a.h0.i
        public h0.e a(h0.f fVar) {
            return h0.e.a(this.a);
        }
    }

    public static final class e extends h0 {
        public e(a aVar) {
        }

        @Override // h.a.h0
        public void a(c1 c1Var) {
        }

        @Override // h.a.h0
        public void b(h0.g gVar) {
        }

        @Override // h.a.h0
        public void d() {
        }
    }

    public static final class f extends Exception {
        public f(String str, a aVar) {
            super(str);
        }
    }

    public static final class g {
        public final i0 a;
        public final Map<String, ?> b;
        public final Object c;

        public g(i0 i0Var, Map<String, ?> map, Object obj) {
            f.b.a.c.b.o.b.A(i0Var, "provider");
            this.a = i0Var;
            this.b = map;
            this.c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || g.class != obj.getClass()) {
                return false;
            }
            g gVar = (g) obj;
            return f.b.a.c.b.o.b.t0(this.a, gVar.a) && f.b.a.c.b.o.b.t0(this.b, gVar.b) && f.b.a.c.b.o.b.t0(this.c, gVar.c);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
        }

        public String toString() {
            k U1 = f.b.a.c.b.o.b.U1(this);
            U1.d("provider", this.a);
            U1.d("rawConfig", this.b);
            U1.d("config", this.c);
            return U1.toString();
        }
    }

    public i(String str) {
        j0 j0Var;
        Logger logger = j0.c;
        synchronized (j0.class) {
            if (j0.f3544d == null) {
                List<i0> q1 = f.b.a.c.b.o.b.q1(i0.class, j0.f3545e, i0.class.getClassLoader(), new j0.a());
                j0.f3544d = new j0();
                for (i0 i0Var : q1) {
                    Logger logger2 = j0.c;
                    logger2.fine("Service loader found " + i0Var);
                    if (i0Var.d()) {
                        j0 j0Var2 = j0.f3544d;
                        synchronized (j0Var2) {
                            f.b.a.c.b.o.b.o(i0Var.d(), "isAvailable() returned false");
                            j0Var2.a.add(i0Var);
                        }
                    }
                }
                j0.f3544d.b();
            }
            j0Var = j0.f3544d;
        }
        f.b.a.c.b.o.b.A(j0Var, "registry");
        this.a = j0Var;
        f.b.a.c.b.o.b.A(str, "defaultPolicy");
        this.b = str;
    }

    public static i0 a(i iVar, String str, String str2) {
        i0 a2 = iVar.a.a(str);
        if (a2 != null) {
            return a2;
        }
        throw new f("Trying to load '" + str + "' because " + str2 + ", but it's unavailable", null);
    }

    public q0.b b(Map<String, ?> map, h.a.e eVar) {
        List<s2> list;
        if (map != null) {
            try {
                list = f.b.a.c.b.o.b.V1(f.b.a.c.b.o.b.S0(map));
            } catch (RuntimeException e2) {
                return new q0.b(c1.f3519h.g("can't parse load balancer configuration").f(e2));
            }
        } else {
            list = null;
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (s2 s2Var : list) {
            String str = s2Var.a;
            i0 a2 = this.a.a(str);
            if (a2 == null) {
                arrayList.add(str);
            } else {
                if (!arrayList.isEmpty()) {
                    eVar.b(e.a.DEBUG, "{0} specified by Service Config are not available", arrayList);
                }
                q0.b e3 = a2.e(s2Var.b);
                if (e3.a != null) {
                    return e3;
                }
                return new q0.b(new g(a2, s2Var.b, e3.b));
            }
        }
        return new q0.b(c1.f3519h.g("None of " + arrayList + " specified by Service Config are available."));
    }
}
