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
import e.i.i.m;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class e<V extends View> extends g<V> {
    public Runnable c;

    /* renamed from: d  reason: collision with root package name */
    public OverScroller f2783d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2784e;

    /* renamed from: f  reason: collision with root package name */
    public int f2785f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f2786g;

    /* renamed from: h  reason: collision with root package name */
    public int f2787h = -1;

    /* renamed from: i  reason: collision with root package name */
    public VelocityTracker f2788i;

    /* JADX WARN: Field signature parse error: c */
    public class a implements Runnable {
        public final CoordinatorLayout b;
        public final View c;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.b = coordinatorLayout;
            this.c = v;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: f.b.a.e.b.e */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            OverScroller overScroller;
            if (this.c != null && (overScroller = e.this.f2783d) != null) {
                if (overScroller.computeScrollOffset()) {
                    e eVar = e.this;
                    eVar.G(this.b, this.c, eVar.f2783d.getCurrY());
                    this.c.postOnAnimation(this);
                    return;
                }
                e eVar2 = e.this;
                CoordinatorLayout coordinatorLayout = this.b;
                View view = this.c;
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) eVar2;
                Objects.requireNonNull(baseBehavior);
                AppBarLayout appBarLayout = (AppBarLayout) view;
                baseBehavior.O(coordinatorLayout, appBarLayout);
                if (appBarLayout.f490j) {
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

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f2785f);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                this.f2786g = y;
                F(coordinatorLayout, v, this.f2786g - y, -((AppBarLayout) v).getDownNestedScrollRange(), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i2 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.f2785f = motionEvent.getPointerId(i2);
                    this.f2786g = (int) (motionEvent.getY(i2) + 0.5f);
                }
            }
            z = false;
            velocityTracker = this.f2788i;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (!this.f2784e && !z) {
                return false;
            }
        }
        VelocityTracker velocityTracker3 = this.f2788i;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.f2788i.computeCurrentVelocity(1000);
            float yVelocity = this.f2788i.getYVelocity(this.f2785f);
            AppBarLayout appBarLayout = (AppBarLayout) v;
            int i3 = -appBarLayout.getTotalScrollRange();
            Runnable runnable = this.c;
            if (runnable != null) {
                v.removeCallbacks(runnable);
                this.c = null;
            }
            if (this.f2783d == null) {
                this.f2783d = new OverScroller(v.getContext());
            }
            this.f2783d.fling(0, B(), 0, Math.round(yVelocity), 0, 0, i3, 0);
            if (this.f2783d.computeScrollOffset()) {
                a aVar = new a(coordinatorLayout, v);
                this.c = aVar;
                AtomicInteger atomicInteger = m.a;
                v.postOnAnimation(aVar);
            } else {
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) this;
                baseBehavior.O(coordinatorLayout, appBarLayout);
                if (appBarLayout.f490j) {
                    appBarLayout.c(appBarLayout.d(baseBehavior.K(coordinatorLayout)));
                }
            }
            z = true;
            this.f2784e = false;
            this.f2785f = -1;
            velocityTracker2 = this.f2788i;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f2788i = null;
            }
            velocityTracker = this.f2788i;
            if (velocityTracker != null) {
            }
            return !this.f2784e ? true : true;
        }
        z = false;
        this.f2784e = false;
        this.f2785f = -1;
        velocityTracker2 = this.f2788i;
        if (velocityTracker2 != null) {
        }
        velocityTracker = this.f2788i;
        if (velocityTracker != null) {
        }
        if (!this.f2784e) {
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
        if (this.f2787h < 0) {
            this.f2787h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f2784e) {
            int i2 = this.f2785f;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.f2786g) > this.f2787h) {
                this.f2786g = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f2785f = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            AppBarLayout appBarLayout = (AppBarLayout) v;
            WeakReference<View> weakReference = ((AppBarLayout.BaseBehavior) this).p;
            boolean z = (weakReference == null || ((view = weakReference.get()) != null && view.isShown() && !view.canScrollVertically(-1))) && coordinatorLayout.p(v, x, y2);
            this.f2784e = z;
            if (z) {
                this.f2786g = y2;
                this.f2785f = motionEvent.getPointerId(0);
                if (this.f2788i == null) {
                    this.f2788i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f2783d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f2783d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f2788i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }
}
