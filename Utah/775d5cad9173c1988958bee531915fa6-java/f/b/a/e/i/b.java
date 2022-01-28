package f.b.a.e.i;

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
import android.util.TypedValue;
import e.b.a.m;
import f.b.a.e.q.i;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class b extends g implements e.i.c.m.a, Drawable.Callback, i.b {
    public static final int[] J0 = {16842910};
    public static final ShapeDrawable K0 = new ShapeDrawable(new OvalShape());
    public ColorStateList A;
    public PorterDuff.Mode A0 = PorterDuff.Mode.SRC_IN;
    public ColorStateList B;
    public int[] B0;
    public float C;
    public boolean C0;
    public float D = -1.0f;
    public ColorStateList D0;
    public ColorStateList E;
    public WeakReference<a> E0 = new WeakReference<>(null);
    public float F;
    public TextUtils.TruncateAt F0;
    public ColorStateList G;
    public boolean G0;
    public CharSequence H;
    public int H0;
    public boolean I;
    public boolean I0;
    public Drawable J;
    public ColorStateList K;
    public float L;
    public boolean M;
    public boolean N;
    public Drawable O;
    public Drawable P;
    public ColorStateList Q;
    public float R;
    public CharSequence S;
    public boolean T;
    public boolean U;
    public Drawable V;
    public ColorStateList W;
    public f.b.a.e.a.g X;
    public f.b.a.e.a.g Y;
    public float Z;
    public float a0;
    public float b0;
    public float c0;
    public float d0;
    public float e0;
    public float f0;
    public float g0;
    public final Context h0;
    public final Paint i0 = new Paint(1);
    public final Paint.FontMetrics j0 = new Paint.FontMetrics();
    public final RectF k0 = new RectF();
    public final PointF l0 = new PointF();
    public final Path m0 = new Path();
    public final i n0;
    public int o0;
    public int p0;
    public int q0;
    public int r0;
    public int s0;
    public int t0;
    public boolean u0;
    public int v0;
    public int w0 = 255;
    public ColorFilter x0;
    public PorterDuffColorFilter y0;
    public ColorStateList z0;

    public interface a {
        void a();
    }

    public b(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(j.b(context, attributeSet, i2, i3).a());
        this.b.b = new f.b.a.e.n.a(context);
        y();
        this.h0 = context;
        i iVar = new i(this);
        this.n0 = iVar;
        this.H = "";
        iVar.a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = J0;
        setState(iArr);
        f0(iArr);
        this.G0 = true;
        int[] iArr2 = f.b.a.e.t.b.a;
        K0.setTint(-1);
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
        if (r0() || q0()) {
            float f3 = this.Z + this.a0;
            float H2 = H();
            if (m.e.o0(this) == 0) {
                float f4 = ((float) rect.left) + f3;
                rectF.left = f4;
                rectF.right = f4 + H2;
            } else {
                float f5 = ((float) rect.right) - f3;
                rectF.right = f5;
                rectF.left = f5 - H2;
            }
            Drawable drawable = this.u0 ? this.V : this.J;
            float f6 = this.L;
            if (f6 <= 0.0f && drawable != null) {
                f6 = (float) Math.ceil((double) TypedValue.applyDimension(1, (float) 24, this.h0.getResources().getDisplayMetrics()));
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
        if (!r0() && !q0()) {
            return 0.0f;
        }
        return H() + this.a0 + this.b0;
    }

    public final void C(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (s0()) {
            float f2 = this.g0 + this.f0;
            if (m.e.o0(this) == 0) {
                float f3 = ((float) rect.right) - f2;
                rectF.right = f3;
                rectF.left = f3 - this.R;
            } else {
                float f4 = ((float) rect.left) + f2;
                rectF.left = f4;
                rectF.right = f4 + this.R;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.R;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    public final void D(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (s0()) {
            float f2 = this.g0 + this.f0 + this.R + this.e0 + this.d0;
            if (m.e.o0(this) == 0) {
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
        if (s0()) {
            return this.e0 + this.R + this.f0;
        }
        return 0.0f;
    }

    public float F() {
        return this.I0 ? l() : this.D;
    }

    public Drawable G() {
        Drawable drawable = this.O;
        if (drawable != null) {
            return m.e.L1(drawable);
        }
        return null;
    }

    public final float H() {
        Drawable drawable = this.u0 ? this.V : this.J;
        float f2 = this.L;
        return (f2 > 0.0f || drawable == null) ? f2 : (float) drawable.getIntrinsicWidth();
    }

    public void K() {
        a aVar = this.E0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x014d  */
    public final boolean L(int[] iArr, int[] iArr2) {
        boolean z;
        boolean z2;
        int colorForState;
        ColorStateList colorStateList;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.A;
        int e2 = e(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.o0) : 0);
        boolean z3 = true;
        if (this.o0 != e2) {
            this.o0 = e2;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.B;
        int e3 = e(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.p0) : 0);
        if (this.p0 != e3) {
            this.p0 = e3;
            onStateChange = true;
        }
        int a2 = e.i.c.a.a(e3, e2);
        if ((this.q0 != a2) || (this.b.f3035d == null)) {
            this.q0 = a2;
            q(ColorStateList.valueOf(a2));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.E;
        int colorForState2 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.r0) : 0;
        if (this.r0 != colorForState2) {
            this.r0 = colorForState2;
            onStateChange = true;
        }
        int colorForState3 = (this.D0 == null || !f.b.a.e.t.b.b(iArr)) ? 0 : this.D0.getColorForState(iArr, this.s0);
        if (this.s0 != colorForState3) {
            this.s0 = colorForState3;
            if (this.C0) {
                onStateChange = true;
            }
        }
        f.b.a.e.s.b bVar = this.n0.f2970f;
        int colorForState4 = (bVar == null || (colorStateList = bVar.f3014j) == null) ? 0 : colorStateList.getColorForState(iArr, this.t0);
        if (this.t0 != colorForState4) {
            this.t0 = colorForState4;
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
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        z = false;
        boolean z4 = z && this.T;
        if (!(this.u0 == z4 || this.V == null)) {
            float B2 = B();
            this.u0 = z4;
            if (B2 != B()) {
                onStateChange = true;
                z2 = true;
                ColorStateList colorStateList5 = this.z0;
                colorForState = colorStateList5 == null ? colorStateList5.getColorForState(iArr, this.v0) : 0;
                if (this.v0 == colorForState) {
                    this.v0 = colorForState;
                    this.y0 = f.b.a.c.b.o.b.v1(this, this.z0, this.A0);
                } else {
                    z3 = onStateChange;
                }
                if (J(this.J)) {
                    z3 |= this.J.setState(iArr);
                }
                if (J(this.V)) {
                    z3 |= this.V.setState(iArr);
                }
                if (J(this.O)) {
                    int[] iArr3 = new int[(iArr.length + iArr2.length)];
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                    z3 |= this.O.setState(iArr3);
                }
                int[] iArr4 = f.b.a.e.t.b.a;
                if (J(this.P)) {
                    z3 |= this.P.setState(iArr2);
                }
                if (z3) {
                    invalidateSelf();
                }
                if (z2) {
                    K();
                }
                return z3;
            }
            onStateChange = true;
        }
        z2 = false;
        ColorStateList colorStateList52 = this.z0;
        if (colorStateList52 == null) {
        }
        if (this.v0 == colorForState) {
        }
        if (J(this.J)) {
        }
        if (J(this.V)) {
        }
        if (J(this.O)) {
        }
        int[] iArr42 = f.b.a.e.t.b.a;
        if (J(this.P)) {
        }
        if (z3) {
        }
        if (z2) {
        }
        return z3;
    }

    public void M(boolean z) {
        if (this.T != z) {
            this.T = z;
            float B2 = B();
            if (!z && this.u0) {
                this.u0 = false;
            }
            float B3 = B();
            invalidateSelf();
            if (B2 != B3) {
                K();
            }
        }
    }

    public void N(Drawable drawable) {
        if (this.V != drawable) {
            float B2 = B();
            this.V = drawable;
            float B3 = B();
            t0(this.V);
            z(this.V);
            invalidateSelf();
            if (B2 != B3) {
                K();
            }
        }
    }

    public void O(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            if (this.U && this.V != null && this.T) {
                this.V.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void P(boolean z) {
        if (this.U != z) {
            boolean q02 = q0();
            this.U = z;
            boolean q03 = q0();
            if (q02 != q03) {
                if (q03) {
                    z(this.V);
                } else {
                    t0(this.V);
                }
                invalidateSelf();
                K();
            }
        }
    }

    public void Q(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            onStateChange(getState());
        }
    }

    @Deprecated
    public void R(float f2) {
        if (this.D != f2) {
            this.D = f2;
            this.b.a = this.b.a.e(f2);
            invalidateSelf();
        }
    }

    public void S(float f2) {
        if (this.g0 != f2) {
            this.g0 = f2;
            invalidateSelf();
            K();
        }
    }

    public void T(Drawable drawable) {
        Drawable drawable2 = this.J;
        Drawable drawable3 = null;
        Drawable L1 = drawable2 != null ? m.e.L1(drawable2) : null;
        if (L1 != drawable) {
            float B2 = B();
            if (drawable != null) {
                drawable3 = m.e.P1(drawable).mutate();
            }
            this.J = drawable3;
            float B3 = B();
            t0(L1);
            if (r0()) {
                z(this.J);
            }
            invalidateSelf();
            if (B2 != B3) {
                K();
            }
        }
    }

    public void U(float f2) {
        if (this.L != f2) {
            float B2 = B();
            this.L = f2;
            float B3 = B();
            invalidateSelf();
            if (B2 != B3) {
                K();
            }
        }
    }

    public void V(ColorStateList colorStateList) {
        this.M = true;
        if (this.K != colorStateList) {
            this.K = colorStateList;
            if (r0()) {
                this.J.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void W(boolean z) {
        if (this.I != z) {
            boolean r02 = r0();
            this.I = z;
            boolean r03 = r0();
            if (r02 != r03) {
                if (r03) {
                    z(this.J);
                } else {
                    t0(this.J);
                }
                invalidateSelf();
                K();
            }
        }
    }

    public void X(float f2) {
        if (this.C != f2) {
            this.C = f2;
            invalidateSelf();
            K();
        }
    }

    public void Y(float f2) {
        if (this.Z != f2) {
            this.Z = f2;
            invalidateSelf();
            K();
        }
    }

    public void Z(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            if (this.I0) {
                v(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // f.b.a.e.q.i.b
    public void a() {
        K();
        invalidateSelf();
    }

    public void a0(float f2) {
        if (this.F != f2) {
            this.F = f2;
            this.i0.setStrokeWidth(f2);
            if (this.I0) {
                this.b.f3043l = f2;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void b0(Drawable drawable) {
        Drawable G2 = G();
        if (G2 != drawable) {
            float E2 = E();
            this.O = drawable != null ? m.e.P1(drawable).mutate() : null;
            int[] iArr = f.b.a.e.t.b.a;
            this.P = new RippleDrawable(f.b.a.e.t.b.a(this.G), this.O, K0);
            float E3 = E();
            t0(G2);
            if (s0()) {
                z(this.O);
            }
            invalidateSelf();
            if (E2 != E3) {
                K();
            }
        }
    }

    public void c0(float f2) {
        if (this.f0 != f2) {
            this.f0 = f2;
            invalidateSelf();
            if (s0()) {
                K();
            }
        }
    }

    public void d0(float f2) {
        if (this.R != f2) {
            this.R = f2;
            invalidateSelf();
            if (s0()) {
                K();
            }
        }
    }

    @Override // f.b.a.e.v.g
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
        if (!bounds.isEmpty() && (i2 = this.w0) != 0) {
            if (i2 < 255) {
                float f3 = (float) bounds.left;
                float f4 = (float) bounds.top;
                float f5 = (float) bounds.right;
                float f6 = (float) bounds.bottom;
                i3 = Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f3, f4, f5, f6, i2) : canvas.saveLayerAlpha(f3, f4, f5, f6, i2, 31);
            } else {
                i3 = 0;
            }
            if (!this.I0) {
                this.i0.setColor(this.o0);
                this.i0.setStyle(Paint.Style.FILL);
                this.k0.set(bounds);
                canvas.drawRoundRect(this.k0, F(), F(), this.i0);
            }
            if (!this.I0) {
                this.i0.setColor(this.p0);
                this.i0.setStyle(Paint.Style.FILL);
                Paint paint = this.i0;
                ColorFilter colorFilter = this.x0;
                if (colorFilter == null) {
                    colorFilter = this.y0;
                }
                paint.setColorFilter(colorFilter);
                this.k0.set(bounds);
                canvas.drawRoundRect(this.k0, F(), F(), this.i0);
            }
            if (this.I0) {
                super.draw(canvas);
            }
            if (this.F > 0.0f && !this.I0) {
                this.i0.setColor(this.r0);
                this.i0.setStyle(Paint.Style.STROKE);
                if (!this.I0) {
                    Paint paint2 = this.i0;
                    ColorFilter colorFilter2 = this.x0;
                    if (colorFilter2 == null) {
                        colorFilter2 = this.y0;
                    }
                    paint2.setColorFilter(colorFilter2);
                }
                RectF rectF = this.k0;
                float f7 = this.F / 2.0f;
                rectF.set(((float) bounds.left) + f7, ((float) bounds.top) + f7, ((float) bounds.right) - f7, ((float) bounds.bottom) - f7);
                float f8 = this.D - (this.F / 2.0f);
                canvas.drawRoundRect(this.k0, f8, f8, this.i0);
            }
            this.i0.setColor(this.s0);
            this.i0.setStyle(Paint.Style.FILL);
            this.k0.set(bounds);
            if (!this.I0) {
                canvas.drawRoundRect(this.k0, F(), F(), this.i0);
                i4 = 0;
            } else {
                c(new RectF(bounds), this.m0);
                i4 = 0;
                g(canvas, this.i0, this.m0, this.b.a, h());
            }
            if (r0()) {
                A(bounds, this.k0);
                RectF rectF2 = this.k0;
                float f9 = rectF2.left;
                float f10 = rectF2.top;
                canvas.translate(f9, f10);
                this.J.setBounds(i4, i4, (int) this.k0.width(), (int) this.k0.height());
                this.J.draw(canvas);
                canvas.translate(-f9, -f10);
            }
            if (q0()) {
                A(bounds, this.k0);
                RectF rectF3 = this.k0;
                float f11 = rectF3.left;
                float f12 = rectF3.top;
                canvas.translate(f11, f12);
                this.V.setBounds(i4, i4, (int) this.k0.width(), (int) this.k0.height());
                this.V.draw(canvas);
                canvas.translate(-f11, -f12);
            }
            if (!this.G0 || this.H == null) {
                i7 = i3;
                i6 = 255;
                i5 = 0;
            } else {
                PointF pointF = this.l0;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                if (this.H != null) {
                    float B2 = B() + this.Z + this.c0;
                    if (m.e.o0(this) == 0) {
                        pointF.x = ((float) bounds.left) + B2;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = ((float) bounds.right) - B2;
                        align = Paint.Align.RIGHT;
                    }
                    this.n0.a.getFontMetrics(this.j0);
                    Paint.FontMetrics fontMetrics = this.j0;
                    pointF.y = ((float) bounds.centerY()) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
                }
                RectF rectF4 = this.k0;
                rectF4.setEmpty();
                if (this.H != null) {
                    float B3 = B() + this.Z + this.c0;
                    float E2 = E() + this.g0 + this.d0;
                    if (m.e.o0(this) == 0) {
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
                i iVar = this.n0;
                if (iVar.f2970f != null) {
                    iVar.a.drawableState = getState();
                    i iVar2 = this.n0;
                    iVar2.f2970f.e(this.h0, iVar2.a, iVar2.b);
                }
                this.n0.a.setTextAlign(align);
                boolean z = Math.round(this.n0.a(this.H.toString())) > Math.round(this.k0.width());
                if (z) {
                    i8 = canvas.save();
                    canvas.clipRect(this.k0);
                } else {
                    i8 = 0;
                }
                CharSequence charSequence = this.H;
                if (z && this.F0 != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.n0.a, this.k0.width(), this.F0);
                }
                int length = charSequence.length();
                PointF pointF2 = this.l0;
                i5 = 0;
                i6 = 255;
                i7 = i3;
                canvas.drawText(charSequence, 0, length, pointF2.x, pointF2.y, this.n0.a);
                if (z) {
                    canvas.restoreToCount(i8);
                }
            }
            if (s0()) {
                C(bounds, this.k0);
                RectF rectF5 = this.k0;
                float f13 = rectF5.left;
                float f14 = rectF5.top;
                canvas.translate(f13, f14);
                this.O.setBounds(i5, i5, (int) this.k0.width(), (int) this.k0.height());
                int[] iArr = f.b.a.e.t.b.a;
                this.P.setBounds(this.O.getBounds());
                this.P.jumpToCurrentState();
                this.P.draw(canvas);
                canvas.translate(-f13, -f14);
            }
            if (this.w0 < i6) {
                canvas.restoreToCount(i7);
            }
        }
    }

    public void e0(float f2) {
        if (this.e0 != f2) {
            this.e0 = f2;
            invalidateSelf();
            if (s0()) {
                K();
            }
        }
    }

    public boolean f0(int[] iArr) {
        if (Arrays.equals(this.B0, iArr)) {
            return false;
        }
        this.B0 = iArr;
        if (s0()) {
            return L(getState(), iArr);
        }
        return false;
    }

    public void g0(ColorStateList colorStateList) {
        if (this.Q != colorStateList) {
            this.Q = colorStateList;
            if (s0()) {
                this.O.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public int getAlpha() {
        return this.w0;
    }

    public ColorFilter getColorFilter() {
        return this.x0;
    }

    public int getIntrinsicHeight() {
        return (int) this.C;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(E() + this.n0.a(this.H.toString()) + B() + this.Z + this.c0 + this.d0 + this.g0), this.H0);
    }

    @Override // f.b.a.e.v.g
    public int getOpacity() {
        return -3;
    }

    @Override // f.b.a.e.v.g
    public void getOutline(Outline outline) {
        if (this.I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.D);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.C, this.D);
        }
        outline.setAlpha(((float) this.w0) / 255.0f);
    }

    public void h0(boolean z) {
        if (this.N != z) {
            boolean s02 = s0();
            this.N = z;
            boolean s03 = s0();
            if (s02 != s03) {
                if (s03) {
                    z(this.O);
                } else {
                    t0(this.O);
                }
                invalidateSelf();
                K();
            }
        }
    }

    public void i0(float f2) {
        if (this.b0 != f2) {
            float B2 = B();
            this.b0 = f2;
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

    @Override // f.b.a.e.v.g
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (I(this.A) || I(this.B) || I(this.E)) {
            return true;
        }
        if (this.C0 && I(this.D0)) {
            return true;
        }
        f.b.a.e.s.b bVar = this.n0.f2970f;
        if ((bVar == null || (colorStateList = bVar.f3014j) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        if ((this.U && this.V != null && this.T) || J(this.J) || J(this.V) || I(this.z0)) {
            return true;
        }
        return false;
    }

    public void j0(float f2) {
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

    public void k0(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            this.D0 = this.C0 ? f.b.a.e.t.b.a(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public void l0(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.H, charSequence)) {
            this.H = charSequence;
            this.n0.f2968d = true;
            invalidateSelf();
            K();
        }
    }

    public void m0(f.b.a.e.s.b bVar) {
        i iVar = this.n0;
        Context context = this.h0;
        if (iVar.f2970f != bVar) {
            iVar.f2970f = bVar;
            if (bVar != null) {
                bVar.f(context, iVar.a, iVar.b);
                i.b bVar2 = iVar.f2969e.get();
                if (bVar2 != null) {
                    iVar.a.drawableState = bVar2.getState();
                }
                bVar.e(context, iVar.a, iVar.b);
                iVar.f2968d = true;
            }
            i.b bVar3 = iVar.f2969e.get();
            if (bVar3 != null) {
                bVar3.a();
                bVar3.onStateChange(bVar3.getState());
            }
        }
    }

    public void n0(float f2) {
        if (this.d0 != f2) {
            this.d0 = f2;
            invalidateSelf();
            K();
        }
    }

    public void o0(float f2) {
        if (this.c0 != f2) {
            this.c0 = f2;
            invalidateSelf();
            K();
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (r0()) {
            onLayoutDirectionChanged |= m.e.r1(this.J, i2);
        }
        if (q0()) {
            onLayoutDirectionChanged |= m.e.r1(this.V, i2);
        }
        if (s0()) {
            onLayoutDirectionChanged |= m.e.r1(this.O, i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    public boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (r0()) {
            onLevelChange |= this.J.setLevel(i2);
        }
        if (q0()) {
            onLevelChange |= this.V.setLevel(i2);
        }
        if (s0()) {
            onLevelChange |= this.O.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // f.b.a.e.q.i.b, f.b.a.e.v.g
    public boolean onStateChange(int[] iArr) {
        if (this.I0) {
            super.onStateChange(iArr);
        }
        return L(iArr, this.B0);
    }

    public void p0(boolean z) {
        if (this.C0 != z) {
            this.C0 = z;
            this.D0 = z ? f.b.a.e.t.b.a(this.G) : null;
            onStateChange(getState());
        }
    }

    public final boolean q0() {
        return this.U && this.V != null && this.u0;
    }

    public final boolean r0() {
        return this.I && this.J != null;
    }

    public final boolean s0() {
        return this.N && this.O != null;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // f.b.a.e.v.g
    public void setAlpha(int i2) {
        if (this.w0 != i2) {
            this.w0 = i2;
            invalidateSelf();
        }
    }

    @Override // f.b.a.e.v.g
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.x0 != colorFilter) {
            this.x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // f.b.a.e.v.g
    public void setTintList(ColorStateList colorStateList) {
        if (this.z0 != colorStateList) {
            this.z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // f.b.a.e.v.g
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.A0 != mode) {
            this.A0 = mode;
            this.y0 = f.b.a.c.b.o.b.v1(this, this.z0, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (r0()) {
            visible |= this.J.setVisible(z, z2);
        }
        if (q0()) {
            visible |= this.V.setVisible(z, z2);
        }
        if (s0()) {
            visible |= this.O.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void t0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
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
            m.e.r1(drawable, m.e.o0(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.O) {
                if (drawable.isStateful()) {
                    drawable.setState(this.B0);
                }
                drawable.setTintList(this.Q);
                return;
            }
            Drawable drawable2 = this.J;
            if (drawable == drawable2 && this.M) {
                drawable2.setTintList(this.K);
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }
}
