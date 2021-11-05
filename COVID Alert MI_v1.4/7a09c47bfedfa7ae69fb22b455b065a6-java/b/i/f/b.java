package b.i.f;

import c.a.a.a.a;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f1744e = new b(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f1745a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1746b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1747c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1748d;

    public b(int i, int i2, int i3, int i4) {
        this.f1745a = i;
        this.f1746b = i2;
        this.f1747c = i3;
        this.f1748d = i4;
    }

    public static b a(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? f1744e : new b(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1748d == bVar.f1748d && this.f1745a == bVar.f1745a && this.f1747c == bVar.f1747c && this.f1746b == bVar.f1746b;
    }

    public int hashCode() {
        return (((((this.f1745a * 31) + this.f1746b) * 31) + this.f1747c) * 31) + this.f1748d;
    }

    public String toString() {
        StringBuilder h = a.h("Insets{left=");
        h.append(this.f1745a);
        h.append(", top=");
        h.append(this.f1746b);
        h.append(", right=");
        h.append(this.f1747c);
        h.append(", bottom=");
        h.append(this.f1748d);
        h.append('}');
        return h.toString();
    }
}
