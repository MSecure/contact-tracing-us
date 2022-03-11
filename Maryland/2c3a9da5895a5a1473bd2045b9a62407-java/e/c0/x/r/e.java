package e.c0.x.r;

import androidx.work.impl.foreground.SystemForegroundService;

public class e implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ SystemForegroundService c;

    public e(SystemForegroundService systemForegroundService, int i2) {
        this.c = systemForegroundService;
        this.b = i2;
    }

    public void run() {
        this.c.f322f.cancel(this.b);
    }
}
