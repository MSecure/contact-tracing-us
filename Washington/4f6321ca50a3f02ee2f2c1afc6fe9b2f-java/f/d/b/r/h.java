package f.d.b.r;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import f.d.b.b;
import f.d.b.k;
import f.d.b.m;
import j.j.b.e;
import java.util.LinkedList;
import java.util.List;

public class h<Item extends k<? extends RecyclerView.b0>> implements g<Item> {
    @Override // f.d.b.r.g
    public RecyclerView.b0 a(b<Item> bVar, ViewGroup viewGroup, int i2, m<?> mVar) {
        e.c(bVar, "fastAdapter");
        e.c(viewGroup, "parent");
        e.c(mVar, "itemVHFactory");
        return mVar.e(viewGroup);
    }

    @Override // f.d.b.r.g
    public RecyclerView.b0 b(b<Item> bVar, RecyclerView.b0 b0Var, m<?> mVar) {
        List<c<Item>> a;
        e.c(bVar, "fastAdapter");
        e.c(b0Var, "viewHolder");
        e.c(mVar, "itemVHFactory");
        List list = bVar.f3478g;
        if (list == null) {
            list = new LinkedList();
            bVar.f3478g = list;
        }
        f.b.a.c.b.o.b.l(list, b0Var);
        if (!(mVar instanceof f.d.b.h)) {
            mVar = null;
        }
        f.d.b.h hVar = (f.d.b.h) mVar;
        if (!(hVar == null || (a = hVar.a()) == null)) {
            f.b.a.c.b.o.b.l(a, b0Var);
        }
        return b0Var;
    }
}
