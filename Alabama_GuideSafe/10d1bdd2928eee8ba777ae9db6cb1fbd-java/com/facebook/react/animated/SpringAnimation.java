package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

public class SpringAnimation extends AnimationDriver {
    public int mCurrentLoop;
    public final PhysicsState mCurrentState;
    public double mDisplacementFromRestThreshold;
    public double mEndValue;
    public double mInitialVelocity;
    public int mIterations;
    public long mLastTime;
    public double mOriginalValue;
    public boolean mOvershootClampingEnabled;
    public double mRestSpeedThreshold;
    public double mSpringDamping;
    public double mSpringMass;
    public boolean mSpringStarted;
    public double mSpringStiffness;
    public double mStartValue;
    public double mTimeAccumulator;

    public static class PhysicsState {
        public double position;
        public double velocity;

        public PhysicsState(AnonymousClass1 r1) {
        }
    }

    public SpringAnimation(ReadableMap readableMap) {
        PhysicsState physicsState = new PhysicsState(null);
        this.mCurrentState = physicsState;
        physicsState.velocity = readableMap.getDouble("initialVelocity");
        resetConfig(readableMap);
    }

    public final boolean isAtRest() {
        if (Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold) {
            if (Math.abs(this.mEndValue - this.mCurrentState.position) <= this.mDisplacementFromRestThreshold || this.mSpringStiffness == 0.0d) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void resetConfig(ReadableMap readableMap) {
        this.mSpringStiffness = readableMap.getDouble("stiffness");
        this.mSpringDamping = readableMap.getDouble("damping");
        this.mSpringMass = readableMap.getDouble("mass");
        this.mInitialVelocity = this.mCurrentState.velocity;
        this.mEndValue = readableMap.getDouble("toValue");
        this.mRestSpeedThreshold = readableMap.getDouble("restSpeedThreshold");
        this.mDisplacementFromRestThreshold = readableMap.getDouble("restDisplacementThreshold");
        this.mOvershootClampingEnabled = readableMap.getBoolean("overshootClamping");
        boolean z = true;
        int i = readableMap.hasKey("iterations") ? readableMap.getInt("iterations") : 1;
        this.mIterations = i;
        if (i != 0) {
            z = false;
        }
        this.mHasFinished = z;
        this.mCurrentLoop = 0;
        this.mTimeAccumulator = 0.0d;
        this.mSpringStarted = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0129, code lost:
        if (r24.mCurrentState.position < r7) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x012e, code lost:
        if (r3 == false) goto L_0x014f;
     */
    @Override // com.facebook.react.animated.AnimationDriver
    public void runAnimationStep(long j) {
        double d;
        double d2;
        boolean z;
        long j2 = j / 1000000;
        if (!this.mSpringStarted) {
            if (this.mCurrentLoop == 0) {
                this.mOriginalValue = this.mAnimatedValue.mValue;
                this.mCurrentLoop = 1;
            }
            PhysicsState physicsState = this.mCurrentState;
            double d3 = this.mAnimatedValue.mValue;
            physicsState.position = d3;
            this.mStartValue = d3;
            this.mLastTime = j2;
            this.mTimeAccumulator = 0.0d;
            this.mSpringStarted = true;
        }
        double d4 = ((double) (j2 - this.mLastTime)) / 1000.0d;
        if (!isAtRest()) {
            if (d4 > 0.064d) {
                d4 = 0.064d;
            }
            this.mTimeAccumulator += d4;
            double d5 = this.mSpringDamping;
            double d6 = this.mSpringMass;
            double d7 = this.mSpringStiffness;
            double d8 = -this.mInitialVelocity;
            double sqrt = d5 / (Math.sqrt(d7 * d6) * 2.0d);
            double sqrt2 = Math.sqrt(d7 / d6);
            double sqrt3 = Math.sqrt(1.0d - (sqrt * sqrt)) * sqrt2;
            double d9 = this.mEndValue - this.mStartValue;
            double d10 = this.mTimeAccumulator;
            if (sqrt < 1.0d) {
                double exp = Math.exp((-sqrt) * sqrt2 * d10);
                double d11 = sqrt * sqrt2;
                double d12 = (d11 * d9) + d8;
                double d13 = d10 * sqrt3;
                d2 = this.mEndValue - (((Math.cos(d13) * d9) + (Math.sin(d13) * (d12 / sqrt3))) * exp);
                d = (((Math.cos(d13) * d9) + ((Math.sin(d13) * d12) / sqrt3)) * (d11 * exp)) - (((Math.cos(d13) * d12) - (Math.sin(d13) * (sqrt3 * d9))) * exp);
            } else {
                double exp2 = Math.exp((-sqrt2) * d10);
                d2 = this.mEndValue - (((((sqrt2 * d9) + d8) * d10) + d9) * exp2);
                d = ((sqrt2 * sqrt2 * d10 * d9) + (((d10 * sqrt2) - 1.0d) * d8)) * exp2;
            }
            PhysicsState physicsState2 = this.mCurrentState;
            physicsState2.position = d2;
            physicsState2.velocity = d;
            if (!isAtRest()) {
                if (this.mOvershootClampingEnabled) {
                    if (this.mSpringStiffness > 0.0d) {
                        double d14 = this.mStartValue;
                        double d15 = this.mEndValue;
                        if (d14 >= d15 || this.mCurrentState.position <= d15) {
                            double d16 = this.mStartValue;
                            double d17 = this.mEndValue;
                            if (d16 > d17) {
                            }
                        }
                        z = true;
                    }
                    z = false;
                }
            }
            if (this.mSpringStiffness > 0.0d) {
                double d18 = this.mEndValue;
                this.mStartValue = d18;
                this.mCurrentState.position = d18;
            } else {
                double d19 = this.mCurrentState.position;
                this.mEndValue = d19;
                this.mStartValue = d19;
            }
            this.mCurrentState.velocity = 0.0d;
        }
        this.mLastTime = j2;
        this.mAnimatedValue.mValue = this.mCurrentState.position;
        if (isAtRest()) {
            int i = this.mIterations;
            if (i == -1 || this.mCurrentLoop < i) {
                this.mSpringStarted = false;
                this.mAnimatedValue.mValue = this.mOriginalValue;
                this.mCurrentLoop++;
                return;
            }
            this.mHasFinished = true;
        }
    }
}
