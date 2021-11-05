package c.b.b.e.a;

import c.b.b.b.c;
import c.b.b.b.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class j<V, C> extends g<V, C> {
    public List<b<V>> q;

    public static final class a<V> extends j<V, List<V>> {
        public a(c.b.b.b.b<? extends u<? extends V>> bVar, boolean z) {
            super(bVar, z);
            k kVar = k.INSTANCE;
            if (this.m.isEmpty()) {
                t();
            } else if (this.n) {
                int i = 0;
                e u = ((c) this.m).listIterator();
                while (u.hasNext()) {
                    u uVar = (u) u.next();
                    uVar.b(new e(this, uVar, i), kVar);
                    i++;
                }
            } else {
                f fVar = new f(this, this.o ? this.m : null);
                e u2 = ((c) this.m).listIterator();
                while (u2.hasNext()) {
                    ((u) u2.next()).b(fVar, kVar);
                }
            }
        }
    }

    public static final class b<V> {

        /* renamed from: a  reason: collision with root package name */
        public V f3405a;

        public b(V v) {
            this.f3405a = v;
        }
    }

    public j(c.b.b.b.b<? extends u<? extends V>> bVar, boolean z) {
        super(bVar, z, true);
        List<b<V>> list;
        if (bVar.isEmpty()) {
            list = c.w();
        } else {
            int size = bVar.size();
            c.b.a.a.c.n.c.s(size, "initialArraySize");
            list = new ArrayList(size);
        }
        for (int i = 0; i < bVar.size(); i++) {
            list.add(null);
        }
        this.q = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: c.b.b.e.a.j<V, C> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.b.e.a.g
    public final void t() {
        List<b<V>> list = this.q;
        if (list != null) {
            int size = list.size();
            c.b.a.a.c.n.c.s(size, "initialArraySize");
            ArrayList arrayList = new ArrayList(size);
            Iterator<b<V>> it = list.iterator();
            while (it.hasNext()) {
                b<V> next = it.next();
                arrayList.add(next != null ? next.f3405a : null);
            }
            m(Collections.unmodifiableList(arrayList));
        }
    }
}
