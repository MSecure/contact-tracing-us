package f.b.a.d.v;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class m {
    @Deprecated
    public float a;
    @Deprecated
    public float b;
    @Deprecated
    public float c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f2806d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f2807e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f2808f;

    /* renamed from: g  reason: collision with root package name */
    public final List<e> f2809g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final List<f> f2810h = new ArrayList();

    public static class a extends f {
        public final c b;

        public a(c cVar) {
            this.b = cVar;
        }

        @Override // f.b.a.d.v.m.f
        public void a(Matrix matrix, f.b.a.d.u.a aVar, int i2, Canvas canvas) {
            c cVar = this.b;
            float f2 = cVar.f2815f;
            float f3 = cVar.f2816g;
            c cVar2 = this.b;
            RectF rectF = new RectF(cVar2.b, cVar2.c, cVar2.f2813d, cVar2.f2814e);
            int[] iArr = f.b.a.d.u.a.f2754k;
            boolean z = f3 < 0.0f;
            Path path = aVar.f2759g;
            if (z) {
                iArr[0] = 0;
                iArr[1] = aVar.f2758f;
                iArr[2] = aVar.f2757e;
                iArr[3] = aVar.f2756d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f2, f3);
                path.close();
                float f4 = (float) (-i2);
                rectF.inset(f4, f4);
                iArr[0] = 0;
                iArr[1] = aVar.f2756d;
                iArr[2] = aVar.f2757e;
                iArr[3] = aVar.f2758f;
            }
            float width = rectF.width() / 2.0f;
            if (width > 0.0f) {
                float f5 = 1.0f - (((float) i2) / width);
                float[] fArr = f.b.a.d.u.a.f2755l;
                fArr[1] = f5;
                fArr[2] = ((1.0f - f5) / 2.0f) + f5;
                aVar.b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, iArr, fArr, Shader.TileMode.CLAMP));
                canvas.save();
                canvas.concat(matrix);
                if (!z) {
                    canvas.clipPath(path, Region.Op.DIFFERENCE);
                    canvas.drawPath(path, aVar.f2760h);
                }
                canvas.drawArc(rectF, f2, f3, true, aVar.b);
                canvas.restore();
            }
        }
    }

    public static class b extends f {
        public final d b;
        public final float c;

        /* renamed from: d  reason: collision with root package name */
        public final float f2811d;

        public b(d dVar, float f2, float f3) {
            this.b = dVar;
            this.c = f2;
            this.f2811d = f3;
        }

        @Override // f.b.a.d.v.m.f
        public void a(Matrix matrix, f.b.a.d.u.a aVar, int i2, Canvas canvas) {
            d dVar = this.b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (dVar.c - this.f2811d), (double) (dVar.b - this.c)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.c, this.f2811d);
            matrix2.preRotate(b());
            Objects.requireNonNull(aVar);
            rectF.bottom += (float) i2;
            rectF.offset(0.0f, (float) (-i2));
            int[] iArr = f.b.a.d.u.a.f2752i;
            iArr[0] = aVar.f2758f;
            iArr[1] = aVar.f2757e;
            iArr[2] = aVar.f2756d;
            Paint paint = aVar.c;
            float f2 = rectF.left;
            paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, f.b.a.d.u.a.f2753j, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, aVar.c);
            canvas.restore();
        }

        public float b() {
            d dVar = this.b;
            return (float) Math.toDegrees(Math.atan((double) ((dVar.c - this.f2811d) / (dVar.b - this.c))));
        }
    }

    public static class c extends e {

        /* renamed from: h  reason: collision with root package name */
        public static final RectF f2812h = new RectF();
        @Deprecated
        public float b;
        @Deprecated
        public float c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f2813d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f2814e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f2815f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public float f2816g;

        public c(float f2, float f3, float f4, float f5) {
            this.b = f2;
            this.c = f3;
            this.f2813d = f4;
            this.f2814e = f5;
        }

        @Override // f.b.a.d.v.m.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f2812h;
            rectF.set(this.b, this.c, this.f2813d, this.f2814e);
            path.arcTo(rectF, this.f2815f, this.f2816g, false);
            path.transform(matrix);
        }
    }

    public static class d extends e {
        public float b;
        public float c;

        @Override // f.b.a.d.v.m.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.b, this.c);
            path.transform(matrix);
        }
    }

    public static abstract class e {
        public final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static abstract class f {
        public static final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, f.b.a.d.u.a aVar, int i2, Canvas canvas);
    }

    public m() {
        e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.f2815f = f6;
        cVar.f2816g = f7;
        this.f2809g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        b(f6);
        this.f2810h.add(aVar);
        this.f2807e = f9;
        double d2 = (double) f8;
        this.c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.f2806d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public final void b(float f2) {
        float f3 = this.f2807e;
        if (f3 != f2) {
            float f4 = ((f2 - f3) + 360.0f) % 360.0f;
            if (f4 <= 180.0f) {
                float f5 = this.c;
                float f6 = this.f2806d;
                c cVar = new c(f5, f6, f5, f6);
                cVar.f2815f = this.f2807e;
                cVar.f2816g = f4;
                this.f2810h.add(new a(cVar));
                this.f2807e = f2;
            }
        }
    }

    public void c(Matrix matrix, Path path) {
        int size = this.f2809g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2809g.get(i2).a(matrix, path);
        }
    }

    public void d(float f2, float f3) {
        d dVar = new d();
        dVar.b = f2;
        dVar.c = f3;
        this.f2809g.add(dVar);
        b bVar = new b(dVar, this.c, this.f2806d);
        b(bVar.b() + 270.0f);
        this.f2810h.add(bVar);
        this.f2807e = bVar.b() + 270.0f;
        this.c = f2;
        this.f2806d = f3;
    }

    public void e(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f2;
        this.f2806d = f3;
        this.f2807e = f4;
        this.f2808f = (f4 + f5) % 360.0f;
        this.f2809g.clear();
        this.f2810h.clear();
    }
}
