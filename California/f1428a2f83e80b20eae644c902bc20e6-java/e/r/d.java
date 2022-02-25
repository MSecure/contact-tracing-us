package e.r;

import f.a.a.a.a;

public final class d {
    public final p a;
    public final boolean b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1727d;

    public d(p<?> pVar, boolean z, Object obj, boolean z2) {
        if (!pVar.a && z) {
            throw new IllegalArgumentException(pVar.b() + " does not allow nullable values");
        } else if (z || !z2 || obj != null) {
            this.a = pVar;
            this.b = z;
            this.f1727d = obj;
            this.c = z2;
        } else {
            StringBuilder h2 = a.h("Argument with type ");
            h2.append(pVar.b());
            h2.append(" has null value but is not nullable.");
            throw new IllegalArgumentException(h2.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.b != dVar.b || this.c != dVar.c || !this.a.equals(dVar.a)) {
            return false;
        }
        Object obj2 = this.f1727d;
        Object obj3 = dVar.f1727d;
        return obj2 != null ? obj2.equals(obj3) : obj3 == null;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31;
        Object obj = this.f1727d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }
}
