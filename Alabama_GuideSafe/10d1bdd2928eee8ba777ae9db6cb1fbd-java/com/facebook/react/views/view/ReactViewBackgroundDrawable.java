package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.Spacing;
import java.util.Arrays;
import java.util.Locale;

public class ReactViewBackgroundDrawable extends Drawable {
    public int mAlpha = 255;
    public Spacing mBorderAlpha;
    public float[] mBorderCornerRadii;
    public Spacing mBorderRGB;
    public float mBorderRadius = Float.NaN;
    public BorderStyle mBorderStyle;
    public Spacing mBorderWidth;
    public Path mCenterDrawPath;
    public int mColor = 0;
    public final Context mContext;
    public PointF mInnerBottomLeftCorner;
    public PointF mInnerBottomRightCorner;
    public Path mInnerClipPathForBorderRadius;
    public RectF mInnerClipTempRectForBorderRadius;
    public PointF mInnerTopLeftCorner;
    public PointF mInnerTopRightCorner;
    public int mLayoutDirection;
    public boolean mNeedUpdatePathForBorderRadius = false;
    public Path mOuterClipPathForBorderRadius;
    public RectF mOuterClipTempRectForBorderRadius;
    public final Paint mPaint = new Paint(1);
    public PathEffect mPathEffectForBorderStyle;
    public Path mPathForBorder;
    public Path mPathForBorderRadiusOutline;
    public RectF mTempRectForBorderRadiusOutline;
    public RectF mTempRectForCenterDrawPath;

    public enum BorderRadiusLocation {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    public enum BorderStyle {
        SOLID,
        DASHED,
        DOTTED
    }

    public ReactViewBackgroundDrawable(Context context) {
        this.mContext = context;
    }

    public static void getEllipseIntersectionWithLine(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, PointF pointF) {
        double d9 = (d + d3) / 2.0d;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = d5 - d9;
        double d12 = d6 - d10;
        double abs = Math.abs(d3 - d) / 2.0d;
        double abs2 = Math.abs(d4 - d2) / 2.0d;
        double d13 = ((d8 - d10) - d12) / ((d7 - d9) - d11);
        double d14 = d12 - (d11 * d13);
        double d15 = abs2 * abs2;
        double d16 = abs * abs;
        double d17 = (d16 * d13 * d13) + d15;
        double d18 = abs * 2.0d * abs * d14 * d13;
        double d19 = (-(d16 * ((d14 * d14) - d15))) / d17;
        double d20 = d17 * 2.0d;
        double sqrt = ((-d18) / d20) - Math.sqrt(Math.pow(d18 / d20, 2.0d) + d19);
        double d21 = sqrt + d9;
        double d22 = (d13 * sqrt) + d14 + d10;
        if (!Double.isNaN(d21) && !Double.isNaN(d22)) {
            pointF.x = (float) d21;
            pointF.y = (float) d22;
        }
    }

