package c.b.a.b.i0;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class l implements SwipeDismissBehavior.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3044a;

    public l(BaseTransientBottomBar baseTransientBottomBar) {
        this.f3044a = baseTransientBottomBar;
    }

    public void a(View view) {
        view.setVisibility(8);
        this.f3044a.a(0);
    }
}
