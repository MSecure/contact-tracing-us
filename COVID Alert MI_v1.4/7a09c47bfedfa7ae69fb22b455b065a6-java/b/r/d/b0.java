package b.r.d;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.f;

public class b0 implements f.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2297a;

    public b0(RecyclerView recyclerView) {
        this.f2297a = recyclerView;
    }

    public View a(int i) {
        return this.f2297a.getChildAt(i);
    }

    public int b() {
        return this.f2297a.getChildCount();
    }

    public void c(int i) {
        View childAt = this.f2297a.getChildAt(i);
        if (childAt != null) {
            this.f2297a.p(childAt);
            childAt.clearAnimation();
        }
        this.f2297a.removeViewAt(i);
    }
}
