package f.b.a.a.a.d0;

import com.google.android.material.chip.ChipGroup;
import f.b.a.a.a.l0.h0;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class i2 implements ChipGroup.d {
    public final /* synthetic */ i6 a;

    public /* synthetic */ i2(i6 i6Var) {
        this.a = i6Var;
    }

    @Override // com.google.android.material.chip.ChipGroup.d
    public final void a(ChipGroup chipGroup, int i2) {
        h0.e eVar;
        i6 i6Var = this.a;
        Objects.requireNonNull(i6Var);
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
        i6Var.b0.o(new c3(eVar));
    }
}
