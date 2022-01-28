package f.b.a.a.a.b0;

import f.a.a.a.a;
import java.util.Objects;
import l.b.a.e;

public final class m extends q0 {
    public final e a;

    public m(e eVar) {
        Objects.requireNonNull(eVar, "Null checkTime");
        this.a = eVar;
    }

    @Override // f.b.a.a.a.b0.q0
    public e a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q0) {
            return this.a.equals(((q0) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        StringBuilder i2 = a.i("ExposureCheckEntity{checkTime=");
        i2.append(this.a);
        i2.append("}");
        return i2.toString();
    }
}
