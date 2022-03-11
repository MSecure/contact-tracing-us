package e.c0.x.r;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;

public class d implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Notification c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f1132d;

    public d(SystemForegroundService systemForegroundService, int i2, Notification notification) {
        this.f1132d = systemForegroundService;
        this.b = i2;
        this.c = notification;
    }

    public void run() {
        this.f1132d.f322f.notify(this.b, this.c);
    }
}
