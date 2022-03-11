package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;
import e.b.a.m;
import e.j.c.a;
/* loaded from: classes.dex */
public class x0 {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    public static final int[] b = {-16842910};
    public static final int[] c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f1050d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f1051e = {16842912};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f1052f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f1053g = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                String str = "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).";
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i2) {
        ColorStateList d2 = d(context, i2);
        if (d2 != null && d2.isStateful()) {
            return d2.getColorForState(b, d2.getDefaultColor());
        }
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f2 = typedValue.getFloat();
        int c2 = c(context, i2);
        return a.c(c2, Math.round(((float) Color.alpha(c2)) * f2));
    }

    public static int c(Context context, int i2) {
        int[] iArr = f1053g;
        iArr[0] = i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList d(Context context, int i2) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = f1053g;
        iArr[0] = i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = m.e.g0(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
