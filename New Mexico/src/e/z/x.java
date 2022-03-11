package e.z;

import android.graphics.Matrix;
import android.view.View;
/* loaded from: classes.dex */
public class x extends w {
    @Override // e.z.t, e.z.y
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // e.z.v, e.z.y
    public void d(View view, int i2, int i3, int i4, int i5) {
        view.setLeftTopRightBottom(i2, i3, i4, i5);
    }

    @Override // e.z.t, e.z.y
    public void e(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // e.z.w, e.z.y
    public void f(View view, int i2) {
        view.setTransitionVisibility(i2);
    }

    @Override // e.z.u, e.z.y
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // e.z.u, e.z.y
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
