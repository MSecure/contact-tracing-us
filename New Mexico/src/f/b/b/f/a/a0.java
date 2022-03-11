package f.b.b.f.a;

import f.b.b.a.v;
import f.b.b.f.a.b;
import f.b.b.f.a.o;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class a0 extends z implements x {
    public final ScheduledExecutorService c;

    /* loaded from: classes.dex */
    public static final class a<V> extends o.a<V> implements v<V> {
        public final ScheduledFuture<?> c;

        public a(u<V> uVar, ScheduledFuture<?> scheduledFuture) {
            super(uVar);
            this.c = scheduledFuture;
        }

        @Override // f.b.b.f.a.n, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            boolean cancel = super.cancel(z);
            if (cancel) {
                this.c.cancel(z);
            }
            return cancel;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.c.compareTo((Delayed) obj);
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return this.c.getDelay(timeUnit);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends b.j<Void> implements Runnable {

        /* renamed from: i  reason: collision with root package name */
        public final Runnable f3428i;

        public b(Runnable runnable) {
            Objects.requireNonNull(runnable);
            this.f3428i = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f3428i.run();
            } catch (Throwable th) {
                u(th);
                v.c(th);
                throw new RuntimeException(th);
            }
        }
    }

    public a0(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.c = scheduledExecutorService;
    }

    @Override // f.b.b.f.a.x, java.util.concurrent.ScheduledExecutorService
    /* renamed from: schedule */
    public <V> v<V> mo17schedule(Callable<V> callable, long j2, TimeUnit timeUnit) {
        d0 d0Var = new d0(callable);
        return new a(d0Var, this.c.schedule(d0Var, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        b bVar = new b(runnable);
        return new a(bVar, this.c.scheduleAtFixedRate(bVar, j2, j3, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        b bVar = new b(runnable);
        return new a(bVar, this.c.scheduleWithFixedDelay(bVar, j2, j3, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        d0 d0Var = new d0(Executors.callable(runnable, null));
        return new a(d0Var, this.c.schedule(d0Var, j2, timeUnit));
    }

    @Override // f.b.b.f.a.x, java.util.concurrent.ScheduledExecutorService
    /* renamed from: schedule  reason: collision with other method in class */
    public ScheduledFuture mo17schedule(Callable callable, long j2, TimeUnit timeUnit) {
        d0 d0Var = new d0(callable);
        return new a(d0Var, this.c.schedule(d0Var, j2, timeUnit));
    }
}
