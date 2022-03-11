package com.google.android.apps.exposurenotification.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import f.b.a.a.a.e0.b6;
import f.b.a.a.a.e0.l6;
import f.b.a.a.a.j0.a;
import f.b.a.a.a.l0.o0;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.t.g0;
import f.b.a.a.a.w.o;
import f.b.a.a.a.x.a1;
import f.b.a.a.a.x.d1;
import f.b.a.a.a.x.g1;
import f.b.a.a.a.x.k1;
import f.b.b.a.l;
/* loaded from: classes.dex */
public final class ExposureNotificationActivity extends d1 {
    public final void C(Uri uri) {
        l6 l6Var;
        boolean z;
        l<String> c = g0.c(uri);
        if (c.b()) {
            l6Var = new l6();
            Bundle bundle = new Bundle();
            bundle.putString("BaseFragment.CODE_FROM_DEEP_LINK", c.a());
            l6Var.A0(bundle);
        } else {
            if (uri == null) {
                z = false;
            } else {
                z = uri.toString().contains("report");
            }
            if (z) {
                l6Var = new l6();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("BaseFragment.IS_SELF_REPORT_FLOW", true);
                l6Var.A0(bundle2);
            } else {
                l6Var = new l6();
            }
        }
        A(new g1());
        B(l6Var);
    }

    public void launchExposureNotificationsAbout(View view) {
        B(new o0());
    }

    @Override // f.b.a.a.a.x.z0, e.o.a.r, androidx.activity.ComponentActivity, e.j.a.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // f.b.a.a.a.x.z0
    public void z(String str, Bundle bundle, Uri uri, boolean z) {
        a1 a1Var;
        g1 g1Var;
        a1 a1Var2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (str == null) {
            str = "";
        }
        if (str.equals("android.intent.action.MAIN")) {
            if (bundle.getBoolean("IntentUtil.EXTRA_NOTIFICATION", false)) {
                ExposureNotificationViewModel exposureNotificationViewModel = this.q;
                if (((a) exposureNotificationViewModel.f347j.b()).a != 0 || exposureNotificationViewModel.f347j.g()) {
                    ExposureNotificationViewModel exposureNotificationViewModel2 = this.q;
                    exposureNotificationViewModel2.f347j.u(exposureNotificationViewModel2.u.c(), a1.g.CLICKED, exposureNotificationViewModel2.f347j.c());
                    a1Var2 = new o();
                    g1Var = new g1();
                    A(g1Var);
                    B(a1Var2);
                    return;
                }
            }
            if (bundle.getBoolean("IntentUtil.ACTION_SMS_VERIFICATION", false)) {
                C((Uri) bundle.getParcelable("IntentUtil.EXTRA_DEEP_LINK"));
                return;
            } else if (bundle.getBoolean("com.google.android.gms.exposurenotification.EXTRA_IS_FROM_PRE_AUTHORIZATION", false)) {
                a1Var2 = new b6();
                g1Var = new g1();
                A(g1Var);
                B(a1Var2);
                return;
            } else if (z) {
                a1Var = new g1();
            } else {
                a1Var = new k1();
            }
        } else if (!str.equals("android.intent.action.VIEW")) {
            a1Var = new k1();
        } else {
            C(uri);
            return;
        }
        A(a1Var);
    }
}
