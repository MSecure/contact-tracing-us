package c.b.a.b.h0;

import android.annotation.TargetApi;
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
import android.util.AttributeSet;
import b.x.t;
import c.b.a.b.h0.j;
import c.b.a.b.h0.k;
import c.b.a.b.h0.m;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.util.BitSet;
import java.util.Objects;

public class g extends Drawable implements n {
    public static final String x = g.class.getSimpleName();
    public static final Paint y = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    public b f4261b;

    /* renamed from: c  reason: collision with root package name */
    public final m.f[] f4262c;

    /* renamed from: d  reason: collision with root package name */
    public final m.f[] f4263d;

    /* renamed from: e  reason: collision with root package name */
    public final BitSet f4264e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4265f;

    /* renamed from: g  reason: collision with root package name */
    public final Matrix f4266g;
    public final Path h;
    public final Path i;
    public final RectF j;
    public final RectF k;
    public final Region l;
    public final Region m;
    public j n;
    public final Paint o;
    public final Paint p;
    public final c.b.a.b.g0.a q;
    public final k.a r;
    public final k s;
    public PorterDuffColorFilter t;
    public PorterDuffColorFilter u;
    public final RectF v;
    public boolean w;

    public class a implements k.a {
        public a() {
        }
    }

    public static final class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public j f4268a;

