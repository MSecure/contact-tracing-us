package e.c0.x.q.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import e.c0.l;

public class a extends c<Boolean> {

    /* renamed from: i  reason: collision with root package name */
    public static final String f1108i = l.e("BatteryChrgTracker");

    public a(Context context, e.c0.x.t.q.a aVar) {
        super(context, aVar);
    }

    @Override // e.c0.x.q.f.d
    public Object a() {
        int intExtra;
        Intent registerReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver == null) {
            l.c().b(f1108i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        if (Build.VERSION.SDK_INT < 23 ? registerReceiver.getIntExtra("plugged", 0) != 0 : (intExtra = registerReceiver.getIntExtra("status", -1)) == 2 || intExtra == 5) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // e.c0.x.q.f.c
    public IntentFilter f() {
        String str;
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            str = "android.os.action.DISCHARGING";
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            str = "android.intent.action.ACTION_POWER_DISCONNECTED";
        }
        intentFilter.addAction(str);
        return intentFilter;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r9.equals("android.intent.action.ACTION_POWER_DISCONNECTED") == false) goto L_0x0055;
     */
    @Override // e.c0.x.q.f.c
    public void g(Context context, Intent intent) {
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = Boolean.TRUE;
        String action = intent.getAction();
        if (action != null) {
            char c = 0;
            l.c().a(f1108i, String.format("Received %s", action), new Throwable[0]);
            switch (action.hashCode()) {
                case -1886648615:
                    break;
                case -54942926:
                    if (action.equals("android.os.action.DISCHARGING")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 948344062:
                    if (action.equals("android.os.action.CHARGING")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0 || c == 1) {
                c(bool);
            } else if (c == 2 || c == 3) {
                c(bool2);
            }
        }
    }
}
