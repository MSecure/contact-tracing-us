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
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$styleable;
import e.b.a.m;
import e.i.i.c0.b;
import e.i.i.i;
import e.i.i.v;
import f.b.a.e.b.d;
import f.b.a.e.b.e;
import f.b.a.e.b.f;
import f.b.a.e.v.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f480d;

    /* renamed from: e  reason: collision with root package name */
    public int f481e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f482f;

    /* renamed from: g  reason: collision with root package name */
    public int f483g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f484h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f485i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f486j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f487k;

    /* renamed from: l  reason: collision with root package name */
    public int f488l;
    public WeakReference<View> m;
    public ValueAnimator n;
    public int[] o;
    public Drawable p;

    public static class BaseBehavior<T extends AppBarLayout> extends e<T> {

        /* renamed from: j  reason: collision with root package name */
        public int f489j;

        /* renamed from: k  reason: collision with root package name */
        public int f490k;

        /* renamed from: l  reason: collision with root package name */
        public ValueAnimator f491l;
        public int m = -1;
        public boolean n;
        public float o;
        public WeakReference<View> p;

        public static class a extends e.k.a.a {
            public static final Parcelable.Creator<a> CREATOR = new C0005a();

            /* renamed from: d  reason: collision with root package name */
            public int f492d;

            /* renamed from: e  reason: collision with root package name */
            public float f493e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f494f;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$a$a  reason: collision with other inner class name */
            public static class C0005a implements Parcelable.ClassLoaderCreator<a> {
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
                this.f492d = parcel.readInt();
                this.f493e = parcel.readFloat();
                this.f494f = parcel.readByte() != 0;
            }

            public a(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // e.k.a.a
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeParcelable(this.b, i2);
                parcel.writeInt(this.f492d);
                parcel.writeFloat(this.f493e);
                parcel.writeByte(this.f494f ? (byte) 1 : 0);
            }
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static boolean J(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        @Override // f.b.a.e.b.e
        public int E() {
            return B() + this.f489j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.a.e.b.e
        public int H(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4) {
            int i5;
            ArrayList<T> orDefault;
            int i6;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int E = E();
            int i7 = 0;
            if (i3 == 0 || E < i3 || E > i4) {
                this.f489j = 0;
            } else {
                int v = m.e.v(i2, i3, i4);
                if (E != v) {
                    if (appBarLayout.f482f) {
                        int abs = Math.abs(v);
                        int childCount = appBarLayout.getChildCount();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= childCount) {
                                break;
                            }
                            View childAt = appBarLayout.getChildAt(i8);
                            c cVar = (c) childAt.getLayoutParams();
                            Interpolator interpolator = cVar.c;
                            if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                                i8++;
                            } else if (interpolator != null) {
                                int i9 = cVar.a;
                                if ((i9 & 1) != 0) {
                                    i6 = childAt.getHeight() + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin + 0;
                                    if ((i9 & 2) != 0) {
                                        AtomicInteger atomicInteger = v.a;
                                        i6 -= v.d.d(childAt);
                                    }
                                } else {
                                    i6 = 0;
                                }
                                AtomicInteger atomicInteger2 = v.a;
                                if (v.d.b(childAt)) {
                                    i6 -= appBarLayout.getTopInset();
                                }
                                if (i6 > 0) {
                                    float f2 = (float) i6;
                                    i5 = (childAt.getTop() + Math.round(interpolator.getInterpolation(((float) (abs - childAt.getTop())) / f2) * f2)) * Integer.signum(v);
                                }
                            }
                        }
                    }
                    i5 = v;
                    boolean D = D(i5);
                    int i10 = E - v;
                    this.f489j = v - i5;
                    if (D) {
                        for (int i11 = 0; i11 < appBarLayout.getChildCount(); i11++) {
                            c cVar2 = (c) appBarLayout.getChildAt(i11).getLayoutParams();
                            a aVar = cVar2.b;
                            if (!(aVar == null || (cVar2.a & 1) == 0)) {
                                View childAt2 = appBarLayout.getChildAt(i11);
                                b bVar = (b) aVar;
                                Rect rect = bVar.a;
                                childAt2.getDrawingRect(rect);
                                appBarLayout.offsetDescendantRectToMyCoords(childAt2, rect);
                                rect.offset(0, -appBarLayout.getTopInset());
                                float abs2 = ((float) bVar.a.top) - Math.abs((float) B());
                                float f3 = 0.0f;
                                if (abs2 <= 0.0f) {
                                    float abs3 = Math.abs(abs2 / ((float) bVar.a.height()));
                                    if (abs3 >= 0.0f) {
                                        f3 = abs3 > 1.0f ? 1.0f : abs3;
                                    }
                                    float f4 = 1.0f - f3;
                                    float height = (-abs2) - ((((float) bVar.a.height()) * 0.3f) * (1.0f - (f4 * f4)));
                                    childAt2.setTranslationY(height);
                                    childAt2.getDrawingRect(bVar.b);
                                    bVar.b.offset(0, (int) (-height));
                                    Rect rect2 = bVar.b;
                                    AtomicInteger atomicInteger3 = v.a;
                                    v.f.c(childAt2, rect2);
                                } else {
                                    AtomicInteger atomicInteger4 = v.a;
                                    v.f.c(childAt2, null);
                                    childAt2.setTranslationY(0.0f);
                                }
                            }
                        }
                    }
                    if (!D && appBarLayout.f482f && (orDefault = coordinatorLayout.c.b.getOrDefault(appBarLayout, null)) != null && !orDefault.isEmpty()) {
                        while (i7 < orDefault.size()) {
                            T t = orDefault.get(i7);
                            CoordinatorLayout.c cVar3 = ((CoordinatorLayout.f) t.getLayoutParams()).a;
                            if (cVar3 != null) {
                                cVar3.g(coordinatorLayout, t, appBarLayout);
                            }
                            i7++;
                        }
                    }
                    appBarLayout.b = B();
                    if (!appBarLayout.willNotDraw()) {
                        AtomicInteger atomicInteger5 = v.a;
                        v.d.k(appBarLayout);
                    }
                    Q(coordinatorLayout, appBarLayout, v, v < E ? -1 : 1, false);
                    i7 = i10;
                }
            }
            P(coordinatorLayout, appBarLayout);
            return i7;
        }

        public final void I(CoordinatorLayout coordinatorLayout, T t, int i2, float f2) {
            int abs = Math.abs(E() - i2);
            float abs2 = Math.abs(f2);
            int round = abs2 > 0.0f ? Math.round((((float) abs) / abs2) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            int E = E();
            if (E == i2) {
                ValueAnimator valueAnimator = this.f491l;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f491l.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f491l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f491l = valueAnimator3;
                valueAnimator3.setInterpolator(f.b.a.e.a.a.f2832e);
                this.f491l.addUpdateListener(new f.b.a.e.b.b(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.f491l.setDuration((long) Math.min(round, 600));
            this.f491l.setIntValues(E, i2);
            this.f491l.start();
        }

        public final View K(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof i) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;II[II)V */
        public void L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int[] iArr) {
            int i3;
            int i4;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i5 = -appBarLayout.getTotalScrollRange();
                    i4 = i5;
                    i3 = appBarLayout.getDownNestedPreScrollRange() + i5;
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    i3 = 0;
                }
                if (i4 != i3) {
                    iArr[1] = F(coordinatorLayout, appBarLayout, i2, i4, i3);
                }
            }
            if (appBarLayout.f487k) {
                appBarLayout.c(appBarLayout.d(view));
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;IIIII[I)V */
        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.google.android.material.appbar.AppBarLayout */
        /* JADX WARN: Multi-variable type inference failed */
        public void M(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int[] iArr) {
            if (i2 < 0) {
                iArr[1] = F(coordinatorLayout, appBarLayout, i2, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i2 == 0) {
                P(coordinatorLayout, appBarLayout);
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/coordinatorlayout/widget/CoordinatorLayout;TT;Landroid/view/View;Landroid/view/View;II)Z */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (((r4.getTotalScrollRange() != 0) && r3.getHeight() - r5.getHeight() <= r4.getHeight()) != false) goto L_0x002b;
         */
        public boolean N(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z = true;
            if ((i2 & 2) != 0) {
                if (!appBarLayout.f487k) {
                }
                if (z && (valueAnimator = this.f491l) != null) {
                    valueAnimator.cancel();
                }
                this.p = null;
                this.f490k = i3;
                return z;
            }
            z = false;
            valueAnimator.cancel();
            this.p = null;
            this.f490k = i3;
            return z;
        }

        public final void O(CoordinatorLayout coordinatorLayout, T t) {
            int E = E();
            int childCount = t.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i2 = -1;
                    break;
                }
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                c cVar = (c) childAt.getLayoutParams();
                if (J(cVar.a, 32)) {
                    top -= ((LinearLayout.LayoutParams) cVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) cVar).bottomMargin;
                }
                int i3 = -E;
                if (top <= i3 && bottom >= i3) {
                    break;
                }
                i2++;
            }
            if (i2 >= 0) {
                View childAt2 = t.getChildAt(i2);
                c cVar2 = (c) childAt2.getLayoutParams();
                int i4 = cVar2.a;
                if ((i4 & 17) == 17) {
                    int i5 = -childAt2.getTop();
                    int i6 = -childAt2.getBottom();
                    if (i2 == t.getChildCount() - 1) {
                        i6 += t.getTopInset();
                    }
                    if (J(i4, 2)) {
                        AtomicInteger atomicInteger = v.a;
                        i6 += v.d.d(childAt2);
                    } else if (J(i4, 5)) {
                        AtomicInteger atomicInteger2 = v.a;
                        int d2 = v.d.d(childAt2) + i6;
                        if (E < d2) {
                            i5 = d2;
                        } else {
                            i6 = d2;
                        }
                    }
                    if (J(i4, 32)) {
                        i5 += ((LinearLayout.LayoutParams) cVar2).topMargin;
                        i6 -= ((LinearLayout.LayoutParams) cVar2).bottomMargin;
                    }
                    if (E < (i6 + i5) / 2) {
                        i5 = i6;
                    }
                    I(coordinatorLayout, t, m.e.v(i5, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void P(CoordinatorLayout coordinatorLayout, T t) {
            b.a aVar = b.a.f1540f;
            v.r(aVar.a(), coordinatorLayout);
            v.m(coordinatorLayout, 0);
            b.a aVar2 = b.a.f1541g;
            v.r(aVar2.a(), coordinatorLayout);
            v.m(coordinatorLayout, 0);
            View K = K(coordinatorLayout);
            if (K != null && t.getTotalScrollRange() != 0 && (((CoordinatorLayout.f) K.getLayoutParams()).a instanceof ScrollingViewBehavior)) {
                if (E() != (-t.getTotalScrollRange()) && K.canScrollVertically(1)) {
                    v.s(coordinatorLayout, aVar, null, new d(this, t, false));
                }
                if (E() == 0) {
                    return;
                }
                if (K.canScrollVertically(-1)) {
                    int i2 = -t.getDownNestedPreScrollRange();
                    if (i2 != 0) {
                        v.s(coordinatorLayout, aVar2, null, new f.b.a.e.b.c(this, coordinatorLayout, t, K, i2));
                        return;
                    }
                    return;
                }
                v.s(coordinatorLayout, aVar2, null, new d(this, t, true));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
        public final void Q(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, boolean z) {
            View view;
            boolean z2;
            int abs = Math.abs(i2);
            int childCount = t.getChildCount();
            boolean z3 = false;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    view = null;
                    break;
                }
                view = t.getChildAt(i4);
                if (abs >= view.getTop() && abs <= view.getBottom()) {
                    break;
                }
                i4++;
            }
            if (view != null) {
                int i5 = ((c) view.getLayoutParams()).a;
                if ((i5 & 1) != 0) {
                    AtomicInteger atomicInteger = v.a;
                    int d2 = v.d.d(view);
                    if (i3 <= 0 || (i5 & 12) == 0 ? !((i5 & 2) == 0 || (-i2) < (view.getBottom() - d2) - t.getTopInset()) : (-i2) >= (view.getBottom() - d2) - t.getTopInset()) {
                        z2 = true;
                        if (t.f487k) {
                            z2 = t.d(K(coordinatorLayout));
                        }
                        boolean c = t.c(z2);
                        if (!z) {
                            if (c) {
                                List<View> e2 = coordinatorLayout.e(t);
                                int size = e2.size();
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= size) {
                                        break;
                                    }
                                    CoordinatorLayout.c cVar = ((CoordinatorLayout.f) e2.get(i6).getLayoutParams()).a;
                                    if (!(cVar instanceof ScrollingViewBehavior)) {
                                        i6++;
                                    } else if (((ScrollingViewBehavior) cVar).f2847f != 0) {
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
            }
            z2 = false;
            if (t.f487k) {
            }
            boolean c2 = t.c(z2);
            if (!z) {
            }
            t.jumpDrawablesToCurrentState();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c, f.b.a.e.b.g
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.k(coordinatorLayout, appBarLayout, i2);
            int pendingAction = appBarLayout.getPendingAction();
            int i3 = this.m;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(i3);
                int i4 = -childAt.getBottom();
                G(coordinatorLayout, appBarLayout, this.n ? appBarLayout.getTopInset() + v.d.d(childAt) + i4 : Math.round(((float) childAt.getHeight()) * this.o) + i4);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        I(coordinatorLayout, appBarLayout, i5, 0.0f);
                    } else {
                        G(coordinatorLayout, appBarLayout, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        I(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        G(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.f483g = 0;
            this.m = -1;
            D(m.e.v(B(), -appBarLayout.getTotalScrollRange(), 0));
            Q(coordinatorLayout, appBarLayout, B(), 0, true);
            appBarLayout.b = B();
            if (!appBarLayout.willNotDraw()) {
                AtomicInteger atomicInteger = v.a;
                v.d.k(appBarLayout);
            }
            P(coordinatorLayout, appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.s(appBarLayout, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) {
            L(coordinatorLayout, (AppBarLayout) view, view2, i3, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            M(coordinatorLayout, (AppBarLayout) view, i5, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void u(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof a) {
                a aVar = (a) parcelable;
                this.m = aVar.f492d;
                this.o = aVar.f493e;
                this.n = aVar.f494f;
                return;
            }
            this.m = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public Parcelable v(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            int B = B();
            int childCount = appBarLayout.getChildCount();
            boolean z = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int bottom = childAt.getBottom() + B;
                if (childAt.getTop() + B <= 0 && bottom >= 0) {
                    a aVar = new a(absSavedState);
                    aVar.f492d = i2;
                    AtomicInteger atomicInteger = v.a;
                    if (bottom == appBarLayout.getTopInset() + v.d.d(childAt)) {
                        z = true;
                    }
                    aVar.f494f = z;
                    aVar.f493e = ((float) bottom) / ((float) childAt.getHeight());
                    return aVar;
                }
            }
            return absSavedState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean x(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            return N(coordinatorLayout, (AppBarLayout) view, view2, i2, i3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f490k == 0 || i2 == 1) {
                O(coordinatorLayout, appBarLayout);
                if (appBarLayout.f487k) {
                    appBarLayout.c(appBarLayout.d(view2));
                }
            }
            this.p = new WeakReference<>(view2);
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            this.f2847f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }

        public AppBarLayout F(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
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
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) view2.getLayoutParams()).a;
            if (cVar instanceof BaseBehavior) {
                v.o(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVar).f489j) + this.f2846e) - E(view2));
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.f487k) {
                return false;
            }
            appBarLayout.c(appBarLayout.d(view));
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                v.r(b.a.f1540f.a(), coordinatorLayout);
                v.m(coordinatorLayout, 0);
                v.r(b.a.f1541g.a(), coordinatorLayout);
                v.m(coordinatorLayout, 0);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean t(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout F = F(coordinatorLayout.d(view));
            if (F != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.c;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    F.b(false, !z);
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class a {
    }

    public static class b extends a {
        public final Rect a = new Rect();
        public final Rect b = new Rect();
    }

    public static class c extends LinearLayout.LayoutParams {
        public int a = 1;
        public a b;
        public Interpolator c;

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            this.b = obtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollEffect, 0) != 1 ? null : new b();
            int i2 = R$styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i2, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: a */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new c((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public void b(boolean z, boolean z2) {
        this.f483g = (z ? 1 : 2) | (z2 ? 4 : 0) | 8;
        requestLayout();
    }

    public boolean c(boolean z) {
        if (!(!this.f484h) || this.f486j == z) {
            return false;
        }
        this.f486j = z;
        refreshDrawableState();
        if (!this.f487k || !(getBackground() instanceof g)) {
            return true;
        }
        g gVar = (g) getBackground();
        float dimension = getResources().getDimension(R$dimen.design_appbar_elevation);
        float f2 = z ? 0.0f : dimension;
        if (!z) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, dimension);
        this.n = ofFloat;
        ofFloat.setDuration((long) getResources().getInteger(R$integer.app_bar_elevation_anim_duration));
        this.n.setInterpolator(f.b.a.e.a.a.a);
        this.n.addUpdateListener(new f.b.a.e.b.a(this, gVar));
        this.n.start();
        return true;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public boolean d(View view) {
        int i2;
        View view2 = null;
        if (this.m == null && (i2 = this.f488l) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.f488l);
            }
            if (findViewById != null) {
                this.m = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.m;
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
        if (this.p != null && getTopInset() > 0) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.b));
            this.p.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8) {
            return false;
        }
        AtomicInteger atomicInteger = v.a;
        return !v.d.b(childAt);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int i2;
        int i3 = this.f480d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = cVar.a;
            if ((i5 & 5) == 5) {
                int i6 = ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
                if ((i5 & 8) != 0) {
                    AtomicInteger atomicInteger = v.a;
                    i2 = i6 + v.d.d(childAt);
                } else if ((i5 & 2) != 0) {
                    AtomicInteger atomicInteger2 = v.a;
                    i2 = i6 + (measuredHeight - v.d.d(childAt));
                } else {
                    i2 = i6 + measuredHeight;
                }
                if (childCount == 0) {
                    AtomicInteger atomicInteger3 = v.a;
                    if (v.d.b(childAt)) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                }
                i4 += i2;
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f480d = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i2 = this.f481e;
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
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin + childAt.getMeasuredHeight();
            int i5 = cVar.a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                AtomicInteger atomicInteger = v.a;
                i4 -= v.d.d(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f481e = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f488l;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        AtomicInteger atomicInteger = v.a;
        int d2 = v.d.d(this);
        if (d2 == 0) {
            int childCount = getChildCount();
            d2 = childCount >= 1 ? v.d.d(getChildAt(childCount - 1)) : 0;
            if (d2 == 0) {
                return getHeight() / 3;
            }
        }
        return (d2 * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f483g;
    }

    public Drawable getStatusBarForeground() {
        return this.p;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.c;
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
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = cVar.a;
            if ((i5 & 1) == 0) {
                break;
            }
            int i6 = measuredHeight + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin + i4;
            if (i3 == 0) {
                AtomicInteger atomicInteger = v.a;
                if (v.d.b(childAt)) {
                    i6 -= getTopInset();
                }
            }
            i4 = i6;
            if ((i5 & 2) != 0) {
                AtomicInteger atomicInteger2 = v.a;
                i4 -= v.d.d(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.c = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            f.b.a.c.b.o.b.p1(this, (g) background);
        }
    }

    public int[] onCreateDrawableState(int i2) {
        if (this.o == null) {
            this.o = new int[4];
        }
        int[] iArr = this.o;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z = this.f485i;
        int i3 = R$attr.state_liftable;
        if (!z) {
            i3 = -i3;
        }
        iArr[0] = i3;
        iArr[1] = (!z || !this.f486j) ? -R$attr.state_lifted : R$attr.state_lifted;
        int i4 = R$attr.state_collapsible;
        if (!z) {
            i4 = -i4;
        }
        iArr[2] = i4;
        iArr[3] = (!z || !this.f486j) ? -R$attr.state_collapsed : R$attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> weakReference = this.m;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.m = null;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        super.onLayout(z, i2, i3, i4, i5);
        AtomicInteger atomicInteger = v.a;
        boolean z3 = true;
        if (v.d.b(this) && e()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                v.o(getChildAt(childCount), topInset);
            }
        }
        this.c = -1;
        this.f480d = -1;
        this.f481e = -1;
        this.f482f = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            } else if (((c) getChildAt(i6).getLayoutParams()).c != null) {
                this.f482f = true;
                break;
            } else {
                i6++;
            }
        }
        Drawable drawable = this.p;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f484h) {
            if (!this.f487k) {
                int childCount3 = getChildCount();
                int i7 = 0;
                while (true) {
                    if (i7 >= childCount3) {
                        z2 = false;
                        break;
                    }
                    int i8 = ((c) getChildAt(i7).getLayoutParams()).a;
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
            if (this.f485i != z3) {
                this.f485i = z3;
                refreshDrawableState();
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            AtomicInteger atomicInteger = v.a;
            if (v.d.b(this) && e()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = m.e.v(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i3));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        this.c = -1;
        this.f480d = -1;
        this.f481e = -1;
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        f.b.a.c.b.o.b.o1(this, f2);
    }

    public void setExpanded(boolean z) {
        AtomicInteger atomicInteger = v.a;
        b(z, v.g.c(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.f487k = z;
    }

    public void setLiftOnScrollTargetViewId(int i2) {
        this.f488l = i2;
        WeakReference<View> weakReference = this.m;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.m = null;
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.f484h = z;
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.p = drawable3;
            boolean z = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                Drawable drawable4 = this.p;
                AtomicInteger atomicInteger = v.a;
                m.e.r1(drawable4, v.e.d(this));
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
            }
            if (this.p != null && getTopInset() > 0) {
                z = true;
            }
            setWillNotDraw(!z);
            AtomicInteger atomicInteger2 = v.a;
            v.d.k(this);
        }
    }

    public void setStatusBarForegroundColor(int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(int i2) {
        setStatusBarForeground(m.e.h0(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        int integer = getResources().getInteger(R$integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = (long) integer;
        stateListAnimator.addState(new int[]{16842766, R$attr.state_liftable, -R$attr.state_lifted}, ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(j2));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(this, "elevation", f2).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(0L));
        setStateListAnimator(stateListAnimator);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.p;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m0generateDefaultLayoutParams() {
        return new c(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m1generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }
}
