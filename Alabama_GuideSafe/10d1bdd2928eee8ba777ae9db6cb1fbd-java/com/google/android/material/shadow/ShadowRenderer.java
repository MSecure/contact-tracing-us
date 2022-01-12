package com.google.android.material.shadow;

import android.graphics.Paint;
import android.graphics.Path;
import androidx.core.graphics.ColorUtils;
import com.facebook.react.uimanager.BaseViewManager;

public class ShadowRenderer {
    public static final int[] cornerColors = new int[4];
    public static final float[] cornerPositions = {BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0.5f, 1.0f};
    public static final int[] edgeColors = new int[3];
    public static final float[] edgePositions = {BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0.5f, 1.0f};
    public final Paint cornerShadowPaint;
    public final Paint edgeShadowPaint;
    public final Path scratch = new Path();
    public int shadowEndColor;
    public int shadowMiddleColor;
    public final Paint shadowPaint;
    public int shadowStartColor;

    public ShadowRenderer() {
        setShadowColor(-16777216);
        Paint paint = new Paint(4);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.shadowPaint = paint2;
        paint2.setColor(this.shadowStartColor);
        this.edgeShadowPaint = new Paint(this.cornerShadowPaint);
    }

    public void setShadowColor(int i) {
        this.shadowStartColor = ColorUtils.setAlphaComponent(i, 68);
        this.shadowMiddleColor = ColorUtils.setAlphaComponent(i, 20);
        this.shadowEndColor = ColorUtils.setAlphaComponent(i, 0);
    }
}
