package l.b.a;

import f.a.a.a.a;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.w.c;
import l.b.a.x.b;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.f;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.m;
import l.b.a.x.n;
import l.b.a.x.o;
/* loaded from: classes.dex */
public final class h extends c implements d, f, Comparable<h>, Serializable {

    /* renamed from: f */
    public static final h f4618f;

    /* renamed from: g */
    public static final h f4619g;

    /* renamed from: h */
    public static final h f4620h;

    /* renamed from: i */
    public static final h[] f4621i = new h[24];
    public final byte b;
    public final byte c;

    /* renamed from: d */
    public final byte f4622d;

    /* renamed from: e */
    public final int f4623e;

    static {
        int i2 = 0;
        while (true) {
            h[] hVarArr = f4621i;
            if (i2 < hVarArr.length) {
                hVarArr[i2] = new h(i2, 0, 0, 0);
                i2++;
            } else {
                f4620h = hVarArr[0];
                h hVar = hVarArr[12];
                f4618f = hVarArr[0];
                f4619g = new h(23, 59, 59, 999999999);
                return;
            }
        }
    }

    public h(int i2, int i3, int i4, int i5) {
        this.b = (byte) i2;
        this.c = (byte) i3;
        this.f4622d = (byte) i4;
        this.f4623e = i5;
    }

