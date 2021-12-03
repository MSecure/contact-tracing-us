package e.z.x.q.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import e.z.l;
import e.z.x.t.q.a;

public class b extends c<Boolean> {

    /* renamed from: i  reason: collision with root package name */
    public static final String f1964i = l.e("BatteryNotLowTracker");

    public b(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // e.z.x.q.f.d
    public Object a() {
        Intent registerReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver == null) {
            l.c().b(f1964i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        float intExtra2 = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        if (intExtra == 1 || intExtra2 > 0.15f) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // e.z.x.q.f.c
    public IntentFilter f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // e.z.x.q.f.c
    public void g(Context context, Intent intent) {
        Boolean bool;
        if (intent.getAction() != null) {
            l.c().a(f1964i, String.format("Received %s", intent.getAction()), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.BATTERY_OKAY")) {
                bool = Boolean.TRUE;
            } else if (action.equals("android.intent.action.BATTERY_LOW")) {
                bool = Boolean.FALSE;
            } else {
                return;
            }
            c(bool);
        }
    }
}
