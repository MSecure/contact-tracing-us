package e.z.x.r;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;

public class d implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Notification c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f1987d;

    public d(SystemForegroundService systemForegroundService, int i2, Notification notification) {
        this.f1987d = systemForegroundService;
        this.b = i2;
        this.c = notification;
    }

    public void run() {
        this.f1987d.f310f.notify(this.b, this.c);
    }
}
