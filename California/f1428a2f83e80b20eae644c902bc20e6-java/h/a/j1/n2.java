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
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class n2<ReqT> implements u {
    public static final n0.f<String> w;
    public static final n0.f<String> x;
    public static final c1 y = c1.f3510g.g("Stream thrown away because RetriableStream committed");
    public static Random z = new Random();
    public final o0<ReqT, ?> a;
    public final Executor b;
    public final ScheduledExecutorService c;

    /* renamed from: d  reason: collision with root package name */
    public final n0 f3668d;

    /* renamed from: e  reason: collision with root package name */
    public final o2.a f3669e;

    /* renamed from: f  reason: collision with root package name */
    public final s0.a f3670f;

    /* renamed from: g  reason: collision with root package name */
    public o2 f3671g;

    /* renamed from: h  reason: collision with root package name */
    public s0 f3672h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3673i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f3674j = new Object();

    /* renamed from: k  reason: collision with root package name */
    public final q f3675k;

    /* renamed from: l  reason: collision with root package name */
    public final long f3676l;
    public final long m;
    public final x n;
    public final y0 o = new y0();
    public volatile u p = new u(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);
    public final AtomicBoolean q = new AtomicBoolean();
    public long r;
    public v s;
    public r t;
    public r u;
    public long v;

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

    public class b implements o {
        public final /* synthetic */ String a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b(n2 n2Var, String str) {
            this.a = str;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.j(this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Collection b;
        public final /* synthetic */ w c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Future f3677d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Future f3678e;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c(Collection collection, w wVar, Future future, Future future2) {
            this.b = collection;
            this.c = wVar;
            this.f3677d = future;
            this.f3678e = future2;
        }

        public void run() {
            for (w wVar : this.b) {
                if (wVar != this.c) {
                    wVar.a.g(n2.y);
                }
            }
            Future future = this.f3677d;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f3678e;
            if (future2 != null) {
                future2.cancel(false);
            }
            n2.this.w();
        }
    }

    public class d implements o {
        public final /* synthetic */ h.a.l a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d(n2 n2Var, h.a.l lVar) {
            this.a = lVar;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.b(this.a);
        }
    }

    public class e implements o {
        public final /* synthetic */ h.a.r a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public e(n2 n2Var, h.a.r rVar) {
            this.a = rVar;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.e(this.a);
        }
    }

    public class f implements o {
        public final /* synthetic */ h.a.t a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public f(n2 n2Var, h.a.t tVar) {
            this.a = tVar;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.f(this.a);
        }
    }

    public class g implements o {
        public g(n2 n2Var) {
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.flush();
        }
    }

    public class h implements o {
        public final /* synthetic */ boolean a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public h(n2 n2Var, boolean z) {
            this.a = z;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.n(this.a);
        }
    }

    public class i implements o {
        public i(n2 n2Var) {
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.l();
        }
    }

    public class j implements o {
        public final /* synthetic */ int a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public j(n2 n2Var, int i2) {
            this.a = i2;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.d(this.a);
        }
    }

    public class k implements o {
        public final /* synthetic */ int a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public k(n2 n2Var, int i2) {
            this.a = i2;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.a(this.a);
        }
    }

    public class l implements o {
        public final /* synthetic */ int a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public l(n2 n2Var, int i2) {
            this.a = i2;
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.c(this.a);
        }
    }

    public class m implements o {
        public final /* synthetic */ Object a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public m(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: h.a.o0<ReqT, ?> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.h(n2.this.a.b(this.a));
        }
    }

    public class n implements o {
        public n() {
        }

        @Override // h.a.j1.n2.o
        public void a(w wVar) {
            wVar.a.i(new v(wVar));
        }
    }

    public interface o {
        void a(w wVar);
    }

    public class p extends h.a.j {
        public final w a;
        public long b;

        public p(w wVar) {
            this.a = wVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
            ((h.a.j1.n2.c) r0).run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        @Override // h.a.f1
        public void a(long j2) {
            if (n2.this.p.f3683f == null) {
                Runnable runnable = null;
                synchronized (n2.this.f3674j) {
                    if (n2.this.p.f3683f == null) {
                        w wVar = this.a;
                        if (!wVar.b) {
                            long j3 = this.b + j2;
                            this.b = j3;
                            n2 n2Var = n2.this;
                            long j4 = n2Var.r;
                            if (j3 > j4) {
                                if (j3 > n2Var.f3676l) {
                                    wVar.c = true;
                                } else {
                                    long addAndGet = n2Var.f3675k.a.addAndGet(j3 - j4);
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
                            }
                        }
                    }
                }
            }
        }
    }

    public static final class q {
        public final AtomicLong a = new AtomicLong();
    }

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

    public final class s implements Runnable {
        public final r b;

        public class a implements Runnable {
            public a() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
                if (r4 != false) goto L_0x004b;
             */
            public void run() {
                boolean z;
                r rVar;
                n2 n2Var;
                n2 n2Var2 = n2.this;
                w q = n2Var2.q(n2Var2.p.f3682e);
                synchronized (n2.this.f3674j) {
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
                                if (xVar.f3687d.get() <= xVar.b) {
                                    z = false;
                                }
                            }
                            n2Var = n2.this;
                            rVar = new r(n2Var.f3674j);
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
                    q.a.g(c1.f3510g.g("Unneeded hedging"));
                    return;
                }
                if (rVar != null) {
                    n2 n2Var6 = n2.this;
                    rVar.b(n2Var6.c.schedule(new s(rVar), n2Var6.f3672h.b, TimeUnit.NANOSECONDS));
                }
                n2.this.s(q);
            }
        }

        public s(r rVar) {
            this.b = rVar;
        }

        public void run() {
            n2.this.b.execute(new a());
        }
    }

    public static final class t {
        public final boolean a;
        public final boolean b;
        public final long c;

        /* renamed from: d  reason: collision with root package name */
        public final Integer f3680d;

        public t(boolean z, boolean z2, long j2, Integer num) {
            this.a = z;
            this.b = z2;
            this.c = j2;
            this.f3680d = num;
        }
    }

    public static final class u {
        public final boolean a;
        public final List<o> b;
        public final Collection<w> c;

        /* renamed from: d  reason: collision with root package name */
        public final Collection<w> f3681d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3682e;

        /* renamed from: f  reason: collision with root package name */
        public final w f3683f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f3684g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f3685h;

        public u(List<o> list, Collection<w> collection, Collection<w> collection2, w wVar, boolean z, boolean z2, boolean z3, int i2) {
            this.b = list;
            f.b.a.c.b.o.b.A(collection, "drainedSubstreams");
            this.c = collection;
            this.f3683f = wVar;
            this.f3681d = collection2;
            this.f3684g = z;
            this.a = z2;
            this.f3685h = z3;
            this.f3682e = i2;
            boolean z4 = false;
            f.b.a.c.b.o.b.G(!z2 || list == null, "passThrough should imply buffer is null");
            f.b.a.c.b.o.b.G(!z2 || wVar != null, "passThrough should imply winningSubstream != null");
            f.b.a.c.b.o.b.G(!z2 || (collection.size() == 1 && collection.contains(wVar)) || (collection.size() == 0 && wVar.b), "passThrough should imply winningSubstream is drained");
            f.b.a.c.b.o.b.G((!z || wVar != null) ? true : z4, "cancelled should imply committed");
        }

        public u a(w wVar) {
            Collection collection;
            f.b.a.c.b.o.b.G(!this.f3685h, "hedging frozen");
            f.b.a.c.b.o.b.G(this.f3683f == null, "already committed");
            if (this.f3681d == null) {
                collection = Collections.singleton(wVar);
            } else {
                ArrayList arrayList = new ArrayList(this.f3681d);
                arrayList.add(wVar);
                collection = Collections.unmodifiableCollection(arrayList);
            }
            return new u(this.b, this.c, collection, this.f3683f, this.f3684g, this.a, this.f3685h, this.f3682e + 1);
        }

        public u b() {
            return this.f3685h ? this : new u(this.b, this.c, this.f3681d, this.f3683f, this.f3684g, this.a, true, this.f3682e);
        }

        public u c(w wVar) {
            ArrayList arrayList = new ArrayList(this.f3681d);
            arrayList.remove(wVar);
            return new u(this.b, this.c, Collections.unmodifiableCollection(arrayList), this.f3683f, this.f3684g, this.a, this.f3685h, this.f3682e);
        }

        public u d(w wVar, w wVar2) {
            ArrayList arrayList = new ArrayList(this.f3681d);
            arrayList.remove(wVar);
            arrayList.add(wVar2);
            return new u(this.b, this.c, Collections.unmodifiableCollection(arrayList), this.f3683f, this.f3684g, this.a, this.f3685h, this.f3682e);
        }

        public u e(w wVar) {
            wVar.b = true;
            if (!this.c.contains(wVar)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.c);
            arrayList.remove(wVar);
            return new u(this.b, Collections.unmodifiableCollection(arrayList), this.f3681d, this.f3683f, this.f3684g, this.a, this.f3685h, this.f3682e);
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
            w wVar2 = this.f3683f;
            boolean z2 = wVar2 != null;
            List<o> list = this.b;
            if (z2) {
                if (wVar2 != wVar) {
                    z = false;
                }
                f.b.a.c.b.o.b.G(z, "Another RPC attempt has already committed");
                list = null;
            }
            return new u(list, unmodifiableCollection, this.f3681d, this.f3683f, this.f3684g, z2, this.f3685h, this.f3682e);
        }
    }

    public final class v implements v {
        public final w a;

        public class a implements Runnable {
            public final /* synthetic */ w b;

            public a(w wVar) {
                this.b = wVar;
            }

            public void run() {
                n2 n2Var = n2.this;
                w wVar = this.b;
                n0.f<String> fVar = n2.w;
                n2Var.s(wVar);
            }
        }

        public class b implements Runnable {

            public class a implements Runnable {
                public a() {
                }

                public void run() {
                    v vVar = v.this;
                    n0.f<String> fVar = n2.w;
                    n2.this.s(n2.this.q(vVar.a.f3686d + 1));
                }
            }

            public b() {
            }

            public void run() {
                n2.this.b.execute(new a());
            }
        }

        public v(w wVar) {
            this.a = wVar;
        }

        @Override // h.a.j1.y2
        public void a(y2.a aVar) {
            u uVar = n2.this.p;
            f.b.a.c.b.o.b.G(uVar.f3683f != null, "Headers should be received prior to messages.");
            if (uVar.f3683f == this.a) {
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

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00aa, code lost:
            if (r2.f3671g.a == 1) goto L_0x00ac;
         */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01be  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x01c1  */
        @Override // h.a.j1.v
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
            synchronized (n2.this.f3674j) {
                n2 n2Var4 = n2.this;
                n2Var4.p = n2Var4.p.e(this.a);
                n2.this.o.a(c1Var.a);
            }
            w wVar = this.a;
            if (wVar.c) {
                n2.m(n2.this, wVar);
                if (n2.this.p.f3683f == this.a) {
                    n2.this.s.b(c1Var, n0Var);
                    return;
                }
                return;
            }
            if (n2.this.p.f3683f == null) {
                boolean z4 = true;
                boolean z5 = false;
                if (aVar != v.a.REFUSED || !n2.this.q.compareAndSet(false, true)) {
                    if (aVar == v.a.DROPPED) {
                        n2 n2Var5 = n2.this;
                        if (n2Var5.f3673i) {
                            n2Var5.t();
                        }
                    } else {
                        n2.this.q.set(true);
                        n2 n2Var6 = n2.this;
                        if (n2Var6.f3671g == null) {
                            n2Var6.f3671g = n2Var6.f3669e.get();
                            n2 n2Var7 = n2.this;
                            n2Var7.v = n2Var7.f3671g.b;
                        }
                        boolean contains = n2.this.f3671g.f3692e.contains(c1Var.a);
                        boolean contains2 = n2.this.f3672h.c.contains(c1Var.a);
                        if (!n2.this.f3673i || contains2) {
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
                                    int i2 = xVar.f3687d.get();
                                    if (i2 == 0) {
                                        break;
                                    }
                                    int i3 = i2 - 1000;
                                    if (xVar.f3687d.compareAndSet(i2, Math.max(i3, 0))) {
                                        if (i3 > xVar.b) {
                                            z3 = true;
                                        }
                                    }
                                }
                                z3 = false;
                                z = !z3;
                            }
                            n2 n2Var8 = n2.this;
                            if (n2Var8.f3671g.a > this.a.f3686d + 1 && !z) {
                                if (num == null) {
                                    if (contains) {
                                        j4 = (long) (n2.z.nextDouble() * ((double) n2Var8.v));
                                        n2Var2 = n2.this;
                                        o2 o2Var = n2Var2.f3671g;
                                        j3 = Math.min((long) (((double) n2Var2.v) * o2Var.f3691d), o2Var.c);
                                    }
                                } else if (num.intValue() >= 0) {
                                    j4 = TimeUnit.MILLISECONDS.toNanos((long) num.intValue());
                                    n2Var2 = n2.this;
                                    j3 = n2Var2.f3671g.b;
                                }
                                n2Var2.v = j3;
                                j2 = j4;
                                z2 = true;
                                tVar = new t(z2, false, j2, !n2.this.f3673i ? num : null);
                            }
                            j2 = 0;
                            z2 = false;
                            tVar = new t(z2, false, j2, !n2.this.f3673i ? num : null);
                        } else {
                            tVar = new t(false, true, 0, null);
                        }
                        if (tVar.a) {
                            synchronized (n2.this.f3674j) {
                                n2Var = n2.this;
                                rVar = new r(n2Var.f3674j);
                                n2Var.t = rVar;
                            }
                            rVar.b(n2Var.c.schedule(new b(), tVar.c, TimeUnit.NANOSECONDS));
                            return;
                        }
                        z5 = tVar.b;
                        n2.o(n2.this, tVar.f3680d);
                    }
                    n2 n2Var9 = n2.this;
                    if (n2Var9.f3673i) {
                        synchronized (n2Var9.f3674j) {
                            n2 n2Var10 = n2.this;
                            n2Var10.p = n2Var10.p.c(this.a);
                            if (!z5) {
                                n2 n2Var11 = n2.this;
                                if (n2Var11.u(n2Var11.p) || !n2.this.p.f3681d.isEmpty()) {
                                    return;
                                }
                            }
                        }
                    }
                } else {
                    w q = n2.this.q(this.a.f3686d);
                    n2 n2Var12 = n2.this;
                    if (n2Var12.f3673i) {
                        synchronized (n2Var12.f3674j) {
                            n2 n2Var13 = n2.this;
                            n2Var13.p = n2Var13.p.d(this.a, q);
                            n2 n2Var14 = n2.this;
                            if (n2Var14.u(n2Var14.p) || n2.this.p.f3681d.size() != 1) {
                                z4 = false;
                            }
                        }
                        if (z4) {
                            n2Var3 = n2.this;
                        }
                        n2.this.b.execute(new a(q));
                        return;
                    }
                    if (n2Var12.f3671g == null) {
                        n2Var12.f3671g = n2Var12.f3669e.get();
                    }
                    n2Var3 = n2.this;
                    n2.m(n2Var3, q);
                    n2.this.b.execute(new a(q));
                    return;
                }
            }
            n2.m(n2.this, this.a);
            if (n2.this.p.f3683f == this.a) {
                n2.this.s.b(c1Var, n0Var);
            }
        }

        @Override // h.a.j1.v
        public void e(n0 n0Var) {
            int i2;
            int i3;
            n2.m(n2.this, this.a);
            if (n2.this.p.f3683f == this.a) {
                n2.this.s.e(n0Var);
                x xVar = n2.this.n;
                if (xVar != null) {
                    do {
                        i2 = xVar.f3687d.get();
                        i3 = xVar.a;
                        if (i2 == i3) {
                            return;
                        }
                    } while (!xVar.f3687d.compareAndSet(i2, Math.min(xVar.c + i2, i3)));
                }
            }
        }
    }

    public static final class w {
        public u a;
        public boolean b;
        public boolean c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3686d;

        public w(int i2) {
            this.f3686d = i2;
        }
    }

    public static final class x {
        public final int a;
        public final int b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f3687d;

        public x(float f2, float f3) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f3687d = atomicInteger;
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
        this.f3675k = qVar;
        this.f3676l = j2;
        this.m = j3;
        this.b = executor;
        this.c = scheduledExecutorService;
        this.f3668d = n0Var;
        f.b.a.c.b.o.b.A(aVar, "retryPolicyProvider");
        this.f3669e = aVar;
        f.b.a.c.b.o.b.A(aVar2, "hedgingPolicyProvider");
        this.f3670f = aVar2;
        this.n = xVar;
    }

    public static void m(n2 n2Var, w wVar) {
        Runnable p2 = n2Var.p(wVar);
        if (p2 != null) {
            ((c) p2).run();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r1 == null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        r1.cancel(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r2.b(r4.c.schedule(new h.a.j1.n2.s(r4, r2), (long) r5.intValue(), java.util.concurrent.TimeUnit.MILLISECONDS));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    public static void o(n2 n2Var, Integer num) {
        Objects.requireNonNull(n2Var);
        if (num != null) {
            if (num.intValue() < 0) {
                n2Var.t();
                return;
            }
            synchronized (n2Var.f3674j) {
                r rVar = n2Var.u;
                if (rVar != null) {
                    Future<?> a2 = rVar.a();
                    r rVar2 = new r(n2Var.f3674j);
                    n2Var.u = rVar2;
                }
            }
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
            uVar.f3683f.a.c(i2);
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
            uVar.f3683f.a.flush();
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
        this.p.f3683f.a.g(c1Var);
        synchronized (this.f3674j) {
            u uVar = this.p;
            this.p = new u(uVar.b, uVar.c, uVar.f3681d, uVar.f3683f, true, uVar.a, uVar.f3685h, uVar.f3682e);
        }
    }

    @Override // h.a.j1.x2
    public final void h(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0067, code lost:
        if (r7 != false) goto L_0x0069;
     */
    @Override // h.a.j1.u
    public final void i(v vVar) {
        this.s = vVar;
        c1 x2 = x();
        if (x2 != null) {
            g(x2);
            return;
        }
        synchronized (this.f3674j) {
            this.p.b.add(new n());
        }
        boolean z2 = false;
        w q2 = q(0);
        f.b.a.c.b.o.b.G(this.f3672h == null, "hedgingPolicy has been initialized unexpectedly");
        s0 s0Var = this.f3670f.get();
        this.f3672h = s0Var;
        if (!s0.f3751d.equals(s0Var)) {
            this.f3673i = true;
            this.f3671g = o2.f3690f;
            r rVar = null;
            synchronized (this.f3674j) {
                this.p = this.p.a(q2);
                if (u(this.p)) {
                    x xVar = this.n;
                    if (xVar != null) {
                        if (xVar.f3687d.get() > xVar.b) {
                            z2 = true;
                        }
                    }
                    rVar = new r(this.f3674j);
                    this.u = rVar;
                }
            }
            if (rVar != null) {
                rVar.b(this.c.schedule(new s(rVar), this.f3672h.b, TimeUnit.NANOSECONDS));
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
        synchronized (this.f3674j) {
            y0Var.b("closed", this.o);
            uVar = this.p;
        }
        if (uVar.f3683f != null) {
            y0Var2 = new y0();
            uVar.f3683f.a.k(y0Var2);
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
        Set set;
        List<o> list;
        Future<?> future;
        Future<?> future2;
        synchronized (this.f3674j) {
            if (this.p.f3683f != null) {
                return null;
            }
            Collection<w> collection = this.p.c;
            u uVar = this.p;
            boolean z2 = false;
            f.b.a.c.b.o.b.G(uVar.f3683f == null, "Already committed");
            List<o> list2 = uVar.b;
            if (uVar.c.contains(wVar)) {
                list = null;
                set = Collections.singleton(wVar);
                z2 = true;
            } else {
                list = list2;
                set = Collections.emptyList();
            }
            this.p = new u(list, set, uVar.f3681d, wVar, uVar.f3684g, z2, uVar.f3685h, uVar.f3682e);
            this.f3675k.a.addAndGet(-this.r);
            r rVar = this.t;
            if (rVar != null) {
                Future<?> a2 = rVar.a();
                this.t = null;
                future = a2;
            } else {
                future = null;
            }
            r rVar2 = this.u;
            if (rVar2 != null) {
                Future<?> a3 = rVar2.a();
                this.u = null;
                future2 = a3;
            } else {
                future2 = null;
            }
            return new c(collection, wVar, future, future2);
        }
    }

    public final w q(int i2) {
        w wVar = new w(i2);
        a aVar = new a(this, new p(wVar));
        n0 n0Var = this.f3668d;
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
        synchronized (this.f3674j) {
            if (!this.p.a) {
                this.p.b.add(oVar);
            }
            collection = this.p.c;
        }
        for (w wVar : collection) {
            oVar.a(wVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        r2 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        if (r2.hasNext() == false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        r3 = (h.a.j1.n2.o) r2.next();
        r4 = r7.p;
        r6 = r4.f3683f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        if (r6 == null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        if (r6 == r8) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006f, code lost:
        if (r4.f3684g == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0071, code lost:
        if (r6 != r8) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0074, code lost:
        f.b.a.c.b.o.b.G(r0, "substream should be CANCELLED_BECAUSE_COMMITTED already");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007a, code lost:
        r3.a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007e, code lost:
        continue;
     */
    public final void s(w wVar) {
        int min;
        boolean z2 = false;
        ArrayList arrayList = null;
        int i2 = 0;
        while (true) {
            synchronized (this.f3674j) {
                u uVar = this.p;
                w wVar2 = uVar.f3683f;
                if (wVar2 != null && wVar2 != wVar) {
                    wVar.a.g(y);
                    return;
                } else if (i2 == uVar.b.size()) {
                    this.p = uVar.f(wVar);
                    return;
                } else if (!wVar.b) {
                    min = Math.min(i2 + 128, uVar.b.size());
                    if (arrayList == null) {
                        arrayList = new ArrayList(uVar.b.subList(i2, min));
                    } else {
                        arrayList.clear();
                        arrayList.addAll(uVar.b.subList(i2, min));
                    }
                } else {
                    return;
                }
            }
            i2 = min;
        }
    }

    public final void t() {
        Future<?> future;
        synchronized (this.f3674j) {
            r rVar = this.u;
            future = null;
            if (rVar != null) {
                Future<?> a2 = rVar.a();
                this.u = null;
                future = a2;
            }
            this.p = this.p.b();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    public final boolean u(u uVar) {
        return uVar.f3683f == null && uVar.f3682e < this.f3672h.a && !uVar.f3685h;
    }

    public abstract u v(j.a aVar, n0 n0Var);

    public abstract void w();

    public abstract c1 x();

    public final void y(ReqT reqt) {
        u uVar = this.p;
        if (uVar.a) {
            uVar.f3683f.a.h(this.a.f3950d.b(reqt));
        } else {
            r(new m(reqt));
        }
    }
}
