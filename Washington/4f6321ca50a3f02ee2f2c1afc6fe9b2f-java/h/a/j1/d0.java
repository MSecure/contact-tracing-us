package h.a.j1;

import h.a.c1;
import h.a.g1;
import h.a.h0;
import h.a.j1.y1;
import h.a.n0;
import h.a.o0;
import h.a.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.concurrent.Executor;

public final class d0 implements y1 {
    public final h.a.d0 a = h.a.d0.a(d0.class, null);
    public final Object b = new Object();
    public final Executor c;

    /* renamed from: d  reason: collision with root package name */
    public final g1 f3592d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f3593e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f3594f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f3595g;

    /* renamed from: h  reason: collision with root package name */
    public y1.a f3596h;

    /* renamed from: i  reason: collision with root package name */
    public Collection<f> f3597i = new LinkedHashSet();

    /* renamed from: j  reason: collision with root package name */
    public c1 f3598j;

    /* renamed from: k  reason: collision with root package name */
    public h0.i f3599k;

    /* renamed from: l  reason: collision with root package name */
    public long f3600l;

    public class a implements Runnable {
        public final /* synthetic */ y1.a b;

        public a(d0 d0Var, y1.a aVar) {
            this.b = aVar;
        }

        public void run() {
            this.b.c(true);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ y1.a b;

        public b(d0 d0Var, y1.a aVar) {
            this.b = aVar;
        }

        public void run() {
            this.b.c(false);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ y1.a b;

        public c(d0 d0Var, y1.a aVar) {
            this.b = aVar;
        }

        public void run() {
            this.b.a();
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ c1 b;

        public d(c1 c1Var) {
            this.b = c1Var;
        }

        public void run() {
            d0.this.f3596h.d(this.b);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ f b;
        public final /* synthetic */ w c;

        public e(d0 d0Var, f fVar, w wVar) {
            this.b = fVar;
            this.c = wVar;
        }

        /* JADX INFO: finally extract failed */
        public void run() {
            f fVar = this.b;
            w wVar = this.c;
            q d2 = fVar.f3602j.d();
            try {
                h0.f fVar2 = fVar.f3601i;
                u g2 = wVar.g(((h2) fVar2).c, ((h2) fVar2).b, ((h2) fVar2).a);
                fVar.f3602j.V(d2);
                fVar.q(g2);
            } catch (Throwable th) {
                fVar.f3602j.V(d2);
                throw th;
            }
        }
    }

    public class f extends e0 {

        /* renamed from: i  reason: collision with root package name */
        public final h0.f f3601i;

        /* renamed from: j  reason: collision with root package name */
        public final q f3602j = q.P();

        public f(h0.f fVar, a aVar) {
            this.f3601i = fVar;
        }

        @Override // h.a.j1.e0, h.a.j1.u
        public void g(c1 c1Var) {
            super.g(c1Var);
            synchronized (d0.this.b) {
                d0 d0Var = d0.this;
                if (d0Var.f3595g != null) {
                    boolean remove = d0Var.f3597i.remove(this);
                    if (!d0.this.h() && remove) {
                        d0 d0Var2 = d0.this;
                        d0Var2.f3592d.b(d0Var2.f3594f);
                        d0 d0Var3 = d0.this;
                        if (d0Var3.f3598j != null) {
                            d0Var3.f3592d.b(d0Var3.f3595g);
                            d0.this.f3595g = null;
                        }
                    }
                }
            }
            d0.this.f3592d.a();
        }
    }

    public d0(Executor executor, g1 g1Var) {
        this.c = executor;
        this.f3592d = g1Var;
    }

    @Override // h.a.j1.y1
    public final void a(c1 c1Var) {
        Collection<f> collection;
        Runnable runnable;
        d(c1Var);
        synchronized (this.b) {
            collection = this.f3597i;
            runnable = this.f3595g;
            this.f3595g = null;
            if (!collection.isEmpty()) {
                this.f3597i = Collections.emptyList();
            }
        }
        if (runnable != null) {
            for (f fVar : collection) {
                fVar.g(c1Var);
            }
            g1 g1Var = this.f3592d;
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(runnable, "runnable is null");
            queue.add(runnable);
            g1Var.a();
        }
    }

    public final f b(h0.f fVar) {
        int size;
        f fVar2 = new f(fVar, null);
        this.f3597i.add(fVar2);
        synchronized (this.b) {
            size = this.f3597i.size();
        }
        if (size == 1) {
            this.f3592d.b(this.f3593e);
        }
        return fVar2;
    }

    @Override // h.a.c0
    public h.a.d0 c() {
        return this.a;
    }

    @Override // h.a.j1.y1
    public final void d(c1 c1Var) {
        Runnable runnable;
        synchronized (this.b) {
            if (this.f3598j == null) {
                this.f3598j = c1Var;
                g1 g1Var = this.f3592d;
                d dVar = new d(c1Var);
                Queue<Runnable> queue = g1Var.c;
                f.b.a.c.b.o.b.A(dVar, "runnable is null");
                queue.add(dVar);
                if (!h() && (runnable = this.f3595g) != null) {
                    this.f3592d.b(runnable);
                    this.f3595g = null;
                }
                this.f3592d.a();
            }
        }
    }

    @Override // h.a.j1.y1
    public final Runnable e(y1.a aVar) {
        this.f3596h = aVar;
        this.f3593e = new a(this, aVar);
        this.f3594f = new b(this, aVar);
        this.f3595g = new c(this, aVar);
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r7 = b(r0);
     */
    @Override // h.a.j1.w
    public final u g(o0<?, ?> o0Var, n0 n0Var, h.a.c cVar) {
        u i0Var;
        try {
            h2 h2Var = new h2(o0Var, n0Var, cVar);
            h0.i iVar = null;
            long j2 = -1;
            while (true) {
                synchronized (this.b) {
                    c1 c1Var = this.f3598j;
                    if (c1Var == null) {
                        h0.i iVar2 = this.f3599k;
                        if (iVar2 != null) {
                            if (iVar != null && j2 == this.f3600l) {
                                break;
                            }
                            j2 = this.f3600l;
                            w e2 = q0.e(iVar2.a(h2Var), cVar.b());
                            if (e2 != null) {
                                i0Var = e2.g(h2Var.c, h2Var.b, h2Var.a);
                                break;
                            }
                            iVar = iVar2;
                        } else {
                            break;
                        }
                    } else {
                        i0Var = new i0(c1Var);
                        break;
                    }
                }
            }
            return i0Var;
        } finally {
            this.f3592d.a();
        }
    }

    public final boolean h() {
        boolean z;
        synchronized (this.b) {
            z = !this.f3597i.isEmpty();
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = new java.util.ArrayList();
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r1.hasNext() == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r2 = (h.a.j1.d0.f) r1.next();
        r3 = r7.a(r2.f3601i);
        r4 = ((h.a.j1.h2) r2.f3601i).a;
        r3 = h.a.j1.q0.e(r3, r4.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        if (r3 == null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r5 = r6.c;
        r4 = r4.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r4 == null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        r5.execute(new h.a.j1.d0.e(r6, r2, r3));
        r0.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        r7 = r6.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0063, code lost:
        if (h() != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        r6.f3597i.removeAll(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0072, code lost:
        if (r6.f3597i.isEmpty() == false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        r6.f3597i = new java.util.LinkedHashSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        if (h() != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0081, code lost:
        r6.f3592d.b(r6.f3594f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
        if (r6.f3598j == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008c, code lost:
        r0 = r6.f3595g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008e, code lost:
        if (r0 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0090, code lost:
        r1 = r6.f3592d.c;
        f.b.a.c.b.o.b.A(r0, "runnable is null");
        r1.add(r0);
        r6.f3595g = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a2, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a3, code lost:
        r6.f3592d.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00aa, code lost:
        throw r0;
     */
    public final void i(h0.i iVar) {
        synchronized (this.b) {
            this.f3599k = iVar;
            this.f3600l++;
            if (iVar != null) {
                if (h()) {
                    ArrayList arrayList = new ArrayList(this.f3597i);
                }
            }
        }
    }
}
