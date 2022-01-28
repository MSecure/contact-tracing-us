package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import b.z.m;
import b.z.y.k;
import b.z.y.s.f;
import b.z.y.s.s.b;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f327a = m.e("ConstrntProxyUpdtRecvr");

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Intent f328b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f329c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f330d;

        public a(ConstraintProxyUpdateReceiver constraintProxyUpdateReceiver, Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f328b = intent;
            this.f329c = context;
            this.f330d = pendingResult;
        }

        public void run() {
            try {
                boolean booleanExtra = this.f328b.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.f328b.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.f328b.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.f328b.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                m.c().a(ConstraintProxyUpdateReceiver.f327a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                f.a(this.f329c, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                f.a(this.f329c, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                f.a(this.f329c, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                f.a(this.f329c, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f330d.finish();
            }
        }
    }

    public static Intent a(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z4);
        return intent;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            m.c().a(f327a, String.format("Ignoring unknown action %s", action), new Throwable[0]);
            return;
        }
        BroadcastReceiver.PendingResult goAsync = goAsync();
        ((b) k.b(context).f1972d).f2183a.execute(new a(this, intent, context, goAsync));
    }
}
