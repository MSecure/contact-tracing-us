package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import e.b0.a0.p.b.b;
import e.b0.n;

public abstract class ConstraintProxy extends BroadcastReceiver {
    public static final String a = n.e("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
    }

    public static class NetworkStateProxy extends ConstraintProxy {
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
    }

    public void onReceive(Context context, Intent intent) {
        n.c().a(a, String.format("onReceive : %s", intent), new Throwable[0]);
        context.startService(b.b(context));
    }
}
