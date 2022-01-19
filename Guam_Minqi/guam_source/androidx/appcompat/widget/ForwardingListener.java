package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;
import com.facebook.react.uimanager.BaseViewManager;

public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public int mActivePointerId;
    public Runnable mDisallowIntercept;
    public boolean mForwarding;
    public final int mLongPressTimeout;
    public final float mScaledTouchSlop;
    public final View mSrc;
    public final int mTapTimeout;
    public final int[] mTmpLocation = new int[2];
    public Runnable mTriggerLongPress;

    public class DisallowIntercept implements Runnable {
        public DisallowIntercept() {
        }

        public void run() {
            ViewParent parent = ForwardingListener.this.mSrc.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class TriggerLongPress implements Runnable {
        public TriggerLongPress() {
        }

        public void run() {
            ForwardingListener forwardingListener = ForwardingListener.this;
            forwardingListener.clearCallbacks();
            View view = forwardingListener.mSrc;
            if (view.isEnabled() && !view.isLongClickable() && forwardingListener.onForwardingStarted()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                forwardingListener.mForwarding = true;
            }
        }
    }

    public ForwardingListener(View view) {
        this.mSrc = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.mScaledTouchSlop = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.mTapTimeout = tapTimeout;
        this.mLongPressTimeout = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void clearCallbacks() {
        Runnable runnable = this.mTriggerLongPress;
        if (runnable != null) {
            this.mSrc.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.mDisallowIntercept;
        if (runnable2 != null) {
            this.mSrc.removeCallbacks(runnable2);
        }
    }

    public abstract ShowableListMenu getPopup();

    public abstract boolean onForwardingStarted();

    public boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return true;
        }
        popup.dismiss();
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
        DropDownListView dropDownListView;
        boolean z4 = this.mForwarding;
        if (z4) {
            View view2 = this.mSrc;
            ShowableListMenu popup = getPopup();
            if (popup != null && popup.isShowing() && (dropDownListView = (DropDownListView) popup.getListView()) != null && dropDownListView.isShown()) {
                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.mTmpLocation;
                view2.getLocationOnScreen(iArr);
                obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
                int[] iArr2 = this.mTmpLocation;
                dropDownListView.getLocationOnScreen(iArr2);
                obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
                boolean onForwardedEvent = dropDownListView.onForwardedEvent(obtainNoHistory, this.mActivePointerId);
                obtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z5 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (onForwardedEvent && z5) {
                    z3 = true;
                    z = !z3 || !onForwardingStopped();
                }
            }
            z3 = false;
            if (!z3) {
            }
        } else {
            View view3 = this.mSrc;
            if (view3.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 != 0) {
                    if (actionMasked2 != 1) {
                        if (actionMasked2 == 2) {
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex >= 0) {
                                float x = motionEvent.getX(findPointerIndex);
                                float y = motionEvent.getY(findPointerIndex);
                                float f = this.mScaledTouchSlop;
                                float f2 = -f;
                                if (!(x >= f2 && y >= f2 && x < ((float) (view3.getRight() - view3.getLeft())) + f && y < ((float) (view3.getBottom() - view3.getTop())) + f)) {
                                    clearCallbacks();
                                    view3.getParent().requestDisallowInterceptTouchEvent(true);
                                    z2 = true;
                                    z = !z2 && onForwardingStarted();
                                    if (z) {
                                        long uptimeMillis = SystemClock.uptimeMillis();
                                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0);
                                        this.mSrc.onTouchEvent(obtain);
                                        obtain.recycle();
                                    }
                                }
                            }
                        }
                    }
                    clearCallbacks();
                } else {
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    if (this.mDisallowIntercept == null) {
                        this.mDisallowIntercept = new DisallowIntercept();
                    }
                    view3.postDelayed(this.mDisallowIntercept, (long) this.mTapTimeout);
                    if (this.mTriggerLongPress == null) {
                        this.mTriggerLongPress = new TriggerLongPress();
                    }
                    view3.postDelayed(this.mTriggerLongPress, (long) this.mLongPressTimeout);
                }
            }
            z2 = false;
            if (!z2) {
            }
            if (z) {
            }
        }
        this.mForwarding = z;
        return z || z4;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        Runnable runnable = this.mDisallowIntercept;
        if (runnable != null) {
            this.mSrc.removeCallbacks(runnable);
        }
    }
}
