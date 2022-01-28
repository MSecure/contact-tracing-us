package f.b.a.a.a.t;

import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import java.util.Objects;

public final /* synthetic */ class e implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ b0 b;
    public final /* synthetic */ NestedScrollView c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f2403d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Button f2404e;

    public /* synthetic */ e(b0 b0Var, NestedScrollView nestedScrollView, LinearLayout linearLayout, Button button) {
        this.b = b0Var;
        this.c = nestedScrollView;
        this.f2403d = linearLayout;
        this.f2404e = button;
    }

    public final void onGlobalLayout() {
        b0 b0Var = this.b;
        NestedScrollView nestedScrollView = this.c;
        LinearLayout linearLayout = this.f2403d;
        Button button = this.f2404e;
        Objects.requireNonNull(b0Var);
        if (nestedScrollView.getMeasuredHeight() >= nestedScrollView.getChildAt(0).getHeight()) {
            b0Var.F0(nestedScrollView, linearLayout, button, true);
        }
    }
}
