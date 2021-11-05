package c.b.a.b.x;

import android.view.View;
import c.b.a.b.x.g;

public class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f3263b;

    public k(g gVar) {
        this.f3263b = gVar;
    }

    public void onClick(View view) {
        g gVar = this.f3263b;
        g.e eVar = g.e.DAY;
        g.e eVar2 = g.e.YEAR;
        g.e eVar3 = gVar.g;
        if (eVar3 == eVar2) {
            gVar.h(eVar);
        } else if (eVar3 == eVar) {
            gVar.h(eVar2);
        }
    }
}
