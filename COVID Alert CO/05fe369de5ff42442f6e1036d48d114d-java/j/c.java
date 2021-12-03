package j;

import j.k.b.e;
import java.io.Serializable;

public final class c<A, B> implements Serializable {
    public final A b;
    public final B c;

    public c(A a, B b2) {
        this.b = a;
        this.c = b2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return e.a(this.b, cVar.b) && e.a(this.c, cVar.c);
    }

    public int hashCode() {
        A a = this.b;
        int i2 = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.c;
        if (b2 != null) {
            i2 = b2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return '(' + ((Object) this.b) + ", " + ((Object) this.c) + ')';
    }
}
