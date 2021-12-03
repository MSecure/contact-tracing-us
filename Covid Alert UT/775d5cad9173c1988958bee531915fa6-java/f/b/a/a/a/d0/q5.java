package f.b.a.a.a.d0;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.R$string;
import e.b.a.m;
import e.n.a.m;
import e.q.f0;
import f.b.a.a.a.l0.h0;
import f.b.a.e.l.a;
import f.b.a.e.l.a0;
import f.b.a.e.l.q;
import f.b.a.e.l.u;
import f.b.a.e.m.b;
import f.b.b.a.g;
import f.b.b.a.l;
import gov.ut.covid19.exposurenotifications.R;
import java.util.ArrayList;
import l.b.a.e;
import l.b.a.f;
import l.b.a.r;
import l.b.a.v.c;
import l.b.a.v.k;

public abstract class q5 extends c5 {
    public ShareDiagnosisViewModel b0;
    public l<Boolean> c0 = f.b.b.a.a.b;
    public f.b.a.a.a.s.e0.a d0;
    public final a.c e0 = new a();

    public class a implements a.c {
        public a() {
        }

        public int describeContents() {
            return 0;
        }

        @Override // f.b.a.e.l.a.c
        public boolean f(long j2) {
            return a5.c(q5.this.d0, j2);
        }

        public void writeToParcel(Parcel parcel, int i2) {
        }
    }

    @Override // f.b.a.a.a.w.z0
    public boolean F0() {
        boolean z;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        shareDiagnosisViewModel.i();
        boolean z2 = false;
        if (shareDiagnosisViewModel.C.isEmpty()) {
            z = false;
        } else {
            shareDiagnosisViewModel.B.j(shareDiagnosisViewModel.C.peek());
            z = true;
        }
        if (!z) {
            x5 x5Var = (x5) this.v;
            if (x5Var != null && x5Var.e0) {
                z2 = true;
            }
            N0(z2);
        }
        return true;
    }

    public void I0() {
        if (!this.v.v().Y()) {
            this.v.s0().finish();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0053, code lost:
        if (f.b.a.e.l.q.d.a(r7, r1) != false) goto L_0x0063;
     */
    public q<Long> J0(e eVar) {
        u uVar;
        a0 a0Var = new a0();
        a.b bVar = new a.b();
        bVar.b = System.currentTimeMillis();
        bVar.f2885d = this.e0;
        f.b.a.e.l.a a2 = bVar.a();
        Long valueOf = Long.valueOf(eVar.G());
        int i2 = R$string.mtrl_picker_date_header_title;
        if (valueOf != null) {
            a0Var.d(valueOf);
        }
        if (a2.f2880e == null) {
            if (!((ArrayList) a0Var.m()).isEmpty()) {
                uVar = u.q(((Long) ((ArrayList) a0Var.m()).iterator().next()).longValue());
            }
            uVar = u.r();
            if (!q.d.a(uVar, a2)) {
                uVar = a2.b;
            }
            a2.f2880e = uVar;
        }
        q<Long> qVar = new q<>();
        Bundle bundle = new Bundle();
        bundle.putInt("OVERRIDE_THEME_RES_ID", 0);
        bundle.putParcelable("DATE_SELECTOR_KEY", a0Var);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", a2);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", i2);
        bundle.putCharSequence("TITLE_TEXT_KEY", null);
        bundle.putInt("INPUT_MODE_KEY", 0);
        qVar.y0(bundle);
        return qVar;
    }

    public q<Long> K0(String str) {
        m I = v().I(str);
        if (I == null) {
            return null;
        }
        return (q) I;
    }

    public c L0() {
        return c.c(k.MEDIUM).g(A().getConfiguration().locale);
    }

    public boolean M0(String str, g<Long, Boolean> gVar) {
        if (str.isEmpty()) {
            return false;
        }
        try {
            return gVar.a(Long.valueOf(f.T(str, L0()).A(r.f4386g).w().G())).booleanValue();
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public void N0(boolean z) {
        if (z) {
            Q0();
        } else {
            I0();
        }
    }

    public void O0(String str) {
        View view;
        String str2;
        if (!TextUtils.isEmpty(str) && !M0(str, new j(this))) {
            view = this.F;
            str2 = E(R.string.input_error_onset_date_future);
        } else if (!TextUtils.isEmpty(str) && !M0(str, new k(this))) {
            view = this.F;
            str2 = F(R.string.input_error_onset_date_past, "14");
        } else {
            return;
        }
        m.e.T0(view, str2);
    }

    public void P0(NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        nestedScrollView.setOnScrollChangeListener(new f(this, nestedScrollView, viewGroup));
        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new l(this, nestedScrollView, viewGroup));
    }

    public void Q0() {
        this.b0.K = true;
        b bVar = new b(t0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.share_close_title);
        bVar.c(R.string.share_close_detail);
        bVar.e(R.string.btn_resume_later, new n(this));
        bVar.d(R.string.btn_cancel, new i(this));
        bVar.a.f39l = new g(this);
        bVar.b();
    }

    public void R0(h0 h0Var) {
        this.b0.J = true;
        b bVar = new b(t0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.delete_test_result_title);
        bVar.a.f38k = true;
        bVar.e(R.string.btn_delete, new p(this, h0Var));
        bVar.d(R.string.btn_cancel, new h(this));
        m mVar = new m(this);
        AlertController.b bVar2 = bVar.a;
        bVar2.m = mVar;
        bVar2.f39l = new o(this);
        bVar.b();
    }

    public final void S0(ViewGroup viewGroup, boolean z) {
        if (!this.c0.b() || this.c0.a().booleanValue() != z) {
            this.c0 = l.c(Boolean.valueOf(z));
            viewGroup.setElevation(z ? 0.0f : A().getDimension(R.dimen.bottom_button_container_elevation));
        }
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        ShareDiagnosisViewModel shareDiagnosisViewModel = (ShareDiagnosisViewModel) new f0(this.v).a(ShareDiagnosisViewModel.class);
        this.b0 = shareDiagnosisViewModel;
        if (shareDiagnosisViewModel.K) {
            Q0();
        }
    }
}
