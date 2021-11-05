package c.b.a.b.c0;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import b.b.k.i;
import b.i.j.d;
import b.i.l.m;
import c.b.a.b.e0.a;

public final class b {
    public static final Paint Z = null;
    public boolean A;
    public Bitmap B;
    public Paint C;
    public float D;
    public float E;
    public int[] F;
    public boolean G;
    public final TextPaint H;
    public final TextPaint I;
    public TimeInterpolator J;
    public TimeInterpolator K;
    public float L;
    public float M;
    public float N;
    public ColorStateList O;
    public float P;
    public float Q;
    public float R;
    public ColorStateList S;
    public StaticLayout T;
    public float U;
    public float V;
    public float W;
    public CharSequence X;
    public int Y = 1;

    /* renamed from: a  reason: collision with root package name */
    public final View f2925a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2926b;

    /* renamed from: c  reason: collision with root package name */
    public float f2927c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f2928d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f2929e;
    public final RectF f;
    public int g = 16;
    public int h = 16;
    public float i = 15.0f;
    public float j = 15.0f;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public c.b.a.b.e0.a v;
    public c.b.a.b.e0.a w;
    public CharSequence x;
    public CharSequence y;
    public boolean z;

    public class a implements a.AbstractC0064a {
        public a() {
        }

        @Override // c.b.a.b.e0.a.AbstractC0064a
        public void a(Typeface typeface) {
            b.this.r(typeface);
        }
    }

    /* renamed from: c.b.a.b.c0.b$b  reason: collision with other inner class name */
    public class C0063b implements a.AbstractC0064a {
        public C0063b() {
        }

        @Override // c.b.a.b.e0.a.AbstractC0064a
        public void a(Typeface typeface) {
            b.this.v(typeface);
        }
    }

