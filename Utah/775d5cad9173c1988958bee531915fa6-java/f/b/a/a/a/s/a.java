package f.b.a.a.a.s;

import android.os.Process;
import android.os.StrictMode;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ StrictMode.ThreadPolicy b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f2344d;

    public /* synthetic */ a(StrictMode.ThreadPolicy threadPolicy, int i2, Runnable runnable) {
        this.b = threadPolicy;
        this.c = i2;
        this.f2344d = runnable;
    }

    public final void run() {
        StrictMode.ThreadPolicy threadPolicy = this.b;
        int i2 = this.c;
        Runnable runnable = this.f2344d;
        StrictMode.setThreadPolicy(threadPolicy);
        Process.setThreadPriority(i2);
        runnable.run();
    }
}
