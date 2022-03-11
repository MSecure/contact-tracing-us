package h.a.j1;

import h.a.j1.t2;

public class u2 implements Runnable {
    public final /* synthetic */ t2.b b;
    public final /* synthetic */ t2.c c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f3859d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ t2 f3860e;

    public u2(t2 t2Var, t2.b bVar, t2.c cVar, Object obj) {
        this.f3860e = t2Var;
        this.b = bVar;
        this.c = cVar;
        this.f3859d = obj;
    }

    public void run() {
        synchronized (this.f3860e) {
            if (this.b.b == 0) {
                try {
                    this.c.b(this.f3859d);
                } finally {
                    this.f3860e.a.remove(this.c);
                    if (this.f3860e.a.isEmpty()) {
                        this.f3860e.c.shutdown();
                        this.f3860e.c = null;
                    }
                }
            }
        }
    }
}
