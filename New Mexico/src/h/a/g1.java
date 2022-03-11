package h.a;

import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class g1 implements Executor {
    public final Thread.UncaughtExceptionHandler b;
    public final Queue<Runnable> c = new ConcurrentLinkedQueue();

    /* renamed from: d */
    public final AtomicReference<Thread> f4107d = new AtomicReference<>();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ b b;
        public final /* synthetic */ Runnable c;

        public a(b bVar, Runnable runnable) {
            g1.this = r1;
            this.b = bVar;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.this.execute(this.b);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.c.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public final Runnable b;
        public boolean c;

        /* renamed from: d */
        public boolean f4109d;

        public b(Runnable runnable) {
            f.b.a.c.b.o.b.A(runnable, "task");
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.c) {
                this.f4109d = true;
                this.b.run();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public final b a;
        public final ScheduledFuture<?> b;

        public c(b bVar, ScheduledFuture scheduledFuture, a aVar) {
            f.b.a.c.b.o.b.A(bVar, "runnable");
            this.a = bVar;
            f.b.a.c.b.o.b.A(scheduledFuture, "future");
            this.b = scheduledFuture;
        }

        public void a() {
            this.a.c = true;
            this.b.cancel(false);
        }
    }

    public g1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        f.b.a.c.b.o.b.A(uncaughtExceptionHandler, "uncaughtExceptionHandler");
        this.b = uncaughtExceptionHandler;
    }

    /* JADX WARN: Finally extract failed */
    public final void a() {
        while (this.f4107d.compareAndSet(null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable poll = this.c.poll();
                    if (poll != null) {
                        poll.run();
                    } else {
                        this.f4107d.set(null);
                        if (this.c.isEmpty()) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    this.f4107d.set(null);
                    throw th;
                }
            }
        }
    }

    public final void b(Runnable runnable) {
        Queue<Runnable> queue = this.c;
        f.b.a.c.b.o.b.A(runnable, "runnable is null");
        queue.add(runnable);
    }

    public final c c(Runnable runnable, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        b bVar = new b(runnable);
        return new c(bVar, scheduledExecutorService.schedule(new a(bVar, runnable), j2, timeUnit), null);
    }

    public void d() {
        f.b.a.c.b.o.b.G(Thread.currentThread() == this.f4107d.get(), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Queue<Runnable> queue = this.c;
        f.b.a.c.b.o.b.A(runnable, "runnable is null");
        queue.add(runnable);
        a();
    }
}
