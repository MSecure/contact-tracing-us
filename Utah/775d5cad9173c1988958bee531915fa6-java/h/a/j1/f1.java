package h.a.j1;

import h.a.c1;
import java.util.ArrayList;
import java.util.Iterator;

public class f1 implements Runnable {
    public final /* synthetic */ c1 b;
    public final /* synthetic */ z0 c;

    public f1(z0 z0Var, c1 c1Var) {
        this.c = z0Var;
        this.b = c1Var;
    }

    public void run() {
        Iterator it = new ArrayList(this.c.q).iterator();
        while (it.hasNext()) {
            ((y1) it.next()).a(this.b);
        }
    }
}
