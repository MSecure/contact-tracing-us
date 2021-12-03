package f.b.a.a.a.e0;

import android.view.ViewTreeObserver;

public final /* synthetic */ class v implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ k0 b;

    public /* synthetic */ v(k0 k0Var) {
        this.b = k0Var;
    }

    public final void onGlobalLayout() {
        k0 k0Var = this.b;
        if (k0Var.f0.getMeasuredHeight() >= k0Var.f0.getChildAt(0).getHeight()) {
            k0Var.I0(true);
        }
    }
}
