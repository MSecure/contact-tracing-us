package f.b.a.a.a.r;

import android.widget.RadioGroup;
import f.b.a.a.a.y.c0;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class o1 implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ i4 a;

    public /* synthetic */ o1(i4 i4Var) {
        this.a = i4Var;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
        c0.e eVar;
        i4 i4Var = this.a;
        Objects.requireNonNull(i4Var);
        switch (i2) {
            case R.id.hasTraveledConfirmed /*{ENCODED_INT: 2131362025}*/:
                eVar = c0.e.TRAVELED;
                break;
            case R.id.hasTraveledNoAnswer /*{ENCODED_INT: 2131362026}*/:
                eVar = c0.e.NO_ANSWER;
                break;
            case R.id.hasTraveledNoTravel /*{ENCODED_INT: 2131362027}*/:
                eVar = c0.e.NOT_TRAVELED;
                break;
            default:
                throw new IllegalStateException("Failed to map checked button to travel status");
        }
        i4Var.b0.j(new t2(eVar));
    }
}
