package f.b.a.c.e.c;

import f.b.a.c.i.i;
import java.util.concurrent.TimeoutException;

public final /* synthetic */ class i2 implements Runnable {
    public final i b;

    public i2(i iVar) {
        this.b = iVar;
    }

    public final void run() {
        i iVar = this.b;
        if (!iVar.a.m()) {
            iVar.a(new TimeoutException("Timed out."));
        }
    }
}
