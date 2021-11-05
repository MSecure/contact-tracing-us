package c.b.a.b.n0;

import android.view.View;
import b.i.l.a;
import b.i.l.w.b;
import c.b.a.b.f;
import com.google.android.material.timepicker.ClockFaceView;

public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f4468d;

    public b(ClockFaceView clockFaceView) {
        this.f4468d = clockFaceView;
    }

    @Override // b.i.l.a
    public void d(View view, b.i.l.w.b bVar) {
        this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
        int intValue = ((Integer) view.getTag(f.material_value_index)).intValue();
        if (intValue > 0) {
            bVar.f1906a.setTraversalAfter(this.f4468d.A.get(intValue - 1));
        }
        bVar.j(b.c.a(0, 1, intValue, 1, false, view.isSelected()));
    }
}