    public static h D(DataInput dataInput) {
        int i2;
        int i3;
        int i4;
        int i5;
        int readByte = dataInput.readByte();
        int i6 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i5 = 0;
        } else {
            int readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                int i7 = ~readByte2;
                i3 = 0;
                i2 = 0;
                i4 = i7;
            } else {
                int readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i6 = readByte2;
                    i5 = ~readByte3;
                } else {
                    i3 = dataInput.readInt();
                    i2 = readByte3;
                    i4 = readByte2;
                }
            }
            return v(readByte, i4 == 1 ? 1 : 0, i2 == 1 ? 1 : 0, i3);
        }
        i3 = 0;
        i4 = i6;
        i2 = i5;
        return v(readByte, i4 == 1 ? 1 : 0, i2 == 1 ? 1 : 0, i3);
    }

    public static h r(int i2, int i3, int i4, int i5) {
        return ((i3 | i4) | i5) == 0 ? f4621i[i2] : new h(i2, i3, i4, i5);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static h s(e eVar) {
        h hVar = (h) eVar.c(k.f4780g);
        if (hVar != null) {
            return hVar;
        }
        throw new b(a.f(eVar, a.k("Unable to obtain LocalTime from TemporalAccessor: ", eVar, ", type ")));
    }

    public static h u(int i2, int i3) {
        l.b.a.x.a aVar = l.b.a.x.a.HOUR_OF_DAY;
        aVar.f4761e.b((long) i2, aVar);
        if (i3 == 0) {
            return f4621i[i2];
        }
        l.b.a.x.a aVar2 = l.b.a.x.a.MINUTE_OF_HOUR;
        aVar2.f4761e.b((long) i3, aVar2);
        return new h(i2, i3, 0, 0);
    }

    public static h v(int i2, int i3, int i4, int i5) {
        l.b.a.x.a aVar = l.b.a.x.a.HOUR_OF_DAY;
        aVar.f4761e.b((long) i2, aVar);
        l.b.a.x.a aVar2 = l.b.a.x.a.MINUTE_OF_HOUR;
        aVar2.f4761e.b((long) i3, aVar2);
        l.b.a.x.a aVar3 = l.b.a.x.a.SECOND_OF_MINUTE;
        aVar3.f4761e.b((long) i4, aVar3);
        l.b.a.x.a aVar4 = l.b.a.x.a.NANO_OF_SECOND;
        aVar4.f4761e.b((long) i5, aVar4);
        return r(i2, i3, i4, i5);
    }

    public static h w(long j2) {
        l.b.a.x.a aVar = l.b.a.x.a.NANO_OF_DAY;
        aVar.f4761e.b(j2, aVar);
        int i2 = (int) (j2 / 3600000000000L);
        long j3 = j2 - (((long) i2) * 3600000000000L);
        int i3 = (int) (j3 / 60000000000L);
        long j4 = j3 - (((long) i3) * 60000000000L);
        int i4 = (int) (j4 / 1000000000);
        return r(i2, i3, i4, (int) (j4 - (((long) i4) * 1000000000)));
    }

    private Object writeReplace() {
        return new n((byte) 5, this);
    }

    public static h x(long j2) {
        l.b.a.x.a aVar = l.b.a.x.a.SECOND_OF_DAY;
        aVar.f4761e.b(j2, aVar);
        int i2 = (int) (j2 / 3600);
        long j3 = j2 - ((long) (i2 * 3600));
        int i3 = (int) (j3 / 60);
        return r(i2, i3, (int) (j3 - ((long) (i3 * 60))), 0);
    }

    public h A(long j2) {
        if (j2 == 0) {
            return this;
        }
        int i2 = (this.b * 60) + this.c;
        int i3 = ((((int) (j2 % 1440)) + i2) + 1440) % 1440;
        return i2 == i3 ? this : r(i3 / 60, i3 % 60, this.f4622d, this.f4623e);
    }

    public h B(long j2) {
        if (j2 == 0) {
            return this;
        }
        long E = E();
        long j3 = (((j2 % 86400000000000L) + E) + 86400000000000L) % 86400000000000L;
        return E == j3 ? this : r((int) (j3 / 3600000000000L), (int) ((j3 / 60000000000L) % 60), (int) ((j3 / 1000000000) % 60), (int) (j3 % 1000000000));
    }

    public h C(long j2) {
        if (j2 == 0) {
            return this;
        }
        int i2 = (this.c * 60) + (this.b * 3600) + this.f4622d;
        int i3 = ((((int) (j2 % 86400)) + i2) + 86400) % 86400;
        return i2 == i3 ? this : r(i3 / 3600, (i3 / 60) % 60, i3 % 60, this.f4623e);
    }

    public long E() {
        return (((long) this.f4622d) * 1000000000) + (((long) this.c) * 60000000000L) + (((long) this.b) * 3600000000000L) + ((long) this.f4623e);
    }

    public int F() {
        return (this.c * 60) + (this.b * 3600) + this.f4622d;
    }

    /* renamed from: G */
    public h l(j jVar, long j2) {
        if (!(jVar instanceof l.b.a.x.a)) {
            return (h) jVar.c(this, j2);
        }
        l.b.a.x.a aVar = (l.b.a.x.a) jVar;
        aVar.f4761e.b(j2, aVar);
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
                if (this.f4622d == i2) {
                    return this;
                }
                l.b.a.x.a aVar2 = l.b.a.x.a.SECOND_OF_MINUTE;
                aVar2.f4761e.b((long) i2, aVar2);
                return r(this.b, this.c, i2, this.f4623e);
            case 7:
                return C(j2 - ((long) F()));
            case 8:
                int i3 = (int) j2;
                if (this.c == i3) {
                    return this;
                }
                l.b.a.x.a aVar3 = l.b.a.x.a.MINUTE_OF_HOUR;
                aVar3.f4761e.b((long) i3, aVar3);
                return r(this.b, i3, this.f4622d, this.f4623e);
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

    public h H(int i2) {
        if (this.b == i2) {
            return this;
        }
        l.b.a.x.a aVar = l.b.a.x.a.HOUR_OF_DAY;
        aVar.f4761e.b((long) i2, aVar);
        return r(i2, this.c, this.f4622d, this.f4623e);
    }

    public h I(int i2) {
        if (this.f4623e == i2) {
            return this;
        }
        l.b.a.x.a aVar = l.b.a.x.a.NANO_OF_SECOND;
        aVar.f4761e.b((long) i2, aVar);
        return r(this.b, this.c, this.f4622d, i2);
    }

    public void J(DataOutput dataOutput) {
        byte b;
        if (this.f4623e == 0) {
            if (this.f4622d != 0) {
                dataOutput.writeByte(this.b);
                dataOutput.writeByte(this.c);
                b = this.f4622d;
            } else if (this.c == 0) {
                b = this.b;
            } else {
                dataOutput.writeByte(this.b);
                b = this.c;
            }
            dataOutput.writeByte(~b);
            return;
        }
        dataOutput.writeByte(this.b);
        dataOutput.writeByte(this.c);
        dataOutput.writeByte(this.f4622d);
        dataOutput.writeInt(this.f4623e);
    }

    @Override // l.b.a.w.c, l.b.a.x.e
    public o a(j jVar) {
        return super.a(jVar);
    }

    @Override // l.b.a.w.c, l.b.a.x.e
    public int b(j jVar) {
        return jVar instanceof l.b.a.x.a ? t(jVar) : super.b(jVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.b.a.w.c, l.b.a.x.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) b.NANOS;
        }
        if (lVar == k.f4780g) {
            return this;
        }
        if (lVar == k.b || lVar == k.a || lVar == k.f4777d || lVar == k.f4778e || lVar == k.f4779f) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.x.d
    public d e(f fVar) {
        boolean z = fVar instanceof h;
        d dVar = fVar;
        if (!z) {
            dVar = fVar.n(this);
        }
        return (h) dVar;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.b == hVar.b && this.c == hVar.c && this.f4622d == hVar.f4622d && this.f4623e == hVar.f4623e;
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar.i() : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.x.d
    public d h(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    @Override // java.lang.Object
    public int hashCode() {
        long E = E();
        return (int) (E ^ (E >>> 32));
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar == l.b.a.x.a.NANO_OF_DAY ? E() : jVar == l.b.a.x.a.MICRO_OF_DAY ? E() / 1000 : (long) t(jVar) : jVar.f(this);
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(l.b.a.x.a.NANO_OF_DAY, E());
    }

    @Override // l.b.a.x.d
    public long o(d dVar, m mVar) {
        long j2;
        h s = s(dVar);
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
    public int compareTo(h hVar) {
        int d2 = g.b.a.c.c.d.d(this.b, hVar.b);
        if (d2 != 0) {
            return d2;
        }
        int d3 = g.b.a.c.c.d.d(this.c, hVar.c);
        if (d3 != 0) {
            return d3;
        }
        int d4 = g.b.a.c.c.d.d(this.f4622d, hVar.f4622d);
        return d4 == 0 ? g.b.a.c.c.d.d(this.f4623e, hVar.f4623e) : d4;
    }

    public final int t(j jVar) {
        switch (((l.b.a.x.a) jVar).ordinal()) {
            case 0:
                return this.f4623e;
            case 1:
                throw new b(a.d("Field too large for an int: ", jVar));
            case 2:
                return this.f4623e / 1000;
            case 3:
                throw new b(a.d("Field too large for an int: ", jVar));
            case 4:
                return this.f4623e / 1000000;
            case 5:
                return (int) (E() / 1000000);
            case 6:
                return this.f4622d;
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
                byte b = this.b;
                if (b == 0) {
                    return 24;
                }
                return b;
            case 14:
                return this.b / 12;
            default:
                throw new n(a.d("Unsupported field: ", jVar));
        }
    }

    @Override // java.lang.Object
    public String toString() {
        int i2;
        StringBuilder sb = new StringBuilder(18);
        byte b = this.b;
        byte b2 = this.c;
        byte b3 = this.f4622d;
        int i3 = this.f4623e;
        sb.append(b < 10 ? "0" : "");
        sb.append((int) b);
        String str = ":0";
        sb.append(b2 < 10 ? str : ":");
        sb.append((int) b2);
        if (b3 > 0 || i3 > 0) {
            if (b3 >= 10) {
                str = ":";
            }
            sb.append(str);
            sb.append((int) b3);
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
    public h m(long j2, m mVar) {
        if (!(mVar instanceof b)) {
            return (h) mVar.c(this, j2);
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

    public h z(long j2) {
        return j2 == 0 ? this : r(((((int) (j2 % 24)) + this.b) + 24) % 24, this.c, this.f4622d, this.f4623e);
    }
}
