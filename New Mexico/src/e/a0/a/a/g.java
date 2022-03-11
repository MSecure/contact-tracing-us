package e.a0.a.a;

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
/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: k  reason: collision with root package name */
    public static final PorterDuff.Mode f668k = PorterDuff.Mode.SRC_IN;
    public h c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuffColorFilter f669d;

    /* renamed from: e  reason: collision with root package name */
    public ColorFilter f670e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f671f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f672g;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f673h;

    /* renamed from: i  reason: collision with root package name */
    public final Matrix f674i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f675j;

    /* loaded from: classes.dex */
    public static class b extends f {
        public b() {
        }

        public b(b bVar) {
            super(bVar);
        }

        @Override // e.a0.a.a.g.f
        public boolean c() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        public int[] f676e;

        /* renamed from: f  reason: collision with root package name */
        public e.j.b.b.b f677f;

        /* renamed from: g  reason: collision with root package name */
        public float f678g;

        /* renamed from: h  reason: collision with root package name */
        public e.j.b.b.b f679h;

        /* renamed from: i  reason: collision with root package name */
        public float f680i;

        /* renamed from: j  reason: collision with root package name */
        public float f681j;

        /* renamed from: k  reason: collision with root package name */
        public float f682k;

        /* renamed from: l  reason: collision with root package name */
        public float f683l;
        public float m;
        public Paint.Cap n;
        public Paint.Join o;
        public float p;

        public c() {
            this.f678g = 0.0f;
            this.f680i = 1.0f;
            this.f681j = 1.0f;
            this.f682k = 0.0f;
            this.f683l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        public c(c cVar) {
            super(cVar);
            this.f678g = 0.0f;
            this.f680i = 1.0f;
            this.f681j = 1.0f;
            this.f682k = 0.0f;
            this.f683l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f676e = cVar.f676e;
            this.f677f = cVar.f677f;
            this.f678g = cVar.f678g;
            this.f680i = cVar.f680i;
            this.f679h = cVar.f679h;
            this.c = cVar.c;
            this.f681j = cVar.f681j;
            this.f682k = cVar.f682k;
            this.f683l = cVar.f683l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        @Override // e.a0.a.a.g.e
        public boolean a() {
            return this.f679h.c() || this.f677f.c();
        }

        @Override // e.a0.a.a.g.e
        public boolean b(int[] iArr) {
            return this.f677f.d(iArr) | this.f679h.d(iArr);
        }

        public float getFillAlpha() {
            return this.f681j;
        }

        public int getFillColor() {
            return this.f679h.c;
        }

        public float getStrokeAlpha() {
            return this.f680i;
        }

        public int getStrokeColor() {
            return this.f677f.c;
        }

        public float getStrokeWidth() {
            return this.f678g;
        }

        public float getTrimPathEnd() {
            return this.f683l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.f682k;
        }

        public void setFillAlpha(float f2) {
            this.f681j = f2;
        }

        public void setFillColor(int i2) {
            this.f679h.c = i2;
        }

        public void setStrokeAlpha(float f2) {
            this.f680i = f2;
        }

        public void setStrokeColor(int i2) {
            this.f677f.c = i2;
        }

        public void setStrokeWidth(float f2) {
            this.f678g = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.f683l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.f682k = f2;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends e {
        public final Matrix a;
        public final ArrayList<e> b;
        public float c;

        /* renamed from: d  reason: collision with root package name */
        public float f684d;

        /* renamed from: e  reason: collision with root package name */
        public float f685e;

        /* renamed from: f  reason: collision with root package name */
        public float f686f;

        /* renamed from: g  reason: collision with root package name */
        public float f687g;

        /* renamed from: h  reason: collision with root package name */
        public float f688h;

        /* renamed from: i  reason: collision with root package name */
        public float f689i;

        /* renamed from: j  reason: collision with root package name */
        public final Matrix f690j;

        /* renamed from: k  reason: collision with root package name */
        public int f691k;

        /* renamed from: l  reason: collision with root package name */
        public int[] f692l;
        public String m;

        public d() {
            super(null);
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.f684d = 0.0f;
            this.f685e = 0.0f;
            this.f686f = 1.0f;
            this.f687g = 1.0f;
            this.f688h = 0.0f;
            this.f689i = 0.0f;
            this.f690j = new Matrix();
            this.m = null;
        }

        public d(d dVar, e.f.a<String, Object> aVar) {
            super(null);
            f fVar;
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.f684d = 0.0f;
            this.f685e = 0.0f;
            this.f686f = 1.0f;
            this.f687g = 1.0f;
            this.f688h = 0.0f;
            this.f689i = 0.0f;
            Matrix matrix = new Matrix();
            this.f690j = matrix;
            this.m = null;
            this.c = dVar.c;
            this.f684d = dVar.f684d;
            this.f685e = dVar.f685e;
            this.f686f = dVar.f686f;
            this.f687g = dVar.f687g;
            this.f688h = dVar.f688h;
            this.f689i = dVar.f689i;
            this.f692l = dVar.f692l;
            String str = dVar.m;
            this.m = str;
            this.f691k = dVar.f691k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f690j);
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

        @Override // e.a0.a.a.g.e
        public boolean a() {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (this.b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // e.a0.a.a.g.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                z |= this.b.get(i2).b(iArr);
            }
            return z;
        }

        public final void c() {
            this.f690j.reset();
            this.f690j.postTranslate(-this.f684d, -this.f685e);
            this.f690j.postScale(this.f686f, this.f687g);
            this.f690j.postRotate(this.c, 0.0f, 0.0f);
            this.f690j.postTranslate(this.f688h + this.f684d, this.f689i + this.f685e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f690j;
        }

        public float getPivotX() {
            return this.f684d;
        }

        public float getPivotY() {
            return this.f685e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f686f;
        }

        public float getScaleY() {
            return this.f687g;
        }

        public float getTranslateX() {
            return this.f688h;
        }

        public float getTranslateY() {
            return this.f689i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f684d) {
                this.f684d = f2;
                c();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f685e) {
                this.f685e = f2;
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
            if (f2 != this.f686f) {
                this.f686f = f2;
                c();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f687g) {
                this.f687g = f2;
                c();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f688h) {
                this.f688h = f2;
                c();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f689i) {
                this.f689i = f2;
                c();
            }
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static abstract class f extends e {
        public e.j.c.d[] a;
        public String b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f693d;

        public f() {
            super(null);
            this.a = null;
            this.c = 0;
        }

        public f(f fVar) {
            super(null);
            this.a = null;
            this.c = 0;
            this.b = fVar.b;
            this.f693d = fVar.f693d;
            this.a = m.e.U(fVar.a);
        }

        public boolean c() {
            return false;
        }

        public e.j.c.d[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.b;
        }

        public void setPathData(e.j.c.d[] dVarArr) {
            if (!m.e.g(this.a, dVarArr)) {
                this.a = m.e.U(dVarArr);
                return;
            }
            e.j.c.d[] dVarArr2 = this.a;
            for (int i2 = 0; i2 < dVarArr.length; i2++) {
                dVarArr2[i2].a = dVarArr[i2].a;
                for (int i3 = 0; i3 < dVarArr[i2].b.length; i3++) {
                    dVarArr2[i2].b[i3] = dVarArr[i2].b[i3];
                }
            }
        }
    }

    /* renamed from: e.a0.a.a.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013g {
        public static final Matrix q = new Matrix();
        public final Path a;
        public final Path b;
        public final Matrix c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f694d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f695e;

        /* renamed from: f  reason: collision with root package name */
        public PathMeasure f696f;

        /* renamed from: g  reason: collision with root package name */
        public int f697g;

        /* renamed from: h  reason: collision with root package name */
        public final d f698h;

        /* renamed from: i  reason: collision with root package name */
        public float f699i;

        /* renamed from: j  reason: collision with root package name */
        public float f700j;

        /* renamed from: k  reason: collision with root package name */
        public float f701k;

        /* renamed from: l  reason: collision with root package name */
        public float f702l;
        public int m;
        public String n;
        public Boolean o;
        public final e.f.a<String, Object> p;

        public C0013g() {
            this.c = new Matrix();
            this.f699i = 0.0f;
            this.f700j = 0.0f;
            this.f701k = 0.0f;
            this.f702l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new e.f.a<>();
            this.f698h = new d();
            this.a = new Path();
            this.b = new Path();
        }

        public C0013g(C0013g gVar) {
            this.c = new Matrix();
            this.f699i = 0.0f;
            this.f700j = 0.0f;
            this.f701k = 0.0f;
            this.f702l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            e.f.a<String, Object> aVar = new e.f.a<>();
            this.p = aVar;
            this.f698h = new d(gVar.f698h, aVar);
            this.a = new Path(gVar.a);
            this.b = new Path(gVar.b);
            this.f699i = gVar.f699i;
            this.f700j = gVar.f700j;
            this.f701k = gVar.f701k;
            this.f702l = gVar.f702l;
            this.f697g = gVar.f697g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.o = gVar.o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public final void a(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            C0013g gVar;
            C0013g gVar2 = this;
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.f690j);
            canvas.save();
            ?? r11 = 0;
            int i4 = 0;
            while (i4 < dVar.b.size()) {
                e eVar = dVar.b.get(i4);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    f fVar = (f) eVar;
                    float f2 = ((float) i2) / gVar2.f701k;
                    float f3 = ((float) i3) / gVar2.f702l;
                    float min = Math.min(f2, f3);
                    Matrix matrix2 = dVar.a;
                    gVar2.c.set(matrix2);
                    gVar2.c.postScale(f2, f3);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    char c = r11 == true ? 1 : 0;
                    char c2 = r11 == true ? 1 : 0;
                    char c3 = r11 == true ? 1 : 0;
                    float f4 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot((double) fArr[c], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
                    float abs = max > 0.0f ? Math.abs(f4) / max : 0.0f;
                    if (abs == 0.0f) {
                        gVar = this;
                    } else {
                        gVar = this;
                        Path path = gVar.a;
                        Objects.requireNonNull(fVar);
                        path.reset();
                        e.j.c.d[] dVarArr = fVar.a;
                        if (dVarArr != null) {
                            e.j.c.d.b(dVarArr, path);
                        }
                        Path path2 = gVar.a;
                        gVar.b.reset();
                        if (fVar.c()) {
                            gVar.b.setFillType(fVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            gVar.b.addPath(path2, gVar.c);
                            canvas.clipPath(gVar.b);
                        } else {
                            c cVar = (c) fVar;
                            float f5 = cVar.f682k;
                            if (!(f5 == 0.0f && cVar.f683l == 1.0f)) {
                                float f6 = cVar.m;
                                float f7 = (f5 + f6) % 1.0f;
                                float f8 = (cVar.f683l + f6) % 1.0f;
                                if (gVar.f696f == null) {
                                    gVar.f696f = new PathMeasure();
                                }
                                gVar.f696f.setPath(gVar.a, r11);
                                float length = gVar.f696f.getLength();
                                float f9 = f7 * length;
                                float f10 = f8 * length;
                                path2.reset();
                                if (f9 > f10) {
                                    gVar.f696f.getSegment(f9, length, path2, true);
                                    gVar.f696f.getSegment(0.0f, f10, path2, true);
                                } else {
                                    gVar.f696f.getSegment(f9, f10, path2, true);
                                }
                                path2.rLineTo(0.0f, 0.0f);
                            }
                            gVar.b.addPath(path2, gVar.c);
                            e.j.b.b.b bVar = cVar.f679h;
                            if (bVar.b() || bVar.c != 0) {
                                e.j.b.b.b bVar2 = cVar.f679h;
                                if (gVar.f695e == null) {
                                    Paint paint = new Paint(1);
                                    gVar.f695e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = gVar.f695e;
                                if (bVar2.b()) {
                                    Shader shader = bVar2.a;
                                    shader.setLocalMatrix(gVar.c);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(cVar.f681j * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i5 = bVar2.c;
                                    float f11 = cVar.f681j;
                                    PorterDuff.Mode mode = g.f668k;
                                    paint2.setColor((i5 & 16777215) | (((int) (((float) Color.alpha(i5)) * f11)) << 24));
                                }
                                paint2.setColorFilter(colorFilter);
                                gVar.b.setFillType(cVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(gVar.b, paint2);
                            }
                            e.j.b.b.b bVar3 = cVar.f677f;
                            if (bVar3.b() || bVar3.c != 0) {
                                e.j.b.b.b bVar4 = cVar.f677f;
                                if (gVar.f694d == null) {
                                    Paint paint3 = new Paint(1);
                                    gVar.f694d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = gVar.f694d;
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
                                    paint4.setAlpha(Math.round(cVar.f680i * 255.0f));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i6 = bVar4.c;
                                    float f12 = cVar.f680i;
                                    PorterDuff.Mode mode2 = g.f668k;
                                    paint4.setColor((i6 & 16777215) | (((int) (((float) Color.alpha(i6)) * f12)) << 24));
                                }
                                paint4.setColorFilter(colorFilter);
                                paint4.setStrokeWidth(cVar.f678g * abs * min);
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

    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {
        public int a;
        public C0013g b;
        public ColorStateList c;

        /* renamed from: d  reason: collision with root package name */
        public PorterDuff.Mode f703d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f704e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f705f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f706g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f707h;

        /* renamed from: i  reason: collision with root package name */
        public int f708i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f709j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f710k;

        /* renamed from: l  reason: collision with root package name */
        public Paint f711l;

        public h() {
            this.c = null;
            this.f703d = g.f668k;
            this.b = new C0013g();
        }

        public h(h hVar) {
            this.c = null;
            this.f703d = g.f668k;
            if (hVar != null) {
                this.a = hVar.a;
                C0013g gVar = new C0013g(hVar.b);
                this.b = gVar;
                if (hVar.b.f695e != null) {
                    gVar.f695e = new Paint(hVar.b.f695e);
                }
                if (hVar.b.f694d != null) {
                    this.b.f694d = new Paint(hVar.b.f694d);
                }
                this.c = hVar.c;
                this.f703d = hVar.f703d;
                this.f704e = hVar.f704e;
            }
        }

        public boolean a() {
            C0013g gVar = this.b;
            if (gVar.o == null) {
                gVar.o = Boolean.valueOf(gVar.f698h.a());
            }
            return gVar.o.booleanValue();
        }

        public void b(int i2, int i3) {
            this.f705f.eraseColor(0);
            Canvas canvas = new Canvas(this.f705f);
            C0013g gVar = this.b;
            gVar.a(gVar.f698h, C0013g.q, canvas, i2, i3, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new g(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new g(this);
        }
    }

    /* loaded from: classes.dex */
    public static class i extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public i(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g();
            gVar.b = (VectorDrawable) this.a.newDrawable();
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            g gVar = new g();
            gVar.b = (VectorDrawable) this.a.newDrawable(resources);
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            g gVar = new g();
            gVar.b = (VectorDrawable) this.a.newDrawable(resources, theme);
            return gVar;
        }
    }

    public g() {
        this.f672g = true;
        this.f673h = new float[9];
        this.f674i = new Matrix();
        this.f675j = new Rect();
        this.c = new h();
    }

    public g(h hVar) {
        this.f672g = true;
        this.f673h = new float[9];
        this.f674i = new Matrix();
        this.f675j = new Rect();
        this.c = hVar;
        this.f669d = b(hVar.c, hVar.f703d);
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

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.b;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d3, code lost:
        if ((r1 == r7.getWidth() && r3 == r6.f705f.getHeight()) == false) goto L_0x00d5;
     */
    @Override // android.graphics.drawable.Drawable
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f675j);
        if (this.f675j.width() > 0 && this.f675j.height() > 0) {
            ColorFilter colorFilter = this.f670e;
            if (colorFilter == null) {
                colorFilter = this.f669d;
            }
            canvas.getMatrix(this.f674i);
            this.f674i.getValues(this.f673h);
            boolean z = false;
            float abs = Math.abs(this.f673h[0]);
            float abs2 = Math.abs(this.f673h[4]);
            float abs3 = Math.abs(this.f673h[1]);
            float abs4 = Math.abs(this.f673h[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f675j.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f675j.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f675j;
                canvas.translate((float) rect.left, (float) rect.top);
                if (isAutoMirrored() && m.e.q0(this) == 1) {
                    canvas.translate((float) this.f675j.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f675j.offsetTo(0, 0);
                h hVar = this.c;
                Bitmap bitmap = hVar.f705f;
                if (bitmap != null) {
                }
                hVar.f705f = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
                hVar.f710k = true;
                if (!this.f672g) {
                    this.c.b(min, min2);
                } else {
                    h hVar2 = this.c;
                    if (!(!hVar2.f710k && hVar2.f706g == hVar2.c && hVar2.f707h == hVar2.f703d && hVar2.f709j == hVar2.f704e && hVar2.f708i == hVar2.b.getRootAlpha())) {
                        this.c.b(min, min2);
                        h hVar3 = this.c;
                        hVar3.f706g = hVar3.c;
                        hVar3.f707h = hVar3.f703d;
                        hVar3.f708i = hVar3.b.getRootAlpha();
                        hVar3.f709j = hVar3.f704e;
                        hVar3.f710k = false;
                    }
                }
                h hVar4 = this.c;
                Rect rect2 = this.f675j;
                if (hVar4.b.getRootAlpha() < 255) {
                    z = true;
                }
                if (z || colorFilter != null) {
                    if (hVar4.f711l == null) {
                        Paint paint2 = new Paint();
                        hVar4.f711l = paint2;
                        paint2.setFilterBitmap(true);
                    }
                    hVar4.f711l.setAlpha(hVar4.b.getRootAlpha());
                    hVar4.f711l.setColorFilter(colorFilter);
                    paint = hVar4.f711l;
                } else {
                    paint = null;
                }
                canvas.drawBitmap(hVar4.f705f, (Rect) null, rect2, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.c.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.f670e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.b != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.b.getConstantState());
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.c.b.f700j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.c.b.f699i;
    }

    @Override // android.graphics.drawable.Drawable
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

    /* JADX WARN: Removed duplicated region for block: B:199:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0  */
    @Override // android.graphics.drawable.Drawable
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        ColorStateList colorStateList;
        int i2;
        ArrayDeque arrayDeque;
        h hVar;
        C0013g gVar;
        h hVar2;
        C0013g gVar2;
        ArrayDeque arrayDeque2;
        TypedArray typedArray;
        d dVar;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar3 = this.c;
        hVar3.b = new C0013g();
        TypedArray c1 = m.e.c1(resources, theme, attributeSet, a.a);
        h hVar4 = this.c;
        C0013g gVar3 = hVar4.b;
        int i3 = !m.e.F0(xmlPullParser, "tintMode") ? -1 : c1.getInt(6, -1);
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
        hVar4.f703d = mode;
        int i5 = 1;
        if (m.e.F0(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            c1.getValue(1, typedValue);
            int i6 = typedValue.type;
            if (i6 != 2) {
                if (i6 < 28 || i6 > 31) {
                    Resources resources2 = c1.getResources();
                    int resourceId = c1.getResourceId(1, 0);
                    ThreadLocal<TypedValue> threadLocal = e.j.b.b.a.a;
                    try {
                        colorStateList = e.j.b.b.a.a(resources2, resources2.getXml(resourceId), theme);
                    } catch (Exception unused) {
                    }
                } else {
                    colorStateList = ColorStateList.valueOf(typedValue.data);
                }
                if (colorStateList != null) {
                    hVar4.c = colorStateList;
                }
                boolean z = hVar4.f704e;
                if (m.e.F0(xmlPullParser, "autoMirrored")) {
                    z = c1.getBoolean(5, z);
                }
                hVar4.f704e = z;
                float f2 = gVar3.f701k;
                if (m.e.F0(xmlPullParser, "viewportWidth")) {
                    f2 = c1.getFloat(7, f2);
                }
                gVar3.f701k = f2;
                float f3 = gVar3.f702l;
                if (m.e.F0(xmlPullParser, "viewportHeight")) {
                    f3 = c1.getFloat(8, f3);
                }
                gVar3.f702l = f3;
                if (gVar3.f701k > 0.0f) {
                    throw new XmlPullParserException(c1.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
                } else if (f3 > 0.0f) {
                    gVar3.f699i = c1.getDimension(3, gVar3.f699i);
                    float dimension = c1.getDimension(2, gVar3.f700j);
                    gVar3.f700j = dimension;
                    if (gVar3.f699i <= 0.0f) {
                        throw new XmlPullParserException(c1.getPositionDescription() + "<vector> tag requires width > 0");
                    } else if (dimension > 0.0f) {
                        float alpha = gVar3.getAlpha();
                        if (m.e.F0(xmlPullParser, "alpha")) {
                            alpha = c1.getFloat(4, alpha);
                        }
                        gVar3.setAlpha(alpha);
                        String string = c1.getString(0);
                        if (string != null) {
                            gVar3.n = string;
                            gVar3.p.put(string, gVar3);
                        }
                        c1.recycle();
                        hVar3.a = getChangingConfigurations();
                        hVar3.f710k = true;
                        h hVar5 = this.c;
                        C0013g gVar4 = hVar5.b;
                        ArrayDeque arrayDeque3 = new ArrayDeque();
                        arrayDeque3.push(gVar4.f698h);
                        int eventType = xmlPullParser.getEventType();
                        int depth = xmlPullParser.getDepth() + 1;
                        boolean z2 = true;
                        while (eventType != i5 && (xmlPullParser.getDepth() >= depth || eventType != i4)) {
                            if (eventType == 2) {
                                String name = xmlPullParser.getName();
                                d dVar2 = (d) arrayDeque3.peek();
                                if ("path".equals(name)) {
                                    c cVar = new c();
                                    TypedArray c12 = m.e.c1(resources, theme, attributeSet, a.c);
                                    cVar.f676e = null;
                                    if (!m.e.F0(xmlPullParser, "pathData")) {
                                        arrayDeque2 = arrayDeque3;
                                        gVar2 = gVar4;
                                        hVar2 = hVar5;
                                        dVar = dVar2;
                                        i2 = depth;
                                        typedArray = c12;
                                    } else {
                                        String string2 = c12.getString(0);
                                        if (string2 != null) {
                                            cVar.b = string2;
                                        }
                                        String string3 = c12.getString(2);
                                        if (string3 != null) {
                                            cVar.a = m.e.L(string3);
                                        }
                                        arrayDeque2 = arrayDeque3;
                                        gVar2 = gVar4;
                                        hVar2 = hVar5;
                                        i2 = depth;
                                        typedArray = c12;
                                        dVar = dVar2;
                                        cVar.f679h = m.e.u0(c12, xmlPullParser, theme, "fillColor", 1, 0);
                                        float f4 = cVar.f681j;
                                        if (m.e.F0(xmlPullParser, "fillAlpha")) {
                                            f4 = typedArray.getFloat(12, f4);
                                        }
                                        cVar.f681j = f4;
                                        int i7 = !m.e.F0(xmlPullParser, "strokeLineCap") ? -1 : typedArray.getInt(8, -1);
                                        Paint.Cap cap = cVar.n;
                                        if (i7 == 0) {
                                            cap = Paint.Cap.BUTT;
                                        } else if (i7 == 1) {
                                            cap = Paint.Cap.ROUND;
                                        } else if (i7 == 2) {
                                            cap = Paint.Cap.SQUARE;
                                        }
                                        cVar.n = cap;
                                        int i8 = !m.e.F0(xmlPullParser, "strokeLineJoin") ? -1 : typedArray.getInt(9, -1);
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
                                        if (m.e.F0(xmlPullParser, "strokeMiterLimit")) {
                                            f5 = typedArray.getFloat(10, f5);
                                        }
                                        cVar.p = f5;
                                        cVar.f677f = m.e.u0(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                                        float f6 = cVar.f680i;
                                        if (m.e.F0(xmlPullParser, "strokeAlpha")) {
                                            f6 = typedArray.getFloat(11, f6);
                                        }
                                        cVar.f680i = f6;
                                        float f7 = cVar.f678g;
                                        if (m.e.F0(xmlPullParser, "strokeWidth")) {
                                            f7 = typedArray.getFloat(4, f7);
                                        }
                                        cVar.f678g = f7;
                                        float f8 = cVar.f683l;
                                        if (m.e.F0(xmlPullParser, "trimPathEnd")) {
                                            f8 = typedArray.getFloat(6, f8);
                                        }
                                        cVar.f683l = f8;
                                        float f9 = cVar.m;
                                        if (m.e.F0(xmlPullParser, "trimPathOffset")) {
                                            f9 = typedArray.getFloat(7, f9);
                                        }
                                        cVar.m = f9;
                                        float f10 = cVar.f682k;
                                        if (m.e.F0(xmlPullParser, "trimPathStart")) {
                                            f10 = typedArray.getFloat(5, f10);
                                        }
                                        cVar.f682k = f10;
                                        int i9 = cVar.c;
                                        if (m.e.F0(xmlPullParser, "fillType")) {
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
                                    hVar.a |= cVar.f693d;
                                    arrayDeque = arrayDeque2;
                                    i5 = 1;
                                    z2 = false;
                                } else {
                                    gVar = gVar4;
                                    hVar = hVar5;
                                    i2 = depth;
                                    if ("clip-path".equals(name)) {
                                        b bVar = new b();
                                        if (m.e.F0(xmlPullParser, "pathData")) {
                                            TypedArray c13 = m.e.c1(resources, theme, attributeSet, a.f654d);
                                            String string4 = c13.getString(0);
                                            if (string4 != null) {
                                                bVar.b = string4;
                                            }
                                            String string5 = c13.getString(1);
                                            if (string5 != null) {
                                                bVar.a = m.e.L(string5);
                                            }
                                            bVar.c = !m.e.F0(xmlPullParser, "fillType") ? 0 : c13.getInt(2, 0);
                                            c13.recycle();
                                        }
                                        dVar2.b.add(bVar);
                                        if (bVar.getPathName() != null) {
                                            gVar.p.put(bVar.getPathName(), bVar);
                                        }
                                        hVar.a = bVar.f693d | hVar.a;
                                    } else if ("group".equals(name)) {
                                        d dVar3 = new d();
                                        TypedArray c14 = m.e.c1(resources, theme, attributeSet, a.b);
                                        dVar3.f692l = null;
                                        float f11 = dVar3.c;
                                        if (m.e.F0(xmlPullParser, "rotation")) {
                                            f11 = c14.getFloat(5, f11);
                                        }
                                        dVar3.c = f11;
                                        i5 = 1;
                                        dVar3.f684d = c14.getFloat(1, dVar3.f684d);
                                        dVar3.f685e = c14.getFloat(2, dVar3.f685e);
                                        float f12 = dVar3.f686f;
                                        if (m.e.F0(xmlPullParser, "scaleX")) {
                                            f12 = c14.getFloat(3, f12);
                                        }
                                        dVar3.f686f = f12;
                                        float f13 = dVar3.f687g;
                                        if (m.e.F0(xmlPullParser, "scaleY")) {
                                            f13 = c14.getFloat(4, f13);
                                        }
                                        dVar3.f687g = f13;
                                        float f14 = dVar3.f688h;
                                        if (m.e.F0(xmlPullParser, "translateX")) {
                                            f14 = c14.getFloat(6, f14);
                                        }
                                        dVar3.f688h = f14;
                                        float f15 = dVar3.f689i;
                                        if (m.e.F0(xmlPullParser, "translateY")) {
                                            f15 = c14.getFloat(7, f15);
                                        }
                                        dVar3.f689i = f15;
                                        String string6 = c14.getString(0);
                                        if (string6 != null) {
                                            dVar3.m = string6;
                                        }
                                        dVar3.c();
                                        c14.recycle();
                                        dVar2.b.add(dVar3);
                                        arrayDeque = arrayDeque3;
                                        arrayDeque.push(dVar3);
                                        if (dVar3.getGroupName() != null) {
                                            gVar.p.put(dVar3.getGroupName(), dVar3);
                                        }
                                        hVar.a = dVar3.f691k | hVar.a;
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
                            this.f669d = b(hVar3.c, hVar3.f703d);
                            return;
                        }
                        throw new XmlPullParserException("no path defined");
                    } else {
                        throw new XmlPullParserException(c1.getPositionDescription() + "<vector> tag requires height > 0");
                    }
                } else {
                    throw new XmlPullParserException(c1.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
                }
            } else {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
        }
        colorStateList = null;
        if (colorStateList != null) {
        }
        boolean z3 = hVar4.f704e;
        if (m.e.F0(xmlPullParser, "autoMirrored")) {
        }
        hVar4.f704e = z3;
        float f22 = gVar3.f701k;
        if (m.e.F0(xmlPullParser, "viewportWidth")) {
        }
        gVar3.f701k = f22;
        float f32 = gVar3.f702l;
        if (m.e.F0(xmlPullParser, "viewportHeight")) {
        }
        gVar3.f702l = f32;
        if (gVar3.f701k > 0.0f) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.c.f704e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.b;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.c) != null && (hVar.a() || ((colorStateList = this.c.c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f671f && super.mutate() == this) {
            this.c = new h(this.c);
            this.f671f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.c;
        ColorStateList colorStateList = hVar.c;
        if (!(colorStateList == null || (mode = hVar.f703d) == null)) {
            this.f669d = b(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.a()) {
            boolean b2 = hVar.b.f698h.b(iArr);
            hVar.f710k |= b2;
            if (b2) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.c.b.getRootAlpha() != i2) {
            this.c.b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.c.f704e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f670e = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.e.E1(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.e.F1(drawable, colorStateList);
            return;
        }
        h hVar = this.c;
        if (hVar.c != colorStateList) {
            hVar.c = colorStateList;
            this.f669d = b(colorStateList, hVar.f703d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            m.e.G1(drawable, mode);
            return;
        }
        h hVar = this.c;
        if (hVar.f703d != mode) {
            hVar.f703d = mode;
            this.f669d = b(hVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.b;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
