package b.b.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import b.b.j;
import b.i.f.a;

public class t0 {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f938a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f939b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f940c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f941d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f942e = {16842912};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f943f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f944g = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(j.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(j.AppCompatTheme_windowActionBar)) {
                String str = "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).";
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i) {
        ColorStateList d2 = d(context, i);
        if (d2 != null && d2.isStateful()) {
            return d2.getColorForState(f939b, d2.getDefaultColor());
        }
        TypedValue typedValue = f938a.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f938a.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f2 = typedValue.getFloat();
        int c2 = c(context, i);
        return a.c(c2, Math.round(((float) Color.alpha(c2)) * f2));
    }

    public static int c(Context context, int i) {
        int[] iArr = f944g;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList d(Context context, int i) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = f944g;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = b.b.l.a.a.a(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
