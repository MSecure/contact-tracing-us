package f.b.a.a.a.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver;
import g.b.a.c.c.c;

public abstract class u extends BroadcastReceiver {
    public final Object a = new Object();
    public volatile boolean b = false;

    public void onReceive(Context context, Intent intent) {
        if (!this.b) {
            synchronized (this.a) {
                if (!this.b) {
                    ((t) c.m(context)).a((ExposureNotificationDismissedReceiver) this);
                    this.b = true;
                }
            }
        }
    }
}
