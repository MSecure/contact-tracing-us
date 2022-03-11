package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import e.c0.l;
import e.c0.x.p.b.b;
import java.util.Objects;

public class RescheduleReceiver extends BroadcastReceiver {
    public static final String a = l.e("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        l.c().a(a, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                e.c0.x.l d2 = e.c0.x.l.d(context);
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Objects.requireNonNull(d2);
                synchronized (e.c0.x.l.n) {
                    d2.f1053i = goAsync;
                    if (d2.f1052h) {
                        goAsync.finish();
                        d2.f1053i = null;
                    }
                }
            } catch (IllegalStateException e2) {
                l.c().b(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
            }
        } else {
            String str = b.f1078e;
            Intent intent2 = new Intent(context, SystemAlarmService.class);
            intent2.setAction("ACTION_RESCHEDULE");
            context.startService(intent2);
        }
    }
}