    public void draw(Canvas canvas) {
        Canvas canvas2;
        int i;
        int i2;
        int i3;
        float f;
        float f2;
        float f3;
        float f4;
        int i4;
        int i5;
        int i6;
        int i7;
        DashPathEffect dashPathEffect;
        BorderStyle borderStyle = this.mBorderStyle;
        DashPathEffect dashPathEffect2 = null;
        boolean z = false;
        if (borderStyle != null) {
            float fullBorderWidth = getFullBorderWidth();
            int ordinal = borderStyle.ordinal();
            if (ordinal == 1) {
                float f5 = fullBorderWidth * 3.0f;
                dashPathEffect = new DashPathEffect(new float[]{f5, f5, f5, f5}, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            } else if (ordinal == 2) {
                dashPathEffect = new DashPathEffect(new float[]{fullBorderWidth, fullBorderWidth, fullBorderWidth, fullBorderWidth}, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            }
            dashPathEffect2 = dashPathEffect;
        }
        this.mPathEffectForBorderStyle = dashPathEffect2;
        this.mPaint.setPathEffect(dashPathEffect2);
        if (!hasRoundedBorders()) {
            this.mPaint.setStyle(Paint.Style.FILL);
            int multiplyColorAlpha = ReactYogaConfigProvider.multiplyColorAlpha(this.mColor, this.mAlpha);
            if (Color.alpha(multiplyColorAlpha) != 0) {
                this.mPaint.setColor(multiplyColorAlpha);
                canvas.drawRect(getBounds(), this.mPaint);
            }
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            int round = Math.round(directionAwareBorderInsets.left);
            int round2 = Math.round(directionAwareBorderInsets.top);
            int round3 = Math.round(directionAwareBorderInsets.right);
            int round4 = Math.round(directionAwareBorderInsets.bottom);
            if (round > 0 || round3 > 0 || round2 > 0 || round4 > 0) {
                Rect bounds = getBounds();
                int borderColor = getBorderColor(0);
                int borderColor2 = getBorderColor(1);
                int borderColor3 = getBorderColor(2);
                int borderColor4 = getBorderColor(3);
                boolean z2 = this.mLayoutDirection == 1;
                int borderColor5 = getBorderColor(4);
                int borderColor6 = getBorderColor(5);
                if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                    if (isBorderColorDefined(4)) {
                        borderColor = borderColor5;
                    }
                    if (isBorderColorDefined(5)) {
                        borderColor3 = borderColor6;
                    }
                    int i8 = z2 ? borderColor3 : borderColor;
                    if (!z2) {
                        borderColor = borderColor3;
                    }
                    i5 = i8;
                    i4 = borderColor;
                } else {
                    int i9 = z2 ? borderColor6 : borderColor5;
                    if (!z2) {
                        borderColor5 = borderColor6;
                    }
                    boolean isBorderColorDefined = isBorderColorDefined(4);
                    boolean isBorderColorDefined2 = isBorderColorDefined(5);
                    boolean z3 = z2 ? isBorderColorDefined2 : isBorderColorDefined;
                    if (!z2) {
                        isBorderColorDefined = isBorderColorDefined2;
                    }
                    if (z3) {
                        borderColor = i9;
                    }
                    if (isBorderColorDefined) {
                        i5 = borderColor;
                        i4 = borderColor5;
                    } else {
                        i4 = borderColor3;
                        i5 = borderColor;
                    }
                }
                int i10 = bounds.left;
                int i11 = bounds.top;
                int i12 = -1;
                int i13 = (round > 0 ? i5 : -1) & (round2 > 0 ? borderColor2 : -1) & (round3 > 0 ? i4 : -1);
                if (round4 > 0) {
                    i12 = borderColor4;
                }
                int i14 = i12 & i13;
                if (i14 != ((round > 0 ? i5 : 0) | (round2 > 0 ? borderColor2 : 0) | (round3 > 0 ? i4 : 0) | (round4 > 0 ? borderColor4 : 0))) {
                    i14 = 0;
                }
                if (i14 == 0) {
                    this.mPaint.setAntiAlias(false);
                    int width = bounds.width();
                    int height = bounds.height();
                    if (round > 0) {
                        float f6 = (float) i10;
                        float f7 = (float) (i10 + round);
                        int i15 = i11 + height;
                        i6 = i11;
                        i7 = i10;
                        drawQuadrilateral(canvas, i5, f6, (float) i11, f7, (float) (i11 + round2), f7, (float) (i15 - round4), f6, (float) i15);
                    } else {
                        i6 = i11;
                        i7 = i10;
                    }
                    if (round2 > 0) {
                        float f8 = (float) i6;
                        float f9 = (float) (i6 + round2);
                        int i16 = i7 + width;
                        drawQuadrilateral(canvas, borderColor2, (float) i7, f8, (float) (i7 + round), f9, (float) (i16 - round3), f9, (float) i16, f8);
                    }
                    if (round3 > 0) {
                        int i17 = i7 + width;
                        float f10 = (float) i17;
                        int i18 = i6 + height;
                        float f11 = (float) (i17 - round3);
                        drawQuadrilateral(canvas, i4, f10, (float) i6, f10, (float) i18, f11, (float) (i18 - round4), f11, (float) (i6 + round2));
                    }
                    if (round4 > 0) {
                        int i19 = i6 + height;
                        float f12 = (float) i19;
                        int i20 = i7 + width;
                        float f13 = (float) i20;
                        float f14 = (float) (i20 - round3);
                        float f15 = (float) (i19 - round4);
                        drawQuadrilateral(canvas, borderColor4, (float) i7, f12, f13, f12, f14, f15, (float) (i7 + round), f15);
                    }
                    this.mPaint.setAntiAlias(true);
                } else if (Color.alpha(i14) != 0) {
                    int i21 = bounds.right;
                    int i22 = bounds.bottom;
                    this.mPaint.setColor(i14);
                    if (round > 0) {
                        canvas.drawRect((float) i10, (float) i11, (float) (i10 + round), (float) (i22 - round4), this.mPaint);
                    }
                    if (round2 > 0) {
                        canvas.drawRect((float) (round + i10), (float) i11, (float) i21, (float) (i11 + round2), this.mPaint);
                    }
                    if (round3 > 0) {
                        canvas.drawRect((float) (i21 - round3), (float) (i11 + round2), (float) i21, (float) i22, this.mPaint);
                    }
                    if (round4 > 0) {
                        canvas.drawRect((float) i10, (float) (i22 - round4), (float) (i21 - round3), (float) i22, this.mPaint);
                    }
                }
            }
        } else {
            updatePath();
            canvas.save();
            int multiplyColorAlpha2 = ReactYogaConfigProvider.multiplyColorAlpha(this.mColor, this.mAlpha);
            if (Color.alpha(multiplyColorAlpha2) != 0) {
                this.mPaint.setColor(multiplyColorAlpha2);
                this.mPaint.setStyle(Paint.Style.FILL);
                canvas2 = canvas;
                canvas2.drawPath(this.mInnerClipPathForBorderRadius, this.mPaint);
            } else {
                canvas2 = canvas;
            }
            RectF directionAwareBorderInsets2 = getDirectionAwareBorderInsets();
            int borderColor7 = getBorderColor(0);
            int borderColor8 = getBorderColor(1);
            int borderColor9 = getBorderColor(2);
            int borderColor10 = getBorderColor(3);
            if (directionAwareBorderInsets2.top > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || directionAwareBorderInsets2.bottom > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || directionAwareBorderInsets2.left > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || directionAwareBorderInsets2.right > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                float fullBorderWidth2 = getFullBorderWidth();
                int borderColor11 = getBorderColor(8);
                if (directionAwareBorderInsets2.top != fullBorderWidth2 || directionAwareBorderInsets2.bottom != fullBorderWidth2 || directionAwareBorderInsets2.left != fullBorderWidth2 || directionAwareBorderInsets2.right != fullBorderWidth2 || borderColor7 != borderColor11 || borderColor8 != borderColor11 || borderColor9 != borderColor11 || borderColor10 != borderColor11) {
                    this.mPaint.setStyle(Paint.Style.FILL);
                    canvas2.clipPath(this.mOuterClipPathForBorderRadius, Region.Op.INTERSECT);
                    canvas2.clipPath(this.mInnerClipPathForBorderRadius, Region.Op.DIFFERENCE);
                    if (this.mLayoutDirection == 1) {
                        z = true;
                    }
                    int borderColor12 = getBorderColor(4);
                    int borderColor13 = getBorderColor(5);
                    if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                        if (isBorderColorDefined(4)) {
                            borderColor7 = borderColor12;
                        }
                        if (isBorderColorDefined(5)) {
                            borderColor9 = borderColor13;
                        }
                        int i23 = z ? borderColor9 : borderColor7;
                        if (!z) {
                            borderColor7 = borderColor9;
                        }
                        i = borderColor7;
                        i2 = i23;
                    } else {
                        int i24 = z ? borderColor13 : borderColor12;
                        if (!z) {
                            borderColor12 = borderColor13;
                        }
                        boolean isBorderColorDefined3 = isBorderColorDefined(4);
                        boolean isBorderColorDefined4 = isBorderColorDefined(5);
                        boolean z4 = z ? isBorderColorDefined4 : isBorderColorDefined3;
                        if (!z) {
                            isBorderColorDefined3 = isBorderColorDefined4;
                        }
                        if (z4) {
                            borderColor7 = i24;
                        }
                        if (isBorderColorDefined3) {
                            i2 = borderColor7;
                            i = borderColor12;
                        } else {
                            i = borderColor9;
                            i2 = borderColor7;
                        }
                    }
                    RectF rectF = this.mOuterClipTempRectForBorderRadius;
                    float f16 = rectF.left;
                    float f17 = rectF.right;
                    float f18 = rectF.top;
                    float f19 = rectF.bottom;
                    if (directionAwareBorderInsets2.left > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        PointF pointF = this.mInnerTopLeftCorner;
                        float f20 = pointF.x;
                        float f21 = pointF.y;
                        PointF pointF2 = this.mInnerBottomLeftCorner;
                        f = f19;
                        f2 = f18;
                        f3 = f17;
                        f4 = f16;
                        i3 = borderColor10;
                        drawQuadrilateral(canvas, i2, f16, f18, f20, f21, pointF2.x, pointF2.y, f16, f);
                    } else {
                        f = f19;
                        f2 = f18;
                        f3 = f17;
                        f4 = f16;
                        i3 = borderColor10;
                    }
                    if (directionAwareBorderInsets2.top > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        PointF pointF3 = this.mInnerTopLeftCorner;
                        float f22 = pointF3.x;
                        float f23 = pointF3.y;
                        PointF pointF4 = this.mInnerTopRightCorner;
                        drawQuadrilateral(canvas, borderColor8, f4, f2, f22, f23, pointF4.x, pointF4.y, f3, f2);
                    }
                    if (directionAwareBorderInsets2.right > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        PointF pointF5 = this.mInnerTopRightCorner;
                        float f24 = pointF5.x;
                        float f25 = pointF5.y;
                        PointF pointF6 = this.mInnerBottomRightCorner;
                        drawQuadrilateral(canvas, i, f3, f2, f24, f25, pointF6.x, pointF6.y, f3, f);
                    }
                    if (directionAwareBorderInsets2.bottom > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        PointF pointF7 = this.mInnerBottomLeftCorner;
                        float f26 = pointF7.x;
                        float f27 = pointF7.y;
                        PointF pointF8 = this.mInnerBottomRightCorner;
                        drawQuadrilateral(canvas, i3, f4, f, f26, f27, pointF8.x, pointF8.y, f3, f);
                    }
                } else if (fullBorderWidth2 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    this.mPaint.setColor(ReactYogaConfigProvider.multiplyColorAlpha(borderColor11, this.mAlpha));
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setStrokeWidth(fullBorderWidth2);
                    canvas2.drawPath(this.mCenterDrawPath, this.mPaint);
                }
            }
            canvas.restore();
        }
    }

