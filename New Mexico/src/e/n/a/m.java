package e.n.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import java.util.Objects;
/* loaded from: classes.dex */
public final class m extends i {
    public m(g gVar) {
        super(gVar);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Objects.requireNonNull(e.a());
        g gVar = this.c;
        Typeface typeface = gVar.b.f1739d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        int i7 = gVar.a * 2;
        canvas.drawText(gVar.b.b, i7, 2, f2, (float) i5, paint);
        paint.setTypeface(typeface2);
    }
}
