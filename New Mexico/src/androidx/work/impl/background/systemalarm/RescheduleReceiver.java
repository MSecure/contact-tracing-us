package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import e.c0.a0.l;
import e.c0.a0.p.b.b;
import e.c0.n;
import java.util.Objects;
/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    public static final String a = n.e("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        n.c().a(a, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                l h2 = l.h(context);
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Objects.requireNonNull(h2);
                synchronized (l.f1105l) {
                    h2.f1111i = goAsync;
                    if (h2.f1110h) {
                        goAsync.finish();
                        h2.f1111i = null;
                    }
                }
            } catch (IllegalStateException e2) {
                n.c().b(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
            }
        } else {
            String str = b.f1136e;
            Intent intent2 = new Intent(context, SystemAlarmService.class);
            intent2.setAction("ACTION_RESCHEDULE");
            context.startService(intent2);
        }
    }
}
