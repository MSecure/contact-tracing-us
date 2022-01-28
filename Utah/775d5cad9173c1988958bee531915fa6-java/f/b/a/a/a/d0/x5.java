package f.b.a.a.a.d0;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.n.a.a;
import e.n.a.e0;
import e.n.a.m;
import e.q.f0;
import f.b.a.a.a.s.c;
import f.b.a.a.a.s.u;
import f.b.a.a.a.s.w;
import f.b.a.a.a.t.c0;
import f.b.a.a.a.u.l;
import f.b.a.a.a.u.r;
import gov.ut.covid19.exposurenotifications.R;
import java.util.HashSet;
import java.util.Objects;

public class x5 extends f5 {
    public ShareDiagnosisViewModel b0;
    public c0 c0;
    public boolean d0 = false;
    public boolean e0 = false;

    @Override // f.b.a.a.a.w.z0
    public boolean F0() {
        q5 q5Var = (q5) h().H(R.id.notify_others_fragment);
        if (q5Var == null) {
            return false;
        }
        if (this.c0.b.getDisplayedChild() != 1) {
            return q5Var.F0();
        }
        q5Var.N0(this.e0);
        return true;
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                    this.c0 = new c0(frameLayout3, frameLayout, viewFlipper, frameLayout2);
                    return frameLayout3;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.c0 = null;
    }

    @Override // e.n.a.m
    public void h0(Bundle bundle) {
        e0 h2 = h();
        m I = h().I("ShareDiagnosisFragment.NOTIFY_OTHERS_FRAGMENT_TAG");
        Objects.requireNonNull(I);
        h2.a0(bundle, "ShareDiagnosisFragment.SAVED_INSTANCE_STATE_FRAGMENT_KEY", I);
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        ShareDiagnosisViewModel shareDiagnosisViewModel;
        ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.BEGIN;
        super.k0(view, bundle);
        this.b0 = (ShareDiagnosisViewModel) new f0(this).a(ShareDiagnosisViewModel.class);
        if (bundle != null) {
            a aVar = new a(h());
            m J = h().J(bundle, "ShareDiagnosisFragment.SAVED_INSTANCE_STATE_FRAGMENT_KEY");
            Objects.requireNonNull(J);
            aVar.f(R.id.notify_others_fragment, J, "ShareDiagnosisFragment.NOTIFY_OTHERS_FRAGMENT_TAG");
            aVar.d();
            this.d0 = true;
        } else {
            Bundle bundle2 = this.f1727g;
            boolean z = false;
            boolean z2 = bundle2 != null && bundle2.containsKey("BaseFragment.CODE_FROM_DEEP_LINK");
            Bundle bundle3 = this.f1727g;
            boolean z3 = bundle3 != null && bundle3.getBoolean("BaseFragment.IS_SELF_REPORT_FLOW", false);
            String str = u.a;
            if (bundle2 != null) {
                String string = bundle2.getString("ShareDiagnosisFragment.EXTRA_STEP", null);
                if (bundle2.getLong("ShareDiagnosisFragment.EXTRA_DIAGNOSIS_ID", -1) > -1) {
                    f.b.a.a.a.s.d0.a aVar2 = ShareDiagnosisViewModel.O;
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
                this.b0.p(j2);
                this.b0.k(ShareDiagnosisViewModel.b.valueOf(string2));
            } else {
                if (z2) {
                    this.b0.q(w5.DEEP_LINK);
                } else if (!z3) {
                    this.W.p.f(this, new n0(this));
                    this.W.c();
                } else if (!TextUtils.isEmpty(t0().getString(R.string.self_report_website_url))) {
                    this.b0.q(w5.SELF_REPORT);
                    shareDiagnosisViewModel = this.b0;
                    bVar = ShareDiagnosisViewModel.b.GET_CODE;
                    shareDiagnosisViewModel.k(bVar);
                }
                shareDiagnosisViewModel = this.b0;
                shareDiagnosisViewModel.k(bVar);
            }
        }
        m.e.U(this.b0.B).f(G(), new o0(this));
        new w(this.b0.f(), this.W.f341f).f(this, new c(new p0(this)));
        e0 h2 = h();
        if (h2.H(R.id.edge_case_fragment) == null) {
            r rVar = new r();
            l.L0(rVar, true, true);
            a aVar3 = new a(h2);
            aVar3.f(R.id.edge_case_fragment, rVar, null);
            aVar3.d();
        }
    }
}
