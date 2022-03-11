package e.w;

import android.graphics.Matrix;
import android.view.View;

public class u extends t {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1966f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f1967g = true;

    @Override // e.w.y
    public void g(View view, Matrix matrix) {
        if (f1966f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f1966f = false;
            }
        }
    }

    @Override // e.w.y
    public void h(View view, Matrix matrix) {
        if (f1967g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f1967g = false;
            }
        }
    }
}
