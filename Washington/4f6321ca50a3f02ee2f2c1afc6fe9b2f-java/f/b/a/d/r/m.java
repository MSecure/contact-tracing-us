package f.b.a.d.r;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import f.a.a.a.a;

public final class m implements j {
    public float a = 300.0f;

    public static void e(Canvas canvas, Paint paint, float f2, float f3, float f4, float f5, RectF rectF) {
        canvas.save();
        canvas.translate(f2, f3);
        canvas.drawArc(rectF, f4, f5, true, paint);
        canvas.restore();
    }

    @Override // f.b.a.d.r.j
    public int a(s sVar) {
        return -1;
    }

    @Override // f.b.a.d.r.j
    public int b(s sVar) {
        return sVar.b;
    }

    @Override // f.b.a.d.r.j
    public void c(Canvas canvas, s sVar, float f2) {
        Rect clipBounds = canvas.getClipBounds();
        this.a = (float) clipBounds.width();
        float f3 = (float) sVar.b;
        canvas.translate(((float) clipBounds.width()) / 2.0f, Math.max(0.0f, ((float) (clipBounds.height() - sVar.b)) / 2.0f) + (((float) clipBounds.height()) / 2.0f));
        if (sVar.f2738f) {
            canvas.scale(-1.0f, 1.0f);
        }
        if (sVar.f2739g == 2) {
            canvas.scale(1.0f, -1.0f);
        }
        int i2 = sVar.f2739g;
        if (i2 == 1 || i2 == 2) {
            canvas.translate(0.0f, ((f2 - 1.0f) * ((float) sVar.b)) / 2.0f);
        }
        float f4 = this.a;
        canvas.clipRect((-f4) / 2.0f, (-f3) / 2.0f, f4 / 2.0f, f3 / 2.0f);
    }

    @Override // f.b.a.d.r.j
    public void d(Canvas canvas, Paint paint, int i2, float f2, float f3, float f4, float f5) {
        if (f2 != f3) {
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(i2);
            float f6 = this.a;
            float f7 = f5 * 2.0f;
            float f8 = (-f4) / 2.0f;
            PointF pointF = new PointF(a.a(f6, f7, f2, ((-f6) / 2.0f) + f5), f8 + f5);
            float f9 = this.a;
            float f10 = f4 / 2.0f;
            PointF pointF2 = new PointF(a.a(f9, f7, f3, ((-f9) / 2.0f) + f5), f10 - f5);
            if (f5 > 0.0f) {
                float f11 = -f5;
                RectF rectF = new RectF(f11, f11, f5, f5);
                e(canvas, paint, pointF.x, pointF.y, 180.0f, 90.0f, rectF);
                e(canvas, paint, pointF.x, pointF2.y, 180.0f, -90.0f, rectF);
                e(canvas, paint, pointF2.x, pointF.y, 0.0f, -90.0f, rectF);
                e(canvas, paint, pointF2.x, pointF2.y, 0.0f, 90.0f, rectF);
                if (f4 > f7) {
                    float f12 = pointF.x;
                    canvas.drawRect(f12 - f5, pointF.y, f12, pointF2.y, paint);
                    float f13 = pointF2.x;
                    canvas.drawRect(f13, pointF.y, f13 + f5, pointF2.y, paint);
                }
            }
            canvas.drawRect(pointF.x, f8, pointF2.x, f10, paint);
        }
    }
}
