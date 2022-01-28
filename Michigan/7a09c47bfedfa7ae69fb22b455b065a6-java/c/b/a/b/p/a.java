package c.b.a.b.p;

import android.view.View;
import b.i.l.m;
import b.i.l.w.d;
import c.b.a.b.i0.l;
import com.google.android.material.behavior.SwipeDismissBehavior;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f4487a;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.f4487a = swipeDismissBehavior;
    }

    @Override // b.i.l.w.d
    public boolean a(View view, d.a aVar) {
        boolean z = false;
        if (!this.f4487a.B(view)) {
            return false;
        }
        boolean z2 = m.p(view) == 1;
        if ((this.f4487a.f6015e == 0 && z2) || (this.f4487a.f6015e == 1 && !z2)) {
            z = true;
        }
        int width = view.getWidth();
        if (z) {
            width = -width;
        }
        view.offsetLeftAndRight(width);
        view.setAlpha(0.0f);
        SwipeDismissBehavior.b bVar = this.f4487a.f6012b;
        if (bVar != null) {
            ((l) bVar).a(view);
        }
        return true;
    }
}
