package com.google.android.apps.exposurenotification.notify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.m.a.c0;
import e.m.a.l;
import e.p.b0;
import f.b.a.a.a.p.n;
import f.b.a.a.a.p.o;
import f.b.a.a.a.p.p;
import f.b.a.a.a.p.q;
import f.b.a.a.a.p.w2;
import f.b.a.d.m.b;
import gov.wi.covid19.exposurenotifications.R;

public class ShareDiagnosisActivity extends w2 {
    public static final /* synthetic */ int t = 0;
    public ShareDiagnosisViewModel r;
    public ExposureNotificationViewModel s;

    public static void w(Activity activity, ShareDiagnosisViewModel shareDiagnosisViewModel) {
        shareDiagnosisViewModel.x = true;
        b bVar = new b(activity);
        bVar.f(R.string.share_close_title);
        bVar.c(R.string.share_close_detail);
        bVar.e(R.string.btn_resume_later, new p(activity));
        bVar.d(R.string.btn_cancel, new n(shareDiagnosisViewModel));
        bVar.a.f27l = new o(shareDiagnosisViewModel);
        bVar.b();
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.o
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        l I = n().I(R.id.share_exposure_fragment);
        if (I != null) {
            I.I(i2, i3, intent);
        }
        if (i2 == 1111) {
            if (i3 == -1) {
                this.s.g();
            } else {
                this.s.f();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        boolean z;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.r;
        shareDiagnosisViewModel.t.pop();
        if (shareDiagnosisViewModel.t.isEmpty()) {
            z = false;
        } else {
            shareDiagnosisViewModel.s.j(shareDiagnosisViewModel.t.peek());
            z = true;
        }
        if (!z) {
            this.f5h.b();
        }
    }

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.p.w2, e.m.a.o, e.i.a.f
    public void onCreate(Bundle bundle) {
        ShareDiagnosisViewModel shareDiagnosisViewModel;
        ShareDiagnosisViewModel.e eVar;
        super.onCreate(bundle);
        setContentView(R.layout.activity_share_diagnosis);
        ExposureNotificationViewModel exposureNotificationViewModel = (ExposureNotificationViewModel) new b0(this).a(ExposureNotificationViewModel.class);
        this.s = exposureNotificationViewModel;
        exposureNotificationViewModel.f336i.f(this, new q(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel2 = (ShareDiagnosisViewModel) new b0(this).a(ShareDiagnosisViewModel.class);
        this.r = shareDiagnosisViewModel2;
        if (shareDiagnosisViewModel2.x) {
            w(this, shareDiagnosisViewModel2);
        }
        if (bundle == null) {
            if (getIntent().hasExtra("ShareExposureActivity.EXTRA_VIEW_POSITIVE_DIAGNOSIS_ID")) {
                this.r.f375h.l(Long.valueOf(getIntent().getLongExtra("ShareExposureActivity.EXTRA_VIEW_POSITIVE_DIAGNOSIS_ID", -1)));
                shareDiagnosisViewModel = this.r;
                eVar = ShareDiagnosisViewModel.e.valueOf(getIntent().getStringExtra("ShareExposureActivity.EXTRA_STEP"));
            } else {
                shareDiagnosisViewModel = this.r;
                eVar = ShareDiagnosisViewModel.e.BEGIN;
            }
            shareDiagnosisViewModel.g(eVar);
        }
        c0.L = false;
        m.h.R(this.r.s).f(this, new f.b.a.a.a.p.m(this));
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.o
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // e.b.a.j
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getWindow().getDecorView().sendAccessibilityEvent(32);
    }
}
