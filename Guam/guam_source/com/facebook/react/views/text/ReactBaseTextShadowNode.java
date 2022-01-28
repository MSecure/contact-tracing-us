package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageShadowNode;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageSpan;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(23)
public abstract class ReactBaseTextShadowNode extends LayoutShadowNode {
    public boolean mAdjustsFontSizeToFit;
    public int mBackgroundColor;
    public int mColor;
    public boolean mContainsImages;
    public String mFontFamily;
    public String mFontFeatureSettings;
    public int mFontStyle;
    public int mFontWeight;
    public int mHyphenationFrequency;
    public boolean mIncludeFontPadding;
    public Map<Integer, ReactShadowNode> mInlineViews;
    public boolean mIsBackgroundColorSet;
    public boolean mIsColorSet;
    public boolean mIsLineThroughTextDecorationSet;
    public boolean mIsUnderlineTextDecorationSet;
    public int mJustificationMode;
    public float mMinimumFontScale;
    public int mNumberOfLines;
    public ReactTextViewManagerCallback mReactTextViewManagerCallback;
    public int mTextAlign;
    public TextAttributes mTextAttributes;
    public int mTextBreakStrategy;
    public int mTextShadowColor;
    public float mTextShadowOffsetDx;
    public float mTextShadowOffsetDy;
    public float mTextShadowRadius;

    public static class SetSpanOperation {
        public int end;
        public int start;
        public ReactSpan what;

        public SetSpanOperation(int i, int i2, ReactSpan reactSpan) {
            this.start = i;
            this.end = i2;
            this.what = reactSpan;
        }
    }

    public ReactBaseTextShadowNode() {
        this(null);
    }

