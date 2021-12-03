package f.b.a.e.k;

import android.view.View;

public class n implements View.OnClickListener {
    public final /* synthetic */ x b;
    public final /* synthetic */ i c;

    public n(i iVar, x xVar) {
        this.c = iVar;
        this.b = xVar;
    }

    public void onClick(View view) {
        int l1 = this.c.B0().l1() + 1;
        if (l1 < this.c.e0.getAdapter().a()) {
            this.c.D0(this.b.m(l1));
        }
    }
}
