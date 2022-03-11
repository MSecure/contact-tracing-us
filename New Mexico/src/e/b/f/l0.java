package e.b.f;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import e.b.e.i.p;
/* loaded from: classes.dex */
public abstract class l0 implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public final float b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f987d;

    /* renamed from: e  reason: collision with root package name */
    public final View f988e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f989f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f990g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f991h;

    /* renamed from: i  reason: collision with root package name */
    public int f992i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f993j = new int[2];

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = l0.this.f988e.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l0 l0Var = l0.this;
            l0Var.a();
            View view = l0Var.f988e;
            if (view.isEnabled() && !view.isLongClickable() && l0Var.c()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                l0Var.f991h = true;
            }
        }
    }

    public l0(View view) {
        this.f988e = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.b = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.c = tapTimeout;
        this.f987d = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        Runnable runnable = this.f990g;
        if (runnable != null) {
            this.f988e.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f989f;
        if (runnable2 != null) {
            this.f988e.removeCallbacks(runnable2);
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

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
        if (r4 != 3) goto L_0x0079;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0113  */
    @Override // android.view.View.OnTouchListener
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        j0 j0Var;
        boolean z4 = this.f991h;
        if (z4) {
            View view2 = this.f988e;
            p b2 = b();
            if (b2 != null && b2.c() && (j0Var = (j0) b2.k()) != null && j0Var.isShown()) {
                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.f993j;
                view2.getLocationOnScreen(iArr);
                obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
                int[] iArr2 = this.f993j;
                j0Var.getLocationOnScreen(iArr2);
                obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
                boolean b3 = j0Var.b(obtainNoHistory, this.f992i);
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
            View view3 = this.f988e;
            if (view3.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 != 0) {
                    if (actionMasked2 != 1) {
                        if (actionMasked2 == 2) {
                            int findPointerIndex = motionEvent.findPointerIndex(this.f992i);
                            if (findPointerIndex >= 0) {
                                float x = motionEvent.getX(findPointerIndex);
                                float y = motionEvent.getY(findPointerIndex);
                                float f2 = this.b;
                                float f3 = -f2;
                                if (!(x >= f3 && y >= f3 && x < ((float) (view3.getRight() - view3.getLeft())) + f2 && y < ((float) (view3.getBottom() - view3.getTop())) + f2)) {
                                    a();
                                    view3.getParent().requestDisallowInterceptTouchEvent(true);
                                    z2 = true;
                                    z = !z2 && c();
                                    if (z) {
                                        long uptimeMillis = SystemClock.uptimeMillis();
                                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                                        this.f988e.onTouchEvent(obtain);
                                        obtain.recycle();
                                    }
                                }
                            }
                        }
                    }
                    a();
                } else {
                    this.f992i = motionEvent.getPointerId(0);
                    if (this.f989f == null) {
                        this.f989f = new a();
                    }
                    view3.postDelayed(this.f989f, (long) this.c);
                    if (this.f990g == null) {
                        this.f990g = new b();
                    }
                    view3.postDelayed(this.f990g, (long) this.f987d);
                }
            }
            z2 = false;
            if (!z2) {
            }
            if (z) {
            }
        }
        this.f991h = z;
        if (z || z4) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f991h = false;
        this.f992i = -1;
        Runnable runnable = this.f989f;
        if (runnable != null) {
            this.f988e.removeCallbacks(runnable);
        }
    }
}
