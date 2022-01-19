package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.HashMap;
import java.util.Map;

public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    public HashMap<String, String> mAdditionalData = new HashMap<>();
    public String mControllerId;
    public int mCurrentTextXPx;
    public int mCurrentTextYPx;
    public long mFinalImageTimeMs;
    public int mFrameCount;
    public int mHeightPx;
    public String mImageFormat;
    public int mImageSizeBytes;
    public int mLineIncrementPx;
    public int mLoopCount;
    public final Matrix mMatrix = new Matrix();
    public String mOrigin;
    public final Paint mPaint = new Paint(1);
    public final Rect mRect = new Rect();
    public final RectF mRectF = new RectF();
    public ScalingUtils$ScaleType mScaleType;
    public int mStartTextXPx;
    public int mStartTextYPx;
    public int mTextGravity = 80;
    public int mWidthPx;

    public DebugControllerOverlayDrawable() {
        reset();
    }

    public final void addDebugText(Canvas canvas, String str, Object... objArr) {
        canvas.drawText(String.format(str, objArr), (float) this.mCurrentTextXPx, (float) this.mCurrentTextYPx, this.mPaint);
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }

    public void draw(Canvas canvas) {
        char c;
        float f;
        Rect bounds = getBounds();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(-26624);
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        Paint paint = this.mPaint;
        int i = this.mWidthPx;
        int i2 = this.mHeightPx;
        ScalingUtils$ScaleType scalingUtils$ScaleType = this.mScaleType;
        int width = getBounds().width();
        int height = getBounds().height();
        int i3 = 1727284022;
        if (width <= 0 || height <= 0 || i <= 0 || i2 <= 0) {
            c = 0;
            f = 0.0f;
        } else {
            if (scalingUtils$ScaleType != null) {
                Rect rect = this.mRect;
                rect.top = 0;
                rect.left = 0;
                rect.right = width;
                rect.bottom = height;
                this.mMatrix.reset();
                ScalingUtils$AbstractScaleType scalingUtils$AbstractScaleType = (ScalingUtils$AbstractScaleType) scalingUtils$ScaleType;
                c = 0;
                f = 0.0f;
                scalingUtils$AbstractScaleType.getTransform(this.mMatrix, this.mRect, i, i2, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                RectF rectF = this.mRectF;
                rectF.top = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                rectF.left = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                rectF.right = (float) i;
                rectF.bottom = (float) i2;
                this.mMatrix.mapRect(rectF);
                width = Math.min(width, (int) this.mRectF.width());
                height = Math.min(height, (int) this.mRectF.height());
            } else {
                c = 0;
                f = 0.0f;
            }
            float f2 = (float) width;
            float f3 = f2 * 0.1f;
            float f4 = f2 * 0.5f;
            float f5 = (float) height;
            float f6 = 0.1f * f5;
            float f7 = f5 * 0.5f;
            int abs = Math.abs(i - width);
            int abs2 = Math.abs(i2 - height);
            float f8 = (float) abs;
            if (f8 < f3 && ((float) abs2) < f6) {
                i3 = 1716301648;
            } else if (f8 < f4 && ((float) abs2) < f7) {
                i3 = 1728026624;
            }
        }
        paint.setColor(i3);
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(f);
        this.mPaint.setColor(-1);
        this.mCurrentTextXPx = this.mStartTextXPx;
        this.mCurrentTextYPx = this.mStartTextYPx;
        Object[] objArr = new Object[1];
        objArr[c] = this.mControllerId;
        addDebugText(canvas, "ID: %s", objArr);
        Object[] objArr2 = new Object[2];
        objArr2[c] = Integer.valueOf(bounds.width());
        objArr2[1] = Integer.valueOf(bounds.height());
        addDebugText(canvas, "D: %dx%d", objArr2);
        Object[] objArr3 = new Object[2];
        objArr3[c] = Integer.valueOf(this.mWidthPx);
        objArr3[1] = Integer.valueOf(this.mHeightPx);
        addDebugText(canvas, "I: %dx%d", objArr3);
        Object[] objArr4 = new Object[1];
        objArr4[c] = Integer.valueOf(this.mImageSizeBytes / 1024);
        addDebugText(canvas, "I: %d KiB", objArr4);
        String str = this.mImageFormat;
        if (str != null) {
            Object[] objArr5 = new Object[1];
            objArr5[c] = str;
            addDebugText(canvas, "i format: %s", objArr5);
        }
        int i4 = this.mFrameCount;
        if (i4 > 0) {
            Object[] objArr6 = new Object[2];
            objArr6[c] = Integer.valueOf(i4);
            objArr6[1] = Integer.valueOf(this.mLoopCount);
            addDebugText(canvas, "anim: f %d, l %d", objArr6);
        }
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = this.mScaleType;
        if (scalingUtils$ScaleType2 != null) {
            Object[] objArr7 = new Object[1];
            objArr7[c] = scalingUtils$ScaleType2;
            addDebugText(canvas, "scale: %s", objArr7);
        }
        long j = this.mFinalImageTimeMs;
        if (j >= 0) {
            Object[] objArr8 = new Object[1];
            objArr8[c] = Long.valueOf(j);
            addDebugText(canvas, "t: %d ms", objArr8);
        }
        String str2 = this.mOrigin;
        if (str2 != null) {
            Object[] objArr9 = new Object[1];
            objArr9[c] = str2;
            addDebugText(canvas, "origin: %s", objArr9);
        }
        for (Map.Entry<String, String> entry : this.mAdditionalData.entrySet()) {
            Object[] objArr10 = new Object[2];
            objArr10[c] = entry.getKey();
            objArr10[1] = entry.getValue();
            addDebugText(canvas, "%s: %s", objArr10);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int min = Math.min(40, Math.max(10, Math.min(rect.width() / 8, rect.height() / 9)));
        this.mPaint.setTextSize((float) min);
        int i = min + 8;
        this.mLineIncrementPx = i;
        if (this.mTextGravity == 80) {
            this.mLineIncrementPx = i * -1;
        }
        this.mStartTextXPx = rect.left + 10;
        this.mStartTextYPx = this.mTextGravity == 80 ? rect.bottom - 10 : rect.top + 10 + 10;
    }

    public void reset() {
        this.mWidthPx = -1;
        this.mHeightPx = -1;
        this.mImageSizeBytes = -1;
        this.mAdditionalData = new HashMap<>();
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.mImageFormat = null;
        this.mControllerId = "none";
        invalidateSelf();
        this.mFinalImageTimeMs = -1;
        this.mOrigin = null;
        invalidateSelf();
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
