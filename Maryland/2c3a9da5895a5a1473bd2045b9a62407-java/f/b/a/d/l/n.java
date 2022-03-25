package f.b.a.d.l;

import android.view.View;

public class n implements View.OnClickListener {
    public final /* synthetic */ x b;
    public final /* synthetic */ i c;

    public n(i iVar, x xVar) {
        this.c = iVar;
        this.b = xVar;
    }

    public void onClick(View view) {
        int m1 = this.c.z0().m1() + 1;
        if (m1 < this.c.f0.getAdapter().c()) {
            this.c.B0(this.b.p(m1));
        }
    }
}
