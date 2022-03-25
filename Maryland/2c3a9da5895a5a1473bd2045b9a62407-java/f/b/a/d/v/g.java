package f.b.a.d.v;

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
import android.util.Log;
import f.b.a.d.v.j;
import f.b.a.d.v.k;
import f.b.a.d.v.m;
import java.util.BitSet;
import java.util.Objects;

public class g extends Drawable implements e.i.c.l.a, n {
    public static final String x = g.class.getSimpleName();
    public static final Paint y = new Paint(1);
    public b b;
    public final m.f[] c;

    /* renamed from: d  reason: collision with root package name */
    public final m.f[] f2865d;

    /* renamed from: e  reason: collision with root package name */
    public final BitSet f2866e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2867f;

    /* renamed from: g  reason: collision with root package name */
    public final Matrix f2868g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f2869h;

    /* renamed from: i  reason: collision with root package name */
    public final Path f2870i;

    /* renamed from: j  reason: collision with root package name */
    public final RectF f2871j;

    /* renamed from: k  reason: collision with root package name */
    public final RectF f2872k;

    /* renamed from: l  reason: collision with root package name */
    public final Region f2873l;
    public final Region m;
    public j n;
    public final Paint o;
    public final Paint p;
    public final f.b.a.d.u.a q;
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
        public f.b.a.d.n.a b;
        public ColorFilter c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f2874d = null;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f2875e = null;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f2876f = null;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f2877g = null;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f2878h = PorterDuff.Mode.SRC_IN;

        /* renamed from: i  reason: collision with root package name */
        public Rect f2879i = null;

