package f.b.a.e.a0;

import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.R$id;
import com.google.android.material.timepicker.ClockFaceView;
import e.j.j.c;
import e.j.j.c0.b;
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f2877d;

    public b(ClockFaceView clockFaceView) {
        this.f2877d = clockFaceView;
    }

    @Override // e.j.j.c
    public void d(View view, e.j.j.c0.b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        int intValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
        if (intValue > 0) {
            TextView textView = this.f2877d.B.get(intValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                bVar.a.setTraversalAfter(textView);
            }
        }
        bVar.j(b.c.a(0, 1, intValue, 1, false, view.isSelected()));
    }
}
