package c.b.a.b.h0;

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

public class m {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f4300a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f4301b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f4302c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f4303d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f4304e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f4305f;

    /* renamed from: g  reason: collision with root package name */
    public final List<e> f4306g = new ArrayList();
    public final List<f> h = new ArrayList();
    public boolean i;

    public static class a extends f {

        /* renamed from: b  reason: collision with root package name */
        public final c f4307b;

        public a(c cVar) {
            this.f4307b = cVar;
        }

        @Override // c.b.a.b.h0.m.f
        public void a(Matrix matrix, c.b.a.b.g0.a aVar, int i, Canvas canvas) {
            c cVar = this.f4307b;
            float f2 = cVar.f4315f;
            float f3 = cVar.f4316g;
            c cVar2 = this.f4307b;
            RectF rectF = new RectF(cVar2.f4311b, cVar2.f4312c, cVar2.f4313d, cVar2.f4314e);
            boolean z = f3 < 0.0f;
            Path path = aVar.f4256g;
            if (z) {
                int[] iArr = c.b.a.b.g0.a.k;
                iArr[0] = 0;
                iArr[1] = aVar.f4255f;
                iArr[2] = aVar.f4254e;
                iArr[3] = aVar.f4253d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f2, f3);
                path.close();
                float f4 = (float) (-i);
                rectF.inset(f4, f4);
                int[] iArr2 = c.b.a.b.g0.a.k;
                iArr2[0] = 0;
                iArr2[1] = aVar.f4253d;
                iArr2[2] = aVar.f4254e;
                iArr2[3] = aVar.f4255f;
            }
            float width = rectF.width() / 2.0f;
            if (width > 0.0f) {
                float f5 = 1.0f - (((float) i) / width);
                float[] fArr = c.b.a.b.g0.a.l;
                fArr[1] = f5;
                fArr[2] = ((1.0f - f5) / 2.0f) + f5;
                aVar.f4251b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, c.b.a.b.g0.a.k, c.b.a.b.g0.a.l, Shader.TileMode.CLAMP));
                canvas.save();
                canvas.concat(matrix);
                if (!z) {
                    canvas.clipPath(path, Region.Op.DIFFERENCE);
                    canvas.drawPath(path, aVar.h);
                }
                canvas.drawArc(rectF, f2, f3, true, aVar.f4251b);
                canvas.restore();
            }
        }
    }

    public static class b extends f {

        /* renamed from: b  reason: collision with root package name */
        public final d f4308b;

        /* renamed from: c  reason: collision with root package name */
        public final float f4309c;

        /* renamed from: d  reason: collision with root package name */
        public final float f4310d;

        public b(d dVar, float f2, float f3) {
            this.f4308b = dVar;
            this.f4309c = f2;
            this.f4310d = f3;
        }

        @Override // c.b.a.b.h0.m.f
        public void a(Matrix matrix, c.b.a.b.g0.a aVar, int i, Canvas canvas) {
            d dVar = this.f4308b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (dVar.f4318c - this.f4310d), (double) (dVar.f4317b - this.f4309c)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f4309c, this.f4310d);
            matrix2.preRotate(b());
            if (aVar != null) {
                rectF.bottom += (float) i;
                rectF.offset(0.0f, (float) (-i));
                int[] iArr = c.b.a.b.g0.a.i;
                iArr[0] = aVar.f4255f;
                iArr[1] = aVar.f4254e;
                iArr[2] = aVar.f4253d;
                Paint paint = aVar.f4252c;
                float f2 = rectF.left;
                paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, c.b.a.b.g0.a.i, c.b.a.b.g0.a.j, Shader.TileMode.CLAMP));
                canvas.save();
                canvas.concat(matrix2);
                canvas.drawRect(rectF, aVar.f4252c);
                canvas.restore();
                return;
            }
            throw null;
        }

        public float b() {
            d dVar = this.f4308b;
            return (float) Math.toDegrees(Math.atan((double) ((dVar.f4318c - this.f4310d) / (dVar.f4317b - this.f4309c))));
        }
    }

    public static class c extends e {
        public static final RectF h = new RectF();
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f4311b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f4312c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f4313d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f4314e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f4315f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public float f4316g;

        public c(float f2, float f3, float f4, float f5) {
            this.f4311b = f2;
            this.f4312c = f3;
            this.f4313d = f4;
            this.f4314e = f5;
        }

        @Override // c.b.a.b.h0.m.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f4319a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(this.f4311b, this.f4312c, this.f4313d, this.f4314e);
            path.arcTo(h, this.f4315f, this.f4316g, false);
            path.transform(matrix);
        }
    }

    public static class d extends e {

        /* renamed from: b  reason: collision with root package name */
        public float f4317b;

        /* renamed from: c  reason: collision with root package name */
        public float f4318c;

        @Override // c.b.a.b.h0.m.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f4319a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f4317b, this.f4318c);
            path.transform(matrix);
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f4319a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        public static final Matrix f4320a = new Matrix();

        public abstract void a(Matrix matrix, c.b.a.b.g0.a aVar, int i, Canvas canvas);
    }

    public m() {
        e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.f4315f = f6;
        cVar.f4316g = f7;
        this.f4306g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        b(f6);
        this.h.add(aVar);
        this.f4304e = f9;
        double d2 = (double) f8;
        this.f4302c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.f4303d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public final void b(float f2) {
        float f3 = this.f4304e;
        if (f3 != f2) {
            float f4 = ((f2 - f3) + 360.0f) % 360.0f;
            if (f4 <= 180.0f) {
                float f5 = this.f4302c;
                float f6 = this.f4303d;
                c cVar = new c(f5, f6, f5, f6);
                cVar.f4315f = this.f4304e;
                cVar.f4316g = f4;
                this.h.add(new a(cVar));
                this.f4304e = f2;
            }
        }
    }

    public void c(Matrix matrix, Path path) {
        int size = this.f4306g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4306g.get(i2).a(matrix, path);
        }
    }

    public void d(float f2, float f3) {
        d dVar = new d();
        dVar.f4317b = f2;
        dVar.f4318c = f3;
        this.f4306g.add(dVar);
        b bVar = new b(dVar, this.f4302c, this.f4303d);
        b(bVar.b() + 270.0f);
        this.h.add(bVar);
        this.f4304e = bVar.b() + 270.0f;
        this.f4302c = f2;
        this.f4303d = f3;
    }

    public void e(float f2, float f3, float f4, float f5) {
        this.f4300a = f2;
        this.f4301b = f3;
        this.f4302c = f2;
        this.f4303d = f3;
        this.f4304e = f4;
        this.f4305f = (f4 + f5) % 360.0f;
        this.f4306g.clear();
        this.h.clear();
        this.i = false;
    }
}
