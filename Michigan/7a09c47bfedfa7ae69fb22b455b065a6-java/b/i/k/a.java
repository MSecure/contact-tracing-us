package b.i.k;

import java.util.Objects;

public class a<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f1841a;

    /* renamed from: b  reason: collision with root package name */
    public final S f1842b;

    public a(F f2, S s) {
        this.f1841a = f2;
        this.f1842b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!Objects.equals(aVar.f1841a, this.f1841a) || !Objects.equals(aVar.f1842b, this.f1842b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f2 = this.f1841a;
        int i = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f1842b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder h = c.a.a.a.a.h("Pair{");
        h.append(String.valueOf(this.f1841a));
        h.append(" ");
        h.append(String.valueOf(this.f1842b));
        h.append("}");
        return h.toString();
    }
}
