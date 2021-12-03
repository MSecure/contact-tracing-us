package f.b.a.a.a.d0;

import android.text.Editable;
import f.b.a.a.a.s.n;
import gov.ut.covid19.exposurenotifications.R;
import l.b.a.f;

public class h6 extends n {
    public final /* synthetic */ i6 b;

    public h6(i6 i6Var) {
        this.b = i6Var;
    }

    public void afterTextChanged(Editable editable) {
        i6 i6Var = this.b;
        int checkedChipId = i6Var.h0.c.getCheckedChipId();
        String charSequence = i6Var.h0.f2383d.getText().toString();
        if (checkedChipId == R.id.has_symptom_confirmed_selected_date_choice && i6Var.M0(charSequence, b2.a)) {
            i6Var.b0.o(new q3(f.T(charSequence, i6Var.L0())));
        }
    }
}
