package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.CancelableFontCallback;

public final class CollapsingTextHelper {
    public static final Paint DEBUG_DRAW_PAINT = null;
    public boolean boundsChanged;
    public final Rect collapsedBounds;
    public float collapsedDrawX;
    public float collapsedDrawY;
    public CancelableFontCallback collapsedFontCallback;
    public ColorStateList collapsedShadowColor;
    public float collapsedShadowDx;
    public float collapsedShadowDy;
    public float collapsedShadowRadius;
    public ColorStateList collapsedTextColor;
    public int collapsedTextGravity = 16;
    public float collapsedTextSize = 15.0f;
    public Typeface collapsedTypeface;
    public final RectF currentBounds;
    public float currentDrawX;
    public float currentDrawY;
    public float currentTextSize;
    public Typeface currentTypeface;
    public boolean drawTitle;
    public final Rect expandedBounds;
    public float expandedDrawX;
    public float expandedDrawY;
    public float expandedFraction;
    public ColorStateList expandedTextColor;
    public int expandedTextGravity = 16;
    public float expandedTextSize = 15.0f;
    public Bitmap expandedTitleTexture;
    public Typeface expandedTypeface;
    public boolean isRtl;
    public TimeInterpolator positionInterpolator;
    public float scale;
    public int[] state;
    public CharSequence text;
    public final TextPaint textPaint;
    public TimeInterpolator textSizeInterpolator;
    public CharSequence textToDraw;
    public float textureAscent;
    public float textureDescent;
    public Paint texturePaint;
    public final TextPaint tmpPaint;
    public boolean useTexture;
    public final View view;

    static {
        Paint paint = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            DEBUG_DRAW_PAINT.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view2) {
        this.view = view2;
        this.textPaint = new TextPaint(129);
        this.tmpPaint = new TextPaint(this.textPaint);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
    }

