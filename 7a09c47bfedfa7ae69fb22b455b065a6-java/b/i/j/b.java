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
        public final TextPaint f1829a;

        /* renamed from: b  reason: collision with root package name */
        public final TextDirectionHeuristic f1830b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1831c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1832d;

        public a(PrecomputedText.Params params) {
            this.f1829a = params.getTextPaint();
            this.f1830b = params.getTextDirection();
            this.f1831c = params.getBreakStrategy();
            this.f1832d = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }

        @SuppressLint({"NewApi"})
        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.f1829a = textPaint;
            this.f1830b = textDirectionHeuristic;
            this.f1831c = i;
            this.f1832d = i2;
        }

        public boolean a(a aVar) {
            if (this.f1831c != aVar.f1831c || this.f1832d != aVar.f1832d || this.f1829a.getTextSize() != aVar.f1829a.getTextSize() || this.f1829a.getTextScaleX() != aVar.f1829a.getTextScaleX() || this.f1829a.getTextSkewX() != aVar.f1829a.getTextSkewX() || this.f1829a.getLetterSpacing() != aVar.f1829a.getLetterSpacing() || !TextUtils.equals(this.f1829a.getFontFeatureSettings(), aVar.f1829a.getFontFeatureSettings()) || this.f1829a.getFlags() != aVar.f1829a.getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f1829a.getTextLocales().equals(aVar.f1829a.getTextLocales())) {
                    return false;
                }
            } else if (!this.f1829a.getTextLocale().equals(aVar.f1829a.getTextLocale())) {
                return false;
            }
            if (this.f1829a.getTypeface() == null) {
                if (aVar.f1829a.getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f1829a.getTypeface().equals(aVar.f1829a.getTypeface())) {
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
            return a(aVar) && this.f1830b == aVar.f1830b;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Objects.hash(Float.valueOf(this.f1829a.getTextSize()), Float.valueOf(this.f1829a.getTextScaleX()), Float.valueOf(this.f1829a.getTextSkewX()), Float.valueOf(this.f1829a.getLetterSpacing()), Integer.valueOf(this.f1829a.getFlags()), this.f1829a.getTextLocales(), this.f1829a.getTypeface(), Boolean.valueOf(this.f1829a.isElegantTextHeight()), this.f1830b, Integer.valueOf(this.f1831c), Integer.valueOf(this.f1832d));
            }
            return Objects.hash(Float.valueOf(this.f1829a.getTextSize()), Float.valueOf(this.f1829a.getTextScaleX()), Float.valueOf(this.f1829a.getTextSkewX()), Float.valueOf(this.f1829a.getLetterSpacing()), Integer.valueOf(this.f1829a.getFlags()), this.f1829a.getTextLocale(), this.f1829a.getTypeface(), Boolean.valueOf(this.f1829a.isElegantTextHeight()), this.f1830b, Integer.valueOf(this.f1831c), Integer.valueOf(this.f1832d));
        }

        public String toString() {
            Object obj;
            StringBuilder sb;
            StringBuilder sb2 = new StringBuilder("{");
            StringBuilder h = c.a.a.a.a.h("textSize=");
            h.append(this.f1829a.getTextSize());
            sb2.append(h.toString());
            sb2.append(", textScaleX=" + this.f1829a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f1829a.getTextSkewX());
            sb2.append(", letterSpacing=" + this.f1829a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f1829a.isElegantTextHeight());
            if (Build.VERSION.SDK_INT >= 24) {
                sb = c.a.a.a.a.h(", textLocale=");
                obj = this.f1829a.getTextLocales();
            } else {
                sb = c.a.a.a.a.h(", textLocale=");
                obj = this.f1829a.getTextLocale();
            }
            sb.append(obj);
            sb2.append(sb.toString());
            StringBuilder h2 = c.a.a.a.a.h(", typeface=");
            h2.append(this.f1829a.getTypeface());
            sb2.append(h2.toString());
            if (Build.VERSION.SDK_INT >= 26) {
                StringBuilder h3 = c.a.a.a.a.h(", variationSettings=");
                h3.append(this.f1829a.getFontVariationSettings());
                sb2.append(h3.toString());
            }
            StringBuilder h4 = c.a.a.a.a.h(", textDir=");
            h4.append(this.f1830b);
            sb2.append(h4.toString());
            sb2.append(", breakStrategy=" + this.f1831c);
            sb2.append(", hyphenationFrequency=" + this.f1832d);
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
