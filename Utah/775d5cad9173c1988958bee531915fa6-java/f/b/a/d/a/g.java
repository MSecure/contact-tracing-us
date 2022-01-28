package f.b.a.d.a;

import android.os.Process;
import android.os.StrictMode;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ StrictMode.ThreadPolicy b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f2802d;

    public /* synthetic */ g(StrictMode.ThreadPolicy threadPolicy, int i2, Runnable runnable) {
        this.b = threadPolicy;
        this.c = i2;
        this.f2802d = runnable;
    }

    public final void run() {
        StrictMode.ThreadPolicy threadPolicy = this.b;
        int i2 = this.c;
        Runnable runnable = this.f2802d;
        StrictMode.setThreadPolicy(threadPolicy);
        Process.setThreadPriority(i2);
        runnable.run();
    }
}
