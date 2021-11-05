package c.b.a.a.e.c;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class ia<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<K, WeakReference<V>> f2622a = new WeakHashMap();

    public final V a(K k) {
        WeakReference<V> weakReference = this.f2622a.get(k);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
