package f.b.a.a.a.s;

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
import e.m.a.m;
import e.p.f0;
import f.b.a.a.a.b0.h0;
import f.b.a.e.k.a;
import f.b.a.e.k.a0;
import f.b.a.e.k.q;
import f.b.a.e.k.u;
import f.b.a.e.l.b;
import f.b.b.a.g;
import f.b.b.a.l;
import gov.co.cdphe.exposurenotifications.R;
import java.util.ArrayList;
import l.b.a.e;
import l.b.a.f;
import l.b.a.r;
import l.b.a.v.c;
import l.b.a.v.k;

public abstract class r5 extends c5 {
    public ShareDiagnosisViewModel a0;
    public l<Boolean> b0 = f.b.b.a.a.b;
    public f.b.a.a.a.i.f0.a c0;
    public final a.c d0 = new a();

    public class a implements a.c {
        public a() {
        }

        public int describeContents() {
            return 0;
        }

        @Override // f.b.a.e.k.a.c
        public boolean f(long j2) {
            return a5.c(r5.this.c0, j2);
        }

        public void writeToParcel(Parcel parcel, int i2) {
        }
    }

    @Override // f.b.a.a.a.m.z0
    public boolean A0() {
        boolean z;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a0;
        shareDiagnosisViewModel.i();
        boolean z2 = false;
        if (shareDiagnosisViewModel.C.isEmpty()) {
            z = false;
        } else {
            shareDiagnosisViewModel.B.j(shareDiagnosisViewModel.C.peek());
            z = true;
        }
        if (!z) {
            y5 y5Var = (y5) this.v;
            if (y5Var != null && y5Var.d0) {
                z2 = true;
            }
            H0(z2);
        }
        return true;
    }

    public void C0() {
        if (!this.v.u().Y()) {
            this.v.o0().finish();
        }
    }

    public q<Long> D0(e eVar) {
        u uVar;
        a0 a0Var = new a0();
        a.b bVar = new a.b();
        bVar.b = System.currentTimeMillis();
        bVar.f2829d = this.d0;
        f.b.a.e.k.a a2 = bVar.a();
        Long valueOf = Long.valueOf(eVar.G());
        int i2 = R$string.mtrl_picker_date_header_title;
        if (valueOf != null) {
            a0Var.d(valueOf);
        }
        if (a2.f2824e == null) {
            long j2 = a2.b.f2851g;
            long j3 = a2.c.f2851g;
            if (!((ArrayList) a0Var.m()).isEmpty()) {
                long longValue = ((Long) ((ArrayList) a0Var.m()).iterator().next()).longValue();
                if (longValue >= j2 && longValue <= j3) {
                    uVar = u.q(longValue);
                    a2.f2824e = uVar;
                }
            }
            long j4 = u.r().f2851g;
            if (j2 <= j4 && j4 <= j3) {
                j2 = j4;
            }
            uVar = u.q(j2);
            a2.f2824e = uVar;
        }
        q<Long> qVar = new q<>();
        Bundle bundle = new Bundle();
        bundle.putInt("OVERRIDE_THEME_RES_ID", 0);
        bundle.putParcelable("DATE_SELECTOR_KEY", a0Var);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", a2);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", i2);
        bundle.putCharSequence("TITLE_TEXT_KEY", null);
        bundle.putInt("INPUT_MODE_KEY", 0);
        qVar.t0(bundle);
        return qVar;
    }

    public q<Long> E0(String str) {
        m I = u().I(str);
        if (I == null) {
            return null;
        }
        return (q) I;
    }

    public c F0() {
        return c.c(k.MEDIUM).g(w().getConfiguration().locale);
    }

    public boolean G0(String str, g<Long, Boolean> gVar) {
        if (str.isEmpty()) {
            return false;
        }
        try {
            return gVar.a(Long.valueOf(f.T(str, F0()).A(r.f4321g).w().G())).booleanValue();
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public void H0(boolean z) {
        if (z) {
            K0();
        } else {
            C0();
        }
    }

    public void I0(String str) {
        View view;
        String str2;
        if (!TextUtils.isEmpty(str) && !G0(str, new j(this))) {
            view = this.F;
            str2 = A(R.string.input_error_onset_date_future);
        } else if (!TextUtils.isEmpty(str) && !G0(str, new k(this))) {
            view = this.F;
            str2 = B(R.string.input_error_onset_date_past, "14");
        } else {
            return;
        }
        m.h.I0(view, str2);
    }

    public void J0(NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        nestedScrollView.setOnScrollChangeListener(new f(this, nestedScrollView, viewGroup));
        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new l(this, nestedScrollView, viewGroup));
    }

    public void K0() {
        this.a0.K = true;
        b bVar = new b(p0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.share_close_title);
        bVar.c(R.string.share_close_detail);
        bVar.e(R.string.btn_resume_later, new n(this));
        bVar.d(R.string.btn_cancel, new i(this));
        bVar.a.f38l = new g(this);
        bVar.b();
    }

    public void L0(h0 h0Var) {
        this.a0.J = true;
        b bVar = new b(p0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.delete_test_result_title);
        bVar.a.f37k = true;
        bVar.e(R.string.btn_delete, new p(this, h0Var));
        bVar.d(R.string.btn_cancel, new h(this));
        m mVar = new m(this);
        AlertController.b bVar2 = bVar.a;
        bVar2.m = mVar;
        bVar2.f38l = new o(this);
        bVar.b();
    }

    public final void M0(ViewGroup viewGroup, boolean z) {
        if (!this.b0.b() || this.b0.a().booleanValue() != z) {
            this.b0 = l.c(Boolean.valueOf(z));
            viewGroup.setElevation(z ? 0.0f : w().getDimension(R.dimen.bottom_button_container_elevation));
        }
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        ShareDiagnosisViewModel shareDiagnosisViewModel = (ShareDiagnosisViewModel) new f0(this.v).a(ShareDiagnosisViewModel.class);
        this.a0 = shareDiagnosisViewModel;
        if (shareDiagnosisViewModel.K) {
            K0();
        }
    }
}
