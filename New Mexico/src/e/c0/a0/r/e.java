package e.c0.a0.r;

import androidx.work.impl.foreground.SystemForegroundService;
/* loaded from: classes.dex */
public class e implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ SystemForegroundService c;

    public e(SystemForegroundService systemForegroundService, int i2) {
        this.c = systemForegroundService;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.f314f.cancel(this.b);
    }
}
