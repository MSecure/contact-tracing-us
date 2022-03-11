package f.b.a.d.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import e.o.a.a.b;
import e.o.a.a.c;

public class a {
    public static final TimeInterpolator a = new LinearInterpolator();
    public static final TimeInterpolator b = new b();
    public static final TimeInterpolator c = new e.o.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f2653d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f2654e = new DecelerateInterpolator();

    public static int a(int i2, int i3, float f2) {
        return Math.round(f2 * ((float) (i3 - i2))) + i2;
    }
}
