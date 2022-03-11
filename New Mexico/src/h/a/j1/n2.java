package h.a.j1;

import h.a.c1;
import h.a.j;
import h.a.j1.o2;
import h.a.j1.s0;
import h.a.j1.v;
import h.a.j1.y2;
import h.a.n0;
import h.a.o0;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public abstract class n2<ReqT> implements u {
    public static final n0.f<String> w;
    public static final n0.f<String> x;
    public static final c1 y = c1.f4088g.g("Stream thrown away because RetriableStream committed");
    public static Random z = new Random();
    public final o0<ReqT, ?> a;
    public final Executor b;
    public final ScheduledExecutorService c;

    /* renamed from: d */
    public final n0 f4246d;

    /* renamed from: e */
    public final o2.a f4247e;

    /* renamed from: f */
    public final s0.a f4248f;

    /* renamed from: g */
    public o2 f4249g;

    /* renamed from: h */
    public s0 f4250h;

    /* renamed from: i */
    public boolean f4251i;

    /* renamed from: k */
    public final q f4253k;

    /* renamed from: l */
    public final long f4254l;
    public final long m;
    public final x n;
    public long r;
    public v s;
    public r t;
    public r u;
    public long v;

    /* renamed from: j */
    public final Object f4252j = new Object();
    public final y0 o = new y0();
    public volatile u p = new u(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);
    public final AtomicBoolean q = new AtomicBoolean();

    /* loaded from: classes.dex */
    public class a extends j.a {
        public final /* synthetic */ h.a.j a;

        public a(n2 n2Var, h.a.j jVar) {
            this.a = jVar;
        }

        @Override // h.a.j.a
        public h.a.j a(j.b bVar, n0 n0Var) {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public class b implements o {
        public final /* synthetic */ String a;

        public b(n2 n2Var, String str) {
            this.a = str;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.j(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ Collection b;
        public final /* synthetic */ w c;

        /* renamed from: d */
        public final /* synthetic */ Future f4255d;

        /* renamed from: e */
        public final /* synthetic */ Future f4256e;

        public c(Collection collection, w wVar, Future future, Future future2) {
            n2.this = r1;
            this.b = collection;
            this.c = wVar;
            this.f4255d = future;
            this.f4256e = future2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (w wVar : this.b) {
                if (wVar != this.c) {
                    wVar.a.g(n2.y);
                }
            }
            Future future = this.f4255d;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f4256e;
            if (future2 != null) {
                future2.cancel(false);
            }
            n2.this.w();
        }
    }

    /* loaded from: classes.dex */
    public class d implements o {
        public final /* synthetic */ h.a.l a;

        public d(n2 n2Var, h.a.l lVar) {
            this.a = lVar;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.b(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class e implements o {
        public final /* synthetic */ h.a.r a;

        public e(n2 n2Var, h.a.r rVar) {
            this.a = rVar;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.e(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class f implements o {
        public final /* synthetic */ h.a.t a;

        public f(n2 n2Var, h.a.t tVar) {
            this.a = tVar;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.f(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class g implements o {
        public g(n2 n2Var) {
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.flush();
        }
    }

    /* loaded from: classes.dex */
    public class h implements o {
        public final /* synthetic */ boolean a;

        public h(n2 n2Var, boolean z) {
            this.a = z;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.n(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class i implements o {
        public i(n2 n2Var) {
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.l();
        }
    }

    /* loaded from: classes.dex */
    public class j implements o {
        public final /* synthetic */ int a;

        public j(n2 n2Var, int i2) {
            this.a = i2;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.d(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class k implements o {
        public final /* synthetic */ int a;

        public k(n2 n2Var, int i2) {
            this.a = i2;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.a(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class l implements o {
        public final /* synthetic */ int a;

        public l(n2 n2Var, int i2) {
            this.a = i2;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.c(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class m implements o {
        public final /* synthetic */ Object a;

        public m(Object obj) {
            n2.this = r1;
            this.a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.h(n2.this.a.b(this.a));
        }
    }

    /* loaded from: classes.dex */
    public class n implements o {
        public n() {
            n2.this = r1;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.i(new v(wVar));
        }
    }

    /* loaded from: classes.dex */
    public interface o {
        void a(w wVar);
    }

    /* loaded from: classes.dex */
    public class p extends h.a.j {
        public final w a;
        public long b;

        public p(w wVar) {
            n2.this = r1;
            this.a = wVar;
        }

        @Override // h.a.f1
        public void a(long j2) {
            if (n2.this.p.f4261f == null) {
                Runnable runnable = null;
                synchronized (n2.this.f4252j) {
                    if (n2.this.p.f4261f == null) {
                        w wVar = this.a;
                        if (!wVar.b) {
                            long j3 = this.b + j2;
                            this.b = j3;
                            n2 n2Var = n2.this;
                            long j4 = n2Var.r;
                            if (j3 > j4) {
                                if (j3 > n2Var.f4254l) {
                                    wVar.c = true;
                                } else {
                                    long addAndGet = n2Var.f4253k.a.addAndGet(j3 - j4);
                                    n2 n2Var2 = n2.this;
                                    n2Var2.r = this.b;
                                    if (addAndGet > n2Var2.m) {
                                        this.a.c = true;
                                    }
                                }
                                w wVar2 = this.a;
                                if (wVar2.c) {
                                    runnable = n2.this.p(wVar2);
                                }
                                if (runnable != null) {
                                    ((c) runnable).run();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class q {
        public final AtomicLong a = new AtomicLong();
    }

    /* loaded from: classes.dex */
    public static final class r {
        public final Object a;
        public Future<?> b;
        public boolean c;

        public r(Object obj) {
            this.a = obj;
        }

        public Future<?> a() {
            this.c = true;
            return this.b;
        }

        public void b(Future<?> future) {
            synchronized (this.a) {
                if (!this.c) {
                    this.b = future;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public final class s implements Runnable {
        public final r b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
                s.this = r1;
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
                if (r4 != false) goto L_0x004b;
             */
            @Override // java.lang.Runnable
            /* Code decompiled incorrectly, please refer to instructions dump */
            public void run() {
                boolean z;
                r rVar;
                n2 n2Var;
                n2 n2Var2 = n2.this;
                w q = n2Var2.q(n2Var2.p.f4260e);
                synchronized (n2.this.f4252j) {
                    s sVar = s.this;
                    z = true;
                    rVar = null;
                    if (!sVar.b.c) {
                        n2 n2Var3 = n2.this;
                        n2Var3.p = n2Var3.p.a(q);
                        n2 n2Var4 = n2.this;
                        if (n2Var4.u(n2Var4.p)) {
                            x xVar = n2.this.n;
                            if (xVar != null) {
                                if (xVar.f4265d.get() <= xVar.b) {
                                    z = false;
                                }
                            }
                            n2Var = n2.this;
                            rVar = new r(n2Var.f4252j);
                            n2Var.u = rVar;
                            z = false;
                        }
                        n2 n2Var5 = n2.this;
                        n2Var5.p = n2Var5.p.b();
                        n2Var = n2.this;
                        n2Var.u = rVar;
                        z = false;
                    }
                }
                if (z) {
                    q.a.g(c1.f4088g.g("Unneeded hedging"));
                    return;
                }
                if (rVar != null) {
                    n2 n2Var6 = n2.this;
                    rVar.b(n2Var6.c.schedule(new s(rVar), n2Var6.f4250h.b, TimeUnit.NANOSECONDS));
                }
                n2.this.s(q);
            }
        }

        public s(r rVar) {
            n2.this = r1;
            this.b = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n2.this.b.execute(new a());
        }
    }

    /* loaded from: classes.dex */
    public static final class t {
        public final boolean a;
        public final boolean b;
        public final long c;

        /* renamed from: d */
        public final Integer f4258d;

        public t(boolean z, boolean z2, long j2, Integer num) {
            this.a = z;
            this.b = z2;
            this.c = j2;
            this.f4258d = num;
        }
    }

    /* loaded from: classes.dex */
    public static final class u {
        public final boolean a;
        public final List<o> b;
        public final Collection<w> c;

        /* renamed from: d */
        public final Collection<w> f4259d;

        /* renamed from: e */
        public final int f4260e;

        /* renamed from: f */
        public final w f4261f;

        /* renamed from: g */
        public final boolean f4262g;

        /* renamed from: h */
        public final boolean f4263h;

        public u(List<o> list, Collection<w> collection, Collection<w> collection2, w wVar, boolean z, boolean z2, boolean z3, int i2) {
            this.b = list;
            f.b.a.c.b.o.b.A(collection, "drainedSubstreams");
            this.c = collection;
            this.f4261f = wVar;
            this.f4259d = collection2;
            this.f4262g = z;
            this.a = z2;
            this.f4263h = z3;
            this.f4260e = i2;
            boolean z4 = false;
            f.b.a.c.b.o.b.G(!z2 || list == null, "passThrough should imply buffer is null");
            f.b.a.c.b.o.b.G(!z2 || wVar != null, "passThrough should imply winningSubstream != null");
            f.b.a.c.b.o.b.G(!z2 || (collection.size() == 1 && collection.contains(wVar)) || (collection.size() == 0 && wVar.b), "passThrough should imply winningSubstream is drained");
            f.b.a.c.b.o.b.G((!z || wVar != null) ? true : z4, "cancelled should imply committed");
        }

        public u a(w wVar) {
            Collection collection;
            f.b.a.c.b.o.b.G(!this.f4263h, "hedging frozen");
            f.b.a.c.b.o.b.G(this.f4261f == null, "already committed");
            if (this.f4259d == null) {
                collection = Collections.singleton(wVar);
            } else {
                ArrayList arrayList = new ArrayList(this.f4259d);
                arrayList.add(wVar);
                collection = Collections.unmodifiableCollection(arrayList);
            }
            return new u(this.b, this.c, collection, this.f4261f, this.f4262g, this.a, this.f4263h, this.f4260e + 1);
        }

        public u b() {
            return this.f4263h ? this : new u(this.b, this.c, this.f4259d, this.f4261f, this.f4262g, this.a, true, this.f4260e);
        }

        public u c(w wVar) {
            ArrayList arrayList = new ArrayList(this.f4259d);
            arrayList.remove(wVar);
            return new u(this.b, this.c, Collections.unmodifiableCollection(arrayList), this.f4261f, this.f4262g, this.a, this.f4263h, this.f4260e);
        }

        public u d(w wVar, w wVar2) {
            ArrayList arrayList = new ArrayList(this.f4259d);
            arrayList.remove(wVar);
            arrayList.add(wVar2);
            return new u(this.b, this.c, Collections.unmodifiableCollection(arrayList), this.f4261f, this.f4262g, this.a, this.f4263h, this.f4260e);
        }

        public u e(w wVar) {
            wVar.b = true;
            if (!this.c.contains(wVar)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.c);
            arrayList.remove(wVar);
            return new u(this.b, Collections.unmodifiableCollection(arrayList), this.f4259d, this.f4261f, this.f4262g, this.a, this.f4263h, this.f4260e);
        }

        public u f(w wVar) {
            Collection unmodifiableCollection;
            boolean z = true;
            f.b.a.c.b.o.b.G(!this.a, "Already passThrough");
            if (wVar.b) {
                unmodifiableCollection = this.c;
            } else if (this.c.isEmpty()) {
                unmodifiableCollection = Collections.singletonList(wVar);
            } else {
                ArrayList arrayList = new ArrayList(this.c);
                arrayList.add(wVar);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            w wVar2 = this.f4261f;
            boolean z2 = wVar2 != null;
            List<o> list = this.b;
            if (z2) {
                if (wVar2 != wVar) {
                    z = false;
                }
                f.b.a.c.b.o.b.G(z, "Another RPC attempt has already committed");
                list = null;
            }
            return new u(list, unmodifiableCollection, this.f4259d, this.f4261f, this.f4262g, z2, this.f4263h, this.f4260e);
        }
    }

    /* loaded from: classes.dex */
    public final class v implements v {
        public final w a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ w b;

            public a(w wVar) {
                v.this = r1;
                this.b = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                n2 n2Var = n2.this;
                w wVar = this.b;
                n0.f<String> fVar = n2.w;
                n2Var.s(wVar);
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* loaded from: classes.dex */
            public class a implements Runnable {
                public a() {
                    b.this = r1;
                }

                @Override // java.lang.Runnable
                public void run() {
                    v vVar = v.this;
                    n0.f<String> fVar = n2.w;
                    n2.this.s(n2.this.q(vVar.a.f4264d + 1));
                }
            }

            public b() {
                v.this = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                n2.this.b.execute(new a());
            }
        }

        public v(w wVar) {
            n2.this = r1;
            this.a = wVar;
        }

        @Override // h.a.j1.y2
        public void a(y2.a aVar) {
            u uVar = n2.this.p;
            f.b.a.c.b.o.b.G(uVar.f4261f != null, "Headers should be received prior to messages.");
            if (uVar.f4261f == this.a) {
                n2.this.s.a(aVar);
            }
        }

        @Override // h.a.j1.v
        public void b(c1 c1Var, n0 n0Var) {
            d(c1Var, v.a.PROCESSED, n0Var);
        }

        @Override // h.a.j1.y2
        public void c() {
            if (n2.this.p.c.contains(this.a)) {
                n2.this.s.c();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00aa, code lost:
            if (r2.f4249g.a == 1) goto L_0x00ac;
         */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01be  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01c1  */
        @Override // h.a.j1.v
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void d(c1 c1Var, v.a aVar, n0 n0Var) {
            t tVar;
            n2 n2Var;
            r rVar;
            Integer num;
            boolean z;
            long j2;
            boolean z2;
            long j3;
            long j4;
            n2 n2Var2;
            boolean z3;
            n2 n2Var3;
            synchronized (n2.this.f4252j) {
                n2 n2Var4 = n2.this;
                n2Var4.p = n2Var4.p.e(this.a);
                n2.this.o.a(c1Var.a);
            }
            w wVar = this.a;
            if (wVar.c) {
                n2.m(n2.this, wVar);
                if (n2.this.p.f4261f == this.a) {
                    n2.this.s.b(c1Var, n0Var);
                    return;
                }
                return;
            }
            if (n2.this.p.f4261f == null) {
                boolean z4 = true;
                boolean z5 = false;
                if (aVar != v.a.REFUSED || !n2.this.q.compareAndSet(false, true)) {
                    if (aVar == v.a.DROPPED) {
                        n2 n2Var5 = n2.this;
                        if (n2Var5.f4251i) {
                            n2Var5.t();
                        }
                    } else {
                        n2.this.q.set(true);
                        n2 n2Var6 = n2.this;
                        if (n2Var6.f4249g == null) {
                            n2Var6.f4249g = n2Var6.f4247e.get();
                            n2 n2Var7 = n2.this;
                            n2Var7.v = n2Var7.f4249g.b;
                        }
                        boolean contains = n2.this.f4249g.f4270e.contains(c1Var.a);
                        boolean contains2 = n2.this.f4250h.c.contains(c1Var.a);
                        if (!n2.this.f4251i || contains2) {
                            String str = (String) n0Var.d(n2.x);
                            if (str != null) {
                                try {
                                    num = Integer.valueOf(str);
                                } catch (NumberFormatException unused) {
                                    num = -1;
                                }
                            } else {
                                num = null;
                            }
                            if (n2.this.n == null || (!contains && !contains2 && (num == null || num.intValue() >= 0))) {
                                z = false;
                            } else {
                                x xVar = n2.this.n;
                                while (true) {
                                    int i2 = xVar.f4265d.get();
                                    if (i2 == 0) {
                                        break;
                                    }
                                    int i3 = i2 - 1000;
                                    if (xVar.f4265d.compareAndSet(i2, Math.max(i3, 0))) {
                                        if (i3 > xVar.b) {
                                            z3 = true;
                                        }
                                    }
                                }
                                z3 = false;
                                z = !z3;
                            }
                            n2 n2Var8 = n2.this;
                            if (n2Var8.f4249g.a > this.a.f4264d + 1 && !z) {
                                if (num == null) {
                                    if (contains) {
                                        j4 = (long) (n2.z.nextDouble() * ((double) n2Var8.v));
                                        n2Var2 = n2.this;
                                        o2 o2Var = n2Var2.f4249g;
                                        j3 = Math.min((long) (((double) n2Var2.v) * o2Var.f4269d), o2Var.c);
                                        n2Var2.v = j3;
                                        j2 = j4;
                                        z2 = true;
                                    }
                                } else if (num.intValue() >= 0) {
                                    j4 = TimeUnit.MILLISECONDS.toNanos((long) num.intValue());
                                    n2Var2 = n2.this;
                                    j3 = n2Var2.f4249g.b;
                                    n2Var2.v = j3;
                                    j2 = j4;
                                    z2 = true;
                                }
                                tVar = new t(z2, false, j2, !n2.this.f4251i ? num : null);
                            }
                            j2 = 0;
                            z2 = false;
                            tVar = new t(z2, false, j2, !n2.this.f4251i ? num : null);
                        } else {
                            tVar = new t(false, true, 0, null);
                        }
                        if (tVar.a) {
                            synchronized (n2.this.f4252j) {
                                n2Var = n2.this;
                                rVar = new r(n2Var.f4252j);
                                n2Var.t = rVar;
                            }
                            rVar.b(n2Var.c.schedule(new b(), tVar.c, TimeUnit.NANOSECONDS));
                            return;
                        }
                        z5 = tVar.b;
                        n2.o(n2.this, tVar.f4258d);
                    }
                    n2 n2Var9 = n2.this;
                    if (n2Var9.f4251i) {
                        synchronized (n2Var9.f4252j) {
                            n2 n2Var10 = n2.this;
                            n2Var10.p = n2Var10.p.c(this.a);
                            if (!z5) {
                                n2 n2Var11 = n2.this;
                                if (n2Var11.u(n2Var11.p) || !n2.this.p.f4259d.isEmpty()) {
                                    return;
                                }
                            }
                        }
                    }
                } else {
                    w q = n2.this.q(this.a.f4264d);
                    n2 n2Var12 = n2.this;
                    if (n2Var12.f4251i) {
                        synchronized (n2Var12.f4252j) {
                            n2 n2Var13 = n2.this;
                            n2Var13.p = n2Var13.p.d(this.a, q);
                            n2 n2Var14 = n2.this;
                            if (n2Var14.u(n2Var14.p) || n2.this.p.f4259d.size() != 1) {
                                z4 = false;
                            }
                        }
                        if (z4) {
                            n2Var3 = n2.this;
                            n2.m(n2Var3, q);
                        }
                        n2.this.b.execute(new a(q));
                        return;
                    }
                    if (n2Var12.f4249g == null) {
                        n2Var12.f4249g = n2Var12.f4247e.get();
                    }
                    n2Var3 = n2.this;
                }
            }
            n2.m(n2.this, this.a);
            if (n2.this.p.f4261f == this.a) {
                n2.this.s.b(c1Var, n0Var);
            }
        }

        @Override // h.a.j1.v
        public void e(n0 n0Var) {
            int i2;
            int i3;
            n2.m(n2.this, this.a);
            if (n2.this.p.f4261f == this.a) {
                n2.this.s.e(n0Var);
                x xVar = n2.this.n;
                if (xVar != null) {
                    do {
                        i2 = xVar.f4265d.get();
                        i3 = xVar.a;
                        if (i2 == i3) {
                            return;
                        }
                    } while (!xVar.f4265d.compareAndSet(i2, Math.min(xVar.c + i2, i3)));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class w {
        public u a;
        public boolean b;
        public boolean c;

        /* renamed from: d */
        public final int f4264d;

        public w(int i2) {
            this.f4264d = i2;
        }
    }

    /* loaded from: classes.dex */
    public static final class x {
        public final int a;
        public final int b;
        public final int c;

        /* renamed from: d */
        public final AtomicInteger f4265d;

        public x(float f2, float f3) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f4265d = atomicInteger;
            this.c = (int) (f3 * 1000.0f);
            int i2 = (int) (f2 * 1000.0f);
            this.a = i2;
            this.b = i2 / 2;
            atomicInteger.set(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof x)) {
                return false;
            }
            x xVar = (x) obj;
            return this.a == xVar.a && this.c == xVar.c;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.c)});
        }
    }

    static {
        n0.d<String> dVar = n0.c;
        w = n0.f.a("grpc-previous-rpc-attempts", dVar);
        x = n0.f.a("grpc-retry-pushback-ms", dVar);
    }

    public n2(o0<ReqT, ?> o0Var, n0 n0Var, q qVar, long j2, long j3, Executor executor, ScheduledExecutorService scheduledExecutorService, o2.a aVar, s0.a aVar2, x xVar) {
        this.a = o0Var;
        this.f4253k = qVar;
        this.f4254l = j2;
        this.m = j3;
        this.b = executor;
        this.c = scheduledExecutorService;
        this.f4246d = n0Var;
        f.b.a.c.b.o.b.A(aVar, "retryPolicyProvider");
        this.f4247e = aVar;
        f.b.a.c.b.o.b.A(aVar2, "hedgingPolicyProvider");
        this.f4248f = aVar2;
        this.n = xVar;
    }

    public static void m(n2 n2Var, w wVar) {
        Runnable p2 = n2Var.p(wVar);
        if (p2 != null) {
            ((c) p2).run();
        }
    }

    public static void o(n2 n2Var, Integer num) {
        Future<?> a2;
        r rVar;
        Objects.requireNonNull(n2Var);
        if (num != null) {
            if (num.intValue() < 0) {
                n2Var.t();
                return;
            }
            synchronized (n2Var.f4252j) {
                r rVar2 = n2Var.u;
                if (rVar2 != null) {
                    a2 = rVar2.a();
                    rVar = new r(n2Var.f4252j);
                    n2Var.u = rVar;
                } else {
                    return;
                }
            }
            if (a2 != null) {
                a2.cancel(false);
            }
            rVar.b(n2Var.c.schedule(new s(rVar), (long) num.intValue(), TimeUnit.MILLISECONDS));
        }
    }

    @Override // h.a.j1.u
    public final void a(int i2) {
        r(new k(this, i2));
    }

    @Override // h.a.j1.x2
    public final void b(h.a.l lVar) {
        r(new d(this, lVar));
    }

    @Override // h.a.j1.x2
    public final void c(int i2) {
        u uVar = this.p;
        if (uVar.a) {
            uVar.f4261f.a.c(i2);
        } else {
            r(new l(this, i2));
        }
    }

    @Override // h.a.j1.u
    public final void d(int i2) {
        r(new j(this, i2));
    }

    @Override // h.a.j1.u
    public final void e(h.a.r rVar) {
        r(new e(this, rVar));
    }

    @Override // h.a.j1.u
    public final void f(h.a.t tVar) {
        r(new f(this, tVar));
    }

    @Override // h.a.j1.x2
    public final void flush() {
        u uVar = this.p;
        if (uVar.a) {
            uVar.f4261f.a.flush();
        } else {
            r(new g(this));
        }
    }

    @Override // h.a.j1.u
    public final void g(c1 c1Var) {
        w wVar = new w(0);
        wVar.a = new c2();
        Runnable p2 = p(wVar);
        if (p2 != null) {
            this.s.b(c1Var, new n0());
            ((c) p2).run();
            return;
        }
        this.p.f4261f.a.g(c1Var);
        synchronized (this.f4252j) {
            u uVar = this.p;
            this.p = new u(uVar.b, uVar.c, uVar.f4259d, uVar.f4261f, true, uVar.a, uVar.f4263h, uVar.f4260e);
        }
    }

    @Override // h.a.j1.x2
    public final void h(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
        if (r7 != false) goto L_0x0069;
     */
    @Override // h.a.j1.u
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void i(v vVar) {
        this.s = vVar;
        c1 x2 = x();
        if (x2 != null) {
            g(x2);
            return;
        }
        synchronized (this.f4252j) {
            this.p.b.add(new n());
        }
        boolean z2 = false;
        w q2 = q(0);
        f.b.a.c.b.o.b.G(this.f4250h == null, "hedgingPolicy has been initialized unexpectedly");
        s0 s0Var = this.f4248f.get();
        this.f4250h = s0Var;
        if (!s0.f4329d.equals(s0Var)) {
            this.f4251i = true;
            this.f4249g = o2.f4268f;
            r rVar = null;
            synchronized (this.f4252j) {
                this.p = this.p.a(q2);
                if (u(this.p)) {
                    x xVar = this.n;
                    if (xVar != null) {
                        if (xVar.f4265d.get() > xVar.b) {
                            z2 = true;
                        }
                    }
                    rVar = new r(this.f4252j);
                    this.u = rVar;
                }
            }
            if (rVar != null) {
                rVar.b(this.c.schedule(new s(rVar), this.f4250h.b, TimeUnit.NANOSECONDS));
            }
        }
        s(q2);
    }

    @Override // h.a.j1.u
    public final void j(String str) {
        r(new b(this, str));
    }

    @Override // h.a.j1.u
    public void k(y0 y0Var) {
        u uVar;
        y0 y0Var2;
        String str;
        synchronized (this.f4252j) {
            y0Var.b("closed", this.o);
            uVar = this.p;
        }
        if (uVar.f4261f != null) {
            y0Var2 = new y0();
            uVar.f4261f.a.k(y0Var2);
            str = "committed";
        } else {
            y0Var2 = new y0();
            for (w wVar : uVar.c) {
                y0 y0Var3 = new y0();
                wVar.a.k(y0Var3);
                y0Var2.a.add(String.valueOf(y0Var3));
            }
            str = "open";
        }
        y0Var.b(str, y0Var2);
    }

    @Override // h.a.j1.u
    public final void l() {
        r(new i(this));
    }

    @Override // h.a.j1.u
    public final void n(boolean z2) {
        r(new h(this, z2));
    }

    public final Runnable p(w wVar) {
        Collection collection;
        Future<?> future;
        Future<?> future2;
        synchronized (this.f4252j) {
            if (this.p.f4261f != null) {
                return null;
            }
            Collection<w> collection2 = this.p.c;
            u uVar = this.p;
            boolean z2 = false;
            f.b.a.c.b.o.b.G(uVar.f4261f == null, "Already committed");
            List<o> list = uVar.b;
            if (uVar.c.contains(wVar)) {
                collection = Collections.singleton(wVar);
                list = null;
                z2 = true;
            } else {
                collection = Collections.emptyList();
            }
            this.p = new u(list, collection, uVar.f4259d, wVar, uVar.f4262g, z2, uVar.f4263h, uVar.f4260e);
            this.f4253k.a.addAndGet(-this.r);
            r rVar = this.t;
            if (rVar != null) {
                future = rVar.a();
                this.t = null;
            } else {
                future = null;
            }
            r rVar2 = this.u;
            if (rVar2 != null) {
                future2 = rVar2.a();
                this.u = null;
            } else {
                future2 = null;
            }
            return new c(collection2, wVar, future, future2);
        }
    }

    public final w q(int i2) {
        w wVar = new w(i2);
        a aVar = new a(this, new p(wVar));
        n0 n0Var = this.f4246d;
        n0 n0Var2 = new n0();
        n0Var2.f(n0Var);
        if (i2 > 0) {
            n0Var2.h(w, String.valueOf(i2));
        }
        wVar.a = v(aVar, n0Var2);
        return wVar;
    }

    public final void r(o oVar) {
        Collection<w> collection;
        synchronized (this.f4252j) {
            if (!this.p.a) {
                this.p.b.add(oVar);
            }
            collection = this.p.c;
        }
        for (w wVar : collection) {
            oVar.a(wVar);
        }
    }

    public final void s(w wVar) {
        boolean z2 = false;
        ArrayList<o> arrayList = null;
        int i2 = 0;
        while (true) {
            synchronized (this.f4252j) {
                u uVar = this.p;
                w wVar2 = uVar.f4261f;
                if (wVar2 != null && wVar2 != wVar) {
                    wVar.a.g(y);
                    return;
                } else if (i2 == uVar.b.size()) {
                    this.p = uVar.f(wVar);
                    return;
                } else if (!wVar.b) {
                    int min = Math.min(i2 + 128, uVar.b.size());
                    if (arrayList == null) {
                        arrayList = new ArrayList(uVar.b.subList(i2, min));
                    } else {
                        arrayList.clear();
                        arrayList.addAll(uVar.b.subList(i2, min));
                    }
                    for (o oVar : arrayList) {
                        u uVar2 = this.p;
                        w wVar3 = uVar2.f4261f;
                        if (wVar3 == null || wVar3 == wVar) {
                            if (uVar2.f4262g) {
                                if (wVar3 == wVar) {
                                    z2 = true;
                                }
                                f.b.a.c.b.o.b.G(z2, "substream should be CANCELLED_BECAUSE_COMMITTED already");
                                return;
                            }
                            oVar.a(wVar);
                        }
                    }
                    i2 = min;
                } else {
                    return;
                }
            }
        }
    }

    public final void t() {
        Future<?> future;
        synchronized (this.f4252j) {
            r rVar = this.u;
            future = null;
            if (rVar != null) {
                future = rVar.a();
                this.u = null;
            }
            this.p = this.p.b();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    public final boolean u(u uVar) {
        return uVar.f4261f == null && uVar.f4260e < this.f4250h.a && !uVar.f4263h;
    }

    public abstract u v(j.a aVar, n0 n0Var);

    public abstract void w();

    public abstract c1 x();

    public final void y(ReqT reqt) {
        u uVar = this.p;
        if (uVar.a) {
            uVar.f4261f.a.h(this.a.f4528d.b(reqt));
        } else {
            r(new m(reqt));
        }
    }
}
