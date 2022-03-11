package f.d.b.p;

import androidx.recyclerview.widget.RecyclerView;
import f.d.b.a;
import f.d.b.i;
import f.d.b.k;
import f.d.b.l;
import j.i.d;
import j.k.a.b;
import j.k.b.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class c<Model, Item extends k<? extends RecyclerView.b0>> extends a<Item> implements Object<Model, Item> {

    /* renamed from: d */
    public i<Item> f4053d;

    /* renamed from: g */
    public final l<Item> f4056g;

    /* renamed from: h */
    public b<? super Model, ? extends Item> f4057h;
    public boolean c = true;

    /* renamed from: e */
    public boolean f4054e = true;

    /* renamed from: f */
    public b<Model, Item> f4055f = new b<>(this);

    public c(b<? super Model, ? extends Item> bVar) {
        e.c(bVar, "interceptor");
        f.d.b.s.c cVar = new f.d.b.s.c(null, 1);
        e.c(cVar, "itemList");
        e.c(bVar, "interceptor");
        this.f4056g = cVar;
        this.f4057h = bVar;
        i<Item> iVar = (i<Item>) i.a;
        Objects.requireNonNull(iVar, "null cannot be cast to non-null type com.mikepenz.fastadapter.IIdDistributor<Item>");
        this.f4053d = iVar;
    }

    @Override // f.d.b.c
    public Item a(int i2) {
        Item item = this.f4056g.get(i2);
        if (item != null) {
            return item;
        }
        throw new RuntimeException("A normal ModelAdapter does not allow null items.");
    }

    @Override // f.d.b.c
    public int c() {
        if (this.c) {
            return this.f4056g.size();
        }
        return 0;
    }

    public c<Model, Item> d(List<? extends Model> list) {
        e.c(list, "items");
        e.c(list, "models");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            k kVar = (k) this.f4057h.d(it.next());
            if (kVar != null) {
                arrayList.add(kVar);
            }
        }
        e.c(arrayList, "items");
        if (this.f4054e) {
            this.f4053d.a(arrayList);
        }
        f.d.b.b<Item> bVar = this.a;
        if (bVar != null) {
            this.f4056g.a(arrayList, bVar.q(this.b));
        } else {
            this.f4056g.a(arrayList, 0);
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
        l<Item> lVar = this.f4056g;
        if (lVar instanceof f.d.b.s.b) {
            Objects.requireNonNull(lVar, "null cannot be cast to non-null type com.mikepenz.fastadapter.utils.DefaultItemList<Item>");
            ((f.d.b.s.b) lVar).a = bVar;
        }
        this.a = bVar;
    }
}
