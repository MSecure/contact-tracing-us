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

public final class c {
    public static final Paint U = null;
    public Bitmap A;
    public Paint B;
    public float C;
    public float D;
    public int[] E;
    public boolean F;
    public final TextPaint G;
    public final TextPaint H;
    public TimeInterpolator I;
    public TimeInterpolator J;
    public float K;
    public float L;
    public float M;
    public ColorStateList N;
    public StaticLayout O;
    public float P;
    public float Q;
    public float R;
    public CharSequence S;
    public int T = 1;

    /* renamed from: a  reason: collision with root package name */
    public final View f4189a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4190b;

    /* renamed from: c  reason: collision with root package name */
    public float f4191c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f4192d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f4193e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f4194f;

    /* renamed from: g  reason: collision with root package name */
    public int f4195g = 16;
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
    public a v;
    public CharSequence w;
    public CharSequence x;
    public boolean y;
    public boolean z;

    static {
        Paint paint = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            U.setColor(-65281);
        }
    }

    public c(View view) {
        this.f4189a = view;
        this.G = new TextPaint(129);
        this.H = new TextPaint(this.G);
        this.f4193e = new Rect();
        this.f4192d = new Rect();
        this.f4194f = new RectF();
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i3)) * f2) + (((float) Color.alpha(i2)) * f3)), (int) ((((float) Color.red(i3)) * f2) + (((float) Color.red(i2)) * f3)), (int) ((((float) Color.green(i3)) * f2) + (((float) Color.green(i2)) * f3)), (int) ((((float) Color.blue(i3)) * f2) + (((float) Color.blue(i2)) * f3)));
    }

    public static float i(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return c.b.a.b.m.a.a(f2, f3, f4);
    }

    public static boolean l(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    public float b() {
        if (this.w == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.H;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        TextPaint textPaint2 = this.H;
        CharSequence charSequence = this.w;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c(CharSequence charSequence) {
        boolean z2 = true;
        if (m.p(this.f4189a) != 1) {
            z2 = false;
        }
        return ((d.c) (z2 ? d.f1836d : d.f1835c)).b(charSequence, 0, charSequence.length());
    }

    public final void d(float f2) {
        int i2;
        TextPaint textPaint;
        this.f4194f.left = i((float) this.f4192d.left, (float) this.f4193e.left, f2, this.I);
        this.f4194f.top = i(this.m, this.n, f2, this.I);
        this.f4194f.right = i((float) this.f4192d.right, (float) this.f4193e.right, f2, this.I);
        this.f4194f.bottom = i((float) this.f4192d.bottom, (float) this.f4193e.bottom, f2, this.I);
        this.q = i(this.o, this.p, f2, this.I);
        this.r = i(this.m, this.n, f2, this.I);
        p(i(this.i, this.j, f2, this.J));
        this.P = 1.0f - i(0.0f, 1.0f, 1.0f - f2, c.b.a.b.m.a.f4411b);
        m.M(this.f4189a);
        this.Q = i(1.0f, 0.0f, f2, c.b.a.b.m.a.f4411b);
        m.M(this.f4189a);
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            textPaint = this.G;
            i2 = a(h(colorStateList2), g(), f2);
        } else {
            textPaint = this.G;
            i2 = g();
        }
        textPaint.setColor(i2);
        this.G.setShadowLayer(i(0.0f, this.K, f2, null), i(0.0f, this.L, f2, null), i(0.0f, this.M, f2, null), a(h(null), h(this.N), f2));
        this.f4189a.postInvalidateOnAnimation();
    }

    public final void e(float f2) {
        float f3;
        boolean z2;
        StaticLayout staticLayout;
        if (this.w != null) {
            float width = (float) this.f4193e.width();
            float width2 = (float) this.f4192d.width();
            if (Math.abs(f2 - this.j) < 0.001f) {
                f3 = this.j;
                this.C = 1.0f;
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
                    this.C = 1.0f;
                } else {
                    this.C = f2 / this.i;
                }
                float f5 = this.j / this.i;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
                f3 = f4;
            }
            if (width > 0.0f) {
                z2 = this.D != f3 || this.F || z2;
                this.D = f3;
                this.F = false;
            }
            if (this.x == null || z2) {
                this.G.setTextSize(this.D);
                this.G.setTypeface(this.u);
                this.G.setLinearText(this.C != 1.0f);
                boolean c2 = c(this.w);
                this.y = c2;
                int i2 = this.T > 1 && !c2 && !this.z ? this.T : 1;
                boolean z3 = this.y;
                try {
                    CharSequence charSequence = this.w;
                    TextPaint textPaint = this.G;
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
                } catch (h e2) {
                    e2.getCause().getMessage();
                    staticLayout = null;
                }
                i.j.g(staticLayout);
                this.O = staticLayout;
                this.x = staticLayout.getText();
            }
        }
    }

    public float f() {
        TextPaint textPaint = this.H;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        return -this.H.ascent();
    }

    public int g() {
        return h(this.l);
    }

    public final int h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.E;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void j() {
        this.f4190b = this.f4193e.width() > 0 && this.f4193e.height() > 0 && this.f4192d.width() > 0 && this.f4192d.height() > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012f  */
    public void k() {
        float measureText;
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        int i2;
        int i3;
        float f2;
        Bitmap bitmap;
        float f3;
        float f4;
        float f5;
        StaticLayout staticLayout3;
        if (this.f4189a.getHeight() > 0 && this.f4189a.getWidth() > 0) {
            float f6 = this.D;
            e(this.j);
            CharSequence charSequence = this.x;
            if (!(charSequence == null || (staticLayout3 = this.O) == null)) {
                this.S = TextUtils.ellipsize(charSequence, this.G, (float) staticLayout3.getWidth(), TextUtils.TruncateAt.END);
            }
            CharSequence charSequence2 = this.S;
            float f7 = 0.0f;
            float measureText2 = charSequence2 != null ? this.G.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
            int absoluteGravity = Gravity.getAbsoluteGravity(this.h, this.y ? 1 : 0);
            int i4 = absoluteGravity & 112;
            if (i4 != 48) {
                this.n = i4 != 80 ? ((float) this.f4193e.centerY()) - ((this.G.descent() - this.G.ascent()) / 2.0f) : this.G.ascent() + ((float) this.f4193e.bottom);
            } else {
                this.n = (float) this.f4193e.top;
            }
            int i5 = absoluteGravity & 8388615;
            if (i5 == 1) {
                f5 = (float) this.f4193e.centerX();
                measureText2 /= 2.0f;
            } else if (i5 != 5) {
                this.p = (float) this.f4193e.left;
                e(this.i);
                StaticLayout staticLayout4 = this.O;
                float height = staticLayout4 == null ? (float) staticLayout4.getHeight() : 0.0f;
                CharSequence charSequence3 = this.x;
                measureText = charSequence3 == null ? this.G.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
                staticLayout = this.O;
                if (staticLayout != null && this.T > 1 && !this.y) {
                    measureText = (float) staticLayout.getWidth();
                }
                staticLayout2 = this.O;
                if (staticLayout2 != null) {
                    f7 = staticLayout2.getLineLeft(0);
                }
                this.R = f7;
                int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f4195g, this.y ? 1 : 0);
                i2 = absoluteGravity2 & 112;
                if (i2 != 48) {
                    f4 = (float) this.f4192d.top;
                } else if (i2 != 80) {
                    this.m = ((float) this.f4192d.centerY()) - (height / 2.0f);
                    i3 = absoluteGravity2 & 8388615;
                    if (i3 == 1) {
                        f3 = (float) this.f4192d.centerX();
                        measureText /= 2.0f;
                    } else if (i3 != 5) {
                        f2 = (float) this.f4192d.left;
                        this.o = f2;
                        bitmap = this.A;
                        if (bitmap != null) {
                            bitmap.recycle();
                            this.A = null;
                        }
                        p(f6);
                        d(this.f4191c);
                    } else {
                        f3 = (float) this.f4192d.right;
                    }
                    f2 = f3 - measureText;
                    this.o = f2;
                    bitmap = this.A;
                    if (bitmap != null) {
                    }
                    p(f6);
                    d(this.f4191c);
                } else {
                    f4 = this.G.descent() + (((float) this.f4192d.bottom) - height);
                }
                this.m = f4;
                i3 = absoluteGravity2 & 8388615;
                if (i3 == 1) {
                }
                f2 = f3 - measureText;
                this.o = f2;
                bitmap = this.A;
                if (bitmap != null) {
                }
                p(f6);
                d(this.f4191c);
            } else {
                f5 = (float) this.f4193e.right;
            }
            this.p = f5 - measureText2;
            e(this.i);
            StaticLayout staticLayout42 = this.O;
            if (staticLayout42 == null) {
            }
            CharSequence charSequence32 = this.x;
            if (charSequence32 == null) {
            }
            staticLayout = this.O;
            measureText = (float) staticLayout.getWidth();
            staticLayout2 = this.O;
            if (staticLayout2 != null) {
            }
            this.R = f7;
            int absoluteGravity22 = Gravity.getAbsoluteGravity(this.f4195g, this.y ? 1 : 0);
            i2 = absoluteGravity22 & 112;
            if (i2 != 48) {
            }
            this.m = f4;
            i3 = absoluteGravity22 & 8388615;
            if (i3 == 1) {
            }
            f2 = f3 - measureText;
            this.o = f2;
            bitmap = this.A;
            if (bitmap != null) {
            }
            p(f6);
            d(this.f4191c);
        }
    }

    public void m(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            k();
        }
    }

    public void n(int i2) {
        if (this.h != i2) {
            this.h = i2;
            k();
        }
    }

    public void o(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 != this.f4191c) {
            this.f4191c = f2;
            d(f2);
        }
    }

    public final void p(float f2) {
        e(f2);
        this.z = false;
        if (0 != 0 && this.A == null && !this.f4192d.isEmpty() && !TextUtils.isEmpty(this.x)) {
            d(0.0f);
            int width = this.O.getWidth();
            int height = this.O.getHeight();
            if (width > 0 && height > 0) {
                this.A = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.O.draw(new Canvas(this.A));
                if (this.B == null) {
                    this.B = new Paint(3);
                }
            }
        }
        m.M(this.f4189a);
    }

    public void q(Typeface typeface) {
        boolean z2;
        a aVar = this.v;
        boolean z3 = true;
        if (aVar != null) {
            aVar.f4230c = true;
        }
        if (this.s != typeface) {
            this.s = typeface;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            z3 = false;
        }
        if (z2 || z3) {
            k();
        }
    }
}
