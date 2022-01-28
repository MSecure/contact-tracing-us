package f.b.a.a.a.t;

import android.view.ViewTreeObserver;

public final /* synthetic */ class y implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ i0 b;

    public /* synthetic */ y(i0 i0Var) {
        this.b = i0Var;
    }

    public final void onGlobalLayout() {
        i0 i0Var = this.b;
        if (i0Var.e0.getMeasuredHeight() >= i0Var.e0.getChildAt(0).getHeight()) {
            i0Var.C0(true);
        }
    }
}
