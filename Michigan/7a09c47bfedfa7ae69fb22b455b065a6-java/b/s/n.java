package b.s;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class n implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final Executor f2538b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayDeque<Runnable> f2539c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    public Runnable f2540d;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f2541b;

        public a(Runnable runnable) {
            this.f2541b = runnable;
        }

        public void run() {
            try {
                this.f2541b.run();
            } finally {
                n.this.a();
            }
        }
    }

    public n(Executor executor) {
        this.f2538b = executor;
    }

    public synchronized void a() {
        Runnable poll = this.f2539c.poll();
        this.f2540d = poll;
        if (poll != null) {
            this.f2538b.execute(poll);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.f2539c.offer(new a(runnable));
        if (this.f2540d == null) {
            a();
        }
    }
}
