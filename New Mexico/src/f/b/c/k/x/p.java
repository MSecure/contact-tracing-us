package f.b.c.k.x;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
/* loaded from: classes.dex */
public class p implements Executor {
    public final Executor b;
    public final Semaphore c;

    public p(int i2, Executor executor) {
        this.c = new Semaphore(i2);
        this.b = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.c.tryAcquire()) {
            try {
                this.b.execute(new Runnable(this, runnable) { // from class: f.b.c.k.x.o
                    public final p b;
                    public final Runnable c;

                    {
                        this.b = r1;
                        this.c = r2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        p pVar = this.b;
                        this.c.run();
                        pVar.c.release();
                    }
                });
                return;
            } catch (RejectedExecutionException unused) {
            }
        }
        runnable.run();
    }
}
