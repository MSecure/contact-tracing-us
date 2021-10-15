package c.b.b.e.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class a0 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ThreadFactory f4707a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f4708b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicLong f4709c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Boolean f4710d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Integer f4711e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Thread.UncaughtExceptionHandler f4712f;

    public a0(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f4707a = threadFactory;
        this.f4708b = str;
        this.f4709c = atomicLong;
        this.f4710d = bool;
        this.f4711e = num;
        this.f4712f = uncaughtExceptionHandler;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f4707a.newThread(runnable);
        String str = this.f4708b;
        if (str != null) {
            newThread.setName(String.format(Locale.ROOT, str, Long.valueOf(this.f4709c.getAndIncrement())));
        }
        Boolean bool = this.f4710d;
        if (bool != null) {
            newThread.setDaemon(bool.booleanValue());
        }
        Integer num = this.f4711e;
        if (num != null) {
            newThread.setPriority(num.intValue());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f4712f;
        if (uncaughtExceptionHandler != null) {
            newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        return newThread;
    }
}
