package l.b.a.t;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import java.io.InvalidObjectException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import l.b.a.g;
import l.b.a.p;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.j;
import l.b.a.w.k;

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
        b.B1(eVar, "temporal");
        h hVar = (h) eVar.c(k.b);
        return hVar != null ? hVar : m.f4084d;
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
        StringBuilder h2 = a.h("Chrono mismatch, expected: ");
        h2.append(n());
        h2.append(", actual: ");
        h2.append(d2.s().n());
        throw new ClassCastException(h2.toString());
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
        StringBuilder h2 = a.h("Chrono mismatch, required: ");
        h2.append(n());
        h2.append(", supplied: ");
        h2.append(dVar2.b.s().n());
        throw new ClassCastException(h2.toString());
    }

    public <D extends b> g<D> h(d dVar) {
        g<D> gVar = (g) dVar;
        if (equals(gVar.x().s())) {
            return gVar;
        }
        StringBuilder h2 = a.h("Chrono mismatch, required: ");
        h2.append(n());
        h2.append(", supplied: ");
        h2.append(gVar.x().s().n());
        throw new ClassCastException(h2.toString());
    }

    public int hashCode() {
        return getClass().hashCode() ^ n().hashCode();
    }

    public abstract i i(int i2);

    public abstract String m();

    public abstract String n();

    public c<?> o(e eVar) {
        try {
            return c(eVar).q(g.s(eVar));
        } catch (l.b.a.a e2) {
            StringBuilder h2 = a.h("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            h2.append(eVar.getClass());
            throw new l.b.a.a(h2.toString(), e2);
        }
    }

    public void r(Map<j, Long> map, l.b.a.w.a aVar, long j2) {
        Long l2 = map.get(aVar);
        if (l2 == null || l2.longValue() == j2) {
            map.put(aVar, Long.valueOf(j2));
            return;
        }
        throw new l.b.a.a("Invalid state, field: " + aVar + " " + l2 + " conflicts with " + aVar + " " + j2);
    }

    public f<?> s(l.b.a.d dVar, p pVar) {
        return g.F(this, dVar, pVar);
    }

    public f<?> t(e eVar) {
        try {
            p q = p.q(eVar);
            try {
                return s(l.b.a.d.s(eVar), q);
            } catch (l.b.a.a unused) {
                return g.E(f(o(eVar)), q, null);
            }
        } catch (l.b.a.a e2) {
            StringBuilder h2 = a.h("Unable to obtain ChronoZonedDateTime from TemporalAccessor: ");
            h2.append(eVar.getClass());
            throw new l.b.a.a(h2.toString(), e2);
        }
    }

    public String toString() {
        return n();
    }
}
