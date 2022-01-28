package c.b.a.b.v;

import android.annotation.TargetApi;
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
import android.text.TextUtils;
import android.util.AttributeSet;
import b.b.k.i;
import b.x.t;
import c.b.a.b.c0.i;
import c.b.a.b.h0.g;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class b extends g implements Drawable.Callback, i.b {
    public static final int[] J0 = {16842910};
    public static final ShapeDrawable K0 = new ShapeDrawable(new OvalShape());
    public ColorStateList A;
    public PorterDuff.Mode A0 = PorterDuff.Mode.SRC_IN;
    public float B;
    public int[] B0;
    public float C = -1.0f;
    public boolean C0;
    public ColorStateList D;
    public ColorStateList D0;
    public float E;
    public WeakReference<a> E0;
    public ColorStateList F;
    public TextUtils.TruncateAt F0;
    public CharSequence G;
    public boolean G0;
    public boolean H;
    public int H0;
    public Drawable I;
    public boolean I0;
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
    public c.b.a.b.m.g W;
    public c.b.a.b.m.g X;
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
    public final Paint i0;
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
    public int w0 = BuildConfig.VERSION_CODE;
    public ColorFilter x0;
    public PorterDuffColorFilter y0;
    public ColorStateList z;
    public ColorStateList z0;

    public interface a {
        void a();
    }

    public b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Paint paint = null;
        this.E0 = new WeakReference<>(null);
        this.f4261b.f4269b = new c.b.a.b.z.a(context);
        z();
        this.g0 = context;
        i iVar = new i(this);
        this.n0 = iVar;
        this.G = "";
        iVar.f4209a.density = context.getResources().getDisplayMetrics().density;
        this.i0 = null;
        if (0 != 0) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(J0);
        g0(J0);
        this.G0 = true;
        boolean z2 = c.b.a.b.f0.a.f4243a;
        K0.setTint(-1);
    }

    public static boolean J(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean K(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.N) {
                if (drawable.isStateful()) {
                    drawable.setState(this.B0);
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

    public final void B(Rect rect, RectF rectF) {
        float f2;
        rectF.setEmpty();
        if (r0() || q0()) {
            float f3 = this.Y + this.Z;
            float I2 = I();
            if (getLayoutDirection() == 0) {
                float f4 = ((float) rect.left) + f3;
                rectF.left = f4;
                rectF.right = f4 + I2;
            } else {
                float f5 = ((float) rect.right) - f3;
                rectF.right = f5;
                rectF.left = f5 - I2;
            }
            Drawable drawable = this.u0 ? this.U : this.I;
            if (this.K > 0.0f || drawable == null) {
                f2 = this.K;
            } else {
                f2 = (float) Math.ceil((double) t.f1(this.g0, 24));
                if (((float) drawable.getIntrinsicHeight()) <= f2) {
                    f2 = (float) drawable.getIntrinsicHeight();
                }
            }
            float exactCenterY = rect.exactCenterY() - (f2 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f2;
        }
    }

    public float C() {
        if (!r0() && !q0()) {
            return 0.0f;
        }
        return I() + this.Z + this.a0;
    }

    public final void D(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (s0()) {
            float f2 = this.f0 + this.e0;
            if (getLayoutDirection() == 0) {
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

    public final void E(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (s0()) {
            float f2 = this.f0 + this.e0 + this.Q + this.d0 + this.c0;
            if (getLayoutDirection() == 0) {
                float f3 = (float) rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i = rect.left;
                rectF.left = (float) i;
                rectF.right = ((float) i) + f2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    public float F() {
        if (s0()) {
            return this.d0 + this.Q + this.e0;
        }
        return 0.0f;
    }

    public float G() {
        return this.I0 ? m() : this.C;
    }

    public Drawable H() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return i.j.l0(drawable);
        }
        return null;
    }

    public final float I() {
        Drawable drawable = this.u0 ? this.U : this.I;
        return (this.K > 0.0f || drawable == null) ? this.K : (float) drawable.getIntrinsicWidth();
    }

    public void L() {
        a aVar = this.E0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0147  */
    public final boolean M(int[] iArr, int[] iArr2) {
        boolean z2;
        boolean z3;
        boolean z4;
        int colorForState;
        ColorStateList colorStateList;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.z;
        int colorForState2 = colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.o0) : 0;
        boolean z5 = true;
        if (this.o0 != colorForState2) {
            this.o0 = colorForState2;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.A;
        int colorForState3 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.p0) : 0;
        if (this.p0 != colorForState3) {
            this.p0 = colorForState3;
            onStateChange = true;
        }
        int a2 = b.i.f.a.a(colorForState3, colorForState2);
        if ((this.q0 != a2) || (this.f4261b.f4271d == null)) {
            this.q0 = a2;
            r(ColorStateList.valueOf(a2));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.D;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.r0) : 0;
        if (this.r0 != colorForState4) {
            this.r0 = colorForState4;
            onStateChange = true;
        }
        int colorForState5 = (this.D0 == null || !c.b.a.b.f0.a.c(iArr)) ? 0 : this.D0.getColorForState(iArr, this.s0);
        if (this.s0 != colorForState5) {
            this.s0 = colorForState5;
            if (this.C0) {
                onStateChange = true;
            }
        }
        c.b.a.b.e0.b bVar = this.n0.f4214f;
        int colorForState6 = (bVar == null || (colorStateList = bVar.f4231a) == null) ? 0 : colorStateList.getColorForState(iArr, this.t0);
        if (this.t0 != colorForState6) {
            this.t0 = colorForState6;
            onStateChange = true;
        }
        int[] state = getState();
        if (state != null) {
            int length = state.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (state[i] == 16842912) {
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            z3 = !z2 && this.S;
            if (this.u0 != z3 || this.U == null) {
                z4 = false;
            } else {
                float C2 = C();
                this.u0 = z3;
                if (C2 != C()) {
                    onStateChange = true;
                    z4 = true;
                } else {
                    z4 = false;
                    onStateChange = true;
                }
            }
            ColorStateList colorStateList5 = this.z0;
            colorForState = colorStateList5 == null ? colorStateList5.getColorForState(iArr, this.v0) : 0;
            if (this.v0 == colorForState) {
                this.v0 = colorForState;
                this.y0 = t.c3(this, this.z0, this.A0);
            } else {
                z5 = onStateChange;
            }
            if (K(this.I)) {
                z5 |= this.I.setState(iArr);
            }
            if (K(this.U)) {
                z5 |= this.U.setState(iArr);
            }
            if (K(this.N)) {
                int[] iArr3 = new int[(iArr.length + iArr2.length)];
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                z5 |= this.N.setState(iArr3);
            }
            boolean z6 = c.b.a.b.f0.a.f4243a;
            if (K(this.O)) {
                z5 |= this.O.setState(iArr2);
            }
            if (z5) {
                invalidateSelf();
            }
            if (z4) {
                L();
            }
            return z5;
        }
        z2 = false;
        if (!z2) {
        }
        if (this.u0 != z3) {
        }
        z4 = false;
        ColorStateList colorStateList52 = this.z0;
        if (colorStateList52 == null) {
        }
        if (this.v0 == colorForState) {
        }
        if (K(this.I)) {
        }
        if (K(this.U)) {
        }
        if (K(this.N)) {
        }
        boolean z62 = c.b.a.b.f0.a.f4243a;
        if (K(this.O)) {
        }
        if (z5) {
        }
        if (z4) {
        }
        return z5;
    }

    public void N(boolean z2) {
        if (this.S != z2) {
            this.S = z2;
            float C2 = C();
            if (!z2 && this.u0) {
                this.u0 = false;
            }
            float C3 = C();
            invalidateSelf();
            if (C2 != C3) {
                L();
            }
        }
    }

    public void O(Drawable drawable) {
        if (this.U != drawable) {
            float C2 = C();
            this.U = drawable;
            float C3 = C();
            t0(this.U);
            A(this.U);
            invalidateSelf();
            if (C2 != C3) {
                L();
            }
        }
    }

    public void P(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (this.T && this.U != null && this.S) {
                this.U.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void Q(boolean z2) {
        if (this.T != z2) {
            boolean q02 = q0();
            this.T = z2;
            boolean q03 = q0();
            if (q02 != q03) {
                if (q03) {
                    A(this.U);
                } else {
                    t0(this.U);
                }
                invalidateSelf();
                L();
            }
        }
    }

    public void R(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    @Deprecated
    public void S(float f2) {
        if (this.C != f2) {
            this.C = f2;
            this.f4261b.f4268a = this.f4261b.f4268a.e(f2);
            invalidateSelf();
        }
    }

    public void T(float f2) {
        if (this.f0 != f2) {
            this.f0 = f2;
            invalidateSelf();
            L();
        }
    }

    public void U(Drawable drawable) {
        Drawable drawable2 = this.I;
        Drawable drawable3 = null;
        Drawable l02 = drawable2 != null ? i.j.l0(drawable2) : null;
        if (l02 != drawable) {
            float C2 = C();
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.I = drawable3;
            float C3 = C();
            t0(l02);
            if (r0()) {
                A(this.I);
            }
            invalidateSelf();
            if (C2 != C3) {
                L();
            }
        }
    }

    public void V(float f2) {
        if (this.K != f2) {
            float C2 = C();
            this.K = f2;
            float C3 = C();
            invalidateSelf();
            if (C2 != C3) {
                L();
            }
        }
    }

    public void W(ColorStateList colorStateList) {
        this.L = true;
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (r0()) {
                this.I.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void X(boolean z2) {
        if (this.H != z2) {
            boolean r02 = r0();
            this.H = z2;
            boolean r03 = r0();
            if (r02 != r03) {
                if (r03) {
                    A(this.I);
                } else {
                    t0(this.I);
                }
                invalidateSelf();
                L();
            }
        }
    }

    public void Y(float f2) {
        if (this.B != f2) {
            this.B = f2;
            invalidateSelf();
            L();
        }
    }

    public void Z(float f2) {
        if (this.Y != f2) {
            this.Y = f2;
            invalidateSelf();
            L();
        }
    }

    @Override // c.b.a.b.c0.i.b
    public void a() {
        L();
        invalidateSelf();
    }

    public void a0(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.I0) {
                w(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void b0(float f2) {
        if (this.E != f2) {
            this.E = f2;
            this.h0.setStrokeWidth(f2);
            if (this.I0) {
                this.f4261b.l = f2;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void c0(Drawable drawable) {
        Drawable H2 = H();
        if (H2 != drawable) {
            float F2 = F();
            this.N = drawable != null ? drawable.mutate() : null;
            boolean z2 = c.b.a.b.f0.a.f4243a;
            this.O = new RippleDrawable(c.b.a.b.f0.a.b(this.F), this.N, K0);
            float F3 = F();
            t0(H2);
            if (s0()) {
                A(this.N);
            }
            invalidateSelf();
            if (F2 != F3) {
                L();
            }
        }
    }

    public void d0(float f2) {
        if (this.e0 != f2) {
            this.e0 = f2;
            invalidateSelf();
            if (s0()) {
                L();
            }
        }
    }

    @Override // c.b.a.b.h0.g
    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        float f2;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && (i = this.w0) != 0) {
            int saveLayerAlpha = i < 255 ? canvas.saveLayerAlpha((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i) : 0;
            if (!this.I0) {
                this.h0.setColor(this.o0);
                this.h0.setStyle(Paint.Style.FILL);
                this.k0.set(bounds);
                canvas.drawRoundRect(this.k0, G(), G(), this.h0);
            }
            if (!this.I0) {
                this.h0.setColor(this.p0);
                this.h0.setStyle(Paint.Style.FILL);
                Paint paint = this.h0;
                ColorFilter colorFilter = this.x0;
                if (colorFilter == null) {
                    colorFilter = this.y0;
                }
                paint.setColorFilter(colorFilter);
                this.k0.set(bounds);
                canvas.drawRoundRect(this.k0, G(), G(), this.h0);
            }
            if (this.I0) {
                super.draw(canvas);
            }
            if (this.E > 0.0f && !this.I0) {
                this.h0.setColor(this.r0);
                this.h0.setStyle(Paint.Style.STROKE);
                if (!this.I0) {
                    Paint paint2 = this.h0;
                    ColorFilter colorFilter2 = this.x0;
                    if (colorFilter2 == null) {
                        colorFilter2 = this.y0;
                    }
                    paint2.setColorFilter(colorFilter2);
                }
                RectF rectF = this.k0;
                float f3 = this.E / 2.0f;
                rectF.set(((float) bounds.left) + f3, ((float) bounds.top) + f3, ((float) bounds.right) - f3, ((float) bounds.bottom) - f3);
                float f4 = this.C - (this.E / 2.0f);
                canvas.drawRoundRect(this.k0, f4, f4, this.h0);
            }
            this.h0.setColor(this.s0);
            this.h0.setStyle(Paint.Style.FILL);
            this.k0.set(bounds);
            if (!this.I0) {
                canvas.drawRoundRect(this.k0, G(), G(), this.h0);
            } else {
                c(new RectF(bounds), this.m0);
                h(canvas, this.h0, this.m0, this.f4261b.f4268a, i());
            }
            if (r0()) {
                B(bounds, this.k0);
                RectF rectF2 = this.k0;
                float f5 = rectF2.left;
                float f6 = rectF2.top;
                canvas.translate(f5, f6);
                this.I.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
                this.I.draw(canvas);
                canvas.translate(-f5, -f6);
            }
            if (q0()) {
                B(bounds, this.k0);
                RectF rectF3 = this.k0;
                float f7 = rectF3.left;
                float f8 = rectF3.top;
                canvas.translate(f7, f8);
                this.U.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
                this.U.draw(canvas);
                canvas.translate(-f7, -f8);
            }
            if (!this.G0 || this.G == null) {
                i2 = saveLayerAlpha;
                i3 = 0;
                i4 = 255;
            } else {
                PointF pointF = this.l0;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                if (this.G != null) {
                    float C2 = C() + this.Y + this.b0;
                    if (getLayoutDirection() == 0) {
                        pointF.x = ((float) bounds.left) + C2;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = ((float) bounds.right) - C2;
                        align = Paint.Align.RIGHT;
                    }
                    this.n0.f4209a.getFontMetrics(this.j0);
                    Paint.FontMetrics fontMetrics = this.j0;
                    pointF.y = ((float) bounds.centerY()) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
                }
                RectF rectF4 = this.k0;
                rectF4.setEmpty();
                if (this.G != null) {
                    float C3 = C() + this.Y + this.b0;
                    float F2 = F() + this.f0 + this.c0;
                    if (getLayoutDirection() == 0) {
                        rectF4.left = ((float) bounds.left) + C3;
                        f2 = ((float) bounds.right) - F2;
                    } else {
                        rectF4.left = ((float) bounds.left) + F2;
                        f2 = ((float) bounds.right) - C3;
                    }
                    rectF4.right = f2;
                    rectF4.top = (float) bounds.top;
                    rectF4.bottom = (float) bounds.bottom;
                }
                c.b.a.b.c0.i iVar = this.n0;
                if (iVar.f4214f != null) {
                    iVar.f4209a.drawableState = getState();
                    c.b.a.b.c0.i iVar2 = this.n0;
                    iVar2.f4214f.c(this.g0, iVar2.f4209a, iVar2.f4210b);
                }
                this.n0.f4209a.setTextAlign(align);
                boolean z2 = Math.round(this.n0.a(this.G.toString())) > Math.round(this.k0.width());
                if (z2) {
                    i7 = canvas.save();
                    canvas.clipRect(this.k0);
                } else {
                    i7 = 0;
                }
                CharSequence charSequence = this.G;
                if (z2 && this.F0 != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.n0.f4209a, this.k0.width(), this.F0);
                }
                int length = charSequence.length();
                PointF pointF2 = this.l0;
                i2 = saveLayerAlpha;
                i3 = 0;
                i4 = 255;
                canvas.drawText(charSequence, 0, length, pointF2.x, pointF2.y, this.n0.f4209a);
                if (z2) {
                    canvas.restoreToCount(i7);
                }
            }
            if (s0()) {
                D(bounds, this.k0);
                RectF rectF5 = this.k0;
                float f9 = rectF5.left;
                float f10 = rectF5.top;
                canvas.translate(f9, f10);
                this.N.setBounds(i3, i3, (int) this.k0.width(), (int) this.k0.height());
                boolean z3 = c.b.a.b.f0.a.f4243a;
                this.O.setBounds(this.N.getBounds());
                this.O.jumpToCurrentState();
                this.O.draw(canvas);
                canvas.translate(-f9, -f10);
            }
            Paint paint3 = this.i0;
            if (paint3 != null) {
                paint3.setColor(b.i.f.a.c(-16777216, 127));
                canvas.drawRect(bounds, this.i0);
                if (r0() || q0()) {
                    B(bounds, this.k0);
                    canvas.drawRect(this.k0, this.i0);
                }
                if (this.G != null) {
                    i6 = i4;
                    i5 = i2;
                    canvas.drawLine((float) bounds.left, bounds.exactCenterY(), (float) bounds.right, bounds.exactCenterY(), this.i0);
                } else {
                    i6 = i4;
                    i5 = i2;
                }
                if (s0()) {
                    D(bounds, this.k0);
                    canvas.drawRect(this.k0, this.i0);
                }
                this.i0.setColor(b.i.f.a.c(-65536, 127));
                RectF rectF6 = this.k0;
                rectF6.set(bounds);
                if (s0()) {
                    float f11 = this.f0 + this.e0 + this.Q + this.d0 + this.c0;
                    if (getLayoutDirection() == 0) {
                        rectF6.right = ((float) bounds.right) - f11;
                    } else {
                        rectF6.left = ((float) bounds.left) + f11;
                    }
                }
                canvas.drawRect(this.k0, this.i0);
                this.i0.setColor(b.i.f.a.c(-16711936, 127));
                E(bounds, this.k0);
                canvas.drawRect(this.k0, this.i0);
            } else {
                i6 = i4;
                i5 = i2;
            }
            if (this.w0 < i6) {
                canvas.restoreToCount(i5);
            }
        }
    }

    public void e0(float f2) {
        if (this.Q != f2) {
            this.Q = f2;
            invalidateSelf();
            if (s0()) {
                L();
            }
        }
    }

    public void f0(float f2) {
        if (this.d0 != f2) {
            this.d0 = f2;
            invalidateSelf();
            if (s0()) {
                L();
            }
        }
    }

    public boolean g0(int[] iArr) {
        if (Arrays.equals(this.B0, iArr)) {
            return false;
        }
        this.B0 = iArr;
        if (s0()) {
            return M(getState(), iArr);
        }
        return false;
    }

    public int getAlpha() {
        return this.w0;
    }

    public ColorFilter getColorFilter() {
        return this.x0;
    }

    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(F() + this.n0.a(this.G.toString()) + C() + this.Y + this.b0 + this.c0 + this.f0), this.H0);
    }

    @Override // c.b.a.b.h0.g
    public int getOpacity() {
        return -3;
    }

    @Override // c.b.a.b.h0.g
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.C);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.B, this.C);
        }
        outline.setAlpha(((float) this.w0) / 255.0f);
    }

    public void h0(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (s0()) {
                this.N.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void i0(boolean z2) {
        if (this.M != z2) {
            boolean s02 = s0();
            this.M = z2;
            boolean s03 = s0();
            if (s02 != s03) {
                if (s03) {
                    A(this.N);
                } else {
                    t0(this.N);
                }
                invalidateSelf();
                L();
            }
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // c.b.a.b.h0.g
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (!J(this.z) && !J(this.A) && !J(this.D) && (!this.C0 || !J(this.D0))) {
            c.b.a.b.e0.b bVar = this.n0.f4214f;
            if (!((bVar == null || (colorStateList = bVar.f4231a) == null || !colorStateList.isStateful()) ? false : true)) {
                if (!(this.T && this.U != null && this.S) && !K(this.I) && !K(this.U) && !J(this.z0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void j0(float f2) {
        if (this.a0 != f2) {
            float C2 = C();
            this.a0 = f2;
            float C3 = C();
            invalidateSelf();
            if (C2 != C3) {
                L();
            }
        }
    }

    public void k0(float f2) {
        if (this.Z != f2) {
            float C2 = C();
            this.Z = f2;
            float C3 = C();
            invalidateSelf();
            if (C2 != C3) {
                L();
            }
        }
    }

    public void l0(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            this.D0 = this.C0 ? c.b.a.b.f0.a.b(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public void m0(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.n0.f4212d = true;
            invalidateSelf();
            L();
        }
    }

    public void n0(float f2) {
        if (this.c0 != f2) {
            this.c0 = f2;
            invalidateSelf();
            L();
        }
    }

    public void o0(float f2) {
        if (this.b0 != f2) {
            this.b0 = f2;
            invalidateSelf();
            L();
        }
    }

    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (r0()) {
            onLayoutDirectionChanged |= this.I.setLayoutDirection(i);
        }
        if (q0()) {
            onLayoutDirectionChanged |= this.U.setLayoutDirection(i);
        }
        if (s0()) {
            onLayoutDirectionChanged |= this.N.setLayoutDirection(i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (r0()) {
            onLevelChange |= this.I.setLevel(i);
        }
        if (q0()) {
            onLevelChange |= this.U.setLevel(i);
        }
        if (s0()) {
            onLevelChange |= this.N.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // c.b.a.b.c0.i.b, c.b.a.b.h0.g
    public boolean onStateChange(int[] iArr) {
        if (this.I0) {
            super.onStateChange(iArr);
        }
        return M(iArr, this.B0);
    }

    public void p0(boolean z2) {
        if (this.C0 != z2) {
            this.C0 = z2;
            this.D0 = z2 ? c.b.a.b.f0.a.b(this.F) : null;
            onStateChange(getState());
        }
    }

    public final boolean q0() {
        return this.T && this.U != null && this.u0;
    }

    public final boolean r0() {
        return this.H && this.I != null;
    }

    public final boolean s0() {
        return this.M && this.N != null;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // c.b.a.b.h0.g
    public void setAlpha(int i) {
        if (this.w0 != i) {
            this.w0 = i;
            invalidateSelf();
        }
    }

    @Override // c.b.a.b.h0.g
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.x0 != colorFilter) {
            this.x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // c.b.a.b.h0.g
    public void setTintList(ColorStateList colorStateList) {
        if (this.z0 != colorStateList) {
            this.z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // c.b.a.b.h0.g
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.A0 != mode) {
            this.A0 = mode;
            this.y0 = t.c3(this, this.z0, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (r0()) {
            visible |= this.I.setVisible(z2, z3);
        }
        if (q0()) {
            visible |= this.U.setVisible(z2, z3);
        }
        if (s0()) {
            visible |= this.N.setVisible(z2, z3);
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
}
