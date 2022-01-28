package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.k.i;
import b.i.l.m;
import c.b.a.b.b0.e;
import c.b.a.b.b0.h;
import c.b.a.b.c0.d;
import c.b.a.b.c0.p;
import c.b.a.b.h0.n;
import c.b.a.b.l;
import c.b.a.b.m.g;
import c.b.a.b.m.j;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FloatingActionButton extends p implements c.b.a.b.a0.a, n, CoordinatorLayout.b {

    /* renamed from: c */
    public ColorStateList f6084c;

    /* renamed from: d */
    public PorterDuff.Mode f6085d;

    /* renamed from: e */
    public ColorStateList f6086e;

    /* renamed from: f */
    public PorterDuff.Mode f6087f;

    /* renamed from: g */
    public ColorStateList f6088g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public final Rect l;
    public e m;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a */
        public Rect f6089a;

        /* renamed from: b */
        public boolean f6090b;

        public BaseBehavior() {
            this.f6090b = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.FloatingActionButton_Behavior_Layout);
            this.f6090b = obtainStyledAttributes.getBoolean(l.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        public boolean B(FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.l;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final boolean C(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            if (this.f6090b && fVar.f191f == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        public final boolean D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!C(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f6089a == null) {
                this.f6089a = new Rect();
            }
            Rect rect = this.f6089a;
            d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.i(null, false);
                return true;
            }
            floatingActionButton.n(null, false);
            return true;
        }

        public final boolean E(View view, FloatingActionButton floatingActionButton) {
            if (!C(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.i(null, false);
                return true;
            }
            floatingActionButton.n(null, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return B((FloatingActionButton) view, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void f(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                D(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f186a instanceof BottomSheetBehavior : false) {
                    E(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List<View> d2 = coordinatorLayout.d(floatingActionButton);
            int size = d2.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = d2.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f186a instanceof BottomSheetBehavior : false) && E(view2, floatingActionButton)) {
                        break;
                    }
                } else if (D(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.q(floatingActionButton, i);
            return true;
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public class b implements c.b.a.b.g0.b {
        public b() {
            FloatingActionButton.this = r1;
        }
    }

    public class c<T extends FloatingActionButton> implements e.AbstractC0072e {

        /* renamed from: a */
        public final j<T> f6092a;

        public c(j<T> jVar) {
            FloatingActionButton.this = r1;
            this.f6092a = jVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.b.a.b.m.j<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.a.b.b0.e.AbstractC0072e
        public void a() {
            this.f6092a.a(FloatingActionButton.this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.b.a.b.m.j<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.a.b.b0.e.AbstractC0072e
        public void b() {
            this.f6092a.b(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && ((c) obj).f6092a.equals(this.f6092a);
        }

        public int hashCode() {
            return this.f6092a.hashCode();
        }
    }

    private e getImpl() {
        if (this.m == null) {
            this.m = new h(this, new b());
        }
        return this.m;
    }

    public static int m(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    @Override // c.b.a.b.a0.a
    public boolean a() {
        throw null;
    }

    public void d(Animator.AnimatorListener animatorListener) {
        e impl = getImpl();
        if (impl.r == null) {
            impl.r = new ArrayList<>();
        }
        impl.r.add(null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().i(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        e impl = getImpl();
        if (impl.q == null) {
            impl.q = new ArrayList<>();
        }
        impl.q.add(animatorListener);
    }

    public void f(j<? extends FloatingActionButton> jVar) {
        e impl = getImpl();
        c cVar = new c(null);
        if (impl.s == null) {
            impl.s = new ArrayList<>();
        }
        impl.s.add(cVar);
    }

    public boolean g(Rect rect) {
        if (!m.C(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        throw null;
    }

    public ColorStateList getBackgroundTintList() {
        return this.f6084c;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f6085d;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().c();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f4175f;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f4176g;
    }

    public Drawable getContentBackground() {
        if (getImpl() != null) {
            return null;
        }
        throw null;
    }

    public int getCustomSize() {
        return this.i;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public g getHideMotionSpec() {
        return getImpl().m;
    }

    public int getRippleColor() {
        ColorStateList colorStateList = this.f6088g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f6088g;
    }

    public c.b.a.b.h0.j getShapeAppearanceModel() {
        c.b.a.b.h0.j jVar = getImpl().f4170a;
        i.j.g(jVar);
        return jVar;
    }

    public g getShowMotionSpec() {
        return getImpl().l;
    }

    public int getSize() {
        return this.h;
    }

    public int getSizeDimension() {
        return h(this.h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f6086e;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f6087f;
    }

    public boolean getUseCompatPadding() {
        return this.k;
    }

    public final int h(int i2) {
        int i3 = this.i;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 == -1) {
            return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? h(1) : h(0);
        }
        return resources.getDimensionPixelSize(i2 != 1 ? c.b.a.b.d.design_fab_size_normal : c.b.a.b.d.design_fab_size_mini);
    }

    public void i(a aVar, boolean z) {
        e impl = getImpl();
        c.b.a.b.b0.b bVar = aVar == null ? null : new c.b.a.b.b0.b(this, aVar);
        if (!impl.e()) {
            Animator animator = impl.k;
            if (animator != null) {
                animator.cancel();
            }
            if (impl.q()) {
                g gVar = impl.m;
                if (gVar == null) {
                    if (impl.j == null) {
                        impl.j = g.b(impl.t.getContext(), c.b.a.b.a.design_fab_hide_motion_spec);
                    }
                    gVar = impl.j;
                    i.j.g(gVar);
                }
                AnimatorSet a2 = impl.a(gVar, 0.0f, 0.0f, 0.0f);
                a2.addListener(new c.b.a.b.b0.c(impl, z, bVar));
                ArrayList<Animator.AnimatorListener> arrayList = impl.r;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            impl.t.b(z ? 8 : 4, z);
            if (bVar != null) {
                bVar.f4161a.a(bVar.f4162b);
            }
        }
    }

    public boolean j() {
        return getImpl().e();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    public boolean k() {
        return getImpl().f();
    }

    public final void l() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f6086e;
            if (colorStateList == null) {
                drawable.clearColorFilter();
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f6087f;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(b.b.q.j.c(colorForState, mode));
        }
    }

    public void n(a aVar, boolean z) {
        e impl = getImpl();
        c.b.a.b.b0.b bVar = aVar == null ? null : new c.b.a.b.b0.b(this, aVar);
        if (!impl.f()) {
            Animator animator = impl.k;
            if (animator != null) {
                animator.cancel();
            }
            if (impl.q()) {
                if (impl.t.getVisibility() != 0) {
                    impl.t.setAlpha(0.0f);
                    impl.t.setScaleY(0.0f);
                    impl.t.setScaleX(0.0f);
                    impl.n(0.0f);
                }
                g gVar = impl.l;
                if (gVar == null) {
                    if (impl.i == null) {
                        impl.i = g.b(impl.t.getContext(), c.b.a.b.a.design_fab_show_motion_spec);
                    }
                    gVar = impl.i;
                    i.j.g(gVar);
                }
                AnimatorSet a2 = impl.a(gVar, 1.0f, 1.0f, 1.0f);
                a2.addListener(new c.b.a.b.b0.d(impl, z, bVar));
                ArrayList<Animator.AnimatorListener> arrayList = impl.q;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            impl.t.b(0, z);
            impl.t.setAlpha(1.0f);
            impl.t.setScaleY(1.0f);
            impl.t.setScaleX(1.0f);
            impl.n(1.0f);
            if (bVar != null) {
                bVar.f4161a.b(bVar.f4162b);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e impl = getImpl();
        if (impl.m()) {
            ViewTreeObserver viewTreeObserver = impl.t.getViewTreeObserver();
            if (impl.z == null) {
                impl.z = new c.b.a.b.b0.g(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.z);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.t.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.z;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.z = null;
        }
    }

    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.j = (sizeDimension + 0) / 2;
        getImpl().t();
        Math.min(m(sizeDimension, i2), m(sizeDimension, i3));
        throw null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c.b.a.b.j0.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c.b.a.b.j0.a aVar = (c.b.a.b.j0.a) parcelable;
        super.onRestoreInstanceState(aVar.f1952b);
        i.j.g(aVar.f4348d.getOrDefault("expandableWidgetHelper", null));
        throw null;
    }

    public Parcelable onSaveInstanceState() {
        if (super.onSaveInstanceState() == null) {
            new Bundle();
        }
        b.k.a.a aVar = b.k.a.a.f1951c;
        throw null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            g(null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i2) {
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i2) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f6084c != colorStateList) {
            this.f6084c = colorStateList;
            if (getImpl() == null) {
                throw null;
            }
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f6085d != mode) {
            this.f6085d = mode;
            if (getImpl() == null) {
                throw null;
            }
        }
    }

    public void setCompatElevation(float f2) {
        e impl = getImpl();
        if (impl.f4174e != f2) {
            impl.f4174e = f2;
            impl.j(f2, impl.f4175f, impl.f4176g);
        }
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        e impl = getImpl();
        if (impl.f4175f != f2) {
            impl.f4175f = f2;
            impl.j(impl.f4174e, f2, impl.f4176g);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        e impl = getImpl();
        if (impl.f4176g != f2) {
            impl.f4176g = f2;
            impl.j(impl.f4174e, impl.f4175f, f2);
        }
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i2 != this.i) {
            this.i = i2;
            requestLayout();
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        if (getImpl() == null) {
            throw null;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().f4172c) {
            getImpl().f4172c = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i2) {
        throw null;
    }

    public void setHideMotionSpec(g gVar) {
        getImpl().m = gVar;
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(g.b(getContext(), i2));
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            e impl = getImpl();
            impl.n(impl.o);
            if (this.f6086e != null) {
                l();
            }
        }
    }

    public void setImageResource(int i2) {
        throw null;
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f6088g != colorStateList) {
            this.f6088g = colorStateList;
            getImpl().o(this.f6088g);
        }
    }

    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().k();
    }

    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().k();
    }

    public void setShadowPaddingEnabled(boolean z) {
        e impl = getImpl();
        impl.f4173d = z;
        impl.t();
    }

    @Override // c.b.a.b.h0.n
    public void setShapeAppearanceModel(c.b.a.b.h0.j jVar) {
        getImpl().f4170a = jVar;
    }

    public void setShowMotionSpec(g gVar) {
        getImpl().l = gVar;
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(g.b(getContext(), i2));
    }

    public void setSize(int i2) {
        this.i = 0;
        if (i2 != this.h) {
            this.h = i2;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f6086e != colorStateList) {
            this.f6086e = colorStateList;
            l();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f6087f != mode) {
            this.f6087f = mode;
            l();
        }
    }

    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().l();
    }

    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().l();
    }

    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().l();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.k != z) {
            this.k = z;
            getImpl().h();
        }
    }

    @Override // c.b.a.b.c0.p
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }
}
