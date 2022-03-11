package f.b.a.a.a.s;

import android.widget.Button;
import e.p.r;

public final /* synthetic */ class j implements r {
    public final /* synthetic */ y a;

    public /* synthetic */ j(y yVar) {
        this.a = yVar;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        y yVar = this.a;
        Boolean bool = (Boolean) obj;
        yVar.e0.setEnabled(!bool.booleanValue());
        yVar.a0.f2122h.setEnabled(!bool.booleanValue());
        int i2 = 0;
        yVar.a0.f2123i.setVisibility(bool.booleanValue() ? 0 : 4);
        Button button = yVar.e0;
        if (bool.booleanValue()) {
            i2 = 4;
        }
        button.setVisibility(i2);
    }
}
