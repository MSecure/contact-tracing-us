package f.b.a.a.a.r;

import android.text.TextUtils;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import f.b.a.c.b.o.b;
import f.b.a.d.l.a;
import f.b.a.d.l.s;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.d;
import l.b.a.q;
import l.b.a.u.c;

public final /* synthetic */ class j0 implements s {
    public final /* synthetic */ c4 a;

    public /* synthetic */ j0(c4 c4Var) {
        this.a = c4Var;
    }

    @Override // f.b.a.d.l.s
    public final void a(Object obj) {
        String str;
        View view;
        c4 c4Var = this.a;
        TextInputEditText textInputEditText = c4Var.b0.f2150i;
        c z0 = c4Var.z0();
        d y = d.y(((Long) obj).longValue());
        q qVar = q.f4166g;
        Objects.requireNonNull(y);
        b.A1(y, "instant");
        b.A1(qVar, "zone");
        textInputEditText.setText(z0.b(l.b.a.s.E(y.b, y.c, qVar)));
        String obj2 = c4Var.b0.f2150i.getText().toString();
        int checkedRadioButtonId = c4Var.b0.c.getCheckedRadioButtonId();
        boolean z = checkedRadioButtonId > 0;
        boolean z2 = checkedRadioButtonId == R.id.has_symptoms_yes;
        a.c cVar = c4Var.d0;
        Objects.requireNonNull(cVar);
        if (!(z && (!z2 || c4Var.A0(obj2, new a(cVar))))) {
            if (!TextUtils.isEmpty(obj2) && !c4Var.A0(obj2, new k0(c4Var))) {
                str = c4Var.z(R.string.input_error_onset_date_future);
                view = c4Var.F;
                if (view == null) {
                    return;
                }
            } else if (!TextUtils.isEmpty(obj2) && !c4Var.A0(obj2, new o0(c4Var))) {
                str = c4Var.A(R.string.input_error_onset_date_past, "14");
                view = c4Var.F;
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
