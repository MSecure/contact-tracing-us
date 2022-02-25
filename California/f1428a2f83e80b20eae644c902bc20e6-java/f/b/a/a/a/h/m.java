package f.b.a.a.a.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver;
import f.b.a.c.b.o.b;

public abstract class m extends BroadcastReceiver {
    public final Object a = new Object();
    public volatile boolean b = false;

    public void onReceive(Context context, Intent intent) {
        if (!this.b) {
            synchronized (this.a) {
                if (!this.b) {
                    ((l) b.G0(context)).a((ExposureNotificationDismissedReceiver) this);
                    this.b = true;
                }
            }
        }
    }
}
