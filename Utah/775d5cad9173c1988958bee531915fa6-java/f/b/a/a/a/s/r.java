package f.b.a.a.a.s;

import android.os.StrictMode;
import f.a.a.a.a;
import f.b.b.f.a.b0;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class r {
    public static final StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    public static final StrictMode.ThreadPolicy b = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    public static ThreadFactory a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        Boolean bool = Boolean.TRUE;
        String w = a.w(str, " #%d");
        String.format(Locale.ROOT, w, 0);
        return new b0(new b(threadPolicy, i2), w, w != null ? new AtomicLong(0) : null, bool, null, null);
    }
}
