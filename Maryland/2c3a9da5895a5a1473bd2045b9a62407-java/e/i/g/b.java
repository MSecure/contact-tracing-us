package e.i.g;

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
        public final TextPaint a;
        public final TextDirectionHeuristic b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1475d;

        public a(PrecomputedText.Params params) {
            this.a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.f1475d = params.getHyphenationFrequency();
            int i2 = Build.VERSION.SDK_INT;
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            }
            this.a = textPaint;
            this.b = textDirectionHeuristic;
            this.c = i2;
            this.f1475d = i3;
        }

        public boolean a(a aVar) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 && (this.c != aVar.c || this.f1475d != aVar.f1475d)) || this.a.getTextSize() != aVar.a.getTextSize() || this.a.getTextScaleX() != aVar.a.getTextScaleX() || this.a.getTextSkewX() != aVar.a.getTextSkewX() || this.a.getLetterSpacing() != aVar.a.getLetterSpacing() || !TextUtils.equals(this.a.getFontFeatureSettings(), aVar.a.getFontFeatureSettings()) || this.a.getFlags() != aVar.a.getFlags()) {
                return false;
            }
            if (i2 >= 24) {
                if (!this.a.getTextLocales().equals(aVar.a.getTextLocales())) {
                    return false;
                }
            } else if (!this.a.getTextLocale().equals(aVar.a.getTextLocale())) {
                return false;
            }
            if (this.a.getTypeface() == null) {
                if (aVar.a.getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.a.getTypeface().equals(aVar.a.getTypeface())) {
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
            return a(aVar) && this.b == aVar.b;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Objects.hash(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.f1475d));
            }
            return Objects.hash(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.f1475d));
        }

        public String toString() {
            Object obj;
            StringBuilder sb;
            StringBuilder sb2 = new StringBuilder("{");
            StringBuilder h2 = f.a.a.a.a.h("textSize=");
            h2.append(this.a.getTextSize());
            sb2.append(h2.toString());
            sb2.append(", textScaleX=" + this.a.getTextScaleX());
            sb2.append(", textSkewX=" + this.a.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            StringBuilder h3 = f.a.a.a.a.h(", letterSpacing=");
            h3.append(this.a.getLetterSpacing());
            sb2.append(h3.toString());
            sb2.append(", elegantTextHeight=" + this.a.isElegantTextHeight());
            if (i2 >= 24) {
                sb = f.a.a.a.a.h(", textLocale=");
                obj = this.a.getTextLocales();
            } else {
                sb = f.a.a.a.a.h(", textLocale=");
                obj = this.a.getTextLocale();
            }
            sb.append(obj);
            sb2.append(sb.toString());
            StringBuilder h4 = f.a.a.a.a.h(", typeface=");
            h4.append(this.a.getTypeface());
            sb2.append(h4.toString());
            if (i2 >= 26) {
                StringBuilder h5 = f.a.a.a.a.h(", variationSettings=");
                h5.append(this.a.getFontVariationSettings());
                sb2.append(h5.toString());
            }
            StringBuilder h6 = f.a.a.a.a.h(", textDir=");
            h6.append(this.b);
            sb2.append(h6.toString());
            sb2.append(", breakStrategy=" + this.c);
            sb2.append(", hyphenationFrequency=" + this.f1475d);
            sb2.append("}");
            return sb2.toString();
        }
    }

    public char charAt(int i2) {
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
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        int i4 = Build.VERSION.SDK_INT;
        throw null;
    }

    public int length() {
        throw null;
    }

    public int nextSpanTransition(int i2, int i3, Class cls) {
        throw null;
    }

    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            int i2 = Build.VERSION.SDK_INT;
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (!(obj instanceof MetricAffectingSpan)) {
            int i5 = Build.VERSION.SDK_INT;
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public CharSequence subSequence(int i2, int i3) {
        throw null;
    }

    public String toString() {
        throw null;
    }
}
