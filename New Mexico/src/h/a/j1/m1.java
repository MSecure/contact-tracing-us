package h.a.j1;

import h.a.a;
import h.a.a0;
import h.a.b0;
import h.a.c0;
import h.a.c1;
import h.a.d0;
import h.a.e;
import h.a.g1;
import h.a.h0;
import h.a.i0;
import h.a.j1.a0;
import h.a.j1.h0;
import h.a.j1.i;
import h.a.j1.j;
import h.a.j1.m;
import h.a.j1.m2;
import h.a.j1.n2;
import h.a.j1.p;
import h.a.j1.y1;
import h.a.j1.z2;
import h.a.k0;
import h.a.o0;
import h.a.q0;
import h.a.y0;
import java.lang.Thread;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class m1 extends k0 implements c0<Object> {
    public static final c1 e0;
    public static final c1 f0;
    public static final c1 g0;
    public boolean A;
    public final d0 D;
    public boolean G;
    public volatile boolean H;
    public volatile boolean I;
    public final m.a K;
    public final m L;
    public final o M;
    public final h.a.e N;
    public final a0 O;
    public boolean R;
    public final boolean S;
    public final long U;
    public final long V;
    public final y1.a W;
    public g1.c Y;
    public j Z;
    public final d0 a;
    public final String b;
    public final m2 b0;
    public final q0.c c;

    /* renamed from: d */
    public final q0.a f4221d;

    /* renamed from: e */
    public final i f4222e;

    /* renamed from: f */
    public final x f4223f;

    /* renamed from: g */
    public final r f4224g;

    /* renamed from: h */
    public final Executor f4225h;

    /* renamed from: i */
    public final d2<? extends Executor> f4226i;

    /* renamed from: j */
    public final d2<? extends Executor> f4227j;

    /* renamed from: k */
    public final k f4228k;

    /* renamed from: l */
    public final k f4229l;
    public final z2 m;
    public final g1 n;
    public final h.a.t o;
    public final h.a.m p;
    public final f.b.b.a.u<f.b.b.a.s> q;
    public final long r;
    public final r2 t;
    public final j.a u;
    public final h.a.d v;
    public q0 w;
    public boolean x;
    public n y;
    public volatile h0.i z;
    public static final Logger c0 = Logger.getLogger(m1.class.getName());
    public static final Pattern d0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");
    public static final t h0 = new t(Collections.emptyMap(), new x1(new HashMap(), new HashMap(), null, null));
    public final a0 s = new a0();
    public final Set<z0> B = new HashSet(16, 0.75f);
    public final Set<e2> C = new HashSet(1, 0.75f);
    public final v E = new v(null);
    public final AtomicBoolean F = new AtomicBoolean(false);
    public final CountDownLatch J = new CountDownLatch(1);
    public q P = q.NO_RESOLUTION;
    public t Q = h0;
    public final n2.q T = new n2.q();
    public final x0<Object> X = new l(null);
    public final p.c a0 = new h(null);

    /* loaded from: classes.dex */
    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
            m1.this = r1;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            Logger logger = m1.c0;
            Level level = Level.SEVERE;
            StringBuilder h2 = f.a.a.a.a.h("[");
            h2.append(m1.this.a);
            h2.append("] Uncaught exception in the SynchronizationContext. Panic!");
            logger.log(level, h2.toString(), th);
            m1 m1Var = m1.this;
            if (!m1Var.A) {
                m1Var.A = true;
                m1Var.r(true);
                m1Var.w(false);
                o1 o1Var = new o1(m1Var, th);
                m1Var.z = o1Var;
                m1Var.D.i(o1Var);
                m1Var.N.a(e.a.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
                m1Var.s.a(h.a.n.TRANSIENT_FAILURE);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class b implements m.a {
        public final /* synthetic */ z2 a;

        public b(m1 m1Var, z2 z2Var) {
            this.a = z2Var;
        }

        @Override // h.a.j1.m.a
        public m a() {
            return new m(this.a);
        }
    }

    /* loaded from: classes.dex */
    public final class c implements Runnable {
        public final /* synthetic */ Runnable b;
        public final /* synthetic */ h.a.n c;

        public c(Runnable runnable, h.a.n nVar) {
            m1.this = r1;
            this.b = runnable;
            this.c = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            m1 m1Var = m1.this;
            a0 a0Var = m1Var.s;
            Runnable runnable = this.b;
            Executor executor = m1Var.f4225h;
            h.a.n nVar = this.c;
            Objects.requireNonNull(a0Var);
            f.b.a.c.b.o.b.A(runnable, "callback");
            f.b.a.c.b.o.b.A(executor, "executor");
            f.b.a.c.b.o.b.A(nVar, "source");
            a0.a aVar = new a0.a(runnable, executor);
            if (a0Var.b != nVar) {
                aVar.b.execute(aVar.a);
            } else {
                a0Var.a.add(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class d implements Runnable {
        public d() {
            m1.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!m1.this.F.get()) {
                m1 m1Var = m1.this;
                if (m1Var.y != null) {
                    m1Var.r(false);
                    m1.q(m1.this);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public final class e implements Runnable {
        public e() {
            m1.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            m1.this.s();
            if (m1.this.z != null) {
                Objects.requireNonNull(m1.this.z);
            }
            n nVar = m1.this.y;
            if (nVar != null) {
                nVar.a.b.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class f implements Runnable {
        public f() {
            m1.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!m1.this.F.get()) {
                m1 m1Var = m1.this;
                g1.c cVar = m1Var.Y;
                if (cVar != null) {
                    g1.b bVar = cVar.a;
                    if (!bVar.f4109d && !bVar.c) {
                        f.b.a.c.b.o.b.G(m1Var.x, "name resolver must be started");
                        m1.this.u();
                    }
                }
                for (z0 z0Var : m1.this.B) {
                    g1 g1Var = z0Var.f4361k;
                    b1 b1Var = new b1(z0Var);
                    Queue<Runnable> queue = g1Var.c;
                    f.b.a.c.b.o.b.A(b1Var, "runnable is null");
                    queue.add(b1Var);
                    g1Var.a();
                }
                Iterator<e2> it = m1.this.C.iterator();
                if (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                    throw null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Executor {
        public g() {
            m1.this = r1;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Executor executor;
            k kVar = m1.this.f4229l;
            synchronized (kVar) {
                if (kVar.b == null) {
                    Object a = kVar.a.a();
                    f.b.a.c.b.o.b.B(a, "%s.getObject()", kVar.b);
                    kVar.b = (Executor) a;
                }
                executor = kVar.b;
            }
            executor.execute(runnable);
        }
    }

    /* loaded from: classes.dex */
    public final class h implements p.c {

        /* loaded from: classes.dex */
        public final class a implements Runnable {
            public a() {
                h.this = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                m1.this.s();
            }
        }

        public h(a aVar) {
            m1.this = r1;
        }

        public w a(h0.f fVar) {
            h0.i iVar = m1.this.z;
            if (!m1.this.F.get()) {
                if (iVar == null) {
                    g1 g1Var = m1.this.n;
                    a aVar = new a();
                    Queue<Runnable> queue = g1Var.c;
                    f.b.a.c.b.o.b.A(aVar, "runnable is null");
                    queue.add(aVar);
                    g1Var.a();
                } else {
                    w e2 = q0.e(iVar.a(fVar), ((h2) fVar).a.b());
                    if (e2 != null) {
                        return e2;
                    }
                }
            }
            return m1.this.D;
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public i() {
            m1.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            m1 m1Var = m1.this;
            m1Var.Y = null;
            m1Var.n.d();
            if (m1Var.x) {
                m1Var.w.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class j implements y1.a {
        public j(a aVar) {
            m1.this = r1;
        }

        @Override // h.a.j1.y1.a
        public void a() {
            f.b.a.c.b.o.b.G(m1.this.F.get(), "Channel must have been shut down");
            m1.this.H = true;
            m1.this.w(false);
            m1.n(m1.this);
            m1.p(m1.this);
        }

        @Override // h.a.j1.y1.a
        public void b() {
        }

        @Override // h.a.j1.y1.a
        public void c(boolean z) {
            m1 m1Var = m1.this;
            m1Var.X.c(m1Var.D, z);
        }

        @Override // h.a.j1.y1.a
        public void d(c1 c1Var) {
            f.b.a.c.b.o.b.G(m1.this.F.get(), "Channel must have been shut down");
        }
    }

    /* loaded from: classes.dex */
    public static final class k {
        public final d2<? extends Executor> a;
        public Executor b;

        public k(d2<? extends Executor> d2Var) {
            f.b.a.c.b.o.b.A(d2Var, "executorPool");
            this.a = d2Var;
        }

        public synchronized void a() {
            Executor executor = this.b;
            if (executor != null) {
                this.b = (Executor) this.a.b(executor);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class l extends x0<Object> {
        public l(a aVar) {
            m1.this = r1;
        }

        @Override // h.a.j1.x0
        public void a() {
            m1.this.s();
        }

        @Override // h.a.j1.x0
        public void b() {
            if (!m1.this.F.get()) {
                m1.this.v();
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public m(a aVar) {
            m1.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            m1.q(m1.this);
        }
    }

    /* loaded from: classes.dex */
    public class n extends h0.d {
        public i.b a;

        /* loaded from: classes.dex */
        public final class a implements Runnable {
            public final /* synthetic */ h0.i b;
            public final /* synthetic */ h.a.n c;

            public a(h0.i iVar, h.a.n nVar) {
                n.this = r1;
                this.b = iVar;
                this.c = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                n nVar = n.this;
                m1 m1Var = m1.this;
                if (nVar == m1Var.y) {
                    h0.i iVar = this.b;
                    m1Var.z = iVar;
                    m1Var.D.i(iVar);
                    h.a.n nVar2 = this.c;
                    if (nVar2 != h.a.n.SHUTDOWN) {
                        m1.this.N.b(e.a.INFO, "Entering {0} state with picker: {1}", nVar2, this.b);
                        m1.this.s.a(this.c);
                    }
                }
            }
        }

        public n(a aVar) {
            m1.this = r1;
        }

        @Override // h.a.h0.d
        public h0.h a(h0.b bVar) {
            m1.this.n.d();
            f.b.a.c.b.o.b.G(!m1.this.I, "Channel is terminated");
            return new u(bVar, this);
        }

        @Override // h.a.h0.d
        public h.a.e b() {
            return m1.this.N;
        }

        @Override // h.a.h0.d
        public g1 c() {
            return m1.this.n;
        }

        @Override // h.a.h0.d
        public void d(h.a.n nVar, h0.i iVar) {
            f.b.a.c.b.o.b.A(nVar, "newState");
            f.b.a.c.b.o.b.A(iVar, "newPicker");
            m1.o(m1.this, "updateBalancingState()");
            g1 g1Var = m1.this.n;
            a aVar = new a(iVar, nVar);
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(aVar, "runnable is null");
            queue.add(aVar);
            g1Var.a();
        }
    }

    /* loaded from: classes.dex */
    public final class o extends q0.e {
        public final n a;
        public final q0 b;

        /* loaded from: classes.dex */
        public final class a implements Runnable {
            public final /* synthetic */ c1 b;

            public a(c1 c1Var) {
                o.this = r1;
                this.b = c1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.c(o.this, this.b);
            }
        }

        /* loaded from: classes.dex */
        public final class b implements Runnable {
            public final /* synthetic */ q0.f b;

            public b(q0.f fVar) {
                o.this = r1;
                this.b = fVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:70:0x0262  */
            /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /* Code decompiled incorrectly, please refer to instructions dump */
            public void run() {
                t tVar;
                c1 c1Var;
                t tVar2;
                c1 c1Var2;
                q qVar = q.SUCCESS;
                e.a aVar = e.a.DEBUG;
                e.a aVar2 = e.a.INFO;
                q0.f fVar = this.b;
                List<h.a.v> list = fVar.a;
                h.a.a aVar3 = fVar.b;
                m1.this.N.b(aVar, "Resolved address: {0}, config={1}", list, aVar3);
                m1 m1Var = m1.this;
                q qVar2 = m1Var.P;
                if (qVar2 != qVar) {
                    m1Var.N.b(aVar2, "Address resolved: {0}", list);
                    m1.this.P = qVar;
                }
                m1.this.Z = null;
                q0.f fVar2 = this.b;
                q0.b bVar = fVar2.c;
                if (bVar != null) {
                    Map map = (Map) fVar2.b.a.get(p0.a);
                    Object obj = bVar.b;
                    if (obj == null) {
                        tVar = null;
                    } else {
                        tVar = new t(map, (x1) obj);
                    }
                    c1Var = bVar.a;
                } else {
                    c1Var = null;
                    tVar = null;
                }
                m1 m1Var2 = m1.this;
                if (!m1Var2.S) {
                    if (tVar != null) {
                        m1Var2.N.a(aVar2, "Service config from name resolver discarded by channel settings");
                    }
                    Objects.requireNonNull(m1.this);
                    tVar2 = m1.h0;
                    a.b b = aVar3.b();
                    a.c<Map<String, ?>> cVar = p0.a;
                    if (b.a.a.containsKey(cVar)) {
                        IdentityHashMap identityHashMap = new IdentityHashMap(b.a.a);
                        identityHashMap.remove(cVar);
                        b.a = new h.a.a(identityHashMap, null);
                    }
                    Map<a.c<?>, Object> map2 = b.b;
                    if (map2 != null) {
                        map2.remove(cVar);
                    }
                    aVar3 = b.a();
                } else {
                    if (tVar != null) {
                        tVar2 = tVar;
                    } else if (c1Var == null) {
                        tVar2 = m1.h0;
                    } else if (!m1Var2.R) {
                        m1Var2.N.a(aVar2, "Fallback to error due to invalid first service config without default config");
                        o.this.a(bVar.a);
                        return;
                    } else {
                        tVar2 = m1Var2.Q;
                    }
                    if (!tVar2.equals(m1Var2.Q)) {
                        h.a.e eVar = m1.this.N;
                        Object[] objArr = new Object[1];
                        objArr[0] = tVar2 == m1.h0 ? " to empty" : "";
                        eVar.b(aVar2, "Service config changed{0}", objArr);
                        m1.this.Q = tVar2;
                    }
                    try {
                        m1 m1Var3 = m1.this;
                        m1Var3.R = true;
                        r2 r2Var = m1Var3.t;
                        r2Var.a.set(m1Var3.Q.b);
                        r2Var.c = true;
                    } catch (RuntimeException e2) {
                        Logger logger = m1.c0;
                        Level level = Level.WARNING;
                        StringBuilder h2 = f.a.a.a.a.h("[");
                        h2.append(m1.this.a);
                        h2.append("] Unexpected exception from parsing service config");
                        logger.log(level, h2.toString(), (Throwable) e2);
                    }
                }
                o oVar = o.this;
                if (oVar.a == m1.this.y) {
                    if (tVar2 != tVar) {
                        a.b b2 = aVar3.b();
                        b2.b(p0.a, tVar2.a);
                        aVar3 = b2.a();
                    }
                    i.b bVar2 = o.this.a.a;
                    h.a.a aVar4 = h.a.a.b;
                    Object obj2 = tVar2.b.f4348d;
                    f.b.a.c.b.o.b.A(list, "addresses");
                    List unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
                    f.b.a.c.b.o.b.A(aVar3, "attributes");
                    Objects.requireNonNull(bVar2);
                    a.c<Map<String, ?>> cVar2 = h0.a;
                    if (aVar3.a.get(cVar2) == null) {
                        i.g gVar = (i.g) obj2;
                        if (gVar == null) {
                            try {
                                i iVar = i.this;
                                gVar = new i.g(i.a(iVar, iVar.b, "using default policy"), null, null);
                            } catch (i.f e3) {
                                bVar2.a.d(h.a.n.TRANSIENT_FAILURE, new i.d(c1.m.g(e3.getMessage())));
                                bVar2.b.d();
                                bVar2.c = null;
                                bVar2.b = new i.e(null);
                            }
                        }
                        if (bVar2.c == null || !gVar.a.b().equals(bVar2.c.b())) {
                            bVar2.a.d(h.a.n.CONNECTING, new i.c(null));
                            bVar2.b.d();
                            i0 i0Var = gVar.a;
                            bVar2.c = i0Var;
                            h0 h0Var = bVar2.b;
                            bVar2.b = i0Var.a(bVar2.a);
                            bVar2.a.b().b(aVar2, "Load balancer changed from {0} to {1}", h0Var.getClass().getSimpleName(), bVar2.b.getClass().getSimpleName());
                        }
                        Object obj3 = gVar.c;
                        if (obj3 != null) {
                            bVar2.a.b().b(aVar, "Load-balancing config: {0}", gVar.c);
                            a.b b3 = aVar3.b();
                            b3.b(cVar2, gVar.b);
                            aVar3 = b3.a();
                        }
                        h0 h0Var2 = bVar2.b;
                        if (unmodifiableList.isEmpty()) {
                            Objects.requireNonNull(h0Var2);
                            c1Var2 = c1.n.g("NameResolver returned no usable address. addrs=" + unmodifiableList + ", attrs=" + aVar3);
                            if (!c1Var2.e()) {
                                return;
                            }
                            if (!list.isEmpty() || qVar2 != qVar) {
                                o.c(o.this, c1Var2.a(o.this.b + " was used"));
                                return;
                            }
                            o.this.d();
                            return;
                        }
                        h0Var2.b(new h0.g(unmodifiableList, aVar3, obj3, null));
                        c1Var2 = c1.f4087f;
                        if (!c1Var2.e()) {
                        }
                    } else {
                        StringBuilder h3 = f.a.a.a.a.h("Unexpected ATTR_LOAD_BALANCING_CONFIG from upstream: ");
                        h3.append(aVar3.a.get(cVar2));
                        throw new IllegalArgumentException(h3.toString());
                    }
                }
            }
        }

        public o(n nVar, q0 q0Var) {
            m1.this = r1;
            f.b.a.c.b.o.b.A(nVar, "helperImpl");
            this.a = nVar;
            f.b.a.c.b.o.b.A(q0Var, "resolver");
            this.b = q0Var;
        }

        public static void c(o oVar, c1 c1Var) {
            Objects.requireNonNull(oVar);
            m1.c0.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{m1.this.a, c1Var});
            m1 m1Var = m1.this;
            q qVar = m1Var.P;
            q qVar2 = q.ERROR;
            if (qVar != qVar2) {
                m1Var.N.b(e.a.WARNING, "Failed to resolve name: {0}", c1Var);
                m1.this.P = qVar2;
            }
            n nVar = oVar.a;
            if (nVar == m1.this.y) {
                nVar.a.b.a(c1Var);
                oVar.d();
            }
        }

        @Override // h.a.q0.e
        public void a(c1 c1Var) {
            f.b.a.c.b.o.b.p(!c1Var.e(), "the error status must not be OK");
            g1 g1Var = m1.this.n;
            a aVar = new a(c1Var);
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(aVar, "runnable is null");
            queue.add(aVar);
            g1Var.a();
        }

        @Override // h.a.q0.e
        public void b(q0.f fVar) {
            g1 g1Var = m1.this.n;
            b bVar = new b(fVar);
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(bVar, "runnable is null");
            queue.add(bVar);
            g1Var.a();
        }

        public final void d() {
            m1 m1Var = m1.this;
            g1.c cVar = m1Var.Y;
            if (cVar != null) {
                g1.b bVar = cVar.a;
                if (!bVar.f4109d && !bVar.c) {
                    return;
                }
            }
            if (m1Var.Z == null) {
                Objects.requireNonNull((h0.a) m1Var.u);
                m1Var.Z = new h0();
            }
            long a2 = ((h0) m1.this.Z).a();
            m1.this.N.b(e.a.DEBUG, "Scheduling DNS resolution backoff for {0} ns", Long.valueOf(a2));
            m1 m1Var2 = m1.this;
            m1Var2.Y = m1Var2.n.c(new i(), a2, TimeUnit.NANOSECONDS, m1Var2.f4223f.p());
        }
    }

    /* loaded from: classes.dex */
    public class p extends h.a.d {
        public final String a;

        public p(String str, a aVar) {
            m1.this = r1;
            f.b.a.c.b.o.b.A(str, "authority");
            this.a = str;
        }

        @Override // h.a.d
        public String b() {
            return this.a;
        }

        @Override // h.a.d
        public <ReqT, RespT> h.a.f<ReqT, RespT> h(o0<ReqT, RespT> o0Var, h.a.c cVar) {
            ScheduledExecutorService scheduledExecutorService;
            m1 m1Var = m1.this;
            Objects.requireNonNull(m1Var);
            Executor executor = cVar.b;
            Executor executor2 = executor == null ? m1Var.f4225h : executor;
            m1 m1Var2 = m1.this;
            p.c cVar2 = m1Var2.a0;
            if (m1Var2.I) {
                scheduledExecutorService = null;
            } else {
                scheduledExecutorService = m1.this.f4223f.p();
            }
            p pVar = new p(o0Var, executor2, cVar, cVar2, scheduledExecutorService, m1.this.L, false);
            Objects.requireNonNull(m1.this);
            pVar.o = false;
            m1 m1Var3 = m1.this;
            pVar.p = m1Var3.o;
            pVar.q = m1Var3.p;
            return pVar;
        }
    }

    /* loaded from: classes.dex */
    public enum q {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    /* loaded from: classes.dex */
    public static final class r implements ScheduledExecutorService {
        public final ScheduledExecutorService b;

        public r(ScheduledExecutorService scheduledExecutorService, a aVar) {
            f.b.a.c.b.o.b.A(scheduledExecutorService, "delegate");
            this.b = scheduledExecutorService;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j2, TimeUnit timeUnit) {
            return this.b.awaitTermination(j2, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.b.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
            return this.b.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) {
            return this.b.invokeAll(collection, j2, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
            return (T) this.b.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) {
            return (T) this.b.invokeAny(collection, j2, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.b.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.b.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
            return this.b.schedule(runnable, j2, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j2, TimeUnit timeUnit) {
            return this.b.schedule(callable, j2, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            return this.b.scheduleAtFixedRate(runnable, j2, j3, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            return this.b.scheduleWithFixedDelay(runnable, j2, j3, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.b.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.b.submit(runnable, t);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.b.submit(callable);
        }
    }

    /* loaded from: classes.dex */
    public static final class s extends q0.g {
        public final int a;
        public final int b;
        public final i c;

        /* renamed from: d */
        public final h.a.e f4234d;

        public s(boolean z, int i2, int i3, i iVar, h.a.e eVar) {
            this.a = i2;
            this.b = i3;
            f.b.a.c.b.o.b.A(iVar, "autoLoadBalancerFactory");
            this.c = iVar;
            f.b.a.c.b.o.b.A(eVar, "channelLogger");
            this.f4234d = eVar;
        }

        @Override // h.a.q0.g
        public q0.b a(Map<String, ?> map) {
            Object obj;
            try {
                q0.b b = this.c.b(map, this.f4234d);
                if (b == null) {
                    obj = null;
                } else {
                    c1 c1Var = b.a;
                    if (c1Var != null) {
                        return new q0.b(c1Var);
                    }
                    obj = b.b;
                }
                return new q0.b(x1.a(map, false, this.a, this.b, obj));
            } catch (RuntimeException e2) {
                return new q0.b(c1.f4089h.g("failed to parse service config").f(e2));
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class t {
        public Map<String, ?> a;
        public x1 b;

        public t(Map<String, ?> map, x1 x1Var) {
            f.b.a.c.b.o.b.A(map, "rawServiceConfig");
            this.a = map;
            f.b.a.c.b.o.b.A(x1Var, "managedChannelServiceConfig");
            this.b = x1Var;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || t.class != obj.getClass()) {
                return false;
            }
            t tVar = (t) obj;
            return f.b.a.c.b.o.b.n0(this.a, tVar.a) && f.b.a.c.b.o.b.n0(this.b, tVar.b);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b});
        }

        public String toString() {
            f.b.b.a.k u1 = f.b.a.c.b.o.b.u1(this);
            u1.d("rawServiceConfig", this.a);
            u1.d("managedChannelServiceConfig", this.b);
            return u1.toString();
        }
    }

    /* loaded from: classes.dex */
    public final class u extends e {
        public final h0.b a;
        public final d0 b;
        public final n c;

        /* renamed from: d */
        public final o f4235d;

        /* renamed from: e */
        public z0 f4236e;

        /* renamed from: f */
        public boolean f4237f;

        /* renamed from: g */
        public boolean f4238g;

        /* renamed from: h */
        public g1.c f4239h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
                u.this = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                g1.c cVar;
                u uVar = u.this;
                m1.this.n.d();
                if (uVar.f4236e == null) {
                    uVar.f4238g = true;
                    return;
                }
                if (!uVar.f4238g) {
                    uVar.f4238g = true;
                } else if (m1.this.H && (cVar = uVar.f4239h) != null) {
                    cVar.a();
                    uVar.f4239h = null;
                } else {
                    return;
                }
                if (!m1.this.H) {
                    uVar.f4239h = m1.this.n.c(new k1(new u1(uVar)), 5, TimeUnit.SECONDS, m1.this.f4223f.p());
                } else {
                    uVar.f4236e.d(m1.f0);
                }
            }
        }

        public u(h0.b bVar, n nVar) {
            m1.this = r8;
            f.b.a.c.b.o.b.A(bVar, "args");
            this.a = bVar;
            f.b.a.c.b.o.b.A(nVar, "helper");
            d0 b = d0.b("Subchannel", r8.b());
            this.b = b;
            long a2 = r8.m.a();
            StringBuilder h2 = f.a.a.a.a.h("Subchannel for ");
            h2.append(bVar.a);
            o oVar = new o(b, 0, a2, h2.toString());
            this.f4235d = oVar;
            this.c = new n(oVar, r8.m);
        }

        @Override // h.a.h0.h
        public List<h.a.v> a() {
            m1.o(m1.this, "Subchannel.getAllAddresses()");
            f.b.a.c.b.o.b.G(this.f4237f, "not started");
            return this.f4236e.m;
        }

        @Override // h.a.h0.h
        public h.a.a b() {
            return this.a.b;
        }

        @Override // h.a.h0.h
        public Object c() {
            f.b.a.c.b.o.b.G(this.f4237f, "Subchannel is not started");
            return this.f4236e;
        }

        @Override // h.a.h0.h
        public void d() {
            m1.o(m1.this, "Subchannel.requestConnection()");
            f.b.a.c.b.o.b.G(this.f4237f, "not started");
            this.f4236e.b();
        }

        @Override // h.a.h0.h
        public void e() {
            m1.o(m1.this, "Subchannel.shutdown()");
            g1 g1Var = m1.this.n;
            a aVar = new a();
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(aVar, "runnable is null");
            queue.add(aVar);
            g1Var.a();
        }

        @Override // h.a.h0.h
        public void f(h0.j jVar) {
            m1.this.n.d();
            f.b.a.c.b.o.b.G(!this.f4237f, "already started");
            f.b.a.c.b.o.b.G(!this.f4238g, "already shutdown");
            this.f4237f = true;
            if (m1.this.H) {
                g1 g1Var = m1.this.n;
                s1 s1Var = new s1(this, jVar);
                Queue<Runnable> queue = g1Var.c;
                f.b.a.c.b.o.b.A(s1Var, "runnable is null");
                queue.add(s1Var);
                g1Var.a();
                return;
            }
            List<h.a.v> list = this.a.a;
            String b = m1.this.b();
            m1 m1Var = m1.this;
            Objects.requireNonNull(m1Var);
            j.a aVar = m1Var.u;
            x xVar = m1Var.f4223f;
            ScheduledExecutorService p = xVar.p();
            m1 m1Var2 = m1.this;
            z0 z0Var = new z0(list, b, null, aVar, xVar, p, m1Var2.q, m1Var2.n, new t1(this, jVar), m1Var2.O, m1Var2.K.a(), this.f4235d, this.b, this.c);
            m1 m1Var3 = m1.this;
            o oVar = m1Var3.M;
            b0.a aVar2 = b0.a.CT_INFO;
            Long valueOf = Long.valueOf(m1Var3.m.a());
            f.b.a.c.b.o.b.A("Child Subchannel started", "description");
            f.b.a.c.b.o.b.A(aVar2, "severity");
            f.b.a.c.b.o.b.A(valueOf, "timestampNanos");
            f.b.a.c.b.o.b.G(true, "at least one of channelRef and subchannelRef must be null");
            oVar.b(new b0("Child Subchannel started", aVar2, valueOf.longValue(), null, z0Var, null));
            this.f4236e = z0Var;
            g1 g1Var2 = m1.this.n;
            v1 v1Var = new v1(this, z0Var);
            Queue<Runnable> queue2 = g1Var2.c;
            f.b.a.c.b.o.b.A(v1Var, "runnable is null");
            queue2.add(v1Var);
            g1Var2.a();
        }

        @Override // h.a.h0.h
        public void g(List<h.a.v> list) {
            m1.this.n.d();
            z0 z0Var = this.f4236e;
            Objects.requireNonNull(z0Var);
            f.b.a.c.b.o.b.A(list, "newAddressGroups");
            for (h.a.v vVar : list) {
                f.b.a.c.b.o.b.A(vVar, "newAddressGroups contains null entry");
            }
            f.b.a.c.b.o.b.p(!list.isEmpty(), "newAddressGroups is empty");
            g1 g1Var = z0Var.f4361k;
            c1 c1Var = new c1(z0Var, list);
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(c1Var, "runnable is null");
            queue.add(c1Var);
            g1Var.a();
        }

        public String toString() {
            return this.b.toString();
        }
    }

    /* loaded from: classes.dex */
    public final class v {
        public final Object a = new Object();
        public Collection<u> b = new HashSet();
        public c1 c;

        public v(a aVar) {
            m1.this = r1;
        }

        public void a(c1 c1Var) {
            synchronized (this.a) {
                if (this.c == null) {
                    this.c = c1Var;
                    boolean isEmpty = this.b.isEmpty();
                    if (isEmpty) {
                        m1.this.D.d(c1Var);
                    }
                }
            }
        }
    }

    static {
        c1 c1Var = c1.n;
        e0 = c1Var.g("Channel shutdownNow invoked");
        f0 = c1Var.g("Channel shutdown invoked");
        g0 = c1Var.g("Subchannel shutdown invoked");
    }

    public m1(b<?> bVar, x xVar, j.a aVar, d2<? extends Executor> d2Var, f.b.b.a.u<f.b.b.a.s> uVar, List<h.a.g> list, z2 z2Var) {
        g1 g1Var = new g1(new a());
        this.n = g1Var;
        this.R = false;
        j jVar = new j(null);
        this.W = jVar;
        String str = bVar.f4140f;
        f.b.a.c.b.o.b.A(str, "target");
        this.b = str;
        d0 b2 = d0.b("Channel", str);
        this.a = b2;
        f.b.a.c.b.o.b.A(z2Var, "timeProvider");
        this.m = z2Var;
        d2<? extends Executor> d2Var2 = bVar.a;
        f.b.a.c.b.o.b.A(d2Var2, "executorPool");
        this.f4226i = d2Var2;
        Object a2 = d2Var2.a();
        f.b.a.c.b.o.b.A(a2, "executor");
        Executor executor = (Executor) a2;
        this.f4225h = executor;
        l lVar = new l(xVar, executor);
        this.f4223f = lVar;
        r rVar = new r(lVar.p(), null);
        this.f4224g = rVar;
        o oVar = new o(b2, 0, ((z2.a) z2Var).a(), f.a.a.a.a.c("Channel for '", str, "'"));
        this.M = oVar;
        n nVar = new n(oVar, z2Var);
        this.N = nVar;
        q0.c cVar = bVar.f4139e;
        this.c = cVar;
        y0 y0Var = q0.f4294k;
        i iVar = new i(bVar.f4141g);
        this.f4222e = iVar;
        d2<? extends Executor> d2Var3 = bVar.b;
        f.b.a.c.b.o.b.A(d2Var3, "offloadExecutorPool");
        this.f4229l = new k(d2Var3);
        s sVar = new s(false, bVar.f4145k, bVar.f4146l, iVar, nVar);
        Integer valueOf = Integer.valueOf(bVar.e());
        Objects.requireNonNull(y0Var);
        q0.a aVar2 = new q0.a(valueOf, y0Var, g1Var, sVar, rVar, nVar, new g(), null);
        this.f4221d = aVar2;
        this.w = t(str, cVar, aVar2);
        f.b.a.c.b.o.b.A(d2Var, "balancerRpcExecutorPool");
        this.f4227j = d2Var;
        this.f4228k = new k(d2Var);
        d0 d0Var = new d0(executor, g1Var);
        this.D = d0Var;
        d0Var.e(jVar);
        this.u = aVar;
        r2 r2Var = new r2(false);
        this.t = r2Var;
        boolean z = bVar.q;
        this.S = z;
        this.v = h.a.i.a(h.a.i.a(new p(this.w.a(), null), Arrays.asList(r2Var)), list);
        f.b.a.c.b.o.b.A(uVar, "stopwatchSupplier");
        this.q = uVar;
        long j2 = bVar.f4144j;
        if (j2 != -1) {
            f.b.a.c.b.o.b.s(j2 >= b.z, "invalid idleTimeoutMillis %s", j2);
            j2 = bVar.f4144j;
        }
        this.r = j2;
        this.b0 = new m2(new m(null), g1Var, lVar.p(), uVar.get());
        h.a.t tVar = bVar.f4142h;
        f.b.a.c.b.o.b.A(tVar, "decompressorRegistry");
        this.o = tVar;
        h.a.m mVar = bVar.f4143i;
        f.b.a.c.b.o.b.A(mVar, "compressorRegistry");
        this.p = mVar;
        this.V = bVar.m;
        this.U = bVar.n;
        b bVar2 = new b(this, z2Var);
        this.K = bVar2;
        this.L = bVar2.a();
        h.a.a0 a0Var = bVar.p;
        Objects.requireNonNull(a0Var);
        this.O = a0Var;
        h.a.a0.a(a0Var.a, this);
        if (!z) {
            this.R = true;
            r2Var.a.set(this.Q.b);
            r2Var.c = true;
        }
    }

    public static void n(m1 m1Var) {
        if (m1Var.G) {
            for (z0 z0Var : m1Var.B) {
                c1 c1Var = e0;
                z0Var.d(c1Var);
                g1 g1Var = z0Var.f4361k;
                f1 f1Var = new f1(z0Var, c1Var);
                Queue<Runnable> queue = g1Var.c;
                f.b.a.c.b.o.b.A(f1Var, "runnable is null");
                queue.add(f1Var);
                g1Var.a();
            }
            Iterator<e2> it = m1Var.C.iterator();
            if (it.hasNext()) {
                Objects.requireNonNull(it.next());
                throw null;
            }
        }
    }

    public static void o(m1 m1Var, String str) {
        Objects.requireNonNull(m1Var);
        try {
            m1Var.n.d();
        } catch (IllegalStateException e2) {
            Logger logger = c0;
            Level level = Level.WARNING;
            logger.log(level, str + " should be called from SynchronizationContext. This warning will become an exception in a future release. See https://github.com/grpc/grpc-java/issues/5015 for more details", (Throwable) e2);
        }
    }

    public static void p(m1 m1Var) {
        if (!m1Var.I && m1Var.F.get() && m1Var.B.isEmpty() && m1Var.C.isEmpty()) {
            m1Var.N.a(e.a.INFO, "Terminated");
            h.a.a0.b(m1Var.O.a, m1Var);
            m1Var.f4226i.b(m1Var.f4225h);
            m1Var.f4228k.a();
            m1Var.f4229l.a();
            m1Var.f4223f.close();
            m1Var.I = true;
            m1Var.J.countDown();
        }
    }

    public static void q(m1 m1Var) {
        m1Var.w(true);
        m1Var.D.i(null);
        m1Var.N.a(e.a.INFO, "Entering IDLE state");
        m1Var.s.a(h.a.n.IDLE);
        if (true ^ m1Var.X.a.isEmpty()) {
            m1Var.s();
        }
    }

    public static q0 t(String str, q0.c cVar, q0.a aVar) {
        URI uri;
        q0 b2;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e2) {
            sb.append(e2.getMessage());
            uri = null;
        }
        if (uri != null && (b2 = cVar.b(uri, aVar)) != null) {
            return b2;
        }
        String str2 = "";
        if (!d0.matcher(str).matches()) {
            try {
                q0 b3 = cVar.b(new URI(cVar.a(), str2, "/" + str, null), aVar);
                if (b3 != null) {
                    return b3;
                }
            } catch (URISyntaxException e3) {
                throw new IllegalArgumentException(e3);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (sb.length() > 0) {
            str2 = " (" + ((Object) sb) + ")";
        }
        objArr[1] = str2;
        throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", objArr));
    }

    @Override // h.a.d
    public String b() {
        return this.v.b();
    }

    @Override // h.a.c0
    public d0 c() {
        return this.a;
    }

    @Override // h.a.d
    public <ReqT, RespT> h.a.f<ReqT, RespT> h(o0<ReqT, RespT> o0Var, h.a.c cVar) {
        return this.v.h(o0Var, cVar);
    }

    @Override // h.a.k0
    public void i() {
        g1 g1Var = this.n;
        d dVar = new d();
        Queue<Runnable> queue = g1Var.c;
        f.b.a.c.b.o.b.A(dVar, "runnable is null");
        queue.add(dVar);
        g1Var.a();
    }

    @Override // h.a.k0
    public h.a.n j(boolean z) {
        h.a.n nVar = this.s.b;
        if (nVar != null) {
            if (z && nVar == h.a.n.IDLE) {
                g1 g1Var = this.n;
                e eVar = new e();
                Queue<Runnable> queue = g1Var.c;
                f.b.a.c.b.o.b.A(eVar, "runnable is null");
                queue.add(eVar);
                g1Var.a();
            }
            return nVar;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    @Override // h.a.k0
    public void k(h.a.n nVar, Runnable runnable) {
        g1 g1Var = this.n;
        c cVar = new c(runnable, nVar);
        Queue<Runnable> queue = g1Var.c;
        f.b.a.c.b.o.b.A(cVar, "runnable is null");
        queue.add(cVar);
        g1Var.a();
    }

    @Override // h.a.k0
    public void l() {
        g1 g1Var = this.n;
        f fVar = new f();
        Queue<Runnable> queue = g1Var.c;
        f.b.a.c.b.o.b.A(fVar, "runnable is null");
        queue.add(fVar);
        g1Var.a();
    }

    @Override // h.a.k0
    public k0 m() {
        ArrayList arrayList;
        h.a.e eVar = this.N;
        e.a aVar = e.a.DEBUG;
        eVar.a(aVar, "shutdownNow() called");
        this.N.a(aVar, "shutdown() called");
        if (this.F.compareAndSet(false, true)) {
            g1 g1Var = this.n;
            p1 p1Var = new p1(this);
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(p1Var, "runnable is null");
            queue.add(p1Var);
            this.E.a(f0);
            g1 g1Var2 = this.n;
            n1 n1Var = new n1(this);
            Queue<Runnable> queue2 = g1Var2.c;
            f.b.a.c.b.o.b.A(n1Var, "runnable is null");
            queue2.add(n1Var);
            g1Var2.a();
        }
        v vVar = this.E;
        c1 c1Var = e0;
        vVar.a(c1Var);
        synchronized (vVar.a) {
            arrayList = new ArrayList(vVar.b);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((u) it.next()).g(c1Var);
        }
        m1.this.D.a(c1Var);
        g1 g1Var3 = this.n;
        q1 q1Var = new q1(this);
        Queue<Runnable> queue3 = g1Var3.c;
        f.b.a.c.b.o.b.A(q1Var, "runnable is null");
        queue3.add(q1Var);
        g1Var3.a();
        return this;
    }

    public final void r(boolean z) {
        ScheduledFuture<?> scheduledFuture;
        m2 m2Var = this.b0;
        m2Var.f4244f = false;
        if (z && (scheduledFuture = m2Var.f4245g) != null) {
            scheduledFuture.cancel(false);
            m2Var.f4245g = null;
        }
    }

    public void s() {
        this.n.d();
        if (!this.F.get() && !this.A) {
            if (!this.X.a.isEmpty()) {
                r(false);
            } else {
                v();
            }
            if (this.y == null) {
                this.N.a(e.a.INFO, "Exiting idle mode");
                n nVar = new n(null);
                i iVar = this.f4222e;
                Objects.requireNonNull(iVar);
                nVar.a = new i.b(nVar);
                this.y = nVar;
                this.w.d(new o(nVar, this.w));
                this.x = true;
            }
        }
    }

    public String toString() {
        f.b.b.a.k u1 = f.b.a.c.b.o.b.u1(this);
        u1.b("logId", this.a.c);
        u1.d("target", this.b);
        return u1.toString();
    }

    public final void u() {
        this.n.d();
        this.n.d();
        g1.c cVar = this.Y;
        if (cVar != null) {
            cVar.a();
            this.Y = null;
            this.Z = null;
        }
        this.n.d();
        if (this.x) {
            this.w.b();
        }
    }

    public final void v() {
        long j2 = this.r;
        if (j2 != -1) {
            m2 m2Var = this.b0;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Objects.requireNonNull(m2Var);
            long nanos = timeUnit.toNanos(j2);
            f.b.b.a.s sVar = m2Var.f4242d;
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            long a2 = sVar.a(timeUnit2) + nanos;
            m2Var.f4244f = true;
            if (a2 - m2Var.f4243e < 0 || m2Var.f4245g == null) {
                ScheduledFuture<?> scheduledFuture = m2Var.f4245g;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                m2Var.f4245g = m2Var.a.schedule(new m2.c(null), nanos, timeUnit2);
            }
            m2Var.f4243e = a2;
        }
    }

    public final void w(boolean z) {
        this.n.d();
        if (z) {
            f.b.a.c.b.o.b.G(this.x, "nameResolver is not started");
            f.b.a.c.b.o.b.G(this.y != null, "lbHelper is null");
        }
        if (this.w != null) {
            this.n.d();
            g1.c cVar = this.Y;
            if (cVar != null) {
                cVar.a();
                this.Y = null;
                this.Z = null;
            }
            this.w.c();
            this.x = false;
            if (z) {
                this.w = t(this.b, this.c, this.f4221d);
            } else {
                this.w = null;
            }
        }
        n nVar = this.y;
        if (nVar != null) {
            i.b bVar = nVar.a;
            bVar.b.d();
            bVar.b = null;
            this.y = null;
        }
        this.z = null;
    }
}
