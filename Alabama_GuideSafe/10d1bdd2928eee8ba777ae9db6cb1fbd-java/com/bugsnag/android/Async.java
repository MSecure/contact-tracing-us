package com.bugsnag.android;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Async {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30, TimeUnit.SECONDS, POOL_WORK_QUEUE, THREAD_FACTORY);
    public static final int MAXIMUM_POOL_SIZE = ((CPU_COUNT * 2) + 1);
    public static final BlockingQueue<Runnable> POOL_WORK_QUEUE = new LinkedBlockingQueue(128);
    public static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {
        /* class com.bugsnag.android.Async.AnonymousClass1 */
        public final AtomicInteger count = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Bugsnag Thread #");
            outline17.append(this.count.getAndIncrement());
            return new Thread(runnable, outline17.toString());
        }
    };

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = Math.max(1, Math.min(availableProcessors - 1, 4));
    }
}
