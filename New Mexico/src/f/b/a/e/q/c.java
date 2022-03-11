package f.b.a.e.q;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import e.j.h.d;
import e.j.j.v;
import f.b.a.e.q.h;
import f.b.a.e.s.a;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class c {
    public Bitmap A;
    public float B;
    public float C;
    public int[] D;
    public boolean E;
    public final TextPaint F;
    public final TextPaint G;
    public TimeInterpolator H;
    public TimeInterpolator I;
    public float J;
    public float K;
    public float L;
    public ColorStateList M;
    public float N;
    public StaticLayout O;
    public float P;
    public float Q;
    public float R;
    public float S;
    public CharSequence T;
    public final View a;
    public boolean b;
    public float c;

    /* renamed from: l */
    public ColorStateList f2997l;
    public ColorStateList m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public Typeface t;
    public Typeface u;
    public Typeface v;
    public a w;
    public CharSequence x;
    public CharSequence y;
    public boolean z;

    /* renamed from: h */
    public int f2993h = 16;

    /* renamed from: i */
    public int f2994i = 16;

    /* renamed from: j */
    public float f2995j = 15.0f;

    /* renamed from: k */
    public float f2996k = 15.0f;
    public int U = h.m;

    /* renamed from: f */
    public final Rect f2991f = new Rect();

    /* renamed from: e */
    public final Rect f2990e = new Rect();

    /* renamed from: g */
    public final RectF f2992g = new RectF();

    /* renamed from: d */
    public float f2989d = 0.5f;

    public c(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(129);
        this.F = textPaint;
        this.G = new TextPaint(textPaint);
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i3)) * f2) + (((float) Color.alpha(i2)) * f3)), (int) ((((float) Color.red(i3)) * f2) + (((float) Color.red(i2)) * f3)), (int) ((((float) Color.green(i3)) * f2) + (((float) Color.green(i2)) * f3)), (int) ((((float) Color.blue(i3)) * f2) + (((float) Color.blue(i2)) * f3)));
    }

    public static float h(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return f.b.a.e.a.a.a(f2, f3, f4);
    }

    public static boolean k(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    public final boolean b(CharSequence charSequence) {
        View view = this.a;
        AtomicInteger atomicInteger = v.a;
        boolean z = true;
        if (v.e.d(view) != 1) {
            z = false;
        }
        return ((d.c) (z ? d.f1607d : d.c)).b(charSequence, 0, charSequence.length());
    }

    public final void c(float f2) {
        int i2;
        TextPaint textPaint;
        TextPaint textPaint2;
        this.f2992g.left = h((float) this.f2990e.left, (float) this.f2991f.left, f2, this.H);
        this.f2992g.top = h(this.n, this.o, f2, this.H);
        this.f2992g.right = h((float) this.f2990e.right, (float) this.f2991f.right, f2, this.H);
        this.f2992g.bottom = h((float) this.f2990e.bottom, (float) this.f2991f.bottom, f2, this.H);
        this.r = h(this.p, this.q, f2, this.H);
        this.s = h(this.n, this.o, f2, this.H);
        o(h(this.f2995j, this.f2996k, f2, this.I));
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.b;
        this.Q = 1.0f - h(0.0f, 1.0f, 1.0f - f2, timeInterpolator);
        View view = this.a;
        AtomicInteger atomicInteger = v.a;
        v.d.k(view);
        this.R = h(1.0f, 0.0f, f2, timeInterpolator);
        v.d.k(this.a);
        ColorStateList colorStateList = this.m;
        ColorStateList colorStateList2 = this.f2997l;
        if (colorStateList != colorStateList2) {
            textPaint = this.F;
            i2 = a(g(colorStateList2), f(), f2);
        } else {
            textPaint = this.F;
            i2 = f();
        }
        textPaint.setColor(i2);
        float f3 = this.N;
        if (f3 != 0.0f) {
            textPaint2 = this.F;
            f3 = h(0.0f, f3, f2, timeInterpolator);
        } else {
            textPaint2 = this.F;
        }
        textPaint2.setLetterSpacing(f3);
        this.F.setShadowLayer(h(0.0f, this.J, f2, null), h(0.0f, this.K, f2, null), h(0.0f, this.L, f2, null), a(g(null), g(this.M), f2));
        v.d.k(this.a);
    }

    public final void d(float f2, boolean z) {
        float f3;
        boolean z2;
        StaticLayout staticLayout;
        if (this.x != null) {
            float width = (float) this.f2991f.width();
            float width2 = (float) this.f2990e.width();
            if (Math.abs(f2 - this.f2996k) < 0.001f) {
                f3 = this.f2996k;
                this.B = 1.0f;
                Typeface typeface = this.v;
                Typeface typeface2 = this.t;
                if (typeface != typeface2) {
                    this.v = typeface2;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                float f4 = this.f2995j;
                Typeface typeface3 = this.v;
                Typeface typeface4 = this.u;
                if (typeface3 != typeface4) {
                    this.v = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (Math.abs(f2 - f4) < 0.001f) {
                    this.B = 1.0f;
                } else {
                    this.B = f2 / this.f2995j;
                }
                float f5 = this.f2996k / this.f2995j;
                width = (!z && width2 * f5 > width) ? Math.min(width / f5, width2) : width2;
                f3 = f4;
            }
            if (width > 0.0f) {
                z2 = this.C != f3 || this.E || z2;
                this.C = f3;
                this.E = false;
            }
            if (this.y == null || z2) {
                this.F.setTextSize(this.C);
                this.F.setTypeface(this.v);
                this.F.setLinearText(this.B != 1.0f);
                boolean b = b(this.x);
                this.z = b;
                try {
                    h hVar = new h(this.x, this.F, (int) width);
                    hVar.f3009l = TextUtils.TruncateAt.END;
                    hVar.f3008k = b;
                    hVar.f3002e = Layout.Alignment.ALIGN_NORMAL;
                    hVar.f3007j = false;
                    hVar.f3003f = 1;
                    hVar.f3004g = 0.0f;
                    hVar.f3005h = 1.0f;
                    hVar.f3006i = this.U;
                    staticLayout = hVar.a();
                } catch (h.a e2) {
                    e2.getCause().getMessage();
                    staticLayout = null;
                }
                Objects.requireNonNull(staticLayout);
                this.O = staticLayout;
                this.y = staticLayout.getText();
            }
        }
    }

    public float e() {
        TextPaint textPaint = this.G;
        textPaint.setTextSize(this.f2996k);
        textPaint.setTypeface(this.t);
        textPaint.setLetterSpacing(this.N);
        return -this.G.ascent();
    }

    public int f() {
        return g(this.m);
    }

    public final int g(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.D;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void i() {
        this.b = this.f2991f.width() > 0 && this.f2991f.height() > 0 && this.f2990e.width() > 0 && this.f2990e.height() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void j() {
        float f2;
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        int i2;
        int i3;
        float f3;
        Bitmap bitmap;
        float f4;
        float f5;
        float f6;
        float f7;
        StaticLayout staticLayout3;
        if (this.a.getHeight() > 0 && this.a.getWidth() > 0) {
            float f8 = this.C;
            d(this.f2996k, false);
            CharSequence charSequence = this.y;
            if (!(charSequence == null || (staticLayout3 = this.O) == null)) {
                this.T = TextUtils.ellipsize(charSequence, this.F, (float) staticLayout3.getWidth(), TextUtils.TruncateAt.END);
            }
            float f9 = 0.0f;
            if (this.T != null) {
                TextPaint textPaint = new TextPaint(this.F);
                textPaint.setLetterSpacing(this.N);
                CharSequence charSequence2 = this.T;
                this.P = textPaint.measureText(charSequence2, 0, charSequence2.length());
            } else {
                this.P = 0.0f;
            }
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f2994i, this.z ? 1 : 0);
            int i4 = absoluteGravity & 112;
            if (i4 != 48) {
                this.o = i4 != 80 ? ((float) this.f2991f.centerY()) - ((this.F.descent() - this.F.ascent()) / 2.0f) : this.F.ascent() + ((float) this.f2991f.bottom);
            } else {
                this.o = (float) this.f2991f.top;
            }
            int i5 = absoluteGravity & 8388615;
            if (i5 == 1) {
                f7 = (float) this.f2991f.centerX();
                f6 = this.P / 2.0f;
            } else if (i5 != 5) {
                f2 = (float) this.f2991f.left;
                this.q = f2;
                d(this.f2995j, false);
                StaticLayout staticLayout4 = this.O;
                float height = staticLayout4 == null ? (float) staticLayout4.getHeight() : 0.0f;
                staticLayout = this.O;
                if (staticLayout != null) {
                    staticLayout.getLineCount();
                }
                CharSequence charSequence3 = this.y;
                float measureText = charSequence3 == null ? this.F.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
                staticLayout2 = this.O;
                if (staticLayout2 != null) {
                    f9 = staticLayout2.getLineLeft(0);
                }
                this.S = f9;
                int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f2993h, this.z ? 1 : 0);
                i2 = absoluteGravity2 & 112;
                if (i2 != 48) {
                    f5 = (float) this.f2990e.top;
                } else if (i2 != 80) {
                    this.n = ((float) this.f2990e.centerY()) - (height / 2.0f);
                    i3 = absoluteGravity2 & 8388615;
                    if (i3 == 1) {
                        f4 = (float) this.f2990e.centerX();
                        measureText /= 2.0f;
                    } else if (i3 != 5) {
                        f3 = (float) this.f2990e.left;
                        this.p = f3;
                        bitmap = this.A;
                        if (bitmap != null) {
                            bitmap.recycle();
                            this.A = null;
                        }
                        o(f8);
                        c(this.c);
                    } else {
                        f4 = (float) this.f2990e.right;
                    }
                    f3 = f4 - measureText;
                    this.p = f3;
                    bitmap = this.A;
                    if (bitmap != null) {
                    }
                    o(f8);
                    c(this.c);
                } else {
                    f5 = this.F.descent() + (((float) this.f2990e.bottom) - height);
                }
                this.n = f5;
                i3 = absoluteGravity2 & 8388615;
                if (i3 == 1) {
                }
                f3 = f4 - measureText;
                this.p = f3;
                bitmap = this.A;
                if (bitmap != null) {
                }
                o(f8);
                c(this.c);
            } else {
                f7 = (float) this.f2991f.right;
                f6 = this.P;
            }
            f2 = f7 - f6;
            this.q = f2;
            d(this.f2995j, false);
            StaticLayout staticLayout42 = this.O;
            if (staticLayout42 == null) {
            }
            staticLayout = this.O;
            if (staticLayout != null) {
            }
            CharSequence charSequence32 = this.y;
            if (charSequence32 == null) {
            }
            staticLayout2 = this.O;
            if (staticLayout2 != null) {
            }
            this.S = f9;
            int absoluteGravity22 = Gravity.getAbsoluteGravity(this.f2993h, this.z ? 1 : 0);
            i2 = absoluteGravity22 & 112;
            if (i2 != 48) {
            }
            this.n = f5;
            i3 = absoluteGravity22 & 8388615;
            if (i3 == 1) {
            }
            f3 = f4 - measureText;
            this.p = f3;
            bitmap = this.A;
            if (bitmap != null) {
            }
            o(f8);
            c(this.c);
        }
    }

    public void l(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            j();
        }
    }

    public void m(int i2) {
        if (this.f2994i != i2) {
            this.f2994i = i2;
            j();
        }
    }

    public void n(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 != this.c) {
            this.c = f2;
            c(f2);
        }
    }

    public final void o(float f2) {
        d(f2, false);
        View view = this.a;
        AtomicInteger atomicInteger = v.a;
        v.d.k(view);
    }

    public void p(Typeface typeface) {
        boolean z;
        a aVar = this.w;
        boolean z2 = true;
        if (aVar != null) {
            aVar.c = true;
        }
        if (this.t != typeface) {
            this.t = typeface;
            z = true;
        } else {
            z = false;
        }
        if (this.u != typeface) {
            this.u = typeface;
        } else {
            z2 = false;
        }
        if (z || z2) {
            j();
        }
    }
}
