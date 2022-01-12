package org.pathcheck.covidsafepaths.exposurenotifications.common;

import android.os.Process;
import android.os.StrictMode;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder$1;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class AppExecutors {
    public static final StrictMode.ThreadPolicy BACKGROUND_POLICY = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    public static final StrictMode.ThreadPolicy LIGHTWEIGHT_POLICY = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    public static ListeningExecutorService backgroundExecutor;
    public static ListeningExecutorService lightweightExecutor;
    public static ListeningScheduledExecutorService scheduledExecutor;

    public static ListeningExecutorService createFixed(String str, int i, int i2, StrictMode.ThreadPolicy threadPolicy) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i, createThreadFactory(str, i2, threadPolicy));
        if (newFixedThreadPool instanceof ListeningExecutorService) {
            return (ListeningExecutorService) newFixedThreadPool;
        }
        return newFixedThreadPool instanceof ScheduledExecutorService ? new MoreExecutors.ScheduledListeningDecorator((ScheduledExecutorService) newFixedThreadPool) : new MoreExecutors.ListeningDecorator(newFixedThreadPool);
    }

    public static ThreadFactory createThreadFactory(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        Boolean bool = Boolean.TRUE;
        String outline10 = GeneratedOutlineSupport.outline10(str, " #%d");
        String.format(Locale.ROOT, outline10, 0);
        return new ThreadFactoryBuilder$1(new ThreadFactory(threadPolicy, i) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.common.$$Lambda$AppExecutors$P1AojKtcEOYawQckduBXC5udyxE */
            public final /* synthetic */ StrictMode.ThreadPolicy f$0;
            public final /* synthetic */ int f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Thread newThread(Runnable runnable) {
                return AppExecutors.lambda$createThreadFactory$1(this.f$0, this.f$1, runnable);
            }
        }, outline10, outline10 != null ? new AtomicLong(0) : null, bool, null, null);
    }

    public static synchronized ListeningExecutorService getBackgroundExecutor() {
        ListeningExecutorService listeningExecutorService;
        synchronized (AppExecutors.class) {
            if (backgroundExecutor == null) {
                backgroundExecutor = createFixed("Background", 4, 10, BACKGROUND_POLICY);
            }
            listeningExecutorService = backgroundExecutor;
        }
        return listeningExecutorService;
    }

    public static synchronized ListeningExecutorService getLightweightExecutor() {
        ListeningExecutorService listeningExecutorService;
        synchronized (AppExecutors.class) {
            if (lightweightExecutor == null) {
                lightweightExecutor = createFixed("Lightweight", Math.max(2, Runtime.getRuntime().availableProcessors() - 2), 0, LIGHTWEIGHT_POLICY);
            }
            listeningExecutorService = lightweightExecutor;
        }
        return listeningExecutorService;
    }

    public static synchronized ListeningScheduledExecutorService getScheduledExecutor() {
        ListeningScheduledExecutorService listeningScheduledExecutorService;
        synchronized (AppExecutors.class) {
            if (scheduledExecutor == null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4, createThreadFactory("Scheduled", 10, BACKGROUND_POLICY));
                scheduledExecutor = newScheduledThreadPool instanceof ListeningScheduledExecutorService ? (ListeningScheduledExecutorService) newScheduledThreadPool : new MoreExecutors.ScheduledListeningDecorator(newScheduledThreadPool);
            }
            listeningScheduledExecutorService = scheduledExecutor;
        }
        return listeningScheduledExecutorService;
    }

    public static /* synthetic */ Thread lambda$createThreadFactory$1(StrictMode.ThreadPolicy threadPolicy, int i, Runnable runnable) {
        return new Thread(new Runnable(threadPolicy, i, runnable) {
            /* class org.pathcheck.covidsafepaths.exposurenotifications.common.$$Lambda$AppExecutors$EwwGhw36byJRjYAsyUuoEm__HLU */
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

    public static /* synthetic */ void lambda$null$0(StrictMode.ThreadPolicy threadPolicy, int i, Runnable runnable) {
        StrictMode.setThreadPolicy(threadPolicy);
        Process.setThreadPriority(i);
        runnable.run();
    }
}
