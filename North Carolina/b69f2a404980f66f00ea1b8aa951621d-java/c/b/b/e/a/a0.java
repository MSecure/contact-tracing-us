package c.b.b.e.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class a0 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ThreadFactory f3362a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3363b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicLong f3364c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Boolean f3365d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Integer f3366e;
    public final /* synthetic */ Thread.UncaughtExceptionHandler f;

    public a0(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f3362a = threadFactory;
        this.f3363b = str;
        this.f3364c = atomicLong;
        this.f3365d = bool;
        this.f3366e = num;
        this.f = uncaughtExceptionHandler;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f3362a.newThread(runnable);
        String str = this.f3363b;
        if (str != null) {
            newThread.setName(String.format(Locale.ROOT, str, Long.valueOf(this.f3364c.getAndIncrement())));
        }
        Boolean bool = this.f3365d;
        if (bool != null) {
            newThread.setDaemon(bool.booleanValue());
        }
        Integer num = this.f3366e;
        if (num != null) {
            newThread.setPriority(num.intValue());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f;
        if (uncaughtExceptionHandler != null) {
            newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        return newThread;
    }
}
