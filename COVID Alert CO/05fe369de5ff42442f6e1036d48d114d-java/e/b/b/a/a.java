package e.b.b.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.util.TypedValue;
import e.b.a.m;
import e.b.f.n0;
import java.util.WeakHashMap;

public final class a {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    public static final WeakHashMap<Context, SparseArray<C0013a>> b = new WeakHashMap<>(0);
    public static final Object c = new Object();

    /* renamed from: e.b.b.a.a$a  reason: collision with other inner class name */
    public static class C0013a {
        public final ColorStateList a;
        public final Configuration b;

        public C0013a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i2) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        C0013a aVar;
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        synchronized (c) {
            SparseArray<C0013a> sparseArray = b.get(context);
            colorStateList = null;
            if (!(sparseArray == null || sparseArray.size() <= 0 || (aVar = sparseArray.get(i2)) == null)) {
                if (aVar.b.equals(context.getResources().getConfiguration())) {
                    colorStateList2 = aVar.a;
                } else {
                    sparseArray.remove(i2);
                }
            }
            colorStateList2 = null;
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        Resources resources = context.getResources();
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        boolean z = true;
        resources.getValue(i2, typedValue, true);
        int i3 = typedValue.type;
        if (i3 < 28 || i3 > 31) {
            z = false;
        }
        if (!z) {
            Resources resources2 = context.getResources();
            try {
                colorStateList = m.h.D(resources2, resources2.getXml(i2), context.getTheme());
            } catch (Exception unused) {
            }
        }
        if (colorStateList != null) {
            synchronized (c) {
                WeakHashMap<Context, SparseArray<C0013a>> weakHashMap = b;
                SparseArray<C0013a> sparseArray2 = weakHashMap.get(context);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray<>();
                    weakHashMap.put(context, sparseArray2);
                }
                sparseArray2.append(i2, new C0013a(colorStateList, context.getResources().getConfiguration()));
            }
            return colorStateList;
        }
        Object obj = e.i.b.a.a;
        return Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i2) : context.getResources().getColorStateList(i2);
    }

    public static Drawable b(Context context, int i2) {
        return n0.d().f(context, i2);
    }
}
