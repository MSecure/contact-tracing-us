package c.b.a.b.z;

import android.content.Context;
import android.graphics.Color;
import c.b.a.a.c.n.c;
import c.b.a.b.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3306a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3307b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3308c;

    /* renamed from: d  reason: collision with root package name */
    public final float f3309d;

    public a(Context context) {
        this.f3306a = c.V1(context, b.elevationOverlayEnabled, false);
        this.f3307b = c.X0(context, b.elevationOverlayColor, 0);
        this.f3308c = c.X0(context, b.colorSurface, 0);
        this.f3309d = context.getResources().getDisplayMetrics().density;
    }

    public int a(int i, float f) {
        if (!this.f3306a) {
            return i;
        }
        if (!(b.i.f.a.c(i, 255) == this.f3308c)) {
            return i;
        }
        float f2 = this.f3309d;
        float f3 = 0.0f;
        if (f2 > 0.0f && f > 0.0f) {
            f3 = Math.min(((((float) Math.log1p((double) (f / f2))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return b.i.f.a.c(c.x1(b.i.f.a.c(i, 255), this.f3307b, f3), Color.alpha(i));
    }
}
