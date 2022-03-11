package f.b.a.e.l;

import android.view.View;
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    public final /* synthetic */ x b;
    public final /* synthetic */ i c;

    public o(i iVar, x xVar) {
        this.c = iVar;
        this.b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int n1 = this.c.I0().n1() - 1;
        if (n1 >= 0) {
            this.c.K0(this.b.m(n1));
        }
    }
}
