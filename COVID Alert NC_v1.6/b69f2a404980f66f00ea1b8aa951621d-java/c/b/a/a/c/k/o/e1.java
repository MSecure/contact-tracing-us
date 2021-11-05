package c.b.a.a.c.k.o;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import c.b.a.a.c.a;
import c.b.a.a.c.d;
import c.b.a.a.c.g;
import com.google.android.gms.common.api.GoogleApiActivity;

public final class e1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final b1 f2332b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c1 f2333c;

    public e1(c1 c1Var, b1 b1Var) {
        this.f2333c = c1Var;
        this.f2332b = b1Var;
    }

    public final void run() {
        if (this.f2333c.f2324c) {
            a aVar = this.f2332b.f2318b;
            if (aVar.p()) {
                c1 c1Var = this.f2333c;
                c1Var.f4436b.startActivityForResult(GoogleApiActivity.b(c1Var.b(), aVar.f2282d, this.f2332b.f2317a, false), 1);
                return;
            }
            d dVar = this.f2333c.f;
            int i = aVar.f2281c;
            if (dVar == null) {
                throw null;
            } else if (g.d(i)) {
                c1 c1Var2 = this.f2333c;
                d dVar2 = c1Var2.f;
                Activity b2 = c1Var2.b();
                c1 c1Var3 = this.f2333c;
                dVar2.i(b2, c1Var3.f4436b, aVar.f2281c, c1Var3);
            } else if (aVar.f2281c == 18) {
                Dialog e2 = d.e(this.f2333c.b(), this.f2333c);
                c1 c1Var4 = this.f2333c;
                d dVar3 = c1Var4.f;
                Context applicationContext = c1Var4.b().getApplicationContext();
                d1 d1Var = new d1(this, e2);
                if (dVar3 != null) {
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addDataScheme("package");
                    f0 f0Var = new f0(d1Var);
                    applicationContext.registerReceiver(f0Var, intentFilter);
                    f0Var.f2334a = applicationContext;
                    if (!g.c(applicationContext, "com.google.android.gms")) {
                        d1Var.f2329b.f2333c.j();
                        if (d1Var.f2328a.isShowing()) {
                            d1Var.f2328a.dismiss();
                        }
                        f0Var.a();
                        return;
                    }
                    return;
                }
                throw null;
            } else {
                this.f2333c.i(aVar, this.f2332b.f2317a);
            }
        }
    }
}
