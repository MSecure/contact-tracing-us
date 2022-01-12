package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintContextWrapper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageSpan;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ReactTextView extends AppCompatTextView implements ReactCompoundView {
    public static final ViewGroup.LayoutParams EMPTY_LAYOUT_PARAMS = new ViewGroup.LayoutParams(0, 0);
    public boolean mAdjustsFontSizeToFit = false;
    public boolean mContainsImages;
    public int mDefaultGravityHorizontal = (getGravity() & 8388615);
    public int mDefaultGravityVertical = (getGravity() & 112);
    public TextUtils.TruncateAt mEllipsizeLocation = TextUtils.TruncateAt.END;
    public int mLinkifyMaskType = 0;
    public boolean mNotifyOnInlineViewLayout;
    public int mNumberOfLines = Integer.MAX_VALUE;
    public ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
    public Spannable mSpanned;
    public int mTextAlign = 0;

    public ReactTextView(Context context) {
        super(context, null);
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        if (context instanceof TintContextWrapper) {
            context = ((TintContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    public static WritableMap inlineViewJson(int i, int i2, int i3, int i4, int i5, int i6) {
        WritableMap createMap = Arguments.createMap();
        if (i == 8) {
            createMap.putString("visibility", "gone");
            createMap.putInt("index", i2);
        } else if (i == 0) {
            createMap.putString("visibility", "visible");
            createMap.putInt("index", i2);
            createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) i3));
            createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_TOP, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) i4));
            createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) i5));
            createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) i6));
        } else {
            createMap.putString("visibility", "unknown");
            createMap.putInt("index", i2);
        }
        return createMap;
    }

    public Spannable getSpanned() {
        return this.mSpanned;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDrawable == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onAttach();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onDetach();
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onAttach();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
        if (r15 < (r4.getEllipsisStart(r14) + r4.getLineStart(r14))) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d4, code lost:
        if (r2 != false) goto L_0x00d6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x013c A[SYNTHETIC] */
    @Override // androidx.appcompat.widget.AppCompatTextView
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr;
        UIManagerModule uIManagerModule;
        int i6;
        int i7;
        float f;
        if ((getText() instanceof Spanned) && ReactYogaConfigProvider.getUIManagerType(getId()) != 2) {
            ReactContext reactContext = getReactContext();
            UIManagerModule uIManagerModule2 = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
            Spanned spanned = (Spanned) getText();
            Layout layout = getLayout();
            boolean z2 = false;
            TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr2 = (TextInlineViewPlaceholderSpan[]) spanned.getSpans(0, spanned.length(), TextInlineViewPlaceholderSpan.class);
            ArrayList arrayList = this.mNotifyOnInlineViewLayout ? new ArrayList(textInlineViewPlaceholderSpanArr2.length) : null;
            int i8 = i3 - i;
            int i9 = i4 - i2;
            int length = textInlineViewPlaceholderSpanArr2.length;
            int i10 = 0;
            while (i10 < length) {
                TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan = textInlineViewPlaceholderSpanArr2[i10];
                View resolveView = uIManagerModule2.resolveView(textInlineViewPlaceholderSpan.mReactTag);
                int spanStart = spanned.getSpanStart(textInlineViewPlaceholderSpan);
                int lineForOffset = layout.getLineForOffset(spanStart);
                boolean z3 = true;
                if (layout.getEllipsisCount(lineForOffset) > 0 ? true : z2) {
                }
                if (lineForOffset < this.mNumberOfLines && spanStart < layout.getLineEnd(lineForOffset)) {
                    int i11 = textInlineViewPlaceholderSpan.mWidth;
                    int i12 = textInlineViewPlaceholderSpan.mHeight;
                    uIManagerModule = uIManagerModule2;
                    boolean isRtlCharAt = layout.isRtlCharAt(spanStart);
                    textInlineViewPlaceholderSpanArr = textInlineViewPlaceholderSpanArr2;
                    i5 = length;
                    boolean z4 = layout.getParagraphDirection(lineForOffset) == -1;
                    if (spanStart != spanned.length() - 1) {
                        if (z4 == isRtlCharAt) {
                            f = layout.getPrimaryHorizontal(spanStart);
                        } else {
                            f = layout.getSecondaryHorizontal(spanStart);
                        }
                        int i13 = (int) f;
                        i6 = z4 ? i8 - (((int) layout.getLineRight(lineForOffset)) - i13) : i13;
                    } else if (z4) {
                        i6 = i8 - ((int) layout.getLineWidth(lineForOffset));
                        if (!isRtlCharAt) {
                            i7 = getTotalPaddingRight();
                        } else {
                            i7 = getTotalPaddingLeft();
                        }
                        int i14 = i7 + i6;
                        int i15 = i + i14;
                        int lineBaseline = (layout.getLineBaseline(lineForOffset) + getTotalPaddingTop()) - i12;
                        int i16 = i2 + lineBaseline;
                        if (i8 > i14 && i9 > lineBaseline) {
                            z3 = false;
                        }
                        int i17 = !z3 ? 8 : 0;
                        int i18 = i15 + i11;
                        int i19 = i16 + i12;
                        resolveView.setVisibility(i17);
                        resolveView.layout(i15, i16, i18, i19);
                        if (!this.mNotifyOnInlineViewLayout) {
                            arrayList.add(inlineViewJson(i17, spanStart, i15, i16, i18, i19));
                        }
                        i10++;
                        length = i5;
                        uIManagerModule2 = uIManagerModule;
                        textInlineViewPlaceholderSpanArr2 = textInlineViewPlaceholderSpanArr;
                        z2 = false;
                    } else {
                        i6 = (int) layout.getLineRight(lineForOffset);
                    }
                    i6 -= i11;
                    if (!isRtlCharAt) {
                    }
                    int i142 = i7 + i6;
                    int i152 = i + i142;
                    int lineBaseline2 = (layout.getLineBaseline(lineForOffset) + getTotalPaddingTop()) - i12;
                    int i162 = i2 + lineBaseline2;
                    z3 = false;
                    if (!z3) {
                    }
                    int i182 = i152 + i11;
                    int i192 = i162 + i12;
                    resolveView.setVisibility(i17);
                    resolveView.layout(i152, i162, i182, i192);
                    if (!this.mNotifyOnInlineViewLayout) {
                    }
                    i10++;
                    length = i5;
                    uIManagerModule2 = uIManagerModule;
                    textInlineViewPlaceholderSpanArr2 = textInlineViewPlaceholderSpanArr;
                    z2 = false;
                }
                uIManagerModule = uIManagerModule2;
                textInlineViewPlaceholderSpanArr = textInlineViewPlaceholderSpanArr2;
                i5 = length;
                resolveView.setVisibility(8);
                if (this.mNotifyOnInlineViewLayout) {
                    arrayList.add(inlineViewJson(8, spanStart, -1, -1, -1, -1));
                }
                i10++;
                length = i5;
                uIManagerModule2 = uIManagerModule;
                textInlineViewPlaceholderSpanArr2 = textInlineViewPlaceholderSpanArr;
                z2 = false;
            }
            if (this.mNotifyOnInlineViewLayout) {
                Collections.sort(arrayList, new Comparator() {
                    /* class com.facebook.react.views.text.ReactTextView.AnonymousClass1 */

                    @Override // java.util.Comparator
                    public int compare(Object obj, Object obj2) {
                        return ((WritableMap) obj).getInt("index") - ((WritableMap) obj2).getInt("index");
                    }
                });
                WritableArray createArray = Arguments.createArray();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    createArray.pushMap((WritableMap) it.next());
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putArray("inlineViews", createArray);
                ((RCTEventEmitter) reactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topInlineViewLayout", createMap);
            }
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onDetach();
            }
        }
    }

    @Override // com.facebook.react.uimanager.ReactCompoundView
    public int reactTagForTouch(float f, float f2) {
        int i;
        CharSequence text = getText();
        int id = getId();
        int i2 = (int) f;
        int i3 = (int) f2;
        Layout layout = getLayout();
        if (layout == null) {
            return id;
        }
        int lineForVertical = layout.getLineForVertical(i3);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        if ((text instanceof Spanned) && i2 >= lineLeft && i2 <= lineRight) {
            Spanned spanned = (Spanned) text;
            try {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (float) i2);
                ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                if (reactTagSpanArr != null) {
                    int length = text.length();
                    for (int i4 = 0; i4 < reactTagSpanArr.length; i4++) {
                        int spanStart = spanned.getSpanStart(reactTagSpanArr[i4]);
                        int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i4]);
                        if (spanEnd > offsetForHorizontal && (i = spanEnd - spanStart) <= length) {
                            id = reactTagSpanArr[i4].mReactTag;
                            length = i;
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Crash in HorizontalMeasurementProvider: ");
                outline17.append(e.getMessage());
                FLog.e("ReactNative", outline17.toString());
            }
        }
        return id;
    }

    public void setAdjustFontSizeToFit(boolean z) {
        this.mAdjustsFontSizeToFit = z;
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.mEllipsizeLocation = truncateAt;
    }

    public void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & -8 & -8388616));
    }

    public void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & -113));
    }

    public void setLinkifyMask(int i) {
        this.mLinkifyMaskType = i;
    }

    public void setNotifyOnInlineViewLayout(boolean z) {
        this.mNotifyOnInlineViewLayout = z;
    }

    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.mNumberOfLines = i;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        setSingleLine(z);
        setMaxLines(this.mNumberOfLines);
    }

    public void setSpanned(Spannable spannable) {
        this.mSpanned = spannable;
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        int i;
        int i2;
        this.mContainsImages = reactTextUpdate.mContainsImages;
        if (getLayoutParams() == null) {
            setLayoutParams(EMPTY_LAYOUT_PARAMS);
        }
        Spannable spannable = reactTextUpdate.mText;
        int i3 = this.mLinkifyMaskType;
        if (i3 > 0) {
            Linkify.addLinks(spannable, i3);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
        setText(spannable);
        float f = reactTextUpdate.mPaddingLeft;
        float f2 = reactTextUpdate.mPaddingTop;
        float f3 = reactTextUpdate.mPaddingRight;
        float f4 = reactTextUpdate.mPaddingBottom;
        if (!(f == -1.0f || f4 == -1.0f || f3 == -1.0f || i2 == 0)) {
            setPadding((int) Math.floor((double) f), (int) Math.floor((double) f2), (int) Math.floor((double) f3), (int) Math.floor((double) f4));
        }
        int i4 = reactTextUpdate.mTextAlign;
        if (this.mTextAlign != i4) {
            this.mTextAlign = i4;
        }
        setGravityHorizontal(this.mTextAlign);
        int breakStrategy = getBreakStrategy();
        int i5 = reactTextUpdate.mTextBreakStrategy;
        if (breakStrategy != i5) {
            setBreakStrategy(i5);
        }
        if (Build.VERSION.SDK_INT >= 26 && getJustificationMode() != (i = reactTextUpdate.mJustificationMode)) {
            setJustificationMode(i);
        }
        requestLayout();
    }

    public boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDrawable == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }
}
