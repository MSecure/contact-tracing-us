package e.c.a.t;

import c.b.a.a.c.n.c;
import e.c.a.a;
import e.c.a.g;
import e.c.a.p;
import e.c.a.w.d;
import e.c.a.w.e;
import e.c.a.w.j;
import e.c.a.w.k;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

public abstract class h implements Comparable<h> {

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, h> f5016b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap<String, h> f5017c = new ConcurrentHashMap<>();

    static {
        try {
            Locale.class.getMethod("getUnicodeLocaleType", String.class);
        } catch (Throwable unused) {
        }
    }

    public static h n(e eVar) {
        c.T1(eVar, "temporal");
        h hVar = (h) eVar.f(k.f5178b);
        return hVar != null ? hVar : m.f5027d;
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static h s(DataInput dataInput) {
        String readUTF = dataInput.readUTF();
        if (f5016b.isEmpty()) {
            t(m.f5027d);
            t(v.f5048d);
            t(r.f5041d);
            t(o.f5032e);
            t(j.f5018d);
            f5016b.putIfAbsent("Hijrah", j.f5018d);
            f5017c.putIfAbsent("islamic", j.f5018d);
            Iterator it = ServiceLoader.load(h.class, h.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                f5016b.putIfAbsent(hVar.p(), hVar);
                String o = hVar.o();
                if (o != null) {
                    f5017c.putIfAbsent(o, hVar);
                }
            }
        }
        h hVar2 = f5016b.get(readUTF);
        if (hVar2 != null || (hVar2 = f5017c.get(readUTF)) != null) {
            return hVar2;
        }
        throw new a(c.a.a.a.a.o("Unknown chronology: ", readUTF));
    }

    public static void t(h hVar) {
        f5016b.putIfAbsent(hVar.p(), hVar);
        String o = hVar.o();
        if (o != null) {
            f5017c.putIfAbsent(o, hVar);
        }
    }

    private Object writeReplace() {
        return new u((byte) 11, this);
    }

    /* renamed from: b */
    public int compareTo(h hVar) {
        return p().compareTo(hVar.p());
    }

    public abstract b d(int i, int i2, int i3);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return compareTo((h) obj) == 0;
        }
        return false;
    }

    public abstract b f(e eVar);

    public <D extends b> D g(d dVar) {
        D d2 = (D) ((b) dVar);
        if (equals(d2.u())) {
            return d2;
        }
        StringBuilder g = c.a.a.a.a.g("Chrono mismatch, expected: ");
        g.append(p());
        g.append(", actual: ");
        g.append(d2.u().p());
        throw new ClassCastException(g.toString());
    }

    public int hashCode() {
        return getClass().hashCode() ^ p().hashCode();
    }

    public <D extends b> d<D> i(d dVar) {
        d<D> dVar2 = (d) dVar;
        if (equals(dVar2.f5011b.u())) {
            return dVar2;
        }
        StringBuilder g = c.a.a.a.a.g("Chrono mismatch, required: ");
        g.append(p());
        g.append(", supplied: ");
        g.append(dVar2.f5011b.u().p());
        throw new ClassCastException(g.toString());
    }

    public <D extends b> g<D> k(d dVar) {
        g<D> gVar = (g) dVar;
        if (equals(gVar.y().u())) {
            return gVar;
        }
        StringBuilder g = c.a.a.a.a.g("Chrono mismatch, required: ");
        g.append(p());
        g.append(", supplied: ");
        g.append(gVar.y().u().p());
        throw new ClassCastException(g.toString());
    }

    public abstract i l(int i);

    public abstract String o();

    public abstract String p();

    public c<?> q(e eVar) {
        try {
            return f(eVar).s(g.u(eVar));
        } catch (a e2) {
            StringBuilder g = c.a.a.a.a.g("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            g.append(eVar.getClass());
            throw new a(g.toString(), e2);
        }
    }

    public String toString() {
        return p();
    }

    public void u(Map<j, Long> map, e.c.a.w.a aVar, long j) {
        Long l = map.get(aVar);
        if (l == null || l.longValue() == j) {
            map.put(aVar, Long.valueOf(j));
            return;
        }
        throw new a("Invalid state, field: " + aVar + " " + l + " conflicts with " + aVar + " " + j);
    }

    public f<?> v(e.c.a.d dVar, p pVar) {
        return g.G(this, dVar, pVar);
    }

    public f<?> w(e eVar) {
        try {
            p s = p.s(eVar);
            try {
                return v(e.c.a.d.t(eVar), s);
            } catch (a unused) {
                return g.F(i(q(eVar)), s, null);
            }
        } catch (a e2) {
            StringBuilder g = c.a.a.a.a.g("Unable to obtain ChronoZonedDateTime from TemporalAccessor: ");
            g.append(eVar.getClass());
            throw new a(g.toString(), e2);
        }
    }
}
