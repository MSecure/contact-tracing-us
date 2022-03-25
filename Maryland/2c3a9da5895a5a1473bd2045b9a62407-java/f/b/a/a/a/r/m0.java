package f.b.a.a.a.r;

import android.widget.RadioGroup;
import f.b.a.a.a.i.w;
import gov.md.covid19.exposurenotifications.R;

public final /* synthetic */ class m0 implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ c4 a;

    public /* synthetic */ m0(c4 c4Var) {
        this.a = c4Var;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
        c4 c4Var = this.a;
        c4Var.b0.f2150i.setEnabled(i2 == R.id.has_symptoms_yes);
        w wVar = c4Var.b0;
        c4Var.B0(wVar.c, wVar.f2150i);
    }
}
