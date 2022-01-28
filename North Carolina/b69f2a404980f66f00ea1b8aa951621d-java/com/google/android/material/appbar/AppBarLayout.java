package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.k.i;
import b.i.l.e;
import b.i.l.m;
import b.i.l.v;
import b.i.l.w.b;
import c.b.a.b.h0.g;
import c.b.a.b.k;
import c.b.a.b.l;
import c.b.a.b.n.d;
import c.b.a.b.n.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    public static final int r = k.Widget_Design_AppBarLayout;

    /* renamed from: b  reason: collision with root package name */
    public int f4437b;

    /* renamed from: c  reason: collision with root package name */
    public int f4438c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f4439d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f4440e = -1;
    public boolean f;
    public int g = 0;
    public v h;
    public List<a> i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public WeakReference<View> n;
    public ValueAnimator o;
    public int[] p;
    public Drawable q;

    public static class BaseBehavior<T extends AppBarLayout> extends h<T> {
        public int k;
        public int l;
        public ValueAnimator m;
        public int n = -1;
        public boolean o;
        public float p;
        public WeakReference<View> q;

        public static class a extends b.k.a.a {
            public static final Parcelable.Creator<a> CREATOR = new C0110a();

            /* renamed from: d  reason: collision with root package name */
            public int f4441d;

            /* renamed from: e  reason: collision with root package name */
            public float f4442e;
            public boolean f;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$a$a  reason: collision with other inner class name */
            public static class C0110a implements Parcelable.ClassLoaderCreator<a> {
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
                this.f4441d = parcel.readInt();
                this.f4442e = parcel.readFloat();
                this.f = parcel.readByte() != 0;
            }

            public a(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // b.k.a.a
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeParcelable(this.f1231b, i);
                parcel.writeInt(this.f4441d);
                parcel.writeFloat(this.f4442e);
                parcel.writeByte(this.f ? (byte) 1 : 0);
            }
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static boolean I(int i, int i2) {
            return (i & i2) == i2;
        }

        @Override // c.b.a.b.n.h
        public int D() {
            return B() + this.k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00b6  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00d7  */
        @Override // c.b.a.b.n.h
        public int G(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            int i4;
            c.b.a.b.n.k kVar;
            boolean z;
            ArrayList<T> orDefault;
            int i5;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int D = D();
            int i6 = 0;
            if (i2 == 0 || D < i2 || D > i3) {
                this.k = 0;
            } else {
                int w = i.j.w(i, i2, i3);
                if (D != w) {
                    if (appBarLayout.f) {
                        int abs = Math.abs(w);
                        int childCount = appBarLayout.getChildCount();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= childCount) {
                                break;
                            }
                            View childAt = appBarLayout.getChildAt(i7);
                            b bVar = (b) childAt.getLayoutParams();
                            Interpolator interpolator = bVar.f4444b;
                            if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                                i7++;
                            } else if (interpolator != null) {
                                int i8 = bVar.f4443a;
                                if ((i8 & 1) != 0) {
                                    i5 = childAt.getHeight() + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin + 0;
                                    if ((i8 & 2) != 0) {
                                        i5 -= m.p(childAt);
                                    }
                                } else {
                                    i5 = 0;
                                }
                                if (m.l(childAt)) {
                                    i5 -= appBarLayout.getTopInset();
                                }
                                if (i5 > 0) {
                                    float f = (float) i5;
                                    i4 = (childAt.getTop() + Math.round(interpolator.getInterpolation(((float) (abs - childAt.getTop())) / f) * f)) * Integer.signum(w);
                                }
                            }
                        }
                        kVar = this.f3154a;
                        if (kVar == null) {
                            z = kVar.b(i4);
                        } else {
                            this.f3155b = i4;
                            z = false;
                        }
                        int i9 = D - w;
                        this.k = w - i4;
                        if (!z && appBarLayout.f && (orDefault = coordinatorLayout.f120c.f958b.getOrDefault(appBarLayout, null)) != null && !orDefault.isEmpty()) {
                            while (i6 < orDefault.size()) {
                                T t = orDefault.get(i6);
                                CoordinatorLayout.c cVar = ((CoordinatorLayout.f) t.getLayoutParams()).f125a;
                                if (cVar != null) {
                                    cVar.g(coordinatorLayout, t, appBarLayout);
                                }
                                i6++;
                            }
                        }
                        appBarLayout.b(B());
                        P(coordinatorLayout, appBarLayout, w, w >= D ? -1 : 1, false);
                        i6 = i9;
                    }
                    i4 = w;
                    kVar = this.f3154a;
                    if (kVar == null) {
                    }
                    int i92 = D - w;
                    this.k = w - i4;
                    while (i6 < orDefault.size()) {
                    }
                    appBarLayout.b(B());
                    P(coordinatorLayout, appBarLayout, w, w >= D ? -1 : 1, false);
                    i6 = i92;
                }
            }
            O(coordinatorLayout, appBarLayout);
            return i6;
        }

        public final void H(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int abs = Math.abs(D() - i);
            float abs2 = Math.abs(f);
            int round = abs2 > 0.0f ? Math.round((((float) abs) / abs2) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            int D = D();
            if (D == i) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(c.b.a.b.m.a.f3112e);
                this.m.addUpdateListener(new c.b.a.b.n.c(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration((long) Math.min(round, 600));
            this.m.setIntValues(D, i);
            this.m.start();
        }

        public final View J(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof e) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;II[II)V */
        public void K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int[] iArr) {
            int i2;
            int i3;
            if (i != 0) {
                if (i < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    i2 = appBarLayout.getDownNestedPreScrollRange() + i3;
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    i2 = 0;
                }
                if (i3 != i2) {
                    iArr[1] = E(coordinatorLayout, appBarLayout, i, i3, i2);
                }
            }
            if (appBarLayout.l) {
                appBarLayout.d(appBarLayout.e(view));
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;IIIII[I)V */
        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.google.android.material.appbar.AppBarLayout */
        /* JADX WARN: Multi-variable type inference failed */
        public void L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int[] iArr) {
            if (i < 0) {
                iArr[1] = E(coordinatorLayout, appBarLayout, i, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i == 0) {
                O(coordinatorLayout, appBarLayout);
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;Landroid/view/View;II)Z */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (((r4.getTotalScrollRange() != 0) && r3.getHeight() - r5.getHeight() <= r4.getHeight()) != false) goto L_0x002b;
         */
        public boolean M(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = true;
            if ((i & 2) != 0) {
                if (!appBarLayout.l) {
                }
                if (z && (valueAnimator = this.m) != null) {
                    valueAnimator.cancel();
                }
                this.q = null;
                this.l = i2;
                return z;
            }
            z = false;
            valueAnimator.cancel();
            this.q = null;
            this.l = i2;
            return z;
        }

        public final void N(CoordinatorLayout coordinatorLayout, T t) {
            int D = D();
            int childCount = t.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = t.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                b bVar = (b) childAt.getLayoutParams();
                if (I(bVar.f4443a, 32)) {
                    top -= ((LinearLayout.LayoutParams) bVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) bVar).bottomMargin;
                }
                int i2 = -D;
                if (top <= i2 && bottom >= i2) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                View childAt2 = t.getChildAt(i);
                b bVar2 = (b) childAt2.getLayoutParams();
                int i3 = bVar2.f4443a;
                if ((i3 & 17) == 17) {
                    int i4 = -childAt2.getTop();
                    int i5 = -childAt2.getBottom();
                    if (i == t.getChildCount() - 1) {
                        i5 += t.getTopInset();
                    }
                    if (I(i3, 2)) {
                        i5 += m.p(childAt2);
                    } else if (I(i3, 5)) {
                        int p2 = m.p(childAt2) + i5;
                        if (D < p2) {
                            i4 = p2;
                        } else {
                            i5 = p2;
                        }
                    }
                    if (I(i3, 32)) {
                        i4 += ((LinearLayout.LayoutParams) bVar2).topMargin;
                        i5 -= ((LinearLayout.LayoutParams) bVar2).bottomMargin;
                    }
                    if (D < (i5 + i4) / 2) {
                        i4 = i5;
                    }
                    H(coordinatorLayout, t, i.j.w(i4, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void O(CoordinatorLayout coordinatorLayout, T t) {
            m.O(coordinatorLayout, b.a.f.a());
            m.O(coordinatorLayout, b.a.g.a());
            View J = J(coordinatorLayout);
            if (J != null && t.getTotalScrollRange() != 0 && (((CoordinatorLayout.f) J.getLayoutParams()).f125a instanceof ScrollingViewBehavior)) {
                if (D() != (-t.getTotalScrollRange()) && J.canScrollVertically(1)) {
                    m.Q(coordinatorLayout, b.a.f, null, new c.b.a.b.n.e(this, t, false));
                }
                if (D() == 0) {
                    return;
                }
                if (J.canScrollVertically(-1)) {
                    int i = -t.getDownNestedPreScrollRange();
                    if (i != 0) {
                        m.Q(coordinatorLayout, b.a.g, null, new d(this, coordinatorLayout, t, J, i));
                        return;
                    }
                    return;
                }
                m.Q(coordinatorLayout, b.a.g, null, new c.b.a.b.n.e(this, t, true));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x006e  */
        public final void P(CoordinatorLayout coordinatorLayout, T t, int i, int i2, boolean z) {
            View view;
            boolean z2;
            int abs = Math.abs(i);
            int childCount = t.getChildCount();
            boolean z3 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    view = null;
                    break;
                }
                view = t.getChildAt(i3);
                if (abs >= view.getTop() && abs <= view.getBottom()) {
                    break;
                }
                i3++;
            }
            if (view != null) {
                int i4 = ((b) view.getLayoutParams()).f4443a;
                if ((i4 & 1) != 0) {
                    int p2 = m.p(view);
                    if (i2 <= 0 || (i4 & 12) == 0 ? !((i4 & 2) == 0 || (-i) < (view.getBottom() - p2) - t.getTopInset()) : (-i) >= (view.getBottom() - p2) - t.getTopInset()) {
                        z2 = true;
                        if (t.l) {
                            z2 = t.e(J(coordinatorLayout));
                        }
                        boolean d2 = t.d(z2);
                        if (!z) {
                            if (d2) {
                                List<View> e2 = coordinatorLayout.e(t);
                                int size = e2.size();
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= size) {
                                        break;
                                    }
                                    CoordinatorLayout.c cVar = ((CoordinatorLayout.f) e2.get(i5).getLayoutParams()).f125a;
                                    if (!(cVar instanceof ScrollingViewBehavior)) {
                                        i5++;
                                    } else if (((ScrollingViewBehavior) cVar).g != 0) {
                                        z3 = true;
                                    }
                                }
                                if (!z3) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        t.jumpDrawablesToCurrentState();
                    }
                }
                z2 = false;
                if (t.l) {
                }
                boolean d22 = t.d(z2);
                if (!z) {
                }
                t.jumpDrawablesToCurrentState();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c, c.b.a.b.n.j
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.k(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            int i2 = this.n;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(i2);
                int i3 = -childAt.getBottom();
                F(coordinatorLayout, appBarLayout, this.o ? appBarLayout.getTopInset() + childAt.getMinimumHeight() + i3 : Math.round(((float) childAt.getHeight()) * this.p) + i3);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        H(coordinatorLayout, appBarLayout, i4, 0.0f);
                    } else {
                        F(coordinatorLayout, appBarLayout, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        H(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        F(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.g = 0;
            this.n = -1;
            int w = i.j.w(B(), -appBarLayout.getTotalScrollRange(), 0);
            c.b.a.b.n.k kVar = this.f3154a;
            if (kVar != null) {
                kVar.b(w);
            } else {
                this.f3155b = w;
            }
            P(coordinatorLayout, appBarLayout, B(), 0, true);
            appBarLayout.b(B());
            O(coordinatorLayout, appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.r(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            K(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            L(coordinatorLayout, (AppBarLayout) view, i4, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void u(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof a) {
                a aVar = (a) parcelable;
                this.n = aVar.f4441d;
                this.p = aVar.f4442e;
                this.o = aVar.f;
                return;
            }
            this.n = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public Parcelable v(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            int B = B();
            int childCount = appBarLayout.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + B;
                if (childAt.getTop() + B <= 0 && bottom >= 0) {
                    a aVar = new a(absSavedState);
                    aVar.f4441d = i;
                    if (bottom == appBarLayout.getTopInset() + m.p(childAt)) {
                        z = true;
                    }
                    aVar.f = z;
                    aVar.f4442e = ((float) bottom) / ((float) childAt.getHeight());
                    return aVar;
                }
            }
            return absSavedState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean x(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            return M(coordinatorLayout, (AppBarLayout) view, view2, i, i2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.l == 0 || i == 1) {
                N(coordinatorLayout, appBarLayout);
                if (appBarLayout.l) {
                    appBarLayout.d(appBarLayout.e(view2));
                }
            }
            this.q = new WeakReference<>(view2);
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends c.b.a.b.n.i {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ScrollingViewBehavior_Layout);
            this.g = obtainStyledAttributes.getDimensionPixelSize(l.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }

        public AppBarLayout E(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) view2.getLayoutParams()).f125a;
            if (cVar instanceof BaseBehavior) {
                m.H(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVar).k) + this.f) - D(view2));
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.l) {
                return false;
            }
            appBarLayout.d(appBarLayout.e(view));
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                m.O(coordinatorLayout, b.a.f.a());
                m.O(coordinatorLayout, b.a.g.a());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean t(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout E = E(coordinatorLayout.d(view));
            if (E != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f3152d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    E.c(false, !z, true);
                    return true;
                }
            }
            return false;
        }
    }

    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    public static class b extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f4443a = 1;

        /* renamed from: b  reason: collision with root package name */
        public Interpolator f4444b;

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.AppBarLayout_Layout);
            this.f4443a = obtainStyledAttributes.getInt(l.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(l.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f4444b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(l.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface c extends a<AppBarLayout> {
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r6, r), attributeSet, r6);
        int i2 = c.b.a.b.b.appBarLayoutStyle;
        Context context2 = getContext();
        setOrientation(1);
        setOutlineProvider(ViewOutlineProvider.BOUNDS);
        int i3 = r;
        Context context3 = getContext();
        TypedArray d2 = c.b.a.b.c0.i.d(context3, attributeSet, c.b.a.b.n.l.f3162a, i2, i3, new int[0]);
        try {
            if (d2.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, d2.getResourceId(0, 0)));
            }
            d2.recycle();
            TypedArray d3 = c.b.a.b.c0.i.d(context2, attributeSet, l.AppBarLayout, i2, r, new int[0]);
            m.W(this, d3.getDrawable(l.AppBarLayout_android_background));
            if (getBackground() instanceof ColorDrawable) {
                g gVar = new g();
                gVar.r(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
                gVar.f2982b.f2988b = new c.b.a.b.z.a(context2);
                gVar.z();
                setBackground(gVar);
            }
            if (d3.hasValue(l.AppBarLayout_expanded)) {
                c(d3.getBoolean(l.AppBarLayout_expanded, false), false, false);
            }
            if (d3.hasValue(l.AppBarLayout_elevation)) {
                c.b.a.b.n.l.a(this, (float) d3.getDimensionPixelSize(l.AppBarLayout_elevation, 0));
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (d3.hasValue(l.AppBarLayout_android_keyboardNavigationCluster)) {
                    setKeyboardNavigationCluster(d3.getBoolean(l.AppBarLayout_android_keyboardNavigationCluster, false));
                }
                if (d3.hasValue(l.AppBarLayout_android_touchscreenBlocksFocus)) {
                    setTouchscreenBlocksFocus(d3.getBoolean(l.AppBarLayout_android_touchscreenBlocksFocus, false));
                }
            }
            this.l = d3.getBoolean(l.AppBarLayout_liftOnScroll, false);
            this.m = d3.getResourceId(l.AppBarLayout_liftOnScrollTargetViewId, -1);
            setStatusBarForeground(d3.getDrawable(l.AppBarLayout_statusBarForeground));
            d3.recycle();
            m.b0(this, new c.b.a.b.n.a(this));
        } catch (Throwable th) {
            d2.recycle();
            throw th;
        }
    }

    /* renamed from: a */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new b((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void b(int i2) {
        this.f4437b = i2;
        if (!willNotDraw()) {
            m.L(this);
        }
        List<a> list = this.i;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.i.get(i3);
                if (aVar != null) {
                    aVar.a(this, i2);
                }
            }
        }
    }

    public final void c(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i2 = 8;
        }
        this.g = i3 | i2;
        requestLayout();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    public boolean d(boolean z) {
        if (this.k == z) {
            return false;
        }
        this.k = z;
        refreshDrawableState();
        if (this.l && (getBackground() instanceof g)) {
            g gVar = (g) getBackground();
            float dimension = getResources().getDimension(c.b.a.b.d.design_appbar_elevation);
            float f2 = z ? 0.0f : dimension;
            if (!z) {
                dimension = 0.0f;
            }
            ValueAnimator valueAnimator = this.o;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, dimension);
            this.o = ofFloat;
            ofFloat.setDuration((long) getResources().getInteger(c.b.a.b.g.app_bar_elevation_anim_duration));
            this.o.setInterpolator(c.b.a.b.m.a.f3108a);
            this.o.addUpdateListener(new c.b.a.b.n.b(this, gVar));
            this.o.start();
        }
        return true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.q != null && getTopInset() > 0) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.f4437b));
            this.q.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public boolean e(View view) {
        int i2;
        View view2 = null;
        if (this.n == null && (i2 = this.m) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.m);
            }
            if (findViewById != null) {
                this.n = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            view2 = weakReference.get();
        }
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public final boolean f() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return childAt.getVisibility() != 8 && !m.l(childAt);
    }

    public final void g() {
        setWillNotDraw(!(this.q != null && getTopInset() > 0));
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int i2;
        int p2;
        int i3 = this.f4439d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = bVar.f4443a;
            if ((i5 & 5) == 5) {
                int i6 = ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
                if ((i5 & 8) != 0) {
                    p2 = m.p(childAt);
                } else if ((i5 & 2) != 0) {
                    p2 = measuredHeight - m.p(childAt);
                } else {
                    i2 = i6 + measuredHeight;
                    if (childCount == 0 && m.l(childAt)) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                    i4 += i2;
                }
                i2 = p2 + i6;
                i2 = Math.min(i2, measuredHeight - getTopInset());
                i4 += i2;
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f4439d = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i2 = this.f4440e;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin + childAt.getMeasuredHeight();
            int i5 = bVar.f4443a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= m.p(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f4440e = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int p2 = m.p(this);
        if (p2 == 0) {
            int childCount = getChildCount();
            p2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
            if (p2 == 0) {
                return getHeight() / 3;
            }
        }
        return (p2 * 2) + topInset;
    }

    public int getPendingAction() {
        return this.g;
    }

    public Drawable getStatusBarForeground() {
        return this.q;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        v vVar = this.h;
        if (vVar != null) {
            return vVar.e();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f4438c;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = bVar.f4443a;
            if ((i5 & 1) == 0) {
                break;
            }
            int i6 = measuredHeight + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin + i4;
            if (i3 == 0 && m.l(childAt)) {
                i6 -= getTopInset();
            }
            i4 = i6;
            if ((i5 & 2) != 0) {
                i4 -= m.p(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f4438c = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            c.b.a.a.c.n.c.f2(this, (g) background);
        }
    }

    public int[] onCreateDrawableState(int i2) {
        if (this.p == null) {
            this.p = new int[4];
        }
        int[] iArr = this.p;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.j ? c.b.a.b.b.state_liftable : -c.b.a.b.b.state_liftable;
        iArr[1] = (!this.j || !this.k) ? -c.b.a.b.b.state_lifted : c.b.a.b.b.state_lifted;
        iArr[2] = this.j ? c.b.a.b.b.state_collapsible : -c.b.a.b.b.state_collapsible;
        iArr[3] = (!this.j || !this.k) ? -c.b.a.b.b.state_collapsed : c.b.a.b.b.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        super.onLayout(z, i2, i3, i4, i5);
        boolean z3 = true;
        if (m.l(this) && f()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                getChildAt(childCount).offsetTopAndBottom(topInset);
            }
        }
        this.f4438c = -1;
        this.f4439d = -1;
        this.f4440e = -1;
        this.f = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            } else if (((b) getChildAt(i6).getLayoutParams()).f4444b != null) {
                this.f = true;
                break;
            } else {
                i6++;
            }
        }
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.l) {
            int childCount3 = getChildCount();
            int i7 = 0;
            while (true) {
                if (i7 >= childCount3) {
                    z2 = false;
                    break;
                }
                int i8 = ((b) getChildAt(i7).getLayoutParams()).f4443a;
                if ((i8 & 1) == 1 && (i8 & 10) != 0) {
                    z2 = true;
                    break;
                }
                i7++;
            }
            if (!z2) {
                z3 = false;
            }
        }
        if (this.j != z3) {
            this.j = z3;
            refreshDrawableState();
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && m.l(this) && f()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = i.j.w(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        this.f4438c = -1;
        this.f4439d = -1;
        this.f4440e = -1;
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        c.b.a.a.c.n.c.e2(this, f2);
    }

    public void setExpanded(boolean z) {
        c(z, m.B(this), true);
    }

    public void setLiftOnScroll(boolean z) {
        this.l = z;
    }

    public void setLiftOnScrollTargetViewId(int i2) {
        this.m = i2;
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.q = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                this.q.setLayoutDirection(m.o(this));
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
            }
            g();
            m.L(this);
        }
    }

    public void setStatusBarForegroundColor(int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(int i2) {
        setStatusBarForeground(b.b.l.a.a.b(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        c.b.a.b.n.l.a(this, f2);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m348generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m349generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }
}
