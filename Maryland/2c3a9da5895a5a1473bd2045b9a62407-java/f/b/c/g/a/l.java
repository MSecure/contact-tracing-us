package f.b.c.g.a;

import f.b.c.g.a.d;
import f.b.c.g.a.i;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class l<K, V> extends d<K, V> {
    public i<K, V> b;
    public Comparator<K> c;

    public static class b<A, B, C> {
        public final List<A> a;
        public final Map<B, C> b;
        public final d.a.AbstractC0112a<A, B> c;

        /* renamed from: d  reason: collision with root package name */
        public k<A, C> f3076d;

        /* renamed from: e  reason: collision with root package name */
        public k<A, C> f3077e;

        public static class a implements Iterable<C0114b> {
            public long b;
            public final int c;

            /* renamed from: f.b.c.g.a.l$b$a$a  reason: collision with other inner class name */
            public class C0113a implements Iterator<C0114b> {
                public int b;

                public C0113a() {
                    this.b = a.this.c - 1;
                }

                public boolean hasNext() {
                    return this.b >= 0;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.Iterator
                public C0114b next() {
                    long j2 = a.this.b;
                    int i2 = this.b;
                    long j3 = j2 & ((long) (1 << i2));
                    C0114b bVar = new C0114b();
                    bVar.a = j3 == 0;
                    bVar.b = (int) Math.pow(2.0d, (double) i2);
                    this.b--;
                    return bVar;
                }

                public void remove() {
                }
            }

            public a(int i2) {
                int i3 = i2 + 1;
                int floor = (int) Math.floor(Math.log((double) i3) / Math.log(2.0d));
                this.c = floor;
                this.b = (((long) Math.pow(2.0d, (double) floor)) - 1) & ((long) i3);
            }

            @Override // java.lang.Iterable
            public Iterator<C0114b> iterator() {
                return new C0113a();
            }
        }

        /* renamed from: f.b.c.g.a.l$b$b  reason: collision with other inner class name */
        public static class C0114b {
            public boolean a;
            public int b;
        }

        public b(List<A> list, Map<B, C> map, d.a.AbstractC0112a<A, B> aVar) {
            this.a = list;
            this.b = map;
            this.c = aVar;
        }

        public static <A, B, C> l<A, C> b(List<A> list, Map<B, C> map, d.a.AbstractC0112a<A, B> aVar, Comparator<A> comparator) {
            i.a aVar2 = i.a.BLACK;
            b bVar = new b(list, map, aVar);
            Collections.sort(list, comparator);
            a.C0113a aVar3 = new a.C0113a();
            int size = list.size();
            while (aVar3.hasNext()) {
                C0114b bVar2 = (C0114b) aVar3.next();
                int i2 = bVar2.b;
                size -= i2;
                boolean z = bVar2.a;
                bVar.c(aVar2, i2, size);
                if (!z) {
                    int i3 = bVar2.b;
                    size -= i3;
                    bVar.c(i.a.RED, i3, size);
                }
            }
            i iVar = bVar.f3076d;
            if (iVar == null) {
                iVar = h.a;
            }
            return new l<>(iVar, comparator, null);
        }

        public final i<A, C> a(int i2, int i3) {
            if (i3 == 0) {
                return h.a;
            }
            if (i3 == 1) {
                A a2 = this.a.get(i2);
                return new g(a2, d(a2), null, null);
            }
            int i4 = i3 / 2;
            int i5 = i2 + i4;
            i<A, C> a3 = a(i2, i4);
            i<A, C> a4 = a(i5 + 1, i4);
            A a5 = this.a.get(i5);
            return new g(a5, d(a5), a3, a4);
        }

        public final void c(i.a aVar, int i2, int i3) {
            i<A, C> a2 = a(i3 + 1, i2 - 1);
            A a3 = this.a.get(i3);
            k<A, C> jVar = aVar == i.a.RED ? new j<>(a3, d(a3), null, a2) : new g<>(a3, d(a3), null, a2);
            if (this.f3076d == null) {
                this.f3076d = jVar;
            } else {
                this.f3077e.r(jVar);
            }
            this.f3077e = jVar;
        }

        public final C d(A a2) {
            Map<B, C> map = this.b;
            Objects.requireNonNull((c) this.c);
            int i2 = d.a.a;
            return map.get(a2);
        }
    }

    public l(i<K, V> iVar, Comparator<K> comparator) {
        this.b = iVar;
        this.c = comparator;
    }

    public l(i iVar, Comparator comparator, a aVar) {
        this.b = iVar;
        this.c = comparator;
    }

    @Override // f.b.c.g.a.d
    public boolean h(K k2) {
        return o(k2) != null;
    }

    @Override // f.b.c.g.a.d
    public V i(K k2) {
        i<K, V> o = o(k2);
        if (o != null) {
            return o.getValue();
        }
        return null;
    }

    @Override // f.b.c.g.a.d
    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // f.b.c.g.a.d, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new e(this.b, null, this.c, false);
    }

    @Override // f.b.c.g.a.d
    public Comparator<K> j() {
        return this.c;
    }

    @Override // f.b.c.g.a.d
    public K k() {
        return this.b.f().getKey();
    }

    @Override // f.b.c.g.a.d
    public d<K, V> l(K k2, V v) {
        return new l(this.b.d(k2, v, this.c).b(null, null, i.a.BLACK, null, null), this.c);
    }

    @Override // f.b.c.g.a.d
    public Iterator<Map.Entry<K, V>> m(K k2) {
        return new e(this.b, k2, this.c, false);
    }

    @Override // f.b.c.g.a.d
    public d<K, V> n(K k2) {
        if (!(o(k2) != null)) {
            return this;
        }
        return new l(this.b.e(k2, this.c).b(null, null, i.a.BLACK, null, null), this.c);
    }

    public final i<K, V> o(K k2) {
        i<K, V> iVar = this.b;
        while (!iVar.isEmpty()) {
            int compare = this.c.compare(k2, iVar.getKey());
            if (compare < 0) {
                iVar = iVar.c();
            } else if (compare == 0) {
                return iVar;
            } else {
                iVar = iVar.a();
            }
        }
        return null;
    }

    @Override // f.b.c.g.a.d
    public int size() {
        return this.b.size();
    }
}
