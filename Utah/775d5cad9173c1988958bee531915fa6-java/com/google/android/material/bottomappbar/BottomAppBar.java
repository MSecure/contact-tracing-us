package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$animator;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.b.a.m;
import e.i.i.v;
import f.b.a.c.b.o.b;
import f.b.a.e.d.c;
import f.b.a.e.d.d;
import f.b.a.e.d.f;
import f.b.a.e.d.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public static final /* synthetic */ int d0 = 0;
    public Integer Q;
    public Animator R;
    public Animator S;
    public int T;
    public int U;
    public boolean V;
    public int W;
    public int a0;
    public boolean b0;
    public Behavior c0;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: e  reason: collision with root package name */
        public final Rect f502e = new Rect();

        /* renamed from: f  reason: collision with root package name */
        public WeakReference<BottomAppBar> f503f;

        /* renamed from: g  reason: collision with root package name */
        public int f504g;

        /* renamed from: h  reason: collision with root package name */
        public final View.OnLayoutChangeListener f505h = new a();

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (Behavior.this.f503f.get() == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Behavior.this.f502e.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                throw null;
            }
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int] */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            BottomAppBar bottomAppBar2 = bottomAppBar;
            this.f503f = new WeakReference<>(bottomAppBar2);
            int i3 = BottomAppBar.d0;
            View z = bottomAppBar2.z();
            if (z != null) {
                AtomicInteger atomicInteger = v.a;
                if (!v.g.c(z)) {
                    CoordinatorLayout.f fVar = (CoordinatorLayout.f) z.getLayoutParams();
                    fVar.f143d = 49;
                    this.f504g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                    if (z instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) z;
                        if (floatingActionButton.getShowMotionSpec() == null) {
                            floatingActionButton.setShowMotionSpecResource(R$animator.mtrl_fab_show_motion_spec);
                        }
                        if (floatingActionButton.getHideMotionSpec() == null) {
                            floatingActionButton.setHideMotionSpecResource(R$animator.mtrl_fab_hide_motion_spec);
                        }
                        floatingActionButton.addOnLayoutChangeListener(this.f505h);
                        floatingActionButton.d(null);
                        floatingActionButton.e(new f(bottomAppBar2));
                        floatingActionButton.f(null);
                    }
                    bottomAppBar2.D();
                    throw null;
                }
            }
            coordinatorLayout.r(bottomAppBar2, i2);
            this.a = bottomAppBar2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) bottomAppBar2.getLayoutParams()).bottomMargin;
            return false;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, android.view.View, int, int] */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean x(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i2, int i3) {
            if (bottomAppBar.getHideOnScroll()) {
                if (i2 == 2) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class a extends e.k.a.a {
        public static final Parcelable.Creator<a> CREATOR = new C0006a();

        /* renamed from: d  reason: collision with root package name */
        public int f506d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f507e;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$a$a  reason: collision with other inner class name */
        public static class C0006a implements Parcelable.ClassLoaderCreator<a> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new a[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f506d = parcel.readInt();
            this.f507e = parcel.readInt() != 0;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeInt(this.f506d);
            parcel.writeInt(this.f507e ? 1 : 0);
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return 0;
    }

    private float getFabTranslationX() {
        return B(this.T);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().f2854d;
    }

    private int getLeftInset() {
        return 0;
    }

    private int getRightInset() {
        return 0;
    }

    private g getTopEdgeTreatment() {
        throw null;
    }

    public static void w(BottomAppBar bottomAppBar) {
        bottomAppBar.W--;
    }

    public int A(ActionMenuView actionMenuView, int i2, boolean z) {
        if (i2 != 1 || !z) {
            return 0;
        }
        boolean V0 = b.V0(this);
        int measuredWidth = V0 ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).a & 8388615) == 8388611) {
                measuredWidth = V0 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((V0 ? actionMenuView.getRight() : actionMenuView.getLeft()) + 0);
    }

    public final float B(int i2) {
        boolean V0 = b.V0(this);
        int i3 = 1;
        if (i2 != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) + 0;
        if (V0) {
            i3 = -1;
        }
        return (float) (measuredWidth * i3);
    }

    public final boolean C() {
        FloatingActionButton y = y();
        return y != null && y.k();
    }

    public final void D() {
        getTopEdgeTreatment().f2855e = getFabTranslationX();
        z();
        if (this.b0) {
            C();
        }
        throw null;
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.c0 == null) {
            this.c0 = new Behavior();
        }
        return this.c0;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f2854d;
    }

    public int getFabAlignmentMode() {
        return this.T;
    }

    public int getFabAnimationMode() {
        return this.U;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().c;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().b;
    }

    public boolean getHideOnScroll() {
        return this.V;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            Animator animator = this.S;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.R;
            if (animator2 != null) {
                animator2.cancel();
            }
            D();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.S == null) {
            actionMenuView.setAlpha(1.0f);
            if (!C()) {
                i6 = A(actionMenuView, 0, false);
            } else {
                i6 = A(actionMenuView, this.T, this.b0);
            }
            actionMenuView.setTranslationX((float) i6);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.b);
        this.T = aVar.f506d;
        this.b0 = aVar.f507e;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f506d = this.T;
        aVar.f507e = this.b0;
        return aVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            g topEdgeTreatment = getTopEdgeTreatment();
            Objects.requireNonNull(topEdgeTreatment);
            if (f2 >= 0.0f) {
                topEdgeTreatment.f2854d = f2;
                throw null;
            }
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    public void setElevation(float f2) {
        throw null;
    }

    public void setFabAlignmentMode(int i2) {
        int i3;
        this.a0 = 0;
        boolean z = this.b0;
        AtomicInteger atomicInteger = v.a;
        if (!v.g.c(this)) {
            int i4 = this.a0;
            if (i4 != 0) {
                this.a0 = 0;
                getMenu().clear();
                n(i4);
            }
        } else {
            Animator animator = this.S;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!C()) {
                z = false;
                i3 = 0;
            } else {
                i3 = i2;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                if (Math.abs(actionMenuView.getTranslationX() - ((float) A(actionMenuView, i3, z))) > 1.0f) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    ofFloat2.addListener(new d(this, actionMenuView, i3, z));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(150L);
                    animatorSet.playSequentially(ofFloat2, ofFloat);
                    arrayList.add(animatorSet);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(ofFloat);
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            this.S = animatorSet2;
            animatorSet2.addListener(new c(this));
            this.S.start();
        }
        if (this.T != i2 && v.g.c(this)) {
            Animator animator2 = this.R;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.U == 1) {
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(y(), "translationX", B(i2));
                ofFloat3.setDuration(300L);
                arrayList2.add(ofFloat3);
            } else {
                x(i2);
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            this.R = animatorSet3;
            animatorSet3.addListener(new f.b.a.e.d.a(this));
            this.R.start();
        }
        this.T = i2;
    }

    public void setFabAnimationMode(int i2) {
        this.U = i2;
    }

    public void setFabCornerSize(float f2) {
        if (f2 != getTopEdgeTreatment().f2856f) {
            getTopEdgeTreatment().f2856f = f2;
            throw null;
        }
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().c = f2;
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().b = f2;
            throw null;
        }
    }

    public void setHideOnScroll(boolean z) {
        this.V = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (!(drawable == null || this.Q == null)) {
            drawable = m.e.P1(drawable.mutate());
            drawable.setTint(this.Q.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i2) {
        this.Q = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Landroid/animation/Animator;>;)V */
    public void x(int i2) {
        FloatingActionButton y = y();
        if (y != null && !y.j()) {
            this.W++;
            y.i(new f.b.a.e.d.b(this, i2), true);
        }
    }

    public final FloatingActionButton y() {
        View z = z();
        if (z instanceof FloatingActionButton) {
            return (FloatingActionButton) z;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    public final View z() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).e(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
            while (r0.hasNext()) {
            }
        }
        return null;
    }
}
