package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.a.m;
import e.i.i.c0.b;
import e.i.i.v;
import e.k.b.e;
import f.b.a.e.q.n;
import f.b.a.e.q.p;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public static final int Y = R$style.Widget_Design_BottomSheet_Modal;
    public float A = 0.5f;
    public int B;
    public float C = -1.0f;
    public boolean D;
    public boolean E;
    public boolean F = true;
    public int G = 4;
    public e.k.b.e H;
    public boolean I;
    public int J;
    public boolean K;
    public int L;
    public int M;
    public int N;
    public WeakReference<V> O;
    public WeakReference<View> P;
    public final ArrayList<c> Q = new ArrayList<>();
    public VelocityTracker R;
    public int S;
    public int T;
    public boolean U;
    public Map<View, Integer> V;
    public int W = -1;
    public final e.c X = new b();
    public int a = 0;
    public boolean b = true;
    public float c;

    /* renamed from: d  reason: collision with root package name */
    public int f508d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f509e;

    /* renamed from: f  reason: collision with root package name */
    public int f510f;

    /* renamed from: g  reason: collision with root package name */
    public int f511g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f512h;

    /* renamed from: i  reason: collision with root package name */
    public g f513i;

    /* renamed from: j  reason: collision with root package name */
    public int f514j = -1;

    /* renamed from: k  reason: collision with root package name */
    public int f515k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f516l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public j t;
    public boolean u;
    public BottomSheetBehavior<V>.e v = null;
    public ValueAnimator w;
    public int x;
    public int y;
    public int z;

    public class a implements Runnable {
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public a(View view, int i2) {
            this.b = view;
            this.c = i2;
        }

        public void run() {
            BottomSheetBehavior.this.M(this.b, this.c);
        }
    }

    public class b extends e.c {
        public long a;

        public b() {
        }

        @Override // e.k.b.e.c
        public int a(View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // e.k.b.e.c
        public int b(View view, int i2, int i3) {
            int H = BottomSheetBehavior.this.H();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return m.e.v(i2, H, bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B);
        }

        @Override // e.k.b.e.c
        public int d(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B;
        }

        @Override // e.k.b.e.c
        public void f(int i2) {
            if (i2 == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.F) {
                    bottomSheetBehavior.L(1);
                }
            }
        }

        @Override // e.k.b.e.c
        public void g(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.E(i3);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
            if (java.lang.Math.abs(r8.getTop() - r7.b.H()) < java.lang.Math.abs(r8.getTop() - r7.b.z)) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c7, code lost:
            if (java.lang.Math.abs(r9 - r7.b.z) < java.lang.Math.abs(r9 - r7.b.B)) goto L_0x00c9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0104, code lost:
            if (r9 < java.lang.Math.abs(r9 - r10.B)) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0116, code lost:
            if (java.lang.Math.abs(r9 - r1) < java.lang.Math.abs(r9 - r7.b.B)) goto L_0x00c9;
         */
        @Override // e.k.b.e.c
        public void h(View view, float f2, float f3) {
            int i2;
            BottomSheetBehavior bottomSheetBehavior;
            BottomSheetBehavior bottomSheetBehavior2;
            int i3 = 4;
            if (f3 < 0.0f) {
                bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.b) {
                    int top = view.getTop();
                    System.currentTimeMillis();
                    Objects.requireNonNull(BottomSheetBehavior.this);
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    int i4 = bottomSheetBehavior3.z;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                        BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                        Objects.requireNonNull(bottomSheetBehavior4);
                        bottomSheetBehavior4.P(view, i3, i2, true);
                    }
                    i2 = bottomSheetBehavior3.H();
                    i3 = 3;
                    BottomSheetBehavior bottomSheetBehavior42 = BottomSheetBehavior.this;
                    Objects.requireNonNull(bottomSheetBehavior42);
                    bottomSheetBehavior42.P(view, i3, i2, true);
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                if (!bottomSheetBehavior5.D || !bottomSheetBehavior5.O(view, f3)) {
                    if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                        if (!bottomSheetBehavior6.b) {
                            int i5 = bottomSheetBehavior6.z;
                            if (top2 < i5) {
                            }
                            Objects.requireNonNull(BottomSheetBehavior.this);
                            i2 = BottomSheetBehavior.this.z;
                            i3 = 6;
                            BottomSheetBehavior bottomSheetBehavior422 = BottomSheetBehavior.this;
                            Objects.requireNonNull(bottomSheetBehavior422);
                            bottomSheetBehavior422.P(view, i3, i2, true);
                        } else if (Math.abs(top2 - bottomSheetBehavior6.y) < Math.abs(top2 - BottomSheetBehavior.this.B)) {
                            bottomSheetBehavior = BottomSheetBehavior.this;
                        }
                        bottomSheetBehavior2 = BottomSheetBehavior.this;
                    } else {
                        bottomSheetBehavior2 = BottomSheetBehavior.this;
                        if (!bottomSheetBehavior2.b) {
                            int top3 = view.getTop();
                        }
                    }
                    i2 = bottomSheetBehavior2.B;
                    BottomSheetBehavior bottomSheetBehavior4222 = BottomSheetBehavior.this;
                    Objects.requireNonNull(bottomSheetBehavior4222);
                    bottomSheetBehavior4222.P(view, i3, i2, true);
                }
                if (Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) {
                    int top4 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior7 = BottomSheetBehavior.this;
                    if (!(top4 > (bottomSheetBehavior7.H() + bottomSheetBehavior7.N) / 2)) {
                        bottomSheetBehavior = BottomSheetBehavior.this;
                        if (!bottomSheetBehavior.b) {
                        }
                    }
                }
                i2 = BottomSheetBehavior.this.N;
                i3 = 5;
                BottomSheetBehavior bottomSheetBehavior42222 = BottomSheetBehavior.this;
                Objects.requireNonNull(bottomSheetBehavior42222);
                bottomSheetBehavior42222.P(view, i3, i2, true);
                i2 = BottomSheetBehavior.this.H();
                i3 = 3;
                BottomSheetBehavior bottomSheetBehavior422222 = BottomSheetBehavior.this;
                Objects.requireNonNull(bottomSheetBehavior422222);
                bottomSheetBehavior422222.P(view, i3, i2, true);
            }
            i2 = bottomSheetBehavior.y;
            i3 = 3;
            BottomSheetBehavior bottomSheetBehavior4222222 = BottomSheetBehavior.this;
            Objects.requireNonNull(bottomSheetBehavior4222222);
            bottomSheetBehavior4222222.P(view, i3, i2, true);
        }

        @Override // e.k.b.e.c
        public boolean i(View view, int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.G;
            if (i3 == 1 || bottomSheetBehavior.U) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.S == i2) {
                WeakReference<View> weakReference = bottomSheetBehavior.P;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.O;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    public static abstract class c {
        public abstract void a(View view, float f2);

        public abstract void b(View view, int i2);
    }

    public static class d extends e.k.a.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public final int f518d;

        /* renamed from: e  reason: collision with root package name */
        public int f519e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f520f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f521g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f522h;

        public static class a implements Parcelable.ClassLoaderCreator<d> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new d(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new d[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f518d = parcel.readInt();
            this.f519e = parcel.readInt();
            boolean z = false;
            this.f520f = parcel.readInt() == 1;
            this.f521g = parcel.readInt() == 1;
            this.f522h = parcel.readInt() == 1 ? true : z;
        }

        public d(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f518d = bottomSheetBehavior.G;
            this.f519e = bottomSheetBehavior.f508d;
            this.f520f = bottomSheetBehavior.b;
            this.f521g = bottomSheetBehavior.D;
            this.f522h = bottomSheetBehavior.E;
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeInt(this.f518d);
            parcel.writeInt(this.f519e);
            parcel.writeInt(this.f520f ? 1 : 0);
            parcel.writeInt(this.f521g ? 1 : 0);
            parcel.writeInt(this.f522h ? 1 : 0);
        }
    }

    public class e implements Runnable {
        public final View b;
        public boolean c;

        /* renamed from: d  reason: collision with root package name */
        public int f523d;

        public e(View view, int i2) {
            this.b = view;
            this.f523d = i2;
        }

        public void run() {
            e.k.b.e eVar = BottomSheetBehavior.this.H;
            if (eVar == null || !eVar.i(true)) {
                BottomSheetBehavior.this.L(this.f523d);
            } else {
                View view = this.b;
                AtomicInteger atomicInteger = v.a;
                v.d.m(view, this);
            }
            this.c = false;
        }
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        int i3;
        this.f511g = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        this.f512h = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i4 = R$styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i4);
        if (hasValue) {
            D(context, attributeSet, hasValue, f.b.a.c.b.o.b.x0(context, obtainStyledAttributes, i4));
        } else {
            D(context, attributeSet, hasValue, null);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.w = ofFloat;
        ofFloat.setDuration(500L);
        this.w.addUpdateListener(new f.b.a.e.e.a(this));
        this.C = obtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i5 = R$styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.f514j = obtainStyledAttributes.getDimensionPixelSize(i5, -1);
        }
        int i6 = R$styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.f515k = obtainStyledAttributes.getDimensionPixelSize(i6, -1);
        }
        int i7 = R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i7);
        if (peekValue == null || (i3 = peekValue.data) != -1) {
            J(obtainStyledAttributes.getDimensionPixelSize(i7, -1));
        } else {
            J(i3);
        }
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false);
        if (this.D != z2) {
            this.D = z2;
            if (!z2 && this.G == 5) {
                K(4);
            }
            Q();
        }
        this.m = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z3 = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.b != z3) {
            this.b = z3;
            if (this.O != null) {
                B();
            }
            L((!this.b || this.G != 6) ? this.G : 3);
            Q();
        }
        this.E = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.F = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.a = obtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f2 = obtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.A = f2;
        if (this.O != null) {
            this.z = (int) ((1.0f - f2) * ((float) this.N));
        }
        int i8 = R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i8);
        if (peekValue2 == null || peekValue2.type != 16) {
            i2 = obtainStyledAttributes.getDimensionPixelOffset(i8, 0);
            if (i2 < 0) {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
        } else {
            i2 = peekValue2.data;
            if (i2 < 0) {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
        }
        this.x = i2;
        this.n = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.o = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.p = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.q = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        obtainStyledAttributes.recycle();
        this.c = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        boolean z2 = false;
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i2 = this.G;
        if (i2 == 1 && actionMasked == 0) {
            return true;
        }
        e.k.b.e eVar = this.H;
        if (eVar != null && (this.F || i2 == 1)) {
            eVar.n(motionEvent);
        }
        if (actionMasked == 0) {
            this.S = -1;
            VelocityTracker velocityTracker = this.R;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.R = null;
            }
        }
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        if (this.H != null && (this.F || this.G == 1)) {
            z2 = true;
        }
        if (z2 && actionMasked == 2 && !this.I) {
            float abs = Math.abs(((float) this.T) - motionEvent.getY());
            e.k.b.e eVar2 = this.H;
            if (abs > ((float) eVar2.b)) {
                eVar2.b(v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.I;
    }

    public final void B() {
        int C2 = C();
        if (this.b) {
            this.B = Math.max(this.N - C2, this.y);
        } else {
            this.B = this.N - C2;
        }
    }

    public final int C() {
        int i2;
        return this.f509e ? Math.min(Math.max(this.f510f, this.N - ((this.M * 9) / 16)), this.L) + this.r : (this.m || this.n || (i2 = this.f516l) <= 0) ? this.f508d + this.r : Math.max(this.f508d, i2 + this.f511g);
    }

    public final void D(Context context, AttributeSet attributeSet, boolean z2, ColorStateList colorStateList) {
        if (this.f512h) {
            this.t = j.b(context, attributeSet, R$attr.bottomSheetStyle, Y).a();
            g gVar = new g(this.t);
            this.f513i = gVar;
            gVar.b.b = new f.b.a.e.n.a(context);
            gVar.y();
            if (!z2 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f513i.setTint(typedValue.data);
                return;
            }
            this.f513i.q(colorStateList);
        }
    }

    public void E(int i2) {
        float f2;
        float f3;
        V v2 = this.O.get();
        if (!(v2 == null || this.Q.isEmpty())) {
            int i3 = this.B;
            if (i2 > i3 || i3 == H()) {
                int i4 = this.B;
                f2 = (float) (i4 - i2);
                f3 = (float) (this.N - i4);
            } else {
                int i5 = this.B;
                f2 = (float) (i5 - i2);
                f3 = (float) (i5 - H());
            }
            float f4 = f2 / f3;
            for (int i6 = 0; i6 < this.Q.size(); i6++) {
                this.Q.get(i6).a(v2, f4);
            }
        }
    }

    public View F(View view) {
        AtomicInteger atomicInteger = v.a;
        if (v.i.p(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View F2 = F(viewGroup.getChildAt(i2));
            if (F2 != null) {
                return F2;
            }
        }
        return null;
    }

    public final int G(int i2, int i3, int i4, int i5) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, i3, i5);
        if (i4 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i4), 1073741824);
        }
        if (size != 0) {
            i4 = Math.min(size, i4);
        }
        return View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
    }

    public int H() {
        if (this.b) {
            return this.y;
        }
        return Math.max(this.x, this.q ? 0 : this.s);
    }

    public final void I(V v2, b.a aVar, int i2) {
        v.s(v2, aVar, null, new f.b.a.e.e.c(this, i2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    public void J(int i2) {
        boolean z2 = true;
        if (i2 == -1) {
            if (!this.f509e) {
                this.f509e = true;
                if (z2) {
                    T(false);
                    return;
                }
                return;
            }
        } else if (this.f509e || this.f508d != i2) {
            this.f509e = false;
            this.f508d = Math.max(0, i2);
            if (z2) {
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    public void K(int i2) {
        if (i2 != this.G) {
            if (this.O != null) {
                N(i2);
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.D && i2 == 5)) {
                this.G = i2;
            }
        }
    }

    public void L(int i2) {
        V v2;
        if (this.G != i2) {
            this.G = i2;
            if (!(i2 == 4 || i2 == 3 || i2 == 6)) {
                boolean z2 = this.D;
            }
            WeakReference<V> weakReference = this.O;
            if (!(weakReference == null || (v2 = weakReference.get()) == null)) {
                if (i2 == 3) {
                    S(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    S(false);
                }
                R(i2);
                for (int i3 = 0; i3 < this.Q.size(); i3++) {
                    this.Q.get(i3).b(v2, i2);
                }
                Q();
            }
        }
    }

    public void M(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.B;
        } else if (i2 == 6) {
            i3 = this.z;
            if (this.b && i3 <= (i4 = this.y)) {
                i2 = 3;
                i3 = i4;
            }
        } else if (i2 == 3) {
            i3 = H();
        } else if (!this.D || i2 != 5) {
            throw new IllegalArgumentException(f.a.a.a.a.t("Illegal state argument: ", i2));
        } else {
            i3 = this.N;
        }
        P(view, i2, i3, false);
    }

    public final void N(int i2) {
        V v2 = this.O.get();
        if (v2 != null) {
            ViewParent parent = v2.getParent();
            if (parent != null && parent.isLayoutRequested()) {
                AtomicInteger atomicInteger = v.a;
                if (v.g.b(v2)) {
                    v2.post(new a(v2, i2));
                    return;
                }
            }
            M(v2, i2);
        }
    }

    public boolean O(View view, float f2) {
        if (this.E) {
            return true;
        }
        if (view.getTop() < this.B) {
            return false;
        }
        return Math.abs(((f2 * 0.1f) + ((float) view.getTop())) - ((float) this.B)) / ((float) C()) > 0.5f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r7 != false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (r0.t(r5.getLeft(), r7) != false) goto L_0x002f;
     */
    public void P(View view, int i2, int i3, boolean z2) {
        e.k.b.e eVar = this.H;
        boolean z3 = false;
        if (eVar != null) {
            if (!z2) {
                int left = view.getLeft();
                eVar.r = view;
                eVar.c = -1;
                boolean l2 = eVar.l(left, i3, 0, 0);
                if (!l2 && eVar.a == 0 && eVar.r != null) {
                    eVar.r = null;
                }
            }
            z3 = true;
        }
        if (z3) {
            L(2);
            R(i2);
            if (this.v == null) {
                this.v = new e(view, i2);
            }
            BottomSheetBehavior<V>.e eVar2 = this.v;
            boolean z4 = eVar2.c;
            eVar2.f523d = i2;
            if (!z4) {
                AtomicInteger atomicInteger = v.a;
                v.d.m(view, eVar2);
                this.v.c = true;
                return;
            }
            return;
        }
        L(i2);
    }

    public final void Q() {
        V v2;
        b.a aVar;
        int i2;
        WeakReference<V> weakReference = this.O;
        if (!(weakReference == null || (v2 = weakReference.get()) == null)) {
            v.r(524288, v2);
            v.m(v2, 0);
            v.r(262144, v2);
            v.m(v2, 0);
            v.r(1048576, v2);
            v.m(v2, 0);
            int i3 = this.W;
            if (i3 != -1) {
                v.r(i3, v2);
                v.m(v2, 0);
            }
            int i4 = 6;
            if (!this.b && this.G != 6) {
                String string = v2.getResources().getString(R$string.bottomsheet_action_expand_halfway);
                f.b.a.e.e.c cVar = new f.b.a.e.e.c(this, 6);
                List<b.a> j2 = v.j(v2);
                int i5 = 0;
                while (true) {
                    if (i5 >= j2.size()) {
                        int i6 = -1;
                        int i7 = 0;
                        while (true) {
                            int[] iArr = v.f1558f;
                            if (i7 >= iArr.length || i6 != -1) {
                                i2 = i6;
                            } else {
                                int i8 = iArr[i7];
                                boolean z2 = true;
                                for (int i9 = 0; i9 < j2.size(); i9++) {
                                    z2 &= j2.get(i9).a() != i8;
                                }
                                if (z2) {
                                    i6 = i8;
                                }
                                i7++;
                            }
                        }
                        i2 = i6;
                    } else if (TextUtils.equals(string, j2.get(i5).b())) {
                        i2 = j2.get(i5).a();
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i2 != -1) {
                    v.a(v2, new b.a(null, i2, string, cVar, null));
                }
                this.W = i2;
            }
            if (this.D && this.G != 5) {
                I(v2, b.a.f1544j, 5);
            }
            int i10 = this.G;
            if (i10 == 3) {
                if (this.b) {
                    i4 = 4;
                }
                aVar = b.a.f1543i;
            } else if (i10 == 4) {
                if (this.b) {
                    i4 = 3;
                }
                aVar = b.a.f1542h;
            } else if (i10 == 6) {
                I(v2, b.a.f1543i, 4);
                I(v2, b.a.f1542h, 3);
                return;
            } else {
                return;
            }
            I(v2, aVar, i4);
        }
    }

    public final void R(int i2) {
        ValueAnimator valueAnimator;
        if (i2 != 2) {
            boolean z2 = i2 == 3;
            if (this.u != z2) {
                this.u = z2;
                if (this.f513i != null && (valueAnimator = this.w) != null) {
                    if (valueAnimator.isRunning()) {
                        this.w.reverse();
                        return;
                    }
                    float f2 = z2 ? 0.0f : 1.0f;
                    this.w.setFloatValues(1.0f - f2, f2);
                    this.w.start();
                }
            }
        }
    }

    public final void S(boolean z2) {
        WeakReference<V> weakReference = this.O;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z2) {
                    if (this.V == null) {
                        this.V = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.O.get() && z2) {
                        this.V.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    }
                }
                if (!z2) {
                    this.V = null;
                }
            }
        }
    }

    public final void T(boolean z2) {
        V v2;
        if (this.O != null) {
            B();
            if (this.G == 4 && (v2 = this.O.get()) != null) {
                if (z2) {
                    N(this.G);
                } else {
                    v2.requestLayout();
                }
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void f(CoordinatorLayout.f fVar) {
        this.O = null;
        this.H = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void i() {
        this.O = null;
        this.H = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        e.k.b.e eVar;
        if (!v2.isShown() || !this.F) {
            this.I = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        View view = null;
        if (actionMasked == 0) {
            this.S = -1;
            VelocityTracker velocityTracker = this.R;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.R = null;
            }
        }
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.T = (int) motionEvent.getY();
            if (this.G != 2) {
                WeakReference<View> weakReference = this.P;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.p(view2, x2, this.T)) {
                    this.S = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.U = true;
                }
            }
            this.I = this.S == -1 && !coordinatorLayout.p(v2, x2, this.T);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.U = false;
            this.S = -1;
            if (this.I) {
                this.I = false;
                return false;
            }
        }
        if (!this.I && (eVar = this.H) != null && eVar.u(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.P;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        if (actionMasked != 2 || view == null || this.I || this.G == 1 || coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.H == null || Math.abs(((float) this.T) - motionEvent.getY()) <= ((float) this.H.b)) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        int i3;
        g gVar;
        AtomicInteger atomicInteger = v.a;
        if (v.d.b(coordinatorLayout) && !v.d.b(v2)) {
            v2.setFitsSystemWindows(true);
        }
        if (this.O == null) {
            this.f510f = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            boolean z2 = Build.VERSION.SDK_INT >= 29 && !this.m && !this.f509e;
            if (this.n || this.o || this.p || z2) {
                v.i.u(v2, new f.b.a.e.q.m(new f.b.a.e.e.b(this, z2), new p(v.e.f(v2), v2.getPaddingTop(), v.e.e(v2), v2.getPaddingBottom())));
                if (v.g.b(v2)) {
                    v.h.c(v2);
                } else {
                    v2.addOnAttachStateChangeListener(new n());
                }
            }
            this.O = new WeakReference<>(v2);
            if (this.f512h && (gVar = this.f513i) != null) {
                v.d.q(v2, gVar);
            }
            g gVar2 = this.f513i;
            if (gVar2 != null) {
                float f2 = this.C;
                if (f2 == -1.0f) {
                    f2 = v.i.i(v2);
                }
                gVar2.p(f2);
                boolean z3 = this.G == 3;
                this.u = z3;
                this.f513i.r(z3 ? 0.0f : 1.0f);
            }
            Q();
            if (v.d.c(v2) == 0) {
                v.d.s(v2, 1);
            }
        }
        if (this.H == null) {
            this.H = new e.k.b.e(coordinatorLayout.getContext(), coordinatorLayout, this.X);
        }
        int top = v2.getTop();
        coordinatorLayout.r(v2, i2);
        this.M = coordinatorLayout.getWidth();
        this.N = coordinatorLayout.getHeight();
        int height = v2.getHeight();
        this.L = height;
        int i4 = this.N;
        int i5 = i4 - height;
        int i6 = this.s;
        if (i5 < i6) {
            if (this.q) {
                this.L = i4;
            } else {
                this.L = i4 - i6;
            }
        }
        this.y = Math.max(0, i4 - this.L);
        this.z = (int) ((1.0f - this.A) * ((float) this.N));
        B();
        int i7 = this.G;
        if (i7 == 3) {
            i3 = H();
        } else if (i7 == 6) {
            i3 = this.z;
        } else if (this.D && i7 == 5) {
            i3 = this.N;
        } else if (i7 == 4) {
            i3 = this.B;
        } else {
            if (i7 == 1 || i7 == 2) {
                v.o(v2, top - v2.getTop());
            }
            this.P = new WeakReference<>(F(v2));
            return true;
        }
        v.o(v2, i3);
        this.P = new WeakReference<>(F(v2));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v2.getLayoutParams();
        v2.measure(G(i2, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, this.f514j, marginLayoutParams.width), G(i4, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, this.f515k, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.P;
        return (weakReference == null || view != weakReference.get() || this.G == 3) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        int i5;
        if (i4 != 1) {
            WeakReference<View> weakReference = this.P;
            if (view == (weakReference != null ? weakReference.get() : null)) {
                int top = v2.getTop();
                int i6 = top - i3;
                if (i3 <= 0) {
                    if (i3 < 0 && !view.canScrollVertically(-1)) {
                        int i7 = this.B;
                        if (i6 > i7 && !this.D) {
                            iArr[1] = top - i7;
                            v.o(v2, -iArr[1]);
                            i5 = 4;
                        } else if (this.F) {
                            iArr[1] = i3;
                            v.o(v2, -i3);
                            L(1);
                        } else {
                            return;
                        }
                    }
                    E(v2.getTop());
                    this.J = i3;
                    this.K = true;
                } else if (i6 < H()) {
                    iArr[1] = top - H();
                    v.o(v2, -iArr[1]);
                    i5 = 3;
                } else if (this.F) {
                    iArr[1] = i3;
                    v.o(v2, -i3);
                    L(1);
                    E(v2.getTop());
                    this.J = i3;
                    this.K = true;
                } else {
                    return;
                }
                L(i5);
                E(v2.getTop());
                this.J = i3;
                this.K = true;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        d dVar = (d) parcelable;
        int i2 = this.a;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.f508d = dVar.f519e;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.b = dVar.f520f;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.D = dVar.f521g;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.E = dVar.f522h;
            }
        }
        int i3 = dVar.f518d;
        if (i3 == 1 || i3 == 2) {
            this.G = 4;
        } else {
            this.G = i3;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable v(CoordinatorLayout coordinatorLayout, V v2) {
        return new d((Parcelable) View.BaseSavedState.EMPTY_STATE, (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean x(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.J = 0;
        this.K = false;
        return (i2 & 2) != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r2 > r4) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        if (java.lang.Math.abs(r2 - r1.y) < java.lang.Math.abs(r2 - r1.B)) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0081, code lost:
        if (r2 < java.lang.Math.abs(r2 - r1.B)) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0083, code lost:
        r2 = H();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0095, code lost:
        if (java.lang.Math.abs(r2 - r4) < java.lang.Math.abs(r2 - r1.B)) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b0, code lost:
        if (java.lang.Math.abs(r2 - r1.z) < java.lang.Math.abs(r2 - r1.B)) goto L_0x00b2;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void z(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        int i4;
        float f2;
        int i5 = 3;
        if (v2.getTop() == H()) {
            L(3);
            return;
        }
        WeakReference<View> weakReference = this.P;
        if (weakReference != null && view == weakReference.get() && this.K) {
            if (this.J <= 0) {
                if (this.D) {
                    VelocityTracker velocityTracker = this.R;
                    if (velocityTracker == null) {
                        f2 = 0.0f;
                    } else {
                        velocityTracker.computeCurrentVelocity(1000, this.c);
                        f2 = this.R.getYVelocity(this.S);
                    }
                    if (O(v2, f2)) {
                        i3 = this.N;
                        i5 = 5;
                        P(v2, i5, i3, false);
                        this.K = false;
                    }
                }
                if (this.J == 0) {
                    int top = v2.getTop();
                    if (!this.b) {
                        int i6 = this.z;
                        if (top < i6) {
                        }
                    }
                    i3 = this.B;
                    i5 = 4;
                    P(v2, i5, i3, false);
                    this.K = false;
                }
                if (!this.b) {
                    int top2 = v2.getTop();
                }
                i3 = this.B;
                i5 = 4;
                P(v2, i5, i3, false);
                this.K = false;
                i4 = this.z;
                i5 = 6;
                i3 = i4;
                P(v2, i5, i3, false);
                this.K = false;
            } else if (!this.b) {
                int top3 = v2.getTop();
                i4 = this.z;
            }
            i3 = this.y;
            P(v2, i5, i3, false);
            this.K = false;
        }
    }
}
