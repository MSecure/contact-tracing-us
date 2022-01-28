package b.b.q;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import b.b.p.i.p;

public abstract class h0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final float f845b;

    /* renamed from: c  reason: collision with root package name */
    public final int f846c;

    /* renamed from: d  reason: collision with root package name */
    public final int f847d;

    /* renamed from: e  reason: collision with root package name */
    public final View f848e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f849f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f850g;
    public boolean h;
    public int i;
    public final int[] j = new int[2];

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ViewParent parent = h0.this.f848e.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            h0 h0Var = h0.this;
            h0Var.a();
            View view = h0Var.f848e;
            if (view.isEnabled() && !view.isLongClickable() && h0Var.c()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                h0Var.h = true;
            }
        }
    }

    public h0(View view) {
        this.f848e = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f845b = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f846c = tapTimeout;
        this.f847d = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        Runnable runnable = this.f850g;
        if (runnable != null) {
            this.f848e.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f849f;
        if (runnable2 != null) {
            this.f848e.removeCallbacks(runnable2);
        }
    }

    public abstract p b();

    public abstract boolean c();

    public boolean d() {
        p b2 = b();
        if (b2 == null || !b2.c()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        if (r4 != 3) goto L_0x0079;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0113  */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        f0 f0Var;
        boolean z4 = this.h;
        if (z4) {
            View view2 = this.f848e;
            p b2 = b();
            if (b2 != null && b2.c() && (f0Var = (f0) b2.k()) != null && f0Var.isShown()) {
                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.j;
                view2.getLocationOnScreen(iArr);
                obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
                int[] iArr2 = this.j;
                f0Var.getLocationOnScreen(iArr2);
                obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
                boolean b3 = f0Var.b(obtainNoHistory, this.i);
                obtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z5 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (b3 && z5) {
                    z3 = true;
                    z = !z3 || !d();
                }
            }
            z3 = false;
            if (!z3) {
            }
        } else {
            View view3 = this.f848e;
            if (view3.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 != 0) {
                    if (actionMasked2 != 1) {
                        if (actionMasked2 == 2) {
                            int findPointerIndex = motionEvent.findPointerIndex(this.i);
                            if (findPointerIndex >= 0) {
                                float x = motionEvent.getX(findPointerIndex);
                                float y = motionEvent.getY(findPointerIndex);
                                float f2 = this.f845b;
                                float f3 = -f2;
                                if (!(x >= f3 && y >= f3 && x < ((float) (view3.getRight() - view3.getLeft())) + f2 && y < ((float) (view3.getBottom() - view3.getTop())) + f2)) {
                                    a();
                                    view3.getParent().requestDisallowInterceptTouchEvent(true);
                                    z2 = true;
                                    z = !z2 && c();
                                    if (z) {
                                        long uptimeMillis = SystemClock.uptimeMillis();
                                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                                        this.f848e.onTouchEvent(obtain);
                                        obtain.recycle();
                                    }
                                }
                            }
                        }
                    }
                    a();
                } else {
                    this.i = motionEvent.getPointerId(0);
                    if (this.f849f == null) {
                        this.f849f = new a();
                    }
                    view3.postDelayed(this.f849f, (long) this.f846c);
                    if (this.f850g == null) {
                        this.f850g = new b();
                    }
                    view3.postDelayed(this.f850g, (long) this.f847d);
                }
            }
            z2 = false;
            if (!z2) {
            }
            if (z) {
            }
        }
        this.h = z;
        return z || z4;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.h = false;
        this.i = -1;
        Runnable runnable = this.f849f;
        if (runnable != null) {
            this.f848e.removeCallbacks(runnable);
        }
    }
}
