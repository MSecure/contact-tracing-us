package f.b.a.d.a;

import android.os.StrictMode;
import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a0;
import f.b.b.f.a.b0;
import f.b.b.f.a.w;
import f.b.b.f.a.x;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class t {
    public static final StrictMode.ThreadPolicy a;
    public static final StrictMode.ThreadPolicy b;
    public static w c;

    /* renamed from: d  reason: collision with root package name */
    public static w f2829d;

    /* renamed from: e  reason: collision with root package name */
    public static x f2830e;

    static {
        StrictMode.ThreadPolicy build = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
        a = build;
        StrictMode.ThreadPolicy build2 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        b = build2;
        c = b.c1(Executors.newFixedThreadPool(4, a("Background", 10, build2)));
        f2829d = b.c1(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors() - 2), a("Lightweight", 0, build)));
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4, a("Scheduled", 10, build2));
        f2830e = newScheduledThreadPool instanceof x ? (x) newScheduledThreadPool : new a0(newScheduledThreadPool);
    }

    public static ThreadFactory a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        Boolean bool = Boolean.TRUE;
        String w = a.w(str, " #%d");
        String.format(Locale.ROOT, w, 0);
        return new b0(new h(threadPolicy, i2), w, w != null ? new AtomicLong(0) : null, bool, null, null);
    }
}
