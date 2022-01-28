package f.b.a.e.v;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import f.b.a.e.v.j;
import f.b.a.e.v.k;
import f.b.a.e.v.m;
import java.util.BitSet;
import java.util.Objects;

public class g extends Drawable implements e.i.c.m.a, n {
    public static final String y = g.class.getSimpleName();
    public static final Paint z;
    public b b;
    public final m.f[] c;

    /* renamed from: d  reason: collision with root package name */
    public final m.f[] f3026d;

    /* renamed from: e  reason: collision with root package name */
    public final BitSet f3027e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3028f;

    /* renamed from: g  reason: collision with root package name */
    public final Matrix f3029g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f3030h;

    /* renamed from: i  reason: collision with root package name */
    public final Path f3031i;

    /* renamed from: j  reason: collision with root package name */
    public final RectF f3032j;

    /* renamed from: k  reason: collision with root package name */
    public final RectF f3033k;

    /* renamed from: l  reason: collision with root package name */
    public final Region f3034l;
    public final Region m;
    public j n;
    public final Paint o;
    public final Paint p;
    public final f.b.a.e.u.a q;
    public final k.b r;
    public final k s;
    public PorterDuffColorFilter t;
    public PorterDuffColorFilter u;
    public int v;
    public final RectF w;
    public boolean x;

    public class a implements k.b {
        public a() {
        }
    }

    public static final class b extends Drawable.ConstantState {
        public j a;
        public f.b.a.e.n.a b;
        public ColorFilter c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f3035d = null;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f3036e = null;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f3037f = null;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f3038g = null;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f3039h = PorterDuff.Mode.SRC_IN;

        /* renamed from: i  reason: collision with root package name */
        public Rect f3040i = null;

        /* renamed from: j  reason: collision with root package name */
        public float f3041j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f3042k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f3043l;
        public int m = 255;
        public float n = 0.0f;
        public float o = 0.0f;
        public float p = 0.0f;
        public int q = 0;
        public int r = 0;
        public int s = 0;
        public int t = 0;
        public boolean u = false;
        public Paint.Style v = Paint.Style.FILL_AND_STROKE;

        public b(b bVar) {
            this.a = bVar.a;
            this.b = bVar.b;
            this.f3043l = bVar.f3043l;
            this.c = bVar.c;
            this.f3035d = bVar.f3035d;
            this.f3036e = bVar.f3036e;
            this.f3039h = bVar.f3039h;
            this.f3038g = bVar.f3038g;
            this.m = bVar.m;
            this.f3041j = bVar.f3041j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.f3042k = bVar.f3042k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f3037f = bVar.f3037f;
            this.v = bVar.v;
            if (bVar.f3040i != null) {
                this.f3040i = new Rect(bVar.f3040i);
            }
        }

        public b(j jVar, f.b.a.e.n.a aVar) {
            this.a = jVar;
            this.b = null;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f3028f = true;
            return gVar;
        }
    }

    static {
        Paint paint = new Paint(1);
        z = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public g() {
        this(new j());
    }

    public g(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(j.b(context, null, i2, i3).a());
    }

    public g(b bVar) {
        k kVar;
        this.c = new m.f[4];
        this.f3026d = new m.f[4];
        this.f3027e = new BitSet(8);
        this.f3029g = new Matrix();
        this.f3030h = new Path();
        this.f3031i = new Path();
        this.f3032j = new RectF();
        this.f3033k = new RectF();
        this.f3034l = new Region();
        this.m = new Region();
        Paint paint = new Paint(1);
        this.o = paint;
        Paint paint2 = new Paint(1);
        this.p = paint2;
        this.q = new f.b.a.e.u.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            kVar = k.a.a;
        } else {
            kVar = new k();
        }
        this.s = kVar;
        this.w = new RectF();
        this.x = true;
        this.b = bVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        x();
        w(getState());
        this.r = new a();
    }

    public g(j jVar) {
        this(new b(jVar, null));
    }

