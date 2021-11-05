package c.b.b.e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class x implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public boolean f3417b = true;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f3418c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f3419d;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f3420b;

        public a(Runnable runnable) {
            this.f3420b = runnable;
        }

        public void run() {
            x.this.f3417b = false;
            this.f3420b.run();
        }

        public String toString() {
            return this.f3420b.toString();
        }
    }

    public x(Executor executor, b bVar) {
        this.f3418c = executor;
        this.f3419d = bVar;
    }

    public void execute(Runnable runnable) {
        try {
            this.f3418c.execute(new a(runnable));
        } catch (RejectedExecutionException e2) {
            if (this.f3417b) {
                this.f3419d.n(e2);
            }
        }
    }
}
