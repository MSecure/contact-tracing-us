package f.d.b;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.R$id;
import e.e.g;
import f.d.b.k;
import f.d.b.r.f;
import f.d.b.r.g;
import f.d.b.r.h;
import f.d.b.r.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class b<Item extends k<? extends RecyclerView.b0>> extends RecyclerView.e<RecyclerView.b0> {
    public static final a p = new a(null);
    public final ArrayList<c<Item>> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public n<m<?>> f3467d = new f.d.b.s.d();

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<c<Item>> f3468e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public int f3469f;

    /* renamed from: g  reason: collision with root package name */
    public List<f.d.b.r.c<? extends Item>> f3470g;

    /* renamed from: h  reason: collision with root package name */
    public final e.e.a<Class<?>, d<Item>> f3471h = new e.e.a<>();

    /* renamed from: i  reason: collision with root package name */
    public boolean f3472i = true;

    /* renamed from: j  reason: collision with root package name */
    public final o f3473j = new o("FastAdapter");

    /* renamed from: k  reason: collision with root package name */
    public g<Item> f3474k = new h();

    /* renamed from: l  reason: collision with root package name */
    public f.d.b.r.e f3475l = new f();
    public final f.d.b.r.a<Item> m = new c();
    public final f.d.b.r.d<Item> n = new d();
    public final i<Item> o = new e();

    public static final class a {
        public a(j.j.b.c cVar) {
        }
    }

    /* renamed from: f.d.b.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0130b<Item extends k<? extends RecyclerView.b0>> extends RecyclerView.b0 {
        public abstract void w(Item item, List<? extends Object> list);

        public abstract void x(Item item);
    }

    public static final class c extends f.d.b.r.a<Item> {
        @Override // f.d.b.r.a
        public void c(View view, int i2, b<Item> bVar, Item item) {
            c<Item> q;
            g.a aVar;
            j.j.a.d<View, c<Item>, Item, Integer, Boolean> a;
            j.j.a.d<View, c<Item>, Item, Integer, Boolean> b;
            j.j.b.e.c(view, "v");
            j.j.b.e.c(bVar, "fastAdapter");
            j.j.b.e.c(item, "item");
            if (item.isEnabled() && (q = bVar.q(i2)) != null) {
                boolean z = item instanceof g;
                g gVar = null;
                g gVar2 = (g) (!z ? null : item);
                if (gVar2 == null || (b = gVar2.b()) == null || !b.a(view, q, item, Integer.valueOf(i2)).booleanValue()) {
                    Iterator it = ((g.e) bVar.f3471h.values()).iterator();
                    do {
                        aVar = (g.a) it;
                        if (!aVar.hasNext()) {
                            if (z) {
                                gVar = item;
                            }
                            g gVar3 = gVar;
                            if (gVar3 != null && (a = gVar3.a()) != null) {
                                a.a(view, q, item, Integer.valueOf(i2)).booleanValue();
                                return;
                            }
                            return;
                        }
                    } while (!((d) aVar.next()).c(view, i2, bVar, item));
                }
            }
        }
    }

    public static final class d extends f.d.b.r.d<Item> {
        @Override // f.d.b.r.d
        public boolean c(View view, int i2, b<Item> bVar, Item item) {
            g.a aVar;
            j.j.b.e.c(view, "v");
            j.j.b.e.c(bVar, "fastAdapter");
            j.j.b.e.c(item, "item");
            if (item.isEnabled() && bVar.q(i2) != null) {
                Iterator it = ((g.e) bVar.f3471h.values()).iterator();
                do {
                    aVar = (g.a) it;
                    if (aVar.hasNext()) {
                    }
                } while (!((d) aVar.next()).f(view, i2, bVar, item));
                return true;
            }
            return false;
        }
    }

    public static final class e extends i<Item> {
        @Override // f.d.b.r.i
        public boolean c(View view, MotionEvent motionEvent, int i2, b<Item> bVar, Item item) {
            g.a aVar;
            j.j.b.e.c(view, "v");
            j.j.b.e.c(motionEvent, "event");
            j.j.b.e.c(bVar, "fastAdapter");
            j.j.b.e.c(item, "item");
            Iterator it = ((g.e) bVar.f3471h.values()).iterator();
            do {
                aVar = (g.a) it;
                if (!aVar.hasNext()) {
                    return false;
                }
            } while (!((d) aVar.next()).a(view, motionEvent, i2, bVar, item));
            return true;
        }
    }

    public b() {
        o(true);
    }

    public static void v(b bVar, int i2, int i3, Object obj, int i4, Object obj2) {
        int i5 = i4 & 4;
        Iterator it = ((g.e) bVar.f3471h.values()).iterator();
        while (true) {
            g.a aVar = (g.a) it;
            if (aVar.hasNext()) {
                ((d) aVar.next()).d(i2, i3, null);
            } else {
                bVar.a.c(i2, i3, null);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int c() {
        return this.f3469f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long d(int i2) {
        Item s = s(i2);
        if (s != null) {
            return s.f();
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int e(int i2) {
        Item s = s(i2);
        if (s == null) {
            return 0;
        }
        if (!this.f3467d.b(s.h())) {
            j.j.b.e.c(s, "item");
            if (s instanceof m) {
                int h2 = s.h();
                m<?> mVar = (m) s;
                j.j.b.e.c(mVar, "item");
                this.f3467d.a(h2, mVar);
            } else {
                m<?> a2 = s.a();
                if (a2 != null) {
                    int h3 = s.h();
                    j.j.b.e.c(a2, "item");
                    this.f3467d.a(h3, a2);
                }
            }
        }
        return s.h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void f(RecyclerView recyclerView) {
        j.j.b.e.c(recyclerView, "recyclerView");
        Objects.requireNonNull(this.f3473j);
        j.j.b.e.c("onAttachedToRecyclerView", "message");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void g(RecyclerView.b0 b0Var, int i2) {
        j.j.b.e.c(b0Var, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void h(RecyclerView.b0 b0Var, int i2, List<? extends Object> list) {
        j.j.b.e.c(b0Var, "holder");
        j.j.b.e.c(list, "payloads");
        Objects.requireNonNull(this.f3473j);
        b0Var.a.setTag(R$id.fastadapter_item_adapter, this);
        this.f3475l.b(b0Var, i2, list);
        j.j.b.e.c(b0Var, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.b0 i(ViewGroup viewGroup, int i2) {
        j.j.b.e.c(viewGroup, "parent");
        Objects.requireNonNull(this.f3473j);
        j.j.b.e.c("onCreateViewHolder: " + i2, "message");
        m<?> mVar = this.f3467d.get(i2);
        RecyclerView.b0 a2 = this.f3474k.a(this, viewGroup, i2, mVar);
        a2.a.setTag(R$id.fastadapter_item_adapter, this);
        if (this.f3472i) {
            f.d.b.r.a<Item> aVar = this.m;
            View view = a2.a;
            j.j.b.e.b(view, "holder.itemView");
            f.b.a.c.b.o.b.i(aVar, a2, view);
            f.d.b.r.d<Item> dVar = this.n;
            View view2 = a2.a;
            j.j.b.e.b(view2, "holder.itemView");
            f.b.a.c.b.o.b.i(dVar, a2, view2);
            i<Item> iVar = this.o;
            View view3 = a2.a;
            j.j.b.e.b(view3, "holder.itemView");
            f.b.a.c.b.o.b.i(iVar, a2, view3);
        }
        return this.f3474k.b(this, a2, mVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void j(RecyclerView recyclerView) {
        j.j.b.e.c(recyclerView, "recyclerView");
        Objects.requireNonNull(this.f3473j);
        j.j.b.e.c("onDetachedFromRecyclerView", "message");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public boolean k(RecyclerView.b0 b0Var) {
        j.j.b.e.c(b0Var, "holder");
        o oVar = this.f3473j;
        StringBuilder h2 = f.a.a.a.a.h("onFailedToRecycleView: ");
        h2.append(b0Var.f214f);
        String sb = h2.toString();
        Objects.requireNonNull(oVar);
        j.j.b.e.c(sb, "message");
        return this.f3475l.c(b0Var, b0Var.e());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void l(RecyclerView.b0 b0Var) {
        j.j.b.e.c(b0Var, "holder");
        o oVar = this.f3473j;
        StringBuilder h2 = f.a.a.a.a.h("onViewAttachedToWindow: ");
        h2.append(b0Var.f214f);
        String sb = h2.toString();
        Objects.requireNonNull(oVar);
        j.j.b.e.c(sb, "message");
        this.f3475l.a(b0Var, b0Var.e());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void m(RecyclerView.b0 b0Var) {
        j.j.b.e.c(b0Var, "holder");
        o oVar = this.f3473j;
        StringBuilder h2 = f.a.a.a.a.h("onViewDetachedFromWindow: ");
        h2.append(b0Var.f214f);
        String sb = h2.toString();
        Objects.requireNonNull(oVar);
        j.j.b.e.c(sb, "message");
        this.f3475l.e(b0Var, b0Var.e());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void n(RecyclerView.b0 b0Var) {
        j.j.b.e.c(b0Var, "holder");
        o oVar = this.f3473j;
        StringBuilder h2 = f.a.a.a.a.h("onViewRecycled: ");
        h2.append(b0Var.f214f);
        String sb = h2.toString();
        Objects.requireNonNull(oVar);
        j.j.b.e.c(sb, "message");
        this.f3475l.d(b0Var, b0Var.e());
    }

    public final void p() {
        this.f3468e.clear();
        Iterator<c<Item>> it = this.c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            c<Item> next = it.next();
            if (next.c() > 0) {
                this.f3468e.append(i2, next);
                i2 += next.c();
            }
        }
        if (i2 == 0 && this.c.size() > 0) {
            this.f3468e.append(0, this.c.get(0));
        }
        this.f3469f = i2;
    }

    public c<Item> q(int i2) {
        if (i2 < 0 || i2 >= this.f3469f) {
            return null;
        }
        Objects.requireNonNull(this.f3473j);
        j.j.b.e.c("getAdapter", "message");
        SparseArray<c<Item>> sparseArray = this.f3468e;
        int indexOfKey = sparseArray.indexOfKey(i2);
        if (indexOfKey < 0) {
            indexOfKey = (~indexOfKey) - 1;
        }
        return sparseArray.valueAt(indexOfKey);
    }

    public int r(RecyclerView.b0 b0Var) {
        j.j.b.e.c(b0Var, "holder");
        return b0Var.e();
    }

    public Item s(int i2) {
        if (i2 < 0 || i2 >= this.f3469f) {
            return null;
        }
        int indexOfKey = this.f3468e.indexOfKey(i2);
        if (indexOfKey < 0) {
            indexOfKey = (~indexOfKey) - 1;
        }
        return this.f3468e.valueAt(indexOfKey).a(i2 - this.f3468e.keyAt(indexOfKey));
    }

    public int t(int i2) {
        if (this.f3469f == 0) {
            return 0;
        }
        int min = Math.min(i2, this.c.size());
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            i3 += this.c.get(i4).c();
        }
        return i3;
    }

    public void u() {
        Iterator it = ((g.e) this.f3471h.values()).iterator();
        while (true) {
            g.a aVar = (g.a) it;
            if (aVar.hasNext()) {
                ((d) aVar.next()).h();
            } else {
                p();
                this.a.b();
                return;
            }
        }
    }

    public void w(int i2, int i3) {
        Iterator it = ((g.e) this.f3471h.values()).iterator();
        while (true) {
            g.a aVar = (g.a) it;
            if (aVar.hasNext()) {
                ((d) aVar.next()).b(i2, i3);
            } else {
                p();
                this.a.d(i2, i3);
                return;
            }
        }
    }

    public void x(int i2, int i3) {
        Iterator it = ((g.e) this.f3471h.values()).iterator();
        while (true) {
            g.a aVar = (g.a) it;
            if (aVar.hasNext()) {
                ((d) aVar.next()).g(i2, i3);
            } else {
                p();
                this.a.e(i2, i3);
                return;
            }
        }
    }
}
