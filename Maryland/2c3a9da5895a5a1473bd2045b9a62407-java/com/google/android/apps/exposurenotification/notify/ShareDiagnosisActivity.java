package com.google.android.apps.exposurenotification.notify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.m.a.a;
import e.m.a.f0;
import e.p.b0;
import f.b.a.a.a.i.g;
import f.b.a.a.a.j.j;
import f.b.a.a.a.r.h3;
import f.b.a.a.a.r.l;
import f.b.a.a.a.r.n;
import f.b.a.a.a.r.o;
import f.b.a.a.a.r.p;
import f.b.a.d.m.b;
import gov.md.covid19.exposurenotifications.R;
import java.util.HashSet;

public class ShareDiagnosisActivity extends h3 {
    public static final /* synthetic */ int v = 0;
    public g s;
    public ShareDiagnosisViewModel t;
    public ExposureNotificationViewModel u;

    public static void x(Activity activity, ShareDiagnosisViewModel shareDiagnosisViewModel) {
        shareDiagnosisViewModel.z = true;
        b bVar = new b(activity);
        bVar.f(R.string.share_close_title);
        bVar.c(R.string.share_close_detail);
        bVar.e(R.string.btn_resume_later, new p(activity));
        bVar.d(R.string.btn_cancel, new l(shareDiagnosisViewModel));
        bVar.a.f35l = new n(shareDiagnosisViewModel);
        bVar.b();
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.r
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        e.m.a.l I = o().I(R.id.share_exposure_fragment);
        if (I != null) {
            I.I(i2, i3, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        boolean z;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.t;
        shareDiagnosisViewModel.v.pop();
        if (shareDiagnosisViewModel.v.isEmpty()) {
            z = false;
        } else {
            shareDiagnosisViewModel.u.j(shareDiagnosisViewModel.v.peek());
            z = true;
        }
        if (!z) {
            this.f5h.b();
        }
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.r, f.b.a.a.a.r.h3, e.i.a.h
    public void onCreate(Bundle bundle) {
        ShareDiagnosisViewModel shareDiagnosisViewModel;
        ShareDiagnosisViewModel.d dVar;
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.activity_share_diagnosis, (ViewGroup) null, false);
        int i2 = R.id.edge_case_fragment;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.edge_case_fragment);
        if (frameLayout != null) {
            ViewFlipper viewFlipper = (ViewFlipper) inflate.findViewById(R.id.en_enabled_flipper);
            if (viewFlipper != null) {
                FrameLayout frameLayout2 = (FrameLayout) inflate.findViewById(R.id.share_exposure_fragment);
                if (frameLayout2 != null) {
                    FrameLayout frameLayout3 = (FrameLayout) inflate;
                    this.s = new g(frameLayout3, frameLayout, viewFlipper, frameLayout2);
                    setContentView(frameLayout3);
                    this.u = (ExposureNotificationViewModel) new b0(this).a(ExposureNotificationViewModel.class);
                    ShareDiagnosisViewModel shareDiagnosisViewModel2 = (ShareDiagnosisViewModel) new b0(this).a(ShareDiagnosisViewModel.class);
                    this.t = shareDiagnosisViewModel2;
                    if (shareDiagnosisViewModel2.z) {
                        x(this, shareDiagnosisViewModel2);
                    }
                    if (bundle == null) {
                        String className = getComponentName().getClassName();
                        String stringExtra = getIntent() != null ? getIntent().getStringExtra("ShareDiagnosisActivity.EXTRA_STEP") : null;
                        long longExtra = getIntent() != null ? getIntent().getLongExtra("ShareDiagnosisActivity.EXTRA_DIAGNOSIS_ID", -1) : -1;
                        if (longExtra > -1) {
                            HashSet hashSet = new HashSet();
                            ShareDiagnosisViewModel.d[] values = ShareDiagnosisViewModel.d.values();
                            for (int i3 = 0; i3 < 8; i3++) {
                                hashSet.add(values[i3].name());
                            }
                            if (hashSet.contains(stringExtra) && className.equals(ShareDiagnosisActivity.class.getName())) {
                                this.t.f391j.l(Long.valueOf(longExtra));
                                shareDiagnosisViewModel = this.t;
                                dVar = ShareDiagnosisViewModel.d.valueOf(stringExtra);
                                shareDiagnosisViewModel.g(dVar);
                            }
                        }
                        shareDiagnosisViewModel = this.t;
                        dVar = ShareDiagnosisViewModel.d.BEGIN;
                        shareDiagnosisViewModel.g(dVar);
                    }
                    f0.L = false;
                    m.h.R(this.t.u).f(this, new o(this));
                    this.u.f343g.f(this, new f.b.a.a.a.r.m(this));
                    f0 o = o();
                    if (o.I(R.id.edge_case_fragment) == null) {
                        f.b.a.a.a.j.p pVar = new f.b.a.a.a.j.p();
                        j.C0(pVar, true, true);
                        a aVar = new a(o);
                        aVar.f(R.id.edge_case_fragment, pVar, null);
                        aVar.c();
                        return;
                    }
                    return;
                }
                i2 = R.id.share_exposure_fragment;
            } else {
                i2 = R.id.en_enabled_flipper;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.b.a, e.m.a.r
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // e.b.a.j
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getWindow().getDecorView().sendAccessibilityEvent(32);
    }
}
