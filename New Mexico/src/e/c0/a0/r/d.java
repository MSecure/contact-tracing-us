package e.c0.a0.r;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;
/* loaded from: classes.dex */
public class d implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Notification c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f1190d;

    public d(SystemForegroundService systemForegroundService, int i2, Notification notification) {
        this.f1190d = systemForegroundService;
        this.b = i2;
        this.c = notification;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1190d.f314f.notify(this.b, this.c);
    }
}
