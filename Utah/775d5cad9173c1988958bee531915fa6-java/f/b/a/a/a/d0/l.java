package f.b.a.a.a.d0;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.widget.NestedScrollView;
import java.util.Objects;

public final /* synthetic */ class l implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ q5 b;
    public final /* synthetic */ NestedScrollView c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2182d;

    public /* synthetic */ l(q5 q5Var, NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        this.b = q5Var;
        this.c = nestedScrollView;
        this.f2182d = viewGroup;
    }

    public final void onGlobalLayout() {
        q5 q5Var = this.b;
        NestedScrollView nestedScrollView = this.c;
        ViewGroup viewGroup = this.f2182d;
        Objects.requireNonNull(q5Var);
        if (nestedScrollView.getMeasuredHeight() >= nestedScrollView.getChildAt(0).getHeight()) {
            q5Var.S0(viewGroup, true);
        }
    }
}
