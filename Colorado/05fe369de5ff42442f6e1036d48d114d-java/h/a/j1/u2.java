package h.a.j1;

import h.a.j1.t2;

public class u2 implements Runnable {
    public final /* synthetic */ t2.b b;
    public final /* synthetic */ t2.c c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f4013d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ t2 f4014e;

    public u2(t2 t2Var, t2.b bVar, t2.c cVar, Object obj) {
        this.f4014e = t2Var;
        this.b = bVar;
        this.c = cVar;
        this.f4013d = obj;
    }

    public void run() {
        synchronized (this.f4014e) {
            if (this.b.b == 0) {
                try {
                    this.c.b(this.f4013d);
                } finally {
                    this.f4014e.a.remove(this.c);
                    if (this.f4014e.a.isEmpty()) {
                        this.f4014e.c.shutdown();
                        this.f4014e.c = null;
                    }
                }
            }
        }
    }
}
