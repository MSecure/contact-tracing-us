package com.facebook.react.views.text;

import android.content.Context;
import android.text.Spannable;
import android.text.TextPaint;
import android.util.LruCache;
import com.facebook.react.bridge.ReadableMap;

public class TextLayoutManager {
    public static LruCache<String, Spannable> sSpannableCache = new LruCache<>(100);
    public static final Object sSpannableCacheLock = new Object();
    public static final TextPaint sTextPaintInstance = new TextPaint(1);

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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r8 = r4.getMap(r7);
        r9 = r2.length();
        r10 = new com.facebook.react.views.text.TextAttributeProps(new com.facebook.react.uimanager.ReactStylesDiffMap(r8.getMap("textAttributes")));
        r2.append((java.lang.CharSequence) com.facebook.react.views.text.TextTransform.apply(r8.getString(com.facebook.react.modules.network.NetworkingModule.REQUEST_BODY_KEY_STRING), r10.mTextTransform));
        r11 = r2.length();
        r12 = r8.getInt("reactTag");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0067, code lost:
        if (r8.hasKey("isAttachment") == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006d, code lost:
        if (r8.getBoolean("isAttachment") == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r2.length() - 1, r2.length(), new com.facebook.react.views.text.TextInlineViewPlaceholderSpan(r12, (int) androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromSP((float) r8.getDouble(com.swmansion.gesturehandler.react.RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH)), (int) androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromSP((float) r8.getDouble(com.swmansion.gesturehandler.react.RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x009f, code lost:
        if (r11 < r9) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a3, code lost:
        if (r10.mIsColorSet == false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a5, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactForegroundColorSpan(r10.mColor)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b6, code lost:
        if (r10.mIsBackgroundColorSet == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b8, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactBackgroundColorSpan(r10.mBackgroundColor)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cf, code lost:
        if (java.lang.Float.isNaN(r10.getLetterSpacing()) != false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d1, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.CustomLetterSpacingSpan(r10.getLetterSpacing())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e2, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactAbsoluteSizeSpan(r10.mFontSize)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f3, code lost:
        if (r10.mFontStyle != -1) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f7, code lost:
        if (r10.mFontWeight != -1) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00fb, code lost:
        if (r10.mFontFamily == null) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fe, code lost:
        r19 = r4;
        r20 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0103, code lost:
        r19 = r4;
        r20 = r5;
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.CustomStyleSpan(r10.mFontStyle, r10.mFontWeight, r10.mFontFeatureSettings, r10.mFontFamily, r21.getAssets())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x012c, code lost:
        if (r10.mIsUnderlineTextDecorationSet == false) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x012e, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactUnderlineSpan()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x013d, code lost:
        if (r10.mIsLineThroughTextDecorationSet == false) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x013f, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactStrikethroughSpan()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0151, code lost:
        if (r10.mTextShadowOffsetDx != com.facebook.react.uimanager.BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0157, code lost:
        if (r10.mTextShadowOffsetDy == com.facebook.react.uimanager.BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0159, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ShadowStyleSpan(r10.mTextShadowOffsetDx, r10.mTextShadowOffsetDy, r10.mTextShadowRadius, r10.mTextShadowColor)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0176, code lost:
        if (java.lang.Float.isNaN(r10.getEffectiveLineHeight()) != false) goto L_0x0189;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0178, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.CustomLineHeightSpan(r10.getEffectiveLineHeight())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0189, code lost:
        r3.add(new com.facebook.react.views.text.TextLayoutManager.SetSpanOperation(r9, r11, new com.facebook.react.views.text.ReactTagSpan(r12)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0197, code lost:
        r19 = r4;
        r20 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x019b, code lost:
        r7 = r7 + 1;
        r4 = r19;
        r5 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01a3, code lost:
        r3 = r3.iterator();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01ac, code lost:
        if (r3.hasNext() == false) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ae, code lost:
        r4 = (com.facebook.react.views.text.TextLayoutManager.SetSpanOperation) r3.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01b6, code lost:
        if (r4.start != 0) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01b8, code lost:
        r5 = 18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01bb, code lost:
        r5 = 34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01bd, code lost:
        r2.setSpan(r4.what, r4.start, r4.end, (r5 & -16711681) | ((r6 << 16) & 16711680));
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01d3, code lost:
        if (r23 == null) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d5, code lost:
        r23.onPostProcessSpannable(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d8, code lost:
        r3 = com.facebook.react.views.text.TextLayoutManager.sSpannableCacheLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01da, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        com.facebook.react.views.text.TextLayoutManager.sSpannableCache.put(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01e0, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e1, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        r2 = new android.text.SpannableStringBuilder();
        r3 = new java.util.ArrayList();
        r4 = r22.getArray("fragments");
        r5 = r4.size();
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r7 >= r5) goto L_0x01a3;
     */
    public static Spannable getOrCreateSpannableForText(Context context, ReadableMap readableMap, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        String obj = readableMap.toString();
        synchronized (sSpannableCacheLock) {
            Spannable spannable = sSpannableCache.get(obj);
            if (spannable != null) {
                return spannable;
            }
        }
    }
}
