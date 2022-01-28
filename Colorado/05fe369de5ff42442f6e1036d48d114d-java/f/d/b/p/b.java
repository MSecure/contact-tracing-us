package f.d.b.p;

import android.widget.Filter;
import androidx.recyclerview.widget.RecyclerView;
import e.e.g;
import f.d.b.d;
import f.d.b.k;
import j.k.b.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class b<Model, Item extends k<? extends RecyclerView.b0>> extends Filter {
    public List<Item> a;
    public CharSequence b;
    public final c<Model, Item> c;

    public b(c<Model, Item> cVar) {
        e.c(cVar, "itemAdapter");
        this.c = cVar;
    }

    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        boolean z = true;
        if (this.a == null) {
            if (charSequence == null || charSequence.length() == 0) {
                return filterResults;
            }
        }
        f.d.b.b<Item> bVar = this.c.a;
        if (bVar != null) {
            Collection<d<Item>> values = bVar.f3729h.values();
            e.b(values, "extensionsCache.values");
            Iterator it = ((g.e) values).iterator();
            while (true) {
                g.a aVar = (g.a) it;
                if (!aVar.hasNext()) {
                    break;
                }
                ((d) aVar.next()).e(charSequence);
            }
        }
        this.b = charSequence;
        List list = this.a;
        if (list == null) {
            list = new ArrayList(this.c.f3737g.c());
            this.a = list;
        }
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (z) {
            filterResults.values = list;
            filterResults.count = list.size();
            this.a = null;
        } else {
            List<Item> c2 = this.c.f3737g.c();
            filterResults.values = c2;
            filterResults.count = c2.size();
        }
        return filterResults;
    }

    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        e.c(filterResults, "results");
        Object obj = filterResults.values;
        if (obj != null) {
            c<Model, Item> cVar = this.c;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.List<Item>");
            List<? extends Item> list = (List) obj;
            Objects.requireNonNull(cVar);
            e.c(list, "items");
            if (cVar.f3735e) {
                cVar.f3734d.a(list);
            }
            f.d.b.b<Item> bVar = cVar.a;
            int i2 = 0;
            if (bVar != null) {
                Collection<d<Item>> values = bVar.f3729h.values();
                e.b(values, "extensionsCache.values");
                Iterator it = ((g.e) values).iterator();
                while (true) {
                    g.a aVar = (g.a) it;
                    if (!aVar.hasNext()) {
                        break;
                    }
                    ((d) aVar.next()).i(list, false);
                }
            }
            f.d.b.b<Item> bVar2 = cVar.a;
            if (bVar2 != null) {
                i2 = bVar2.q(cVar.b);
            }
            cVar.f3737g.b(list, i2, null);
        }
        List<Item> list2 = this.a;
    }
}
