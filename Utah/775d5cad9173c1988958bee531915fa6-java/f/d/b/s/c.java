package f.d.b.s;

import androidx.recyclerview.widget.RecyclerView;
import f.d.b.b;
import f.d.b.f;
import f.d.b.k;
import j.k.b.e;
import java.util.ArrayList;
import java.util.List;

public class c<Item extends k<? extends RecyclerView.b0>> extends b<Item> {
    public List<Item> b;

    public c(List list, int i2) {
        ArrayList arrayList = (i2 & 1) != 0 ? new ArrayList() : null;
        e.c(arrayList, "_items");
        this.b = arrayList;
    }

    @Override // f.d.b.l
    public void a(List<? extends Item> list, int i2) {
        e.c(list, "items");
        int size = this.b.size();
        this.b.addAll(list);
        b<Item> bVar = this.a;
        if (bVar != null) {
            bVar.t(i2 + size, list.size());
        }
    }

    @Override // f.d.b.l
    public void b(List<? extends Item> list, int i2, f fVar) {
        e.c(list, "items");
        int size = list.size();
        int size2 = this.b.size();
        List<Item> list2 = this.b;
        if (list != list2) {
            if (!list2.isEmpty()) {
                this.b.clear();
            }
            this.b.addAll(list);
        }
        b<Item> bVar = this.a;
        if (bVar != null) {
            if (fVar == null) {
                fVar = f.a;
            }
            fVar.a(bVar, size, size2, i2);
        }
    }

    @Override // f.d.b.l
    public List<Item> c() {
        return this.b;
    }

    @Override // f.d.b.l
    public void d(int i2) {
        int size = this.b.size();
        this.b.clear();
        b<Item> bVar = this.a;
        if (bVar != null) {
            bVar.u(i2, size);
        }
    }

    @Override // f.d.b.l
    public Item get(int i2) {
        return this.b.get(i2);
    }

    @Override // f.d.b.l
    public int size() {
        return this.b.size();
    }
}
