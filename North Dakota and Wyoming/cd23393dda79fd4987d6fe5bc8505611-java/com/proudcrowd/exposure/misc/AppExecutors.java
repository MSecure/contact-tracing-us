package com.proudcrowd.exposure.misc;

import android.os.Process;
import android.os.StrictMode;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class AppExecutors {
    private static final StrictMode.ThreadPolicy BACKGROUND_POLICY = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    private static final StrictMode.ThreadPolicy LIGHTWEIGHT_POLICY = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    private static final int NUM_BACKGROUND_THREADS = 4;
    private static ListeningExecutorService backgroundExecutor;
    private static ListeningExecutorService lightweightExecutor;
    private static ListeningScheduledExecutorService scheduledExecutor;

    private static int backgroundThreadCount() {
        return 4;
    }

    private AppExecutors() {
    }

    public static synchronized ListeningExecutorService getLightweightExecutor() {
        ListeningExecutorService listeningExecutorService;
        synchronized (AppExecutors.class) {
            if (lightweightExecutor == null) {
                lightweightExecutor = createFixed("Lightweight", lightweightThreadCount(), 0, LIGHTWEIGHT_POLICY);
            }
            listeningExecutorService = lightweightExecutor;
        }
        return listeningExecutorService;
    }

    public static synchronized ListeningExecutorService getBackgroundExecutor() {
        ListeningExecutorService listeningExecutorService;
        synchronized (AppExecutors.class) {
            if (backgroundExecutor == null) {
                backgroundExecutor = createFixed("Background", backgroundThreadCount(), 10, BACKGROUND_POLICY);
            }
            listeningExecutorService = backgroundExecutor;
        }
        return listeningExecutorService;
    }

    public static synchronized ListeningScheduledExecutorService getScheduledExecutor() {
        ListeningScheduledExecutorService listeningScheduledExecutorService;
        synchronized (AppExecutors.class) {
            if (scheduledExecutor == null) {
                scheduledExecutor = createScheduled("Scheduled", backgroundThreadCount(), 10, BACKGROUND_POLICY);
            }
            listeningScheduledExecutorService = scheduledExecutor;
        }
        return listeningScheduledExecutorService;
    }

    private static ListeningExecutorService createFixed(String str, int i, int i2, StrictMode.ThreadPolicy threadPolicy) {
        return MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(i, createThreadFactory(str, i2, threadPolicy)));
    }

    private static ListeningScheduledExecutorService createScheduled(String str, int i, int i2, StrictMode.ThreadPolicy threadPolicy) {
        return MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(i, createThreadFactory(str, i2, threadPolicy)));
    }

    private static ThreadFactory createThreadFactory(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        ThreadFactoryBuilder daemon = new ThreadFactoryBuilder().setDaemon(true);
        return daemon.setNameFormat(str + " #%d").setThreadFactory(new ThreadFactory(threadPolicy, i) {
            /* class com.proudcrowd.exposure.misc.$$Lambda$AppExecutors$65I0gu44xqzYyywfxD_pZP4k3v8 */
            public final /* synthetic */ StrictMode.ThreadPolicy f$0;
            public final /* synthetic */ int f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Thread newThread(Runnable runnable) {
                return AppExecutors.lambda$createThreadFactory$1(this.f$0, this.f$1, runnable);
            }
        }).build();
    }

    static /* synthetic */ Thread lambda$createThreadFactory$1(StrictMode.ThreadPolicy threadPolicy, int i, Runnable runnable) {
        return new Thread(new Runnable(threadPolicy, i, runnable) {
            /* class com.proudcrowd.exposure.misc.$$Lambda$AppExecutors$5j2id6koU4UVP5A5l1hmKBmiWic */
            public final /* synthetic */ StrictMode.ThreadPolicy f$0;
            public final /* synthetic */ int f$1;
            public final /* synthetic */ Runnable f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                AppExecutors.lambda$null$0(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    static /* synthetic */ void lambda$null$0(StrictMode.ThreadPolicy threadPolicy, int i, Runnable runnable) {
        StrictMode.setThreadPolicy(threadPolicy);
        Process.setThreadPriority(i);
        runnable.run();
    }

    private static int lightweightThreadCount() {
        return Math.max(2, Runtime.getRuntime().availableProcessors() - 2);
    }
}
