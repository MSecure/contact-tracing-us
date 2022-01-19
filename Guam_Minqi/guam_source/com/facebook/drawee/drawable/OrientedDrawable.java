package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class OrientedDrawable extends ForwardingDrawable {
    public int mExifOrientation;
    public int mRotationAngle;
    public final Matrix mRotationMatrix = new Matrix();
    public final Matrix mTempMatrix = new Matrix();
    public final RectF mTempRectF = new RectF();

    public OrientedDrawable(Drawable drawable, int i, int i2) {
        super(drawable);
        this.mRotationAngle = i - (i % 90);
        this.mExifOrientation = (i2 < 0 || i2 > 8) ? 0 : i2;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public void draw(Canvas canvas) {
        int i;
        if (this.mRotationAngle > 0 || !((i = this.mExifOrientation) == 0 || i == 1)) {
            int save = canvas.save();
            canvas.concat(this.mRotationMatrix);
            Drawable drawable = this.mCurrentDelegate;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            canvas.restoreToCount(save);
            return;
        }
        Drawable drawable2 = this.mCurrentDelegate;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public int getIntrinsicHeight() {
        int i = this.mExifOrientation;
        if (i == 5 || i == 7 || this.mRotationAngle % 180 != 0) {
            return super.getIntrinsicWidth();
        }
        return super.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public int getIntrinsicWidth() {
        int i = this.mExifOrientation;
        if (i == 5 || i == 7 || this.mRotationAngle % 180 != 0) {
            return super.getIntrinsicHeight();
        }
        return super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        if (!this.mRotationMatrix.isIdentity()) {
            matrix.preConcat(this.mRotationMatrix);
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public void onBoundsChange(Rect rect) {
        int i;
        Drawable drawable = this.mCurrentDelegate;
        if (this.mRotationAngle > 0 || !((i = this.mExifOrientation) == 0 || i == 1)) {
            int i2 = this.mExifOrientation;
            if (i2 == 2) {
                this.mRotationMatrix.setScale(-1.0f, 1.0f);
            } else if (i2 == 7) {
                this.mRotationMatrix.setRotate(270.0f, (float) rect.centerX(), (float) rect.centerY());
                this.mRotationMatrix.postScale(-1.0f, 1.0f);
            } else if (i2 == 4) {
                this.mRotationMatrix.setScale(1.0f, -1.0f);
            } else if (i2 != 5) {
                this.mRotationMatrix.setRotate((float) this.mRotationAngle, (float) rect.centerX(), (float) rect.centerY());
            } else {
                this.mRotationMatrix.setRotate(270.0f, (float) rect.centerX(), (float) rect.centerY());
                this.mRotationMatrix.postScale(1.0f, -1.0f);
            }
            this.mTempMatrix.reset();
            this.mRotationMatrix.invert(this.mTempMatrix);
            this.mTempRectF.set(rect);
            this.mTempMatrix.mapRect(this.mTempRectF);
            RectF rectF = this.mTempRectF;
            drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            return;
        }
        drawable.setBounds(rect);
    }
}
