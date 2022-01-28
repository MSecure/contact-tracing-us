package b.q.d;

import androidx.recyclerview.widget.RecyclerView;

public final class b implements w {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.g f1456a;

    public b(RecyclerView.g gVar) {
        this.f1456a = gVar;
    }

    @Override // b.q.d.w
    public void a(int i, int i2) {
        this.f1456a.notifyItemRangeRemoved(i, i2);
    }

    @Override // b.q.d.w
    public void b(int i, int i2) {
        this.f1456a.notifyItemRangeInserted(i, i2);
    }

    @Override // b.q.d.w
    public void c(int i, int i2) {
        this.f1456a.notifyItemMoved(i, i2);
    }

    @Override // b.q.d.w
    public void d(int i, int i2, Object obj) {
        this.f1456a.notifyItemRangeChanged(i, i2, obj);
    }
}
