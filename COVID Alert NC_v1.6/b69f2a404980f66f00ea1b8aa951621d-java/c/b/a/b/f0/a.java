package c.b.a.b.f0;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f2968a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f2969b = {16842919};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f2970c = {16843623, 16842908};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f2971d = {16842908};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f2972e = {16843623};
    public static final int[] f = {16842913, 16842919};
    public static final int[] g = {16842913, 16843623, 16842908};
    public static final int[] h = {16842913, 16842908};
    public static final int[] i = {16842913, 16843623};
    public static final int[] j = {16842913};
    public static final int[] k = {16842910, 16842919};
    public static final String l = a.class.getSimpleName();

    public static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return b.i.f.a.c(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    public static ColorStateList b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0) {
            Color.alpha(colorStateList.getColorForState(k, 0));
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
