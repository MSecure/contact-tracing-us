package b.r;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class n implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final Executor f1668b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayDeque<Runnable> f1669c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    public Runnable f1670d;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f1671b;

        public a(Runnable runnable) {
            this.f1671b = runnable;
        }

        public void run() {
            try {
                this.f1671b.run();
            } finally {
                n.this.a();
            }
        }
    }

    public n(Executor executor) {
        this.f1668b = executor;
    }

    public synchronized void a() {
        Runnable poll = this.f1669c.poll();
        this.f1670d = poll;
        if (poll != null) {
            this.f1668b.execute(poll);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.f1669c.offer(new a(runnable));
        if (this.f1670d == null) {
            a();
        }
    }
}
