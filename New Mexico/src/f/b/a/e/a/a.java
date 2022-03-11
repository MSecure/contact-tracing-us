package f.b.a.e.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import e.q.a.a.b;
import e.q.a.a.c;
/* loaded from: classes.dex */
public class a {
    public static final TimeInterpolator a = new LinearInterpolator();
    public static final TimeInterpolator b = new b();
    public static final TimeInterpolator c = new e.q.a.a.a();

    /* renamed from: d */
    public static final TimeInterpolator f2873d = new c();

    /* renamed from: e */
    public static final TimeInterpolator f2874e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f.a.a.a.a.a(f3, f2, f4, f2);
    }

    public static float b(float f2, float f3, float f4, float f5, float f6) {
        return f6 < f4 ? f2 : f6 > f5 ? f3 : a(f2, f3, (f6 - f4) / (f5 - f4));
    }
}
