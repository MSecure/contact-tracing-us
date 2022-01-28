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
    public float f3011a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f3012b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f3013c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f3014d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f3015e;
    @Deprecated
    public float f;
    public final List<e> g = new ArrayList();
    public final List<f> h = new ArrayList();
    public boolean i;

    public static class a extends f {

        /* renamed from: b  reason: collision with root package name */
        public final c f3016b;

        public a(c cVar) {
            this.f3016b = cVar;
        }

        @Override // c.b.a.b.h0.m.f
        public void a(Matrix matrix, c.b.a.b.g0.a aVar, int i, Canvas canvas) {
            c cVar = this.f3016b;
            float f = cVar.f;
            float f2 = cVar.g;
            c cVar2 = this.f3016b;
            RectF rectF = new RectF(cVar2.f3020b, cVar2.f3021c, cVar2.f3022d, cVar2.f3023e);
            boolean z = f2 < 0.0f;
            Path path = aVar.g;
            if (z) {
                int[] iArr = c.b.a.b.g0.a.k;
                iArr[0] = 0;
                iArr[1] = aVar.f;
                iArr[2] = aVar.f2977e;
                iArr[3] = aVar.f2976d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f, f2);
                path.close();
                float f3 = (float) (-i);
                rectF.inset(f3, f3);
                int[] iArr2 = c.b.a.b.g0.a.k;
                iArr2[0] = 0;
                iArr2[1] = aVar.f2976d;
                iArr2[2] = aVar.f2977e;
                iArr2[3] = aVar.f;
            }
            float width = 1.0f - (((float) i) / (rectF.width() / 2.0f));
            float[] fArr = c.b.a.b.g0.a.l;
            fArr[1] = width;
            fArr[2] = ((1.0f - width) / 2.0f) + width;
            aVar.f2974b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, c.b.a.b.g0.a.k, c.b.a.b.g0.a.l, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            if (!z) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, aVar.h);
            }
            canvas.drawArc(rectF, f, f2, true, aVar.f2974b);
            canvas.restore();
        }
    }

    public static class b extends f {

        /* renamed from: b  reason: collision with root package name */
        public final d f3017b;

        /* renamed from: c  reason: collision with root package name */
        public final float f3018c;

        /* renamed from: d  reason: collision with root package name */
        public final float f3019d;

        public b(d dVar, float f, float f2) {
            this.f3017b = dVar;
            this.f3018c = f;
            this.f3019d = f2;
        }

        @Override // c.b.a.b.h0.m.f
        public void a(Matrix matrix, c.b.a.b.g0.a aVar, int i, Canvas canvas) {
            d dVar = this.f3017b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (dVar.f3025c - this.f3019d), (double) (dVar.f3024b - this.f3018c)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f3018c, this.f3019d);
            matrix2.preRotate(b());
            if (aVar != null) {
                rectF.bottom += (float) i;
                rectF.offset(0.0f, (float) (-i));
                int[] iArr = c.b.a.b.g0.a.i;
                iArr[0] = aVar.f;
                iArr[1] = aVar.f2977e;
                iArr[2] = aVar.f2976d;
                Paint paint = aVar.f2975c;
                float f = rectF.left;
                paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, c.b.a.b.g0.a.i, c.b.a.b.g0.a.j, Shader.TileMode.CLAMP));
                canvas.save();
                canvas.concat(matrix2);
                canvas.drawRect(rectF, aVar.f2975c);
                canvas.restore();
                return;
            }
            throw null;
        }

        public float b() {
            d dVar = this.f3017b;
            return (float) Math.toDegrees(Math.atan((double) ((dVar.f3025c - this.f3019d) / (dVar.f3024b - this.f3018c))));
        }
    }

    public static class c extends e {
        public static final RectF h = new RectF();
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f3020b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f3021c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f3022d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f3023e;
        @Deprecated
        public float f;
        @Deprecated
        public float g;

        public c(float f2, float f3, float f4, float f5) {
            this.f3020b = f2;
            this.f3021c = f3;
            this.f3022d = f4;
            this.f3023e = f5;
        }

        @Override // c.b.a.b.h0.m.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f3026a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(this.f3020b, this.f3021c, this.f3022d, this.f3023e);
            path.arcTo(h, this.f, this.g, false);
            path.transform(matrix);
        }
    }

    public static class d extends e {

        /* renamed from: b  reason: collision with root package name */
        public float f3024b;

        /* renamed from: c  reason: collision with root package name */
        public float f3025c;

        @Override // c.b.a.b.h0.m.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f3026a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f3024b, this.f3025c);
            path.transform(matrix);
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f3026a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        public static final Matrix f3027a = new Matrix();

        public abstract void a(Matrix matrix, c.b.a.b.g0.a aVar, int i, Canvas canvas);
    }

    public m() {
        e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.f = f6;
        cVar.g = f7;
        this.g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        b(f6);
        this.h.add(aVar);
        this.f3015e = f9;
        double d2 = (double) f8;
        this.f3013c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.f3014d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public final void b(float f2) {
        float f3 = this.f3015e;
        if (f3 != f2) {
            float f4 = ((f2 - f3) + 360.0f) % 360.0f;
            if (f4 <= 180.0f) {
                float f5 = this.f3013c;
                float f6 = this.f3014d;
                c cVar = new c(f5, f6, f5, f6);
                cVar.f = this.f3015e;
                cVar.g = f4;
                this.h.add(new a(cVar));
                this.f3015e = f2;
            }
        }
    }

    public void c(Matrix matrix, Path path) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.g.get(i2).a(matrix, path);
        }
    }

    public void d(float f2, float f3) {
        d dVar = new d();
        dVar.f3024b = f2;
        dVar.f3025c = f3;
        this.g.add(dVar);
        b bVar = new b(dVar, this.f3013c, this.f3014d);
        b(bVar.b() + 270.0f);
        this.h.add(bVar);
        this.f3015e = bVar.b() + 270.0f;
        this.f3013c = f2;
        this.f3014d = f3;
    }

    public void e(float f2, float f3, float f4, float f5) {
        this.f3011a = f2;
        this.f3012b = f3;
        this.f3013c = f2;
        this.f3014d = f3;
        this.f3015e = f4;
        this.f = (f4 + f5) % 360.0f;
        this.g.clear();
        this.h.clear();
        this.i = false;
    }
}
