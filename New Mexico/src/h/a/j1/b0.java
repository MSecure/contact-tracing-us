package h.a.j1;

import h.a.q;
/* loaded from: classes.dex */
public abstract class b0 implements Runnable {
    public final q b;

    public b0(q qVar) {
        this.b = qVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        q d2 = this.b.d();
        try {
            a();
        } finally {
            this.b.Q(d2);
        }
    }
}
