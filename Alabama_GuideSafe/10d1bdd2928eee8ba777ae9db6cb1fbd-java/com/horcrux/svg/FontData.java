package com.horcrux.svg;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.devsupport.FpsView;
import com.google.common.util.concurrent.MoreExecutors;

public class FontData {
    public static final FontData Defaults = new FontData();
    public int absoluteFontWeight;
    public final ReadableMap fontData;
    public final String fontFamily;
    public final String fontFeatureSettings;
    public final double fontSize;
    public final TextProperties$FontStyle fontStyle;
    public final TextProperties$FontVariantLigatures fontVariantLigatures;
    public final String fontVariationSettings;
    public TextProperties$FontWeight fontWeight;
    public final double kerning;
    public final double letterSpacing;
    public final boolean manualKerning;
    public final TextProperties$TextAnchor textAnchor;
    public final TextProperties$TextDecoration textDecoration;
    public final double wordSpacing;

    public static class AbsoluteFontWeight {
        public static final TextProperties$FontWeight[] WEIGHTS;
        public static final int[] absoluteFontWeights = {400, 700, 100, 200, 300, 400, FpsView.UPDATE_INTERVAL_MS, 600, 700, 800, 900};

        static {
            TextProperties$FontWeight textProperties$FontWeight = TextProperties$FontWeight.w100;
            TextProperties$FontWeight textProperties$FontWeight2 = TextProperties$FontWeight.w900;
            WEIGHTS = new TextProperties$FontWeight[]{textProperties$FontWeight, textProperties$FontWeight, TextProperties$FontWeight.w200, TextProperties$FontWeight.w300, TextProperties$FontWeight.Normal, TextProperties$FontWeight.w500, TextProperties$FontWeight.w600, TextProperties$FontWeight.Bold, TextProperties$FontWeight.w800, textProperties$FontWeight2, textProperties$FontWeight2};
        }

        public static int from(TextProperties$FontWeight textProperties$FontWeight, FontData fontData) {
            if (textProperties$FontWeight == TextProperties$FontWeight.Bolder) {
                int i = fontData.absoluteFontWeight;
                if (i < 350) {
                    return 400;
                }
                if (i < 550) {
                    return 700;
                }
                if (i < 900) {
                    return 900;
                }
                return i;
            } else if (textProperties$FontWeight != TextProperties$FontWeight.Lighter) {
                return absoluteFontWeights[textProperties$FontWeight.ordinal()];
            } else {
                int i2 = fontData.absoluteFontWeight;
                if (i2 < 100) {
                    return i2;
                }
                if (i2 < 550) {
                    return 100;
                }
                return i2 < 750 ? 400 : 700;
            }
        }
    }

    public FontData() {
        this.fontData = null;
        this.fontFamily = "";
        this.fontStyle = TextProperties$FontStyle.normal;
        this.fontWeight = TextProperties$FontWeight.Normal;
        this.absoluteFontWeight = 400;
        this.fontFeatureSettings = "";
        this.fontVariationSettings = "";
        this.fontVariantLigatures = TextProperties$FontVariantLigatures.normal;
        this.textAnchor = TextProperties$TextAnchor.start;
        this.textDecoration = TextProperties$TextDecoration.None;
        this.manualKerning = false;
        this.kerning = 0.0d;
        this.fontSize = 12.0d;
        this.wordSpacing = 0.0d;
        this.letterSpacing = 0.0d;
    }

    public final void handleNumericWeight(FontData fontData2, double d) {
        long round = Math.round(d);
        if (round < 1 || round > 1000) {
            setInheritedWeight(fontData2);
            return;
        }
        int i = (int) round;
        this.absoluteFontWeight = i;
        this.fontWeight = AbsoluteFontWeight.WEIGHTS[Math.round(((float) i) / 100.0f)];
    }

    public final void setInheritedWeight(FontData fontData2) {
        this.absoluteFontWeight = fontData2.absoluteFontWeight;
        this.fontWeight = fontData2.fontWeight;
    }