        /* renamed from: j  reason: collision with root package name */
        public float f2880j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f2881k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f2882l;
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
            this.f2882l = bVar.f2882l;
            this.c = bVar.c;
            this.f2874d = bVar.f2874d;
            this.f2875e = bVar.f2875e;
            this.f2878h = bVar.f2878h;
            this.f2877g = bVar.f2877g;
            this.m = bVar.m;
            this.f2880j = bVar.f2880j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.f2881k = bVar.f2881k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f2876f = bVar.f2876f;
            this.v = bVar.v;
            if (bVar.f2879i != null) {
                this.f2879i = new Rect(bVar.f2879i);
            }
        }

        public b(j jVar, f.b.a.d.n.a aVar) {
            this.a = jVar;
            this.b = null;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f2867f = true;
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
        this.f2865d = new m.f[4];
        this.f2866e = new BitSet(8);
        this.f2868g = new Matrix();
        this.f2869h = new Path();
        this.f2870i = new Path();
        this.f2871j = new RectF();
        this.f2872k = new RectF();
        this.f2873l = new Region();
        this.m = new Region();
        Paint paint = new Paint(1);
        this.o = paint;
        Paint paint2 = new Paint(1);
        this.p = paint2;
        this.q = new f.b.a.d.u.a();
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
        if (this.b.f2880j != 1.0f) {
            this.f2868g.reset();
            Matrix matrix = this.f2868g;
            float f2 = this.b.f2880j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f2868g);
        }
        path.computeBounds(this.v, true);
    }

    public final void c(RectF rectF, Path path) {
        k kVar = this.s;
        b bVar = this.b;
        kVar.a(bVar.a, bVar.f2881k, rectF, this.r, path);
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
        if ((!o() && !r12.f2869h.isConvex() && android.os.Build.VERSION.SDK_INT < 29) != false) goto L_0x00ed;
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
        this.p.setStrokeWidth(this.b.f2882l);
        int alpha2 = this.p.getAlpha();
        Paint paint2 = this.p;
        int i3 = this.b.m;
        paint2.setAlpha(((i3 + (i3 >>> 7)) * alpha2) >>> 8);
        boolean z2 = false;
        if (this.f2867f) {
            float f2 = -k();
            j jVar = this.b.a;
            Objects.requireNonNull(jVar);
            j.b bVar = new j.b(jVar);
            c cVar = jVar.f2884e;
            if (!(cVar instanceof h)) {
                cVar = new b(f2, cVar);
            }
            bVar.f2893e = cVar;
            c cVar2 = jVar.f2885f;
            if (!(cVar2 instanceof h)) {
                cVar2 = new b(f2, cVar2);
            }
            bVar.f2894f = cVar2;
            c cVar3 = jVar.f2887h;
            if (!(cVar3 instanceof h)) {
                cVar3 = new b(f2, cVar3);
            }
            bVar.f2896h = cVar3;
            c cVar4 = jVar.f2886g;
            if (!(cVar4 instanceof h)) {
                cVar4 = new b(f2, cVar4);
            }
            bVar.f2895g = cVar4;
            j a2 = bVar.a();
            this.n = a2;
            k kVar = this.s;
            float f3 = this.b.f2881k;
            this.f2872k.set(h());
            float k2 = k();
            this.f2872k.inset(k2, k2);
            kVar.a(a2, f3, this.f2872k, null, this.f2870i);
            b(h(), this.f2869h);
            this.f2867f = false;
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
                g(canvas, this.o, this.f2869h, bVar3.a, h());
            }
            if (m()) {
                Paint paint3 = this.p;
                Path path = this.f2870i;
                j jVar2 = this.n;
                this.f2872k.set(h());
                float k3 = k();
                this.f2872k.inset(k3, k3);
                g(canvas, paint3, path, jVar2, this.f2872k);
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
        f.b.a.d.n.a aVar = bVar.b;
        return aVar != null ? aVar.a(i2, f2) : i2;
    }

    public final void f(Canvas canvas) {
        if (this.f2866e.cardinality() > 0) {
            Log.w(x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.b.s != 0) {
            canvas.drawPath(this.f2869h, this.q.a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            m.f fVar = this.c[i2];
            f.b.a.d.u.a aVar = this.q;
            int i3 = this.b.r;
            Matrix matrix = m.f.a;
            fVar.a(matrix, aVar, i3, canvas);
            this.f2865d[i2].a(matrix, this.q, this.b.r, canvas);
        }
        if (this.w) {
            int i4 = i();
            int j2 = j();
            canvas.translate((float) (-i4), (float) (-j2));
            canvas.drawPath(this.f2869h, y);
            canvas.translate((float) i4, (float) j2);
        }
    }

    public final void g(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (jVar.d(rectF)) {
            float a2 = jVar.f2885f.a(rectF) * this.b.f2881k;
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
                outline.setRoundRect(getBounds(), l() * this.b.f2881k);
                return;
            }
            b(h(), this.f2869h);
            if (this.f2869h.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.f2869h);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.b.f2879i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Region getTransparentRegion() {
        this.f2873l.set(getBounds());
        b(h(), this.f2869h);
        this.m.setPath(this.f2869h, this.f2873l);
        this.f2873l.op(this.m, Region.Op.DIFFERENCE);
        return this.f2873l;
    }

    public RectF h() {
        this.f2871j.set(getBounds());
        return this.f2871j;
    }

    public int i() {
        b bVar = this.b;
        return (int) (Math.sin(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public void invalidateSelf() {
        this.f2867f = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.b.f2877g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.b.f2876f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.b.f2875e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.b.f2874d) != null && colorStateList4.isStateful())));
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
        return this.b.a.f2884e.a(h());
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
        this.b.b = new f.b.a.d.n.a(context);
        y();
    }

    public boolean o() {
        return this.b.a.d(h());
    }

    public void onBoundsChange(Rect rect) {
        this.f2867f = true;
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
        if (bVar.f2874d != colorStateList) {
            bVar.f2874d = colorStateList;
            onStateChange(getState());
        }
    }

    public void r(float f2) {
        b bVar = this.b;
        if (bVar.f2881k != f2) {
            bVar.f2881k = f2;
            this.f2867f = true;
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

    @Override // f.b.a.d.v.n
    public void setShapeAppearanceModel(j jVar) {
        this.b.a = jVar;
        invalidateSelf();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.b.f2877g = colorStateList;
        x();
        super.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.b;
        if (bVar.f2878h != mode) {
            bVar.f2878h = mode;
            x();
            super.invalidateSelf();
        }
    }

    public void t(float f2, int i2) {
        this.b.f2882l = f2;
        invalidateSelf();
        v(ColorStateList.valueOf(i2));
    }

    public void u(float f2, ColorStateList colorStateList) {
        this.b.f2882l = f2;
        invalidateSelf();
        v(colorStateList);
    }

    public void v(ColorStateList colorStateList) {
        b bVar = this.b;
        if (bVar.f2875e != colorStateList) {
            bVar.f2875e = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean w(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.b.f2874d == null || color2 == (colorForState2 = this.b.f2874d.getColorForState(iArr, (color2 = this.o.getColor())))) {
            z = false;
        } else {
            this.o.setColor(colorForState2);
            z = true;
        }
        if (this.b.f2875e == null || color == (colorForState = this.b.f2875e.getColorForState(iArr, (color = this.p.getColor())))) {
            return z;
        }
        this.p.setColor(colorForState);
        return true;
    }

    public final boolean x() {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        b bVar = this.b;
        this.t = d(bVar.f2877g, bVar.f2878h, this.o, true);
        b bVar2 = this.b;
        this.u = d(bVar2.f2876f, bVar2.f2878h, this.p, false);
        b bVar3 = this.b;
        if (bVar3.u) {
            this.q.a(bVar3.f2877g.getColorForState(getState(), 0));
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