        /* renamed from: b  reason: collision with root package name */
        public c.b.a.b.z.a f4269b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f4270c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f4271d = null;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f4272e = null;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f4273f = null;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f4274g = null;
        public PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
        public Rect i = null;
        public float j = 1.0f;
        public float k = 1.0f;
        public float l;
        public int m = BuildConfig.VERSION_CODE;
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
            this.f4268a = bVar.f4268a;
            this.f4269b = bVar.f4269b;
            this.l = bVar.l;
            this.f4270c = bVar.f4270c;
            this.f4271d = bVar.f4271d;
            this.f4272e = bVar.f4272e;
            this.h = bVar.h;
            this.f4274g = bVar.f4274g;
            this.m = bVar.m;
            this.j = bVar.j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.k = bVar.k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f4273f = bVar.f4273f;
            this.v = bVar.v;
            if (bVar.i != null) {
                this.i = new Rect(bVar.i);
            }
        }

        public b(j jVar, c.b.a.b.z.a aVar) {
            this.f4268a = jVar;
            this.f4269b = null;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f4265f = true;
            return gVar;
        }
    }

    public g() {
        this(new j());
    }

    public g(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(j.b(context, attributeSet, i2, i3).a());
    }

    public g(b bVar) {
        this.f4262c = new m.f[4];
        this.f4263d = new m.f[4];
        this.f4264e = new BitSet(8);
        this.f4266g = new Matrix();
        this.h = new Path();
        this.i = new Path();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new Region();
        this.m = new Region();
        this.o = new Paint(1);
        this.p = new Paint(1);
        this.q = new c.b.a.b.g0.a();
        this.s = new k();
        this.v = new RectF();
        this.w = true;
        this.f4261b = bVar;
        this.p.setStyle(Paint.Style.STROKE);
        this.o.setStyle(Paint.Style.FILL);
        y.setColor(-1);
        y.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        y();
        x(getState());
        this.r = new a();
    }

    public g(j jVar) {
        this(new b(jVar, null));
    }

    public static g f(Context context, float f2) {
        int B2 = t.B2(context, c.b.a.b.b.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.f4261b.f4269b = new c.b.a.b.z.a(context);
        gVar.z();
        gVar.r(ColorStateList.valueOf(B2));
        b bVar = gVar.f4261b;
        if (bVar.o != f2) {
            bVar.o = f2;
            gVar.z();
        }
        return gVar;
    }

    public final void b(RectF rectF, Path path) {
        c(rectF, path);
        if (this.f4261b.j != 1.0f) {
            this.f4266g.reset();
            Matrix matrix = this.f4266g;
            float f2 = this.f4261b.j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f4266g);
        }
        path.computeBounds(this.v, true);
    }

    public final void c(RectF rectF, Path path) {
        k kVar = this.s;
        b bVar = this.f4261b;
        kVar.a(bVar.f4268a, bVar.k, rectF, this.r, path);
    }

    public final PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        int color;
        int e2;
        if (colorStateList == null || mode == null) {
            return (!z || (e2 = e((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(e2, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = e(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00eb, code lost:
        if ((!p() && !r13.h.isConvex() && android.os.Build.VERSION.SDK_INT < 29) != false) goto L_0x00ed;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01aa  */
    public void draw(Canvas canvas) {
        boolean z;
        this.o.setColorFilter(this.t);
        int alpha = this.o.getAlpha();
        Paint paint = this.o;
        int i2 = this.f4261b.m;
        paint.setAlpha(((i2 + (i2 >>> 7)) * alpha) >>> 8);
        this.p.setColorFilter(this.u);
        this.p.setStrokeWidth(this.f4261b.l);
        int alpha2 = this.p.getAlpha();
        Paint paint2 = this.p;
        int i3 = this.f4261b.m;
        paint2.setAlpha(((i3 + (i3 >>> 7)) * alpha2) >>> 8);
        boolean z2 = false;
        if (this.f4265f) {
            float f2 = -l();
            j jVar = this.f4261b.f4268a;
            if (jVar != null) {
                j.b bVar = new j.b(jVar);
                c cVar = jVar.f4281e;
                if (!(cVar instanceof h)) {
                    cVar = new b(f2, cVar);
                }
                bVar.f4288e = cVar;
                c cVar2 = jVar.f4282f;
                if (!(cVar2 instanceof h)) {
                    cVar2 = new b(f2, cVar2);
                }
                bVar.f4289f = cVar2;
                c cVar3 = jVar.h;
                if (!(cVar3 instanceof h)) {
                    cVar3 = new b(f2, cVar3);
                }
                bVar.h = cVar3;
                c cVar4 = jVar.f4283g;
                if (!(cVar4 instanceof h)) {
                    cVar4 = new b(f2, cVar4);
                }
                bVar.f4290g = cVar4;
                j a2 = bVar.a();
                this.n = a2;
                k kVar = this.s;
                float f3 = this.f4261b.k;
                this.k.set(i());
                float l2 = l();
                this.k.inset(l2, l2);
                kVar.a(a2, f3, this.k, null, this.i);
                b(i(), this.h);
                this.f4265f = false;
            } else {
                throw null;
            }
        }
        b bVar2 = this.f4261b;
        int i4 = bVar2.q;
        if (i4 != 1 && bVar2.r > 0) {
            if (i4 != 2) {
            }
            z = true;
            if (z) {
                canvas.save();
                canvas.translate((float) j(), (float) k());
                if (!this.w) {
                    g(canvas);
                } else {
                    int width = (int) (this.v.width() - ((float) getBounds().width()));
                    int height = (int) (this.v.height() - ((float) getBounds().height()));
                    if (width < 0 || height < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap createBitmap = Bitmap.createBitmap((this.f4261b.r * 2) + ((int) this.v.width()) + width, (this.f4261b.r * 2) + ((int) this.v.height()) + height, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    float f4 = (float) ((getBounds().left - this.f4261b.r) - width);
                    float f5 = (float) ((getBounds().top - this.f4261b.r) - height);
                    canvas2.translate(-f4, -f5);
                    g(canvas2);
                    canvas.drawBitmap(createBitmap, f4, f5, (Paint) null);
                    createBitmap.recycle();
                }
                canvas.restore();
            }
            Paint.Style style = this.f4261b.v;
            if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
                z2 = true;
            }
            if (z2) {
                h(canvas, this.o, this.h, this.f4261b.f4268a, i());
            }
            if (n()) {
                Paint paint3 = this.p;
                Path path = this.i;
                j jVar2 = this.n;
                this.k.set(i());
                float l3 = l();
                this.k.inset(l3, l3);
                h(canvas, paint3, path, jVar2, this.k);
            }
            this.o.setAlpha(alpha);
            this.p.setAlpha(alpha2);
        }
        z = false;
        if (z) {
        }
        Paint.Style style2 = this.f4261b.v;
        z2 = true;
        if (z2) {
        }
        if (n()) {
        }
        this.o.setAlpha(alpha);
        this.p.setAlpha(alpha2);
    }

    public final int e(int i2) {
        b bVar = this.f4261b;
        float f2 = bVar.o + bVar.p + bVar.n;
        c.b.a.b.z.a aVar = bVar.f4269b;
        return aVar != null ? aVar.a(i2, f2) : i2;
    }

    public final void g(Canvas canvas) {
        this.f4264e.cardinality();
        if (this.f4261b.s != 0) {
            canvas.drawPath(this.h, this.q.f4250a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.f4262c[i2].a(m.f.f4320a, this.q, this.f4261b.r, canvas);
            this.f4263d[i2].a(m.f.f4320a, this.q, this.f4261b.r, canvas);
        }
        if (this.w) {
            int j2 = j();
            int k2 = k();
            canvas.translate((float) (-j2), (float) (-k2));
            canvas.drawPath(this.h, y);
            canvas.translate((float) j2, (float) k2);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f4261b;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f4261b.q != 2) {
            if (p()) {
                outline.setRoundRect(getBounds(), m() * this.f4261b.k);
                return;
            }
            b(i(), this.h);
            if (this.h.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.h);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f4261b.i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Region getTransparentRegion() {
        this.l.set(getBounds());
        b(i(), this.h);
        this.m.setPath(this.h, this.l);
        this.l.op(this.m, Region.Op.DIFFERENCE);
        return this.l;
    }

    public final void h(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (jVar.d(rectF)) {
            float a2 = jVar.f4282f.a(rectF) * this.f4261b.k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    public RectF i() {
        this.j.set(getBounds());
        return this.j;
    }

    public void invalidateSelf() {
        this.f4265f = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f4261b.f4274g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f4261b.f4273f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f4261b.f4272e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f4261b.f4271d) != null && colorStateList4.isStateful())));
    }

    public int j() {
        b bVar = this.f4261b;
        return (int) (Math.sin(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public int k() {
        b bVar = this.f4261b;
        return (int) (Math.cos(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public final float l() {
        if (n()) {
            return this.p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float m() {
        return this.f4261b.f4268a.f4281e.a(i());
    }

    public Drawable mutate() {
        this.f4261b = new b(this.f4261b);
        return this;
    }

    public final boolean n() {
        Paint.Style style = this.f4261b.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.p.getStrokeWidth() > 0.0f;
    }

    public void o(Context context) {
        this.f4261b.f4269b = new c.b.a.b.z.a(context);
        z();
    }

    public void onBoundsChange(Rect rect) {
        this.f4265f = true;
        super.onBoundsChange(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z = x(iArr) || y();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public boolean p() {
        return this.f4261b.f4268a.d(i());
    }

    public void q(float f2) {
        b bVar = this.f4261b;
        if (bVar.o != f2) {
            bVar.o = f2;
            z();
        }
    }

    public void r(ColorStateList colorStateList) {
        b bVar = this.f4261b;
        if (bVar.f4271d != colorStateList) {
            bVar.f4271d = colorStateList;
            onStateChange(getState());
        }
    }

    public void s(float f2) {
        b bVar = this.f4261b;
        if (bVar.k != f2) {
            bVar.k = f2;
            this.f4265f = true;
            invalidateSelf();
        }
    }

    public void setAlpha(int i2) {
        b bVar = this.f4261b;
        if (bVar.m != i2) {
            bVar.m = i2;
            super.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4261b.f4270c = colorFilter;
        super.invalidateSelf();
    }

    @Override // c.b.a.b.h0.n
    public void setShapeAppearanceModel(j jVar) {
        this.f4261b.f4268a = jVar;
        invalidateSelf();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f4261b.f4274g = colorStateList;
        y();
        super.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f4261b;
        if (bVar.h != mode) {
            bVar.h = mode;
            y();
            super.invalidateSelf();
        }
    }

    public void t(int i2) {
        this.q.a(i2);
        this.f4261b.u = false;
        super.invalidateSelf();
    }

    public void u(float f2, int i2) {
        this.f4261b.l = f2;
        invalidateSelf();
        w(ColorStateList.valueOf(i2));
    }

    public void v(float f2, ColorStateList colorStateList) {
        this.f4261b.l = f2;
        invalidateSelf();
        w(colorStateList);
    }

    public void w(ColorStateList colorStateList) {
        b bVar = this.f4261b;
        if (bVar.f4272e != colorStateList) {
            bVar.f4272e = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean x(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f4261b.f4271d == null || color2 == (colorForState2 = this.f4261b.f4271d.getColorForState(iArr, (color2 = this.o.getColor())))) {
            z = false;
        } else {
            this.o.setColor(colorForState2);
            z = true;
        }
        if (this.f4261b.f4272e == null || color == (colorForState = this.f4261b.f4272e.getColorForState(iArr, (color = this.p.getColor())))) {
            return z;
        }
        this.p.setColor(colorForState);
        return true;
    }

    public final boolean y() {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        b bVar = this.f4261b;
        this.t = d(bVar.f4274g, bVar.h, this.o, true);
        b bVar2 = this.f4261b;
        this.u = d(bVar2.f4273f, bVar2.h, this.p, false);
        b bVar3 = this.f4261b;
        if (bVar3.u) {
            this.q.a(bVar3.f4274g.getColorForState(getState(), 0));
        }
        return !Objects.equals(porterDuffColorFilter, this.t) || !Objects.equals(porterDuffColorFilter2, this.u);
    }

    public final void z() {
        b bVar = this.f4261b;
        float f2 = bVar.o + bVar.p;
        bVar.r = (int) Math.ceil((double) (0.75f * f2));
        this.f4261b.s = (int) Math.ceil((double) (f2 * 0.25f));
        y();
        super.invalidateSelf();
    }
}
