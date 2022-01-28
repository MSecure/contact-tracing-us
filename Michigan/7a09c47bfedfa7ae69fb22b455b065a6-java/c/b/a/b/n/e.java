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
import com.google.android.gms.nearby.messages.BleSignal;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;

public abstract class e<V extends View> extends g<V> {

    /* renamed from: d  reason: collision with root package name */
    public Runnable f4446d;

    /* renamed from: e  reason: collision with root package name */
    public OverScroller f4447e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4448f;

    /* renamed from: g  reason: collision with root package name */
    public int f4449g = -1;
    public int h;
    public int i = -1;
    public VelocityTracker j;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CoordinatorLayout f4450b;

        /* renamed from: c  reason: collision with root package name */
        public final V f4451c;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.f4450b = coordinatorLayout;
            this.f4451c = v;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: c.b.a.b.n.e */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            OverScroller overScroller;
            if (this.f4451c != null && (overScroller = e.this.f4447e) != null) {
                if (overScroller.computeScrollOffset()) {
                    e eVar = e.this;
                    eVar.G(this.f4450b, this.f4451c, eVar.f4447e.getCurrY());
                    this.f4451c.postOnAnimation(this);
                    return;
                }
                e eVar2 = e.this;
                CoordinatorLayout coordinatorLayout = this.f4450b;
                V v = this.f4451c;
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) eVar2;
                if (baseBehavior != null) {
                    V v2 = v;
                    baseBehavior.O(coordinatorLayout, v2);
                    if (v2.j) {
                        v2.c(v2.d(baseBehavior.K(coordinatorLayout)));
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    public e() {
    }

    public e(Context context, AttributeSet attributeSet) {
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
                int findPointerIndex = motionEvent.findPointerIndex(this.f4449g);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                this.h = y;
                F(coordinatorLayout, v, this.h - y, -((AppBarLayout) v).getDownNestedScrollRange(), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i2 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.f4449g = motionEvent.getPointerId(i2);
                    this.h = (int) (motionEvent.getY(i2) + 0.5f);
                }
            }
            z = false;
            velocityTracker = this.j;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return !this.f4448f || z;
        }
        VelocityTracker velocityTracker3 = this.j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.j.computeCurrentVelocity(1000);
            float yVelocity = this.j.getYVelocity(this.f4449g);
            AppBarLayout appBarLayout = (AppBarLayout) v;
            int i3 = -appBarLayout.getTotalScrollRange();
            Runnable runnable = this.f4446d;
            if (runnable != null) {
                v.removeCallbacks(runnable);
                this.f4446d = null;
            }
            if (this.f4447e == null) {
                this.f4447e = new OverScroller(v.getContext());
            }
            this.f4447e.fling(0, B(), 0, Math.round(yVelocity), 0, 0, i3, 0);
            if (this.f4447e.computeScrollOffset()) {
                a aVar = new a(coordinatorLayout, v);
                this.f4446d = aVar;
                m.N(v, aVar);
            } else {
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) this;
                baseBehavior.O(coordinatorLayout, appBarLayout);
                if (appBarLayout.j) {
                    appBarLayout.c(appBarLayout.d(baseBehavior.K(coordinatorLayout)));
                }
            }
            z = true;
            this.f4448f = false;
            this.f4449g = -1;
            velocityTracker2 = this.j;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.j = null;
            }
            velocityTracker = this.j;
            if (velocityTracker != null) {
            }
            if (!this.f4448f) {
                return true;
            }
        }
        z = false;
        this.f4448f = false;
        this.f4449g = -1;
        velocityTracker2 = this.j;
        if (velocityTracker2 != null) {
        }
        velocityTracker = this.j;
        if (velocityTracker != null) {
        }
        if (!this.f4448f) {
        }
    }

    public abstract int E();

    public final int F(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return H(coordinatorLayout, v, E() - i2, i3, i4);
    }

    public int G(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return H(coordinatorLayout, v, i2, BleSignal.UNKNOWN_TX_POWER, Integer.MAX_VALUE);
    }

    public abstract int H(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        View view;
        int findPointerIndex;
        if (this.i < 0) {
            this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f4448f) {
            int i2 = this.f4449g;
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
            this.f4449g = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            AppBarLayout appBarLayout = (AppBarLayout) v;
            WeakReference<View> weakReference = ((AppBarLayout.BaseBehavior) this).q;
            boolean z = (weakReference == null || ((view = weakReference.get()) != null && view.isShown() && !view.canScrollVertically(-1))) && coordinatorLayout.l(v, x, y2);
            this.f4448f = z;
            if (z) {
                this.h = y2;
                this.f4449g = motionEvent.getPointerId(0);
                if (this.j == null) {
                    this.j = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f4447e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f4447e.abortAnimation();
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
