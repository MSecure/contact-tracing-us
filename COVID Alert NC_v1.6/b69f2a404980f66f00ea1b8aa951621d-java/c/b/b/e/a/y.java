package c.b.b.e.a;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class y extends c {

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f3422b;

    public y(ExecutorService executorService) {
        if (executorService != null) {
            this.f3422b = executorService;
            return;
        }
        throw null;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f3422b.awaitTermination(j, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.f3422b.execute(runnable);
    }

    public final boolean isShutdown() {
        return this.f3422b.isShutdown();
    }

    public final boolean isTerminated() {
        return this.f3422b.isTerminated();
    }

    public final void shutdown() {
        this.f3422b.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.f3422b.shutdownNow();
    }
}
