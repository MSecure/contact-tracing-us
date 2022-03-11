package e.z;

import android.graphics.Matrix;
import android.view.View;
/* loaded from: classes.dex */
public class u extends t {

    /* renamed from: f */
    public static boolean f2144f;

    /* renamed from: g */
    public static boolean f2145g;

    @Override // e.z.y
    public void g(View view, Matrix matrix) {
        if (f2144f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f2144f = false;
            }
        }
    }

    @Override // e.z.y
    public void h(View view, Matrix matrix) {
        if (f2145g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f2145g = false;
            }
        }
    }
}
