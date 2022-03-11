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
import e.j.j.c0.b;
import e.j.j.v;
import e.l.b.e;
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
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public static final int Y = R$style.Widget_Design_BottomSheet_Modal;
    public float A;
    public int B;
    public float C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public e.l.b.e H;
    public boolean I;
    public int J;
    public boolean K;
    public int L;
    public int M;
    public int N;
    public WeakReference<V> O;
    public WeakReference<View> P;
    public final ArrayList<c> Q;
    public VelocityTracker R;
    public int S;
    public int T;
    public boolean U;
    public Map<View, Integer> V;
    public int W;
    public final e.c X;
    public int a;
    public boolean b;
    public float c;

    /* renamed from: d */
    public int f520d;

    /* renamed from: e */
    public boolean f521e;

    /* renamed from: f */
    public int f522f;

    /* renamed from: g */
    public int f523g;

    /* renamed from: h */
    public boolean f524h;

    /* renamed from: i */
    public g f525i;

    /* renamed from: j */
    public int f526j;

    /* renamed from: k */
    public int f527k;

    /* renamed from: l */
    public int f528l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public j t;
    public boolean u;
    public BottomSheetBehavior<V>.e v;
    public ValueAnimator w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public a(View view, int i2) {
            BottomSheetBehavior.this = r1;
            this.b = view;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.M(this.b, this.c);
        }
    }

    /* loaded from: classes.dex */
    public class b extends e.c {
        public long a;

        public b() {
            BottomSheetBehavior.this = r1;
        }

        @Override // e.l.b.e.c
        public int a(View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // e.l.b.e.c
        public int b(View view, int i2, int i3) {
            int H = BottomSheetBehavior.this.H();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return m.e.v(i2, H, bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B);
        }

        @Override // e.l.b.e.c
        public int d(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B;
        }

        @Override // e.l.b.e.c
        public void f(int i2) {
            if (i2 == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.F) {
                    bottomSheetBehavior.L(1);
                }
            }
        }

        @Override // e.l.b.e.c
        public void g(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.E(i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x008c, code lost:
            if (java.lang.Math.abs(r8.getTop() - com.google.android.material.bottomsheet.BottomSheetBehavior.this.H()) < java.lang.Math.abs(r8.getTop() - com.google.android.material.bottomsheet.BottomSheetBehavior.this.z)) goto L_0x008e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
            r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this.H();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00c7, code lost:
            if (java.lang.Math.abs(r9 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.z) < java.lang.Math.abs(r9 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.B)) goto L_0x00c9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0104, code lost:
            if (r9 < java.lang.Math.abs(r9 - r10.B)) goto L_0x008e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0116, code lost:
            if (java.lang.Math.abs(r9 - r1) < java.lang.Math.abs(r9 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.B)) goto L_0x00c9;
         */
        @Override // e.l.b.e.c
        /* Code decompiled incorrectly, please refer to instructions dump */
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
                    } else {
                        i2 = bottomSheetBehavior3.H();
                        i3 = 3;
                    }
                }
                i2 = bottomSheetBehavior.y;
                i3 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                if (bottomSheetBehavior4.D && bottomSheetBehavior4.O(view, f3)) {
                    if (Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                        if (!(top2 > (bottomSheetBehavior5.H() + bottomSheetBehavior5.N) / 2)) {
                            bottomSheetBehavior = BottomSheetBehavior.this;
                            if (!bottomSheetBehavior.b) {
                            }
                            i2 = bottomSheetBehavior.y;
                            i3 = 3;
                        }
                    }
                    i2 = BottomSheetBehavior.this.N;
                    i3 = 5;
                } else if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                    int top3 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior6.b) {
                        int i5 = bottomSheetBehavior6.z;
                        if (top3 < i5) {
                        }
                        Objects.requireNonNull(BottomSheetBehavior.this);
                        i2 = BottomSheetBehavior.this.z;
                        i3 = 6;
                    } else if (Math.abs(top3 - bottomSheetBehavior6.y) < Math.abs(top3 - BottomSheetBehavior.this.B)) {
                        bottomSheetBehavior = BottomSheetBehavior.this;
                        i2 = bottomSheetBehavior.y;
                        i3 = 3;
                    }
                    bottomSheetBehavior2 = BottomSheetBehavior.this;
                    i2 = bottomSheetBehavior2.B;
                } else {
                    bottomSheetBehavior2 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior2.b) {
                        int top4 = view.getTop();
                    }
                    i2 = bottomSheetBehavior2.B;
                }
            }
            BottomSheetBehavior bottomSheetBehavior7 = BottomSheetBehavior.this;
            Objects.requireNonNull(bottomSheetBehavior7);
            bottomSheetBehavior7.P(view, i3, i2, true);
        }

        @Override // e.l.b.e.c
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

    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract void a(View view, float f2);

        public abstract void b(View view, int i2);
    }

    /* loaded from: classes.dex */
    public static class d extends e.l.a.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: d */
        public final int f530d;

        /* renamed from: e */
        public int f531e;

        /* renamed from: f */
        public boolean f532f;

        /* renamed from: g */
        public boolean f533g;

        /* renamed from: h */
        public boolean f534h;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<d> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new d(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new d[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f530d = parcel.readInt();
            this.f531e = parcel.readInt();
            boolean z = false;
            this.f532f = parcel.readInt() == 1;
            this.f533g = parcel.readInt() == 1;
            this.f534h = parcel.readInt() == 1 ? true : z;
        }

        public d(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f530d = bottomSheetBehavior.G;
            this.f531e = bottomSheetBehavior.f520d;
            this.f532f = bottomSheetBehavior.b;
            this.f533g = bottomSheetBehavior.D;
            this.f534h = bottomSheetBehavior.E;
        }

        @Override // e.l.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeInt(this.f530d);
            parcel.writeInt(this.f531e);
            parcel.writeInt(this.f532f ? 1 : 0);
            parcel.writeInt(this.f533g ? 1 : 0);
            parcel.writeInt(this.f534h ? 1 : 0);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public final View b;
        public boolean c;

        /* renamed from: d */
        public int f535d;

        public e(View view, int i2) {
            BottomSheetBehavior.this = r1;
            this.b = view;
            this.f535d = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.l.b.e eVar = BottomSheetBehavior.this.H;
            if (eVar == null || !eVar.i(true)) {
                BottomSheetBehavior.this.L(this.f535d);
            } else {
                View view = this.b;
                AtomicInteger atomicInteger = v.a;
                v.d.m(view, this);
            }
            this.c = false;
        }
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.f526j = -1;
        this.f527k = -1;
        this.v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList<>();
        this.W = -1;
        this.X = new b();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        int i3;
        this.a = 0;
        this.b = true;
        this.f526j = -1;
        this.f527k = -1;
        this.v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList<>();
        this.W = -1;
        this.X = new b();
        this.f523g = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        this.f524h = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i4 = R$styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i4);
        if (hasValue) {
            D(context, attributeSet, hasValue, f.b.a.c.b.o.b.y0(context, obtainStyledAttributes, i4));
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
            this.f526j = obtainStyledAttributes.getDimensionPixelSize(i5, -1);
        }
        int i6 = R$styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.f527k = obtainStyledAttributes.getDimensionPixelSize(i6, -1);
        }
        int i7 = R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i7);
        if (peekValue == null || (i3 = peekValue.data) != -1) {
            J(obtainStyledAttributes.getDimensionPixelSize(i7, -1));
        } else {
            J(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false);
        if (this.D != z) {
            this.D = z;
            if (!z && this.G == 5) {
                K(4);
            }
            Q();
        }
        this.m = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.b != z2) {
            this.b = z2;
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
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = false;
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i2 = this.G;
        if (i2 == 1 && actionMasked == 0) {
            return true;
        }
        e.l.b.e eVar = this.H;
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
            z = true;
        }
        if (z && actionMasked == 2 && !this.I) {
            float abs = Math.abs(((float) this.T) - motionEvent.getY());
            e.l.b.e eVar2 = this.H;
            if (abs > ((float) eVar2.b)) {
                eVar2.b(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.I;
    }

    public final void B() {
        int C = C();
        if (this.b) {
            this.B = Math.max(this.N - C, this.y);
        } else {
            this.B = this.N - C;
        }
    }

    public final int C() {
        int i2;
        return this.f521e ? Math.min(Math.max(this.f522f, this.N - ((this.M * 9) / 16)), this.L) + this.r : (this.m || this.n || (i2 = this.f528l) <= 0) ? this.f520d + this.r : Math.max(this.f520d, i2 + this.f523g);
    }

    public final void D(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.f524h) {
            this.t = j.b(context, attributeSet, R$attr.bottomSheetStyle, Y).a();
            g gVar = new g(this.t);
            this.f525i = gVar;
            gVar.b.b = new f.b.a.e.n.a(context);
            gVar.z();
            if (!z || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f525i.setTint(typedValue.data);
                return;
            }
            this.f525i.r(colorStateList);
        }
    }

    public void E(int i2) {
        float f2;
        float f3;
        V v = this.O.get();
        if (!(v == null || this.Q.isEmpty())) {
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
                this.Q.get(i6).a(v, f4);
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
            View F = F(viewGroup.getChildAt(i2));
            if (F != null) {
                return F;
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

    public final void I(V v, b.a aVar, int i2) {
        v.s(v, aVar, null, new f.b.a.e.e.c(this, i2));
    }

    public void J(int i2) {
        boolean z = true;
        if (i2 == -1) {
            if (!this.f521e) {
                this.f521e = true;
            }
            z = false;
        } else {
            if (this.f521e || this.f520d != i2) {
                this.f521e = false;
                this.f520d = Math.max(0, i2);
            }
            z = false;
        }
        if (z) {
            T(false);
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
        V v;
        if (this.G != i2) {
            this.G = i2;
            if (!(i2 == 4 || i2 == 3 || i2 == 6)) {
                boolean z = this.D;
            }
            WeakReference<V> weakReference = this.O;
            if (!(weakReference == null || (v = weakReference.get()) == null)) {
                if (i2 == 3) {
                    S(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    S(false);
                }
                R(i2);
                for (int i3 = 0; i3 < this.Q.size(); i3++) {
                    this.Q.get(i3).b(v, i2);
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
            int i5 = this.z;
            if (!this.b || i5 > (i4 = this.y)) {
                i3 = i5;
            } else {
                i3 = i4;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = H();
        } else if (this.D && i2 == 5) {
            i3 = this.N;
        } else {
            return;
        }
        P(view, i2, i3, false);
    }

    public final void N(int i2) {
        V v = this.O.get();
        if (v != null) {
            ViewParent parent = v.getParent();
            if (parent != null && parent.isLayoutRequested()) {
                AtomicInteger atomicInteger = v.a;
                if (v.g.b(v)) {
                    v.post(new a(v, i2));
                    return;
                }
            }
            M(v, i2);
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

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r7 != false) goto L_0x002f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
        if (r0.t(r5.getLeft(), r7) != false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void P(View view, int i2, int i3, boolean z) {
        e.l.b.e eVar = this.H;
        boolean z2 = false;
        if (eVar != null) {
            if (!z) {
                int left = view.getLeft();
                eVar.s = view;
                eVar.c = -1;
                boolean l2 = eVar.l(left, i3, 0, 0);
                if (!l2 && eVar.a == 0 && eVar.s != null) {
                    eVar.s = null;
                }
            }
        }
        if (z2) {
            L(2);
            R(i2);
            if (this.v == null) {
                this.v = new e(view, i2);
            }
            BottomSheetBehavior<V>.e eVar2 = this.v;
            boolean z3 = eVar2.c;
            eVar2.f535d = i2;
            if (!z3) {
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
        V v;
        b.a aVar;
        int i2;
        WeakReference<V> weakReference = this.O;
        if (!(weakReference == null || (v = weakReference.get()) == null)) {
            v.r(524288, v);
            v.m(v, 0);
            v.r(262144, v);
            v.m(v, 0);
            v.r(1048576, v);
            v.m(v, 0);
            int i3 = this.W;
            if (i3 != -1) {
                v.r(i3, v);
                v.m(v, 0);
            }
            int i4 = 6;
            if (!this.b && this.G != 6) {
                String string = v.getResources().getString(R$string.bottomsheet_action_expand_halfway);
                f.b.a.e.e.c cVar = new f.b.a.e.e.c(this, 6);
                List<b.a> j2 = v.j(v);
                int i5 = 0;
                while (true) {
                    if (i5 >= j2.size()) {
                        int i6 = -1;
                        int i7 = 0;
                        while (true) {
                            int[] iArr = v.f1643f;
                            if (i7 >= iArr.length || i6 != -1) {
                                break;
                            }
                            int i8 = iArr[i7];
                            boolean z = true;
                            for (int i9 = 0; i9 < j2.size(); i9++) {
                                z &= j2.get(i9).a() != i8;
                            }
                            if (z) {
                                i6 = i8;
                            }
                            i7++;
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
                    v.a(v, new b.a(null, i2, string, cVar, null));
                }
                this.W = i2;
            }
            if (this.D && this.G != 5) {
                I(v, b.a.f1629j, 5);
            }
            int i10 = this.G;
            if (i10 == 3) {
                if (this.b) {
                    i4 = 4;
                }
                aVar = b.a.f1628i;
            } else if (i10 == 4) {
                if (this.b) {
                    i4 = 3;
                }
                aVar = b.a.f1627h;
            } else if (i10 == 6) {
                I(v, b.a.f1628i, 4);
                I(v, b.a.f1627h, 3);
                return;
            } else {
                return;
            }
            I(v, aVar, i4);
        }
    }

    public final void R(int i2) {
        ValueAnimator valueAnimator;
        if (i2 != 2) {
            boolean z = i2 == 3;
            if (this.u != z) {
                this.u = z;
                if (this.f525i != null && (valueAnimator = this.w) != null) {
                    if (valueAnimator.isRunning()) {
                        this.w.reverse();
                        return;
                    }
                    float f2 = z ? 0.0f : 1.0f;
                    this.w.setFloatValues(1.0f - f2, f2);
                    this.w.start();
                }
            }
        }
    }

    public final void S(boolean z) {
        WeakReference<V> weakReference = this.O;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z) {
                    if (this.V == null) {
                        this.V = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.O.get() && z) {
                        this.V.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    }
                }
                if (!z) {
                    this.V = null;
                }
            }
        }
    }

    public final void T(boolean z) {
        V v;
        if (this.O != null) {
            B();
            if (this.G == 4 && (v = this.O.get()) != null) {
                if (z) {
                    N(this.G);
                } else {
                    v.requestLayout();
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
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        e.l.b.e eVar;
        if (!v.isShown() || !this.F) {
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
            int x = (int) motionEvent.getX();
            this.T = (int) motionEvent.getY();
            if (this.G != 2) {
                WeakReference<View> weakReference = this.P;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.p(view2, x, this.T)) {
                    this.S = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.U = true;
                }
            }
            this.I = this.S == -1 && !coordinatorLayout.p(v, x, this.T);
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
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i2) {
        int i3;
        g gVar;
        AtomicInteger atomicInteger = v.a;
        if (v.d.b(coordinatorLayout) && !v.d.b(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.O == null) {
            this.f522f = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            boolean z = Build.VERSION.SDK_INT >= 29 && !this.m && !this.f521e;
            if (this.n || this.o || this.p || z) {
                v.i.u(v, new f.b.a.e.q.m(new f.b.a.e.e.b(this, z), new p(v.e.f(v), v.getPaddingTop(), v.e.e(v), v.getPaddingBottom())));
                if (v.g.b(v)) {
                    v.h.c(v);
                } else {
                    v.addOnAttachStateChangeListener(new n());
                }
            }
            this.O = new WeakReference<>(v);
            if (this.f524h && (gVar = this.f525i) != null) {
                v.d.q(v, gVar);
            }
            g gVar2 = this.f525i;
            if (gVar2 != null) {
                float f2 = this.C;
                if (f2 == -1.0f) {
                    f2 = v.i.i(v);
                }
                gVar2.q(f2);
                boolean z2 = this.G == 3;
                this.u = z2;
                this.f525i.s(z2 ? 0.0f : 1.0f);
            }
            Q();
            if (v.d.c(v) == 0) {
                v.d.s(v, 1);
            }
        }
        if (this.H == null) {
            this.H = new e.l.b.e(coordinatorLayout.getContext(), coordinatorLayout, this.X);
        }
        int top = v.getTop();
        coordinatorLayout.r(v, i2);
        this.M = coordinatorLayout.getWidth();
        this.N = coordinatorLayout.getHeight();
        int height = v.getHeight();
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
                v.o(v, top - v.getTop());
            }
            this.P = new WeakReference<>(F(v));
            return true;
        }
        v.o(v, i3);
        this.P = new WeakReference<>(F(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        v.measure(G(i2, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, this.f526j, marginLayoutParams.width), G(i4, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, this.f527k, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.P;
        return (weakReference == null || view != weakReference.get() || this.G == 3) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
        int i5;
        if (i4 != 1) {
            WeakReference<View> weakReference = this.P;
            if (view == (weakReference != null ? weakReference.get() : null)) {
                int top = v.getTop();
                int i6 = top - i3;
                if (i3 > 0) {
                    if (i6 < H()) {
                        iArr[1] = top - H();
                        v.o(v, -iArr[1]);
                        i5 = 3;
                        L(i5);
                    } else if (this.F) {
                        iArr[1] = i3;
                        v.o(v, -i3);
                        L(1);
                    } else {
                        return;
                    }
                } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                    int i7 = this.B;
                    if (i6 > i7 && !this.D) {
                        iArr[1] = top - i7;
                        v.o(v, -iArr[1]);
                        i5 = 4;
                        L(i5);
                    } else if (this.F) {
                        iArr[1] = i3;
                        v.o(v, -i3);
                        L(1);
                    } else {
                        return;
                    }
                }
                E(v.getTop());
                this.J = i3;
                this.K = true;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        d dVar = (d) parcelable;
        int i2 = this.a;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.f520d = dVar.f531e;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.b = dVar.f532f;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.D = dVar.f533g;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.E = dVar.f534h;
            }
        }
        int i3 = dVar.f530d;
        if (i3 == 1 || i3 == 2) {
            this.G = 4;
        } else {
            this.G = i3;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable v(CoordinatorLayout coordinatorLayout, V v) {
        return new d((Parcelable) View.BaseSavedState.EMPTY_STATE, (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean x(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        this.J = 0;
        this.K = false;
        return (i2 & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r2 > r4) goto L_0x00b4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0070, code lost:
        if (java.lang.Math.abs(r2 - r1.y) < java.lang.Math.abs(r2 - r1.B)) goto L_0x0072;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0081, code lost:
        if (r2 < java.lang.Math.abs(r2 - r1.B)) goto L_0x0083;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
        r2 = H();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
        if (java.lang.Math.abs(r2 - r4) < java.lang.Math.abs(r2 - r1.B)) goto L_0x00b2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b0, code lost:
        if (java.lang.Math.abs(r2 - r1.z) < java.lang.Math.abs(r2 - r1.B)) goto L_0x00b2;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void z(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
        int i3;
        int i4;
        float f2;
        int i5 = 3;
        if (v.getTop() == H()) {
            L(3);
            return;
        }
        WeakReference<View> weakReference = this.P;
        if (weakReference != null && view == weakReference.get() && this.K) {
            if (this.J > 0) {
                if (!this.b) {
                    int top = v.getTop();
                    i4 = this.z;
                }
                i3 = this.y;
            } else {
                if (this.D) {
                    VelocityTracker velocityTracker = this.R;
                    if (velocityTracker == null) {
                        f2 = 0.0f;
                    } else {
                        velocityTracker.computeCurrentVelocity(1000, this.c);
                        f2 = this.R.getYVelocity(this.S);
                    }
                    if (O(v, f2)) {
                        i3 = this.N;
                        i5 = 5;
                    }
                }
                if (this.J == 0) {
                    int top2 = v.getTop();
                    if (!this.b) {
                        int i6 = this.z;
                        if (top2 < i6) {
                        }
                        i4 = this.z;
                        i5 = 6;
                        i3 = i4;
                    }
                    i3 = this.B;
                    i5 = 4;
                } else {
                    if (!this.b) {
                        int top3 = v.getTop();
                    }
                    i3 = this.B;
                    i5 = 4;
                }
            }
            P(v, i5, i3, false);
            this.K = false;
        }
    }
}
