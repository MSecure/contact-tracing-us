package f.d.b;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.R$id;
import e.f.g;
import f.d.b.k;
import f.d.b.r.f;
import f.d.b.r.g;
import f.d.b.r.h;
import f.d.b.r.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class b<Item extends k<? extends RecyclerView.b0>> extends RecyclerView.e<RecyclerView.b0> {
    public static final a p = new a(null);

    /* renamed from: f */
    public int f4046f;

    /* renamed from: g */
    public List<f.d.b.r.c<? extends Item>> f4047g;
    public final ArrayList<c<Item>> c = new ArrayList<>();

    /* renamed from: d */
    public n<m<?>> f4044d = new f.d.b.s.d();

    /* renamed from: e */
    public final SparseArray<c<Item>> f4045e = new SparseArray<>();

    /* renamed from: h */
    public final e.f.a<Class<?>, d<Item>> f4048h = new e.f.a<>();

    /* renamed from: i */
    public boolean f4049i = true;

    /* renamed from: j */
    public final o f4050j = new o("FastAdapter");

    /* renamed from: k */
    public g<Item> f4051k = new h();

    /* renamed from: l */
    public f.d.b.r.e f4052l = new f();
    public final f.d.b.r.a<Item> m = new c();
    public final f.d.b.r.d<Item> n = new d();
    public final i<Item> o = new e();

    /* loaded from: classes.dex */
    public static final class a {
        public a(j.k.b.c cVar) {
        }
    }

    /* renamed from: f.d.b.b$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0136b<Item extends k<? extends RecyclerView.b0>> extends RecyclerView.b0 {
        public abstract void w(Item item, List<? extends Object> list);

        public abstract void x(Item item);
    }

    /* loaded from: classes.dex */
    public static final class c extends f.d.b.r.a<Item> {
        public void c(View view, int i2, b<Item> bVar, Item item) {
            c<Item> n;
            g.a aVar;
            j.k.a.d<View, c<Item>, Item, Integer, Boolean> a;
            j.k.a.d<View, c<Item>, Item, Integer, Boolean> b;
            j.k.b.e.c(view, "v");
            j.k.b.e.c(bVar, "fastAdapter");
            j.k.b.e.c(item, "item");
            if (item.isEnabled() && (n = bVar.n(i2)) != null) {
                boolean z = item instanceof g;
                g gVar = null;
                g gVar2 = (g) (!z ? null : item);
                if (gVar2 == null || (b = gVar2.b()) == null || !b.a(view, n, item, Integer.valueOf(i2)).booleanValue()) {
                    Iterator it = ((g.e) bVar.f4048h.values()).iterator();
                    do {
                        aVar = (g.a) it;
                        if (!aVar.hasNext()) {
                            if (z) {
                                gVar = item;
                            }
                            g gVar3 = gVar;
                            if (gVar3 != null && (a = gVar3.a()) != null) {
                                a.a(view, n, item, Integer.valueOf(i2)).booleanValue();
                                return;
                            }
                            return;
                        }
                    } while (!((d) aVar.next()).c(view, i2, bVar, item));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends f.d.b.r.d<Item> {
        public boolean c(View view, int i2, b<Item> bVar, Item item) {
            g.a aVar;
            j.k.b.e.c(view, "v");
            j.k.b.e.c(bVar, "fastAdapter");
            j.k.b.e.c(item, "item");
            if (item.isEnabled() && bVar.n(i2) != null) {
                Iterator it = ((g.e) bVar.f4048h.values()).iterator();
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

    /* loaded from: classes.dex */
    public static final class e extends i<Item> {
        public boolean c(View view, MotionEvent motionEvent, int i2, b<Item> bVar, Item item) {
            g.a aVar;
            j.k.b.e.c(view, "v");
            j.k.b.e.c(motionEvent, "event");
            j.k.b.e.c(bVar, "fastAdapter");
            j.k.b.e.c(item, "item");
            Iterator it = ((g.e) bVar.f4048h.values()).iterator();
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
        if (!this.a.a()) {
            this.b = true;
            return;
        }
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }

    public static void s(b bVar, int i2, int i3, Object obj, int i4, Object obj2) {
        int i5 = i4 & 4;
        Iterator it = ((g.e) bVar.f4048h.values()).iterator();
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
    public int a() {
        return this.f4046f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long b(int i2) {
        Item p2 = p(i2);
        if (p2 != null) {
            return p2.f();
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int c(int i2) {
        Item p2 = p(i2);
        if (p2 == null) {
            return 0;
        }
        if (!this.f4044d.b(p2.h())) {
            j.k.b.e.c(p2, "item");
            if (p2 instanceof m) {
                int h2 = p2.h();
                m<?> mVar = (m) p2;
                j.k.b.e.c(mVar, "item");
                this.f4044d.a(h2, mVar);
            } else {
                m<?> a2 = p2.a();
                if (a2 != null) {
                    int h3 = p2.h();
                    j.k.b.e.c(a2, "item");
                    this.f4044d.a(h3, a2);
                }
            }
        }
        return p2.h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void d(RecyclerView recyclerView) {
        j.k.b.e.c(recyclerView, "recyclerView");
        Objects.requireNonNull(this.f4050j);
        j.k.b.e.c("onAttachedToRecyclerView", "message");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void e(RecyclerView.b0 b0Var, int i2) {
        j.k.b.e.c(b0Var, "holder");
    }

    public void f(RecyclerView.b0 b0Var, int i2, List<? extends Object> list) {
        j.k.b.e.c(b0Var, "holder");
        j.k.b.e.c(list, "payloads");
        Objects.requireNonNull(this.f4050j);
        b0Var.a.setTag(R$id.fastadapter_item_adapter, this);
        this.f4052l.b(b0Var, i2, list);
        j.k.b.e.c(b0Var, "holder");
    }

    public RecyclerView.b0 g(ViewGroup viewGroup, int i2) {
        j.k.b.e.c(viewGroup, "parent");
        Objects.requireNonNull(this.f4050j);
        j.k.b.e.c("onCreateViewHolder: " + i2, "message");
        m<?> mVar = this.f4044d.get(i2);
        RecyclerView.b0 a2 = this.f4051k.a(this, viewGroup, i2, mVar);
        a2.a.setTag(R$id.fastadapter_item_adapter, this);
        if (this.f4049i) {
            f.d.b.r.a<Item> aVar = this.m;
            View view = a2.a;
            j.k.b.e.b(view, "holder.itemView");
            f.b.a.c.b.o.b.i(aVar, a2, view);
            f.d.b.r.d<Item> dVar = this.n;
            View view2 = a2.a;
            j.k.b.e.b(view2, "holder.itemView");
            f.b.a.c.b.o.b.i(dVar, a2, view2);
            i<Item> iVar = this.o;
            View view3 = a2.a;
            j.k.b.e.b(view3, "holder.itemView");
            f.b.a.c.b.o.b.i(iVar, a2, view3);
        }
        return this.f4051k.b(this, a2, mVar);
    }

    public void h(RecyclerView recyclerView) {
        j.k.b.e.c(recyclerView, "recyclerView");
        Objects.requireNonNull(this.f4050j);
        j.k.b.e.c("onDetachedFromRecyclerView", "message");
    }

    public boolean i(RecyclerView.b0 b0Var) {
        j.k.b.e.c(b0Var, "holder");
        o oVar = this.f4050j;
        StringBuilder h2 = f.a.a.a.a.h("onFailedToRecycleView: ");
        h2.append(b0Var.f226f);
        String sb = h2.toString();
        Objects.requireNonNull(oVar);
        j.k.b.e.c(sb, "message");
        return this.f4052l.c(b0Var, b0Var.e());
    }

    public void j(RecyclerView.b0 b0Var) {
        j.k.b.e.c(b0Var, "holder");
        o oVar = this.f4050j;
        StringBuilder h2 = f.a.a.a.a.h("onViewAttachedToWindow: ");
        h2.append(b0Var.f226f);
        String sb = h2.toString();
        Objects.requireNonNull(oVar);
        j.k.b.e.c(sb, "message");
        this.f4052l.a(b0Var, b0Var.e());
    }

    public void k(RecyclerView.b0 b0Var) {
        j.k.b.e.c(b0Var, "holder");
        o oVar = this.f4050j;
        StringBuilder h2 = f.a.a.a.a.h("onViewDetachedFromWindow: ");
        h2.append(b0Var.f226f);
        String sb = h2.toString();
        Objects.requireNonNull(oVar);
        j.k.b.e.c(sb, "message");
        this.f4052l.e(b0Var, b0Var.e());
    }

    public void l(RecyclerView.b0 b0Var) {
        j.k.b.e.c(b0Var, "holder");
        o oVar = this.f4050j;
        StringBuilder h2 = f.a.a.a.a.h("onViewRecycled: ");
        h2.append(b0Var.f226f);
        String sb = h2.toString();
        Objects.requireNonNull(oVar);
        j.k.b.e.c(sb, "message");
        this.f4052l.d(b0Var, b0Var.e());
    }

    public final void m() {
        this.f4045e.clear();
        Iterator<c<Item>> it = this.c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            c<Item> next = it.next();
            if (next.c() > 0) {
                this.f4045e.append(i2, next);
                i2 += next.c();
            }
        }
        if (i2 == 0 && this.c.size() > 0) {
            this.f4045e.append(0, this.c.get(0));
        }
        this.f4046f = i2;
    }

    public c<Item> n(int i2) {
        if (i2 < 0 || i2 >= this.f4046f) {
            return null;
        }
        Objects.requireNonNull(this.f4050j);
        j.k.b.e.c("getAdapter", "message");
        SparseArray<c<Item>> sparseArray = this.f4045e;
        int indexOfKey = sparseArray.indexOfKey(i2);
        if (indexOfKey < 0) {
            indexOfKey = (~indexOfKey) - 1;
        }
        return sparseArray.valueAt(indexOfKey);
    }

    public int o(RecyclerView.b0 b0Var) {
        j.k.b.e.c(b0Var, "holder");
        return b0Var.e();
    }

    public Item p(int i2) {
        if (i2 < 0 || i2 >= this.f4046f) {
            return null;
        }
        int indexOfKey = this.f4045e.indexOfKey(i2);
        if (indexOfKey < 0) {
            indexOfKey = (~indexOfKey) - 1;
        }
        return this.f4045e.valueAt(indexOfKey).a(i2 - this.f4045e.keyAt(indexOfKey));
    }

    public int q(int i2) {
        if (this.f4046f == 0) {
            return 0;
        }
        int min = Math.min(i2, this.c.size());
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            i3 += this.c.get(i4).c();
        }
        return i3;
    }

    public void r() {
        Iterator it = ((g.e) this.f4048h.values()).iterator();
        while (true) {
            g.a aVar = (g.a) it;
            if (aVar.hasNext()) {
                ((d) aVar.next()).h();
            } else {
                m();
                this.a.b();
                return;
            }
        }
    }

    public void t(int i2, int i3) {
        Iterator it = ((g.e) this.f4048h.values()).iterator();
        while (true) {
            g.a aVar = (g.a) it;
            if (aVar.hasNext()) {
                ((d) aVar.next()).b(i2, i3);
            } else {
                m();
                this.a.d(i2, i3);
                return;
            }
        }
    }

    public void u(int i2, int i3) {
        Iterator it = ((g.e) this.f4048h.values()).iterator();
        while (true) {
            g.a aVar = (g.a) it;
            if (aVar.hasNext()) {
                ((d) aVar.next()).g(i2, i3);
            } else {
                m();
                this.a.e(i2, i3);
                return;
            }
        }
    }
}
