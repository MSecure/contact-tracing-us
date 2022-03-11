package f.b.g;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class n1<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ int f3927h = 0;
    public final int b;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3929e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n1<K, V>.d f3930f;
    public List<n1<K, V>.b> c = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f3928d = Collections.emptyMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<K, V> f3931g = Collections.emptyMap();

    /* loaded from: classes.dex */
    public static class a {
        public static final Iterator<Object> a = new C0128a();
        public static final Iterable<Object> b = new b();

        /* renamed from: f.b.g.n1$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0128a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* loaded from: classes.dex */
        public static class b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return a.a;
            }
        }
    }

    /* JADX WARN: Incorrect field signature: TK; */
    /* loaded from: classes.dex */
    public class b implements Map.Entry<K, V>, Comparable<n1<K, V>.b> {
        public final Comparable b;
        public V c;

        public b(K k2, V v) {
            this.b = k2;
            this.c = v;
        }

        public b(n1 n1Var, Map.Entry<K, V> entry) {
            V value = entry.getValue();
            n1.this = n1Var;
            this.b = entry.getKey();
            this.c = value;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.b.compareTo(((b) obj).b);
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object obj) {
            boolean z;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Comparable comparable = this.b;
            Object key = entry.getKey();
            if (comparable == null ? key == null : comparable.equals(key)) {
                V v = this.c;
                Object value = entry.getValue();
                if (v == null) {
                    z = value == null;
                } else {
                    z = v.equals(value);
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.c;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            Comparable comparable = this.b;
            int i2 = 0;
            int hashCode = comparable == null ? 0 : comparable.hashCode();
            V v = this.c;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            n1 n1Var = n1.this;
            int i2 = n1.f3927h;
            n1Var.b();
            V v2 = this.c;
            this.c = v;
            return v2;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.b + "=" + this.c;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Iterator<Map.Entry<K, V>> {
        public int b = -1;
        public boolean c;

        /* renamed from: d  reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f3933d;

        public c(m1 m1Var) {
        }

        public final Iterator<Map.Entry<K, V>> b() {
            if (this.f3933d == null) {
                this.f3933d = n1.this.f3928d.entrySet().iterator();
            }
            return (Iterator<Map.Entry<K, V>>) this.f3933d;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b + 1 < n1.this.c.size()) {
                return true;
            }
            if (n1.this.f3928d.isEmpty() || !b().hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public Object next() {
            this.c = true;
            int i2 = this.b + 1;
            this.b = i2;
            return i2 < n1.this.c.size() ? n1.this.c.get(this.b) : b().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.c) {
                this.c = false;
                n1 n1Var = n1.this;
                int i2 = n1.f3927h;
                n1Var.b();
                if (this.b < n1.this.c.size()) {
                    n1 n1Var2 = n1.this;
                    int i3 = this.b;
                    this.b = i3 - 1;
                    n1Var2.i(i3);
                    return;
                }
                b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    /* loaded from: classes.dex */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d(m1 m1Var) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            n1.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            n1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = n1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new c(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            n1.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return n1.this.size();
        }
    }

    public n1(int i2, m1 m1Var) {
        this.b = i2;
    }

    public final int a(K k2) {
        int size = this.c.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo(this.c.get(size).b);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k2.compareTo(this.c.get(i3).b);
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    public final void b() {
        if (this.f3929e) {
            throw new UnsupportedOperationException();
        }
    }

    public Map.Entry<K, V> c(int i2) {
        return this.c.get(i2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        b();
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
        if (!this.f3928d.isEmpty()) {
            this.f3928d.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f3928d.containsKey(comparable);
    }

    public int d() {
        return this.c.size();
    }

    public Iterable<Map.Entry<K, V>> e() {
        return this.f3928d.isEmpty() ? (Iterable<Map.Entry<K, V>>) a.b : this.f3928d.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f3930f == null) {
            this.f3930f = new d(null);
        }
        return this.f3930f;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return super.equals(obj);
        }
        n1 n1Var = (n1) obj;
        int size = size();
        if (size != n1Var.size()) {
            return false;
        }
        int d2 = d();
        if (d2 != n1Var.d()) {
            return entrySet().equals(n1Var.entrySet());
        }
        for (int i2 = 0; i2 < d2; i2++) {
            if (!c(i2).equals(n1Var.c(i2))) {
                return false;
            }
        }
        if (d2 != size) {
            return this.f3928d.equals(n1Var.f3928d);
        }
        return true;
    }

    public final SortedMap<K, V> f() {
        b();
        if (this.f3928d.isEmpty() && !(this.f3928d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f3928d = treeMap;
            this.f3931g = treeMap.descendingMap();
        }
        return (SortedMap) this.f3928d;
    }

    public void g() {
        if (!this.f3929e) {
            this.f3928d = this.f3928d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f3928d);
            this.f3931g = this.f3931g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f3931g);
            this.f3929e = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.c.get(a2).c;
        }
        return this.f3928d.get(comparable);
    }

    /* renamed from: h */
    public V put(K k2, V v) {
        b();
        int a2 = a(k2);
        if (a2 >= 0) {
            n1<K, V>.b bVar = this.c.get(a2);
            n1.this.b();
            V v2 = bVar.c;
            bVar.c = v;
            return v2;
        }
        b();
        if (this.c.isEmpty() && !(this.c instanceof ArrayList)) {
            this.c = new ArrayList(this.b);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.b) {
            return f().put(k2, v);
        }
        int size = this.c.size();
        int i3 = this.b;
        if (size == i3) {
            n1<K, V>.b remove = this.c.remove(i3 - 1);
            f().put((K) remove.b, remove.c);
        }
        this.c.add(i2, new b(k2, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
    public int hashCode() {
        int d2 = d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            i2 += this.c.get(i3).hashCode();
        }
        return this.f3928d.size() > 0 ? i2 + this.f3928d.hashCode() : i2;
    }

    public final V i(int i2) {
        b();
        V v = this.c.remove(i2).c;
        if (!this.f3928d.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = f().entrySet().iterator();
            this.c.add(new b(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return (V) i(a2);
        }
        if (this.f3928d.isEmpty()) {
            return null;
        }
        return this.f3928d.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f3928d.size() + this.c.size();
    }
}
