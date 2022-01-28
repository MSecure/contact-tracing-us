package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.facebook.react.devsupport.FpsView;
import com.facebook.react.uimanager.BaseViewManager;

public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    public int mActivationDelay;
    public boolean mAlreadyDelayed;
    public boolean mAnimating;
    public final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
    public int mEdgeType;
    public boolean mEnabled;
    public float[] mMaximumEdges = {Float.MAX_VALUE, Float.MAX_VALUE};
    public float[] mMaximumVelocity = {Float.MAX_VALUE, Float.MAX_VALUE};
    public float[] mMinimumVelocity = {BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER};
    public boolean mNeedsCancel;
    public boolean mNeedsReset;
    public float[] mRelativeEdges = {BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER};
    public float[] mRelativeVelocity = {BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER};
    public Runnable mRunnable;
    public final ClampedScroller mScroller = new ClampedScroller();
    public final View mTarget;

    public static class ClampedScroller {
        public long mDeltaTime = 0;
        public int mDeltaX = 0;
        public int mDeltaY = 0;
        public int mEffectiveRampDown;
        public int mRampDownDuration;
        public int mRampUpDuration;
        public long mStartTime = Long.MIN_VALUE;
        public long mStopTime = -1;
        public float mStopValue;
        public float mTargetVelocityX;
        public float mTargetVelocityY;

        public final float getValueAt(long j) {
            if (j < this.mStartTime) {
                return BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            }
            long j2 = this.mStopTime;
            if (j2 < 0 || j < j2) {
                return AutoScrollHelper.constrain(((float) (j - this.mStartTime)) / ((float) this.mRampUpDuration), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f) * 0.5f;
            }
            float f = this.mStopValue;
            return (AutoScrollHelper.constrain(((float) (j - j2)) / ((float) this.mEffectiveRampDown), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f) * f) + (1.0f - f);
        }
    }

    public class ScrollAnimationRunnable implements Runnable {
        public ScrollAnimationRunnable() {
        }

        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.mAnimating) {
                if (autoScrollHelper.mNeedsReset) {
                    autoScrollHelper.mNeedsReset = false;
                    ClampedScroller clampedScroller = autoScrollHelper.mScroller;
                    if (clampedScroller != null) {
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        clampedScroller.mStartTime = currentAnimationTimeMillis;
                        clampedScroller.mStopTime = -1;
                        clampedScroller.mDeltaTime = currentAnimationTimeMillis;
                        clampedScroller.mStopValue = 0.5f;
                        clampedScroller.mDeltaX = 0;
                        clampedScroller.mDeltaY = 0;
                    } else {
                        throw null;
                    }
                }
                ClampedScroller clampedScroller2 = AutoScrollHelper.this.mScroller;
                if ((clampedScroller2.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > clampedScroller2.mStopTime + ((long) clampedScroller2.mEffectiveRampDown)) || !AutoScrollHelper.this.shouldAnimate()) {
                    AutoScrollHelper.this.mAnimating = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.mNeedsCancel) {
                    autoScrollHelper2.mNeedsCancel = false;
                    if (autoScrollHelper2 != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0);
                        autoScrollHelper2.mTarget.onTouchEvent(obtain);
                        obtain.recycle();
                    } else {
                        throw null;
                    }
                }
                if (clampedScroller2.mDeltaTime != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float valueAt = clampedScroller2.getValueAt(currentAnimationTimeMillis2);
                    clampedScroller2.mDeltaTime = currentAnimationTimeMillis2;
                    float f = ((float) (currentAnimationTimeMillis2 - clampedScroller2.mDeltaTime)) * ((valueAt * 4.0f) + (-4.0f * valueAt * valueAt));
                    clampedScroller2.mDeltaX = (int) (clampedScroller2.mTargetVelocityX * f);
                    int i = (int) (f * clampedScroller2.mTargetVelocityY);
                    clampedScroller2.mDeltaY = i;
                    ((ListViewAutoScrollHelper) AutoScrollHelper.this).mTarget.scrollListBy(i);
                    ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public AutoScrollHelper(View view) {
        this.mTarget = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.mMaximumVelocity;
        float f2 = ((float) ((int) ((1575.0f * f) + 0.5f))) / 1000.0f;
        fArr[0] = f2;
        fArr[1] = f2;
        float[] fArr2 = this.mMinimumVelocity;
        float f3 = ((float) ((int) ((f * 315.0f) + 0.5f))) / 1000.0f;
        fArr2[0] = f3;
        fArr2[1] = f3;
        this.mEdgeType = 1;
        float[] fArr3 = this.mMaximumEdges;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.mRelativeEdges;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.mRelativeVelocity;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.mActivationDelay = DEFAULT_ACTIVATION_DELAY;
        ClampedScroller clampedScroller = this.mScroller;
        clampedScroller.mRampUpDuration = FpsView.UPDATE_INTERVAL_MS;
        clampedScroller.mRampDownDuration = FpsView.UPDATE_INTERVAL_MS;
    }

    public static float constrain(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    public final float computeTargetVelocity(int i, float f, float f2, float f3) {
        float f4;
        int i2;
        float f5;
        float constrain = constrain(this.mRelativeEdges[i] * f2, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, this.mMaximumEdges[i]);
        float constrainEdgeValue = constrainEdgeValue(f2 - f, constrain) - constrainEdgeValue(f, constrain);
        if (constrainEdgeValue < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            f5 = -this.mEdgeInterpolator.getInterpolation(-constrainEdgeValue);
        } else if (constrainEdgeValue > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            f5 = this.mEdgeInterpolator.getInterpolation(constrainEdgeValue);
        } else {
            f4 = 0.0f;
            i2 = (f4 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? 1 : (f4 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? 0 : -1));
            if (i2 != 0) {
                return BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            }
            float f6 = this.mRelativeVelocity[i];
            float f7 = this.mMinimumVelocity[i];
            float f8 = this.mMaximumVelocity[i];
            float f9 = f6 * f3;
            if (i2 > 0) {
                return constrain(f4 * f9, f7, f8);
            }
            return -constrain((-f4) * f9, f7, f8);
        }
        f4 = constrain(f5, -1.0f, 1.0f);
        i2 = (f4 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? 1 : (f4 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? 0 : -1));
        if (i2 != 0) {
        }
    }

    public final float constrainEdgeValue(float f, float f2) {
        if (f2 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            return BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        }
        int i = this.mEdgeType;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    return 1.0f - (f / f2);
                }
                if (!this.mAnimating || this.mEdgeType != 1) {
                    return BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                }
                return 1.0f;
            }
        } else if (i == 2 && f < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            return f / (-f2);
        }
        return BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007d;
     */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        if (!this.mEnabled) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            requestStop();
            return false;
        }
        this.mNeedsCancel = true;
        this.mAlreadyDelayed = false;
        float computeTargetVelocity = computeTargetVelocity(0, motionEvent.getX(), (float) view.getWidth(), (float) this.mTarget.getWidth());
        float computeTargetVelocity2 = computeTargetVelocity(1, motionEvent.getY(), (float) view.getHeight(), (float) this.mTarget.getHeight());
        ClampedScroller clampedScroller = this.mScroller;
        clampedScroller.mTargetVelocityX = computeTargetVelocity;
        clampedScroller.mTargetVelocityY = computeTargetVelocity2;
        if (!this.mAnimating && shouldAnimate()) {
            if (this.mRunnable == null) {
                this.mRunnable = new ScrollAnimationRunnable();
            }
            this.mAnimating = true;
            this.mNeedsReset = true;
            if (this.mAlreadyDelayed || (i = this.mActivationDelay) <= 0) {
                this.mRunnable.run();
            } else {
                ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, (long) i);
            }
            this.mAlreadyDelayed = true;
        }
        return false;
    }

    public final void requestStop() {
        int i = 0;
        if (this.mNeedsReset) {
            this.mAnimating = false;
            return;
        }
        ClampedScroller clampedScroller = this.mScroller;
        if (clampedScroller != null) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            int i2 = (int) (currentAnimationTimeMillis - clampedScroller.mStartTime);
            int i3 = clampedScroller.mRampDownDuration;
            if (i2 > i3) {
                i = i3;
            } else if (i2 >= 0) {
                i = i2;
            }
            clampedScroller.mEffectiveRampDown = i;
            clampedScroller.mStopValue = clampedScroller.getValueAt(currentAnimationTimeMillis);
            clampedScroller.mStopTime = currentAnimationTimeMillis;
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public boolean shouldAnimate() {
        boolean z;
        ClampedScroller clampedScroller = this.mScroller;
        float f = clampedScroller.mTargetVelocityY;
        int abs = (int) (f / Math.abs(f));
        float f2 = clampedScroller.mTargetVelocityX;
        int abs2 = (int) (f2 / Math.abs(f2));
        if (abs != 0) {
            ListView listView = ((ListViewAutoScrollHelper) this).mTarget;
            int count = listView.getCount();
            if (count != 0) {
                int childCount = listView.getChildCount();
                int firstVisiblePosition = listView.getFirstVisiblePosition();
                int i = firstVisiblePosition + childCount;
                if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0)) : !(i >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight())) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        return false;
    }
}
