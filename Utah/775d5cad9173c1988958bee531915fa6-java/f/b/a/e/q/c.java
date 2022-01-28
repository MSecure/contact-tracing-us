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
import e.i.g.d;
import e.i.i.v;
import f.b.a.e.q.h;
import f.b.a.e.s.a;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

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
    public CharSequence S;
    public int T = h.m;
    public final View a;
    public boolean b;
    public float c;

    /* renamed from: d  reason: collision with root package name */
    public float f2947d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f2948e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f2949f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f2950g;

    /* renamed from: h  reason: collision with root package name */
    public int f2951h = 16;

    /* renamed from: i  reason: collision with root package name */
    public int f2952i = 16;

    /* renamed from: j  reason: collision with root package name */
    public float f2953j = 15.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f2954k = 15.0f;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f2955l;
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

    public c(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(129);
        this.F = textPaint;
        this.G = new TextPaint(textPaint);
        this.f2949f = new Rect();
        this.f2948e = new Rect();
        this.f2950g = new RectF();
        this.f2947d = 0.5f;
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i3)) * f2) + (((float) Color.alpha(i2)) * f3)), (int) ((((float) Color.red(i3)) * f2) + (((float) Color.red(i2)) * f3)), (int) ((((float) Color.green(i3)) * f2) + (((float) Color.green(i2)) * f3)), (int) ((((float) Color.blue(i3)) * f2) + (((float) Color.blue(i2)) * f3)));
    }

    public static float i(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return f.b.a.e.a.a.a(f2, f3, f4);
    }

    public static boolean l(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    public float b() {
        if (this.x == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.G;
        textPaint.setTextSize(this.f2954k);
        textPaint.setTypeface(this.t);
        textPaint.setLetterSpacing(this.N);
        TextPaint textPaint2 = this.G;
        CharSequence charSequence = this.x;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c(CharSequence charSequence) {
        View view = this.a;
        AtomicInteger atomicInteger = v.a;
        boolean z2 = true;
        if (v.e.d(view) != 1) {
            z2 = false;
        }
        return ((d.c) (z2 ? d.f1522d : d.c)).b(charSequence, 0, charSequence.length());
    }

    public final void d(float f2) {
        int i2;
        TextPaint textPaint;
        TextPaint textPaint2;
        this.f2950g.left = i((float) this.f2948e.left, (float) this.f2949f.left, f2, this.H);
        this.f2950g.top = i(this.n, this.o, f2, this.H);
        this.f2950g.right = i((float) this.f2948e.right, (float) this.f2949f.right, f2, this.H);
        this.f2950g.bottom = i((float) this.f2948e.bottom, (float) this.f2949f.bottom, f2, this.H);
        this.r = i(this.p, this.q, f2, this.H);
        this.s = i(this.n, this.o, f2, this.H);
        p(i(this.f2953j, this.f2954k, f2, this.I));
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.b;
        this.P = 1.0f - i(0.0f, 1.0f, 1.0f - f2, timeInterpolator);
        View view = this.a;
        AtomicInteger atomicInteger = v.a;
        v.d.k(view);
        this.Q = i(1.0f, 0.0f, f2, timeInterpolator);
        v.d.k(this.a);
        ColorStateList colorStateList = this.m;
        ColorStateList colorStateList2 = this.f2955l;
        if (colorStateList != colorStateList2) {
            textPaint = this.F;
            i2 = a(h(colorStateList2), g(), f2);
        } else {
            textPaint = this.F;
            i2 = g();
        }
        textPaint.setColor(i2);
        float f3 = this.N;
        if (f3 != 0.0f) {
            textPaint2 = this.F;
            f3 = i(0.0f, f3, f2, timeInterpolator);
        } else {
            textPaint2 = this.F;
        }
        textPaint2.setLetterSpacing(f3);
        this.F.setShadowLayer(i(0.0f, this.J, f2, null), i(0.0f, this.K, f2, null), i(0.0f, this.L, f2, null), a(h(null), h(this.M), f2));
        v.d.k(this.a);
    }

    public final void e(float f2, boolean z2) {
        float f3;
        boolean z3;
        StaticLayout staticLayout;
        if (this.x != null) {
            float width = (float) this.f2949f.width();
            float width2 = (float) this.f2948e.width();
            if (Math.abs(f2 - this.f2954k) < 0.001f) {
                f3 = this.f2954k;
                this.B = 1.0f;
                Typeface typeface = this.v;
                Typeface typeface2 = this.t;
                if (typeface != typeface2) {
                    this.v = typeface2;
                    z3 = true;
                } else {
                    z3 = false;
                }
            } else {
                float f4 = this.f2953j;
                Typeface typeface3 = this.v;
                Typeface typeface4 = this.u;
                if (typeface3 != typeface4) {
                    this.v = typeface4;
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (Math.abs(f2 - f4) < 0.001f) {
                    this.B = 1.0f;
                } else {
                    this.B = f2 / this.f2953j;
                }
                float f5 = this.f2954k / this.f2953j;
                width = (!z2 && width2 * f5 > width) ? Math.min(width / f5, width2) : width2;
                f3 = f4;
            }
            if (width > 0.0f) {
                z3 = this.C != f3 || this.E || z3;
                this.C = f3;
                this.E = false;
            }
            if (this.y == null || z3) {
                this.F.setTextSize(this.C);
                this.F.setTypeface(this.v);
                this.F.setLinearText(this.B != 1.0f);
                boolean c2 = c(this.x);
                this.z = c2;
                try {
                    h hVar = new h(this.x, this.F, (int) width);
                    hVar.f2967l = TextUtils.TruncateAt.END;
                    hVar.f2966k = c2;
                    hVar.f2960e = Layout.Alignment.ALIGN_NORMAL;
                    hVar.f2965j = false;
                    hVar.f2961f = 1;
                    hVar.f2962g = 0.0f;
                    hVar.f2963h = 1.0f;
                    hVar.f2964i = this.T;
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

    public float f() {
        TextPaint textPaint = this.G;
        textPaint.setTextSize(this.f2954k);
        textPaint.setTypeface(this.t);
        textPaint.setLetterSpacing(this.N);
        return -this.G.ascent();
    }

    public int g() {
        return h(this.m);
    }

    public final int h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.D;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void j() {
        this.b = this.f2949f.width() > 0 && this.f2949f.height() > 0 && this.f2948e.width() > 0 && this.f2948e.height() > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0127  */
    public void k() {
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
        if (this.a.getHeight() > 0 && this.a.getWidth() > 0) {
            float f6 = this.C;
            e(this.f2954k, false);
            CharSequence charSequence = this.y;
            if (!(charSequence == null || (staticLayout3 = this.O) == null)) {
                this.S = TextUtils.ellipsize(charSequence, this.F, (float) staticLayout3.getWidth(), TextUtils.TruncateAt.END);
            }
            CharSequence charSequence2 = this.S;
            float f7 = 0.0f;
            float measureText = charSequence2 != null ? this.F.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f2952i, this.z ? 1 : 0);
            int i4 = absoluteGravity & 112;
            if (i4 != 48) {
                this.o = i4 != 80 ? ((float) this.f2949f.centerY()) - ((this.F.descent() - this.F.ascent()) / 2.0f) : this.F.ascent() + ((float) this.f2949f.bottom);
            } else {
                this.o = (float) this.f2949f.top;
            }
            int i5 = absoluteGravity & 8388615;
            if (i5 == 1) {
                f5 = (float) this.f2949f.centerX();
                measureText /= 2.0f;
            } else if (i5 != 5) {
                this.q = (float) this.f2949f.left;
                e(this.f2953j, false);
                StaticLayout staticLayout4 = this.O;
                float height = staticLayout4 == null ? (float) staticLayout4.getHeight() : 0.0f;
                staticLayout = this.O;
                if (staticLayout != null) {
                    staticLayout.getLineCount();
                }
                CharSequence charSequence3 = this.y;
                float measureText2 = charSequence3 == null ? this.F.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
                staticLayout2 = this.O;
                if (staticLayout2 != null) {
                    f7 = staticLayout2.getLineLeft(0);
                }
                this.R = f7;
                int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f2951h, this.z ? 1 : 0);
                i2 = absoluteGravity2 & 112;
                if (i2 != 48) {
                    f4 = (float) this.f2948e.top;
                } else if (i2 != 80) {
                    this.n = ((float) this.f2948e.centerY()) - (height / 2.0f);
                    i3 = absoluteGravity2 & 8388615;
                    if (i3 == 1) {
                        f3 = (float) this.f2948e.centerX();
                        measureText2 /= 2.0f;
                    } else if (i3 != 5) {
                        f2 = (float) this.f2948e.left;
                        this.p = f2;
                        bitmap = this.A;
                        if (bitmap != null) {
                            bitmap.recycle();
                            this.A = null;
                        }
                        p(f6);
                        d(this.c);
                    } else {
                        f3 = (float) this.f2948e.right;
                    }
                    f2 = f3 - measureText2;
                    this.p = f2;
                    bitmap = this.A;
                    if (bitmap != null) {
                    }
                    p(f6);
                    d(this.c);
                } else {
                    f4 = this.F.descent() + (((float) this.f2948e.bottom) - height);
                }
                this.n = f4;
                i3 = absoluteGravity2 & 8388615;
                if (i3 == 1) {
                }
                f2 = f3 - measureText2;
                this.p = f2;
                bitmap = this.A;
                if (bitmap != null) {
                }
                p(f6);
                d(this.c);
            } else {
                f5 = (float) this.f2949f.right;
            }
            this.q = f5 - measureText;
            e(this.f2953j, false);
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
            this.R = f7;
            int absoluteGravity22 = Gravity.getAbsoluteGravity(this.f2951h, this.z ? 1 : 0);
            i2 = absoluteGravity22 & 112;
            if (i2 != 48) {
            }
            this.n = f4;
            i3 = absoluteGravity22 & 8388615;
            if (i3 == 1) {
            }
            f2 = f3 - measureText2;
            this.p = f2;
            bitmap = this.A;
            if (bitmap != null) {
            }
            p(f6);
            d(this.c);
        }
    }

    public void m(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            k();
        }
    }

    public void n(int i2) {
        if (this.f2952i != i2) {
            this.f2952i = i2;
            k();
        }
    }

    public void o(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 != this.c) {
            this.c = f2;
            d(f2);
        }
    }

    public final void p(float f2) {
        e(f2, false);
        View view = this.a;
        AtomicInteger atomicInteger = v.a;
        v.d.k(view);
    }

    public void q(Typeface typeface) {
        boolean z2;
        a aVar = this.w;
        boolean z3 = true;
        if (aVar != null) {
            aVar.c = true;
        }
        if (this.t != typeface) {
            this.t = typeface;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.u != typeface) {
            this.u = typeface;
        } else {
            z3 = false;
        }
        if (z2 || z3) {
            k();
        }
    }
}
