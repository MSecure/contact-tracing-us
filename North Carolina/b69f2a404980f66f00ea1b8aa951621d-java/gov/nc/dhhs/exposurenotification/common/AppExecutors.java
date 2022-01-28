package gov.nc.dhhs.exposurenotification.common;

import android.os.Process;
import android.os.StrictMode;
import c.b.b.e.a.a0;
import c.b.b.e.a.v;
import c.b.b.e.a.w;
import c.b.b.e.a.y;
import c.b.b.e.a.z;
import d.a.a.a.c.a;
import d.a.a.a.c.b;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class AppExecutors {
    public static final StrictMode.ThreadPolicy BACKGROUND_POLICY = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    public static final StrictMode.ThreadPolicy LIGHTWEIGHT_POLICY = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    public static final int NUM_BACKGROUND_THREADS = 4;
    public static v backgroundExecutor;
    public static v lightweightExecutor;
    public static w scheduledExecutor;

    public static /* synthetic */ Thread a(StrictMode.ThreadPolicy threadPolicy, int i, Runnable runnable) {
        return new Thread(new a(threadPolicy, i, runnable));
    }

    public static /* synthetic */ void b(StrictMode.ThreadPolicy threadPolicy, int i, Runnable runnable) {
        StrictMode.setThreadPolicy(threadPolicy);
        Process.setThreadPriority(i);
        runnable.run();
    }

    public static int backgroundThreadCount() {
        return 4;
    }

    public static v createFixed(String str, int i, int i2, StrictMode.ThreadPolicy threadPolicy) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i, createThreadFactory(str, i2, threadPolicy));
        if (newFixedThreadPool instanceof v) {
            return (v) newFixedThreadPool;
        }
        return newFixedThreadPool instanceof ScheduledExecutorService ? new z((ScheduledExecutorService) newFixedThreadPool) : new y(newFixedThreadPool);
    }

    public static w createScheduled(String str, int i, int i2, StrictMode.ThreadPolicy threadPolicy) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(i, createThreadFactory(str, i2, threadPolicy));
        return newScheduledThreadPool instanceof w ? (w) newScheduledThreadPool : new z(newScheduledThreadPool);
    }

    public static ThreadFactory createThreadFactory(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        Boolean bool = Boolean.TRUE;
        String o = c.a.a.a.a.o(str, " #%d");
        String.format(Locale.ROOT, o, 0);
        return new a0(new b(threadPolicy, i), o, o != null ? new AtomicLong(0) : null, bool, null, null);
    }

    public static synchronized v getBackgroundExecutor() {
        v vVar;
        synchronized (AppExecutors.class) {
            if (backgroundExecutor == null) {
                backgroundExecutor = createFixed("Background", backgroundThreadCount(), 10, BACKGROUND_POLICY);
            }
            vVar = backgroundExecutor;
        }
        return vVar;
    }

    public static synchronized v getLightweightExecutor() {
        v vVar;
        synchronized (AppExecutors.class) {
            if (lightweightExecutor == null) {
                lightweightExecutor = createFixed("Lightweight", lightweightThreadCount(), 0, LIGHTWEIGHT_POLICY);
            }
            vVar = lightweightExecutor;
        }
        return vVar;
    }

    public static synchronized w getScheduledExecutor() {
        w wVar;
        synchronized (AppExecutors.class) {
            if (scheduledExecutor == null) {
                scheduledExecutor = createScheduled("Scheduled", backgroundThreadCount(), 10, BACKGROUND_POLICY);
            }
            wVar = scheduledExecutor;
        }
        return wVar;
    }

    public static int lightweightThreadCount() {
        return Math.max(2, Runtime.getRuntime().availableProcessors() - 2);
    }
}
