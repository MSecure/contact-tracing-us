package b.i.l;

import c.a.a.a.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1851a;

    public c(Object obj) {
        this.f1851a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        Object obj2 = this.f1851a;
        Object obj3 = ((c) obj).f1851a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.f1851a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder h = a.h("DisplayCutoutCompat{");
        h.append(this.f1851a);
        h.append("}");
        return h.toString();
    }
}
