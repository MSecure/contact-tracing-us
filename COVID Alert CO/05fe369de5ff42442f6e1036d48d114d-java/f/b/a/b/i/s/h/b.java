package f.b.a.b.i.s.h;

import f.b.a.b.d;
import f.b.a.b.i.s.h.f;
import f.b.a.b.i.u.a;
import java.util.Map;
import java.util.Objects;

public final class b extends f {
    public final a a;
    public final Map<d, f.a> b;

    public b(a aVar, Map<d, f.a> map) {
        Objects.requireNonNull(aVar, "Null clock");
        this.a = aVar;
        Objects.requireNonNull(map, "Null values");
        this.b = map;
    }

    @Override // f.b.a.b.i.s.h.f
    public a a() {
        return this.a;
    }

    @Override // f.b.a.b.i.s.h.f
    public Map<d, f.a> c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a.equals(fVar.a()) && this.b.equals(fVar.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("SchedulerConfig{clock=");
        i2.append(this.a);
        i2.append(", values=");
        i2.append(this.b);
        i2.append("}");
        return i2.toString();
    }
}
