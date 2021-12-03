package e.i.a;

import e.i.a.g;

public class d implements Runnable {
    public final /* synthetic */ g.a b;
    public final /* synthetic */ Object c;

    public d(g.a aVar, Object obj) {
        this.b = aVar;
        this.c = obj;
    }

    public void run() {
        this.b.b = this.c;
    }
}
