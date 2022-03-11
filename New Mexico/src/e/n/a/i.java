package e.n.a;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import e.b.a.m;
import e.n.a.n.a;
/* loaded from: classes.dex */
public abstract class i extends ReplacementSpan {
    public final g c;
    public final Paint.FontMetricsInt b = new Paint.FontMetricsInt();

    /* renamed from: d */
    public short f1730d = -1;

    /* renamed from: e */
    public float f1731e = 1.0f;

    public i(g gVar) {
        m.e.q(gVar, "metadata cannot be null");
        this.c = gVar;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.b);
        Paint.FontMetricsInt fontMetricsInt2 = this.b;
        this.f1731e = (((float) Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent)) * 1.0f) / ((float) this.c.c());
        this.c.c();
        a e2 = this.c.e();
        int a = e2.a(12);
        short s = (short) ((int) (((float) (a != 0 ? e2.b.getShort(a + e2.a) : 0)) * this.f1731e));
        this.f1730d = s;
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
