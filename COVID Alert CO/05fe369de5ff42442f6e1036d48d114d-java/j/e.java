package j;

import java.io.Serializable;

public final class e<A, B, C> implements Serializable {
    public final A b;
    public final B c;

    /* renamed from: d  reason: collision with root package name */
    public final C f4250d;

    public e(A a, B b2, C c2) {
        this.b = a;
        this.c = b2;
        this.f4250d = c2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return j.k.b.e.a(this.b, eVar.b) && j.k.b.e.a(this.c, eVar.c) && j.k.b.e.a(this.f4250d, eVar.f4250d);
    }

    public int hashCode() {
        A a = this.b;
        int i2 = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.c;
        int hashCode2 = (hashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c2 = this.f4250d;
        if (c2 != null) {
            i2 = c2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return '(' + ((Object) this.b) + ", " + ((Object) this.c) + ", " + ((Object) this.f4250d) + ')';
    }
}
