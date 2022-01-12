package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewParent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactFontManager;
import com.google.common.util.concurrent.MoreExecutors;
import java.text.Bidi;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
public class TSpanView extends TextView {
    public final AssetManager assets = this.mContext.getResources().getAssets();
    public final ArrayList<String> emoji = new ArrayList<>();
    public final ArrayList<Matrix> emojiTransforms = new ArrayList<>();
    public Path mCachedPath;
    public String mContent;
    public TextPathView textPath;

    public TSpanView(ReactContext reactContext) {
        super(reactContext);
    }

    public final void applySpacingAndFeatures(Paint paint, FontData fontData) {
        double d = fontData.letterSpacing;
        paint.setLetterSpacing((float) (d / (fontData.fontSize * ((double) this.mScale))));
        if (d == 0.0d && fontData.fontVariantLigatures == TextProperties$FontVariantLigatures.normal) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', ");
            outline17.append(fontData.fontFeatureSettings);
            paint.setFontFeatureSettings(outline17.toString());
        } else {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, ");
            outline172.append(fontData.fontFeatureSettings);
            paint.setFontFeatureSettings(outline172.toString());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            StringBuilder outline173 = GeneratedOutlineSupport.outline17("'wght' ");
            outline173.append(fontData.absoluteFontWeight);
            outline173.append(fontData.fontVariationSettings);
            paint.setFontVariationSettings(outline173.toString());
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00ab */
    public final void applyTextPropertiesToPaint(Paint paint, FontData fontData) {
        boolean z = fontData.fontWeight == TextProperties$FontWeight.Bold || fontData.absoluteFontWeight >= 550;
        boolean z2 = fontData.fontStyle == TextProperties$FontStyle.italic;
        int i = (!z || !z2) ? z ? 1 : z2 ? 2 : 0 : 3;
        Typeface typeface = null;
        int i2 = fontData.absoluteFontWeight;
        String str = fontData.fontFamily;
        if (str != null && str.length() > 0) {
            String outline11 = GeneratedOutlineSupport.outline11("fonts/", str, ".otf");
            String outline112 = GeneratedOutlineSupport.outline11("fonts/", str, ".ttf");
            if (Build.VERSION.SDK_INT >= 26) {
                Typeface.Builder builder = new Typeface.Builder(this.assets, outline11);
                builder.setFontVariationSettings("'wght' " + i2 + fontData.fontVariationSettings);
                builder.setWeight(i2);
                builder.setItalic(z2);
                typeface = builder.build();
                if (typeface == null) {
                    Typeface.Builder builder2 = new Typeface.Builder(this.assets, outline112);
                    builder2.setFontVariationSettings("'wght' " + i2 + fontData.fontVariationSettings);
                    builder2.setWeight(i2);
                    builder2.setItalic(z2);
                    typeface = builder2.build();
                }
            } else {
                typeface = Typeface.create(Typeface.createFromAsset(this.assets, outline11), i);
                try {
                    typeface = Typeface.create(Typeface.createFromAsset(this.assets, outline112), i);
                } catch (Exception unused) {
                }
            }
        }
        if (typeface == null) {
            try {
                typeface = ReactFontManager.getInstance().getTypeface(str, i, 0, this.assets);
            } catch (Exception unused2) {
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            typeface = Typeface.create(typeface, i2, z2);
        }
        paint.setLinearText(true);
        paint.setSubpixelText(true);
        paint.setTypeface(typeface);
        paint.setTextSize((float) (fontData.fontSize * ((double) this.mScale)));
        paint.setLetterSpacing(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.TextView
    public void clearCache() {
        this.mCachedPath = null;
        super.clearCache();
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView, com.horcrux.svg.TextView, com.horcrux.svg.GroupView
    public void draw(Canvas canvas, Paint paint, float f) {
        if (this.mContent != null) {
            SVGLength sVGLength = this.mInlineSize;
            if (sVGLength == null || sVGLength.value == 0.0d) {
                int size = this.emoji.size();
                if (size > 0) {
                    applyTextPropertiesToPaint(paint, getTextRootGlyphContext().topFont);
                    for (int i = 0; i < size; i++) {
                        canvas.save();
                        canvas.concat(this.emojiTransforms.get(i));
                        canvas.drawText(this.emoji.get(i), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, paint);
                        canvas.restore();
                    }
                }
                drawPath(canvas, paint, f);
                return;
            }
            if (setupFillPaint(paint, this.fillOpacity * f)) {
                drawWrappedText(canvas, paint);
            }
            if (setupStrokePaint(paint, f * this.strokeOpacity)) {
                drawWrappedText(canvas, paint);
                return;
            }
            return;
        }
        clip(canvas, paint);
        drawGroup(canvas, paint, f);
    }

    public final void drawWrappedText(Canvas canvas, Paint paint) {
        Layout.Alignment alignment;
        GlyphContext textRootGlyphContext = getTextRootGlyphContext();
        pushGlyphContext();
        FontData fontData = textRootGlyphContext.topFont;
        TextPaint textPaint = new TextPaint(paint);
        applyTextPropertiesToPaint(textPaint, fontData);
        applySpacingAndFeatures(textPaint, fontData);
        double d = textRootGlyphContext.mFontSize;
        int ordinal = fontData.textAnchor.ordinal();
        if (ordinal == 1) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (ordinal != 2) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        SpannableString spannableString = new SpannableString(this.mContent);
        StaticLayout build = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, (int) MoreExecutors.fromRelative(this.mInlineSize, (double) canvas.getWidth(), 0.0d, (double) this.mScale, d)).setAlignment(alignment).setLineSpacing(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f).setIncludePad(true).setBreakStrategy(1).setHyphenationFrequency(1).build();
        int lineAscent = build.getLineAscent(0);
        popGlyphContext();
        canvas.save();
        canvas.translate((float) textRootGlyphContext.nextX(0.0d), (float) (textRootGlyphContext.nextY() + ((double) lineAscent)));
        build.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0390, code lost:
        if (r2.equals("sub") != false) goto L_0x039e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0242  */
    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView, com.horcrux.svg.TextView, com.horcrux.svg.GroupView
    public Path getPath(Canvas canvas, Paint paint) {
        TSpanView tSpanView;
        Path path;
        double d;
        PathMeasure pathMeasure;
        Path path2;
        boolean z;
        ReadableMap readableMap;
        ArrayList<FontData> arrayList;
        ViewParent parent;
        int size;
        TextView textView;
        int ordinal;
        double d2;
        double d3;
        int i;
        float[] fArr;
        ArrayList arrayList2;
        boolean z2;
        double d4;
        double d5;
        boolean z3;
        double d6;
        int i2;
        SVGLength sVGLength;
        double d7;
        double d8;
        String str;
        double d9;
        TextProperties$AlignmentBaseline textProperties$AlignmentBaseline;
        Paint paint2;
        double d10;
        char c;
        GlyphContext glyphContext;
        int i3;
        boolean z4;
        double d11;
        char c2;
        int i4;
        double d12;
        double d13;
        Matrix matrix;
        Matrix matrix2;
        double d14;
        boolean z5;
        float[] fArr2;
        double d15;
        double d16;
        float[] fArr3;
        Matrix matrix3;
        PathMeasure pathMeasure2;
        int i5;
        double d17;
        int i6;
        GlyphContext glyphContext2;
        Paint paint3;
        TSpanView tSpanView2;
        Path path3;
        ArrayList arrayList3;
        Matrix matrix4;
        double d18;
        double d19;
        GlyphContext glyphContext3;
        double d20;
        Path path4;
        char c3;
        int i7;
        Path path5;
        int i8;
        double d21;
        int ordinal2;
        int hashCode;
        double d22;
        double d23;
        String str2;
        double d24;
        int i9;
        boolean z6;
        TSpanView tSpanView3 = this;
        Path path6 = tSpanView3.mCachedPath;
        if (path6 != null) {
            return path6;
        }
        if (tSpanView3.mContent == null) {
            Path groupPath = getGroupPath(canvas, paint);
            tSpanView3.mCachedPath = groupPath;
            return groupPath;
        }
        ViewParent parent2 = getParent();
        while (true) {
            if (parent2 == null) {
                break;
            } else if (parent2.getClass() == TextPathView.class) {
                tSpanView3.textPath = (TextPathView) parent2;
                break;
            } else if (!(parent2 instanceof TextView)) {
                break;
            } else {
                parent2 = parent2.getParent();
            }
        }
        pushGlyphContext();
        String str3 = tSpanView3.mContent;
        boolean z7 = false;
        if (!(str3 == null || str3.length() == 0)) {
            Bidi bidi = new Bidi(str3, -2);
            if (!bidi.isLeftToRight()) {
                int runCount = bidi.getRunCount();
                byte[] bArr = new byte[runCount];
                Integer[] numArr = new Integer[runCount];
                for (int i10 = 0; i10 < runCount; i10++) {
                    bArr[i10] = (byte) bidi.getRunLevel(i10);
                    numArr[i10] = Integer.valueOf(i10);
                }
                Bidi.reorderVisually(bArr, 0, numArr, 0, runCount);
                StringBuilder sb = new StringBuilder();
                for (int i11 = 0; i11 < runCount; i11++) {
                    int intValue = numArr[i11].intValue();
                    int runStart = bidi.getRunStart(intValue);
                    int runLimit = bidi.getRunLimit(intValue);
                    if ((bArr[intValue] & 1) != 0) {
                        while (true) {
                            runLimit--;
                            if (runLimit < runStart) {
                                break;
                            }
                            sb.append(str3.charAt(runLimit));
                        }
                    } else {
                        sb.append((CharSequence) str3, runStart, runLimit);
                    }
                }
                str3 = sb.toString();
            }
        }
        int length = str3.length();
        Path path7 = new Path();
        tSpanView3.emoji.clear();
        tSpanView3.emojiTransforms.clear();
        if (length != 0) {
            boolean z8 = tSpanView3.textPath != null;
            Path path8 = null;
            if (z8) {
                TextPathView textPathView = tSpanView3.textPath;
                VirtualView definedTemplate = textPathView.getSvgView().getDefinedTemplate(textPathView.mHref);
                if (definedTemplate instanceof RenderableView) {
                    path8 = ((RenderableView) definedTemplate).getPath(canvas, paint);
                }
                PathMeasure pathMeasure3 = new PathMeasure(path8, false);
                double length2 = (double) pathMeasure3.getLength();
                boolean isClosed = pathMeasure3.isClosed();
                if (length2 != 0.0d) {
                    d = length2;
                    z7 = isClosed;
                    pathMeasure = pathMeasure3;
                }
            } else {
                pathMeasure = null;
                d = 0.0d;
            }
            GlyphContext textRootGlyphContext = getTextRootGlyphContext();
            FontData fontData = textRootGlyphContext.topFont;
            tSpanView3.applyTextPropertiesToPaint(paint, fontData);
            ArrayList arrayList4 = new ArrayList();
            int[][] iArr = new int[256][];
            arrayList4.add(new Path());
            boolean[] zArr = new boolean[length];
            char[] charArray = str3.toCharArray();
            double d25 = fontData.kerning;
            double d26 = fontData.wordSpacing;
            double d27 = fontData.letterSpacing;
            boolean z9 = !fontData.manualKerning;
            if (d27 == 0.0d) {
                path2 = path7;
                if (fontData.fontVariantLigatures == TextProperties$FontVariantLigatures.normal) {
                    z = true;
                    if (!z) {
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', ");
                        outline17.append(fontData.fontFeatureSettings);
                        paint.setFontFeatureSettings(outline17.toString());
                    } else {
                        StringBuilder outline172 = GeneratedOutlineSupport.outline17("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, ");
                        outline172.append(fontData.fontFeatureSettings);
                        paint.setFontFeatureSettings(outline172.toString());
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        StringBuilder outline173 = GeneratedOutlineSupport.outline17("'wght' ");
                        outline173.append(fontData.absoluteFontWeight);
                        outline173.append(fontData.fontVariationSettings);
                        paint.setFontVariationSettings(outline173.toString());
                    }
                    readableMap = fontData.fontData;
                    float[] fArr4 = new float[length];
                    paint.getTextWidths(str3, fArr4);
                    TextProperties$TextAnchor textProperties$TextAnchor = fontData.textAnchor;
                    arrayList = getTextRootGlyphContext().mFontContext;
                    PathMeasure pathMeasure4 = pathMeasure;
                    parent = getParent();
                    size = arrayList.size() - 1;
                    textView = tSpanView3;
                    while (size >= 0 && (parent instanceof TextView) && arrayList.get(size).textAnchor != TextProperties$TextAnchor.start && textView.mPositionX == null) {
                        textView = (TextView) parent;
                        parent = textView.getParent();
                        size--;
                        arrayList = arrayList;
                        readableMap = readableMap;
                    }
                    double d28 = d27;
                    double subtreeTextChunksTotalAdvance = textView.getSubtreeTextChunksTotalAdvance(paint);
                    ordinal = textProperties$TextAnchor.ordinal();
                    if (ordinal != 1) {
                        i = length;
                        d3 = (-subtreeTextChunksTotalAdvance) / 2.0d;
                    } else if (ordinal != 2) {
                        i = length;
                        d2 = subtreeTextChunksTotalAdvance;
                        d3 = 0.0d;
                        double d29 = textRootGlyphContext.mFontSize;
                        if (z8) {
                            z6 = tSpanView3.textPath.mMidLine == TextProperties$TextPathMidLine.sharp;
                            i9 = tSpanView3.textPath.mSide == TextProperties$TextPathSide.right ? -1 : 1;
                            z2 = z8;
                            arrayList2 = arrayList4;
                            fArr = fArr4;
                            double fromRelative = MoreExecutors.fromRelative(tSpanView3.textPath.mStartOffset, d, 0.0d, (double) tSpanView3.mScale, d29);
                            d3 += fromRelative;
                            if (z7) {
                                z3 = z6;
                                double d30 = (textProperties$TextAnchor == TextProperties$TextAnchor.middle ? -(d / 2.0d) : 0.0d) + fromRelative;
                                d4 = d30;
                                i2 = i9;
                                d5 = d30 + d;
                                d6 = d3;
                                sVGLength = tSpanView3.mTextLength;
                                if (sVGLength == null) {
                                    d8 = d;
                                    double fromRelative2 = MoreExecutors.fromRelative(sVGLength, (double) canvas.getWidth(), 0.0d, (double) tSpanView3.mScale, d29);
                                    if (fromRelative2 < 0.0d) {
                                        throw new IllegalArgumentException("Negative textLength value");
                                    } else if (tSpanView3.mLengthAdjust.ordinal() != 1) {
                                        d24 = ((fromRelative2 - d2) / ((double) (i - 1))) + d28;
                                    } else {
                                        d7 = fromRelative2 / d2;
                                        double d31 = (double) i2;
                                        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                                        double d32 = d7 * d31;
                                        double d33 = (double) fontMetrics.descent;
                                        float f = fontMetrics.leading;
                                        double d34 = ((double) f) + d33;
                                        int i12 = i2;
                                        double d35 = (double) ((-fontMetrics.ascent) + f);
                                        double d36 = d31;
                                        double d37 = (double) (-fontMetrics.top);
                                        double d38 = d37 + d34;
                                        if (tSpanView3.mBaselineShift == null) {
                                            ViewParent parent3 = getParent();
                                            while (true) {
                                                if (parent3 == null) {
                                                    break;
                                                }
                                                if ((parent3 instanceof TextView) && (str2 = ((TextView) parent3).mBaselineShift) != null) {
                                                    tSpanView3.mBaselineShift = str2;
                                                    str = str2;
                                                    break;
                                                }
                                                parent3 = parent3.getParent();
                                            }
                                        }
                                        str = tSpanView3.mBaselineShift;
                                        if (tSpanView3.mAlignmentBaseline == null) {
                                            ViewParent parent4 = getParent();
                                            while (true) {
                                                if (parent4 == null) {
                                                    break;
                                                }
                                                d9 = d37;
                                                if ((parent4 instanceof TextView) && (textProperties$AlignmentBaseline = ((TextView) parent4).mAlignmentBaseline) != null) {
                                                    tSpanView3.mAlignmentBaseline = textProperties$AlignmentBaseline;
                                                    break;
                                                }
                                                parent4 = parent4.getParent();
                                                d37 = d9;
                                            }
                                        }
                                        d9 = d37;
                                        if (tSpanView3.mAlignmentBaseline == null) {
                                            tSpanView3.mAlignmentBaseline = TextProperties$AlignmentBaseline.baseline;
                                        }
                                        textProperties$AlignmentBaseline = tSpanView3.mAlignmentBaseline;
                                        if (textProperties$AlignmentBaseline != null) {
                                            switch (textProperties$AlignmentBaseline.ordinal()) {
                                                case 1:
                                                case 3:
                                                case 12:
                                                case 14:
                                                    paint2 = paint;
                                                    d22 = -d33;
                                                    c = 0;
                                                    d10 = d22;
                                                    break;
                                                case 4:
                                                    Rect rect = new Rect();
                                                    paint2 = paint;
                                                    paint2.getTextBounds("x", 0, 1, rect);
                                                    d22 = ((double) rect.height()) / 2.0d;
                                                    c = 0;
                                                    d10 = d22;
                                                    break;
                                                case 5:
                                                    d34 = (d35 - d33) / 2.0d;
                                                    c = 0;
                                                    d10 = d34;
                                                    paint2 = paint;
                                                    break;
                                                case 6:
                                                    d23 = 0.5d;
                                                    d34 = d23 * d35;
                                                    c = 0;
                                                    d10 = d34;
                                                    paint2 = paint;
                                                    break;
                                                case 7:
                                                case 11:
                                                case 13:
                                                    d34 = d35;
                                                    c = 0;
                                                    d10 = d34;
                                                    paint2 = paint;
                                                    break;
                                                case 8:
                                                    c = 0;
                                                    d10 = d34;
                                                    paint2 = paint;
                                                    break;
                                                case 9:
                                                    d34 = d38 / 2.0d;
                                                    c = 0;
                                                    d10 = d34;
                                                    paint2 = paint;
                                                    break;
                                                case 10:
                                                    d34 = d9;
                                                    c = 0;
                                                    d10 = d34;
                                                    paint2 = paint;
                                                    break;
                                                case 15:
                                                    d23 = 0.8d;
                                                    d34 = d23 * d35;
                                                    c = 0;
                                                    d10 = d34;
                                                    paint2 = paint;
                                                    break;
                                            }
                                            if (!(str == null || str.isEmpty() || (ordinal2 = textProperties$AlignmentBaseline.ordinal()) == 8 || ordinal2 == 10)) {
                                                hashCode = str.hashCode();
                                                if (hashCode == -1720785339) {
                                                    if (hashCode != 114240) {
                                                        if (hashCode == 109801339 && str.equals("super")) {
                                                            c = 1;
                                                            if (c != 0) {
                                                                glyphContext = textRootGlyphContext;
                                                                if (readableMap != null && readableMap.hasKey("tables") && readableMap.hasKey("unitsPerEm")) {
                                                                    int i13 = readableMap.getInt("unitsPerEm");
                                                                    ReadableMap map = readableMap.getMap("tables");
                                                                    if (map.hasKey("os2")) {
                                                                        ReadableMap map2 = map.getMap("os2");
                                                                        if (map2.hasKey("ySubscriptYOffset")) {
                                                                            d10 += ((((double) tSpanView3.mScale) * d29) * map2.getDouble("ySubscriptYOffset")) / ((double) i13);
                                                                        }
                                                                    }
                                                                }
                                                            } else if (c != 1) {
                                                                if (c != 2) {
                                                                    double d39 = (double) tSpanView3.mScale;
                                                                    d10 -= MoreExecutors.fromRelative(str, d39 * d29, d39, d29);
                                                                }
                                                            } else if (readableMap != null && readableMap.hasKey("tables") && readableMap.hasKey("unitsPerEm")) {
                                                                int i14 = readableMap.getInt("unitsPerEm");
                                                                ReadableMap map3 = readableMap.getMap("tables");
                                                                if (map3.hasKey("os2")) {
                                                                    ReadableMap map4 = map3.getMap("os2");
                                                                    if (map4.hasKey("ySuperscriptYOffset")) {
                                                                        glyphContext = textRootGlyphContext;
                                                                        d10 -= ((((double) tSpanView3.mScale) * d29) * map4.getDouble("ySuperscriptYOffset")) / ((double) i14);
                                                                    }
                                                                }
                                                            }
                                                            double d40 = d10;
                                                            Matrix matrix5 = new Matrix();
                                                            Matrix matrix6 = new Matrix();
                                                            Matrix matrix7 = new Matrix();
                                                            float[] fArr5 = new float[9];
                                                            float[] fArr6 = new float[9];
                                                            i3 = 0;
                                                            while (i3 < i) {
                                                                char c4 = charArray[i3];
                                                                String valueOf = String.valueOf(c4);
                                                                boolean z10 = zArr[i3];
                                                                if (z10) {
                                                                    valueOf = "";
                                                                    z4 = false;
                                                                } else {
                                                                    z4 = false;
                                                                    int i15 = i3;
                                                                    while (true) {
                                                                        int i16 = i15 + 1;
                                                                        if (i16 < i && fArr[i16] <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                                            StringBuilder outline174 = GeneratedOutlineSupport.outline17(valueOf);
                                                                            outline174.append(charArray[i16]);
                                                                            valueOf = outline174.toString();
                                                                            zArr[i16] = true;
                                                                            z4 = true;
                                                                            i = i;
                                                                            i15 = i16;
                                                                        }
                                                                    }
                                                                }
                                                                double measureText = ((double) paint2.measureText(valueOf)) * d7;
                                                                if (z9) {
                                                                    d11 = d40;
                                                                    d25 = (((double) fArr[i3]) * d7) - measureText;
                                                                } else {
                                                                    d11 = d40;
                                                                }
                                                                boolean z11 = c4 == ' ';
                                                                double d41 = (z11 ? d26 : 0.0d) + d28 + measureText;
                                                                if (z10) {
                                                                    c2 = c4;
                                                                    i4 = i3;
                                                                    d12 = 0.0d;
                                                                } else {
                                                                    c2 = c4;
                                                                    i4 = i3;
                                                                    d12 = d25 + d41;
                                                                }
                                                                double nextX = glyphContext.nextX(d12);
                                                                float[] fArr7 = fArr5;
                                                                double nextY = glyphContext.nextY();
                                                                GlyphContext.incrementIndices(glyphContext.mDXIndices, glyphContext.mDXsIndex);
                                                                int i17 = glyphContext.mDXIndex + 1;
                                                                SVGLength[] sVGLengthArr = glyphContext.mDXs;
                                                                if (i17 < sVGLengthArr.length) {
                                                                    glyphContext.mDXIndex = i17;
                                                                    matrix2 = matrix5;
                                                                    matrix = matrix6;
                                                                    d13 = nextX;
                                                                    glyphContext.mDX += MoreExecutors.fromRelative(sVGLengthArr[i17], (double) glyphContext.mWidth, 0.0d, (double) glyphContext.mScale, glyphContext.mFontSize);
                                                                } else {
                                                                    d13 = nextX;
                                                                    matrix2 = matrix5;
                                                                    matrix = matrix6;
                                                                }
                                                                double d42 = glyphContext.mDX;
                                                                GlyphContext.incrementIndices(glyphContext.mDYIndices, glyphContext.mDYsIndex);
                                                                int i18 = glyphContext.mDYIndex + 1;
                                                                SVGLength[] sVGLengthArr2 = glyphContext.mDYs;
                                                                if (i18 < sVGLengthArr2.length) {
                                                                    glyphContext.mDYIndex = i18;
                                                                    d14 = d42;
                                                                    glyphContext.mDY += MoreExecutors.fromRelative(sVGLengthArr2[i18], (double) glyphContext.mHeight, 0.0d, (double) glyphContext.mScale, glyphContext.mFontSize);
                                                                } else {
                                                                    d14 = d42;
                                                                }
                                                                double d43 = glyphContext.mDY;
                                                                GlyphContext.incrementIndices(glyphContext.mRIndices, glyphContext.mRsIndex);
                                                                int min = Math.min(glyphContext.mRIndex + 1, glyphContext.mRs.length - 1);
                                                                glyphContext.mRIndex = min;
                                                                double d44 = glyphContext.mRs[min];
                                                                if (z10 || z11) {
                                                                    tSpanView2 = this;
                                                                    paint3 = paint;
                                                                    glyphContext2 = glyphContext;
                                                                } else {
                                                                    double d45 = measureText * d36;
                                                                    double d46 = (((d13 + d14) * d36) + d6) - (d41 * d36);
                                                                    if (z2) {
                                                                        double d47 = d46 + d45;
                                                                        double d48 = d45 / 2.0d;
                                                                        double d49 = d46 + d48;
                                                                        if (d49 <= d5 && d49 >= d4) {
                                                                            if (z3) {
                                                                                pathMeasure4.getMatrix((float) d49, matrix, 3);
                                                                                glyphContext3 = glyphContext;
                                                                                matrix4 = matrix;
                                                                                d19 = d44;
                                                                                z5 = z3;
                                                                                d18 = d8;
                                                                                matrix5 = matrix2;
                                                                                matrix3 = matrix7;
                                                                            } else {
                                                                                glyphContext3 = glyphContext;
                                                                                matrix4 = matrix;
                                                                                if (d46 < 0.0d) {
                                                                                    z5 = z3;
                                                                                    d19 = d44;
                                                                                    matrix5 = matrix2;
                                                                                    pathMeasure4.getMatrix(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, matrix5, 3);
                                                                                    matrix5.preTranslate((float) d46, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                                                                    i8 = 1;
                                                                                } else {
                                                                                    d19 = d44;
                                                                                    z5 = z3;
                                                                                    matrix5 = matrix2;
                                                                                    pathMeasure4.getMatrix((float) d46, matrix5, 1);
                                                                                    i8 = 1;
                                                                                }
                                                                                pathMeasure4.getMatrix((float) d49, matrix4, i8);
                                                                                if (d47 > d8) {
                                                                                    d21 = d8;
                                                                                    pathMeasure4.getMatrix((float) d21, matrix7, 3);
                                                                                    matrix7.preTranslate((float) (d47 - d21), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                                                                } else {
                                                                                    d21 = d8;
                                                                                    pathMeasure4.getMatrix((float) d47, matrix7, i8);
                                                                                }
                                                                                matrix5.getValues(fArr7);
                                                                                matrix7.getValues(fArr6);
                                                                                pathMeasure4 = pathMeasure4;
                                                                                matrix3 = matrix7;
                                                                                fArr7 = fArr7;
                                                                                d18 = d21;
                                                                                matrix4.preRotate((float) (Math.atan2(((double) fArr6[5]) - ((double) fArr7[5]), ((double) fArr6[2]) - ((double) fArr7[2])) * 57.29577951308232d * d36));
                                                                            }
                                                                            matrix4.preTranslate((float) (-d48), (float) (d43 + d11));
                                                                            d20 = d32;
                                                                            i6 = i12;
                                                                            matrix4.preScale((float) d20, (float) i6);
                                                                            matrix4.postTranslate(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (float) nextY);
                                                                        } else {
                                                                            tSpanView2 = this;
                                                                            paint3 = paint;
                                                                            glyphContext2 = glyphContext;
                                                                        }
                                                                    } else {
                                                                        glyphContext3 = glyphContext;
                                                                        d19 = d44;
                                                                        z5 = z3;
                                                                        d18 = d8;
                                                                        i6 = i12;
                                                                        matrix5 = matrix2;
                                                                        matrix4 = matrix;
                                                                        matrix3 = matrix7;
                                                                        d20 = d32;
                                                                        matrix4.setTranslate((float) d46, (float) (nextY + d43 + d11));
                                                                    }
                                                                    matrix4.preRotate((float) d19);
                                                                    if (z4) {
                                                                        Path path9 = new Path();
                                                                        d17 = d20;
                                                                        i5 = i4;
                                                                        glyphContext2 = glyphContext3;
                                                                        pathMeasure2 = pathMeasure4;
                                                                        fArr3 = fArr6;
                                                                        fArr2 = fArr7;
                                                                        d15 = d36;
                                                                        d16 = d18;
                                                                        paint.getTextPath(valueOf, 0, valueOf.length(), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, path9);
                                                                        path4 = path9;
                                                                        arrayList3 = arrayList2;
                                                                    } else {
                                                                        d17 = d20;
                                                                        pathMeasure2 = pathMeasure4;
                                                                        fArr3 = fArr6;
                                                                        i5 = i4;
                                                                        glyphContext2 = glyphContext3;
                                                                        d16 = d18;
                                                                        fArr2 = fArr7;
                                                                        d15 = d36;
                                                                        int i19 = c2 >> '\b';
                                                                        int[] iArr2 = iArr[i19];
                                                                        if (iArr2 == null) {
                                                                            i7 = 0;
                                                                            c3 = c2;
                                                                        } else {
                                                                            c3 = c2;
                                                                            i7 = iArr2[c3 & 255];
                                                                        }
                                                                        if (i7 != 0) {
                                                                            path5 = (Path) arrayList2.get(i7);
                                                                            arrayList3 = arrayList2;
                                                                        } else {
                                                                            Path path10 = new Path();
                                                                            paint.getTextPath(valueOf, 0, 1, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, path10);
                                                                            int[] iArr3 = iArr[i19];
                                                                            if (iArr3 == null) {
                                                                                iArr3 = new int[256];
                                                                                iArr[i19] = iArr3;
                                                                            }
                                                                            iArr3[c3 & 255] = arrayList2.size();
                                                                            path5 = path10;
                                                                            arrayList3 = arrayList2;
                                                                            arrayList3.add(path5);
                                                                        }
                                                                        path4 = new Path();
                                                                        path4.addPath(path5);
                                                                    }
                                                                    RectF rectF = new RectF();
                                                                    path4.computeBounds(rectF, true);
                                                                    if (rectF.width() == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                                        canvas.save();
                                                                        canvas.concat(matrix4);
                                                                        tSpanView2 = this;
                                                                        tSpanView2.emoji.add(valueOf);
                                                                        tSpanView2.emojiTransforms.add(new Matrix(matrix4));
                                                                        paint3 = paint;
                                                                        canvas.drawText(valueOf, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, paint3);
                                                                        canvas.restore();
                                                                        path3 = path2;
                                                                    } else {
                                                                        tSpanView2 = this;
                                                                        paint3 = paint;
                                                                        path4.transform(matrix4);
                                                                        path3 = path2;
                                                                        path3.addPath(path4);
                                                                    }
                                                                    int i20 = i5 + 1;
                                                                    matrix6 = matrix4;
                                                                    arrayList2 = arrayList3;
                                                                    path2 = path3;
                                                                    tSpanView3 = tSpanView2;
                                                                    i12 = i6;
                                                                    d32 = d17;
                                                                    matrix7 = matrix3;
                                                                    fArr6 = fArr3;
                                                                    d8 = d16;
                                                                    i = i;
                                                                    d40 = d11;
                                                                    d36 = d15;
                                                                    i3 = i20;
                                                                    glyphContext = glyphContext2;
                                                                    pathMeasure4 = pathMeasure2;
                                                                    z3 = z5;
                                                                    paint2 = paint3;
                                                                    fArr5 = fArr2;
                                                                }
                                                                z5 = z3;
                                                                path3 = path2;
                                                                pathMeasure2 = pathMeasure4;
                                                                i5 = i4;
                                                                d17 = d32;
                                                                arrayList3 = arrayList2;
                                                                i6 = i12;
                                                                matrix5 = matrix2;
                                                                matrix4 = matrix;
                                                                d16 = d8;
                                                                fArr2 = fArr7;
                                                                fArr3 = fArr6;
                                                                d15 = d36;
                                                                matrix3 = matrix7;
                                                                int i202 = i5 + 1;
                                                                matrix6 = matrix4;
                                                                arrayList2 = arrayList3;
                                                                path2 = path3;
                                                                tSpanView3 = tSpanView2;
                                                                i12 = i6;
                                                                d32 = d17;
                                                                matrix7 = matrix3;
                                                                fArr6 = fArr3;
                                                                d8 = d16;
                                                                i = i;
                                                                d40 = d11;
                                                                d36 = d15;
                                                                i3 = i202;
                                                                glyphContext = glyphContext2;
                                                                pathMeasure4 = pathMeasure2;
                                                                z3 = z5;
                                                                paint2 = paint3;
                                                                fArr5 = fArr2;
                                                            }
                                                            tSpanView = tSpanView3;
                                                            path = path2;
                                                            tSpanView.mCachedPath = path;
                                                            popGlyphContext();
                                                            return tSpanView.mCachedPath;
                                                        }
                                                    }
                                                } else if (str.equals("baseline")) {
                                                    c = 2;
                                                    if (c != 0) {
                                                    }
                                                    double d402 = d10;
                                                    Matrix matrix52 = new Matrix();
                                                    Matrix matrix62 = new Matrix();
                                                    Matrix matrix72 = new Matrix();
                                                    float[] fArr52 = new float[9];
                                                    float[] fArr62 = new float[9];
                                                    i3 = 0;
                                                    while (i3 < i) {
                                                    }
                                                    tSpanView = tSpanView3;
                                                    path = path2;
                                                    tSpanView.mCachedPath = path;
                                                    popGlyphContext();
                                                    return tSpanView.mCachedPath;
                                                }
                                                c = 65535;
                                                if (c != 0) {
                                                }
                                                double d4022 = d10;
                                                Matrix matrix522 = new Matrix();
                                                Matrix matrix622 = new Matrix();
                                                Matrix matrix722 = new Matrix();
                                                float[] fArr522 = new float[9];
                                                float[] fArr622 = new float[9];
                                                i3 = 0;
                                                while (i3 < i) {
                                                }
                                                tSpanView = tSpanView3;
                                                path = path2;
                                                tSpanView.mCachedPath = path;
                                                popGlyphContext();
                                                return tSpanView.mCachedPath;
                                            }
                                            glyphContext = textRootGlyphContext;
                                            double d40222 = d10;
                                            Matrix matrix5222 = new Matrix();
                                            Matrix matrix6222 = new Matrix();
                                            Matrix matrix7222 = new Matrix();
                                            float[] fArr5222 = new float[9];
                                            float[] fArr6222 = new float[9];
                                            i3 = 0;
                                            while (i3 < i) {
                                            }
                                            tSpanView = tSpanView3;
                                            path = path2;
                                            tSpanView.mCachedPath = path;
                                            popGlyphContext();
                                            return tSpanView.mCachedPath;
                                        }
                                        paint2 = paint;
                                        c = 0;
                                        d10 = 0.0d;
                                        hashCode = str.hashCode();
                                        if (hashCode == -1720785339) {
                                        }
                                        c = 65535;
                                        if (c != 0) {
                                        }
                                        double d402222 = d10;
                                        Matrix matrix52222 = new Matrix();
                                        Matrix matrix62222 = new Matrix();
                                        Matrix matrix72222 = new Matrix();
                                        float[] fArr52222 = new float[9];
                                        float[] fArr62222 = new float[9];
                                        i3 = 0;
                                        while (i3 < i) {
                                        }
                                        tSpanView = tSpanView3;
                                        path = path2;
                                        tSpanView.mCachedPath = path;
                                        popGlyphContext();
                                        return tSpanView.mCachedPath;
                                    }
                                } else {
                                    d8 = d;
                                    d24 = d28;
                                }
                                d28 = d24;
                                d7 = 1.0d;
                                double d312 = (double) i2;
                                Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
                                double d322 = d7 * d312;
                                double d332 = (double) fontMetrics2.descent;
                                float f2 = fontMetrics2.leading;
                                double d342 = ((double) f2) + d332;
                                int i122 = i2;
                                double d352 = (double) ((-fontMetrics2.ascent) + f2);
                                double d362 = d312;
                                double d372 = (double) (-fontMetrics2.top);
                                double d382 = d372 + d342;
                                if (tSpanView3.mBaselineShift == null) {
                                }
                                str = tSpanView3.mBaselineShift;
                                if (tSpanView3.mAlignmentBaseline == null) {
                                }
                                d9 = d372;
                                if (tSpanView3.mAlignmentBaseline == null) {
                                }
                                textProperties$AlignmentBaseline = tSpanView3.mAlignmentBaseline;
                                if (textProperties$AlignmentBaseline != null) {
                                }
                                paint2 = paint;
                                c = 0;
                                d10 = 0.0d;
                                hashCode = str.hashCode();
                                if (hashCode == -1720785339) {
                                }
                                c = 65535;
                                if (c != 0) {
                                }
                                double d4022222 = d10;
                                Matrix matrix522222 = new Matrix();
                                Matrix matrix622222 = new Matrix();
                                Matrix matrix722222 = new Matrix();
                                float[] fArr522222 = new float[9];
                                float[] fArr622222 = new float[9];
                                i3 = 0;
                                while (i3 < i) {
                                }
                                tSpanView = tSpanView3;
                                path = path2;
                                tSpanView.mCachedPath = path;
                                popGlyphContext();
                                return tSpanView.mCachedPath;
                            }
                        } else {
                            z2 = z8;
                            arrayList2 = arrayList4;
                            fArr = fArr4;
                            z6 = false;
                            i9 = 1;
                        }
                        z3 = z6;
                        d5 = d;
                        d6 = d3;
                        d4 = 0.0d;
                        i2 = i9;
                        sVGLength = tSpanView3.mTextLength;
                        if (sVGLength == null) {
                        }
                        d28 = d24;
                        d7 = 1.0d;
                        double d3122 = (double) i2;
                        Paint.FontMetrics fontMetrics22 = paint.getFontMetrics();
                        double d3222 = d7 * d3122;
                        double d3322 = (double) fontMetrics22.descent;
                        float f22 = fontMetrics22.leading;
                        double d3422 = ((double) f22) + d3322;
                        int i1222 = i2;
                        double d3522 = (double) ((-fontMetrics22.ascent) + f22);
                        double d3622 = d3122;
                        double d3722 = (double) (-fontMetrics22.top);
                        double d3822 = d3722 + d3422;
                        if (tSpanView3.mBaselineShift == null) {
                        }
                        str = tSpanView3.mBaselineShift;
                        if (tSpanView3.mAlignmentBaseline == null) {
                        }
                        d9 = d3722;
                        if (tSpanView3.mAlignmentBaseline == null) {
                        }
                        textProperties$AlignmentBaseline = tSpanView3.mAlignmentBaseline;
                        if (textProperties$AlignmentBaseline != null) {
                        }
                        paint2 = paint;
                        c = 0;
                        d10 = 0.0d;
                        hashCode = str.hashCode();
                        if (hashCode == -1720785339) {
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        double d40222222 = d10;
                        Matrix matrix5222222 = new Matrix();
                        Matrix matrix6222222 = new Matrix();
                        Matrix matrix7222222 = new Matrix();
                        float[] fArr5222222 = new float[9];
                        float[] fArr6222222 = new float[9];
                        i3 = 0;
                        while (i3 < i) {
                        }
                        tSpanView = tSpanView3;
                        path = path2;
                        tSpanView.mCachedPath = path;
                        popGlyphContext();
                        return tSpanView.mCachedPath;
                    } else {
                        i = length;
                        d3 = -subtreeTextChunksTotalAdvance;
                    }
                    d2 = subtreeTextChunksTotalAdvance;
                    double d292 = textRootGlyphContext.mFontSize;
                    if (z8) {
                    }
                    z3 = z6;
                    d5 = d;
                    d6 = d3;
                    d4 = 0.0d;
                    i2 = i9;
                    sVGLength = tSpanView3.mTextLength;
                    if (sVGLength == null) {
                    }
                    d28 = d24;
                    d7 = 1.0d;
                    double d31222 = (double) i2;
                    Paint.FontMetrics fontMetrics222 = paint.getFontMetrics();
                    double d32222 = d7 * d31222;
                    double d33222 = (double) fontMetrics222.descent;
                    float f222 = fontMetrics222.leading;
                    double d34222 = ((double) f222) + d33222;
                    int i12222 = i2;
                    double d35222 = (double) ((-fontMetrics222.ascent) + f222);
                    double d36222 = d31222;
                    double d37222 = (double) (-fontMetrics222.top);
                    double d38222 = d37222 + d34222;
                    if (tSpanView3.mBaselineShift == null) {
                    }
                    str = tSpanView3.mBaselineShift;
                    if (tSpanView3.mAlignmentBaseline == null) {
                    }
                    d9 = d37222;
                    if (tSpanView3.mAlignmentBaseline == null) {
                    }
                    textProperties$AlignmentBaseline = tSpanView3.mAlignmentBaseline;
                    if (textProperties$AlignmentBaseline != null) {
                    }
                    paint2 = paint;
                    c = 0;
                    d10 = 0.0d;
                    hashCode = str.hashCode();
                    if (hashCode == -1720785339) {
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                    double d402222222 = d10;
                    Matrix matrix52222222 = new Matrix();
                    Matrix matrix62222222 = new Matrix();
                    Matrix matrix72222222 = new Matrix();
                    float[] fArr52222222 = new float[9];
                    float[] fArr62222222 = new float[9];
                    i3 = 0;
                    while (i3 < i) {
                    }
                    tSpanView = tSpanView3;
                    path = path2;
                    tSpanView.mCachedPath = path;
                    popGlyphContext();
                    return tSpanView.mCachedPath;
                }
            } else {
                path2 = path7;
            }
            z = false;
            if (!z) {
            }
            if (Build.VERSION.SDK_INT >= 26) {
            }
            readableMap = fontData.fontData;
            float[] fArr42 = new float[length];
            paint.getTextWidths(str3, fArr42);
            TextProperties$TextAnchor textProperties$TextAnchor2 = fontData.textAnchor;
            arrayList = getTextRootGlyphContext().mFontContext;
            PathMeasure pathMeasure42 = pathMeasure;
            parent = getParent();
            size = arrayList.size() - 1;
            textView = tSpanView3;
            while (size >= 0) {
                textView = (TextView) parent;
                parent = textView.getParent();
                size--;
                arrayList = arrayList;
                readableMap = readableMap;
            }
            double d282 = d27;
            double subtreeTextChunksTotalAdvance2 = textView.getSubtreeTextChunksTotalAdvance(paint);
            ordinal = textProperties$TextAnchor2.ordinal();
            if (ordinal != 1) {
            }
            d2 = subtreeTextChunksTotalAdvance2;
            double d2922 = textRootGlyphContext.mFontSize;
            if (z8) {
            }
            z3 = z6;
            d5 = d;
            d6 = d3;
            d4 = 0.0d;
            i2 = i9;
            sVGLength = tSpanView3.mTextLength;
            if (sVGLength == null) {
            }
            d282 = d24;
            d7 = 1.0d;
            double d312222 = (double) i2;
            Paint.FontMetrics fontMetrics2222 = paint.getFontMetrics();
            double d322222 = d7 * d312222;
            double d332222 = (double) fontMetrics2222.descent;
            float f2222 = fontMetrics2222.leading;
            double d342222 = ((double) f2222) + d332222;
            int i122222 = i2;
            double d352222 = (double) ((-fontMetrics2222.ascent) + f2222);
            double d362222 = d312222;
            double d372222 = (double) (-fontMetrics2222.top);
            double d382222 = d372222 + d342222;
            if (tSpanView3.mBaselineShift == null) {
            }
            str = tSpanView3.mBaselineShift;
            if (tSpanView3.mAlignmentBaseline == null) {
            }
            d9 = d372222;
            if (tSpanView3.mAlignmentBaseline == null) {
            }
            textProperties$AlignmentBaseline = tSpanView3.mAlignmentBaseline;
            if (textProperties$AlignmentBaseline != null) {
            }
            paint2 = paint;
            c = 0;
            d10 = 0.0d;
            hashCode = str.hashCode();
            if (hashCode == -1720785339) {
            }
            c = 65535;
            if (c != 0) {
            }
            double d4022222222 = d10;
            Matrix matrix522222222 = new Matrix();
            Matrix matrix622222222 = new Matrix();
            Matrix matrix722222222 = new Matrix();
            float[] fArr522222222 = new float[9];
            float[] fArr622222222 = new float[9];
            i3 = 0;
            while (i3 < i) {
            }
            tSpanView = tSpanView3;
            path = path2;
            tSpanView.mCachedPath = path;
            popGlyphContext();
            return tSpanView.mCachedPath;
        }
        tSpanView = tSpanView3;
        path = path7;
        tSpanView.mCachedPath = path;
        popGlyphContext();
        return tSpanView.mCachedPath;
    }

    @Override // com.horcrux.svg.TextView
    public double getSubtreeTextChunksTotalAdvance(Paint paint) {
        if (!Double.isNaN(this.cachedAdvance)) {
            return this.cachedAdvance;
        }
        String str = this.mContent;
        double d = 0.0d;
        if (str == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    d = ((TextView) childAt).getSubtreeTextChunksTotalAdvance(paint) + d;
                }
            }
            this.cachedAdvance = d;
            return d;
        } else if (str.length() == 0) {
            this.cachedAdvance = 0.0d;
            return 0.0d;
        } else {
            FontData fontData = getTextRootGlyphContext().topFont;
            applyTextPropertiesToPaint(paint, fontData);
            applySpacingAndFeatures(paint, fontData);
            double measureText = (double) paint.measureText(str);
            this.cachedAdvance = measureText;
            return measureText;
        }
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView, com.horcrux.svg.GroupView
    public int hitTest(float[] fArr) {
        Region region;
        if (this.mContent == null) {
            return super.hitTest(fArr);
        }
        if (((VirtualView) this).mPath != null && this.mInvertible && this.mTransformInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            int round = Math.round(fArr2[0]);
            int round2 = Math.round(fArr2[1]);
            initBounds();
            Region region2 = this.mRegion;
            if ((region2 != null && region2.contains(round, round2)) || ((region = this.mStrokeRegion) != null && region.contains(round, round2))) {
                if (getClipPath() == null || this.mClipRegion.contains(round, round2)) {
                    return getId();
                }
                return -1;
            }
        }
        return -1;
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.TextView
    public void invalidate() {
        this.mCachedPath = null;
        super.invalidate();
    }

    @ReactProp(name = "content")
    public void setContent(String str) {
        this.mContent = str;
        invalidate();
    }
}
