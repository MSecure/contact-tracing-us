package f.d.b.p;

import android.widget.Filter;
import androidx.recyclerview.widget.RecyclerView;
import e.f.g;
import f.d.b.d;
import f.d.b.k;
import j.k.b.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class b<Model, Item extends k<? extends RecyclerView.b0>> extends Filter {
    public List<Item> a;
    public CharSequence b;
    public final c<Model, Item> c;

    public b(c<Model, Item> cVar) {
        e.c(cVar, "itemAdapter");
        this.c = cVar;
    }

    @Override // android.widget.Filter
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
            Collection<d<Item>> values = bVar.f4048h.values();
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
            list = new ArrayList(this.c.f4056g.c());
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
            List<Item> c = this.c.f4056g.c();
            filterResults.values = c;
            filterResults.count = c.size();
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        e.c(filterResults, "results");
        Object obj = filterResults.values;
        if (obj != null) {
            c<Model, Item> cVar = this.c;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.List<Item>");
            List<? extends Item> list = (List) obj;
            Objects.requireNonNull(cVar);
            e.c(list, "items");
            if (cVar.f4054e) {
                cVar.f4053d.a(list);
            }
            f.d.b.b<Item> bVar = cVar.a;
            int i2 = 0;
            if (bVar != null) {
                Collection<d<Item>> values = bVar.f4048h.values();
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
            cVar.f4056g.b(list, i2, null);
        }
        List<Item> list2 = this.a;
    }
}
