package b.b0.y.q;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;

public class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1206b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Notification f1207c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f1208d;

    public d(SystemForegroundService systemForegroundService, int i, Notification notification) {
        this.f1208d = systemForegroundService;
        this.f1206b = i;
        this.f1207c = notification;
    }

    public void run() {
        this.f1208d.f477f.notify(this.f1206b, this.f1207c);
    }
}
