package b.i.f;

import c.a.a.a.a;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f1047e = new b(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f1048a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1049b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1050c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1051d;

    public b(int i, int i2, int i3, int i4) {
        this.f1048a = i;
        this.f1049b = i2;
        this.f1050c = i3;
        this.f1051d = i4;
    }

    public static b a(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? f1047e : new b(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1051d == bVar.f1051d && this.f1048a == bVar.f1048a && this.f1050c == bVar.f1050c && this.f1049b == bVar.f1049b;
    }

    public int hashCode() {
        return (((((this.f1048a * 31) + this.f1049b) * 31) + this.f1050c) * 31) + this.f1051d;
    }

    public String toString() {
        StringBuilder g = a.g("Insets{left=");
        g.append(this.f1048a);
        g.append(", top=");
        g.append(this.f1049b);
        g.append(", right=");
        g.append(this.f1050c);
        g.append(", bottom=");
        g.append(this.f1051d);
        g.append('}');
        return g.toString();
    }
}
