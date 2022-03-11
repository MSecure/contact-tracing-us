package f.b.a.a.a.t;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver;
import g.b.a.c.c.d;
/* loaded from: classes.dex */
public abstract class f0 extends BroadcastReceiver {
    public volatile boolean a = false;
    public final Object b = new Object();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!this.a) {
            synchronized (this.b) {
                if (!this.a) {
                    ((e0) d.m(context)).a((ExposureNotificationDismissedReceiver) this);
                    this.a = true;
                }
            }
        }
    }
}
