package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import e.z.l;
import e.z.x.p.b.b;
import java.util.Objects;

public class RescheduleReceiver extends BroadcastReceiver {
    public static final String a = l.e("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        l.c().a(a, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                e.z.x.l f2 = e.z.x.l.f(context);
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Objects.requireNonNull(f2);
                synchronized (e.z.x.l.n) {
                    f2.f1908i = goAsync;
                    if (f2.f1907h) {
                        goAsync.finish();
                        f2.f1908i = null;
                    }
                }
            } catch (IllegalStateException e2) {
                l.c().b(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
            }
        } else {
            String str = b.f1933e;
            Intent intent2 = new Intent(context, SystemAlarmService.class);
            intent2.setAction("ACTION_RESCHEDULE");
            context.startService(intent2);
        }
    }
}
