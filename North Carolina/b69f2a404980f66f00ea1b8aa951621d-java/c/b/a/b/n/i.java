package c.b.a.b.n;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.k.i;
import b.i.l.m;
import b.i.l.v;
import com.google.android.material.appbar.AppBarLayout;

public abstract class i extends j<View> {

    /* renamed from: d  reason: collision with root package name */
    public final Rect f3152d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f3153e = new Rect();
    public int f = 0;
    public int g;

    public i() {
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // c.b.a.b.n.j
    public void C(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i2;
        AppBarLayout E = ((AppBarLayout.ScrollingViewBehavior) this).E(coordinatorLayout.d(view));
        if (E != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f3152d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, E.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((E.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            v lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && m.l(coordinatorLayout) && !view.getFitsSystemWindows()) {
                rect.left = lastWindowInsets.c() + rect.left;
                rect.right -= lastWindowInsets.d();
            }
            Rect rect2 = this.f3153e;
            int i3 = fVar.f127c;
            if (i3 == 0) {
                i3 = 8388659;
            }
            Gravity.apply(i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int D = D(E);
            view.layout(rect2.left, rect2.top - D, rect2.right, rect2.bottom - D);
            i2 = rect2.top - E.getBottom();
        } else {
            coordinatorLayout.q(view, i);
            i2 = 0;
        }
        this.f = i2;
    }

    public final int D(View view) {
        int i;
        if (this.g == 0) {
            return 0;
        }
        float f2 = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f125a;
            int D = cVar instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) cVar).D() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + D > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                f2 = 1.0f + (((float) D) / ((float) i));
            }
        }
        int i2 = this.g;
        return i.j.w((int) (f2 * ((float) i2)), 0, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        AppBarLayout E;
        v lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (E = ((AppBarLayout.ScrollingViewBehavior) this).E(coordinatorLayout.d(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (m.l(E) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.b() + lastWindowInsets.e();
        }
        coordinatorLayout.r(view, i, i2, View.MeasureSpec.makeMeasureSpec((size + E.getTotalScrollRange()) - E.getMeasuredHeight(), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }
}
