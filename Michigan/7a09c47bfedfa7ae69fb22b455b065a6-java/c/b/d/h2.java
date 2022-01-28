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

public class h2<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: b  reason: collision with root package name */
    public final int f5295b;

    /* renamed from: c  reason: collision with root package name */
    public List<h2<K, V>.c> f5296c = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f5297d = Collections.emptyMap();

    /* renamed from: e  reason: collision with root package name */
    public boolean f5298e;

    /* renamed from: f  reason: collision with root package name */
    public volatile h2<K, V>.e f5299f;

    /* renamed from: g  reason: collision with root package name */
    public Map<K, V> f5300g = Collections.emptyMap();

    public static class a extends h2<FieldDescriptorType, Object> {
        public a(int i) {
            super(i, null);
        }

        @Override // c.b.d.h2
        public void h() {
            if (!this.f5298e) {
                for (int i = 0; i < e(); i++) {
                    Map.Entry<K, V> d2 = d(i);
                    if (((f0.c) d2.getKey()).e()) {
                        d2.setValue((V) Collections.unmodifiableList(d2.getValue()));
                    }
                }
                for (Map.Entry<K, V> entry : f()) {
                    if (((f0.c) entry.getKey()).e()) {
                        entry.setValue((V) Collections.unmodifiableList(entry.getValue()));
                    }
                }
            }
            h2.super.h();
        }

        @Override // java.util.AbstractMap, java.util.Map, c.b.d.h2
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return h2.super.put((f0.c) obj, obj2);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f5301a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final Iterable<Object> f5302b = new C0108b();

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

        /* renamed from: c.b.d.h2$b$b  reason: collision with other inner class name */
        public static class C0108b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.f5301a;
            }
        }
    }

    public class c implements Map.Entry<K, V>, Comparable<h2<K, V>.c> {

        /* renamed from: b  reason: collision with root package name */
        public final K f5303b;

        /* renamed from: c  reason: collision with root package name */
        public V f5304c;

        public c(K k, V v) {
            this.f5303b = k;
            this.f5304c = v;
        }

        public c(h2 h2Var, Map.Entry<K, V> entry) {
            V value = entry.getValue();
            h2.this = h2Var;
            this.f5303b = entry.getKey();
            this.f5304c = value;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(h2<K, V>.c cVar) {
            return this.f5303b.compareTo(cVar.f5303b);
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
            K k = this.f5303b;
            Object key = entry.getKey();
            if (k == null ? key == null : k.equals(key)) {
                V v = this.f5304c;
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
            return this.f5303b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f5304c;
        }

        public int hashCode() {
            K k = this.f5303b;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f5304c;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            h2.this.c();
            V v2 = this.f5304c;
            this.f5304c = v;
            return v2;
        }

        public String toString() {
            return ((Object) this.f5303b) + "=" + ((Object) this.f5304c);
        }
    }

    public class d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public int f5306b = -1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5307c;

        /* renamed from: d  reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f5308d;

        public d(a aVar) {
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<K, V>>, java.util.Iterator<java.util.Map$Entry<K extends java.lang.Comparable<K>, V>> */
        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f5308d == null) {
                this.f5308d = h2.this.f5297d.entrySet().iterator();
            }
            return (Iterator<Map.Entry<K, V>>) this.f5308d;
        }

        public boolean hasNext() {
            if (this.f5306b + 1 < h2.this.f5296c.size()) {
                return true;
            }
            if (h2.this.f5297d.isEmpty() || !a().hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public Object next() {
            this.f5307c = true;
            int i = this.f5306b + 1;
            this.f5306b = i;
            return i < h2.this.f5296c.size() ? h2.this.f5296c.get(this.f5306b) : a().next();
        }

        public void remove() {
            if (this.f5307c) {
                this.f5307c = false;
                h2.this.c();
                if (this.f5306b < h2.this.f5296c.size()) {
                    h2 h2Var = h2.this;
                    int i = this.f5306b;
                    this.f5306b = i - 1;
                    h2Var.k(i);
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

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: c.b.d.h2 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            h2.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            h2.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = h2.this.get(entry.getKey());
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
            h2.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return h2.this.size();
        }
    }

    public h2(int i, a aVar) {
        this.f5295b = i;
    }

    public static <FieldDescriptorType extends f0.c<FieldDescriptorType>> h2<FieldDescriptorType, Object> i(int i) {
        return new a(i);
    }

    public final int b(K k) {
        int size = this.f5296c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f5296c.get(size).f5303b);
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
            int compareTo2 = k.compareTo(this.f5296c.get(i2).f5303b);
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
        if (this.f5298e) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        c();
        if (!this.f5296c.isEmpty()) {
            this.f5296c.clear();
        }
        if (!this.f5297d.isEmpty()) {
            this.f5297d.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.d.h2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return b(comparable) >= 0 || this.f5297d.containsKey(comparable);
    }

    public Map.Entry<K, V> d(int i) {
        return this.f5296c.get(i);
    }

    public int e() {
        return this.f5296c.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f5299f == null) {
            this.f5299f = new e(null);
        }
        return this.f5299f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h2)) {
            return super.equals(obj);
        }
        h2 h2Var = (h2) obj;
        int size = size();
        if (size != h2Var.size()) {
            return false;
        }
        int e2 = e();
        if (e2 != h2Var.e()) {
            return entrySet().equals(h2Var.entrySet());
        }
        for (int i = 0; i < e2; i++) {
            if (!d(i).equals(h2Var.d(i))) {
                return false;
            }
        }
        if (e2 != size) {
            return this.f5297d.equals(h2Var.f5297d);
        }
        return true;
    }

    public Iterable<Map.Entry<K, V>> f() {
        return this.f5297d.isEmpty() ? (Iterable<Map.Entry<K, V>>) b.f5302b : this.f5297d.entrySet();
    }

    public final SortedMap<K, V> g() {
        c();
        if (this.f5297d.isEmpty() && !(this.f5297d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f5297d = treeMap;
            this.f5300g = treeMap.descendingMap();
        }
        return (SortedMap) this.f5297d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.d.h2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return this.f5296c.get(b2).f5304c;
        }
        return this.f5297d.get(comparable);
    }

    public void h() {
        if (!this.f5298e) {
            this.f5297d = this.f5297d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f5297d);
            this.f5300g = this.f5300g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f5300g);
            this.f5298e = true;
        }
    }

    public int hashCode() {
        int e2 = e();
        int i = 0;
        for (int i2 = 0; i2 < e2; i2++) {
            i += this.f5296c.get(i2).hashCode();
        }
        return this.f5297d.size() > 0 ? i + this.f5297d.hashCode() : i;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    /* renamed from: j */
    public V put(K k, V v) {
        c();
        int b2 = b(k);
        if (b2 >= 0) {
            h2<K, V>.c cVar = this.f5296c.get(b2);
            h2.this.c();
            V v2 = cVar.f5304c;
            cVar.f5304c = v;
            return v2;
        }
        c();
        if (this.f5296c.isEmpty() && !(this.f5296c instanceof ArrayList)) {
            this.f5296c = new ArrayList(this.f5295b);
        }
        int i = -(b2 + 1);
        if (i >= this.f5295b) {
            return g().put(k, v);
        }
        int size = this.f5296c.size();
        int i2 = this.f5295b;
        if (size == i2) {
            h2<K, V>.c remove = this.f5296c.remove(i2 - 1);
            g().put(remove.f5303b, remove.f5304c);
        }
        this.f5296c.add(i, new c(k, v));
        return null;
    }

    public final V k(int i) {
        c();
        V v = this.f5296c.remove(i).f5304c;
        if (!this.f5297d.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.f5296c.add(new c(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.d.h2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        c();
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return (V) k(b2);
        }
        if (this.f5297d.isEmpty()) {
            return null;
        }
        return this.f5297d.remove(comparable);
    }

    public int size() {
        return this.f5297d.size() + this.f5296c.size();
    }
}
