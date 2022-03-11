package f.b.a.a.a.r;

import android.widget.RadioButton;
import e.p.r;
import f.b.a.a.a.y.c0;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class k1 implements r {
    public final /* synthetic */ i4 a;

    public /* synthetic */ k1(i4 i4Var) {
        this.a = i4Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        int i2;
        i4 i4Var = this.a;
        Objects.requireNonNull(i4Var);
        c0.e m = ((c0) obj).m();
        if (!c0.e.NOT_ATTEMPTED.equals(m)) {
            int ordinal = m.ordinal();
            if (ordinal == 1) {
                i2 = R.id.hasTraveledConfirmed;
            } else if (ordinal == 2) {
                i2 = R.id.hasTraveledNoTravel;
            } else if (ordinal == 3) {
                i2 = R.id.hasTraveledNoAnswer;
            } else {
                throw new IllegalStateException("Failed to map travel status to radio button id");
            }
            ((RadioButton) i4Var.F.findViewById(i2)).setChecked(true);
            i4Var.a0.f2154d.setEnabled(true);
        }
    }
}
