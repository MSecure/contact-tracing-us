package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import e.c0.a0.l;
import e.c0.a0.t.g;
import e.c0.a0.t.t.b;
import e.c0.n;
/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final String a = n.e("ConstrntProxyUpdtRecvr");

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Intent b;
        public final /* synthetic */ Context c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f307d;

        public a(ConstraintProxyUpdateReceiver constraintProxyUpdateReceiver, Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.b = intent;
            this.c = context;
            this.f307d = pendingResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean booleanExtra = this.b.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.b.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.b.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.b.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                n.c().a(ConstraintProxyUpdateReceiver.a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                g.a(this.c, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                g.a(this.c, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                g.a(this.c, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                g.a(this.c, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f307d.finish();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            n.c().a(a, String.format("Ignoring unknown action %s", action), new Throwable[0]);
            return;
        }
        ((b) l.h(context).f1106d).a.execute(new a(this, intent, context, goAsync()));
    }
}
