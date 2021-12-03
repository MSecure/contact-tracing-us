package f.b.a.a.a.d0;

import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import java.util.Objects;

public final /* synthetic */ class f implements NestedScrollView.b {
    public final /* synthetic */ q5 a;
    public final /* synthetic */ NestedScrollView b;
    public final /* synthetic */ ViewGroup c;

    public /* synthetic */ f(q5 q5Var, NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        this.a = q5Var;
        this.b = nestedScrollView;
        this.c = viewGroup;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public final void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        q5 q5Var = this.a;
        NestedScrollView nestedScrollView2 = this.b;
        ViewGroup viewGroup = this.c;
        Objects.requireNonNull(q5Var);
        if (nestedScrollView2.getChildAt(0).getBottom() <= nestedScrollView2.getScrollY() + nestedScrollView2.getHeight()) {
            q5Var.S0(viewGroup, true);
        } else {
            q5Var.S0(viewGroup, false);
        }
    }
}
