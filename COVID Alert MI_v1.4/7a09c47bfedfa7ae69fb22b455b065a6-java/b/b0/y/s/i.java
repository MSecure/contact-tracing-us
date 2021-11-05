package b.b0.y.s;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class i implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque<a> f1267b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    public final Executor f1268c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1269d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile Runnable f1270e;

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final i f1271b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f1272c;

        public a(i iVar, Runnable runnable) {
            this.f1271b = iVar;
            this.f1272c = runnable;
        }

        public void run() {
            try {
                this.f1272c.run();
            } finally {
                this.f1271b.a();
            }
        }
    }

    public i(Executor executor) {
        this.f1268c = executor;
    }

    public void a() {
        synchronized (this.f1269d) {
            a poll = this.f1267b.poll();
            this.f1270e = poll;
            if (poll != null) {
                this.f1268c.execute(this.f1270e);
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.f1269d) {
            this.f1267b.add(new a(this, runnable));
            if (this.f1270e == null) {
                a();
            }
        }
    }
}
