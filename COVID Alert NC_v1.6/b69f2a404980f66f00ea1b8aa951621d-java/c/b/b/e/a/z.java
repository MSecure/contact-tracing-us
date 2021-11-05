package c.b.b.e.a;

import c.b.b.e.a.b;
import c.b.b.e.a.o;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class z extends y implements w {

    /* renamed from: c  reason: collision with root package name */
    public final ScheduledExecutorService f3423c;

    public static final class a<V> extends o.a<V> implements Object<V>, u {

        /* renamed from: c  reason: collision with root package name */
        public final ScheduledFuture<?> f3424c;

        public a(u<V> uVar, ScheduledFuture<?> scheduledFuture) {
            super(uVar);
            this.f3424c = scheduledFuture;
        }

        @Override // c.b.b.e.a.n
        public boolean cancel(boolean z) {
            boolean cancel = super.cancel(z);
            if (cancel) {
                this.f3424c.cancel(z);
            }
            return cancel;
        }

        public int compareTo(Object obj) {
            return this.f3424c.compareTo((Delayed) obj);
        }

        public long getDelay(TimeUnit timeUnit) {
            return this.f3424c.getDelay(timeUnit);
        }
    }

    public static final class b extends b.j<Void> implements Runnable {
        public final Runnable i;

        public b(Runnable runnable) {
            if (runnable != null) {
                this.i = runnable;
                return;
            }
            throw null;
        }

        public void run() {
            try {
                this.i.run();
            } catch (Throwable th) {
                n(th);
                c.b.b.a.o.c(th);
                throw new RuntimeException(th);
            }
        }
    }

    public z(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f3423c = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        c0 c0Var = new c0(Executors.callable(runnable, null));
        return new a(c0Var, this.f3423c.schedule(c0Var, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        b bVar = new b(runnable);
        return new a(bVar, this.f3423c.scheduleAtFixedRate(bVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        b bVar = new b(runnable);
        return new a(bVar, this.f3423c.scheduleWithFixedDelay(bVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        c0 c0Var = new c0(callable);
        return new a(c0Var, this.f3423c.schedule(c0Var, j, timeUnit));
    }
}
