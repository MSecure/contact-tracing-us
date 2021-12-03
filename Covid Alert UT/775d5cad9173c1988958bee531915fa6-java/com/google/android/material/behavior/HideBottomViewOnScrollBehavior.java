package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public int a = 0;
    public int b = 2;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public ViewPropertyAnimator f495d;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f495d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void B(V v, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f495d = v.animate().translationY((float) i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i2) {
        this.a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        boolean z = true;
        boolean z2 = false;
        if (i3 > 0) {
            if (this.b == 1) {
                z2 = true;
            }
            if (!z2) {
                ViewPropertyAnimator viewPropertyAnimator = this.f495d;
                if (viewPropertyAnimator != null) {
                    viewPropertyAnimator.cancel();
                    v.clearAnimation();
                }
                this.b = 1;
                B(v, this.a + this.c, 175, f.b.a.e.a.a.c);
            }
        } else if (i3 < 0) {
            if (this.b != 2) {
                z = false;
            }
            if (!z) {
                ViewPropertyAnimator viewPropertyAnimator2 = this.f495d;
                if (viewPropertyAnimator2 != null) {
                    viewPropertyAnimator2.cancel();
                    v.clearAnimation();
                }
                this.b = 2;
                B(v, 0, 225, f.b.a.e.a.a.f2831d);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean x(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        return i2 == 2;
    }
}
