package f.b.a.a.a.s;

import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import java.util.Objects;

public final /* synthetic */ class f implements NestedScrollView.b {
    public final /* synthetic */ r5 a;
    public final /* synthetic */ NestedScrollView b;
    public final /* synthetic */ ViewGroup c;

    public /* synthetic */ f(r5 r5Var, NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        this.a = r5Var;
        this.b = nestedScrollView;
        this.c = viewGroup;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public final void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        r5 r5Var = this.a;
        NestedScrollView nestedScrollView2 = this.b;
        ViewGroup viewGroup = this.c;
        Objects.requireNonNull(r5Var);
        if (nestedScrollView2.getChildAt(0).getBottom() <= nestedScrollView2.getScrollY() + nestedScrollView2.getHeight()) {
            r5Var.M0(viewGroup, true);
        } else {
            r5Var.M0(viewGroup, false);
        }
    }
}
