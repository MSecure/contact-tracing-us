package f.b.a.a.a.c0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.apps.exposurenotification.nearby.SmsVerificationBroadcastReceiver;
import g.b.a.c.c.d;
/* loaded from: classes.dex */
public abstract class t1 extends BroadcastReceiver {
    public volatile boolean a = false;
    public final Object b = new Object();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!this.a) {
            synchronized (this.b) {
                if (!this.a) {
                    ((v1) d.m(context)).c((SmsVerificationBroadcastReceiver) this);
                    this.a = true;
                }
            }
        }
    }
}
