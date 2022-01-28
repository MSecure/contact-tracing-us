package f.b.a.e.a0;

import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.R$id;
import com.google.android.material.timepicker.ClockFaceView;
import e.i.i.c;
import e.i.i.c0.b;

public class b extends c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f2835d;

    public b(ClockFaceView clockFaceView) {
        this.f2835d = clockFaceView;
    }

    @Override // e.i.i.c
    public void d(View view, e.i.i.c0.b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        int intValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
        if (intValue > 0) {
            TextView textView = this.f2835d.B.get(intValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                bVar.a.setTraversalAfter(textView);
            }
        }
        bVar.j(b.c.a(0, 1, intValue, 1, false, view.isSelected()));
    }
}
