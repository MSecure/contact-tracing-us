package e.b0.x.t;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class i implements Executor {
    public final ArrayDeque<a> b = new ArrayDeque<>();
    public final Executor c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1132d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile Runnable f1133e;

    public static class a implements Runnable {
        public final i b;
        public final Runnable c;

        public a(i iVar, Runnable runnable) {
            this.b = iVar;
            this.c = runnable;
        }

        public void run() {
            try {
                this.c.run();
            } finally {
                this.b.a();
            }
        }
    }

    public i(Executor executor) {
        this.c = executor;
    }

    public void a() {
        synchronized (this.f1132d) {
            a poll = this.b.poll();
            this.f1133e = poll;
            if (poll != null) {
                this.c.execute(this.f1133e);
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.f1132d) {
            this.b.add(new a(this, runnable));
            if (this.f1133e == null) {
                a();
            }
        }
    }
}
