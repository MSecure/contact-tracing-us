package f.b.a.d.j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import e.b.a.m;
import f.b.a.d.q.i;
import f.b.a.d.v.g;
import f.b.a.d.v.j;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class b extends g implements e.i.c.l.a, Drawable.Callback, i.b {
    public static final int[] I0 = {16842910};
    public static final ShapeDrawable J0 = new ShapeDrawable(new OvalShape());
    public ColorStateList A;
    public int[] A0;
    public float B;
    public boolean B0;
    public float C = -1.0f;
    public ColorStateList C0;
    public ColorStateList D;
    public WeakReference<a> D0 = new WeakReference<>(null);
    public float E;
    public TextUtils.TruncateAt E0;
    public ColorStateList F;
    public boolean F0;
    public CharSequence G;
    public int G0;
    public boolean H;
    public boolean H0;
    public Drawable I;
    public ColorStateList J;
    public float K;
    public boolean L;
    public boolean M;
    public Drawable N;
    public Drawable O;
    public ColorStateList P;
    public float Q;
    public CharSequence R;
    public boolean S;
    public boolean T;
    public Drawable U;
    public ColorStateList V;
    public f.b.a.d.a.g W;
    public f.b.a.d.a.g X;
    public float Y;
    public float Z;
    public float a0;
    public float b0;
    public float c0;
    public float d0;
    public float e0;
    public float f0;
    public final Context g0;
    public final Paint h0 = new Paint(1);
    public final Paint.FontMetrics i0 = new Paint.FontMetrics();
    public final RectF j0 = new RectF();
    public final PointF k0 = new PointF();
    public final Path l0 = new Path();
    public final i m0;
    public int n0;
    public int o0;
    public int p0;
    public int q0;
    public int r0;
    public int s0;
    public boolean t0;
    public int u0;
    public int v0 = 255;
    public ColorFilter w0;
    public PorterDuffColorFilter x0;
    public ColorStateList y0;
    public ColorStateList z;
    public PorterDuff.Mode z0 = PorterDuff.Mode.SRC_IN;

    public interface a {
        void a();
    }

    public b(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(j.b(context, attributeSet, i2, i3).a());
        this.b.b = new f.b.a.d.n.a(context);
        y();
        this.g0 = context;
        i iVar = new i(this);
        this.m0 = iVar;
        this.G = "";
        iVar.a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = I0;
        setState(iArr);
        f0(iArr);
        this.F0 = true;
        int[] iArr2 = f.b.a.d.t.a.a;
        J0.setTint(-1);
    }

    public static boolean I(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean J(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(Rect rect, RectF rectF) {
        float f2;
        rectF.setEmpty();
        if (q0() || p0()) {
            float f3 = this.Y + this.Z;
            float H2 = H();
            if (m.h.i0(this) == 0) {
                float f4 = ((float) rect.left) + f3;
                rectF.left = f4;
                rectF.right = f4 + H2;
            } else {
                float f5 = ((float) rect.right) - f3;
                rectF.right = f5;
                rectF.left = f5 - H2;
            }
            Drawable drawable = this.t0 ? this.U : this.I;
            float f6 = this.K;
            if (f6 <= 0.0f && drawable != null) {
                f6 = (float) Math.ceil((double) f.b.a.c.b.o.b.r0(this.g0, 24));
                if (((float) drawable.getIntrinsicHeight()) <= f6) {
                    f2 = (float) drawable.getIntrinsicHeight();
                    float exactCenterY = rect.exactCenterY() - (f2 / 2.0f);
                    rectF.top = exactCenterY;
                    rectF.bottom = exactCenterY + f2;
                }
            }
            f2 = f6;
            float exactCenterY2 = rect.exactCenterY() - (f2 / 2.0f);
            rectF.top = exactCenterY2;
            rectF.bottom = exactCenterY2 + f2;
        }
    }

    public float B() {
        if (!q0() && !p0()) {
            return 0.0f;
        }
        return H() + this.Z + this.a0;
    }

    public final void C(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (r0()) {
            float f2 = this.f0 + this.e0;
            if (m.h.i0(this) == 0) {
                float f3 = ((float) rect.right) - f2;
                rectF.right = f3;
                rectF.left = f3 - this.Q;
            } else {
                float f4 = ((float) rect.left) + f2;
                rectF.left = f4;
                rectF.right = f4 + this.Q;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.Q;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    public final void D(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (r0()) {
            float f2 = this.f0 + this.e0 + this.Q + this.d0 + this.c0;
            if (m.h.i0(this) == 0) {
                float f3 = (float) rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = (float) i2;
                rectF.right = ((float) i2) + f2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    public float E() {
        if (r0()) {
            return this.d0 + this.Q + this.e0;
        }
        return 0.0f;
    }

    public float F() {
        return this.H0 ? l() : this.C;
    }

    public Drawable G() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return m.h.s1(drawable);
        }
        return null;
    }

    public final float H() {
        Drawable drawable = this.t0 ? this.U : this.I;
        float f2 = this.K;
        return (f2 > 0.0f || drawable == null) ? f2 : (float) drawable.getIntrinsicWidth();
    }

    public void K() {
        a aVar = this.D0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0145  */
    public final boolean L(int[] iArr, int[] iArr2) {
        boolean z2;
        boolean z3;
        boolean z4;
        int colorForState;
        float B2;
        ColorStateList colorStateList;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.z;
        int colorForState2 = colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.n0) : 0;
        boolean z5 = true;
        if (this.n0 != colorForState2) {
            this.n0 = colorForState2;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.A;
        int colorForState3 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.o0) : 0;
        if (this.o0 != colorForState3) {
            this.o0 = colorForState3;
            onStateChange = true;
        }
        int a2 = e.i.c.a.a(colorForState3, colorForState2);
        if ((this.p0 != a2) || (this.b.f2770d == null)) {
            this.p0 = a2;
            q(ColorStateList.valueOf(a2));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.D;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.q0) : 0;
        if (this.q0 != colorForState4) {
            this.q0 = colorForState4;
            onStateChange = true;
        }
        int colorForState5 = (this.C0 == null || !f.b.a.d.t.a.c(iArr)) ? 0 : this.C0.getColorForState(iArr, this.r0);
        if (this.r0 != colorForState5) {
            this.r0 = colorForState5;
            if (this.B0) {
                onStateChange = true;
            }
        }
        f.b.a.d.s.b bVar = this.m0.f2693f;
        int colorForState6 = (bVar == null || (colorStateList = bVar.a) == null) ? 0 : colorStateList.getColorForState(iArr, this.s0);
        if (this.s0 != colorForState6) {
            this.s0 = colorForState6;
            onStateChange = true;
        }
        int[] state = getState();
        if (state != null) {
            int length = state.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (state[i2] == 16842912) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            z3 = !z2 && this.S;
            if (!(this.t0 == z3 || this.U == null)) {
                B2 = B();
                this.t0 = z3;
                if (B2 == B()) {
                    onStateChange = true;
                    z4 = true;
                    ColorStateList colorStateList5 = this.y0;
                    colorForState = colorStateList5 == null ? colorStateList5.getColorForState(iArr, this.u0) : 0;
                    if (this.u0 == colorForState) {
                        this.u0 = colorForState;
                        this.x0 = f.b.a.c.b.o.b.W1(this, this.y0, this.z0);
                    } else {
                        z5 = onStateChange;
                    }
                    if (J(this.I)) {
                        z5 |= this.I.setState(iArr);
                    }
                    if (J(this.U)) {
                        z5 |= this.U.setState(iArr);
                    }
                    if (J(this.N)) {
                        int[] iArr3 = new int[(iArr.length + iArr2.length)];
                        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                        z5 |= this.N.setState(iArr3);
                    }
                    int[] iArr4 = f.b.a.d.t.a.a;
                    if (J(this.O)) {
                        z5 |= this.O.setState(iArr2);
                    }
                    if (z5) {
                        invalidateSelf();
                    }
                    if (z4) {
                        K();
                    }
                    return z5;
                }
                onStateChange = true;
            }
            z4 = false;
            ColorStateList colorStateList52 = this.y0;
            if (colorStateList52 == null) {
            }
            if (this.u0 == colorForState) {
            }
            if (J(this.I)) {
            }
            if (J(this.U)) {
            }
            if (J(this.N)) {
            }
            int[] iArr42 = f.b.a.d.t.a.a;
            if (J(this.O)) {
            }
            if (z5) {
            }
            if (z4) {
            }
            return z5;
        }
        z2 = false;
        if (!z2) {
        }
        B2 = B();
        this.t0 = z3;
        if (B2 == B()) {
        }
    }

    public void M(boolean z2) {
        if (this.S != z2) {
            this.S = z2;
            float B2 = B();
            if (!z2 && this.t0) {
                this.t0 = false;
            }
            float B3 = B();
            invalidateSelf();
            if (B2 != B3) {
                K();
            }
        }
    }

    public void N(Drawable drawable) {
        if (this.U != drawable) {
            float B2 = B();
            this.U = drawable;
            float B3 = B();
            s0(this.U);
            z(this.U);
            invalidateSelf();
            if (B2 != B3) {
                K();
            }
        }
    }

    public void O(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (this.T && this.U != null && this.S) {
                this.U.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void P(boolean z2) {
        if (this.T != z2) {
            boolean p02 = p0();
            this.T = z2;
            boolean p03 = p0();
            if (p02 != p03) {
                if (p03) {
                    z(this.U);
                } else {
                    s0(this.U);
                }
                invalidateSelf();
                K();
            }
        }
    }

    public void Q(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    @Deprecated
    public void R(float f2) {
        if (this.C != f2) {
            this.C = f2;
            this.b.a = this.b.a.e(f2);
            invalidateSelf();
        }
    }

    public void S(float f2) {
        if (this.f0 != f2) {
            this.f0 = f2;
            invalidateSelf();
            K();
        }
    }

    public void T(Drawable drawable) {
        Drawable drawable2 = this.I;
        Drawable drawable3 = null;
        Drawable s1 = drawable2 != null ? m.h.s1(drawable2) : null;
        if (s1 != drawable) {
            float B2 = B();
            if (drawable != null) {
                drawable3 = m.h.v1(drawable).mutate();
            }
            this.I = drawable3;
            float B3 = B();
            s0(s1);
            if (q0()) {
                z(this.I);
            }
            invalidateSelf();
            if (B2 != B3) {
                K();
            }
        }
    }

    public void U(float f2) {
        if (this.K != f2) {
            float B2 = B();
            this.K = f2;
            float B3 = B();
            invalidateSelf();
            if (B2 != B3) {
                K();
            }
        }
    }

    public void V(ColorStateList colorStateList) {
        this.L = true;
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (q0()) {
                this.I.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void W(boolean z2) {
        if (this.H != z2) {
            boolean q02 = q0();
            this.H = z2;
            boolean q03 = q0();
            if (q02 != q03) {
                if (q03) {
                    z(this.I);
                } else {
                    s0(this.I);
                }
                invalidateSelf();
                K();
            }
        }
    }

    public void X(float f2) {
        if (this.B != f2) {
            this.B = f2;
            invalidateSelf();
            K();
        }
    }

    public void Y(float f2) {
        if (this.Y != f2) {
            this.Y = f2;
            invalidateSelf();
            K();
        }
    }

    public void Z(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.H0) {
                v(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // f.b.a.d.q.i.b
    public void a() {
        K();
        invalidateSelf();
    }

    public void a0(float f2) {
        if (this.E != f2) {
            this.E = f2;
            this.h0.setStrokeWidth(f2);
            if (this.H0) {
                this.b.f2778l = f2;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void b0(Drawable drawable) {
        Drawable G2 = G();
        if (G2 != drawable) {
            float E2 = E();
            this.N = drawable != null ? m.h.v1(drawable).mutate() : null;
            int[] iArr = f.b.a.d.t.a.a;
            this.O = new RippleDrawable(f.b.a.d.t.a.b(this.F), this.N, J0);
            float E3 = E();
            s0(G2);
            if (r0()) {
                z(this.N);
            }
            invalidateSelf();
            if (E2 != E3) {
                K();
            }
        }
    }

    public void c0(float f2) {
        if (this.e0 != f2) {
            this.e0 = f2;
            invalidateSelf();
            if (r0()) {
                K();
            }
        }
    }

    public void d0(float f2) {
        if (this.Q != f2) {
            this.Q = f2;
            invalidateSelf();
            if (r0()) {
                K();
            }
        }
    }

    @Override // f.b.a.d.v.g
    public void draw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f2;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && (i2 = this.v0) != 0) {
            if (i2 < 255) {
                float f3 = (float) bounds.left;
                float f4 = (float) bounds.top;
                float f5 = (float) bounds.right;
                float f6 = (float) bounds.bottom;
                i3 = Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f3, f4, f5, f6, i2) : canvas.saveLayerAlpha(f3, f4, f5, f6, i2, 31);
            } else {
                i3 = 0;
            }
            if (!this.H0) {
                this.h0.setColor(this.n0);
                this.h0.setStyle(Paint.Style.FILL);
                this.j0.set(bounds);
                canvas.drawRoundRect(this.j0, F(), F(), this.h0);
            }
            if (!this.H0) {
                this.h0.setColor(this.o0);
                this.h0.setStyle(Paint.Style.FILL);
                Paint paint = this.h0;
                ColorFilter colorFilter = this.w0;
                if (colorFilter == null) {
                    colorFilter = this.x0;
                }
                paint.setColorFilter(colorFilter);
                this.j0.set(bounds);
                canvas.drawRoundRect(this.j0, F(), F(), this.h0);
            }
            if (this.H0) {
                super.draw(canvas);
            }
            if (this.E > 0.0f && !this.H0) {
                this.h0.setColor(this.q0);
                this.h0.setStyle(Paint.Style.STROKE);
                if (!this.H0) {
                    Paint paint2 = this.h0;
                    ColorFilter colorFilter2 = this.w0;
                    if (colorFilter2 == null) {
                        colorFilter2 = this.x0;
                    }
                    paint2.setColorFilter(colorFilter2);
                }
                RectF rectF = this.j0;
                float f7 = this.E / 2.0f;
                rectF.set(((float) bounds.left) + f7, ((float) bounds.top) + f7, ((float) bounds.right) - f7, ((float) bounds.bottom) - f7);
                float f8 = this.C - (this.E / 2.0f);
                canvas.drawRoundRect(this.j0, f8, f8, this.h0);
            }
            this.h0.setColor(this.r0);
            this.h0.setStyle(Paint.Style.FILL);
            this.j0.set(bounds);
            if (!this.H0) {
                canvas.drawRoundRect(this.j0, F(), F(), this.h0);
                i4 = 0;
            } else {
                c(new RectF(bounds), this.l0);
                i4 = 0;
                g(canvas, this.h0, this.l0, this.b.a, h());
            }
            if (q0()) {
                A(bounds, this.j0);
                RectF rectF2 = this.j0;
                float f9 = rectF2.left;
                float f10 = rectF2.top;
                canvas.translate(f9, f10);
                this.I.setBounds(i4, i4, (int) this.j0.width(), (int) this.j0.height());
                this.I.draw(canvas);
                canvas.translate(-f9, -f10);
            }
            if (p0()) {
                A(bounds, this.j0);
                RectF rectF3 = this.j0;
                float f11 = rectF3.left;
                float f12 = rectF3.top;
                canvas.translate(f11, f12);
                this.U.setBounds(i4, i4, (int) this.j0.width(), (int) this.j0.height());
                this.U.draw(canvas);
                canvas.translate(-f11, -f12);
            }
            if (!this.F0 || this.G == null) {
                i7 = i3;
                i6 = 255;
                i5 = 0;
            } else {
                PointF pointF = this.k0;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                if (this.G != null) {
                    float B2 = B() + this.Y + this.b0;
                    if (m.h.i0(this) == 0) {
                        pointF.x = ((float) bounds.left) + B2;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = ((float) bounds.right) - B2;
                        align = Paint.Align.RIGHT;
                    }
                    this.m0.a.getFontMetrics(this.i0);
                    Paint.FontMetrics fontMetrics = this.i0;
                    pointF.y = ((float) bounds.centerY()) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
                }
                RectF rectF4 = this.j0;
                rectF4.setEmpty();
                if (this.G != null) {
                    float B3 = B() + this.Y + this.b0;
                    float E2 = E() + this.f0 + this.c0;
                    if (m.h.i0(this) == 0) {
                        rectF4.left = ((float) bounds.left) + B3;
                        f2 = ((float) bounds.right) - E2;
                    } else {
                        rectF4.left = ((float) bounds.left) + E2;
                        f2 = ((float) bounds.right) - B3;
                    }
                    rectF4.right = f2;
                    rectF4.top = (float) bounds.top;
                    rectF4.bottom = (float) bounds.bottom;
                }
                i iVar = this.m0;
                if (iVar.f2693f != null) {
                    iVar.a.drawableState = getState();
                    i iVar2 = this.m0;
                    iVar2.f2693f.c(this.g0, iVar2.a, iVar2.b);
                }
                this.m0.a.setTextAlign(align);
                boolean z2 = Math.round(this.m0.a(this.G.toString())) > Math.round(this.j0.width());
                if (z2) {
                    i8 = canvas.save();
                    canvas.clipRect(this.j0);
                } else {
                    i8 = 0;
                }
                CharSequence charSequence = this.G;
                if (z2 && this.E0 != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.m0.a, this.j0.width(), this.E0);
                }
                int length = charSequence.length();
                PointF pointF2 = this.k0;
                i5 = 0;
                i6 = 255;
                i7 = i3;
                canvas.drawText(charSequence, 0, length, pointF2.x, pointF2.y, this.m0.a);
                if (z2) {
                    canvas.restoreToCount(i8);
                }
            }
            if (r0()) {
                C(bounds, this.j0);
                RectF rectF5 = this.j0;
                float f13 = rectF5.left;
                float f14 = rectF5.top;
                canvas.translate(f13, f14);
                this.N.setBounds(i5, i5, (int) this.j0.width(), (int) this.j0.height());
                int[] iArr = f.b.a.d.t.a.a;
                this.O.setBounds(this.N.getBounds());
                this.O.jumpToCurrentState();
                this.O.draw(canvas);
                canvas.translate(-f13, -f14);
            }
            if (this.v0 < i6) {
                canvas.restoreToCount(i7);
            }
        }
    }

    public void e0(float f2) {
        if (this.d0 != f2) {
            this.d0 = f2;
            invalidateSelf();
            if (r0()) {
                K();
            }
        }
    }

    public boolean f0(int[] iArr) {
        if (Arrays.equals(this.A0, iArr)) {
            return false;
        }
        this.A0 = iArr;
        if (r0()) {
            return L(getState(), iArr);
        }
        return false;
    }

    public void g0(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (r0()) {
                this.N.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public int getAlpha() {
        return this.v0;
    }

    public ColorFilter getColorFilter() {
        return this.w0;
    }

    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(E() + this.m0.a(this.G.toString()) + B() + this.Y + this.b0 + this.c0 + this.f0), this.G0);
    }

    @Override // f.b.a.d.v.g
    public int getOpacity() {
        return -3;
    }

    @Override // f.b.a.d.v.g
    public void getOutline(Outline outline) {
        if (this.H0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.C);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.B, this.C);
        }
        outline.setAlpha(((float) this.v0) / 255.0f);
    }

    public void h0(boolean z2) {
        if (this.M != z2) {
            boolean r02 = r0();
            this.M = z2;
            boolean r03 = r0();
            if (r02 != r03) {
                if (r03) {
                    z(this.N);
                } else {
                    s0(this.N);
                }
                invalidateSelf();
                K();
            }
        }
    }

    public void i0(float f2) {
        if (this.a0 != f2) {
            float B2 = B();
            this.a0 = f2;
            float B3 = B();
            invalidateSelf();
            if (B2 != B3) {
                K();
            }
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // f.b.a.d.v.g
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (I(this.z) || I(this.A) || I(this.D)) {
            return true;
        }
        if (this.B0 && I(this.C0)) {
            return true;
        }
        f.b.a.d.s.b bVar = this.m0.f2693f;
        if ((bVar == null || (colorStateList = bVar.a) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        if ((this.T && this.U != null && this.S) || J(this.I) || J(this.U) || I(this.y0)) {
            return true;
        }
        return false;
    }

    public void j0(float f2) {
        if (this.Z != f2) {
            float B2 = B();
            this.Z = f2;
            float B3 = B();
            invalidateSelf();
            if (B2 != B3) {
                K();
            }
        }
    }

    public void k0(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            this.C0 = this.B0 ? f.b.a.d.t.a.b(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public void l0(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.m0.f2691d = true;
            invalidateSelf();
            K();
        }
    }

    public void m0(float f2) {
        if (this.c0 != f2) {
            this.c0 = f2;
            invalidateSelf();
            K();
        }
    }

    public void n0(float f2) {
        if (this.b0 != f2) {
            this.b0 = f2;
            invalidateSelf();
            K();
        }
    }

    public void o0(boolean z2) {
        if (this.B0 != z2) {
            this.B0 = z2;
            this.C0 = z2 ? f.b.a.d.t.a.b(this.F) : null;
            onStateChange(getState());
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (q0()) {
            onLayoutDirectionChanged |= m.h.Y0(this.I, i2);
        }
        if (p0()) {
            onLayoutDirectionChanged |= m.h.Y0(this.U, i2);
        }
        if (r0()) {
            onLayoutDirectionChanged |= m.h.Y0(this.N, i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    public boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (q0()) {
            onLevelChange |= this.I.setLevel(i2);
        }
        if (p0()) {
            onLevelChange |= this.U.setLevel(i2);
        }
        if (r0()) {
            onLevelChange |= this.N.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // f.b.a.d.v.g, f.b.a.d.q.i.b
    public boolean onStateChange(int[] iArr) {
        if (this.H0) {
            super.onStateChange(iArr);
        }
        return L(iArr, this.A0);
    }

    public final boolean p0() {
        return this.T && this.U != null && this.t0;
    }

    public final boolean q0() {
        return this.H && this.I != null;
    }

    public final boolean r0() {
        return this.M && this.N != null;
    }

    public final void s0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // f.b.a.d.v.g
    public void setAlpha(int i2) {
        if (this.v0 != i2) {
            this.v0 = i2;
            invalidateSelf();
        }
    }

    @Override // f.b.a.d.v.g
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.w0 != colorFilter) {
            this.w0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // f.b.a.d.v.g
    public void setTintList(ColorStateList colorStateList) {
        if (this.y0 != colorStateList) {
            this.y0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // f.b.a.d.v.g
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.z0 != mode) {
            this.z0 = mode;
            this.x0 = f.b.a.c.b.o.b.W1(this, this.y0, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (q0()) {
            visible |= this.I.setVisible(z2, z3);
        }
        if (p0()) {
            visible |= this.U.setVisible(z2, z3);
        }
        if (r0()) {
            visible |= this.N.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void z(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            m.h.Y0(drawable, m.h.i0(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.N) {
                if (drawable.isStateful()) {
                    drawable.setState(this.A0);
                }
                drawable.setTintList(this.P);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.I;
            if (drawable == drawable2 && this.L) {
                drawable2.setTintList(this.J);
            }
        }
    }
}
