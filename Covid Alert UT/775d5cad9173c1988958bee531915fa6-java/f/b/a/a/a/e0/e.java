package f.b.a.a.a.e0;

import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import java.util.Objects;

public final /* synthetic */ class e implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ d0 b;
    public final /* synthetic */ NestedScrollView c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f2199d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Button f2200e;

    public /* synthetic */ e(d0 d0Var, NestedScrollView nestedScrollView, LinearLayout linearLayout, Button button) {
        this.b = d0Var;
        this.c = nestedScrollView;
        this.f2199d = linearLayout;
        this.f2200e = button;
    }

    public final void onGlobalLayout() {
        d0 d0Var = this.b;
        NestedScrollView nestedScrollView = this.c;
        LinearLayout linearLayout = this.f2199d;
        Button button = this.f2200e;
        Objects.requireNonNull(d0Var);
        if (nestedScrollView.getMeasuredHeight() >= nestedScrollView.getChildAt(0).getHeight()) {
            d0Var.K0(nestedScrollView, linearLayout, button, true);
        }
    }
}
