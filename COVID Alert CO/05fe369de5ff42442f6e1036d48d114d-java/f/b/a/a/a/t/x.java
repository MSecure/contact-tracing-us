package f.b.a.a.a.t;

import androidx.core.widget.NestedScrollView;

public final /* synthetic */ class x implements NestedScrollView.b {
    public final /* synthetic */ i0 a;

    public /* synthetic */ x(i0 i0Var) {
        this.a = i0Var;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public final void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        i0 i0Var = this.a;
        if (i0Var.e0.getChildAt(0).getBottom() <= i0Var.e0.getScrollY() + i0Var.e0.getHeight()) {
            i0Var.C0(true);
        } else {
            i0Var.C0(false);
        }
    }
}
