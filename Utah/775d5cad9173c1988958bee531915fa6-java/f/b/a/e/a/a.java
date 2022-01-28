package f.b.a.e.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import e.p.a.a.b;
import e.p.a.a.c;

public class a {
    public static final TimeInterpolator a = new LinearInterpolator();
    public static final TimeInterpolator b = new b();
    public static final TimeInterpolator c = new e.p.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f2831d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f2832e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f.a.a.a.a.a(f3, f2, f4, f2);
    }

    public static float b(float f2, float f3, float f4, float f5, float f6) {
        return f6 < f4 ? f2 : f6 > f5 ? f3 : a(f2, f3, (f6 - f4) / (f5 - f4));
    }
}
