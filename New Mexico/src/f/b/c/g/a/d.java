package f.b.c.g.a;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class d<K, V> implements Iterable<Map.Entry<K, V>> {

    /* loaded from: classes.dex */
    public static class a {
        public static final /* synthetic */ int a = 0;

        /* renamed from: f.b.c.g.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface AbstractC0113a<C, D> {
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!j().equals(dVar.j()) || size() != dVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = dVar.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean h(K k2);

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = j().hashCode();
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            hashCode = (hashCode * 31) + it.next().hashCode();
        }
        return hashCode;
    }

    public abstract V i(K k2);

    public abstract boolean isEmpty();

    @Override // java.lang.Iterable
    public abstract Iterator<Map.Entry<K, V>> iterator();

    public abstract Comparator<K> j();

    public abstract K k();

    public abstract d<K, V> l(K k2, V v);

    public abstract Iterator<Map.Entry<K, V>> m(K k2);

    public abstract d<K, V> n(K k2);

    public abstract int size();

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        Iterator<Map.Entry<K, V>> it = iterator();
        boolean z = true;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append("(");
            sb.append(next.getKey());
            sb.append("=>");
            sb.append(next.getValue());
            sb.append(")");
        }
        sb.append("};");
        return sb.toString();
    }
}
