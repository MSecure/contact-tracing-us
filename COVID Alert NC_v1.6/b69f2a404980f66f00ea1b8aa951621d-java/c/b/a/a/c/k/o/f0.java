package c.b.a.a.c.k.o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class f0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public Context f2334a;

    /* renamed from: b  reason: collision with root package name */
    public final d1 f2335b;

    public f0(d1 d1Var) {
        this.f2335b = d1Var;
    }

    public final synchronized void a() {
        if (this.f2334a != null) {
            this.f2334a.unregisterReceiver(this);
        }
        this.f2334a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            d1 d1Var = this.f2335b;
            d1Var.f2329b.f2333c.j();
            if (d1Var.f2328a.isShowing()) {
                d1Var.f2328a.dismiss();
            }
            a();
        }
    }
}
