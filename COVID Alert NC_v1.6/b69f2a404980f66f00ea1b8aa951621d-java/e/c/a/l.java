package e.c.a;

import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.c.a.t.e;
import e.c.a.w.b;
import e.c.a.w.d;
import java.io.Serializable;
import java.util.regex.Pattern;

public final class l extends e implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final l f4991e = new l(0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final int f4992b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4993c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4994d;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    }

    public l(int i, int i2, int i3) {
        this.f4992b = i;
        this.f4993c = i2;
        this.f4994d = i3;
    }

    public static l b(int i) {
        return (0 | i) == 0 ? f4991e : new l(0, 0, i);
    }

    private Object readResolve() {
        return ((this.f4992b | this.f4993c) | this.f4994d) == 0 ? f4991e : this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    public d a(d dVar) {
        b bVar;
        long j;
        c.T1(dVar, "temporal");
        int i = this.f4992b;
        if (i != 0) {
            int i2 = this.f4993c;
            if (i2 != 0) {
                dVar = dVar.o((((long) i) * 12) + ((long) i2), b.MONTHS);
                int i3 = this.f4994d;
                return i3 != 0 ? dVar.o((long) i3, b.DAYS) : dVar;
            }
            j = (long) i;
            bVar = b.YEARS;
        } else {
            int i4 = this.f4993c;
            if (i4 != 0) {
                j = (long) i4;
                bVar = b.MONTHS;
            }
            int i32 = this.f4994d;
            if (i32 != 0) {
            }
        }
        dVar = dVar.o(j, bVar);
        int i322 = this.f4994d;
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
        return this.f4992b == lVar.f4992b && this.f4993c == lVar.f4993c && this.f4994d == lVar.f4994d;
    }

    public int hashCode() {
        return Integer.rotateLeft(this.f4994d, 16) + Integer.rotateLeft(this.f4993c, 8) + this.f4992b;
    }

    public String toString() {
        if (this == f4991e) {
            return "P0D";
        }
        StringBuilder f = a.f('P');
        int i = this.f4992b;
        if (i != 0) {
            f.append(i);
            f.append('Y');
        }
        int i2 = this.f4993c;
        if (i2 != 0) {
            f.append(i2);
            f.append('M');
        }
        int i3 = this.f4994d;
        if (i3 != 0) {
            f.append(i3);
            f.append('D');
        }
        return f.toString();
    }
}
