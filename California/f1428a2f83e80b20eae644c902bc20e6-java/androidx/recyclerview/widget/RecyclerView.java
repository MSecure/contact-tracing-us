package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import e.i.i.w.b;
import e.s.a.a;
import e.s.a.b;
import e.s.a.j;
import e.s.a.u;
import e.s.a.x;
import e.s.a.y;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class RecyclerView extends ViewGroup implements e.i.i.e {
    public static final boolean A0 = (Build.VERSION.SDK_INT >= 23);
    public static final boolean B0 = true;
    public static final boolean C0 = true;
    public static final Class<?>[] D0;
    public static final Interpolator E0 = new c();
    public static final int[] z0 = {16843830};
    public int A;
    public boolean B;
    public final AccessibilityManager C;
    public List<o> D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public i I;
    public EdgeEffect J;
    public EdgeEffect K;
    public EdgeEffect L;
    public EdgeEffect M;
    public j N;
    public int O;
    public int P;
    public VelocityTracker Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public p W;
    public final int a0;
    public final v b;
    public final int b0;
    public final t c;
    public float c0;

    /* renamed from: d  reason: collision with root package name */
    public w f198d;
    public float d0;

    /* renamed from: e  reason: collision with root package name */
    public e.s.a.a f199e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public e.s.a.b f200f;
    public final a0 f0;

    /* renamed from: g  reason: collision with root package name */
    public final e.s.a.y f201g;
    public e.s.a.j g0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f202h;
    public j.b h0;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f203i;
    public final y i0;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f204j;
    public r j0;

    /* renamed from: k  reason: collision with root package name */
    public final Rect f205k;
    public List<r> k0;

    /* renamed from: l  reason: collision with root package name */
    public final RectF f206l;
    public boolean l0;
    public e m;
    public boolean m0;
    public m n;
    public j.b n0;
    public u o;
    public boolean o0;
    public final ArrayList<l> p;
    public e.s.a.u p0;
    public final ArrayList<q> q;
    public h q0;
    public q r;
    public final int[] r0;
    public boolean s;
    public e.i.i.f s0;
    public boolean t;
    public final int[] t0;
    public boolean u;
    public final int[] u0;
    public boolean v;
    public final int[] v0;
    public int w;
    public final List<b0> w0;
    public boolean x;
    public Runnable x0;
    public boolean y;
    public final y.b y0;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.v && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.s) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.y) {
                    recyclerView2.x = true;
                } else {
                    recyclerView2.n();
                }
            }
        }
    }

    public class a0 implements Runnable {
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public OverScroller f207d;

        /* renamed from: e  reason: collision with root package name */
        public Interpolator f208e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f209f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f210g = false;

        public a0() {
            Interpolator interpolator = RecyclerView.E0;
            this.f208e = interpolator;
            this.f207d = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public void a() {
            if (this.f209f) {
                this.f210g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            RecyclerView recyclerView = RecyclerView.this;
            AtomicInteger atomicInteger = e.i.i.l.a;
            recyclerView.postOnAnimation(this);
        }

        public void b(int i2, int i3, int i4, Interpolator interpolator) {
            int i5;
            if (i4 == Integer.MIN_VALUE) {
                int abs = Math.abs(i2);
                int abs2 = Math.abs(i3);
                boolean z = abs > abs2;
                int sqrt = (int) Math.sqrt((double) 0);
                int sqrt2 = (int) Math.sqrt((double) ((i3 * i3) + (i2 * i2)));
                RecyclerView recyclerView = RecyclerView.this;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                int i6 = width / 2;
                float f2 = (float) width;
                float f3 = (float) i6;
                float sin = (((float) Math.sin((double) ((Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2) - 0.5f) * 0.47123894f))) * f3) + f3;
                if (sqrt > 0) {
                    i5 = Math.round(Math.abs(sin / ((float) sqrt)) * 1000.0f) * 4;
                } else {
                    if (!z) {
                        abs = abs2;
                    }
                    i5 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
                }
                i4 = Math.min(i5, 2000);
            }
            if (interpolator == null) {
                interpolator = RecyclerView.E0;
            }
            if (this.f208e != interpolator) {
                this.f208e = interpolator;
                this.f207d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.c = 0;
            this.b = 0;
            RecyclerView.this.setScrollState(2);
            this.f207d.startScroll(0, 0, i2, i3, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f207d.computeScrollOffset();
            }
            a();
        }

        public void c() {
            RecyclerView.this.removeCallbacks(this);
            this.f207d.abortAnimation();
        }

        public void run() {
            int i2;
            int i3;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.n == null) {
                c();
                return;
            }
            this.f210g = false;
            this.f209f = true;
            recyclerView.n();
            OverScroller overScroller = this.f207d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.b;
                int i5 = currY - this.c;
                this.b = currX;
                this.c = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.v0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.t(i4, i5, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.v0;
                    i4 -= iArr2[0];
                    i5 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.m(i4, i5);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.m != null) {
                    int[] iArr3 = recyclerView3.v0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.h0(i4, i5, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.v0;
                    i2 = iArr4[0];
                    i3 = iArr4[1];
                    i4 -= i2;
                    i5 -= i3;
                    x xVar = recyclerView4.n.f227g;
                    if (xVar != null && !xVar.f242d && xVar.f243e) {
                        int b2 = recyclerView4.i0.b();
                        if (b2 == 0) {
                            xVar.d();
                        } else {
                            if (xVar.a >= b2) {
                                xVar.a = b2 - 1;
                            }
                            xVar.b(i2, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.p.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.v0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.u(i2, i3, i4, i5, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.v0;
                int i6 = i4 - iArr6[0];
                int i7 = i5 - iArr6[1];
                if (!(i2 == 0 && i3 == 0)) {
                    recyclerView6.v(i2, i3);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
                RecyclerView recyclerView7 = RecyclerView.this;
                x xVar2 = recyclerView7.n.f227g;
                if ((xVar2 != null && xVar2.f242d) || !z) {
                    a();
                    RecyclerView recyclerView8 = RecyclerView.this;
                    e.s.a.j jVar = recyclerView8.g0;
                    if (jVar != null) {
                        jVar.a(recyclerView8, i2, i3);
                    }
                } else {
                    if (recyclerView7.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i8 = i6 < 0 ? -currVelocity : i6 > 0 ? currVelocity : 0;
                        if (i7 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i7 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView recyclerView9 = RecyclerView.this;
                        Objects.requireNonNull(recyclerView9);
                        if (i8 < 0) {
                            recyclerView9.x();
                            if (recyclerView9.J.isFinished()) {
                                recyclerView9.J.onAbsorb(-i8);
                            }
                        } else if (i8 > 0) {
                            recyclerView9.y();
                            if (recyclerView9.L.isFinished()) {
                                recyclerView9.L.onAbsorb(i8);
                            }
                        }
                        if (currVelocity < 0) {
                            recyclerView9.z();
                            if (recyclerView9.K.isFinished()) {
                                recyclerView9.K.onAbsorb(-currVelocity);
                            }
                        } else if (currVelocity > 0) {
                            recyclerView9.w();
                            if (recyclerView9.M.isFinished()) {
                                recyclerView9.M.onAbsorb(currVelocity);
                            }
                        }
                        if (!(i8 == 0 && currVelocity == 0)) {
                            AtomicInteger atomicInteger = e.i.i.l.a;
                            recyclerView9.postInvalidateOnAnimation();
                        }
                    }
                    if (RecyclerView.C0) {
                        j.b bVar = RecyclerView.this.h0;
                        int[] iArr7 = bVar.c;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        bVar.f1807d = 0;
                    }
                }
            }
            x xVar3 = RecyclerView.this.n.f227g;
            if (xVar3 != null && xVar3.f242d) {
                xVar3.b(0, 0);
            }
            this.f209f = false;
            if (this.f210g) {
                RecyclerView.this.removeCallbacks(this);
                RecyclerView recyclerView10 = RecyclerView.this;
                AtomicInteger atomicInteger2 = e.i.i.l.a;
                recyclerView10.postOnAnimation(this);
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.p0(1);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            j jVar = RecyclerView.this.N;
            if (jVar != null) {
                jVar.m();
            }
            RecyclerView.this.o0 = false;
        }
    }

    public static abstract class b0 {
        public static final List<Object> s = Collections.emptyList();
        public final View a;
        public WeakReference<RecyclerView> b;
        public int c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f212d = -1;

        /* renamed from: e  reason: collision with root package name */
        public long f213e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f214f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f215g = -1;

        /* renamed from: h  reason: collision with root package name */
        public b0 f216h = null;

        /* renamed from: i  reason: collision with root package name */
        public b0 f217i = null;

        /* renamed from: j  reason: collision with root package name */
        public int f218j;

        /* renamed from: k  reason: collision with root package name */
        public List<Object> f219k = null;

        /* renamed from: l  reason: collision with root package name */
        public List<Object> f220l = null;
        public int m = 0;
        public t n = null;
        public boolean o = false;
        public int p = 0;
        public int q = -1;
        public RecyclerView r;

        public b0(View view) {
            if (view != null) {
                this.a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f218j) == 0) {
                if (this.f219k == null) {
                    ArrayList arrayList = new ArrayList();
                    this.f219k = arrayList;
                    this.f220l = Collections.unmodifiableList(arrayList);
                }
                this.f219k.add(obj);
            }
        }

        public void b(int i2) {
            this.f218j = i2 | this.f218j;
        }

        public void c() {
            this.f212d = -1;
            this.f215g = -1;
        }

        public void d() {
            this.f218j &= -33;
        }

        public final int e() {
            RecyclerView recyclerView = this.r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.H(this);
        }

        public final int f() {
            int i2 = this.f215g;
            return i2 == -1 ? this.c : i2;
        }

        public List<Object> g() {
            if ((this.f218j & 1024) != 0) {
                return s;
            }
            List<Object> list = this.f219k;
            return (list == null || list.size() == 0) ? s : this.f220l;
        }

        public boolean h(int i2) {
            return (i2 & this.f218j) != 0;
        }

        public boolean i() {
            return (this.a.getParent() == null || this.a.getParent() == this.r) ? false : true;
        }

        public boolean j() {
            return (this.f218j & 1) != 0;
        }

        public boolean k() {
            return (this.f218j & 4) != 0;
        }

        public final boolean l() {
            if ((this.f218j & 16) == 0) {
                View view = this.a;
                AtomicInteger atomicInteger = e.i.i.l.a;
                if (!view.hasTransientState()) {
                    return true;
                }
            }
            return false;
        }

        public boolean m() {
            return (this.f218j & 8) != 0;
        }

        public boolean n() {
            return this.n != null;
        }

        public boolean o() {
            return (this.f218j & 256) != 0;
        }

        public boolean p() {
            return (this.f218j & 2) != 0;
        }

        public void q(int i2, boolean z) {
            if (this.f212d == -1) {
                this.f212d = this.c;
            }
            if (this.f215g == -1) {
                this.f215g = this.c;
            }
            if (z) {
                this.f215g += i2;
            }
            this.c += i2;
            if (this.a.getLayoutParams() != null) {
                ((n) this.a.getLayoutParams()).c = true;
            }
        }

        public void r() {
            this.f218j = 0;
            this.c = -1;
            this.f212d = -1;
            this.f213e = -1;
            this.f215g = -1;
            this.m = 0;
            this.f216h = null;
            this.f217i = null;
            List<Object> list = this.f219k;
            if (list != null) {
                list.clear();
            }
            this.f218j &= -1025;
            this.p = 0;
            this.q = -1;
            RecyclerView.k(this);
        }

        public void s(int i2, int i3) {
            this.f218j = (i2 & i3) | (this.f218j & (~i3));
        }

        public final void t(boolean z) {
            int i2;
            int i3 = this.m;
            int i4 = z ? i3 - 1 : i3 + 1;
            this.m = i4;
            if (i4 < 0) {
                this.m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i4 == 1) {
                i2 = this.f218j | 16;
            } else if (z && i4 == 0) {
                i2 = this.f218j & -17;
            } else {
                return;
            }
            this.f218j = i2;
        }

        public String toString() {
            StringBuilder i2 = f.a.a.a.a.i(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            i2.append(Integer.toHexString(hashCode()));
            i2.append(" position=");
            i2.append(this.c);
            i2.append(" id=");
            i2.append(this.f213e);
            i2.append(", oldPos=");
            i2.append(this.f212d);
            i2.append(", pLpos:");
            i2.append(this.f215g);
            StringBuilder sb = new StringBuilder(i2.toString());
            if (n()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (k()) {
                sb.append(" invalid");
            }
            if (!j()) {
                sb.append(" unbound");
            }
            boolean z = false;
            if ((this.f218j & 2) != 0) {
                sb.append(" update");
            }
            if (m()) {
                sb.append(" removed");
            }
            if (u()) {
                sb.append(" ignored");
            }
            if (o()) {
                sb.append(" tmpDetached");
            }
            if (!l()) {
                StringBuilder h2 = f.a.a.a.a.h(" not recyclable(");
                h2.append(this.m);
                h2.append(")");
                sb.append(h2.toString());
            }
            if ((this.f218j & 512) != 0 || k()) {
                z = true;
            }
            if (z) {
                sb.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public boolean u() {
            return (this.f218j & 128) != 0;
        }

        public boolean v() {
            return (this.f218j & 32) != 0;
        }
    }

    public static class c implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public class d implements y.b {
        public d() {
        }

        public void a(b0 b0Var, j.c cVar, j.c cVar2) {
            RecyclerView.this.c.k(b0Var);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f(b0Var);
            b0Var.t(false);
            if (recyclerView.N.c(b0Var, cVar, cVar2)) {
                recyclerView.Z();
            }
        }
    }

    public static abstract class e<VH extends b0> {
        public final f a = new f();
        public boolean b = false;

        public abstract int c();

        public long d(int i2) {
            return -1;
        }

        public int e(int i2) {
            return 0;
        }

        public void f(RecyclerView recyclerView) {
        }

        public abstract void g(VH vh, int i2);

        public void h(VH vh, int i2, List<Object> list) {
            g(vh, i2);
        }

        public abstract VH i(ViewGroup viewGroup, int i2);

        public void j(RecyclerView recyclerView) {
        }

        public boolean k(VH vh) {
            return false;
        }

        public void l(VH vh) {
        }

        public void m(VH vh) {
        }

        public void n(VH vh) {
        }

        public void o(boolean z) {
            if (!this.a.a()) {
                this.b = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
    }

    public static class f extends Observable<g> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i2, int i3, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).c(i2, i3, obj);
            }
        }

        public void d(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).d(i2, i3);
            }
        }

        public void e(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).e(i2, i3);
            }
        }
    }

    public static abstract class g {
        public void a() {
        }

        public void b(int i2, int i3) {
        }

        public void c(int i2, int i3, Object obj) {
            b(i2, i3);
        }

        public void d(int i2, int i3) {
        }

        public void e(int i2, int i3) {
        }
    }

    public interface h {
        int a(int i2, int i3);
    }

    public static class i {
        public EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class j {
        public b a = null;
        public ArrayList<a> b = new ArrayList<>();
        public long c = 120;

        /* renamed from: d  reason: collision with root package name */
        public long f221d = 120;

        /* renamed from: e  reason: collision with root package name */
        public long f222e = 250;

        /* renamed from: f  reason: collision with root package name */
        public long f223f = 250;

        public interface a {
            void a();
        }

        public interface b {
        }

        public static class c {
            public int a;
            public int b;
        }

        public static int e(b0 b0Var) {
            int i2 = b0Var.f218j & 14;
            if (b0Var.k()) {
                return 4;
            }
            if ((i2 & 4) != 0) {
                return i2;
            }
            int i3 = b0Var.f212d;
            int e2 = b0Var.e();
            return (i3 == -1 || e2 == -1 || i3 == e2) ? i2 : i2 | 2048;
        }

        public abstract boolean a(b0 b0Var, c cVar, c cVar2);

        public abstract boolean b(b0 b0Var, b0 b0Var2, c cVar, c cVar2);

        public abstract boolean c(b0 b0Var, c cVar, c cVar2);

        public abstract boolean d(b0 b0Var, c cVar, c cVar2);

        public abstract boolean f(b0 b0Var, List<Object> list);

        public final void g(b0 b0Var) {
            b bVar = this.a;
            if (bVar != null) {
                k kVar = (k) bVar;
                Objects.requireNonNull(kVar);
                boolean z = true;
                b0Var.t(true);
                if (b0Var.f216h != null && b0Var.f217i == null) {
                    b0Var.f216h = null;
                }
                b0Var.f217i = null;
                if (!((b0Var.f218j & 16) != 0)) {
                    RecyclerView recyclerView = RecyclerView.this;
                    View view = b0Var.a;
                    recyclerView.m0();
                    e.s.a.b bVar2 = recyclerView.f200f;
                    int indexOfChild = ((e.s.a.s) bVar2.a).a.indexOfChild(view);
                    if (indexOfChild == -1) {
                        bVar2.l(view);
                    } else if (bVar2.b.d(indexOfChild)) {
                        bVar2.b.f(indexOfChild);
                        bVar2.l(view);
                        ((e.s.a.s) bVar2.a).c(indexOfChild);
                    } else {
                        z = false;
                    }
                    if (z) {
                        b0 K = RecyclerView.K(view);
                        recyclerView.c.k(K);
                        recyclerView.c.h(K);
                    }
                    recyclerView.o0(!z);
                    if (!z && b0Var.o()) {
                        RecyclerView.this.removeDetachedView(b0Var.a, false);
                    }
                }
            }
        }

        public final void h() {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.b.get(i2).a();
            }
            this.b.clear();
        }

        public abstract void i(b0 b0Var);

        public abstract void j();

        public abstract boolean k();

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/recyclerview/widget/RecyclerView$y;Landroidx/recyclerview/widget/RecyclerView$b0;ILjava/util/List<Ljava/lang/Object;>;)Landroidx/recyclerview/widget/RecyclerView$j$c; */
        public c l(b0 b0Var) {
            c cVar = new c();
            View view = b0Var.a;
            cVar.a = view.getLeft();
            cVar.b = view.getTop();
            view.getRight();
            view.getBottom();
            return cVar;
        }

        public abstract void m();
    }

    public class k implements j.b {
        public k() {
        }
    }

    public static abstract class l {
        public void d(Canvas canvas, RecyclerView recyclerView, y yVar) {
        }

        public void e(Canvas canvas, RecyclerView recyclerView, y yVar) {
        }
    }

    public static abstract class m {
        public e.s.a.b a;
        public RecyclerView b;
        public final x.b c;

        /* renamed from: d  reason: collision with root package name */
        public final x.b f224d;

        /* renamed from: e  reason: collision with root package name */
        public e.s.a.x f225e;

        /* renamed from: f  reason: collision with root package name */
        public e.s.a.x f226f;

        /* renamed from: g  reason: collision with root package name */
        public x f227g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f228h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f229i = false;

        /* renamed from: j  reason: collision with root package name */
        public boolean f230j = true;

        /* renamed from: k  reason: collision with root package name */
        public boolean f231k = true;

        /* renamed from: l  reason: collision with root package name */
        public int f232l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;

        public class a implements x.b {
            public a() {
            }

            @Override // e.s.a.x.b
            public View a(int i2) {
                return m.this.x(i2);
            }

            @Override // e.s.a.x.b
            public int b() {
                m mVar = m.this;
                return mVar.p - mVar.P();
            }

            @Override // e.s.a.x.b
            public int c() {
                return m.this.O();
            }

            @Override // e.s.a.x.b
            public int d(View view) {
                return m.this.G(view) + ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).rightMargin;
            }

            @Override // e.s.a.x.b
            public int e(View view) {
                return m.this.D(view) - ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).leftMargin;
            }
        }

        public class b implements x.b {
            public b() {
            }

            @Override // e.s.a.x.b
            public View a(int i2) {
                return m.this.x(i2);
            }

            @Override // e.s.a.x.b
            public int b() {
                m mVar = m.this;
                return mVar.q - mVar.N();
            }

            @Override // e.s.a.x.b
            public int c() {
                return m.this.Q();
            }

            @Override // e.s.a.x.b
            public int d(View view) {
                return m.this.B(view) + ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).bottomMargin;
            }

            @Override // e.s.a.x.b
            public int e(View view) {
                return m.this.H(view) - ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).topMargin;
            }
        }

        public interface c {
        }

        public static class d {
            public int a;
            public int b;
            public boolean c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f233d;
        }

        public m() {
            a aVar = new a();
            this.c = aVar;
            b bVar = new b();
            this.f224d = bVar;
            this.f225e = new e.s.a.x(aVar);
            this.f226f = new e.s.a.x(bVar);
        }

        public static d S(Context context, AttributeSet attributeSet, int i2, int i3) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i2, i3);
            dVar.a = obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
            dVar.b = obtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
            dVar.c = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
            dVar.f233d = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static boolean Y(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        public static int h(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i3, i4) : size : Math.min(size, Math.max(i3, i4));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        public static int z(int i2, int i3, int i4, int i5, boolean z) {
            int max = Math.max(0, i2 - i4);
            if (z) {
                if (i5 < 0) {
                    if (i5 == -1) {
                        if (i3 != Integer.MIN_VALUE) {
                            if (i3 != 0) {
                            }
                        }
                        i5 = max;
                        return View.MeasureSpec.makeMeasureSpec(i5, i3);
                    }
                    i3 = 0;
                    i5 = 0;
                    return View.MeasureSpec.makeMeasureSpec(i5, i3);
                }
            } else if (i5 < 0) {
                if (i5 != -1) {
                    if (i5 == -2) {
                        i3 = (i3 == Integer.MIN_VALUE || i3 == 1073741824) ? Integer.MIN_VALUE : 0;
                    }
                    i3 = 0;
                    i5 = 0;
                    return View.MeasureSpec.makeMeasureSpec(i5, i3);
                }
                i5 = max;
                return View.MeasureSpec.makeMeasureSpec(i5, i3);
            }
            i3 = 1073741824;
            return View.MeasureSpec.makeMeasureSpec(i5, i3);
        }

        public int A(t tVar, y yVar) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.m == null || !e()) {
                return 1;
            }
            return this.b.m.c();
        }

        public void A0(Parcelable parcelable) {
        }

        public int B(View view) {
            return view.getBottom() + ((n) view.getLayoutParams()).b.bottom;
        }

        public Parcelable B0() {
            return null;
        }

        public void C(View view, Rect rect) {
            int[] iArr = RecyclerView.z0;
            n nVar = (n) view.getLayoutParams();
            Rect rect2 = nVar.b;
            rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) nVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin);
        }

        public void C0(int i2) {
        }

        public int D(View view) {
            return view.getLeft() - ((n) view.getLayoutParams()).b.left;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[ADDED_TO_REGION] */
        public boolean D0(t tVar, y yVar, int i2, Bundle bundle) {
            int i3;
            int i4;
            int i5;
            int i6;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                return false;
            }
            if (i2 == 4096) {
                i5 = recyclerView.canScrollVertically(1) ? (this.q - Q()) - N() : 0;
                if (this.b.canScrollHorizontally(1)) {
                    i6 = (this.p - O()) - P();
                }
                i3 = i5;
                i4 = 0;
                if (i3 != 0) {
                }
                this.b.k0(i4, i3, null, Integer.MIN_VALUE, true);
                return true;
            } else if (i2 != 8192) {
                i4 = 0;
                i3 = 0;
                if (i3 != 0 && i4 == 0) {
                    return false;
                }
                this.b.k0(i4, i3, null, Integer.MIN_VALUE, true);
                return true;
            } else {
                i5 = recyclerView.canScrollVertically(-1) ? -((this.q - Q()) - N()) : 0;
                if (this.b.canScrollHorizontally(-1)) {
                    i6 = -((this.p - O()) - P());
                }
                i3 = i5;
                i4 = 0;
                if (i3 != 0) {
                }
                this.b.k0(i4, i3, null, Integer.MIN_VALUE, true);
                return true;
            }
            i3 = i5;
            i4 = i6;
            if (i3 != 0) {
            }
            this.b.k0(i4, i3, null, Integer.MIN_VALUE, true);
            return true;
        }

        public int E(View view) {
            Rect rect = ((n) view.getLayoutParams()).b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public boolean E0() {
            return false;
        }

        public int F(View view) {
            Rect rect = ((n) view.getLayoutParams()).b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void F0(t tVar) {
            for (int y = y() - 1; y >= 0; y--) {
                if (!RecyclerView.K(x(y)).u()) {
                    I0(y, tVar);
                }
            }
        }

        public int G(View view) {
            return view.getRight() + ((n) view.getLayoutParams()).b.right;
        }

        public void G0(t tVar) {
            int size = tVar.a.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                View view = tVar.a.get(i2).a;
                b0 K = RecyclerView.K(view);
                if (!K.u()) {
                    K.t(false);
                    if (K.o()) {
                        this.b.removeDetachedView(view, false);
                    }
                    j jVar = this.b.N;
                    if (jVar != null) {
                        jVar.i(K);
                    }
                    K.t(true);
                    b0 K2 = RecyclerView.K(view);
                    K2.n = null;
                    K2.o = false;
                    K2.d();
                    tVar.h(K2);
                }
            }
            tVar.a.clear();
            ArrayList<b0> arrayList = tVar.b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.b.invalidate();
            }
        }

        public int H(View view) {
            return view.getTop() - ((n) view.getLayoutParams()).b.top;
        }

        public void H0(View view, t tVar) {
            e.s.a.b bVar = this.a;
            int indexOfChild = ((e.s.a.s) bVar.a).a.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (bVar.b.f(indexOfChild)) {
                    bVar.l(view);
                }
                ((e.s.a.s) bVar.a).c(indexOfChild);
            }
            tVar.g(view);
        }

        public View I() {
            View focusedChild;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.a.c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void I0(int i2, t tVar) {
            View x = x(i2);
            J0(i2);
            tVar.g(x);
        }

        public int J() {
            RecyclerView recyclerView = this.b;
            e adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.c();
            }
            return 0;
        }

        public void J0(int i2) {
            e.s.a.b bVar;
            int f2;
            View a2;
            if (x(i2) != null && (a2 = ((e.s.a.s) bVar.a).a((f2 = (bVar = this.a).f(i2)))) != null) {
                if (bVar.b.f(f2)) {
                    bVar.l(a2);
                }
                ((e.s.a.s) bVar.a).c(f2);
            }
        }

        public int K() {
            RecyclerView recyclerView = this.b;
            AtomicInteger atomicInteger = e.i.i.l.a;
            return recyclerView.getLayoutDirection();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b8, code lost:
            if (r1 == false) goto L_0x00bf;
         */
        public boolean K0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            boolean z3;
            int[] iArr = new int[2];
            int O = O();
            int Q = Q();
            int P = this.p - P();
            int N = this.q - N();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i2 = left - O;
            int min = Math.min(0, i2);
            int i3 = top - Q;
            int min2 = Math.min(0, i3);
            int i4 = width - P;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height - N);
            if (K() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            int i5 = iArr[0];
            int i6 = iArr[1];
            if (z2) {
                View focusedChild = recyclerView.getFocusedChild();
                if (focusedChild != null) {
                    int O2 = O();
                    int Q2 = Q();
                    int P2 = this.p - P();
                    int N2 = this.q - N();
                    Rect rect2 = this.b.f204j;
                    C(focusedChild, rect2);
                    if (rect2.left - i5 < P2 && rect2.right - i5 > O2 && rect2.top - i6 < N2 && rect2.bottom - i6 > Q2) {
                        z3 = true;
                    }
                }
                z3 = false;
            }
            if (!(i5 == 0 && i6 == 0)) {
                if (z) {
                    recyclerView.scrollBy(i5, i6);
                } else {
                    recyclerView.k0(i5, i6, null, Integer.MIN_VALUE, false);
                }
                return true;
            }
            return false;
        }

        public int L() {
            RecyclerView recyclerView = this.b;
            AtomicInteger atomicInteger = e.i.i.l.a;
            return recyclerView.getMinimumHeight();
        }

        public void L0() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int M() {
            RecyclerView recyclerView = this.b;
            AtomicInteger atomicInteger = e.i.i.l.a;
            return recyclerView.getMinimumWidth();
        }

        public int M0(int i2, t tVar, y yVar) {
            return 0;
        }

        public int N() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public void N0(int i2) {
        }

        public int O() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int O0(int i2, t tVar, y yVar) {
            return 0;
        }

        public int P() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void P0(RecyclerView recyclerView) {
            Q0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int Q() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public void Q0(int i2, int i3) {
            this.p = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.n = mode;
            if (mode == 0 && !RecyclerView.A0) {
                this.p = 0;
            }
            this.q = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.o = mode2;
            if (mode2 == 0 && !RecyclerView.A0) {
                this.q = 0;
            }
        }

        public int R(View view) {
            return ((n) view.getLayoutParams()).a();
        }

        public void R0(Rect rect, int i2, int i3) {
            int P = P() + O() + rect.width();
            int N = N() + Q() + rect.height();
            this.b.setMeasuredDimension(h(i2, P, M()), h(i3, N, L()));
        }

        public void S0(int i2, int i3) {
            int y = y();
            if (y == 0) {
                this.b.o(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < y; i8++) {
                View x = x(i8);
                Rect rect = this.b.f204j;
                C(x, rect);
                int i9 = rect.left;
                if (i9 < i6) {
                    i6 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i7) {
                    i7 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i5) {
                    i5 = i12;
                }
            }
            this.b.f204j.set(i6, i7, i4, i5);
            R0(this.b.f204j, i2, i3);
        }

        public int T(t tVar, y yVar) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.m == null || !f()) {
                return 1;
            }
            return this.b.m.c();
        }

        public void T0(RecyclerView recyclerView) {
            int i2;
            if (recyclerView == null) {
                this.b = null;
                this.a = null;
                i2 = 0;
                this.p = 0;
            } else {
                this.b = recyclerView;
                this.a = recyclerView.f200f;
                this.p = recyclerView.getWidth();
                i2 = recyclerView.getHeight();
            }
            this.q = i2;
            this.n = 1073741824;
            this.o = 1073741824;
        }

        public int U() {
            return 0;
        }

        public boolean U0(View view, int i2, int i3, n nVar) {
            return view.isLayoutRequested() || !this.f230j || !Y(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) nVar).width) || !Y(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) nVar).height);
        }

        public void V(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((n) view.getLayoutParams()).b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.b.f206l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean V0() {
            return false;
        }

        public boolean W() {
            return false;
        }

        public boolean W0(View view, int i2, int i3, n nVar) {
            return !this.f230j || !Y(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) nVar).width) || !Y(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) nVar).height);
        }

        public boolean X() {
            return false;
        }

        public void X0(RecyclerView recyclerView, y yVar, int i2) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void Y0(x xVar) {
            x xVar2 = this.f227g;
            if (!(xVar2 == null || xVar == xVar2 || !xVar2.f243e)) {
                xVar2.d();
            }
            this.f227g = xVar;
            RecyclerView recyclerView = this.b;
            recyclerView.f0.c();
            if (xVar.f246h) {
                StringBuilder h2 = f.a.a.a.a.h("An instance of ");
                h2.append(xVar.getClass().getSimpleName());
                h2.append(" was started more than once. Each instance of");
                h2.append(xVar.getClass().getSimpleName());
                h2.append(" is intended to only be used once. You should create a new instance for each use.");
                Log.w("RecyclerView", h2.toString());
            }
            xVar.b = recyclerView;
            xVar.c = this;
            int i2 = xVar.a;
            if (i2 != -1) {
                recyclerView.i0.a = i2;
                xVar.f243e = true;
                xVar.f242d = true;
                xVar.f244f = recyclerView.n.t(i2);
                xVar.b.f0.a();
                xVar.f246h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public boolean Z(View view, boolean z) {
            boolean z2 = this.f225e.b(view, 24579) && this.f226f.b(view, 24579);
            return z ? z2 : !z2;
        }

        public boolean Z0() {
            return false;
        }

        public void a0(View view, int i2, int i3, int i4, int i5) {
            n nVar = (n) view.getLayoutParams();
            Rect rect = nVar.b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) nVar).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) nVar).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) nVar).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) nVar).bottomMargin);
        }

        public void b(View view) {
            c(view, -1, false);
        }

        public void b0(int i2) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                int e2 = recyclerView.f200f.e();
                for (int i3 = 0; i3 < e2; i3++) {
                    recyclerView.f200f.d(i3).offsetLeftAndRight(i2);
                }
            }
        }

        public final void c(View view, int i2, boolean z) {
            b0 K = RecyclerView.K(view);
            if (z || K.m()) {
                this.b.f201g.a(K);
            } else {
                this.b.f201g.f(K);
            }
            n nVar = (n) view.getLayoutParams();
            if (K.v() || K.n()) {
                if (K.n()) {
                    K.n.k(K);
                } else {
                    K.d();
                }
                this.a.b(view, i2, view.getLayoutParams(), false);
            } else {
                int i3 = -1;
                if (view.getParent() == this.b) {
                    int j2 = this.a.j(view);
                    if (i2 == -1) {
                        i2 = this.a.e();
                    }
                    if (j2 == -1) {
                        StringBuilder h2 = f.a.a.a.a.h("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        h2.append(this.b.indexOfChild(view));
                        throw new IllegalStateException(f.a.a.a.a.m(this.b, h2));
                    } else if (j2 != i2) {
                        m mVar = this.b.n;
                        View x = mVar.x(j2);
                        if (x != null) {
                            mVar.x(j2);
                            mVar.r(j2);
                            n nVar2 = (n) x.getLayoutParams();
                            b0 K2 = RecyclerView.K(x);
                            if (K2.m()) {
                                mVar.b.f201g.a(K2);
                            } else {
                                mVar.b.f201g.f(K2);
                            }
                            mVar.a.b(x, i2, nVar2, K2.m());
                        } else {
                            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + j2 + mVar.b.toString());
                        }
                    }
                } else {
                    this.a.a(view, i2, false);
                    nVar.c = true;
                    x xVar = this.f227g;
                    if (xVar != null && xVar.f243e) {
                        Objects.requireNonNull(xVar.b);
                        b0 K3 = RecyclerView.K(view);
                        if (K3 != null) {
                            i3 = K3.f();
                        }
                        if (i3 == xVar.a) {
                            xVar.f244f = view;
                        }
                    }
                }
            }
            if (nVar.f234d) {
                K.a.invalidate();
                nVar.f234d = false;
            }
        }

        public void c0(int i2) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                int e2 = recyclerView.f200f.e();
                for (int i3 = 0; i3 < e2; i3++) {
                    recyclerView.f200f.d(i3).offsetTopAndBottom(i2);
                }
            }
        }

        public void d(String str) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.i(str);
            }
        }

        public void d0() {
        }

        public boolean e() {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/recyclerview/widget/RecyclerView;Ljava/util/ArrayList<Landroid/view/View;>;II)Z */
        public boolean e0() {
            return false;
        }

        public boolean f() {
            return false;
        }

        public void f0() {
        }

        public boolean g(n nVar) {
            return nVar != null;
        }

        @Deprecated
        public void g0() {
        }

        public void h0(RecyclerView recyclerView, t tVar) {
            g0();
        }

        public void i(int i2, int i3, y yVar, c cVar) {
        }

        public View i0(View view, int i2, t tVar, y yVar) {
            return null;
        }

        public void j(int i2, c cVar) {
        }

        public void j0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            t tVar = recyclerView.c;
            y yVar = recyclerView.i0;
            k0(accessibilityEvent);
        }

        public int k(y yVar) {
            return 0;
        }

        public void k0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                e eVar = this.b.m;
                if (eVar != null) {
                    accessibilityEvent.setItemCount(eVar.c());
                }
            }
        }

        public int l(y yVar) {
            return 0;
        }

        public void l0(t tVar, y yVar, e.i.i.w.b bVar) {
            if (this.b.canScrollVertically(-1) || this.b.canScrollHorizontally(-1)) {
                bVar.a.addAction(8192);
                bVar.a.setScrollable(true);
            }
            if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
                bVar.a.addAction(4096);
                bVar.a.setScrollable(true);
            }
            bVar.i(b.C0035b.a(T(tVar, yVar), A(tVar, yVar), X(), U()));
        }

        public int m(y yVar) {
            return 0;
        }

        public void m0(View view, e.i.i.w.b bVar) {
            b0 K = RecyclerView.K(view);
            if (K != null && !K.m() && !this.a.k(K.a)) {
                RecyclerView recyclerView = this.b;
                n0(recyclerView.c, recyclerView.i0, view, bVar);
            }
        }

        public int n(y yVar) {
            return 0;
        }

        public void n0(t tVar, y yVar, View view, e.i.i.w.b bVar) {
            bVar.j(b.c.a(f() ? R(view) : 0, 1, e() ? R(view) : 0, 1, false, false));
        }

        public int o(y yVar) {
            return 0;
        }

        public View o0() {
            return null;
        }

        public int p(y yVar) {
            return 0;
        }

        public void p0(RecyclerView recyclerView, int i2, int i3) {
        }

        public void q(t tVar) {
            int y = y();
            while (true) {
                y--;
                if (y >= 0) {
                    View x = x(y);
                    b0 K = RecyclerView.K(x);
                    if (!K.u()) {
                        if (!K.k() || K.m() || this.b.m.b) {
                            x(y);
                            r(y);
                            tVar.i(x);
                            this.b.f201g.f(K);
                        } else {
                            J0(y);
                            tVar.h(K);
                        }
                    }
                } else {
                    return;
                }
            }
        }

        public void q0(RecyclerView recyclerView) {
        }

        public final void r(int i2) {
            this.a.c(i2);
        }

        public void r0(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public View s(View view) {
            View C;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (C = recyclerView.C(view)) == null || this.a.c.contains(C)) {
                return null;
            }
            return C;
        }

        public void s0(RecyclerView recyclerView, int i2, int i3) {
        }

        public View t(int i2) {
            int y = y();
            for (int i3 = 0; i3 < y; i3++) {
                View x = x(i3);
                b0 K = RecyclerView.K(x);
                if (K != null && K.f() == i2 && !K.u() && (this.b.i0.f254g || !K.m())) {
                    return x;
                }
            }
            return null;
        }

        public void t0() {
        }

        public abstract n u();

        public void u0(RecyclerView recyclerView, int i2, int i3, Object obj) {
            t0();
        }

        public n v(Context context, AttributeSet attributeSet) {
            return new n(context, attributeSet);
        }

        public void v0(t tVar, y yVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public n w(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof n ? new n((n) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new n((ViewGroup.MarginLayoutParams) layoutParams) : new n(layoutParams);
        }

        public void w0(y yVar) {
        }

        public View x(int i2) {
            e.s.a.b bVar = this.a;
            if (bVar == null) {
                return null;
            }
            return ((e.s.a.s) bVar.a).a(bVar.f(i2));
        }

        public void x0(int i2, int i3) {
            this.b.o(i2, i3);
        }

        public int y() {
            e.s.a.b bVar = this.a;
            if (bVar != null) {
                return bVar.e();
            }
            return 0;
        }

        @Deprecated
        public boolean y0(RecyclerView recyclerView) {
            x xVar = this.f227g;
            if ((xVar != null && xVar.f243e) || recyclerView.O()) {
                return true;
            }
            return false;
        }

        public boolean z0(RecyclerView recyclerView, View view, View view2) {
            return y0(recyclerView);
        }
    }

    public static class n extends ViewGroup.MarginLayoutParams {
        public b0 a;
        public final Rect b = new Rect();
        public boolean c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f234d = false;

        public n(int i2, int i3) {
            super(i2, i3);
        }

        public n(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public n(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public n(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public n(n nVar) {
            super((ViewGroup.LayoutParams) nVar);
        }

        public int a() {
            return this.a.f();
        }

        public boolean b() {
            return this.a.p();
        }

        public boolean c() {
            return this.a.m();
        }
    }

    public interface o {
        void a(View view);

        void b(View view);
    }

    public static abstract class p {
    }

    public interface q {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z);
    }

    public static abstract class r {
        public void a(RecyclerView recyclerView, int i2) {
        }

        public void b(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public static class s {
        public SparseArray<a> a = new SparseArray<>();
        public int b = 0;

        public static class a {
            public final ArrayList<b0> a = new ArrayList<>();
            public int b = 5;
            public long c = 0;

            /* renamed from: d  reason: collision with root package name */
            public long f235d = 0;
        }

        public final a a(int i2) {
            a aVar = this.a.get(i2);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.a.put(i2, aVar2);
            return aVar2;
        }

        public long b(long j2, long j3) {
            if (j2 == 0) {
                return j3;
            }
            return (j3 / 4) + ((j2 / 4) * 3);
        }
    }

    public final class t {
        public final ArrayList<b0> a;
        public ArrayList<b0> b = null;
        public final ArrayList<b0> c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final List<b0> f236d;

        /* renamed from: e  reason: collision with root package name */
        public int f237e;

        /* renamed from: f  reason: collision with root package name */
        public int f238f;

        /* renamed from: g  reason: collision with root package name */
        public s f239g;

        public t() {
            ArrayList<b0> arrayList = new ArrayList<>();
            this.a = arrayList;
            this.f236d = Collections.unmodifiableList(arrayList);
            this.f237e = 2;
            this.f238f = 2;
        }

        public void a(b0 b0Var, boolean z) {
            RecyclerView.k(b0Var);
            View view = b0Var.a;
            e.s.a.u uVar = RecyclerView.this.p0;
            if (uVar != null) {
                u.a aVar = uVar.f1825e;
                e.i.i.l.r(view, aVar instanceof u.a ? aVar.f1827e.remove(view) : null);
            }
            if (z) {
                u uVar2 = RecyclerView.this.o;
                if (uVar2 != null) {
                    uVar2.a(b0Var);
                }
                e eVar = RecyclerView.this.m;
                if (eVar != null) {
                    eVar.n(b0Var);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.i0 != null) {
                    recyclerView.f201g.g(b0Var);
                }
            }
            b0Var.r = null;
            s d2 = d();
            Objects.requireNonNull(d2);
            int i2 = b0Var.f214f;
            ArrayList<b0> arrayList = d2.a(i2).a;
            if (d2.a.get(i2).b > arrayList.size()) {
                b0Var.r();
                arrayList.add(b0Var);
            }
        }

        public void b() {
            this.a.clear();
            e();
        }

        public int c(int i2) {
            if (i2 < 0 || i2 >= RecyclerView.this.i0.b()) {
                StringBuilder sb = new StringBuilder();
                sb.append("invalid position ");
                sb.append(i2);
                sb.append(". State item count is ");
                sb.append(RecyclerView.this.i0.b());
                throw new IndexOutOfBoundsException(f.a.a.a.a.m(RecyclerView.this, sb));
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.i0.f254g) {
                return i2;
            }
            return recyclerView.f199e.f(i2, 0);
        }

        public s d() {
            if (this.f239g == null) {
                this.f239g = new s();
            }
            return this.f239g;
        }

        public void e() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                f(size);
            }
            this.c.clear();
            if (RecyclerView.C0) {
                j.b bVar = RecyclerView.this.h0;
                int[] iArr = bVar.c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                bVar.f1807d = 0;
            }
        }

        public void f(int i2) {
            a(this.c.get(i2), true);
            this.c.remove(i2);
        }

        public void g(View view) {
            b0 K = RecyclerView.K(view);
            if (K.o()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (K.n()) {
                K.n.k(K);
            } else if (K.v()) {
                K.d();
            }
            h(K);
            if (RecyclerView.this.N != null && !K.l()) {
                RecyclerView.this.N.i(K);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:45:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00aa A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:64:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        public void h(b0 b0Var) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (b0Var.n() || b0Var.a.getParent() != null) {
                StringBuilder h2 = f.a.a.a.a.h("Scrapped or attached views may not be recycled. isScrap:");
                h2.append(b0Var.n());
                h2.append(" isAttached:");
                if (b0Var.a.getParent() != null) {
                    z2 = true;
                }
                h2.append(z2);
                throw new IllegalArgumentException(f.a.a.a.a.m(RecyclerView.this, h2));
            } else if (b0Var.o()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(b0Var);
                throw new IllegalArgumentException(f.a.a.a.a.m(RecyclerView.this, sb));
            } else if (!b0Var.u()) {
                if ((b0Var.f218j & 16) == 0) {
                    View view = b0Var.a;
                    AtomicInteger atomicInteger = e.i.i.l.a;
                    if (view.hasTransientState()) {
                        z = true;
                        e eVar = RecyclerView.this.m;
                        if ((eVar == null && z && eVar.k(b0Var)) || b0Var.l()) {
                            if (this.f238f > 0 || b0Var.h(526)) {
                                z2 = false;
                            } else {
                                int size = this.c.size();
                                if (size >= this.f238f && size > 0) {
                                    f(0);
                                    size--;
                                }
                                if (RecyclerView.C0 && size > 0 && !RecyclerView.this.h0.c(b0Var.c)) {
                                    do {
                                        size--;
                                        if (size < 0) {
                                            break;
                                        }
                                    } while (RecyclerView.this.h0.c(this.c.get(size).c));
                                    size++;
                                }
                                this.c.add(size, b0Var);
                                z2 = true;
                            }
                            if (!z2) {
                                a(b0Var, true);
                                RecyclerView.this.f201g.g(b0Var);
                                if (z2 && !z3 && z) {
                                    b0Var.r = null;
                                    return;
                                }
                                return;
                            }
                        }
                        z3 = false;
                        RecyclerView.this.f201g.g(b0Var);
                        if (z2) {
                            return;
                        }
                        return;
                    }
                }
                z = false;
                e eVar2 = RecyclerView.this.m;
                if (this.f238f > 0) {
                }
                z2 = false;
                if (!z2) {
                }
                z3 = false;
                RecyclerView.this.f201g.g(b0Var);
                if (z2) {
                }
            } else {
                throw new IllegalArgumentException(f.a.a.a.a.m(RecyclerView.this, f.a.a.a.a.h("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
            }
        }

        public void i(View view) {
            ArrayList<b0> arrayList;
            b0 K = RecyclerView.K(view);
            if (!K.h(12) && K.p()) {
                j jVar = RecyclerView.this.N;
                if (!(jVar == null || jVar.f(K, K.g()))) {
                    if (this.b == null) {
                        this.b = new ArrayList<>();
                    }
                    K.n = this;
                    K.o = true;
                    arrayList = this.b;
                    arrayList.add(K);
                    return;
                }
            }
            if (!K.k() || K.m() || RecyclerView.this.m.b) {
                K.n = this;
                K.o = false;
                arrayList = this.a;
                arrayList.add(K);
                return;
            }
            throw new IllegalArgumentException(f.a.a.a.a.m(RecyclerView.this, f.a.a.a.a.h("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:160:0x02ff, code lost:
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:228:0x044e, code lost:
            if (r7.k() == false) goto L_0x0484;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:237:0x0482, code lost:
            if ((r10 == 0 || r10 + r8 < r20) == false) goto L_0x0484;
         */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x024b  */
        /* JADX WARNING: Removed duplicated region for block: B:214:0x0416  */
        /* JADX WARNING: Removed duplicated region for block: B:222:0x0440  */
        /* JADX WARNING: Removed duplicated region for block: B:231:0x046b  */
        /* JADX WARNING: Removed duplicated region for block: B:241:0x0494  */
        /* JADX WARNING: Removed duplicated region for block: B:244:0x04b2  */
        /* JADX WARNING: Removed duplicated region for block: B:247:0x04c5  */
        /* JADX WARNING: Removed duplicated region for block: B:255:0x04f5  */
        /* JADX WARNING: Removed duplicated region for block: B:269:0x052b  */
        /* JADX WARNING: Removed duplicated region for block: B:273:0x0536  */
        /* JADX WARNING: Removed duplicated region for block: B:274:0x053d  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0090  */
        public b0 j(int i2, boolean z, long j2) {
            b0 b0Var;
            boolean z2;
            boolean z3;
            ViewGroup.LayoutParams layoutParams;
            n nVar;
            ViewGroup.LayoutParams layoutParams2;
            e eVar;
            List<Object> list;
            ViewGroup.LayoutParams layoutParams3;
            AccessibilityManager accessibilityManager;
            RecyclerView F;
            b0 b0Var2;
            b0 b0Var3;
            View view;
            boolean z4;
            int size;
            int f2;
            if (i2 < 0 || i2 >= RecyclerView.this.i0.b()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid item position ");
                sb.append(i2);
                sb.append("(");
                sb.append(i2);
                sb.append("). Item count:");
                sb.append(RecyclerView.this.i0.b());
                throw new IndexOutOfBoundsException(f.a.a.a.a.m(RecyclerView.this, sb));
            }
            boolean z5 = false;
            if (RecyclerView.this.i0.f254g) {
                ArrayList<b0> arrayList = this.b;
                if (arrayList != null && (size = arrayList.size()) != 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            b0Var = this.b.get(i3);
                            if (!b0Var.v() && b0Var.f() == i2) {
                                b0Var.b(32);
                                break;
                            }
                            i3++;
                        } else {
                            RecyclerView recyclerView = RecyclerView.this;
                            if (recyclerView.m.b && (f2 = recyclerView.f199e.f(i2, 0)) > 0 && f2 < RecyclerView.this.m.c()) {
                                long d2 = RecyclerView.this.m.d(f2);
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= size) {
                                        break;
                                    }
                                    b0 b0Var4 = this.b.get(i4);
                                    if (!b0Var4.v() && b0Var4.f213e == d2) {
                                        b0Var4.b(32);
                                        b0Var = b0Var4;
                                        break;
                                    }
                                    i4++;
                                }
                            }
                        }
                    }
                    if (b0Var != null) {
                        z2 = true;
                        if (b0Var == null) {
                            int size2 = this.a.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 < size2) {
                                    b0Var3 = this.a.get(i5);
                                    if (b0Var3.v() || b0Var3.f() != i2 || b0Var3.k() || (!RecyclerView.this.i0.f254g && b0Var3.m())) {
                                        i5++;
                                    }
                                } else {
                                    if (!z) {
                                        e.s.a.b bVar = RecyclerView.this.f200f;
                                        int size3 = bVar.c.size();
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 >= size3) {
                                                view = null;
                                                break;
                                            }
                                            view = bVar.c.get(i6);
                                            Objects.requireNonNull((e.s.a.s) bVar.a);
                                            b0 K = RecyclerView.K(view);
                                            if (!(K.f() != i2 || K.k() || K.m())) {
                                                break;
                                            }
                                            i6++;
                                        }
                                        if (view != null) {
                                            b0Var = RecyclerView.K(view);
                                            e.s.a.b bVar2 = RecyclerView.this.f200f;
                                            int indexOfChild = ((e.s.a.s) bVar2.a).a.indexOfChild(view);
                                            if (indexOfChild < 0) {
                                                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                                            } else if (bVar2.b.d(indexOfChild)) {
                                                bVar2.b.a(indexOfChild);
                                                bVar2.l(view);
                                                int j3 = RecyclerView.this.f200f.j(view);
                                                if (j3 != -1) {
                                                    RecyclerView.this.f200f.c(j3);
                                                    i(view);
                                                    b0Var.b(8224);
                                                } else {
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("layout index should not be -1 after unhiding a view:");
                                                    sb2.append(b0Var);
                                                    throw new IllegalStateException(f.a.a.a.a.m(RecyclerView.this, sb2));
                                                }
                                            } else {
                                                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                                            }
                                        }
                                    }
                                    int size4 = this.c.size();
                                    for (int i7 = 0; i7 < size4; i7++) {
                                        b0Var3 = this.c.get(i7);
                                        if (!b0Var3.k() && b0Var3.f() == i2 && !b0Var3.i()) {
                                            if (!z) {
                                                this.c.remove(i7);
                                            }
                                        }
                                    }
                                    b0Var = null;
                                }
                            }
                            b0Var3.b(32);
                            b0Var = b0Var3;
                            if (b0Var != null) {
                                if (b0Var.m()) {
                                    z4 = RecyclerView.this.i0.f254g;
                                } else {
                                    int i8 = b0Var.c;
                                    if (i8 < 0 || i8 >= RecyclerView.this.m.c()) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Inconsistency detected. Invalid view holder adapter position");
                                        sb3.append(b0Var);
                                        throw new IndexOutOfBoundsException(f.a.a.a.a.m(RecyclerView.this, sb3));
                                    }
                                    RecyclerView recyclerView2 = RecyclerView.this;
                                    if (recyclerView2.i0.f254g || recyclerView2.m.e(b0Var.c) == b0Var.f214f) {
                                        e eVar2 = RecyclerView.this.m;
                                        if (!eVar2.b || b0Var.f213e == eVar2.d(b0Var.c)) {
                                            z4 = true;
                                        }
                                    }
                                    z4 = false;
                                }
                                if (!z4) {
                                    if (!z) {
                                        b0Var.b(4);
                                        if (b0Var.n()) {
                                            RecyclerView.this.removeDetachedView(b0Var.a, false);
                                            b0Var.n.k(b0Var);
                                        } else if (b0Var.v()) {
                                            b0Var.d();
                                        }
                                        h(b0Var);
                                    }
                                    b0Var = null;
                                } else {
                                    z2 = true;
                                }
                            }
                        }
                        if (b0Var == null) {
                            int f3 = RecyclerView.this.f199e.f(i2, 0);
                            if (f3 < 0 || f3 >= RecyclerView.this.m.c()) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Inconsistency detected. Invalid item position ");
                                sb4.append(i2);
                                sb4.append("(offset:");
                                sb4.append(f3);
                                sb4.append(").state:");
                                sb4.append(RecyclerView.this.i0.b());
                                throw new IndexOutOfBoundsException(f.a.a.a.a.m(RecyclerView.this, sb4));
                            }
                            int e2 = RecyclerView.this.m.e(f3);
                            e eVar3 = RecyclerView.this.m;
                            if (eVar3.b) {
                                long d3 = eVar3.d(f3);
                                int size5 = this.a.size() - 1;
                                while (true) {
                                    if (size5 < 0) {
                                        int size6 = this.c.size() - 1;
                                        while (true) {
                                            if (size6 < 0) {
                                                break;
                                            }
                                            b0Var = this.c.get(size6);
                                            if (b0Var.f213e == d3 && !b0Var.i()) {
                                                if (e2 == b0Var.f214f) {
                                                    if (!z) {
                                                        this.c.remove(size6);
                                                    }
                                                } else if (!z) {
                                                    f(size6);
                                                    break;
                                                }
                                            }
                                            size6--;
                                        }
                                    } else {
                                        b0 b0Var5 = this.a.get(size5);
                                        if (b0Var5.f213e == d3 && !b0Var5.v()) {
                                            if (e2 == b0Var5.f214f) {
                                                b0Var5.b(32);
                                                if (b0Var5.m() && !RecyclerView.this.i0.f254g) {
                                                    b0Var5.s(2, 14);
                                                }
                                                b0Var = b0Var5;
                                            } else if (!z) {
                                                this.a.remove(size5);
                                                RecyclerView.this.removeDetachedView(b0Var5.a, false);
                                                b0 K2 = RecyclerView.K(b0Var5.a);
                                                K2.n = null;
                                                K2.o = false;
                                                K2.d();
                                                h(K2);
                                            }
                                        }
                                        size5--;
                                    }
                                }
                                if (b0Var != null) {
                                    b0Var.c = f3;
                                    z2 = true;
                                }
                            }
                            if (b0Var == null) {
                                s.a aVar = d().a.get(e2);
                                if (aVar != null && !aVar.a.isEmpty()) {
                                    ArrayList<b0> arrayList2 = aVar.a;
                                    int size7 = arrayList2.size() - 1;
                                    while (true) {
                                        if (size7 < 0) {
                                            break;
                                        } else if (!arrayList2.get(size7).i()) {
                                            b0Var2 = arrayList2.remove(size7);
                                            break;
                                        } else {
                                            size7--;
                                        }
                                    }
                                }
                                b0Var2 = null;
                                if (b0Var2 != null) {
                                    b0Var2.r();
                                    int[] iArr = RecyclerView.z0;
                                }
                                b0Var = b0Var2;
                            }
                            if (b0Var == null) {
                                long nanoTime = RecyclerView.this.getNanoTime();
                                if (j2 != Long.MAX_VALUE) {
                                    long j4 = this.f239g.a(e2).c;
                                    if (!(j4 == 0 || j4 + nanoTime < j2)) {
                                        return null;
                                    }
                                }
                                RecyclerView recyclerView3 = RecyclerView.this;
                                e eVar4 = recyclerView3.m;
                                Objects.requireNonNull(eVar4);
                                try {
                                    int i9 = e.i.e.f.a;
                                    Trace.beginSection("RV CreateView");
                                    b0 i10 = eVar4.i(recyclerView3, e2);
                                    if (i10.a.getParent() == null) {
                                        i10.f214f = e2;
                                        Trace.endSection();
                                        if (RecyclerView.C0 && (F = RecyclerView.F(i10.a)) != null) {
                                            i10.b = new WeakReference<>(F);
                                        }
                                        long nanoTime2 = RecyclerView.this.getNanoTime();
                                        s sVar = this.f239g;
                                        long j5 = nanoTime2 - nanoTime;
                                        s.a a2 = sVar.a(e2);
                                        a2.c = sVar.b(a2.c, j5);
                                        b0Var = i10;
                                    } else {
                                        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                                    }
                                } catch (Throwable th) {
                                    int i11 = e.i.e.f.a;
                                    Trace.endSection();
                                    throw th;
                                }
                            }
                        }
                        if (z2 && !RecyclerView.this.i0.f254g && b0Var.h(8192)) {
                            b0Var.s(0, 8192);
                            if (RecyclerView.this.i0.f257j) {
                                j.e(b0Var);
                                j jVar = RecyclerView.this.N;
                                b0Var.g();
                                RecyclerView.this.c0(b0Var, jVar.l(b0Var));
                            }
                        }
                        if (RecyclerView.this.i0.f254g || !b0Var.j()) {
                            if (b0Var.j()) {
                                if (!((b0Var.f218j & 2) != 0)) {
                                }
                            }
                            int f4 = RecyclerView.this.f199e.f(i2, 0);
                            RecyclerView recyclerView4 = RecyclerView.this;
                            b0Var.r = recyclerView4;
                            int i12 = b0Var.f214f;
                            long nanoTime3 = recyclerView4.getNanoTime();
                            if (j2 != Long.MAX_VALUE) {
                                long j6 = this.f239g.a(i12).f235d;
                            }
                            eVar = RecyclerView.this.m;
                            Objects.requireNonNull(eVar);
                            b0Var.c = f4;
                            if (eVar.b) {
                                b0Var.f213e = eVar.d(f4);
                            }
                            b0Var.s(1, 519);
                            int i13 = e.i.e.f.a;
                            Trace.beginSection("RV OnBindView");
                            eVar.h(b0Var, f4, b0Var.g());
                            list = b0Var.f219k;
                            if (list != null) {
                                list.clear();
                            }
                            b0Var.f218j &= -1025;
                            layoutParams3 = b0Var.a.getLayoutParams();
                            if (layoutParams3 instanceof n) {
                                ((n) layoutParams3).c = true;
                            }
                            Trace.endSection();
                            long nanoTime4 = RecyclerView.this.getNanoTime();
                            s sVar2 = this.f239g;
                            long j7 = nanoTime4 - nanoTime3;
                            s.a a3 = sVar2.a(b0Var.f214f);
                            a3.f235d = sVar2.b(a3.f235d, j7);
                            accessibilityManager = RecyclerView.this.C;
                            if (accessibilityManager == null && accessibilityManager.isEnabled()) {
                                View view2 = b0Var.a;
                                AtomicInteger atomicInteger = e.i.i.l.a;
                                if (view2.getImportantForAccessibility() == 0) {
                                    view2.setImportantForAccessibility(1);
                                }
                                e.s.a.u uVar = RecyclerView.this.p0;
                                if (uVar != null) {
                                    u.a aVar2 = uVar.f1825e;
                                    if (aVar2 instanceof u.a) {
                                        Objects.requireNonNull(aVar2);
                                        e.i.i.a f5 = e.i.i.l.f(view2);
                                        if (!(f5 == null || f5 == aVar2)) {
                                            aVar2.f1827e.put(view2, f5);
                                        }
                                    }
                                    e.i.i.l.r(view2, aVar2);
                                }
                            }
                            if (RecyclerView.this.i0.f254g) {
                                b0Var.f215g = i2;
                            }
                            z3 = true;
                            layoutParams = b0Var.a.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams2 = RecyclerView.this.generateDefaultLayoutParams();
                            } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                layoutParams2 = RecyclerView.this.generateLayoutParams(layoutParams);
                            } else {
                                nVar = (n) layoutParams;
                                nVar.a = b0Var;
                                if (z2 && z3) {
                                    z5 = true;
                                }
                                nVar.f234d = z5;
                                return b0Var;
                            }
                            nVar = (n) layoutParams2;
                            b0Var.a.setLayoutParams(nVar);
                            nVar.a = b0Var;
                            z5 = true;
                            nVar.f234d = z5;
                            return b0Var;
                        }
                        b0Var.f215g = i2;
                        z3 = false;
                        layoutParams = b0Var.a.getLayoutParams();
                        if (layoutParams == null) {
                        }
                        nVar = (n) layoutParams2;
                        b0Var.a.setLayoutParams(nVar);
                        nVar.a = b0Var;
                        z5 = true;
                        nVar.f234d = z5;
                        return b0Var;
                    }
                }
                b0Var = null;
                if (b0Var != null) {
                }
            } else {
                b0Var = null;
            }
            z2 = false;
            if (b0Var == null) {
            }
            if (b0Var == null) {
            }
            b0Var.s(0, 8192);
            if (RecyclerView.this.i0.f257j) {
            }
            if (RecyclerView.this.i0.f254g) {
            }
            if (b0Var.j()) {
            }
            int f42 = RecyclerView.this.f199e.f(i2, 0);
            RecyclerView recyclerView42 = RecyclerView.this;
            b0Var.r = recyclerView42;
            int i122 = b0Var.f214f;
            long nanoTime32 = recyclerView42.getNanoTime();
            if (j2 != Long.MAX_VALUE) {
            }
            eVar = RecyclerView.this.m;
            Objects.requireNonNull(eVar);
            b0Var.c = f42;
            if (eVar.b) {
            }
            b0Var.s(1, 519);
            int i132 = e.i.e.f.a;
            Trace.beginSection("RV OnBindView");
            eVar.h(b0Var, f42, b0Var.g());
            list = b0Var.f219k;
            if (list != null) {
            }
            b0Var.f218j &= -1025;
            layoutParams3 = b0Var.a.getLayoutParams();
            if (layoutParams3 instanceof n) {
            }
            Trace.endSection();
            long nanoTime42 = RecyclerView.this.getNanoTime();
            s sVar22 = this.f239g;
            long j72 = nanoTime42 - nanoTime32;
            s.a a32 = sVar22.a(b0Var.f214f);
            a32.f235d = sVar22.b(a32.f235d, j72);
            accessibilityManager = RecyclerView.this.C;
            if (accessibilityManager == null && accessibilityManager.isEnabled()) {
            }
            if (RecyclerView.this.i0.f254g) {
            }
            z3 = true;
            layoutParams = b0Var.a.getLayoutParams();
            if (layoutParams == null) {
            }
            nVar = (n) layoutParams2;
            b0Var.a.setLayoutParams(nVar);
            nVar.a = b0Var;
            z5 = true;
            nVar.f234d = z5;
            return b0Var;
        }

        public void k(b0 b0Var) {
            (b0Var.o ? this.b : this.a).remove(b0Var);
            b0Var.n = null;
            b0Var.o = false;
            b0Var.d();
        }

        public void l() {
            m mVar = RecyclerView.this.n;
            this.f238f = this.f237e + (mVar != null ? mVar.f232l : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f238f; size--) {
                f(size);
            }
        }
    }

    public interface u {
        void a(b0 b0Var);
    }

    public class v extends g {
        public v() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void a() {
            RecyclerView.this.i(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.i0.f253f = true;
            recyclerView.b0(true);
            if (!RecyclerView.this.f199e.g()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void c(int i2, int i3, Object obj) {
            RecyclerView.this.i(null);
            e.s.a.a aVar = RecyclerView.this.f199e;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i3 >= 1) {
                aVar.b.add(aVar.h(4, i2, i3, obj));
                aVar.f1775f |= 4;
                if (aVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void d(int i2, int i3) {
            RecyclerView.this.i(null);
            e.s.a.a aVar = RecyclerView.this.f199e;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i3 >= 1) {
                aVar.b.add(aVar.h(1, i2, i3, null));
                aVar.f1775f |= 1;
                if (aVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void e(int i2, int i3) {
            RecyclerView.this.i(null);
            e.s.a.a aVar = RecyclerView.this.f199e;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i3 >= 1) {
                aVar.b.add(aVar.h(2, i2, i3, null));
                aVar.f1775f |= 2;
                if (aVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                f();
            }
        }

        public void f() {
            if (RecyclerView.B0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.t && recyclerView.s) {
                    Runnable runnable = recyclerView.f203i;
                    AtomicInteger atomicInteger = e.i.i.l.a;
                    recyclerView.postOnAnimation(runnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.B = true;
            recyclerView2.requestLayout();
        }
    }

    public static class w extends e.k.a.a {
        public static final Parcelable.Creator<w> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public Parcelable f241d;

        public static class a implements Parcelable.ClassLoaderCreator<w> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new w(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new w[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public w createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new w(parcel, classLoader);
            }
        }

        public w(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f241d = parcel.readParcelable(classLoader == null ? m.class.getClassLoader() : classLoader);
        }

        public w(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeParcelable(this.f241d, 0);
        }
    }

    public static abstract class x {
        public int a = -1;
        public RecyclerView b;
        public m c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f242d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f243e;

        /* renamed from: f  reason: collision with root package name */
        public View f244f;

        /* renamed from: g  reason: collision with root package name */
        public final a f245g = new a(0, 0);

        /* renamed from: h  reason: collision with root package name */
        public boolean f246h;

        public static class a {
            public int a;
            public int b;
            public int c;

            /* renamed from: d  reason: collision with root package name */
            public int f247d = -1;

            /* renamed from: e  reason: collision with root package name */
            public Interpolator f248e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f249f = false;

            /* renamed from: g  reason: collision with root package name */
            public int f250g = 0;

            public a(int i2, int i3) {
                this.a = i2;
                this.b = i3;
                this.c = Integer.MIN_VALUE;
                this.f248e = null;
            }

            public void a(RecyclerView recyclerView) {
                int i2 = this.f247d;
                if (i2 >= 0) {
                    this.f247d = -1;
                    recyclerView.P(i2);
                    this.f249f = false;
                } else if (this.f249f) {
                    Interpolator interpolator = this.f248e;
                    if (interpolator == null || this.c >= 1) {
                        int i3 = this.c;
                        if (i3 >= 1) {
                            recyclerView.f0.b(this.a, this.b, i3, interpolator);
                            int i4 = this.f250g + 1;
                            this.f250g = i4;
                            if (i4 > 10) {
                                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                            }
                            this.f249f = false;
                            return;
                        }
                        throw new IllegalStateException("Scroll duration must be a positive number");
                    }
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else {
                    this.f250g = 0;
                }
            }

            public void b(int i2, int i3, int i4, Interpolator interpolator) {
                this.a = i2;
                this.b = i3;
                this.c = i4;
                this.f248e = interpolator;
                this.f249f = true;
            }
        }

        public interface b {
            PointF a(int i2);
        }

        public PointF a(int i2) {
            m mVar = this.c;
            if (mVar instanceof b) {
                return ((b) mVar).a(i2);
            }
            StringBuilder h2 = f.a.a.a.a.h("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            h2.append(b.class.getCanonicalName());
            Log.w("RecyclerView", h2.toString());
            return null;
        }

        public void b(int i2, int i3) {
            PointF a2;
            RecyclerView recyclerView = this.b;
            int i4 = -1;
            if (this.a == -1 || recyclerView == null) {
                d();
            }
            if (this.f242d && this.f244f == null && this.c != null && (a2 = a(this.a)) != null) {
                float f2 = a2.x;
                if (!(f2 == 0.0f && a2.y == 0.0f)) {
                    recyclerView.h0((int) Math.signum(f2), (int) Math.signum(a2.y), null);
                }
            }
            boolean z = false;
            this.f242d = false;
            View view = this.f244f;
            if (view != null) {
                Objects.requireNonNull(this.b);
                b0 K = RecyclerView.K(view);
                if (K != null) {
                    i4 = K.f();
                }
                if (i4 == this.a) {
                    c(this.f244f, recyclerView.i0, this.f245g);
                    this.f245g.a(recyclerView);
                    d();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f244f = null;
                }
            }
            if (this.f243e) {
                y yVar = recyclerView.i0;
                a aVar = this.f245g;
                e.s.a.l lVar = (e.s.a.l) this;
                if (lVar.b.n.y() == 0) {
                    lVar.d();
                } else {
                    int i5 = lVar.o;
                    int i6 = i5 - i2;
                    if (i5 * i6 <= 0) {
                        i6 = 0;
                    }
                    lVar.o = i6;
                    int i7 = lVar.p;
                    int i8 = i7 - i3;
                    if (i7 * i8 <= 0) {
                        i8 = 0;
                    }
                    lVar.p = i8;
                    if (i6 == 0 && i8 == 0) {
                        PointF a3 = lVar.a(lVar.a);
                        if (a3 != null) {
                            float f3 = a3.x;
                            if (!(f3 == 0.0f && a3.y == 0.0f)) {
                                float f4 = a3.y;
                                float sqrt = (float) Math.sqrt((double) ((f4 * f4) + (f3 * f3)));
                                float f5 = a3.x / sqrt;
                                a3.x = f5;
                                float f6 = a3.y / sqrt;
                                a3.y = f6;
                                lVar.f1818k = a3;
                                lVar.o = (int) (f5 * 10000.0f);
                                lVar.p = (int) (f6 * 10000.0f);
                                aVar.b((int) (((float) lVar.o) * 1.2f), (int) (((float) lVar.p) * 1.2f), (int) (((float) lVar.h(10000)) * 1.2f), lVar.f1816i);
                            }
                        }
                        aVar.f247d = lVar.a;
                        lVar.d();
                    }
                }
                a aVar2 = this.f245g;
                if (aVar2.f247d >= 0) {
                    z = true;
                }
                aVar2.a(recyclerView);
                if (z && this.f243e) {
                    this.f242d = true;
                    recyclerView.f0.a();
                }
            }
        }

        public abstract void c(View view, y yVar, a aVar);

        public final void d() {
            if (this.f243e) {
                this.f243e = false;
                e.s.a.l lVar = (e.s.a.l) this;
                lVar.p = 0;
                lVar.o = 0;
                lVar.f1818k = null;
                this.b.i0.a = -1;
                this.f244f = null;
                this.a = -1;
                this.f242d = false;
                m mVar = this.c;
                if (mVar.f227g == this) {
                    mVar.f227g = null;
                }
                this.c = null;
                this.b = null;
            }
        }
    }

    public static class y {
        public int a = -1;
        public int b = 0;
        public int c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f251d = 1;

        /* renamed from: e  reason: collision with root package name */
        public int f252e = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f253f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f254g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f255h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f256i = false;

        /* renamed from: j  reason: collision with root package name */
        public boolean f257j = false;

        /* renamed from: k  reason: collision with root package name */
        public boolean f258k = false;

        /* renamed from: l  reason: collision with root package name */
        public int f259l;
        public long m;
        public int n;

        public void a(int i2) {
            if ((this.f251d & i2) == 0) {
                StringBuilder h2 = f.a.a.a.a.h("Layout state should be one of ");
                h2.append(Integer.toBinaryString(i2));
                h2.append(" but it is ");
                h2.append(Integer.toBinaryString(this.f251d));
                throw new IllegalStateException(h2.toString());
            }
        }

        public int b() {
            return this.f254g ? this.b - this.c : this.f252e;
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("State{mTargetPosition=");
            h2.append(this.a);
            h2.append(", mData=");
            h2.append((Object) null);
            h2.append(", mItemCount=");
            h2.append(this.f252e);
            h2.append(", mIsMeasuring=");
            h2.append(this.f256i);
            h2.append(", mPreviousLayoutItemCount=");
            h2.append(this.b);
            h2.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            h2.append(this.c);
            h2.append(", mStructureChanged=");
            h2.append(this.f253f);
            h2.append(", mInPreLayout=");
            h2.append(this.f254g);
            h2.append(", mRunSimpleAnimations=");
            h2.append(this.f257j);
            h2.append(", mRunPredictiveAnimations=");
            h2.append(this.f258k);
            h2.append('}');
            return h2.toString();
        }
    }

    public static abstract class z {
    }

    static {
        Class<?> cls = Integer.TYPE;
        D0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.recyclerViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        char c2;
        StringBuilder sb;
        Constructor<? extends U> constructor;
        int i3 = Build.VERSION.SDK_INT;
        this.b = new v();
        this.c = new t();
        this.f201g = new e.s.a.y();
        this.f203i = new a();
        this.f204j = new Rect();
        this.f205k = new Rect();
        this.f206l = new RectF();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.w = 0;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.I = new i();
        this.N = new e.s.a.c();
        this.O = 0;
        this.P = -1;
        this.c0 = Float.MIN_VALUE;
        this.d0 = Float.MIN_VALUE;
        this.e0 = true;
        this.f0 = new a0();
        Object[] objArr = null;
        this.h0 = C0 ? new j.b() : null;
        this.i0 = new y();
        this.l0 = false;
        this.m0 = false;
        this.n0 = new k();
        this.o0 = false;
        this.r0 = new int[2];
        this.t0 = new int[2];
        this.u0 = new int[2];
        this.v0 = new int[2];
        this.w0 = new ArrayList();
        this.x0 = new b();
        this.y0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.V = viewConfiguration.getScaledTouchSlop();
        Method method = e.i.i.q.a;
        this.c0 = i3 >= 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : e.i.i.q.a(viewConfiguration, context);
        this.d0 = i3 >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : e.i.i.q.a(viewConfiguration, context);
        this.a0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.N.a = this.n0;
        this.f199e = new e.s.a.a(new e.s.a.t(this));
        this.f200f = new e.s.a.b(new e.s.a.s(this));
        AtomicInteger atomicInteger = e.i.i.l.a;
        if ((i3 >= 26 ? getImportantForAutofill() : 0) == 0 && i3 >= 26) {
            setImportantForAutofill(8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new e.s.a.u(this));
        int[] iArr = R$styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (i3 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(R$styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f202h = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
        this.u = z2;
        if (z2) {
            StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(f.a.a.a.a.m(this, f.a.a.a.a.h("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            c2 = 2;
            new e.s.a.i(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
        } else {
            c2 = 2;
        }
        obtainStyledAttributes.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    sb = new StringBuilder();
                    sb.append(context.getPackageName());
                    sb.append(trim);
                    trim = sb.toString();
                } else if (!trim.contains(".")) {
                    sb = new StringBuilder();
                    sb.append(RecyclerView.class.getPackage().getName());
                    sb.append('.');
                    sb.append(trim);
                    trim = sb.toString();
                }
                try {
                    Class<? extends U> asSubclass = Class.forName(trim, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(m.class);
                    try {
                        constructor = asSubclass.getConstructor(D0);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = context;
                        objArr2[1] = attributeSet;
                        objArr2[c2] = Integer.valueOf(i2);
                        objArr2[3] = 0;
                        objArr = objArr2;
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + trim, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((m) constructor.newInstance(objArr));
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + trim, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + trim, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + trim, e8);
                }
            }
        }
        int[] iArr2 = z0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
        if (i3 >= 29) {
            saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes2, i2, 0);
        }
        boolean z3 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    public static RecyclerView F(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView F2 = F(viewGroup.getChildAt(i2));
            if (F2 != null) {
                return F2;
            }
        }
        return null;
    }

    public static b0 K(View view) {
        if (view == null) {
            return null;
        }
        return ((n) view.getLayoutParams()).a;
    }

    private e.i.i.f getScrollingChildHelper() {
        if (this.s0 == null) {
            this.s0 = new e.i.i.f(this);
        }
        return this.s0;
    }

    public static void k(b0 b0Var) {
        WeakReference<RecyclerView> weakReference = b0Var.b;
        if (weakReference != null) {
            ViewParent viewParent = weakReference.get();
            while (true) {
                View view = (View) viewParent;
                while (true) {
                    if (view == null) {
                        b0Var.b = null;
                        return;
                    } else if (view != b0Var.a) {
                        viewParent = view.getParent();
                        if (!(viewParent instanceof View)) {
                            view = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public String A() {
        StringBuilder h2 = f.a.a.a.a.h(" ");
        h2.append(super.toString());
        h2.append(", adapter:");
        h2.append(this.m);
        h2.append(", layout:");
        h2.append(this.n);
        h2.append(", context:");
        h2.append(getContext());
        return h2.toString();
    }

    public final void B(y yVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f0.f207d;
            overScroller.getFinalX();
            overScroller.getCurrX();
            Objects.requireNonNull(yVar);
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        Objects.requireNonNull(yVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public View C(View view) {
        ViewParent parent;
        while (true) {
            parent = view.getParent();
            if (parent != null && parent != this && (parent instanceof View)) {
                view = (View) parent;
            } else if (parent != this) {
                return view;
            } else {
                return null;
            }
        }
        if (parent != this) {
        }
    }

    public final boolean D(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            q qVar = this.q.get(i2);
            if (qVar.a(this, motionEvent) && action != 3) {
                this.r = qVar;
                return true;
            }
        }
        return false;
    }

    public final void E(int[] iArr) {
        int e2 = this.f200f.e();
        if (e2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < e2; i4++) {
            b0 K2 = K(this.f200f.d(i4));
            if (!K2.u()) {
                int f2 = K2.f();
                if (f2 < i2) {
                    i2 = f2;
                }
                if (f2 > i3) {
                    i3 = f2;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public b0 G(int i2) {
        b0 b0Var = null;
        if (this.E) {
            return null;
        }
        int h2 = this.f200f.h();
        for (int i3 = 0; i3 < h2; i3++) {
            b0 K2 = K(this.f200f.g(i3));
            if (K2 != null && !K2.m() && H(K2) == i2) {
                if (!this.f200f.k(K2.a)) {
                    return K2;
                }
                b0Var = K2;
            }
        }
        return b0Var;
    }

    public int H(b0 b0Var) {
        if (!b0Var.h(524) && b0Var.j()) {
            e.s.a.a aVar = this.f199e;
            int i2 = b0Var.c;
            int size = aVar.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                a.b bVar = aVar.b.get(i3);
                int i4 = bVar.a;
                if (i4 != 1) {
                    if (i4 == 2) {
                        int i5 = bVar.b;
                        if (i5 <= i2) {
                            int i6 = bVar.f1776d;
                            if (i5 + i6 <= i2) {
                                i2 -= i6;
                            }
                        } else {
                            continue;
                        }
                    } else if (i4 == 8) {
                        int i7 = bVar.b;
                        if (i7 == i2) {
                            i2 = bVar.f1776d;
                        } else {
                            if (i7 < i2) {
                                i2--;
                            }
                            if (bVar.f1776d <= i2) {
                                i2++;
                            }
                        }
                    }
                } else if (bVar.b <= i2) {
                    i2 += bVar.f1776d;
                }
            }
            return i2;
        }
        return -1;
    }

    public long I(b0 b0Var) {
        if (this.m.b) {
            return b0Var.f213e;
        }
        return (long) b0Var.c;
    }

    public b0 J(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return K(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public Rect L(View view) {
        n nVar = (n) view.getLayoutParams();
        if (!nVar.c) {
            return nVar.b;
        }
        if (this.i0.f254g && (nVar.b() || nVar.a.k())) {
            return nVar.b;
        }
        Rect rect = nVar.b;
        rect.set(0, 0, 0, 0);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f204j.set(0, 0, 0, 0);
            Rect rect2 = this.f204j;
            Objects.requireNonNull(this.p.get(i2));
            ((n) view.getLayoutParams()).a();
            rect2.set(0, 0, 0, 0);
            int i3 = rect.left;
            Rect rect3 = this.f204j;
            rect.left = i3 + rect3.left;
            rect.top += rect3.top;
            rect.right += rect3.right;
            rect.bottom += rect3.bottom;
        }
        nVar.c = false;
        return rect;
    }

    public boolean M() {
        return !this.v || this.E || this.f199e.g();
    }

    public void N() {
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    public boolean O() {
        return this.G > 0;
    }

    public void P(int i2) {
        if (this.n != null) {
            setScrollState(2);
            this.n.N0(i2);
            awakenScrollBars();
        }
    }

    public void Q() {
        int h2 = this.f200f.h();
        for (int i2 = 0; i2 < h2; i2++) {
            ((n) this.f200f.g(i2).getLayoutParams()).c = true;
        }
        t tVar = this.c;
        int size = tVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = (n) tVar.c.get(i3).a.getLayoutParams();
            if (nVar != null) {
                nVar.c = true;
            }
        }
    }

    public void R(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int h2 = this.f200f.h();
        for (int i5 = 0; i5 < h2; i5++) {
            b0 K2 = K(this.f200f.g(i5));
            if (K2 != null && !K2.u()) {
                int i6 = K2.c;
                if (i6 >= i4) {
                    K2.q(-i3, z2);
                } else if (i6 >= i2) {
                    K2.b(8);
                    K2.q(-i3, z2);
                    K2.c = i2 - 1;
                }
                this.i0.f253f = true;
            }
        }
        t tVar = this.c;
        int size = tVar.c.size();
        while (true) {
            size--;
            if (size >= 0) {
                b0 b0Var = tVar.c.get(size);
                if (b0Var != null) {
                    int i7 = b0Var.c;
                    if (i7 >= i4) {
                        b0Var.q(-i3, z2);
                    } else if (i7 >= i2) {
                        b0Var.b(8);
                        tVar.f(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    public void S() {
    }

    public void T() {
    }

    public void U() {
        this.G++;
    }

    public void V(boolean z2) {
        int i2;
        boolean z3 = true;
        int i3 = this.G - 1;
        this.G = i3;
        if (i3 < 1) {
            this.G = 0;
            if (z2) {
                int i4 = this.A;
                this.A = 0;
                if (i4 != 0) {
                    AccessibilityManager accessibilityManager = this.C;
                    if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                        z3 = false;
                    }
                    if (z3) {
                        AccessibilityEvent obtain = AccessibilityEvent.obtain();
                        obtain.setEventType(2048);
                        obtain.setContentChangeTypes(i4);
                        sendAccessibilityEventUnchecked(obtain);
                    }
                }
                for (int size = this.w0.size() - 1; size >= 0; size--) {
                    b0 b0Var = this.w0.get(size);
                    if (b0Var.a.getParent() == this && !b0Var.u() && (i2 = b0Var.q) != -1) {
                        View view = b0Var.a;
                        AtomicInteger atomicInteger = e.i.i.l.a;
                        view.setImportantForAccessibility(i2);
                        b0Var.q = -1;
                    }
                }
                this.w0.clear();
            }
        }
    }

    public final void W(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.P) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.P = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.U = y2;
            this.S = y2;
        }
    }

    public void X() {
    }

    public void Y() {
    }

    public void Z() {
        if (!this.o0 && this.s) {
            Runnable runnable = this.x0;
            AtomicInteger atomicInteger = e.i.i.l.a;
            postOnAnimation(runnable);
            this.o0 = true;
        }
    }

    public final void a0() {
        boolean z2;
        boolean z3 = false;
        if (this.E) {
            e.s.a.a aVar = this.f199e;
            aVar.l(aVar.b);
            aVar.l(aVar.c);
            aVar.f1775f = 0;
            if (this.F) {
                this.n.q0(this);
            }
        }
        if (this.N != null && this.n.Z0()) {
            this.f199e.j();
        } else {
            this.f199e.c();
        }
        boolean z4 = this.l0 || this.m0;
        y yVar = this.i0;
        boolean z5 = this.v && this.N != null && ((z2 = this.E) || z4 || this.n.f228h) && (!z2 || this.m.b);
        yVar.f257j = z5;
        if (z5 && z4 && !this.E) {
            if (this.N != null && this.n.Z0()) {
                z3 = true;
            }
        }
        yVar.f258k = z3;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        m mVar = this.n;
        if (mVar == null || !mVar.e0()) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void b0(boolean z2) {
        this.F = z2 | this.F;
        this.E = true;
        int h2 = this.f200f.h();
        for (int i2 = 0; i2 < h2; i2++) {
            b0 K2 = K(this.f200f.g(i2));
            if (K2 != null && !K2.u()) {
                K2.b(6);
            }
        }
        Q();
        t tVar = this.c;
        int size = tVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b0 b0Var = tVar.c.get(i3);
            if (b0Var != null) {
                b0Var.b(6);
                b0Var.a(null);
            }
        }
        e eVar = RecyclerView.this.m;
        if (eVar == null || !eVar.b) {
            tVar.e();
        }
    }

    public void c0(b0 b0Var, j.c cVar) {
        b0Var.s(0, 8192);
        if (this.i0.f255h && b0Var.p() && !b0Var.m() && !b0Var.u()) {
            this.f201g.b.j(I(b0Var), b0Var);
        }
        this.f201g.c(b0Var, cVar);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof n) && this.n.g((n) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        m mVar = this.n;
        if (mVar != null && mVar.e()) {
            return this.n.k(this.i0);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        m mVar = this.n;
        if (mVar != null && mVar.e()) {
            return this.n.l(this.i0);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        m mVar = this.n;
        if (mVar != null && mVar.e()) {
            return this.n.m(this.i0);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        m mVar = this.n;
        if (mVar != null && mVar.f()) {
            return this.n.n(this.i0);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        m mVar = this.n;
        if (mVar != null && mVar.f()) {
            return this.n.o(this.i0);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        m mVar = this.n;
        if (mVar != null && mVar.f()) {
            return this.n.p(this.i0);
        }
        return 0;
    }

    public void d0() {
        j jVar = this.N;
        if (jVar != null) {
            jVar.j();
        }
        m mVar = this.n;
        if (mVar != null) {
            mVar.F0(this.c);
            this.n.G0(this.c);
        }
        this.c.b();
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().e(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z2;
        float f2;
        float f3;
        super.draw(canvas);
        int size = this.p.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).e(canvas, this, this.i0);
        }
        EdgeEffect edgeEffect = this.J;
        boolean z4 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f202h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.J;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f202h) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.K;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f202h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.L;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.M;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f202h) {
                f3 = (float) (getPaddingRight() + (-getWidth()));
                f2 = (float) (getPaddingBottom() + (-getHeight()));
            } else {
                f3 = (float) (-getWidth());
                f2 = (float) (-getHeight());
            }
            canvas.translate(f3, f2);
            EdgeEffect edgeEffect8 = this.M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.N == null || this.p.size() <= 0 || !this.N.k()) {
            z4 = z2;
        }
        if (z4) {
            AtomicInteger atomicInteger = e.i.i.l.a;
            postInvalidateOnAnimation();
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public final void e0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f204j.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof n) {
            n nVar = (n) layoutParams;
            if (!nVar.c) {
                Rect rect = nVar.b;
                Rect rect2 = this.f204j;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f204j);
            offsetRectIntoDescendantCoords(view, this.f204j);
        }
        this.n.K0(this, view, this.f204j, !this.v, view2 == null);
    }

    public final void f(b0 b0Var) {
        View view = b0Var.a;
        boolean z2 = view.getParent() == this;
        this.c.k(J(view));
        if (b0Var.o()) {
            this.f200f.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        e.s.a.b bVar = this.f200f;
        if (!z2) {
            bVar.a(view, -1, true);
            return;
        }
        int indexOfChild = ((e.s.a.s) bVar.a).a.indexOfChild(view);
        if (indexOfChild >= 0) {
            bVar.b.h(indexOfChild);
            bVar.i(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public final void f0() {
        VelocityTracker velocityTracker = this.Q;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z2 = false;
        p0(0);
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.M.isFinished();
        }
        if (z2) {
            AtomicInteger atomicInteger = e.i.i.l.a;
            postInvalidateOnAnimation();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0169, code lost:
        if (r3 > 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0183, code lost:
        if (r6 > 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0186, code lost:
        if (r3 < 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0189, code lost:
        if (r6 < 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0192, code lost:
        if ((r6 * r1) < 0) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x019b, code lost:
        if ((r6 * r1) > 0) goto L_0x019f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0075  */
    public View focusSearch(View view, int i2) {
        View view2;
        int i3;
        char c2;
        boolean z2;
        View o02 = this.n.o0();
        if (o02 != null) {
            return o02;
        }
        boolean z3 = false;
        boolean z4 = this.m != null && this.n != null && !O() && !this.y;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z4 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z4) {
                view2 = findNextFocus;
            } else {
                n();
                if (C(view) == null) {
                    return null;
                }
                m0();
                view2 = this.n.i0(view, i2, this.c, this.i0);
                o0(false);
            }
        } else {
            if (this.n.f()) {
                if (instance.findNextFocus(this, view, i2 == 2 ? 130 : 33) == null) {
                    z2 = true;
                    if (!z2 && this.n.e()) {
                        z2 = instance.findNextFocus(this, view, !((this.n.K() != 1) ^ (i2 != 2)) ? 66 : 17) != null;
                    }
                    if (z2) {
                        n();
                        if (C(view) == null) {
                            return null;
                        }
                        m0();
                        this.n.i0(view, i2, this.c, this.i0);
                        o0(false);
                    }
                    view2 = instance.findNextFocus(this, view, i2);
                }
            }
            z2 = false;
            if (instance.findNextFocus(this, view, !((this.n.K() != 1) ^ (i2 != 2)) ? 66 : 17) != null) {
            }
            if (z2) {
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            if (!(view2 == null || view2 == this)) {
                if (C(view2) != null) {
                    if (!(view == null || C(view) == null)) {
                        this.f204j.set(0, 0, view.getWidth(), view.getHeight());
                        this.f205k.set(0, 0, view2.getWidth(), view2.getHeight());
                        offsetDescendantRectToMyCoords(view, this.f204j);
                        offsetDescendantRectToMyCoords(view2, this.f205k);
                        int i4 = this.n.K() == 1 ? -1 : 1;
                        Rect rect = this.f204j;
                        int i5 = rect.left;
                        Rect rect2 = this.f205k;
                        int i6 = rect2.left;
                        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
                            i3 = 1;
                        } else {
                            int i7 = rect.right;
                            int i8 = rect2.right;
                            i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
                        }
                        int i9 = rect.top;
                        int i10 = rect2.top;
                        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
                            c2 = 1;
                        } else {
                            int i11 = rect.bottom;
                            int i12 = rect2.bottom;
                            c2 = ((i11 > i12 || i9 >= i12) && i9 > i10) ? (char) 65535 : 0;
                        }
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 17) {
                                    if (i2 != 33) {
                                        if (i2 != 66) {
                                            if (i2 != 130) {
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("Invalid direction: ");
                                                sb.append(i2);
                                                throw new IllegalArgumentException(f.a.a.a.a.m(this, sb));
                                            }
                                        }
                                    }
                                }
                            } else if (c2 <= 0) {
                                if (c2 == 0) {
                                }
                            }
                        } else if (c2 >= 0) {
                            if (c2 == 0) {
                            }
                        }
                    }
                    z3 = true;
                }
                return !z3 ? view2 : super.focusSearch(view, i2);
            }
            z3 = false;
            if (!z3) {
            }
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        } else {
            e0(view2, null);
            return view;
        }
    }

    public void g(l lVar) {
        m mVar = this.n;
        if (mVar != null) {
            mVar.d("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            setWillNotDraw(false);
        }
        this.p.add(lVar);
        Q();
        requestLayout();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f3  */
    public boolean g0(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        float f2;
        EdgeEffect edgeEffect;
        float f3;
        n();
        if (this.m != null) {
            int[] iArr = this.v0;
            iArr[0] = 0;
            iArr[1] = 0;
            h0(i2, i3, iArr);
            int[] iArr2 = this.v0;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i7 = i9;
            i6 = i8;
            i5 = i2 - i8;
            i4 = i3 - i9;
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (!this.p.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.v0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        u(i6, i7, i5, i4, this.t0, 0, iArr3);
        int[] iArr4 = this.v0;
        int i10 = i5 - iArr4[0];
        int i11 = i4 - iArr4[1];
        boolean z3 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.T;
        int[] iArr5 = this.t0;
        this.T = i12 - iArr5[0];
        this.U -= iArr5[1];
        int[] iArr6 = this.u0;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                if (!((motionEvent.getSource() & 8194) == 8194)) {
                    float x2 = motionEvent.getX();
                    float f4 = (float) i10;
                    float y2 = motionEvent.getY();
                    float f5 = (float) i11;
                    if (f4 < 0.0f) {
                        x();
                        edgeEffect = this.J;
                        f2 = (-f4) / ((float) getWidth());
                        f3 = 1.0f - (y2 / ((float) getHeight()));
                    } else if (f4 > 0.0f) {
                        y();
                        edgeEffect = this.L;
                        f2 = f4 / ((float) getWidth());
                        f3 = y2 / ((float) getHeight());
                    } else {
                        z2 = false;
                        if (f5 >= 0.0f) {
                            z();
                            this.K.onPull((-f5) / ((float) getHeight()), x2 / ((float) getWidth()));
                        } else {
                            if (f5 > 0.0f) {
                                w();
                                this.M.onPull(f5 / ((float) getHeight()), 1.0f - (x2 / ((float) getWidth())));
                            }
                            if (!(!z2 && f4 == 0.0f && f5 == 0.0f)) {
                                AtomicInteger atomicInteger = e.i.i.l.a;
                                postInvalidateOnAnimation();
                            }
                        }
                        z2 = true;
                        AtomicInteger atomicInteger2 = e.i.i.l.a;
                        postInvalidateOnAnimation();
                    }
                    edgeEffect.onPull(f2, f3);
                    z2 = true;
                    if (f5 >= 0.0f) {
                    }
                    z2 = true;
                    AtomicInteger atomicInteger22 = e.i.i.l.a;
                    postInvalidateOnAnimation();
                }
            }
            m(i2, i3);
        }
        if (!(i6 == 0 && i7 == 0)) {
            v(i6, i7);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z3 && i6 == 0 && i7 == 0) ? false : true;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        m mVar = this.n;
        if (mVar != null) {
            return mVar.u();
        }
        throw new IllegalStateException(f.a.a.a.a.m(this, f.a.a.a.a.h("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        m mVar = this.n;
        if (mVar != null) {
            return mVar.v(getContext(), attributeSet);
        }
        throw new IllegalStateException(f.a.a.a.a.m(this, f.a.a.a.a.h("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        m mVar = this.n;
        if (mVar != null) {
            return mVar.w(layoutParams);
        }
        throw new IllegalStateException(f.a.a.a.a.m(this, f.a.a.a.a.h("RecyclerView has no LayoutManager")));
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public e getAdapter() {
        return this.m;
    }

    public int getBaseline() {
        m mVar = this.n;
        if (mVar == null) {
            return super.getBaseline();
        }
        Objects.requireNonNull(mVar);
        return -1;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        h hVar = this.q0;
        return hVar == null ? super.getChildDrawingOrder(i2, i3) : hVar.a(i2, i3);
    }

    public boolean getClipToPadding() {
        return this.f202h;
    }

    public e.s.a.u getCompatAccessibilityDelegate() {
        return this.p0;
    }

    public i getEdgeEffectFactory() {
        return this.I;
    }

    public j getItemAnimator() {
        return this.N;
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public m getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.b0;
    }

    public int getMinFlingVelocity() {
        return this.a0;
    }

    public long getNanoTime() {
        if (C0) {
            return System.nanoTime();
        }
        return 0;
    }

    public p getOnFlingListener() {
        return this.W;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.e0;
    }

    public s getRecycledViewPool() {
        return this.c.d();
    }

    public int getScrollState() {
        return this.O;
    }

    public void h(r rVar) {
        if (this.k0 == null) {
            this.k0 = new ArrayList();
        }
        this.k0.add(rVar);
    }

    public void h0(int i2, int i3, int[] iArr) {
        b0 b0Var;
        m0();
        U();
        int i4 = e.i.e.f.a;
        Trace.beginSection("RV Scroll");
        B(this.i0);
        int M0 = i2 != 0 ? this.n.M0(i2, this.c, this.i0) : 0;
        int O0 = i3 != 0 ? this.n.O0(i3, this.c, this.i0) : 0;
        Trace.endSection();
        int e2 = this.f200f.e();
        for (int i5 = 0; i5 < e2; i5++) {
            View d2 = this.f200f.d(i5);
            b0 J2 = J(d2);
            if (!(J2 == null || (b0Var = J2.f217i) == null)) {
                View view = b0Var.a;
                int left = d2.getLeft();
                int top = d2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        V(true);
        o0(false);
        if (iArr != null) {
            iArr[0] = M0;
            iArr[1] = O0;
        }
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().h(0);
    }

    public void i(String str) {
        if (O()) {
            if (str == null) {
                throw new IllegalStateException(f.a.a.a.a.m(this, f.a.a.a.a.h("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(f.a.a.a.a.m(this, f.a.a.a.a.h(""))));
        }
    }

    public void i0(int i2) {
        if (!this.y) {
            q0();
            m mVar = this.n;
            if (mVar == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            mVar.N0(i2);
            awakenScrollBars();
        }
    }

    public boolean isAttachedToWindow() {
        return this.s;
    }

    public final boolean isLayoutSuppressed() {
        return this.y;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f1465d;
    }

    public final void j() {
        f0();
        setScrollState(0);
    }

    public boolean j0(b0 b0Var, int i2) {
        if (O()) {
            b0Var.q = i2;
            this.w0.add(b0Var);
            return false;
        }
        View view = b0Var.a;
        AtomicInteger atomicInteger = e.i.i.l.a;
        view.setImportantForAccessibility(i2);
        return true;
    }

    public void k0(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        m mVar = this.n;
        if (mVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.y) {
            int i5 = 0;
            if (!mVar.e()) {
                i2 = 0;
            }
            if (!this.n.f()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                if (i4 == Integer.MIN_VALUE || i4 > 0) {
                    if (z2) {
                        if (i2 != 0) {
                            i5 = 1;
                        }
                        if (i3 != 0) {
                            i5 |= 2;
                        }
                        n0(i5, 1);
                    }
                    this.f0.b(i2, i3, i4, interpolator);
                    return;
                }
                scrollBy(i2, i3);
            }
        }
    }

    public void l() {
        int h2 = this.f200f.h();
        for (int i2 = 0; i2 < h2; i2++) {
            b0 K2 = K(this.f200f.g(i2));
            if (!K2.u()) {
                K2.c();
            }
        }
        t tVar = this.c;
        int size = tVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            tVar.c.get(i3).c();
        }
        int size2 = tVar.a.size();
        for (int i4 = 0; i4 < size2; i4++) {
            tVar.a.get(i4).c();
        }
        ArrayList<b0> arrayList = tVar.b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i5 = 0; i5 < size3; i5++) {
                tVar.b.get(i5).c();
            }
        }
    }

    public void l0(int i2) {
        if (!this.y) {
            m mVar = this.n;
            if (mVar == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                mVar.X0(this, this.i0, i2);
            }
        }
    }

    public void m(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.J.onRelease();
            z2 = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.L.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.K.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.M.onRelease();
            z2 |= this.M.isFinished();
        }
        if (z2) {
            AtomicInteger atomicInteger = e.i.i.l.a;
            postInvalidateOnAnimation();
        }
    }

    public void m0() {
        int i2 = this.w + 1;
        this.w = i2;
        if (i2 == 1 && !this.y) {
            this.x = false;
        }
    }

    public void n() {
        if (!this.v || this.E) {
            int i2 = e.i.e.f.a;
            Trace.beginSection("RV FullInvalidate");
            q();
            Trace.endSection();
        } else if (this.f199e.g()) {
            e.s.a.a aVar = this.f199e;
            int i3 = aVar.f1775f;
            boolean z2 = false;
            if ((i3 & 4) != 0) {
                if (!((i3 & 11) != 0)) {
                    int i4 = e.i.e.f.a;
                    Trace.beginSection("RV PartialInvalidate");
                    m0();
                    U();
                    this.f199e.j();
                    if (!this.x) {
                        int e2 = this.f200f.e();
                        int i5 = 0;
                        while (true) {
                            if (i5 < e2) {
                                b0 K2 = K(this.f200f.d(i5));
                                if (K2 != null && !K2.u() && K2.p()) {
                                    z2 = true;
                                    break;
                                }
                                i5++;
                            } else {
                                break;
                            }
                        }
                        if (z2) {
                            q();
                        } else {
                            this.f199e.b();
                        }
                    }
                    o0(true);
                    V(true);
                    Trace.endSection();
                }
            }
            if (aVar.g()) {
                int i6 = e.i.e.f.a;
                Trace.beginSection("RV FullInvalidate");
                q();
                Trace.endSection();
            }
        }
    }

    public boolean n0(int i2, int i3) {
        return getScrollingChildHelper().i(i2, i3);
    }

    public void o(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        AtomicInteger atomicInteger = e.i.i.l.a;
        setMeasuredDimension(m.h(i2, paddingRight, getMinimumWidth()), m.h(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void o0(boolean z2) {
        if (this.w < 1) {
            this.w = 1;
        }
        if (!z2 && !this.y) {
            this.x = false;
        }
        if (this.w == 1) {
            if (z2 && this.x && !this.y && this.n != null && this.m != null) {
                q();
            }
            if (!this.y) {
                this.x = false;
            }
        }
        this.w--;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G = 0;
        this.s = true;
        this.v = this.v && !isLayoutRequested();
        m mVar = this.n;
        if (mVar != null) {
            mVar.f229i = true;
            mVar.f0();
        }
        this.o0 = false;
        if (C0) {
            ThreadLocal<e.s.a.j> threadLocal = e.s.a.j.f1803f;
            e.s.a.j jVar = threadLocal.get();
            this.g0 = jVar;
            if (jVar == null) {
                this.g0 = new e.s.a.j();
                AtomicInteger atomicInteger = e.i.i.l.a;
                Display display = getDisplay();
                float f2 = 60.0f;
                if (!isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                e.s.a.j jVar2 = this.g0;
                jVar2.f1805d = (long) (1.0E9f / f2);
                threadLocal.set(jVar2);
            }
            this.g0.b.add(this);
        }
    }

    public void onDetachedFromWindow() {
        e.s.a.j jVar;
        super.onDetachedFromWindow();
        j jVar2 = this.N;
        if (jVar2 != null) {
            jVar2.j();
        }
        q0();
        this.s = false;
        m mVar = this.n;
        if (mVar != null) {
            t tVar = this.c;
            mVar.f229i = false;
            mVar.h0(this, tVar);
        }
        this.w0.clear();
        removeCallbacks(this.x0);
        Objects.requireNonNull(this.f201g);
        do {
        } while (y.a.f1831d.a() != null);
        if (C0 && (jVar = this.g0) != null) {
            jVar.b.remove(this);
            this.g0 = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).d(canvas, this, this.i0);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.n != null && !this.y && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.n.f() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.n.e()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == 0.0f && f2 == 0.0f)) {
                        g0((int) (f2 * this.c0), (int) (f3 * this.d0), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.n.f()) {
                        f3 = -axisValue;
                    } else if (this.n.e()) {
                        f2 = axisValue;
                        f3 = 0.0f;
                        g0((int) (f2 * this.c0), (int) (f3 * this.d0), motionEvent);
                    }
                }
                f3 = 0.0f;
            }
            f2 = 0.0f;
            g0((int) (f2 * this.c0), (int) (f3 * this.d0), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.y) {
            return false;
        }
        this.r = null;
        if (D(motionEvent)) {
            j();
            return true;
        }
        m mVar = this.n;
        if (mVar == null) {
            return false;
        }
        boolean e2 = mVar.e();
        boolean f2 = this.n.f();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        this.Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.z) {
                this.z = false;
            }
            this.P = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.U = y2;
            this.S = y2;
            if (this.O == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                p0(1);
            }
            int[] iArr = this.u0;
            iArr[1] = 0;
            iArr[0] = 0;
            if (f2) {
                boolean z3 = e2 ? 1 : 0;
                char c2 = e2 ? 1 : 0;
                e2 = z3 | true;
            }
            int i2 = e2 ? 1 : 0;
            int i3 = e2 ? 1 : 0;
            int i4 = e2 ? 1 : 0;
            n0(i2, 0);
        } else if (actionMasked == 1) {
            this.Q.clear();
            p0(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.P);
            if (findPointerIndex < 0) {
                StringBuilder h2 = f.a.a.a.a.h("Error processing scroll; pointer index for id ");
                h2.append(this.P);
                h2.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", h2.toString());
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.O != 1) {
                int i5 = x3 - this.R;
                int i6 = y3 - this.S;
                if (!e2 || Math.abs(i5) <= this.V) {
                    z2 = false;
                } else {
                    this.T = x3;
                    z2 = true;
                }
                if (f2 && Math.abs(i6) > this.V) {
                    this.U = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            j();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x4;
            this.R = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y4;
            this.S = y4;
        } else if (actionMasked == 6) {
            W(motionEvent);
        }
        return this.O == 1;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = e.i.e.f.a;
        Trace.beginSection("RV OnLayout");
        q();
        Trace.endSection();
        this.v = true;
    }

    public void onMeasure(int i2, int i3) {
        m mVar = this.n;
        if (mVar == null) {
            o(i2, i3);
            return;
        }
        boolean z2 = false;
        if (mVar.W()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.x0(i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (!z2 && this.m != null) {
                if (this.i0.f251d == 1) {
                    r();
                }
                this.n.Q0(i2, i3);
                this.i0.f256i = true;
                s();
                this.n.S0(i2, i3);
                if (this.n.V0()) {
                    this.n.Q0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.i0.f256i = true;
                    s();
                    this.n.S0(i2, i3);
                }
            }
        } else if (this.t) {
            this.n.x0(i2, i3);
        } else {
            if (this.B) {
                m0();
                U();
                a0();
                V(true);
                y yVar = this.i0;
                if (yVar.f258k) {
                    yVar.f254g = true;
                } else {
                    this.f199e.c();
                    this.i0.f254g = false;
                }
                this.B = false;
                o0(false);
            } else if (this.i0.f258k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            e eVar = this.m;
            if (eVar != null) {
                this.i0.f252e = eVar.c();
            } else {
                this.i0.f252e = 0;
            }
            m0();
            this.n.x0(i2, i3);
            o0(false);
            this.i0.f254g = false;
        }
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (O()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof w)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        w wVar = (w) parcelable;
        this.f198d = wVar;
        super.onRestoreInstanceState(wVar.b);
        m mVar = this.n;
        if (mVar != null && (parcelable2 = this.f198d.f241d) != null) {
            mVar.A0(parcelable2);
        }
    }

    public Parcelable onSaveInstanceState() {
        w wVar = new w(super.onSaveInstanceState());
        w wVar2 = this.f198d;
        if (wVar2 != null) {
            wVar.f241d = wVar2.f241d;
        } else {
            m mVar = this.n;
            wVar.f241d = mVar != null ? mVar.B0() : null;
        }
        return wVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            N();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:144:0x024e, code lost:
        if (r7 == false) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02a7, code lost:
        if (r1 != false) goto L_0x02ac;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010c  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        boolean z4;
        int minFlingVelocity;
        boolean z5;
        e.s.a.l c2;
        int e2;
        boolean z6;
        boolean z7 = false;
        if (this.y || this.z) {
            return false;
        }
        q qVar = this.r;
        if (qVar == null) {
            z2 = motionEvent.getAction() == 0 ? false : D(motionEvent);
        } else {
            qVar.b(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.r = null;
            }
            z2 = true;
        }
        if (z2) {
            j();
            return true;
        }
        m mVar = this.n;
        if (mVar == null) {
            return false;
        }
        boolean e3 = mVar.e();
        boolean f2 = this.n.f();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.u0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.u0;
        obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (actionMasked == 0) {
            this.P = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.U = y2;
            this.S = y2;
            if (f2) {
                boolean z8 = e3 ? 1 : 0;
                char c3 = e3 ? 1 : 0;
                e3 = z8 | true;
            }
            int i2 = e3 ? 1 : 0;
            int i3 = e3 ? 1 : 0;
            int i4 = e3 ? 1 : 0;
            n0(i2, 0);
        } else if (actionMasked == 1) {
            this.Q.addMovement(obtain);
            this.Q.computeCurrentVelocity(1000, (float) this.b0);
            float f3 = e3 ? -this.Q.getXVelocity(this.P) : 0.0f;
            float f4 = f2 ? -this.Q.getYVelocity(this.P) : 0.0f;
            if (!(f3 == 0.0f && f4 == 0.0f)) {
                int i5 = (int) f3;
                int i6 = (int) f4;
                m mVar2 = this.n;
                if (mVar2 == null) {
                    Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                } else if (!this.y) {
                    boolean e4 = mVar2.e();
                    boolean f5 = this.n.f();
                    if (!e4 || Math.abs(i5) < this.a0) {
                        i5 = 0;
                    }
                    if (!f5 || Math.abs(i6) < this.a0) {
                        i6 = 0;
                    }
                    if (!(i5 == 0 && i6 == 0)) {
                        float f6 = (float) i5;
                        float f7 = (float) i6;
                        if (!dispatchNestedPreFling(f6, f7)) {
                            boolean z9 = e4 || f5;
                            dispatchNestedFling(f6, f7, z9);
                            p pVar = this.W;
                            if (pVar != null) {
                                e.s.a.w wVar = (e.s.a.w) pVar;
                                m layoutManager = wVar.a.getLayoutManager();
                                if (!(layoutManager == null || wVar.a.getAdapter() == null || (Math.abs(i6) <= (minFlingVelocity = wVar.a.getMinFlingVelocity()) && Math.abs(i5) <= minFlingVelocity))) {
                                    if (!(layoutManager instanceof x.b) || (c2 = wVar.c(layoutManager)) == null || (e2 = wVar.e(layoutManager, i5, i6)) == -1) {
                                        z5 = false;
                                    } else {
                                        c2.a = e2;
                                        layoutManager.Y0(c2);
                                        z5 = true;
                                    }
                                    if (z5) {
                                        z4 = true;
                                    }
                                }
                                z4 = false;
                            }
                            if (z9) {
                                if (f5) {
                                    boolean z10 = e4 ? 1 : 0;
                                    char c4 = e4 ? 1 : 0;
                                    e4 = z10 | true;
                                }
                                int i7 = e4 ? 1 : 0;
                                int i8 = e4 ? 1 : 0;
                                int i9 = e4 ? 1 : 0;
                                n0(i7, 1);
                                int i10 = this.b0;
                                int max = Math.max(-i10, Math.min(i5, i10));
                                int i11 = this.b0;
                                int max2 = Math.max(-i11, Math.min(i6, i11));
                                a0 a0Var = this.f0;
                                RecyclerView.this.setScrollState(2);
                                a0Var.c = 0;
                                a0Var.b = 0;
                                Interpolator interpolator = a0Var.f208e;
                                Interpolator interpolator2 = E0;
                                if (interpolator != interpolator2) {
                                    a0Var.f208e = interpolator2;
                                    a0Var.f207d = new OverScroller(RecyclerView.this.getContext(), interpolator2);
                                }
                                a0Var.f207d.fling(0, 0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                a0Var.a();
                                z3 = true;
                            }
                        }
                    }
                }
                z3 = false;
            }
            setScrollState(0);
            f0();
            z7 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.P);
            if (findPointerIndex < 0) {
                StringBuilder h2 = f.a.a.a.a.h("Error processing scroll; pointer index for id ");
                h2.append(this.P);
                h2.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", h2.toString());
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i12 = this.T - x3;
            int i13 = this.U - y3;
            if (this.O != 1) {
                if (e3) {
                    int i14 = this.V;
                    i12 = i12 > 0 ? Math.max(0, i12 - i14) : Math.min(0, i12 + i14);
                    if (i12 != 0) {
                        z6 = true;
                        if (f2) {
                            int i15 = this.V;
                            i13 = i13 > 0 ? Math.max(0, i13 - i15) : Math.min(0, i13 + i15);
                            if (i13 != 0) {
                                z6 = true;
                            }
                        }
                        if (z6) {
                            setScrollState(1);
                        }
                    }
                }
                z6 = false;
                if (f2) {
                }
                if (z6) {
                }
            }
            if (this.O == 1) {
                int[] iArr3 = this.v0;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (getScrollingChildHelper().c(e3 ? i12 : 0, f2 ? i13 : 0, iArr3, this.t0, 0)) {
                    int[] iArr4 = this.v0;
                    i12 -= iArr4[0];
                    i13 -= iArr4[1];
                    int[] iArr5 = this.u0;
                    int i16 = iArr5[0];
                    int[] iArr6 = this.t0;
                    iArr5[0] = i16 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int[] iArr7 = this.t0;
                this.T = x3 - iArr7[0];
                this.U = y3 - iArr7[1];
                if (g0(e3 ? i12 : 0, f2 ? i13 : 0, motionEvent)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                e.s.a.j jVar = this.g0;
                if (!(jVar == null || (i12 == 0 && i13 == 0))) {
                    jVar.a(this, i12, i13);
                }
            }
        } else if (actionMasked == 3) {
            j();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x4;
            this.R = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y4;
            this.S = y4;
        } else if (actionMasked == 6) {
            W(motionEvent);
        }
        if (!z7) {
            this.Q.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void p(View view) {
        b0 K2 = K(view);
        T();
        e eVar = this.m;
        if (!(eVar == null || K2 == null)) {
            eVar.m(K2);
        }
        List<o> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).b(view);
            }
        }
    }

    public void p0(int i2) {
        getScrollingChildHelper().j(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02ff, code lost:
        if (r17.f200f.k(getFocusedChild()) == false) goto L_0x03c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0387, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    public void q() {
        String str;
        y yVar;
        View view;
        ArrayList<b0> arrayList;
        m mVar;
        long j2;
        b0 b0Var;
        View findViewById;
        View view2;
        boolean z2;
        b0 b0Var2;
        j.c cVar;
        j.c cVar2;
        RecyclerView recyclerView;
        if (this.m == null) {
            str = "No adapter attached; skipping layout";
        } else if (this.n == null) {
            str = "No layout manager attached; skipping layout";
        } else {
            y yVar2 = this.i0;
            int i2 = 0;
            yVar2.f256i = false;
            boolean z3 = true;
            if (yVar2.f251d == 1) {
                r();
            } else {
                e.s.a.a aVar = this.f199e;
                if (!(!aVar.c.isEmpty() && !aVar.b.isEmpty()) && this.n.p == getWidth() && this.n.q == getHeight()) {
                    this.n.P0(this);
                    int i3 = 4;
                    this.i0.a(4);
                    m0();
                    U();
                    yVar = this.i0;
                    yVar.f251d = 1;
                    view = null;
                    if (yVar.f257j) {
                        int e2 = this.f200f.e() - 1;
                        while (e2 >= 0) {
                            b0 K2 = K(this.f200f.d(e2));
                            if (!K2.u()) {
                                long I2 = I(K2);
                                Objects.requireNonNull(this.N);
                                j.c cVar3 = new j.c();
                                View view3 = K2.a;
                                cVar3.a = view3.getLeft();
                                cVar3.b = view3.getTop();
                                view3.getRight();
                                view3.getBottom();
                                b0 g2 = this.f201g.b.g(I2, null);
                                if (g2 != null && !g2.u()) {
                                    boolean d2 = this.f201g.d(g2);
                                    boolean d3 = this.f201g.d(K2);
                                    if (!d2 || g2 != K2) {
                                        j.c e3 = this.f201g.e(g2, i3);
                                        this.f201g.b(K2, cVar3);
                                        j.c e4 = this.f201g.e(K2, 8);
                                        if (e3 == null) {
                                            int e5 = this.f200f.e();
                                            for (int i4 = 0; i4 < e5; i4++) {
                                                b0 K3 = K(this.f200f.d(i4));
                                                if (K3 != K2 && I(K3) == I2) {
                                                    e eVar = this.m;
                                                    if (eVar == null || !eVar.b) {
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                                                        sb.append(K3);
                                                        sb.append(" \n View Holder 2:");
                                                        sb.append(K2);
                                                        throw new IllegalStateException(f.a.a.a.a.m(this, sb));
                                                    }
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                                                    sb2.append(K3);
                                                    sb2.append(" \n View Holder 2:");
                                                    sb2.append(K2);
                                                    throw new IllegalStateException(f.a.a.a.a.m(this, sb2));
                                                }
                                            }
                                            Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + g2 + " cannot be found but it is necessary for " + K2 + A());
                                        } else {
                                            g2.t(false);
                                            if (d2) {
                                                f(g2);
                                            }
                                            if (g2 != K2) {
                                                if (d3) {
                                                    f(K2);
                                                }
                                                g2.f216h = K2;
                                                f(g2);
                                                this.c.k(g2);
                                                K2.t(false);
                                                K2.f217i = g2;
                                            }
                                            if (this.N.b(g2, K2, e3, e4)) {
                                                Z();
                                            }
                                        }
                                    }
                                }
                                this.f201g.b(K2, cVar3);
                            }
                            e2--;
                            i3 = 4;
                        }
                        e.s.a.y yVar3 = this.f201g;
                        y.b bVar = this.y0;
                        for (int i5 = yVar3.a.f1199d - 1; i5 >= 0; i5--) {
                            b0 h2 = yVar3.a.h(i5);
                            y.a i6 = yVar3.a.i(i5);
                            int i7 = i6.a;
                            if ((i7 & 3) != 3) {
                                if ((i7 & 1) != 0) {
                                    cVar2 = i6.b;
                                    if (cVar2 != null) {
                                        cVar = i6.c;
                                    }
                                } else {
                                    if ((i7 & 14) == 14) {
                                        j.c cVar4 = i6.b;
                                        j.c cVar5 = i6.c;
                                        recyclerView = RecyclerView.this;
                                        Objects.requireNonNull(recyclerView);
                                        h2.t(false);
                                        if (!recyclerView.N.a(h2, cVar4, cVar5)) {
                                            y.a.b(i6);
                                        }
                                    } else {
                                        if ((i7 & 12) == 12) {
                                            j.c cVar6 = i6.b;
                                            j.c cVar7 = i6.c;
                                            d dVar = (d) bVar;
                                            Objects.requireNonNull(dVar);
                                            h2.t(false);
                                            RecyclerView recyclerView2 = RecyclerView.this;
                                            boolean z4 = recyclerView2.E;
                                            j jVar = recyclerView2.N;
                                            if (z4) {
                                                if (!jVar.b(h2, h2, cVar6, cVar7)) {
                                                }
                                            } else if (!jVar.d(h2, cVar6, cVar7)) {
                                            }
                                            RecyclerView.this.Z();
                                        } else if ((i7 & 4) != 0) {
                                            cVar2 = i6.b;
                                            cVar = null;
                                        } else if ((i7 & 8) != 0) {
                                            j.c cVar8 = i6.b;
                                            j.c cVar9 = i6.c;
                                            recyclerView = RecyclerView.this;
                                            Objects.requireNonNull(recyclerView);
                                            h2.t(false);
                                            if (!recyclerView.N.a(h2, cVar8, cVar9)) {
                                            }
                                        }
                                        y.a.b(i6);
                                    }
                                    recyclerView.Z();
                                    y.a.b(i6);
                                }
                                ((d) bVar).a(h2, cVar2, cVar);
                                y.a.b(i6);
                            }
                            RecyclerView recyclerView3 = RecyclerView.this;
                            recyclerView3.n.H0(h2.a, recyclerView3.c);
                            y.a.b(i6);
                        }
                    }
                    this.n.G0(this.c);
                    y yVar4 = this.i0;
                    yVar4.b = yVar4.f252e;
                    this.E = false;
                    this.F = false;
                    yVar4.f257j = false;
                    yVar4.f258k = false;
                    this.n.f228h = false;
                    arrayList = this.c.b;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    mVar = this.n;
                    if (mVar.m) {
                        mVar.f232l = 0;
                        mVar.m = false;
                        this.c.l();
                    }
                    this.n.w0(this.i0);
                    V(true);
                    o0(false);
                    e.s.a.y yVar5 = this.f201g;
                    yVar5.a.clear();
                    yVar5.b.b();
                    int[] iArr = this.r0;
                    int i8 = iArr[0];
                    int i9 = iArr[1];
                    E(iArr);
                    int[] iArr2 = this.r0;
                    if (iArr2[0] == i8 && iArr2[1] == i9) {
                        z3 = false;
                    }
                    if (z3) {
                        v(0, 0);
                    }
                    if (this.e0 && this.m != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
                        if (!isFocused()) {
                        }
                        j2 = this.i0.m;
                        if (j2 != -1 || !(z2 = this.m.b)) {
                            b0Var = null;
                        } else {
                            if (!z2) {
                                b0Var2 = null;
                            } else {
                                int h3 = this.f200f.h();
                                int i10 = 0;
                                b0Var2 = null;
                                while (true) {
                                    if (i10 >= h3) {
                                        break;
                                    }
                                    b0Var = K(this.f200f.g(i10));
                                    if (b0Var != null && !b0Var.m() && b0Var.f213e == j2) {
                                        if (!this.f200f.k(b0Var.a)) {
                                            break;
                                        }
                                        b0Var2 = b0Var;
                                    }
                                    i10++;
                                }
                            }
                            b0Var = b0Var2;
                        }
                        if (b0Var == null && !this.f200f.k(b0Var.a) && b0Var.a.hasFocusable()) {
                            view = b0Var.a;
                        } else if (this.f200f.e() > 0) {
                            y yVar6 = this.i0;
                            int i11 = yVar6.f259l;
                            if (i11 != -1) {
                                i2 = i11;
                            }
                            int b2 = yVar6.b();
                            int i12 = i2;
                            while (true) {
                                if (i12 >= b2) {
                                    break;
                                }
                                b0 G2 = G(i12);
                                if (G2 == null) {
                                    break;
                                } else if (G2.a.hasFocusable()) {
                                    view2 = G2.a;
                                    break;
                                } else {
                                    i12++;
                                }
                            }
                            int min = Math.min(b2, i2) - 1;
                            while (true) {
                                if (min < 0) {
                                    break;
                                }
                                b0 G3 = G(min);
                                if (G3 == null) {
                                    break;
                                } else if (G3.a.hasFocusable()) {
                                    view2 = G3.a;
                                    break;
                                } else {
                                    min--;
                                }
                            }
                        }
                        if (view != null) {
                            int i13 = this.i0.n;
                            if (!(((long) i13) == -1 || (findViewById = view.findViewById(i13)) == null || !findViewById.isFocusable())) {
                                view = findViewById;
                            }
                            view.requestFocus();
                        }
                    }
                    y yVar7 = this.i0;
                    yVar7.m = -1;
                    yVar7.f259l = -1;
                    yVar7.n = -1;
                    return;
                }
            }
            this.n.P0(this);
            s();
            int i32 = 4;
            this.i0.a(4);
            m0();
            U();
            yVar = this.i0;
            yVar.f251d = 1;
            view = null;
            if (yVar.f257j) {
            }
            this.n.G0(this.c);
            y yVar42 = this.i0;
            yVar42.b = yVar42.f252e;
            this.E = false;
            this.F = false;
            yVar42.f257j = false;
            yVar42.f258k = false;
            this.n.f228h = false;
            arrayList = this.c.b;
            if (arrayList != null) {
            }
            mVar = this.n;
            if (mVar.m) {
            }
            this.n.w0(this.i0);
            V(true);
            o0(false);
            e.s.a.y yVar52 = this.f201g;
            yVar52.a.clear();
            yVar52.b.b();
            int[] iArr3 = this.r0;
            int i82 = iArr3[0];
            int i92 = iArr3[1];
            E(iArr3);
            int[] iArr22 = this.r0;
            z3 = false;
            if (z3) {
            }
            if (!isFocused()) {
            }
            j2 = this.i0.m;
            if (j2 != -1) {
            }
            b0Var = null;
            if (b0Var == null) {
            }
            if (this.f200f.e() > 0) {
            }
            if (view != null) {
            }
            y yVar72 = this.i0;
            yVar72.m = -1;
            yVar72.f259l = -1;
            yVar72.n = -1;
            return;
        }
        Log.e("RecyclerView", str);
    }

    public void q0() {
        x xVar;
        setScrollState(0);
        this.f0.c();
        m mVar = this.n;
        if (mVar != null && (xVar = mVar.f227g) != null) {
            xVar.d();
        }
    }

    public final void r() {
        int id;
        View C2;
        this.i0.a(1);
        B(this.i0);
        this.i0.f256i = false;
        m0();
        e.s.a.y yVar = this.f201g;
        yVar.a.clear();
        yVar.b.b();
        U();
        a0();
        View focusedChild = (!this.e0 || !hasFocus() || this.m == null) ? null : getFocusedChild();
        b0 J2 = (focusedChild == null || (C2 = C(focusedChild)) == null) ? null : J(C2);
        long j2 = -1;
        if (J2 == null) {
            y yVar2 = this.i0;
            yVar2.m = -1;
            yVar2.f259l = -1;
            yVar2.n = -1;
        } else {
            y yVar3 = this.i0;
            if (this.m.b) {
                j2 = J2.f213e;
            }
            yVar3.m = j2;
            yVar3.f259l = this.E ? -1 : J2.m() ? J2.f212d : J2.e();
            y yVar4 = this.i0;
            View view = J2.a;
            loop0:
            while (true) {
                id = view.getId();
                while (true) {
                    if (view.isFocused() || !(view instanceof ViewGroup) || !view.hasFocus()) {
                        yVar4.n = id;
                    } else {
                        view = ((ViewGroup) view).getFocusedChild();
                        if (view.getId() != -1) {
                        }
                    }
                }
            }
            yVar4.n = id;
        }
        y yVar5 = this.i0;
        yVar5.f255h = yVar5.f257j && this.m0;
        this.m0 = false;
        this.l0 = false;
        yVar5.f254g = yVar5.f258k;
        yVar5.f252e = this.m.c();
        E(this.r0);
        if (this.i0.f257j) {
            int e2 = this.f200f.e();
            for (int i2 = 0; i2 < e2; i2++) {
                b0 K2 = K(this.f200f.d(i2));
                if (!K2.u() && (!K2.k() || this.m.b)) {
                    j jVar = this.N;
                    j.e(K2);
                    K2.g();
                    this.f201g.c(K2, jVar.l(K2));
                    if (this.i0.f255h && K2.p() && !K2.m() && !K2.u() && !K2.k()) {
                        this.f201g.b.j(I(K2), K2);
                    }
                }
            }
        }
        if (this.i0.f258k) {
            int h2 = this.f200f.h();
            for (int i3 = 0; i3 < h2; i3++) {
                b0 K3 = K(this.f200f.g(i3));
                if (!K3.u() && K3.f212d == -1) {
                    K3.f212d = K3.c;
                }
            }
            y yVar6 = this.i0;
            boolean z2 = yVar6.f253f;
            yVar6.f253f = false;
            this.n.v0(this.c, yVar6);
            this.i0.f253f = z2;
            for (int i4 = 0; i4 < this.f200f.e(); i4++) {
                b0 K4 = K(this.f200f.d(i4));
                if (!K4.u()) {
                    y.a orDefault = this.f201g.a.getOrDefault(K4, null);
                    if (!((orDefault == null || (orDefault.a & 4) == 0) ? false : true)) {
                        j.e(K4);
                        boolean h3 = K4.h(8192);
                        j jVar2 = this.N;
                        K4.g();
                        j.c l2 = jVar2.l(K4);
                        if (h3) {
                            c0(K4, l2);
                        } else {
                            e.s.a.y yVar7 = this.f201g;
                            y.a orDefault2 = yVar7.a.getOrDefault(K4, null);
                            if (orDefault2 == null) {
                                orDefault2 = y.a.a();
                                yVar7.a.put(K4, orDefault2);
                            }
                            orDefault2.a |= 2;
                            orDefault2.b = l2;
                        }
                    }
                }
            }
        }
        l();
        V(true);
        o0(false);
        this.i0.f251d = 2;
    }

    public void removeDetachedView(View view, boolean z2) {
        b0 K2 = K(view);
        if (K2 != null) {
            if (K2.o()) {
                K2.f218j &= -257;
            } else if (!K2.u()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(K2);
                throw new IllegalArgumentException(f.a.a.a.a.m(this, sb));
            }
        }
        view.clearAnimation();
        p(view);
        super.removeDetachedView(view, z2);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.n.z0(this, view, view2) && view2 != null) {
            e0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.n.K0(this, view, rect, z2, false);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.q.get(i2).c(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.w != 0 || this.y) {
            this.x = true;
        } else {
            super.requestLayout();
        }
    }

    public final void s() {
        m0();
        U();
        this.i0.a(6);
        this.f199e.c();
        this.i0.f252e = this.m.c();
        y yVar = this.i0;
        yVar.c = 0;
        yVar.f254g = false;
        this.n.v0(this.c, yVar);
        y yVar2 = this.i0;
        yVar2.f253f = false;
        this.f198d = null;
        yVar2.f257j = yVar2.f257j && this.N != null;
        yVar2.f251d = 4;
        V(true);
        o0(false);
    }

    public void scrollBy(int i2, int i3) {
        m mVar = this.n;
        if (mVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.y) {
            boolean e2 = mVar.e();
            boolean f2 = this.n.f();
            if (e2 || f2) {
                if (!e2) {
                    i2 = 0;
                }
                if (!f2) {
                    i3 = 0;
                }
                g0(i2, i3, null);
            }
        }
    }

    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i2 = 0;
        if (O()) {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            if (contentChangeTypes != 0) {
                i2 = contentChangeTypes;
            }
            this.A |= i2;
            i2 = 1;
        }
        if (i2 == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(e.s.a.u uVar) {
        this.p0 = uVar;
        e.i.i.l.r(this, uVar);
    }

    public void setAdapter(e eVar) {
        setLayoutFrozen(false);
        e eVar2 = this.m;
        if (eVar2 != null) {
            eVar2.a.unregisterObserver(this.b);
            this.m.j(this);
        }
        d0();
        e.s.a.a aVar = this.f199e;
        aVar.l(aVar.b);
        aVar.l(aVar.c);
        aVar.f1775f = 0;
        e eVar3 = this.m;
        this.m = eVar;
        if (eVar != null) {
            eVar.a.registerObserver(this.b);
            eVar.f(this);
        }
        m mVar = this.n;
        if (mVar != null) {
            mVar.d0();
        }
        t tVar = this.c;
        e eVar4 = this.m;
        tVar.b();
        s d2 = tVar.d();
        Objects.requireNonNull(d2);
        if (eVar3 != null) {
            d2.b--;
        }
        if (d2.b == 0) {
            for (int i2 = 0; i2 < d2.a.size(); i2++) {
                d2.a.valueAt(i2).a.clear();
            }
        }
        if (eVar4 != null) {
            d2.b++;
        }
        this.i0.f253f = true;
        b0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(h hVar) {
        if (hVar != this.q0) {
            this.q0 = hVar;
            setChildrenDrawingOrderEnabled(hVar != null);
        }
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.f202h) {
            N();
        }
        this.f202h = z2;
        super.setClipToPadding(z2);
        if (this.v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(i iVar) {
        Objects.requireNonNull(iVar);
        this.I = iVar;
        N();
    }

    public void setHasFixedSize(boolean z2) {
        this.t = z2;
    }

    public void setItemAnimator(j jVar) {
        j jVar2 = this.N;
        if (jVar2 != null) {
            jVar2.j();
            this.N.a = null;
        }
        this.N = jVar;
        if (jVar != null) {
            jVar.a = this.n0;
        }
    }

    public void setItemViewCacheSize(int i2) {
        t tVar = this.c;
        tVar.f237e = i2;
        tVar.l();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(m mVar) {
        if (mVar != this.n) {
            q0();
            if (this.n != null) {
                j jVar = this.N;
                if (jVar != null) {
                    jVar.j();
                }
                this.n.F0(this.c);
                this.n.G0(this.c);
                this.c.b();
                if (this.s) {
                    m mVar2 = this.n;
                    t tVar = this.c;
                    mVar2.f229i = false;
                    mVar2.h0(this, tVar);
                }
                this.n.T0(null);
                this.n = null;
            } else {
                this.c.b();
            }
            e.s.a.b bVar = this.f200f;
            b.a aVar = bVar.b;
            aVar.a = 0;
            b.a aVar2 = aVar.b;
            if (aVar2 != null) {
                aVar2.g();
            }
            int size = bVar.c.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                e.s.a.s sVar = (e.s.a.s) bVar.a;
                Objects.requireNonNull(sVar);
                b0 K2 = K(bVar.c.get(size));
                if (K2 != null) {
                    sVar.a.j0(K2, K2.p);
                    K2.p = 0;
                }
                bVar.c.remove(size);
            }
            e.s.a.s sVar2 = (e.s.a.s) bVar.a;
            int b2 = sVar2.b();
            for (int i2 = 0; i2 < b2; i2++) {
                View a2 = sVar2.a(i2);
                sVar2.a.p(a2);
                a2.clearAnimation();
            }
            sVar2.a.removeAllViews();
            this.n = mVar;
            if (mVar != null) {
                if (mVar.b == null) {
                    mVar.T0(this);
                    if (this.s) {
                        m mVar3 = this.n;
                        mVar3.f229i = true;
                        mVar3.f0();
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LayoutManager ");
                    sb.append(mVar);
                    sb.append(" is already attached to a RecyclerView:");
                    throw new IllegalArgumentException(f.a.a.a.a.m(mVar.b, sb));
                }
            }
            this.c.l();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z2) {
        e.i.i.f scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f1465d) {
            View view = scrollingChildHelper.c;
            AtomicInteger atomicInteger = e.i.i.l.a;
            view.stopNestedScroll();
        }
        scrollingChildHelper.f1465d = z2;
    }

    public void setOnFlingListener(p pVar) {
        this.W = pVar;
    }

    @Deprecated
    public void setOnScrollListener(r rVar) {
        this.j0 = rVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.e0 = z2;
    }

    public void setRecycledViewPool(s sVar) {
        t tVar = this.c;
        s sVar2 = tVar.f239g;
        if (sVar2 != null) {
            sVar2.b--;
        }
        tVar.f239g = sVar;
        if (sVar != null && RecyclerView.this.getAdapter() != null) {
            tVar.f239g.b++;
        }
    }

    public void setRecyclerListener(u uVar) {
        this.o = uVar;
    }

    public void setScrollState(int i2) {
        x xVar;
        if (i2 != this.O) {
            this.O = i2;
            if (i2 != 2) {
                this.f0.c();
                m mVar = this.n;
                if (!(mVar == null || (xVar = mVar.f227g) == null)) {
                    xVar.d();
                }
            }
            m mVar2 = this.n;
            if (mVar2 != null) {
                mVar2.C0(i2);
            }
            X();
            r rVar = this.j0;
            if (rVar != null) {
                rVar.a(this, i2);
            }
            List<r> list = this.k0;
            if (list != null) {
                int size = list.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        this.k0.get(size).a(this, i2);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setScrollingTouchSlop(int i2) {
        int i3;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                i3 = viewConfiguration.getScaledPagingTouchSlop();
                this.V = i3;
            }
        }
        i3 = viewConfiguration.getScaledTouchSlop();
        this.V = i3;
    }

    public void setViewCacheExtension(z zVar) {
        Objects.requireNonNull(this.c);
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().i(i2, 0);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().j(0);
    }

    public final void suppressLayout(boolean z2) {
        if (z2 != this.y) {
            i("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.y = false;
                if (!(!this.x || this.n == null || this.m == null)) {
                    requestLayout();
                }
                this.x = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.y = true;
            this.z = true;
            q0();
        }
    }

    public boolean t(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().c(i2, i3, iArr, null, i4);
    }

    public final void u(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().f(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void v(int i2, int i3) {
        this.H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        Y();
        r rVar = this.j0;
        if (rVar != null) {
            rVar.b(this, i2, i3);
        }
        List<r> list = this.k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.k0.get(size).b(this, i2, i3);
            }
        }
        this.H--;
    }

    public void w() {
        int i2;
        int i3;
        if (this.M == null) {
            EdgeEffect a2 = this.I.a(this);
            this.M = a2;
            if (this.f202h) {
                i3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i3 = getMeasuredWidth();
                i2 = getMeasuredHeight();
            }
            a2.setSize(i3, i2);
        }
    }

    public void x() {
        int i2;
        int i3;
        if (this.J == null) {
            EdgeEffect a2 = this.I.a(this);
            this.J = a2;
            if (this.f202h) {
                i3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i3 = getMeasuredHeight();
                i2 = getMeasuredWidth();
            }
            a2.setSize(i3, i2);
        }
    }

    public void y() {
        int i2;
        int i3;
        if (this.L == null) {
            EdgeEffect a2 = this.I.a(this);
            this.L = a2;
            if (this.f202h) {
                i3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i3 = getMeasuredHeight();
                i2 = getMeasuredWidth();
            }
            a2.setSize(i3, i2);
        }
    }

    public void z() {
        int i2;
        int i3;
        if (this.K == null) {
            EdgeEffect a2 = this.I.a(this);
            this.K = a2;
            if (this.f202h) {
                i3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i3 = getMeasuredWidth();
                i2 = getMeasuredHeight();
            }
            a2.setSize(i3, i2);
        }
    }
}
