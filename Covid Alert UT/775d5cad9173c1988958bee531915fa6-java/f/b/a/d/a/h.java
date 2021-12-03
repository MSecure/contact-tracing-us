package f.b.a.d.a;

import android.os.StrictMode;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class h implements ThreadFactory {
    public final /* synthetic */ StrictMode.ThreadPolicy b;
    public final /* synthetic */ int c;

    public /* synthetic */ h(StrictMode.ThreadPolicy threadPolicy, int i2) {
        this.b = threadPolicy;
        this.c = i2;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(new g(this.b, this.c, runnable));
    }
}
