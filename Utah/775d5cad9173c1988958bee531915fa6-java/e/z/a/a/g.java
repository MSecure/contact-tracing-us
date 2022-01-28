package e.z.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import e.b.a.m;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends f {

    /* renamed from: k  reason: collision with root package name */
    public static final PorterDuff.Mode f2079k = PorterDuff.Mode.SRC_IN;
    public h c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuffColorFilter f2080d;

    /* renamed from: e  reason: collision with root package name */
    public ColorFilter f2081e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2082f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2083g;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f2084h;

    /* renamed from: i  reason: collision with root package name */
    public final Matrix f2085i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f2086j;

    public static class b extends f {
        public b() {
        }

        public b(b bVar) {
            super(bVar);
        }

        @Override // e.z.a.a.g.f
        public boolean c() {
            return true;
        }
    }

    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        public int[] f2087e;

        /* renamed from: f  reason: collision with root package name */
        public e.i.b.b.b f2088f;

        /* renamed from: g  reason: collision with root package name */
        public float f2089g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public e.i.b.b.b f2090h;

        /* renamed from: i  reason: collision with root package name */
        public float f2091i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f2092j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f2093k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f2094l = 1.0f;
        public float m = 0.0f;
        public Paint.Cap n = Paint.Cap.BUTT;
        public Paint.Join o = Paint.Join.MITER;
        public float p = 4.0f;

        public c() {
        }

        public c(c cVar) {
            super(cVar);
            this.f2087e = cVar.f2087e;
            this.f2088f = cVar.f2088f;
            this.f2089g = cVar.f2089g;
            this.f2091i = cVar.f2091i;
            this.f2090h = cVar.f2090h;
            this.c = cVar.c;
            this.f2092j = cVar.f2092j;
            this.f2093k = cVar.f2093k;
            this.f2094l = cVar.f2094l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        @Override // e.z.a.a.g.e
        public boolean a() {
            return this.f2090h.c() || this.f2088f.c();
        }

        @Override // e.z.a.a.g.e
        public boolean b(int[] iArr) {
            return this.f2088f.d(iArr) | this.f2090h.d(iArr);
        }

        public float getFillAlpha() {
            return this.f2092j;
        }

        public int getFillColor() {
            return this.f2090h.c;
        }

        public float getStrokeAlpha() {
            return this.f2091i;
        }

        public int getStrokeColor() {
            return this.f2088f.c;
        }

        public float getStrokeWidth() {
            return this.f2089g;
        }

        public float getTrimPathEnd() {
            return this.f2094l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.f2093k;
        }

        public void setFillAlpha(float f2) {
            this.f2092j = f2;
        }

        public void setFillColor(int i2) {
            this.f2090h.c = i2;
        }

        public void setStrokeAlpha(float f2) {
            this.f2091i = f2;
        }

        public void setStrokeColor(int i2) {
            this.f2088f.c = i2;
        }

        public void setStrokeWidth(float f2) {
            this.f2089g = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.f2094l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.f2093k = f2;
        }
    }

    public static class d extends e {
        public final Matrix a;
        public final ArrayList<e> b;
        public float c;

        /* renamed from: d  reason: collision with root package name */
        public float f2095d;

        /* renamed from: e  reason: collision with root package name */
        public float f2096e;

        /* renamed from: f  reason: collision with root package name */
        public float f2097f;

        /* renamed from: g  reason: collision with root package name */
        public float f2098g;

        /* renamed from: h  reason: collision with root package name */
        public float f2099h;

        /* renamed from: i  reason: collision with root package name */
        public float f2100i;

        /* renamed from: j  reason: collision with root package name */
        public final Matrix f2101j;

        /* renamed from: k  reason: collision with root package name */
        public int f2102k;

        /* renamed from: l  reason: collision with root package name */
        public int[] f2103l;
        public String m;

        public d() {
            super(null);
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.f2095d = 0.0f;
            this.f2096e = 0.0f;
            this.f2097f = 1.0f;
            this.f2098g = 1.0f;
            this.f2099h = 0.0f;
            this.f2100i = 0.0f;
            this.f2101j = new Matrix();
            this.m = null;
        }

        public d(d dVar, e.e.a<String, Object> aVar) {
            super(null);
            f fVar;
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.f2095d = 0.0f;
            this.f2096e = 0.0f;
            this.f2097f = 1.0f;
            this.f2098g = 1.0f;
            this.f2099h = 0.0f;
            this.f2100i = 0.0f;
            Matrix matrix = new Matrix();
            this.f2101j = matrix;
            this.m = null;
            this.c = dVar.c;
            this.f2095d = dVar.f2095d;
            this.f2096e = dVar.f2096e;
            this.f2097f = dVar.f2097f;
            this.f2098g = dVar.f2098g;
            this.f2099h = dVar.f2099h;
            this.f2100i = dVar.f2100i;
            this.f2103l = dVar.f2103l;
            String str = dVar.m;
            this.m = str;
            this.f2102k = dVar.f2102k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f2101j);
            ArrayList<e> arrayList = dVar.b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.b.add(fVar);
                    String str2 = fVar.b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        @Override // e.z.a.a.g.e
        public boolean a() {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (this.b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // e.z.a.a.g.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                z |= this.b.get(i2).b(iArr);
            }
            return z;
        }

        public final void c() {
            this.f2101j.reset();
            this.f2101j.postTranslate(-this.f2095d, -this.f2096e);
            this.f2101j.postScale(this.f2097f, this.f2098g);
            this.f2101j.postRotate(this.c, 0.0f, 0.0f);
            this.f2101j.postTranslate(this.f2099h + this.f2095d, this.f2100i + this.f2096e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f2101j;
        }

        public float getPivotX() {
            return this.f2095d;
        }

        public float getPivotY() {
            return this.f2096e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f2097f;
        }

        public float getScaleY() {
            return this.f2098g;
        }

        public float getTranslateX() {
            return this.f2099h;
        }

        public float getTranslateY() {
            return this.f2100i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f2095d) {
                this.f2095d = f2;
                c();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f2096e) {
                this.f2096e = f2;
                c();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.c) {
                this.c = f2;
                c();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f2097f) {
                this.f2097f = f2;
                c();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f2098g) {
                this.f2098g = f2;
                c();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f2099h) {
                this.f2099h = f2;
                c();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f2100i) {
                this.f2100i = f2;
                c();
            }
        }
    }

    public static abstract class e {
        public e() {
        }

        public e(a aVar) {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    public static abstract class f extends e {
        public e.i.c.d[] a = null;
        public String b;
        public int c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2104d;

        public f() {
            super(null);
        }

        public f(f fVar) {
            super(null);
            this.b = fVar.b;
            this.f2104d = fVar.f2104d;
            this.a = m.e.T(fVar.a);
        }

        public boolean c() {
            return false;
        }

        public e.i.c.d[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.b;
        }

        public void setPathData(e.i.c.d[] dVarArr) {
            if (!m.e.g(this.a, dVarArr)) {
                this.a = m.e.T(dVarArr);
                return;
            }
            e.i.c.d[] dVarArr2 = this.a;
            for (int i2 = 0; i2 < dVarArr.length; i2++) {
                dVarArr2[i2].a = dVarArr[i2].a;
                for (int i3 = 0; i3 < dVarArr[i2].b.length; i3++) {
                    dVarArr2[i2].b[i3] = dVarArr[i2].b[i3];
                }
            }
        }
    }

    /* renamed from: e.z.a.a.g$g  reason: collision with other inner class name */
    public static class C0067g {
        public static final Matrix q = new Matrix();
        public final Path a;
        public final Path b;
        public final Matrix c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f2105d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f2106e;

        /* renamed from: f  reason: collision with root package name */
        public PathMeasure f2107f;

        /* renamed from: g  reason: collision with root package name */
        public int f2108g;

        /* renamed from: h  reason: collision with root package name */
        public final d f2109h;

        /* renamed from: i  reason: collision with root package name */
        public float f2110i;

        /* renamed from: j  reason: collision with root package name */
        public float f2111j;

        /* renamed from: k  reason: collision with root package name */
        public float f2112k;

        /* renamed from: l  reason: collision with root package name */
        public float f2113l;
        public int m;
        public String n;
        public Boolean o;
        public final e.e.a<String, Object> p;

        public C0067g() {
            this.c = new Matrix();
            this.f2110i = 0.0f;
            this.f2111j = 0.0f;
            this.f2112k = 0.0f;
            this.f2113l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new e.e.a<>();
            this.f2109h = new d();
            this.a = new Path();
            this.b = new Path();
        }

        public C0067g(C0067g gVar) {
            this.c = new Matrix();
            this.f2110i = 0.0f;
            this.f2111j = 0.0f;
            this.f2112k = 0.0f;
            this.f2113l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            e.e.a<String, Object> aVar = new e.e.a<>();
            this.p = aVar;
            this.f2109h = new d(gVar.f2109h, aVar);
            this.a = new Path(gVar.a);
            this.b = new Path(gVar.b);
            this.f2110i = gVar.f2110i;
            this.f2111j = gVar.f2111j;
            this.f2112k = gVar.f2112k;
            this.f2113l = gVar.f2113l;
            this.f2108g = gVar.f2108g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.o = gVar.o;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r13v11, resolved type: android.graphics.PathMeasure */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final void a(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            C0067g gVar;
            C0067g gVar2 = this;
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.f2101j);
            canvas.save();
            ?? r11 = 0;
            int i4 = 0;
            while (i4 < dVar.b.size()) {
                e eVar = dVar.b.get(i4);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    f fVar = (f) eVar;
                    float f2 = ((float) i2) / gVar2.f2112k;
                    float f3 = ((float) i3) / gVar2.f2113l;
                    float min = Math.min(f2, f3);
                    Matrix matrix2 = dVar.a;
                    gVar2.c.set(matrix2);
                    gVar2.c.postScale(f2, f3);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    char c2 = r11 == true ? 1 : 0;
                    char c3 = r11 == true ? 1 : 0;
                    char c4 = r11 == true ? 1 : 0;
                    float f4 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot((double) fArr[c2], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
                    float abs = max > 0.0f ? Math.abs(f4) / max : 0.0f;
                    if (abs == 0.0f) {
                        gVar = this;
                    } else {
                        gVar = this;
                        Path path = gVar.a;
                        Objects.requireNonNull(fVar);
                        path.reset();
                        e.i.c.d[] dVarArr = fVar.a;
                        if (dVarArr != null) {
                            e.i.c.d.b(dVarArr, path);
                        }
                        Path path2 = gVar.a;
                        gVar.b.reset();
                        if (fVar.c()) {
                            gVar.b.setFillType(fVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            gVar.b.addPath(path2, gVar.c);
                            canvas.clipPath(gVar.b);
                        } else {
                            c cVar = (c) fVar;
                            float f5 = cVar.f2093k;
                            if (!(f5 == 0.0f && cVar.f2094l == 1.0f)) {
                                float f6 = cVar.m;
                                float f7 = (f5 + f6) % 1.0f;
                                float f8 = (cVar.f2094l + f6) % 1.0f;
                                if (gVar.f2107f == null) {
                                    gVar.f2107f = new PathMeasure();
                                }
                                gVar.f2107f.setPath(gVar.a, r11);
                                float length = gVar.f2107f.getLength();
                                float f9 = f7 * length;
                                float f10 = f8 * length;
                                path2.reset();
                                if (f9 > f10) {
                                    gVar.f2107f.getSegment(f9, length, path2, true);
                                    gVar.f2107f.getSegment(0.0f, f10, path2, true);
                                } else {
                                    gVar.f2107f.getSegment(f9, f10, path2, true);
                                }
                                path2.rLineTo(0.0f, 0.0f);
                            }
                            gVar.b.addPath(path2, gVar.c);
                            e.i.b.b.b bVar = cVar.f2090h;
                            if (bVar.b() || bVar.c != 0) {
                                e.i.b.b.b bVar2 = cVar.f2090h;
                                if (gVar.f2106e == null) {
                                    Paint paint = new Paint(1);
                                    gVar.f2106e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = gVar.f2106e;
                                if (bVar2.b()) {
                                    Shader shader = bVar2.a;
                                    shader.setLocalMatrix(gVar.c);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(cVar.f2092j * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i5 = bVar2.c;
                                    float f11 = cVar.f2092j;
                                    PorterDuff.Mode mode = g.f2079k;
                                    paint2.setColor((i5 & 16777215) | (((int) (((float) Color.alpha(i5)) * f11)) << 24));
                                }
                                paint2.setColorFilter(colorFilter);
                                gVar.b.setFillType(cVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(gVar.b, paint2);
                            }
                            e.i.b.b.b bVar3 = cVar.f2088f;
                            if (bVar3.b() || bVar3.c != 0) {
                                e.i.b.b.b bVar4 = cVar.f2088f;
                                if (gVar.f2105d == null) {
                                    Paint paint3 = new Paint(1);
                                    gVar.f2105d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = gVar.f2105d;
                                Paint.Join join = cVar.o;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = cVar.n;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(cVar.p);
                                if (bVar4.b()) {
                                    Shader shader2 = bVar4.a;
                                    shader2.setLocalMatrix(gVar.c);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(cVar.f2091i * 255.0f));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i6 = bVar4.c;
                                    float f12 = cVar.f2091i;
                                    PorterDuff.Mode mode2 = g.f2079k;
                                    paint4.setColor((i6 & 16777215) | (((int) (((float) Color.alpha(i6)) * f12)) << 24));
                                }
                                paint4.setColorFilter(colorFilter);
                                paint4.setStrokeWidth(cVar.f2089g * abs * min);
                                canvas.drawPath(gVar.b, paint4);
                            }
                        }
                    }
                    i4++;
                    gVar2 = gVar;
                    r11 = 0;
                }
                gVar = gVar2;
                i4++;
                gVar2 = gVar;
                r11 = 0;
            }
            canvas.restore();
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.m = i2;
        }
    }

    public static class h extends Drawable.ConstantState {
        public int a;
        public C0067g b;
        public ColorStateList c;

        /* renamed from: d  reason: collision with root package name */
        public PorterDuff.Mode f2114d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2115e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f2116f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f2117g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f2118h;

        /* renamed from: i  reason: collision with root package name */
        public int f2119i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f2120j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f2121k;

        /* renamed from: l  reason: collision with root package name */
        public Paint f2122l;

        public h() {
            this.c = null;
            this.f2114d = g.f2079k;
            this.b = new C0067g();
        }

        public h(h hVar) {
            this.c = null;
            this.f2114d = g.f2079k;
            if (hVar != null) {
                this.a = hVar.a;
                C0067g gVar = new C0067g(hVar.b);
                this.b = gVar;
                if (hVar.b.f2106e != null) {
                    gVar.f2106e = new Paint(hVar.b.f2106e);
                }
                if (hVar.b.f2105d != null) {
                    this.b.f2105d = new Paint(hVar.b.f2105d);
                }
                this.c = hVar.c;
                this.f2114d = hVar.f2114d;
                this.f2115e = hVar.f2115e;
            }
        }

        public boolean a() {
            C0067g gVar = this.b;
            if (gVar.o == null) {
                gVar.o = Boolean.valueOf(gVar.f2109h.a());
            }
            return gVar.o.booleanValue();
        }

        public void b(int i2, int i3) {
            this.f2116f.eraseColor(0);
            Canvas canvas = new Canvas(this.f2116f);
            C0067g gVar = this.b;
            gVar.a(gVar.f2109h, C0067g.q, canvas, i2, i3, null);
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            return new g(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new g(this);
        }
    }

    public static class i extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public i(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            g gVar = new g();
            gVar.b = (VectorDrawable) this.a.newDrawable();
            return gVar;
        }

        public Drawable newDrawable(Resources resources) {
            g gVar = new g();
            gVar.b = (VectorDrawable) this.a.newDrawable(resources);
            return gVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            g gVar = new g();
            gVar.b = (VectorDrawable) this.a.newDrawable(resources, theme);
            return gVar;
        }
    }

    public g() {
        this.f2083g = true;
        this.f2084h = new float[9];
        this.f2085i = new Matrix();
        this.f2086j = new Rect();
        this.c = new h();
    }

    public g(h hVar) {
        this.f2083g = true;
        this.f2084h = new float[9];
        this.f2085i = new Matrix();
        this.f2086j = new Rect();
        this.c = hVar;
        this.f2080d = b(hVar.c, hVar.f2114d);
    }

    public static g a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        g gVar = new g();
        gVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return gVar;
    }

    public PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.b;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d3, code lost:
        if ((r1 == r7.getWidth() && r3 == r6.f2116f.getHeight()) == false) goto L_0x00d5;
     */
    public void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f2086j);
        if (this.f2086j.width() > 0 && this.f2086j.height() > 0) {
            ColorFilter colorFilter = this.f2081e;
            if (colorFilter == null) {
                colorFilter = this.f2080d;
            }
            canvas.getMatrix(this.f2085i);
            this.f2085i.getValues(this.f2084h);
            boolean z = false;
            float abs = Math.abs(this.f2084h[0]);
            float abs2 = Math.abs(this.f2084h[4]);
            float abs3 = Math.abs(this.f2084h[1]);
            float abs4 = Math.abs(this.f2084h[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f2086j.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f2086j.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f2086j;
                canvas.translate((float) rect.left, (float) rect.top);
                if (isAutoMirrored() && m.e.o0(this) == 1) {
                    canvas.translate((float) this.f2086j.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f2086j.offsetTo(0, 0);
                h hVar = this.c;
                Bitmap bitmap = hVar.f2116f;
                if (bitmap != null) {
                }
                hVar.f2116f = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
                hVar.f2121k = true;
                if (!this.f2083g) {
                    this.c.b(min, min2);
                } else {
                    h hVar2 = this.c;
                    if (!(!hVar2.f2121k && hVar2.f2117g == hVar2.c && hVar2.f2118h == hVar2.f2114d && hVar2.f2120j == hVar2.f2115e && hVar2.f2119i == hVar2.b.getRootAlpha())) {
                        this.c.b(min, min2);
                        h hVar3 = this.c;
                        hVar3.f2117g = hVar3.c;
                        hVar3.f2118h = hVar3.f2114d;
                        hVar3.f2119i = hVar3.b.getRootAlpha();
                        hVar3.f2120j = hVar3.f2115e;
                        hVar3.f2121k = false;
                    }
                }
                h hVar4 = this.c;
                Rect rect2 = this.f2086j;
                if (hVar4.b.getRootAlpha() < 255) {
                    z = true;
                }
                if (z || colorFilter != null) {
                    if (hVar4.f2122l == null) {
                        Paint paint2 = new Paint();
                        hVar4.f2122l = paint2;
                        paint2.setFilterBitmap(true);
                    }
                    hVar4.f2122l.setAlpha(hVar4.b.getRootAlpha());
                    hVar4.f2122l.setColorFilter(colorFilter);
                    paint = hVar4.f2122l;
                } else {
                    paint = null;
                }
                canvas.drawBitmap(hVar4.f2116f, (Rect) null, rect2, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.c.b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.f2081e;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.b != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.b.getConstantState());
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.c.b.f2111j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.c.b.f2110i;
    }

    public int getOpacity() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:199:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f0  */
    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        ColorStateList colorStateList;
        int i2;
        ArrayDeque arrayDeque;
        h hVar;
        C0067g gVar;
        h hVar2;
        C0067g gVar2;
        ArrayDeque arrayDeque2;
        TypedArray typedArray;
        d dVar;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar3 = this.c;
        hVar3.b = new C0067g();
        TypedArray W0 = m.e.W0(resources, theme, attributeSet, a.a);
        h hVar4 = this.c;
        C0067g gVar3 = hVar4.b;
        int i3 = !m.e.D0(xmlPullParser, "tintMode") ? -1 : W0.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i4 = 3;
        if (i3 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i3 != 5) {
            if (i3 != 9) {
                switch (i3) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        hVar4.f2114d = mode;
        int i5 = 1;
        if (m.e.D0(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            W0.getValue(1, typedValue);
            int i6 = typedValue.type;
            if (i6 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index " + 1 + ": " + typedValue);
            } else if (i6 < 28 || i6 > 31) {
                Resources resources2 = W0.getResources();
                int resourceId = W0.getResourceId(1, 0);
                ThreadLocal<TypedValue> threadLocal = e.i.b.b.a.a;
                try {
                    colorStateList = e.i.b.b.a.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception unused) {
                }
                if (colorStateList != null) {
                    hVar4.c = colorStateList;
                }
                boolean z = hVar4.f2115e;
                if (m.e.D0(xmlPullParser, "autoMirrored")) {
                    z = W0.getBoolean(5, z);
                }
                hVar4.f2115e = z;
                float f2 = gVar3.f2112k;
                if (m.e.D0(xmlPullParser, "viewportWidth")) {
                    f2 = W0.getFloat(7, f2);
                }
                gVar3.f2112k = f2;
                float f3 = gVar3.f2113l;
                if (m.e.D0(xmlPullParser, "viewportHeight")) {
                    f3 = W0.getFloat(8, f3);
                }
                gVar3.f2113l = f3;
                if (gVar3.f2112k <= 0.0f) {
                    throw new XmlPullParserException(W0.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
                } else if (f3 > 0.0f) {
                    gVar3.f2110i = W0.getDimension(3, gVar3.f2110i);
                    float dimension = W0.getDimension(2, gVar3.f2111j);
                    gVar3.f2111j = dimension;
                    if (gVar3.f2110i <= 0.0f) {
                        throw new XmlPullParserException(W0.getPositionDescription() + "<vector> tag requires width > 0");
                    } else if (dimension > 0.0f) {
                        float alpha = gVar3.getAlpha();
                        if (m.e.D0(xmlPullParser, "alpha")) {
                            alpha = W0.getFloat(4, alpha);
                        }
                        gVar3.setAlpha(alpha);
                        String string = W0.getString(0);
                        if (string != null) {
                            gVar3.n = string;
                            gVar3.p.put(string, gVar3);
                        }
                        W0.recycle();
                        hVar3.a = getChangingConfigurations();
                        hVar3.f2121k = true;
                        h hVar5 = this.c;
                        C0067g gVar4 = hVar5.b;
                        ArrayDeque arrayDeque3 = new ArrayDeque();
                        arrayDeque3.push(gVar4.f2109h);
                        int eventType = xmlPullParser.getEventType();
                        int depth = xmlPullParser.getDepth() + 1;
                        boolean z2 = true;
                        while (eventType != i5 && (xmlPullParser.getDepth() >= depth || eventType != i4)) {
                            if (eventType == 2) {
                                String name = xmlPullParser.getName();
                                d dVar2 = (d) arrayDeque3.peek();
                                if ("path".equals(name)) {
                                    c cVar = new c();
                                    TypedArray W02 = m.e.W0(resources, theme, attributeSet, a.c);
                                    cVar.f2087e = null;
                                    if (!m.e.D0(xmlPullParser, "pathData")) {
                                        arrayDeque2 = arrayDeque3;
                                        gVar2 = gVar4;
                                        hVar2 = hVar5;
                                        dVar = dVar2;
                                        i2 = depth;
                                        typedArray = W02;
                                    } else {
                                        String string2 = W02.getString(0);
                                        if (string2 != null) {
                                            cVar.b = string2;
                                        }
                                        String string3 = W02.getString(2);
                                        if (string3 != null) {
                                            cVar.a = m.e.K(string3);
                                        }
                                        arrayDeque2 = arrayDeque3;
                                        gVar2 = gVar4;
                                        hVar2 = hVar5;
                                        i2 = depth;
                                        typedArray = W02;
                                        dVar = dVar2;
                                        cVar.f2090h = m.e.s0(W02, xmlPullParser, theme, "fillColor", 1, 0);
                                        float f4 = cVar.f2092j;
                                        if (m.e.D0(xmlPullParser, "fillAlpha")) {
                                            f4 = typedArray.getFloat(12, f4);
                                        }
                                        cVar.f2092j = f4;
                                        int i7 = !m.e.D0(xmlPullParser, "strokeLineCap") ? -1 : typedArray.getInt(8, -1);
                                        Paint.Cap cap = cVar.n;
                                        if (i7 == 0) {
                                            cap = Paint.Cap.BUTT;
                                        } else if (i7 == 1) {
                                            cap = Paint.Cap.ROUND;
                                        } else if (i7 == 2) {
                                            cap = Paint.Cap.SQUARE;
                                        }
                                        cVar.n = cap;
                                        int i8 = !m.e.D0(xmlPullParser, "strokeLineJoin") ? -1 : typedArray.getInt(9, -1);
                                        Paint.Join join = cVar.o;
                                        if (i8 == 0) {
                                            join = Paint.Join.MITER;
                                        } else if (i8 == 1) {
                                            join = Paint.Join.ROUND;
                                        } else if (i8 == 2) {
                                            join = Paint.Join.BEVEL;
                                        }
                                        cVar.o = join;
                                        float f5 = cVar.p;
                                        if (m.e.D0(xmlPullParser, "strokeMiterLimit")) {
                                            f5 = typedArray.getFloat(10, f5);
                                        }
                                        cVar.p = f5;
                                        cVar.f2088f = m.e.s0(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                                        float f6 = cVar.f2091i;
                                        if (m.e.D0(xmlPullParser, "strokeAlpha")) {
                                            f6 = typedArray.getFloat(11, f6);
                                        }
                                        cVar.f2091i = f6;
                                        float f7 = cVar.f2089g;
                                        if (m.e.D0(xmlPullParser, "strokeWidth")) {
                                            f7 = typedArray.getFloat(4, f7);
                                        }
                                        cVar.f2089g = f7;
                                        float f8 = cVar.f2094l;
                                        if (m.e.D0(xmlPullParser, "trimPathEnd")) {
                                            f8 = typedArray.getFloat(6, f8);
                                        }
                                        cVar.f2094l = f8;
                                        float f9 = cVar.m;
                                        if (m.e.D0(xmlPullParser, "trimPathOffset")) {
                                            f9 = typedArray.getFloat(7, f9);
                                        }
                                        cVar.m = f9;
                                        float f10 = cVar.f2093k;
                                        if (m.e.D0(xmlPullParser, "trimPathStart")) {
                                            f10 = typedArray.getFloat(5, f10);
                                        }
                                        cVar.f2093k = f10;
                                        int i9 = cVar.c;
                                        if (m.e.D0(xmlPullParser, "fillType")) {
                                            i9 = typedArray.getInt(13, i9);
                                        }
                                        cVar.c = i9;
                                    }
                                    typedArray.recycle();
                                    dVar.b.add(cVar);
                                    gVar = gVar2;
                                    if (cVar.getPathName() != null) {
                                        gVar.p.put(cVar.getPathName(), cVar);
                                    }
                                    hVar = hVar2;
                                    hVar.a |= cVar.f2104d;
                                    arrayDeque = arrayDeque2;
                                    i5 = 1;
                                    z2 = false;
                                } else {
                                    gVar = gVar4;
                                    hVar = hVar5;
                                    i2 = depth;
                                    if ("clip-path".equals(name)) {
                                        b bVar = new b();
                                        if (m.e.D0(xmlPullParser, "pathData")) {
                                            TypedArray W03 = m.e.W0(resources, theme, attributeSet, a.f2065d);
                                            String string4 = W03.getString(0);
                                            if (string4 != null) {
                                                bVar.b = string4;
                                            }
                                            String string5 = W03.getString(1);
                                            if (string5 != null) {
                                                bVar.a = m.e.K(string5);
                                            }
                                            bVar.c = !m.e.D0(xmlPullParser, "fillType") ? 0 : W03.getInt(2, 0);
                                            W03.recycle();
                                        }
                                        dVar2.b.add(bVar);
                                        if (bVar.getPathName() != null) {
                                            gVar.p.put(bVar.getPathName(), bVar);
                                        }
                                        hVar.a = bVar.f2104d | hVar.a;
                                    } else if ("group".equals(name)) {
                                        d dVar3 = new d();
                                        TypedArray W04 = m.e.W0(resources, theme, attributeSet, a.b);
                                        dVar3.f2103l = null;
                                        float f11 = dVar3.c;
                                        if (m.e.D0(xmlPullParser, "rotation")) {
                                            f11 = W04.getFloat(5, f11);
                                        }
                                        dVar3.c = f11;
                                        i5 = 1;
                                        dVar3.f2095d = W04.getFloat(1, dVar3.f2095d);
                                        dVar3.f2096e = W04.getFloat(2, dVar3.f2096e);
                                        float f12 = dVar3.f2097f;
                                        if (m.e.D0(xmlPullParser, "scaleX")) {
                                            f12 = W04.getFloat(3, f12);
                                        }
                                        dVar3.f2097f = f12;
                                        float f13 = dVar3.f2098g;
                                        if (m.e.D0(xmlPullParser, "scaleY")) {
                                            f13 = W04.getFloat(4, f13);
                                        }
                                        dVar3.f2098g = f13;
                                        float f14 = dVar3.f2099h;
                                        if (m.e.D0(xmlPullParser, "translateX")) {
                                            f14 = W04.getFloat(6, f14);
                                        }
                                        dVar3.f2099h = f14;
                                        float f15 = dVar3.f2100i;
                                        if (m.e.D0(xmlPullParser, "translateY")) {
                                            f15 = W04.getFloat(7, f15);
                                        }
                                        dVar3.f2100i = f15;
                                        String string6 = W04.getString(0);
                                        if (string6 != null) {
                                            dVar3.m = string6;
                                        }
                                        dVar3.c();
                                        W04.recycle();
                                        dVar2.b.add(dVar3);
                                        arrayDeque = arrayDeque3;
                                        arrayDeque.push(dVar3);
                                        if (dVar3.getGroupName() != null) {
                                            gVar.p.put(dVar3.getGroupName(), dVar3);
                                        }
                                        hVar.a = dVar3.f2102k | hVar.a;
                                    }
                                    arrayDeque = arrayDeque3;
                                    i5 = 1;
                                }
                            } else {
                                i2 = depth;
                                arrayDeque = arrayDeque3;
                                gVar = gVar4;
                                hVar = hVar5;
                                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                                    arrayDeque.pop();
                                }
                            }
                            eventType = xmlPullParser.next();
                            i4 = 3;
                            depth = i2;
                            gVar4 = gVar;
                            arrayDeque3 = arrayDeque;
                            hVar5 = hVar;
                        }
                        if (!z2) {
                            this.f2080d = b(hVar3.c, hVar3.f2114d);
                            return;
                        }
                        throw new XmlPullParserException("no path defined");
                    } else {
                        throw new XmlPullParserException(W0.getPositionDescription() + "<vector> tag requires height > 0");
                    }
                } else {
                    throw new XmlPullParserException(W0.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
                }
            } else {
                colorStateList = ColorStateList.valueOf(typedValue.data);
                if (colorStateList != null) {
                }
                boolean z3 = hVar4.f2115e;
                if (m.e.D0(xmlPullParser, "autoMirrored")) {
                }
                hVar4.f2115e = z3;
                float f22 = gVar3.f2112k;
                if (m.e.D0(xmlPullParser, "viewportWidth")) {
                }
                gVar3.f2112k = f22;
                float f32 = gVar3.f2113l;
                if (m.e.D0(xmlPullParser, "viewportHeight")) {
                }
                gVar3.f2113l = f32;
                if (gVar3.f2112k <= 0.0f) {
                }
            }
        }
        colorStateList = null;
        if (colorStateList != null) {
        }
        boolean z32 = hVar4.f2115e;
        if (m.e.D0(xmlPullParser, "autoMirrored")) {
        }
        hVar4.f2115e = z32;
        float f222 = gVar3.f2112k;
        if (m.e.D0(xmlPullParser, "viewportWidth")) {
        }
        gVar3.f2112k = f222;
        float f322 = gVar3.f2113l;
        if (m.e.D0(xmlPullParser, "viewportHeight")) {
        }
        gVar3.f2113l = f322;
        if (gVar3.f2112k <= 0.0f) {
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.c.f2115e;
    }

    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.b;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.c) != null && (hVar.a() || ((colorStateList = this.c.c) != null && colorStateList.isStateful())));
    }

    public Drawable mutate() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2082f && super.mutate() == this) {
            this.c = new h(this.c);
            this.f2082f = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.c;
        ColorStateList colorStateList = hVar.c;
        if (!(colorStateList == null || (mode = hVar.f2114d) == null)) {
            this.f2080d = b(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.a()) {
            boolean b2 = hVar.b.f2109h.b(iArr);
            hVar.f2121k |= b2;
            if (b2) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.c.b.getRootAlpha() != i2) {
            this.c.b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.c.f2115e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f2081e = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.e.w1(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.e.x1(drawable, colorStateList);
            return;
        }
        h hVar = this.c;
        if (hVar.c != colorStateList) {
            hVar.c = colorStateList;
            this.f2080d = b(colorStateList, hVar.f2114d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.e.y1(drawable, mode);
            return;
        }
        h hVar = this.c;
        if (hVar.f2114d != mode) {
            hVar.f2114d = mode;
            this.f2080d = b(hVar.c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.b;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
