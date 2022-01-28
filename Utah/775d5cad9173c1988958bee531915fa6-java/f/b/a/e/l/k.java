package f.b.a.e.l;

import android.view.View;
import com.google.android.material.R$string;
import e.i.i.c;
import e.i.i.c0.b;

public class k extends c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i f2903d;

    public k(i iVar) {
        this.f2903d = iVar;
    }

    @Override // e.i.i.c
    public void d(View view, b bVar) {
        i iVar;
        int i2;
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        if (this.f2903d.g0.getVisibility() == 0) {
            iVar = this.f2903d;
            i2 = R$string.mtrl_picker_toggle_to_year_selection;
        } else {
            iVar = this.f2903d;
            i2 = R$string.mtrl_picker_toggle_to_day_selection;
        }
        bVar.k(iVar.E(i2));
    }
}
