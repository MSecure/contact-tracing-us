package com.facebook.react.views.text;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.BaseViewManager;

public class TextAttributes {
    public boolean mAllowFontScaling = true;
    public float mFontSize = Float.NaN;
    public float mHeightOfTallestInlineViewOrImage = Float.NaN;
    public float mLetterSpacing = Float.NaN;
    public float mLineHeight = Float.NaN;
    public float mMaxFontSizeMultiplier = Float.NaN;
    public TextTransform mTextTransform = TextTransform.UNSET;

    public int getEffectiveFontSize() {
        double d;
        float f = !Float.isNaN(this.mFontSize) ? this.mFontSize : 14.0f;
        if (this.mAllowFontScaling) {
            d = Math.ceil((double) AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromSP(f, getEffectiveMaxFontSizeMultiplier()));
        } else {
            d = Math.ceil((double) AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f));
        }
        return (int) d;
    }

    public float getEffectiveLetterSpacing() {
        float f;
        if (Float.isNaN(this.mLetterSpacing)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            f = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromSP(this.mLetterSpacing, getEffectiveMaxFontSizeMultiplier());
        } else {
            f = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(this.mLetterSpacing);
        }
        return f / ((float) getEffectiveFontSize());
    }

    public float getEffectiveLineHeight() {
        float f;
        if (Float.isNaN(this.mLineHeight)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            f = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromSP(this.mLineHeight, getEffectiveMaxFontSizeMultiplier());
        } else {
            f = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(this.mLineHeight);
        }
        return !Float.isNaN(this.mHeightOfTallestInlineViewOrImage) && (this.mHeightOfTallestInlineViewOrImage > f ? 1 : (this.mHeightOfTallestInlineViewOrImage == f ? 0 : -1)) > 0 ? this.mHeightOfTallestInlineViewOrImage : f;
    }

    public float getEffectiveMaxFontSizeMultiplier() {
        return !Float.isNaN(this.mMaxFontSizeMultiplier) ? this.mMaxFontSizeMultiplier : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    public void setMaxFontSizeMultiplier(float f) {
        if (f == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f >= 1.0f) {
            this.mMaxFontSizeMultiplier = f;
            return;
        }
        throw new JSApplicationIllegalArgumentException("maxFontSizeMultiplier must be NaN, 0, or >= 1");
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("TextAttributes {\n  getAllowFontScaling(): ");
        outline15.append(this.mAllowFontScaling);
        outline15.append("\n  getFontSize(): ");
        outline15.append(this.mFontSize);
        outline15.append("\n  getEffectiveFontSize(): ");
        outline15.append(getEffectiveFontSize());
        outline15.append("\n  getHeightOfTallestInlineViewOrImage(): ");
        outline15.append(this.mHeightOfTallestInlineViewOrImage);
        outline15.append("\n  getLetterSpacing(): ");
        outline15.append(this.mLetterSpacing);
        outline15.append("\n  getEffectiveLetterSpacing(): ");
        outline15.append(getEffectiveLetterSpacing());
        outline15.append("\n  getLineHeight(): ");
        outline15.append(this.mLineHeight);
        outline15.append("\n  getEffectiveLineHeight(): ");
        outline15.append(getEffectiveLineHeight());
        outline15.append("\n  getTextTransform(): ");
        outline15.append(this.mTextTransform);
        outline15.append("\n  getMaxFontSizeMultiplier(): ");
        outline15.append(this.mMaxFontSizeMultiplier);
        outline15.append("\n  getEffectiveMaxFontSizeMultiplier(): ");
        outline15.append(getEffectiveMaxFontSizeMultiplier());
        outline15.append("\n}");
        return outline15.toString();
    }
}
