package f.b.a.d.d;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import e.i.i.m;
import e.i.i.x.d;
import java.util.concurrent.atomic.AtomicInteger;

public class a implements d {
    public final /* synthetic */ SwipeDismissBehavior a;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.a = swipeDismissBehavior;
    }

    @Override // e.i.i.x.d
    public boolean a(View view, d.a aVar) {
        boolean z = false;
        if (!this.a.B(view)) {
            return false;
        }
        AtomicInteger atomicInteger = m.a;
        boolean z2 = view.getLayoutDirection() == 1;
        int i2 = this.a.f472d;
        if ((i2 == 0 && z2) || (i2 == 1 && !z2)) {
            z = true;
        }
        int width = view.getWidth();
        if (z) {
            width = -width;
        }
        m.l(view, width);
        view.setAlpha(0.0f);
        SwipeDismissBehavior.b bVar = this.a.b;
        if (bVar != null) {
            ((f.b.a.d.w.m) bVar).a(view);
        }
        return true;
    }
}
