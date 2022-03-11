package h.a.j1;

import f.b.b.a.k;
import h.a.c1;
import h.a.g1;
import h.a.h0;
import h.a.n;
import h.a.o;
import h.a.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class f2 extends h0 {
    public final h0.d b;
    public h0.h c;

    /* loaded from: classes.dex */
    public class a implements h0.j {
        public final /* synthetic */ h0.h a;

        public a(h0.h hVar) {
            this.a = hVar;
        }

        @Override // h.a.h0.j
        public void a(o oVar) {
            h0.i iVar;
            f2 f2Var = f2.this;
            h0.h hVar = this.a;
            Objects.requireNonNull(f2Var);
            n nVar = oVar.a;
            if (nVar != n.SHUTDOWN) {
                int ordinal = nVar.ordinal();
                if (ordinal == 0) {
                    iVar = new b(h0.e.f4110e);
                } else if (ordinal == 1) {
                    iVar = new b(h0.e.b(hVar));
                } else if (ordinal == 2) {
                    iVar = new b(h0.e.a(oVar.b));
                } else if (ordinal == 3) {
                    iVar = new c(hVar);
                } else {
                    throw new IllegalArgumentException("Unsupported state:" + nVar);
                }
                f2Var.b.d(nVar, iVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends h0.i {
        public final h0.e a;

        public b(h0.e eVar) {
            f.b.a.c.b.o.b.A(eVar, "result");
            this.a = eVar;
        }

        @Override // h.a.h0.i
        public h0.e a(h0.f fVar) {
            return this.a;
        }

        public String toString() {
            k kVar = new k(b.class.getSimpleName(), null);
            kVar.d("result", this.a);
            return kVar.toString();
        }
    }

    /* loaded from: classes.dex */
    public final class c extends h0.i {
        public final h0.h a;
        public final AtomicBoolean b = new AtomicBoolean(false);

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a.d();
            }
        }

        public c(h0.h hVar) {
            f.b.a.c.b.o.b.A(hVar, "subchannel");
            this.a = hVar;
        }

        @Override // h.a.h0.i
        public h0.e a(h0.f fVar) {
            if (this.b.compareAndSet(false, true)) {
                g1 c = f2.this.b.c();
                a aVar = new a();
                Queue<Runnable> queue = c.c;
                f.b.a.c.b.o.b.A(aVar, "runnable is null");
                queue.add(aVar);
                c.a();
            }
            return h0.e.f4110e;
        }
    }

    public f2(h0.d dVar) {
        f.b.a.c.b.o.b.A(dVar, "helper");
        this.b = dVar;
    }

    @Override // h.a.h0
    public void a(c1 c1Var) {
        h0.h hVar = this.c;
        if (hVar != null) {
            hVar.e();
            this.c = null;
        }
        this.b.d(n.TRANSIENT_FAILURE, new b(h0.e.a(c1Var)));
    }

    @Override // h.a.h0
    public void b(h0.g gVar) {
        List<v> list = gVar.a;
        h0.h hVar = this.c;
        if (hVar == null) {
            h0.d dVar = this.b;
            h0.b.a aVar = new h0.b.a();
            f.b.a.c.b.o.b.p(!list.isEmpty(), "addrs is empty");
            List<v> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
            aVar.a = unmodifiableList;
            h0.h a2 = dVar.a(new h0.b(unmodifiableList, aVar.b, aVar.c, null));
            a2.f(new a(a2));
            this.c = a2;
            this.b.d(n.CONNECTING, new b(h0.e.b(a2)));
            a2.d();
            return;
        }
        hVar.g(list);
    }

    @Override // h.a.h0
    public void c() {
        h0.h hVar = this.c;
        if (hVar != null) {
            hVar.d();
        }
    }

    @Override // h.a.h0
    public void d() {
        h0.h hVar = this.c;
        if (hVar != null) {
            hVar.e();
        }
    }
}
