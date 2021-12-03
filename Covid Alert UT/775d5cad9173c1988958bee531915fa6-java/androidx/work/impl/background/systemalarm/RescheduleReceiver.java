package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import e.b0.a0.l;
import e.b0.a0.p.b.b;
import e.b0.n;
import java.util.Objects;

public class RescheduleReceiver extends BroadcastReceiver {
    public static final String a = n.e("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        n.c().a(a, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                l g2 = l.g(context);
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Objects.requireNonNull(g2);
                synchronized (l.f1026l) {
                    g2.f1032i = goAsync;
                    if (g2.f1031h) {
                        goAsync.finish();
                        g2.f1032i = null;
                    }
                }
            } catch (IllegalStateException e2) {
                n.c().b(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
            }
        } else {
            String str = b.f1057e;
            Intent intent2 = new Intent(context, SystemAlarmService.class);
            intent2.setAction("ACTION_RESCHEDULE");
            context.startService(intent2);
        }
    }
}
