package l.b.a;

import java.io.Serializable;
import java.util.regex.Pattern;
import l.b.a.t.e;
import l.b.a.w.b;
import l.b.a.w.d;

public final class l extends e implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final l f4161e = new l(0, 0, 0);
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4162d;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    }

    public l(int i2, int i3, int i4) {
        this.b = i2;
        this.c = i3;
        this.f4162d = i4;
    }

    public static l c(int i2) {
        return (0 | i2) == 0 ? f4161e : new l(0, 0, i2);
    }

    private Object readResolve() {
        return ((this.b | this.c) | this.f4162d) == 0 ? f4161e : this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // l.b.a.w.i
    public d a(d dVar) {
        int i2;
        b bVar;
        long j2;
        f.b.a.c.b.o.b.A1(dVar, "temporal");
        int i3 = this.b;
        if (i3 != 0) {
            int i4 = this.c;
            if (i4 != 0) {
                dVar = ((d) dVar).h((((long) i3) * 12) + ((long) i4), b.MONTHS);
                i2 = this.f4162d;
                if (i2 == 0) {
                    return dVar;
                }
                return ((d) dVar).h((long) i2, b.DAYS);
            }
            j2 = (long) i3;
            bVar = b.YEARS;
        } else {
            int i5 = this.c;
            if (i5 != 0) {
                j2 = (long) i5;
                bVar = b.MONTHS;
            }
            i2 = this.f4162d;
            if (i2 == 0) {
            }
        }
        dVar = ((d) dVar).h(j2, bVar);
        i2 = this.f4162d;
        if (i2 == 0) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    public d b(d dVar) {
        b bVar;
        long j2;
        f.b.a.c.b.o.b.A1(dVar, "temporal");
        int i2 = this.b;
        if (i2 != 0) {
            int i3 = this.c;
            if (i3 != 0) {
                dVar = dVar.m((((long) i2) * 12) + ((long) i3), b.MONTHS);
                int i4 = this.f4162d;
                return i4 != 0 ? dVar.m((long) i4, b.DAYS) : dVar;
            }
            j2 = (long) i2;
            bVar = b.YEARS;
        } else {
            int i5 = this.c;
            if (i5 != 0) {
                j2 = (long) i5;
                bVar = b.MONTHS;
            }
            int i42 = this.f4162d;
            if (i42 != 0) {
            }
        }
        dVar = dVar.m(j2, bVar);
        int i422 = this.f4162d;
        if (i422 != 0) {
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
        return this.b == lVar.b && this.c == lVar.c && this.f4162d == lVar.f4162d;
    }

    public int hashCode() {
        return Integer.rotateLeft(this.f4162d, 16) + Integer.rotateLeft(this.c, 8) + this.b;
    }

    public String toString() {
        if (this == f4161e) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        int i2 = this.b;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('Y');
        }
        int i3 = this.c;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        int i4 = this.f4162d;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('D');
        }
        return sb.toString();
    }
}
