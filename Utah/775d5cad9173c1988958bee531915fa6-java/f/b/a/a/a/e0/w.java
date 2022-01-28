package f.b.a.a.a.e0;

import androidx.core.widget.NestedScrollView;

public final /* synthetic */ class w implements NestedScrollView.b {
    public final /* synthetic */ k0 a;

    public /* synthetic */ w(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public final void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        k0 k0Var = this.a;
        if (k0Var.f0.getChildAt(0).getBottom() <= k0Var.f0.getScrollY() + k0Var.f0.getHeight()) {
            k0Var.I0(true);
        } else {
            k0Var.I0(false);
        }
    }
}
