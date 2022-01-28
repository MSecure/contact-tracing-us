package f.b.a.a.a.t;

import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import java.util.Objects;

public final /* synthetic */ class c implements NestedScrollView.b {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ NestedScrollView b;
    public final /* synthetic */ LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Button f2402d;

    public /* synthetic */ c(b0 b0Var, NestedScrollView nestedScrollView, LinearLayout linearLayout, Button button) {
        this.a = b0Var;
        this.b = nestedScrollView;
        this.c = linearLayout;
        this.f2402d = button;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public final void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        b0 b0Var = this.a;
        NestedScrollView nestedScrollView2 = this.b;
        LinearLayout linearLayout = this.c;
        Button button = this.f2402d;
        Objects.requireNonNull(b0Var);
        boolean z = false;
        if (nestedScrollView2.getChildAt(0).getBottom() <= nestedScrollView2.getScrollY() + nestedScrollView2.getHeight()) {
            z = true;
        }
        b0Var.F0(nestedScrollView2, linearLayout, button, z);
    }
}
