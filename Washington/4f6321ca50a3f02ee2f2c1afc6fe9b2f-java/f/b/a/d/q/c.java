package f.b.a.d.q;

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
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import e.i.g.d;
import e.i.i.l;
import f.b.a.d.q.h;
import f.b.a.d.s.a;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class c {
    public float A;
    public float B;
    public int[] C;
    public boolean D;
    public final TextPaint E;
    public final TextPaint F;
    public TimeInterpolator G;
    public TimeInterpolator H;
    public float I;
    public float J;
    public float K;
    public ColorStateList L;
    public float M;
    public StaticLayout N;
    public float O;
    public float P;
    public float Q;
    public CharSequence R;
    public final View a;
    public boolean b;
    public float c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f2678d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f2679e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f2680f;

    /* renamed from: g  reason: collision with root package name */
    public int f2681g = 16;

    /* renamed from: h  reason: collision with root package name */
    public int f2682h = 16;

    /* renamed from: i  reason: collision with root package name */
    public float f2683i = 15.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f2684j = 15.0f;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f2685k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f2686l;
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
    public Bitmap z;

    public c(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(129);
        this.E = textPaint;
        this.F = new TextPaint(textPaint);
        this.f2679e = new Rect();
        this.f2678d = new Rect();
        this.f2680f = new RectF();
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i3)) * f2) + (((float) Color.alpha(i2)) * f3)), (int) ((((float) Color.red(i3)) * f2) + (((float) Color.red(i2)) * f3)), (int) ((((float) Color.green(i3)) * f2) + (((float) Color.green(i2)) * f3)), (int) ((((float) Color.blue(i3)) * f2) + (((float) Color.blue(i2)) * f3)));
    }

    public static float i(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        TimeInterpolator timeInterpolator2 = f.b.a.d.a.a.a;
        return f.a.a.a.a.a(f3, f2, f4, f2);
    }

    public static boolean l(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    public float b() {
        if (this.w == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.F;
        textPaint.setTextSize(this.f2684j);
        textPaint.setTypeface(this.s);
        textPaint.setLetterSpacing(this.M);
        TextPaint textPaint2 = this.F;
        CharSequence charSequence = this.w;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c(CharSequence charSequence) {
        View view = this.a;
        AtomicInteger atomicInteger = l.a;
        boolean z2 = true;
        if (view.getLayoutDirection() != 1) {
            z2 = false;
        }
        return ((d.c) (z2 ? d.f1462d : d.c)).b(charSequence, 0, charSequence.length());
    }

    public final void d(float f2) {
        int i2;
        TextPaint textPaint;
        TextPaint textPaint2;
        this.f2680f.left = i((float) this.f2678d.left, (float) this.f2679e.left, f2, this.G);
        this.f2680f.top = i(this.m, this.n, f2, this.G);
        this.f2680f.right = i((float) this.f2678d.right, (float) this.f2679e.right, f2, this.G);
        this.f2680f.bottom = i((float) this.f2678d.bottom, (float) this.f2679e.bottom, f2, this.G);
        this.q = i(this.o, this.p, f2, this.G);
        this.r = i(this.m, this.n, f2, this.G);
        p(i(this.f2683i, this.f2684j, f2, this.H));
        TimeInterpolator timeInterpolator = f.b.a.d.a.a.b;
        this.O = 1.0f - i(0.0f, 1.0f, 1.0f - f2, timeInterpolator);
        View view = this.a;
        AtomicInteger atomicInteger = l.a;
        view.postInvalidateOnAnimation();
        this.P = i(1.0f, 0.0f, f2, timeInterpolator);
        this.a.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f2686l;
        ColorStateList colorStateList2 = this.f2685k;
        if (colorStateList != colorStateList2) {
            textPaint = this.E;
            i2 = a(h(colorStateList2), g(), f2);
        } else {
            textPaint = this.E;
            i2 = g();
        }
        textPaint.setColor(i2);
        float f3 = this.M;
        if (f3 != 0.0f) {
            textPaint2 = this.E;
            f3 = i(0.0f, f3, f2, timeInterpolator);
        } else {
            textPaint2 = this.E;
        }
        textPaint2.setLetterSpacing(f3);
        this.E.setShadowLayer(i(0.0f, this.I, f2, null), i(0.0f, this.J, f2, null), i(0.0f, this.K, f2, null), a(h(null), h(this.L), f2));
        this.a.postInvalidateOnAnimation();
    }

    public final void e(float f2) {
        float f3;
        boolean z2;
        StaticLayout staticLayout;
        if (this.w != null) {
            float width = (float) this.f2679e.width();
            float width2 = (float) this.f2678d.width();
            if (Math.abs(f2 - this.f2684j) < 0.001f) {
                f3 = this.f2684j;
                this.A = 1.0f;
                Typeface typeface = this.u;
                Typeface typeface2 = this.s;
                if (typeface != typeface2) {
                    this.u = typeface2;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                float f4 = this.f2683i;
                Typeface typeface3 = this.u;
                Typeface typeface4 = this.t;
                if (typeface3 != typeface4) {
                    this.u = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (Math.abs(f2 - f4) < 0.001f) {
                    this.A = 1.0f;
                } else {
                    this.A = f2 / this.f2683i;
                }
                float f5 = this.f2684j / this.f2683i;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
                f3 = f4;
            }
            if (width > 0.0f) {
                z2 = this.B != f3 || this.D || z2;
                this.B = f3;
                this.D = false;
            }
            if (this.x == null || z2) {
                this.E.setTextSize(this.B);
                this.E.setTypeface(this.u);
                this.E.setLinearText(this.A != 1.0f);
                boolean c2 = c(this.w);
                this.y = c2;
                try {
                    h hVar = new h(this.w, this.E, (int) width);
                    hVar.f2698i = TextUtils.TruncateAt.END;
                    hVar.f2697h = c2;
                    hVar.f2694e = Layout.Alignment.ALIGN_NORMAL;
                    hVar.f2696g = false;
                    hVar.f2695f = 1;
                    staticLayout = hVar.a();
                } catch (h.a e2) {
                    Log.e("CollapsingTextHelper", e2.getCause().getMessage(), e2);
                    staticLayout = null;
                }
                Objects.requireNonNull(staticLayout);
                this.N = staticLayout;
                this.x = staticLayout.getText();
            }
        }
    }

    public float f() {
        TextPaint textPaint = this.F;
        textPaint.setTextSize(this.f2684j);
        textPaint.setTypeface(this.s);
        textPaint.setLetterSpacing(this.M);
        return -this.F.ascent();
    }

    public int g() {
        return h(this.f2686l);
    }

    public final int h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.C;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void j() {
        this.b = this.f2679e.width() > 0 && this.f2679e.height() > 0 && this.f2678d.width() > 0 && this.f2678d.height() > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011e  */
    public void k() {
        StaticLayout staticLayout;
        int i2;
        int i3;
        float f2;
        Bitmap bitmap;
        float f3;
        float f4;
        float f5;
        StaticLayout staticLayout2;
        if (this.a.getHeight() > 0 && this.a.getWidth() > 0) {
            float f6 = this.B;
            e(this.f2684j);
            CharSequence charSequence = this.x;
            if (!(charSequence == null || (staticLayout2 = this.N) == null)) {
                this.R = TextUtils.ellipsize(charSequence, this.E, (float) staticLayout2.getWidth(), TextUtils.TruncateAt.END);
            }
            CharSequence charSequence2 = this.R;
            float f7 = 0.0f;
            float measureText = charSequence2 != null ? this.E.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f2682h, this.y ? 1 : 0);
            int i4 = absoluteGravity & 112;
            if (i4 != 48) {
                this.n = i4 != 80 ? ((float) this.f2679e.centerY()) - ((this.E.descent() - this.E.ascent()) / 2.0f) : this.E.ascent() + ((float) this.f2679e.bottom);
            } else {
                this.n = (float) this.f2679e.top;
            }
            int i5 = absoluteGravity & 8388615;
            if (i5 == 1) {
                f5 = (float) this.f2679e.centerX();
                measureText /= 2.0f;
            } else if (i5 != 5) {
                this.p = (float) this.f2679e.left;
                e(this.f2683i);
                StaticLayout staticLayout3 = this.N;
                float height = staticLayout3 == null ? (float) staticLayout3.getHeight() : 0.0f;
                CharSequence charSequence3 = this.x;
                float measureText2 = charSequence3 == null ? this.E.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
                staticLayout = this.N;
                if (staticLayout != null) {
                    f7 = staticLayout.getLineLeft(0);
                }
                this.Q = f7;
                int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f2681g, this.y ? 1 : 0);
                i2 = absoluteGravity2 & 112;
                if (i2 != 48) {
                    f4 = (float) this.f2678d.top;
                } else if (i2 != 80) {
                    this.m = ((float) this.f2678d.centerY()) - (height / 2.0f);
                    i3 = absoluteGravity2 & 8388615;
                    if (i3 == 1) {
                        f3 = (float) this.f2678d.centerX();
                        measureText2 /= 2.0f;
                    } else if (i3 != 5) {
                        f2 = (float) this.f2678d.left;
                        this.o = f2;
                        bitmap = this.z;
                        if (bitmap != null) {
                            bitmap.recycle();
                            this.z = null;
                        }
                        p(f6);
                        d(this.c);
                    } else {
                        f3 = (float) this.f2678d.right;
                    }
                    f2 = f3 - measureText2;
                    this.o = f2;
                    bitmap = this.z;
                    if (bitmap != null) {
                    }
                    p(f6);
                    d(this.c);
                } else {
                    f4 = this.E.descent() + (((float) this.f2678d.bottom) - height);
                }
                this.m = f4;
                i3 = absoluteGravity2 & 8388615;
                if (i3 == 1) {
                }
                f2 = f3 - measureText2;
                this.o = f2;
                bitmap = this.z;
                if (bitmap != null) {
                }
                p(f6);
                d(this.c);
            } else {
                f5 = (float) this.f2679e.right;
            }
            this.p = f5 - measureText;
            e(this.f2683i);
            StaticLayout staticLayout32 = this.N;
            if (staticLayout32 == null) {
            }
            CharSequence charSequence32 = this.x;
            if (charSequence32 == null) {
            }
            staticLayout = this.N;
            if (staticLayout != null) {
            }
            this.Q = f7;
            int absoluteGravity22 = Gravity.getAbsoluteGravity(this.f2681g, this.y ? 1 : 0);
            i2 = absoluteGravity22 & 112;
            if (i2 != 48) {
            }
            this.m = f4;
            i3 = absoluteGravity22 & 8388615;
            if (i3 == 1) {
            }
            f2 = f3 - measureText2;
            this.o = f2;
            bitmap = this.z;
            if (bitmap != null) {
            }
            p(f6);
            d(this.c);
        }
    }

    public void m(ColorStateList colorStateList) {
        if (this.f2686l != colorStateList) {
            this.f2686l = colorStateList;
            k();
        }
    }

    public void n(int i2) {
        if (this.f2682h != i2) {
            this.f2682h = i2;
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
        e(f2);
        View view = this.a;
        AtomicInteger atomicInteger = l.a;
        view.postInvalidateOnAnimation();
    }

    public void q(Typeface typeface) {
        boolean z2;
        a aVar = this.v;
        boolean z3 = true;
        if (aVar != null) {
            aVar.c = true;
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
