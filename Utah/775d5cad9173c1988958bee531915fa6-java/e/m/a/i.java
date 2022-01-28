package e.m.a;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import e.b.a.m;
import e.m.a.n.a;

public abstract class i extends ReplacementSpan {
    public final Paint.FontMetricsInt b = new Paint.FontMetricsInt();
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public short f1645d = -1;

    /* renamed from: e  reason: collision with root package name */
    public float f1646e = 1.0f;

    public i(g gVar) {
        m.e.q(gVar, "metadata cannot be null");
        this.c = gVar;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.b);
        Paint.FontMetricsInt fontMetricsInt2 = this.b;
        this.f1646e = (((float) Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent)) * 1.0f) / ((float) this.c.c());
        this.c.c();
        a e2 = this.c.e();
        int a = e2.a(12);
        short s = (short) ((int) (((float) (a != 0 ? e2.b.getShort(a + e2.a) : 0)) * this.f1646e));
        this.f1645d = s;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.b;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return s;
    }
}
