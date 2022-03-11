package f.b.b.f.a;

import f.b.b.b.c;
import f.b.b.b.g;
import f.b.b.b.k;
import f.b.b.f.a.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class j<V, C> extends g<V, C> {
    public List<b<V>> q;

    /* loaded from: classes.dex */
    public static final class a<V> extends j<V, List<V>> {
        public a(f.b.b.b.b<? extends u<? extends V>> bVar, boolean z) {
            super(bVar, z);
            k kVar = k.INSTANCE;
            if (this.m.isEmpty()) {
                H();
            } else if (this.n) {
                int i2 = 0;
                k n = this.m.iterator();
                while (n.hasNext()) {
                    u uVar = (u) n.next();
                    i2++;
                    uVar.a(new e(this, uVar, i2), kVar);
                }
            } else {
                f fVar = new f(this, this.o ? this.m : null);
                k n2 = this.m.iterator();
                while (n2.hasNext()) {
                    ((u) n2.next()).a(fVar, kVar);
                }
            }
        }
    }

    /* loaded from: classes.dex */
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
            list = g.f3390f;
        } else {
            int size = bVar.size();
            f.b.a.c.b.o.b.z(size, "initialArraySize");
            list = new ArrayList<>(size);
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
