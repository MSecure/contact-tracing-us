package f.b.a.a.a.s;

import com.google.android.material.chip.ChipGroup;
import f.b.a.a.a.b0.h0;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class j2 implements ChipGroup.d {
    public final /* synthetic */ j6 a;

    public /* synthetic */ j2(j6 j6Var) {
        this.a = j6Var;
    }

    @Override // com.google.android.material.chip.ChipGroup.d
    public final void a(ChipGroup chipGroup, int i2) {
        this.a.a0.o(new l3(i2 != R.id.has_symptom_confirmed_selected_date_choice ? i2 != R.id.skip_symptom_date_choice ? h0.b.UNSET : h0.b.WITHHELD : h0.b.YES));
    }
}
