package c.b.a.a.g.h;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class r3<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: b  reason: collision with root package name */
    public final int f4018b;

    /* renamed from: c  reason: collision with root package name */
    public List<y3> f4019c = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f4020d = Collections.emptyMap();

    /* renamed from: e  reason: collision with root package name */
    public boolean f4021e;

    /* renamed from: f  reason: collision with root package name */
    public volatile a4 f4022f;

    /* renamed from: g  reason: collision with root package name */
    public Map<K, V> f4023g = Collections.emptyMap();

    public r3(int i, t3 t3Var) {
        this.f4018b = i;
    }

    public static <FieldDescriptorType extends l1<FieldDescriptorType>> r3<FieldDescriptorType, Object> d(int i) {
        return new t3(i);
    }

    public final int a(K k) {
        int size = this.f4019c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f4019c.get(size).f4070b);
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
            int compareTo2 = k.compareTo(this.f4019c.get(i2).f4070b);
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

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    /* renamed from: b */
    public final V put(K k, V v) {
        j();
        int a2 = a(k);
        if (a2 >= 0) {
            y3 y3Var = this.f4019c.get(a2);
            y3Var.f4072d.j();
            V v2 = y3Var.f4071c;
            y3Var.f4071c = v;
            return v2;
        }
        j();
        if (this.f4019c.isEmpty() && !(this.f4019c instanceof ArrayList)) {
            this.f4019c = new ArrayList(this.f4018b);
        }
        int i = -(a2 + 1);
        if (i >= this.f4018b) {
            return k().put(k, v);
        }
        int size = this.f4019c.size();
        int i2 = this.f4018b;
        if (size == i2) {
            y3 remove = this.f4019c.remove(i2 - 1);
            k().put(remove.f4070b, remove.f4071c);
        }
        this.f4019c.add(i, new y3(this, k, v));
        return null;
    }

    public void clear() {
        j();
        if (!this.f4019c.isEmpty()) {
            this.f4019c.clear();
        }
        if (!this.f4020d.isEmpty()) {
            this.f4020d.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.a.a.g.h.r3<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f4020d.containsKey(comparable);
    }

    public final Map.Entry<K, V> e(int i) {
        return this.f4019c.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f4022f == null) {
            this.f4022f = new a4(this, null);
        }
        return this.f4022f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r3)) {
            return super.equals(obj);
        }
        r3 r3Var = (r3) obj;
        int size = size();
        if (size != r3Var.size()) {
            return false;
        }
        int h = h();
        if (h != r3Var.h()) {
            return entrySet().equals(r3Var.entrySet());
        }
        for (int i = 0; i < h; i++) {
            if (!e(i).equals(r3Var.e(i))) {
                return false;
            }
        }
        if (h != size) {
            return this.f4020d.equals(r3Var.f4020d);
        }
        return true;
    }

    public final V f(int i) {
        j();
        V v = this.f4019c.remove(i).f4071c;
        if (!this.f4020d.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = k().entrySet().iterator();
            this.f4019c.add(new y3(this, it.next()));
            it.remove();
        }
        return v;
    }

    public void g() {
        if (!this.f4021e) {
            this.f4020d = this.f4020d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f4020d);
            this.f4023g = this.f4023g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f4023g);
            this.f4021e = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.a.a.g.h.r3<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f4019c.get(a2).f4071c;
        }
        return this.f4020d.get(comparable);
    }

    public final int h() {
        return this.f4019c.size();
    }

    public int hashCode() {
        int h = h();
        int i = 0;
        for (int i2 = 0; i2 < h; i2++) {
            i += this.f4019c.get(i2).hashCode();
        }
        return this.f4020d.size() > 0 ? i + this.f4020d.hashCode() : i;
    }

    public final Iterable<Map.Entry<K, V>> i() {
        return this.f4020d.isEmpty() ? (Iterable<Map.Entry<K, V>>) u3.f4045b : this.f4020d.entrySet();
    }

    public final void j() {
        if (this.f4021e) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap<K, V> k() {
        j();
        if (this.f4020d.isEmpty() && !(this.f4020d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f4020d = treeMap;
            this.f4023g = treeMap.descendingMap();
        }
        return (SortedMap) this.f4020d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.a.a.g.h.r3<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        j();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return (V) f(a2);
        }
        if (this.f4020d.isEmpty()) {
            return null;
        }
        return this.f4020d.remove(comparable);
    }

    public int size() {
        return this.f4020d.size() + this.f4019c.size();
    }
}
