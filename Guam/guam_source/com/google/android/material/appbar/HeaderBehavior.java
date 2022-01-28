package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;

public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public int activePointerId = -1;
    public Runnable flingRunnable;
    public boolean isBeingDragged;
    public int lastMotionY;
    public OverScroller scroller;
    public int touchSlop = -1;
    public VelocityTracker velocityTracker;

    public class FlingRunnable implements Runnable {
        public final V layout;
        public final CoordinatorLayout parent;

        public FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.parent = coordinatorLayout;
            this.layout = v;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.google.android.material.appbar.HeaderBehavior */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            OverScroller overScroller;
            if (this.layout != null && (overScroller = HeaderBehavior.this.scroller) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.setHeaderTopBottomOffset(this.parent, this.layout, headerBehavior.scroller.getCurrY());
                    ViewCompat.postOnAnimation(this.layout, this);
                    return;
                }
                HeaderBehavior headerBehavior2 = HeaderBehavior.this;
                CoordinatorLayout coordinatorLayout = this.parent;
                V v = this.layout;
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) headerBehavior2;
                if (baseBehavior != null) {
                    V v2 = v;
                    baseBehavior.snapToChildIfNeeded(coordinatorLayout, v2);
                    if (v2.liftOnScroll) {
                        v2.setLiftedState(v2.shouldLift(baseBehavior.findFirstScrollingChild(coordinatorLayout)));
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    public HeaderBehavior() {
    }

    public abstract boolean canDragView(V v);

    public abstract int getTopBottomOffsetForScrollingSibling();

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r0 != 3) goto L_0x008a;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.isBeingDragged) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.activePointerId;
                    if (!(i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1)) {
                        int y = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y - this.lastMotionY) > this.touchSlop) {
                            this.isBeingDragged = true;
                            this.lastMotionY = y;
                        }
                    }
                }
            }
            this.isBeingDragged = false;
            this.activePointerId = -1;
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.velocityTracker = null;
            }
        } else {
            this.isBeingDragged = false;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (canDragView(v) && coordinatorLayout.isPointInChildBounds(v, x, y2)) {
                this.lastMotionY = y2;
                this.activePointerId = motionEvent.getPointerId(0);
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
            }
        }
        VelocityTracker velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return this.isBeingDragged;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r0 != 3) goto L_0x0117;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int i;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                    this.velocityTracker.computeCurrentVelocity(1000);
                    float yVelocity = this.velocityTracker.getYVelocity(this.activePointerId);
                    AppBarLayout appBarLayout = (AppBarLayout) v;
                    int i2 = -appBarLayout.getTotalScrollRange();
                    Runnable runnable = this.flingRunnable;
                    if (runnable != null) {
                        v.removeCallbacks(runnable);
                        this.flingRunnable = null;
                    }
                    if (this.scroller == null) {
                        this.scroller = new OverScroller(v.getContext());
                    }
                    this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(yVelocity), 0, 0, i2, 0);
                    if (this.scroller.computeScrollOffset()) {
                        FlingRunnable flingRunnable2 = new FlingRunnable(coordinatorLayout, v);
                        this.flingRunnable = flingRunnable2;
                        ViewCompat.postOnAnimation(v, flingRunnable2);
                    } else {
                        AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) this;
                        baseBehavior.snapToChildIfNeeded(coordinatorLayout, appBarLayout);
                        if (appBarLayout.liftOnScroll) {
                            appBarLayout.setLiftedState(appBarLayout.shouldLift(baseBehavior.findFirstScrollingChild(coordinatorLayout)));
                        }
                    }
                }
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                int i3 = this.lastMotionY - y;
                if (!this.isBeingDragged && Math.abs(i3) > (i = this.touchSlop)) {
                    this.isBeingDragged = true;
                    i3 = i3 > 0 ? i3 - i : i3 + i;
                }
                if (this.isBeingDragged) {
                    this.lastMotionY = y;
                    scroll(coordinatorLayout, v, i3, -((AppBarLayout) v).getDownNestedScrollRange(), 0);
                }
            }
            this.isBeingDragged = false;
            this.activePointerId = -1;
            VelocityTracker velocityTracker3 = this.velocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.velocityTracker = null;
            }
        } else {
            int y2 = (int) motionEvent.getY();
            if (!coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), y2) || !canDragView(v)) {
                return false;
            }
            this.lastMotionY = y2;
            this.activePointerId = motionEvent.getPointerId(0);
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
        }
        VelocityTracker velocityTracker4 = this.velocityTracker;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(motionEvent);
        }
        return true;
    }

    public final int scroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, i, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
    }

    public abstract int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
