package f.b.a.e.q;

import android.graphics.Canvas;
import android.graphics.Paint;
import f.b.a.e.q.c;

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
        float f3 = (((float) hVar.f2932g) / 2.0f) + ((float) hVar.f2933h);
        canvas.translate(f3, f3);
        canvas.rotate(-90.0f);
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        h hVar2 = (h) dVar.a;
        dVar.c = hVar2.f2934i == 0 ? 1 : -1;
        int i2 = hVar2.a;
        dVar.f2920d = ((float) i2) * f2;
        dVar.f2921e = ((float) hVar2.b) * f2;
        dVar.f2922f = ((float) (hVar2.f2932g - i2)) / 2.0f;
        if ((dVar.b.f() && ((h) dVar.a).f2918e == 2) || (dVar.b.e() && ((h) dVar.a).f2919f == 1)) {
            dVar.f2922f = (((1.0f - f2) * ((float) ((h) dVar.a).a)) / 2.0f) + dVar.f2922f;
        } else if ((dVar.b.f() && ((h) dVar.a).f2918e == 1) || (dVar.b.e() && ((h) dVar.a).f2919f == 2)) {
            dVar.f2922f -= ((1.0f - f2) * ((float) ((h) dVar.a).a)) / 2.0f;
        }
    }
}
