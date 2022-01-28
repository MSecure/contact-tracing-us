package c.b.a.b.x;

import android.view.View;

public class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f3275b;

    public p(o oVar) {
        this.f3275b = oVar;
    }

    public void onClick(View view) {
        o oVar = this.f3275b;
        oVar.r.setEnabled(oVar.g.k());
        this.f3275b.p.toggle();
        o oVar2 = this.f3275b;
        oVar2.j(oVar2.p);
        this.f3275b.g();
    }
}
