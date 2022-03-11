package e.i.a;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewParent;
/* loaded from: classes.dex */
public class b {
    public static final ThreadLocal<Matrix> a = new ThreadLocal<>();
    public static final ThreadLocal<RectF> b = new ThreadLocal<>();

    public static void a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
