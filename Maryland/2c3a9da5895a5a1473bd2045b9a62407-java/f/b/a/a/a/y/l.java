package f.b.a.a.a.y;

import f.a.a.a.a;
import java.util.Objects;
import l.b.a.d;

public final class l extends l0 {
    public final d a;

    public l(d dVar) {
        Objects.requireNonNull(dVar, "Null checkTime");
        this.a = dVar;
    }

    @Override // f.b.a.a.a.y.l0
    public d a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l0) {
            return this.a.equals(((l0) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        StringBuilder h2 = a.h("ExposureCheckEntity{checkTime=");
        h2.append(this.a);
        h2.append("}");
        return h2.toString();
    }
}
