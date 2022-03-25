package f.b.a.d.l;

import android.view.View;

public class r implements View.OnClickListener {
    public final /* synthetic */ q b;

    public r(q qVar) {
        this.b = qVar;
    }

    public void onClick(View view) {
        q qVar = this.b;
        qVar.D0.setEnabled(qVar.s0.h());
        this.b.B0.toggle();
        q qVar2 = this.b;
        qVar2.H0(qVar2.B0);
        this.b.F0();
    }
}
