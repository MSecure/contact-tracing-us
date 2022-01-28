package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.l.m;
import c.b.a.a.c.n.c;
import c.b.a.b.q.b;
import c.b.a.b.q.d;
import c.b.a.b.q.e;
import c.b.a.b.q.f;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public Animator Q;
    public Animator R;
    public int S;
    public int T;
    public boolean U;
    public int V;
    public boolean W;
    public Behavior a0;
    public AnimatorListenerAdapter b0;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: e  reason: collision with root package name */
        public final Rect f4468e = new Rect();
        public WeakReference<BottomAppBar> f;
        public int g;
        public final View.OnLayoutChangeListener h = new a();

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (Behavior.this.f.get() == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Behavior.this.f4468e.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
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
        public boolean k(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            BottomAppBar bottomAppBar2 = bottomAppBar;
            this.f = new WeakReference<>(bottomAppBar2);
            View C = bottomAppBar2.C();
            if (C == null || m.B(C)) {
                coordinatorLayout.q(bottomAppBar2, i);
                this.f4452a = bottomAppBar2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) bottomAppBar2.getLayoutParams()).bottomMargin;
                return false;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) C.getLayoutParams();
            fVar.f128d = 49;
            this.g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
            if (C instanceof FloatingActionButton) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) C;
                floatingActionButton.addOnLayoutChangeListener(this.h);
                floatingActionButton.d(null);
                floatingActionButton.e(new e(bottomAppBar2));
                floatingActionButton.f(null);
            }
            bottomAppBar2.G();
            throw null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, android.view.View, int, int] */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean x(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            if (bottomAppBar.getHideOnScroll()) {
                if (i == 2) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class a extends b.k.a.a {
        public static final Parcelable.Creator<a> CREATOR = new C0111a();

        /* renamed from: d  reason: collision with root package name */
        public int f4470d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4471e;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$a$a  reason: collision with other inner class name */
        public static class C0111a implements Parcelable.ClassLoaderCreator<a> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new a[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4470d = parcel.readInt();
            this.f4471e = parcel.readInt() != 0;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1231b, i);
            parcel.writeInt(this.f4470d);
            parcel.writeInt(this.f4471e ? 1 : 0);
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return 0;
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX() {
        return E(this.S);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().f3189d;
    }

    private int getLeftInset() {
        return 0;
    }

    private int getRightInset() {
        return 0;
    }

    private f getTopEdgeTreatment() {
        throw null;
    }

    public static void v(BottomAppBar bottomAppBar) {
        bottomAppBar.V--;
    }

    public static void x(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        actionMenuView.setTranslationX((float) bottomAppBar.D(actionMenuView, i, z));
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Landroid/animation/Animator;>;)V */
    public void A(int i) {
        FloatingActionButton B = B();
        if (B != null && !B.j()) {
            this.V++;
            B.i(new b(this, i), true);
        }
    }

    public final FloatingActionButton B() {
        View C = C();
        if (C instanceof FloatingActionButton) {
            return (FloatingActionButton) C;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    public final View C() {
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

    public int D(ActionMenuView actionMenuView, int i, boolean z) {
        if (i != 1 || !z) {
            return 0;
        }
        boolean q1 = c.q1(this);
        int measuredWidth = q1 ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f359a & 8388615) == 8388611) {
                measuredWidth = q1 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((q1 ? actionMenuView.getRight() : actionMenuView.getLeft()) + 0);
    }

    public final float E(int i) {
        boolean q1 = c.q1(this);
        int i2 = 1;
        if (i != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) + 0;
        if (q1) {
            i2 = -1;
        }
        return (float) (measuredWidth * i2);
    }

    public final boolean F() {
        FloatingActionButton B = B();
        return B != null && B.k();
    }

    public final void G() {
        getTopEdgeTreatment().f3190e = getFabTranslationX();
        C();
        if (this.W) {
            F();
        }
        throw null;
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.a0 == null) {
            this.a0 = new Behavior();
        }
        return this.a0;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f3189d;
    }

    public int getFabAlignmentMode() {
        return this.S;
    }

    public int getFabAnimationMode() {
        return this.T;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f3188c;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f3187b;
    }

    public boolean getHideOnScroll() {
        return this.U;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            Animator animator = this.R;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.Q;
            if (animator2 != null) {
                animator2.cancel();
            }
            G();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!F()) {
                i5 = D(actionMenuView, 0, false);
            } else {
                i5 = D(actionMenuView, this.S, this.W);
            }
            actionMenuView.setTranslationX((float) i5);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f1231b);
        this.S = aVar.f4470d;
        this.W = aVar.f4471e;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f4470d = this.S;
        aVar.f4471e = this.W;
        return aVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            f topEdgeTreatment = getTopEdgeTreatment();
            if (topEdgeTreatment == null) {
                throw null;
            } else if (f >= 0.0f) {
                topEdgeTreatment.f3189d = f;
                throw null;
            } else {
                throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
            }
        }
    }

    public void setElevation(float f) {
        throw null;
    }

    public void setFabAlignmentMode(int i) {
        int i2;
        if (this.S != i && m.B(this)) {
            Animator animator = this.Q;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.T == 1) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(B(), "translationX", E(i));
                ofFloat.setDuration(300L);
                arrayList.add(ofFloat);
            } else {
                A(i);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.Q = animatorSet;
            animatorSet.addListener(new c.b.a.b.q.a(this));
            this.Q.start();
        }
        boolean z = this.W;
        if (m.B(this)) {
            Animator animator2 = this.R;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (!F()) {
                z = false;
                i2 = 0;
            } else {
                i2 = i;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                if (Math.abs(actionMenuView.getTranslationX() - ((float) D(actionMenuView, i2, z))) > 1.0f) {
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    ofFloat3.addListener(new d(this, actionMenuView, i2, z));
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.setDuration(150L);
                    animatorSet2.playSequentially(ofFloat3, ofFloat2);
                    arrayList2.add(animatorSet2);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList2.add(ofFloat2);
                }
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            this.R = animatorSet3;
            animatorSet3.addListener(new c.b.a.b.q.c(this));
            this.R.start();
        }
        this.S = i;
    }

    public void setFabAnimationMode(int i) {
        this.T = i;
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            getTopEdgeTreatment().f3188c = f;
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f3187b = f;
            throw null;
        }
    }

    public void setHideOnScroll(boolean z) {
        this.U = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
