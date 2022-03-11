package f.b.b.f.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class a0 implements ThreadFactory {
    public final /* synthetic */ ThreadFactory b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AtomicLong f2920d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Boolean f2921e;

    public a0(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.b = threadFactory;
        this.c = str;
        this.f2920d = atomicLong;
        this.f2921e = bool;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.b.newThread(runnable);
        String str = this.c;
        if (str != null) {
            newThread.setName(String.format(Locale.ROOT, str, Long.valueOf(this.f2920d.getAndIncrement())));
        }
        Boolean bool = this.f2921e;
        if (bool != null) {
            newThread.setDaemon(bool.booleanValue());
        }
        return newThread;
    }
}
