package f.b.c.k.t;

import f.b.c.k.t.v;

public final /* synthetic */ class x implements Runnable {
    public final v.d b;

    public x(v.d dVar) {
        this.b = dVar;
    }

    public void run() {
        v.d dVar = this.b;
        r rVar = dVar.b;
        v.b bVar = (v.b) rVar.a.g("Collect garbage", new i(rVar, v.this));
        dVar.c = true;
        dVar.a();
    }
}
