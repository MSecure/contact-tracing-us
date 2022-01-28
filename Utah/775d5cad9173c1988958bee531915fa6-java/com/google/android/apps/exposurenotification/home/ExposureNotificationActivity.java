package com.google.android.apps.exposurenotification.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import f.b.a.a.a.d0.n5;
import f.b.a.a.a.d0.x5;
import f.b.a.a.a.h0.a;
import f.b.a.a.a.j0.o0;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.s.u;
import f.b.a.a.a.v.n;
import f.b.a.a.a.w.c1;
import f.b.a.a.a.w.f1;
import f.b.a.a.a.w.j1;
import f.b.a.a.a.w.z0;
import f.b.b.a.l;

public final class ExposureNotificationActivity extends c1 {
    public final void C(Uri uri) {
        x5 x5Var;
        boolean z;
        l<String> c = u.c(uri);
        if (c.b()) {
            x5Var = new x5();
            Bundle bundle = new Bundle();
            bundle.putString("BaseFragment.CODE_FROM_DEEP_LINK", c.a());
            x5Var.y0(bundle);
        } else {
            if (uri == null) {
                z = false;
            } else {
                z = uri.toString().contains("report");
            }
            if (z) {
                x5Var = new x5();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("BaseFragment.IS_SELF_REPORT_FLOW", true);
                x5Var.y0(bundle2);
            } else {
                x5Var = new x5();
            }
        }
        A(new f1());
        B(x5Var);
    }

    public void launchExposureNotificationsAbout(View view) {
        B(new o0());
    }

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.w.y0, e.n.a.r, e.i.a.g
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // f.b.a.a.a.w.y0
    public void z(String str, Bundle bundle, Uri uri, boolean z) {
        z0 z0Var;
        f1 f1Var;
        z0 z0Var2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (str == null) {
            str = "";
        }
        if (str.equals("android.intent.action.MAIN")) {
            if (bundle.getBoolean("IntentUtil.EXTRA_NOTIFICATION", false)) {
                ExposureNotificationViewModel exposureNotificationViewModel = this.q;
                if (((a) exposureNotificationViewModel.f345j.a()).a != 0 || exposureNotificationViewModel.f345j.f()) {
                    ExposureNotificationViewModel exposureNotificationViewModel2 = this.q;
                    exposureNotificationViewModel2.f345j.q(exposureNotificationViewModel2.u.c(), v0.g.CLICKED, exposureNotificationViewModel2.f345j.b());
                    z0Var2 = new n();
                    f1Var = new f1();
                    A(f1Var);
                    B(z0Var2);
                    return;
                }
            }
            if (bundle.getBoolean("IntentUtil.ACTION_SMS_VERIFICATION", false)) {
                C((Uri) bundle.getParcelable("IntentUtil.EXTRA_DEEP_LINK"));
                return;
            } else if (bundle.getBoolean("com.google.android.gms.exposurenotification.EXTRA_IS_FROM_PRE_AUTHORIZATION", false)) {
                z0Var2 = new n5();
                f1Var = new f1();
                A(f1Var);
                B(z0Var2);
                return;
            } else if (z) {
                z0Var = new f1();
            } else {
                z0Var = new j1();
            }
        } else if (!str.equals("android.intent.action.VIEW")) {
            z0Var = new j1();
        } else {
            C(uri);
            return;
        }
        A(z0Var);
    }
}
