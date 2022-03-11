package k;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class c extends t {
    public static final long a;
    public static final long b;

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        a = millis;
        b = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void a() {
    }

    public final void b(boolean z) {
        if (c() && z) {
            throw d(null);
        }
    }

    public final boolean c() {
        return false;
    }

    public IOException d(IOException iOException) {
        throw null;
    }
}
