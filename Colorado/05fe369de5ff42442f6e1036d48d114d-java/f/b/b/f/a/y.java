package f.b.b.f.a;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class y implements Executor {
    public boolean b = true;
    public final /* synthetic */ Executor c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f3142d;

    public class a implements Runnable {
        public final /* synthetic */ Runnable b;

        public a(Runnable runnable) {
            this.b = runnable;
        }

        public void run() {
            y.this.b = false;
            this.b.run();
        }

        public String toString() {
            return this.b.toString();
        }
    }

    public y(Executor executor, b bVar) {
        this.c = executor;
        this.f3142d = bVar;
    }

    public void execute(Runnable runnable) {
        try {
            this.c.execute(new a(runnable));
        } catch (RejectedExecutionException e2) {
            if (this.b) {
                this.f3142d.u(e2);
            }
        }
    }
}