    public static int blendColors(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f) + (((float) Color.alpha(i)) * f2)), (int) ((((float) Color.red(i2)) * f) + (((float) Color.red(i)) * f2)), (int) ((((float) Color.green(i2)) * f) + (((float) Color.green(i)) * f2)), (int) ((((float) Color.blue(i2)) * f) + (((float) Color.blue(i)) * f2)));
    }

    public static float lerp(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return AnimationUtils.lerp(f, f2, f3);
    }

    public static boolean rectEquals(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    public float calculateCollapsedTextWidth() {
        if (this.text == null) {
            return BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        }
        TextPaint textPaint2 = this.tmpPaint;
        textPaint2.setTextSize(this.collapsedTextSize);
        textPaint2.setTypeface(this.collapsedTypeface);
        TextPaint textPaint3 = this.tmpPaint;
        CharSequence charSequence = this.text;
        return textPaint3.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean calculateIsRtl(CharSequence charSequence) {
        boolean z = true;
        if (ViewCompat.getLayoutDirection(this.view) != 1) {
            z = false;
        }
        return ((TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl) (z ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR)).isRtl(charSequence, 0, charSequence.length());
    }

    public final void calculateOffsets(float f) {
        this.currentBounds.left = lerp((float) this.expandedBounds.left, (float) this.collapsedBounds.left, f, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        this.currentBounds.right = lerp((float) this.expandedBounds.right, (float) this.collapsedBounds.right, f, this.positionInterpolator);
        this.currentBounds.bottom = lerp((float) this.expandedBounds.bottom, (float) this.collapsedBounds.bottom, f, this.positionInterpolator);
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f, this.textSizeInterpolator));
        ColorStateList colorStateList = this.collapsedTextColor;
        ColorStateList colorStateList2 = this.expandedTextColor;
        if (colorStateList != colorStateList2) {
            this.textPaint.setColor(blendColors(getCurrentColor(colorStateList2), getCurrentCollapsedTextColor(), f));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        this.textPaint.setShadowLayer(lerp(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, this.collapsedShadowRadius, f, null), lerp(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, this.collapsedShadowDx, f, null), lerp(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, this.collapsedShadowDy, f, null), blendColors(getCurrentColor(null), getCurrentColor(this.collapsedShadowColor), f));
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    public final void calculateUsingTextSize(float f) {
        float f2;
        boolean z;
        if (this.text != null) {
            float width = (float) this.collapsedBounds.width();
            float width2 = (float) this.expandedBounds.width();
            boolean z2 = true;
            if (Math.abs(f - this.collapsedTextSize) < 0.001f) {
                f2 = this.collapsedTextSize;
                this.scale = 1.0f;
                Typeface typeface = this.currentTypeface;
                Typeface typeface2 = this.collapsedTypeface;
                if (typeface != typeface2) {
                    this.currentTypeface = typeface2;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                float f3 = this.expandedTextSize;
                Typeface typeface3 = this.currentTypeface;
                Typeface typeface4 = this.expandedTypeface;
                if (typeface3 != typeface4) {
                    this.currentTypeface = typeface4;
                    z = true;
                } else {
                    z = false;
                }
                if (Math.abs(f - this.expandedTextSize) < 0.001f) {
                    this.scale = 1.0f;
                } else {
                    this.scale = f / this.expandedTextSize;
                }
                float f4 = this.collapsedTextSize / this.expandedTextSize;
                width = width2 * f4 > width ? Math.min(width / f4, width2) : width2;
                f2 = f3;
            }
            if (width > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                z = this.currentTextSize != f2 || this.boundsChanged || z;
                this.currentTextSize = f2;
                this.boundsChanged = false;
            }
            if (this.textToDraw == null || z) {
                this.textPaint.setTextSize(this.currentTextSize);
                this.textPaint.setTypeface(this.currentTypeface);
                TextPaint textPaint2 = this.textPaint;
                if (this.scale == 1.0f) {
                    z2 = false;
                }
                textPaint2.setLinearText(z2);
                CharSequence ellipsize = TextUtils.ellipsize(this.text, this.textPaint, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.textToDraw)) {
                    this.textToDraw = ellipsize;
                    this.isRtl = calculateIsRtl(ellipsize);
                }
            }
        }
    }

    public float getCollapsedTextHeight() {
        TextPaint textPaint2 = this.tmpPaint;
        textPaint2.setTextSize(this.collapsedTextSize);
        textPaint2.setTypeface(this.collapsedTypeface);
        return -this.tmpPaint.ascent();
    }

    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public final int getCurrentColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public void onBoundsChanged() {
        this.drawTitle = this.collapsedBounds.width() > 0 && this.collapsedBounds.height() > 0 && this.expandedBounds.width() > 0 && this.expandedBounds.height() > 0;
    }

    public void recalculate() {
        if (this.view.getHeight() > 0 && this.view.getWidth() > 0) {
            float f = this.currentTextSize;
            calculateUsingTextSize(this.collapsedTextSize);
            CharSequence charSequence = this.textToDraw;
            float f2 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            float measureText = charSequence != null ? this.textPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
            int absoluteGravity = Gravity.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
            int i = absoluteGravity & 112;
            if (i == 48) {
                this.collapsedDrawY = ((float) this.collapsedBounds.top) - this.textPaint.ascent();
            } else if (i != 80) {
                this.collapsedDrawY = ((float) this.collapsedBounds.centerY()) + (((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f) - this.textPaint.descent());
            } else {
                this.collapsedDrawY = (float) this.collapsedBounds.bottom;
            }
            int i2 = absoluteGravity & 8388615;
            if (i2 == 1) {
                this.collapsedDrawX = ((float) this.collapsedBounds.centerX()) - (measureText / 2.0f);
            } else if (i2 != 5) {
                this.collapsedDrawX = (float) this.collapsedBounds.left;
            } else {
                this.collapsedDrawX = ((float) this.collapsedBounds.right) - measureText;
            }
            calculateUsingTextSize(this.expandedTextSize);
            CharSequence charSequence2 = this.textToDraw;
            if (charSequence2 != null) {
                f2 = this.textPaint.measureText(charSequence2, 0, charSequence2.length());
            }
            int absoluteGravity2 = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
            int i3 = absoluteGravity2 & 112;
            if (i3 == 48) {
                this.expandedDrawY = ((float) this.expandedBounds.top) - this.textPaint.ascent();
            } else if (i3 != 80) {
                this.expandedDrawY = ((float) this.expandedBounds.centerY()) + (((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f) - this.textPaint.descent());
            } else {
                this.expandedDrawY = (float) this.expandedBounds.bottom;
            }
            int i4 = absoluteGravity2 & 8388615;
            if (i4 == 1) {
                this.expandedDrawX = ((float) this.expandedBounds.centerX()) - (f2 / 2.0f);
            } else if (i4 != 5) {
                this.expandedDrawX = (float) this.expandedBounds.left;
            } else {
                this.expandedDrawX = ((float) this.expandedBounds.right) - f2;
            }
            Bitmap bitmap = this.expandedTitleTexture;
            if (bitmap != null) {
                bitmap.recycle();
                this.expandedTitleTexture = null;
            }
            setInterpolatedTextSize(f);
            calculateOffsets(this.expandedFraction);
        }
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpansionFraction(float f) {
        if (f < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.expandedFraction) {
            this.expandedFraction = f;
            calculateOffsets(f);
        }
    }

    public final void setInterpolatedTextSize(float f) {
        calculateUsingTextSize(f);
        this.useTexture = false;
        if (0 != 0 && this.expandedTitleTexture == null && !this.expandedBounds.isEmpty() && !TextUtils.isEmpty(this.textToDraw)) {
            calculateOffsets(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            this.textureAscent = this.textPaint.ascent();
            this.textureDescent = this.textPaint.descent();
            TextPaint textPaint2 = this.textPaint;
            CharSequence charSequence = this.textToDraw;
            int round = Math.round(textPaint2.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.textureDescent - this.textureAscent);
            if (round > 0 && round2 > 0) {
                this.expandedTitleTexture = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.expandedTitleTexture);
                CharSequence charSequence2 = this.textToDraw;
                canvas.drawText(charSequence2, 0, charSequence2.length(), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, ((float) round2) - this.textPaint.descent(), this.textPaint);
                if (this.texturePaint == null) {
                    this.texturePaint = new Paint(3);
                }
            }
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    public void setTypefaces(Typeface typeface) {
        boolean z;
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        boolean z2 = true;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        if (this.collapsedTypeface != typeface) {
            this.collapsedTypeface = typeface;
            z = true;
        } else {
            z = false;
        }
        if (this.expandedTypeface != typeface) {
            this.expandedTypeface = typeface;
        } else {
            z2 = false;
        }
        if (z || z2) {
            recalculate();
        }
    }
}
