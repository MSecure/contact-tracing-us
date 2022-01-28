package c.b.a.a.d.k.o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class b0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public Context f2955a;

    /* renamed from: b  reason: collision with root package name */
    public final b1 f2956b;

    public b0(b1 b1Var) {
        this.f2956b = b1Var;
    }

    public final synchronized void a() {
        if (this.f2955a != null) {
            this.f2955a.unregisterReceiver(this);
        }
        this.f2955a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            b1 b1Var = this.f2956b;
            b1Var.f2958b.f3067c.i();
            if (b1Var.f2957a.isShowing()) {
                b1Var.f2957a.dismiss();
            }
            a();
        }
    }
}
