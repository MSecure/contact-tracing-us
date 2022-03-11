package f.b.a.a.a.n0;

import f.a.a.a.a;
import java.util.Objects;
import l.b.a.e;
/* loaded from: classes.dex */
public final class m extends u0 {
    public final e a;

    public m(e eVar) {
        Objects.requireNonNull(eVar, "Null checkTime");
        this.a = eVar;
    }

    @Override // f.b.a.a.a.n0.u0
    public e a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u0) {
            return this.a.equals(((u0) obj).a());
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
