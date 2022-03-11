package e.i.c;

import android.graphics.Insets;
import f.a.a.a.a;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f1421e = new b(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1422d;

    public b(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f1422d = i5;
    }

    public static b a(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f1421e : new b(i2, i3, i4, i5);
    }

    public Insets b() {
        return Insets.of(this.a, this.b, this.c, this.f1422d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1422d == bVar.f1422d && this.a == bVar.a && this.c == bVar.c && this.b == bVar.b;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.f1422d;
    }

    public String toString() {
        StringBuilder h2 = a.h("Insets{left=");
        h2.append(this.a);
        h2.append(", top=");
        h2.append(this.b);
        h2.append(", right=");
        h2.append(this.c);
        h2.append(", bottom=");
        h2.append(this.f1422d);
        h2.append('}');
        return h2.toString();
    }
}
