package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.graphics.ColorUtils;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    public static final int[] DEFAULT_STATE = {16842910};
    public static final ShapeDrawable closeIconRippleMask = new ShapeDrawable(new OvalShape());
    public int alpha = 255;
    public boolean checkable;
    public Drawable checkedIcon;
    public boolean checkedIconVisible;
    public ColorStateList chipBackgroundColor;
    public float chipCornerRadius;
    public float chipEndPadding;
    public Drawable chipIcon;
    public float chipIconSize;
    public ColorStateList chipIconTint;
    public boolean chipIconVisible;
    public float chipMinHeight;
    public final Paint chipPaint = new Paint(1);
    public float chipStartPadding;
    public ColorStateList chipStrokeColor;
    public float chipStrokeWidth;
    public ColorStateList chipSurfaceColor;
    public Drawable closeIcon;
    public CharSequence closeIconContentDescription;
    public float closeIconEndPadding;
    public Drawable closeIconRipple;
    public float closeIconSize;
    public float closeIconStartPadding;
    public int[] closeIconStateSet;
    public ColorStateList closeIconTint;
    public boolean closeIconVisible;
    public ColorFilter colorFilter;
    public ColorStateList compatRippleColor;
    public final Context context;
    public boolean currentChecked;
    public int currentChipBackgroundColor;
    public int currentChipStrokeColor;
    public int currentChipSurfaceColor;
    public int currentCompatRippleColor;
    public int currentCompositeSurfaceBackgroundColor;
    public int currentTextColor;
    public int currentTint;
    public final Paint debugPaint;
    public WeakReference<Delegate> delegate = new WeakReference<>(null);
    public final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    public boolean hasChipIconTint;
    public MotionSpec hideMotionSpec;
    public float iconEndPadding;
    public float iconStartPadding;
    public boolean isShapeThemingEnabled;
    public int maxWidth;
    public final PointF pointF = new PointF();
    public final RectF rectF = new RectF();
    public ColorStateList rippleColor;
    public final Path shapePath = new Path();
    public boolean shouldDrawText;
    public MotionSpec showMotionSpec;
    public CharSequence text;
    public final TextDrawableHelper textDrawableHelper;
    public float textEndPadding;
    public float textStartPadding;
    public ColorStateList tint;
    public PorterDuffColorFilter tintFilter;
    public PorterDuff.Mode tintMode = PorterDuff.Mode.SRC_IN;
    public TextUtils.TruncateAt truncateAt;
    public boolean useCompatRipple;

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    public ChipDrawable(Context context2, AttributeSet attributeSet, int i, int i2) {
        super(ShapeAppearanceModel.builder(context2, attributeSet, i, i2).build());
        this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context2);
        updateZ();
        this.context = context2;
        TextDrawableHelper textDrawableHelper2 = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper2;
        this.text = "";
        textDrawableHelper2.textPaint.density = context2.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        setState(DEFAULT_STATE);
        setCloseIconState(DEFAULT_STATE);
        this.shouldDrawText = true;
        boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
        closeIconRippleMask.setTint(-1);
    }

    public final void applyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.closeIcon) {
                if (drawable.isStateful()) {
                    drawable.setState(this.closeIconStateSet);
                }
                drawable.setTintList(this.closeIconTint);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.chipIcon;
            if (drawable == drawable2 && this.hasChipIconTint) {
                drawable2.setTintList(this.chipIconTint);
            }
        }
    }

    public final void calculateChipIconBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f = this.chipStartPadding + this.iconStartPadding;
            if (getLayoutDirection() == 0) {
                float f2 = ((float) rect.left) + f;
                rectF2.left = f2;
                rectF2.right = f2 + this.chipIconSize;
            } else {
                float f3 = ((float) rect.right) - f;
                rectF2.right = f3;
                rectF2.left = f3 - this.chipIconSize;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.chipIconSize;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF2.top = f5;
            rectF2.bottom = f5 + f4;
        }
    }

    public float calculateChipIconWidth() {
        if (showsChipIcon() || showsCheckedIcon()) {
            return this.iconStartPadding + this.chipIconSize + this.iconEndPadding;
        }
        return BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public final void calculateCloseIconBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding;
            if (getLayoutDirection() == 0) {
                float f2 = ((float) rect.right) - f;
                rectF2.right = f2;
                rectF2.left = f2 - this.closeIconSize;
            } else {
                float f3 = ((float) rect.left) + f;
                rectF2.left = f3;
                rectF2.right = f3 + this.closeIconSize;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.closeIconSize;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF2.top = f5;
            rectF2.bottom = f5 + f4;
        }
    }

    public final void calculateCloseIconTouchBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (getLayoutDirection() == 0) {
                float f2 = (float) rect.right;
                rectF2.right = f2;
                rectF2.left = f2 - f;
            } else {
                int i = rect.left;
                rectF2.left = (float) i;
                rectF2.right = ((float) i) + f;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    public float calculateCloseIconWidth() {
        return showsCloseIcon() ? this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && (i = this.alpha) != 0) {
            int saveLayerAlpha = i < 255 ? canvas.saveLayerAlpha((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i) : 0;
            if (!this.isShapeThemingEnabled) {
                this.chipPaint.setColor(this.currentChipSurfaceColor);
                this.chipPaint.setStyle(Paint.Style.FILL);
                this.rectF.set(bounds);
                canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
            }
            if (!this.isShapeThemingEnabled) {
                this.chipPaint.setColor(this.currentChipBackgroundColor);
                this.chipPaint.setStyle(Paint.Style.FILL);
                Paint paint = this.chipPaint;
                ColorFilter colorFilter2 = this.colorFilter;
                if (colorFilter2 == null) {
                    colorFilter2 = this.tintFilter;
                }
                paint.setColorFilter(colorFilter2);
                this.rectF.set(bounds);
                canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
            }
            if (this.isShapeThemingEnabled) {
                super.draw(canvas);
            }
            if (this.chipStrokeWidth > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && !this.isShapeThemingEnabled) {
                this.chipPaint.setColor(this.currentChipStrokeColor);
                this.chipPaint.setStyle(Paint.Style.STROKE);
                if (!this.isShapeThemingEnabled) {
                    Paint paint2 = this.chipPaint;
                    ColorFilter colorFilter3 = this.colorFilter;
                    if (colorFilter3 == null) {
                        colorFilter3 = this.tintFilter;
                    }
                    paint2.setColorFilter(colorFilter3);
                }
                RectF rectF2 = this.rectF;
                float f = this.chipStrokeWidth / 2.0f;
                rectF2.set(((float) bounds.left) + f, ((float) bounds.top) + f, ((float) bounds.right) - f, ((float) bounds.bottom) - f);
                float f2 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
                canvas.drawRoundRect(this.rectF, f2, f2, this.chipPaint);
            }
            this.chipPaint.setColor(this.currentCompatRippleColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.rectF.set(bounds);
            if (!this.isShapeThemingEnabled) {
                canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
            } else {
                calculatePathForSize(new RectF(bounds), this.shapePath);
                drawShape(canvas, this.chipPaint, this.shapePath, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
            }
            if (showsChipIcon()) {
                calculateChipIconBounds(bounds, this.rectF);
                RectF rectF3 = this.rectF;
                float f3 = rectF3.left;
                float f4 = rectF3.top;
                canvas.translate(f3, f4);
                this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
                this.chipIcon.draw(canvas);
                canvas.translate(-f3, -f4);
            }
            if (showsCheckedIcon()) {
                calculateChipIconBounds(bounds, this.rectF);
                RectF rectF4 = this.rectF;
                float f5 = rectF4.left;
                float f6 = rectF4.top;
                canvas.translate(f5, f6);
                this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
                this.checkedIcon.draw(canvas);
                canvas.translate(-f5, -f6);
            }
            if (!this.shouldDrawText || this.text == null) {
                i2 = saveLayerAlpha;
                i3 = 0;
                i4 = 255;
            } else {
                PointF pointF2 = this.pointF;
                pointF2.set(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                Paint.Align align = Paint.Align.LEFT;
                if (this.text != null) {
                    float calculateChipIconWidth = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                    if (getLayoutDirection() == 0) {
                        pointF2.x = ((float) bounds.left) + calculateChipIconWidth;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF2.x = ((float) bounds.right) - calculateChipIconWidth;
                        align = Paint.Align.RIGHT;
                    }
                    this.textDrawableHelper.textPaint.getFontMetrics(this.fontMetrics);
                    Paint.FontMetrics fontMetrics2 = this.fontMetrics;
                    pointF2.y = ((float) bounds.centerY()) - ((fontMetrics2.descent + fontMetrics2.ascent) / 2.0f);
                }
                RectF rectF5 = this.rectF;
                rectF5.setEmpty();
                if (this.text != null) {
                    float calculateChipIconWidth2 = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                    float calculateCloseIconWidth = calculateCloseIconWidth() + this.chipEndPadding + this.textEndPadding;
                    if (getLayoutDirection() == 0) {
                        rectF5.left = ((float) bounds.left) + calculateChipIconWidth2;
                        rectF5.right = ((float) bounds.right) - calculateCloseIconWidth;
                    } else {
                        rectF5.left = ((float) bounds.left) + calculateCloseIconWidth;
                        rectF5.right = ((float) bounds.right) - calculateChipIconWidth2;
                    }
                    rectF5.top = (float) bounds.top;
                    rectF5.bottom = (float) bounds.bottom;
                }
                TextDrawableHelper textDrawableHelper2 = this.textDrawableHelper;
                if (textDrawableHelper2.textAppearance != null) {
                    textDrawableHelper2.textPaint.drawableState = getState();
                    TextDrawableHelper textDrawableHelper3 = this.textDrawableHelper;
                    textDrawableHelper3.textAppearance.updateDrawState(this.context, textDrawableHelper3.textPaint, textDrawableHelper3.fontCallback);
                }
                this.textDrawableHelper.textPaint.setTextAlign(align);
                boolean z = Math.round(this.textDrawableHelper.getTextWidth(this.text.toString())) > Math.round(this.rectF.width());
                if (z) {
                    i7 = canvas.save();
                    canvas.clipRect(this.rectF);
                } else {
                    i7 = 0;
                }
                CharSequence charSequence = this.text;
                if (z && this.truncateAt != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.textDrawableHelper.textPaint, this.rectF.width(), this.truncateAt);
                }
                int length = charSequence.length();
                PointF pointF3 = this.pointF;
                i2 = saveLayerAlpha;
                i3 = 0;
                i4 = 255;
                canvas.drawText(charSequence, 0, length, pointF3.x, pointF3.y, this.textDrawableHelper.textPaint);
                if (z) {
                    canvas.restoreToCount(i7);
                }
            }
            if (showsCloseIcon()) {
                calculateCloseIconBounds(bounds, this.rectF);
                RectF rectF6 = this.rectF;
                float f7 = rectF6.left;
                float f8 = rectF6.top;
                canvas.translate(f7, f8);
                this.closeIcon.setBounds(i3, i3, (int) this.rectF.width(), (int) this.rectF.height());
                boolean z2 = RippleUtils.USE_FRAMEWORK_RIPPLE;
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(canvas);
                canvas.translate(-f7, -f8);
            }
            Paint paint3 = this.debugPaint;
            if (paint3 != null) {
                paint3.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
                canvas.drawRect(bounds, this.debugPaint);
                if (showsChipIcon() || showsCheckedIcon()) {
                    calculateChipIconBounds(bounds, this.rectF);
                    canvas.drawRect(this.rectF, this.debugPaint);
                }
                if (this.text != null) {
                    i6 = i4;
                    i5 = i2;
                    canvas.drawLine((float) bounds.left, bounds.exactCenterY(), (float) bounds.right, bounds.exactCenterY(), this.debugPaint);
                } else {
                    i6 = i4;
                    i5 = i2;
                }
                if (showsCloseIcon()) {
                    calculateCloseIconBounds(bounds, this.rectF);
                    canvas.drawRect(this.rectF, this.debugPaint);
                }
                this.debugPaint.setColor(ColorUtils.setAlphaComponent(-65536, 127));
                RectF rectF7 = this.rectF;
                rectF7.set(bounds);
                if (showsCloseIcon()) {
                    float f9 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
                    if (getLayoutDirection() == 0) {
                        rectF7.right = ((float) bounds.right) - f9;
                    } else {
                        rectF7.left = ((float) bounds.left) + f9;
                    }
                }
                canvas.drawRect(this.rectF, this.debugPaint);
                this.debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
                calculateCloseIconTouchBounds(bounds, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            } else {
                i6 = i4;
                i5 = i2;
            }
            if (this.alpha < i6) {
                canvas.restoreToCount(i5);
            }
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    public float getChipCornerRadius() {
        return this.isShapeThemingEnabled ? getTopLeftCornerResolvedSize() : this.chipCornerRadius;
    }

    public Drawable getCloseIcon() {
        Drawable drawable = this.closeIcon;
        if (drawable != null) {
            return AppCompatDelegateImpl.ConfigurationImplApi17.unwrap(drawable);
        }
        return null;
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(calculateCloseIconWidth() + this.textDrawableHelper.getTextWidth(this.text.toString()) + calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding + this.textEndPadding + this.chipEndPadding), this.maxWidth);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.chipMinHeight, this.chipCornerRadius);
        }
        outline.setAlpha(((float) this.alpha) / 255.0f);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (!isStateful(this.chipSurfaceColor) && !isStateful(this.chipBackgroundColor) && !isStateful(this.chipStrokeColor) && (!this.useCompatRipple || !isStateful(this.compatRippleColor))) {
            TextAppearance textAppearance = this.textDrawableHelper.textAppearance;
            if (!((textAppearance == null || (colorStateList = textAppearance.textColor) == null || !colorStateList.isStateful()) ? false : true)) {
                if (!(this.checkedIconVisible && this.checkedIcon != null && this.checkable) && !isStateful(this.chipIcon) && !isStateful(this.checkedIcon) && !isStateful(this.tint)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= this.chipIcon.setLayoutDirection(i);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= this.checkedIcon.setLayoutDirection(i);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= this.closeIcon.setLayoutDirection(i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(i);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(i);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public void onSizeChange() {
        Delegate delegate2 = this.delegate.get();
        if (delegate2 != null) {
            delegate2.onChipDrawableSizeChange();
        }
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate, com.google.android.material.shape.MaterialShapeDrawable
    public boolean onStateChange(int[] iArr) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(iArr);
        }
        return onStateChange(iArr, this.closeIconStateSet);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.checkedIconVisible != z) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        if (this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        if (this.chipCornerRadius != f) {
            this.chipCornerRadius = f;
            this.drawableState.shapeAppearanceModel = this.drawableState.shapeAppearanceModel.withCornerSize(f);
            invalidateSelf();
        }
    }

    public void setChipEndPadding(float f) {
        if (this.chipEndPadding != f) {
            this.chipEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipIcon(Drawable drawable) {
        Drawable drawable2 = this.chipIcon;
        Drawable drawable3 = null;
        Drawable unwrap = drawable2 != null ? AppCompatDelegateImpl.ConfigurationImplApi17.unwrap(drawable2) : null;
        if (unwrap != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.chipIcon = drawable3;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(unwrap);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconSize(float f) {
        if (this.chipIconSize != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        this.hasChipIconTint = true;
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                this.chipIcon.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipIconVisible(boolean z) {
        if (this.chipIconVisible != z) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipMinHeight(float f) {
        if (this.chipMinHeight != f) {
            this.chipMinHeight = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStartPadding(float f) {
        if (this.chipStartPadding != f) {
            this.chipStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipStrokeWidth(float f) {
        if (this.chipStrokeWidth != f) {
            this.chipStrokeWidth = f;
            this.chipPaint.setStrokeWidth(f);
            if (this.isShapeThemingEnabled) {
                this.drawableState.strokeWidth = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void setCloseIcon(Drawable drawable) {
        Drawable closeIcon2 = getCloseIcon();
        if (closeIcon2 != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            this.closeIcon = drawable != null ? drawable.mutate() : null;
            boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
            this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), this.closeIcon, closeIconRippleMask);
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon2);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconEndPadding(float f) {
        if (this.closeIconEndPadding != f) {
            this.closeIconEndPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconSize(float f) {
        if (this.closeIconSize != f) {
            this.closeIconSize = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconStartPadding(float f) {
        if (this.closeIconStartPadding != f) {
            this.closeIconStartPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public boolean setCloseIconState(int[] iArr) {
        if (Arrays.equals(this.closeIconStateSet, iArr)) {
            return false;
        }
        this.closeIconStateSet = iArr;
        if (showsCloseIcon()) {
            return onStateChange(getState(), iArr);
        }
        return false;
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                this.closeIcon.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconVisible(boolean z) {
        if (this.closeIconVisible != z) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public void setColorFilter(ColorFilter colorFilter2) {
        if (this.colorFilter != colorFilter2) {
            this.colorFilter = colorFilter2;
            invalidateSelf();
        }
    }

    public void setIconEndPadding(float f) {
        if (this.iconEndPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconStartPadding(float f) {
        if (this.iconStartPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            this.compatRippleColor = this.useCompatRipple ? RippleUtils.sanitizeRippleDrawableColor(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textDrawableHelper.textWidthDirty = true;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        TextDrawableHelper textDrawableHelper2 = this.textDrawableHelper;
        Context context2 = this.context;
        if (textDrawableHelper2.textAppearance != textAppearance) {
            textDrawableHelper2.textAppearance = textAppearance;
            if (textAppearance != null) {
                TextPaint textPaint = textDrawableHelper2.textPaint;
                TextAppearanceFontCallback textAppearanceFontCallback = textDrawableHelper2.fontCallback;
                textAppearance.createFallbackFont();
                textAppearance.updateTextPaintMeasureState(textPaint, textAppearance.font);
                textAppearance.getFontAsync(context2, new TextAppearanceFontCallback(textPaint, textAppearanceFontCallback) {
                    /* class com.google.android.material.resources.TextAppearance.AnonymousClass2 */

                    @Override // com.google.android.material.resources.TextAppearanceFontCallback
                    public void onFontRetrievalFailed(int i) {
                        r7.onFontRetrievalFailed(i);
                    }

                    @Override // com.google.android.material.resources.TextAppearanceFontCallback
                    public void onFontRetrieved(Typeface typeface, boolean z) {
                        TextAppearance.this.updateTextPaintMeasureState(r6, typeface);
                        r7.onFontRetrieved(typeface, z);
                    }
                });
                TextDrawableHelper.TextDrawableDelegate textDrawableDelegate = textDrawableHelper2.delegate.get();
                if (textDrawableDelegate != null) {
                    textDrawableHelper2.textPaint.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.updateDrawState(context2, textDrawableHelper2.textPaint, textDrawableHelper2.fontCallback);
                textDrawableHelper2.textWidthDirty = true;
            }
            TextDrawableHelper.TextDrawableDelegate textDrawableDelegate2 = textDrawableHelper2.delegate.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.onTextSizeChange();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    public void setTextEndPadding(float f) {
        if (this.textEndPadding != f) {
            this.textEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextStartPadding(float f) {
        if (this.textStartPadding != f) {
            this.textStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = ReactYogaConfigProvider.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z) {
        if (this.useCompatRipple != z) {
            this.useCompatRipple = z;
            this.compatRippleColor = z ? RippleUtils.sanitizeRippleDrawableColor(this.rippleColor) : null;
            onStateChange(getState());
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final boolean showsCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.currentChecked;
    }

    public final boolean showsChipIcon() {
        return this.chipIconVisible && this.chipIcon != null;
    }

    public final boolean showsCloseIcon() {
        return this.closeIconVisible && this.closeIcon != null;
    }

    public final void unapplyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0147  */
    public final boolean onStateChange(int[] iArr, int[] iArr2) {
        boolean z;
        boolean z2;
        boolean z3;
        int colorForState;
        ColorStateList colorStateList;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.chipSurfaceColor;
        int colorForState2 = colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.currentChipSurfaceColor) : 0;
        boolean z4 = true;
        if (this.currentChipSurfaceColor != colorForState2) {
            this.currentChipSurfaceColor = colorForState2;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.chipBackgroundColor;
        int colorForState3 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.currentChipBackgroundColor) : 0;
        if (this.currentChipBackgroundColor != colorForState3) {
            this.currentChipBackgroundColor = colorForState3;
            onStateChange = true;
        }
        int compositeColors = ColorUtils.compositeColors(colorForState3, colorForState2);
        if ((this.currentCompositeSurfaceBackgroundColor != compositeColors) || (this.drawableState.fillColor == null)) {
            this.currentCompositeSurfaceBackgroundColor = compositeColors;
            setFillColor(ColorStateList.valueOf(compositeColors));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.chipStrokeColor;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.currentChipStrokeColor) : 0;
        if (this.currentChipStrokeColor != colorForState4) {
            this.currentChipStrokeColor = colorForState4;
            onStateChange = true;
        }
        int colorForState5 = (this.compatRippleColor == null || !RippleUtils.shouldDrawRippleCompat(iArr)) ? 0 : this.compatRippleColor.getColorForState(iArr, this.currentCompatRippleColor);
        if (this.currentCompatRippleColor != colorForState5) {
            this.currentCompatRippleColor = colorForState5;
            if (this.useCompatRipple) {
                onStateChange = true;
            }
        }
        TextAppearance textAppearance = this.textDrawableHelper.textAppearance;
        int colorForState6 = (textAppearance == null || (colorStateList = textAppearance.textColor) == null) ? 0 : colorStateList.getColorForState(iArr, this.currentTextColor);
        if (this.currentTextColor != colorForState6) {
            this.currentTextColor = colorForState6;
            onStateChange = true;
        }
        int[] state = getState();
        if (state != null) {
            int length = state.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (state[i] == 16842912) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            z2 = !z && this.checkable;
            if (this.currentChecked != z2 || this.checkedIcon == null) {
                z3 = false;
            } else {
                float calculateChipIconWidth = calculateChipIconWidth();
                this.currentChecked = z2;
                if (calculateChipIconWidth != calculateChipIconWidth()) {
                    onStateChange = true;
                    z3 = true;
                } else {
                    z3 = false;
                    onStateChange = true;
                }
            }
            ColorStateList colorStateList5 = this.tint;
            colorForState = colorStateList5 == null ? colorStateList5.getColorForState(iArr, this.currentTint) : 0;
            if (this.currentTint == colorForState) {
                this.currentTint = colorForState;
                this.tintFilter = ReactYogaConfigProvider.updateTintFilter(this, this.tint, this.tintMode);
            } else {
                z4 = onStateChange;
            }
            if (isStateful(this.chipIcon)) {
                z4 |= this.chipIcon.setState(iArr);
            }
            if (isStateful(this.checkedIcon)) {
                z4 |= this.checkedIcon.setState(iArr);
            }
            if (isStateful(this.closeIcon)) {
                int[] iArr3 = new int[(iArr.length + iArr2.length)];
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                z4 |= this.closeIcon.setState(iArr3);
            }
            boolean z5 = RippleUtils.USE_FRAMEWORK_RIPPLE;
            if (isStateful(this.closeIconRipple)) {
                z4 |= this.closeIconRipple.setState(iArr2);
            }
            if (z4) {
                invalidateSelf();
            }
            if (z3) {
                onSizeChange();
            }
            return z4;
        }
        z = false;
        if (!z) {
        }
        if (this.currentChecked != z2) {
        }
        z3 = false;
        ColorStateList colorStateList52 = this.tint;
        if (colorStateList52 == null) {
        }
        if (this.currentTint == colorForState) {
        }
        if (isStateful(this.chipIcon)) {
        }
        if (isStateful(this.checkedIcon)) {
        }
        if (isStateful(this.closeIcon)) {
        }
        boolean z52 = RippleUtils.USE_FRAMEWORK_RIPPLE;
        if (isStateful(this.closeIconRipple)) {
        }
        if (z4) {
        }
        if (z3) {
        }
        return z4;
    }

    public static boolean isStateful(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean isStateful(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }
}
