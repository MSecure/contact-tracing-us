package f.b.a.a.a.s;

import android.widget.RadioGroup;
import f.b.a.a.a.b0.v0;
import f.b.b.a.o;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class m2 implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ l6 a;

    public /* synthetic */ m2(l6 l6Var) {
        this.a = l6Var;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
        this.a.a0.w.j(new o(i2 != R.id.no_radio_button ? i2 != R.id.yes_radio_button ? v0.i.UNKNOWN : v0.i.VACCINATED : v0.i.NOT_VACCINATED));
    }
}
