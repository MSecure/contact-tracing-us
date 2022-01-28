package b.e;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class f<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f1386a;

    /* renamed from: b  reason: collision with root package name */
    public int f1387b;

    /* renamed from: c  reason: collision with root package name */
    public int f1388c;

    /* renamed from: d  reason: collision with root package name */
    public int f1389d;

    /* renamed from: e  reason: collision with root package name */
    public int f1390e;

    /* renamed from: f  reason: collision with root package name */
    public int f1391f;

    /* renamed from: g  reason: collision with root package name */
    public int f1392g;

    public f(int i) {
        if (i > 0) {
            this.f1388c = i;
            this.f1386a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final V a(K k) {
        if (k != null) {
            synchronized (this) {
                V v = this.f1386a.get(k);
                if (v != null) {
                    this.f1391f++;
                    return v;
                }
                this.f1392g++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V b(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f1389d++;
            this.f1387b++;
            put = this.f1386a.put(k, v);
            if (put != null) {
                this.f1387b--;
            }
        }
        c(this.f1388c);
        return put;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    public void c(int i) {
        while (true) {
            synchronized (this) {
                if (this.f1387b < 0 || (this.f1386a.isEmpty() && this.f1387b != 0)) {
                } else if (this.f1387b <= i) {
                    break;
                } else if (this.f1386a.isEmpty()) {
                    break;
                } else {
                    Map.Entry<K, V> next = this.f1386a.entrySet().iterator().next();
                    K key = next.getKey();
                    next.getValue();
                    this.f1386a.remove(key);
                    this.f1387b--;
                    this.f1390e++;
                }
            }
        }
    }

    public final synchronized String toString() {
        int i;
        i = this.f1391f + this.f1392g;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f1388c), Integer.valueOf(this.f1391f), Integer.valueOf(this.f1392g), Integer.valueOf(i != 0 ? (this.f1391f * 100) / i : 0));
    }
}
