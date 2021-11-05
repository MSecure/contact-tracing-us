package c.b.a.b.x;

import android.view.View;
import b.i.l.a;
import b.i.l.w.b;
import c.b.a.b.j;

public class i extends a {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f3259d;

    public i(g gVar) {
        this.f3259d = gVar;
    }

    @Override // b.i.l.a
    public void d(View view, b bVar) {
        g gVar;
        int i;
        this.f1139a.onInitializeAccessibilityNodeInfo(view, bVar.f1195a);
        if (this.f3259d.l.getVisibility() == 0) {
            gVar = this.f3259d;
            i = j.mtrl_picker_toggle_to_year_selection;
        } else {
            gVar = this.f3259d;
            i = j.mtrl_picker_toggle_to_day_selection;
        }
        bVar.k(gVar.getString(i));
    }
}
