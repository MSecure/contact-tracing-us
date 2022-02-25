package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;
import l.b.a.w.a;
import l.b.a.w.b;
import l.b.a.w.d;
import l.b.a.w.i;

public final class c implements i, Comparable<c>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final c f4031d = new c(0, 0);
    public final long b;
    public final int c;

    static {
        BigInteger.valueOf(1000000000);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    public c(long j2, int i2) {
        this.b = j2;
        this.c = i2;
    }

    public static c b(d dVar, d dVar2) {
        b bVar = b.SECONDS;
        long o = dVar.o(dVar2, bVar);
        a aVar = a.NANO_OF_SECOND;
        long j2 = 0;
        if (dVar.f(aVar) && dVar2.f(aVar)) {
            try {
                long i2 = dVar.i(aVar);
                long i3 = dVar2.i(aVar) - i2;
                int i4 = (o > 0 ? 1 : (o == 0 ? 0 : -1));
                if (i4 > 0 && i3 < 0) {
                    i3 += 1000000000;
                } else if (i4 < 0 && i3 > 0) {
                    i3 -= 1000000000;
                } else if (i4 == 0 && i3 != 0) {
                    try {
                        o = dVar.o(dVar2.l(aVar, i2), bVar);
                    } catch (ArithmeticException | a unused) {
                    }
                }
                j2 = i3;
            } catch (ArithmeticException | a unused2) {
            }
        }
        return m(o, j2);
    }

    public static c c(long j2, int i2) {
        return (((long) i2) | j2) == 0 ? f4031d : new c(j2, i2);
    }

    public static c e(long j2) {
        return c(f.b.a.c.b.o.b.I1(j2, 86400), 0);
    }

    public static c f(long j2) {
        return c(f.b.a.c.b.o.b.I1(j2, 3600), 0);
    }

    public static c h(long j2) {
        return c(f.b.a.c.b.o.b.I1(j2, 60), 0);
    }

    public static c i(long j2) {
        long j3 = j2 / 1000000000;
        int i2 = (int) (j2 % 1000000000);
        if (i2 < 0) {
            i2 += 1000000000;
            j3--;
        }
        return c(j3, i2);
    }

    public static c l(long j2) {
        return c(j2, 0);
    }

    public static c m(long j2, long j3) {
        return c(f.b.a.c.b.o.b.H1(j2, f.b.a.c.b.o.b.B0(j3, 1000000000)), f.b.a.c.b.o.b.C0(j3, 1000000000));
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 1, this);
    }

    @Override // l.b.a.w.i
    public d a(d dVar) {
        long j2 = this.b;
        if (j2 != 0) {
            dVar = ((d) dVar).h(j2, b.SECONDS);
        }
        int i2 = this.c;
        if (i2 == 0) {
            return dVar;
        }
        return ((d) dVar).h((long) i2, b.NANOS);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(c cVar) {
        c cVar2 = cVar;
        int L = f.b.a.c.b.o.b.L(this.b, cVar2.b);
        return L != 0 ? L : this.c - cVar2.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.b == cVar.b && this.c == cVar.c;
    }

    public int hashCode() {
        long j2 = this.b;
        return (this.c * 51) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public c n(long j2) {
        long I1 = f.b.a.c.b.o.b.I1(j2, 60);
        return (I1 | 0) == 0 ? this : m(f.b.a.c.b.o.b.H1(f.b.a.c.b.o.b.H1(this.b, I1), 0), ((long) this.c) + 0);
    }

    public long o() {
        return this.b / 3600;
    }

    public long q() {
        return f.b.a.c.b.o.b.H1(f.b.a.c.b.o.b.I1(this.b, 1000), (long) (this.c / 1000000));
    }

    public String toString() {
        if (this == f4031d) {
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
}
