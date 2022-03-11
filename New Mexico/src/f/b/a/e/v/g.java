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
/* loaded from: classes.dex */
public class g extends Drawable implements e.j.c.m.a, n {
    public static final String y = g.class.getSimpleName();
    public static final Paint z;
    public b b;
    public final m.f[] c;

    /* renamed from: d */
    public final m.f[] f3068d;

    /* renamed from: e */
    public final BitSet f3069e;

    /* renamed from: f */
    public boolean f3070f;

    /* renamed from: g */
    public final Matrix f3071g;

    /* renamed from: h */
    public final Path f3072h;

    /* renamed from: i */
    public final Path f3073i;

    /* renamed from: j */
    public final RectF f3074j;

    /* renamed from: k */
    public final RectF f3075k;

    /* renamed from: l */
    public final Region f3076l;
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

    /* loaded from: classes.dex */
    public class a implements k.b {
        public a() {
            g.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {
        public j a;
        public f.b.a.e.n.a b;
        public ColorFilter c;

        /* renamed from: d */
        public ColorStateList f3077d;

        /* renamed from: e */
        public ColorStateList f3078e;

        /* renamed from: f */
        public ColorStateList f3079f;

        /* renamed from: g */
        public ColorStateList f3080g;

        /* renamed from: h */
        public PorterDuff.Mode f3081h;

        /* renamed from: i */
        public Rect f3082i;

        /* renamed from: j */
        public float f3083j;

        /* renamed from: k */
        public float f3084k;

        /* renamed from: l */
        public float f3085l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public b(b bVar) {
            this.f3077d = null;
            this.f3078e = null;
            this.f3079f = null;
            this.f3080g = null;
            this.f3081h = PorterDuff.Mode.SRC_IN;
            this.f3082i = null;
            this.f3083j = 1.0f;
            this.f3084k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = bVar.a;
            this.b = bVar.b;
            this.f3085l = bVar.f3085l;
            this.c = bVar.c;
            this.f3077d = bVar.f3077d;
            this.f3078e = bVar.f3078e;
            this.f3081h = bVar.f3081h;
            this.f3080g = bVar.f3080g;
            this.m = bVar.m;
            this.f3083j = bVar.f3083j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.f3084k = bVar.f3084k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f3079f = bVar.f3079f;
            this.v = bVar.v;
            if (bVar.f3082i != null) {
                this.f3082i = new Rect(bVar.f3082i);
            }
        }

        public b(j jVar, f.b.a.e.n.a aVar) {
            this.f3077d = null;
            this.f3078e = null;
            this.f3079f = null;
            this.f3080g = null;
            this.f3081h = PorterDuff.Mode.SRC_IN;
            this.f3082i = null;
            this.f3083j = 1.0f;
            this.f3084k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = jVar;
            this.b = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f3070f = true;
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
        this.f3068d = new m.f[4];
        this.f3069e = new BitSet(8);
        this.f3071g = new Matrix();
        this.f3072h = new Path();
        this.f3073i = new Path();
        this.f3074j = new RectF();
        this.f3075k = new RectF();
        this.f3076l = new Region();
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
        y();
        x(getState());
        this.r = new a();
    }

    public g(j jVar) {
        this(new b(jVar, null));
    }

    public final void b(RectF rectF, Path path) {
        c(rectF, path);
        if (this.b.f3083j != 1.0f) {
            this.f3071g.reset();
            Matrix matrix = this.f3071g;
            float f2 = this.b.f3083j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f3071g);
        }
        path.computeBounds(this.w, true);
    }

    public final void c(RectF rectF, Path path) {
        k kVar = this.s;
        b bVar = this.b;
        kVar.a(bVar.a, bVar.f3084k, rectF, this.r, path);
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00eb, code lost:
        if ((!p() && !r12.f3072h.isConvex() && android.os.Build.VERSION.SDK_INT < 29) != false) goto L_0x00ed;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ab  */
    @Override // android.graphics.drawable.Drawable
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void draw(Canvas canvas) {
        boolean z2;
        Paint.Style style;
        this.o.setColorFilter(this.t);
        int alpha = this.o.getAlpha();
        Paint paint = this.o;
        int i2 = this.b.m;
        paint.setAlpha(((i2 + (i2 >>> 7)) * alpha) >>> 8);
        this.p.setColorFilter(this.u);
        this.p.setStrokeWidth(this.b.f3085l);
        int alpha2 = this.p.getAlpha();
        Paint paint2 = this.p;
        int i3 = this.b.m;
        paint2.setAlpha(((i3 + (i3 >>> 7)) * alpha2) >>> 8);
        boolean z3 = false;
        if (this.f3070f) {
            float f2 = -l();
            j jVar = this.b.a;
            Objects.requireNonNull(jVar);
            j.b bVar = new j.b(jVar);
            c cVar = jVar.f3087e;
            if (!(cVar instanceof h)) {
                cVar = new b(f2, cVar);
            }
            bVar.f3096e = cVar;
            c cVar2 = jVar.f3088f;
            if (!(cVar2 instanceof h)) {
                cVar2 = new b(f2, cVar2);
            }
            bVar.f3097f = cVar2;
            c cVar3 = jVar.f3090h;
            if (!(cVar3 instanceof h)) {
                cVar3 = new b(f2, cVar3);
            }
            bVar.f3099h = cVar3;
            c cVar4 = jVar.f3089g;
            if (!(cVar4 instanceof h)) {
                cVar4 = new b(f2, cVar4);
            }
            bVar.f3098g = cVar4;
            j a2 = bVar.a();
            this.n = a2;
            k kVar = this.s;
            float f3 = this.b.f3084k;
            this.f3075k.set(i());
            float l2 = l();
            this.f3075k.inset(l2, l2);
            kVar.a(a2, f3, this.f3075k, null, this.f3073i);
            b(i(), this.f3072h);
            this.f3070f = false;
        }
        b bVar2 = this.b;
        int i4 = bVar2.q;
        if (i4 != 1 && bVar2.r > 0) {
            if (i4 != 2) {
            }
            z2 = true;
            if (z2) {
                canvas.save();
                canvas.translate((float) j(), (float) k());
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
            style = bVar3.v;
            if (style != Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
                z3 = true;
            }
            if (z3) {
                g(canvas, this.o, this.f3072h, bVar3.a, i());
            }
            if (n()) {
                h(canvas);
            }
            this.o.setAlpha(alpha);
            this.p.setAlpha(alpha2);
        }
        z2 = false;
        if (z2) {
        }
        b bVar32 = this.b;
        style = bVar32.v;
        if (style != Paint.Style.FILL_AND_STROKE) {
        }
        z3 = true;
        if (z3) {
        }
        if (n()) {
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
        this.f3069e.cardinality();
        if (this.b.s != 0) {
            canvas.drawPath(this.f3072h, this.q.a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            m.f fVar = this.c[i2];
            f.b.a.e.u.a aVar = this.q;
            int i3 = this.b.r;
            Matrix matrix = m.f.a;
            fVar.a(matrix, aVar, i3, canvas);
            this.f3068d[i2].a(matrix, this.q, this.b.r, canvas);
        }
        if (this.x) {
            int j2 = j();
            int k2 = k();
            canvas.translate((float) (-j2), (float) (-k2));
            canvas.drawPath(this.f3072h, z);
            canvas.translate((float) j2, (float) k2);
        }
    }

    public final void g(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (jVar.d(rectF)) {
            float a2 = jVar.f3088f.a(rectF) * this.b.f3084k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.b.q != 2) {
            if (p()) {
                outline.setRoundRect(getBounds(), m() * this.b.f3084k);
                return;
            }
            b(i(), this.f3072h);
            if (this.f3072h.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.f3072h);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.b.f3082i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f3076l.set(getBounds());
        b(i(), this.f3072h);
        this.m.setPath(this.f3072h, this.f3076l);
        this.f3076l.op(this.m, Region.Op.DIFFERENCE);
        return this.f3076l;
    }

    public void h(Canvas canvas) {
        Paint paint = this.p;
        Path path = this.f3073i;
        j jVar = this.n;
        this.f3075k.set(i());
        float l2 = l();
        this.f3075k.inset(l2, l2);
        g(canvas, paint, path, jVar, this.f3075k);
    }

    public RectF i() {
        this.f3074j.set(getBounds());
        return this.f3074j;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f3070f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.b.f3080g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.b.f3079f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.b.f3078e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.b.f3077d) != null && colorStateList4.isStateful())));
    }

    public int j() {
        b bVar = this.b;
        return (int) (Math.sin(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public int k() {
        b bVar = this.b;
        return (int) (Math.cos(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public final float l() {
        if (n()) {
            return this.p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float m() {
        return this.b.a.f3087e.a(i());
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.b = new b(this.b);
        return this;
    }

    public final boolean n() {
        Paint.Style style = this.b.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.p.getStrokeWidth() > 0.0f;
    }

    public void o(Context context) {
        this.b.b = new f.b.a.e.n.a(context);
        z();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f3070f = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, f.b.a.e.q.i.b
    public boolean onStateChange(int[] iArr) {
        boolean z2 = x(iArr) || y();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public boolean p() {
        return this.b.a.d(i());
    }

    public void q(float f2) {
        b bVar = this.b;
        if (bVar.o != f2) {
            bVar.o = f2;
            z();
        }
    }

    public void r(ColorStateList colorStateList) {
        b bVar = this.b;
        if (bVar.f3077d != colorStateList) {
            bVar.f3077d = colorStateList;
            onStateChange(getState());
        }
    }

    public void s(float f2) {
        b bVar = this.b;
        if (bVar.f3084k != f2) {
            bVar.f3084k = f2;
            this.f3070f = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        b bVar = this.b;
        if (bVar.m != i2) {
            bVar.m = i2;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.c = colorFilter;
        super.invalidateSelf();
    }

    @Override // f.b.a.e.v.n
    public void setShapeAppearanceModel(j jVar) {
        this.b.a = jVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.b.f3080g = colorStateList;
        y();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.b;
        if (bVar.f3081h != mode) {
            bVar.f3081h = mode;
            y();
            super.invalidateSelf();
        }
    }

    public void t(int i2) {
        this.q.a(i2);
        this.b.u = false;
        super.invalidateSelf();
    }

    public void u(float f2, int i2) {
        this.b.f3085l = f2;
        invalidateSelf();
        w(ColorStateList.valueOf(i2));
    }

    public void v(float f2, ColorStateList colorStateList) {
        this.b.f3085l = f2;
        invalidateSelf();
        w(colorStateList);
    }

    public void w(ColorStateList colorStateList) {
        b bVar = this.b;
        if (bVar.f3078e != colorStateList) {
            bVar.f3078e = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean x(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.b.f3077d == null || color2 == (colorForState2 = this.b.f3077d.getColorForState(iArr, (color2 = this.o.getColor())))) {
            z2 = false;
        } else {
            this.o.setColor(colorForState2);
            z2 = true;
        }
        if (this.b.f3078e == null || color == (colorForState = this.b.f3078e.getColorForState(iArr, (color = this.p.getColor())))) {
            return z2;
        }
        this.p.setColor(colorForState);
        return true;
    }

    public final boolean y() {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        b bVar = this.b;
        this.t = d(bVar.f3080g, bVar.f3081h, this.o, true);
        b bVar2 = this.b;
        this.u = d(bVar2.f3079f, bVar2.f3081h, this.p, false);
        b bVar3 = this.b;
        if (bVar3.u) {
            this.q.a(bVar3.f3080g.getColorForState(getState(), 0));
        }
        if (!Objects.equals(porterDuffColorFilter, this.t) || !Objects.equals(porterDuffColorFilter2, this.u)) {
            return true;
        }
        return false;
    }

    public final void z() {
        b bVar = this.b;
        float f2 = bVar.o + bVar.p;
        bVar.r = (int) Math.ceil((double) (0.75f * f2));
        this.b.s = (int) Math.ceil((double) (f2 * 0.25f));
        y();
        super.invalidateSelf();
    }
}
