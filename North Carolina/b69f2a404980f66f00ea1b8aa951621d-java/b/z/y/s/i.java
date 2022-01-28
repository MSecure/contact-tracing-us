package b.z.y.s;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class i implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque<a> f2120b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    public final Executor f2121c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f2122d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile Runnable f2123e;

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final i f2124b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f2125c;

        public a(i iVar, Runnable runnable) {
            this.f2124b = iVar;
            this.f2125c = runnable;
        }

        public void run() {
            try {
                this.f2125c.run();
            } finally {
                this.f2124b.a();
            }
        }
    }

    public i(Executor executor) {
        this.f2121c = executor;
    }

    public void a() {
        synchronized (this.f2122d) {
            a poll = this.f2120b.poll();
            this.f2123e = poll;
            if (poll != null) {
                this.f2121c.execute(this.f2123e);
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.f2122d) {
            this.f2120b.add(new a(this, runnable));
            if (this.f2123e == null) {
                a();
            }
        }
    }
}
