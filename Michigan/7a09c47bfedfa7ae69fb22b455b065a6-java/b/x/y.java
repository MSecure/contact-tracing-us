package b.x;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

public class y extends x {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f2729d = true;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2730e = true;

    @Override // b.x.c0
    @SuppressLint({"NewApi"})
    public void g(View view, Matrix matrix) {
        if (f2729d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f2729d = false;
            }
        }
    }

    @Override // b.x.c0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (f2730e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f2730e = false;
            }
        }
    }
}
