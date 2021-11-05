package c.b.a.b.c0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import c.a.a.a.a;
import c.b.a.b.b;
import c.b.a.b.l;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f4216a = {b.colorPrimary};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f4217b = {b.colorPrimaryVariant};

    public static void a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ThemeEnforcement, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(l.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(b.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context, f4217b, "Theme.MaterialComponents");
            }
        }
        c(context, f4216a, "Theme.AppCompat");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r0.getResourceId(c.b.a.b.l.ThemeEnforcement_android_textAppearance, -1) != -1) goto L_0x003d;
     */
    public static void b(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ThemeEnforcement, i, i2);
        boolean z = false;
        if (!obtainStyledAttributes.getBoolean(l.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 != null && iArr2.length != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
            for (int i3 : iArr2) {
                if (obtainStyledAttributes2.getResourceId(i3, -1) == -1) {
                    obtainStyledAttributes2.recycle();
                    break;
                }
            }
            obtainStyledAttributes2.recycle();
        }
        z = true;
        obtainStyledAttributes.recycle();
        if (!z) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void c(Context context, int[] iArr, String str) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= iArr.length) {
                obtainStyledAttributes.recycle();
                z = true;
                break;
            } else if (!obtainStyledAttributes.hasValue(i)) {
                obtainStyledAttributes.recycle();
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            throw new IllegalArgumentException(a.c("The style on this component requires your app theme to be ", str, " (or a descendant)."));
        }
    }

    public static TypedArray d(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        a(context, attributeSet, i, i2);
        b(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }
}
