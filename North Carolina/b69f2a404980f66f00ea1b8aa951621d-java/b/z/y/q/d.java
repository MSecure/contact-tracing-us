package b.z.y.q;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;

public class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2063b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Notification f2064c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f2065d;

    public d(SystemForegroundService systemForegroundService, int i, Notification notification) {
        this.f2065d = systemForegroundService;
        this.f2063b = i;
        this.f2064c = notification;
    }

    public void run() {
        this.f2065d.f.notify(this.f2063b, this.f2064c);
    }
}
