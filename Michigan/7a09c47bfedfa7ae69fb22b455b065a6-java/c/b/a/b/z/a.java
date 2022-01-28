package c.b.a.b.z;

import android.content.Context;
import android.graphics.Color;
import b.x.t;
import c.b.a.b.b;
import gov.michigan.MiCovidExposure.BuildConfig;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4642a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4643b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4644c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4645d;

    public a(Context context) {
        this.f4642a = t.A2(context, b.elevationOverlayEnabled, false);
        this.f4643b = t.z1(context, b.elevationOverlayColor, 0);
        this.f4644c = t.z1(context, b.colorSurface, 0);
        this.f4645d = context.getResources().getDisplayMetrics().density;
    }

    public int a(int i, float f2) {
        if (!this.f4642a) {
            return i;
        }
        if (!(b.i.f.a.c(i, BuildConfig.VERSION_CODE) == this.f4644c)) {
            return i;
        }
        float f3 = this.f4645d;
        float f4 = 0.0f;
        if (f3 > 0.0f && f2 > 0.0f) {
            f4 = Math.min(((((float) Math.log1p((double) (f2 / f3))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return b.i.f.a.c(t.a2(b.i.f.a.c(i, BuildConfig.VERSION_CODE), this.f4643b, f4), Color.alpha(i));
    }
}
