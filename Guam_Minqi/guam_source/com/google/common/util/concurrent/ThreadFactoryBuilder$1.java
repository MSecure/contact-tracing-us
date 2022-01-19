package com.google.common.util.concurrent;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadFactoryBuilder$1 implements ThreadFactory {
    public final /* synthetic */ ThreadFactory val$backingThreadFactory;
    public final /* synthetic */ AtomicLong val$count;
    public final /* synthetic */ Boolean val$daemon;
    public final /* synthetic */ String val$nameFormat;
    public final /* synthetic */ Integer val$priority;
    public final /* synthetic */ Thread.UncaughtExceptionHandler val$uncaughtExceptionHandler;

    public ThreadFactoryBuilder$1(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.val$backingThreadFactory = threadFactory;
        this.val$nameFormat = str;
        this.val$count = atomicLong;
        this.val$daemon = bool;
        this.val$priority = num;
        this.val$uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.val$backingThreadFactory.newThread(runnable);
        String str = this.val$nameFormat;
        if (str != null) {
            newThread.setName(String.format(Locale.ROOT, str, Long.valueOf(this.val$count.getAndIncrement())));
        }
        Boolean bool = this.val$daemon;
        if (bool != null) {
            newThread.setDaemon(bool.booleanValue());
        }
        Integer num = this.val$priority;
        if (num != null) {
            newThread.setPriority(num.intValue());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.val$uncaughtExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        return newThread;
    }
}
