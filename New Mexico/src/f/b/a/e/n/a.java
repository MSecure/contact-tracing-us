package f.b.a.e.n;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R$attr;
import f.b.a.c.b.o.b;
/* loaded from: classes.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f2965f = (int) Math.round(5.1000000000000005d);
    public final boolean a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2966d;

    /* renamed from: e  reason: collision with root package name */
    public final float f2967e;

    public a(Context context) {
        boolean m1 = b.m1(context, R$attr.elevationOverlayEnabled, false);
        int w0 = b.w0(context, R$attr.elevationOverlayColor, 0);
        int w02 = b.w0(context, R$attr.elevationOverlayAccentColor, 0);
        int w03 = b.w0(context, R$attr.colorSurface, 0);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.a = m1;
        this.b = w0;
        this.c = w02;
        this.f2966d = w03;
        this.f2967e = f2;
    }

    public int a(int i2, float f2) {
        int i3;
        if (!this.a) {
            return i2;
        }
        if (!(e.j.c.a.c(i2, 255) == this.f2966d)) {
            return i2;
        }
        float f3 = this.f2967e;
        float min = (f3 <= 0.0f || f2 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p((double) (f2 / f3))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int alpha = Color.alpha(i2);
        int b1 = b.b1(e.j.c.a.c(i2, 255), this.b, min);
        if (min > 0.0f && (i3 = this.c) != 0) {
            b1 = e.j.c.a.a(e.j.c.a.c(i3, f2965f), b1);
        }
        return e.j.c.a.c(b1, alpha);
    }
}
