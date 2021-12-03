package l.b.a.u;

import f.a.a.a.a;
import g.b.a.c.c.c;
import java.io.InvalidObjectException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import l.b.a.b;
import l.b.a.q;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.j;
import l.b.a.x.k;

public abstract class h implements Comparable<h> {
    public static final ConcurrentHashMap<String, h> b = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, h> c = new ConcurrentHashMap<>();

    static {
        try {
            Locale.class.getMethod("getUnicodeLocaleType", String.class);
        } catch (Throwable unused) {
        }
    }

    public static h l(e eVar) {
        c.u(eVar, "temporal");
        h hVar = (h) eVar.c(k.b);
        return hVar != null ? hVar : m.f4343d;
    }

    public static void q(h hVar) {
        b.putIfAbsent(hVar.n(), hVar);
        String m = hVar.m();
        if (m != null) {
            c.putIfAbsent(m, hVar);
        }
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new u((byte) 11, this);
    }

    /* renamed from: a */
    public int compareTo(h hVar) {
        return n().compareTo(hVar.n());
    }

    public abstract b b(int i2, int i3, int i4);

    public abstract b c(e eVar);

    public <D extends b> D e(d dVar) {
        D d2 = (D) ((b) dVar);
        if (equals(d2.s())) {
            return d2;
        }
        StringBuilder i2 = a.i("Chrono mismatch, expected: ");
        i2.append(n());
        i2.append(", actual: ");
        i2.append(d2.s().n());
        throw new ClassCastException(i2.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && compareTo((h) obj) == 0;
    }

    public <D extends b> d<D> f(d dVar) {
        d<D> dVar2 = (d) dVar;
        if (equals(dVar2.b.s())) {
            return dVar2;
        }
        StringBuilder i2 = a.i("Chrono mismatch, required: ");
        i2.append(n());
        i2.append(", supplied: ");
        i2.append(dVar2.b.s().n());
        throw new ClassCastException(i2.toString());
    }

    public <D extends b> g<D> h(d dVar) {
        g<D> gVar = (g) dVar;
        if (equals(gVar.x().s())) {
            return gVar;
        }
        StringBuilder i2 = a.i("Chrono mismatch, required: ");
        i2.append(n());
        i2.append(", supplied: ");
        i2.append(gVar.x().s().n());
        throw new ClassCastException(i2.toString());
    }

    public int hashCode() {
        return getClass().hashCode() ^ n().hashCode();
    }

    public abstract i i(int i2);

    public abstract String m();

    public abstract String n();

    public c<?> o(e eVar) {
        try {
            return c(eVar).q(l.b.a.h.s(eVar));
        } catch (b e2) {
            StringBuilder i2 = a.i("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            i2.append(eVar.getClass());
            throw new b(i2.toString(), e2);
        }
    }

    public void r(Map<j, Long> map, l.b.a.x.a aVar, long j2) {
        Long l2 = map.get(aVar);
        if (l2 == null || l2.longValue() == j2) {
            map.put(aVar, Long.valueOf(j2));
            return;
        }
        throw new b("Invalid state, field: " + aVar + " " + l2 + " conflicts with " + aVar + " " + j2);
    }

    public f<?> s(l.b.a.e eVar, q qVar) {
        return g.F(this, eVar, qVar);
    }

    public f<?> t(e eVar) {
        try {
            q q = q.q(eVar);
            try {
                return s(l.b.a.e.s(eVar), q);
            } catch (b unused) {
                return g.E(f(o(eVar)), q, null);
            }
        } catch (b e2) {
            StringBuilder i2 = a.i("Unable to obtain ChronoZonedDateTime from TemporalAccessor: ");
            i2.append(eVar.getClass());
            throw new b(i2.toString(), e2);
        }
    }

    public String toString() {
        return n();
    }
}
