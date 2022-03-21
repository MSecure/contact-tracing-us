package f.b.a.a.a.p;

import android.os.Bundle;
import android.os.Parcel;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.R$string;
import com.google.android.material.radiobutton.MaterialRadioButton;
import e.b.a.m;
import e.m.a.l;
import f.b.a.a.a.h.g;
import f.b.a.a.a.w.b0;
import f.b.a.d.l.a;
import f.b.a.d.l.a0;
import f.b.a.d.l.u;
import gov.wi.covid19.exposurenotifications.R;
import java.util.ArrayList;
import l.b.a.d;
import l.b.a.e;
import l.b.a.f;
import l.b.a.q;
import l.b.a.s;
import l.b.a.u.c;
import l.b.a.u.k;

public class q3 extends a3 {
    public static final /* synthetic */ int c0 = 0;
    public f.b.a.a.a.h.s.a Z;
    public ShareDiagnosisViewModel a0;
    public final a.c b0 = new b();

    public class a extends g {
        public final /* synthetic */ RadioGroup b;
        public final /* synthetic */ EditText c;

        public a(RadioGroup radioGroup, EditText editText) {
            this.b = radioGroup;
            this.c = editText;
        }

        public void afterTextChanged(Editable editable) {
            q3 q3Var = q3.this;
            RadioGroup radioGroup = this.b;
            EditText editText = this.c;
            int i2 = q3.c0;
            q3Var.B0(radioGroup, editText);
        }
    }

    public class b implements a.c {
        public b() {
        }

        public int describeContents() {
            return 0;
        }

        @Override // f.b.a.d.l.a.c
        public boolean f(long j2) {
            return m.h.x0(q3.this.Z, j2);
        }

        public void writeToParcel(Parcel parcel, int i2) {
        }
    }

    public final boolean A0(String str, f.b.b.a.g<Long, Boolean> gVar) {
        if (str.isEmpty()) {
            return false;
        }
        try {
            return gVar.a(Long.valueOf(e.T(str, z0()).A(q.f4070g).w().D())).booleanValue();
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public final void B0(RadioGroup radioGroup, EditText editText) {
        b0.b bVar;
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId > 0) {
            ShareDiagnosisViewModel shareDiagnosisViewModel = this.a0;
            switch (checkedRadioButtonId) {
                case R.id.has_symptoms_no /*{ENCODED_INT: 2131362021}*/:
                    bVar = b0.b.NO;
                    break;
                case R.id.has_symptoms_radio_group /*{ENCODED_INT: 2131362022}*/:
                default:
                    bVar = b0.b.UNSET;
                    break;
                case R.id.has_symptoms_withheld /*{ENCODED_INT: 2131362023}*/:
                    bVar = b0.b.WITHHELD;
                    break;
                case R.id.has_symptoms_yes /*{ENCODED_INT: 2131362024}*/:
                    bVar = b0.b.YES;
                    break;
            }
            shareDiagnosisViewModel.j(new e2(bVar));
        }
        String obj = editText.getText().toString();
        if (checkedRadioButtonId == R.id.has_symptoms_yes && A0(obj, r0.a)) {
            this.a0.j(new j2(e.T(obj, z0())));
        }
    }

    public final void C0() {
        d dVar;
        u uVar;
        RadioGroup radioGroup = (RadioGroup) this.F.findViewById(R.id.has_symptoms_radio_group);
        int checkedRadioButtonId = radioGroup == null ? -1 : radioGroup.getCheckedRadioButtonId();
        l J = t().J("date_picker");
        if ((J == null ? null : (f.b.a.d.l.q) J) == null && checkedRadioButtonId == R.id.has_symptoms_yes) {
            a0 a0Var = new a0();
            a.b bVar = new a.b();
            bVar.b = System.currentTimeMillis();
            bVar.f2624d = this.b0;
            f.b.a.d.l.a a2 = bVar.a();
            b0 d2 = this.a0.e().d();
            e i2 = (d2 == null || d2.i() == null) ? null : d2.i();
            if (i2 != null) {
                dVar = s.H(f.F(i2, l.b.a.g.f4047f), q.f4070g).w();
            } else {
                d dVar2 = d.f4040d;
                q qVar = q.f4070g;
                dVar = d.x(System.currentTimeMillis());
            }
            Long valueOf = Long.valueOf(dVar.D());
            int i3 = R$string.mtrl_picker_date_header_title;
            if (valueOf != null) {
                a0Var.d(valueOf);
            }
            if (a2.f2619e == null) {
                long j2 = a2.b.f2646g;
                long j3 = a2.c.f2646g;
                if (!((ArrayList) a0Var.m()).isEmpty()) {
                    long longValue = ((Long) ((ArrayList) a0Var.m()).iterator().next()).longValue();
                    if (longValue >= j2 && longValue <= j3) {
                        uVar = u.q(longValue);
                        a2.f2619e = uVar;
                    }
                }
                long j4 = u.r().f2646g;
                if (j2 <= j4 && j4 <= j3) {
                    j2 = j4;
                }
                uVar = u.q(j2);
                a2.f2619e = uVar;
            }
            f.b.a.d.l.q qVar2 = new f.b.a.d.l.q();
            Bundle bundle = new Bundle();
            bundle.putInt("OVERRIDE_THEME_RES_ID", 0);
            bundle.putParcelable("DATE_SELECTOR_KEY", a0Var);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", a2);
            bundle.putInt("TITLE_TEXT_RES_ID_KEY", i3);
            bundle.putCharSequence("TITLE_TEXT_KEY", null);
            bundle.putInt("INPUT_MODE_KEY", 0);
            qVar2.s0(bundle);
            qVar2.m0.add(new p0(this));
            qVar2.B0(t(), "date_picker");
        }
    }

    public final void D0(View view, int i2, boolean z) {
        ((MaterialRadioButton) view.findViewById(i2)).setChecked(z);
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_onset_date, viewGroup, false);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.share_onset_title);
        this.a0 = (ShareDiagnosisViewModel) new e.p.b0(g()).a(ShareDiagnosisViewModel.class);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.has_symptoms_radio_group);
        EditText editText = (EditText) view.findViewById(R.id.share_test_date);
        Button button = (Button) view.findViewById(R.id.share_next_button);
        Button button2 = (Button) view.findViewById(R.id.share_previous_button);
        View findViewById = view.findViewById(16908332);
        button.setEnabled(false);
        editText.setEnabled(false);
        radioGroup.setOnCheckedChangeListener(new k0(this, editText, radioGroup));
        editText.addTextChangedListener(new a(radioGroup, editText));
        editText.setOnClickListener(new q0(this));
        this.a0.e().f(B(), new l0(this, editText, view, button, button2));
        findViewById.setContentDescription(z(R.string.btn_cancel));
        findViewById.setOnClickListener(new s0(this));
        l J = t().J("date_picker");
        f.b.a.d.l.q qVar = J == null ? null : (f.b.a.d.l.q) J;
        if (qVar != null) {
            qVar.m0.clear();
            qVar.m0.add(new p0(this));
        }
    }

    public final c z0() {
        return c.c(k.MEDIUM).g(v().getConfiguration().locale);
    }
}
