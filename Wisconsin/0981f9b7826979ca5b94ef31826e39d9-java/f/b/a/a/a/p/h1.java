package f.b.a.a.a.p;

import android.widget.RadioGroup;
import f.b.a.a.a.w.b0;
import gov.wi.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class h1 implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ w3 a;

    public /* synthetic */ h1(w3 w3Var) {
        this.a = w3Var;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
        b0.e eVar;
        w3 w3Var = this.a;
        Objects.requireNonNull(w3Var);
        switch (i2) {
            case R.id.hasTraveledConfirmed /*{ENCODED_INT: 2131362017}*/:
                eVar = b0.e.TRAVELED;
                break;
            case R.id.hasTraveledNoAnswer /*{ENCODED_INT: 2131362018}*/:
                eVar = b0.e.NO_ANSWER;
                break;
            case R.id.hasTraveledNoTravel /*{ENCODED_INT: 2131362019}*/:
                eVar = b0.e.NOT_TRAVELED;
                break;
            default:
                throw new IllegalStateException("Failed to map checked button to travel status");
        }
        w3Var.Z.j(new k2(eVar));
    }
}
