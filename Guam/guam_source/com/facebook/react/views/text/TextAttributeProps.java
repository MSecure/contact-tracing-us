package com.facebook.react.views.text;

import android.os.Build;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class TextAttributeProps {
    public static final int DEFAULT_BREAK_STRATEGY = 1;
    public static final int DEFAULT_JUSTIFICATION_MODE = 0;
    public boolean mAllowFontScaling;
    public int mBackgroundColor;
    public int mColor;
    public String mFontFamily;
    public String mFontFeatureSettings;
    public int mFontSize;
    public float mFontSizeInput;
    public int mFontStyle;
    public int mFontWeight;
    public float mHeightOfTallestInlineImage;
    public boolean mIsBackgroundColorSet;
    public boolean mIsColorSet;
    public boolean mIsLineThroughTextDecorationSet;
    public boolean mIsUnderlineTextDecorationSet;
    public float mLetterSpacingInput;
    public float mLineHeight = Float.NaN;
    public float mLineHeightInput;
    public final ReactStylesDiffMap mProps;
    public int mTextShadowColor;
    public float mTextShadowOffsetDx;
    public float mTextShadowOffsetDy;
    public float mTextShadowRadius;
    public TextTransform mTextTransform;

    static {
        int i = Build.VERSION.SDK_INT;
    }

    public TextAttributeProps(ReactStylesDiffMap reactStylesDiffMap) {
        this.mIsColorSet = false;
        this.mAllowFontScaling = true;
        this.mIsBackgroundColorSet = false;
        int i = -1;
        this.mFontSize = -1;
        this.mFontSizeInput = -1.0f;
        this.mLineHeightInput = -1.0f;
        this.mLetterSpacingInput = Float.NaN;
        this.mTextTransform = TextTransform.UNSET;
        this.mTextShadowOffsetDx = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mTextShadowOffsetDy = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mTextShadowRadius = 1.0f;
        this.mTextShadowColor = 1426063360;
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        this.mFontStyle = -1;
        this.mFontWeight = -1;
        ReadableMap readableMap = null;
        this.mFontFamily = null;
        this.mFontFeatureSettings = null;
        this.mHeightOfTallestInlineImage = Float.NaN;
        this.mProps = reactStylesDiffMap;
        getIntProp("numberOfLines", -1);
        setLineHeight(getFloatProp("lineHeight", -1.0f));
        this.mLetterSpacingInput = getFloatProp("letterSpacing", Float.NaN);
        boolean booleanProp = getBooleanProp("allowFontScaling", true);
        if (booleanProp != this.mAllowFontScaling) {
            this.mAllowFontScaling = booleanProp;
            setFontSize(this.mFontSizeInput);
            setLineHeight(this.mLineHeightInput);
            this.mLetterSpacingInput = this.mLetterSpacingInput;
        }
        setFontSize(getFloatProp("fontSize", -1.0f));
        Integer valueOf = reactStylesDiffMap.mBackingMap.hasKey("color") ? Integer.valueOf(reactStylesDiffMap.getInt("color", 0)) : null;
        boolean z = valueOf != null;
        this.mIsColorSet = z;
        if (z) {
            this.mColor = valueOf.intValue();
        }
        Integer valueOf2 = reactStylesDiffMap.mBackingMap.hasKey("foregroundColor") ? Integer.valueOf(reactStylesDiffMap.getInt("foregroundColor", 0)) : null;
        boolean z2 = valueOf2 != null;
        this.mIsColorSet = z2;
        if (z2) {
            this.mColor = valueOf2.intValue();
        }
        Integer valueOf3 = reactStylesDiffMap.mBackingMap.hasKey("backgroundColor") ? Integer.valueOf(reactStylesDiffMap.getInt("backgroundColor", 0)) : null;
        boolean z3 = valueOf3 != null;
        this.mIsBackgroundColorSet = z3;
        if (z3) {
            this.mBackgroundColor = valueOf3.intValue();
        }
        this.mFontFamily = getStringProp("fontFamily");
        String stringProp = getStringProp("fontWeight");
        int charAt = (stringProp == null || stringProp.length() != 3 || !stringProp.endsWith("00") || stringProp.charAt(0) > '9' || stringProp.charAt(0) < '1') ? -1 : (stringProp.charAt(0) - '0') * 100;
        int i2 = (charAt >= 500 || "bold".equals(stringProp)) ? 1 : ("normal".equals(stringProp) || (charAt != -1 && charAt < 500)) ? 0 : -1;
        if (i2 != this.mFontWeight) {
            this.mFontWeight = i2;
        }
        String stringProp2 = getStringProp("fontStyle");
        if ("italic".equals(stringProp2)) {
            i = 2;
        } else if ("normal".equals(stringProp2)) {
            i = 0;
        }
        if (i != this.mFontStyle) {
            this.mFontStyle = i;
        }
        this.mFontFeatureSettings = ReactYogaConfigProvider.parseFontVariant(this.mProps.mBackingMap.hasKey("fontVariant") ? this.mProps.mBackingMap.getArray("fontVariant") : null);
        getBooleanProp("includeFontPadding", true);
        String stringProp3 = getStringProp("textDecorationLine");
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        if (stringProp3 != null) {
            String[] split = stringProp3.split("-");
            for (String str : split) {
                if ("underline".equals(str)) {
                    this.mIsUnderlineTextDecorationSet = true;
                } else if ("strikethrough".equals(str)) {
                    this.mIsLineThroughTextDecorationSet = true;
                }
            }
        }
        readableMap = reactStylesDiffMap.mBackingMap.hasKey("textShadowOffset") ? reactStylesDiffMap.mBackingMap.getMap("textShadowOffset") : readableMap;
        this.mTextShadowOffsetDx = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mTextShadowOffsetDy = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        if (readableMap != null) {
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH) && !readableMap.isNull(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH)) {
                this.mTextShadowOffsetDx = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT) && !readableMap.isNull(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)) {
                this.mTextShadowOffsetDy = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT));
            }
        }
        float intProp = (float) getIntProp("textShadowRadius", 1);
        if (intProp != this.mTextShadowRadius) {
            this.mTextShadowRadius = intProp;
        }
        int intProp2 = getIntProp("textShadowColor", 1426063360);
        if (intProp2 != this.mTextShadowColor) {
            this.mTextShadowColor = intProp2;
        }
        String stringProp4 = getStringProp("textTransform");
        if (stringProp4 == null || "none".equals(stringProp4)) {
            this.mTextTransform = TextTransform.NONE;
        } else if ("uppercase".equals(stringProp4)) {
            this.mTextTransform = TextTransform.UPPERCASE;
        } else if ("lowercase".equals(stringProp4)) {
            this.mTextTransform = TextTransform.LOWERCASE;
        } else if ("capitalize".equals(stringProp4)) {
            this.mTextTransform = TextTransform.CAPITALIZE;
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("Invalid textTransform: ", stringProp4));
        }
    }

    public static int getJustificationMode(ReactStylesDiffMap reactStylesDiffMap) {
        if (!"justify".equals(reactStylesDiffMap.mBackingMap.hasKey("textAlign") ? reactStylesDiffMap.mBackingMap.getString("textAlign") : null) || Build.VERSION.SDK_INT < 26) {
            return DEFAULT_JUSTIFICATION_MODE;
        }
        return 1;
    }

    public static int getTextAlignment(ReactStylesDiffMap reactStylesDiffMap) {
        String string = reactStylesDiffMap.mBackingMap.hasKey("textAlign") ? reactStylesDiffMap.mBackingMap.getString("textAlign") : null;
        if ("justify".equals(string)) {
            return 3;
        }
        if (string == null || "auto".equals(string)) {
            return 0;
        }
        if (RNGestureHandlerModule.KEY_HIT_SLOP_LEFT.equals(string)) {
            return 3;
        }
        if (RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT.equals(string)) {
            return 5;
        }
        if ("center".equals(string)) {
            return 1;
        }
        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("Invalid textAlign: ", string));
    }

    public static int getTextBreakStrategy(String str) {
        int i = DEFAULT_BREAK_STRATEGY;
        if (str == null) {
            return i;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1924829944) {
            if (hashCode == -902286926 && str.equals("simple")) {
                c = 0;
            }
        } else if (str.equals("balanced")) {
            c = 1;
        }
        if (c == 0) {
            return 0;
        }
        if (c != 1) {
            return 1;
        }
        return 2;
    }

    public final boolean getBooleanProp(String str, boolean z) {
        if (!this.mProps.mBackingMap.hasKey(str)) {
            return z;
        }
        ReactStylesDiffMap reactStylesDiffMap = this.mProps;
        return reactStylesDiffMap.mBackingMap.isNull(str) ? z : reactStylesDiffMap.mBackingMap.getBoolean(str);
    }

    public float getEffectiveLineHeight() {
        return !Float.isNaN(this.mLineHeight) && !Float.isNaN(this.mHeightOfTallestInlineImage) && (this.mHeightOfTallestInlineImage > this.mLineHeight ? 1 : (this.mHeightOfTallestInlineImage == this.mLineHeight ? 0 : -1)) > 0 ? this.mHeightOfTallestInlineImage : this.mLineHeight;
    }

    public final float getFloatProp(String str, float f) {
        if (!this.mProps.mBackingMap.hasKey(str)) {
            return f;
        }
        ReactStylesDiffMap reactStylesDiffMap = this.mProps;
        return reactStylesDiffMap.mBackingMap.isNull(str) ? f : (float) reactStylesDiffMap.mBackingMap.getDouble(str);
    }

    public final int getIntProp(String str, int i) {
        return this.mProps.mBackingMap.hasKey(str) ? this.mProps.getInt(str, i) : i;
    }

    public float getLetterSpacing() {
        float f;
        if (this.mAllowFontScaling) {
            f = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromSP(this.mLetterSpacingInput);
        } else {
            f = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(this.mLetterSpacingInput);
        }
        int i = this.mFontSize;
        if (i > 0) {
            return f / ((float) i);
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("FontSize should be a positive value. Current value: ");
        outline15.append(this.mFontSize);
        throw new IllegalArgumentException(outline15.toString());
    }

    public final String getStringProp(String str) {
        if (this.mProps.mBackingMap.hasKey(str)) {
            return this.mProps.mBackingMap.getString(str);
        }
        return null;
    }

    public void setFontSize(float f) {
        double d;
        this.mFontSizeInput = f;
        if (f != -1.0f) {
            if (this.mAllowFontScaling) {
                d = Math.ceil((double) AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromSP(f));
            } else {
                d = Math.ceil((double) AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f));
            }
            f = (float) d;
        }
        this.mFontSize = (int) f;
    }

    public void setLineHeight(float f) {
        float f2;
        this.mLineHeightInput = f;
        if (f == -1.0f) {
            this.mLineHeight = Float.NaN;
            return;
        }
        if (this.mAllowFontScaling) {
            f2 = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromSP(f);
        } else {
            f2 = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f);
        }
        this.mLineHeight = f2;
    }
}
