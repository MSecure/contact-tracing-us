package c.b.b.e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class x implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public boolean f4767b = true;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f4768c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f4769d;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f4770b;

        public a(Runnable runnable) {
            this.f4770b = runnable;
        }

        public void run() {
            x.this.f4767b = false;
            this.f4770b.run();
        }

        public String toString() {
            return this.f4770b.toString();
        }
    }

    public x(Executor executor, b bVar) {
        this.f4768c = executor;
        this.f4769d = bVar;
    }

    public void execute(Runnable runnable) {
        try {
            this.f4768c.execute(new a(runnable));
        } catch (RejectedExecutionException e2) {
            if (this.f4767b) {
                this.f4769d.n(e2);
            }
        }
    }
}
