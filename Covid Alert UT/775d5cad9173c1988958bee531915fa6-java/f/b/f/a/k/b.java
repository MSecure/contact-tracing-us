package f.b.f.a.k;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class b {
    public a<String, Pattern> a;

    public static class a<K, V> {
        public LinkedHashMap<K, V> a;
        public int b;

        /* renamed from: f.b.f.a.k.b$a$a  reason: collision with other inner class name */
        public class C0123a extends LinkedHashMap<K, V> {
            public C0123a(int i2, float f2, boolean z) {
                super(i2, f2, z);
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                return size() > a.this.b;
            }
        }

        public a(int i2) {
            this.b = i2;
            this.a = new C0123a(f.a.a.a.a.b(i2, 4, 3, 1), 0.75f, true);
        }
    }

    public b(int i2) {
        this.a = new a<>(i2);
    }

    public Pattern a(String str) {
        V v;
        a<String, Pattern> aVar = this.a;
        synchronized (aVar) {
            v = aVar.a.get(str);
        }
        V v2 = v;
        if (v2 == null) {
            v2 = Pattern.compile(str);
            a<String, Pattern> aVar2 = this.a;
            synchronized (aVar2) {
                aVar2.a.put(str, v2);
            }
        }
        return v2;
    }
}
