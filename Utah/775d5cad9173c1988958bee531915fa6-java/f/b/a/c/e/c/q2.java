package f.b.a.c.e.c;

import f.b.a.c.i.i;
import java.util.concurrent.TimeoutException;

public final /* synthetic */ class q2 implements Runnable {
    public final /* synthetic */ i b;

    public /* synthetic */ q2(i iVar) {
        this.b = iVar;
    }

    public final void run() {
        i iVar = this.b;
        if (!iVar.a.n()) {
            iVar.a(new TimeoutException("Timed out."));
        }
    }
}