    public final void b(RectF rectF, Path path) {
        c(rectF, path);
        if (this.b.f3041j != 1.0f) {
            this.f3029g.reset();
            Matrix matrix = this.f3029g;
            float f2 = this.b.f3041j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f3029g);
        }
        path.computeBounds(this.w, true);
    }

    public final void c(RectF rectF, Path path) {
        k kVar = this.s;
        b bVar = this.b;
        kVar.a(bVar.a, bVar.f3042k, rectF, this.r, path);
    }

    public final PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z2) {
        PorterDuffColorFilter porterDuffColorFilter;
        if (colorStateList == null || mode == null) {
            if (z2) {
                int color = paint.getColor();
                int e2 = e(color);
                this.v = e2;
                if (e2 != color) {
                    porterDuffColorFilter = new PorterDuffColorFilter(e2, PorterDuff.Mode.SRC_IN);
                    return porterDuffColorFilter;
                }
            }
            porterDuffColorFilter = null;
            return porterDuffColorFilter;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = e(colorForState);
        }
        this.v = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00eb, code lost:
        if ((!o() && !r12.f3030h.isConvex() && android.os.Build.VERSION.SDK_INT < 29) != false) goto L_0x00ed;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01ab  */
    public void draw(Canvas canvas) {
        boolean z2;
        this.o.setColorFilter(this.t);
        int alpha = this.o.getAlpha();
        Paint paint = this.o;
        int i2 = this.b.m;
        paint.setAlpha(((i2 + (i2 >>> 7)) * alpha) >>> 8);
        this.p.setColorFilter(this.u);
        this.p.setStrokeWidth(this.b.f3043l);
        int alpha2 = this.p.getAlpha();
        Paint paint2 = this.p;
        int i3 = this.b.m;
        paint2.setAlpha(((i3 + (i3 >>> 7)) * alpha2) >>> 8);
        boolean z3 = false;
        if (this.f3028f) {
            float f2 = -k();
            j jVar = this.b.a;
            Objects.requireNonNull(jVar);
            j.b bVar = new j.b(jVar);
            c cVar = jVar.f3045e;
            if (!(cVar instanceof h)) {
                cVar = new b(f2, cVar);
            }
            bVar.f3054e = cVar;
            c cVar2 = jVar.f3046f;
            if (!(cVar2 instanceof h)) {
                cVar2 = new b(f2, cVar2);
            }
            bVar.f3055f = cVar2;
            c cVar3 = jVar.f3048h;
            if (!(cVar3 instanceof h)) {
                cVar3 = new b(f2, cVar3);
            }
            bVar.f3057h = cVar3;
            c cVar4 = jVar.f3047g;
            if (!(cVar4 instanceof h)) {
                cVar4 = new b(f2, cVar4);
            }
            bVar.f3056g = cVar4;
            j a2 = bVar.a();
            this.n = a2;
            k kVar = this.s;
            float f3 = this.b.f3042k;
            this.f3033k.set(h());
            float k2 = k();
            this.f3033k.inset(k2, k2);
            kVar.a(a2, f3, this.f3033k, null, this.f3031i);
            b(h(), this.f3030h);
            this.f3028f = false;
        }
        b bVar2 = this.b;
        int i4 = bVar2.q;
        if (i4 != 1 && bVar2.r > 0) {
            if (i4 != 2) {
            }
            z2 = true;
            if (z2) {
                canvas.save();
                canvas.translate((float) i(), (float) j());
                if (!this.x) {
                    f(canvas);
                } else {
                    int width = (int) (this.w.width() - ((float) getBounds().width()));
                    int height = (int) (this.w.height() - ((float) getBounds().height()));
                    if (width < 0 || height < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap createBitmap = Bitmap.createBitmap((this.b.r * 2) + ((int) this.w.width()) + width, (this.b.r * 2) + ((int) this.w.height()) + height, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    float f4 = (float) ((getBounds().left - this.b.r) - width);
                    float f5 = (float) ((getBounds().top - this.b.r) - height);
                    canvas2.translate(-f4, -f5);
                    f(canvas2);
                    canvas.drawBitmap(createBitmap, f4, f5, (Paint) null);
                    createBitmap.recycle();
                }
                canvas.restore();
            }
            b bVar3 = this.b;
            Paint.Style style = bVar3.v;
            if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
                z3 = true;
            }
            if (z3) {
                g(canvas, this.o, this.f3030h, bVar3.a, h());
            }
            if (m()) {
                Paint paint3 = this.p;
                Path path = this.f3031i;
                j jVar2 = this.n;
                this.f3033k.set(h());
                float k3 = k();
                this.f3033k.inset(k3, k3);
                g(canvas, paint3, path, jVar2, this.f3033k);
            }
            this.o.setAlpha(alpha);
            this.p.setAlpha(alpha2);
        }
        z2 = false;
        if (z2) {
        }
        b bVar32 = this.b;
        Paint.Style style2 = bVar32.v;
        z3 = true;
        if (z3) {
        }
        if (m()) {
        }
        this.o.setAlpha(alpha);
        this.p.setAlpha(alpha2);
    }

    public int e(int i2) {
        b bVar = this.b;
        float f2 = bVar.o + bVar.p + bVar.n;
        f.b.a.e.n.a aVar = bVar.b;
        return aVar != null ? aVar.a(i2, f2) : i2;
    }

    public final void f(Canvas canvas) {
        this.f3027e.cardinality();
        if (this.b.s != 0) {
            canvas.drawPath(this.f3030h, this.q.a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            m.f fVar = this.c[i2];
            f.b.a.e.u.a aVar = this.q;
            int i3 = this.b.r;
            Matrix matrix = m.f.a;
            fVar.a(matrix, aVar, i3, canvas);
            this.f3026d[i2].a(matrix, this.q, this.b.r, canvas);
        }
        if (this.x) {
            int i4 = i();
            int j2 = j();
            canvas.translate((float) (-i4), (float) (-j2));
            canvas.drawPath(this.f3030h, z);
            canvas.translate((float) i4, (float) j2);
        }
    }

    public final void g(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (jVar.d(rectF)) {
            float a2 = jVar.f3046f.a(rectF) * this.b.f3042k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    public Drawable.ConstantState getConstantState() {
        return this.b;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        if (this.b.q != 2) {
            if (o()) {
                outline.setRoundRect(getBounds(), l() * this.b.f3042k);
                return;
            }
            b(h(), this.f3030h);
            if (this.f3030h.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.f3030h);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.b.f3040i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Region getTransparentRegion() {
        this.f3034l.set(getBounds());
        b(h(), this.f3030h);
        this.m.setPath(this.f3030h, this.f3034l);
        this.f3034l.op(this.m, Region.Op.DIFFERENCE);
        return this.f3034l;
    }

    public RectF h() {
        this.f3032j.set(getBounds());
        return this.f3032j;
    }

    public int i() {
        b bVar = this.b;
        return (int) (Math.sin(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public void invalidateSelf() {
        this.f3028f = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.b.f3038g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.b.f3037f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.b.f3036e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.b.f3035d) != null && colorStateList4.isStateful())));
    }

    public int j() {
        b bVar = this.b;
        return (int) (Math.cos(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public final float k() {
        if (m()) {
            return this.p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float l() {
        return this.b.a.f3045e.a(h());
    }

    public final boolean m() {
        Paint.Style style = this.b.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.p.getStrokeWidth() > 0.0f;
    }

    public Drawable mutate() {
        this.b = new b(this.b);
        return this;
    }

    public void n(Context context) {
        this.b.b = new f.b.a.e.n.a(context);
        y();
    }

    public boolean o() {
        return this.b.a.d(h());
    }

    public void onBoundsChange(Rect rect) {
        this.f3028f = true;
        super.onBoundsChange(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z2 = w(iArr) || x();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public void p(float f2) {
        b bVar = this.b;
        if (bVar.o != f2) {
            bVar.o = f2;
            y();
        }
    }

    public void q(ColorStateList colorStateList) {
        b bVar = this.b;
        if (bVar.f3035d != colorStateList) {
            bVar.f3035d = colorStateList;
            onStateChange(getState());
        }
    }

    public void r(float f2) {
        b bVar = this.b;
        if (bVar.f3042k != f2) {
            bVar.f3042k = f2;
            this.f3028f = true;
            invalidateSelf();
        }
    }

    public void s(int i2) {
        this.q.a(i2);
        this.b.u = false;
        super.invalidateSelf();
    }

    public void setAlpha(int i2) {
        b bVar = this.b;
        if (bVar.m != i2) {
            bVar.m = i2;
            super.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.c = colorFilter;
        super.invalidateSelf();
    }

    @Override // f.b.a.e.v.n
    public void setShapeAppearanceModel(j jVar) {
        this.b.a = jVar;
        invalidateSelf();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.b.f3038g = colorStateList;
        x();
        super.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.b;
        if (bVar.f3039h != mode) {
            bVar.f3039h = mode;
            x();
            super.invalidateSelf();
        }
    }

    public void t(float f2, int i2) {
        this.b.f3043l = f2;
        invalidateSelf();
        v(ColorStateList.valueOf(i2));
    }

    public void u(float f2, ColorStateList colorStateList) {
        this.b.f3043l = f2;
        invalidateSelf();
        v(colorStateList);
    }

    public void v(ColorStateList colorStateList) {
        b bVar = this.b;
        if (bVar.f3036e != colorStateList) {
            bVar.f3036e = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean w(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.b.f3035d == null || color2 == (colorForState2 = this.b.f3035d.getColorForState(iArr, (color2 = this.o.getColor())))) {
            z2 = false;
        } else {
            this.o.setColor(colorForState2);
            z2 = true;
        }
        if (this.b.f3036e == null || color == (colorForState = this.b.f3036e.getColorForState(iArr, (color = this.p.getColor())))) {
            return z2;
        }
        this.p.setColor(colorForState);
        return true;
    }

    public final boolean x() {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        b bVar = this.b;
        this.t = d(bVar.f3038g, bVar.f3039h, this.o, true);
        b bVar2 = this.b;
        this.u = d(bVar2.f3037f, bVar2.f3039h, this.p, false);
        b bVar3 = this.b;
        if (bVar3.u) {
            this.q.a(bVar3.f3038g.getColorForState(getState(), 0));
        }
        if (!Objects.equals(porterDuffColorFilter, this.t) || !Objects.equals(porterDuffColorFilter2, this.u)) {
            return true;
        }
        return false;
    }

    public final void y() {
        b bVar = this.b;
        float f2 = bVar.o + bVar.p;
        bVar.r = (int) Math.ceil((double) (0.75f * f2));
        this.b.s = (int) Math.ceil((double) (f2 * 0.25f));
        x();
        super.invalidateSelf();
    }
}
