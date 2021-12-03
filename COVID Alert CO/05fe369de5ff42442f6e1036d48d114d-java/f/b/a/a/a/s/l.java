package f.b.a.a.a.s;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.widget.NestedScrollView;
import java.util.Objects;

public final /* synthetic */ class l implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ r5 b;
    public final /* synthetic */ NestedScrollView c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2377d;

    public /* synthetic */ l(r5 r5Var, NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        this.b = r5Var;
        this.c = nestedScrollView;
        this.f2377d = viewGroup;
    }

    public final void onGlobalLayout() {
        r5 r5Var = this.b;
        NestedScrollView nestedScrollView = this.c;
        ViewGroup viewGroup = this.f2377d;
        Objects.requireNonNull(r5Var);
        if (nestedScrollView.getMeasuredHeight() >= nestedScrollView.getChildAt(0).getHeight()) {
            r5Var.M0(viewGroup, true);
        }
    }
}
