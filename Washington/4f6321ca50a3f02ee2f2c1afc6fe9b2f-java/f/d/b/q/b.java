package f.d.b.q;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import f.d.b.k;
import f.d.b.m;
import j.j.b.e;
import java.util.List;

public abstract class b<VH extends RecyclerView.b0> implements k<VH> {
    public long a = -1;

    @Override // f.d.b.k
    public m<VH> a() {
        return null;
    }

    @Override // f.d.b.j
    public void b(long j2) {
        this.a = j2;
    }

    @Override // f.d.b.k
    public void c(VH vh) {
        e.c(vh, "holder");
    }

    @Override // f.d.b.k
    public boolean d(VH vh) {
        e.c(vh, "holder");
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || (!e.a(getClass(), obj.getClass()))) {
            return false;
        }
        if (!(obj instanceof b)) {
            obj = null;
        }
        b bVar = (b) obj;
        return bVar != null && this.a == bVar.a;
    }

    @Override // f.d.b.j
    public long f() {
        return this.a;
    }

    @Override // f.d.b.k
    public void g(VH vh, List<? extends Object> list) {
        e.c(vh, "holder");
        e.c(list, "payloads");
        View view = vh.a;
        e.b(view, "holder.itemView");
        view.setSelected(false);
    }

    public int hashCode() {
        return Long.valueOf(this.a).hashCode();
    }

    @Override // f.d.b.k
    public void i(VH vh) {
        e.c(vh, "holder");
    }

    @Override // f.d.b.k
    public boolean isEnabled() {
        return true;
    }

    @Override // f.d.b.k
    public void j(VH vh) {
        e.c(vh, "holder");
    }
}
