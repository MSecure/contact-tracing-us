package f.b.c.k.x;

import f.b.a.c.i.i;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Runnable {
    public final i b;
    public final Callable c;

    public f(i iVar, Callable callable) {
        this.b = iVar;
        this.c = callable;
    }

    public void run() {
        i iVar = this.b;
        try {
            iVar.a.r(this.c.call());
        } catch (Exception e2) {
            iVar.a.q(e2);
            throw new RuntimeException(e2);
        }
    }
}
