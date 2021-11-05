package c.b.a.b.h0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import c.b.a.b.h0.g;
import c.b.a.b.h0.m;
import java.util.ArrayList;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public final m[] f3004a = new m[4];

    /* renamed from: b  reason: collision with root package name */
    public final Matrix[] f3005b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    public final Matrix[] f3006c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    public final PointF f3007d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    public final Path f3008e = new Path();
    public final Path f = new Path();
    public final m g = new m();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public boolean j = true;

    public interface a {
    }

    public k() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f3004a[i2] = new m();
            this.f3005b[i2] = new Matrix();
            this.f3006c[i2] = new Matrix();
        }
    }

    public void a(j jVar, float f2, RectF rectF, a aVar, Path path) {
        float f3;
        float f4;
        f fVar;
        char c2;
        Path path2;
        Matrix matrix;
        m mVar;
        c cVar;
        d dVar;
        float f5;
        float f6;
        path.rewind();
        this.f3008e.rewind();
        this.f.rewind();
        this.f.addRect(rectF, Path.Direction.CW);
        char c3 = 0;
        int i2 = 0;
        while (i2 < 4) {
            if (i2 == 1) {
                cVar = jVar.g;
            } else if (i2 == 2) {
                cVar = jVar.h;
            } else if (i2 != 3) {
                cVar = jVar.f;
            } else {
                cVar = jVar.f2998e;
            }
            if (i2 == 1) {
                dVar = jVar.f2996c;
            } else if (i2 == 2) {
                dVar = jVar.f2997d;
            } else if (i2 != 3) {
                dVar = jVar.f2995b;
            } else {
                dVar = jVar.f2994a;
            }
            m mVar2 = this.f3004a[i2];
            if (dVar != null) {
                dVar.a(mVar2, 90.0f, f2, cVar.a(rectF));
                int i3 = i2 + 1;
                float f7 = (float) (i3 * 90);
                this.f3005b[i2].reset();
                PointF pointF = this.f3007d;
                if (i2 == 1) {
                    f6 = rectF.right;
                } else if (i2 != 2) {
                    f6 = i2 != 3 ? rectF.right : rectF.left;
                    f5 = rectF.top;
                    pointF.set(f6, f5);
                    Matrix matrix2 = this.f3005b[i2];
                    PointF pointF2 = this.f3007d;
                    matrix2.setTranslate(pointF2.x, pointF2.y);
                    this.f3005b[i2].preRotate(f7);
                    float[] fArr = this.h;
                    m[] mVarArr = this.f3004a;
                    fArr[0] = mVarArr[i2].f3013c;
                    fArr[1] = mVarArr[i2].f3014d;
                    this.f3005b[i2].mapPoints(fArr);
                    this.f3006c[i2].reset();
                    Matrix matrix3 = this.f3006c[i2];
                    float[] fArr2 = this.h;
                    matrix3.setTranslate(fArr2[0], fArr2[1]);
                    this.f3006c[i2].preRotate(f7);
                    i2 = i3;
                } else {
                    f6 = rectF.left;
                }
                f5 = rectF.bottom;
                pointF.set(f6, f5);
                Matrix matrix22 = this.f3005b[i2];
                PointF pointF22 = this.f3007d;
                matrix22.setTranslate(pointF22.x, pointF22.y);
                this.f3005b[i2].preRotate(f7);
                float[] fArr3 = this.h;
                m[] mVarArr2 = this.f3004a;
                fArr3[0] = mVarArr2[i2].f3013c;
                fArr3[1] = mVarArr2[i2].f3014d;
                this.f3005b[i2].mapPoints(fArr3);
                this.f3006c[i2].reset();
                Matrix matrix32 = this.f3006c[i2];
                float[] fArr22 = this.h;
                matrix32.setTranslate(fArr22[0], fArr22[1]);
                this.f3006c[i2].preRotate(f7);
                i2 = i3;
            } else {
                throw null;
            }
        }
        int i4 = 0;
        while (i4 < 4) {
            float[] fArr4 = this.h;
            m[] mVarArr3 = this.f3004a;
            fArr4[c3] = mVarArr3[i4].f3011a;
            fArr4[1] = mVarArr3[i4].f3012b;
            this.f3005b[i4].mapPoints(fArr4);
            float[] fArr5 = this.h;
            if (i4 == 0) {
                path.moveTo(fArr5[c3], fArr5[1]);
            } else {
                path.lineTo(fArr5[c3], fArr5[1]);
            }
            this.f3004a[i4].c(this.f3005b[i4], path);
            if (aVar != null) {
                m mVar3 = this.f3004a[i4];
                Matrix matrix4 = this.f3005b[i4];
                g.a aVar2 = (g.a) aVar;
                g.this.f2985e.set(i4, mVar3.i);
                m.f[] fVarArr = g.this.f2983c;
                mVar3.b(mVar3.f);
                fVarArr[i4] = new l(mVar3, new ArrayList(mVar3.h), matrix4);
            }
            int i5 = i4 + 1;
            int i6 = i5 % 4;
            float[] fArr6 = this.h;
            m[] mVarArr4 = this.f3004a;
            fArr6[c3] = mVarArr4[i4].f3013c;
            fArr6[1] = mVarArr4[i4].f3014d;
            this.f3005b[i4].mapPoints(fArr6);
            float[] fArr7 = this.i;
            m[] mVarArr5 = this.f3004a;
            fArr7[c3] = mVarArr5[i6].f3011a;
            fArr7[1] = mVarArr5[i6].f3012b;
            this.f3005b[i6].mapPoints(fArr7);
            float[] fArr8 = this.h;
            float f8 = fArr8[c3];
            float[] fArr9 = this.i;
            float max = Math.max(((float) Math.hypot((double) (f8 - fArr9[c3]), (double) (fArr8[1] - fArr9[1]))) - 0.001f, 0.0f);
            float[] fArr10 = this.h;
            m[] mVarArr6 = this.f3004a;
            fArr10[c3] = mVarArr6[i4].f3013c;
            fArr10[1] = mVarArr6[i4].f3014d;
            this.f3005b[i4].mapPoints(fArr10);
            if (i4 == 1 || i4 == 3) {
                f4 = rectF.centerX();
                f3 = this.h[c3];
            } else {
                f4 = rectF.centerY();
                f3 = this.h[1];
            }
            float abs = Math.abs(f4 - f3);
            this.g.e(0.0f, 0.0f, 270.0f, 0.0f);
            if (i4 == 1) {
                c2 = 3;
                fVar = jVar.k;
            } else if (i4 != 2) {
                c2 = 3;
                if (i4 != 3) {
                    fVar = jVar.j;
                } else {
                    fVar = jVar.i;
                }
            } else {
                c2 = 3;
                fVar = jVar.l;
            }
            fVar.a(max, abs, f2, this.g);
            Path path3 = new Path();
            this.g.c(this.f3006c[i4], path3);
            if (!this.j || (!b(path3, i4) && !b(path3, i6))) {
                mVar = this.g;
                matrix = this.f3006c[i4];
                path2 = path;
            } else {
                path3.op(path3, this.f, Path.Op.DIFFERENCE);
                float[] fArr11 = this.h;
                m mVar4 = this.g;
                fArr11[c3] = mVar4.f3011a;
                fArr11[1] = mVar4.f3012b;
                this.f3006c[i4].mapPoints(fArr11);
                Path path4 = this.f3008e;
                float[] fArr12 = this.h;
                path4.moveTo(fArr12[c3], fArr12[1]);
                mVar = this.g;
                matrix = this.f3006c[i4];
                path2 = this.f3008e;
            }
            mVar.c(matrix, path2);
            if (aVar != null) {
                m mVar5 = this.g;
                Matrix matrix5 = this.f3006c[i4];
                g.a aVar3 = (g.a) aVar;
                g.this.f2985e.set(i4 + 4, mVar5.i);
                m.f[] fVarArr2 = g.this.f2984d;
                mVar5.b(mVar5.f);
                fVarArr2[i4] = new l(mVar5, new ArrayList(mVar5.h), matrix5);
            }
            i4 = i5;
            c3 = 0;
        }
        path.close();
        this.f3008e.close();
        if (!this.f3008e.isEmpty()) {
            path.op(this.f3008e, Path.Op.UNION);
        }
    }

    public final boolean b(Path path, int i2) {
        Path path2 = new Path();
        this.f3004a[i2].c(this.f3005b[i2], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
