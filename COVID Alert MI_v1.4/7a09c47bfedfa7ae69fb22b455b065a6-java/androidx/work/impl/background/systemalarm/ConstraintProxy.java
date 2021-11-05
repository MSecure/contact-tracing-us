package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b.b0.c;
import b.b0.m;
import b.b0.n;
import b.b0.y.o.b.b;
import b.b0.y.r.p;
import java.util.List;

public abstract class ConstraintProxy extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f460a = m.e("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
    }

    public static class NetworkStateProxy extends ConstraintProxy {
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
    }

    public static void a(Context context, List<p> list) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        for (p pVar : list) {
            c cVar = pVar.j;
            z |= cVar.f1012d;
            z2 |= cVar.f1010b;
            z3 |= cVar.f1013e;
            z4 |= cVar.f1009a != n.NOT_REQUIRED;
            if (z && z2 && z3 && z4) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.a(context, z, z2, z3, z4));
    }

    public void onReceive(Context context, Intent intent) {
        m.c().a(f460a, String.format("onReceive : %s", intent), new Throwable[0]);
        context.startService(b.b(context));
    }
}
