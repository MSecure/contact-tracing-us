package f.b.a.d.n;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R$attr;
import f.b.a.c.b.o.b;

public class a {
    public final boolean a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final float f2654d;

    public a(Context context) {
        this.a = b.D1(context, R$attr.elevationOverlayEnabled, false);
        this.b = b.J0(context, R$attr.elevationOverlayColor, 0);
        this.c = b.J0(context, R$attr.colorSurface, 0);
        this.f2654d = context.getResources().getDisplayMetrics().density;
    }

    public int a(int i2, float f2) {
        if (!this.a) {
            return i2;
        }
        if (!(e.i.c.a.c(i2, 255) == this.c)) {
            return i2;
        }
        float f3 = this.f2654d;
        float f4 = 0.0f;
        if (f3 > 0.0f && f2 > 0.0f) {
            f4 = Math.min(((((float) Math.log1p((double) (f2 / f3))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return e.i.c.a.c(b.m1(e.i.c.a.c(i2, 255), this.b, f4), Color.alpha(i2));
    }
}
