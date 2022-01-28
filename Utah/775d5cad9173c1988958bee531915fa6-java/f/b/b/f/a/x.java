package f.b.b.f.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public interface x extends ScheduledExecutorService, w {
    @Override // java.util.concurrent.ScheduledExecutorService
    <V> v<V> schedule(Callable<V> callable, long j2, TimeUnit timeUnit);
}
