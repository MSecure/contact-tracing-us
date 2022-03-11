package e.s.a;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public abstract class y extends RecyclerView.p {
    public RecyclerView a;
    public final RecyclerView.r b = new a();

    public class a extends RecyclerView.r {
        public boolean a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void a(RecyclerView recyclerView, int i2) {
            if (i2 == 0 && this.a) {
                this.a = false;
                y.this.d();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void b(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.a = true;
            }
        }
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                RecyclerView.r rVar = this.b;
                List<RecyclerView.r> list = recyclerView2.k0;
                if (list != null) {
                    list.remove(rVar);
                }
                this.a.setOnFlingListener(null);
            }
            this.a = recyclerView;
            if (recyclerView == null) {
                return;
            }
            if (recyclerView.getOnFlingListener() == null) {
                this.a.h(this.b);
                this.a.setOnFlingListener(this);
                new Scroller(this.a.getContext(), new DecelerateInterpolator());
                d();
                return;
            }
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
    }

    public abstract int[] b(RecyclerView.m mVar, View view);

    public abstract View c(RecyclerView.m mVar);

    public void d() {
        RecyclerView.m layoutManager;
        View c;
        RecyclerView recyclerView = this.a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (c = c(layoutManager)) != null) {
            int[] b2 = b(layoutManager, c);
            if (b2[0] != 0 || b2[1] != 0) {
                this.a.l0(b2[0], b2[1], null, Integer.MIN_VALUE, false);
            }
        }
    }
}
