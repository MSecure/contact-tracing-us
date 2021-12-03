package f.b.a.e.q;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import f.b.a.c.b.o.b;

public final class d extends m<h> {
    public int c = 1;

    /* renamed from: d  reason: collision with root package name */
    public float f2920d;

    /* renamed from: e  reason: collision with root package name */
    public float f2921e;

    /* renamed from: f  reason: collision with root package name */
    public float f2922f;

    public d(h hVar) {
        super(hVar);
    }

    @Override // f.b.a.e.q.m
    public void a(Canvas canvas, Paint paint, float f2, float f3, int i2) {
        if (f2 != f3) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i2);
            paint.setStrokeWidth(this.f2920d);
            float f4 = (float) this.c;
            float f5 = f2 * 360.0f * f4;
            if (f3 < f2) {
                f3 += 1.0f;
            }
            float f6 = (f3 - f2) * 360.0f * f4;
            float f7 = this.f2922f;
            float f8 = -f7;
            canvas.drawArc(new RectF(f8, f8, f7, f7), f5, f6, false, paint);
            if (this.f2921e > 0.0f && Math.abs(f6) < 360.0f) {
                paint.setStyle(Paint.Style.FILL);
                float f9 = this.f2921e;
                float f10 = -f9;
                RectF rectF = new RectF(f10, f10, f9, f9);
                f(canvas, paint, this.f2920d, this.f2921e, f5, true, rectF);
                f(canvas, paint, this.f2920d, this.f2921e, f5 + f6, false, rectF);
            }
        }
    }

    @Override // f.b.a.e.q.m
    public void b(Canvas canvas, Paint paint) {
        int H = b.H(((h) this.a).f2917d, this.b.f2943k);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(H);
        paint.setStrokeWidth(this.f2920d);
        float f2 = this.f2922f;
        float f3 = -f2;
        canvas.drawArc(new RectF(f3, f3, f2, f2), 0.0f, 360.0f, false, paint);
    }

    @Override // f.b.a.e.q.m
    public int c() {
        h hVar = (h) this.a;
        return (hVar.f2933h * 2) + hVar.f2932g;
    }

    @Override // f.b.a.e.q.m
    public int d() {
        h hVar = (h) this.a;
        return (hVar.f2933h * 2) + hVar.f2932g;
    }

    public final void f(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z, RectF rectF) {
        float f5 = z ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f4);
        float f6 = f2 / 2.0f;
        float f7 = f5 * f3;
        canvas.drawRect((this.f2922f - f6) + f3, Math.min(0.0f, ((float) this.c) * f7), (this.f2922f + f6) - f3, Math.max(0.0f, f7 * ((float) this.c)), paint);
        canvas.translate((this.f2922f - f6) + f3, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f5) * 90.0f * ((float) this.c), true, paint);
        canvas.translate(f2 - (f3 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f5 * 90.0f * ((float) this.c), true, paint);
        canvas.restore();
    }
}
