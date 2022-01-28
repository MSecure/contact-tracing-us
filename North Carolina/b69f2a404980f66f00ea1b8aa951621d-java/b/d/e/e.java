package b.d.e;

import android.graphics.drawable.Drawable;

public class e extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public static final double f793a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        return (float) (((1.0d - f793a) * ((double) f2)) + ((double) f));
    }

    public static float b(float f, float f2, boolean z) {
        float f3 = f * 1.5f;
        if (!z) {
            return f3;
        }
        return (float) (((1.0d - f793a) * ((double) f2)) + ((double) f3));
    }
}
