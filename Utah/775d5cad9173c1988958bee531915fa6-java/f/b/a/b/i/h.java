package f.b.a.b.i;

import e.b.a.m;
import java.util.concurrent.Executor;

public class h implements Executor {
    public final Executor b;

    public static class a implements Runnable {
        public final Runnable b;

        public a(Runnable runnable) {
            this.b = runnable;
        }

        public void run() {
            try {
                this.b.run();
            } catch (Exception unused) {
                m.e.A0("Executor");
            }
        }
    }

    public h(Executor executor) {
        this.b = executor;
    }

    public void execute(Runnable runnable) {
        this.b.execute(new a(runnable));
    }
}
