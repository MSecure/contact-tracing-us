package f.b.a.d.r;

import android.graphics.Canvas;
import android.graphics.Paint;
import f.b.a.d.r.c;

public abstract class m<S extends c> {
    public S a;
    public l b;

    public m(S s) {
        this.a = s;
    }

    public abstract void a(Canvas canvas, Paint paint, float f2, float f3, int i2);

    public abstract void b(Canvas canvas, Paint paint);

    public abstract int c();

    public abstract int d();

    public void e(Canvas canvas, float f2) {
        this.a.a();
        d dVar = (d) this;
        h hVar = (h) dVar.a;
        float f3 = (((float) hVar.f2827g) / 2.0f) + ((float) hVar.f2828h);
        canvas.translate(f3, f3);
        canvas.rotate(-90.0f);
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        h hVar2 = (h) dVar.a;
        dVar.c = hVar2.f2829i == 0 ? 1 : -1;
        int i2 = hVar2.a;
        dVar.f2815d = ((float) i2) * f2;
        dVar.f2816e = ((float) hVar2.b) * f2;
        dVar.f2817f = ((float) (hVar2.f2827g - i2)) / 2.0f;
        if ((dVar.b.f() && ((h) dVar.a).f2813e == 2) || (dVar.b.e() && ((h) dVar.a).f2814f == 1)) {
            dVar.f2817f = (((1.0f - f2) * ((float) ((h) dVar.a).a)) / 2.0f) + dVar.f2817f;
        } else if ((dVar.b.f() && ((h) dVar.a).f2813e == 1) || (dVar.b.e() && ((h) dVar.a).f2814f == 2)) {
            dVar.f2817f -= ((1.0f - f2) * ((float) ((h) dVar.a).a)) / 2.0f;
        }
    }
}
