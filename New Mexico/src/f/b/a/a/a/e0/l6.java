package f.b.a.a.a.e0;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.o.a.a;
import e.o.a.e0;
import e.o.a.m;
import e.r.t;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.t.g0;
import f.b.a.a.a.t.i0;
import f.b.a.a.a.t.l;
import f.b.a.a.a.u.f0;
import f.b.a.a.a.v.r;
import gov.nm.covid19.exposurenotifications.R;
import java.util.HashSet;
import java.util.Objects;
/* loaded from: classes.dex */
public class l6 extends t5 {
    public ShareDiagnosisViewModel b0;
    public f0 c0;
    public boolean d0 = false;
    public boolean e0 = false;

    @Override // f.b.a.a.a.x.a1
    public boolean I0() {
        e6 e6Var = (e6) j().H(R.id.notify_others_fragment);
        if (e6Var == null) {
            return false;
        }
        if (this.c0.b.getDisplayedChild() != 1) {
            return e6Var.I0();
        }
        e6Var.Q0(this.e0);
        return true;
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                    this.c0 = new f0(frameLayout3, frameLayout, viewFlipper, frameLayout2);
                    return frameLayout3;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.c0 = null;
    }

    @Override // e.o.a.m
    public void j0(Bundle bundle) {
        e0 j2 = j();
        m I = j().I("ShareDiagnosisFragment.NOTIFY_OTHERS_FRAGMENT_TAG");
        Objects.requireNonNull(I);
        j2.b0(bundle, "ShareDiagnosisFragment.SAVED_INSTANCE_STATE_FRAGMENT_KEY", I);
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        ShareDiagnosisViewModel shareDiagnosisViewModel;
        ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.BEGIN;
        super.m0(view, bundle);
        this.b0 = (ShareDiagnosisViewModel) new e.r.f0(this).a(ShareDiagnosisViewModel.class);
        if (bundle != null) {
            a aVar = new a(j());
            m K = j().K(bundle, "ShareDiagnosisFragment.SAVED_INSTANCE_STATE_FRAGMENT_KEY");
            Objects.requireNonNull(K);
            aVar.g(R.id.notify_others_fragment, K, "ShareDiagnosisFragment.NOTIFY_OTHERS_FRAGMENT_TAG");
            aVar.d();
            this.d0 = true;
        } else {
            Bundle bundle2 = this.f1812g;
            boolean z = false;
            boolean z2 = bundle2 != null && bundle2.containsKey("BaseFragment.CODE_FROM_DEEP_LINK");
            Bundle bundle3 = this.f1812g;
            boolean z3 = bundle3 != null && bundle3.getBoolean("BaseFragment.IS_SELF_REPORT_FLOW", false);
            String str = g0.a;
            if (bundle2 != null) {
                String string = bundle2.getString("ShareDiagnosisFragment.EXTRA_STEP", null);
                if (bundle2.getLong("ShareDiagnosisFragment.EXTRA_DIAGNOSIS_ID", -1) > -1) {
                    f.b.a.a.a.t.p0.a aVar2 = ShareDiagnosisViewModel.R;
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
                this.b0.q(j2);
                this.b0.l(ShareDiagnosisViewModel.b.valueOf(string2));
            } else {
                if (z2) {
                    this.b0.r(k6.DEEP_LINK);
                } else if (!z3) {
                    this.W.p.f(this, new t() { // from class: f.b.a.a.a.e0.t0
                        @Override // e.r.t
                        public final void a(Object obj) {
                            ShareDiagnosisViewModel shareDiagnosisViewModel2;
                            ShareDiagnosisViewModel.b bVar2;
                            l6 l6Var = l6.this;
                            j0 j0Var = (j0) obj;
                            Objects.requireNonNull(l6Var);
                            if (j0Var == null || ShareDiagnosisViewModel.X.equals(j0Var)) {
                                l6Var.b0.q(-1);
                                shareDiagnosisViewModel2 = l6Var.b0;
                                bVar2 = ShareDiagnosisViewModel.b.BEGIN;
                            } else {
                                ShareDiagnosisViewModel shareDiagnosisViewModel3 = l6Var.b0;
                                shareDiagnosisViewModel3.P = true;
                                shareDiagnosisViewModel3.q(j0Var.e());
                                ShareDiagnosisViewModel shareDiagnosisViewModel4 = l6Var.b0;
                                shareDiagnosisViewModel4.K.b("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", j0Var.p());
                                shareDiagnosisViewModel2 = l6Var.b0;
                                bVar2 = ShareDiagnosisViewModel.b.CODE;
                            }
                            shareDiagnosisViewModel2.l(bVar2);
                        }
                    });
                    this.W.c();
                } else if (!TextUtils.isEmpty(v0().getString(R.string.self_report_website_url))) {
                    this.b0.r(k6.SELF_REPORT);
                    shareDiagnosisViewModel = this.b0;
                    bVar = ShareDiagnosisViewModel.b.GET_CODE;
                    shareDiagnosisViewModel.l(bVar);
                }
                shareDiagnosisViewModel = this.b0;
                shareDiagnosisViewModel.l(bVar);
            }
        }
        m.e.V(this.b0.C).f(H(), new t() { // from class: f.b.a.a.a.e0.u0
            @Override // e.r.t
            public final void a(Object obj) {
                e.o.a.m mVar;
                l6 l6Var = l6.this;
                ShareDiagnosisViewModel.b bVar2 = (ShareDiagnosisViewModel.b) obj;
                if (!l6Var.d0) {
                    a aVar3 = new a(l6Var.j());
                    switch (bVar2.ordinal()) {
                        case 1:
                            mVar = new o6();
                            break;
                        case 2:
                            mVar = new n6();
                            break;
                        case 3:
                            mVar = new i6();
                            break;
                        case 4:
                            mVar = new w6();
                            break;
                        case 5:
                            mVar = new t6();
                            break;
                        case 6:
                            mVar = new q6();
                            break;
                        case 7:
                            mVar = new z6();
                            break;
                        case 8:
                            mVar = new c6();
                            break;
                        case 9:
                            mVar = new s6();
                            break;
                        case 10:
                            mVar = new y6();
                            break;
                        default:
                            mVar = new g6();
                            break;
                    }
                    aVar3.g(R.id.notify_others_fragment, mVar, "ShareDiagnosisFragment.NOTIFY_OTHERS_FRAGMENT_TAG");
                    aVar3.f1829f = 4097;
                    aVar3.d();
                    return;
                }
                l6Var.d0 = false;
            }
        });
        new i0(this.b0.f(), this.W.f343f).f(this, new l(new i0.a() { // from class: f.b.a.a.a.e0.v0
            @Override // f.b.a.a.a.t.i0.a
            public final void a(Object obj, Object obj2) {
                l6 l6Var = l6.this;
                j0 j0Var = (j0) obj;
                Objects.requireNonNull(l6Var);
                boolean z4 = true;
                if (((Boolean) obj2).booleanValue() || o5.a(j0Var)) {
                    l6Var.c0.b.setDisplayedChild(0);
                } else {
                    l6Var.c0.b.setDisplayedChild(1);
                }
                if (!o5.b(j0Var) || !j0.c.NOT_ATTEMPTED.equals(j0Var.m())) {
                    z4 = false;
                }
                l6Var.e0 = z4;
            }
        }));
        e0 j3 = j();
        if (j3.H(R.id.edge_case_fragment) == null) {
            r rVar = new r();
            f.b.a.a.a.v.l.O0(rVar, true, true);
            a aVar3 = new a(j3);
            aVar3.g(R.id.edge_case_fragment, rVar, null);
            aVar3.d();
        }
    }
}
