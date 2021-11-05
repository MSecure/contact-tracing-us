package b.w.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
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
import android.util.Xml;
import b.b.k.i;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class f extends e {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    public h f1855c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuffColorFilter f1856d;

    /* renamed from: e  reason: collision with root package name */
    public ColorFilter f1857e;
    public boolean f;
    public boolean g;
    public final float[] h;
    public final Matrix i;
    public final Rect j;

    public static class b extends AbstractC0049f {
        public b() {
        }

        public b(b bVar) {
            super(bVar);
        }

        @Override // b.w.a.a.f.AbstractC0049f
        public boolean c() {
            return true;
        }
    }

    public static class c extends AbstractC0049f {

        /* renamed from: e  reason: collision with root package name */
        public int[] f1858e;
        public b.i.e.b.a f;
        public float g = 0.0f;
        public b.i.e.b.a h;
        public float i = 1.0f;
        public float j = 1.0f;
        public float k = 0.0f;
        public float l = 1.0f;
        public float m = 0.0f;
        public Paint.Cap n = Paint.Cap.BUTT;
        public Paint.Join o = Paint.Join.MITER;
        public float p = 4.0f;

        public c() {
        }

        public c(c cVar) {
            super(cVar);
            this.f1858e = cVar.f1858e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.i = cVar.i;
            this.h = cVar.h;
            this.f1866c = cVar.f1866c;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        @Override // b.w.a.a.f.e
        public boolean a() {
            return this.h.c() || this.f.c();
        }

        @Override // b.w.a.a.f.e
        public boolean b(int[] iArr) {
            return this.f.d(iArr) | this.h.d(iArr);
        }

        public float getFillAlpha() {
            return this.j;
        }

        public int getFillColor() {
            return this.h.f1028c;
        }

        public float getStrokeAlpha() {
            return this.i;
        }

        public int getStrokeColor() {
            return this.f.f1028c;
        }

        public float getStrokeWidth() {
            return this.g;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public void setFillAlpha(float f2) {
            this.j = f2;
        }

        public void setFillColor(int i2) {
            this.h.f1028c = i2;
        }

        public void setStrokeAlpha(float f2) {
            this.i = f2;
        }

        public void setStrokeColor(int i2) {
            this.f.f1028c = i2;
        }

        public void setStrokeWidth(float f2) {
            this.g = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.k = f2;
        }
    }

    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f1859a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<e> f1860b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public float f1861c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f1862d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1863e = 0.0f;
        public float f = 1.0f;
        public float g = 1.0f;
        public float h = 0.0f;
        public float i = 0.0f;
        public final Matrix j = new Matrix();
        public int k;
        public int[] l;
        public String m = null;

        public d() {
            super(null);
        }

        public d(d dVar, b.e.a<String, Object> aVar) {
            super(null);
            AbstractC0049f fVar;
            this.f1861c = dVar.f1861c;
            this.f1862d = dVar.f1862d;
            this.f1863e = dVar.f1863e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                aVar.put(str, this);
            }
            this.j.set(dVar.j);
            ArrayList<e> arrayList = dVar.f1860b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.f1860b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f1860b.add(fVar);
                    String str2 = fVar.f1865b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        @Override // b.w.a.a.f.e
        public boolean a() {
            for (int i2 = 0; i2 < this.f1860b.size(); i2++) {
                if (this.f1860b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // b.w.a.a.f.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f1860b.size(); i2++) {
                z |= this.f1860b.get(i2).b(iArr);
            }
            return z;
        }

        public final void c() {
            this.j.reset();
            this.j.postTranslate(-this.f1862d, -this.f1863e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.f1861c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.f1862d, this.i + this.f1863e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f1862d;
        }

        public float getPivotY() {
            return this.f1863e;
        }

        public float getRotation() {
            return this.f1861c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f1862d) {
                this.f1862d = f2;
                c();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f1863e) {
                this.f1863e = f2;
                c();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f1861c) {
                this.f1861c = f2;
                c();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f) {
                this.f = f2;
                c();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                c();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                c();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
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

    /* renamed from: b.w.a.a.f$f  reason: collision with other inner class name */
    public static abstract class AbstractC0049f extends e {

        /* renamed from: a  reason: collision with root package name */
        public b.i.f.c[] f1864a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f1865b;

        /* renamed from: c  reason: collision with root package name */
        public int f1866c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f1867d;

        public AbstractC0049f() {
            super(null);
        }

        public AbstractC0049f(AbstractC0049f fVar) {
            super(null);
            this.f1865b = fVar.f1865b;
            this.f1867d = fVar.f1867d;
            this.f1864a = i.j.U(fVar.f1864a);
        }

        public boolean c() {
            return false;
        }

        public b.i.f.c[] getPathData() {
            return this.f1864a;
        }

        public String getPathName() {
            return this.f1865b;
        }

        public void setPathData(b.i.f.c[] cVarArr) {
            if (!i.j.h(this.f1864a, cVarArr)) {
                this.f1864a = i.j.U(cVarArr);
                return;
            }
            b.i.f.c[] cVarArr2 = this.f1864a;
            for (int i = 0; i < cVarArr.length; i++) {
                cVarArr2[i].f1052a = cVarArr[i].f1052a;
                for (int i2 = 0; i2 < cVarArr[i].f1053b.length; i2++) {
                    cVarArr2[i].f1053b[i2] = cVarArr[i].f1053b[i2];
                }
            }
        }
    }

    public static class g {
        public static final Matrix q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        public final Path f1868a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f1869b;

        /* renamed from: c  reason: collision with root package name */
        public final Matrix f1870c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f1871d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f1872e;
        public PathMeasure f;
        public int g;
        public final d h;
        public float i;
        public float j;
        public float k;
        public float l;
        public int m;
        public String n;
        public Boolean o;
        public final b.e.a<String, Object> p;

        public g() {
            this.f1870c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new b.e.a<>();
            this.h = new d();
            this.f1868a = new Path();
            this.f1869b = new Path();
        }

        public g(g gVar) {
            this.f1870c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            b.e.a<String, Object> aVar = new b.e.a<>();
            this.p = aVar;
            this.h = new d(gVar.h, aVar);
            this.f1868a = new Path(gVar.f1868a);
            this.f1869b = new Path(gVar.f1869b);
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.g = gVar.g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                this.p.put(str, this);
            }
            this.o = gVar.o;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r14v4, resolved type: android.graphics.PathMeasure */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final void a(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            g gVar;
            g gVar2 = this;
            dVar.f1859a.set(matrix);
            dVar.f1859a.preConcat(dVar.j);
            canvas.save();
            ?? r11 = 0;
            int i4 = 0;
            while (i4 < dVar.f1860b.size()) {
                e eVar = dVar.f1860b.get(i4);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.f1859a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof AbstractC0049f) {
                    AbstractC0049f fVar = (AbstractC0049f) eVar;
                    float f2 = ((float) i2) / gVar2.k;
                    float f3 = ((float) i3) / gVar2.l;
                    float min = Math.min(f2, f3);
                    Matrix matrix2 = dVar.f1859a;
                    gVar2.f1870c.set(matrix2);
                    gVar2.f1870c.postScale(f2, f3);
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
                        Path path = gVar.f1868a;
                        if (fVar != null) {
                            path.reset();
                            b.i.f.c[] cVarArr = fVar.f1864a;
                            if (cVarArr != null) {
                                b.i.f.c.b(cVarArr, path);
                            }
                            Path path2 = gVar.f1868a;
                            gVar.f1869b.reset();
                            if (fVar.c()) {
                                gVar.f1869b.setFillType(fVar.f1866c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                gVar.f1869b.addPath(path2, gVar.f1870c);
                                canvas.clipPath(gVar.f1869b);
                            } else {
                                c cVar = (c) fVar;
                                if (!(cVar.k == 0.0f && cVar.l == 1.0f)) {
                                    float f5 = cVar.k;
                                    float f6 = cVar.m;
                                    float f7 = (f5 + f6) % 1.0f;
                                    float f8 = (cVar.l + f6) % 1.0f;
                                    if (gVar.f == null) {
                                        gVar.f = new PathMeasure();
                                    }
                                    gVar.f.setPath(gVar.f1868a, r11);
                                    float length = gVar.f.getLength();
                                    float f9 = f7 * length;
                                    float f10 = f8 * length;
                                    path2.reset();
                                    if (f9 > f10) {
                                        gVar.f.getSegment(f9, length, path2, true);
                                        gVar.f.getSegment(0.0f, f10, path2, true);
                                    } else {
                                        gVar.f.getSegment(f9, f10, path2, true);
                                    }
                                    path2.rLineTo(0.0f, 0.0f);
                                }
                                gVar.f1869b.addPath(path2, gVar.f1870c);
                                b.i.e.b.a aVar = cVar.h;
                                if (aVar.b() || aVar.f1028c != 0) {
                                    b.i.e.b.a aVar2 = cVar.h;
                                    if (gVar.f1872e == null) {
                                        Paint paint = new Paint(1);
                                        gVar.f1872e = paint;
                                        paint.setStyle(Paint.Style.FILL);
                                    }
                                    Paint paint2 = gVar.f1872e;
                                    if (aVar2.b()) {
                                        Shader shader = aVar2.f1026a;
                                        shader.setLocalMatrix(gVar.f1870c);
                                        paint2.setShader(shader);
                                        paint2.setAlpha(Math.round(cVar.j * 255.0f));
                                    } else {
                                        paint2.setShader(null);
                                        paint2.setAlpha(255);
                                        paint2.setColor(f.a(aVar2.f1028c, cVar.j));
                                    }
                                    paint2.setColorFilter(colorFilter);
                                    gVar.f1869b.setFillType(cVar.f1866c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                    canvas.drawPath(gVar.f1869b, paint2);
                                }
                                b.i.e.b.a aVar3 = cVar.f;
                                if (aVar3.b() || aVar3.f1028c != 0) {
                                    b.i.e.b.a aVar4 = cVar.f;
                                    if (gVar.f1871d == null) {
                                        Paint paint3 = new Paint(1);
                                        gVar.f1871d = paint3;
                                        paint3.setStyle(Paint.Style.STROKE);
                                    }
                                    Paint paint4 = gVar.f1871d;
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
                                        Shader shader2 = aVar4.f1026a;
                                        shader2.setLocalMatrix(gVar.f1870c);
                                        paint4.setShader(shader2);
                                        paint4.setAlpha(Math.round(cVar.i * 255.0f));
                                    } else {
                                        paint4.setShader(null);
                                        paint4.setAlpha(255);
                                        paint4.setColor(f.a(aVar4.f1028c, cVar.i));
                                    }
                                    paint4.setColorFilter(colorFilter);
                                    paint4.setStrokeWidth(cVar.g * abs * min);
                                    canvas.drawPath(gVar.f1869b, paint4);
                                }
                            }
                        } else {
                            throw null;
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

        /* renamed from: a  reason: collision with root package name */
        public int f1873a;

        /* renamed from: b  reason: collision with root package name */
        public g f1874b;

        /* renamed from: c  reason: collision with root package name */
        public ColorStateList f1875c;

        /* renamed from: d  reason: collision with root package name */
        public PorterDuff.Mode f1876d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1877e;
        public Bitmap f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public int i;
        public boolean j;
        public boolean k;
        public Paint l;

        public h() {
            this.f1875c = null;
            this.f1876d = f.k;
            this.f1874b = new g();
        }

        public h(h hVar) {
            this.f1875c = null;
            this.f1876d = f.k;
            if (hVar != null) {
                this.f1873a = hVar.f1873a;
                g gVar = new g(hVar.f1874b);
                this.f1874b = gVar;
                if (hVar.f1874b.f1872e != null) {
                    gVar.f1872e = new Paint(hVar.f1874b.f1872e);
                }
                if (hVar.f1874b.f1871d != null) {
                    this.f1874b.f1871d = new Paint(hVar.f1874b.f1871d);
                }
                this.f1875c = hVar.f1875c;
                this.f1876d = hVar.f1876d;
                this.f1877e = hVar.f1877e;
            }
        }

        public boolean a() {
            g gVar = this.f1874b;
            if (gVar.o == null) {
                gVar.o = Boolean.valueOf(gVar.h.a());
            }
            return gVar.o.booleanValue();
        }

        public void b(int i2, int i3) {
            this.f.eraseColor(0);
            Canvas canvas = new Canvas(this.f);
            g gVar = this.f1874b;
            gVar.a(gVar.h, g.q, canvas, i2, i3, null);
        }

        public int getChangingConfigurations() {
            return this.f1873a;
        }

        public Drawable newDrawable() {
            return new f(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new f(this);
        }
    }

    public static class i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f1878a;

        public i(Drawable.ConstantState constantState) {
            this.f1878a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f1878a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f1878a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            f fVar = new f();
            fVar.f1854b = (VectorDrawable) this.f1878a.newDrawable();
            return fVar;
        }

        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f1854b = (VectorDrawable) this.f1878a.newDrawable(resources);
            return fVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f1854b = (VectorDrawable) this.f1878a.newDrawable(resources, theme);
            return fVar;
        }
    }

    public f() {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f1855c = new h();
    }

    public f(h hVar) {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f1855c = hVar;
        this.f1856d = d(hVar.f1875c, hVar.f1876d);
    }

    public static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032 A[Catch:{ IOException | XmlPullParserException -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A[Catch:{ IOException | XmlPullParserException -> 0x003f }] */
    public static f b(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            f fVar = new f();
            fVar.f1854b = resources.getDrawable(i2, theme);
            new i(fVar.f1854b.getConstantState());
            return fVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    if (next != 2) {
                        return c(resources, xml, asAttributeSet, theme);
                    }
                    throw new XmlPullParserException("No start tag found");
                }
            }
            if (next != 2) {
            }
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
    }

    public static f c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        f fVar = new f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f1854b;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    public PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if ((r1 == r7.getWidth() && r3 == r6.f.getHeight()) == false) goto L_0x00d1;
     */
    public void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.j);
        if (this.j.width() > 0 && this.j.height() > 0) {
            ColorFilter colorFilter = this.f1857e;
            if (colorFilter == null) {
                colorFilter = this.f1856d;
            }
            canvas.getMatrix(this.i);
            this.i.getValues(this.h);
            boolean z = false;
            float abs = Math.abs(this.h[0]);
            float abs2 = Math.abs(this.h[4]);
            float abs3 = Math.abs(this.h[1]);
            float abs4 = Math.abs(this.h[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.j.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.j.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.j;
                canvas.translate((float) rect.left, (float) rect.top);
                if (isAutoMirrored() && getLayoutDirection() == 1) {
                    canvas.translate((float) this.j.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.j.offsetTo(0, 0);
                h hVar = this.f1855c;
                Bitmap bitmap = hVar.f;
                if (bitmap != null) {
                }
                hVar.f = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
                hVar.k = true;
                if (!this.g) {
                    this.f1855c.b(min, min2);
                } else {
                    h hVar2 = this.f1855c;
                    if (!(!hVar2.k && hVar2.g == hVar2.f1875c && hVar2.h == hVar2.f1876d && hVar2.j == hVar2.f1877e && hVar2.i == hVar2.f1874b.getRootAlpha())) {
                        this.f1855c.b(min, min2);
                        h hVar3 = this.f1855c;
                        hVar3.g = hVar3.f1875c;
                        hVar3.h = hVar3.f1876d;
                        hVar3.i = hVar3.f1874b.getRootAlpha();
                        hVar3.j = hVar3.f1877e;
                        hVar3.k = false;
                    }
                }
                h hVar4 = this.f1855c;
                Rect rect2 = this.j;
                if (hVar4.f1874b.getRootAlpha() < 255) {
                    z = true;
                }
                if (z || colorFilter != null) {
                    if (hVar4.l == null) {
                        Paint paint2 = new Paint();
                        hVar4.l = paint2;
                        paint2.setFilterBitmap(true);
                    }
                    hVar4.l.setAlpha(hVar4.f1874b.getRootAlpha());
                    hVar4.l.setColorFilter(colorFilter);
                    paint = hVar4.l;
                } else {
                    paint = null;
                }
                canvas.drawBitmap(hVar4.f, (Rect) null, rect2, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.f1855c.f1874b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f1855c.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.f1857e;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f1854b != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f1854b.getConstantState());
        }
        this.f1855c.f1873a = getChangingConfigurations();
        return this.f1855c;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f1855c.f1874b.j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f1855c.f1874b.i;
    }

    public int getOpacity() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x0430  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d8  */
    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        ColorStateList colorStateList;
        int i2;
        int i3;
        ArrayDeque arrayDeque;
        h hVar;
        g gVar;
        boolean z;
        h hVar2;
        g gVar2;
        ArrayDeque arrayDeque2;
        TypedArray typedArray;
        d dVar;
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar3 = this.f1855c;
        hVar3.f1874b = new g();
        TypedArray C0 = i.j.C0(resources, theme, attributeSet, a.f1837a);
        h hVar4 = this.f1855c;
        g gVar3 = hVar4.f1874b;
        int h0 = i.j.h0(C0, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i4 = 3;
        if (h0 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (h0 != 5) {
            if (h0 != 9) {
                switch (h0) {
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
        hVar4.f1876d = mode;
        boolean z2 = false;
        int i5 = 1;
        if (i.j.q0(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            C0.getValue(1, typedValue);
            int i6 = typedValue.type;
            if (i6 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index " + 1 + ": " + typedValue);
            } else if (i6 < 28 || i6 > 31) {
                Resources resources2 = C0.getResources();
                try {
                    colorStateList = i.j.H(resources2, resources2.getXml(C0.getResourceId(1, 0)), theme);
                } catch (Exception unused) {
                }
                if (colorStateList != null) {
                    hVar4.f1875c = colorStateList;
                }
                boolean z3 = hVar4.f1877e;
                if (i.j.q0(xmlPullParser, "autoMirrored")) {
                    z3 = C0.getBoolean(5, z3);
                }
                hVar4.f1877e = z3;
                gVar3.k = i.j.g0(C0, xmlPullParser, "viewportWidth", 7, gVar3.k);
                float g0 = i.j.g0(C0, xmlPullParser, "viewportHeight", 8, gVar3.l);
                gVar3.l = g0;
                if (gVar3.k <= 0.0f) {
                    throw new XmlPullParserException(C0.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
                } else if (g0 > 0.0f) {
                    gVar3.i = C0.getDimension(3, gVar3.i);
                    float dimension = C0.getDimension(2, gVar3.j);
                    gVar3.j = dimension;
                    if (gVar3.i <= 0.0f) {
                        throw new XmlPullParserException(C0.getPositionDescription() + "<vector> tag requires width > 0");
                    } else if (dimension > 0.0f) {
                        gVar3.setAlpha(i.j.g0(C0, xmlPullParser, "alpha", 4, gVar3.getAlpha()));
                        String string = C0.getString(0);
                        if (string != null) {
                            gVar3.n = string;
                            gVar3.p.put(string, gVar3);
                        }
                        C0.recycle();
                        hVar3.f1873a = getChangingConfigurations();
                        hVar3.k = true;
                        h hVar5 = this.f1855c;
                        g gVar4 = hVar5.f1874b;
                        ArrayDeque arrayDeque3 = new ArrayDeque();
                        arrayDeque3.push(gVar4.h);
                        int eventType = xmlPullParser.getEventType();
                        int depth = xmlPullParser.getDepth() + 1;
                        boolean z4 = true;
                        while (eventType != i5 && (xmlPullParser.getDepth() >= depth || eventType != i4)) {
                            if (eventType == 2) {
                                String name = xmlPullParser.getName();
                                d dVar2 = (d) arrayDeque3.peek();
                                if ("path".equals(name)) {
                                    c cVar = new c();
                                    TypedArray C02 = i.j.C0(resources, theme, attributeSet, a.f1839c);
                                    cVar.f1858e = null;
                                    if (!i.j.q0(xmlPullParser, "pathData")) {
                                        arrayDeque2 = arrayDeque3;
                                        gVar2 = gVar4;
                                        hVar2 = hVar5;
                                        dVar = dVar2;
                                        i2 = depth;
                                        typedArray = C02;
                                    } else {
                                        String string2 = C02.getString(0);
                                        if (string2 != null) {
                                            cVar.f1865b = string2;
                                        }
                                        String string3 = C02.getString(2);
                                        if (string3 != null) {
                                            cVar.f1864a = i.j.N(string3);
                                        }
                                        arrayDeque2 = arrayDeque3;
                                        gVar2 = gVar4;
                                        hVar2 = hVar5;
                                        i2 = depth;
                                        typedArray = C02;
                                        dVar = dVar2;
                                        cVar.h = i.j.f0(C02, xmlPullParser, theme, "fillColor", 1, 0);
                                        cVar.j = i.j.g0(typedArray, xmlPullParser, "fillAlpha", 12, cVar.j);
                                        int h02 = i.j.h0(typedArray, xmlPullParser, "strokeLineCap", 8, -1);
                                        Paint.Cap cap = cVar.n;
                                        if (h02 == 0) {
                                            cap = Paint.Cap.BUTT;
                                        } else if (h02 == 1) {
                                            cap = Paint.Cap.ROUND;
                                        } else if (h02 == 2) {
                                            cap = Paint.Cap.SQUARE;
                                        }
                                        cVar.n = cap;
                                        int h03 = i.j.h0(typedArray, xmlPullParser, "strokeLineJoin", 9, -1);
                                        Paint.Join join = cVar.o;
                                        if (h03 == 0) {
                                            join = Paint.Join.MITER;
                                        } else if (h03 == 1) {
                                            join = Paint.Join.ROUND;
                                        } else if (h03 == 2) {
                                            join = Paint.Join.BEVEL;
                                        }
                                        cVar.o = join;
                                        cVar.p = i.j.g0(typedArray, xmlPullParser, "strokeMiterLimit", 10, cVar.p);
                                        cVar.f = i.j.f0(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                                        cVar.i = i.j.g0(typedArray, xmlPullParser, "strokeAlpha", 11, cVar.i);
                                        cVar.g = i.j.g0(typedArray, xmlPullParser, "strokeWidth", 4, cVar.g);
                                        cVar.l = i.j.g0(typedArray, xmlPullParser, "trimPathEnd", 6, cVar.l);
                                        cVar.m = i.j.g0(typedArray, xmlPullParser, "trimPathOffset", 7, cVar.m);
                                        cVar.k = i.j.g0(typedArray, xmlPullParser, "trimPathStart", 5, cVar.k);
                                        cVar.f1866c = i.j.h0(typedArray, xmlPullParser, "fillType", 13, cVar.f1866c);
                                    }
                                    typedArray.recycle();
                                    dVar.f1860b.add(cVar);
                                    gVar = gVar2;
                                    if (cVar.getPathName() != null) {
                                        gVar.p.put(cVar.getPathName(), cVar);
                                    }
                                    hVar = hVar2;
                                    hVar.f1873a |= cVar.f1867d;
                                    arrayDeque = arrayDeque2;
                                    z = false;
                                    i3 = 3;
                                    z4 = false;
                                } else {
                                    gVar = gVar4;
                                    hVar = hVar5;
                                    i2 = depth;
                                    if ("clip-path".equals(name)) {
                                        b bVar = new b();
                                        if (i.j.q0(xmlPullParser, "pathData")) {
                                            TypedArray C03 = i.j.C0(resources, theme, attributeSet, a.f1840d);
                                            String string4 = C03.getString(0);
                                            if (string4 != null) {
                                                bVar.f1865b = string4;
                                            }
                                            String string5 = C03.getString(1);
                                            if (string5 != null) {
                                                bVar.f1864a = i.j.N(string5);
                                            }
                                            bVar.f1866c = i.j.h0(C03, xmlPullParser, "fillType", 2, 0);
                                            C03.recycle();
                                        }
                                        dVar2.f1860b.add(bVar);
                                        if (bVar.getPathName() != null) {
                                            gVar.p.put(bVar.getPathName(), bVar);
                                        }
                                        hVar.f1873a = bVar.f1867d | hVar.f1873a;
                                    } else if ("group".equals(name)) {
                                        d dVar3 = new d();
                                        TypedArray C04 = i.j.C0(resources, theme, attributeSet, a.f1838b);
                                        dVar3.l = null;
                                        dVar3.f1861c = i.j.g0(C04, xmlPullParser, "rotation", 5, dVar3.f1861c);
                                        dVar3.f1862d = C04.getFloat(1, dVar3.f1862d);
                                        dVar3.f1863e = C04.getFloat(2, dVar3.f1863e);
                                        i3 = 3;
                                        dVar3.f = i.j.g0(C04, xmlPullParser, "scaleX", 3, dVar3.f);
                                        dVar3.g = i.j.g0(C04, xmlPullParser, "scaleY", 4, dVar3.g);
                                        dVar3.h = i.j.g0(C04, xmlPullParser, "translateX", 6, dVar3.h);
                                        dVar3.i = i.j.g0(C04, xmlPullParser, "translateY", 7, dVar3.i);
                                        z = false;
                                        String string6 = C04.getString(0);
                                        if (string6 != null) {
                                            dVar3.m = string6;
                                        }
                                        dVar3.c();
                                        C04.recycle();
                                        dVar2.f1860b.add(dVar3);
                                        arrayDeque = arrayDeque3;
                                        arrayDeque.push(dVar3);
                                        if (dVar3.getGroupName() != null) {
                                            gVar.p.put(dVar3.getGroupName(), dVar3);
                                        }
                                        hVar.f1873a = dVar3.k | hVar.f1873a;
                                    }
                                    arrayDeque = arrayDeque3;
                                    z = false;
                                    i3 = 3;
                                }
                            } else {
                                z = z2;
                                i2 = depth;
                                i3 = 3;
                                arrayDeque = arrayDeque3;
                                gVar = gVar4;
                                hVar = hVar5;
                                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                                    arrayDeque.pop();
                                }
                            }
                            eventType = xmlPullParser.next();
                            i4 = i3;
                            depth = i2;
                            i5 = 1;
                            z2 = z;
                            gVar4 = gVar;
                            arrayDeque3 = arrayDeque;
                            hVar5 = hVar;
                        }
                        if (!z4) {
                            this.f1856d = d(hVar3.f1875c, hVar3.f1876d);
                            return;
                        }
                        throw new XmlPullParserException("no path defined");
                    } else {
                        throw new XmlPullParserException(C0.getPositionDescription() + "<vector> tag requires height > 0");
                    }
                } else {
                    throw new XmlPullParserException(C0.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
                }
            } else {
                colorStateList = ColorStateList.valueOf(typedValue.data);
                if (colorStateList != null) {
                }
                boolean z32 = hVar4.f1877e;
                if (i.j.q0(xmlPullParser, "autoMirrored")) {
                }
                hVar4.f1877e = z32;
                gVar3.k = i.j.g0(C0, xmlPullParser, "viewportWidth", 7, gVar3.k);
                float g02 = i.j.g0(C0, xmlPullParser, "viewportHeight", 8, gVar3.l);
                gVar3.l = g02;
                if (gVar3.k <= 0.0f) {
                }
            }
        }
        colorStateList = null;
        if (colorStateList != null) {
        }
        boolean z322 = hVar4.f1877e;
        if (i.j.q0(xmlPullParser, "autoMirrored")) {
        }
        hVar4.f1877e = z322;
        gVar3.k = i.j.g0(C0, xmlPullParser, "viewportWidth", 7, gVar3.k);
        float g022 = i.j.g0(C0, xmlPullParser, "viewportHeight", 8, gVar3.l);
        gVar3.l = g022;
        if (gVar3.k <= 0.0f) {
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.f1855c.f1877e;
    }

    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f1855c) != null && (hVar.a() || ((colorStateList = this.f1855c.f1875c) != null && colorStateList.isStateful())));
    }

    public Drawable mutate() {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.f1855c = new h(this.f1855c);
            this.f = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.f1855c;
        ColorStateList colorStateList = hVar.f1875c;
        if (!(colorStateList == null || (mode = hVar.f1876d) == null)) {
            this.f1856d = d(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.a()) {
            boolean b2 = hVar.f1874b.h.b(iArr);
            hVar.k |= b2;
            if (b2) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f1855c.f1874b.getRootAlpha() != i2) {
            this.f1855c.f1874b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.f1855c.f1877e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f1857e = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i2) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            i.j.b1(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            i.j.c1(drawable, colorStateList);
            return;
        }
        h hVar = this.f1855c;
        if (hVar.f1875c != colorStateList) {
            hVar.f1875c = colorStateList;
            this.f1856d = d(colorStateList, hVar.f1876d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            i.j.d1(drawable, mode);
            return;
        }
        h hVar = this.f1855c;
        if (hVar.f1876d != mode) {
            hVar.f1876d = mode;
            this.f1856d = d(hVar.f1875c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1854b;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f1854b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
