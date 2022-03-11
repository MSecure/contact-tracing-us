package e.s.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import e.s.a.b;

public class s implements b.AbstractC0050b {
    public final /* synthetic */ RecyclerView a;

    public s(RecyclerView recyclerView) {
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
