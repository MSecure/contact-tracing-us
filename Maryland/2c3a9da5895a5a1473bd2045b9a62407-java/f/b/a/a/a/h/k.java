package f.b.a.a.a.h;

import android.os.StrictMode;
import f.a.a.a.a;
import f.b.b.f.a.a0;
import f.b.b.f.a.b0;
import f.b.b.f.a.w;
import f.b.b.f.a.z;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class k {
    public static final StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    public static final StrictMode.ThreadPolicy b = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    public static w a(String str, int i2, int i3, StrictMode.ThreadPolicy threadPolicy) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i2, b(str, i3, threadPolicy));
        if (newFixedThreadPool instanceof w) {
            return (w) newFixedThreadPool;
        }
        return newFixedThreadPool instanceof ScheduledExecutorService ? new a0((ScheduledExecutorService) newFixedThreadPool) : new z(newFixedThreadPool);
    }

    public static ThreadFactory b(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        Boolean bool = Boolean.TRUE;
        String t = a.t(str, " #%d");
        String.format(Locale.ROOT, t, 0);
        return new b0(new b(threadPolicy, i2), t, t != null ? new AtomicLong(0) : null, bool, null, null);
    }
}
