package f.b.c.k.w;

import f.b.a.c.b.o.b;

public final /* synthetic */ class a implements Runnable {
    public final b b;

    public a(b bVar) {
        this.b = bVar;
    }

    public void run() {
        b bVar = this.b;
        m0 m0Var = bVar.f3124g;
        b.a1(m0Var == m0.Backoff, "State should still be backoff but was %s", m0Var);
        bVar.f3124g = m0.Initial;
        bVar.g();
        b.a1(bVar.d(), "Stream should have started", new Object[0]);
    }
}
