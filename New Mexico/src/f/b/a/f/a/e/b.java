package f.b.a.f.a.e;

import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public abstract class b implements Runnable {
    public final n<?> b;

    public b() {
        this.b = null;
    }

    public b(n<?> nVar) {
        this.b = nVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e2) {
            n<?> nVar = this.b;
            if (nVar != null) {
                nVar.a(e2);
            }
        }
    }
}
