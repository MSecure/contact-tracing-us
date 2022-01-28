package com.swmansion.gesturehandler;

import android.os.Handler;
import android.view.MotionEvent;
import com.facebook.react.uimanager.BaseViewManager;
import com.horcrux.svg.PathParser;

public class TapGestureHandler extends GestureHandler<TapGestureHandler> {
    public final Runnable mFailDelayed = new Runnable() {
        /* class com.swmansion.gesturehandler.TapGestureHandler.AnonymousClass1 */

        public void run() {
            TapGestureHandler.this.fail();
        }
    };
    public Handler mHandler;
    public float mLastX;
    public float mLastY;
    public long mMaxDelayMs = 500;
    public float mMaxDeltaX = Float.MIN_VALUE;
    public float mMaxDeltaY = Float.MIN_VALUE;
    public float mMaxDistSq = Float.MIN_VALUE;
    public long mMaxDurationMs = 500;
    public int mMinNumberOfPointers = 1;
    public int mNumberOfPointers = 1;
    public int mNumberOfTaps = 1;
    public float mOffsetX;
    public float mOffsetY;
    public float mStartX;
    public float mStartY;
    public int mTapsSoFar;

    public TapGestureHandler() {
        this.mShouldCancelWhenOutside = true;
    }

    @Override // com.swmansion.gesturehandler.GestureHandler
    public void onCancel() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ab  */
    @Override // com.swmansion.gesturehandler.GestureHandler
    public void onHandle(MotionEvent motionEvent) {
        boolean z;
        int i = this.mState;
        int actionMasked = motionEvent.getActionMasked();
        if (i == 0) {
            this.mOffsetX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mOffsetY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mStartX = motionEvent.getRawX();
            this.mStartY = motionEvent.getRawY();
        }
        if (actionMasked == 6 || actionMasked == 5) {
            this.mOffsetX = (this.mLastX - this.mStartX) + this.mOffsetX;
            this.mOffsetY = (this.mLastY - this.mStartY) + this.mOffsetY;
            this.mLastX = PathParser.getLastPointerX(motionEvent, true);
            float lastPointerY = PathParser.getLastPointerY(motionEvent, true);
            this.mLastY = lastPointerY;
            this.mStartX = this.mLastX;
            this.mStartY = lastPointerY;
        } else {
            this.mLastX = PathParser.getLastPointerX(motionEvent, true);
            this.mLastY = PathParser.getLastPointerY(motionEvent, true);
        }
        if (this.mNumberOfPointers < motionEvent.getPointerCount()) {
            this.mNumberOfPointers = motionEvent.getPointerCount();
        }
        float f = (this.mLastX - this.mStartX) + this.mOffsetX;
        if (this.mMaxDeltaX == Float.MIN_VALUE || Math.abs(f) <= this.mMaxDeltaX) {
            float f2 = (this.mLastY - this.mStartY) + this.mOffsetY;
            if (this.mMaxDeltaY == Float.MIN_VALUE || Math.abs(f2) <= this.mMaxDeltaY) {
                float f3 = (f * f) + (f2 * f2);
                float f4 = this.mMaxDistSq;
                if (f4 == Float.MIN_VALUE || f3 <= f4) {
                    z = false;
                    if (!z) {
                        fail();
                        return;
                    } else if (i == 0) {
                        if (actionMasked == 0) {
                            begin();
                        }
                        startTap();
                        return;
                    } else if (i != 2) {
                        return;
                    } else {
                        if (actionMasked == 1) {
                            Handler handler = this.mHandler;
                            if (handler == null) {
                                this.mHandler = new Handler();
                            } else {
                                handler.removeCallbacksAndMessages(null);
                            }
                            int i2 = this.mTapsSoFar + 1;
                            this.mTapsSoFar = i2;
                            if (i2 != this.mNumberOfTaps || this.mNumberOfPointers < this.mMinNumberOfPointers) {
                                this.mHandler.postDelayed(this.mFailDelayed, this.mMaxDelayMs);
                                return;
                            }
                            activate();
                            end();
                            return;
                        } else if (actionMasked == 0) {
                            startTap();
                            return;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
        z = true;
        if (!z) {
        }
    }

    @Override // com.swmansion.gesturehandler.GestureHandler
    public void onReset() {
        this.mTapsSoFar = 0;
        this.mNumberOfPointers = 0;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void startTap() {
        Handler handler = this.mHandler;
        if (handler == null) {
            this.mHandler = new Handler();
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandler.postDelayed(this.mFailDelayed, this.mMaxDurationMs);
    }
}
