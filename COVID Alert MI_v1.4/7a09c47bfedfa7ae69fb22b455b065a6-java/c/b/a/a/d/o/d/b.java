package c.b.a.a.d.o.d;

import android.os.Process;

public final class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f3178b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3179c = 0;

    public b(Runnable runnable) {
        this.f3178b = runnable;
    }

    public final void run() {
        Process.setThreadPriority(this.f3179c);
        this.f3178b.run();
    }
}
