package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$styleable;

public class TextAppearance {
    public Typeface font;
    public final String fontFamily;
    public final int fontFamilyResourceId;
    public boolean fontResolved = false;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final ColorStateList textColor;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        this.textColor = ReactYogaConfigProvider.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        ReactYogaConfigProvider.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        ReactYogaConfigProvider.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int i2 = R$styleable.TextAppearance_fontFamily;
        i2 = !obtainStyledAttributes.hasValue(i2) ? R$styleable.TextAppearance_android_fontFamily : i2;
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(i2, 0);
        this.fontFamily = obtainStyledAttributes.getString(i2);
        obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = ReactYogaConfigProvider.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        this.shadowDy = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        this.shadowRadius = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        obtainStyledAttributes.recycle();
    }

    public final void createFallbackFont() {
        String str;
        if (this.font == null && (str = this.fontFamily) != null) {
            this.font = Typeface.create(str, this.textStyle);
        }
        if (this.font == null) {
            int i = this.typeface;
            if (i == 1) {
                this.font = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.font = Typeface.SERIF;
            } else if (i != 3) {
                this.font = Typeface.DEFAULT;
            } else {
                this.font = Typeface.MONOSPACE;
            }
            this.font = Typeface.create(this.font, this.textStyle);
        }
    }

    public void getFontAsync(Context context, final TextAppearanceFontCallback textAppearanceFontCallback) {
        createFallbackFont();
        if (this.fontFamilyResourceId == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            int i = this.fontFamilyResourceId;
            AnonymousClass1 r6 = new ResourcesCompat$FontCallback() {
                /* class com.google.android.material.resources.TextAppearance.AnonymousClass1 */

                @Override // androidx.core.content.res.ResourcesCompat$FontCallback
                public void onFontRetrievalFailed(int i) {
                    TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrievalFailed(i);
                }

                @Override // androidx.core.content.res.ResourcesCompat$FontCallback
                public void onFontRetrieved(Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
                    TextAppearance textAppearance2 = TextAppearance.this;
                    textAppearance2.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrieved(textAppearance2.font, false);
                }
            };
            if (context.isRestricted()) {
                r6.callbackFailAsync(-4, null);
            } else {
                AppCompatDelegateImpl.ConfigurationImplApi17.loadFont(context, i, new TypedValue(), 0, r6, null, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception unused2) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    public void updateDrawState(Context context, final TextPaint textPaint, final TextAppearanceFontCallback textAppearanceFontCallback) {
        createFallbackFont();
        updateTextPaintMeasureState(textPaint, this.font);
        getFontAsync(context, new TextAppearanceFontCallback() {
            /* class com.google.android.material.resources.TextAppearance.AnonymousClass2 */

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrievalFailed(int i) {
                textAppearanceFontCallback.onFontRetrievalFailed(i);
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrieved(Typeface typeface, boolean z) {
                TextAppearance.this.updateTextPaintMeasureState(textPaint, typeface);
                textAppearanceFontCallback.onFontRetrieved(typeface, z);
            }
        });
        ColorStateList colorStateList = this.textColor;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.shadowRadius;
        float f2 = this.shadowDx;
        float f3 = this.shadowDy;
        ColorStateList colorStateList2 = this.shadowColor;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void updateTextPaintMeasureState(TextPaint textPaint, Typeface typeface2) {
        textPaint.setTypeface(typeface2);
        int i = (~typeface2.getStyle()) & this.textStyle;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        textPaint.setTextSize(this.textSize);
    }
}
