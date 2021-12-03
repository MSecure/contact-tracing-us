package f.b.a.e.b;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import e.b.a.m;
import e.i.i.b0;
import e.i.i.v;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class f extends g<View> {
    public final Rect c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public final Rect f2845d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public int f2846e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f2847f;

    public f() {
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // f.b.a.e.b.g
    public void C(CoordinatorLayout coordinatorLayout, View view, int i2) {
        int i3;
        AppBarLayout F = ((AppBarLayout.ScrollingViewBehavior) this).F(coordinatorLayout.d(view));
        if (F != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.c;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, F.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((F.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            b0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null) {
                AtomicInteger atomicInteger = v.a;
                if (v.d.b(coordinatorLayout) && !v.d.b(view)) {
                    rect.left = lastWindowInsets.b() + rect.left;
                    rect.right -= lastWindowInsets.c();
                }
            }
            Rect rect2 = this.f2845d;
            int i4 = fVar.c;
            Gravity.apply(i4 == 0 ? 8388659 : i4, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int E = E(F);
            view.layout(rect2.left, rect2.top - E, rect2.right, rect2.bottom - E);
            i3 = rect2.top - F.getBottom();
        } else {
            coordinatorLayout.r(view, i2);
            i3 = 0;
        }
        this.f2846e = i3;
    }

    public final int E(View view) {
        int i2;
        if (this.f2847f == 0) {
            return 0;
        }
        float f2 = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).a;
            int E = cVar instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) cVar).E() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + E > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                f2 = 1.0f + (((float) E) / ((float) i2));
            }
        }
        int i3 = this.f2847f;
        return m.e.v((int) (f2 * ((float) i3)), 0, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        AppBarLayout F;
        b0 lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (F = ((AppBarLayout.ScrollingViewBehavior) this).F(coordinatorLayout.d(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size > 0) {
            AtomicInteger atomicInteger = v.a;
            if (v.d.b(F) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.a() + lastWindowInsets.d();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.s(view, i2, i3, View.MeasureSpec.makeMeasureSpec((size + F.getTotalScrollRange()) - F.getMeasuredHeight(), i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
        return true;
    }
}
