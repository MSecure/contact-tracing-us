package f.b.a.a.a.s;

import android.view.ViewTreeObserver;

public final /* synthetic */ class q implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ a0 b;

    public /* synthetic */ q(a0 a0Var) {
        this.b = a0Var;
    }

    public final void onGlobalLayout() {
        a0 a0Var = this.b;
        if (a0Var.e0.getMeasuredHeight() >= a0Var.e0.getChildAt(0).getHeight()) {
            a0Var.z0(true);
        }
    }
}
