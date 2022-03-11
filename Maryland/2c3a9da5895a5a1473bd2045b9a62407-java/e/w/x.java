package e.w;

import android.graphics.Matrix;
import android.view.View;

public class x extends w {
    @Override // e.w.t, e.w.y
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // e.w.v, e.w.y
    public void d(View view, int i2, int i3, int i4, int i5) {
        view.setLeftTopRightBottom(i2, i3, i4, i5);
    }

    @Override // e.w.t, e.w.y
    public void e(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // e.w.w, e.w.y
    public void f(View view, int i2) {
        view.setTransitionVisibility(i2);
    }

    @Override // e.w.u, e.w.y
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // e.w.u, e.w.y
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
