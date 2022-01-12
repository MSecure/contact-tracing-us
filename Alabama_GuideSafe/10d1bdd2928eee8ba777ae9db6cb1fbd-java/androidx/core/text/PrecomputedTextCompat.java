package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Objects;

public class PrecomputedTextCompat implements Spannable {
    public char charAt(int i) {
        throw null;
    }

    public int getSpanEnd(Object obj) {
        throw null;
    }

    public int getSpanFlags(Object obj) {
        throw null;
    }

    public int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        throw null;
    }

    public int length() {
        throw null;
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        throw null;
    }

    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        } else {
            throw null;
        }
    }

    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        } else {
            throw null;
        }
    }

    public CharSequence subSequence(int i, int i2) {
        throw null;
    }

    public String toString() {
        throw null;
    }

    public static final class Params {
        public final int mBreakStrategy;
        public final int mHyphenationFrequency;
        public final TextPaint mPaint;
        public final TextDirectionHeuristic mTextDir;

        @SuppressLint({"NewApi"})
        public Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.mPaint = textPaint;
            this.mTextDir = textDirectionHeuristic;
            this.mBreakStrategy = i;
            this.mHyphenationFrequency = i2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return equalsWithoutTextDirection(params) && this.mTextDir == params.mTextDir;
        }

        public boolean equalsWithoutTextDirection(Params params) {
            if (this.mBreakStrategy != params.mBreakStrategy || this.mHyphenationFrequency != params.mHyphenationFrequency || this.mPaint.getTextSize() != params.mPaint.getTextSize() || this.mPaint.getTextScaleX() != params.mPaint.getTextScaleX() || this.mPaint.getTextSkewX() != params.mPaint.getTextSkewX() || this.mPaint.getLetterSpacing() != params.mPaint.getLetterSpacing() || !TextUtils.equals(this.mPaint.getFontFeatureSettings(), params.mPaint.getFontFeatureSettings()) || this.mPaint.getFlags() != params.mPaint.getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.mPaint.getTextLocales().equals(params.mPaint.getTextLocales())) {
                    return false;
                }
            } else if (!this.mPaint.getTextLocale().equals(params.mPaint.getTextLocale())) {
                return false;
            }
            if (this.mPaint.getTypeface() == null) {
                if (params.mPaint.getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.mPaint.getTypeface().equals(params.mPaint.getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Objects.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
            }
            return Objects.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("textSize=");
            outline17.append(this.mPaint.getTextSize());
            sb.append(outline17.toString());
            sb.append(", textScaleX=" + this.mPaint.getTextScaleX());
            sb.append(", textSkewX=" + this.mPaint.getTextSkewX());
            sb.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
            if (Build.VERSION.SDK_INT >= 24) {
                StringBuilder outline172 = GeneratedOutlineSupport.outline17(", textLocale=");
                outline172.append(this.mPaint.getTextLocales());
                sb.append(outline172.toString());
            } else {
                StringBuilder outline173 = GeneratedOutlineSupport.outline17(", textLocale=");
                outline173.append(this.mPaint.getTextLocale());
                sb.append(outline173.toString());
            }
            StringBuilder outline174 = GeneratedOutlineSupport.outline17(", typeface=");
            outline174.append(this.mPaint.getTypeface());
            sb.append(outline174.toString());
            if (Build.VERSION.SDK_INT >= 26) {
                StringBuilder outline175 = GeneratedOutlineSupport.outline17(", variationSettings=");
                outline175.append(this.mPaint.getFontVariationSettings());
                sb.append(outline175.toString());
            }
            StringBuilder outline176 = GeneratedOutlineSupport.outline17(", textDir=");
            outline176.append(this.mTextDir);
            sb.append(outline176.toString());
            sb.append(", breakStrategy=" + this.mBreakStrategy);
            sb.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            sb.append("}");
            return sb.toString();
        }

        public Params(PrecomputedText.Params params) {
            this.mPaint = params.getTextPaint();
            this.mTextDir = params.getTextDirection();
            this.mBreakStrategy = params.getBreakStrategy();
            this.mHyphenationFrequency = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }
    }
}
