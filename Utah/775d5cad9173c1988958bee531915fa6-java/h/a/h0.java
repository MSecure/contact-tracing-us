package h.a;

import f.b.b.a.k;
import h.a.a;
import h.a.j;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class h0 {
    @Deprecated
    public static final a.c<Map<String, ?>> a = new a.c<>("io.grpc.LoadBalancer.loadBalancingConfig");

    public static final class b {
        public final List<v> a;
        public final a b;
        public final Object[][] c;

        public static final class a {
            public List<v> a;
            public a b = a.b;
            public Object[][] c = ((Object[][]) Array.newInstance(Object.class, 0, 2));
        }

        public b(List list, a aVar, Object[][] objArr, a aVar2) {
            f.b.a.c.b.o.b.z(list, "addresses are not set");
            this.a = list;
            f.b.a.c.b.o.b.z(aVar, "attrs");
            this.b = aVar;
            f.b.a.c.b.o.b.z(objArr, "customOptions");
            this.c = objArr;
        }

        public String toString() {
            k t1 = f.b.a.c.b.o.b.t1(this);
            t1.d("addrs", this.a);
            t1.d("attrs", this.b);
            t1.d("customOptions", Arrays.deepToString(this.c));
            return t1.toString();
        }
    }

    public static abstract class c {
        public abstract h0 a(d dVar);
    }

    public static abstract class d {
        public h a(b bVar) {
            throw new UnsupportedOperationException();
        }

        public e b() {
            throw new UnsupportedOperationException();
        }

        public g1 c() {
            throw new UnsupportedOperationException();
        }

        public abstract void d(n nVar, i iVar);
    }

    public static final class e {

        /* renamed from: e  reason: collision with root package name */
        public static final e f3855e = new e(null, null, c1.f3832f, false);
        public final h a;
        public final j.a b;
        public final c1 c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f3856d;

        public e(h hVar, j.a aVar, c1 c1Var, boolean z) {
            this.a = hVar;
            this.b = aVar;
            f.b.a.c.b.o.b.z(c1Var, "status");
            this.c = c1Var;
            this.f3856d = z;
        }

        public static e a(c1 c1Var) {
            f.b.a.c.b.o.b.o(!c1Var.e(), "error status shouldn't be OK");
            return new e(null, null, c1Var, false);
        }

        public static e b(h hVar) {
            f.b.a.c.b.o.b.z(hVar, "subchannel");
            return new e(hVar, null, c1.f3832f, false);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return f.b.a.c.b.o.b.m0(this.a, eVar.a) && f.b.a.c.b.o.b.m0(this.c, eVar.c) && f.b.a.c.b.o.b.m0(this.b, eVar.b) && this.f3856d == eVar.f3856d;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.c, this.b, Boolean.valueOf(this.f3856d)});
        }

        public String toString() {
            k t1 = f.b.a.c.b.o.b.t1(this);
            t1.d("subchannel", this.a);
            t1.d("streamTracerFactory", this.b);
            t1.d("status", this.c);
            t1.c("drop", this.f3856d);
            return t1.toString();
        }
    }

    public static abstract class f {
    }

    public static final class g {
        public final List<v> a;
        public final a b;
        public final Object c;

        public g(List list, a aVar, Object obj, a aVar2) {
            f.b.a.c.b.o.b.z(list, "addresses");
            this.a = Collections.unmodifiableList(new ArrayList(list));
            f.b.a.c.b.o.b.z(aVar, "attributes");
            this.b = aVar;
            this.c = obj;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return f.b.a.c.b.o.b.m0(this.a, gVar.a) && f.b.a.c.b.o.b.m0(this.b, gVar.b) && f.b.a.c.b.o.b.m0(this.c, gVar.c);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
        }

        public String toString() {
            k t1 = f.b.a.c.b.o.b.t1(this);
            t1.d("addresses", this.a);
            t1.d("attributes", this.b);
            t1.d("loadBalancingPolicyConfig", this.c);
            return t1.toString();
        }
    }

    public static abstract class h {
        public List<v> a() {
            throw new UnsupportedOperationException();
        }

        public abstract a b();

        public Object c() {
            throw new UnsupportedOperationException();
        }

        public abstract void d();

        public abstract void e();

        public void f(j jVar) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public void g(List<v> list) {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class i {
        public abstract e a(f fVar);
    }

    public interface j {
        void a(o oVar);
    }

    public abstract void a(c1 c1Var);

    public abstract void b(g gVar);

    public void c() {
    }

    public abstract void d();
}
