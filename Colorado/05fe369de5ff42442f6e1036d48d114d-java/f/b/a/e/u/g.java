package f.b.a.e.u;

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
import f.b.a.e.u.j;
import f.b.a.e.u.k;
import f.b.a.e.u.m;
import java.util.BitSet;
import java.util.Objects;

public class g extends Drawable implements e.i.c.l.a, n {
    public static final String x = g.class.getSimpleName();
    public static final Paint y = new Paint(1);
    public b b;
    public final m.f[] c;

    /* renamed from: d  reason: collision with root package name */
    public final m.f[] f2962d;

    /* renamed from: e  reason: collision with root package name */
    public final BitSet f2963e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2964f;

    /* renamed from: g  reason: collision with root package name */
    public final Matrix f2965g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f2966h;

    /* renamed from: i  reason: collision with root package name */
    public final Path f2967i;

    /* renamed from: j  reason: collision with root package name */
    public final RectF f2968j;

    /* renamed from: k  reason: collision with root package name */
    public final RectF f2969k;

    /* renamed from: l  reason: collision with root package name */
    public final Region f2970l;
    public final Region m;
    public j n;
    public final Paint o;
    public final Paint p;
    public final f.b.a.e.t.a q;
    public final k.b r;
    public final k s;
    public PorterDuffColorFilter t;
    public PorterDuffColorFilter u;
    public final RectF v;
    public boolean w;

    public class a implements k.b {
        public a() {
        }
    }

    public static final class b extends Drawable.ConstantState {
        public j a;
        public f.b.a.e.m.a b;
        public ColorFilter c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f2971d = null;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f2972e = null;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f2973f = null;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f2974g = null;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f2975h = PorterDuff.Mode.SRC_IN;

        /* renamed from: i  reason: collision with root package name */
        public Rect f2976i = null;

        /* renamed from: j  reason: collision with root package name */
        public float f2977j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f2978k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f2979l;
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
            this.f2979l = bVar.f2979l;
            this.c = bVar.c;
            this.f2971d = bVar.f2971d;
            this.f2972e = bVar.f2972e;
            this.f2975h = bVar.f2975h;
            this.f2974g = bVar.f2974g;
            this.m = bVar.m;
            this.f2977j = bVar.f2977j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.f2978k = bVar.f2978k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f2973f = bVar.f2973f;
            this.v = bVar.v;
            if (bVar.f2976i != null) {
                this.f2976i = new Rect(bVar.f2976i);
            }
        }

