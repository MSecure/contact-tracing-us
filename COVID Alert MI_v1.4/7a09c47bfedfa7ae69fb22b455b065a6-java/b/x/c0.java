package b.x;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.Field;

public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static Field f2658a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2659b;

    public abstract void a(View view);

    public abstract float b(View view);

    public abstract void c(View view);

    public abstract void d(View view, int i, int i2, int i3, int i4);

    public abstract void e(View view, float f2);

    public void f(View view, int i) {
        if (!f2659b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f2658a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2659b = true;
        }
        Field field = f2658a;
        if (field != null) {
            try {
                f2658a.setInt(view, i | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void g(View view, Matrix matrix);

    public abstract void h(View view, Matrix matrix);
}
