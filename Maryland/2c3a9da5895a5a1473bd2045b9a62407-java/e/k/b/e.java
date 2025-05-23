package e.k.b;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import e.i.i.m;
import java.util.Arrays;
import java.util.Objects;

public class e {
    public static final Interpolator v = new a();
    public int a;
    public int b;
    public int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public float[] f1546d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f1547e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f1548f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f1549g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f1550h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f1551i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f1552j;

    /* renamed from: k  reason: collision with root package name */
    public int f1553k;

    /* renamed from: l  reason: collision with root package name */
    public VelocityTracker f1554l;
    public float m;
    public float n;
    public int o;
    public OverScroller p;
    public final c q;
    public View r;
    public boolean s;
    public final ViewGroup t;
    public final Runnable u = new b();

    public static class a implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            e.this.s(0);
        }
    }

    public static abstract class c {
        public abstract int a(View view, int i2, int i3);

        public abstract int b(View view, int i2, int i3);

        public int c(View view) {
            return 0;
        }

        public int d(View view) {
            return 0;
        }

        public void e(View view, int i2) {
        }

        public abstract void f(int i2);

        public abstract void g(View view, int i2, int i3, int i4, int i5);

        public abstract void h(View view, float f2, float f3);

        public abstract boolean i(View view, int i2);
    }

    public e(Context context, ViewGroup viewGroup, c cVar) {
        if (cVar != null) {
            this.t = viewGroup;
            this.q = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.p = new OverScroller(context, v);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    public void a() {
        this.c = -1;
        float[] fArr = this.f1546d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f1547e, 0.0f);
            Arrays.fill(this.f1548f, 0.0f);
            Arrays.fill(this.f1549g, 0.0f);
            Arrays.fill(this.f1550h, 0);
            Arrays.fill(this.f1551i, 0);
            Arrays.fill(this.f1552j, 0);
            this.f1553k = 0;
        }
        VelocityTracker velocityTracker = this.f1554l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1554l = null;
        }
    }

    public void b(View view, int i2) {
        if (view.getParent() == this.t) {
            this.r = view;
            this.c = i2;
            this.q.e(view, i2);
            s(1);
            return;
        }
        StringBuilder h2 = f.a.a.a.a.h("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        h2.append(this.t);
        h2.append(")");
        throw new IllegalArgumentException(h2.toString());
    }

    public final boolean c(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f1550h[i2] & i3) != i3 || (0 & i3) == 0 || (this.f1552j[i2] & i3) == i3 || (this.f1551i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs < abs2 * 0.5f) {
            Objects.requireNonNull(this.q);
        }
        return (this.f1551i[i2] & i3) == 0 && abs > ((float) this.b);
    }

    public final boolean d(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.q.c(view) > 0;
        boolean z2 = this.q.d(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.b) : z2 && Math.abs(f3) > ((float) this.b);
        }
        float f4 = f3 * f3;
        int i2 = this.b;
        return f4 + (f2 * f2) > ((float) (i2 * i2));
    }

    public final float e(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    public final int f(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    public final void g(int i2) {
        float[] fArr = this.f1546d;
        if (fArr != null) {
            int i3 = this.f1553k;
            boolean z = true;
            int i4 = 1 << i2;
            if ((i4 & i3) == 0) {
                z = false;
            }
            if (z) {
                fArr[i2] = 0.0f;
                this.f1547e[i2] = 0.0f;
                this.f1548f[i2] = 0.0f;
                this.f1549g[i2] = 0.0f;
                this.f1550h[i2] = 0;
                this.f1551i[i2] = 0;
                this.f1552j[i2] = 0;
                this.f1553k = (~i4) & i3;
            }
        }
    }

    public final int h(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.t.getWidth();
        float f2 = (float) (width / 2);
        float sin = (((float) Math.sin((double) ((Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width)) - 0.5f) * 0.47123894f))) * f2) + f2;
        int abs = Math.abs(i3);
        return Math.min(abs > 0 ? Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f), 600);
    }

    public boolean i(boolean z) {
        if (this.a == 2) {
            boolean computeScrollOffset = this.p.computeScrollOffset();
            int currX = this.p.getCurrX();
            int currY = this.p.getCurrY();
            int left = currX - this.r.getLeft();
            int top = currY - this.r.getTop();
            if (left != 0) {
                m.l(this.r, left);
            }
            if (top != 0) {
                m.m(this.r, top);
            }
            if (!(left == 0 && top == 0)) {
                this.q.g(this.r, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.p.getFinalX() && currY == this.p.getFinalY()) {
                this.p.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.t.post(this.u);
                } else {
                    s(0);
                }
            }
        }
        return this.a == 2;
    }

    public final void j(float f2, float f3) {
        this.s = true;
        this.q.h(this.r, f2, f3);
        this.s = false;
        if (this.a == 1) {
            s(0);
        }
    }

    public View k(int i2, int i3) {
        for (int childCount = this.t.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.t;
            Objects.requireNonNull(this.q);
            View childAt = viewGroup.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean l(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int left = this.r.getLeft();
        int top = this.r.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.p.abortAnimation();
            s(0);
            return false;
        }
        View view = this.r;
        int f6 = f(i4, (int) this.n, (int) this.m);
        int f7 = f(i5, (int) this.n, (int) this.m);
        int abs = Math.abs(i6);
        int abs2 = Math.abs(i7);
        int abs3 = Math.abs(f6);
        int abs4 = Math.abs(f7);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (f6 != 0) {
            f2 = (float) abs3;
            f3 = (float) i8;
        } else {
            f2 = (float) abs;
            f3 = (float) i9;
        }
        float f8 = f2 / f3;
        if (f7 != 0) {
            f5 = (float) abs4;
            f4 = (float) i8;
        } else {
            f5 = (float) abs2;
            f4 = (float) i9;
        }
        int h2 = h(i6, f6, this.q.c(view));
        float h3 = ((float) h(i7, f7, this.q.d(view))) * (f5 / f4);
        this.p.startScroll(left, top, i6, i7, (int) (h3 + (((float) h2) * f8)));
        s(2);
        return true;
    }

    public final boolean m(int i2) {
        if ((this.f1553k & (1 << i2)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public void n(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1554l == null) {
            this.f1554l = VelocityTracker.obtain();
        }
        this.f1554l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.a != 1) {
                        int pointerCount = motionEvent.getPointerCount();
                        while (i3 < pointerCount) {
                            int pointerId = motionEvent.getPointerId(i3);
                            if (m(pointerId)) {
                                float x = motionEvent.getX(i3);
                                float y = motionEvent.getY(i3);
                                float f2 = x - this.f1546d[pointerId];
                                float f3 = y - this.f1547e[pointerId];
                                p(f2, f3, pointerId);
                                if (this.a != 1) {
                                    View k2 = k((int) x, (int) y);
                                    if (d(k2, f2, f3) && v(k2, pointerId)) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            i3++;
                        }
                    } else if (m(this.c)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.c);
                        float x2 = motionEvent.getX(findPointerIndex);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.f1548f;
                        int i4 = this.c;
                        int i5 = (int) (x2 - fArr[i4]);
                        int i6 = (int) (y2 - this.f1549g[i4]);
                        int left = this.r.getLeft() + i5;
                        int top = this.r.getTop() + i6;
                        int left2 = this.r.getLeft();
                        int top2 = this.r.getTop();
                        if (i5 != 0) {
                            left = this.q.a(this.r, left, i5);
                            m.l(this.r, left - left2);
                        }
                        if (i6 != 0) {
                            top = this.q.b(this.r, top, i6);
                            m.m(this.r, top - top2);
                        }
                        if (!(i5 == 0 && i6 == 0)) {
                            this.q.g(this.r, left, top, left - left2, top - top2);
                        }
                    } else {
                        return;
                    }
                    r(motionEvent);
                    return;
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        float x3 = motionEvent.getX(actionIndex);
                        float y3 = motionEvent.getY(actionIndex);
                        q(x3, y3, pointerId2);
                        if (this.a == 0) {
                            v(k((int) x3, (int) y3), pointerId2);
                            if ((this.f1550h[pointerId2] & 0) == 0) {
                                return;
                            }
                        } else {
                            int i7 = (int) x3;
                            int i8 = (int) y3;
                            View view = this.r;
                            if (view != null && i7 >= view.getLeft() && i7 < view.getRight() && i8 >= view.getTop() && i8 < view.getBottom()) {
                                i3 = 1;
                            }
                            if (i3 != 0) {
                                v(this.r, pointerId2);
                                return;
                            }
                            return;
                        }
                    } else if (actionMasked == 6) {
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        if (this.a == 1 && pointerId3 == this.c) {
                            int pointerCount2 = motionEvent.getPointerCount();
                            while (true) {
                                if (i3 >= pointerCount2) {
                                    i2 = -1;
                                    break;
                                }
                                int pointerId4 = motionEvent.getPointerId(i3);
                                if (pointerId4 != this.c) {
                                    View k3 = k((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                                    View view2 = this.r;
                                    if (k3 == view2 && v(view2, pointerId4)) {
                                        i2 = this.c;
                                        break;
                                    }
                                }
                                i3++;
                            }
                            if (i2 == -1) {
                                o();
                            }
                        }
                        g(pointerId3);
                        return;
                    } else {
                        return;
                    }
                } else if (this.a == 1) {
                    j(0.0f, 0.0f);
                }
            } else if (this.a == 1) {
                o();
            }
            a();
            return;
        }
        float x4 = motionEvent.getX();
        float y4 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View k4 = k((int) x4, (int) y4);
        q(x4, y4, pointerId5);
        v(k4, pointerId5);
        if ((this.f1550h[pointerId5] & 0) == 0) {
            return;
        }
        Objects.requireNonNull(this.q);
    }

    public final void o() {
        this.f1554l.computeCurrentVelocity(1000, this.m);
        j(e(this.f1554l.getXVelocity(this.c), this.n, this.m), e(this.f1554l.getYVelocity(this.c), this.n, this.m));
    }

    public final void p(float f2, float f3, int i2) {
        int i3 = 1;
        if (!c(f2, f3, i2, 1)) {
            i3 = 0;
        }
        if (c(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (c(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (c(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.f1551i;
            iArr[i2] = iArr[i2] | i3;
            Objects.requireNonNull(this.q);
        }
    }

    public final void q(float f2, float f3, int i2) {
        float[] fArr = this.f1546d;
        int i3 = 0;
        if (fArr == null || fArr.length <= i2) {
            int i4 = i2 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f1547e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f1548f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f1549g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f1550h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1551i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1552j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1546d = fArr2;
            this.f1547e = fArr3;
            this.f1548f = fArr4;
            this.f1549g = fArr5;
            this.f1550h = iArr;
            this.f1551i = iArr2;
            this.f1552j = iArr3;
        }
        float[] fArr9 = this.f1546d;
        this.f1548f[i2] = f2;
        fArr9[i2] = f2;
        float[] fArr10 = this.f1547e;
        this.f1549g[i2] = f3;
        fArr10[i2] = f3;
        int[] iArr7 = this.f1550h;
        int i5 = (int) f2;
        int i6 = (int) f3;
        if (i5 < this.t.getLeft() + this.o) {
            i3 = 1;
        }
        if (i6 < this.t.getTop() + this.o) {
            i3 |= 4;
        }
        if (i5 > this.t.getRight() - this.o) {
            i3 |= 2;
        }
        if (i6 > this.t.getBottom() - this.o) {
            i3 |= 8;
        }
        iArr7[i2] = i3;
        this.f1553k |= 1 << i2;
    }

    public final void r(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (m(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f1548f[pointerId] = x;
                this.f1549g[pointerId] = y;
            }
        }
    }

    public void s(int i2) {
        this.t.removeCallbacks(this.u);
        if (this.a != i2) {
            this.a = i2;
            this.q.f(i2);
            if (this.a == 0) {
                this.r = null;
            }
        }
    }

    public boolean t(int i2, int i3) {
        if (this.s) {
            return l(i2, i3, (int) this.f1554l.getXVelocity(this.c), (int) this.f1554l.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    public boolean u(MotionEvent motionEvent) {
        View k2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1554l == null) {
            this.f1554l = VelocityTracker.obtain();
        }
        this.f1554l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x = motionEvent.getX(actionIndex);
                            float y = motionEvent.getY(actionIndex);
                            q(x, y, pointerId);
                            int i2 = this.a;
                            if (i2 == 0) {
                                if ((this.f1550h[pointerId] & 0) != 0) {
                                    Objects.requireNonNull(this.q);
                                }
                            } else if (i2 == 2 && (k2 = k((int) x, (int) y)) == this.r) {
                                v(k2, pointerId);
                            }
                        } else if (actionMasked == 6) {
                            g(motionEvent.getPointerId(actionIndex));
                        }
                    }
                } else if (!(this.f1546d == null || this.f1547e == null)) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i3 = 0; i3 < pointerCount; i3++) {
                        int pointerId2 = motionEvent.getPointerId(i3);
                        if (m(pointerId2)) {
                            float x2 = motionEvent.getX(i3);
                            float y2 = motionEvent.getY(i3);
                            float f2 = x2 - this.f1546d[pointerId2];
                            float f3 = y2 - this.f1547e[pointerId2];
                            View k3 = k((int) x2, (int) y2);
                            boolean z = k3 != null && d(k3, f2, f3);
                            if (z) {
                                int left = k3.getLeft();
                                int i4 = (int) f2;
                                int a2 = this.q.a(k3, left + i4, i4);
                                int top = k3.getTop();
                                int i5 = (int) f3;
                                int b2 = this.q.b(k3, top + i5, i5);
                                int c2 = this.q.c(k3);
                                int d2 = this.q.d(k3);
                                if (c2 != 0) {
                                    if (c2 > 0) {
                                    }
                                }
                                if (d2 != 0) {
                                    if (d2 > 0 && b2 == top) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            p(f2, f3, pointerId2);
                            if (this.a != 1) {
                                if (z && v(k3, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    r(motionEvent);
                }
            }
            a();
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId3 = motionEvent.getPointerId(0);
            q(x3, y3, pointerId3);
            View k4 = k((int) x3, (int) y3);
            if (k4 == this.r && this.a == 2) {
                v(k4, pointerId3);
            }
            if ((this.f1550h[pointerId3] & 0) != 0) {
                Objects.requireNonNull(this.q);
            }
        }
        if (this.a == 1) {
            return true;
        }
        return false;
    }

    public boolean v(View view, int i2) {
        if (view == this.r && this.c == i2) {
            return true;
        }
        if (view == null || !this.q.i(view, i2)) {
            return false;
        }
        this.c = i2;
        b(view, i2);
        return true;
    }
}
