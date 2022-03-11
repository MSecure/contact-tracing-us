package f.b.a.d.b0;

import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.R$id;
import com.google.android.material.timepicker.ClockFaceView;
import e.i.i.a;
import e.i.i.x.b;

public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f2671d;

    public b(ClockFaceView clockFaceView) {
        this.f2671d = clockFaceView;
    }

    @Override // e.i.i.a
    public void d(View view, e.i.i.x.b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        int intValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
        if (intValue > 0) {
            TextView textView = this.f2671d.A.get(intValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                bVar.a.setTraversalAfter(textView);
            }
        }
        bVar.j(b.c.a(0, 1, intValue, 1, false, view.isSelected()));
    }
}
