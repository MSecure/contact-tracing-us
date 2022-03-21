package f.b.c.k.x;

import java.util.Date;

public final /* synthetic */ class k implements Runnable {
    public final l b;
    public final Runnable c;

    public k(l lVar, Runnable runnable) {
        this.b = lVar;
        this.c = runnable;
    }

    public void run() {
        l lVar = this.b;
        Runnable runnable = this.c;
        lVar.f3193g = new Date().getTime();
        runnable.run();
    }
}
