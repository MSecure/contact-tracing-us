package f.b.a.a.a.s;

import android.text.Editable;
import f.b.a.a.a.i.n;
import gov.co.cdphe.exposurenotifications.R;
import l.b.a.f;

public class i6 extends n {
    public final /* synthetic */ j6 b;

    public i6(j6 j6Var) {
        this.b = j6Var;
    }

    public void afterTextChanged(Editable editable) {
        j6 j6Var = this.b;
        int checkedChipId = j6Var.g0.c.getCheckedChipId();
        String charSequence = j6Var.g0.f2188d.getText().toString();
        if (checkedChipId == R.id.has_symptom_confirmed_selected_date_choice && j6Var.G0(charSequence, b2.a)) {
            j6Var.a0.o(new q3(f.T(charSequence, j6Var.F0())));
        }
    }
}
