package f.b.a.a.a.r;

import android.os.Bundle;
import android.os.Parcel;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.R$string;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import e.b.a.m;
import e.m.a.l;
import e.p.b0;
import f.b.a.a.a.h.g;
import f.b.a.a.a.i.w;
import f.b.a.a.a.y.c0;
import f.b.a.d.l.a;
import f.b.a.d.l.a0;
import f.b.a.d.l.u;
import gov.md.covid19.exposurenotifications.R;
import java.util.ArrayList;
import l.b.a.d;
import l.b.a.e;
import l.b.a.f;
import l.b.a.q;
import l.b.a.s;
import l.b.a.u.c;
import l.b.a.u.k;

public class c4 extends l3 {
    public static final /* synthetic */ int e0 = 0;
    public f.b.a.a.a.h.s.a a0;
    public w b0;
    public ShareDiagnosisViewModel c0;
    public final a.c d0 = new b();

    public class a extends g {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            c4 c4Var = c4.this;
            w wVar = c4Var.b0;
            c4Var.B0(wVar.c, wVar.f2150i);
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
            return m.h.x0(c4.this.a0, j2);
        }

        public void writeToParcel(Parcel parcel, int i2) {
        }
    }

    public final boolean A0(String str, f.b.b.a.g<Long, Boolean> gVar) {
        if (str.isEmpty()) {
            return false;
        }
        try {
            return gVar.a(Long.valueOf(e.T(str, z0()).A(q.f4166g).w().E())).booleanValue();
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public final void B0(RadioGroup radioGroup, EditText editText) {
        c0.b bVar;
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId > 0) {
            ShareDiagnosisViewModel shareDiagnosisViewModel = this.c0;
            switch (checkedRadioButtonId) {
                case R.id.has_symptoms_no /*{ENCODED_INT: 2131362029}*/:
                    bVar = c0.b.NO;
                    break;
                case R.id.has_symptoms_radio_group /*{ENCODED_INT: 2131362030}*/:
                default:
                    bVar = c0.b.UNSET;
                    break;
                case R.id.has_symptoms_withheld /*{ENCODED_INT: 2131362031}*/:
                    bVar = c0.b.WITHHELD;
                    break;
                case R.id.has_symptoms_yes /*{ENCODED_INT: 2131362032}*/:
                    bVar = c0.b.YES;
                    break;
            }
            shareDiagnosisViewModel.j(new a2(bVar));
        }
        String obj = editText.getText().toString();
        if (checkedRadioButtonId == R.id.has_symptoms_yes && A0(obj, r0.a)) {
            this.c0.j(new p2(e.T(obj, z0())));
        }
    }

    public final void C0() {
        d dVar;
        u uVar;
        int checkedRadioButtonId = this.b0.c.getCheckedRadioButtonId();
        l J = t().J("date_picker");
        if ((J == null ? null : (f.b.a.d.l.q) J) == null && checkedRadioButtonId == R.id.has_symptoms_yes) {
            a0 a0Var = new a0();
            a.b bVar = new a.b();
            bVar.b = System.currentTimeMillis();
            bVar.f2724d = this.d0;
            f.b.a.d.l.a a2 = bVar.a();
            c0 d2 = this.c0.e().d();
            e i2 = (d2 == null || d2.i() == null) ? null : d2.i();
            if (i2 != null) {
                dVar = s.H(f.F(i2, l.b.a.g.f4143f), q.f4166g).w();
            } else {
                d dVar2 = d.f4136d;
                q qVar = q.f4166g;
                dVar = d.y(System.currentTimeMillis());
            }
            Long valueOf = Long.valueOf(dVar.E());
            int i3 = R$string.mtrl_picker_date_header_title;
            if (valueOf != null) {
                a0Var.d(valueOf);
            }
            if (a2.f2719e == null) {
                long j2 = a2.b.f2746g;
                long j3 = a2.c.f2746g;
                if (!((ArrayList) a0Var.m()).isEmpty()) {
                    long longValue = ((Long) ((ArrayList) a0Var.m()).iterator().next()).longValue();
                    if (longValue >= j2 && longValue <= j3) {
                        uVar = u.q(longValue);
                        a2.f2719e = uVar;
                    }
                }
                long j4 = u.r().f2746g;
                if (j2 <= j4 && j4 <= j3) {
                    j2 = j4;
                }
                uVar = u.q(j2);
                a2.f2719e = uVar;
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
            qVar2.n0.add(new j0(this));
            qVar2.B0(t(), "date_picker");
        }
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_onset_date, viewGroup, false);
        int i2 = R.id.has_symptoms_no;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) inflate.findViewById(R.id.has_symptoms_no);
        if (materialRadioButton != null) {
            i2 = R.id.has_symptoms_radio_group;
            RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.has_symptoms_radio_group);
            if (radioGroup != null) {
                i2 = R.id.has_symptoms_withheld;
                MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) inflate.findViewById(R.id.has_symptoms_withheld);
                if (materialRadioButton2 != null) {
                    i2 = R.id.has_symptoms_yes;
                    MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) inflate.findViewById(R.id.has_symptoms_yes);
                    if (materialRadioButton3 != null) {
                        i2 = 16908332;
                        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                        if (imageButton != null) {
                            i2 = R.id.share_next_button;
                            Button button = (Button) inflate.findViewById(R.id.share_next_button);
                            if (button != null) {
                                i2 = R.id.share_previous_button;
                                Button button2 = (Button) inflate.findViewById(R.id.share_previous_button);
                                if (button2 != null) {
                                    i2 = R.id.share_test_date;
                                    TextInputEditText textInputEditText = (TextInputEditText) inflate.findViewById(R.id.share_test_date);
                                    if (textInputEditText != null) {
                                        LinearLayout linearLayout = (LinearLayout) inflate;
                                        this.b0 = new w(linearLayout, materialRadioButton, radioGroup, materialRadioButton2, materialRadioButton3, imageButton, button, button2, textInputEditText);
                                        return linearLayout;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.b0 = null;
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.share_onset_title);
        this.c0 = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        this.b0.f2148g.setEnabled(false);
        this.b0.f2150i.setEnabled(false);
        this.b0.c.setOnCheckedChangeListener(new m0(this));
        this.b0.f2150i.addTextChangedListener(new a());
        this.b0.f2150i.setOnClickListener(new q0(this));
        this.c0.e().f(B(), new h0(this));
        this.b0.f2147f.setContentDescription(z(R.string.btn_cancel));
        this.b0.f2147f.setOnClickListener(new p0(this));
        l J = t().J("date_picker");
        f.b.a.d.l.q qVar = J == null ? null : (f.b.a.d.l.q) J;
        if (qVar != null) {
            qVar.n0.clear();
            qVar.n0.add(new j0(this));
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.c0;
        ShareDiagnosisViewModel.d dVar = ShareDiagnosisViewModel.d.ONSET;
        m.h.A0(shareDiagnosisViewModel.e(), new b3(shareDiagnosisViewModel, dVar)).f(B(), new n0(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.c0;
        m.h.A0(shareDiagnosisViewModel2.e(), new z2(shareDiagnosisViewModel2, dVar)).f(B(), new i0(this, view));
    }

    public final c z0() {
        return c.c(k.MEDIUM).g(v().getConfiguration().locale);
    }
}
