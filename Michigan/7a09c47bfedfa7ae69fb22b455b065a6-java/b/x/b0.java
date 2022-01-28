package b.x;

import android.graphics.Matrix;
import android.view.View;

public class b0 extends a0 {
    @Override // b.x.c0, b.x.x
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // b.x.z, b.x.c0
    public void d(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // b.x.c0, b.x.x
    public void e(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // b.x.c0, b.x.a0
    public void f(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // b.x.c0, b.x.y
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // b.x.c0, b.x.y
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
