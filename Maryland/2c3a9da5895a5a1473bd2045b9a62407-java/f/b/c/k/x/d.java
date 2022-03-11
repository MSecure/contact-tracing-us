package f.b.c.k.x;

import f.b.c.k.x.c;

public final /* synthetic */ class d implements Runnable {
    public final c.b b;

    public d(c.b bVar) {
        this.b = bVar;
    }

    public void run() {
        c.b bVar = this.b;
        c.this.d();
        if (bVar.b != null) {
            bVar.b();
            bVar.a.run();
        }
    }
}
