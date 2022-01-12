package kotlinx.coroutines.scheduling;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;

/* compiled from: Tasks.kt */
public final class TasksKt {
    public static final int CORE_POOL_SIZE;
    public static final long IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(MoreExecutors.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, (Object) null));
    public static final int MAX_POOL_SIZE = MoreExecutors.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", MoreExecutors.coerceIn(SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS * 128, CORE_POOL_SIZE, 2097150), 0, 2097150, 4, (Object) null);
    public static final long WORK_STEALING_TIME_RESOLUTION_NS = MoreExecutors.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, (Object) null);
    public static TimeSource schedulerTimeSource = NanoTimeSource.INSTANCE;

    static {
        MoreExecutors.systemProp$default("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        CORE_POOL_SIZE = MoreExecutors.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", i < 2 ? 2 : i, 1, 0, 8, (Object) null);
    }
}
