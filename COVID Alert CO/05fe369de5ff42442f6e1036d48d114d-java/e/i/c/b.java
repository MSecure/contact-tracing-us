package e.i.c;

import android.graphics.Insets;
import f.a.a.a.a;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f1246e = new b(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1247d;

    public b(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f1247d = i5;
    }

    public static b a(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f1246e : new b(i2, i3, i4, i5);
    }

    public Insets b() {
        return Insets.of(this.a, this.b, this.c, this.f1247d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1247d == bVar.f1247d && this.a == bVar.a && this.c == bVar.c && this.b == bVar.b;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.f1247d;
    }

    public String toString() {
        StringBuilder i2 = a.i("Insets{left=");
        i2.append(this.a);
        i2.append(", top=");
        i2.append(this.b);
        i2.append(", right=");
        i2.append(this.c);
        i2.append(", bottom=");
        i2.append(this.f1247d);
        i2.append('}');
        return i2.toString();
    }
}
