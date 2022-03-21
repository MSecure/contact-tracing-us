package f.b.a.a.a.p;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.google.android.material.snackbar.Snackbar;
import f.b.a.c.b.o.b;
import f.b.a.d.l.a;
import f.b.a.d.l.s;
import gov.wi.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.d;
import l.b.a.q;
import l.b.a.u.c;

public final /* synthetic */ class p0 implements s {
    public final /* synthetic */ q3 a;

    public /* synthetic */ p0(q3 q3Var) {
        this.a = q3Var;
    }

    @Override // f.b.a.d.l.s
    public final void a(Object obj) {
        String str;
        View view;
        q3 q3Var = this.a;
        c z0 = q3Var.z0();
        d x = d.x(((Long) obj).longValue());
        q qVar = q.f4070g;
        Objects.requireNonNull(x);
        b.B1(x, "instant");
        b.B1(qVar, "zone");
        ((EditText) q3Var.F.findViewById(R.id.share_test_date)).setText(z0.b(l.b.a.s.E(x.b, x.c, qVar)));
        String obj2 = ((EditText) q3Var.F.findViewById(R.id.share_test_date)).getText().toString();
        int checkedRadioButtonId = ((RadioGroup) q3Var.F.findViewById(R.id.has_symptoms_radio_group)).getCheckedRadioButtonId();
        boolean z = checkedRadioButtonId > 0;
        boolean z2 = checkedRadioButtonId == R.id.has_symptoms_yes;
        a.c cVar = q3Var.b0;
        Objects.requireNonNull(cVar);
        if (!(z && (!z2 || q3Var.A0(obj2, new a(cVar))))) {
            if (!TextUtils.isEmpty(obj2) && !q3Var.A0(obj2, new n0(q3Var))) {
                str = q3Var.z(R.string.input_error_onset_date_future);
                view = q3Var.F;
                if (view == null) {
                    return;
                }
            } else if (!TextUtils.isEmpty(obj2) && !q3Var.A0(obj2, new m0(q3Var))) {
                str = q3Var.A(R.string.input_error_onset_date_past, "14");
                view = q3Var.F;
                if (view == null) {
                    return;
                }
            } else {
                return;
            }
            Snackbar.j(view, str, 0).k();
        }
    }
}
