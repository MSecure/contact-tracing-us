package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import e.z.l;
import e.z.x.t.f;
import e.z.x.t.q.b;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final String a = l.e("ConstrntProxyUpdtRecvr");

    public class a implements Runnable {
        public final /* synthetic */ Intent b;
        public final /* synthetic */ Context c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f303d;

        public a(ConstraintProxyUpdateReceiver constraintProxyUpdateReceiver, Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.b = intent;
            this.c = context;
            this.f303d = pendingResult;
        }

        public void run() {
            try {
                boolean booleanExtra = this.b.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.b.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.b.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.b.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                l.c().a(ConstraintProxyUpdateReceiver.a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                f.a(this.c, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                f.a(this.c, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                f.a(this.c, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                f.a(this.c, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f303d.finish();
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            l.c().a(a, String.format("Ignoring unknown action %s", action), new Throwable[0]);
            return;
        }
        BroadcastReceiver.PendingResult goAsync = goAsync();
        ((b) e.z.x.l.f(context).f1903d).a.execute(new a(this, intent, context, goAsync));
    }
}
