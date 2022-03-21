package f.b.a.a.a.q;

import androidx.core.widget.NestedScrollView;

public final /* synthetic */ class p implements NestedScrollView.b {
    public final /* synthetic */ a0 a;

    public /* synthetic */ p(a0 a0Var) {
        this.a = a0Var;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public final void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        a0 a0Var = this.a;
        if (a0Var.c0.getChildAt(0).getBottom() <= a0Var.c0.getScrollY() + a0Var.c0.getHeight()) {
            a0Var.z0(true);
        } else {
            a0Var.z0(false);
        }
    }
}
