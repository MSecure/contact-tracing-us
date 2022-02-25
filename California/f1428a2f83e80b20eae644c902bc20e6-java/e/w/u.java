package e.w;

import android.graphics.Matrix;
import android.view.View;

public class u extends t {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1934f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f1935g = true;

    @Override // e.w.y
    public void g(View view, Matrix matrix) {
        if (f1934f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f1934f = false;
            }
        }
    }

    @Override // e.w.y
    public void h(View view, Matrix matrix) {
        if (f1935g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f1935g = false;
            }
        }
    }
}
