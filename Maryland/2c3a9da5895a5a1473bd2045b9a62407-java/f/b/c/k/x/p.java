package f.b.c.k.x;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

public class p implements Executor {
    public final Executor b;
    public final Semaphore c;

    public p(int i2, Executor executor) {
        this.c = new Semaphore(i2);
        this.b = executor;
    }

    public void execute(Runnable runnable) {
        if (this.c.tryAcquire()) {
            try {
                this.b.execute(new o(this, runnable));
                return;
            } catch (RejectedExecutionException unused) {
            }
        }
        runnable.run();
    }
}
