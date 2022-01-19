package com.swmansion.gesturehandler;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.facebook.react.uimanager.BaseViewManager;
import com.horcrux.svg.PathParser;

public class PanGestureHandler extends GestureHandler<PanGestureHandler> {
    public float mActiveOffsetXEnd = Float.MIN_VALUE;
    public float mActiveOffsetXStart = Float.MAX_VALUE;
    public float mActiveOffsetYEnd = Float.MIN_VALUE;
    public float mActiveOffsetYStart = Float.MAX_VALUE;
    public boolean mAverageTouches;
    public float mFailOffsetXEnd = Float.MAX_VALUE;
    public float mFailOffsetXStart = Float.MIN_VALUE;
    public float mFailOffsetYEnd = Float.MAX_VALUE;
    public float mFailOffsetYStart = Float.MIN_VALUE;
    public float mLastVelocityX;
    public float mLastVelocityY;
    public float mLastX;
    public float mLastY;
    public int mMaxPointers = 10;
    public float mMinDistSq = Float.MIN_VALUE;
    public int mMinPointers = 1;
    public float mMinVelocitySq = Float.MAX_VALUE;
    public float mMinVelocityX = Float.MAX_VALUE;
    public float mMinVelocityY = Float.MAX_VALUE;
    public float mOffsetX;
    public float mOffsetY;
    public float mStartX;
    public float mStartY;
    public VelocityTracker mVelocityTracker;

    public PanGestureHandler(Context context) {
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMinDistSq = (float) (scaledTouchSlop * scaledTouchSlop);
    }

    public static void addVelocityMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        motionEvent.offsetLocation(rawX, rawY);
        velocityTracker.addMovement(motionEvent);
        motionEvent.offsetLocation(-rawX, -rawY);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0175, code lost:
        if (r10 >= r0) goto L_0x01a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0190, code lost:
        if (r10 >= r1) goto L_0x01a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0111  */
    @Override // com.swmansion.gesturehandler.GestureHandler
    public void onHandle(MotionEvent motionEvent) {
        boolean z;
        int i = this.mState;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 6 || actionMasked == 5) {
            this.mOffsetX = (this.mLastX - this.mStartX) + this.mOffsetX;
            this.mOffsetY = (this.mLastY - this.mStartY) + this.mOffsetY;
            this.mLastX = PathParser.getLastPointerX(motionEvent, this.mAverageTouches);
            float lastPointerY = PathParser.getLastPointerY(motionEvent, this.mAverageTouches);
            this.mLastY = lastPointerY;
            this.mStartX = this.mLastX;
            this.mStartY = lastPointerY;
        } else {
            this.mLastX = PathParser.getLastPointerX(motionEvent, this.mAverageTouches);
            this.mLastY = PathParser.getLastPointerY(motionEvent, this.mAverageTouches);
        }
        if (i != 0 || motionEvent.getPointerCount() < this.mMinPointers) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                addVelocityMovement(velocityTracker, motionEvent);
                this.mVelocityTracker.computeCurrentVelocity(1000);
                this.mLastVelocityX = this.mVelocityTracker.getXVelocity();
                this.mLastVelocityY = this.mVelocityTracker.getYVelocity();
            }
        } else {
            this.mStartX = this.mLastX;
            this.mStartY = this.mLastY;
            this.mOffsetX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mOffsetY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            VelocityTracker obtain = VelocityTracker.obtain();
            this.mVelocityTracker = obtain;
            addVelocityMovement(obtain, motionEvent);
            begin();
        }
        boolean z2 = true;
        if (actionMasked == 1) {
            if (i == 4 || i == 2) {
                end();
            } else {
                fail();
            }
        } else if (actionMasked != 5 || motionEvent.getPointerCount() <= this.mMaxPointers) {
            if (actionMasked == 6 && i == 4 && motionEvent.getPointerCount() < this.mMinPointers) {
                fail();
            } else if (i == 2) {
                float f = (this.mLastX - this.mStartX) + this.mOffsetX;
                float f2 = this.mFailOffsetXStart;
                if (f2 == Float.MIN_VALUE || f >= f2) {
                    float f3 = this.mFailOffsetXEnd;
                    if (f3 == Float.MAX_VALUE || f <= f3) {
                        float f4 = (this.mLastY - this.mStartY) + this.mOffsetY;
                        float f5 = this.mFailOffsetYStart;
                        if (f5 == Float.MIN_VALUE || f4 >= f5) {
                            float f6 = this.mFailOffsetYEnd;
                            if (f6 == Float.MAX_VALUE || f4 <= f6) {
                                z = false;
                                if (!z) {
                                    fail();
                                    return;
                                }
                                float f7 = (this.mLastX - this.mStartX) + this.mOffsetX;
                                float f8 = this.mActiveOffsetXStart;
                                if (f8 == Float.MAX_VALUE || f7 >= f8) {
                                    float f9 = this.mActiveOffsetXEnd;
                                    if (f9 == Float.MIN_VALUE || f7 <= f9) {
                                        float f10 = (this.mLastY - this.mStartY) + this.mOffsetY;
                                        float f11 = this.mActiveOffsetYStart;
                                        if (f11 == Float.MAX_VALUE || f10 >= f11) {
                                            float f12 = this.mActiveOffsetYEnd;
                                            if (f12 == Float.MIN_VALUE || f10 <= f12) {
                                                float f13 = (f10 * f10) + (f7 * f7);
                                                float f14 = this.mMinDistSq;
                                                if (f14 == Float.MAX_VALUE || f13 < f14) {
                                                    float f15 = this.mLastVelocityX;
                                                    float f16 = this.mMinVelocityX;
                                                    if (f16 != Float.MAX_VALUE) {
                                                        if (f16 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f15 > f16) {
                                                            float f17 = this.mMinVelocityX;
                                                            if (f17 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                            }
                                                        }
                                                    }
                                                    float f18 = this.mLastVelocityY;
                                                    float f19 = this.mMinVelocityY;
                                                    if (f19 != Float.MAX_VALUE) {
                                                        if (f19 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f15 > f19) {
                                                            float f20 = this.mMinVelocityY;
                                                            if (f20 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                            }
                                                        }
                                                    }
                                                    float f21 = (f18 * f18) + (f15 * f15);
                                                    float f22 = this.mMinVelocitySq;
                                                    if (f22 == Float.MAX_VALUE || f21 < f22) {
                                                        z2 = false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (z2) {
                                    this.mStartX = this.mLastX;
                                    this.mStartY = this.mLastY;
                                    activate();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                z = true;
                if (!z) {
                }
            }
        } else if (i == 4) {
            cancel();
        } else {
            fail();
        }
    }

    @Override // com.swmansion.gesturehandler.GestureHandler
    public void onReset() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
