package f.b.a.e.r;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import f.b.a.c.b.o.b;

public final class d extends m<h> {
    public int c = 1;

    /* renamed from: d  reason: collision with root package name */
    public float f2984d;

    /* renamed from: e  reason: collision with root package name */
    public float f2985e;

    /* renamed from: f  reason: collision with root package name */
    public float f2986f;

    public d(h hVar) {
        super(hVar);
    }

    @Override // f.b.a.e.r.m
    public void a(Canvas canvas, Paint paint, float f2, float f3, int i2) {
        if (f2 != f3) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i2);
            paint.setStrokeWidth(this.f2984d);
            float f4 = (float) this.c;
            float f5 = f2 * 360.0f * f4;
            float f6 = (f3 >= f2 ? f3 - f2 : (1.0f + f3) - f2) * 360.0f * f4;
            float f7 = this.f2986f;
            float f8 = -f7;
            canvas.drawArc(new RectF(f8, f8, f7, f7), f5, f6, false, paint);
            if (this.f2985e > 0.0f && Math.abs(f6) < 360.0f) {
                paint.setStyle(Paint.Style.FILL);
                f(canvas, paint, this.f2984d, this.f2985e, f5);
                f(canvas, paint, this.f2984d, this.f2985e, f5 + f6);
            }
        }
    }

    @Override // f.b.a.e.r.m
    public void b(Canvas canvas, Paint paint) {
        int H = b.H(((h) this.a).f2981d, this.b.f3007k);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(H);
        paint.setStrokeWidth(this.f2984d);
        float f2 = this.f2986f;
        float f3 = -f2;
        canvas.drawArc(new RectF(f3, f3, f2, f2), 0.0f, 360.0f, false, paint);
    }

    @Override // f.b.a.e.r.m
    public int c() {
        h hVar = (h) this.a;
        return (hVar.f2997h * 2) + hVar.f2996g;
    }

    @Override // f.b.a.e.r.m
    public int d() {
        h hVar = (h) this.a;
        return (hVar.f2997h * 2) + hVar.f2996g;
    }

    public final void f(Canvas canvas, Paint paint, float f2, float f3, float f4) {
        canvas.save();
        canvas.rotate(f4);
        float f5 = this.f2986f;
        float f6 = f2 / 2.0f;
        canvas.drawRoundRect(new RectF(f5 - f6, f3, f5 + f6, -f3), f3, f3, paint);
        canvas.restore();
    }
}
