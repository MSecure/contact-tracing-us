package b.q.d;

import android.view.View;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

public abstract class d0 extends RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f1481a;

    /* renamed from: b  reason: collision with root package name */
    public Scroller f1482b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView.t f1483c = new a();

    public class a extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1484a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            if (i == 0 && this.f1484a) {
                this.f1484a = false;
                d0.this.c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f1484a = true;
            }
        }
    }

    public abstract int[] a(RecyclerView.o oVar, View view);

    public abstract View b(RecyclerView.o oVar);

    public void c() {
        RecyclerView.o layoutManager;
        View b2;
        RecyclerView recyclerView = this.f1481a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (b2 = b(layoutManager)) != null) {
            int[] a2 = a(layoutManager, b2);
            if (a2[0] != 0 || a2[1] != 0) {
                this.f1481a.smoothScrollBy(a2[0], a2[1]);
            }
        }
    }
}
