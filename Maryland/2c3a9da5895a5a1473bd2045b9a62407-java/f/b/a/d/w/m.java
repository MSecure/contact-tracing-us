package f.b.a.d.w;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class m implements SwipeDismissBehavior.b {
    public final /* synthetic */ BaseTransientBottomBar a;

    public m(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    public void a(View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        this.a.b(0);
    }
}
