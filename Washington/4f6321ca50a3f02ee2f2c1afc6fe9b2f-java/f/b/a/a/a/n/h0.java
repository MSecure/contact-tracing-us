package f.b.a.a.a.n;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.apps.exposurenotification.nearby.ExposureNotificationBroadcastReceiver;
import f.b.a.c.b.o.b;

public abstract class h0 extends BroadcastReceiver {
    public final Object a = new Object();
    public volatile boolean b = false;

    public void onReceive(Context context, Intent intent) {
        if (!this.b) {
            synchronized (this.a) {
                if (!this.b) {
                    ((e0) b.G0(context)).b((ExposureNotificationBroadcastReceiver) this);
                    this.b = true;
                }
            }
        }
    }
}
