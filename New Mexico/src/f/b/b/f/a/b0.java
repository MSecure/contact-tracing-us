package f.b.b.f.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class b0 implements ThreadFactory {
    public final /* synthetic */ ThreadFactory b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AtomicLong f3441d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Boolean f3442e;

    public b0(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.b = threadFactory;
        this.c = str;
        this.f3441d = atomicLong;
        this.f3442e = bool;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.b.newThread(runnable);
        String str = this.c;
        if (str != null) {
            newThread.setName(String.format(Locale.ROOT, str, Long.valueOf(this.f3441d.getAndIncrement())));
        }
        Boolean bool = this.f3442e;
        if (bool != null) {
            newThread.setDaemon(bool.booleanValue());
        }
        return newThread;
    }
}
