package com.google.android.material.appbar;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.k.i;
import b.i.l.m;
import b.i.l.w.b;
import b.x.t;
import c.b.a.b.h0.g;
import c.b.a.b.l;
import c.b.a.b.n.b;
import c.b.a.b.n.c;
import c.b.a.b.n.d;
import c.b.a.b.n.e;
import c.b.a.b.n.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: b  reason: collision with root package name */
    public int f5995b;

    /* renamed from: c  reason: collision with root package name */
    public int f5996c;

    /* renamed from: d  reason: collision with root package name */
    public int f5997d;

    /* renamed from: e  reason: collision with root package name */
    public int f5998e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5999f;

    /* renamed from: g  reason: collision with root package name */
    public int f6000g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public WeakReference<View> l;
    public ValueAnimator m;
    public int[] n;
    public Drawable o;

    public static class BaseBehavior<T extends AppBarLayout> extends e<T> {
        public int k;
        public int l;
        public ValueAnimator m;
        public int n = -1;
        public boolean o;
        public float p;
        public WeakReference<View> q;

        public static class a extends b.k.a.a {
            public static final Parcelable.Creator<a> CREATOR = new C0119a();

            /* renamed from: d  reason: collision with root package name */
            public int f6001d;

            /* renamed from: e  reason: collision with root package name */
            public float f6002e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f6003f;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$a$a  reason: collision with other inner class name */
            public static class C0119a implements Parcelable.ClassLoaderCreator<a> {
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
                this.f6001d = parcel.readInt();
                this.f6002e = parcel.readFloat();
                this.f6003f = parcel.readByte() != 0;
            }

            public a(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // b.k.a.a
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeParcelable(this.f1952b, i);
                parcel.writeInt(this.f6001d);
                parcel.writeFloat(this.f6002e);
                parcel.writeByte(this.f6003f ? (byte) 1 : 0);
            }
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static boolean J(int i, int i2) {
            return (i & i2) == i2;
        }

        @Override // c.b.a.b.n.e
        public int E() {
            return B() + this.k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7  */
        @Override // c.b.a.b.n.e
        public int H(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            int i4;
            ArrayList<T> orDefault;
            int i5;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int E = E();
            int i6 = 0;
            if (i2 == 0 || E < i2 || E > i3) {
                this.k = 0;
            } else {
                int j = i.j.j(i, i2, i3);
                if (E != j) {
                    if (appBarLayout.f5999f) {
                        int abs = Math.abs(j);
                        int childCount = appBarLayout.getChildCount();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= childCount) {
                                break;
                            }
                            View childAt = appBarLayout.getChildAt(i7);
                            a aVar = (a) childAt.getLayoutParams();
                            Interpolator interpolator = aVar.f6005b;
                            if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                                i7++;
                            } else if (interpolator != null) {
                                int i8 = aVar.f6004a;
                                if ((i8 & 1) != 0) {
                                    i5 = childAt.getHeight() + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + 0;
                                    if ((i8 & 2) != 0) {
                                        i5 -= m.q(childAt);
                                    }
                                } else {
                                    i5 = 0;
                                }
                                if (m.m(childAt)) {
                                    i5 -= appBarLayout.getTopInset();
                                }
                                if (i5 > 0) {
                                    float f2 = (float) i5;
                                    i4 = (childAt.getTop() + Math.round(interpolator.getInterpolation(((float) (abs - childAt.getTop())) / f2) * f2)) * Integer.signum(j);
                                }
                            }
                        }
                        boolean D = D(i4);
                        int i9 = E - j;
                        this.k = j - i4;
                        if (!D && appBarLayout.f5999f && (orDefault = coordinatorLayout.f179c.f1642b.getOrDefault(appBarLayout, null)) != null && !orDefault.isEmpty()) {
                            while (i6 < orDefault.size()) {
                                T t = orDefault.get(i6);
                                CoordinatorLayout.c cVar = ((CoordinatorLayout.f) t.getLayoutParams()).f186a;
                                if (cVar != null) {
                                    cVar.g(coordinatorLayout, t, appBarLayout);
                                }
                                i6++;
                            }
                        }
                        appBarLayout.f5995b = B();
                        if (!appBarLayout.willNotDraw()) {
                            m.M(appBarLayout);
                        }
                        Q(coordinatorLayout, appBarLayout, j, j >= E ? -1 : 1, false);
                        i6 = i9;
                    }
                    i4 = j;
                    boolean D2 = D(i4);
                    int i92 = E - j;
                    this.k = j - i4;
                    while (i6 < orDefault.size()) {
                    }
                    appBarLayout.f5995b = B();
                    if (!appBarLayout.willNotDraw()) {
                    }
                    Q(coordinatorLayout, appBarLayout, j, j >= E ? -1 : 1, false);
                    i6 = i92;
                }
            }
            P(coordinatorLayout, appBarLayout);
            return i6;
        }

        public final void I(CoordinatorLayout coordinatorLayout, T t, int i, float f2) {
            int abs = Math.abs(E() - i);
            float abs2 = Math.abs(f2);
            int round = abs2 > 0.0f ? Math.round((((float) abs) / abs2) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            int E = E();
            if (E == i) {
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
                valueAnimator3.setInterpolator(c.b.a.b.m.a.f4414e);
                this.m.addUpdateListener(new b(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration((long) Math.min(round, 600));
            this.m.setIntValues(E, i);
            this.m.start();
        }

        public final View K(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof b.i.l.e) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;II[II)V */
        public void L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int[] iArr) {
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
                    iArr[1] = F(coordinatorLayout, appBarLayout, i, i3, i2);
                }
            }
            if (appBarLayout.j) {
                appBarLayout.c(appBarLayout.d(view));
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;IIIII[I)V */
        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.google.android.material.appbar.AppBarLayout */
        /* JADX WARN: Multi-variable type inference failed */
        public void M(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int[] iArr) {
            if (i < 0) {
                iArr[1] = F(coordinatorLayout, appBarLayout, i, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i == 0) {
                P(coordinatorLayout, appBarLayout);
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;Landroid/view/View;II)Z */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (((r4.getTotalScrollRange() != 0) && r3.getHeight() - r5.getHeight() <= r4.getHeight()) != false) goto L_0x002b;
         */
        public boolean N(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = true;
            if ((i & 2) != 0) {
                if (!appBarLayout.j) {
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

        public final void O(CoordinatorLayout coordinatorLayout, T t) {
            int E = E();
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
                a aVar = (a) childAt.getLayoutParams();
                if (J(aVar.f6004a, 32)) {
                    top -= ((LinearLayout.LayoutParams) aVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) aVar).bottomMargin;
                }
                int i2 = -E;
                if (top <= i2 && bottom >= i2) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                View childAt2 = t.getChildAt(i);
                a aVar2 = (a) childAt2.getLayoutParams();
                int i3 = aVar2.f6004a;
                if ((i3 & 17) == 17) {
                    int i4 = -childAt2.getTop();
                    int i5 = -childAt2.getBottom();
                    if (i == t.getChildCount() - 1) {
                        i5 += t.getTopInset();
                    }
                    if (J(i3, 2)) {
                        i5 += m.q(childAt2);
                    } else if (J(i3, 5)) {
                        int q2 = m.q(childAt2) + i5;
                        if (E < q2) {
                            i4 = q2;
                        } else {
                            i5 = q2;
                        }
                    }
                    if (J(i3, 32)) {
                        i4 += ((LinearLayout.LayoutParams) aVar2).topMargin;
                        i5 -= ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                    }
                    if (E < (i5 + i4) / 2) {
                        i4 = i5;
                    }
                    I(coordinatorLayout, t, i.j.j(i4, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void P(CoordinatorLayout coordinatorLayout, T t) {
            m.P(coordinatorLayout, b.a.f1910f.a());
            m.P(coordinatorLayout, b.a.f1911g.a());
            View K = K(coordinatorLayout);
            if (K != null && t.getTotalScrollRange() != 0 && (((CoordinatorLayout.f) K.getLayoutParams()).f186a instanceof ScrollingViewBehavior)) {
                if (E() != (-t.getTotalScrollRange()) && K.canScrollVertically(1)) {
                    m.R(coordinatorLayout, b.a.f1910f, null, new d(this, t, false));
                }
                if (E() == 0) {
                    return;
                }
                if (K.canScrollVertically(-1)) {
                    int i = -t.getDownNestedPreScrollRange();
                    if (i != 0) {
                        m.R(coordinatorLayout, b.a.f1911g, null, new c(this, coordinatorLayout, t, K, i));
                        return;
                    }
                    return;
                }
                m.R(coordinatorLayout, b.a.f1911g, null, new d(this, t, true));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x006e  */
        public final void Q(CoordinatorLayout coordinatorLayout, T t, int i, int i2, boolean z) {
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
                int i4 = ((a) view.getLayoutParams()).f6004a;
                if ((i4 & 1) != 0) {
                    int q2 = m.q(view);
                    if (i2 <= 0 || (i4 & 12) == 0 ? !((i4 & 2) == 0 || (-i) < (view.getBottom() - q2) - t.getTopInset()) : (-i) >= (view.getBottom() - q2) - t.getTopInset()) {
                        z2 = true;
                        if (t.j) {
                            z2 = t.d(K(coordinatorLayout));
                        }
                        boolean c2 = t.c(z2);
                        if (!z) {
                            if (c2) {
                                List<View> e2 = coordinatorLayout.e(t);
                                int size = e2.size();
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= size) {
                                        break;
                                    }
                                    CoordinatorLayout.c cVar = ((CoordinatorLayout.f) e2.get(i5).getLayoutParams()).f186a;
                                    if (!(cVar instanceof ScrollingViewBehavior)) {
                                        i5++;
                                    } else if (((ScrollingViewBehavior) cVar).f4456g != 0) {
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
                if (t.j) {
                }
                boolean c22 = t.c(z2);
                if (!z) {
                }
                t.jumpDrawablesToCurrentState();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.a.b.n.g, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.k(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            int i2 = this.n;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(i2);
                int i3 = -childAt.getBottom();
                G(coordinatorLayout, appBarLayout, this.o ? appBarLayout.getTopInset() + childAt.getMinimumHeight() + i3 : Math.round(((float) childAt.getHeight()) * this.p) + i3);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        I(coordinatorLayout, appBarLayout, i4, 0.0f);
                    } else {
                        G(coordinatorLayout, appBarLayout, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        I(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        G(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.f6000g = 0;
            this.n = -1;
            D(i.j.j(B(), -appBarLayout.getTotalScrollRange(), 0));
            Q(coordinatorLayout, appBarLayout, B(), 0, true);
            appBarLayout.f5995b = B();
            if (!appBarLayout.willNotDraw()) {
                appBarLayout.postInvalidateOnAnimation();
            }
            P(coordinatorLayout, appBarLayout);
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
            L(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            M(coordinatorLayout, (AppBarLayout) view, i4, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void u(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof a) {
                a aVar = (a) parcelable;
                this.n = aVar.f6001d;
                this.p = aVar.f6002e;
                this.o = aVar.f6003f;
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
                    aVar.f6001d = i;
                    if (bottom == appBarLayout.getTopInset() + m.q(childAt)) {
                        z = true;
                    }
                    aVar.f6003f = z;
                    aVar.f6002e = ((float) bottom) / ((float) childAt.getHeight());
                    return aVar;
                }
            }
            return absSavedState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean x(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            return N(coordinatorLayout, (AppBarLayout) view, view2, i, i2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.l == 0 || i == 1) {
                O(coordinatorLayout, appBarLayout);
                if (appBarLayout.j) {
                    appBarLayout.c(appBarLayout.d(view2));
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

    public static class ScrollingViewBehavior extends f {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ScrollingViewBehavior_Layout);
            this.f4456g = obtainStyledAttributes.getDimensionPixelSize(l.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }

        public AppBarLayout F(List<View> list) {
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
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) view2.getLayoutParams()).f186a;
            if (cVar instanceof BaseBehavior) {
                m.I(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVar).k) + this.f4455f) - E(view2));
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.j) {
                return false;
            }
            appBarLayout.c(appBarLayout.d(view));
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                m.P(coordinatorLayout, b.a.f1910f.a());
                m.P(coordinatorLayout, b.a.f1911g.a());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean t(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout F = F(coordinatorLayout.d(view));
            if (F != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f4453d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    F.b(false, !z);
                    return true;
                }
            }
            return false;
        }
    }

    public static class a extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f6004a = 1;

        /* renamed from: b  reason: collision with root package name */
        public Interpolator f6005b;

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.AppBarLayout_Layout);
            this.f6004a = obtainStyledAttributes.getInt(l.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(l.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f6005b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(l.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public a(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: a */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new a((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    public void b(boolean z, boolean z2) {
        int i2 = z ? 1 : 2;
        int i3 = 0;
        if (z2) {
            i3 = 4;
        }
        this.f6000g = i2 | i3 | 8;
        requestLayout();
    }

    public boolean c(boolean z) {
        if (this.i == z) {
            return false;
        }
        this.i = z;
        refreshDrawableState();
        if (this.j && (getBackground() instanceof g)) {
            g gVar = (g) getBackground();
            float dimension = getResources().getDimension(c.b.a.b.d.design_appbar_elevation);
            float f2 = z ? 0.0f : dimension;
            if (!z) {
                dimension = 0.0f;
            }
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, dimension);
            this.m = ofFloat;
            ofFloat.setDuration((long) getResources().getInteger(c.b.a.b.g.app_bar_elevation_anim_duration));
            this.m.setInterpolator(c.b.a.b.m.a.f4410a);
            this.m.addUpdateListener(new c.b.a.b.n.a(this, gVar));
            this.m.start();
        }
        return true;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public boolean d(View view) {
        int i2;
        View view2 = null;
        if (this.l == null && (i2 = this.k) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.k);
            }
            if (findViewById != null) {
                this.l = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.l;
        if (weakReference != null) {
            view2 = weakReference.get();
        }
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.o != null && getTopInset() > 0) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.f5995b));
            this.o.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.o;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return childAt.getVisibility() != 8 && !m.m(childAt);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int i2;
        int q;
        int i3 = this.f5997d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = aVar.f6004a;
            if ((i5 & 5) == 5) {
                int i6 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                if ((i5 & 8) != 0) {
                    q = m.q(childAt);
                } else if ((i5 & 2) != 0) {
                    q = measuredHeight - m.q(childAt);
                } else {
                    i2 = i6 + measuredHeight;
                    if (childCount == 0 && m.m(childAt)) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                    i4 += i2;
                }
                i2 = q + i6;
                i2 = Math.min(i2, measuredHeight - getTopInset());
                i4 += i2;
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f5997d = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i2 = this.f5998e;
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
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + childAt.getMeasuredHeight();
            int i5 = aVar.f6004a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= m.q(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f5998e = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.k;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int q = m.q(this);
        if (q == 0) {
            int childCount = getChildCount();
            q = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
            if (q == 0) {
                return getHeight() / 3;
            }
        }
        return (q * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f6000g;
    }

    public Drawable getStatusBarForeground() {
        return this.o;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f5996c;
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
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = aVar.f6004a;
            if ((i5 & 1) == 0) {
                break;
            }
            int i6 = measuredHeight + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + i4;
            if (i3 == 0 && m.m(childAt)) {
                i6 -= getTopInset();
            }
            i4 = i6;
            if ((i5 & 2) != 0) {
                i4 -= m.q(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f5996c = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            t.K2(this, (g) background);
        }
    }

    public int[] onCreateDrawableState(int i2) {
        if (this.n == null) {
            this.n = new int[4];
        }
        int[] iArr = this.n;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.h ? c.b.a.b.b.state_liftable : -c.b.a.b.b.state_liftable;
        iArr[1] = (!this.h || !this.i) ? -c.b.a.b.b.state_lifted : c.b.a.b.b.state_lifted;
        iArr[2] = this.h ? c.b.a.b.b.state_collapsible : -c.b.a.b.b.state_collapsible;
        iArr[3] = (!this.h || !this.i) ? -c.b.a.b.b.state_collapsed : c.b.a.b.b.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> weakReference = this.l;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.l = null;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        super.onLayout(z, i2, i3, i4, i5);
        boolean z3 = true;
        if (m.m(this) && e()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                getChildAt(childCount).offsetTopAndBottom(topInset);
            }
        }
        this.f5996c = -1;
        this.f5997d = -1;
        this.f5998e = -1;
        this.f5999f = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            } else if (((a) getChildAt(i6).getLayoutParams()).f6005b != null) {
                this.f5999f = true;
                break;
            } else {
                i6++;
            }
        }
        Drawable drawable = this.o;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.j) {
            int childCount3 = getChildCount();
            int i7 = 0;
            while (true) {
                if (i7 >= childCount3) {
                    z2 = false;
                    break;
                }
                int i8 = ((a) getChildAt(i7).getLayoutParams()).f6004a;
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
        if (this.h != z3) {
            this.h = z3;
            refreshDrawableState();
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && m.m(this) && e()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = i.j.j(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        this.f5996c = -1;
        this.f5997d = -1;
        this.f5998e = -1;
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        t.J2(this, f2);
    }

    public void setExpanded(boolean z) {
        b(z, m.C(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.j = z;
    }

    public void setLiftOnScrollTargetViewId(int i2) {
        this.k = i2;
        WeakReference<View> weakReference = this.l;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.l = null;
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.o = drawable3;
            boolean z = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                this.o.setLayoutDirection(m.p(this));
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
            }
            if (this.o != null && getTopInset() > 0) {
                z = true;
            }
            setWillNotDraw(true ^ z);
            m.M(this);
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
        int integer = getResources().getInteger(c.b.a.b.g.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = (long) integer;
        stateListAnimator.addState(new int[]{16842766, c.b.a.b.b.state_liftable, -c.b.a.b.b.state_lifted}, ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(j2));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(this, "elevation", f2).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(0L));
        setStateListAnimator(stateListAnimator);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.o;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m348generateDefaultLayoutParams() {
        return new a(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m349generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }
}
