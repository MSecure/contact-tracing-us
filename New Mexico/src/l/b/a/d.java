package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;
import l.b.a.x.a;
import l.b.a.x.b;
import l.b.a.x.i;
/* loaded from: classes.dex */
public final class d implements i, Comparable<d>, Serializable {

    /* renamed from: d */
    public static final d f4610d = new d(0, 0);
    public final long b;
    public final int c;

    static {
        BigInteger.valueOf(1000000000);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    public d(long j2, int i2) {
        this.b = j2;
        this.c = i2;
    }

    public static d c(l.b.a.x.d dVar, l.b.a.x.d dVar2) {
        b bVar = b.SECONDS;
        long o = dVar.o(dVar2, bVar);
        a aVar = a.NANO_OF_SECOND;
        long j2 = 0;
        if (dVar.f(aVar) && dVar2.f(aVar)) {
            try {
                long i2 = dVar.i(aVar);
                j2 = dVar2.i(aVar) - i2;
                int i3 = (o > 0 ? 1 : (o == 0 ? 0 : -1));
                if (i3 > 0 && j2 < 0) {
                    j2 += 1000000000;
                } else if (i3 < 0 && j2 > 0) {
                    j2 -= 1000000000;
                } else if (i3 == 0 && j2 != 0) {
                    try {
                        o = dVar.o(dVar2.l(aVar, i2), bVar);
                    } catch (ArithmeticException | b unused) {
                    }
                }
            } catch (ArithmeticException | b unused2) {
            }
        }
        return o(o, j2);
    }

    public static d e(long j2, int i2) {
        return (((long) i2) | j2) == 0 ? f4610d : new d(j2, i2);
    }

    public static d f(long j2) {
        return e(g.b.a.c.c.d.x(j2, 86400), 0);
    }

    public static d h(long j2) {
        return e(g.b.a.c.c.d.x(j2, 3600), 0);
    }

    public static d i(long j2) {
        long j3 = j2 / 1000;
        int i2 = (int) (j2 % 1000);
        if (i2 < 0) {
            i2 += 1000;
            j3--;
        }
        return e(j3, i2 * 1000000);
    }

    public static d l(long j2) {
        return e(g.b.a.c.c.d.x(j2, 60), 0);
    }

    public static d m(long j2) {
        long j3 = j2 / 1000000000;
        int i2 = (int) (j2 % 1000000000);
        if (i2 < 0) {
            i2 += 1000000000;
            j3--;
        }
        return e(j3, i2);
    }

    public static d n(long j2) {
        return e(j2, 0);
    }

    public static d o(long j2, long j3) {
        return e(g.b.a.c.c.d.w(j2, g.b.a.c.c.d.i(j3, 1000000000)), g.b.a.c.c.d.k(j3, 1000000000));
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new n((byte) 1, this);
    }

    @Override // l.b.a.x.i
    public l.b.a.x.d a(l.b.a.x.d dVar) {
        long j2 = this.b;
        if (j2 != 0) {
            dVar = ((e) dVar).h(j2, b.SECONDS);
        }
        int i2 = this.c;
        if (i2 == 0) {
            return dVar;
        }
        return ((e) dVar).h((long) i2, b.NANOS);
    }

    public l.b.a.x.d b(l.b.a.x.d dVar) {
        long j2 = this.b;
        if (j2 != 0) {
            dVar = dVar.m(j2, b.SECONDS);
        }
        int i2 = this.c;
        return i2 != 0 ? dVar.m((long) i2, b.NANOS) : dVar;
    }

    @Override // java.lang.Comparable
    public int compareTo(d dVar) {
        d dVar2 = dVar;
        int e2 = g.b.a.c.c.d.e(this.b, dVar2.b);
        return e2 != 0 ? e2 : this.c - dVar2.c;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.b == dVar.b && this.c == dVar.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        long j2 = this.b;
        return (this.c * 51) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final d q(long j2, long j3) {
        if ((j2 | j3) == 0) {
            return this;
        }
        return o(g.b.a.c.c.d.w(g.b.a.c.c.d.w(this.b, j2), j3 / 1000000000), ((long) this.c) + (j3 % 1000000000));
    }

    public d r(long j2) {
        return q(g.b.a.c.c.d.x(j2, 60), 0);
    }

    public long s() {
        return this.b / 86400;
    }

    public long t() {
        return this.b / 3600;
    }

    @Override // java.lang.Object
    public String toString() {
        if (this == f4610d) {
            return "PT0S";
        }
        long j2 = this.b;
        long j3 = j2 / 3600;
        int i2 = (int) ((j2 % 3600) / 60);
        int i3 = (int) (j2 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j3 != 0) {
            sb.append(j3);
            sb.append('H');
        }
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        if (i3 == 0 && this.c == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i3 >= 0 || this.c <= 0) {
            sb.append(i3);
        } else if (i3 == -1) {
            sb.append("-0");
        } else {
            sb.append(i3 + 1);
        }
        if (this.c > 0) {
            int length = sb.length();
            sb.append(i3 < 0 ? 2000000000 - this.c : this.c + 1000000000);
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    public long u() {
        return g.b.a.c.c.d.w(g.b.a.c.c.d.x(this.b, 1000), (long) (this.c / 1000000));
    }
}
