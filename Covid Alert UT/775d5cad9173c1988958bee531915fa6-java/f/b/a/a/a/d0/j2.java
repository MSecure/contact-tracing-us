package f.b.a.a.a.d0;

import com.google.android.material.chip.ChipGroup;
import f.b.a.a.a.l0.h0;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class j2 implements ChipGroup.d {
    public final /* synthetic */ i6 a;

    public /* synthetic */ j2(i6 i6Var) {
        this.a = i6Var;
    }

    @Override // com.google.android.material.chip.ChipGroup.d
    public final void a(ChipGroup chipGroup, int i2) {
        this.a.b0.o(new l3(i2 != R.id.has_symptom_confirmed_selected_date_choice ? i2 != R.id.skip_symptom_date_choice ? h0.b.UNSET : h0.b.WITHHELD : h0.b.YES));
    }
}
