package c.b.a.b.m;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import b.n.a.a.b;
import b.n.a.a.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f4410a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f4411b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f4412c = new b.n.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f4413d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f4414e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return ((f3 - f2) * f4) + f2;
    }

    public static int b(int i, int i2, float f2) {
        return Math.round(f2 * ((float) (i2 - i))) + i;
    }
}
