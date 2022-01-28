package g.b.a;

import b.x.t;
import c.a.a.a.a;
import g.b.a.t.e;
import g.b.a.w.b;
import g.b.a.w.d;
import java.io.Serializable;
import java.util.regex.Pattern;

public final class l extends e implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final l f6434e = new l(0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final int f6435b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6436c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6437d;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    }

    public l(int i, int i2, int i3) {
        this.f6435b = i;
        this.f6436c = i2;
        this.f6437d = i3;
    }

    public static l b(int i) {
        return (0 | i) == 0 ? f6434e : new l(0, 0, i);
    }

    private Object readResolve() {
        return ((this.f6435b | this.f6436c) | this.f6437d) == 0 ? f6434e : this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    public d a(d dVar) {
        b bVar;
        long j;
        t.y2(dVar, "temporal");
        int i = this.f6435b;
        if (i != 0) {
            int i2 = this.f6436c;
            if (i2 != 0) {
                dVar = dVar.s((((long) i) * 12) + ((long) i2), b.MONTHS);
                int i3 = this.f6437d;
                return i3 != 0 ? dVar.s((long) i3, b.DAYS) : dVar;
            }
            j = (long) i;
            bVar = b.YEARS;
        } else {
            int i4 = this.f6436c;
            if (i4 != 0) {
                j = (long) i4;
                bVar = b.MONTHS;
            }
            int i32 = this.f6437d;
            if (i32 != 0) {
            }
        }
        dVar = dVar.s(j, bVar);
        int i322 = this.f6437d;
        if (i322 != 0) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f6435b == lVar.f6435b && this.f6436c == lVar.f6436c && this.f6437d == lVar.f6437d;
    }

    public int hashCode() {
        return Integer.rotateLeft(this.f6437d, 16) + Integer.rotateLeft(this.f6436c, 8) + this.f6435b;
    }

    public String toString() {
        if (this == f6434e) {
            return "P0D";
        }
        StringBuilder g2 = a.g('P');
        int i = this.f6435b;
        if (i != 0) {
            g2.append(i);
            g2.append('Y');
        }
        int i2 = this.f6436c;
        if (i2 != 0) {
            g2.append(i2);
            g2.append('M');
        }
        int i3 = this.f6437d;
        if (i3 != 0) {
            g2.append(i3);
            g2.append('D');
        }
        return g2.toString();
    }
}