    public final double toAbsolute(ReadableMap readableMap, String str, double d, double d2, double d3) {
        if (readableMap.getType(str) == ReadableType.Number) {
            return readableMap.getDouble(str);
        }
        return MoreExecutors.fromRelative(readableMap.getString(str), d3, d, d2);
    }

    public FontData(ReadableMap readableMap, FontData fontData2, double d) {
        TextProperties$TextDecoration textProperties$TextDecoration;
        double d2 = fontData2.fontSize;
        if (readableMap.hasKey("fontSize")) {
            this.fontSize = toAbsolute(readableMap, "fontSize", 1.0d, d2, d2);
        } else {
            this.fontSize = d2;
        }
        if (!readableMap.hasKey("fontWeight")) {
            setInheritedWeight(fontData2);
        } else if (readableMap.getType("fontWeight") == ReadableType.Number) {
            handleNumericWeight(fontData2, readableMap.getDouble("fontWeight"));
        } else {
            String string = readableMap.getString("fontWeight");
            if (TextProperties$FontWeight.weightToEnum.containsKey(string)) {
                int from = AbsoluteFontWeight.from(TextProperties$FontWeight.weightToEnum.get(string), fontData2);
                this.absoluteFontWeight = from;
                this.fontWeight = AbsoluteFontWeight.WEIGHTS[Math.round(((float) from) / 100.0f)];
            } else if (string != null) {
                handleNumericWeight(fontData2, Double.parseDouble(string));
            } else {
                setInheritedWeight(fontData2);
            }
        }
        this.fontData = readableMap.hasKey("fontData") ? readableMap.getMap("fontData") : fontData2.fontData;
        this.fontFamily = readableMap.hasKey("fontFamily") ? readableMap.getString("fontFamily") : fontData2.fontFamily;
        this.fontStyle = readableMap.hasKey("fontStyle") ? TextProperties$FontStyle.valueOf(readableMap.getString("fontStyle")) : fontData2.fontStyle;
        this.fontFeatureSettings = readableMap.hasKey("fontFeatureSettings") ? readableMap.getString("fontFeatureSettings") : fontData2.fontFeatureSettings;
        this.fontVariationSettings = readableMap.hasKey("fontVariationSettings") ? readableMap.getString("fontVariationSettings") : fontData2.fontVariationSettings;
        this.fontVariantLigatures = readableMap.hasKey("fontVariantLigatures") ? TextProperties$FontVariantLigatures.valueOf(readableMap.getString("fontVariantLigatures")) : fontData2.fontVariantLigatures;
        this.textAnchor = readableMap.hasKey("textAnchor") ? TextProperties$TextAnchor.valueOf(readableMap.getString("textAnchor")) : fontData2.textAnchor;
        if (readableMap.hasKey("textDecoration")) {
            String string2 = readableMap.getString("textDecoration");
            if (TextProperties$TextDecoration.decorationToEnum.containsKey(string2)) {
                textProperties$TextDecoration = TextProperties$TextDecoration.decorationToEnum.get(string2);
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline10("Unknown String Value: ", string2));
            }
        } else {
            textProperties$TextDecoration = fontData2.textDecoration;
        }
        this.textDecoration = textProperties$TextDecoration;
        boolean hasKey = readableMap.hasKey("kerning");
        this.manualKerning = hasKey || fontData2.manualKerning;
        this.kerning = hasKey ? toAbsolute(readableMap, "kerning", d, this.fontSize, 0.0d) : fontData2.kerning;
        this.wordSpacing = readableMap.hasKey("wordSpacing") ? toAbsolute(readableMap, "wordSpacing", d, this.fontSize, 0.0d) : fontData2.wordSpacing;
        this.letterSpacing = readableMap.hasKey("letterSpacing") ? toAbsolute(readableMap, "letterSpacing", d, this.fontSize, 0.0d) : fontData2.letterSpacing;
    }
}
