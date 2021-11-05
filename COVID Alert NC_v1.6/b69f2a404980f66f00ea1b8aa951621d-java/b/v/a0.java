package b.v;

import android.graphics.Matrix;
import android.view.View;

public class a0 extends z {
    @Override // b.v.w, b.v.b0
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // b.v.b0, b.v.y
    public void d(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // b.v.w, b.v.b0
    public void e(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // b.v.b0, b.v.z
    public void f(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // b.v.b0, b.v.x
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // b.v.b0, b.v.x
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
