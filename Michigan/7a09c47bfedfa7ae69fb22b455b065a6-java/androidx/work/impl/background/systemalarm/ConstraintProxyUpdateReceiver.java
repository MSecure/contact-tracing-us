package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import b.b0.m;
import b.b0.y.k;
import b.b0.y.s.f;
import b.b0.y.s.s.b;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f461a = m.e("ConstrntProxyUpdtRecvr");

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Intent f462b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f463c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f464d;

        public a(ConstraintProxyUpdateReceiver constraintProxyUpdateReceiver, Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f462b = intent;
            this.f463c = context;
            this.f464d = pendingResult;
        }

        public void run() {
            try {
                boolean booleanExtra = this.f462b.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.f462b.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.f462b.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.f462b.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                m.c().a(ConstraintProxyUpdateReceiver.f461a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                f.a(this.f463c, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                f.a(this.f463c, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                f.a(this.f463c, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                f.a(this.f463c, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f464d.finish();
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
            m.c().a(f461a, String.format("Ignoring unknown action %s", action), new Throwable[0]);
            return;
        }
        BroadcastReceiver.PendingResult goAsync = goAsync();
        ((b) k.b(context).f1097d).f1334a.execute(new a(this, intent, context, goAsync));
    }
}
