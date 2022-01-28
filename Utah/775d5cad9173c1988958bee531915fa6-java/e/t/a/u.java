package e.t.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import e.t.a.b;

public class u implements b.AbstractC0055b {
    public final /* synthetic */ RecyclerView a;

    public u(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public View a(int i2) {
        return this.a.getChildAt(i2);
    }

    public int b() {
        return this.a.getChildCount();
    }

    public void c(int i2) {
        View childAt = this.a.getChildAt(i2);
        if (childAt != null) {
            this.a.p(childAt);
            childAt.clearAnimation();
        }
        this.a.removeViewAt(i2);
    }
}
