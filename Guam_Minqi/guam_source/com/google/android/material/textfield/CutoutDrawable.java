package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

public class CutoutDrawable extends MaterialShapeDrawable {
    public final RectF cutoutBounds;
    public final Paint cutoutPaint;
    public int savedLayer;

    public CutoutDrawable() {
        this(null);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public void draw(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            this.savedLayer = canvas.saveLayer(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (float) canvas.getWidth(), (float) canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.cutoutBounds, this.cutoutPaint);
        if (!(getCallback() instanceof View)) {
            canvas.restoreToCount(this.savedLayer);
        }
    }

    public void setCutout(float f, float f2, float f3, float f4) {
        RectF rectF = this.cutoutBounds;
        if (f != rectF.left || f2 != rectF.top || f3 != rectF.right || f4 != rectF.bottom) {
            this.cutoutBounds.set(f, f2, f3, f4);
            invalidateSelf();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CutoutDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        super(shapeAppearanceModel == null ? new ShapeAppearanceModel() : shapeAppearanceModel);
        Paint paint = new Paint(1);
        this.cutoutPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.cutoutBounds = new RectF();
    }
}
