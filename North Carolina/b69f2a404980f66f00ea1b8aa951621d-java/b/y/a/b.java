package b.y.a;

import android.graphics.Rect;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import b.i.l.j;
import b.i.l.m;
import b.i.l.v;

public class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f1884a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPager f1885b;

    public b(ViewPager viewPager) {
        this.f1885b = viewPager;
    }

    @Override // b.i.l.j
    public v a(View view, v vVar) {
        v I = m.I(view, vVar);
        if (I.h()) {
            return I;
        }
        Rect rect = this.f1884a;
        rect.left = I.c();
        rect.top = I.e();
        rect.right = I.d();
        rect.bottom = I.b();
        int childCount = this.f1885b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            v c2 = m.c(this.f1885b.getChildAt(i), I);
            rect.left = Math.min(c2.c(), rect.left);
            rect.top = Math.min(c2.e(), rect.top);
            rect.right = Math.min(c2.d(), rect.right);
            rect.bottom = Math.min(c2.b(), rect.bottom);
        }
        return I.i(rect.left, rect.top, rect.right, rect.bottom);
    }
}
