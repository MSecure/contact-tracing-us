package e.c0.x.t;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class i implements Executor {
    public final ArrayDeque<a> b = new ArrayDeque<>();
    public final Executor c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1152d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile Runnable f1153e;

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
        synchronized (this.f1152d) {
            a poll = this.b.poll();
            this.f1153e = poll;
            if (poll != null) {
                this.c.execute(this.f1153e);
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.f1152d) {
            this.b.add(new a(this, runnable));
            if (this.f1153e == null) {
                a();
            }
        }
    }
}
