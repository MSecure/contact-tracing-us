package f.b.a.d.r;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public final class b implements j {
    public RectF a = new RectF();
    public int b = 1;

    @Override // f.b.a.d.r.j
    public int a(s sVar) {
        return (sVar.f2740h * 2) + (sVar.f2741i * 2) + sVar.b;
    }

    @Override // f.b.a.d.r.j
    public int b(s sVar) {
        return (sVar.f2740h * 2) + (sVar.f2741i * 2) + sVar.b;
    }

    @Override // f.b.a.d.r.j
    public void c(Canvas canvas, s sVar, float f2) {
        int i2 = (sVar.b / 2) + sVar.f2741i + sVar.f2740h;
        float f3 = (float) i2;
        canvas.translate(f3, f3);
        canvas.rotate(-90.0f);
        int i3 = -i2;
        canvas.clipRect(i3, i3, i2, i2);
        float f4 = (float) sVar.f2741i;
        int i4 = sVar.f2739g;
        int i5 = 1;
        if (i4 == 1) {
            f4 += ((1.0f - f2) * ((float) sVar.b)) / 2.0f;
        } else if (i4 == 2) {
            f4 -= ((1.0f - f2) * ((float) sVar.b)) / 2.0f;
        }
        float f5 = -f4;
        this.a = new RectF(f5, f5, f4, f4);
        if (sVar.f2738f) {
            i5 = -1;
        }
        this.b = i5;
    }

    @Override // f.b.a.d.r.j
    public void d(Canvas canvas, Paint paint, int i2, float f2, float f3, float f4, float f5) {
        if (f2 != f3) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i2);
            paint.setStrokeWidth(f4);
            float f6 = (float) this.b;
            float f7 = f2 * 360.0f * f6;
            float f8 = (f3 >= f2 ? f3 - f2 : (f3 + 1.0f) - f2) * 360.0f * f6;
            canvas.drawArc(this.a, f7, f8, false, paint);
            if (f5 > 0.0f && Math.abs(f8) < 360.0f) {
                paint.setStyle(Paint.Style.FILL);
                float f9 = -f5;
                RectF rectF = new RectF(f9, f9, f5, f5);
                e(canvas, paint, f4, f5, f7, true, rectF);
                e(canvas, paint, f4, f5, f7 + f8, false, rectF);
            }
        }
    }

    public final void e(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z, RectF rectF) {
        float f5 = z ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f4);
        float f6 = f2 / 2.0f;
        float f7 = f5 * f3;
        canvas.drawRect((this.a.right - f6) + f3, Math.min(0.0f, ((float) this.b) * f7), (this.a.right + f6) - f3, Math.max(0.0f, f7 * ((float) this.b)), paint);
        canvas.translate((this.a.right - f6) + f3, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f5) * 90.0f * ((float) this.b), true, paint);
        canvas.translate(f2 - (f3 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f5 * 90.0f * ((float) this.b), true, paint);
        canvas.restore();
    }
}
