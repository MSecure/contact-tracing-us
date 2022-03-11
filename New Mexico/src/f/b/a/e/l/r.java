package f.b.a.e.l;

import android.view.View;
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    public final /* synthetic */ q b;

    public r(q qVar) {
        this.b = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar = this.b;
        qVar.C0.setEnabled(qVar.L0().h());
        this.b.A0.toggle();
        q qVar2 = this.b;
        qVar2.R0(qVar2.A0);
        this.b.P0();
    }
}
