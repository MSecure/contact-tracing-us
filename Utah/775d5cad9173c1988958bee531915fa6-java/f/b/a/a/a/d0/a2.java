package f.b.a.a.a.d0;

import android.view.View;
import com.google.android.material.chip.Chip;
import f.b.a.a.a.l0.h0;
import f.b.a.e.l.q;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.e;
import l.b.a.f;
import l.b.a.g;
import l.b.a.h;
import l.b.a.r;
import l.b.a.t;

public final /* synthetic */ class a2 implements View.OnClickListener {
    public final /* synthetic */ i6 b;
    public final /* synthetic */ h0 c;

    public /* synthetic */ a2(i6 i6Var, h0 h0Var) {
        this.b = i6Var;
        this.c = h0Var;
    }

    public final void onClick(View view) {
        e eVar;
        i6 i6Var = this.b;
        h0 h0Var = this.c;
        Objects.requireNonNull(i6Var);
        if (((Chip) view).isChecked()) {
            if (h0Var == null || h0Var.k() == null) {
                eVar = e.y();
            } else {
                f k2 = h0Var.k();
                h hVar = h.f4363f;
                eVar = t.H(g.F(k2, hVar), r.f4386g).w();
            }
            int checkedChipId = i6Var.h0.c.getCheckedChipId();
            if (i6Var.K0("ShareDiagnosisUploadFragment.DATE_PICKER_TAG") == null && checkedChipId == R.id.has_symptom_confirmed_selected_date_choice) {
                q<Long> J0 = i6Var.J0(eVar);
                J0.m0.add(new d2(i6Var));
                J0.I0(i6Var.v(), "ShareDiagnosisUploadFragment.DATE_PICKER_TAG");
            }
        }
    }
}
