package e.i.f;

import e.i.b.b.h;
import e.i.c.e;

public class b implements Runnable {
    public final /* synthetic */ m b;
    public final /* synthetic */ int c;

    public b(c cVar, m mVar, int i2) {
        this.b = mVar;
        this.c = i2;
    }

    public void run() {
        m mVar = this.b;
        int i2 = this.c;
        h.c cVar = ((e.a) mVar).a;
        if (cVar != null) {
            cVar.d(i2);
        }
    }
}
