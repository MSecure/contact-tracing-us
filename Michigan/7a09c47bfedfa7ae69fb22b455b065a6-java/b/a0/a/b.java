package b.a0.a;

import android.graphics.Rect;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import b.i.l.j;
import b.i.l.m;
import b.i.l.v;

public class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f507a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPager f508b;

    public b(ViewPager viewPager) {
        this.f508b = viewPager;
    }

    @Override // b.i.l.j
    public v a(View view, v vVar) {
        v J = m.J(view, vVar);
        if (J.g()) {
            return J;
        }
        Rect rect = this.f507a;
        rect.left = J.b();
        rect.top = J.d();
        rect.right = J.c();
        rect.bottom = J.a();
        int childCount = this.f508b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            v c2 = m.c(this.f508b.getChildAt(i), J);
            rect.left = Math.min(c2.b(), rect.left);
            rect.top = Math.min(c2.d(), rect.top);
            rect.right = Math.min(c2.c(), rect.right);
            rect.bottom = Math.min(c2.a(), rect.bottom);
        }
        return J.h(rect.left, rect.top, rect.right, rect.bottom);
    }
}
