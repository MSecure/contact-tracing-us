package f.b.a.b.i;

import e.b.a.m;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class h implements Executor {
    public final Executor b;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public final Runnable b;

        public a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Exception unused) {
                m.e.C0("Executor");
            }
        }
    }

    public h(Executor executor) {
        this.b = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.b.execute(new a(runnable));
    }
}
