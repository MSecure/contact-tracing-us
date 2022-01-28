package f.b.a.a.a.s;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.m.a.a;
import e.m.a.e0;
import e.m.a.m;
import e.p.f0;
import f.b.a.a.a.i.c;
import f.b.a.a.a.i.v;
import f.b.a.a.a.i.x;
import f.b.a.a.a.j.c0;
import f.b.a.a.a.k.l;
import f.b.a.a.a.k.r;
import gov.co.cdphe.exposurenotifications.R;
import java.util.HashSet;
import java.util.Objects;

public class y5 extends f5 {
    public ShareDiagnosisViewModel a0;
    public c0 b0;
    public boolean c0 = false;
    public boolean d0 = false;

    @Override // f.b.a.a.a.m.z0
    public boolean A0() {
        r5 r5Var = (r5) h().H(R.id.notify_others_fragment);
        if (r5Var == null) {
            return false;
        }
        if (this.b0.b.getDisplayedChild() != 1) {
            return r5Var.A0();
        }
        r5Var.H0(this.d0);
        return true;
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis, viewGroup, false);
        int i2 = R.id.edge_case_fragment;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.edge_case_fragment);
        if (frameLayout != null) {
            i2 = R.id.en_enabled_flipper;
            ViewFlipper viewFlipper = (ViewFlipper) inflate.findViewById(R.id.en_enabled_flipper);
            if (viewFlipper != null) {
                i2 = R.id.notify_others_fragment;
                FrameLayout frameLayout2 = (FrameLayout) inflate.findViewById(R.id.notify_others_fragment);
                if (frameLayout2 != null) {
                    FrameLayout frameLayout3 = (FrameLayout) inflate;
                    this.b0 = new c0(frameLayout3, frameLayout, viewFlipper, frameLayout2);
                    return frameLayout3;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.b0 = null;
    }

    @Override // e.m.a.m
    public void d0(Bundle bundle) {
        e0 h2 = h();
        m I = h().I("ShareDiagnosisFragment.NOTIFY_OTHERS_FRAGMENT_TAG");
        Objects.requireNonNull(I);
        h2.a0(bundle, "ShareDiagnosisFragment.SAVED_INSTANCE_STATE_FRAGMENT_KEY", I);
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        ShareDiagnosisViewModel shareDiagnosisViewModel;
        ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.BEGIN;
        super.g0(view, bundle);
        this.a0 = (ShareDiagnosisViewModel) new f0(this).a(ShareDiagnosisViewModel.class);
        if (bundle != null) {
            a aVar = new a(h());
            m J = h().J(bundle, "ShareDiagnosisFragment.SAVED_INSTANCE_STATE_FRAGMENT_KEY");
            Objects.requireNonNull(J);
            aVar.f(R.id.notify_others_fragment, J, "ShareDiagnosisFragment.NOTIFY_OTHERS_FRAGMENT_TAG");
            aVar.d();
            this.c0 = true;
        } else {
            Bundle bundle2 = this.f1454g;
            boolean z = false;
            boolean z2 = bundle2 != null && bundle2.containsKey("BaseFragment.CODE_FROM_DEEP_LINK");
            Bundle bundle3 = this.f1454g;
            boolean z3 = bundle3 != null && bundle3.getBoolean("BaseFragment.IS_SELF_REPORT_FLOW", false);
            String str = v.a;
            if (bundle2 != null) {
                String string = bundle2.getString("ShareDiagnosisFragment.EXTRA_STEP", null);
                if (bundle2.getLong("ShareDiagnosisFragment.EXTRA_DIAGNOSIS_ID", -1) > -1) {
                    f.b.a.a.a.i.e0.a aVar2 = ShareDiagnosisViewModel.O;
                    HashSet hashSet = new HashSet();
                    ShareDiagnosisViewModel.b[] values = ShareDiagnosisViewModel.b.values();
                    for (int i2 = 0; i2 < 11; i2++) {
                        hashSet.add(values[i2].name());
                    }
                    if (hashSet.contains(string)) {
                        z = true;
                    }
                }
            }
            if (z) {
                long j2 = bundle2.getLong("ShareDiagnosisFragment.EXTRA_DIAGNOSIS_ID");
                String string2 = bundle2.getString("ShareDiagnosisFragment.EXTRA_STEP");
                this.a0.p(j2);
                this.a0.k(ShareDiagnosisViewModel.b.valueOf(string2));
            } else {
                if (z2) {
                    this.a0.q(x5.DEEP_LINK);
                } else if (!z3) {
                    this.W.p.f(this, new n0(this));
                    this.W.c();
                } else if (!TextUtils.isEmpty(p0().getString(R.string.self_report_website_url))) {
                    this.a0.q(x5.SELF_REPORT);
                    shareDiagnosisViewModel = this.a0;
                    bVar = ShareDiagnosisViewModel.b.GET_CODE;
                    shareDiagnosisViewModel.k(bVar);
                }
                shareDiagnosisViewModel = this.a0;
                shareDiagnosisViewModel.k(bVar);
            }
        }
        m.h.S(this.a0.B).f(C(), new o0(this));
        new x(this.a0.f(), this.W.f336f).f(this, new c(new p0(this)));
        e0 h2 = h();
        if (h2.H(R.id.edge_case_fragment) == null) {
            r rVar = new r();
            l.G0(rVar, true, true);
            a aVar3 = new a(h2);
            aVar3.f(R.id.edge_case_fragment, rVar, null);
            aVar3.d();
        }
    }
}
