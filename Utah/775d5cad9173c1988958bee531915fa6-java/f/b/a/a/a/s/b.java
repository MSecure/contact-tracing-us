package f.b.a.a.a.s;

import android.os.StrictMode;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class b implements ThreadFactory {
    public final /* synthetic */ StrictMode.ThreadPolicy b;
    public final /* synthetic */ int c;

    public /* synthetic */ b(StrictMode.ThreadPolicy threadPolicy, int i2) {
        this.b = threadPolicy;
        this.c = i2;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(new a(this.b, this.c, runnable));
    }
}
