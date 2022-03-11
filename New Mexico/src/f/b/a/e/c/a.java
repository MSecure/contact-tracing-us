package f.b.a.e.c;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import e.j.j.c0.d;
import e.j.j.v;
import f.b.a.e.w.l;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class a implements d {
    public final /* synthetic */ SwipeDismissBehavior a;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.a = swipeDismissBehavior;
    }

    @Override // e.j.j.c0.d
    public boolean a(View view, d.a aVar) {
        boolean z = false;
        if (!this.a.B(view)) {
            return false;
        }
        AtomicInteger atomicInteger = v.a;
        boolean z2 = v.e.d(view) == 1;
        int i2 = this.a.f508d;
        if ((i2 == 0 && z2) || (i2 == 1 && !z2)) {
            z = true;
        }
        int width = view.getWidth();
        if (z) {
            width = -width;
        }
        v.n(view, width);
        view.setAlpha(0.0f);
        SwipeDismissBehavior.b bVar = this.a.b;
        if (bVar != null) {
            ((l) bVar).a(view);
        }
        return true;
    }
}
