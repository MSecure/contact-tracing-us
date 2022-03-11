package j;

import j.k.b.e;
import java.io.Serializable;
/* loaded from: classes.dex */
public final class c<A, B> implements Serializable {
    public final A b;
    public final B c;

    public c(A a, B b) {
        this.b = a;
        this.c = b;
    }

    @Override // java.lang.Object
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

    @Override // java.lang.Object
    public int hashCode() {
        A a = this.b;
        int i2 = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.c;
        if (b != null) {
            i2 = b.hashCode();
        }
        return hashCode + i2;
    }

    @Override // java.lang.Object
    public String toString() {
        return '(' + this.b + ", " + this.c + ')';
    }
}
