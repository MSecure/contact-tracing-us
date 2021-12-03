package f.b.a.a.a.s;

import android.view.View;
import com.google.android.material.chip.Chip;
import f.b.a.a.a.b0.h0;
import f.b.a.e.k.q;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;
import l.b.a.e;
import l.b.a.f;
import l.b.a.g;
import l.b.a.h;
import l.b.a.r;
import l.b.a.t;

public final /* synthetic */ class a2 implements View.OnClickListener {
    public final /* synthetic */ j6 b;
    public final /* synthetic */ h0 c;

    public /* synthetic */ a2(j6 j6Var, h0 h0Var) {
        this.b = j6Var;
        this.c = h0Var;
    }

    public final void onClick(View view) {
        e eVar;
        j6 j6Var = this.b;
        h0 h0Var = this.c;
        Objects.requireNonNull(j6Var);
        if (((Chip) view).isChecked()) {
            if (h0Var == null || h0Var.k() == null) {
                eVar = e.y();
            } else {
                f k2 = h0Var.k();
                h hVar = h.f4298f;
                eVar = t.H(g.F(k2, hVar), r.f4321g).w();
            }
            int checkedChipId = j6Var.g0.c.getCheckedChipId();
            if (j6Var.E0("ShareDiagnosisUploadFragment.DATE_PICKER_TAG") == null && checkedChipId == R.id.has_symptom_confirmed_selected_date_choice) {
                q<Long> D0 = j6Var.D0(eVar);
                D0.m0.add(new d2(j6Var));
                D0.D0(j6Var.u(), "ShareDiagnosisUploadFragment.DATE_PICKER_TAG");
            }
        }
    }
}
