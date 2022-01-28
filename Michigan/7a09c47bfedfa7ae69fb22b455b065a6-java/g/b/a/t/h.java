package g.b.a.t;

import b.x.t;
import g.b.a.a;
import g.b.a.d;
import g.b.a.g;
import g.b.a.p;
import g.b.a.w.e;
import g.b.a.w.j;
import g.b.a.w.k;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

public abstract class h implements Comparable<h> {

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, h> f6461b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap<String, h> f6462c = new ConcurrentHashMap<>();

    static {
        try {
            Locale.class.getMethod("getUnicodeLocaleType", String.class);
        } catch (Throwable unused) {
        }
    }

    public static h p(e eVar) {
        t.y2(eVar, "temporal");
        h hVar = (h) eVar.f(k.f6657b);
        return hVar != null ? hVar : m.f6476d;
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new u((byte) 11, this);
    }

    public static h x(DataInput dataInput) {
        String readUTF = dataInput.readUTF();
        if (f6461b.isEmpty()) {
            y(m.f6476d);
            y(v.f6501d);
            y(r.f6494d);
            y(o.f6481e);
            y(j.f6463d);
            f6461b.putIfAbsent("Hijrah", j.f6463d);
            f6462c.putIfAbsent("islamic", j.f6463d);
            Iterator it = ServiceLoader.load(h.class, h.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                f6461b.putIfAbsent(hVar.s(), hVar);
                String r = hVar.r();
                if (r != null) {
                    f6462c.putIfAbsent(r, hVar);
                }
            }
        }
        h hVar2 = f6461b.get(readUTF);
        if (hVar2 != null || (hVar2 = f6462c.get(readUTF)) != null) {
            return hVar2;
        }
        throw new a(c.a.a.a.a.q("Unknown chronology: ", readUTF));
    }

    public static void y(h hVar) {
        f6461b.putIfAbsent(hVar.s(), hVar);
        String r = hVar.r();
        if (r != null) {
            f6462c.putIfAbsent(r, hVar);
        }
    }

    public void A(Map<j, Long> map, g.b.a.w.a aVar, long j) {
        Long l = map.get(aVar);
        if (l == null || l.longValue() == j) {
            map.put(aVar, Long.valueOf(j));
            return;
        }
        throw new a("Invalid state, field: " + aVar + " " + l + " conflicts with " + aVar + " " + j);
    }

    public f<?> B(d dVar, p pVar) {
        return g.W(this, dVar, pVar);
    }

    public f<?> D(e eVar) {
        try {
            p p = p.p(eVar);
            try {
                return B(d.B(eVar), p);
            } catch (a unused) {
                return g.V(k(t(eVar)), p, null);
            }
        } catch (a e2) {
            StringBuilder h = c.a.a.a.a.h("Unable to obtain ChronoZonedDateTime from TemporalAccessor: ");
            h.append(eVar.getClass());
            throw new a(h.toString(), e2);
        }
    }

    /* renamed from: b */
    public int compareTo(h hVar) {
        return s().compareTo(hVar.s());
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

    public int hashCode() {
        return getClass().hashCode() ^ s().hashCode();
    }

    public <D extends b> D i(g.b.a.w.d dVar) {
        D d2 = (D) ((b) dVar);
        if (equals(d2.D())) {
            return d2;
        }
        StringBuilder h = c.a.a.a.a.h("Chrono mismatch, expected: ");
        h.append(s());
        h.append(", actual: ");
        h.append(d2.D().s());
        throw new ClassCastException(h.toString());
    }

    public <D extends b> d<D> k(g.b.a.w.d dVar) {
        d<D> dVar2 = (d) dVar;
        if (equals(dVar2.f6456b.D())) {
            return dVar2;
        }
        StringBuilder h = c.a.a.a.a.h("Chrono mismatch, required: ");
        h.append(s());
        h.append(", supplied: ");
        h.append(dVar2.f6456b.D().s());
        throw new ClassCastException(h.toString());
    }

    public <D extends b> g<D> m(g.b.a.w.d dVar) {
        g<D> gVar = (g) dVar;
        if (equals(gVar.L().D())) {
            return gVar;
        }
        StringBuilder h = c.a.a.a.a.h("Chrono mismatch, required: ");
        h.append(s());
        h.append(", supplied: ");
        h.append(gVar.L().D().s());
        throw new ClassCastException(h.toString());
    }

    public abstract i n(int i);

    public abstract String r();

    public abstract String s();

    public c<?> t(e eVar) {
        try {
            return f(eVar).A(g.D(eVar));
        } catch (a e2) {
            StringBuilder h = c.a.a.a.a.h("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            h.append(eVar.getClass());
            throw new a(h.toString(), e2);
        }
    }

    public String toString() {
        return s();
    }
}
