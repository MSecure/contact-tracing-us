package j;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class e<A, B, C> implements Serializable {
    public final A b;
    public final B c;

    /* renamed from: d  reason: collision with root package name */
    public final C f4570d;

    public e(A a, B b, C c) {
        this.b = a;
        this.c = b;
        this.f4570d = c;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return j.k.b.e.a(this.b, eVar.b) && j.k.b.e.a(this.c, eVar.c) && j.k.b.e.a(this.f4570d, eVar.f4570d);
    }

    @Override // java.lang.Object
    public int hashCode() {
        A a = this.b;
        int i2 = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.c;
        int hashCode2 = (hashCode + (b != null ? b.hashCode() : 0)) * 31;
        C c = this.f4570d;
        if (c != null) {
            i2 = c.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // java.lang.Object
    public String toString() {
        return '(' + this.b + ", " + this.c + ", " + this.f4570d + ')';
    }
}
