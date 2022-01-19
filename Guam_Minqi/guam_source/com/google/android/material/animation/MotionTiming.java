package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import com.android.tools.r8.GeneratedOutlineSupport;

public class MotionTiming {
    public long delay = 0;
    public long duration = 300;
    public TimeInterpolator interpolator = null;
    public int repeatCount = 0;
    public int repeatMode = 1;

    public MotionTiming(long j, long j2) {
        this.delay = j;
        this.duration = j2;
    }

    public void apply(Animator animator) {
        animator.setStartDelay(this.delay);
        animator.setDuration(this.duration);
        animator.setInterpolator(getInterpolator());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.repeatCount);
            valueAnimator.setRepeatMode(this.repeatMode);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionTiming)) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (this.delay == motionTiming.delay && this.duration == motionTiming.duration && this.repeatCount == motionTiming.repeatCount && this.repeatMode == motionTiming.repeatMode) {
            return getInterpolator().getClass().equals(motionTiming.getInterpolator().getClass());
        }
        return false;
    }

    public TimeInterpolator getInterpolator() {
        TimeInterpolator timeInterpolator = this.interpolator;
        return timeInterpolator != null ? timeInterpolator : AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public int hashCode() {
        long j = this.delay;
        long j2 = this.duration;
        return ((((getInterpolator().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31)) * 31) + this.repeatCount) * 31) + this.repeatMode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        sb.append(MotionTiming.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.delay);
        sb.append(" duration: ");
        sb.append(this.duration);
        sb.append(" interpolator: ");
        sb.append(getInterpolator().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.repeatCount);
        sb.append(" repeatMode: ");
        return GeneratedOutlineSupport.outline11(sb, this.repeatMode, "}\n");
    }

    public MotionTiming(long j, long j2, TimeInterpolator timeInterpolator) {
        this.delay = j;
        this.duration = j2;
        this.interpolator = timeInterpolator;
    }
}
