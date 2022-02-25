package f.b.c.k.s;

import f.b.c.k.s.i;
import f.b.c.k.s.w;
import f.b.c.k.u.h;
import f.b.c.k.u.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class x {

    /* renamed from: k  reason: collision with root package name */
    public static final w f3056k;

    /* renamed from: l  reason: collision with root package name */
    public static final w f3057l;
    public final List<w> a;
    public List<w> b;
    public c0 c;

    /* renamed from: d  reason: collision with root package name */
    public final List<i> f3058d;

    /* renamed from: e  reason: collision with root package name */
    public final l f3059e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3060f;

    /* renamed from: g  reason: collision with root package name */
    public final long f3061g;

    /* renamed from: h  reason: collision with root package name */
    public final a f3062h;

    /* renamed from: i  reason: collision with root package name */
    public final c f3063i;

    /* renamed from: j  reason: collision with root package name */
    public final c f3064j;

    public enum a {
        LIMIT_TO_FIRST,
        LIMIT_TO_LAST
    }

    static {
        w.a aVar = w.a.ASCENDING;
        h hVar = h.c;
        f3056k = new w(aVar, hVar);
        f3057l = new w(w.a.DESCENDING, hVar);
    }

    public x(l lVar, String str, List<i> list, List<w> list2, long j2, a aVar, c cVar, c cVar2) {
        this.f3059e = lVar;
        this.f3060f = str;
        this.a = list2;
        this.f3058d = list;
        this.f3061g = j2;
        this.f3062h = aVar;
        this.f3063i = cVar;
        this.f3064j = cVar2;
    }

    public static x a(l lVar) {
        return new x(lVar, null, Collections.emptyList(), Collections.emptyList(), -1, a.LIMIT_TO_FIRST, null, null);
    }

    public h b() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.get(0).b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Enum] */
    public List<w> c() {
        boolean z;
        h hVar;
        w.a aVar;
        List<w> list;
        w.a aVar2 = w.a.ASCENDING;
        if (this.b == null) {
            Iterator<i> it = this.f3058d.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    hVar = null;
                    break;
                }
                i next = it.next();
                if (next instanceof h) {
                    h hVar2 = (h) next;
                    Objects.requireNonNull(hVar2);
                    if (Arrays.asList(i.a.LESS_THAN, i.a.LESS_THAN_OR_EQUAL, i.a.GREATER_THAN, i.a.GREATER_THAN_OR_EQUAL, i.a.NOT_EQUAL).contains(hVar2.a)) {
                        hVar = hVar2.c;
                        break;
                    }
                }
            }
            h b2 = b();
            if (hVar == null || b2 != null) {
                ArrayList arrayList = new ArrayList();
                for (w wVar : this.a) {
                    arrayList.add(wVar);
                    if (wVar.b.equals(h.c)) {
                        z = true;
                    }
                }
                if (!z) {
                    if (this.a.size() > 0) {
                        List<w> list2 = this.a;
                        aVar = list2.get(list2.size() - 1).a;
                    } else {
                        aVar = aVar2;
                    }
                    arrayList.add(aVar.equals(aVar2) ? f3056k : f3057l);
                }
                this.b = arrayList;
            } else {
                if (hVar.s()) {
                    list = Collections.singletonList(f3056k);
                } else {
                    list = Arrays.asList(new w(aVar2, hVar), f3056k);
                }
                this.b = list;
            }
        }
        return this.b;
    }

    public c0 d() {
        if (this.c == null) {
            if (this.f3062h == a.LIMIT_TO_FIRST) {
                this.c = new c0(this.f3059e, this.f3060f, this.f3058d, c(), this.f3061g, this.f3063i, this.f3064j);
            } else {
                ArrayList arrayList = new ArrayList();
                for (w wVar : c()) {
                    w.a aVar = wVar.a;
                    w.a aVar2 = w.a.DESCENDING;
                    if (aVar == aVar2) {
                        aVar2 = w.a.ASCENDING;
                    }
                    arrayList.add(new w(aVar2, wVar.b));
                }
                c cVar = this.f3064j;
                c cVar2 = null;
                c cVar3 = cVar != null ? new c(cVar.b, !cVar.a) : null;
                c cVar4 = this.f3063i;
                if (cVar4 != null) {
                    cVar2 = new c(cVar4.b, !cVar4.a);
                }
                this.c = new c0(this.f3059e, this.f3060f, this.f3058d, arrayList, this.f3061g, cVar3, cVar2);
            }
        }
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        if (this.f3062h != xVar.f3062h) {
            return false;
        }
        return d().equals(xVar.d());
    }

    public int hashCode() {
        return this.f3062h.hashCode() + (d().hashCode() * 31);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("Query(target=");
        h2.append(d().toString());
        h2.append(";limitType=");
        h2.append(this.f3062h.toString());
        h2.append(")");
        return h2.toString();
    }
}
