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
        int o1 = this.c.z0().o1() - 1;
        if (o1 >= 0) {
            this.c.B0(this.b.p(o1));
        }
    }
}