    public final void drawQuadrilateral(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (i != 0) {
            if (this.mPathForBorder == null) {
                this.mPathForBorder = new Path();
            }
            this.mPaint.setColor(i);
            this.mPathForBorder.reset();
            this.mPathForBorder.moveTo(f, f2);
            this.mPathForBorder.lineTo(f3, f4);
            this.mPathForBorder.lineTo(f5, f6);
            this.mPathForBorder.lineTo(f7, f8);
            this.mPathForBorder.lineTo(f, f2);
            canvas.drawPath(this.mPathForBorder, this.mPaint);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public final int getBorderColor(int i) {
        Spacing spacing = this.mBorderRGB;
        float f = spacing != null ? spacing.get(i) : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        Spacing spacing2 = this.mBorderAlpha;
        return ((((int) (spacing2 != null ? spacing2.get(i) : 255.0f)) << 24) & -16777216) | (((int) f) & 16777215);
    }

    public float getBorderRadiusOrDefaultTo(float f, BorderRadiusLocation borderRadiusLocation) {
        float[] fArr = this.mBorderCornerRadii;
        if (fArr == null) {
            return f;
        }
        float f2 = fArr[borderRadiusLocation.ordinal()];
        return ReactYogaConfigProvider.isUndefined(f2) ? f : f2;
    }

    public float getBorderWidthOrDefaultTo(float f, int i) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return f;
        }
        float f2 = spacing.mSpacing[i];
        return ReactYogaConfigProvider.isUndefined(f2) ? f : f2;
    }

