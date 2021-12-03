package f.b.a.a.a.d0;

import android.widget.RadioGroup;
import f.b.a.a.a.l0.v0;
import f.b.b.a.o;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class m2 implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ k6 a;

    public /* synthetic */ m2(k6 k6Var) {
        this.a = k6Var;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
        this.a.b0.w.j(new o(i2 != R.id.no_radio_button ? i2 != R.id.yes_radio_button ? v0.i.UNKNOWN : v0.i.VACCINATED : v0.i.NOT_VACCINATED));
    }
}
