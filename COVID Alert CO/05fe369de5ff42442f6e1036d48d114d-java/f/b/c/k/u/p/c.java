package f.b.c.k.u.p;

import f.a.a.a.a;
import f.b.c.k.u.h;
import java.util.Set;

public final class c {
    public final Set<h> a;

    public c(Set<h> set) {
        this.a = set;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((c) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder i2 = a.i("FieldMask{mask=");
        i2.append(this.a.toString());
        i2.append("}");
        return i2.toString();
    }
}
