package f.b.a.e.l;

import android.view.View;
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    public final /* synthetic */ x b;
    public final /* synthetic */ i c;

    public n(i iVar, x xVar) {
        this.c = iVar;
        this.b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int l1 = this.c.I0().l1() + 1;
        if (l1 < this.c.e0.getAdapter().a()) {
            this.c.K0(this.b.m(l1));
        }
    }
}
