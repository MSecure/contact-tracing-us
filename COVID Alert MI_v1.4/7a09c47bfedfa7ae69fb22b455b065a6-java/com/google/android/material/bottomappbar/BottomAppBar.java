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
import b.x.t;
import c.b.a.b.q.b;
import c.b.a.b.q.c;
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
    public int W;
    public boolean a0;
    public boolean b0;
    public Behavior c0;
    public AnimatorListenerAdapter d0;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: e  reason: collision with root package name */
        public final Rect f6024e = new Rect();

        /* renamed from: f  reason: collision with root package name */
        public WeakReference<BottomAppBar> f6025f;

        /* renamed from: g  reason: collision with root package name */
        public int f6026g;
        public final View.OnLayoutChangeListener h = new a();

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (Behavior.this.f6025f.get() == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Behavior.this.f6024e.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
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
            this.f6025f = new WeakReference<>(bottomAppBar2);
            View D = bottomAppBar2.D();
            if (D == null || m.C(D)) {
                coordinatorLayout.q(bottomAppBar2, i);
                this.f6006a = bottomAppBar2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) bottomAppBar2.getLayoutParams()).bottomMargin;
                return false;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) D.getLayoutParams();
            fVar.f189d = 49;
            this.f6026g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
            if (D instanceof FloatingActionButton) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) D;
                floatingActionButton.addOnLayoutChangeListener(this.h);
                floatingActionButton.d(null);
                floatingActionButton.e(new e(bottomAppBar2));
                floatingActionButton.f(null);
            }
            bottomAppBar2.H();
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
        public static final Parcelable.Creator<a> CREATOR = new C0120a();

        /* renamed from: d  reason: collision with root package name */
        public int f6028d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f6029e;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$a$a  reason: collision with other inner class name */
        public static class C0120a implements Parcelable.ClassLoaderCreator<a> {
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
            this.f6028d = parcel.readInt();
            this.f6029e = parcel.readInt() != 0;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1952b, i);
            parcel.writeInt(this.f6028d);
            parcel.writeInt(this.f6029e ? 1 : 0);
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
        return F(this.S);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().f4501d;
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

    public static void w(BottomAppBar bottomAppBar) {
        bottomAppBar.V--;
    }

    public static void y(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        actionMenuView.setTranslationX((float) bottomAppBar.E(actionMenuView, i, z));
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Landroid/animation/Animator;>;)V */
    public void B(int i) {
        FloatingActionButton C = C();
        if (C != null && !C.j()) {
            this.V++;
            C.i(new b(this, i), true);
        }
    }

    public final FloatingActionButton C() {
        View D = D();
        if (D instanceof FloatingActionButton) {
            return (FloatingActionButton) D;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    public final View D() {
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

    public int E(ActionMenuView actionMenuView, int i, boolean z) {
        if (i != 1 || !z) {
            return 0;
        }
        boolean V1 = t.V1(this);
        int measuredWidth = V1 ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f509a & 8388615) == 8388611) {
                measuredWidth = V1 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((V1 ? actionMenuView.getRight() : actionMenuView.getLeft()) + 0);
    }

    public final float F(int i) {
        boolean V1 = t.V1(this);
        int i2 = 1;
        if (i != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) + 0;
        if (V1) {
            i2 = -1;
        }
        return (float) (measuredWidth * i2);
    }

    public final boolean G() {
        FloatingActionButton C = C();
        return C != null && C.k();
    }

    public final void H() {
        getTopEdgeTreatment().f4502e = getFabTranslationX();
        D();
        if (this.b0) {
            G();
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
        return getTopEdgeTreatment().f4501d;
    }

    public int getFabAlignmentMode() {
        return this.S;
    }

    public int getFabAnimationMode() {
        return this.T;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f4500c;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f4499b;
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
            H();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.R == null) {
            actionMenuView.setAlpha(1.0f);
            if (!G()) {
                i5 = E(actionMenuView, 0, false);
            } else {
                i5 = E(actionMenuView, this.S, this.b0);
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
        super.onRestoreInstanceState(aVar.f1952b);
        this.S = aVar.f6028d;
        this.b0 = aVar.f6029e;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f6028d = this.S;
        aVar.f6029e = this.b0;
        return aVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            f topEdgeTreatment = getTopEdgeTreatment();
            if (topEdgeTreatment == null) {
                throw null;
            } else if (f2 >= 0.0f) {
                topEdgeTreatment.f4501d = f2;
                throw null;
            } else {
                throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
            }
        }
    }

    public void setElevation(float f2) {
        throw null;
    }

    public void setFabAlignmentMode(int i) {
        int i2;
        this.W = 0;
        boolean z = this.b0;
        if (m.C(this)) {
            Animator animator = this.R;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!G()) {
                z = false;
                i2 = 0;
            } else {
                i2 = i;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                if (Math.abs(actionMenuView.getTranslationX() - ((float) E(actionMenuView, i2, z))) > 1.0f) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    ofFloat2.addListener(new d(this, actionMenuView, i2, z));
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
            this.R = animatorSet2;
            animatorSet2.addListener(new c(this));
            this.R.start();
        }
        if (this.S != i && m.C(this)) {
            Animator animator2 = this.Q;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.T == 1) {
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(C(), "translationX", F(i));
                ofFloat3.setDuration(300L);
                arrayList2.add(ofFloat3);
            } else {
                B(i);
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            this.Q = animatorSet3;
            animatorSet3.addListener(new c.b.a.b.q.a(this));
            this.Q.start();
        }
        this.S = i;
    }

    public void setFabAnimationMode(int i) {
        this.T = i;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().f4500c = f2;
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f4499b = f2;
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
