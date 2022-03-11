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
import e.j.j.v;
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
/* loaded from: classes.dex */
public class FloatingActionButton extends q implements f.b.a.e.o.a, n, CoordinatorLayout.b {
    public ColorStateList c;

    /* renamed from: d */
    public PorterDuff.Mode f574d;

    /* renamed from: e */
    public ColorStateList f575e;

    /* renamed from: f */
    public PorterDuff.Mode f576f;

    /* renamed from: g */
    public ColorStateList f577g;

    /* renamed from: h */
    public int f578h;

    /* renamed from: i */
    public int f579i;

    /* renamed from: j */
    public int f580j;

    /* renamed from: k */
    public int f581k;

    /* renamed from: l */
    public boolean f582l;
    public d m;

    /* loaded from: classes.dex */
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

        public void f(CoordinatorLayout.f fVar) {
            if (fVar.f147h == 0) {
                fVar.f147h = 80;
            }
        }

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

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements f.b.a.e.u.b {
        public b() {
            FloatingActionButton.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public class c<T extends FloatingActionButton> implements d.f {
        public final j<T> a;

        public c(j<T> jVar) {
            FloatingActionButton.this = r1;
            this.a = jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.a.e.p.d.f
        public void a() {
            this.a.a(FloatingActionButton.this);
        }

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
        if (this.m == null) {
            this.m = new g(this, new b());
        }
        return this.m;
    }

    @Override // f.b.a.e.o.a
    public boolean a() {
        throw null;
    }

    public void d(Animator.AnimatorListener animatorListener) {
        d impl = getImpl();
        if (impl.p == null) {
            impl.p = new ArrayList<>();
        }
        impl.p.add(null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().k(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        d impl = getImpl();
        if (impl.o == null) {
            impl.o = new ArrayList<>();
        }
        impl.o.add(animatorListener);
    }

    public void f(j<? extends FloatingActionButton> jVar) {
        d impl = getImpl();
        c cVar = new c(null);
        if (impl.q == null) {
            impl.q = new ArrayList<>();
        }
        impl.q.add(cVar);
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

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.c;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f574d;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f2970e;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f2971f;
    }

    public Drawable getContentBackground() {
        Objects.requireNonNull(getImpl());
        return null;
    }

    public int getCustomSize() {
        return this.f579i;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public f.b.a.e.a.g getHideMotionSpec() {
        return getImpl().f2975j;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f577g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f577g;
    }

    public f.b.a.e.v.j getShapeAppearanceModel() {
        f.b.a.e.v.j jVar = getImpl().a;
        Objects.requireNonNull(jVar);
        return jVar;
    }

    public f.b.a.e.a.g getShowMotionSpec() {
        return getImpl().f2974i;
    }

    public int getSize() {
        return this.f578h;
    }

    public int getSizeDimension() {
        return h(this.f578h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f575e;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f576f;
    }

    public boolean getUseCompatPadding() {
        return this.f582l;
    }

    public final int h(int i2) {
        int i3 = this.f579i;
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
            Animator animator = impl.f2973h;
            if (animator != null) {
                animator.cancel();
            }
            if (impl.s()) {
                f.b.a.e.a.g gVar = impl.f2975j;
                AnimatorSet b2 = gVar != null ? impl.b(gVar, 0.0f, 0.0f, 0.0f) : impl.c(0.0f, 0.4f, 0.4f);
                b2.addListener(new f.b.a.e.p.b(impl, z, aVar2));
                ArrayList<Animator.AnimatorListener> arrayList = impl.p;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        b2.addListener(it.next());
                    }
                }
                b2.start();
                return;
            }
            impl.r.b(z ? 8 : 4, z);
            if (aVar2 != null) {
                aVar2.a.a(aVar2.b);
            }
        }
    }

    public boolean j() {
        return getImpl().g();
    }

    @Override // android.widget.ImageView, android.view.View
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
            ColorStateList colorStateList = this.f575e;
            if (colorStateList == null) {
                m.e.w(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f576f;
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
            Animator animator = impl.f2973h;
            if (animator != null) {
                animator.cancel();
            }
            boolean z2 = impl.f2974i == null;
            if (impl.s()) {
                if (impl.r.getVisibility() != 0) {
                    float f2 = 0.0f;
                    impl.r.setAlpha(0.0f);
                    impl.r.setScaleY(z2 ? 0.4f : 0.0f);
                    impl.r.setScaleX(z2 ? 0.4f : 0.0f);
                    if (z2) {
                        f2 = 0.4f;
                    }
                    impl.p(f2);
                }
                f.b.a.e.a.g gVar = impl.f2974i;
                AnimatorSet b2 = gVar != null ? impl.b(gVar, 1.0f, 1.0f, 1.0f) : impl.c(1.0f, 1.0f, 1.0f);
                b2.addListener(new f.b.a.e.p.c(impl, z, aVar2));
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
            impl.r.b(0, z);
            impl.r.setAlpha(1.0f);
            impl.r.setScaleY(1.0f);
            impl.r.setScaleX(1.0f);
            impl.p(1.0f);
            if (aVar2 != null) {
                aVar2.a.b(aVar2.b);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d impl = getImpl();
        if (impl.o()) {
            ViewTreeObserver viewTreeObserver = impl.r.getViewTreeObserver();
            if (impl.x == null) {
                impl.x = new f(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.x);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.r.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.x;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.x = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        this.f580j = (getSizeDimension() - this.f581k) / 2;
        getImpl().v();
        throw null;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f.b.a.e.x.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f.b.a.e.x.a aVar = (f.b.a.e.x.a) parcelable;
        super.onRestoreInstanceState(aVar.b);
        Objects.requireNonNull(aVar.f3126d.getOrDefault("expandableWidgetHelper", null));
        throw null;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        if (super.onSaveInstanceState() == null) {
            new Bundle();
        }
        e.l.a.a aVar = e.l.a.a.c;
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            g(null);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.c != colorStateList) {
            this.c = colorStateList;
            Objects.requireNonNull(getImpl());
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f574d != mode) {
            this.f574d = mode;
            Objects.requireNonNull(getImpl());
        }
    }

    public void setCompatElevation(float f2) {
        d impl = getImpl();
        if (impl.f2969d != f2) {
            impl.f2969d = f2;
            impl.l(f2, impl.f2970e, impl.f2971f);
        }
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        d impl = getImpl();
        if (impl.f2970e != f2) {
            impl.f2970e = f2;
            impl.l(impl.f2969d, f2, impl.f2971f);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        d impl = getImpl();
        if (impl.f2971f != f2) {
            impl.f2971f = f2;
            impl.l(impl.f2969d, impl.f2970e, f2);
        }
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i2 != this.f579i) {
            this.f579i = i2;
            requestLayout();
        }
    }

    @Override // android.view.View
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
        getImpl().f2975j = gVar;
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(f.b.a.e.a.g.b(getContext(), i2));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            d impl = getImpl();
            impl.p(impl.f2977l);
            if (this.f575e != null) {
                l();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        throw null;
    }

    public void setMaxImageSize(int i2) {
        this.f581k = i2;
        d impl = getImpl();
        if (impl.m != i2) {
            impl.m = i2;
            impl.p(impl.f2977l);
        }
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f577g != colorStateList) {
            this.f577g = colorStateList;
            getImpl().q(this.f577g);
        }
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().m();
    }

    @Override // android.view.View
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
        getImpl().f2974i = gVar;
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(f.b.a.e.a.g.b(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f579i = 0;
        if (i2 != this.f578h) {
            this.f578h = i2;
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
        if (this.f575e != colorStateList) {
            this.f575e = colorStateList;
            l();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f576f != mode) {
            this.f576f = mode;
            l();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().n();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().n();
    }

    @Override // android.view.View
    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().n();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f582l != z) {
            this.f582l = z;
            getImpl().j();
        }
    }

    @Override // f.b.a.e.q.q, android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }
}