    static {
        Paint paint = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            Z.setColor(-65281);
        }
    }

    public b(View view) {
        this.f2925a = view;
        this.H = new TextPaint(129);
        this.I = new TextPaint(this.H);
        this.f2929e = new Rect();
        this.f2928d = new Rect();
        this.f = new RectF();
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i3)) * f2) + (((float) Color.alpha(i2)) * f3)), (int) ((((float) Color.red(i3)) * f2) + (((float) Color.red(i2)) * f3)), (int) ((((float) Color.green(i3)) * f2) + (((float) Color.green(i2)) * f3)), (int) ((((float) Color.blue(i3)) * f2) + (((float) Color.blue(i2)) * f3)));
    }

    public static float k(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return c.b.a.b.m.a.a(f2, f3, f4);
    }

    public static boolean n(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    public void A(Typeface typeface) {
        boolean z2;
        c.b.a.b.e0.a aVar = this.w;
        boolean z3 = true;
        if (aVar != null) {
            aVar.f2957c = true;
        }
        if (this.s != typeface) {
            this.s = typeface;
            z2 = true;
        } else {
            z2 = false;
        }
        c.b.a.b.e0.a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.f2957c = true;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            z3 = false;
        }
        if (z2 || z3) {
            m();
        }
    }

    public final boolean B() {
        return this.Y > 1 && !this.z && !this.A;
    }

    public float b() {
        if (this.x == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.I;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        TextPaint textPaint2 = this.I;
        CharSequence charSequence = this.x;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c(CharSequence charSequence) {
        boolean z2 = true;
        if (m.o(this.f2925a) != 1) {
            z2 = false;
        }
        return ((d.c) (z2 ? d.f1126d : d.f1125c)).b(charSequence, 0, charSequence.length());
    }

    public final void d(float f2) {
        int i2;
        TextPaint textPaint;
        this.f.left = k((float) this.f2928d.left, (float) this.f2929e.left, f2, this.J);
        this.f.top = k(this.m, this.n, f2, this.J);
        this.f.right = k((float) this.f2928d.right, (float) this.f2929e.right, f2, this.J);
        this.f.bottom = k((float) this.f2928d.bottom, (float) this.f2929e.bottom, f2, this.J);
        this.q = k(this.o, this.p, f2, this.J);
        this.r = k(this.m, this.n, f2, this.J);
        x(k(this.i, this.j, f2, this.K));
        this.U = 1.0f - k(0.0f, 1.0f, 1.0f - f2, c.b.a.b.m.a.f3109b);
        m.L(this.f2925a);
        this.V = k(1.0f, 0.0f, f2, c.b.a.b.m.a.f3109b);
        m.L(this.f2925a);
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            textPaint = this.H;
            i2 = a(j(colorStateList2), i(), f2);
        } else {
            textPaint = this.H;
            i2 = i();
        }
        textPaint.setColor(i2);
        this.H.setShadowLayer(k(this.P, this.L, f2, null), k(this.Q, this.M, f2, null), k(this.R, this.N, f2, null), a(j(this.S), j(this.O), f2));
        this.f2925a.postInvalidateOnAnimation();
    }

    public final void e(float f2) {
        float f3;
        boolean z2;
        StaticLayout staticLayout;
        if (this.x != null) {
            float width = (float) this.f2929e.width();
            float width2 = (float) this.f2928d.width();
            if (Math.abs(f2 - this.j) < 0.001f) {
                f3 = this.j;
                this.D = 1.0f;
                Typeface typeface = this.u;
                Typeface typeface2 = this.s;
                if (typeface != typeface2) {
                    this.u = typeface2;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                float f4 = this.i;
                Typeface typeface3 = this.u;
                Typeface typeface4 = this.t;
                if (typeface3 != typeface4) {
                    this.u = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (Math.abs(f2 - this.i) < 0.001f) {
                    this.D = 1.0f;
                } else {
                    this.D = f2 / this.i;
                }
                float f5 = this.j / this.i;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
                f3 = f4;
            }
            if (width > 0.0f) {
                z2 = this.E != f3 || this.G || z2;
                this.E = f3;
                this.G = false;
            }
            if (this.y == null || z2) {
                this.H.setTextSize(this.E);
                this.H.setTypeface(this.u);
                this.H.setLinearText(this.D != 1.0f);
                this.z = c(this.x);
                int i2 = B() ? this.Y : 1;
                boolean z3 = this.z;
                try {
                    CharSequence charSequence = this.x;
                    TextPaint textPaint = this.H;
                    int length = charSequence.length();
                    Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
                    TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
                    Layout.Alignment alignment2 = Layout.Alignment.ALIGN_NORMAL;
                    int max = Math.max(0, (int) width);
                    if (i2 == 1) {
                        charSequence = TextUtils.ellipsize(charSequence, textPaint, (float) max, truncateAt);
                    }
                    int min = Math.min(charSequence.length(), length);
                    if (z3) {
                        alignment2 = Layout.Alignment.ALIGN_OPPOSITE;
                    }
                    StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, textPaint, max);
                    obtain.setAlignment(alignment2);
                    obtain.setIncludePad(false);
                    obtain.setTextDirection(z3 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
                    if (truncateAt != null) {
                        obtain.setEllipsize(truncateAt);
                    }
                    obtain.setMaxLines(i2);
                    staticLayout = obtain.build();
                } catch (g e2) {
                    e2.getCause().getMessage();
                    staticLayout = null;
                }
                i.j.q(staticLayout);
                this.T = staticLayout;
                this.y = staticLayout.getText();
            }
        }
    }

    public final void f() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    public void g(Canvas canvas) {
        int save = canvas.save();
        if (this.y != null && this.f2926b) {
            float lineLeft = (this.T.getLineLeft(0) + this.q) - (this.W * 2.0f);
            this.H.setTextSize(this.E);
            float f2 = this.q;
            float f3 = this.r;
            boolean z2 = this.A && this.B != null;
            float lineAscent = (float) this.T.getLineAscent(0);
            float f4 = this.D;
            if (f4 != 1.0f) {
                canvas.scale(f4, f4, f2, f3);
            }
            if (z2) {
                canvas.drawBitmap(this.B, f2, f3 + lineAscent, this.C);
                canvas.restoreToCount(save);
                return;
            }
            if (B()) {
                int alpha = this.H.getAlpha();
                canvas.translate(lineLeft, f3);
                float f5 = (float) alpha;
                this.H.setAlpha((int) (this.V * f5));
                this.T.draw(canvas);
                canvas.translate(f2 - lineLeft, 0.0f);
                this.H.setAlpha((int) (this.U * f5));
                CharSequence charSequence = this.X;
                float f6 = -lineAscent;
                canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6 / this.D, this.H);
                String trim = this.X.toString().trim();
                if (trim.endsWith("…")) {
                    trim = trim.substring(0, trim.length() - 1);
                }
                this.H.setAlpha(alpha);
                canvas.drawText(trim, 0, Math.min(this.T.getLineEnd(0), trim.length()), 0.0f, f6 / this.D, (Paint) this.H);
            } else {
                canvas.translate(f2, f3 + lineAscent);
                this.T.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public float h() {
        TextPaint textPaint = this.I;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        return -this.I.ascent();
    }

    public int i() {
        return j(this.l);
    }

    public final int j(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.F;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void l() {
        this.f2926b = this.f2929e.width() > 0 && this.f2929e.height() > 0 && this.f2928d.width() > 0 && this.f2928d.height() > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x016b  */
    public void m() {
        int i2;
        float measureText;
        StaticLayout staticLayout;
        int i3;
        int i4;
        float f2;
        float f3;
        float f4;
        float f5;
        StaticLayout staticLayout2;
        if (this.f2925a.getHeight() > 0 && this.f2925a.getWidth() > 0) {
            float f6 = this.E;
            e(this.j);
            CharSequence charSequence = this.y;
            if (!(charSequence == null || (staticLayout2 = this.T) == null)) {
                this.X = TextUtils.ellipsize(charSequence, this.H, (float) staticLayout2.getWidth(), TextUtils.TruncateAt.END);
            }
            CharSequence charSequence2 = this.X;
            float f7 = 0.0f;
            float measureText2 = charSequence2 != null ? this.H.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
            int absoluteGravity = Gravity.getAbsoluteGravity(this.h, this.z ? 1 : 0);
            StaticLayout staticLayout3 = this.T;
            float height = staticLayout3 != null ? (float) staticLayout3.getHeight() : 0.0f;
            int i5 = absoluteGravity & 112;
            if (i5 == 48) {
                f5 = ((float) this.f2929e.top) - this.H.ascent();
            } else if (i5 != 80) {
                float descent = (this.H.descent() - this.H.ascent()) / 2.0f;
                this.n = B() ? ((float) this.f2929e.centerY()) - descent : (descent - this.H.descent()) + ((float) this.f2929e.centerY());
                i2 = absoluteGravity & 8388615;
                if (i2 != 1) {
                    f4 = (float) this.f2929e.centerX();
                    measureText2 /= 2.0f;
                } else if (i2 != 5) {
                    this.p = (float) this.f2929e.left;
                    e(this.i);
                    CharSequence charSequence3 = this.y;
                    measureText = charSequence3 != null ? this.H.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
                    staticLayout = this.T;
                    if (staticLayout != null && this.Y > 1 && !this.z) {
                        measureText = staticLayout.getLineWidth(0);
                    }
                    StaticLayout staticLayout4 = this.T;
                    this.W = staticLayout4 != null ? staticLayout4.getLineLeft(0) : 0.0f;
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(this.g, this.z ? 1 : 0);
                    i3 = absoluteGravity2 & 112;
                    if (i3 == 48) {
                        f3 = ((float) this.f2928d.top) - this.H.ascent();
                    } else if (i3 != 80) {
                        f3 = B() ? ((float) this.f2928d.centerY()) - (height / 2.0f) : (((this.H.descent() - this.H.ascent()) / 2.0f) - this.H.descent()) + ((float) this.f2928d.centerY());
                    } else {
                        if (B()) {
                            f7 = height - this.H.descent();
                        }
                        this.m = ((float) this.f2928d.bottom) - f7;
                        i4 = absoluteGravity2 & 8388615;
                        if (i4 != 1) {
                            f2 = (float) this.f2928d.centerX();
                            measureText /= 2.0f;
                        } else if (i4 != 5) {
                            this.o = (float) this.f2928d.left;
                            f();
                            x(f6);
                            d(this.f2927c);
                        } else {
                            f2 = (float) this.f2928d.right;
                        }
                        this.o = f2 - measureText;
                        f();
                        x(f6);
                        d(this.f2927c);
                    }
                    this.m = f3;
                    i4 = absoluteGravity2 & 8388615;
                    if (i4 != 1) {
                    }
                    this.o = f2 - measureText;
                    f();
                    x(f6);
                    d(this.f2927c);
                } else {
                    f4 = (float) this.f2929e.right;
                }
                this.p = f4 - measureText2;
                e(this.i);
                CharSequence charSequence32 = this.y;
                if (charSequence32 != null) {
                }
                staticLayout = this.T;
                measureText = staticLayout.getLineWidth(0);
                StaticLayout staticLayout42 = this.T;
                this.W = staticLayout42 != null ? staticLayout42.getLineLeft(0) : 0.0f;
                int absoluteGravity22 = Gravity.getAbsoluteGravity(this.g, this.z ? 1 : 0);
                i3 = absoluteGravity22 & 112;
                if (i3 == 48) {
                }
                this.m = f3;
                i4 = absoluteGravity22 & 8388615;
                if (i4 != 1) {
                }
                this.o = f2 - measureText;
                f();
                x(f6);
                d(this.f2927c);
            } else {
                f5 = (float) this.f2929e.bottom;
            }
            this.n = f5;
            i2 = absoluteGravity & 8388615;
            if (i2 != 1) {
            }
            this.p = f4 - measureText2;
            e(this.i);
            CharSequence charSequence322 = this.y;
            if (charSequence322 != null) {
            }
            staticLayout = this.T;
            measureText = staticLayout.getLineWidth(0);
            StaticLayout staticLayout422 = this.T;
            this.W = staticLayout422 != null ? staticLayout422.getLineLeft(0) : 0.0f;
            int absoluteGravity222 = Gravity.getAbsoluteGravity(this.g, this.z ? 1 : 0);
            i3 = absoluteGravity222 & 112;
            if (i3 == 48) {
            }
            this.m = f3;
            i4 = absoluteGravity222 & 8388615;
            if (i4 != 1) {
            }
            this.o = f2 - measureText;
            f();
            x(f6);
            d(this.f2927c);
        }
    }

    public void o(int i2) {
        c.b.a.b.e0.b bVar = new c.b.a.b.e0.b(this.f2925a.getContext(), i2);
        ColorStateList colorStateList = bVar.f2959b;
        if (colorStateList != null) {
            this.l = colorStateList;
        }
        float f2 = bVar.f2958a;
        if (f2 != 0.0f) {
            this.j = f2;
        }
        ColorStateList colorStateList2 = bVar.f;
        if (colorStateList2 != null) {
            this.O = colorStateList2;
        }
        this.M = bVar.g;
        this.N = bVar.h;
        this.L = bVar.i;
        c.b.a.b.e0.a aVar = this.w;
        if (aVar != null) {
            aVar.f2957c = true;
        }
        a aVar2 = new a();
        bVar.a();
        this.w = new c.b.a.b.e0.a(aVar2, bVar.l);
        bVar.b(this.f2925a.getContext(), this.w);
        m();
    }

    public void p(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            m();
        }
    }

    public void q(int i2) {
        if (this.h != i2) {
            this.h = i2;
            m();
        }
    }

    public void r(Typeface typeface) {
        c.b.a.b.e0.a aVar = this.w;
        boolean z2 = true;
        if (aVar != null) {
            aVar.f2957c = true;
        }
        if (this.s != typeface) {
            this.s = typeface;
        } else {
            z2 = false;
        }
        if (z2) {
            m();
        }
    }

    public void s(int i2) {
        c.b.a.b.e0.b bVar = new c.b.a.b.e0.b(this.f2925a.getContext(), i2);
        ColorStateList colorStateList = bVar.f2959b;
        if (colorStateList != null) {
            this.k = colorStateList;
        }
        float f2 = bVar.f2958a;
        if (f2 != 0.0f) {
            this.i = f2;
        }
        ColorStateList colorStateList2 = bVar.f;
        if (colorStateList2 != null) {
            this.S = colorStateList2;
        }
        this.Q = bVar.g;
        this.R = bVar.h;
        this.P = bVar.i;
        c.b.a.b.e0.a aVar = this.v;
        if (aVar != null) {
            aVar.f2957c = true;
        }
        C0063b bVar2 = new C0063b();
        bVar.a();
        this.v = new c.b.a.b.e0.a(bVar2, bVar.l);
        bVar.b(this.f2925a.getContext(), this.v);
        m();
    }

    public void t(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            m();
        }
    }

    public void u(int i2) {
        if (this.g != i2) {
            this.g = i2;
            m();
        }
    }

    public void v(Typeface typeface) {
        c.b.a.b.e0.a aVar = this.v;
        boolean z2 = true;
        if (aVar != null) {
            aVar.f2957c = true;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            z2 = false;
        }
        if (z2) {
            m();
        }
    }

    public void w(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 != this.f2927c) {
            this.f2927c = f2;
            d(f2);
        }
    }

    public final void x(float f2) {
        e(f2);
        this.A = false;
        if (0 != 0 && this.B == null && !this.f2928d.isEmpty() && !TextUtils.isEmpty(this.y)) {
            d(0.0f);
            int width = this.T.getWidth();
            int height = this.T.getHeight();
            if (width > 0 && height > 0) {
                this.B = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.T.draw(new Canvas(this.B));
                if (this.C == null) {
                    this.C = new Paint(3);
                }
            }
        }
        m.L(this.f2925a);
    }

    public final boolean y(int[] iArr) {
        ColorStateList colorStateList;
        this.F = iArr;
        ColorStateList colorStateList2 = this.l;
        if (!((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.k) != null && colorStateList.isStateful()))) {
            return false;
        }
        m();
        return true;
    }

    public void z(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.x, charSequence)) {
            this.x = charSequence;
            this.y = null;
            f();
            m();
        }
    }
}
