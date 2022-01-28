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
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e.b.a.m;
import e.b.f.k;
import e.i.i.v;
import f.b.a.e.a.j;
import f.b.a.e.p.d;
import f.b.a.e.p.f;
import f.b.a.e.p.g;
import f.b.a.e.q.q;
import f.b.a.e.v.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class FloatingActionButton extends q implements f.b.a.e.o.a, n, CoordinatorLayout.b {
    public ColorStateList c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f562d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f563e;

    /* renamed from: f  reason: collision with root package name */
    public PorterDuff.Mode f564f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f565g;

    /* renamed from: h  reason: collision with root package name */
    public int f566h;

    /* renamed from: i  reason: collision with root package name */
    public int f567i;

    /* renamed from: j  reason: collision with root package name */
    public int f568j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f569k;

    /* renamed from: l  reason: collision with root package name */
    public d f570l;

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
            if (this.b && fVar.f145f == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
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
            f.b.a.e.q.d.a(coordinatorLayout, appBarLayout, rect);
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
            if (fVar.f147h == 0) {
                fVar.f147h = 80;
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

    public class b implements f.b.a.e.u.b {
        public b() {
        }
    }

    public class c<T extends FloatingActionButton> implements d.f {
        public final j<T> a;

        public c(j<T> jVar) {
            this.a = jVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: f.b.a.e.a.j<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.a.e.p.d.f
        public void a() {
            this.a.a(FloatingActionButton.this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: f.b.a.e.a.j<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.a.e.p.d.f
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
        if (this.f570l == null) {
            this.f570l = new g(this, new b());
        }
        return this.f570l;
    }

    @Override // f.b.a.e.o.a
    public boolean a() {
        throw null;
    }

    public void d(Animator.AnimatorListener animatorListener) {
        d impl = getImpl();
        if (impl.o == null) {
            impl.o = new ArrayList<>();
        }
        impl.o.add(null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().k(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        d impl = getImpl();
        if (impl.n == null) {
            impl.n = new ArrayList<>();
        }
        impl.n.add(animatorListener);
    }

    public void f(j<? extends FloatingActionButton> jVar) {
        d impl = getImpl();
        c cVar = new c(null);
        if (impl.p == null) {
            impl.p = new ArrayList<>();
        }
        impl.p.add(cVar);
    }

    @Deprecated
    public boolean g(Rect rect) {
        AtomicInteger atomicInteger = v.a;
        if (!v.g.c(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        throw null;
    }

    public ColorStateList getBackgroundTintList() {
        return this.c;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f562d;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f2928e;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f2929f;
    }

    public Drawable getContentBackground() {
        Objects.requireNonNull(getImpl());
        return null;
    }

    public int getCustomSize() {
        return this.f567i;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public f.b.a.e.a.g getHideMotionSpec() {
        return getImpl().f2933j;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f565g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f565g;
    }

    public f.b.a.e.v.j getShapeAppearanceModel() {
        f.b.a.e.v.j jVar = getImpl().a;
        Objects.requireNonNull(jVar);
        return jVar;
    }

    public f.b.a.e.a.g getShowMotionSpec() {
        return getImpl().f2932i;
    }

    public int getSize() {
        return this.f566h;
    }

    public int getSizeDimension() {
        return h(this.f566h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f563e;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f564f;
    }

    public boolean getUseCompatPadding() {
        return this.f569k;
    }

    public final int h(int i2) {
        int i3 = this.f567i;
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
        f.b.a.e.p.a aVar2 = aVar == null ? null : new f.b.a.e.p.a(this, aVar);
        if (!impl.g()) {
            Animator animator = impl.f2931h;
            if (animator != null) {
                animator.cancel();
            }
            if (impl.s()) {
                f.b.a.e.a.g gVar = impl.f2933j;
                AnimatorSet b2 = gVar != null ? impl.b(gVar, 0.0f, 0.0f, 0.0f) : impl.c(0.0f, 0.4f, 0.4f);
                b2.addListener(new f.b.a.e.p.b(impl, z, aVar2));
                ArrayList<Animator.AnimatorListener> arrayList = impl.o;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        b2.addListener(it.next());
                    }
                }
                b2.start();
                return;
            }
            impl.q.b(z ? 8 : 4, z);
            if (aVar2 != null) {
                aVar2.a.a(aVar2.b);
            }
        }
    }

    public boolean j() {
        return getImpl().g();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().i();
    }

    public boolean k() {
        return getImpl().h();
    }

    public final void l() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f563e;
            if (colorStateList == null) {
                m.e.w(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f564f;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(k.c(colorForState, mode));
        }
    }

    public void m(a aVar, boolean z) {
        d impl = getImpl();
        f.b.a.e.p.a aVar2 = aVar == null ? null : new f.b.a.e.p.a(this, aVar);
        if (!impl.h()) {
            Animator animator = impl.f2931h;
            if (animator != null) {
                animator.cancel();
            }
            boolean z2 = impl.f2932i == null;
            if (impl.s()) {
                if (impl.q.getVisibility() != 0) {
                    float f2 = 0.0f;
                    impl.q.setAlpha(0.0f);
                    impl.q.setScaleY(z2 ? 0.4f : 0.0f);
                    impl.q.setScaleX(z2 ? 0.4f : 0.0f);
                    if (z2) {
                        f2 = 0.4f;
                    }
                    impl.p(f2);
                }
                f.b.a.e.a.g gVar = impl.f2932i;
                AnimatorSet b2 = gVar != null ? impl.b(gVar, 1.0f, 1.0f, 1.0f) : impl.c(1.0f, 1.0f, 1.0f);
                b2.addListener(new f.b.a.e.p.c(impl, z, aVar2));
                ArrayList<Animator.AnimatorListener> arrayList = impl.n;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        b2.addListener(it.next());
                    }
                }
                b2.start();
                return;
            }
            impl.q.b(0, z);
            impl.q.setAlpha(1.0f);
            impl.q.setScaleY(1.0f);
            impl.q.setScaleX(1.0f);
            impl.p(1.0f);
            if (aVar2 != null) {
                aVar2.a.b(aVar2.b);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d impl = getImpl();
        if (impl.o()) {
            ViewTreeObserver viewTreeObserver = impl.q.getViewTreeObserver();
            if (impl.w == null) {
                impl.w = new f(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.w);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.q.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.w;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.w = null;
        }
    }

    public void onMeasure(int i2, int i3) {
        this.f568j = (getSizeDimension() + 0) / 2;
        getImpl().v();
        throw null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f.b.a.e.x.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f.b.a.e.x.a aVar = (f.b.a.e.x.a) parcelable;
        super.onRestoreInstanceState(aVar.b);
        Objects.requireNonNull(aVar.f3084d.getOrDefault("expandableWidgetHelper", null));
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
        if (this.f562d != mode) {
            this.f562d = mode;
            Objects.requireNonNull(getImpl());
        }
    }

    public void setCompatElevation(float f2) {
        d impl = getImpl();
        if (impl.f2927d != f2) {
            impl.f2927d = f2;
            impl.l(f2, impl.f2928e, impl.f2929f);
        }
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        d impl = getImpl();
        if (impl.f2928e != f2) {
            impl.f2928e = f2;
            impl.l(impl.f2927d, f2, impl.f2929f);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        d impl = getImpl();
        if (impl.f2929f != f2) {
            impl.f2929f = f2;
            impl.l(impl.f2927d, impl.f2928e, f2);
        }
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i2 != this.f567i) {
            this.f567i = i2;
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
        getImpl().f2933j = gVar;
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(f.b.a.e.a.g.b(getContext(), i2));
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            d impl = getImpl();
            impl.p(impl.f2935l);
            if (this.f563e != null) {
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
        if (this.f565g != colorStateList) {
            this.f565g = colorStateList;
            getImpl().q(this.f565g);
        }
    }

    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().m();
    }

    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().m();
    }

    public void setShadowPaddingEnabled(boolean z) {
        d impl = getImpl();
        impl.c = z;
        impl.v();
        throw null;
    }

    @Override // f.b.a.e.v.n
    public void setShapeAppearanceModel(f.b.a.e.v.j jVar) {
        getImpl().a = jVar;
    }

    public void setShowMotionSpec(f.b.a.e.a.g gVar) {
        getImpl().f2932i = gVar;
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(f.b.a.e.a.g.b(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f567i = 0;
        if (i2 != this.f566h) {
            this.f566h = i2;
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
        if (this.f563e != colorStateList) {
            this.f563e = colorStateList;
            l();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f564f != mode) {
            this.f564f = mode;
            l();
        }
    }

    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().n();
    }

    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().n();
    }

    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().n();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f569k != z) {
            this.f569k = z;
            getImpl().j();
        }
    }

    @Override // f.b.a.e.q.q
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }
}
