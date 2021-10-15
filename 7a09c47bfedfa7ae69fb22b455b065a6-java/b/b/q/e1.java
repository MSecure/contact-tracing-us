package b.b.q;

import android.graphics.Rect;
import android.view.View;
import b.i.l.m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class e1 {

    /* renamed from: a  reason: collision with root package name */
    public static Method f829a;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f829a = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                f829a.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public static boolean a(View view) {
        return m.p(view) == 1;
    }

    public static void b(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }
}
