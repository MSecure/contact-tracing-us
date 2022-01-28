package b.z.y.q;

import androidx.work.impl.foreground.SystemForegroundService;

public class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2066b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f2067c;

    public e(SystemForegroundService systemForegroundService, int i) {
        this.f2067c = systemForegroundService;
        this.f2066b = i;
    }

    public void run() {
        this.f2067c.f.cancel(this.f2066b);
    }
}
