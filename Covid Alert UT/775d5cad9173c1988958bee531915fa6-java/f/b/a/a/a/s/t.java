package f.b.a.a.a.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver;
import g.b.a.c.c.d;

public abstract class t extends BroadcastReceiver {
    public volatile boolean a = false;
    public final Object b = new Object();

    public void onReceive(Context context, Intent intent) {
        if (!this.a) {
            synchronized (this.b) {
                if (!this.a) {
                    ((s) d.m(context)).a((ExposureNotificationDismissedReceiver) this);
                    this.a = true;
                }
            }
        }
    }
}
