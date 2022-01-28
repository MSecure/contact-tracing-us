package b.r.d;

import androidx.recyclerview.widget.RecyclerView;

public final class b implements w {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.e f2296a;

    public b(RecyclerView.e eVar) {
        this.f2296a = eVar;
    }

    @Override // b.r.d.w
    public void a(int i, int i2) {
        this.f2296a.notifyItemRangeRemoved(i, i2);
    }

    @Override // b.r.d.w
    public void b(int i, int i2) {
        this.f2296a.notifyItemRangeInserted(i, i2);
    }

    @Override // b.r.d.w
    public void c(int i, int i2) {
        this.f2296a.notifyItemMoved(i, i2);
    }

    @Override // b.r.d.w
    public void d(int i, int i2, Object obj) {
        this.f2296a.notifyItemRangeChanged(i, i2, obj);
    }
}
