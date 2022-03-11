package e.b.f;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
public class n0 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ o0 b;

    public n0(o0 o0Var) {
        this.b = o0Var;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        j0 j0Var;
        if (i2 != -1 && (j0Var = this.b.f1004d) != null) {
            j0Var.setListSelectionHidden(false);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
