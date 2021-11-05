package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b.b0.m;
import b.b0.y.k;

public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f465a = m.e("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        m.c().a(f465a, String.format("Received intent %s", intent), new Throwable[0]);
        try {
            k b2 = k.b(context);
            BroadcastReceiver.PendingResult goAsync = goAsync();
            if (b2 != null) {
                synchronized (k.n) {
                    b2.i = goAsync;
                    if (b2.h) {
                        goAsync.finish();
                        b2.i = null;
                    }
                }
                return;
            }
            throw null;
        } catch (IllegalStateException e2) {
            m.c().b(f465a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
        }
    }
}
