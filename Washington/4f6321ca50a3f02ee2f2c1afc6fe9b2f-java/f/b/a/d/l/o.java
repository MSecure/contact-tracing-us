package f.b.a.d.l;

import android.view.View;

public class o implements View.OnClickListener {
    public final /* synthetic */ x b;
    public final /* synthetic */ i c;

    public o(i iVar, x xVar) {
        this.c = iVar;
        this.b = xVar;
    }

    public void onClick(View view) {
        int n1 = this.c.z0().n1() - 1;
        if (n1 >= 0) {
            this.c.B0(this.b.p(n1));
        }
    }
}
