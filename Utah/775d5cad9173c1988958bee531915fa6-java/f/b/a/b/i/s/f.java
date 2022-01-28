package f.b.a.b.i.s;

import f.b.a.b.d;
import f.b.a.b.i.s.h.b;
import f.b.a.b.i.s.h.c;
import f.b.a.b.i.s.h.f;
import i.a.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class f implements Object<f.b.a.b.i.s.h.f> {
    public final a<f.b.a.b.i.u.a> a;

    public f(a<f.b.a.b.i.u.a> aVar) {
        this.a = aVar;
    }

    public Object get() {
        f.b.a.b.i.u.a aVar = this.a.get();
        HashMap hashMap = new HashMap();
        d dVar = d.DEFAULT;
        f.a.AbstractC0078a a2 = f.a.a();
        a2.b(30000);
        a2.c(86400000);
        hashMap.put(dVar, a2.a());
        d dVar2 = d.HIGHEST;
        f.a.AbstractC0078a a3 = f.a.a();
        a3.b(1000);
        a3.c(86400000);
        hashMap.put(dVar2, a3.a());
        d dVar3 = d.VERY_LOW;
        f.a.AbstractC0078a a4 = f.a.a();
        a4.b(86400000);
        a4.c(86400000);
        Set<f.b> unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(f.b.NETWORK_UNMETERED, f.b.DEVICE_IDLE)));
        c.b bVar = (c.b) a4;
        Objects.requireNonNull(unmodifiableSet, "Null flags");
        bVar.c = unmodifiableSet;
        hashMap.put(dVar3, bVar.a());
        Objects.requireNonNull(aVar, "missing required property: clock");
        int size = hashMap.keySet().size();
        d.values();
        if (size >= 3) {
            new HashMap();
            return new b(aVar, hashMap);
        }
        throw new IllegalStateException("Not all priorities have been configured");
    }
}
