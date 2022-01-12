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
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("TextAttributes {\n  getAllowFontScaling(): ");
        outline17.append(this.mAllowFontScaling);
        outline17.append("\n  getFontSize(): ");
        outline17.append(this.mFontSize);
        outline17.append("\n  getEffectiveFontSize(): ");
        outline17.append(getEffectiveFontSize());
        outline17.append("\n  getHeightOfTallestInlineViewOrImage(): ");
        outline17.append(this.mHeightOfTallestInlineViewOrImage);
        outline17.append("\n  getLetterSpacing(): ");
        outline17.append(this.mLetterSpacing);
        outline17.append("\n  getEffectiveLetterSpacing(): ");
        outline17.append(getEffectiveLetterSpacing());
        outline17.append("\n  getLineHeight(): ");
        outline17.append(this.mLineHeight);
        outline17.append("\n  getEffectiveLineHeight(): ");
        outline17.append(getEffectiveLineHeight());
        outline17.append("\n  getTextTransform(): ");
        outline17.append(this.mTextTransform);
        outline17.append("\n  getMaxFontSizeMultiplier(): ");
        outline17.append(this.mMaxFontSizeMultiplier);
        outline17.append("\n  getEffectiveMaxFontSizeMultiplier(): ");
        outline17.append(getEffectiveMaxFontSizeMultiplier());
        outline17.append("\n}");
        return outline17.toString();
    }
}
