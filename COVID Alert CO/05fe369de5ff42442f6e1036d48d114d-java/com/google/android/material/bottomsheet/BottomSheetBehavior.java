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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.b.a.m;
import e.i.i.x.b;
import e.k.b.e;
import f.b.a.e.p.n;
import f.b.a.e.p.p;
import f.b.a.e.u.g;
import f.b.a.e.u.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public static final int Q = R$style.Widget_Design_BottomSheet_Modal;
    public boolean A;
    public int B;
    public boolean C;
    public int D;
    public int E;
    public int F;
    public WeakReference<V> G;
    public WeakReference<View> H;
    public final ArrayList<c> I = new ArrayList<>();
    public VelocityTracker J;
    public int K;
    public int L;
    public boolean M;
    public Map<View, Integer> N;
    public int O = -1;
    public final e.c P = new b();
    public int a = 0;
    public boolean b = true;
    public float c;

    /* renamed from: d  reason: collision with root package name */
    public int f512d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f513e;

    /* renamed from: f  reason: collision with root package name */
    public int f514f;

    /* renamed from: g  reason: collision with root package name */
    public int f515g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f516h;

    /* renamed from: i  reason: collision with root package name */
    public g f517i;

    /* renamed from: j  reason: collision with root package name */
    public int f518j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f519k;

    /* renamed from: l  reason: collision with root package name */
    public j f520l;
    public boolean m;
    public BottomSheetBehavior<V>.e n = null;
    public ValueAnimator o;
    public int p;
    public int q;
    public int r;
    public float s = 0.5f;
    public int t;
    public float u = -1.0f;
    public boolean v;
    public boolean w;
    public boolean x = true;
    public int y = 4;
    public e.k.b.e z;

    public class a implements Runnable {
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public a(View view, int i2) {
            this.b = view;
            this.c = i2;
        }

        public void run() {
            BottomSheetBehavior.this.L(this.b, this.c);
        }
    }

    public class b extends e.c {
        public b() {
        }

        @Override // e.k.b.e.c
        public int a(View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // e.k.b.e.c
        public int b(View view, int i2, int i3) {
            int G = BottomSheetBehavior.this.G();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return m.h.s(i2, G, bottomSheetBehavior.v ? bottomSheetBehavior.F : bottomSheetBehavior.t);
        }

        @Override // e.k.b.e.c
        public int d(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.v ? bottomSheetBehavior.F : bottomSheetBehavior.t;
        }

        @Override // e.k.b.e.c
        public void f(int i2) {
            if (i2 == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.x) {
                    bottomSheetBehavior.K(1);
                }
            }
        }

        @Override // e.k.b.e.c
        public void g(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.E(i3);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
            if (java.lang.Math.abs(r8.getTop() - r7.a.p) < java.lang.Math.abs(r8.getTop() - r7.a.r)) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b8, code lost:
            if (java.lang.Math.abs(r9 - r7.a.r) < java.lang.Math.abs(r9 - r7.a.t)) goto L_0x00ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f0, code lost:
            if (r9 < java.lang.Math.abs(r9 - r10.t)) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0102, code lost:
            if (java.lang.Math.abs(r9 - r1) < java.lang.Math.abs(r9 - r7.a.t)) goto L_0x00ba;
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
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    int i4 = bottomSheetBehavior3.r;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                        BottomSheetBehavior.this.O(view, i3, i2, true);
                    }
                    i2 = bottomSheetBehavior3.p;
                    i3 = 3;
                    BottomSheetBehavior.this.O(view, i3, i2, true);
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                if (!bottomSheetBehavior4.v || !bottomSheetBehavior4.N(view, f3)) {
                    if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                        if (!bottomSheetBehavior5.b) {
                            int i5 = bottomSheetBehavior5.r;
                            if (top2 < i5) {
                            }
                            i2 = BottomSheetBehavior.this.r;
                            i3 = 6;
                            BottomSheetBehavior.this.O(view, i3, i2, true);
                        } else if (Math.abs(top2 - bottomSheetBehavior5.q) < Math.abs(top2 - BottomSheetBehavior.this.t)) {
                            bottomSheetBehavior = BottomSheetBehavior.this;
                        }
                        bottomSheetBehavior2 = BottomSheetBehavior.this;
                    } else {
                        bottomSheetBehavior2 = BottomSheetBehavior.this;
                        if (!bottomSheetBehavior2.b) {
                            int top3 = view.getTop();
                        }
                    }
                    i2 = bottomSheetBehavior2.t;
                    BottomSheetBehavior.this.O(view, i3, i2, true);
                }
                if (Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) {
                    int top4 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                    if (!(top4 > (bottomSheetBehavior6.G() + bottomSheetBehavior6.F) / 2)) {
                        bottomSheetBehavior = BottomSheetBehavior.this;
                        if (!bottomSheetBehavior.b) {
                        }
                    }
                }
                i2 = BottomSheetBehavior.this.F;
                i3 = 5;
                BottomSheetBehavior.this.O(view, i3, i2, true);
                i2 = BottomSheetBehavior.this.p;
                i3 = 3;
                BottomSheetBehavior.this.O(view, i3, i2, true);
            }
            i2 = bottomSheetBehavior.q;
            i3 = 3;
            BottomSheetBehavior.this.O(view, i3, i2, true);
        }

        @Override // e.k.b.e.c
        public boolean i(View view, int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.y;
            if (i3 == 1 || bottomSheetBehavior.M) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.K == i2) {
                WeakReference<View> weakReference = bottomSheetBehavior.H;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.G;
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
        public final int f522d;

        /* renamed from: e  reason: collision with root package name */
        public int f523e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f524f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f525g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f526h;

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
            this.f522d = parcel.readInt();
            this.f523e = parcel.readInt();
            boolean z = false;
            this.f524f = parcel.readInt() == 1;
            this.f525g = parcel.readInt() == 1;
            this.f526h = parcel.readInt() == 1 ? true : z;
        }

        public d(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f522d = bottomSheetBehavior.y;
            this.f523e = bottomSheetBehavior.f512d;
            this.f524f = bottomSheetBehavior.b;
            this.f525g = bottomSheetBehavior.v;
            this.f526h = bottomSheetBehavior.w;
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeInt(this.f522d);
            parcel.writeInt(this.f523e);
            parcel.writeInt(this.f524f ? 1 : 0);
            parcel.writeInt(this.f525g ? 1 : 0);
            parcel.writeInt(this.f526h ? 1 : 0);
        }
    }

    public class e implements Runnable {
        public final View b;
        public boolean c;

        /* renamed from: d  reason: collision with root package name */
        public int f527d;

        public e(View view, int i2) {
            this.b = view;
            this.f527d = i2;
        }

        public void run() {
            e.k.b.e eVar = BottomSheetBehavior.this.z;
            if (eVar == null || !eVar.i(true)) {
                BottomSheetBehavior.this.K(this.f527d);
            } else {
                View view = this.b;
                AtomicInteger atomicInteger = e.i.i.m.a;
                view.postOnAnimation(this);
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
        this.f515g = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        this.f516h = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i4 = R$styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i4);
        if (hasValue) {
            D(context, attributeSet, hasValue, f.b.a.c.b.o.b.w0(context, obtainStyledAttributes, i4));
        } else {
            D(context, attributeSet, hasValue, null);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.o = ofFloat;
        ofFloat.setDuration(500L);
        this.o.addUpdateListener(new f.b.a.e.e.a(this));
        this.u = obtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i5 = R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i5);
        if (peekValue == null || (i3 = peekValue.data) != -1) {
            I(obtainStyledAttributes.getDimensionPixelSize(i5, -1));
        } else {
            I(i3);
        }
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false);
        if (this.v != z2) {
            this.v = z2;
            if (!z2 && this.y == 5) {
                J(4);
            }
            P();
        }
        this.f519k = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z3 = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.b != z3) {
            this.b = z3;
            if (this.G != null) {
                B();
            }
            K((!this.b || this.y != 6) ? this.y : 3);
            P();
        }
        this.w = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.x = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.a = obtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f2 = obtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.s = f2;
        if (this.G != null) {
            this.r = (int) ((1.0f - f2) * ((float) this.F));
        }
        int i6 = R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i6);
        if (peekValue2 == null || peekValue2.type != 16) {
            i2 = obtainStyledAttributes.getDimensionPixelOffset(i6, 0);
            if (i2 < 0) {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
        } else {
            i2 = peekValue2.data;
            if (i2 < 0) {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
        }
        this.p = i2;
        obtainStyledAttributes.recycle();
        this.c = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.y == 1 && actionMasked == 0) {
            return true;
        }
        e.k.b.e eVar = this.z;
        if (eVar != null) {
            eVar.n(motionEvent);
        }
        if (actionMasked == 0) {
            this.K = -1;
            VelocityTracker velocityTracker = this.J;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.J = null;
            }
        }
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        if (this.z != null && actionMasked == 2 && !this.A) {
            float abs = Math.abs(((float) this.L) - motionEvent.getY());
            e.k.b.e eVar2 = this.z;
            if (abs > ((float) eVar2.b)) {
                eVar2.b(v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.A;
    }

    public final void B() {
        int C2 = C();
        if (this.b) {
            this.t = Math.max(this.F - C2, this.q);
        } else {
            this.t = this.F - C2;
        }
    }

    public final int C() {
        int i2;
        return this.f513e ? Math.min(Math.max(this.f514f, this.F - ((this.E * 9) / 16)), this.D) : (this.f519k || (i2 = this.f518j) <= 0) ? this.f512d : Math.max(this.f512d, i2 + this.f515g);
    }

    public final void D(Context context, AttributeSet attributeSet, boolean z2, ColorStateList colorStateList) {
        if (this.f516h) {
            this.f520l = j.b(context, attributeSet, R$attr.bottomSheetStyle, Q).a();
            g gVar = new g(this.f520l);
            this.f517i = gVar;
            gVar.b.b = new f.b.a.e.m.a(context);
            gVar.y();
            if (!z2 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f517i.setTint(typedValue.data);
                return;
            }
            this.f517i.q(colorStateList);
        }
    }

    public void E(int i2) {
        float f2;
        float f3;
        V v2 = this.G.get();
        if (!(v2 == null || this.I.isEmpty())) {
            int i3 = this.t;
            if (i2 > i3 || i3 == G()) {
                int i4 = this.t;
                f2 = (float) (i4 - i2);
                f3 = (float) (this.F - i4);
            } else {
                int i5 = this.t;
                f2 = (float) (i5 - i2);
                f3 = (float) (i5 - G());
            }
            float f4 = f2 / f3;
            for (int i6 = 0; i6 < this.I.size(); i6++) {
                this.I.get(i6).a(v2, f4);
            }
        }
    }

    public View F(View view) {
        AtomicInteger atomicInteger = e.i.i.m.a;
        if (view.isNestedScrollingEnabled()) {
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

    public int G() {
        return this.b ? this.q : this.p;
    }

    public final void H(V v2, b.a aVar, int i2) {
        e.i.i.m.o(v2, aVar, null, new f.b.a.e.e.c(this, i2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    public void I(int i2) {
        boolean z2 = true;
        if (i2 == -1) {
            if (!this.f513e) {
                this.f513e = true;
                if (z2) {
                    S(false);
                    return;
                }
                return;
            }
        } else if (this.f513e || this.f512d != i2) {
            this.f513e = false;
            this.f512d = Math.max(0, i2);
            if (z2) {
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    public void J(int i2) {
        if (i2 != this.y) {
            if (this.G != null) {
                M(i2);
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.v && i2 == 5)) {
                this.y = i2;
            }
        }
    }

    public void K(int i2) {
        V v2;
        if (this.y != i2) {
            this.y = i2;
            WeakReference<V> weakReference = this.G;
            if (!(weakReference == null || (v2 = weakReference.get()) == null)) {
                if (i2 == 3) {
                    R(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    R(false);
                }
                Q(i2);
                for (int i3 = 0; i3 < this.I.size(); i3++) {
                    this.I.get(i3).b(v2, i2);
                }
                P();
            }
        }
    }

    public void L(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.t;
        } else if (i2 == 6) {
            i3 = this.r;
            if (this.b && i3 <= (i4 = this.q)) {
                i2 = 3;
                i3 = i4;
            }
        } else if (i2 == 3) {
            i3 = G();
        } else if (!this.v || i2 != 5) {
            throw new IllegalArgumentException(f.a.a.a.a.v("Illegal state argument: ", i2));
        } else {
            i3 = this.F;
        }
        O(view, i2, i3, false);
    }

    public final void M(int i2) {
        V v2 = this.G.get();
        if (v2 != null) {
            ViewParent parent = v2.getParent();
            if (parent != null && parent.isLayoutRequested()) {
                AtomicInteger atomicInteger = e.i.i.m.a;
                if (v2.isAttachedToWindow()) {
                    v2.post(new a(v2, i2));
                    return;
                }
            }
            L(v2, i2);
        }
    }

    public boolean N(View view, float f2) {
        if (this.w) {
            return true;
        }
        if (view.getTop() < this.t) {
            return false;
        }
        return Math.abs(((f2 * 0.1f) + ((float) view.getTop())) - ((float) this.t)) / ((float) C()) > 0.5f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r7 != false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (r0.t(r5.getLeft(), r7) != false) goto L_0x002f;
     */
    public void O(View view, int i2, int i3, boolean z2) {
        e.k.b.e eVar = this.z;
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
            K(2);
            Q(i2);
            if (this.n == null) {
                this.n = new e(view, i2);
            }
            BottomSheetBehavior<V>.e eVar2 = this.n;
            boolean z4 = eVar2.c;
            eVar2.f527d = i2;
            if (!z4) {
                AtomicInteger atomicInteger = e.i.i.m.a;
                view.postOnAnimation(eVar2);
                this.n.c = true;
                return;
            }
            return;
        }
        K(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    public final void P() {
        V v2;
        b.a aVar;
        WeakReference<V> weakReference = this.G;
        if (!(weakReference == null || (v2 = weakReference.get()) == null)) {
            e.i.i.m.n(524288, v2);
            e.i.i.m.k(v2, 0);
            e.i.i.m.n(262144, v2);
            e.i.i.m.k(v2, 0);
            e.i.i.m.n(1048576, v2);
            e.i.i.m.k(v2, 0);
            int i2 = this.O;
            if (i2 != -1) {
                e.i.i.m.n(i2, v2);
                e.i.i.m.k(v2, 0);
            }
            int i3 = 6;
            if (this.y != 6) {
                String string = v2.getResources().getString(R$string.bottomsheet_action_expand_halfway);
                f.b.a.e.e.c cVar = new f.b.a.e.e.c(this, 6);
                List<b.a> h2 = e.i.i.m.h(v2);
                int i4 = 0;
                int i5 = -1;
                while (true) {
                    int[] iArr = e.i.i.m.f1294f;
                    if (i4 < iArr.length && i5 == -1) {
                        int i6 = iArr[i4];
                        boolean z2 = true;
                        for (int i7 = 0; i7 < h2.size(); i7++) {
                            z2 &= h2.get(i7).a() != i6;
                        }
                        if (z2) {
                            i5 = i6;
                        }
                        i4++;
                    } else if (i5 != -1) {
                        e.i.i.m.a(v2, new b.a(null, i5, string, cVar, null));
                    }
                }
                if (i5 != -1) {
                }
                this.O = i5;
            }
            if (this.v && this.y != 5) {
                H(v2, b.a.f1314j, 5);
            }
            int i8 = this.y;
            if (i8 == 3) {
                if (this.b) {
                    i3 = 4;
                }
                aVar = b.a.f1313i;
            } else if (i8 == 4) {
                if (this.b) {
                    i3 = 3;
                }
                aVar = b.a.f1312h;
            } else if (i8 == 6) {
                H(v2, b.a.f1313i, 4);
                H(v2, b.a.f1312h, 3);
                return;
            } else {
                return;
            }
            H(v2, aVar, i3);
        }
    }

    public final void Q(int i2) {
        ValueAnimator valueAnimator;
        if (i2 != 2) {
            boolean z2 = i2 == 3;
            if (this.m != z2) {
                this.m = z2;
                if (this.f517i != null && (valueAnimator = this.o) != null) {
                    if (valueAnimator.isRunning()) {
                        this.o.reverse();
                        return;
                    }
                    float f2 = z2 ? 0.0f : 1.0f;
                    this.o.setFloatValues(1.0f - f2, f2);
                    this.o.start();
                }
            }
        }
    }

    public final void R(boolean z2) {
        WeakReference<V> weakReference = this.G;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z2) {
                    if (this.N == null) {
                        this.N = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.G.get() && z2) {
                        this.N.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    }
                }
                if (!z2) {
                    this.N = null;
                }
            }
        }
    }

    public final void S(boolean z2) {
        V v2;
        if (this.G != null) {
            B();
            if (this.y == 4 && (v2 = this.G.get()) != null) {
                if (z2) {
                    M(this.y);
                } else {
                    v2.requestLayout();
                }
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void f(CoordinatorLayout.f fVar) {
        this.G = null;
        this.z = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void i() {
        this.G = null;
        this.z = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        e.k.b.e eVar;
        if (!v2.isShown() || !this.x) {
            this.A = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        View view = null;
        if (actionMasked == 0) {
            this.K = -1;
            VelocityTracker velocityTracker = this.J;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.J = null;
            }
        }
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.L = (int) motionEvent.getY();
            if (this.y != 2) {
                WeakReference<View> weakReference = this.H;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.p(view2, x2, this.L)) {
                    this.K = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.M = true;
                }
            }
            this.A = this.K == -1 && !coordinatorLayout.p(v2, x2, this.L);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.M = false;
            this.K = -1;
            if (this.A) {
                this.A = false;
                return false;
            }
        }
        if (!this.A && (eVar = this.z) != null && eVar.u(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.H;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        if (actionMasked != 2 || view == null || this.A || this.y == 1 || coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.z == null || Math.abs(((float) this.L) - motionEvent.getY()) <= ((float) this.z.b)) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        int i3;
        g gVar;
        AtomicInteger atomicInteger = e.i.i.m.a;
        if (coordinatorLayout.getFitsSystemWindows() && !v2.getFitsSystemWindows()) {
            v2.setFitsSystemWindows(true);
        }
        if (this.G == null) {
            this.f514f = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            if (Build.VERSION.SDK_INT >= 29 && !this.f519k && !this.f513e) {
                e.i.i.m.r(v2, new f.b.a.e.p.m(new f.b.a.e.e.b(this), new p(v2.getPaddingStart(), v2.getPaddingTop(), v2.getPaddingEnd(), v2.getPaddingBottom())));
                if (v2.isAttachedToWindow()) {
                    v2.requestApplyInsets();
                } else {
                    v2.addOnAttachStateChangeListener(new n());
                }
            }
            this.G = new WeakReference<>(v2);
            if (this.f516h && (gVar = this.f517i) != null) {
                v2.setBackground(gVar);
            }
            g gVar2 = this.f517i;
            if (gVar2 != null) {
                float f2 = this.u;
                if (f2 == -1.0f) {
                    f2 = v2.getElevation();
                }
                gVar2.p(f2);
                boolean z2 = this.y == 3;
                this.m = z2;
                this.f517i.r(z2 ? 0.0f : 1.0f);
            }
            P();
            if (v2.getImportantForAccessibility() == 0) {
                v2.setImportantForAccessibility(1);
            }
        }
        if (this.z == null) {
            this.z = new e.k.b.e(coordinatorLayout.getContext(), coordinatorLayout, this.P);
        }
        int top = v2.getTop();
        coordinatorLayout.r(v2, i2);
        this.E = coordinatorLayout.getWidth();
        this.F = coordinatorLayout.getHeight();
        int height = v2.getHeight();
        this.D = height;
        this.q = Math.max(0, this.F - height);
        this.r = (int) ((1.0f - this.s) * ((float) this.F));
        B();
        int i4 = this.y;
        if (i4 == 3) {
            i3 = G();
        } else if (i4 == 6) {
            i3 = this.r;
        } else if (this.v && i4 == 5) {
            i3 = this.F;
        } else if (i4 == 4) {
            i3 = this.t;
        } else {
            if (i4 == 1 || i4 == 2) {
                e.i.i.m.m(v2, top - v2.getTop());
            }
            this.H = new WeakReference<>(F(v2));
            return true;
        }
        e.i.i.m.m(v2, i3);
        this.H = new WeakReference<>(F(v2));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.H;
        return (weakReference == null || view != weakReference.get() || this.y == 3) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        int i5;
        if (i4 != 1) {
            WeakReference<View> weakReference = this.H;
            if (view == (weakReference != null ? weakReference.get() : null)) {
                int top = v2.getTop();
                int i6 = top - i3;
                if (i3 <= 0) {
                    if (i3 < 0 && !view.canScrollVertically(-1)) {
                        int i7 = this.t;
                        if (i6 > i7 && !this.v) {
                            iArr[1] = top - i7;
                            e.i.i.m.m(v2, -iArr[1]);
                            i5 = 4;
                        } else if (this.x) {
                            iArr[1] = i3;
                            e.i.i.m.m(v2, -i3);
                            K(1);
                        } else {
                            return;
                        }
                    }
                    E(v2.getTop());
                    this.B = i3;
                    this.C = true;
                } else if (i6 < G()) {
                    iArr[1] = top - G();
                    e.i.i.m.m(v2, -iArr[1]);
                    i5 = 3;
                } else if (this.x) {
                    iArr[1] = i3;
                    e.i.i.m.m(v2, -i3);
                    K(1);
                    E(v2.getTop());
                    this.B = i3;
                    this.C = true;
                } else {
                    return;
                }
                K(i5);
                E(v2.getTop());
                this.B = i3;
                this.C = true;
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
                this.f512d = dVar.f523e;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.b = dVar.f524f;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.v = dVar.f525g;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.w = dVar.f526h;
            }
        }
        int i3 = dVar.f522d;
        if (i3 == 1 || i3 == 2) {
            this.y = 4;
        } else {
            this.y = i3;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable v(CoordinatorLayout coordinatorLayout, V v2) {
        return new d((Parcelable) View.BaseSavedState.EMPTY_STATE, (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean x(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.B = 0;
        this.C = false;
        return (i2 & 2) != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r2 > r4) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        if (java.lang.Math.abs(r2 - r1.q) < java.lang.Math.abs(r2 - r1.t)) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0081, code lost:
        if (r2 < java.lang.Math.abs(r2 - r1.t)) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0083, code lost:
        r2 = r1.p;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0093, code lost:
        if (java.lang.Math.abs(r2 - r4) < java.lang.Math.abs(r2 - r1.t)) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ae, code lost:
        if (java.lang.Math.abs(r2 - r1.r) < java.lang.Math.abs(r2 - r1.t)) goto L_0x00b0;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void z(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        int i4;
        float f2;
        int i5 = 3;
        if (v2.getTop() == G()) {
            K(3);
            return;
        }
        WeakReference<View> weakReference = this.H;
        if (weakReference != null && view == weakReference.get() && this.C) {
            if (this.B <= 0) {
                if (this.v) {
                    VelocityTracker velocityTracker = this.J;
                    if (velocityTracker == null) {
                        f2 = 0.0f;
                    } else {
                        velocityTracker.computeCurrentVelocity(1000, this.c);
                        f2 = this.J.getYVelocity(this.K);
                    }
                    if (N(v2, f2)) {
                        i3 = this.F;
                        i5 = 5;
                        O(v2, i5, i3, false);
                        this.C = false;
                    }
                }
                if (this.B == 0) {
                    int top = v2.getTop();
                    if (!this.b) {
                        int i6 = this.r;
                        if (top < i6) {
                        }
                    }
                    i3 = this.t;
                    i5 = 4;
                    O(v2, i5, i3, false);
                    this.C = false;
                }
                if (!this.b) {
                    int top2 = v2.getTop();
                }
                i3 = this.t;
                i5 = 4;
                O(v2, i5, i3, false);
                this.C = false;
                i4 = this.r;
                i5 = 6;
                i3 = i4;
                O(v2, i5, i3, false);
                this.C = false;
            } else if (!this.b) {
                int top3 = v2.getTop();
                i4 = this.r;
            }
            i3 = this.q;
            O(v2, i5, i3, false);
            this.C = false;
        }
    }
}
