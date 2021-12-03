package e.x.a.a;

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
    public static final PorterDuff.Mode f1802k = PorterDuff.Mode.SRC_IN;
    public h c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuffColorFilter f1803d;

    /* renamed from: e  reason: collision with root package name */
    public ColorFilter f1804e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1805f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1806g;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f1807h;

    /* renamed from: i  reason: collision with root package name */
    public final Matrix f1808i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f1809j;

    public static class b extends f {
        public b() {
        }

        public b(b bVar) {
            super(bVar);
        }

        @Override // e.x.a.a.g.f
        public boolean c() {
            return true;
        }
    }

    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        public int[] f1810e;

        /* renamed from: f  reason: collision with root package name */
        public e.i.b.b.a f1811f;

        /* renamed from: g  reason: collision with root package name */
        public float f1812g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public e.i.b.b.a f1813h;

        /* renamed from: i  reason: collision with root package name */
        public float f1814i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f1815j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f1816k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f1817l = 1.0f;
        public float m = 0.0f;
        public Paint.Cap n = Paint.Cap.BUTT;
        public Paint.Join o = Paint.Join.MITER;
        public float p = 4.0f;

        public c() {
        }

        public c(c cVar) {
            super(cVar);
            this.f1810e = cVar.f1810e;
            this.f1811f = cVar.f1811f;
            this.f1812g = cVar.f1812g;
            this.f1814i = cVar.f1814i;
            this.f1813h = cVar.f1813h;
            this.c = cVar.c;
            this.f1815j = cVar.f1815j;
            this.f1816k = cVar.f1816k;
            this.f1817l = cVar.f1817l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        @Override // e.x.a.a.g.e
        public boolean a() {
            return this.f1813h.c() || this.f1811f.c();
        }

        @Override // e.x.a.a.g.e
        public boolean b(int[] iArr) {
            return this.f1811f.d(iArr) | this.f1813h.d(iArr);
        }

        public float getFillAlpha() {
            return this.f1815j;
        }

        public int getFillColor() {
            return this.f1813h.c;
        }

        public float getStrokeAlpha() {
            return this.f1814i;
        }

        public int getStrokeColor() {
            return this.f1811f.c;
        }

        public float getStrokeWidth() {
            return this.f1812g;
        }

        public float getTrimPathEnd() {
            return this.f1817l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.f1816k;
        }

        public void setFillAlpha(float f2) {
            this.f1815j = f2;
        }

        public void setFillColor(int i2) {
            this.f1813h.c = i2;
        }

        public void setStrokeAlpha(float f2) {
            this.f1814i = f2;
        }

        public void setStrokeColor(int i2) {
            this.f1811f.c = i2;
        }

        public void setStrokeWidth(float f2) {
            this.f1812g = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.f1817l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.f1816k = f2;
        }
    }

    public static class d extends e {
        public final Matrix a;
        public final ArrayList<e> b;
        public float c;

        /* renamed from: d  reason: collision with root package name */
        public float f1818d;

        /* renamed from: e  reason: collision with root package name */
        public float f1819e;

        /* renamed from: f  reason: collision with root package name */
        public float f1820f;

        /* renamed from: g  reason: collision with root package name */
        public float f1821g;

        /* renamed from: h  reason: collision with root package name */
        public float f1822h;

        /* renamed from: i  reason: collision with root package name */
        public float f1823i;

        /* renamed from: j  reason: collision with root package name */
        public final Matrix f1824j;

        /* renamed from: k  reason: collision with root package name */
        public int f1825k;

        /* renamed from: l  reason: collision with root package name */
        public int[] f1826l;
        public String m;

        public d() {
            super(null);
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.f1818d = 0.0f;
            this.f1819e = 0.0f;
            this.f1820f = 1.0f;
            this.f1821g = 1.0f;
            this.f1822h = 0.0f;
            this.f1823i = 0.0f;
            this.f1824j = new Matrix();
            this.m = null;
        }

        public d(d dVar, e.e.a<String, Object> aVar) {
            super(null);
            f fVar;
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.f1818d = 0.0f;
            this.f1819e = 0.0f;
            this.f1820f = 1.0f;
            this.f1821g = 1.0f;
            this.f1822h = 0.0f;
            this.f1823i = 0.0f;
            Matrix matrix = new Matrix();
            this.f1824j = matrix;
            this.m = null;
            this.c = dVar.c;
            this.f1818d = dVar.f1818d;
            this.f1819e = dVar.f1819e;
            this.f1820f = dVar.f1820f;
            this.f1821g = dVar.f1821g;
            this.f1822h = dVar.f1822h;
            this.f1823i = dVar.f1823i;
            this.f1826l = dVar.f1826l;
            String str = dVar.m;
            this.m = str;
            this.f1825k = dVar.f1825k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f1824j);
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

        @Override // e.x.a.a.g.e
        public boolean a() {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (this.b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // e.x.a.a.g.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                z |= this.b.get(i2).b(iArr);
            }
            return z;
        }

        public final void c() {
            this.f1824j.reset();
            this.f1824j.postTranslate(-this.f1818d, -this.f1819e);
            this.f1824j.postScale(this.f1820f, this.f1821g);
            this.f1824j.postRotate(this.c, 0.0f, 0.0f);
            this.f1824j.postTranslate(this.f1822h + this.f1818d, this.f1823i + this.f1819e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f1824j;
        }

        public float getPivotX() {
            return this.f1818d;
        }

        public float getPivotY() {
            return this.f1819e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f1820f;
        }

        public float getScaleY() {
            return this.f1821g;
        }

        public float getTranslateX() {
            return this.f1822h;
        }

        public float getTranslateY() {
            return this.f1823i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f1818d) {
                this.f1818d = f2;
                c();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f1819e) {
                this.f1819e = f2;
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
            if (f2 != this.f1820f) {
                this.f1820f = f2;
                c();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f1821g) {
                this.f1821g = f2;
                c();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f1822h) {
                this.f1822h = f2;
                c();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f1823i) {
                this.f1823i = f2;
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
        public e.i.c.c[] a = null;
        public String b;
        public int c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f1827d;

        public f() {
            super(null);
        }

        public f(f fVar) {
            super(null);
            this.b = fVar.b;
            this.f1827d = fVar.f1827d;
            this.a = m.h.R(fVar.a);
        }

        public boolean c() {
            return false;
        }

        public e.i.c.c[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.b;
        }

        public void setPathData(e.i.c.c[] cVarArr) {
            if (!m.h.g(this.a, cVarArr)) {
                this.a = m.h.R(cVarArr);
                return;
            }
            e.i.c.c[] cVarArr2 = this.a;
            for (int i2 = 0; i2 < cVarArr.length; i2++) {
                cVarArr2[i2].a = cVarArr[i2].a;
                for (int i3 = 0; i3 < cVarArr[i2].b.length; i3++) {
                    cVarArr2[i2].b[i3] = cVarArr[i2].b[i3];
                }
            }
        }
    }

    /* renamed from: e.x.a.a.g$g  reason: collision with other inner class name */
    public static class C0061g {
        public static final Matrix q = new Matrix();
        public final Path a;
        public final Path b;
        public final Matrix c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f1828d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f1829e;

        /* renamed from: f  reason: collision with root package name */
        public PathMeasure f1830f;

        /* renamed from: g  reason: collision with root package name */
        public int f1831g;

        /* renamed from: h  reason: collision with root package name */
        public final d f1832h;

        /* renamed from: i  reason: collision with root package name */
        public float f1833i;

        /* renamed from: j  reason: collision with root package name */
        public float f1834j;

        /* renamed from: k  reason: collision with root package name */
        public float f1835k;

        /* renamed from: l  reason: collision with root package name */
        public float f1836l;
        public int m;
        public String n;
        public Boolean o;
        public final e.e.a<String, Object> p;

        public C0061g() {
            this.c = new Matrix();
            this.f1833i = 0.0f;
            this.f1834j = 0.0f;
            this.f1835k = 0.0f;
            this.f1836l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new e.e.a<>();
            this.f1832h = new d();
            this.a = new Path();
            this.b = new Path();
        }

        public C0061g(C0061g gVar) {
            this.c = new Matrix();
            this.f1833i = 0.0f;
            this.f1834j = 0.0f;
            this.f1835k = 0.0f;
            this.f1836l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            e.e.a<String, Object> aVar = new e.e.a<>();
            this.p = aVar;
            this.f1832h = new d(gVar.f1832h, aVar);
            this.a = new Path(gVar.a);
            this.b = new Path(gVar.b);
            this.f1833i = gVar.f1833i;
            this.f1834j = gVar.f1834j;
            this.f1835k = gVar.f1835k;
            this.f1836l = gVar.f1836l;
            this.f1831g = gVar.f1831g;
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
            C0061g gVar;
            C0061g gVar2 = this;
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.f1824j);
            canvas.save();
            ?? r11 = 0;
            int i4 = 0;
            while (i4 < dVar.b.size()) {
                e eVar = dVar.b.get(i4);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    f fVar = (f) eVar;
                    float f2 = ((float) i2) / gVar2.f1835k;
                    float f3 = ((float) i3) / gVar2.f1836l;
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
                        e.i.c.c[] cVarArr = fVar.a;
                        if (cVarArr != null) {
                            e.i.c.c.b(cVarArr, path);
                        }
                        Path path2 = gVar.a;
                        gVar.b.reset();
                        if (fVar.c()) {
                            gVar.b.setFillType(fVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            gVar.b.addPath(path2, gVar.c);
                            canvas.clipPath(gVar.b);
                        } else {
                            c cVar = (c) fVar;
                            float f5 = cVar.f1816k;
                            if (!(f5 == 0.0f && cVar.f1817l == 1.0f)) {
                                float f6 = cVar.m;
                                float f7 = (f5 + f6) % 1.0f;
                                float f8 = (cVar.f1817l + f6) % 1.0f;
                                if (gVar.f1830f == null) {
                                    gVar.f1830f = new PathMeasure();
                                }
                                gVar.f1830f.setPath(gVar.a, r11);
                                float length = gVar.f1830f.getLength();
                                float f9 = f7 * length;
                                float f10 = f8 * length;
                                path2.reset();
                                if (f9 > f10) {
                                    gVar.f1830f.getSegment(f9, length, path2, true);
                                    gVar.f1830f.getSegment(0.0f, f10, path2, true);
                                } else {
                                    gVar.f1830f.getSegment(f9, f10, path2, true);
                                }
                                path2.rLineTo(0.0f, 0.0f);
                            }
                            gVar.b.addPath(path2, gVar.c);
                            e.i.b.b.a aVar = cVar.f1813h;
                            if (aVar.b() || aVar.c != 0) {
                                e.i.b.b.a aVar2 = cVar.f1813h;
                                if (gVar.f1829e == null) {
                                    Paint paint = new Paint(1);
                                    gVar.f1829e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = gVar.f1829e;
                                if (aVar2.b()) {
                                    Shader shader = aVar2.a;
                                    shader.setLocalMatrix(gVar.c);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(cVar.f1815j * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i5 = aVar2.c;
                                    float f11 = cVar.f1815j;
                                    PorterDuff.Mode mode = g.f1802k;
                                    paint2.setColor((i5 & 16777215) | (((int) (((float) Color.alpha(i5)) * f11)) << 24));
                                }
                                paint2.setColorFilter(colorFilter);
                                gVar.b.setFillType(cVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(gVar.b, paint2);
                            }
                            e.i.b.b.a aVar3 = cVar.f1811f;
                            if (aVar3.b() || aVar3.c != 0) {
                                e.i.b.b.a aVar4 = cVar.f1811f;
                                if (gVar.f1828d == null) {
                                    Paint paint3 = new Paint(1);
                                    gVar.f1828d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = gVar.f1828d;
                                Paint.Join join = cVar.o;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = cVar.n;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(cVar.p);
                                if (aVar4.b()) {
                                    Shader shader2 = aVar4.a;
                                    shader2.setLocalMatrix(gVar.c);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(cVar.f1814i * 255.0f));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i6 = aVar4.c;
                                    float f12 = cVar.f1814i;
                                    PorterDuff.Mode mode2 = g.f1802k;
                                    paint4.setColor((i6 & 16777215) | (((int) (((float) Color.alpha(i6)) * f12)) << 24));
                                }
                                paint4.setColorFilter(colorFilter);
                                paint4.setStrokeWidth(cVar.f1812g * abs * min);
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
        public C0061g b;
        public ColorStateList c;

        /* renamed from: d  reason: collision with root package name */
        public PorterDuff.Mode f1837d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1838e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f1839f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f1840g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f1841h;

        /* renamed from: i  reason: collision with root package name */
        public int f1842i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f1843j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f1844k;

        /* renamed from: l  reason: collision with root package name */
        public Paint f1845l;

        public h() {
            this.c = null;
            this.f1837d = g.f1802k;
            this.b = new C0061g();
        }

        public h(h hVar) {
            this.c = null;
            this.f1837d = g.f1802k;
            if (hVar != null) {
                this.a = hVar.a;
                C0061g gVar = new C0061g(hVar.b);
                this.b = gVar;
                if (hVar.b.f1829e != null) {
                    gVar.f1829e = new Paint(hVar.b.f1829e);
                }
                if (hVar.b.f1828d != null) {
                    this.b.f1828d = new Paint(hVar.b.f1828d);
                }
                this.c = hVar.c;
                this.f1837d = hVar.f1837d;
                this.f1838e = hVar.f1838e;
            }
        }

        public boolean a() {
            C0061g gVar = this.b;
            if (gVar.o == null) {
                gVar.o = Boolean.valueOf(gVar.f1832h.a());
            }
            return gVar.o.booleanValue();
        }

        public void b(int i2, int i3) {
            this.f1839f.eraseColor(0);
            Canvas canvas = new Canvas(this.f1839f);
            C0061g gVar = this.b;
            gVar.a(gVar.f1832h, C0061g.q, canvas, i2, i3, null);
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
        this.f1806g = true;
        this.f1807h = new float[9];
        this.f1808i = new Matrix();
        this.f1809j = new Rect();
        this.c = new h();
    }

    public g(h hVar) {
        this.f1806g = true;
        this.f1807h = new float[9];
        this.f1808i = new Matrix();
        this.f1809j = new Rect();
        this.c = hVar;
        this.f1803d = b(hVar.c, hVar.f1837d);
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
        if ((r1 == r7.getWidth() && r3 == r6.f1839f.getHeight()) == false) goto L_0x00d5;
     */
    public void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f1809j);
        if (this.f1809j.width() > 0 && this.f1809j.height() > 0) {
            ColorFilter colorFilter = this.f1804e;
            if (colorFilter == null) {
                colorFilter = this.f1803d;
            }
            canvas.getMatrix(this.f1808i);
            this.f1808i.getValues(this.f1807h);
            boolean z = false;
            float abs = Math.abs(this.f1807h[0]);
            float abs2 = Math.abs(this.f1807h[4]);
            float abs3 = Math.abs(this.f1807h[1]);
            float abs4 = Math.abs(this.f1807h[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f1809j.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f1809j.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f1809j;
                canvas.translate((float) rect.left, (float) rect.top);
                if (isAutoMirrored() && m.h.k0(this) == 1) {
                    canvas.translate((float) this.f1809j.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f1809j.offsetTo(0, 0);
                h hVar = this.c;
                Bitmap bitmap = hVar.f1839f;
                if (bitmap != null) {
                }
                hVar.f1839f = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
                hVar.f1844k = true;
                if (!this.f1806g) {
                    this.c.b(min, min2);
                } else {
                    h hVar2 = this.c;
                    if (!(!hVar2.f1844k && hVar2.f1840g == hVar2.c && hVar2.f1841h == hVar2.f1837d && hVar2.f1843j == hVar2.f1838e && hVar2.f1842i == hVar2.b.getRootAlpha())) {
                        this.c.b(min, min2);
                        h hVar3 = this.c;
                        hVar3.f1840g = hVar3.c;
                        hVar3.f1841h = hVar3.f1837d;
                        hVar3.f1842i = hVar3.b.getRootAlpha();
                        hVar3.f1843j = hVar3.f1838e;
                        hVar3.f1844k = false;
                    }
                }
                h hVar4 = this.c;
                Rect rect2 = this.f1809j;
                if (hVar4.b.getRootAlpha() < 255) {
                    z = true;
                }
                if (z || colorFilter != null) {
                    if (hVar4.f1845l == null) {
                        Paint paint2 = new Paint();
                        hVar4.f1845l = paint2;
                        paint2.setFilterBitmap(true);
                    }
                    hVar4.f1845l.setAlpha(hVar4.b.getRootAlpha());
                    hVar4.f1845l.setColorFilter(colorFilter);
                    paint = hVar4.f1845l;
                } else {
                    paint = null;
                }
                canvas.drawBitmap(hVar4.f1839f, (Rect) null, rect2, paint);
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
        return this.f1804e;
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
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.c.b.f1834j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.c.b.f1833i;
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

    /* JADX WARNING: Removed duplicated region for block: B:199:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ee  */
    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        ColorStateList colorStateList;
        int i2;
        ArrayDeque arrayDeque;
        h hVar;
        C0061g gVar;
        h hVar2;
        C0061g gVar2;
        ArrayDeque arrayDeque2;
        TypedArray typedArray;
        d dVar;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar3 = this.c;
        hVar3.b = new C0061g();
        TypedArray e2 = e.i.b.b.h.e(resources, theme, attributeSet, a.a);
        h hVar4 = this.c;
        C0061g gVar3 = hVar4.b;
        int i3 = !e.i.b.b.h.c(xmlPullParser, "tintMode") ? -1 : e2.getInt(6, -1);
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
        hVar4.f1837d = mode;
        int i5 = 1;
        if (e.i.b.b.h.c(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            e2.getValue(1, typedValue);
            int i6 = typedValue.type;
            if (i6 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index " + 1 + ": " + typedValue);
            } else if (i6 < 28 || i6 > 31) {
                Resources resources2 = e2.getResources();
                try {
                    colorStateList = m.h.D(resources2, resources2.getXml(e2.getResourceId(1, 0)), theme);
                } catch (Exception unused) {
                }
                if (colorStateList != null) {
                    hVar4.c = colorStateList;
                }
                boolean z = hVar4.f1838e;
                if (e.i.b.b.h.c(xmlPullParser, "autoMirrored")) {
                    z = e2.getBoolean(5, z);
                }
                hVar4.f1838e = z;
                float f2 = gVar3.f1835k;
                if (e.i.b.b.h.c(xmlPullParser, "viewportWidth")) {
                    f2 = e2.getFloat(7, f2);
                }
                gVar3.f1835k = f2;
                float f3 = gVar3.f1836l;
                if (e.i.b.b.h.c(xmlPullParser, "viewportHeight")) {
                    f3 = e2.getFloat(8, f3);
                }
                gVar3.f1836l = f3;
                if (gVar3.f1835k <= 0.0f) {
                    throw new XmlPullParserException(e2.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
                } else if (f3 > 0.0f) {
                    gVar3.f1833i = e2.getDimension(3, gVar3.f1833i);
                    float dimension = e2.getDimension(2, gVar3.f1834j);
                    gVar3.f1834j = dimension;
                    if (gVar3.f1833i <= 0.0f) {
                        throw new XmlPullParserException(e2.getPositionDescription() + "<vector> tag requires width > 0");
                    } else if (dimension > 0.0f) {
                        float alpha = gVar3.getAlpha();
                        if (e.i.b.b.h.c(xmlPullParser, "alpha")) {
                            alpha = e2.getFloat(4, alpha);
                        }
                        gVar3.setAlpha(alpha);
                        String string = e2.getString(0);
                        if (string != null) {
                            gVar3.n = string;
                            gVar3.p.put(string, gVar3);
                        }
                        e2.recycle();
                        hVar3.a = getChangingConfigurations();
                        hVar3.f1844k = true;
                        h hVar5 = this.c;
                        C0061g gVar4 = hVar5.b;
                        ArrayDeque arrayDeque3 = new ArrayDeque();
                        arrayDeque3.push(gVar4.f1832h);
                        int eventType = xmlPullParser.getEventType();
                        int depth = xmlPullParser.getDepth() + 1;
                        boolean z2 = true;
                        while (eventType != i5 && (xmlPullParser.getDepth() >= depth || eventType != i4)) {
                            if (eventType == 2) {
                                String name = xmlPullParser.getName();
                                d dVar2 = (d) arrayDeque3.peek();
                                if ("path".equals(name)) {
                                    c cVar = new c();
                                    TypedArray e3 = e.i.b.b.h.e(resources, theme, attributeSet, a.c);
                                    cVar.f1810e = null;
                                    if (!e.i.b.b.h.c(xmlPullParser, "pathData")) {
                                        arrayDeque2 = arrayDeque3;
                                        gVar2 = gVar4;
                                        hVar2 = hVar5;
                                        dVar = dVar2;
                                        i2 = depth;
                                        typedArray = e3;
                                    } else {
                                        String string2 = e3.getString(0);
                                        if (string2 != null) {
                                            cVar.b = string2;
                                        }
                                        String string3 = e3.getString(2);
                                        if (string3 != null) {
                                            cVar.a = m.h.I(string3);
                                        }
                                        arrayDeque2 = arrayDeque3;
                                        gVar2 = gVar4;
                                        hVar2 = hVar5;
                                        i2 = depth;
                                        typedArray = e3;
                                        dVar = dVar2;
                                        cVar.f1813h = e.i.b.b.h.a(e3, xmlPullParser, theme, "fillColor", 1, 0);
                                        float f4 = cVar.f1815j;
                                        if (e.i.b.b.h.c(xmlPullParser, "fillAlpha")) {
                                            f4 = typedArray.getFloat(12, f4);
                                        }
                                        cVar.f1815j = f4;
                                        int i7 = !e.i.b.b.h.c(xmlPullParser, "strokeLineCap") ? -1 : typedArray.getInt(8, -1);
                                        Paint.Cap cap = cVar.n;
                                        if (i7 == 0) {
                                            cap = Paint.Cap.BUTT;
                                        } else if (i7 == 1) {
                                            cap = Paint.Cap.ROUND;
                                        } else if (i7 == 2) {
                                            cap = Paint.Cap.SQUARE;
                                        }
                                        cVar.n = cap;
                                        int i8 = !e.i.b.b.h.c(xmlPullParser, "strokeLineJoin") ? -1 : typedArray.getInt(9, -1);
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
                                        if (e.i.b.b.h.c(xmlPullParser, "strokeMiterLimit")) {
                                            f5 = typedArray.getFloat(10, f5);
                                        }
                                        cVar.p = f5;
                                        cVar.f1811f = e.i.b.b.h.a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                                        float f6 = cVar.f1814i;
                                        if (e.i.b.b.h.c(xmlPullParser, "strokeAlpha")) {
                                            f6 = typedArray.getFloat(11, f6);
                                        }
                                        cVar.f1814i = f6;
                                        float f7 = cVar.f1812g;
                                        if (e.i.b.b.h.c(xmlPullParser, "strokeWidth")) {
                                            f7 = typedArray.getFloat(4, f7);
                                        }
                                        cVar.f1812g = f7;
                                        float f8 = cVar.f1817l;
                                        if (e.i.b.b.h.c(xmlPullParser, "trimPathEnd")) {
                                            f8 = typedArray.getFloat(6, f8);
                                        }
                                        cVar.f1817l = f8;
                                        float f9 = cVar.m;
                                        if (e.i.b.b.h.c(xmlPullParser, "trimPathOffset")) {
                                            f9 = typedArray.getFloat(7, f9);
                                        }
                                        cVar.m = f9;
                                        float f10 = cVar.f1816k;
                                        if (e.i.b.b.h.c(xmlPullParser, "trimPathStart")) {
                                            f10 = typedArray.getFloat(5, f10);
                                        }
                                        cVar.f1816k = f10;
                                        int i9 = cVar.c;
                                        if (e.i.b.b.h.c(xmlPullParser, "fillType")) {
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
                                    hVar.a |= cVar.f1827d;
                                    arrayDeque = arrayDeque2;
                                    i5 = 1;
                                    z2 = false;
                                } else {
                                    gVar = gVar4;
                                    hVar = hVar5;
                                    i2 = depth;
                                    if ("clip-path".equals(name)) {
                                        b bVar = new b();
                                        if (e.i.b.b.h.c(xmlPullParser, "pathData")) {
                                            TypedArray e4 = e.i.b.b.h.e(resources, theme, attributeSet, a.f1788d);
                                            String string4 = e4.getString(0);
                                            if (string4 != null) {
                                                bVar.b = string4;
                                            }
                                            String string5 = e4.getString(1);
                                            if (string5 != null) {
                                                bVar.a = m.h.I(string5);
                                            }
                                            bVar.c = !e.i.b.b.h.c(xmlPullParser, "fillType") ? 0 : e4.getInt(2, 0);
                                            e4.recycle();
                                        }
                                        dVar2.b.add(bVar);
                                        if (bVar.getPathName() != null) {
                                            gVar.p.put(bVar.getPathName(), bVar);
                                        }
                                        hVar.a = bVar.f1827d | hVar.a;
                                    } else if ("group".equals(name)) {
                                        d dVar3 = new d();
                                        TypedArray e5 = e.i.b.b.h.e(resources, theme, attributeSet, a.b);
                                        dVar3.f1826l = null;
                                        float f11 = dVar3.c;
                                        if (e.i.b.b.h.c(xmlPullParser, "rotation")) {
                                            f11 = e5.getFloat(5, f11);
                                        }
                                        dVar3.c = f11;
                                        i5 = 1;
                                        dVar3.f1818d = e5.getFloat(1, dVar3.f1818d);
                                        dVar3.f1819e = e5.getFloat(2, dVar3.f1819e);
                                        float f12 = dVar3.f1820f;
                                        if (e.i.b.b.h.c(xmlPullParser, "scaleX")) {
                                            f12 = e5.getFloat(3, f12);
                                        }
                                        dVar3.f1820f = f12;
                                        float f13 = dVar3.f1821g;
                                        if (e.i.b.b.h.c(xmlPullParser, "scaleY")) {
                                            f13 = e5.getFloat(4, f13);
                                        }
                                        dVar3.f1821g = f13;
                                        float f14 = dVar3.f1822h;
                                        if (e.i.b.b.h.c(xmlPullParser, "translateX")) {
                                            f14 = e5.getFloat(6, f14);
                                        }
                                        dVar3.f1822h = f14;
                                        float f15 = dVar3.f1823i;
                                        if (e.i.b.b.h.c(xmlPullParser, "translateY")) {
                                            f15 = e5.getFloat(7, f15);
                                        }
                                        dVar3.f1823i = f15;
                                        String string6 = e5.getString(0);
                                        if (string6 != null) {
                                            dVar3.m = string6;
                                        }
                                        dVar3.c();
                                        e5.recycle();
                                        dVar2.b.add(dVar3);
                                        arrayDeque = arrayDeque3;
                                        arrayDeque.push(dVar3);
                                        if (dVar3.getGroupName() != null) {
                                            gVar.p.put(dVar3.getGroupName(), dVar3);
                                        }
                                        hVar.a = dVar3.f1825k | hVar.a;
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
                            this.f1803d = b(hVar3.c, hVar3.f1837d);
                            return;
                        }
                        throw new XmlPullParserException("no path defined");
                    } else {
                        throw new XmlPullParserException(e2.getPositionDescription() + "<vector> tag requires height > 0");
                    }
                } else {
                    throw new XmlPullParserException(e2.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
                }
            } else {
                colorStateList = ColorStateList.valueOf(typedValue.data);
                if (colorStateList != null) {
                }
                boolean z3 = hVar4.f1838e;
                if (e.i.b.b.h.c(xmlPullParser, "autoMirrored")) {
                }
                hVar4.f1838e = z3;
                float f22 = gVar3.f1835k;
                if (e.i.b.b.h.c(xmlPullParser, "viewportWidth")) {
                }
                gVar3.f1835k = f22;
                float f32 = gVar3.f1836l;
                if (e.i.b.b.h.c(xmlPullParser, "viewportHeight")) {
                }
                gVar3.f1836l = f32;
                if (gVar3.f1835k <= 0.0f) {
                }
            }
        }
        colorStateList = null;
        if (colorStateList != null) {
        }
        boolean z32 = hVar4.f1838e;
        if (e.i.b.b.h.c(xmlPullParser, "autoMirrored")) {
        }
        hVar4.f1838e = z32;
        float f222 = gVar3.f1835k;
        if (e.i.b.b.h.c(xmlPullParser, "viewportWidth")) {
        }
        gVar3.f1835k = f222;
        float f322 = gVar3.f1836l;
        if (e.i.b.b.h.c(xmlPullParser, "viewportHeight")) {
        }
        gVar3.f1836l = f322;
        if (gVar3.f1835k <= 0.0f) {
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
        return this.c.f1838e;
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
        if (!this.f1805f && super.mutate() == this) {
            this.c = new h(this.c);
            this.f1805f = true;
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
        if (!(colorStateList == null || (mode = hVar.f1837d) == null)) {
            this.f1803d = b(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.a()) {
            boolean b2 = hVar.b.f1832h.b(iArr);
            hVar.f1844k |= b2;
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
            this.c.f1838e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f1804e = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.h.k1(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.h.l1(drawable, colorStateList);
            return;
        }
        h hVar = this.c;
        if (hVar.c != colorStateList) {
            hVar.c = colorStateList;
            this.f1803d = b(colorStateList, hVar.f1837d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.h.m1(drawable, mode);
            return;
        }
        h hVar = this.c;
        if (hVar.f1837d != mode) {
            hVar.f1837d = mode;
            this.f1803d = b(hVar.c, mode);
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
