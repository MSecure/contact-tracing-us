package f.b.c.k.w;

import f.b.c.k.w.b;
import f.b.c.k.x.m;

public final /* synthetic */ class d implements Runnable {
    public final b.c b;
    public final Object c;

    public d(b.c cVar, Object obj) {
        this.b = cVar;
        this.c = obj;
    }

    public void run() {
        b.c cVar = this.b;
        Object obj = this.c;
        m.a(m.a.DEBUG, b.this.getClass().getSimpleName(), "(%x) Stream received: %s", Integer.valueOf(System.identityHashCode(b.this)), obj);
        b.this.f(obj);
    }
}
