package h.a.j1;

import f.b.b.a.s;
import h.a.a0;
import h.a.g;
import h.a.j1.b;
import h.a.j1.c3;
import h.a.j1.h0;
import h.a.k0;
import h.a.l0;
import h.a.m;
import h.a.q0;
import h.a.s0;
import h.a.t;
import h.a.t0;
import h.a.u0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class b<T extends b<T>> extends l0<T> {
    public static final d2<? extends Executor> A = new v2(q0.m);
    public static final t B = t.f3986d;
    public static final m C = m.b;
    public static final Logger x = Logger.getLogger(b.class.getName());
    public static final long y = TimeUnit.MINUTES.toMillis(30);
    public static final long z = TimeUnit.SECONDS.toMillis(1);
    public d2<? extends Executor> a;
    public d2<? extends Executor> b;
    public final List<g> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final u0 f3568d;

    /* renamed from: e  reason: collision with root package name */
    public q0.c f3569e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3570f;

    /* renamed from: g  reason: collision with root package name */
    public String f3571g;

    /* renamed from: h  reason: collision with root package name */
    public t f3572h;

    /* renamed from: i  reason: collision with root package name */
    public m f3573i;

    /* renamed from: j  reason: collision with root package name */
    public long f3574j;

    /* renamed from: k  reason: collision with root package name */
    public int f3575k;

    /* renamed from: l  reason: collision with root package name */
    public int f3576l;
    public long m;
    public long n;
    public boolean o;
    public a0 p;
    public boolean q;
    public c3.b r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;

    public b(String str) {
        u0 u0Var;
        d2<? extends Executor> d2Var = A;
        this.a = d2Var;
        this.b = d2Var;
        Logger logger = u0.f3987d;
        synchronized (u0.class) {
            if (u0.f3988e == null) {
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(Class.forName("h.a.j1.g0"));
                } catch (ClassNotFoundException e2) {
                    u0.f3987d.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e2);
                }
                List<s0> q1 = f.b.a.c.b.o.b.q1(s0.class, Collections.unmodifiableList(arrayList), s0.class.getClassLoader(), new u0.b(null));
                if (q1.isEmpty()) {
                    u0.f3987d.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                u0.f3988e = new u0();
                for (s0 s0Var : q1) {
                    Logger logger2 = u0.f3987d;
                    logger2.fine("Service loader found " + s0Var);
                    if (s0Var.c()) {
                        u0 u0Var2 = u0.f3988e;
                        synchronized (u0Var2) {
                            f.b.a.c.b.o.b.o(s0Var.c(), "isAvailable() returned false");
                            u0Var2.b.add(s0Var);
                        }
                    }
                }
                u0 u0Var3 = u0.f3988e;
                synchronized (u0Var3) {
                    ArrayList arrayList2 = new ArrayList(u0Var3.b);
                    Collections.sort(arrayList2, Collections.reverseOrder(new t0(u0Var3)));
                    u0Var3.c = Collections.unmodifiableList(arrayList2);
                }
            }
            u0Var = u0.f3988e;
        }
        this.f3568d = u0Var;
        this.f3569e = u0Var.a;
        this.f3571g = "pick_first";
        this.f3572h = B;
        this.f3573i = C;
        this.f3574j = y;
        this.f3575k = 5;
        this.f3576l = 5;
        this.m = 16777216;
        this.n = 1048576;
        this.p = a0.f3501e;
        this.q = true;
        c3.b bVar = c3.f3583h;
        this.r = c3.f3583h;
        this.s = 4194304;
        this.t = true;
        this.u = true;
        this.v = true;
        this.w = true;
        f.b.a.c.b.o.b.A(str, "target");
        this.f3570f = str;
    }

    @Override // h.a.l0
    public k0 a() {
        g gVar;
        x d2 = d();
        h0.a aVar = new h0.a();
        v2 v2Var = new v2(q0.m);
        f.b.b.a.t<s> tVar = q0.o;
        ArrayList arrayList = new ArrayList(this.c);
        this.o = false;
        g gVar2 = null;
        if (this.t) {
            this.o = true;
            try {
                Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
                Class<?> cls2 = Boolean.TYPE;
                gVar = (g) cls.getDeclaredMethod("getClientInterceptor", cls2, cls2, cls2).invoke(null, Boolean.valueOf(this.u), Boolean.valueOf(this.v), Boolean.FALSE);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                x.log(Level.FINE, "Unable to apply census stats", e2);
                gVar = null;
            }
            if (gVar != null) {
                arrayList.add(0, gVar);
            }
        }
        if (this.w) {
            this.o = true;
            try {
                gVar2 = (g) Class.forName("io.grpc.census.InternalCensusTracingAccessor").getDeclaredMethod("getClientInterceptor", new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
                x.log(Level.FINE, "Unable to apply census stats", e3);
            }
            if (gVar2 != null) {
                arrayList.add(0, gVar2);
            }
        }
        return new w1(new m1(this, d2, aVar, v2Var, tVar, arrayList, z2.a));
    }

    public abstract x d();

    public int e() {
        return 443;
    }
}
