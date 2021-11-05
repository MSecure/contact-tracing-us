package c.b.a.a.d.k.o;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.widget.ProgressBar;
import b.x.t;
import c.b.a.a.d.a;
import c.b.a.a.d.d;
import c.b.a.a.d.g;
import c.b.a.a.d.m.q;
import com.google.android.gms.common.api.GoogleApiActivity;

public final class z0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final a1 f3066b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ y0 f3067c;

    public z0(y0 y0Var, a1 a1Var) {
        this.f3067c = y0Var;
        this.f3066b = a1Var;
    }

    public final void run() {
        if (this.f3067c.f3061c) {
            a aVar = this.f3066b.f2951b;
            if (aVar.t()) {
                y0 y0Var = this.f3067c;
                j jVar = y0Var.f5986b;
                Activity b2 = y0Var.b();
                PendingIntent pendingIntent = aVar.f2919d;
                t.C(pendingIntent);
                jVar.startActivityForResult(GoogleApiActivity.b(b2, pendingIntent, this.f3066b.f2950a, false), 1);
                return;
            }
            y0 y0Var2 = this.f3067c;
            if (y0Var2.f3064f.a(y0Var2.b(), aVar.f2918c, null) != null) {
                y0 y0Var3 = this.f3067c;
                d dVar = y0Var3.f3064f;
                Activity b3 = y0Var3.b();
                y0 y0Var4 = this.f3067c;
                dVar.h(b3, y0Var4.f5986b, aVar.f2918c, y0Var4);
            } else if (aVar.f2918c == 18) {
                Activity b4 = this.f3067c.b();
                y0 y0Var5 = this.f3067c;
                ProgressBar progressBar = new ProgressBar(b4, null, 16842874);
                progressBar.setIndeterminate(true);
                progressBar.setVisibility(0);
                AlertDialog.Builder builder = new AlertDialog.Builder(b4);
                builder.setView(progressBar);
                builder.setMessage(q.f(b4, 18));
                builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
                AlertDialog create = builder.create();
                d.f(b4, create, "GooglePlayServicesUpdatingDialog", y0Var5);
                y0 y0Var6 = this.f3067c;
                d dVar2 = y0Var6.f3064f;
                Context applicationContext = y0Var6.b().getApplicationContext();
                b1 b1Var = new b1(this, create);
                if (dVar2 != null) {
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addDataScheme("package");
                    b0 b0Var = new b0(b1Var);
                    applicationContext.registerReceiver(b0Var, intentFilter);
                    b0Var.f2955a = applicationContext;
                    if (!g.d(applicationContext, "com.google.android.gms")) {
                        b1Var.f2958b.f3067c.i();
                        if (b1Var.f2957a.isShowing()) {
                            b1Var.f2957a.dismiss();
                        }
                        b0Var.a();
                        return;
                    }
                    return;
                }
                throw null;
            } else {
                y0 y0Var7 = this.f3067c;
                ((f1) y0Var7).h.f(aVar, this.f3066b.f2950a);
            }
        }
    }
}
