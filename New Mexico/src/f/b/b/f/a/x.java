package f.b.b.f.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public interface x extends ScheduledExecutorService, w {
    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: schedule */
    <V> v<V> mo17schedule(Callable<V> callable, long j2, TimeUnit timeUnit);
}
