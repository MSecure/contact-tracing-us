package b.z.y.p.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import b.z.m;

public class a extends c<Boolean> {
    public static final String i = m.e("BatteryChrgTracker");

    public a(Context context, b.z.y.s.s.a aVar) {
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
        if (intExtra == 2 || intExtra == 5) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // b.z.y.p.f.c
    public IntentFilter f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.CHARGING");
        intentFilter.addAction("android.os.action.DISCHARGING");
        return intentFilter;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        if (r6.equals("android.os.action.CHARGING") != false) goto L_0x0051;
     */
    @Override // b.z.y.p.f.c
    public void g(Context context, Intent intent) {
        Boolean bool;
        String action = intent.getAction();
        if (action != null) {
            boolean z = false;
            m.c().a(i, String.format("Received %s", action), new Throwable[0]);
            switch (action.hashCode()) {
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -54942926:
                    if (action.equals("android.os.action.DISCHARGING")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 948344062:
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (z) {
                if (!z) {
                    if (!z) {
                        if (!z) {
                            return;
                        }
                    }
                }
                bool = Boolean.FALSE;
                c(bool);
            }
            bool = Boolean.TRUE;
            c(bool);
        }
    }
}
