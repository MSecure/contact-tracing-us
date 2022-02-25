package f.b.a.d.t;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

public class a {
    public static final int[] a = {16842919};
    public static final int[] b = {16843623, 16842908};
    public static final int[] c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f2744d = {16843623};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f2745e = {16842913, 16842919};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f2746f = {16842913, 16843623, 16842908};

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f2747g = {16842913, 16842908};

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f2748h = {16842913, 16843623};

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f2749i = {16842913};

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f2750j = {16842910, 16842919};

    /* renamed from: k  reason: collision with root package name */
    public static final String f2751k = a.class.getSimpleName();

    public static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return e.i.c.a.c(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    public static ColorStateList b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f2750j, 0)) != 0) {
            Log.w(f2751k, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean c(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
