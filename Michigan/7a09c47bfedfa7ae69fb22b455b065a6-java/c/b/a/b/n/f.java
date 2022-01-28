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
import com.google.android.gms.nearby.messages.BleSignal;
import com.google.android.material.appbar.AppBarLayout;

public abstract class f extends g<View> {

    /* renamed from: d  reason: collision with root package name */
    public final Rect f4453d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f4454e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public int f4455f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f4456g;

    public f() {
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // c.b.a.b.n.g
    public void C(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i2;
        AppBarLayout F = ((AppBarLayout.ScrollingViewBehavior) this).F(coordinatorLayout.d(view));
        if (F != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f4453d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, F.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((F.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            v lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && m.m(coordinatorLayout) && !view.getFitsSystemWindows()) {
                rect.left = lastWindowInsets.b() + rect.left;
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.f4454e;
            int i3 = fVar.f188c;
            if (i3 == 0) {
                i3 = 8388659;
            }
            Gravity.apply(i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int E = E(F);
            view.layout(rect2.left, rect2.top - E, rect2.right, rect2.bottom - E);
            i2 = rect2.top - F.getBottom();
        } else {
            coordinatorLayout.q(view, i);
            i2 = 0;
        }
        this.f4455f = i2;
    }

    public final int E(View view) {
        int i;
        if (this.f4456g == 0) {
            return 0;
        }
        float f2 = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f186a;
            int E = cVar instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) cVar).E() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + E > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                f2 = 1.0f + (((float) E) / ((float) i));
            }
        }
        int i2 = this.f4456g;
        return i.j.j((int) (f2 * ((float) i2)), 0, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        AppBarLayout F;
        v lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (F = ((AppBarLayout.ScrollingViewBehavior) this).F(coordinatorLayout.d(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (m.m(F) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.a() + lastWindowInsets.d();
        }
        coordinatorLayout.r(view, i, i2, View.MeasureSpec.makeMeasureSpec((size + F.getTotalScrollRange()) - F.getMeasuredHeight(), i5 == -1 ? 1073741824 : BleSignal.UNKNOWN_TX_POWER), i4);
        return true;
    }
}
