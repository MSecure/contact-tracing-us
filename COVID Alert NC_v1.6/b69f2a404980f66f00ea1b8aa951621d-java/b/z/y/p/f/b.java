package b.z.y.p.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import b.z.m;
import b.z.y.s.s.a;

public class b extends c<Boolean> {
    public static final String i = m.e("BatteryNotLowTracker");

    public b(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // b.z.y.p.f.d
    public Object a() {
        Intent registerReceiver = this.f2043b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver == null) {
            m.c().b(i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        float intExtra2 = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        if (intExtra == 1 || intExtra2 > 0.15f) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // b.z.y.p.f.c
    public IntentFilter f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        if (r6.equals("android.intent.action.BATTERY_OKAY") != false) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    @Override // b.z.y.p.f.c
    public void g(Context context, Intent intent) {
        Boolean bool;
        if (intent.getAction() != null) {
            boolean z = false;
            m.c().a(i, String.format("Received %s", intent.getAction()), new Throwable[0]);
            String action = intent.getAction();
            int hashCode = action.hashCode();
            if (hashCode != -1980154005) {
                if (hashCode == 490310653 && action.equals("android.intent.action.BATTERY_LOW")) {
                    z = true;
                    if (z) {
                        bool = Boolean.TRUE;
                    } else if (z) {
                        bool = Boolean.FALSE;
                    } else {
                        return;
                    }
                    c(bool);
                }
            }
            z = true;
            if (z) {
            }
            c(bool);
        }
    }
}
