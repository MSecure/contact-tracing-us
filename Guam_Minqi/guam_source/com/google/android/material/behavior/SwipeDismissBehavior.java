package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.facebook.react.uimanager.BaseViewManager;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public float alphaEndSwipeDistance = 0.5f;
    public float alphaStartSwipeDistance = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    public final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        /* class com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1 */
        public int activePointerId = -1;
        public int originalCapturedViewLeft;

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int i3;
            int i4;
            int width;
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int i5 = SwipeDismissBehavior.this.swipeDirection;
            if (i5 != 0) {
                if (i5 != 1) {
                    i3 = this.originalCapturedViewLeft - view.getWidth();
                    i4 = view.getWidth() + this.originalCapturedViewLeft;
                } else if (z) {
                    i3 = this.originalCapturedViewLeft;
                    width = view.getWidth();
                } else {
                    i3 = this.originalCapturedViewLeft - view.getWidth();
                    i4 = this.originalCapturedViewLeft;
                }
                return Math.min(Math.max(i3, i), i4);
            } else if (z) {
                i3 = this.originalCapturedViewLeft - view.getWidth();
                i4 = this.originalCapturedViewLeft;
                return Math.min(Math.max(i3, i), i4);
            } else {
                i3 = this.originalCapturedViewLeft;
                width = view.getWidth();
            }
            i4 = width + i3;
            return Math.min(Math.max(i3, i), i4);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            this.activePointerId = i;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float width = (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaStartSwipeDistance) + ((float) this.originalCapturedViewLeft);
            float width2 = (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaEndSwipeDistance) + ((float) this.originalCapturedViewLeft);
            float f = (float) i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f - ((f - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
            if (java.lang.Math.abs(r8.getLeft() - r7.originalCapturedViewLeft) >= java.lang.Math.round(((float) r8.getWidth()) * r7.this$0.dragDismissThreshold)) goto L_0x002a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            boolean z;
            int i;
            OnDismissListener onDismissListener;
            this.activePointerId = -1;
            int width = view.getWidth();
            int i2 = (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? 1 : (f == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? 0 : -1));
            boolean z2 = true;
            if (i2 != 0) {
                boolean z3 = ViewCompat.getLayoutDirection(view) == 1;
                int i3 = SwipeDismissBehavior.this.swipeDirection;
                if (i3 != 2) {
                    if (i3 == 0) {
                        z = false;
                        if (z) {
                            int left = view.getLeft();
                            int i4 = this.originalCapturedViewLeft;
                            i = left < i4 ? i4 - width : i4 + width;
                        } else {
                            i = this.originalCapturedViewLeft;
                            z2 = false;
                        }
                        if (SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(i, view.getTop())) {
                            ViewCompat.postOnAnimation(view, new SettleRunnable(view, z2));
                            return;
                        } else if (z2 && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                            onDismissListener.onDismiss(view);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        z = false;
                        if (z) {
                        }
                        if (SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(i, view.getTop())) {
                        }
                    }
                }
            }
            z = true;
            if (z) {
            }
            if (SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(i, view.getTop())) {
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            int i2 = this.activePointerId;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }
    };
    public float dragDismissThreshold = 0.5f;
    public boolean interceptingEvents;
    public OnDismissListener listener;
    public float sensitivity = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    public int swipeDirection = 2;
    public ViewDragHelper viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i);
    }

    public class SettleRunnable implements Runnable {
        public final boolean dismiss;
        public final View view;

        public SettleRunnable(View view2, boolean z) {
            this.view = view2;
            this.dismiss = z;
        }

        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.view, this);
            } else if (this.dismiss && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(this.view);
            }
        }
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!z) {
            return false;
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.dragCallback);
        }
        return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null) {
            return false;
        }
        viewDragHelper2.processTouchEvent(motionEvent);
        return true;
    }
}
