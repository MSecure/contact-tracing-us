package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.react.uimanager.BaseViewManager;

public class AutoRotateDrawable extends ForwardingDrawable implements Runnable {
    public boolean mClockwise;
    public int mInterval;
    public boolean mIsScheduled;
    public float mRotationAngle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoRotateDrawable(Drawable drawable, int i) {
        super(drawable);
        if (drawable != null) {
            this.mRotationAngle = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mIsScheduled = false;
            this.mInterval = i;
            this.mClockwise = true;
            return;
        }
        throw null;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.mRotationAngle;
        if (!this.mClockwise) {
            f = 360.0f - f;
        }
        canvas.rotate(f, (float) ((i / 2) + bounds.left), (float) ((i2 / 2) + bounds.top));
        Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restoreToCount(save);
        if (!this.mIsScheduled) {
            this.mIsScheduled = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    public void run() {
        this.mIsScheduled = false;
        this.mRotationAngle += (float) ((int) ((20.0f / ((float) this.mInterval)) * 360.0f));
        invalidateSelf();
    }
}