    public RectF getDirectionAwareBorderInsets() {
        float borderWidthOrDefaultTo = getBorderWidthOrDefaultTo(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 8);
        boolean z = true;
        float borderWidthOrDefaultTo2 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 1);
        float borderWidthOrDefaultTo3 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 3);
        float borderWidthOrDefaultTo4 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 0);
        float borderWidthOrDefaultTo5 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 2);
        if (this.mBorderWidth != null) {
            if (this.mLayoutDirection != 1) {
                z = false;
            }
            float[] fArr = this.mBorderWidth.mSpacing;
            float f = fArr[4];
            float f2 = fArr[5];
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (!ReactYogaConfigProvider.isUndefined(f)) {
                    borderWidthOrDefaultTo4 = f;
                }
                if (!ReactYogaConfigProvider.isUndefined(f2)) {
                    borderWidthOrDefaultTo5 = f2;
                }
                float f3 = z ? borderWidthOrDefaultTo5 : borderWidthOrDefaultTo4;
                if (z) {
                    borderWidthOrDefaultTo5 = borderWidthOrDefaultTo4;
                }
                borderWidthOrDefaultTo4 = f3;
            } else {
                float f4 = z ? f2 : f;
                if (!z) {
                    f = f2;
                }
                if (!ReactYogaConfigProvider.isUndefined(f4)) {
                    borderWidthOrDefaultTo4 = f4;
                }
                if (!ReactYogaConfigProvider.isUndefined(f)) {
                    borderWidthOrDefaultTo5 = f;
                }
            }
        }
        return new RectF(borderWidthOrDefaultTo4, borderWidthOrDefaultTo2, borderWidthOrDefaultTo5, borderWidthOrDefaultTo3);
    }

    public float getFullBorderWidth() {
        Spacing spacing = this.mBorderWidth;
        return (spacing == null || ReactYogaConfigProvider.isUndefined(spacing.mSpacing[8])) ? BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER : this.mBorderWidth.mSpacing[8];
    }

    public int getOpacity() {
        int multiplyColorAlpha = ReactYogaConfigProvider.multiplyColorAlpha(this.mColor, this.mAlpha) >>> 24;
        if (multiplyColorAlpha == 255) {
            return -1;
        }
        return multiplyColorAlpha == 0 ? -2 : -3;
    }

    public void getOutline(Outline outline) {
        if ((ReactYogaConfigProvider.isUndefined(this.mBorderRadius) || this.mBorderRadius <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) && this.mBorderCornerRadii == null) {
            outline.setRect(getBounds());
            return;
        }
        updatePath();
        outline.setConvexPath(this.mPathForBorderRadiusOutline);
    }

    public boolean hasRoundedBorders() {
        if (!ReactYogaConfigProvider.isUndefined(this.mBorderRadius) && this.mBorderRadius > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            return true;
        }
        float[] fArr = this.mBorderCornerRadii;
        if (fArr != null) {
            for (float f : fArr) {
                if (!ReactYogaConfigProvider.isUndefined(f) && f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isBorderColorDefined(int i) {
        Spacing spacing = this.mBorderRGB;
        float f = Float.NaN;
        float f2 = spacing != null ? spacing.get(i) : Float.NaN;
        Spacing spacing2 = this.mBorderAlpha;
        if (spacing2 != null) {
            f = spacing2.get(i);
        }
        return !ReactYogaConfigProvider.isUndefined(f2) && !ReactYogaConfigProvider.isUndefined(f);
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdatePathForBorderRadius = true;
    }

    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public void setBorderColor(int i, float f, float f2) {
        if (this.mBorderRGB == null) {
            this.mBorderRGB = new Spacing(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
        if (!AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(this.mBorderRGB.mSpacing[i], f)) {
            this.mBorderRGB.set(i, f);
            invalidateSelf();
        }
        if (this.mBorderAlpha == null) {
            this.mBorderAlpha = new Spacing(255.0f);
        }
        if (!AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(this.mBorderAlpha.mSpacing[i], f2)) {
            this.mBorderAlpha.set(i, f2);
            invalidateSelf();
        }
    }

    public void setBorderStyle(String str) {
        BorderStyle borderStyle;
        if (str == null) {
            borderStyle = null;
        } else {
            borderStyle = BorderStyle.valueOf(str.toUpperCase(Locale.US));
        }
        if (this.mBorderStyle != borderStyle) {
            this.mBorderStyle = borderStyle;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setBorderWidth(int i, float f) {
        if (this.mBorderWidth == null) {
            this.mBorderWidth = new Spacing(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
        if (!AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(this.mBorderWidth.mSpacing[i], f)) {
            this.mBorderWidth.set(i, f);
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
                this.mNeedUpdatePathForBorderRadius = true;
            }
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setRadius(float f, int i) {
        if (this.mBorderCornerRadii == null) {
            float[] fArr = new float[8];
            this.mBorderCornerRadii = fArr;
            Arrays.fill(fArr, Float.NaN);
        }
        if (!AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(this.mBorderCornerRadii[i], f)) {
            this.mBorderCornerRadii[i] = f;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public final void updatePath() {
        float f;
        float f2;
        int i;
        float f3;
        if (this.mNeedUpdatePathForBorderRadius) {
            this.mNeedUpdatePathForBorderRadius = false;
            if (this.mInnerClipPathForBorderRadius == null) {
                this.mInnerClipPathForBorderRadius = new Path();
            }
            if (this.mOuterClipPathForBorderRadius == null) {
                this.mOuterClipPathForBorderRadius = new Path();
            }
            if (this.mPathForBorderRadiusOutline == null) {
                this.mPathForBorderRadiusOutline = new Path();
            }
            if (this.mCenterDrawPath == null) {
                this.mCenterDrawPath = new Path();
            }
            if (this.mInnerClipTempRectForBorderRadius == null) {
                this.mInnerClipTempRectForBorderRadius = new RectF();
            }
            if (this.mOuterClipTempRectForBorderRadius == null) {
                this.mOuterClipTempRectForBorderRadius = new RectF();
            }
            if (this.mTempRectForBorderRadiusOutline == null) {
                this.mTempRectForBorderRadiusOutline = new RectF();
            }
            if (this.mTempRectForCenterDrawPath == null) {
                this.mTempRectForCenterDrawPath = new RectF();
            }
            this.mInnerClipPathForBorderRadius.reset();
            this.mOuterClipPathForBorderRadius.reset();
            this.mPathForBorderRadiusOutline.reset();
            this.mCenterDrawPath.reset();
            this.mInnerClipTempRectForBorderRadius.set(getBounds());
            this.mOuterClipTempRectForBorderRadius.set(getBounds());
            this.mTempRectForBorderRadiusOutline.set(getBounds());
            this.mTempRectForCenterDrawPath.set(getBounds());
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            RectF rectF = this.mInnerClipTempRectForBorderRadius;
            rectF.top += directionAwareBorderInsets.top;
            rectF.bottom -= directionAwareBorderInsets.bottom;
            rectF.left += directionAwareBorderInsets.left;
            rectF.right -= directionAwareBorderInsets.right;
            RectF rectF2 = this.mTempRectForCenterDrawPath;
            rectF2.top = (directionAwareBorderInsets.top * 0.5f) + rectF2.top;
            rectF2.bottom -= directionAwareBorderInsets.bottom * 0.5f;
            rectF2.left = (directionAwareBorderInsets.left * 0.5f) + rectF2.left;
            rectF2.right -= directionAwareBorderInsets.right * 0.5f;
            float f4 = ReactYogaConfigProvider.isUndefined(this.mBorderRadius) ? 0.0f : this.mBorderRadius;
            float borderRadiusOrDefaultTo = getBorderRadiusOrDefaultTo(f4, BorderRadiusLocation.TOP_LEFT);
            float borderRadiusOrDefaultTo2 = getBorderRadiusOrDefaultTo(f4, BorderRadiusLocation.TOP_RIGHT);
            float borderRadiusOrDefaultTo3 = getBorderRadiusOrDefaultTo(f4, BorderRadiusLocation.BOTTOM_LEFT);
            float borderRadiusOrDefaultTo4 = getBorderRadiusOrDefaultTo(f4, BorderRadiusLocation.BOTTOM_RIGHT);
            boolean z = this.mLayoutDirection == 1;
            float borderRadiusOrDefaultTo5 = getBorderRadiusOrDefaultTo(Float.NaN, BorderRadiusLocation.TOP_START);
            float borderRadiusOrDefaultTo6 = getBorderRadiusOrDefaultTo(Float.NaN, BorderRadiusLocation.TOP_END);
            float borderRadiusOrDefaultTo7 = getBorderRadiusOrDefaultTo(Float.NaN, BorderRadiusLocation.BOTTOM_START);
            float borderRadiusOrDefaultTo8 = getBorderRadiusOrDefaultTo(Float.NaN, BorderRadiusLocation.BOTTOM_END);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (!ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo5)) {
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo5;
                }
                if (!ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo6)) {
                    borderRadiusOrDefaultTo2 = borderRadiusOrDefaultTo6;
                }
                if (!ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo7)) {
                    borderRadiusOrDefaultTo3 = borderRadiusOrDefaultTo7;
                }
                if (!ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo8)) {
                    borderRadiusOrDefaultTo4 = borderRadiusOrDefaultTo8;
                }
                f2 = z ? borderRadiusOrDefaultTo2 : borderRadiusOrDefaultTo;
                if (!z) {
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                }
                f = z ? borderRadiusOrDefaultTo4 : borderRadiusOrDefaultTo3;
                if (z) {
                    borderRadiusOrDefaultTo4 = borderRadiusOrDefaultTo3;
                }
            } else {
                float f5 = z ? borderRadiusOrDefaultTo6 : borderRadiusOrDefaultTo5;
                if (!z) {
                    borderRadiusOrDefaultTo5 = borderRadiusOrDefaultTo6;
                }
                float f6 = z ? borderRadiusOrDefaultTo8 : borderRadiusOrDefaultTo7;
                if (!z) {
                    borderRadiusOrDefaultTo7 = borderRadiusOrDefaultTo8;
                }
                if (!ReactYogaConfigProvider.isUndefined(f5)) {
                    borderRadiusOrDefaultTo = f5;
                }
                if (!ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo5)) {
                    borderRadiusOrDefaultTo2 = borderRadiusOrDefaultTo5;
                }
                if (!ReactYogaConfigProvider.isUndefined(f6)) {
                    borderRadiusOrDefaultTo3 = f6;
                }
                if (!ReactYogaConfigProvider.isUndefined(borderRadiusOrDefaultTo7)) {
                    f2 = borderRadiusOrDefaultTo;
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                    f = borderRadiusOrDefaultTo3;
                    borderRadiusOrDefaultTo4 = borderRadiusOrDefaultTo7;
                } else {
                    f2 = borderRadiusOrDefaultTo;
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                    f = borderRadiusOrDefaultTo3;
                }
            }
            float max = Math.max(f2 - directionAwareBorderInsets.left, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            float max2 = Math.max(f2 - directionAwareBorderInsets.top, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            float max3 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.right, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            float max4 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            float max5 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.right, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            float max6 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.bottom, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            float max7 = Math.max(f - directionAwareBorderInsets.left, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            float max8 = Math.max(f - directionAwareBorderInsets.bottom, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            this.mInnerClipPathForBorderRadius.addRoundRect(this.mInnerClipTempRectForBorderRadius, new float[]{max, max2, max3, max4, max5, max6, max7, max8}, Path.Direction.CW);
            this.mOuterClipPathForBorderRadius.addRoundRect(this.mOuterClipTempRectForBorderRadius, new float[]{f2, f2, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo4, borderRadiusOrDefaultTo4, f, f}, Path.Direction.CW);
            Spacing spacing = this.mBorderWidth;
            if (spacing != null) {
                i = 8;
                f3 = spacing.get(8) / 2.0f;
            } else {
                i = 8;
                f3 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            }
            Path path = this.mPathForBorderRadiusOutline;
            RectF rectF3 = this.mTempRectForBorderRadiusOutline;
            float[] fArr = new float[i];
            float f7 = f2 + f3;
            fArr[0] = f7;
            fArr[1] = f7;
            float f8 = borderRadiusOrDefaultTo + f3;
            fArr[2] = f8;
            fArr[3] = f8;
            float f9 = borderRadiusOrDefaultTo4 + f3;
            fArr[4] = f9;
            fArr[5] = f9;
            float f10 = f + f3;
            fArr[6] = f10;
            fArr[7] = f10;
            path.addRoundRect(rectF3, fArr, Path.Direction.CW);
            Path path2 = this.mCenterDrawPath;
            RectF rectF4 = this.mTempRectForCenterDrawPath;
            float[] fArr2 = new float[8];
            float f11 = directionAwareBorderInsets.left;
            fArr2[0] = Math.max(f2 - (f11 * 0.5f), f11 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? f2 / f11 : 0.0f);
            float f12 = directionAwareBorderInsets.top;
            fArr2[1] = Math.max(f2 - (f12 * 0.5f), f12 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? f2 / f12 : 0.0f);
            float f13 = directionAwareBorderInsets.right;
            fArr2[2] = Math.max(borderRadiusOrDefaultTo - (f13 * 0.5f), f13 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? borderRadiusOrDefaultTo / f13 : 0.0f);
            float f14 = directionAwareBorderInsets.top;
            fArr2[3] = Math.max(borderRadiusOrDefaultTo - (f14 * 0.5f), f14 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? borderRadiusOrDefaultTo / f14 : 0.0f);
            float f15 = directionAwareBorderInsets.right;
            fArr2[4] = Math.max(borderRadiusOrDefaultTo4 - (f15 * 0.5f), f15 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? borderRadiusOrDefaultTo4 / f15 : 0.0f);
            float f16 = directionAwareBorderInsets.bottom;
            fArr2[5] = Math.max(borderRadiusOrDefaultTo4 - (f16 * 0.5f), f16 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? borderRadiusOrDefaultTo4 / f16 : 0.0f);
            float f17 = directionAwareBorderInsets.left;
            fArr2[6] = Math.max(f - (f17 * 0.5f), f17 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? f / f17 : 0.0f);
            float f18 = directionAwareBorderInsets.bottom;
            fArr2[7] = Math.max(f - (f18 * 0.5f), f18 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? f / f18 : 0.0f);
            path2.addRoundRect(rectF4, fArr2, Path.Direction.CW);
            if (this.mInnerTopLeftCorner == null) {
                this.mInnerTopLeftCorner = new PointF();
            }
            PointF pointF = this.mInnerTopLeftCorner;
            RectF rectF5 = this.mInnerClipTempRectForBorderRadius;
            float f19 = rectF5.left;
            pointF.x = f19;
            float f20 = rectF5.top;
            pointF.y = f20;
            double d = (double) f19;
            double d2 = (double) f20;
            RectF rectF6 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine(d, d2, (double) ((max * 2.0f) + f19), (double) ((max2 * 2.0f) + f20), (double) rectF6.left, (double) rectF6.top, d, d2, pointF);
            if (this.mInnerBottomLeftCorner == null) {
                this.mInnerBottomLeftCorner = new PointF();
            }
            PointF pointF2 = this.mInnerBottomLeftCorner;
            RectF rectF7 = this.mInnerClipTempRectForBorderRadius;
            float f21 = rectF7.left;
            pointF2.x = f21;
            float f22 = rectF7.bottom;
            pointF2.y = f22;
            double d3 = (double) f21;
            double d4 = (double) f22;
            RectF rectF8 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine(d3, (double) (f22 - (max8 * 2.0f)), (double) ((max7 * 2.0f) + f21), d4, (double) rectF8.left, (double) rectF8.bottom, d3, d4, pointF2);
            if (this.mInnerTopRightCorner == null) {
                this.mInnerTopRightCorner = new PointF();
            }
            PointF pointF3 = this.mInnerTopRightCorner;
            RectF rectF9 = this.mInnerClipTempRectForBorderRadius;
            float f23 = rectF9.right;
            pointF3.x = f23;
            float f24 = rectF9.top;
            pointF3.y = f24;
            double d5 = (double) (f23 - (max3 * 2.0f));
            double d6 = (double) f24;
            double d7 = (double) f23;
            RectF rectF10 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine(d5, d6, d7, (double) ((max4 * 2.0f) + f24), (double) rectF10.right, (double) rectF10.top, d7, d6, pointF3);
            if (this.mInnerBottomRightCorner == null) {
                this.mInnerBottomRightCorner = new PointF();
            }
            PointF pointF4 = this.mInnerBottomRightCorner;
            RectF rectF11 = this.mInnerClipTempRectForBorderRadius;
            float f25 = rectF11.right;
            pointF4.x = f25;
            float f26 = rectF11.bottom;
            pointF4.y = f26;
            double d8 = (double) (f26 - (max6 * 2.0f));
            double d9 = (double) f25;
            double d10 = (double) f26;
            RectF rectF12 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine((double) (f25 - (max5 * 2.0f)), d8, d9, d10, (double) rectF12.right, (double) rectF12.bottom, d9, d10, pointF4);
        }
    }
}
