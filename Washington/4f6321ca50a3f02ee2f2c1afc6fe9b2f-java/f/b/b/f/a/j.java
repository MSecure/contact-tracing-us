package f.b.b.f.a;

import f.b.b.b.c;
import f.b.b.b.g;
import f.b.b.b.k;
import f.b.b.f.a.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class j<V, C> extends g<V, C> {
    public List<b<V>> q;

    public static final class a<V> extends j<V, List<V>> {
        public a(f.b.b.b.b<? extends u<? extends V>> bVar, boolean z) {
            super(bVar, z);
            k kVar = k.INSTANCE;
            if (this.m.isEmpty()) {
                H();
            } else if (this.n) {
                int i2 = 0;
                k<? extends u<? extends InputT>> n = this.m.iterator();
                while (n.hasNext()) {
                    u uVar = (u) n.next();
                    uVar.a(new e(this, uVar, i2), kVar);
                    i2++;
                }
            } else {
                f fVar = new f(this, this.o ? this.m : null);
                k<? extends u<? extends InputT>> n2 = this.m.iterator();
                while (n2.hasNext()) {
                    ((u) n2.next()).a(fVar, kVar);
                }
            }
        }
    }

    public static final class b<V> {
        public V a;

        public b(V v) {
            this.a = v;
        }
    }

    public j(f.b.b.b.b<? extends u<? extends V>> bVar, boolean z) {
        super(bVar, z, true);
        List<b<V>> list;
        if (bVar.isEmpty()) {
            f.b.b.b.a<Object> aVar = c.c;
            list = g.f2882f;
        } else {
            int size = bVar.size();
            f.b.a.c.b.o.b.z(size, "initialArraySize");
            list = new ArrayList(size);
        }
        for (int i2 = 0; i2 < bVar.size(); i2++) {
            list.add(null);
        }
        this.q = list;
    }

    @Override // f.b.b.f.a.g
    public final void F(int i2, V v) {
        List<b<V>> list = this.q;
        if (list != null) {
            list.set(i2, new b<>(v));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: f.b.b.f.a.j<V, C> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.b.f.a.g
    public final void H() {
        List<b<V>> list = this.q;
        if (list != null) {
            int size = list.size();
            f.b.a.c.b.o.b.z(size, "initialArraySize");
            ArrayList arrayList = new ArrayList(size);
            Iterator<b<V>> it = list.iterator();
            while (it.hasNext()) {
                b<V> next = it.next();
                arrayList.add(next != null ? next.a : null);
            }
            t(Collections.unmodifiableList(arrayList));
        }
    }

    @Override // f.b.b.f.a.g
    public void J(g.a aVar) {
        super.J(aVar);
        this.q = null;
    }
}
