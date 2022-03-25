package l.b.a;

import f.a.a.a.a;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.v.c;
import l.b.a.w.b;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.m;
import l.b.a.w.n;
import l.b.a.w.o;

public final class g extends c implements d, f, Comparable<g>, Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static final g f4143f;

    /* renamed from: g  reason: collision with root package name */
    public static final g f4144g = new g(23, 59, 59, 999999999);

    /* renamed from: h  reason: collision with root package name */
    public static final g f4145h;

    /* renamed from: i  reason: collision with root package name */
    public static final g[] f4146i = new g[24];
    public final byte b;
    public final byte c;

    /* renamed from: d  reason: collision with root package name */
    public final byte f4147d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4148e;

    static {
        int i2 = 0;
        while (true) {
            g[] gVarArr = f4146i;
            if (i2 < gVarArr.length) {
                gVarArr[i2] = new g(i2, 0, 0, 0);
                i2++;
            } else {
                f4145h = gVarArr[0];
                g gVar = gVarArr[12];
                f4143f = gVarArr[0];
                return;
            }
        }
    }

    public g(int i2, int i3, int i4, int i5) {
        this.b = (byte) i2;
        this.c = (byte) i3;
        this.f4147d = (byte) i4;
        this.f4148e = i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    /* JADX WARN: Type inference failed for: r5v5, types: [int] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static g D(DataInput dataInput) {
        byte b2;
        int i2;
        byte b3;
        int readByte = dataInput.readByte();
        byte b4 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            b3 = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                ?? r5 = ~readByte2;
                i2 = 0;
                b4 = r5;
                b2 = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    b4 = readByte2;
                    b3 = ~readByte3;
                } else {
                    int readInt = dataInput.readInt();
                    b2 = readByte3;
                    i2 = readInt;
                    b4 = readByte2;
                }
            }
            return v(readByte, b4, b2 == 1 ? 1 : 0, i2);
        }
        i2 = 0;
        b2 = b3;
        return v(readByte, b4, b2 == 1 ? 1 : 0, i2);
    }

    public static g r(int i2, int i3, int i4, int i5) {
        return ((i3 | i4) | i5) == 0 ? f4146i[i2] : new g(i2, i3, i4, i5);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static g s(e eVar) {
        g gVar = (g) eVar.c(k.f4305g);
        if (gVar != null) {
            return gVar;
        }
        throw new a(a.f(eVar, a.k("Unable to obtain LocalTime from TemporalAccessor: ", eVar, ", type ")));
    }

    public static g u(int i2, int i3) {
        l.b.a.w.a aVar = l.b.a.w.a.HOUR_OF_DAY;
        aVar.f4286e.b((long) i2, aVar);
        if (i3 == 0) {
            return f4146i[i2];
        }
        l.b.a.w.a aVar2 = l.b.a.w.a.MINUTE_OF_HOUR;
        aVar2.f4286e.b((long) i3, aVar2);
        return new g(i2, i3, 0, 0);
    }

    public static g v(int i2, int i3, int i4, int i5) {
        l.b.a.w.a aVar = l.b.a.w.a.HOUR_OF_DAY;
        aVar.f4286e.b((long) i2, aVar);
        l.b.a.w.a aVar2 = l.b.a.w.a.MINUTE_OF_HOUR;
        aVar2.f4286e.b((long) i3, aVar2);
        l.b.a.w.a aVar3 = l.b.a.w.a.SECOND_OF_MINUTE;
        aVar3.f4286e.b((long) i4, aVar3);
        l.b.a.w.a aVar4 = l.b.a.w.a.NANO_OF_SECOND;
        aVar4.f4286e.b((long) i5, aVar4);
        return r(i2, i3, i4, i5);
    }

    public static g w(long j2) {
        l.b.a.w.a aVar = l.b.a.w.a.NANO_OF_DAY;
        aVar.f4286e.b(j2, aVar);
        int i2 = (int) (j2 / 3600000000000L);
        long j3 = j2 - (((long) i2) * 3600000000000L);
        int i3 = (int) (j3 / 60000000000L);
        long j4 = j3 - (((long) i3) * 60000000000L);
        int i4 = (int) (j4 / 1000000000);
        return r(i2, i3, i4, (int) (j4 - (((long) i4) * 1000000000)));
    }

    private Object writeReplace() {
        return new m((byte) 5, this);
    }

    public static g x(long j2) {
        l.b.a.w.a aVar = l.b.a.w.a.SECOND_OF_DAY;
        aVar.f4286e.b(j2, aVar);
        int i2 = (int) (j2 / 3600);
        long j3 = j2 - ((long) (i2 * 3600));
        int i3 = (int) (j3 / 60);
        return r(i2, i3, (int) (j3 - ((long) (i3 * 60))), 0);
    }

    public g A(long j2) {
        if (j2 == 0) {
            return this;
        }
        int i2 = (this.b * 60) + this.c;
        int i3 = ((((int) (j2 % 1440)) + i2) + 1440) % 1440;
        return i2 == i3 ? this : r(i3 / 60, i3 % 60, this.f4147d, this.f4148e);
    }

    public g B(long j2) {
        if (j2 == 0) {
            return this;
        }
        long E = E();
        long j3 = (((j2 % 86400000000000L) + E) + 86400000000000L) % 86400000000000L;
        return E == j3 ? this : r((int) (j3 / 3600000000000L), (int) ((j3 / 60000000000L) % 60), (int) ((j3 / 1000000000) % 60), (int) (j3 % 1000000000));
    }

    public g C(long j2) {
        if (j2 == 0) {
            return this;
        }
        int i2 = (this.c * 60) + (this.b * 3600) + this.f4147d;
        int i3 = ((((int) (j2 % 86400)) + i2) + 86400) % 86400;
        return i2 == i3 ? this : r(i3 / 3600, (i3 / 60) % 60, i3 % 60, this.f4148e);
    }

    public long E() {
        return (((long) this.f4147d) * 1000000000) + (((long) this.c) * 60000000000L) + (((long) this.b) * 3600000000000L) + ((long) this.f4148e);
    }

    public int F() {
        return (this.c * 60) + (this.b * 3600) + this.f4147d;
    }

    /* renamed from: G */
    public g l(j jVar, long j2) {
        if (!(jVar instanceof l.b.a.w.a)) {
            return (g) jVar.c(this, j2);
        }
        l.b.a.w.a aVar = (l.b.a.w.a) jVar;
        aVar.f4286e.b(j2, aVar);
        switch (aVar.ordinal()) {
            case 0:
                return I((int) j2);
            case 1:
                return w(j2);
            case 2:
                return I(((int) j2) * 1000);
            case 3:
                return w(j2 * 1000);
            case 4:
                return I(((int) j2) * 1000000);
            case 5:
                return w(j2 * 1000000);
            case 6:
                int i2 = (int) j2;
                if (this.f4147d == i2) {
                    return this;
                }
                l.b.a.w.a aVar2 = l.b.a.w.a.SECOND_OF_MINUTE;
                aVar2.f4286e.b((long) i2, aVar2);
                return r(this.b, this.c, i2, this.f4148e);
            case 7:
                return C(j2 - ((long) F()));
            case 8:
                int i3 = (int) j2;
                if (this.c == i3) {
                    return this;
                }
                l.b.a.w.a aVar3 = l.b.a.w.a.MINUTE_OF_HOUR;
                aVar3.f4286e.b((long) i3, aVar3);
                return r(this.b, i3, this.f4147d, this.f4148e);
            case 9:
                return A(j2 - ((long) ((this.b * 60) + this.c)));
            case 10:
                return z(j2 - ((long) (this.b % 12)));
            case 11:
                if (j2 == 12) {
                    j2 = 0;
                }
                return z(j2 - ((long) (this.b % 12)));
            case 12:
                return H((int) j2);
            case 13:
                if (j2 == 24) {
                    j2 = 0;
                }
                return H((int) j2);
            case 14:
                return z((j2 - ((long) (this.b / 12))) * 12);
            default:
                throw new n(a.d("Unsupported field: ", jVar));
        }
    }

    public g H(int i2) {
        if (this.b == i2) {
            return this;
        }
        l.b.a.w.a aVar = l.b.a.w.a.HOUR_OF_DAY;
        aVar.f4286e.b((long) i2, aVar);
        return r(i2, this.c, this.f4147d, this.f4148e);
    }

    public g I(int i2) {
        if (this.f4148e == i2) {
            return this;
        }
        l.b.a.w.a aVar = l.b.a.w.a.NANO_OF_SECOND;
        aVar.f4286e.b((long) i2, aVar);
        return r(this.b, this.c, this.f4147d, i2);
    }

    public void J(DataOutput dataOutput) {
        byte b2;
        if (this.f4148e == 0) {
            if (this.f4147d != 0) {
                dataOutput.writeByte(this.b);
                dataOutput.writeByte(this.c);
                b2 = this.f4147d;
            } else if (this.c == 0) {
                b2 = this.b;
            } else {
                dataOutput.writeByte(this.b);
                b2 = this.c;
            }
            dataOutput.writeByte(~b2);
            return;
        }
        dataOutput.writeByte(this.b);
        dataOutput.writeByte(this.c);
        dataOutput.writeByte(this.f4147d);
        dataOutput.writeInt(this.f4148e);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        return super.a(jVar);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        return jVar instanceof l.b.a.w.a ? t(jVar) : super.b(jVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: l.b.a.g */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) b.NANOS;
        }
        if (lVar == k.f4305g) {
            return this;
        }
        if (lVar == k.b || lVar == k.a || lVar == k.f4302d || lVar == k.f4303e || lVar == k.f4304f) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.w.d
    public d e(f fVar) {
        boolean z = fVar instanceof g;
        d dVar = fVar;
        if (!z) {
            dVar = fVar.n(this);
        }
        return (g) dVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.b == gVar.b && this.c == gVar.c && this.f4147d == gVar.f4147d && this.f4148e == gVar.f4148e;
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar.i() : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.w.d
    public d h(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    public int hashCode() {
        long E = E();
        return (int) (E ^ (E >>> 32));
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar == l.b.a.w.a.NANO_OF_DAY ? E() : jVar == l.b.a.w.a.MICRO_OF_DAY ? E() / 1000 : (long) t(jVar) : jVar.f(this);
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        return dVar.l(l.b.a.w.a.NANO_OF_DAY, E());
    }

    @Override // l.b.a.w.d
    public long o(d dVar, m mVar) {
        long j2;
        g s = s(dVar);
        if (!(mVar instanceof b)) {
            return mVar.b(this, s);
        }
        long E = s.E() - E();
        switch (((b) mVar).ordinal()) {
            case 0:
                return E;
            case 1:
                j2 = 1000;
                break;
            case 2:
                j2 = 1000000;
                break;
            case 3:
                j2 = 1000000000;
                break;
            case 4:
                j2 = 60000000000L;
                break;
            case 5:
                j2 = 3600000000000L;
                break;
            case 6:
                j2 = 43200000000000L;
                break;
            default:
                throw new n("Unsupported unit: " + mVar);
        }
        return E / j2;
    }

    /* renamed from: q */
    public int compareTo(g gVar) {
        int K = f.b.a.c.b.o.b.K(this.b, gVar.b);
        if (K != 0) {
            return K;
        }
        int K2 = f.b.a.c.b.o.b.K(this.c, gVar.c);
        if (K2 != 0) {
            return K2;
        }
        int K3 = f.b.a.c.b.o.b.K(this.f4147d, gVar.f4147d);
        return K3 == 0 ? f.b.a.c.b.o.b.K(this.f4148e, gVar.f4148e) : K3;
    }

    public final int t(j jVar) {
        switch (((l.b.a.w.a) jVar).ordinal()) {
            case 0:
                return this.f4148e;
            case 1:
                throw new a(a.d("Field too large for an int: ", jVar));
            case 2:
                return this.f4148e / 1000;
            case 3:
                throw new a(a.d("Field too large for an int: ", jVar));
            case 4:
                return this.f4148e / 1000000;
            case 5:
                return (int) (E() / 1000000);
            case 6:
                return this.f4147d;
            case 7:
                return F();
            case 8:
                return this.c;
            case 9:
                return (this.b * 60) + this.c;
            case 10:
                return this.b % 12;
            case 11:
                int i2 = this.b % 12;
                if (i2 % 12 == 0) {
                    return 12;
                }
                return i2;
            case 12:
                return this.b;
            case 13:
                byte b2 = this.b;
                if (b2 == 0) {
                    return 24;
                }
                return b2;
            case 14:
                return this.b / 12;
            default:
                throw new n(a.d("Unsupported field: ", jVar));
        }
    }

    public String toString() {
        int i2;
        StringBuilder sb = new StringBuilder(18);
        byte b2 = this.b;
        byte b3 = this.c;
        byte b4 = this.f4147d;
        int i3 = this.f4148e;
        sb.append(b2 < 10 ? "0" : "");
        sb.append((int) b2);
        String str = ":0";
        sb.append(b3 < 10 ? str : ":");
        sb.append((int) b3);
        if (b4 > 0 || i3 > 0) {
            if (b4 >= 10) {
                str = ":";
            }
            sb.append(str);
            sb.append((int) b4);
            if (i3 > 0) {
                sb.append('.');
                int i4 = 1000000;
                if (i3 % 1000000 == 0) {
                    i2 = (i3 / 1000000) + 1000;
                } else {
                    if (i3 % 1000 == 0) {
                        i3 /= 1000;
                    } else {
                        i4 = 1000000000;
                    }
                    i2 = i3 + i4;
                }
                sb.append(Integer.toString(i2).substring(1));
            }
        }
        return sb.toString();
    }

    /* renamed from: y */
    public g m(long j2, m mVar) {
        if (!(mVar instanceof b)) {
            return (g) mVar.c(this, j2);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return B(j2);
            case 1:
                return B((j2 % 86400000000L) * 1000);
            case 2:
                return B((j2 % 86400000) * 1000000);
            case 3:
                return C(j2);
            case 4:
                return A(j2);
            case 5:
                return z(j2);
            case 6:
                return z((j2 % 2) * 12);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public g z(long j2) {
        return j2 == 0 ? this : r(((((int) (j2 % 24)) + this.b) + 24) % 24, this.c, this.f4147d, this.f4148e);
    }
}
