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
import com.google.android.material.R$animator;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e.b.a.m;
import e.i.i.m;
import f.b.a.e.a.j;
import f.b.a.e.o.d;
import f.b.a.e.o.f;
import f.b.a.e.o.g;
import f.b.a.e.p.q;
import f.b.a.e.u.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class FloatingActionButton extends q implements f.b.a.e.n.a, n, CoordinatorLayout.b {
    public ColorStateList c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f568d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f569e;

    /* renamed from: f  reason: collision with root package name */
    public PorterDuff.Mode f570f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f571g;

    /* renamed from: h  reason: collision with root package name */
    public int f572h;

    /* renamed from: i  reason: collision with root package name */
    public int f573i;

    /* renamed from: j  reason: collision with root package name */
    public int f574j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f575k;

    /* renamed from: l  reason: collision with root package name */
    public d f576l;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {
        public Rect a;
        public boolean b;

        public BaseBehavior() {
            this.b = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.b = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        public boolean B(FloatingActionButton floatingActionButton, Rect rect) {
            Objects.requireNonNull(floatingActionButton);
            floatingActionButton.getLeft();
            throw null;
        }

        public final boolean C(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            if (this.b && fVar.f144f == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        public final boolean D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!C(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            f.b.a.e.p.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.i(null, false);
                return true;
            }
            floatingActionButton.m(null, false);
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
            floatingActionButton.m(null, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return B((FloatingActionButton) view, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void f(CoordinatorLayout.f fVar) {
            if (fVar.f146h == 0) {
                fVar.f146h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                D(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).a instanceof BottomSheetBehavior : false) {
                    E(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List<View> d2 = coordinatorLayout.d(floatingActionButton);
            int size = d2.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view2 = d2.get(i3);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).a instanceof BottomSheetBehavior : false) && E(view2, floatingActionButton)) {
                        break;
                    }
                } else if (D(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.r(floatingActionButton, i2);
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

    public class b implements f.b.a.e.t.b {
        public b() {
        }
    }

    public class c<T extends FloatingActionButton> implements d.e {
        public final j<T> a;

        public c(j<T> jVar) {
            this.a = jVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: f.b.a.e.a.j<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.a.e.o.d.e
        public void a() {
            this.a.a(FloatingActionButton.this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: f.b.a.e.a.j<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.a.e.o.d.e
        public void b() {
            this.a.b(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && ((c) obj).a.equals(this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    private d getImpl() {
        if (this.f576l == null) {
            this.f576l = new g(this, new b());
        }
        return this.f576l;
    }

    @Override // f.b.a.e.n.a
    public boolean a() {
        throw null;
    }

    public void d(Animator.AnimatorListener animatorListener) {
        d impl = getImpl();
        if (impl.q == null) {
            impl.q = new ArrayList<>();
        }
        impl.q.add(null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().i(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        d impl = getImpl();
        if (impl.p == null) {
            impl.p = new ArrayList<>();
        }
        impl.p.add(animatorListener);
    }

    public void f(j<? extends FloatingActionButton> jVar) {
        d impl = getImpl();
        c cVar = new c(null);
        if (impl.r == null) {
            impl.r = new ArrayList<>();
        }
        impl.r.add(cVar);
    }

    @Deprecated
    public boolean g(Rect rect) {
        AtomicInteger atomicInteger = m.a;
        if (!isLaidOut()) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        throw null;
    }

    public ColorStateList getBackgroundTintList() {
        return this.c;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f568d;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().c();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f2870e;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f2871f;
    }

    public Drawable getContentBackground() {
        Objects.requireNonNull(getImpl());
        return null;
    }

    public int getCustomSize() {
        return this.f573i;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public f.b.a.e.a.g getHideMotionSpec() {
        return getImpl().f2877l;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f571g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f571g;
    }

    public f.b.a.e.u.j getShapeAppearanceModel() {
        f.b.a.e.u.j jVar = getImpl().a;
        Objects.requireNonNull(jVar);
        return jVar;
    }

    public f.b.a.e.a.g getShowMotionSpec() {
        return getImpl().f2876k;
    }

    public int getSize() {
        return this.f572h;
    }

    public int getSizeDimension() {
        return h(this.f572h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f569e;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f570f;
    }

    public boolean getUseCompatPadding() {
        return this.f575k;
    }

    public final int h(int i2) {
        int i3 = this.f573i;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 == -1) {
            return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? h(1) : h(0);
        }
        return resources.getDimensionPixelSize(i2 != 1 ? R$dimen.design_fab_size_normal : R$dimen.design_fab_size_mini);
    }

    public void i(a aVar, boolean z) {
        d impl = getImpl();
        f.b.a.e.o.a aVar2 = aVar == null ? null : new f.b.a.e.o.a(this, aVar);
        if (!impl.e()) {
            Animator animator = impl.f2875j;
            if (animator != null) {
                animator.cancel();
            }
            if (impl.q()) {
                f.b.a.e.a.g gVar = impl.f2877l;
                if (gVar == null) {
                    if (impl.f2874i == null) {
                        impl.f2874i = f.b.a.e.a.g.b(impl.s.getContext(), R$animator.design_fab_hide_motion_spec);
                    }
                    gVar = impl.f2874i;
                    Objects.requireNonNull(gVar);
                }
                AnimatorSet a2 = impl.a(gVar, 0.0f, 0.0f, 0.0f);
                a2.addListener(new f.b.a.e.o.b(impl, z, aVar2));
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
            impl.s.b(z ? 8 : 4, z);
            if (aVar2 != null) {
                aVar2.a.a(aVar2.b);
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
            ColorStateList colorStateList = this.f569e;
            if (colorStateList == null) {
                m.h.t(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f570f;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(e.b.f.j.c(colorForState, mode));
        }
    }

    public void m(a aVar, boolean z) {
        d impl = getImpl();
        f.b.a.e.o.a aVar2 = aVar == null ? null : new f.b.a.e.o.a(this, aVar);
        if (!impl.f()) {
            Animator animator = impl.f2875j;
            if (animator != null) {
                animator.cancel();
            }
            if (impl.q()) {
                if (impl.s.getVisibility() != 0) {
                    impl.s.setAlpha(0.0f);
                    impl.s.setScaleY(0.0f);
                    impl.s.setScaleX(0.0f);
                    impl.n(0.0f);
                }
                f.b.a.e.a.g gVar = impl.f2876k;
                if (gVar == null) {
                    if (impl.f2873h == null) {
                        impl.f2873h = f.b.a.e.a.g.b(impl.s.getContext(), R$animator.design_fab_show_motion_spec);
                    }
                    gVar = impl.f2873h;
                    Objects.requireNonNull(gVar);
                }
                AnimatorSet a2 = impl.a(gVar, 1.0f, 1.0f, 1.0f);
                a2.addListener(new f.b.a.e.o.c(impl, z, aVar2));
                ArrayList<Animator.AnimatorListener> arrayList = impl.p;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            impl.s.b(0, z);
            impl.s.setAlpha(1.0f);
            impl.s.setScaleY(1.0f);
            impl.s.setScaleX(1.0f);
            impl.n(1.0f);
            if (aVar2 != null) {
                aVar2.a.b(aVar2.b);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d impl = getImpl();
        if (impl.m()) {
            ViewTreeObserver viewTreeObserver = impl.s.getViewTreeObserver();
            if (impl.y == null) {
                impl.y = new f(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.y);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.s.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.y;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.y = null;
        }
    }

    public void onMeasure(int i2, int i3) {
        this.f574j = (getSizeDimension() + 0) / 2;
        getImpl().t();
        throw null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f.b.a.e.w.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f.b.a.e.w.a aVar = (f.b.a.e.w.a) parcelable;
        super.onRestoreInstanceState(aVar.b);
        Objects.requireNonNull(aVar.f3020d.getOrDefault("expandableWidgetHelper", null));
        throw null;
    }

    public Parcelable onSaveInstanceState() {
        if (super.onSaveInstanceState() == null) {
            new Bundle();
        }
        e.k.a.a aVar = e.k.a.a.c;
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
        if (this.c != colorStateList) {
            this.c = colorStateList;
            Objects.requireNonNull(getImpl());
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f568d != mode) {
            this.f568d = mode;
            Objects.requireNonNull(getImpl());
        }
    }

    public void setCompatElevation(float f2) {
        d impl = getImpl();
        if (impl.f2869d != f2) {
            impl.f2869d = f2;
            impl.j(f2, impl.f2870e, impl.f2871f);
        }
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        d impl = getImpl();
        if (impl.f2870e != f2) {
            impl.f2870e = f2;
            impl.j(impl.f2869d, f2, impl.f2871f);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        d impl = getImpl();
        if (impl.f2871f != f2) {
            impl.f2871f = f2;
            impl.j(impl.f2869d, impl.f2870e, f2);
        }
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i2 != this.f573i) {
            this.f573i = i2;
            requestLayout();
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        Objects.requireNonNull(getImpl());
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().b) {
            getImpl().b = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i2) {
        throw null;
    }

    public void setHideMotionSpec(f.b.a.e.a.g gVar) {
        getImpl().f2877l = gVar;
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(f.b.a.e.a.g.b(getContext(), i2));
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            d impl = getImpl();
            impl.n(impl.n);
            if (this.f569e != null) {
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
        if (this.f571g != colorStateList) {
            this.f571g = colorStateList;
            getImpl().o(this.f571g);
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
        d impl = getImpl();
        impl.c = z;
        impl.t();
        throw null;
    }

    @Override // f.b.a.e.u.n
    public void setShapeAppearanceModel(f.b.a.e.u.j jVar) {
        getImpl().a = jVar;
    }

    public void setShowMotionSpec(f.b.a.e.a.g gVar) {
        getImpl().f2876k = gVar;
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(f.b.a.e.a.g.b(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f573i = 0;
        if (i2 != this.f572h) {
            this.f572h = i2;
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
        if (this.f569e != colorStateList) {
            this.f569e = colorStateList;
            l();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f570f != mode) {
            this.f570f = mode;
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
        if (this.f575k != z) {
            this.f575k = z;
            getImpl().h();
        }
    }

    @Override // f.b.a.e.p.q
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }
}
