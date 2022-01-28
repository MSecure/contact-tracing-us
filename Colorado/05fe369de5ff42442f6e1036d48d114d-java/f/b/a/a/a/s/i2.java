package f.b.a.a.a.s;

import com.google.android.material.chip.ChipGroup;
import f.b.a.a.a.b0.h0;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class i2 implements ChipGroup.d {
    public final /* synthetic */ j6 a;

    public /* synthetic */ i2(j6 j6Var) {
        this.a = j6Var;
    }

    @Override // com.google.android.material.chip.ChipGroup.d
    public final void a(ChipGroup chipGroup, int i2) {
        h0.e eVar;
        j6 j6Var = this.a;
        Objects.requireNonNull(j6Var);
        if (i2 == -1) {
            eVar = h0.e.NOT_ATTEMPTED;
        } else if (i2 == R.id.no_travel_choice) {
            eVar = h0.e.NOT_TRAVELED;
        } else if (i2 == R.id.skip_travel_history_choice) {
            eVar = h0.e.NO_ANSWER;
        } else if (i2 == R.id.travel_confirmed_choice) {
            eVar = h0.e.TRAVELED;
        } else {
            throw new IllegalStateException("Failed to map checked button to travel status");
        }
        j6Var.a0.o(new c3(eVar));
    }
}
