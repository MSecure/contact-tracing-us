package l.b.a;

import java.io.Serializable;
import java.util.regex.Pattern;
import l.b.a.u.e;
import l.b.a.x.b;
import l.b.a.x.d;
/* loaded from: classes.dex */
public final class m extends e implements Serializable {

    /* renamed from: e */
    public static final m f4636e = new m(0, 0, 0);
    public final int b;
    public final int c;

    /* renamed from: d */
    public final int f4637d;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    }

    public m(int i2, int i3, int i4) {
        this.b = i2;
        this.c = i3;
        this.f4637d = i4;
    }

    public static m c(int i2) {
        return (0 | i2) == 0 ? f4636e : new m(0, 0, i2);
    }

    private Object readResolve() {
        return ((this.b | this.c) | this.f4637d) == 0 ? f4636e : this;
    }

    @Override // l.b.a.x.i
    public d a(d dVar) {
        b bVar;
        long j2;
        g.b.a.c.c.d.u(dVar, "temporal");
        int i2 = this.b;
        if (i2 != 0) {
            int i3 = this.c;
            if (i3 != 0) {
                dVar = ((e) dVar).h((((long) i2) * 12) + ((long) i3), b.MONTHS);
            } else {
                j2 = (long) i2;
                bVar = b.YEARS;
                dVar = ((e) dVar).h(j2, bVar);
            }
        } else {
            int i4 = this.c;
            if (i4 != 0) {
                j2 = (long) i4;
                bVar = b.MONTHS;
                dVar = ((e) dVar).h(j2, bVar);
            }
        }
        int i5 = this.f4637d;
        if (i5 == 0) {
            return dVar;
        }
        return ((e) dVar).h((long) i5, b.DAYS);
    }

    public d b(d dVar) {
        b bVar;
        long j2;
        g.b.a.c.c.d.u(dVar, "temporal");
        int i2 = this.b;
        if (i2 != 0) {
            int i3 = this.c;
            if (i3 != 0) {
                dVar = dVar.m((((long) i2) * 12) + ((long) i3), b.MONTHS);
            } else {
                j2 = (long) i2;
                bVar = b.YEARS;
                dVar = dVar.m(j2, bVar);
            }
        } else {
            int i4 = this.c;
            if (i4 != 0) {
                j2 = (long) i4;
                bVar = b.MONTHS;
                dVar = dVar.m(j2, bVar);
            }
        }
        int i5 = this.f4637d;
        return i5 != 0 ? dVar.m((long) i5, b.DAYS) : dVar;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.b == mVar.b && this.c == mVar.c && this.f4637d == mVar.f4637d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Integer.rotateLeft(this.f4637d, 16) + Integer.rotateLeft(this.c, 8) + this.b;
    }

    @Override // java.lang.Object
    public String toString() {
        if (this == f4636e) {
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
        int i4 = this.f4637d;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('D');
        }
        return sb.toString();
    }
}
