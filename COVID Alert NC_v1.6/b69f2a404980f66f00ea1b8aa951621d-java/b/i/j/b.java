package b.i.j;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

public class b implements Spannable {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextPaint f1119a;

        /* renamed from: b  reason: collision with root package name */
        public final TextDirectionHeuristic f1120b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1121c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1122d;

        public a(PrecomputedText.Params params) {
            this.f1119a = params.getTextPaint();
            this.f1120b = params.getTextDirection();
            this.f1121c = params.getBreakStrategy();
            this.f1122d = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }

        @SuppressLint({"NewApi"})
        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.f1119a = textPaint;
            this.f1120b = textDirectionHeuristic;
            this.f1121c = i;
            this.f1122d = i2;
        }

        public boolean a(a aVar) {
            if (this.f1121c != aVar.f1121c || this.f1122d != aVar.f1122d || this.f1119a.getTextSize() != aVar.f1119a.getTextSize() || this.f1119a.getTextScaleX() != aVar.f1119a.getTextScaleX() || this.f1119a.getTextSkewX() != aVar.f1119a.getTextSkewX() || this.f1119a.getLetterSpacing() != aVar.f1119a.getLetterSpacing() || !TextUtils.equals(this.f1119a.getFontFeatureSettings(), aVar.f1119a.getFontFeatureSettings()) || this.f1119a.getFlags() != aVar.f1119a.getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f1119a.getTextLocales().equals(aVar.f1119a.getTextLocales())) {
                    return false;
                }
            } else if (!this.f1119a.getTextLocale().equals(aVar.f1119a.getTextLocale())) {
                return false;
            }
            if (this.f1119a.getTypeface() == null) {
                if (aVar.f1119a.getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f1119a.getTypeface().equals(aVar.f1119a.getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f1120b == aVar.f1120b;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Objects.hash(Float.valueOf(this.f1119a.getTextSize()), Float.valueOf(this.f1119a.getTextScaleX()), Float.valueOf(this.f1119a.getTextSkewX()), Float.valueOf(this.f1119a.getLetterSpacing()), Integer.valueOf(this.f1119a.getFlags()), this.f1119a.getTextLocales(), this.f1119a.getTypeface(), Boolean.valueOf(this.f1119a.isElegantTextHeight()), this.f1120b, Integer.valueOf(this.f1121c), Integer.valueOf(this.f1122d));
            }
            return Objects.hash(Float.valueOf(this.f1119a.getTextSize()), Float.valueOf(this.f1119a.getTextScaleX()), Float.valueOf(this.f1119a.getTextSkewX()), Float.valueOf(this.f1119a.getLetterSpacing()), Integer.valueOf(this.f1119a.getFlags()), this.f1119a.getTextLocale(), this.f1119a.getTypeface(), Boolean.valueOf(this.f1119a.isElegantTextHeight()), this.f1120b, Integer.valueOf(this.f1121c), Integer.valueOf(this.f1122d));
        }

        public String toString() {
            Object obj;
            StringBuilder sb;
            StringBuilder sb2 = new StringBuilder("{");
            StringBuilder g = c.a.a.a.a.g("textSize=");
            g.append(this.f1119a.getTextSize());
            sb2.append(g.toString());
            sb2.append(", textScaleX=" + this.f1119a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f1119a.getTextSkewX());
            sb2.append(", letterSpacing=" + this.f1119a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f1119a.isElegantTextHeight());
            if (Build.VERSION.SDK_INT >= 24) {
                sb = c.a.a.a.a.g(", textLocale=");
                obj = this.f1119a.getTextLocales();
            } else {
                sb = c.a.a.a.a.g(", textLocale=");
                obj = this.f1119a.getTextLocale();
            }
            sb.append(obj);
            sb2.append(sb.toString());
            StringBuilder g2 = c.a.a.a.a.g(", typeface=");
            g2.append(this.f1119a.getTypeface());
            sb2.append(g2.toString());
            if (Build.VERSION.SDK_INT >= 26) {
                StringBuilder g3 = c.a.a.a.a.g(", variationSettings=");
                g3.append(this.f1119a.getFontVariationSettings());
                sb2.append(g3.toString());
            }
            StringBuilder g4 = c.a.a.a.a.g(", textDir=");
            g4.append(this.f1120b);
            sb2.append(g4.toString());
            sb2.append(", breakStrategy=" + this.f1121c);
            sb2.append(", hyphenationFrequency=" + this.f1122d);
            sb2.append("}");
            return sb2.toString();
        }
    }

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
        int i3 = Build.VERSION.SDK_INT;
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
        if (!(obj instanceof MetricAffectingSpan)) {
            int i = Build.VERSION.SDK_INT;
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            int i4 = Build.VERSION.SDK_INT;
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public CharSequence subSequence(int i, int i2) {
        throw null;
    }

    public String toString() {
        throw null;
    }
}
