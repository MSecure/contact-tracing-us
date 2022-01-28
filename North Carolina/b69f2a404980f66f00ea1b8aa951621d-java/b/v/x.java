package b.v;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

public class x extends w {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1835d = true;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f1836e = true;

    @Override // b.v.b0
    @SuppressLint({"NewApi"})
    public void g(View view, Matrix matrix) {
        if (f1835d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f1835d = false;
            }
        }
    }

    @Override // b.v.b0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (f1836e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f1836e = false;
            }
        }
    }
}
