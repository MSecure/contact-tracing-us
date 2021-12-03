package e.b0.a0.t;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class j implements Executor {
    public final ArrayDeque<a> b = new ArrayDeque<>();
    public final Executor c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1131d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile Runnable f1132e;

    public static class a implements Runnable {
        public final j b;
        public final Runnable c;

        public a(j jVar, Runnable runnable) {
            this.b = jVar;
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

    public j(Executor executor) {
        this.c = executor;
    }

    public void a() {
        synchronized (this.f1131d) {
            a poll = this.b.poll();
            this.f1132e = poll;
            if (poll != null) {
                this.c.execute(this.f1132e);
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.f1131d) {
            this.b.add(new a(this, runnable));
            if (this.f1132e == null) {
                a();
            }
        }
    }
}