    public static void buildSpannedFromShadowNode(ReactBaseTextShadowNode reactBaseTextShadowNode, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list, TextAttributes textAttributes, boolean z, Map<Integer, ReactShadowNode> map, int i) {
        TextAttributes textAttributes2;
        TextAttributes textAttributes3;
        int i2;
        float f;
        float f2;
        ReactBaseTextShadowNode reactBaseTextShadowNode2 = reactBaseTextShadowNode;
        if (textAttributes != null) {
            TextAttributes textAttributes4 = reactBaseTextShadowNode2.mTextAttributes;
            textAttributes2 = new TextAttributes();
            textAttributes2.mAllowFontScaling = textAttributes.mAllowFontScaling;
            textAttributes2.mFontSize = !Float.isNaN(textAttributes4.mFontSize) ? textAttributes4.mFontSize : textAttributes.mFontSize;
            textAttributes2.mLineHeight = !Float.isNaN(textAttributes4.mLineHeight) ? textAttributes4.mLineHeight : textAttributes.mLineHeight;
            textAttributes2.mLetterSpacing = !Float.isNaN(textAttributes4.mLetterSpacing) ? textAttributes4.mLetterSpacing : textAttributes.mLetterSpacing;
            textAttributes2.mMaxFontSizeMultiplier = !Float.isNaN(textAttributes4.mMaxFontSizeMultiplier) ? textAttributes4.mMaxFontSizeMultiplier : textAttributes.mMaxFontSizeMultiplier;
            textAttributes2.mHeightOfTallestInlineViewOrImage = !Float.isNaN(textAttributes4.mHeightOfTallestInlineViewOrImage) ? textAttributes4.mHeightOfTallestInlineViewOrImage : textAttributes.mHeightOfTallestInlineViewOrImage;
            TextTransform textTransform = textAttributes4.mTextTransform;
            if (textTransform == TextTransform.UNSET) {
                textTransform = textAttributes.mTextTransform;
            }
            textAttributes2.mTextTransform = textTransform;
        } else {
            textAttributes2 = reactBaseTextShadowNode2.mTextAttributes;
        }
        TextAttributes textAttributes5 = textAttributes2;
        int childCount = reactBaseTextShadowNode.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            ReactShadowNodeImpl childAt = reactBaseTextShadowNode2.getChildAt(i3);
            if (childAt instanceof ReactRawTextShadowNode) {
                spannableStringBuilder.append((CharSequence) TextTransform.apply(((ReactRawTextShadowNode) childAt).mText, textAttributes5.mTextTransform));
            } else if (childAt instanceof ReactBaseTextShadowNode) {
                buildSpannedFromShadowNode((ReactBaseTextShadowNode) childAt, spannableStringBuilder, list, textAttributes5, z, map, spannableStringBuilder.length());
            } else {
                if (childAt instanceof ReactTextInlineImageShadowNode) {
                    spannableStringBuilder.append("0");
                    FrescoBasedReactTextInlineImageShadowNode frescoBasedReactTextInlineImageShadowNode = (FrescoBasedReactTextInlineImageShadowNode) ((ReactTextInlineImageShadowNode) childAt);
                    i2 = childCount;
                    textAttributes3 = textAttributes5;
                    list.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new FrescoBasedReactTextInlineImageSpan(frescoBasedReactTextInlineImageShadowNode.getThemedContext().getResources(), (int) Math.ceil((double) frescoBasedReactTextInlineImageShadowNode.mHeight), (int) Math.ceil((double) frescoBasedReactTextInlineImageShadowNode.mWidth), frescoBasedReactTextInlineImageShadowNode.mTintColor, frescoBasedReactTextInlineImageShadowNode.mUri, frescoBasedReactTextInlineImageShadowNode.mHeaders, frescoBasedReactTextInlineImageShadowNode.mDraweeControllerBuilder, frescoBasedReactTextInlineImageShadowNode.mCallerContext, frescoBasedReactTextInlineImageShadowNode.mResizeMode)));
                } else {
                    textAttributes3 = textAttributes5;
                    i2 = childCount;
                    if (z) {
                        int reactTag = childAt.getReactTag();
                        YogaValue styleWidth = childAt.getStyleWidth();
                        YogaValue styleHeight = childAt.getStyleHeight();
                        YogaUnit yogaUnit = styleWidth.unit;
                        YogaUnit yogaUnit2 = YogaUnit.POINT;
                        if (yogaUnit == yogaUnit2 && styleHeight.unit == yogaUnit2) {
                            f2 = styleWidth.value;
                            f = styleHeight.value;
                        } else {
                            childAt.calculateLayout();
                            f2 = childAt.getLayoutWidth();
                            f = childAt.getLayoutHeight();
                        }
                        spannableStringBuilder.append("0");
                        list.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new TextInlineViewPlaceholderSpan(reactTag, (int) f2, (int) f)));
                        map.put(Integer.valueOf(reactTag), childAt);
                    } else {
                        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unexpected view type nested under a <Text> or <TextInput> node: ");
                        outline15.append(childAt.getClass());
                        throw new IllegalViewOperationException(outline15.toString());
                    }
                }
                childAt.markUpdateSeen();
                i3++;
                reactBaseTextShadowNode2 = reactBaseTextShadowNode;
                childCount = i2;
                textAttributes5 = textAttributes3;
            }
            textAttributes3 = textAttributes5;
            i2 = childCount;
            childAt.markUpdateSeen();
            i3++;
            reactBaseTextShadowNode2 = reactBaseTextShadowNode;
            childCount = i2;
            textAttributes5 = textAttributes3;
        }
        int length = spannableStringBuilder.length();
        if (length >= i) {
            if (reactBaseTextShadowNode.mIsColorSet) {
                list.add(new SetSpanOperation(i, length, new ReactForegroundColorSpan(reactBaseTextShadowNode.mColor)));
            }
            if (reactBaseTextShadowNode.mIsBackgroundColorSet) {
                list.add(new SetSpanOperation(i, length, new ReactBackgroundColorSpan(reactBaseTextShadowNode.mBackgroundColor)));
            }
            float effectiveLetterSpacing = textAttributes5.getEffectiveLetterSpacing();
            if (!Float.isNaN(effectiveLetterSpacing) && (textAttributes == null || textAttributes.getEffectiveLetterSpacing() != effectiveLetterSpacing)) {
                list.add(new SetSpanOperation(i, length, new CustomLetterSpacingSpan(effectiveLetterSpacing)));
            }
            int effectiveFontSize = textAttributes5.getEffectiveFontSize();
            if (textAttributes == null || textAttributes.getEffectiveFontSize() != effectiveFontSize) {
                list.add(new SetSpanOperation(i, length, new ReactAbsoluteSizeSpan(effectiveFontSize)));
            }
            if (!(reactBaseTextShadowNode.mFontStyle == -1 && reactBaseTextShadowNode.mFontWeight == -1 && reactBaseTextShadowNode.mFontFamily == null)) {
                list.add(new SetSpanOperation(i, length, new CustomStyleSpan(reactBaseTextShadowNode.mFontStyle, reactBaseTextShadowNode.mFontWeight, reactBaseTextShadowNode.mFontFeatureSettings, reactBaseTextShadowNode.mFontFamily, reactBaseTextShadowNode.getThemedContext().getAssets())));
            }
            if (reactBaseTextShadowNode.mIsUnderlineTextDecorationSet) {
                list.add(new SetSpanOperation(i, length, new ReactUnderlineSpan()));
            }
            if (reactBaseTextShadowNode.mIsLineThroughTextDecorationSet) {
                list.add(new SetSpanOperation(i, length, new ReactStrikethroughSpan()));
            }
            if (!((reactBaseTextShadowNode.mTextShadowOffsetDx == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && reactBaseTextShadowNode.mTextShadowOffsetDy == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && reactBaseTextShadowNode.mTextShadowRadius == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) || Color.alpha(reactBaseTextShadowNode.mTextShadowColor) == 0)) {
                list.add(new SetSpanOperation(i, length, new ShadowStyleSpan(reactBaseTextShadowNode.mTextShadowOffsetDx, reactBaseTextShadowNode.mTextShadowOffsetDy, reactBaseTextShadowNode.mTextShadowRadius, reactBaseTextShadowNode.mTextShadowColor)));
            }
            float effectiveLineHeight = textAttributes5.getEffectiveLineHeight();
            if (!Float.isNaN(effectiveLineHeight) && (textAttributes == null || textAttributes.getEffectiveLineHeight() != effectiveLineHeight)) {
                list.add(new SetSpanOperation(i, length, new CustomLineHeightSpan(effectiveLineHeight)));
            }
            list.add(new SetSpanOperation(i, length, new ReactTagSpan(reactBaseTextShadowNode.mReactTag)));
        }
    }

    @ReactProp(name = "adjustsFontSizeToFit")
    public void setAdjustFontSizeToFit(boolean z) {
        if (z != this.mAdjustsFontSizeToFit) {
            this.mAdjustsFontSizeToFit = z;
            markUpdated();
        }
    }

    @ReactProp(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(boolean z) {
        TextAttributes textAttributes = this.mTextAttributes;
        if (z != textAttributes.mAllowFontScaling) {
            textAttributes.mAllowFontScaling = z;
            markUpdated();
        }
    }

    @ReactProp(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(Integer num) {
        if (isVirtual()) {
            boolean z = num != null;
            this.mIsBackgroundColorSet = z;
            if (z) {
                this.mBackgroundColor = num.intValue();
            }
            markUpdated();
        }
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(Integer num) {
        boolean z = num != null;
        this.mIsColorSet = z;
        if (z) {
            this.mColor = num.intValue();
        }
        markUpdated();
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(String str) {
        this.mFontFamily = str;
        markUpdated();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "fontSize")
    public void setFontSize(float f) {
        this.mTextAttributes.mFontSize = f;
        markUpdated();
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(String str) {
        int parseFontStyle = ReactYogaConfigProvider.parseFontStyle(str);
        if (parseFontStyle != this.mFontStyle) {
            this.mFontStyle = parseFontStyle;
            markUpdated();
        }
    }

    @ReactProp(name = "fontVariant")
    public void setFontVariant(ReadableArray readableArray) {
        String parseFontVariant = ReactYogaConfigProvider.parseFontVariant(readableArray);
        if (!TextUtils.equals(parseFontVariant, this.mFontFeatureSettings)) {
            this.mFontFeatureSettings = parseFontVariant;
            markUpdated();
        }
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(String str) {
        int parseFontWeight = ReactYogaConfigProvider.parseFontWeight(str);
        if (parseFontWeight != this.mFontWeight) {
            this.mFontWeight = parseFontWeight;
            markUpdated();
        }
    }

    @ReactProp(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(boolean z) {
        this.mIncludeFontPadding = z;
    }

    @ReactProp(defaultFloat = Float.NaN, name = "letterSpacing")
    public void setLetterSpacing(float f) {
        this.mTextAttributes.mLetterSpacing = f;
        markUpdated();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "lineHeight")
    public void setLineHeight(float f) {
        this.mTextAttributes.mLineHeight = f;
        markUpdated();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(float f) {
        TextAttributes textAttributes = this.mTextAttributes;
        if (f != textAttributes.mMaxFontSizeMultiplier) {
            textAttributes.setMaxFontSizeMultiplier(f);
            markUpdated();
        }
    }

    @ReactProp(name = "minimumFontScale")
    public void setMinimumFontScale(float f) {
        if (f != this.mMinimumFontScale) {
            this.mMinimumFontScale = f;
            markUpdated();
        }
    }

    @ReactProp(defaultInt = -1, name = "numberOfLines")
    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = -1;
        }
        this.mNumberOfLines = i;
        markUpdated();
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mJustificationMode = 1;
            }
            this.mTextAlign = 3;
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mJustificationMode = 0;
            }
            if (str == null || "auto".equals(str)) {
                this.mTextAlign = 0;
            } else if (RNGestureHandlerModule.KEY_HIT_SLOP_LEFT.equals(str)) {
                this.mTextAlign = 3;
            } else if (RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT.equals(str)) {
                this.mTextAlign = 5;
            } else if ("center".equals(str)) {
                this.mTextAlign = 1;
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("Invalid textAlign: ", str));
            }
        }
        markUpdated();
    }

    @ReactProp(name = "textBreakStrategy")
    public void setTextBreakStrategy(String str) {
        if (str == null || "highQuality".equals(str)) {
            this.mTextBreakStrategy = 1;
        } else if ("simple".equals(str)) {
            this.mTextBreakStrategy = 0;
        } else if ("balanced".equals(str)) {
            this.mTextBreakStrategy = 2;
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("Invalid textBreakStrategy: ", str));
        }
        markUpdated();
    }

    @ReactProp(name = "textDecorationLine")
    public void setTextDecorationLine(String str) {
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        if (str != null) {
            String[] split = str.split(" ");
            for (String str2 : split) {
                if ("underline".equals(str2)) {
                    this.mIsUnderlineTextDecorationSet = true;
                } else if ("line-through".equals(str2)) {
                    this.mIsLineThroughTextDecorationSet = true;
                }
            }
        }
        markUpdated();
    }

    @ReactProp(customType = "Color", defaultInt = 1426063360, name = "textShadowColor")
    public void setTextShadowColor(int i) {
        if (i != this.mTextShadowColor) {
            this.mTextShadowColor = i;
            markUpdated();
        }
    }

    @ReactProp(name = "textShadowOffset")
    public void setTextShadowOffset(ReadableMap readableMap) {
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
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "textShadowRadius")
    public void setTextShadowRadius(float f) {
        if (f != this.mTextShadowRadius) {
            this.mTextShadowRadius = f;
            markUpdated();
        }
    }

    @ReactProp(name = "textTransform")
    public void setTextTransform(String str) {
        if (str == null) {
            this.mTextAttributes.mTextTransform = TextTransform.UNSET;
        } else if ("none".equals(str)) {
            this.mTextAttributes.mTextTransform = TextTransform.NONE;
        } else if ("uppercase".equals(str)) {
            this.mTextAttributes.mTextTransform = TextTransform.UPPERCASE;
        } else if ("lowercase".equals(str)) {
            this.mTextAttributes.mTextTransform = TextTransform.LOWERCASE;
        } else if ("capitalize".equals(str)) {
            this.mTextAttributes.mTextTransform = TextTransform.CAPITALIZE;
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("Invalid textTransform: ", str));
        }
        markUpdated();
    }

    public Spannable spannedFromShadowNode(ReactBaseTextShadowNode reactBaseTextShadowNode, String str, boolean z, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        int i;
        int i2 = 0;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(!z || nativeViewHierarchyOptimizer != null, "nativeViewHierarchyOptimizer is required when inline views are supported");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = z ? new HashMap() : null;
        if (str != null) {
            spannableStringBuilder.append((CharSequence) TextTransform.apply(str, reactBaseTextShadowNode.mTextAttributes.mTextTransform));
        }
        buildSpannedFromShadowNode(reactBaseTextShadowNode, spannableStringBuilder, arrayList, null, z, hashMap, 0);
        reactBaseTextShadowNode.mContainsImages = false;
        reactBaseTextShadowNode.mInlineViews = hashMap;
        float f = Float.NaN;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SetSpanOperation setSpanOperation = (SetSpanOperation) it.next();
            ReactSpan reactSpan = setSpanOperation.what;
            boolean z2 = reactSpan instanceof TextInlineImageSpan;
            if (z2 || (reactSpan instanceof TextInlineViewPlaceholderSpan)) {
                if (z2) {
                    i = ((FrescoBasedReactTextInlineImageSpan) ((TextInlineImageSpan) setSpanOperation.what)).mHeight;
                    reactBaseTextShadowNode.mContainsImages = true;
                } else {
                    TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan = (TextInlineViewPlaceholderSpan) setSpanOperation.what;
                    int i3 = textInlineViewPlaceholderSpan.mHeight;
                    ReactShadowNode reactShadowNode = hashMap.get(Integer.valueOf(textInlineViewPlaceholderSpan.mReactTag));
                    if (nativeViewHierarchyOptimizer != null) {
                        if (reactShadowNode.isLayoutOnly()) {
                            nativeViewHierarchyOptimizer.transitionLayoutOnlyViewToNativeView(reactShadowNode, null);
                        }
                        reactShadowNode.setLayoutParent(reactBaseTextShadowNode);
                        i = i3;
                    } else {
                        throw null;
                    }
                }
                if (Float.isNaN(f) || ((float) i) > f) {
                    f = (float) i;
                }
            }
            spannableStringBuilder.setSpan(setSpanOperation.what, setSpanOperation.start, setSpanOperation.end, ((setSpanOperation.start == 0 ? 18 : 34) & -16711681) | ((i2 << 16) & 16711680));
            i2++;
        }
        reactBaseTextShadowNode.mTextAttributes.mHeightOfTallestInlineViewOrImage = f;
        ReactTextViewManagerCallback reactTextViewManagerCallback = this.mReactTextViewManagerCallback;
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    public ReactBaseTextShadowNode(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        this.mIsColorSet = false;
        this.mIsBackgroundColorSet = false;
        this.mNumberOfLines = -1;
        this.mTextAlign = 0;
        int i = Build.VERSION.SDK_INT;
        this.mTextBreakStrategy = 1;
        this.mHyphenationFrequency = 0;
        this.mJustificationMode = 0;
        this.mTextShadowOffsetDx = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mTextShadowOffsetDy = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mTextShadowRadius = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mTextShadowColor = 1426063360;
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        this.mIncludeFontPadding = true;
        this.mAdjustsFontSizeToFit = false;
        this.mMinimumFontScale = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mFontStyle = -1;
        this.mFontWeight = -1;
        this.mFontFamily = null;
        this.mFontFeatureSettings = null;
        this.mContainsImages = false;
        this.mTextAttributes = new TextAttributes();
        this.mReactTextViewManagerCallback = reactTextViewManagerCallback;
    }
}
