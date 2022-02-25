package f.d.b.p;

import androidx.recyclerview.widget.RecyclerView;
import f.d.b.a;
import f.d.b.i;
import f.d.b.k;
import f.d.b.l;
import j.h.d;
import j.j.a.b;
import j.j.b.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class c<Model, Item extends k<? extends RecyclerView.b0>> extends a<Item> implements Object<Model, Item> {
    public boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    public i<Item> f3476d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3477e;

    /* renamed from: f  reason: collision with root package name */
    public b<Model, Item> f3478f;

    /* renamed from: g  reason: collision with root package name */
    public final l<Item> f3479g;

    /* renamed from: h  reason: collision with root package name */
    public b<? super Model, ? extends Item> f3480h;

    public c(b<? super Model, ? extends Item> bVar) {
        e.c(bVar, "interceptor");
        f.d.b.s.c cVar = new f.d.b.s.c(null, 1);
        e.c(cVar, "itemList");
        e.c(bVar, "interceptor");
        this.f3479g = cVar;
        this.f3480h = bVar;
        i<Item> iVar = (i<Item>) i.a;
        Objects.requireNonNull(iVar, "null cannot be cast to non-null type com.mikepenz.fastadapter.IIdDistributor<Item>");
        this.f3476d = iVar;
        this.f3477e = true;
        this.f3478f = new b<>(this);
    }

    @Override // f.d.b.c
    public Item a(int i2) {
        Item item = this.f3479g.get(i2);
        if (item != null) {
            return item;
        }
        throw new RuntimeException("A normal ModelAdapter does not allow null items.");
    }

    @Override // f.d.b.c
    public int c() {
        if (this.c) {
            return this.f3479g.size();
        }
        return 0;
    }

    public c<Model, Item> d(List<? extends Model> list) {
        e.c(list, "items");
        e.c(list, "models");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            k kVar = (k) this.f3480h.d(it.next());
            if (kVar != null) {
                arrayList.add(kVar);
            }
        }
        e.c(arrayList, "items");
        if (this.f3477e) {
            this.f3476d.a(arrayList);
        }
        f.d.b.b<Item> bVar = this.a;
        if (bVar != null) {
            this.f3479g.a(arrayList, bVar.t(this.b));
        } else {
            this.f3479g.a(arrayList, 0);
        }
        return this;
    }

    @SafeVarargs
    public c<Model, Item> e(Model... modelArr) {
        List<? extends Model> list;
        e.c(modelArr, "items");
        Object[] copyOf = Arrays.copyOf(modelArr, modelArr.length);
        e.c(copyOf, "elements");
        if (copyOf.length > 0) {
            e.c(copyOf, "$this$asList");
            list = Arrays.asList(copyOf);
            e.b(list, "ArraysUtilJVM.asList(this)");
        } else {
            list = d.b;
        }
        d(list);
        return this;
    }

    public void f(f.d.b.b<Item> bVar) {
        l<Item> lVar = this.f3479g;
        if (lVar instanceof f.d.b.s.b) {
            Objects.requireNonNull(lVar, "null cannot be cast to non-null type com.mikepenz.fastadapter.utils.DefaultItemList<Item>");
            ((f.d.b.s.b) lVar).a = bVar;
        }
        this.a = bVar;
    }
}
