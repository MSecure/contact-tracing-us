package e.t.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$id;
import androidx.recyclerview.widget.RecyclerView;
import e.i.i.g;
import e.i.i.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class k extends RecyclerView.l implements RecyclerView.o {
    public final RecyclerView.q A = new b();
    public Rect B;
    public long C;
    public final List<View> a = new ArrayList();
    public final float[] b = new float[2];
    public RecyclerView.b0 c = null;

    /* renamed from: d  reason: collision with root package name */
    public float f1916d;

    /* renamed from: e  reason: collision with root package name */
    public float f1917e;

    /* renamed from: f  reason: collision with root package name */
    public float f1918f;

    /* renamed from: g  reason: collision with root package name */
    public float f1919g;

    /* renamed from: h  reason: collision with root package name */
    public float f1920h;

    /* renamed from: i  reason: collision with root package name */
    public float f1921i;

    /* renamed from: j  reason: collision with root package name */
    public float f1922j;

    /* renamed from: k  reason: collision with root package name */
    public float f1923k;

    /* renamed from: l  reason: collision with root package name */
    public int f1924l = -1;
    public d m;
    public int n = 0;
    public int o;
    public List<f> p = new ArrayList();
    public int q;
    public RecyclerView r;
    public final Runnable s = new a();
    public VelocityTracker t;
    public List<RecyclerView.b0> u;
    public List<Integer> v;
    public View w = null;
    public int x = -1;
    public e.i.i.g y;
    public e z;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00e4  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x010a  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
        public void run() {
            int i2;
            int i3;
            int i4;
            k kVar = k.this;
            RecyclerView.b0 b0Var = kVar.c;
            if (b0Var != null) {
                boolean z = false;
                if (b0Var != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = kVar.C;
                    long j3 = j2 == Long.MIN_VALUE ? 0 : currentTimeMillis - j2;
                    RecyclerView.m layoutManager = kVar.r.getLayoutManager();
                    if (kVar.B == null) {
                        kVar.B = new Rect();
                    }
                    layoutManager.e(kVar.c.a, kVar.B);
                    if (layoutManager.f()) {
                        int i5 = (int) (kVar.f1922j + kVar.f1920h);
                        int paddingLeft = (i5 - kVar.B.left) - kVar.r.getPaddingLeft();
                        float f2 = kVar.f1920h;
                        if ((f2 < 0.0f && paddingLeft < 0) || (f2 > 0.0f && (paddingLeft = ((kVar.c.a.getWidth() + i5) + kVar.B.right) - (kVar.r.getWidth() - kVar.r.getPaddingRight())) > 0)) {
                            i2 = paddingLeft;
                            if (layoutManager.g()) {
                                int i6 = (int) (kVar.f1923k + kVar.f1921i);
                                int paddingTop = (i6 - kVar.B.top) - kVar.r.getPaddingTop();
                                float f3 = kVar.f1921i;
                                if ((f3 < 0.0f && paddingTop < 0) || (f3 > 0.0f && (paddingTop = ((kVar.c.a.getHeight() + i6) + kVar.B.bottom) - (kVar.r.getHeight() - kVar.r.getPaddingBottom())) > 0)) {
                                    i3 = paddingTop;
                                    if (i2 != 0) {
                                        d dVar = kVar.m;
                                        RecyclerView recyclerView = kVar.r;
                                        int width = kVar.c.a.getWidth();
                                        kVar.r.getWidth();
                                        i2 = dVar.e(recyclerView, width, i2, j3);
                                    }
                                    if (i3 != 0) {
                                        d dVar2 = kVar.m;
                                        RecyclerView recyclerView2 = kVar.r;
                                        int height = kVar.c.a.getHeight();
                                        kVar.r.getHeight();
                                        i4 = i2;
                                        i3 = dVar2.e(recyclerView2, height, i3, j3);
                                    } else {
                                        i4 = i2;
                                    }
                                    if (!(i4 == 0 && i3 == 0)) {
                                        if (kVar.C == Long.MIN_VALUE) {
                                            kVar.C = currentTimeMillis;
                                        }
                                        kVar.r.scrollBy(i4, i3);
                                        z = true;
                                        if (!z) {
                                            k kVar2 = k.this;
                                            RecyclerView.b0 b0Var2 = kVar2.c;
                                            if (b0Var2 != null) {
                                                kVar2.p(b0Var2);
                                            }
                                            k kVar3 = k.this;
                                            kVar3.r.removeCallbacks(kVar3.s);
                                            RecyclerView recyclerView3 = k.this.r;
                                            AtomicInteger atomicInteger = v.a;
                                            v.d.m(recyclerView3, this);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            i3 = 0;
                            if (i2 != 0) {
                            }
                            if (i3 != 0) {
                            }
                            if (kVar.C == Long.MIN_VALUE) {
                            }
                            kVar.r.scrollBy(i4, i3);
                            z = true;
                            if (!z) {
                            }
                        }
                    }
                    i2 = 0;
                    if (layoutManager.g()) {
                    }
                    i3 = 0;
                    if (i2 != 0) {
                    }
                    if (i3 != 0) {
                    }
                    if (kVar.C == Long.MIN_VALUE) {
                    }
                    kVar.r.scrollBy(i4, i3);
                    z = true;
                    if (!z) {
                    }
                }
                kVar.C = Long.MIN_VALUE;
                if (!z) {
                }
            }
        }
    }

    public class b implements RecyclerView.q {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            ((g.b) k.this.y.a).a.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            f fVar = null;
            if (actionMasked == 0) {
                k.this.f1924l = motionEvent.getPointerId(0);
                k.this.f1916d = motionEvent.getX();
                k.this.f1917e = motionEvent.getY();
                k kVar = k.this;
                VelocityTracker velocityTracker = kVar.t;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                }
                kVar.t = VelocityTracker.obtain();
                k kVar2 = k.this;
                if (kVar2.c == null) {
                    if (!kVar2.p.isEmpty()) {
                        View m = kVar2.m(motionEvent);
                        int size = kVar2.p.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            }
                            f fVar2 = kVar2.p.get(size);
                            if (fVar2.f1926e.a == m) {
                                fVar = fVar2;
                                break;
                            }
                            size--;
                        }
                    }
                    if (fVar != null) {
                        k kVar3 = k.this;
                        kVar3.f1916d -= fVar.f1930i;
                        kVar3.f1917e -= fVar.f1931j;
                        kVar3.l(fVar.f1926e, true);
                        if (k.this.a.remove(fVar.f1926e.a)) {
                            k.this.m.a(fVar.f1926e);
                        }
                        k.this.r(fVar.f1926e, fVar.f1927f);
                        k kVar4 = k.this;
                        kVar4.s(motionEvent, kVar4.o, 0);
                    }
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                k kVar5 = k.this;
                kVar5.f1924l = -1;
                kVar5.r(null, 0);
            } else {
                int i2 = k.this.f1924l;
                if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) >= 0) {
                    k.this.j(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker2 = k.this.t;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (k.this.c != null) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            ((g.b) k.this.y.a).a.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = k.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (k.this.f1924l != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(k.this.f1924l);
                if (findPointerIndex >= 0) {
                    k.this.j(actionMasked, motionEvent, findPointerIndex);
                }
                k kVar = k.this;
                RecyclerView.b0 b0Var = kVar.c;
                if (b0Var != null) {
                    int i2 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = kVar.t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                k kVar2 = k.this;
                                if (pointerId == kVar2.f1924l) {
                                    if (actionIndex == 0) {
                                        i2 = 1;
                                    }
                                    kVar2.f1924l = motionEvent.getPointerId(i2);
                                    k kVar3 = k.this;
                                    kVar3.s(motionEvent, kVar3.o, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            kVar.s(motionEvent, kVar.o, findPointerIndex);
                            k.this.p(b0Var);
                            k kVar4 = k.this;
                            kVar4.r.removeCallbacks(kVar4.s);
                            k.this.s.run();
                            k.this.r.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    k.this.r(null, 0);
                    k.this.f1924l = -1;
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void e(boolean z) {
            if (z) {
                k.this.r(null, 0);
            }
        }
    }

    public class c extends f {
        public final /* synthetic */ int n;
        public final /* synthetic */ RecyclerView.b0 o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(RecyclerView.b0 b0Var, int i2, int i3, float f2, float f3, float f4, float f5, int i4, RecyclerView.b0 b0Var2) {
            super(b0Var, i2, i3, f2, f3, f4, f5);
            this.n = i4;
            this.o = b0Var2;
        }

        @Override // e.t.a.k.f
        public void onAnimationEnd(Animator animator) {
            if (!this.f1933l) {
                this.f1926e.t(true);
            }
            this.f1933l = true;
            if (!this.f1932k) {
                if (this.n <= 0) {
                    k kVar = k.this;
                    d dVar = kVar.m;
                    RecyclerView recyclerView = kVar.r;
                    dVar.a(this.o);
                } else {
                    k.this.a.add(this.o.a);
                    this.f1929h = true;
                    int i2 = this.n;
                    if (i2 > 0) {
                        k kVar2 = k.this;
                        kVar2.r.post(new l(kVar2, this, i2));
                    }
                }
                k kVar3 = k.this;
                View view = kVar3.w;
                View view2 = this.o.a;
                if (view == view2) {
                    kVar3.q(view2);
                }
            }
        }
    }

    public static abstract class d {
        public static final Interpolator b = new a();
        public static final Interpolator c = new b();
        public int a = -1;

        public static class a implements Interpolator {
            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        }

        public static class b implements Interpolator {
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        }

        public static int c(int i2, int i3) {
            int i4;
            int i5 = i2 & 789516;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= -789517 & i7;
                i4 = (i7 & 789516) << 2;
            }
            return i6 | i4;
        }

        public void a(RecyclerView.b0 b0Var) {
            View view = b0Var.a;
            int i2 = R$id.item_touch_helper_previous_elevation;
            Object tag = view.getTag(i2);
            if (tag instanceof Float) {
                float floatValue = ((Float) tag).floatValue();
                AtomicInteger atomicInteger = v.a;
                v.i.s(view, floatValue);
            }
            view.setTag(i2, null);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }

        public int b(int i2, int i3) {
            int i4;
            int i5 = i2 & 3158064;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= -3158065 & i7;
                i4 = (i7 & 3158064) >> 2;
            }
            return i6 | i4;
        }

        public final int d(RecyclerView recyclerView, RecyclerView.b0 b0Var) {
            g gVar = (g) this;
            int i2 = gVar.f1935e;
            int i3 = gVar.f1934d;
            int i4 = (i3 << 8) | ((i3 | i2) << 0) | (i2 << 16);
            AtomicInteger atomicInteger = v.a;
            return b(i4, v.e.d(recyclerView));
        }

        public int e(RecyclerView recyclerView, int i2, int i3, long j2) {
            if (this.a == -1) {
                this.a = recyclerView.getResources().getDimensionPixelSize(R$dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            int i4 = this.a;
            float f2 = 1.0f;
            float min = Math.min(1.0f, (((float) Math.abs(i3)) * 1.0f) / ((float) i2)) - 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i3)) * i4)) * ((min * min * min * min * min) + 1.0f));
            if (j2 <= 2000) {
                f2 = ((float) j2) / 2000.0f;
            }
            int i5 = (int) (((float) signum) * f2 * f2 * f2 * f2 * f2);
            if (i5 != 0) {
                return i5;
            }
            if (i3 > 0) {
                return 1;
            }
            return -1;
        }

        public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var, float f2, float f3, int i2, boolean z) {
            View view = b0Var.a;
            if (z && view.getTag(R$id.item_touch_helper_previous_elevation) == null) {
                AtomicInteger atomicInteger = v.a;
                Float valueOf = Float.valueOf(v.i.i(view));
                int childCount = recyclerView.getChildCount();
                float f4 = 0.0f;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = recyclerView.getChildAt(i3);
                    if (childAt != view) {
                        AtomicInteger atomicInteger2 = v.a;
                        float i4 = v.i.i(childAt);
                        if (i4 > f4) {
                            f4 = i4;
                        }
                    }
                }
                v.i.s(view, f4 + 1.0f);
                view.setTag(R$id.item_touch_helper_previous_elevation, valueOf);
            }
            view.setTranslationX(f2);
            view.setTranslationY(f3);
        }
    }

    public class e extends GestureDetector.SimpleOnGestureListener {
        public boolean a = true;

        public e() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View m;
            RecyclerView.b0 J;
            int i2;
            if (this.a && (m = k.this.m(motionEvent)) != null && (J = k.this.r.J(m)) != null) {
                k kVar = k.this;
                if (((kVar.m.d(kVar.r, J) & 16711680) != 0) && motionEvent.getPointerId(0) == (i2 = k.this.f1924l)) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    k kVar2 = k.this;
                    kVar2.f1916d = x;
                    kVar2.f1917e = y;
                    kVar2.f1921i = 0.0f;
                    kVar2.f1920h = 0.0f;
                    Objects.requireNonNull(kVar2.m);
                    k.this.r(J, 2);
                }
            }
        }
    }

    public static class f implements Animator.AnimatorListener {
        public final float a;
        public final float b;
        public final float c;

        /* renamed from: d  reason: collision with root package name */
        public final float f1925d;

        /* renamed from: e  reason: collision with root package name */
        public final RecyclerView.b0 f1926e;

        /* renamed from: f  reason: collision with root package name */
        public final int f1927f;

        /* renamed from: g  reason: collision with root package name */
        public final ValueAnimator f1928g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f1929h;

        /* renamed from: i  reason: collision with root package name */
        public float f1930i;

        /* renamed from: j  reason: collision with root package name */
        public float f1931j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f1932k = false;

        /* renamed from: l  reason: collision with root package name */
        public boolean f1933l = false;
        public float m;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.m = valueAnimator.getAnimatedFraction();
            }
        }

        public f(RecyclerView.b0 b0Var, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.f1927f = i3;
            this.f1926e = b0Var;
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.f1925d = f5;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f1928g = ofFloat;
            ofFloat.addUpdateListener(new a());
            ofFloat.setTarget(b0Var.a);
            ofFloat.addListener(this);
            this.m = 0.0f;
        }

        public void onAnimationCancel(Animator animator) {
            this.m = 1.0f;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f1933l) {
                this.f1926e.t(true);
            }
            this.f1933l = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static abstract class g extends d {

        /* renamed from: d  reason: collision with root package name */
        public int f1934d;

        /* renamed from: e  reason: collision with root package name */
        public int f1935e;

        public g(int i2, int i3) {
            this.f1934d = i3;
            this.f1935e = i2;
        }
    }

    public k(d dVar) {
        this.m = dVar;
    }

    public static boolean o(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d(View view) {
        q(view);
        RecyclerView.b0 J = this.r.J(view);
        if (J != null) {
            RecyclerView.b0 b0Var = this.c;
            if (b0Var == null || J != b0Var) {
                l(J, false);
                if (this.a.remove(J.a)) {
                    this.m.a(J);
                    return;
                }
                return;
            }
            r(null, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void f(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        float f2;
        float f3;
        this.x = -1;
        if (this.c != null) {
            n(this.b);
            float[] fArr = this.b;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        d dVar = this.m;
        RecyclerView.b0 b0Var = this.c;
        List<f> list = this.p;
        int i2 = this.n;
        Objects.requireNonNull(dVar);
        int i3 = 0;
        for (int size = list.size(); i3 < size; size = size) {
            f fVar = list.get(i3);
            float f5 = fVar.a;
            float f6 = fVar.c;
            fVar.f1930i = f5 == f6 ? fVar.f1926e.a.getTranslationX() : f.a.a.a.a.a(f6, f5, fVar.m, f5);
            float f7 = fVar.b;
            float f8 = fVar.f1925d;
            fVar.f1931j = f7 == f8 ? fVar.f1926e.a.getTranslationY() : f.a.a.a.a.a(f8, f7, fVar.m, f7);
            int save = canvas.save();
            dVar.f(canvas, recyclerView, fVar.f1926e, fVar.f1930i, fVar.f1931j, fVar.f1927f, false);
            canvas.restoreToCount(save);
            i3++;
        }
        if (b0Var != null) {
            int save2 = canvas.save();
            dVar.f(canvas, recyclerView, b0Var, f3, f2, i2, true);
            canvas.restoreToCount(save2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void h(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        boolean z2 = false;
        if (this.c != null) {
            n(this.b);
            float[] fArr = this.b;
            float f2 = fArr[0];
            float f3 = fArr[1];
        }
        d dVar = this.m;
        RecyclerView.b0 b0Var = this.c;
        List<f> list = this.p;
        Objects.requireNonNull(dVar);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int save = canvas.save();
            View view = list.get(i2).f1926e.a;
            canvas.restoreToCount(save);
        }
        if (b0Var != null) {
            canvas.restoreToCount(canvas.save());
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            f fVar = list.get(i3);
            boolean z3 = fVar.f1933l;
            if (z3 && !fVar.f1929h) {
                list.remove(i3);
            } else if (!z3) {
                z2 = true;
            }
        }
        if (z2) {
            recyclerView.invalidate();
        }
    }

    public final int i(RecyclerView.b0 b0Var, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = 4;
        int i4 = this.f1920h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.f1924l > -1) {
            d dVar = this.m;
            float f2 = this.f1919g;
            Objects.requireNonNull(dVar);
            velocityTracker.computeCurrentVelocity(1000, f2);
            float xVelocity = this.t.getXVelocity(this.f1924l);
            float yVelocity = this.t.getYVelocity(this.f1924l);
            if (xVelocity > 0.0f) {
                i3 = 8;
            }
            float abs = Math.abs(xVelocity);
            if ((i3 & i2) != 0 && i4 == i3) {
                d dVar2 = this.m;
                float f3 = this.f1918f;
                Objects.requireNonNull(dVar2);
                if (abs >= f3 && abs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
        }
        Objects.requireNonNull(this.m);
        float width = ((float) this.r.getWidth()) * 0.5f;
        if ((i2 & i4) == 0 || Math.abs(this.f1920h) <= width) {
            return 0;
        }
        return i4;
    }

    public void j(int i2, MotionEvent motionEvent, int i3) {
        int d2;
        View m2;
        if (this.c == null && i2 == 2 && this.n != 2) {
            Objects.requireNonNull(this.m);
            if (this.r.getScrollState() != 1) {
                RecyclerView.m layoutManager = this.r.getLayoutManager();
                int i4 = this.f1924l;
                RecyclerView.b0 b0Var = null;
                if (i4 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i4);
                    float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f1916d);
                    float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f1917e);
                    float f2 = (float) this.q;
                    if ((abs >= f2 || abs2 >= f2) && ((abs <= abs2 || !layoutManager.f()) && ((abs2 <= abs || !layoutManager.g()) && (m2 = m(motionEvent)) != null))) {
                        b0Var = this.r.J(m2);
                    }
                }
                if (b0Var != null && (d2 = (this.m.d(this.r, b0Var) & 65280) >> 8) != 0) {
                    float x2 = motionEvent.getX(i3);
                    float y2 = motionEvent.getY(i3);
                    float f3 = x2 - this.f1916d;
                    float f4 = y2 - this.f1917e;
                    float abs3 = Math.abs(f3);
                    float abs4 = Math.abs(f4);
                    float f5 = (float) this.q;
                    if (abs3 >= f5 || abs4 >= f5) {
                        if (abs3 > abs4) {
                            if (f3 < 0.0f && (d2 & 4) == 0) {
                                return;
                            }
                            if (f3 > 0.0f && (d2 & 8) == 0) {
                                return;
                            }
                        } else if (f4 < 0.0f && (d2 & 1) == 0) {
                            return;
                        } else {
                            if (f4 > 0.0f && (d2 & 2) == 0) {
                                return;
                            }
                        }
                        this.f1921i = 0.0f;
                        this.f1920h = 0.0f;
                        this.f1924l = motionEvent.getPointerId(0);
                        r(b0Var, 1);
                    }
                }
            }
        }
    }

    public final int k(RecyclerView.b0 b0Var, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = 1;
        int i4 = this.f1921i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.f1924l > -1) {
            d dVar = this.m;
            float f2 = this.f1919g;
            Objects.requireNonNull(dVar);
            velocityTracker.computeCurrentVelocity(1000, f2);
            float xVelocity = this.t.getXVelocity(this.f1924l);
            float yVelocity = this.t.getYVelocity(this.f1924l);
            if (yVelocity > 0.0f) {
                i3 = 2;
            }
            float abs = Math.abs(yVelocity);
            if ((i3 & i2) != 0 && i3 == i4) {
                d dVar2 = this.m;
                float f3 = this.f1918f;
                Objects.requireNonNull(dVar2);
                if (abs >= f3 && abs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
        }
        Objects.requireNonNull(this.m);
        float height = ((float) this.r.getHeight()) * 0.5f;
        if ((i2 & i4) == 0 || Math.abs(this.f1921i) <= height) {
            return 0;
        }
        return i4;
    }

    public void l(RecyclerView.b0 b0Var, boolean z2) {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            f fVar = this.p.get(size);
            if (fVar.f1926e == b0Var) {
                fVar.f1932k |= z2;
                if (!fVar.f1933l) {
                    fVar.f1928g.cancel();
                }
                this.p.remove(size);
                return;
            }
        }
    }

    public View m(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        RecyclerView.b0 b0Var = this.c;
        if (b0Var != null) {
            View view = b0Var.a;
            if (o(view, x2, y2, this.f1922j + this.f1920h, this.f1923k + this.f1921i)) {
                return view;
            }
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            f fVar = this.p.get(size);
            View view2 = fVar.f1926e.a;
            if (o(view2, x2, y2, fVar.f1930i, fVar.f1931j)) {
                return view2;
            }
        }
        RecyclerView recyclerView = this.r;
        int e2 = recyclerView.f212f.e();
        while (true) {
            e2--;
            if (e2 < 0) {
                return null;
            }
            View d2 = recyclerView.f212f.d(e2);
            float translationX = d2.getTranslationX();
            float translationY = d2.getTranslationY();
            if (x2 >= ((float) d2.getLeft()) + translationX && x2 <= ((float) d2.getRight()) + translationX && y2 >= ((float) d2.getTop()) + translationY && y2 <= ((float) d2.getBottom()) + translationY) {
                return d2;
            }
        }
    }

    public final void n(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.f1922j + this.f1920h) - ((float) this.c.a.getLeft());
        } else {
            fArr[0] = this.c.a.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.f1923k + this.f1921i) - ((float) this.c.a.getTop());
        } else {
            fArr[1] = this.c.a.getTranslationY();
        }
    }

    public void p(RecyclerView.b0 b0Var) {
        List<RecyclerView.b0> list;
        int bottom;
        int abs;
        int top;
        int abs2;
        int left;
        int abs3;
        int right;
        int abs4;
        int i2;
        int i3;
        if (!this.r.isLayoutRequested() && this.n == 2) {
            Objects.requireNonNull(this.m);
            int i4 = (int) (this.f1922j + this.f1920h);
            int i5 = (int) (this.f1923k + this.f1921i);
            if (((float) Math.abs(i5 - b0Var.a.getTop())) >= ((float) b0Var.a.getHeight()) * 0.5f || ((float) Math.abs(i4 - b0Var.a.getLeft())) >= ((float) b0Var.a.getWidth()) * 0.5f) {
                List<RecyclerView.b0> list2 = this.u;
                if (list2 == null) {
                    this.u = new ArrayList();
                    this.v = new ArrayList();
                } else {
                    list2.clear();
                    this.v.clear();
                }
                Objects.requireNonNull(this.m);
                int round = Math.round(this.f1922j + this.f1920h) - 0;
                int round2 = Math.round(this.f1923k + this.f1921i) - 0;
                int width = b0Var.a.getWidth() + round + 0;
                int height = b0Var.a.getHeight() + round2 + 0;
                int i6 = (round + width) / 2;
                int i7 = (round2 + height) / 2;
                RecyclerView.m layoutManager = this.r.getLayoutManager();
                int z2 = layoutManager.z();
                int i8 = 0;
                while (i8 < z2) {
                    View y2 = layoutManager.y(i8);
                    if (y2 != b0Var.a && y2.getBottom() >= round2 && y2.getTop() <= height && y2.getRight() >= round && y2.getLeft() <= width) {
                        RecyclerView.b0 J = this.r.J(y2);
                        Objects.requireNonNull(this.m);
                        int abs5 = Math.abs(i6 - ((y2.getRight() + y2.getLeft()) / 2));
                        int abs6 = Math.abs(i7 - ((y2.getBottom() + y2.getTop()) / 2));
                        int i9 = (abs6 * abs6) + (abs5 * abs5);
                        i3 = round;
                        i2 = round2;
                        int i10 = 0;
                        int i11 = 0;
                        for (int size = this.u.size(); i10 < size && i9 > this.v.get(i10).intValue(); size = size) {
                            i11++;
                            i10++;
                        }
                        this.u.add(i11, J);
                        this.v.add(i11, Integer.valueOf(i9));
                    } else {
                        i3 = round;
                        i2 = round2;
                    }
                    i8++;
                    round = i3;
                    round2 = i2;
                }
                List<RecyclerView.b0> list3 = this.u;
                if (list3.size() != 0) {
                    Objects.requireNonNull(this.m);
                    int width2 = b0Var.a.getWidth() + i4;
                    int height2 = b0Var.a.getHeight() + i5;
                    int left2 = i4 - b0Var.a.getLeft();
                    int top2 = i5 - b0Var.a.getTop();
                    int size2 = list3.size();
                    RecyclerView.b0 b0Var2 = null;
                    int i12 = 0;
                    int i13 = -1;
                    while (i12 < size2) {
                        RecyclerView.b0 b0Var3 = list3.get(i12);
                        if (left2 <= 0 || (right = b0Var3.a.getRight() - width2) >= 0) {
                            list = list3;
                        } else {
                            list = list3;
                            if (b0Var3.a.getRight() > b0Var.a.getRight() && (abs4 = Math.abs(right)) > i13) {
                                i13 = abs4;
                                b0Var2 = b0Var3;
                            }
                        }
                        if (left2 < 0 && (left = b0Var3.a.getLeft() - i4) > 0 && b0Var3.a.getLeft() < b0Var.a.getLeft() && (abs3 = Math.abs(left)) > i13) {
                            i13 = abs3;
                            b0Var2 = b0Var3;
                        }
                        if (top2 < 0 && (top = b0Var3.a.getTop() - i5) > 0 && b0Var3.a.getTop() < b0Var.a.getTop() && (abs2 = Math.abs(top)) > i13) {
                            i13 = abs2;
                            b0Var2 = b0Var3;
                        }
                        if (top2 > 0 && (bottom = b0Var3.a.getBottom() - height2) < 0 && b0Var3.a.getBottom() > b0Var.a.getBottom() && (abs = Math.abs(bottom)) > i13) {
                            i13 = abs;
                            b0Var2 = b0Var3;
                        }
                        i12++;
                        list3 = list;
                    }
                    if (b0Var2 == null) {
                        this.u.clear();
                        this.v.clear();
                        return;
                    }
                    b0Var2.e();
                    b0Var.e();
                    Objects.requireNonNull(this.m);
                }
            }
        }
    }

    public void q(View view) {
        if (view == this.w) {
            this.w = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a0, code lost:
        if (r3 > 0) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01c7  */
    public void r(RecyclerView.b0 b0Var, int i2) {
        boolean z2;
        boolean z3;
        ViewParent parent;
        RecyclerView.b0 b0Var2;
        int i3;
        float f2;
        float f3;
        long j2;
        float f4;
        int i4;
        if (b0Var != this.c || i2 != this.n) {
            this.C = Long.MIN_VALUE;
            int i5 = this.n;
            l(b0Var, true);
            this.n = i2;
            if (i2 == 2) {
                if (b0Var != null) {
                    this.w = b0Var.a;
                } else {
                    throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
                }
            }
            int i6 = (1 << ((i2 * 8) + 8)) - 1;
            RecyclerView.b0 b0Var3 = this.c;
            if (b0Var3 != null) {
                if (b0Var3.a.getParent() != null) {
                    if (i5 == 2) {
                        i3 = 0;
                    } else {
                        if (this.n != 2) {
                            d dVar = this.m;
                            RecyclerView recyclerView = this.r;
                            g gVar = (g) dVar;
                            int i7 = gVar.f1935e;
                            int i8 = gVar.f1934d;
                            int i9 = (i8 << 8) | ((i8 | i7) << 0) | (i7 << 16);
                            AtomicInteger atomicInteger = v.a;
                            int b2 = (dVar.b(i9, v.e.d(recyclerView)) & 65280) >> 8;
                            if (b2 != 0) {
                                int i10 = (65280 & i9) >> 8;
                                if (Math.abs(this.f1920h) > Math.abs(this.f1921i)) {
                                    i4 = i(b0Var3, b2);
                                    if (i4 <= 0) {
                                        i4 = k(b0Var3, b2);
                                    } else if ((i10 & i4) == 0) {
                                        i4 = d.c(i4, v.e.d(this.r));
                                    }
                                    i3 = i4;
                                } else {
                                    i4 = k(b0Var3, b2);
                                    if (i4 <= 0) {
                                        int i11 = i(b0Var3, b2);
                                        if (i11 > 0) {
                                            if ((i10 & i11) == 0) {
                                                i11 = d.c(i11, v.e.d(this.r));
                                            }
                                            i4 = i11;
                                        }
                                    }
                                    i3 = i4;
                                }
                            }
                        }
                        i4 = 0;
                        i3 = i4;
                    }
                    VelocityTracker velocityTracker = this.t;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.t = null;
                    }
                    if (i3 == 1 || i3 == 2) {
                        f2 = Math.signum(this.f1921i) * ((float) this.r.getHeight());
                        f3 = 0.0f;
                    } else {
                        if (i3 == 4 || i3 == 8 || i3 == 16 || i3 == 32) {
                            f4 = Math.signum(this.f1920h) * ((float) this.r.getWidth());
                        } else {
                            f4 = 0.0f;
                        }
                        f3 = f4;
                        f2 = 0.0f;
                    }
                    int i12 = i5 == 2 ? 8 : i3 > 0 ? 2 : 4;
                    n(this.b);
                    float[] fArr = this.b;
                    c cVar = new c(b0Var3, i12, i5, fArr[0], fArr[1], f3, f2, i3, b0Var3);
                    d dVar2 = this.m;
                    RecyclerView recyclerView2 = this.r;
                    Objects.requireNonNull(dVar2);
                    RecyclerView.j itemAnimator = recyclerView2.getItemAnimator();
                    if (itemAnimator == null) {
                        j2 = i12 == 8 ? 200 : 250;
                    } else if (i12 == 8) {
                        j2 = itemAnimator.f234e;
                    } else {
                        j2 = itemAnimator.f233d;
                    }
                    cVar.f1928g.setDuration(j2);
                    this.p.add(cVar);
                    cVar.f1926e.t(false);
                    cVar.f1928g.start();
                    b0Var2 = null;
                    z2 = true;
                } else {
                    q(b0Var3.a);
                    this.m.a(b0Var3);
                    b0Var2 = null;
                    z2 = false;
                }
                this.c = b0Var2;
            } else {
                z2 = false;
            }
            if (b0Var != null) {
                this.o = (this.m.d(this.r, b0Var) & i6) >> (this.n * 8);
                this.f1922j = (float) b0Var.a.getLeft();
                this.f1923k = (float) b0Var.a.getTop();
                this.c = b0Var;
                if (i2 == 2) {
                    z3 = false;
                    b0Var.a.performHapticFeedback(0);
                    parent = this.r.getParent();
                    if (parent != null) {
                        if (this.c != null) {
                            z3 = true;
                        }
                        parent.requestDisallowInterceptTouchEvent(z3);
                    }
                    if (!z2) {
                        this.r.getLayoutManager().f240h = true;
                    }
                    Objects.requireNonNull(this.m);
                    this.r.invalidate();
                }
            }
            z3 = false;
            parent = this.r.getParent();
            if (parent != null) {
            }
            if (!z2) {
            }
            Objects.requireNonNull(this.m);
            this.r.invalidate();
        }
    }

    public void s(MotionEvent motionEvent, int i2, int i3) {
        float x2 = motionEvent.getX(i3);
        float y2 = motionEvent.getY(i3);
        float f2 = x2 - this.f1916d;
        this.f1920h = f2;
        this.f1921i = y2 - this.f1917e;
        if ((i2 & 4) == 0) {
            this.f1920h = Math.max(0.0f, f2);
        }
        if ((i2 & 8) == 0) {
            this.f1920h = Math.min(0.0f, this.f1920h);
        }
        if ((i2 & 1) == 0) {
            this.f1921i = Math.max(0.0f, this.f1921i);
        }
        if ((i2 & 2) == 0) {
            this.f1921i = Math.min(0.0f, this.f1921i);
        }
    }
}
