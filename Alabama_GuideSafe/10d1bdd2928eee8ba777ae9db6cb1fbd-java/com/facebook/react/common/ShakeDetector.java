package com.facebook.react.common;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.concurrent.TimeUnit;

public class ShakeDetector implements SensorEventListener {
    public static final long MIN_TIME_BETWEEN_SAMPLES_NS = TimeUnit.NANOSECONDS.convert(20, TimeUnit.MILLISECONDS);
    public static final float SHAKING_WINDOW_NS = ((float) TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS));
    public float mAccelerationX;
    public float mAccelerationY;
    public float mAccelerationZ;
    public long mLastShakeTimestamp;
    public long mLastTimestamp;
    public int mMinNumShakes;
    public int mNumShakes;
    public SensorManager mSensorManager;
    public final ShakeListener mShakeListener;

    public interface ShakeListener {
        void onShake();
    }

    public ShakeDetector(ShakeListener shakeListener, int i) {
        this.mShakeListener = shakeListener;
        this.mMinNumShakes = i;
    }

    public final boolean atLeastRequiredForce(float f) {
        return Math.abs(f) > 13.042845f;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        long j = sensorEvent.timestamp;
        if (j - this.mLastTimestamp >= MIN_TIME_BETWEEN_SAMPLES_NS) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2] - 9.80665f;
            this.mLastTimestamp = j;
            if (atLeastRequiredForce(f) && this.mAccelerationX * f <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                recordShake(sensorEvent.timestamp);
                this.mAccelerationX = f;
            } else if (atLeastRequiredForce(f2) && this.mAccelerationY * f2 <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                recordShake(sensorEvent.timestamp);
                this.mAccelerationY = f2;
            } else if (atLeastRequiredForce(f3) && this.mAccelerationZ * f3 <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                recordShake(sensorEvent.timestamp);
                this.mAccelerationZ = f3;
            }
            long j2 = sensorEvent.timestamp;
            if (this.mNumShakes >= this.mMinNumShakes * 8) {
                reset();
                this.mShakeListener.onShake();
            }
            if (((float) (j2 - this.mLastShakeTimestamp)) > SHAKING_WINDOW_NS) {
                reset();
            }
        }
    }

    public final void recordShake(long j) {
        this.mLastShakeTimestamp = j;
        this.mNumShakes++;
    }

    public final void reset() {
        this.mNumShakes = 0;
        this.mAccelerationX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mAccelerationY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mAccelerationZ = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }
}
