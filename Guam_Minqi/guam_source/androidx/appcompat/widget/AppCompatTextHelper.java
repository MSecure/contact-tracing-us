package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;

public class AppCompatTextHelper {
    public boolean mAsyncFontPending;
    public final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    public TintInfo mDrawableBottomTint;
    public TintInfo mDrawableEndTint;
    public TintInfo mDrawableLeftTint;
    public TintInfo mDrawableRightTint;
    public TintInfo mDrawableStartTint;
    public TintInfo mDrawableTint;
    public TintInfo mDrawableTopTint;
    public Typeface mFontTypeface;
    public int mFontWeight = -1;
    public int mStyle = 0;
    public final TextView mView;

    public AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
    }

    public static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    public final void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    public void applyCompoundDrawablesTints() {
        if (!(this.mDrawableLeftTint == null && this.mDrawableTopTint == null && this.mDrawableRightTint == null && this.mDrawableBottomTint == null)) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
        }
    }

    public boolean isAutoSizeEnabled() {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        return appCompatTextViewAutoSizeHelper.supportsAutoSizeText() && appCompatTextViewAutoSizeHelper.mAutoSizeTextType != 0;
    }

    @SuppressLint({"NewApi"})
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        int resourceId;
        int resourceId2;
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R$styleable.AppCompatTextHelper, i, 0);
        TextView textView = this.mView;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), R$styleable.AppCompatTextHelper, attributeSet, obtainStyledAttributes.mWrapped, i, 0);
        int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextHelper_android_drawableTop)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextHelper_android_drawableRight)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextHelper_android_drawableStart)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.mWrapped.recycle();
        boolean z3 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (resourceId3 != -1) {
            TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(resourceId3, R$styleable.TextAppearance));
            if (z3 || !tintTypedArray.hasValue(R$styleable.TextAppearance_textAllCaps)) {
                z2 = false;
                z = false;
            } else {
                z2 = tintTypedArray.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
                z = true;
            }
            updateTypefaceAndStyle(context, tintTypedArray);
            str2 = tintTypedArray.hasValue(R$styleable.TextAppearance_textLocale) ? tintTypedArray.getString(R$styleable.TextAppearance_textLocale) : null;
            str = (Build.VERSION.SDK_INT < 26 || !tintTypedArray.hasValue(R$styleable.TextAppearance_fontVariationSettings)) ? null : tintTypedArray.getString(R$styleable.TextAppearance_fontVariationSettings);
            tintTypedArray.mWrapped.recycle();
        } else {
            z2 = false;
            z = false;
            str2 = null;
            str = null;
        }
        TintTypedArray tintTypedArray2 = new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, R$styleable.TextAppearance, i, 0));
        if (!z3 && tintTypedArray2.hasValue(R$styleable.TextAppearance_textAllCaps)) {
            z2 = tintTypedArray2.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (tintTypedArray2.hasValue(R$styleable.TextAppearance_textLocale)) {
            str2 = tintTypedArray2.getString(R$styleable.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && tintTypedArray2.hasValue(R$styleable.TextAppearance_fontVariationSettings)) {
            str = tintTypedArray2.getString(R$styleable.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && tintTypedArray2.hasValue(R$styleable.TextAppearance_android_textSize) && tintTypedArray2.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
        updateTypefaceAndStyle(context, tintTypedArray2);
        tintTypedArray2.mWrapped.recycle();
        if (!z3 && z) {
            this.mView.setAllCaps(z2);
        }
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            if (this.mFontWeight == -1) {
                this.mView.setTypeface(typeface, this.mStyle);
            } else {
                this.mView.setTypeface(typeface);
            }
        }
        if (str != null) {
            this.mView.setFontVariationSettings(str);
        }
        if (str2 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.mView.setTextLocales(LocaleList.forLanguageTags(str2));
            } else {
                this.mView.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
            }
        }
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        TypedArray obtainStyledAttributes2 = appCompatTextViewAutoSizeHelper.mContext.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i, 0);
        TextView textView2 = appCompatTextViewAutoSizeHelper.mTextView;
        ViewCompat.saveAttributeDataForStyleable(textView2, textView2.getContext(), R$styleable.AppCompatTextView, attributeSet, obtainStyledAttributes2, i, 0);
        if (obtainStyledAttributes2.hasValue(R$styleable.AppCompatTextView_autoSizeTextType)) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = obtainStyledAttributes2.getInt(R$styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes2.hasValue(R$styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes2.getDimension(R$styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes2.hasValue(R$styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes2.getDimension(R$styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes2.hasValue(R$styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes2.getDimension(R$styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes2.hasValue(R$styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId2 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes2.getResources().obtainTypedArray(resourceId2);
            int length = obtainTypedArray.length();
            int[] iArr = new int[length];
            if (length > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = obtainTypedArray.getDimensionPixelSize(i2, -1);
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = appCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArr);
                appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration();
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes2.recycle();
        if (!appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
        } else if (appCompatTextViewAutoSizeHelper.mAutoSizeTextType == 1) {
            if (!appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues) {
                DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(dimension2, dimension3, dimension);
            }
            appCompatTextViewAutoSizeHelper.setupAutoSizeText();
        }
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper2 = this.mAutoSizeTextHelper;
            if (appCompatTextViewAutoSizeHelper2.mAutoSizeTextType != 0) {
                int[] iArr2 = appCompatTextViewAutoSizeHelper2.mAutoSizeTextSizesInPx;
                if (iArr2.length > 0) {
                    if (((float) this.mView.getAutoSizeStepGranularity()) != -1.0f) {
                        this.mView.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.mAutoSizeTextHelper.mAutoSizeMinTextSizeInPx), Math.round(this.mAutoSizeTextHelper.mAutoSizeMaxTextSizeInPx), Math.round(this.mAutoSizeTextHelper.mAutoSizeStepGranularityInPx), 0);
                    } else {
                        this.mView.setAutoSizeTextTypeUniformWithPresetSizes(iArr2, 0);
                    }
                }
            }
        }
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView);
        int resourceId4 = obtainStyledAttributes3.getResourceId(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable drawable = resourceId4 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId4) : null;
        int resourceId5 = obtainStyledAttributes3.getResourceId(R$styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawable2 = resourceId5 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId5) : null;
        int resourceId6 = obtainStyledAttributes3.getResourceId(R$styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawable3 = resourceId6 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId6) : null;
        int resourceId7 = obtainStyledAttributes3.getResourceId(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawable4 = resourceId7 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId7) : null;
        int resourceId8 = obtainStyledAttributes3.getResourceId(R$styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawable5 = resourceId8 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId8) : null;
        int resourceId9 = obtainStyledAttributes3.getResourceId(R$styleable.AppCompatTextView_drawableEndCompat, -1);
        Drawable drawable6 = resourceId9 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId9) : null;
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            TextView textView3 = this.mView;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (!(drawable == null && drawable2 == null && drawable3 == null && drawable4 == null)) {
            Drawable[] compoundDrawablesRelative2 = this.mView.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
                TextView textView4 = this.mView;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView4.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            } else {
                TextView textView5 = this.mView;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
            }
        }
        if (obtainStyledAttributes3.hasValue(R$styleable.AppCompatTextView_drawableTint)) {
            int i3 = R$styleable.AppCompatTextView_drawableTint;
            if (!obtainStyledAttributes3.hasValue(i3) || (resourceId = obtainStyledAttributes3.getResourceId(i3, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes3.getColorStateList(i3);
            }
            TextView textView6 = this.mView;
            if (textView6 == null) {
                throw null;
            } else if (Build.VERSION.SDK_INT >= 24) {
                textView6.setCompoundDrawableTintList(colorStateList);
            } else if (textView6 instanceof TintableCompoundDrawablesView) {
                ((TintableCompoundDrawablesView) textView6).setSupportCompoundDrawablesTintList(colorStateList);
            }
        }
        if (obtainStyledAttributes3.hasValue(R$styleable.AppCompatTextView_drawableTintMode)) {
            PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes3.getInt(R$styleable.AppCompatTextView_drawableTintMode, -1), null);
            TextView textView7 = this.mView;
            if (textView7 == null) {
                throw null;
            } else if (Build.VERSION.SDK_INT >= 24) {
                textView7.setCompoundDrawableTintMode(parseTintMode);
            } else if (textView7 instanceof TintableCompoundDrawablesView) {
                ((TintableCompoundDrawablesView) textView7).setSupportCompoundDrawablesTintMode(parseTintMode);
            }
        }
        int dimensionPixelSize = obtainStyledAttributes3.getDimensionPixelSize(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int dimensionPixelSize2 = obtainStyledAttributes3.getDimensionPixelSize(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int dimensionPixelSize3 = obtainStyledAttributes3.getDimensionPixelSize(R$styleable.AppCompatTextView_lineHeight, -1);
        obtainStyledAttributes3.recycle();
        if (dimensionPixelSize != -1) {
            AppCompatDelegateImpl.ConfigurationImplApi17.setFirstBaselineToTopHeight(this.mView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            AppCompatDelegateImpl.ConfigurationImplApi17.setLastBaselineToBottomHeight(this.mView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            AppCompatDelegateImpl.ConfigurationImplApi17.setLineHeight(this.mView, dimensionPixelSize3);
        }
    }

    public void onSetTextAppearance(Context context, int i) {
        String string;
        TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(i, R$styleable.TextAppearance));
        if (tintTypedArray.hasValue(R$styleable.TextAppearance_textAllCaps)) {
            this.mView.setAllCaps(tintTypedArray.getBoolean(R$styleable.TextAppearance_textAllCaps, false));
        }
        if (tintTypedArray.hasValue(R$styleable.TextAppearance_android_textSize) && tintTypedArray.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
        updateTypefaceAndStyle(context, tintTypedArray);
        if (Build.VERSION.SDK_INT >= 26 && tintTypedArray.hasValue(R$styleable.TextAppearance_fontVariationSettings) && (string = tintTypedArray.getString(R$styleable.TextAppearance_fontVariationSettings)) != null) {
            this.mView.setFontVariationSettings(string);
        }
        tintTypedArray.mWrapped.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                    }
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = appCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArr2);
                if (!appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration()) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("None of the preset sizes is valid: ");
                    outline15.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(outline15.toString());
                }
            } else {
                appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues = false;
            }
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (!appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            return;
        }
        if (i == 0) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
            appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = new int[0];
            appCompatTextViewAutoSizeHelper.mNeedsAutoSizeText = false;
        } else if (i == 1) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("Unknown auto-size text type: ", i));
        }
    }

    public void setCompoundDrawableTintList(ColorStateList colorStateList) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = colorStateList != null;
        TintInfo tintInfo2 = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo2;
        this.mDrawableTopTint = tintInfo2;
        this.mDrawableRightTint = tintInfo2;
        this.mDrawableBottomTint = tintInfo2;
        this.mDrawableStartTint = tintInfo2;
        this.mDrawableEndTint = tintInfo2;
    }

    public void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = mode != null;
        TintInfo tintInfo2 = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo2;
        this.mDrawableTopTint = tintInfo2;
        this.mDrawableRightTint = tintInfo2;
        this.mDrawableBottomTint = tintInfo2;
        this.mDrawableStartTint = tintInfo2;
        this.mDrawableEndTint = tintInfo2;
    }

    public final void updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        int i;
        String string;
        this.mStyle = tintTypedArray.getInt(R$styleable.TextAppearance_android_textStyle, this.mStyle);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 28) {
            int i2 = tintTypedArray.getInt(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = i2;
            if (i2 != -1) {
                this.mStyle = (this.mStyle & 2) | 0;
            }
        }
        if (tintTypedArray.hasValue(R$styleable.TextAppearance_android_fontFamily) || tintTypedArray.hasValue(R$styleable.TextAppearance_fontFamily)) {
            this.mFontTypeface = null;
            if (tintTypedArray.hasValue(R$styleable.TextAppearance_fontFamily)) {
                i = R$styleable.TextAppearance_fontFamily;
            } else {
                i = R$styleable.TextAppearance_android_fontFamily;
            }
            final int i3 = this.mFontWeight;
            final int i4 = this.mStyle;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.mView);
                try {
                    Typeface font = tintTypedArray.getFont(i, this.mStyle, new ResourcesCompat$FontCallback() {
                        /* class androidx.appcompat.widget.AppCompatTextHelper.AnonymousClass1 */

                        @Override // androidx.core.content.res.ResourcesCompat$FontCallback
                        public void onFontRetrievalFailed(int i) {
                        }

                        @Override // androidx.core.content.res.ResourcesCompat$FontCallback
                        public void onFontRetrieved(Typeface typeface) {
                            int i;
                            if (Build.VERSION.SDK_INT >= 28 && (i = i3) != -1) {
                                typeface = Typeface.create(typeface, i, (i4 & 2) != 0);
                            }
                            AppCompatTextHelper appCompatTextHelper = AppCompatTextHelper.this;
                            WeakReference weakReference = weakReference;
                            if (appCompatTextHelper.mAsyncFontPending) {
                                appCompatTextHelper.mFontTypeface = typeface;
                                TextView textView = (TextView) weakReference.get();
                                if (textView != null) {
                                    textView.setTypeface(typeface, appCompatTextHelper.mStyle);
                                }
                            }
                        }
                    });
                    if (font != null) {
                        if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
                            this.mFontTypeface = font;
                        } else {
                            this.mFontTypeface = Typeface.create(Typeface.create(font, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                        }
                    }
                    this.mAsyncFontPending = this.mFontTypeface == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.mFontTypeface == null && (string = tintTypedArray.getString(i)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
                    this.mFontTypeface = Typeface.create(string, this.mStyle);
                    return;
                }
                Typeface create = Typeface.create(string, 0);
                int i5 = this.mFontWeight;
                if ((this.mStyle & 2) != 0) {
                    z = true;
                }
                this.mFontTypeface = Typeface.create(create, i5, z);
            }
        } else if (tintTypedArray.hasValue(R$styleable.TextAppearance_android_typeface)) {
            this.mAsyncFontPending = false;
            int i6 = tintTypedArray.getInt(R$styleable.TextAppearance_android_typeface, 1);
            if (i6 == 1) {
                this.mFontTypeface = Typeface.SANS_SERIF;
            } else if (i6 == 2) {
                this.mFontTypeface = Typeface.SERIF;
            } else if (i6 == 3) {
                this.mFontTypeface = Typeface.MONOSPACE;
            }
        }
    }
}
