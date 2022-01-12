package com.facebook.react.views.text;

import android.content.Context;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.IViewManagerWithChildren;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.yoga.YogaMeasureMode;
import java.util.Map;

@ReactModule(name = ReactTextViewManager.REACT_CLASS)
public class ReactTextViewManager extends ReactTextAnchorViewManager<ReactTextView, ReactTextShadowNode> implements IViewManagerWithChildren {
    public static final String REACT_CLASS = "RCTText";
    public ReactTextViewManagerCallback mReactTextViewManagerCallback;

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("topTextLayout", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onTextLayout"), "topInlineViewLayout", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onInlineViewLayout"));
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<ReactTextShadowNode> getShadowNodeClass() {
        return ReactTextShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, int[] iArr) {
        Layout layout;
        int i;
        Spannable spannable;
        boolean z;
        int i2;
        int i3;
        float f3;
        ReactTextViewManagerCallback reactTextViewManagerCallback = this.mReactTextViewManagerCallback;
        TextPaint textPaint = TextLayoutManager.sTextPaintInstance;
        Spannable orCreateSpannableForText = TextLayoutManager.getOrCreateSpannableForText(context, readableMap, reactTextViewManagerCallback);
        int textBreakStrategy = TextAttributeProps.getTextBreakStrategy(readableMap2.getString("textBreakStrategy"));
        BoringLayout.Metrics isBoring = BoringLayout.isBoring(orCreateSpannableForText, textPaint);
        float desiredWidth = isBoring == null ? Layout.getDesiredWidth(orCreateSpannableForText, textPaint) : Float.NaN;
        int i4 = 0;
        boolean z2 = true;
        boolean z3 = yogaMeasureMode == YogaMeasureMode.UNDEFINED || f < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        int length = orCreateSpannableForText.length();
        if (isBoring == null && (z3 || (!ReactYogaConfigProvider.isUndefined(desiredWidth) && desiredWidth <= f))) {
            layout = StaticLayout.Builder.obtain(orCreateSpannableForText, 0, length, textPaint, (int) Math.ceil((double) desiredWidth)).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f).setIncludePad(true).setBreakStrategy(textBreakStrategy).setHyphenationFrequency(1).build();
        } else if (isBoring == null || (!z3 && ((float) isBoring.width) > f)) {
            layout = StaticLayout.Builder.obtain(orCreateSpannableForText, 0, length, textPaint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f).setIncludePad(true).setBreakStrategy(textBreakStrategy).setHyphenationFrequency(1).build();
        } else {
            layout = BoringLayout.make(orCreateSpannableForText, textPaint, isBoring.width, Layout.Alignment.ALIGN_NORMAL, 1.0f, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, isBoring, true);
        }
        int i5 = -1;
        int i6 = readableMap2.hasKey("maximumNumberOfLines") ? readableMap2.getInt("maximumNumberOfLines") : -1;
        int width = layout.getWidth();
        if (i6 == -1 || i6 == 0 || i6 >= layout.getLineCount()) {
            i = layout.getHeight();
        } else {
            i = layout.getLineBottom(i6 - 1);
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int nextSpanTransition = orCreateSpannableForText.nextSpanTransition(i7, length, TextInlineViewPlaceholderSpan.class);
            TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr = (TextInlineViewPlaceholderSpan[]) orCreateSpannableForText.getSpans(i7, nextSpanTransition, TextInlineViewPlaceholderSpan.class);
            int length2 = textInlineViewPlaceholderSpanArr.length;
            int i9 = i4;
            while (i9 < length2) {
                TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan = textInlineViewPlaceholderSpanArr[i9];
                int spanStart = orCreateSpannableForText.getSpanStart(textInlineViewPlaceholderSpan);
                int lineForOffset = layout.getLineForOffset(spanStart);
                if (layout.getEllipsisCount(lineForOffset) > 0 ? z2 : false) {
                    if (spanStart >= layout.getEllipsisStart(lineForOffset) + layout.getLineStart(lineForOffset) && spanStart < layout.getLineEnd(lineForOffset)) {
                        spannable = orCreateSpannableForText;
                        z = true;
                        i9++;
                        z2 = z;
                        i5 = -1;
                        i4 = 0;
                        orCreateSpannableForText = spannable;
                    }
                }
                int i10 = textInlineViewPlaceholderSpan.mWidth;
                int i11 = textInlineViewPlaceholderSpan.mHeight;
                boolean isRtlCharAt = layout.isRtlCharAt(spanStart);
                spannable = orCreateSpannableForText;
                boolean z4 = layout.getParagraphDirection(lineForOffset) == i5;
                if (spanStart != length - 1) {
                    if (z4 == isRtlCharAt) {
                        f3 = layout.getPrimaryHorizontal(spanStart);
                    } else {
                        f3 = layout.getSecondaryHorizontal(spanStart);
                    }
                    int i12 = (int) f3;
                    if (z4) {
                        i12 = width - (((int) layout.getLineRight(lineForOffset)) - i12);
                    }
                    if (isRtlCharAt) {
                        i3 = i12;
                    } else {
                        i2 = i12;
                        int i13 = i8 * 2;
                        iArr[i13] = (int) AppCompatDelegateImpl.ConfigurationImplApi17.toSPFromPixel((float) (layout.getLineBaseline(lineForOffset) - i11));
                        z = true;
                        iArr[i13 + 1] = (int) AppCompatDelegateImpl.ConfigurationImplApi17.toSPFromPixel((float) i2);
                        i8++;
                        i9++;
                        z2 = z;
                        i5 = -1;
                        i4 = 0;
                        orCreateSpannableForText = spannable;
                    }
                } else if (z4) {
                    i2 = width - ((int) layout.getLineWidth(lineForOffset));
                    int i132 = i8 * 2;
                    iArr[i132] = (int) AppCompatDelegateImpl.ConfigurationImplApi17.toSPFromPixel((float) (layout.getLineBaseline(lineForOffset) - i11));
                    z = true;
                    iArr[i132 + 1] = (int) AppCompatDelegateImpl.ConfigurationImplApi17.toSPFromPixel((float) i2);
                    i8++;
                    i9++;
                    z2 = z;
                    i5 = -1;
                    i4 = 0;
                    orCreateSpannableForText = spannable;
                } else {
                    i3 = (int) layout.getLineRight(lineForOffset);
                }
                i2 = i3 - i10;
                int i1322 = i8 * 2;
                iArr[i1322] = (int) AppCompatDelegateImpl.ConfigurationImplApi17.toSPFromPixel((float) (layout.getLineBaseline(lineForOffset) - i11));
                z = true;
                iArr[i1322 + 1] = (int) AppCompatDelegateImpl.ConfigurationImplApi17.toSPFromPixel((float) i2);
                i8++;
                i9++;
                z2 = z;
                i5 = -1;
                i4 = 0;
                orCreateSpannableForText = spannable;
            }
            i7 = nextSpanTransition;
        }
        return ReactYogaConfigProvider.make(AppCompatDelegateImpl.ConfigurationImplApi17.toSPFromPixel((float) width), AppCompatDelegateImpl.ConfigurationImplApi17.toSPFromPixel((float) i));
    }

    @Override // com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactTextShadowNode createShadowNodeInstance() {
        return new ReactTextShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactTextView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactTextView(themedReactContext);
    }

    public void onAfterUpdateTransaction(ReactTextView reactTextView) {
        super.onAfterUpdateTransaction((View) reactTextView);
        reactTextView.setEllipsize((reactTextView.mNumberOfLines == Integer.MAX_VALUE || reactTextView.mAdjustsFontSizeToFit) ? null : reactTextView.mEllipsizeLocation);
    }

    public void setPadding(ReactTextView reactTextView, int i, int i2, int i3, int i4) {
        reactTextView.setPadding(i, i2, i3, i4);
    }

    public void updateExtraData(ReactTextView reactTextView, Object obj) {
        ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
        if (reactTextUpdate.mContainsImages) {
            TextInlineImageSpan.possiblyUpdateInlineImageSpans(reactTextUpdate.mText, reactTextView);
        }
        reactTextView.setText(reactTextUpdate);
    }

    public Object updateState(ReactTextView reactTextView, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        ReadableNativeMap state = stateWrapper.getState();
        ReadableNativeMap map = state.getMap("attributedString");
        ReadableNativeMap map2 = state.getMap("paragraphAttributes");
        Spannable orCreateSpannableForText = TextLayoutManager.getOrCreateSpannableForText(reactTextView.getContext(), map, this.mReactTextViewManagerCallback);
        reactTextView.setSpanned(orCreateSpannableForText);
        return new ReactTextUpdate(orCreateSpannableForText, state.hasKey("mostRecentEventCount") ? state.getInt("mostRecentEventCount") : -1, false, TextAttributeProps.getTextAlignment(reactStylesDiffMap), TextAttributeProps.getTextBreakStrategy(map2.getString("textBreakStrategy")), TextAttributeProps.getJustificationMode(reactStylesDiffMap));
    }

    public ReactTextShadowNode createShadowNodeInstance(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return new ReactTextShadowNode(reactTextViewManagerCallback);
    }
}
