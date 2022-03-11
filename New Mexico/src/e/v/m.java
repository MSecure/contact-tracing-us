package e.v;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class m implements Executor {
    public final Executor b;
    public final ArrayDeque<Runnable> c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    public Runnable f2094d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Runnable b;

        public a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } finally {
                m.this.a();
            }
        }
    }

    public m(Executor executor) {
        this.b = executor;
    }

    public synchronized void a() {
        Runnable poll = this.c.poll();
        this.f2094d = poll;
        if (poll != null) {
            this.b.execute(poll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.c.offer(new a(runnable));
        if (this.f2094d == null) {
            a();
        }
    }
}
