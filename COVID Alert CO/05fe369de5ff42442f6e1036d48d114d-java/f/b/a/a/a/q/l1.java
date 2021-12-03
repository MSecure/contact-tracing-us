package f.b.a.a.a.q;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.apps.exposurenotification.nearby.SmsVerificationBroadcastReceiver;
import g.b.a.c.c.c;

public abstract class l1 extends BroadcastReceiver {
    public final Object a = new Object();
    public volatile boolean b = false;

    public void onReceive(Context context, Intent intent) {
        if (!this.b) {
            synchronized (this.a) {
                if (!this.b) {
                    ((p1) c.m(context)).c((SmsVerificationBroadcastReceiver) this);
                    this.b = true;
                }
            }
        }
    }
}
