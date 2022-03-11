package f.b.c.k.u;

import f.b.a.c.b.o.b;
import f.b.c.k.u.p.c;
import f.b.d.a.n;
import f.b.d.a.s;
import f.b.g.n0;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public class k {
    public static final k b;
    public s a;

    /* loaded from: classes.dex */
    public static class a {
        public k a;
        public Map<String, Object> b = new HashMap();

        public a(k kVar) {
            this.a = kVar;
        }

        public final n a(h hVar, Map<String, Object> map) {
            s c = this.a.c(hVar);
            n.b builder = o.g(c) ? c.u().toBuilder() : n.i();
            boolean z = false;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Map) {
                    n a = a(hVar.b(key), (Map) value);
                    if (a != null) {
                        s.b z2 = s.z();
                        z2.copyOnWrite();
                        s.i((s) z2.instance, a);
                        builder.b(key, z2.build());
                        z = true;
                    }
                } else {
                    if (value instanceof s) {
                        builder.b(key, (s) value);
                    } else {
                        Objects.requireNonNull(builder);
                        key.getClass();
                        if (((n) builder.instance).f().containsKey(key)) {
                            b.P0(value == null, "Expected entry to be a Map, a Value or null", new Object[0]);
                            builder.copyOnWrite();
                            ((n0) n.c((n) builder.instance)).remove(key);
                        }
                    }
                    z = true;
                }
            }
            if (z) {
                return builder.build();
            }
            return null;
        }

        public k b() {
            n a = a(h.f3627d, this.b);
            if (a == null) {
                return this.a;
            }
            s.b z = s.z();
            z.copyOnWrite();
            s.i((s) z.instance, a);
            return new k(z.build());
        }

        public a c(h hVar, s sVar) {
            b.P0(!hVar.l(), "Cannot set field for empty path on ObjectValue", new Object[0]);
            d(hVar, sVar);
            return this;
        }

        public final void d(h hVar, s sVar) {
            Map<String, Object> map = this.b;
            for (int i2 = 0; i2 < hVar.n() - 1; i2++) {
                String i3 = hVar.i(i2);
                Object obj = map.get(i3);
                if (obj instanceof Map) {
                    map = (Map) obj;
                } else {
                    if (obj instanceof s) {
                        s sVar2 = (s) obj;
                        if (sVar2.y() == s.c.MAP_VALUE) {
                            HashMap hashMap = new HashMap(sVar2.u().f());
                            map.put(i3, hashMap);
                            map = hashMap;
                        }
                    }
                    map = new HashMap<>();
                    map.put(i3, map);
                }
            }
            map.put(hVar.h(), sVar);
        }
    }

    static {
        s.b z = s.z();
        z.f(n.d());
        b = new k(z.build());
    }

    public k(s sVar) {
        b.P0(sVar.y() == s.c.MAP_VALUE, "ObjectValues should be backed by a MapValue", new Object[0]);
        b.P0(!b.Y0(sVar), "ServerTimestamps should not be used as an ObjectValue", new Object[0]);
        this.a = sVar;
    }

    public static k b(Map<String, s> map) {
        s.b z = s.z();
        n.b i2 = n.i();
        i2.copyOnWrite();
        ((n0) n.c((n) i2.instance)).putAll(map);
        z.e(i2);
        return new k(z.build());
    }

    public final c a(n nVar) {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, s> entry : nVar.f().entrySet()) {
            h hVar = new h(Collections.singletonList(entry.getKey()));
            if (o.g(entry.getValue())) {
                Set<h> set = a(entry.getValue().u()).a;
                if (!set.isEmpty()) {
                    for (h hVar2 : set) {
                        hashSet.add(hVar.a(hVar2));
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
