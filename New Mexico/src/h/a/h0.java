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
/* loaded from: classes.dex */
public abstract class h0 {
    @Deprecated
    public static final a.c<Map<String, ?>> a = new a.c<>("io.grpc.LoadBalancer.loadBalancingConfig");

    /* loaded from: classes.dex */
    public static final class b {
        public final List<v> a;
        public final a b;
        public final Object[][] c;

        /* loaded from: classes.dex */
        public static final class a {
            public List<v> a;
            public a b = a.b;
            public Object[][] c = (Object[][]) Array.newInstance(Object.class, 0, 2);
        }

        public b(List list, a aVar, Object[][] objArr, a aVar2) {
            f.b.a.c.b.o.b.A(list, "addresses are not set");
            this.a = list;
            f.b.a.c.b.o.b.A(aVar, "attrs");
            this.b = aVar;
            f.b.a.c.b.o.b.A(objArr, "customOptions");
            this.c = objArr;
        }

        public String toString() {
            k u1 = f.b.a.c.b.o.b.u1(this);
            u1.d("addrs", this.a);
            u1.d("attrs", this.b);
            u1.d("customOptions", Arrays.deepToString(this.c));
            return u1.toString();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract h0 a(d dVar);
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: e */
        public static final e f4110e = new e(null, null, c1.f4087f, false);
        public final h a;
        public final j.a b;
        public final c1 c;

        /* renamed from: d */
        public final boolean f4111d;

        public e(h hVar, j.a aVar, c1 c1Var, boolean z) {
            this.a = hVar;
            this.b = aVar;
            f.b.a.c.b.o.b.A(c1Var, "status");
            this.c = c1Var;
            this.f4111d = z;
        }

        public static e a(c1 c1Var) {
            f.b.a.c.b.o.b.p(!c1Var.e(), "error status shouldn't be OK");
            return new e(null, null, c1Var, false);
        }

        public static e b(h hVar) {
            f.b.a.c.b.o.b.A(hVar, "subchannel");
            return new e(hVar, null, c1.f4087f, false);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return f.b.a.c.b.o.b.n0(this.a, eVar.a) && f.b.a.c.b.o.b.n0(this.c, eVar.c) && f.b.a.c.b.o.b.n0(this.b, eVar.b) && this.f4111d == eVar.f4111d;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.c, this.b, Boolean.valueOf(this.f4111d)});
        }

        public String toString() {
            k u1 = f.b.a.c.b.o.b.u1(this);
            u1.d("subchannel", this.a);
            u1.d("streamTracerFactory", this.b);
            u1.d("status", this.c);
            u1.c("drop", this.f4111d);
            return u1.toString();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
    }

    /* loaded from: classes.dex */
    public static final class g {
        public final List<v> a;
        public final a b;
        public final Object c;

        public g(List list, a aVar, Object obj, a aVar2) {
            f.b.a.c.b.o.b.A(list, "addresses");
            this.a = Collections.unmodifiableList(new ArrayList(list));
            f.b.a.c.b.o.b.A(aVar, "attributes");
            this.b = aVar;
            this.c = obj;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return f.b.a.c.b.o.b.n0(this.a, gVar.a) && f.b.a.c.b.o.b.n0(this.b, gVar.b) && f.b.a.c.b.o.b.n0(this.c, gVar.c);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
        }

        public String toString() {
            k u1 = f.b.a.c.b.o.b.u1(this);
            u1.d("addresses", this.a);
            u1.d("attributes", this.b);
            u1.d("loadBalancingPolicyConfig", this.c);
            return u1.toString();
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static abstract class i {
        public abstract e a(f fVar);
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(o oVar);
    }

    public abstract void a(c1 c1Var);

    public abstract void b(g gVar);

    public void c() {
    }

    public abstract void d();
}
