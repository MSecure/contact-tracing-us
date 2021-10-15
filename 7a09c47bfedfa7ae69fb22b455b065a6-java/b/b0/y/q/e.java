package b.b0.y.q;

import androidx.work.impl.foreground.SystemForegroundService;

public class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1209b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f1210c;

    public e(SystemForegroundService systemForegroundService, int i) {
        this.f1210c = systemForegroundService;
        this.f1209b = i;
    }

    public void run() {
        this.f1210c.f477f.cancel(this.f1209b);
    }
}
