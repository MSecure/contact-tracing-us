package e.y;

import android.graphics.Matrix;
import android.view.View;

public class u extends t {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f2059f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f2060g = true;

    @Override // e.y.y
    public void g(View view, Matrix matrix) {
        if (f2059f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f2059f = false;
            }
        }
    }

    @Override // e.y.y
    public void h(View view, Matrix matrix) {
        if (f2060g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f2060g = false;
            }
        }
    }
}
