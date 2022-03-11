package f.b.b.f.a;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes.dex */
public final class y implements Executor {
    public boolean b = true;
    public final /* synthetic */ Executor c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f3460d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Runnable b;

        public a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.b = false;
            this.b.run();
        }

        @Override // java.lang.Object
        public String toString() {
            return this.b.toString();
        }
    }

    public y(Executor executor, b bVar) {
        this.c = executor;
        this.f3460d = bVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        try {
            this.c.execute(new a(runnable));
        } catch (RejectedExecutionException e2) {
            if (this.b) {
                this.f3460d.u(e2);
            }
        }
    }
}
