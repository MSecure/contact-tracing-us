package b.i.k;

import java.util.Objects;

public class b<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f1133a;

    /* renamed from: b  reason: collision with root package name */
    public final S f1134b;

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Objects.equals(bVar.f1133a, null) || !Objects.equals(bVar.f1134b, null)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "Pair{null null}";
    }
}
