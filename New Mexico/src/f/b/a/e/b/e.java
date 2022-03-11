package f.b.a.e.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import e.j.j.v;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class e<V extends View> extends g<V> {
    public Runnable c;

    /* renamed from: d  reason: collision with root package name */
    public OverScroller f2880d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2881e;

    /* renamed from: g  reason: collision with root package name */
    public int f2883g;

    /* renamed from: i  reason: collision with root package name */
    public VelocityTracker f2885i;

    /* renamed from: f  reason: collision with root package name */
    public int f2882f = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f2884h = -1;

    /* JADX WARN: Field signature parse error: c
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: TV at position 1 ('V'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:170)
    	at jadx.core.dex.visitors.SignatureProcessor.parseFieldSignature(SignatureProcessor.java:83)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:33)
     */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final CoordinatorLayout b;
        public final View c;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.b = coordinatorLayout;
            this.c = v;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.c != null && (overScroller = e.this.f2880d) != null) {
                if (overScroller.computeScrollOffset()) {
                    e eVar = e.this;
                    eVar.G(this.b, this.c, eVar.f2880d.getCurrY());
                    v.d.m(this.c, this);
                    return;
                }
                e eVar2 = e.this;
                CoordinatorLayout coordinatorLayout = this.b;
                View view = this.c;
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) eVar2;
                Objects.requireNonNull(baseBehavior);
                AppBarLayout appBarLayout = (AppBarLayout) view;
                baseBehavior.O(coordinatorLayout, appBarLayout);
                if (appBarLayout.f498k) {
                    appBarLayout.c(appBarLayout.d(baseBehavior.K(coordinatorLayout)));
                }
            }
        }
    }

    public e() {
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f2882f);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                this.f2883g = y;
                F(coordinatorLayout, v, this.f2883g - y, -((AppBarLayout) v).getDownNestedScrollRange(), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i2 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.f2882f = motionEvent.getPointerId(i2);
                    this.f2883g = (int) (motionEvent.getY(i2) + 0.5f);
                }
            }
            z = false;
            velocityTracker = this.f2885i;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (!this.f2881e && !z) {
                return false;
            }
        } else {
            VelocityTracker velocityTracker3 = this.f2885i;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.f2885i.computeCurrentVelocity(1000);
                float yVelocity = this.f2885i.getYVelocity(this.f2882f);
                AppBarLayout appBarLayout = (AppBarLayout) v;
                int i3 = -appBarLayout.getTotalScrollRange();
                Runnable runnable = this.c;
                if (runnable != null) {
                    v.removeCallbacks(runnable);
                    this.c = null;
                }
                if (this.f2880d == null) {
                    this.f2880d = new OverScroller(v.getContext());
                }
                this.f2880d.fling(0, B(), 0, Math.round(yVelocity), 0, 0, i3, 0);
                if (this.f2880d.computeScrollOffset()) {
                    a aVar = new a(coordinatorLayout, v);
                    this.c = aVar;
                    AtomicInteger atomicInteger = v.a;
                    v.d.m(v, aVar);
                } else {
                    AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) this;
                    baseBehavior.O(coordinatorLayout, appBarLayout);
                    if (appBarLayout.f498k) {
                        appBarLayout.c(appBarLayout.d(baseBehavior.K(coordinatorLayout)));
                    }
                }
                z = true;
                this.f2881e = false;
                this.f2882f = -1;
                velocityTracker2 = this.f2885i;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f2885i = null;
                }
                velocityTracker = this.f2885i;
                if (velocityTracker != null) {
                }
                return !this.f2881e ? true : true;
            }
        }
        z = false;
        this.f2881e = false;
        this.f2882f = -1;
        velocityTracker2 = this.f2885i;
        if (velocityTracker2 != null) {
        }
        velocityTracker = this.f2885i;
        if (velocityTracker != null) {
        }
        if (!this.f2881e) {
        }
    }

    public abstract int E();

    public final int F(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return H(coordinatorLayout, v, E() - i2, i3, i4);
    }

    public int G(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return H(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int H(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        View view;
        int findPointerIndex;
        if (this.f2884h < 0) {
            this.f2884h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f2881e) {
            int i2 = this.f2882f;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.f2883g) > this.f2884h) {
                this.f2883g = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f2882f = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            AppBarLayout appBarLayout = (AppBarLayout) v;
            WeakReference<View> weakReference = ((AppBarLayout.BaseBehavior) this).n;
            boolean z = (weakReference == null || ((view = weakReference.get()) != null && view.isShown() && !view.canScrollVertically(-1))) && coordinatorLayout.p(v, x, y2);
            this.f2881e = z;
            if (z) {
                this.f2883g = y2;
                this.f2882f = motionEvent.getPointerId(0);
                if (this.f2885i == null) {
                    this.f2885i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f2880d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f2880d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f2885i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }
}
