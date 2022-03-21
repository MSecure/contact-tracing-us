package f.b.c.k.u;

import f.b.a.c.b.o.b;
import f.b.c.k.u.p.c;
import f.b.d.a.n;
import f.b.d.a.s;
import f.b.f.n0;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class k {
    public static final k b;
    public s a;

    public static class a {
        public k a;
        public Map<String, Object> b = new HashMap();

        public a(k kVar) {
            this.a = kVar;
        }

        public final n a(h hVar, Map<String, Object> map) {
            s c = this.a.c(hVar);
            n.b i2 = o.g(c) ? (n.b) c.u().toBuilder() : n.i();
            boolean z = false;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Map) {
                    n a2 = a((h) hVar.b(key), (Map) value);
                    if (a2 != null) {
                        s.b z2 = s.z();
                        z2.copyOnWrite();
                        s.i((s) z2.instance, a2);
                        i2.b(key, (s) z2.build());
                    }
                } else if (value instanceof s) {
                    i2.b(key, (s) value);
                } else {
                    Objects.requireNonNull(i2);
                    key.getClass();
                    if (((n) i2.instance).f().containsKey(key)) {
                        b.a1(value == null, "Expected entry to be a Map, a Value or null", new Object[0]);
                        i2.copyOnWrite();
                        ((n0) n.c((n) i2.instance)).remove(key);
                    }
                }
                z = true;
            }
            if (z) {
                return (n) i2.build();
            }
            return null;
        }

        public k b() {
            n a2 = a(h.f3118d, this.b);
            if (a2 == null) {
                return this.a;
            }
            s.b z = s.z();
            z.copyOnWrite();
            s.i((s) z.instance, a2);
            return new k((s) z.build());
        }

        public a c(h hVar, s sVar) {
            b.a1(!hVar.l(), "Cannot set field for empty path on ObjectValue", new Object[0]);
            d(hVar, sVar);
            return this;
        }

        public final void d(h hVar, s sVar) {
            Map<String, Object> map;
            Map<String, Object> map2 = this.b;
            for (int i2 = 0; i2 < hVar.n() - 1; i2++) {
                String i3 = hVar.i(i2);
                Object obj = map2.get(i3);
                if (obj instanceof Map) {
                    map = (Map) obj;
                } else {
                    if (obj instanceof s) {
                        s sVar2 = (s) obj;
                        if (sVar2.y() == s.c.MAP_VALUE) {
                            HashMap hashMap = new HashMap(sVar2.u().f());
                            map2.put(i3, hashMap);
                            map2 = hashMap;
                        }
                    }
                    map = new HashMap<>();
                    map2.put(i3, map);
                }
                map2 = map;
            }
            map2.put(hVar.h(), sVar);
        }
    }

    static {
        s.b z = s.z();
        z.f(n.d());
        b = new k((s) z.build());
    }

    public k(s sVar) {
        b.a1(sVar.y() == s.c.MAP_VALUE, "ObjectValues should be backed by a MapValue", new Object[0]);
        b.a1(!b.j1(sVar), "ServerTimestamps should not be used as an ObjectValue", new Object[0]);
        this.a = sVar;
    }

    public static k b(Map<String, s> map) {
        s.b z = s.z();
        n.b i2 = n.i();
        i2.copyOnWrite();
        ((n0) n.c((n) i2.instance)).putAll(map);
        z.e(i2);
        return new k((s) z.build());
    }

    public final c a(n nVar) {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, s> entry : nVar.f().entrySet()) {
            h hVar = new h(Collections.singletonList(entry.getKey()));
            if (o.g(entry.getValue())) {
                Set<h> set = a(entry.getValue().u()).a;
                if (!set.isEmpty()) {
                    for (h hVar2 : set) {
                        hashSet.add((h) hVar.a(hVar2));
                    }
                }
            }
            hashSet.add(hVar);
        }
        return new c(hashSet);
    }

    public s c(h hVar) {
        if (hVar.l()) {
            return this.a;
        }
        s sVar = this.a;
        int i2 = 0;
        while (true) {
            int n = hVar.n() - 1;
            n u = sVar.u();
            if (i2 >= n) {
                return u.g(hVar.h(), null);
            }
            sVar = u.g(hVar.i(i2), null);
            if (!o.g(sVar)) {
                return null;
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            return o.c(this.a, ((k) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
