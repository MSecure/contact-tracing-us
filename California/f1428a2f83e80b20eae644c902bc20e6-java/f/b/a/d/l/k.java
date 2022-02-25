package f.b.a.d.l;

import android.view.View;
import com.google.android.material.R$string;
import e.i.i.a;
import e.i.i.w.b;

public class k extends a {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i f2634d;

    public k(i iVar) {
        this.f2634d = iVar;
    }

    @Override // e.i.i.a
    public void d(View view, b bVar) {
        i iVar;
        int i2;
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        if (this.f2634d.g0.getVisibility() == 0) {
            iVar = this.f2634d;
            i2 = R$string.mtrl_picker_toggle_to_year_selection;
        } else {
            iVar = this.f2634d;
            i2 = R$string.mtrl_picker_toggle_to_day_selection;
        }
        bVar.k(iVar.z(i2));
    }
}
