package com.swmansion.gesturehandler;

import android.os.Handler;
import android.view.MotionEvent;

public class FlingGestureHandler extends GestureHandler<FlingGestureHandler> {
    public int mDirection = 1;
    public final Runnable mFailDelayed = new Runnable() {
        /* class com.swmansion.gesturehandler.FlingGestureHandler.AnonymousClass1 */

        public void run() {
            FlingGestureHandler.this.fail();
        }
    };
    public Handler mHandler;
    public long mMaxDurationMs = 800;
    public int mMaxNumberOfPointersSimultaneously;
    public long mMinAcceptableDelta = 160;
    public int mNumberOfPointersRequired = 1;
    public float mStartX;
    public float mStartY;

    @Override // com.swmansion.gesturehandler.GestureHandler
    public void onCancel() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.swmansion.gesturehandler.GestureHandler
    public void onHandle(MotionEvent motionEvent) {
        int i = this.mState;
        if (i == 0) {
            this.mStartX = motionEvent.getRawX();
            this.mStartY = motionEvent.getRawY();
            begin();
            this.mMaxNumberOfPointersSimultaneously = 1;
            Handler handler = this.mHandler;
            if (handler == null) {
                this.mHandler = new Handler();
            } else {
                handler.removeCallbacksAndMessages(null);
            }
            this.mHandler.postDelayed(this.mFailDelayed, this.mMaxDurationMs);
        }
        if (i == 2) {
            tryEndFling(motionEvent);
            if (motionEvent.getPointerCount() > this.mMaxNumberOfPointersSimultaneously) {
                this.mMaxNumberOfPointersSimultaneously = motionEvent.getPointerCount();
            }
            if (motionEvent.getActionMasked() == 1 && !tryEndFling(motionEvent)) {
                fail();
            }
        }
    }

    @Override // com.swmansion.gesturehandler.GestureHandler
    public void onReset() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final boolean tryEndFling(MotionEvent motionEvent) {
        if (this.mMaxNumberOfPointersSimultaneously != this.mNumberOfPointersRequired) {
            return false;
        }
        if (((this.mDirection & 1) == 0 || motionEvent.getRawX() - this.mStartX <= ((float) this.mMinAcceptableDelta)) && (((this.mDirection & 2) == 0 || this.mStartX - motionEvent.getRawX() <= ((float) this.mMinAcceptableDelta)) && (((this.mDirection & 4) == 0 || this.mStartY - motionEvent.getRawY() <= ((float) this.mMinAcceptableDelta)) && ((this.mDirection & 8) == 0 || motionEvent.getRawY() - this.mStartY <= ((float) this.mMinAcceptableDelta))))) {
            return false;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        activate();
        end();
        return true;
    }
}
