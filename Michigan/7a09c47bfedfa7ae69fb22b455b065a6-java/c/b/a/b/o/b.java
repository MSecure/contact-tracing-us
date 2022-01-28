package c.b.a.b.o;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

public class b {
    public static void a(a aVar, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        if (view != null) {
            view.getDrawingRect(rect);
            aVar.setBounds(rect);
            aVar.p = new WeakReference<>(view);
            aVar.q = new WeakReference<>(frameLayout);
            aVar.e();
            aVar.invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Trying to reference null badgeParent");
    }
}
