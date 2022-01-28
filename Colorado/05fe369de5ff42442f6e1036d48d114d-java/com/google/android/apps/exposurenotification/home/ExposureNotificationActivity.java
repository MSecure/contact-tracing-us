package com.google.android.apps.exposurenotification.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.i.v;
import f.b.a.a.a.l.o;
import f.b.a.a.a.m.c1;
import f.b.a.a.a.m.f1;
import f.b.a.a.a.m.j1;
import f.b.a.a.a.m.z0;
import f.b.a.a.a.s.o5;
import f.b.a.a.a.s.y5;
import f.b.a.a.a.x.a;
import f.b.a.a.a.z.p0;
import f.b.b.a.l;

public final class ExposureNotificationActivity extends c1 {
    public final void B(Uri uri) {
        y5 y5Var;
        boolean z;
        l<String> c = v.c(uri);
        if (c.b()) {
            y5Var = new y5();
            Bundle bundle = new Bundle();
            bundle.putString("BaseFragment.CODE_FROM_DEEP_LINK", c.a());
            y5Var.t0(bundle);
        } else {
            if (uri == null) {
                z = false;
            } else {
                z = uri.toString().contains("report");
            }
            if (z) {
                y5Var = new y5();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("BaseFragment.IS_SELF_REPORT_FLOW", true);
                y5Var.t0(bundle2);
            } else {
                y5Var = new y5();
            }
        }
        z(new f1());
        A(y5Var);
    }

    public void launchExposureNotificationsAbout(View view) {
        A(new p0());
    }

    @Override // f.b.a.a.a.m.y0, androidx.activity.ComponentActivity, e.m.a.r, f.b.a.a.a.m.c1, e.i.a.h
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // f.b.a.a.a.m.y0
    public void y(String str, Bundle bundle, Uri uri, boolean z) {
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
                if (((a) exposureNotificationViewModel.f340j.a()).a != 0 || exposureNotificationViewModel.f340j.f()) {
                    ExposureNotificationViewModel exposureNotificationViewModel2 = this.q;
                    exposureNotificationViewModel2.f340j.q(exposureNotificationViewModel2.u.c(), v0.g.CLICKED, exposureNotificationViewModel2.f340j.b());
                    z0Var2 = new o();
                    f1Var = new f1();
                    z(f1Var);
                    A(z0Var2);
                    return;
                }
            }
            if (bundle.getBoolean("IntentUtil.ACTION_SMS_VERIFICATION", false)) {
                B((Uri) bundle.getParcelable("IntentUtil.EXTRA_DEEP_LINK"));
                return;
            } else if (bundle.getBoolean("com.google.android.gms.exposurenotification.EXTRA_IS_FROM_PRE_AUTHORIZATION", false)) {
                z0Var2 = new o5();
                f1Var = new f1();
                z(f1Var);
                A(z0Var2);
                return;
            } else if (z) {
                z0Var = new f1();
            } else {
                z0Var = new j1();
            }
        } else if (!str.equals("android.intent.action.VIEW")) {
            z0Var = new j1();
        } else {
            B(uri);
            return;
        }
        z(z0Var);
    }
}
