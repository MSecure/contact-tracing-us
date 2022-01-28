package b.i.l;

import c.a.a.a.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1143a;

    public c(Object obj) {
        this.f1143a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        Object obj2 = this.f1143a;
        Object obj3 = ((c) obj).f1143a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.f1143a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder g = a.g("DisplayCutoutCompat{");
        g.append(this.f1143a);
        g.append("}");
        return g.toString();
    }
}
