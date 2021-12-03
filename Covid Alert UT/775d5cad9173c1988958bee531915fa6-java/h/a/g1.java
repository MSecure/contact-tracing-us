package h.a;

import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class g1 implements Executor {
    public final Thread.UncaughtExceptionHandler b;
    public final Queue<Runnable> c = new ConcurrentLinkedQueue();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Thread> f3852d = new AtomicReference<>();

    public class a implements Runnable {
        public final /* synthetic */ b b;
        public final /* synthetic */ Runnable c;

        public a(b bVar, Runnable runnable) {
            this.b = bVar;
            this.c = runnable;
        }

        public void run() {
            g1.this.execute(this.b);
        }

        public String toString() {
            return this.c.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    public static class b implements Runnable {
        public final Runnable b;
        public boolean c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3854d;

        public b(Runnable runnable) {
            f.b.a.c.b.o.b.z(runnable, "task");
            this.b = runnable;
        }

        public void run() {
            if (!this.c) {
                this.f3854d = true;
                this.b.run();
            }
        }
    }

    public static final class c {
        public final b a;
        public final ScheduledFuture<?> b;

        public c(b bVar, ScheduledFuture scheduledFuture, a aVar) {
            f.b.a.c.b.o.b.z(bVar, "runnable");
            this.a = bVar;
            f.b.a.c.b.o.b.z(scheduledFuture, "future");
            this.b = scheduledFuture;
        }

        public void a() {
            this.a.c = true;
            this.b.cancel(false);
        }
    }

    public g1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        f.b.a.c.b.o.b.z(uncaughtExceptionHandler, "uncaughtExceptionHandler");
        this.b = uncaughtExceptionHandler;
    }

    /* JADX INFO: finally extract failed */
    public final void a() {
        while (this.f3852d.compareAndSet(null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable poll = this.c.poll();
                    if (poll != null) {
                        try {
                            poll.run();
                        } catch (Throwable th) {
                            this.b.uncaughtException(Thread.currentThread(), th);
                        }
                    } else {
                        this.f3852d.set(null);
                        if (this.c.isEmpty()) {
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    this.f3852d.set(null);
                    throw th2;
                }
            }
        }
    }

    public final void b(Runnable runnable) {
        Queue<Runnable> queue = this.c;
        f.b.a.c.b.o.b.z(runnable, "runnable is null");
        queue.add(runnable);
    }

    public final c c(Runnable runnable, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        b bVar = new b(runnable);
        return new c(bVar, scheduledExecutorService.schedule(new a(bVar, runnable), j2, timeUnit), null);
    }

    public void d() {
        f.b.a.c.b.o.b.F(Thread.currentThread() == this.f3852d.get(), "Not called from the SynchronizationContext");
    }

    public final void execute(Runnable runnable) {
        Queue<Runnable> queue = this.c;
        f.b.a.c.b.o.b.z(runnable, "runnable is null");
        queue.add(runnable);
        a();
    }
}
