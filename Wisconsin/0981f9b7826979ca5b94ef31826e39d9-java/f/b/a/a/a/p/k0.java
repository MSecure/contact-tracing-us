package f.b.a.a.a.p;

import android.widget.EditText;
import android.widget.RadioGroup;
import gov.wi.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class k0 implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ q3 a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ RadioGroup c;

    public /* synthetic */ k0(q3 q3Var, EditText editText, RadioGroup radioGroup) {
        this.a = q3Var;
        this.b = editText;
        this.c = radioGroup;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
        q3 q3Var = this.a;
        EditText editText = this.b;
        RadioGroup radioGroup2 = this.c;
        Objects.requireNonNull(q3Var);
        editText.setEnabled(i2 == R.id.has_symptoms_yes);
        q3Var.B0(radioGroup2, editText);
    }
}
