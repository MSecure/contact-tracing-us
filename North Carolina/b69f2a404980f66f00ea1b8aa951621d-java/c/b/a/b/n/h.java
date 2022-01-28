package c.b.a.b.n;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.l.m;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;

public abstract class h<V extends View> extends j<V> {

    /* renamed from: d  reason: collision with root package name */
    public Runnable f3147d;

    /* renamed from: e  reason: collision with root package name */
    public OverScroller f3148e;
    public boolean f;
    public int g = -1;
    public int h;
    public int i = -1;
    public VelocityTracker j;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CoordinatorLayout f3149b;

        /* renamed from: c  reason: collision with root package name */
        public final V f3150c;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.f3149b = coordinatorLayout;
            this.f3150c = v;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: c.b.a.b.n.h */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            OverScroller overScroller;
            if (this.f3150c != null && (overScroller = h.this.f3148e) != null) {
                if (overScroller.computeScrollOffset()) {
                    h hVar = h.this;
                    hVar.F(this.f3149b, this.f3150c, hVar.f3148e.getCurrY());
                    this.f3150c.postOnAnimation(this);
                    return;
                }
                h hVar2 = h.this;
                CoordinatorLayout coordinatorLayout = this.f3149b;
                V v = this.f3150c;
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) hVar2;
                if (baseBehavior != null) {
                    V v2 = v;
                    baseBehavior.N(coordinatorLayout, v2);
                    if (v2.l) {
                        v2.d(v2.e(baseBehavior.J(coordinatorLayout)));
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    public h() {
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ee A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.g);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                this.h = y;
                E(coordinatorLayout, v, this.h - y, -((AppBarLayout) v).getDownNestedScrollRange(), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i2 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.g = motionEvent.getPointerId(i2);
                    this.h = (int) (motionEvent.getY(i2) + 0.5f);
                }
            }
            z = false;
            velocityTracker = this.j;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return !this.f || z;
        }
        VelocityTracker velocityTracker3 = this.j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.j.computeCurrentVelocity(1000);
            float yVelocity = this.j.getYVelocity(this.g);
            AppBarLayout appBarLayout = (AppBarLayout) v;
            int i3 = -appBarLayout.getTotalScrollRange();
            Runnable runnable = this.f3147d;
            if (runnable != null) {
                v.removeCallbacks(runnable);
                this.f3147d = null;
            }
            if (this.f3148e == null) {
                this.f3148e = new OverScroller(v.getContext());
            }
            this.f3148e.fling(0, B(), 0, Math.round(yVelocity), 0, 0, i3, 0);
            if (this.f3148e.computeScrollOffset()) {
                a aVar = new a(coordinatorLayout, v);
                this.f3147d = aVar;
                m.M(v, aVar);
            } else {
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) this;
                baseBehavior.N(coordinatorLayout, appBarLayout);
                if (appBarLayout.l) {
                    appBarLayout.d(appBarLayout.e(baseBehavior.J(coordinatorLayout)));
                }
            }
            z = true;
            this.f = false;
            this.g = -1;
            velocityTracker2 = this.j;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.j = null;
            }
            velocityTracker = this.j;
            if (velocityTracker != null) {
            }
            if (!this.f) {
                return true;
            }
        }
        z = false;
        this.f = false;
        this.g = -1;
        velocityTracker2 = this.j;
        if (velocityTracker2 != null) {
        }
        velocityTracker = this.j;
        if (velocityTracker != null) {
        }
        if (!this.f) {
        }
    }

    public abstract int D();

    public final int E(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return G(coordinatorLayout, v, D() - i2, i3, i4);
    }

    public int F(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return G(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int G(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        View view;
        int findPointerIndex;
        if (this.i < 0) {
            this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f) {
            int i2 = this.g;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.h) > this.i) {
                this.h = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.g = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            AppBarLayout appBarLayout = (AppBarLayout) v;
            WeakReference<View> weakReference = ((AppBarLayout.BaseBehavior) this).q;
            boolean z = (weakReference == null || ((view = weakReference.get()) != null && view.isShown() && !view.canScrollVertically(-1))) && coordinatorLayout.l(v, x, y2);
            this.f = z;
            if (z) {
                this.h = y2;
                this.g = motionEvent.getPointerId(0);
                if (this.j == null) {
                    this.j = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f3148e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f3148e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }
}
