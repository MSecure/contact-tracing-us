package e.b.f;

import android.graphics.Rect;
import android.view.View;
import e.i.i.v;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class i1 {
    public static Method a;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            a = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                a.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public static boolean a(View view) {
        AtomicInteger atomicInteger = v.a;
        return v.e.d(view) == 1;
    }
}
