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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class d0 implements y1 {
    public final Executor c;

    /* renamed from: d */
    public final g1 f4162d;

    /* renamed from: e */
    public Runnable f4163e;

    /* renamed from: f */
    public Runnable f4164f;

    /* renamed from: g */
    public Runnable f4165g;

    /* renamed from: h */
    public y1.a f4166h;

    /* renamed from: j */
    public c1 f4168j;

    /* renamed from: k */
    public h0.i f4169k;

    /* renamed from: l */
    public long f4170l;
    public final h.a.d0 a = h.a.d0.a(d0.class, null);
    public final Object b = new Object();

    /* renamed from: i */
    public Collection<f> f4167i = new LinkedHashSet();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ y1.a b;

        public a(d0 d0Var, y1.a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c(true);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ y1.a b;

        public b(d0 d0Var, y1.a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c(false);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ y1.a b;

        public c(d0 d0Var, y1.a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a();
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public final /* synthetic */ c1 b;

        public d(c1 c1Var) {
            d0.this = r1;
            this.b = c1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4166h.d(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public final /* synthetic */ f b;
        public final /* synthetic */ w c;

        public e(d0 d0Var, f fVar, w wVar) {
            this.b = fVar;
            this.c = wVar;
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            f fVar = this.b;
            w wVar = this.c;
            q d2 = fVar.f4172j.d();
            try {
                h0.f fVar2 = fVar.f4171i;
                u g2 = wVar.g(((h2) fVar2).c, ((h2) fVar2).b, ((h2) fVar2).a);
                fVar.f4172j.Q(d2);
                fVar.q(g2);
            } catch (Throwable th) {
                fVar.f4172j.Q(d2);
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends e0 {

        /* renamed from: i */
        public final h0.f f4171i;

        /* renamed from: j */
        public final q f4172j = q.L();

        public f(h0.f fVar, a aVar) {
            d0.this = r1;
            this.f4171i = fVar;
        }

        @Override // h.a.j1.e0, h.a.j1.u
        public void g(c1 c1Var) {
            super.g(c1Var);
            synchronized (d0.this.b) {
                d0 d0Var = d0.this;
                if (d0Var.f4165g != null) {
                    boolean remove = d0Var.f4167i.remove(this);
                    if (!d0.this.h() && remove) {
                        d0 d0Var2 = d0.this;
                        d0Var2.f4162d.b(d0Var2.f4164f);
                        d0 d0Var3 = d0.this;
                        if (d0Var3.f4168j != null) {
                            d0Var3.f4162d.b(d0Var3.f4165g);
                            d0.this.f4165g = null;
                        }
                    }
                }
            }
            d0.this.f4162d.a();
        }
    }

    public d0(Executor executor, g1 g1Var) {
        this.c = executor;
        this.f4162d = g1Var;
    }

    @Override // h.a.j1.y1
    public final void a(c1 c1Var) {
        Collection<f> collection;
        Runnable runnable;
        d(c1Var);
        synchronized (this.b) {
            collection = this.f4167i;
            runnable = this.f4165g;
            this.f4165g = null;
            if (!collection.isEmpty()) {
                this.f4167i = Collections.emptyList();
            }
        }
        if (runnable != null) {
            for (f fVar : collection) {
                fVar.g(c1Var);
            }
            g1 g1Var = this.f4162d;
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(runnable, "runnable is null");
            queue.add(runnable);
            g1Var.a();
        }
    }

    public final f b(h0.f fVar) {
        int size;
        f fVar2 = new f(fVar, null);
        this.f4167i.add(fVar2);
        synchronized (this.b) {
            size = this.f4167i.size();
        }
        if (size == 1) {
            this.f4162d.b(this.f4163e);
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
            if (this.f4168j == null) {
                this.f4168j = c1Var;
                g1 g1Var = this.f4162d;
                d dVar = new d(c1Var);
                Queue<Runnable> queue = g1Var.c;
                f.b.a.c.b.o.b.A(dVar, "runnable is null");
                queue.add(dVar);
                if (!h() && (runnable = this.f4165g) != null) {
                    this.f4162d.b(runnable);
                    this.f4165g = null;
                }
                this.f4162d.a();
            }
        }
    }

    @Override // h.a.j1.y1
    public final Runnable e(y1.a aVar) {
        this.f4166h = aVar;
        this.f4163e = new a(this, aVar);
        this.f4164f = new b(this, aVar);
        this.f4165g = new c(this, aVar);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        r7 = b(r0);
     */
    @Override // h.a.j1.w
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final u g(o0<?, ?> o0Var, n0 n0Var, h.a.c cVar) {
        u i0Var;
        try {
            h2 h2Var = new h2(o0Var, n0Var, cVar);
            h0.i iVar = null;
            long j2 = -1;
            while (true) {
                synchronized (this.b) {
                    c1 c1Var = this.f4168j;
                    if (c1Var == null) {
                        h0.i iVar2 = this.f4169k;
                        if (iVar2 == null || (iVar != null && j2 == this.f4170l)) {
                            break;
                        }
                        j2 = this.f4170l;
                        w e2 = q0.e(iVar2.a(h2Var), cVar.b());
                        if (e2 != null) {
                            i0Var = e2.g(h2Var.c, h2Var.b, h2Var.a);
                            break;
                        }
                        iVar = iVar2;
                    } else {
                        i0Var = new i0(c1Var);
                        break;
                    }
                }
            }
            return i0Var;
        } finally {
            this.f4162d.a();
        }
    }

    public final boolean h() {
        boolean z;
        synchronized (this.b) {
            z = !this.f4167i.isEmpty();
        }
        return z;
    }

    public final void i(h0.i iVar) {
        Runnable runnable;
        synchronized (this.b) {
            this.f4169k = iVar;
            this.f4170l++;
            if (iVar != null && h()) {
                ArrayList arrayList = new ArrayList(this.f4167i);
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    h0.e a2 = iVar.a(fVar.f4171i);
                    h.a.c cVar = ((h2) fVar.f4171i).a;
                    w e2 = q0.e(a2, cVar.b());
                    if (e2 != null) {
                        Executor executor = this.c;
                        Executor executor2 = cVar.b;
                        if (executor2 != null) {
                            executor = executor2;
                        }
                        executor.execute(new e(this, fVar, e2));
                        arrayList2.add(fVar);
                    }
                }
                synchronized (this.b) {
                    try {
                        if (h()) {
                            this.f4167i.removeAll(arrayList2);
                            if (this.f4167i.isEmpty()) {
                                this.f4167i = new LinkedHashSet();
                            }
                            if (!h()) {
                                this.f4162d.b(this.f4164f);
                                if (!(this.f4168j == null || (runnable = this.f4165g) == null)) {
                                    Queue<Runnable> queue = this.f4162d.c;
                                    f.b.a.c.b.o.b.A(runnable, "runnable is null");
                                    queue.add(runnable);
                                    this.f4165g = null;
                                }
                            }
                            this.f4162d.a();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }
}
