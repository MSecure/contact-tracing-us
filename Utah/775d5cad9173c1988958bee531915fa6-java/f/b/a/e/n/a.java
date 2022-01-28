package f.b.a.e.n;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R$attr;
import f.b.a.c.b.o.b;

public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f2923f = ((int) Math.round(5.1000000000000005d));
    public final boolean a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2924d;

    /* renamed from: e  reason: collision with root package name */
    public final float f2925e;

    public a(Context context) {
        boolean l1 = b.l1(context, R$attr.elevationOverlayEnabled, false);
        int v0 = b.v0(context, R$attr.elevationOverlayColor, 0);
        int v02 = b.v0(context, R$attr.elevationOverlayAccentColor, 0);
        int v03 = b.v0(context, R$attr.colorSurface, 0);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.a = l1;
        this.b = v0;
        this.c = v02;
        this.f2924d = v03;
        this.f2925e = f2;
    }

    public int a(int i2, float f2) {
        int i3;
        if (!this.a) {
            return i2;
        }
        if (!(e.i.c.a.c(i2, 255) == this.f2924d)) {
            return i2;
        }
        float f3 = this.f2925e;
        float min = (f3 <= 0.0f || f2 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p((double) (f2 / f3))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int alpha = Color.alpha(i2);
        int a1 = b.a1(e.i.c.a.c(i2, 255), this.b, min);
        if (min > 0.0f && (i3 = this.c) != 0) {
            a1 = e.i.c.a.a(e.i.c.a.c(i3, f2923f), a1);
        }
        return e.i.c.a.c(a1, alpha);
    }
}
