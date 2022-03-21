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
import android.util.Log;
import android.util.TypedValue;
import e.b.a.m;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends f {

    /* renamed from: k  reason: collision with root package name */
    public static final PorterDuff.Mode f1953k = PorterDuff.Mode.SRC_IN;
    public h c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuffColorFilter f1954d;

    /* renamed from: e  reason: collision with root package name */
    public ColorFilter f1955e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1956f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1957g;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f1958h;

    /* renamed from: i  reason: collision with root package name */
    public final Matrix f1959i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f1960j;

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
        public int[] f1961e;

        /* renamed from: f  reason: collision with root package name */
        public e.i.b.b.a f1962f;

        /* renamed from: g  reason: collision with root package name */
        public float f1963g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public e.i.b.b.a f1964h;

        /* renamed from: i  reason: collision with root package name */
        public float f1965i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f1966j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f1967k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f1968l = 1.0f;
        public float m = 0.0f;
        public Paint.Cap n = Paint.Cap.BUTT;
        public Paint.Join o = Paint.Join.MITER;
        public float p = 4.0f;

        public c() {
        }

        public c(c cVar) {
            super(cVar);
            this.f1961e = cVar.f1961e;
            this.f1962f = cVar.f1962f;
            this.f1963g = cVar.f1963g;
            this.f1965i = cVar.f1965i;
            this.f1964h = cVar.f1964h;
            this.c = cVar.c;
            this.f1966j = cVar.f1966j;
            this.f1967k = cVar.f1967k;
            this.f1968l = cVar.f1968l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        @Override // e.x.a.a.g.e
        public boolean a() {
            return this.f1964h.c() || this.f1962f.c();
        }

        @Override // e.x.a.a.g.e
        public boolean b(int[] iArr) {
            return this.f1962f.d(iArr) | this.f1964h.d(iArr);
        }

        public float getFillAlpha() {
            return this.f1966j;
        }

        public int getFillColor() {
            return this.f1964h.c;
        }

        public float getStrokeAlpha() {
            return this.f1965i;
        }

        public int getStrokeColor() {
            return this.f1962f.c;
        }

        public float getStrokeWidth() {
            return this.f1963g;
        }

        public float getTrimPathEnd() {
            return this.f1968l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.f1967k;
        }

        public void setFillAlpha(float f2) {
            this.f1966j = f2;
        }

        public void setFillColor(int i2) {
            this.f1964h.c = i2;
        }

        public void setStrokeAlpha(float f2) {
            this.f1965i = f2;
        }

        public void setStrokeColor(int i2) {
            this.f1962f.c = i2;
        }

        public void setStrokeWidth(float f2) {
            this.f1963g = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.f1968l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.f1967k = f2;
        }
    }

    public static class d extends e {
        public final Matrix a;
        public final ArrayList<e> b;
        public float c;

        /* renamed from: d  reason: collision with root package name */
        public float f1969d;

        /* renamed from: e  reason: collision with root package name */
        public float f1970e;

        /* renamed from: f  reason: collision with root package name */
        public float f1971f;

        /* renamed from: g  reason: collision with root package name */
        public float f1972g;

        /* renamed from: h  reason: collision with root package name */
        public float f1973h;

        /* renamed from: i  reason: collision with root package name */
        public float f1974i;

        /* renamed from: j  reason: collision with root package name */
        public final Matrix f1975j;

        /* renamed from: k  reason: collision with root package name */
        public int f1976k;

        /* renamed from: l  reason: collision with root package name */
        public int[] f1977l;
        public String m;

        public d() {
            super(null);
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.f1969d = 0.0f;
            this.f1970e = 0.0f;
            this.f1971f = 1.0f;
            this.f1972g = 1.0f;
            this.f1973h = 0.0f;
            this.f1974i = 0.0f;
            this.f1975j = new Matrix();
            this.m = null;
        }

        public d(d dVar, e.e.a<String, Object> aVar) {
            super(null);
            f fVar;
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.f1969d = 0.0f;
            this.f1970e = 0.0f;
            this.f1971f = 1.0f;
            this.f1972g = 1.0f;
            this.f1973h = 0.0f;
            this.f1974i = 0.0f;
            Matrix matrix = new Matrix();
            this.f1975j = matrix;
            this.m = null;
            this.c = dVar.c;
            this.f1969d = dVar.f1969d;
            this.f1970e = dVar.f1970e;
            this.f1971f = dVar.f1971f;
            this.f1972g = dVar.f1972g;
            this.f1973h = dVar.f1973h;
            this.f1974i = dVar.f1974i;
            this.f1977l = dVar.f1977l;
            String str = dVar.m;
            this.m = str;
            this.f1976k = dVar.f1976k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f1975j);
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
            this.f1975j.reset();
            this.f1975j.postTranslate(-this.f1969d, -this.f1970e);
            this.f1975j.postScale(this.f1971f, this.f1972g);
            this.f1975j.postRotate(this.c, 0.0f, 0.0f);
            this.f1975j.postTranslate(this.f1973h + this.f1969d, this.f1974i + this.f1970e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f1975j;
        }

        public float getPivotX() {
            return this.f1969d;
        }

        public float getPivotY() {
            return this.f1970e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f1971f;
        }

        public float getScaleY() {
            return this.f1972g;
        }

        public float getTranslateX() {
            return this.f1973h;
        }

        public float getTranslateY() {
            return this.f1974i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f1969d) {
                this.f1969d = f2;
                c();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f1970e) {
                this.f1970e = f2;
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
            if (f2 != this.f1971f) {
                this.f1971f = f2;
                c();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f1972g) {
                this.f1972g = f2;
                c();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f1973h) {
                this.f1973h = f2;
                c();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f1974i) {
                this.f1974i = f2;
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
        public int f1978d;

        public f() {
            super(null);
        }

        public f(f fVar) {
            super(null);
            this.b = fVar.b;
            this.f1978d = fVar.f1978d;
            this.a = m.h.Q(fVar.a);
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
                this.a = m.h.Q(cVarArr);
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
    public static class C0062g {
        public static final Matrix q = new Matrix();
        public final Path a;
        public final Path b;
        public final Matrix c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f1979d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f1980e;

        /* renamed from: f  reason: collision with root package name */
        public PathMeasure f1981f;

        /* renamed from: g  reason: collision with root package name */
        public int f1982g;

        /* renamed from: h  reason: collision with root package name */
        public final d f1983h;

        /* renamed from: i  reason: collision with root package name */
        public float f1984i;

        /* renamed from: j  reason: collision with root package name */
        public float f1985j;

        /* renamed from: k  reason: collision with root package name */
        public float f1986k;

        /* renamed from: l  reason: collision with root package name */
        public float f1987l;
        public int m;
        public String n;
        public Boolean o;
        public final e.e.a<String, Object> p;

        public C0062g() {
            this.c = new Matrix();
            this.f1984i = 0.0f;
            this.f1985j = 0.0f;
            this.f1986k = 0.0f;
            this.f1987l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new e.e.a<>();
            this.f1983h = new d();
            this.a = new Path();
            this.b = new Path();
        }

        public C0062g(C0062g gVar) {
            this.c = new Matrix();
            this.f1984i = 0.0f;
            this.f1985j = 0.0f;
            this.f1986k = 0.0f;
            this.f1987l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            e.e.a<String, Object> aVar = new e.e.a<>();
            this.p = aVar;
            this.f1983h = new d(gVar.f1983h, aVar);
            this.a = new Path(gVar.a);
            this.b = new Path(gVar.b);
            this.f1984i = gVar.f1984i;
            this.f1985j = gVar.f1985j;
            this.f1986k = gVar.f1986k;
            this.f1987l = gVar.f1987l;
            this.f1982g = gVar.f1982g;
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
            C0062g gVar;
            C0062g gVar2 = this;
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.f1975j);
            canvas.save();
            ?? r11 = 0;
            int i4 = 0;
            while (i4 < dVar.b.size()) {
                e eVar = dVar.b.get(i4);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    f fVar = (f) eVar;
                    float f2 = ((float) i2) / gVar2.f1986k;
                    float f3 = ((float) i3) / gVar2.f1987l;
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
                            float f5 = cVar.f1967k;
                            if (!(f5 == 0.0f && cVar.f1968l == 1.0f)) {
                                float f6 = cVar.m;
                                float f7 = (f5 + f6) % 1.0f;
                                float f8 = (cVar.f1968l + f6) % 1.0f;
                                if (gVar.f1981f == null) {
                                    gVar.f1981f = new PathMeasure();
                                }
                                gVar.f1981f.setPath(gVar.a, r11);
                                float length = gVar.f1981f.getLength();
                                float f9 = f7 * length;
                                float f10 = f8 * length;
                                path2.reset();
                                if (f9 > f10) {
                                    gVar.f1981f.getSegment(f9, length, path2, true);
                                    gVar.f1981f.getSegment(0.0f, f10, path2, true);
                                } else {
                                    gVar.f1981f.getSegment(f9, f10, path2, true);
                                }
                                path2.rLineTo(0.0f, 0.0f);
                            }
                            gVar.b.addPath(path2, gVar.c);
                            e.i.b.b.a aVar = cVar.f1964h;
                            if (aVar.b() || aVar.c != 0) {
                                e.i.b.b.a aVar2 = cVar.f1964h;
                                if (gVar.f1980e == null) {
                                    Paint paint = new Paint(1);
                                    gVar.f1980e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = gVar.f1980e;
                                if (aVar2.b()) {
                                    Shader shader = aVar2.a;
                                    shader.setLocalMatrix(gVar.c);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(cVar.f1966j * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i5 = aVar2.c;
                                    float f11 = cVar.f1966j;
                                    PorterDuff.Mode mode = g.f1953k;
                                    paint2.setColor((i5 & 16777215) | (((int) (((float) Color.alpha(i5)) * f11)) << 24));
                                }
                                paint2.setColorFilter(colorFilter);
                                gVar.b.setFillType(cVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(gVar.b, paint2);
                            }
                            e.i.b.b.a aVar3 = cVar.f1962f;
                            if (aVar3.b() || aVar3.c != 0) {
                                e.i.b.b.a aVar4 = cVar.f1962f;
                                if (gVar.f1979d == null) {
                                    Paint paint3 = new Paint(1);
                                    gVar.f1979d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = gVar.f1979d;
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
                                    paint4.setAlpha(Math.round(cVar.f1965i * 255.0f));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i6 = aVar4.c;
                                    float f12 = cVar.f1965i;
                                    PorterDuff.Mode mode2 = g.f1953k;
                                    paint4.setColor((i6 & 16777215) | (((int) (((float) Color.alpha(i6)) * f12)) << 24));
                                }
                                paint4.setColorFilter(colorFilter);
                                paint4.setStrokeWidth(cVar.f1963g * abs * min);
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
        public C0062g b;
        public ColorStateList c;

        /* renamed from: d  reason: collision with root package name */
        public PorterDuff.Mode f1988d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1989e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f1990f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f1991g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f1992h;

        /* renamed from: i  reason: collision with root package name */
        public int f1993i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f1994j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f1995k;

        /* renamed from: l  reason: collision with root package name */
        public Paint f1996l;

        public h() {
            this.c = null;
            this.f1988d = g.f1953k;
            this.b = new C0062g();
        }

        public h(h hVar) {
            this.c = null;
            this.f1988d = g.f1953k;
            if (hVar != null) {
                this.a = hVar.a;
                C0062g gVar = new C0062g(hVar.b);
                this.b = gVar;
                if (hVar.b.f1980e != null) {
                    gVar.f1980e = new Paint(hVar.b.f1980e);
                }
                if (hVar.b.f1979d != null) {
                    this.b.f1979d = new Paint(hVar.b.f1979d);
                }
                this.c = hVar.c;
                this.f1988d = hVar.f1988d;
                this.f1989e = hVar.f1989e;
            }
        }

        public boolean a() {
            C0062g gVar = this.b;
            if (gVar.o == null) {
                gVar.o = Boolean.valueOf(gVar.f1983h.a());
            }
            return gVar.o.booleanValue();
        }

        public void b(int i2, int i3) {
            this.f1990f.eraseColor(0);
            Canvas canvas = new Canvas(this.f1990f);
            C0062g gVar = this.b;
            gVar.a(gVar.f1983h, C0062g.q, canvas, i2, i3, null);
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
        this.f1957g = true;
        this.f1958h = new float[9];
        this.f1959i = new Matrix();
        this.f1960j = new Rect();
        this.c = new h();
    }

    public g(h hVar) {
        this.f1957g = true;
        this.f1958h = new float[9];
        this.f1959i = new Matrix();
        this.f1960j = new Rect();
        this.c = hVar;
        this.f1954d = b(hVar.c, hVar.f1988d);
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
        if ((r1 == r7.getWidth() && r3 == r6.f1990f.getHeight()) == false) goto L_0x00d5;
     */
    public void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f1960j);
        if (this.f1960j.width() > 0 && this.f1960j.height() > 0) {
            ColorFilter colorFilter = this.f1955e;
            if (colorFilter == null) {
                colorFilter = this.f1954d;
            }
            canvas.getMatrix(this.f1959i);
            this.f1959i.getValues(this.f1958h);
            boolean z = false;
            float abs = Math.abs(this.f1958h[0]);
            float abs2 = Math.abs(this.f1958h[4]);
            float abs3 = Math.abs(this.f1958h[1]);
            float abs4 = Math.abs(this.f1958h[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f1960j.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f1960j.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f1960j;
                canvas.translate((float) rect.left, (float) rect.top);
                if (isAutoMirrored() && m.h.i0(this) == 1) {
                    canvas.translate((float) this.f1960j.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f1960j.offsetTo(0, 0);
                h hVar = this.c;
                Bitmap bitmap = hVar.f1990f;
                if (bitmap != null) {
                }
                hVar.f1990f = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
                hVar.f1995k = true;
                if (!this.f1957g) {
                    this.c.b(min, min2);
                } else {
                    h hVar2 = this.c;
                    if (!(!hVar2.f1995k && hVar2.f1991g == hVar2.c && hVar2.f1992h == hVar2.f1988d && hVar2.f1994j == hVar2.f1989e && hVar2.f1993i == hVar2.b.getRootAlpha())) {
                        this.c.b(min, min2);
                        h hVar3 = this.c;
                        hVar3.f1991g = hVar3.c;
                        hVar3.f1992h = hVar3.f1988d;
                        hVar3.f1993i = hVar3.b.getRootAlpha();
                        hVar3.f1994j = hVar3.f1989e;
                        hVar3.f1995k = false;
                    }
                }
                h hVar4 = this.c;
                Rect rect2 = this.f1960j;
                if (hVar4.b.getRootAlpha() < 255) {
                    z = true;
                }
                if (z || colorFilter != null) {
                    if (hVar4.f1996l == null) {
                        Paint paint2 = new Paint();
                        hVar4.f1996l = paint2;
                        paint2.setFilterBitmap(true);
                    }
                    hVar4.f1996l.setAlpha(hVar4.b.getRootAlpha());
                    hVar4.f1996l.setColorFilter(colorFilter);
                    paint = hVar4.f1996l;
                } else {
                    paint = null;
                }
                canvas.drawBitmap(hVar4.f1990f, (Rect) null, rect2, paint);
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
        return this.f1955e;
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
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.c.b.f1985j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.c.b.f1984i;
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

    /* JADX WARNING: Removed duplicated region for block: B:200:0x04d8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f7  */
    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        ColorStateList colorStateList;
        int i2;
        C0062g gVar;
        C0062g gVar2;
        ArrayDeque arrayDeque;
        d dVar;
        c cVar;
        TypedArray typedArray;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.c;
        hVar.b = new C0062g();
        TypedArray e2 = e.i.b.b.h.e(resources, theme, attributeSet, a.a);
        h hVar2 = this.c;
        C0062g gVar3 = hVar2.b;
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
        hVar2.f1988d = mode;
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
                } catch (Exception e3) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e3);
                }
                if (colorStateList != null) {
                    hVar2.c = colorStateList;
                }
                boolean z = hVar2.f1989e;
                if (e.i.b.b.h.c(xmlPullParser, "autoMirrored")) {
                    z = e2.getBoolean(5, z);
                }
                hVar2.f1989e = z;
                float f2 = gVar3.f1986k;
                if (e.i.b.b.h.c(xmlPullParser, "viewportWidth")) {
                    f2 = e2.getFloat(7, f2);
                }
                gVar3.f1986k = f2;
                float f3 = gVar3.f1987l;
                if (e.i.b.b.h.c(xmlPullParser, "viewportHeight")) {
                    f3 = e2.getFloat(8, f3);
                }
                gVar3.f1987l = f3;
                if (gVar3.f1986k <= 0.0f) {
                    throw new XmlPullParserException(e2.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
                } else if (f3 > 0.0f) {
                    gVar3.f1984i = e2.getDimension(3, gVar3.f1984i);
                    float dimension = e2.getDimension(2, gVar3.f1985j);
                    gVar3.f1985j = dimension;
                    if (gVar3.f1984i <= 0.0f) {
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
                        hVar.a = getChangingConfigurations();
                        hVar.f1995k = true;
                        h hVar3 = this.c;
                        C0062g gVar4 = hVar3.b;
                        ArrayDeque arrayDeque2 = new ArrayDeque();
                        arrayDeque2.push(gVar4.f1983h);
                        int eventType = xmlPullParser.getEventType();
                        int depth = xmlPullParser.getDepth() + 1;
                        boolean z2 = true;
                        while (eventType != i5 && (xmlPullParser.getDepth() >= depth || eventType != i4)) {
                            if (eventType == 2) {
                                String name = xmlPullParser.getName();
                                d dVar2 = (d) arrayDeque2.peek();
                                if ("path".equals(name)) {
                                    c cVar2 = new c();
                                    TypedArray e4 = e.i.b.b.h.e(resources, theme, attributeSet, a.c);
                                    cVar2.f1961e = null;
                                    if (!e.i.b.b.h.c(xmlPullParser, "pathData")) {
                                        arrayDeque = arrayDeque2;
                                        gVar2 = gVar4;
                                        typedArray = e4;
                                        cVar = cVar2;
                                        i2 = depth;
                                        dVar = dVar2;
                                    } else {
                                        String string2 = e4.getString(0);
                                        if (string2 != null) {
                                            cVar2.b = string2;
                                        }
                                        String string3 = e4.getString(2);
                                        if (string3 != null) {
                                            cVar2.a = m.h.H(string3);
                                        }
                                        arrayDeque = arrayDeque2;
                                        gVar2 = gVar4;
                                        i2 = depth;
                                        dVar = dVar2;
                                        cVar = cVar2;
                                        cVar.f1964h = e.i.b.b.h.a(e4, xmlPullParser, theme, "fillColor", 1, 0);
                                        float f4 = cVar.f1966j;
                                        if (e.i.b.b.h.c(xmlPullParser, "fillAlpha")) {
                                            f4 = e4.getFloat(12, f4);
                                        }
                                        cVar.f1966j = f4;
                                        int i7 = !e.i.b.b.h.c(xmlPullParser, "strokeLineCap") ? -1 : e4.getInt(8, -1);
                                        Paint.Cap cap = cVar.n;
                                        if (i7 == 0) {
                                            cap = Paint.Cap.BUTT;
                                        } else if (i7 == 1) {
                                            cap = Paint.Cap.ROUND;
                                        } else if (i7 == 2) {
                                            cap = Paint.Cap.SQUARE;
                                        }
                                        cVar.n = cap;
                                        int i8 = !e.i.b.b.h.c(xmlPullParser, "strokeLineJoin") ? -1 : e4.getInt(9, -1);
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
                                            f5 = e4.getFloat(10, f5);
                                        }
                                        cVar.p = f5;
                                        typedArray = e4;
                                        cVar.f1962f = e.i.b.b.h.a(e4, xmlPullParser, theme, "strokeColor", 3, 0);
                                        float f6 = cVar.f1965i;
                                        if (e.i.b.b.h.c(xmlPullParser, "strokeAlpha")) {
                                            f6 = typedArray.getFloat(11, f6);
                                        }
                                        cVar.f1965i = f6;
                                        float f7 = cVar.f1963g;
                                        if (e.i.b.b.h.c(xmlPullParser, "strokeWidth")) {
                                            f7 = typedArray.getFloat(4, f7);
                                        }
                                        cVar.f1963g = f7;
                                        float f8 = cVar.f1968l;
                                        if (e.i.b.b.h.c(xmlPullParser, "trimPathEnd")) {
                                            f8 = typedArray.getFloat(6, f8);
                                        }
                                        cVar.f1968l = f8;
                                        float f9 = cVar.m;
                                        if (e.i.b.b.h.c(xmlPullParser, "trimPathOffset")) {
                                            f9 = typedArray.getFloat(7, f9);
                                        }
                                        cVar.m = f9;
                                        float f10 = cVar.f1967k;
                                        if (e.i.b.b.h.c(xmlPullParser, "trimPathStart")) {
                                            f10 = typedArray.getFloat(5, f10);
                                        }
                                        cVar.f1967k = f10;
                                        int i9 = cVar.c;
                                        if (e.i.b.b.h.c(xmlPullParser, "fillType")) {
                                            i9 = typedArray.getInt(13, i9);
                                        }
                                        cVar.c = i9;
                                    }
                                    typedArray.recycle();
                                    dVar.b.add(cVar);
                                    if (cVar.getPathName() != null) {
                                        gVar = gVar2;
                                        gVar.p.put(cVar.getPathName(), cVar);
                                    } else {
                                        gVar = gVar2;
                                    }
                                    hVar3.a |= cVar.f1978d;
                                    arrayDeque2 = arrayDeque;
                                    z2 = false;
                                } else {
                                    gVar = gVar4;
                                    i2 = depth;
                                    if ("clip-path".equals(name)) {
                                        b bVar = new b();
                                        if (e.i.b.b.h.c(xmlPullParser, "pathData")) {
                                            TypedArray e5 = e.i.b.b.h.e(resources, theme, attributeSet, a.f1939d);
                                            String string4 = e5.getString(0);
                                            if (string4 != null) {
                                                bVar.b = string4;
                                            }
                                            String string5 = e5.getString(1);
                                            if (string5 != null) {
                                                bVar.a = m.h.H(string5);
                                            }
                                            bVar.c = !e.i.b.b.h.c(xmlPullParser, "fillType") ? 0 : e5.getInt(2, 0);
                                            e5.recycle();
                                        }
                                        dVar2.b.add(bVar);
                                        if (bVar.getPathName() != null) {
                                            gVar.p.put(bVar.getPathName(), bVar);
                                        }
                                        hVar3.a = bVar.f1978d | hVar3.a;
                                    } else if ("group".equals(name)) {
                                        d dVar3 = new d();
                                        TypedArray e6 = e.i.b.b.h.e(resources, theme, attributeSet, a.b);
                                        dVar3.f1977l = null;
                                        float f11 = dVar3.c;
                                        if (e.i.b.b.h.c(xmlPullParser, "rotation")) {
                                            f11 = e6.getFloat(5, f11);
                                        }
                                        dVar3.c = f11;
                                        dVar3.f1969d = e6.getFloat(1, dVar3.f1969d);
                                        dVar3.f1970e = e6.getFloat(2, dVar3.f1970e);
                                        float f12 = dVar3.f1971f;
                                        if (e.i.b.b.h.c(xmlPullParser, "scaleX")) {
                                            f12 = e6.getFloat(3, f12);
                                        }
                                        dVar3.f1971f = f12;
                                        float f13 = dVar3.f1972g;
                                        if (e.i.b.b.h.c(xmlPullParser, "scaleY")) {
                                            f13 = e6.getFloat(4, f13);
                                        }
                                        dVar3.f1972g = f13;
                                        float f14 = dVar3.f1973h;
                                        if (e.i.b.b.h.c(xmlPullParser, "translateX")) {
                                            f14 = e6.getFloat(6, f14);
                                        }
                                        dVar3.f1973h = f14;
                                        float f15 = dVar3.f1974i;
                                        if (e.i.b.b.h.c(xmlPullParser, "translateY")) {
                                            f15 = e6.getFloat(7, f15);
                                        }
                                        dVar3.f1974i = f15;
                                        String string6 = e6.getString(0);
                                        if (string6 != null) {
                                            dVar3.m = string6;
                                        }
                                        dVar3.c();
                                        e6.recycle();
                                        dVar2.b.add(dVar3);
                                        arrayDeque2 = arrayDeque2;
                                        arrayDeque2.push(dVar3);
                                        if (dVar3.getGroupName() != null) {
                                            gVar.p.put(dVar3.getGroupName(), dVar3);
                                        }
                                        hVar3.a = dVar3.f1976k | hVar3.a;
                                    }
                                    arrayDeque2 = arrayDeque2;
                                }
                            } else {
                                gVar = gVar4;
                                i2 = depth;
                                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                                    arrayDeque2.pop();
                                }
                            }
                            eventType = xmlPullParser.next();
                            i4 = 3;
                            i5 = 1;
                            gVar4 = gVar;
                            depth = i2;
                        }
                        if (!z2) {
                            this.f1954d = b(hVar.c, hVar.f1988d);
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
                boolean z3 = hVar2.f1989e;
                if (e.i.b.b.h.c(xmlPullParser, "autoMirrored")) {
                }
                hVar2.f1989e = z3;
                float f22 = gVar3.f1986k;
                if (e.i.b.b.h.c(xmlPullParser, "viewportWidth")) {
                }
                gVar3.f1986k = f22;
                float f32 = gVar3.f1987l;
                if (e.i.b.b.h.c(xmlPullParser, "viewportHeight")) {
                }
                gVar3.f1987l = f32;
                if (gVar3.f1986k <= 0.0f) {
                }
            }
        }
        colorStateList = null;
        if (colorStateList != null) {
        }
        boolean z32 = hVar2.f1989e;
        if (e.i.b.b.h.c(xmlPullParser, "autoMirrored")) {
        }
        hVar2.f1989e = z32;
        float f222 = gVar3.f1986k;
        if (e.i.b.b.h.c(xmlPullParser, "viewportWidth")) {
        }
        gVar3.f1986k = f222;
        float f322 = gVar3.f1987l;
        if (e.i.b.b.h.c(xmlPullParser, "viewportHeight")) {
        }
        gVar3.f1987l = f322;
        if (gVar3.f1986k <= 0.0f) {
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
        return this.c.f1989e;
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
        if (!this.f1956f && super.mutate() == this) {
            this.c = new h(this.c);
            this.f1956f = true;
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
        if (!(colorStateList == null || (mode = hVar.f1988d) == null)) {
            this.f1954d = b(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.a()) {
            boolean b2 = hVar.b.f1983h.b(iArr);
            hVar.f1995k |= b2;
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
            this.c.f1989e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f1955e = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.h.d1(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.h.e1(drawable, colorStateList);
            return;
        }
        h hVar = this.c;
        if (hVar.c != colorStateList) {
            hVar.c = colorStateList;
            this.f1954d = b(colorStateList, hVar.f1988d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.h.f1(drawable, mode);
            return;
        }
        h hVar = this.c;
        if (hVar.f1988d != mode) {
            hVar.f1988d = mode;
            this.f1954d = b(hVar.c, mode);
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
