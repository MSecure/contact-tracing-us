package e.c0.a0.t;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class j implements Executor {
    public final Executor c;

    /* renamed from: e  reason: collision with root package name */
    public volatile Runnable f1211e;
    public final ArrayDeque<a> b = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    public final Object f1210d = new Object();

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public final j b;
        public final Runnable c;

        public a(j jVar, Runnable runnable) {
            this.b = jVar;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
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
        synchronized (this.f1210d) {
            a poll = this.b.poll();
            this.f1211e = poll;
            if (poll != null) {
                this.c.execute(this.f1211e);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.f1210d) {
            this.b.add(new a(this, runnable));
            if (this.f1211e == null) {
                a();
            }
        }
    }
}
