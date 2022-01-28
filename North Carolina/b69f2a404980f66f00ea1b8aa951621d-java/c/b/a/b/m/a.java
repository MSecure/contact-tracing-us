package c.b.a.b.m;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import b.m.a.a.b;
import b.m.a.a.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f3108a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f3109b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f3110c = new b.m.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f3111d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f3112e = new DecelerateInterpolator();

    public static float a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static int b(int i, int i2, float f) {
        return Math.round(f * ((float) (i2 - i))) + i;
    }
}
