package f.b.a.e.u;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import f.b.a.e.u.g;
import f.b.a.e.u.m;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Objects;

public class k {
    public final m[] a = new m[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    public final PointF f2998d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    public final Path f2999e = new Path();

    /* renamed from: f  reason: collision with root package name */
    public final Path f3000f = new Path();

    /* renamed from: g  reason: collision with root package name */
    public final m f3001g = new m();

    /* renamed from: h  reason: collision with root package name */
    public final float[] f3002h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    public final float[] f3003i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    public final Path f3004j = new Path();

    /* renamed from: k  reason: collision with root package name */
    public final Path f3005k = new Path();

    /* renamed from: l  reason: collision with root package name */
    public boolean f3006l = true;

    public static class a {
        public static final k a = new k();
    }

    public interface b {
    }

    public k() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.a[i2] = new m();
            this.b[i2] = new Matrix();
            this.c[i2] = new Matrix();
        }
    }

    public void a(j jVar, float f2, RectF rectF, b bVar, Path path) {
        float f3;
        float f4;
        f fVar;
        Path path2;
        Matrix matrix;
        m mVar;
        c cVar;
        d dVar;
        float f5;
        float f6;
        path.rewind();
        this.f2999e.rewind();
        this.f3000f.rewind();
        this.f3000f.addRect(rectF, Path.Direction.CW);
        int i2 = 0;
        while (i2 < 4) {
            if (i2 == 1) {
                cVar = jVar.f2983g;
            } else if (i2 == 2) {
                cVar = jVar.f2984h;
            } else if (i2 != 3) {
                cVar = jVar.f2982f;
            } else {
                cVar = jVar.f2981e;
            }
            if (i2 == 1) {
                dVar = jVar.c;
            } else if (i2 == 2) {
                dVar = jVar.f2980d;
            } else if (i2 != 3) {
                dVar = jVar.b;
            } else {
                dVar = jVar.a;
            }
            m mVar2 = this.a[i2];
            Objects.requireNonNull(dVar);
            dVar.a(mVar2, 90.0f, f2, cVar.a(rectF));
            int i3 = i2 + 1;
            float f7 = (float) (i3 * 90);
            this.b[i2].reset();
            PointF pointF = this.f2998d;
            if (i2 == 1) {
                f6 = rectF.right;
            } else if (i2 != 2) {
                f6 = i2 != 3 ? rectF.right : rectF.left;
                f5 = rectF.top;
                pointF.set(f6, f5);
                Matrix matrix2 = this.b[i2];
                PointF pointF2 = this.f2998d;
                matrix2.setTranslate(pointF2.x, pointF2.y);
                this.b[i2].preRotate(f7);
                float[] fArr = this.f3002h;
                m[] mVarArr = this.a;
                fArr[0] = mVarArr[i2].c;
                fArr[1] = mVarArr[i2].f3007d;
                this.b[i2].mapPoints(fArr);
                this.c[i2].reset();
                Matrix matrix3 = this.c[i2];
                float[] fArr2 = this.f3002h;
                matrix3.setTranslate(fArr2[0], fArr2[1]);
                this.c[i2].preRotate(f7);
                i2 = i3;
            } else {
                f6 = rectF.left;
            }
            f5 = rectF.bottom;
            pointF.set(f6, f5);
            Matrix matrix22 = this.b[i2];
            PointF pointF22 = this.f2998d;
            matrix22.setTranslate(pointF22.x, pointF22.y);
            this.b[i2].preRotate(f7);
            float[] fArr3 = this.f3002h;
            m[] mVarArr2 = this.a;
            fArr3[0] = mVarArr2[i2].c;
            fArr3[1] = mVarArr2[i2].f3007d;
            this.b[i2].mapPoints(fArr3);
            this.c[i2].reset();
            Matrix matrix32 = this.c[i2];
            float[] fArr22 = this.f3002h;
            matrix32.setTranslate(fArr22[0], fArr22[1]);
            this.c[i2].preRotate(f7);
            i2 = i3;
        }
        int i4 = 0;
        while (i4 < 4) {
            float[] fArr4 = this.f3002h;
            m[] mVarArr3 = this.a;
            fArr4[0] = mVarArr3[i4].a;
            fArr4[1] = mVarArr3[i4].b;
            this.b[i4].mapPoints(fArr4);
            float[] fArr5 = this.f3002h;
            if (i4 == 0) {
                path.moveTo(fArr5[0], fArr5[1]);
            } else {
                path.lineTo(fArr5[0], fArr5[1]);
            }
            this.a[i4].c(this.b[i4], path);
            if (bVar != null) {
                m mVar3 = this.a[i4];
                Matrix matrix4 = this.b[i4];
                g.a aVar = (g.a) bVar;
                BitSet bitSet = g.this.f2963e;
                Objects.requireNonNull(mVar3);
                bitSet.set(i4, false);
                m.f[] fVarArr = g.this.c;
                mVar3.b(mVar3.f3009f);
                fVarArr[i4] = new l(mVar3, new ArrayList(mVar3.f3011h), new Matrix(matrix4));
            }
            int i5 = i4 + 1;
            int i6 = i5 % 4;
            float[] fArr6 = this.f3002h;
            m[] mVarArr4 = this.a;
            fArr6[0] = mVarArr4[i4].c;
            fArr6[1] = mVarArr4[i4].f3007d;
            this.b[i4].mapPoints(fArr6);
            float[] fArr7 = this.f3003i;
            m[] mVarArr5 = this.a;
            fArr7[0] = mVarArr5[i6].a;
            fArr7[1] = mVarArr5[i6].b;
            this.b[i6].mapPoints(fArr7);
            float[] fArr8 = this.f3002h;
            float f8 = fArr8[0];
            float[] fArr9 = this.f3003i;
            float max = Math.max(((float) Math.hypot((double) (f8 - fArr9[0]), (double) (fArr8[1] - fArr9[1]))) - 0.001f, 0.0f);
            float[] fArr10 = this.f3002h;
            m[] mVarArr6 = this.a;
            fArr10[0] = mVarArr6[i4].c;
            fArr10[1] = mVarArr6[i4].f3007d;
            this.b[i4].mapPoints(fArr10);
            if (i4 == 1 || i4 == 3) {
                f4 = rectF.centerX();
                f3 = this.f3002h[0];
            } else {
                f4 = rectF.centerY();
                f3 = this.f3002h[1];
            }
            float abs = Math.abs(f4 - f3);
            this.f3001g.e(0.0f, 0.0f, 270.0f, 0.0f);
            if (i4 == 1) {
                fVar = jVar.f2987k;
            } else if (i4 == 2) {
                fVar = jVar.f2988l;
            } else if (i4 != 3) {
                fVar = jVar.f2986j;
            } else {
                fVar = jVar.f2985i;
            }
            fVar.a(max, abs, f2, this.f3001g);
            this.f3004j.reset();
            this.f3001g.c(this.c[i4], this.f3004j);
            if (!this.f3006l || (!b(this.f3004j, i4) && !b(this.f3004j, i6))) {
                mVar = this.f3001g;
                matrix = this.c[i4];
                path2 = path;
            } else {
                Path path3 = this.f3004j;
                path3.op(path3, this.f3000f, Path.Op.DIFFERENCE);
                float[] fArr11 = this.f3002h;
                m mVar4 = this.f3001g;
                fArr11[0] = mVar4.a;
                fArr11[1] = mVar4.b;
                this.c[i4].mapPoints(fArr11);
                Path path4 = this.f2999e;
                float[] fArr12 = this.f3002h;
                path4.moveTo(fArr12[0], fArr12[1]);
                mVar = this.f3001g;
                matrix = this.c[i4];
                path2 = this.f2999e;
            }
            mVar.c(matrix, path2);
            if (bVar != null) {
                m mVar5 = this.f3001g;
                Matrix matrix5 = this.c[i4];
                g.a aVar2 = (g.a) bVar;
                Objects.requireNonNull(mVar5);
                g.this.f2963e.set(i4 + 4, false);
                m.f[] fVarArr2 = g.this.f2962d;
                mVar5.b(mVar5.f3009f);
                fVarArr2[i4] = new l(mVar5, new ArrayList(mVar5.f3011h), new Matrix(matrix5));
            }
            i4 = i5;
        }
        path.close();
        this.f2999e.close();
        if (!this.f2999e.isEmpty()) {
            path.op(this.f2999e, Path.Op.UNION);
        }
    }

    public final boolean b(Path path, int i2) {
        this.f3005k.reset();
        this.a[i2].c(this.b[i2], this.f3005k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f3005k.computeBounds(rectF, true);
        path.op(this.f3005k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
