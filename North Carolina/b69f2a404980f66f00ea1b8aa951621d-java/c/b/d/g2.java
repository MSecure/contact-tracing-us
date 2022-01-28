package c.b.d;

import c.b.d.f0;
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

public class g2<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: b  reason: collision with root package name */
    public final int f3881b;

    /* renamed from: c  reason: collision with root package name */
    public List<g2<K, V>.c> f3882c = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f3883d = Collections.emptyMap();

    /* renamed from: e  reason: collision with root package name */
    public boolean f3884e;
    public volatile g2<K, V>.e f;
    public Map<K, V> g = Collections.emptyMap();

    public static class a extends g2<FieldDescriptorType, Object> {
        public a(int i) {
            super(i, null);
        }

        @Override // c.b.d.g2
        public void h() {
            if (!this.f3884e) {
                for (int i = 0; i < e(); i++) {
                    Map.Entry<K, V> d2 = d(i);
                    if (((f0.c) d2.getKey()).c()) {
                        d2.setValue((V) Collections.unmodifiableList(d2.getValue()));
                    }
                }
                for (Map.Entry<K, V> entry : f()) {
                    if (((f0.c) entry.getKey()).c()) {
                        entry.setValue((V) Collections.unmodifiableList(entry.getValue()));
                    }
                }
            }
            g2.super.h();
        }

        @Override // java.util.AbstractMap, java.util.Map, c.b.d.g2
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return g2.super.put((f0.c) obj, obj2);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f3885a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final Iterable<Object> f3886b = new C0099b();

        public static class a implements Iterator<Object> {
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: c.b.d.g2$b$b  reason: collision with other inner class name */
        public static class C0099b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.f3885a;
            }
        }
    }

    public class c implements Map.Entry<K, V>, Comparable<g2<K, V>.c> {

        /* renamed from: b  reason: collision with root package name */
        public final K f3887b;

        /* renamed from: c  reason: collision with root package name */
        public V f3888c;

        public c(K k, V v) {
            this.f3887b = k;
            this.f3888c = v;
        }

        public c(g2 g2Var, Map.Entry<K, V> entry) {
            V value = entry.getValue();
            g2.this = g2Var;
            this.f3887b = entry.getKey();
            this.f3888c = value;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(g2<K, V>.c cVar) {
            return this.f3887b.compareTo(cVar.f3887b);
        }

        public boolean equals(Object obj) {
            boolean z;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f3887b;
            Object key = entry.getKey();
            if (k == null ? key == null : k.equals(key)) {
                V v = this.f3888c;
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
            return this.f3887b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3888c;
        }

        public int hashCode() {
            K k = this.f3887b;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f3888c;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            g2.this.c();
            V v2 = this.f3888c;
            this.f3888c = v;
            return v2;
        }

        public String toString() {
            return ((Object) this.f3887b) + "=" + ((Object) this.f3888c);
        }
    }

    public class d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public int f3890b = -1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3891c;

        /* renamed from: d  reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f3892d;

        public d(a aVar) {
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<K, V>>, java.util.Iterator<java.util.Map$Entry<K extends java.lang.Comparable<K>, V>> */
        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f3892d == null) {
                this.f3892d = g2.this.f3883d.entrySet().iterator();
            }
            return (Iterator<Map.Entry<K, V>>) this.f3892d;
        }

        public boolean hasNext() {
            if (this.f3890b + 1 < g2.this.f3882c.size()) {
                return true;
            }
            if (g2.this.f3883d.isEmpty() || !a().hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public Object next() {
            this.f3891c = true;
            int i = this.f3890b + 1;
            this.f3890b = i;
            return i < g2.this.f3882c.size() ? g2.this.f3882c.get(this.f3890b) : a().next();
        }

        public void remove() {
            if (this.f3891c) {
                this.f3891c = false;
                g2.this.c();
                if (this.f3890b < g2.this.f3882c.size()) {
                    g2 g2Var = g2.this;
                    int i = this.f3890b;
                    this.f3890b = i - 1;
                    g2Var.k(i);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    public class e extends AbstractSet<Map.Entry<K, V>> {
        public e(a aVar) {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: c.b.d.g2 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            g2.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            g2.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = g2.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(null);
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            g2.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return g2.this.size();
        }
    }

    public g2(int i, a aVar) {
        this.f3881b = i;
    }

    public static <FieldDescriptorType extends f0.c<FieldDescriptorType>> g2<FieldDescriptorType, Object> i(int i) {
        return new a(i);
    }

    public final int b(K k) {
        int size = this.f3882c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f3882c.get(size).f3887b);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.f3882c.get(i2).f3887b);
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public final void c() {
        if (this.f3884e) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        c();
        if (!this.f3882c.isEmpty()) {
            this.f3882c.clear();
        }
        if (!this.f3883d.isEmpty()) {
            this.f3883d.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.d.g2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return b(comparable) >= 0 || this.f3883d.containsKey(comparable);
    }

    public Map.Entry<K, V> d(int i) {
        return this.f3882c.get(i);
    }

    public int e() {
        return this.f3882c.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f == null) {
            this.f = new e(null);
        }
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g2)) {
            return super.equals(obj);
        }
        g2 g2Var = (g2) obj;
        int size = size();
        if (size != g2Var.size()) {
            return false;
        }
        int e2 = e();
        if (e2 != g2Var.e()) {
            return entrySet().equals(g2Var.entrySet());
        }
        for (int i = 0; i < e2; i++) {
            if (!d(i).equals(g2Var.d(i))) {
                return false;
            }
        }
        if (e2 != size) {
            return this.f3883d.equals(g2Var.f3883d);
        }
        return true;
    }

    public Iterable<Map.Entry<K, V>> f() {
        return this.f3883d.isEmpty() ? (Iterable<Map.Entry<K, V>>) b.f3886b : this.f3883d.entrySet();
    }

    public final SortedMap<K, V> g() {
        c();
        if (this.f3883d.isEmpty() && !(this.f3883d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f3883d = treeMap;
            this.g = treeMap.descendingMap();
        }
        return (SortedMap) this.f3883d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.d.g2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return this.f3882c.get(b2).f3888c;
        }
        return this.f3883d.get(comparable);
    }

    public void h() {
        if (!this.f3884e) {
            this.f3883d = this.f3883d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f3883d);
            this.g = this.g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.g);
            this.f3884e = true;
        }
    }

    public int hashCode() {
        int e2 = e();
        int i = 0;
        for (int i2 = 0; i2 < e2; i2++) {
            i += this.f3882c.get(i2).hashCode();
        }
        return this.f3883d.size() > 0 ? i + this.f3883d.hashCode() : i;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    /* renamed from: j */
    public V put(K k, V v) {
        c();
        int b2 = b(k);
        if (b2 >= 0) {
            g2<K, V>.c cVar = this.f3882c.get(b2);
            g2.this.c();
            V v2 = cVar.f3888c;
            cVar.f3888c = v;
            return v2;
        }
        c();
        if (this.f3882c.isEmpty() && !(this.f3882c instanceof ArrayList)) {
            this.f3882c = new ArrayList(this.f3881b);
        }
        int i = -(b2 + 1);
        if (i >= this.f3881b) {
            return g().put(k, v);
        }
        int size = this.f3882c.size();
        int i2 = this.f3881b;
        if (size == i2) {
            g2<K, V>.c remove = this.f3882c.remove(i2 - 1);
            g().put(remove.f3887b, remove.f3888c);
        }
        this.f3882c.add(i, new c(k, v));
        return null;
    }

    public final V k(int i) {
        c();
        V v = this.f3882c.remove(i).f3888c;
        if (!this.f3883d.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.f3882c.add(new c(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.d.g2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        c();
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return (V) k(b2);
        }
        if (this.f3883d.isEmpty()) {
            return null;
        }
        return this.f3883d.remove(comparable);
    }

    public int size() {
        return this.f3883d.size() + this.f3882c.size();
    }
}
