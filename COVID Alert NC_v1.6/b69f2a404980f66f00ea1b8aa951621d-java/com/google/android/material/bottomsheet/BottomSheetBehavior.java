package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.k.i;
import b.i.l.m;
import b.i.l.w.b;
import b.i.l.w.d;
import b.k.b.e;
import c.b.a.b.h0.g;
import c.b.a.b.h0.j;
import c.b.a.b.k;
import c.b.a.b.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public static final int N = k.Widget_Design_BottomSheet_Modal;
    public int A;
    public boolean B;
    public int C;
    public int D;
    public WeakReference<V> E;
    public WeakReference<View> F;
    public final ArrayList<d> G = new ArrayList<>();
    public VelocityTracker H;
    public int I;
    public int J;
    public boolean K;
    public Map<View, Integer> L;
    public final e.c M = new b();

    /* renamed from: a  reason: collision with root package name */
    public int f4472a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4473b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4474c = false;

    /* renamed from: d  reason: collision with root package name */
    public float f4475d;

    /* renamed from: e  reason: collision with root package name */
    public int f4476e;
    public boolean f;
    public int g;
    public boolean h;
    public g i;
    public boolean j;
    public j k;
    public boolean l;
    public BottomSheetBehavior<V>.f m = null;
    public ValueAnimator n;
    public int o;
    public int p;
    public int q;
    public float r = 0.5f;
    public int s;
    public float t = -1.0f;
    public boolean u;
    public boolean v;
    public boolean w = true;
    public int x = 4;
    public b.k.b.e y;
    public boolean z;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f4477b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4478c;

        public a(View view, int i) {
            this.f4477b = view;
            this.f4478c = i;
        }

        public void run() {
            BottomSheetBehavior.this.N(this.f4477b, this.f4478c);
        }
    }

    public class b extends e.c {
        public b() {
        }

        @Override // b.k.b.e.c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // b.k.b.e.c
        public int b(View view, int i, int i2) {
            int I = BottomSheetBehavior.this.I();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return i.j.w(i, I, bottomSheetBehavior.u ? bottomSheetBehavior.D : bottomSheetBehavior.s);
        }

        @Override // b.k.b.e.c
        public int d(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.u ? bottomSheetBehavior.D : bottomSheetBehavior.s;
        }

        @Override // b.k.b.e.c
        public void f(int i) {
            if (i == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.w) {
                    bottomSheetBehavior.M(1);
                }
            }
        }

        @Override // b.k.b.e.c
        public void g(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.F(i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
            if (java.lang.Math.abs(r8.getTop() - r7.f4480a.o) < java.lang.Math.abs(r8.getTop() - r7.f4480a.q)) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b8, code lost:
            if (java.lang.Math.abs(r9 - r7.f4480a.q) < java.lang.Math.abs(r9 - r7.f4480a.s)) goto L_0x00ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f0, code lost:
            if (r9 < java.lang.Math.abs(r9 - r10.s)) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0102, code lost:
            if (java.lang.Math.abs(r9 - r0) < java.lang.Math.abs(r9 - r7.f4480a.s)) goto L_0x00ba;
         */
        @Override // b.k.b.e.c
        public void h(View view, float f, float f2) {
            int i;
            BottomSheetBehavior bottomSheetBehavior;
            BottomSheetBehavior bottomSheetBehavior2;
            int i2 = 4;
            if (f2 < 0.0f) {
                bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.f4473b) {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    int i3 = bottomSheetBehavior3.q;
                    if (top > i3) {
                        i = i3;
                        i2 = 6;
                        BottomSheetBehavior.this.Q(view, i2, i, true);
                    }
                    i = bottomSheetBehavior3.o;
                    i2 = 3;
                    BottomSheetBehavior.this.Q(view, i2, i, true);
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                if (!bottomSheetBehavior4.u || !bottomSheetBehavior4.P(view, f2)) {
                    if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                        if (!bottomSheetBehavior5.f4473b) {
                            int i4 = bottomSheetBehavior5.q;
                            if (top2 < i4) {
                            }
                            i = BottomSheetBehavior.this.q;
                            i2 = 6;
                            BottomSheetBehavior.this.Q(view, i2, i, true);
                        } else if (Math.abs(top2 - bottomSheetBehavior5.p) < Math.abs(top2 - BottomSheetBehavior.this.s)) {
                            bottomSheetBehavior = BottomSheetBehavior.this;
                        }
                        bottomSheetBehavior2 = BottomSheetBehavior.this;
                    } else {
                        bottomSheetBehavior2 = BottomSheetBehavior.this;
                        if (!bottomSheetBehavior2.f4473b) {
                            int top3 = view.getTop();
                        }
                    }
                    i = bottomSheetBehavior2.s;
                    BottomSheetBehavior.this.Q(view, i2, i, true);
                }
                if (Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) {
                    int top4 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                    if (!(top4 > (bottomSheetBehavior6.I() + bottomSheetBehavior6.D) / 2)) {
                        bottomSheetBehavior = BottomSheetBehavior.this;
                        if (!bottomSheetBehavior.f4473b) {
                        }
                    }
                }
                i = BottomSheetBehavior.this.D;
                i2 = 5;
                BottomSheetBehavior.this.Q(view, i2, i, true);
                i = BottomSheetBehavior.this.o;
                i2 = 3;
                BottomSheetBehavior.this.Q(view, i2, i, true);
            }
            i = bottomSheetBehavior.p;
            i2 = 3;
            BottomSheetBehavior.this.Q(view, i2, i, true);
        }

        @Override // b.k.b.e.c
        public boolean i(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.x;
            if (i2 == 1 || bottomSheetBehavior.K) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.I == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.F;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.E;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    public class c implements b.i.l.w.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f4481a;

        public c(int i) {
            this.f4481a = i;
        }

        @Override // b.i.l.w.d
        public boolean a(View view, d.a aVar) {
            BottomSheetBehavior.this.L(this.f4481a);
            return true;
        }
    }

    public static abstract class d {
        public abstract void a(View view, float f);

        public abstract void b(View view, int i);
    }

    public static class e extends b.k.a.a {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public final int f4483d;

        /* renamed from: e  reason: collision with root package name */
        public int f4484e;
        public boolean f;
        public boolean g;
        public boolean h;

        public static class a implements Parcelable.ClassLoaderCreator<e> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new e(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new e[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }
        }

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4483d = parcel.readInt();
            this.f4484e = parcel.readInt();
            boolean z = false;
            this.f = parcel.readInt() == 1;
            this.g = parcel.readInt() == 1;
            this.h = parcel.readInt() == 1 ? true : z;
        }

        public e(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f4483d = bottomSheetBehavior.x;
            this.f4484e = bottomSheetBehavior.f4476e;
            this.f = bottomSheetBehavior.f4473b;
            this.g = bottomSheetBehavior.u;
            this.h = bottomSheetBehavior.v;
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1231b, i);
            parcel.writeInt(this.f4483d);
            parcel.writeInt(this.f4484e);
            parcel.writeInt(this.f ? 1 : 0);
            parcel.writeInt(this.g ? 1 : 0);
            parcel.writeInt(this.h ? 1 : 0);
        }
    }

    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final View f4485b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4486c;

        /* renamed from: d  reason: collision with root package name */
        public int f4487d;

        public f(View view, int i) {
            this.f4485b = view;
            this.f4487d = i;
        }

        public void run() {
            b.k.b.e eVar = BottomSheetBehavior.this.y;
            if (eVar == null || !eVar.i(true)) {
                BottomSheetBehavior.this.M(this.f4487d);
            } else {
                m.M(this.f4485b, this);
            }
            this.f4486c = false;
        }
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimensionPixelSize;
        int i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.BottomSheetBehavior_Layout);
        this.h = obtainStyledAttributes.hasValue(l.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(l.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            E(context, attributeSet, hasValue, c.b.a.a.c.n.c.Z0(context, obtainStyledAttributes, l.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            E(context, attributeSet, hasValue, null);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.n = ofFloat;
        ofFloat.setDuration(500L);
        this.n.addUpdateListener(new c.b.a.b.r.a(this));
        this.t = obtainStyledAttributes.getDimension(l.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        TypedValue peekValue = obtainStyledAttributes.peekValue(l.BottomSheetBehavior_Layout_behavior_peekHeight);
        K((peekValue == null || (dimensionPixelSize = peekValue.data) != -1) ? obtainStyledAttributes.getDimensionPixelSize(l.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : dimensionPixelSize);
        J(obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_hideable, false));
        this.j = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z2 = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.f4473b != z2) {
            this.f4473b = z2;
            if (this.E != null) {
                C();
            }
            M((!this.f4473b || this.x != 6) ? this.x : 3);
            R();
        }
        this.v = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.w = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.f4472a = obtainStyledAttributes.getInt(l.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f2 = obtainStyledAttributes.getFloat(l.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.r = f2;
        if (this.E != null) {
            this.q = (int) ((1.0f - f2) * ((float) this.D));
        }
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(l.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (peekValue2 == null || peekValue2.type != 16) {
            i2 = obtainStyledAttributes.getDimensionPixelOffset(l.BottomSheetBehavior_Layout_behavior_expandedOffset, 0);
            if (i2 < 0) {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
        } else {
            i2 = peekValue2.data;
            if (i2 < 0) {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
        }
        this.o = i2;
        obtainStyledAttributes.recycle();
        this.f4475d = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static <V extends View> BottomSheetBehavior<V> H(V v2) {
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) layoutParams).f125a;
            if (cVar instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) cVar;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.x == 1 && actionMasked == 0) {
            return true;
        }
        b.k.b.e eVar = this.y;
        if (eVar != null) {
            eVar.n(motionEvent);
        }
        if (actionMasked == 0) {
            this.I = -1;
            VelocityTracker velocityTracker = this.H;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.H = null;
            }
        }
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
        if (actionMasked == 2 && !this.z) {
            float abs = Math.abs(((float) this.J) - motionEvent.getY());
            b.k.b.e eVar2 = this.y;
            if (abs > ((float) eVar2.f1240b)) {
                eVar2.b(v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.z;
    }

    public final void B(V v2, b.a aVar, int i2) {
        m.Q(v2, aVar, null, new c(i2));
    }

    public final void C() {
        int D2 = D();
        if (this.f4473b) {
            this.s = Math.max(this.D - D2, this.p);
        } else {
            this.s = this.D - D2;
        }
    }

    public final int D() {
        return this.f ? Math.max(this.g, this.D - ((this.C * 9) / 16)) : this.f4476e;
    }

    public final void E(Context context, AttributeSet attributeSet, boolean z2, ColorStateList colorStateList) {
        if (this.h) {
            this.k = j.b(context, attributeSet, c.b.a.b.b.bottomSheetStyle, N).a();
            g gVar = new g(this.k);
            this.i = gVar;
            gVar.f2982b.f2988b = new c.b.a.b.z.a(context);
            gVar.z();
            if (!z2 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.i.setTint(typedValue.data);
                return;
            }
            this.i.r(colorStateList);
        }
    }

    public void F(int i2) {
        float f2;
        float f3;
        V v2 = this.E.get();
        if (!(v2 == null || this.G.isEmpty())) {
            int i3 = this.s;
            if (i2 > i3 || i3 == I()) {
                int i4 = this.s;
                f2 = (float) (i4 - i2);
                f3 = (float) (this.D - i4);
            } else {
                int i5 = this.s;
                f2 = (float) (i5 - i2);
                f3 = (float) (i5 - I());
            }
            float f4 = f2 / f3;
            for (int i6 = 0; i6 < this.G.size(); i6++) {
                this.G.get(i6).a(v2, f4);
            }
        }
    }

    public View G(View view) {
        if (m.C(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View G2 = G(viewGroup.getChildAt(i2));
            if (G2 != null) {
                return G2;
            }
        }
        return null;
    }

    public int I() {
        return this.f4473b ? this.p : this.o;
    }

    public void J(boolean z2) {
        if (this.u != z2) {
            this.u = z2;
            if (!z2 && this.x == 5) {
                L(4);
            }
            R();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public void K(int i2) {
        V v2;
        boolean z2 = true;
        if (i2 == -1) {
            if (!this.f) {
                this.f = true;
                if (!z2 && this.E != null) {
                    C();
                    if (this.x == 4 && (v2 = this.E.get()) != null) {
                        v2.requestLayout();
                        return;
                    }
                    return;
                }
                return;
            }
        } else if (this.f || this.f4476e != i2) {
            this.f = false;
            this.f4476e = Math.max(0, i2);
            if (!z2) {
                return;
            }
            return;
        }
        z2 = false;
        if (!z2) {
        }
    }

    public void L(int i2) {
        if (i2 != this.x) {
            if (this.E != null) {
                O(i2);
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.u && i2 == 5)) {
                this.x = i2;
            }
        }
    }

    public void M(int i2) {
        V v2;
        if (this.x != i2) {
            this.x = i2;
            WeakReference<V> weakReference = this.E;
            if (!(weakReference == null || (v2 = weakReference.get()) == null)) {
                if (i2 == 3) {
                    T(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    T(false);
                }
                S(i2);
                for (int i3 = 0; i3 < this.G.size(); i3++) {
                    this.G.get(i3).b(v2, i2);
                }
                R();
            }
        }
    }

    public void N(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.s;
        } else if (i2 == 6) {
            int i5 = this.q;
            if (!this.f4473b || i5 > (i4 = this.p)) {
                i3 = i5;
            } else {
                i2 = 3;
                i3 = i4;
            }
        } else if (i2 == 3) {
            i3 = I();
        } else if (!this.u || i2 != 5) {
            throw new IllegalArgumentException(c.a.a.a.a.l("Illegal state argument: ", i2));
        } else {
            i3 = this.D;
        }
        Q(view, i2, i3, false);
    }

    public final void O(int i2) {
        V v2 = this.E.get();
        if (v2 != null) {
            ViewParent parent = v2.getParent();
            if (parent == null || !parent.isLayoutRequested() || !m.A(v2)) {
                N(v2, i2);
            } else {
                v2.post(new a(v2, i2));
            }
        }
    }

    public boolean P(View view, float f2) {
        if (this.v) {
            return true;
        }
        if (view.getTop() < this.s) {
            return false;
        }
        return Math.abs(((f2 * 0.1f) + ((float) view.getTop())) - ((float) this.s)) / ((float) D()) > 0.5f;
    }

    public void Q(View view, int i2, int i3, boolean z2) {
        boolean z3;
        if (z2) {
            z3 = this.y.t(view.getLeft(), i3);
        } else {
            b.k.b.e eVar = this.y;
            int left = view.getLeft();
            eVar.r = view;
            eVar.f1241c = -1;
            z3 = eVar.l(left, i3, 0, 0);
            if (!z3 && eVar.f1239a == 0 && eVar.r != null) {
                eVar.r = null;
            }
        }
        if (z3) {
            M(2);
            S(i2);
            if (this.m == null) {
                this.m = new f(view, i2);
            }
            BottomSheetBehavior<V>.f fVar = this.m;
            boolean z4 = fVar.f4486c;
            fVar.f4487d = i2;
            if (!z4) {
                m.M(view, fVar);
                this.m.f4486c = true;
                return;
            }
            return;
        }
        M(i2);
    }

    public final void R() {
        V v2;
        b.a aVar;
        WeakReference<V> weakReference = this.E;
        if (weakReference != null && (v2 = weakReference.get()) != null) {
            m.O(v2, 524288);
            m.O(v2, 262144);
            m.O(v2, 1048576);
            if (this.u && this.x != 5) {
                B(v2, b.a.j, 5);
            }
            int i2 = this.x;
            int i3 = 6;
            if (i2 == 3) {
                if (this.f4473b) {
                    i3 = 4;
                }
                aVar = b.a.i;
            } else if (i2 == 4) {
                if (this.f4473b) {
                    i3 = 3;
                }
                aVar = b.a.h;
            } else if (i2 == 6) {
                B(v2, b.a.i, 4);
                B(v2, b.a.h, 3);
                return;
            } else {
                return;
            }
            B(v2, aVar, i3);
        }
    }

    public final void S(int i2) {
        ValueAnimator valueAnimator;
        if (i2 != 2) {
            boolean z2 = i2 == 3;
            if (this.l != z2) {
                this.l = z2;
                if (this.i != null && (valueAnimator = this.n) != null) {
                    if (valueAnimator.isRunning()) {
                        this.n.reverse();
                        return;
                    }
                    float f2 = z2 ? 0.0f : 1.0f;
                    this.n.setFloatValues(1.0f - f2, f2);
                    this.n.start();
                }
            }
        }
    }

    public final void T(boolean z2) {
        Map<View, Integer> map;
        int intValue;
        WeakReference<V> weakReference = this.E;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z2) {
                    if (this.L == null) {
                        this.L = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.E.get()) {
                        if (z2) {
                            this.L.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            if (this.f4474c) {
                                intValue = 4;
                            }
                        } else if (this.f4474c && (map = this.L) != null && map.containsKey(childAt)) {
                            intValue = this.L.get(childAt).intValue();
                        }
                        m.a0(childAt, intValue);
                    }
                }
                if (!z2) {
                    this.L = null;
                }
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void f(CoordinatorLayout.f fVar) {
        this.E = null;
        this.y = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void i() {
        this.E = null;
        this.y = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        b.k.b.e eVar;
        if (!v2.isShown() || !this.w) {
            this.z = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        View view = null;
        if (actionMasked == 0) {
            this.I = -1;
            VelocityTracker velocityTracker = this.H;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.H = null;
            }
        }
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.J = (int) motionEvent.getY();
            if (this.x != 2) {
                WeakReference<View> weakReference = this.F;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.l(view2, x2, this.J)) {
                    this.I = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.K = true;
                }
            }
            this.z = this.I == -1 && !coordinatorLayout.l(v2, x2, this.J);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.K = false;
            this.I = -1;
            if (this.z) {
                this.z = false;
                return false;
            }
        }
        if (!this.z && (eVar = this.y) != null && eVar.u(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.F;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        return actionMasked == 2 && view != null && !this.z && this.x != 1 && !coordinatorLayout.l(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.y != null && Math.abs(((float) this.J) - motionEvent.getY()) > ((float) this.y.f1240b);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        int i3;
        g gVar;
        WindowInsets rootWindowInsets;
        if (m.l(coordinatorLayout) && !v2.getFitsSystemWindows()) {
            v2.setFitsSystemWindows(true);
        }
        if (this.E == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(c.b.a.b.d.design_bottom_sheet_peek_height_min);
            if (Build.VERSION.SDK_INT >= 29 && !this.j && (rootWindowInsets = coordinatorLayout.getRootWindowInsets()) != null) {
                this.f4476e += rootWindowInsets.getSystemGestureInsets().bottom;
            }
            this.E = new WeakReference<>(v2);
            if (this.h && (gVar = this.i) != null) {
                v2.setBackground(gVar);
            }
            g gVar2 = this.i;
            if (gVar2 != null) {
                float f2 = this.t;
                if (f2 == -1.0f) {
                    f2 = v2.getElevation();
                }
                gVar2.q(f2);
                boolean z2 = this.x == 3;
                this.l = z2;
                this.i.s(z2 ? 0.0f : 1.0f);
            }
            R();
            if (v2.getImportantForAccessibility() == 0) {
                v2.setImportantForAccessibility(1);
            }
        }
        if (this.y == null) {
            this.y = new b.k.b.e(coordinatorLayout.getContext(), coordinatorLayout, this.M);
        }
        int top = v2.getTop();
        coordinatorLayout.q(v2, i2);
        this.C = coordinatorLayout.getWidth();
        int height = coordinatorLayout.getHeight();
        this.D = height;
        this.p = Math.max(0, height - v2.getHeight());
        this.q = (int) ((1.0f - this.r) * ((float) this.D));
        C();
        int i4 = this.x;
        if (i4 == 3) {
            i3 = I();
        } else if (i4 == 6) {
            i3 = this.q;
        } else if (!this.u || i4 != 5) {
            int i5 = this.x;
            if (i5 == 4) {
                i3 = this.s;
            } else {
                if (i5 == 1 || i5 == 2) {
                    v2.offsetTopAndBottom(top - v2.getTop());
                }
                this.F = new WeakReference<>(G(v2));
                return true;
            }
        } else {
            i3 = this.D;
        }
        v2.offsetTopAndBottom(i3);
        this.F = new WeakReference<>(G(v2));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.F;
        return (weakReference == null || view != weakReference.get() || this.x == 3) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        int i5;
        if (i4 != 1) {
            WeakReference<View> weakReference = this.F;
            if (view == (weakReference != null ? weakReference.get() : null)) {
                int top = v2.getTop();
                int i6 = top - i3;
                if (i3 <= 0) {
                    if (i3 < 0 && !view.canScrollVertically(-1)) {
                        int i7 = this.s;
                        if (i6 > i7 && !this.u) {
                            iArr[1] = top - i7;
                            m.H(v2, -iArr[1]);
                            i5 = 4;
                        } else if (this.w) {
                            iArr[1] = i3;
                            m.H(v2, -i3);
                            M(1);
                        } else {
                            return;
                        }
                    }
                    F(v2.getTop());
                    this.A = i3;
                    this.B = true;
                } else if (i6 < I()) {
                    iArr[1] = top - I();
                    m.H(v2, -iArr[1]);
                    i5 = 3;
                } else if (this.w) {
                    iArr[1] = i3;
                    m.H(v2, -i3);
                    M(1);
                    F(v2.getTop());
                    this.A = i3;
                    this.B = true;
                } else {
                    return;
                }
                M(i5);
                F(v2.getTop());
                this.A = i3;
                this.B = true;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        e eVar = (e) parcelable;
        int i2 = this.f4472a;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.f4476e = eVar.f4484e;
            }
            int i3 = this.f4472a;
            if (i3 == -1 || (i3 & 2) == 2) {
                this.f4473b = eVar.f;
            }
            int i4 = this.f4472a;
            if (i4 == -1 || (i4 & 4) == 4) {
                this.u = eVar.g;
            }
            int i5 = this.f4472a;
            if (i5 == -1 || (i5 & 8) == 8) {
                this.v = eVar.h;
            }
        }
        int i6 = eVar.f4483d;
        if (i6 == 1 || i6 == 2) {
            this.x = 4;
        } else {
            this.x = i6;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable v(CoordinatorLayout coordinatorLayout, V v2) {
        return new e((Parcelable) View.BaseSavedState.EMPTY_STATE, (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean x(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.A = 0;
        this.B = false;
        return (i2 & 2) != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r4 > r6) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0072, code lost:
        if (java.lang.Math.abs(r4 - r3.p) < java.lang.Math.abs(r4 - r3.s)) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0083, code lost:
        if (r4 < java.lang.Math.abs(r4 - r3.s)) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
        r4 = r3.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0095, code lost:
        if (java.lang.Math.abs(r4 - r1) < java.lang.Math.abs(r4 - r3.s)) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b0, code lost:
        if (java.lang.Math.abs(r4 - r3.q) < java.lang.Math.abs(r4 - r3.s)) goto L_0x00b2;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void z(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        int i4;
        float f2;
        int i5 = 3;
        if (v2.getTop() == I()) {
            M(3);
            return;
        }
        WeakReference<View> weakReference = this.F;
        if (weakReference != null && view == weakReference.get() && this.B) {
            if (this.A <= 0) {
                if (this.u) {
                    VelocityTracker velocityTracker = this.H;
                    if (velocityTracker == null) {
                        f2 = 0.0f;
                    } else {
                        velocityTracker.computeCurrentVelocity(1000, this.f4475d);
                        f2 = this.H.getYVelocity(this.I);
                    }
                    if (P(v2, f2)) {
                        i3 = this.D;
                        i5 = 5;
                        Q(v2, i5, i3, false);
                        this.B = false;
                    }
                }
                if (this.A == 0) {
                    int top = v2.getTop();
                    if (!this.f4473b) {
                        int i6 = this.q;
                        if (top < i6) {
                        }
                    }
                    i3 = this.s;
                    i5 = 4;
                    Q(v2, i5, i3, false);
                    this.B = false;
                }
                if (!this.f4473b) {
                    int top2 = v2.getTop();
                }
                i3 = this.s;
                i5 = 4;
                Q(v2, i5, i3, false);
                this.B = false;
                i4 = this.q;
                i3 = i4;
                i5 = 6;
                Q(v2, i5, i3, false);
                this.B = false;
            } else if (!this.f4473b) {
                int top3 = v2.getTop();
                i4 = this.q;
            }
            i3 = this.p;
            Q(v2, i5, i3, false);
            this.B = false;
        }
    }
}