        public b(j jVar, f.b.a.e.m.a aVar) {
            this.a = jVar;
            this.b = null;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f2964f = true;
            return gVar;
        }
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
        this.f2962d = new m.f[4];
        this.f2963e = new BitSet(8);
        this.f2965g = new Matrix();
        this.f2966h = new Path();
        this.f2967i = new Path();
        this.f2968j = new RectF();
        this.f2969k = new RectF();
        this.f2970l = new Region();
        this.m = new Region();
        Paint paint = new Paint(1);
        this.o = paint;
        Paint paint2 = new Paint(1);
        this.p = paint2;
        this.q = new f.b.a.e.t.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            kVar = k.a.a;
        } else {
            kVar = new k();
        }
        this.s = kVar;
        this.v = new RectF();
        this.w = true;
        this.b = bVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = y;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        x();
        w(getState());
        this.r = new a();
    }

    public g(j jVar) {
        this(new b(jVar, null));
    }

    public final void b(RectF rectF, Path path) {
        c(rectF, path);
        if (this.b.f2977j != 1.0f) {
            this.f2965g.reset();
            Matrix matrix = this.f2965g;
            float f2 = this.b.f2977j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f2965g);
        }
        path.computeBounds(this.v, true);
    }

    public final void c(RectF rectF, Path path) {
        k kVar = this.s;
        b bVar = this.b;
        kVar.a(bVar.a, bVar.f2978k, rectF, this.r, path);
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

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00eb, code lost:
        if ((!o() && !r12.f2966h.isConvex() && android.os.Build.VERSION.SDK_INT < 29) != false) goto L_0x00ed;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01ab  */
    public void draw(Canvas canvas) {
        boolean z;
        this.o.setColorFilter(this.t);
        int alpha = this.o.getAlpha();
        Paint paint = this.o;
        int i2 = this.b.m;
        paint.setAlpha(((i2 + (i2 >>> 7)) * alpha) >>> 8);
        this.p.setColorFilter(this.u);
        this.p.setStrokeWidth(this.b.f2979l);
        int alpha2 = this.p.getAlpha();
        Paint paint2 = this.p;
        int i3 = this.b.m;
        paint2.setAlpha(((i3 + (i3 >>> 7)) * alpha2) >>> 8);
        boolean z2 = false;
        if (this.f2964f) {
            float f2 = -k();
            j jVar = this.b.a;
            Objects.requireNonNull(jVar);
            j.b bVar = new j.b(jVar);
            c cVar = jVar.f2981e;
            if (!(cVar instanceof h)) {
                cVar = new b(f2, cVar);
            }
            bVar.f2990e = cVar;
            c cVar2 = jVar.f2982f;
            if (!(cVar2 instanceof h)) {
                cVar2 = new b(f2, cVar2);
            }
            bVar.f2991f = cVar2;
            c cVar3 = jVar.f2984h;
            if (!(cVar3 instanceof h)) {
                cVar3 = new b(f2, cVar3);
            }
            bVar.f2993h = cVar3;
            c cVar4 = jVar.f2983g;
            if (!(cVar4 instanceof h)) {
                cVar4 = new b(f2, cVar4);
            }
            bVar.f2992g = cVar4;
            j a2 = bVar.a();
            this.n = a2;
            k kVar = this.s;
            float f3 = this.b.f2978k;
            this.f2969k.set(h());
            float k2 = k();
            this.f2969k.inset(k2, k2);
            kVar.a(a2, f3, this.f2969k, null, this.f2967i);
            b(h(), this.f2966h);
            this.f2964f = false;
        }
        b bVar2 = this.b;
        int i4 = bVar2.q;
        if (i4 != 1 && bVar2.r > 0) {
            if (i4 != 2) {
            }
            z = true;
            if (z) {
                canvas.save();
                canvas.translate((float) i(), (float) j());
                if (!this.w) {
                    f(canvas);
                } else {
                    int width = (int) (this.v.width() - ((float) getBounds().width()));
                    int height = (int) (this.v.height() - ((float) getBounds().height()));
                    if (width < 0 || height < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap createBitmap = Bitmap.createBitmap((this.b.r * 2) + ((int) this.v.width()) + width, (this.b.r * 2) + ((int) this.v.height()) + height, Bitmap.Config.ARGB_8888);
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
                z2 = true;
            }
            if (z2) {
                g(canvas, this.o, this.f2966h, bVar3.a, h());
            }
            if (m()) {
                Paint paint3 = this.p;
                Path path = this.f2967i;
                j jVar2 = this.n;
                this.f2969k.set(h());
                float k3 = k();
                this.f2969k.inset(k3, k3);
                g(canvas, paint3, path, jVar2, this.f2969k);
            }
            this.o.setAlpha(alpha);
            this.p.setAlpha(alpha2);
        }
        z = false;
        if (z) {
        }
        b bVar32 = this.b;
        Paint.Style style2 = bVar32.v;
        z2 = true;
        if (z2) {
        }
        if (m()) {
        }
        this.o.setAlpha(alpha);
        this.p.setAlpha(alpha2);
    }

    public int e(int i2) {
        b bVar = this.b;
        float f2 = bVar.o + bVar.p + bVar.n;
        f.b.a.e.m.a aVar = bVar.b;
        return aVar != null ? aVar.a(i2, f2) : i2;
    }

    public final void f(Canvas canvas) {
        this.f2963e.cardinality();
        if (this.b.s != 0) {
            canvas.drawPath(this.f2966h, this.q.a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            m.f fVar = this.c[i2];
            f.b.a.e.t.a aVar = this.q;
            int i3 = this.b.r;
            Matrix matrix = m.f.a;
            fVar.a(matrix, aVar, i3, canvas);
            this.f2962d[i2].a(matrix, this.q, this.b.r, canvas);
        }
        if (this.w) {
            int i4 = i();
            int j2 = j();
            canvas.translate((float) (-i4), (float) (-j2));
            canvas.drawPath(this.f2966h, y);
            canvas.translate((float) i4, (float) j2);
        }
    }

    public final void g(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (jVar.d(rectF)) {
            float a2 = jVar.f2982f.a(rectF) * this.b.f2978k;
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
                outline.setRoundRect(getBounds(), l() * this.b.f2978k);
                return;
            }
            b(h(), this.f2966h);
            if (this.f2966h.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.f2966h);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.b.f2976i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Region getTransparentRegion() {
        this.f2970l.set(getBounds());
        b(h(), this.f2966h);
        this.m.setPath(this.f2966h, this.f2970l);
        this.f2970l.op(this.m, Region.Op.DIFFERENCE);
        return this.f2970l;
    }

    public RectF h() {
        this.f2968j.set(getBounds());
        return this.f2968j;
    }

    public int i() {
        b bVar = this.b;
        return (int) (Math.sin(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public void invalidateSelf() {
        this.f2964f = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.b.f2974g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.b.f2973f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.b.f2972e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.b.f2971d) != null && colorStateList4.isStateful())));
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
        return this.b.a.f2981e.a(h());
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
        this.b.b = new f.b.a.e.m.a(context);
        y();
    }

    public boolean o() {
        return this.b.a.d(h());
    }

    public void onBoundsChange(Rect rect) {
        this.f2964f = true;
        super.onBoundsChange(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z = w(iArr) || x();
        if (z) {
            invalidateSelf();
        }
        return z;
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
        if (bVar.f2971d != colorStateList) {
            bVar.f2971d = colorStateList;
            onStateChange(getState());
        }
    }

    public void r(float f2) {
        b bVar = this.b;
        if (bVar.f2978k != f2) {
            bVar.f2978k = f2;
            this.f2964f = true;
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

    @Override // f.b.a.e.u.n
    public void setShapeAppearanceModel(j jVar) {
        this.b.a = jVar;
        invalidateSelf();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.b.f2974g = colorStateList;
        x();
        super.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.b;
        if (bVar.f2975h != mode) {
            bVar.f2975h = mode;
            x();
            super.invalidateSelf();
        }
    }

    public void t(float f2, int i2) {
        this.b.f2979l = f2;
        invalidateSelf();
        v(ColorStateList.valueOf(i2));
    }

    public void u(float f2, ColorStateList colorStateList) {
        this.b.f2979l = f2;
        invalidateSelf();
        v(colorStateList);
    }

    public void v(ColorStateList colorStateList) {
        b bVar = this.b;
        if (bVar.f2972e != colorStateList) {
            bVar.f2972e = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean w(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.b.f2971d == null || color2 == (colorForState2 = this.b.f2971d.getColorForState(iArr, (color2 = this.o.getColor())))) {
            z = false;
        } else {
            this.o.setColor(colorForState2);
            z = true;
        }
        if (this.b.f2972e == null || color == (colorForState = this.b.f2972e.getColorForState(iArr, (color = this.p.getColor())))) {
            return z;
        }
        this.p.setColor(colorForState);
        return true;
    }

    public final boolean x() {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        b bVar = this.b;
        this.t = d(bVar.f2974g, bVar.f2975h, this.o, true);
        b bVar2 = this.b;
        this.u = d(bVar2.f2973f, bVar2.f2975h, this.p, false);
        b bVar3 = this.b;
        if (bVar3.u) {
            this.q.a(bVar3.f2974g.getColorForState(getState(), 0));
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
