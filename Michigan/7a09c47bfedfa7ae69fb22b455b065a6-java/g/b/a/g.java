package g.b.a;

import b.x.t;
import c.a.a.a.a;
import com.google.android.gms.nearby.messages.Strategy;
import g.b.a.v.c;
import g.b.a.w.b;
import g.b.a.w.d;
import g.b.a.w.e;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.m;
import g.b.a.w.n;
import g.b.a.w.o;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class g extends c implements d, f, Comparable<g>, Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static final g f6416f;

    /* renamed from: g  reason: collision with root package name */
    public static final g f6417g = new g(23, 59, 59, 999999999);
    public static final g h;
    public static final g[] i = new g[24];

    /* renamed from: b  reason: collision with root package name */
    public final byte f6418b;

    /* renamed from: c  reason: collision with root package name */
    public final byte f6419c;

    /* renamed from: d  reason: collision with root package name */
    public final byte f6420d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6421e;

    static {
        int i2 = 0;
        while (true) {
            g[] gVarArr = i;
            if (i2 < gVarArr.length) {
                gVarArr[i2] = new g(i2, 0, 0, 0);
                i2++;
            } else {
                h = gVarArr[0];
                g gVar = gVarArr[12];
                f6416f = gVarArr[0];
                return;
            }
        }
    }

    public g(int i2, int i3, int i4, int i5) {
        this.f6418b = (byte) i2;
        this.f6419c = (byte) i3;
        this.f6420d = (byte) i4;
        this.f6421e = i5;
    }

    public static g B(int i2, int i3, int i4, int i5) {
        return ((i3 | i4) | i5) == 0 ? i[i2] : new g(i2, i3, i4, i5);
    }

    public static g D(e eVar) {
        g gVar = (g) eVar.f(k.f6662g);
        if (gVar != null) {
            return gVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to obtain LocalTime from TemporalAccessor: ");
        sb.append(eVar);
        sb.append(", type ");
        throw new a(a.e(eVar, sb));
    }

    public static g G(int i2, int i3) {
        g.b.a.w.a aVar = g.b.a.w.a.HOUR_OF_DAY;
        aVar.f6633c.b((long) i2, aVar);
        if (i3 == 0) {
            return i[i2];
        }
        g.b.a.w.a aVar2 = g.b.a.w.a.MINUTE_OF_HOUR;
        aVar2.f6633c.b((long) i3, aVar2);
        return new g(i2, i3, 0, 0);
    }

    public static g H(int i2, int i3, int i4) {
        g.b.a.w.a aVar = g.b.a.w.a.HOUR_OF_DAY;
        aVar.f6633c.b((long) i2, aVar);
        if ((i3 | i4) == 0) {
            return i[i2];
        }
        g.b.a.w.a aVar2 = g.b.a.w.a.MINUTE_OF_HOUR;
        aVar2.f6633c.b((long) i3, aVar2);
        g.b.a.w.a aVar3 = g.b.a.w.a.SECOND_OF_MINUTE;
        aVar3.f6633c.b((long) i4, aVar3);
        return new g(i2, i3, i4, 0);
    }

    public static g L(int i2, int i3, int i4, int i5) {
        g.b.a.w.a aVar = g.b.a.w.a.HOUR_OF_DAY;
        aVar.f6633c.b((long) i2, aVar);
        g.b.a.w.a aVar2 = g.b.a.w.a.MINUTE_OF_HOUR;
        aVar2.f6633c.b((long) i3, aVar2);
        g.b.a.w.a aVar3 = g.b.a.w.a.SECOND_OF_MINUTE;
        aVar3.f6633c.b((long) i4, aVar3);
        g.b.a.w.a aVar4 = g.b.a.w.a.NANO_OF_SECOND;
        aVar4.f6633c.b((long) i5, aVar4);
        return B(i2, i3, i4, i5);
    }

    public static g P(long j) {
        g.b.a.w.a aVar = g.b.a.w.a.NANO_OF_DAY;
        aVar.f6633c.b(j, aVar);
        int i2 = (int) (j / 3600000000000L);
        long j2 = j - (((long) i2) * 3600000000000L);
        int i3 = (int) (j2 / 60000000000L);
        long j3 = j2 - (((long) i3) * 60000000000L);
        int i4 = (int) (j3 / 1000000000);
        return B(i2, i3, i4, (int) (j3 - (((long) i4) * 1000000000)));
    }

    public static g Q(long j) {
        g.b.a.w.a aVar = g.b.a.w.a.SECOND_OF_DAY;
        aVar.f6633c.b(j, aVar);
        int i2 = (int) (j / 3600);
        long j2 = j - ((long) (i2 * 3600));
        int i3 = (int) (j2 / 60);
        return B(i2, i3, (int) (j2 - ((long) (i3 * 60))), 0);
    }

    public static g R(long j, int i2) {
        g.b.a.w.a aVar = g.b.a.w.a.SECOND_OF_DAY;
        aVar.f6633c.b(j, aVar);
        g.b.a.w.a aVar2 = g.b.a.w.a.NANO_OF_SECOND;
        aVar2.f6633c.b((long) i2, aVar2);
        int i3 = (int) (j / 3600);
        long j2 = j - ((long) (i3 * 3600));
        int i4 = (int) (j2 / 60);
        return B(i3, i4, (int) (j2 - ((long) (i4 * 60))), i2);
    }

    public static g X(DataInput dataInput) {
        int i2;
        int i3;
        int readByte = dataInput.readByte();
        int i4 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i2 = 0;
            i3 = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                int i5 = ~readByte2;
                i3 = 0;
                i4 = i5;
                i2 = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i2 = ~readByte3;
                } else {
                    i4 = dataInput.readInt();
                    i2 = readByte3;
                }
                i3 = i4;
                i4 = readByte2;
            }
        }
        return L(readByte, i4, i2, i3);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 5, this);
    }

    /* renamed from: A */
    public int compareTo(g gVar) {
        int K = t.K(this.f6418b, gVar.f6418b);
        if (K != 0) {
            return K;
        }
        int K2 = t.K(this.f6419c, gVar.f6419c);
        if (K2 != 0) {
            return K2;
        }
        int K3 = t.K(this.f6420d, gVar.f6420d);
        return K3 == 0 ? t.K(this.f6421e, gVar.f6421e) : K3;
    }

    public final int F(j jVar) {
        switch (((g.b.a.w.a) jVar).ordinal()) {
            case 0:
                return this.f6421e;
            case 1:
                throw new a(a.d("Field too large for an int: ", jVar));
            case 2:
                return this.f6421e / 1000;
            case 3:
                throw new a(a.d("Field too large for an int: ", jVar));
            case 4:
                return this.f6421e / 1000000;
            case 5:
                return (int) (Y() / 1000000);
            case 6:
                return this.f6420d;
            case 7:
                return Z();
            case 8:
                return this.f6419c;
            case 9:
                return (this.f6418b * 60) + this.f6419c;
            case 10:
                return this.f6418b % 12;
            case 11:
                int i2 = this.f6418b % 12;
                if (i2 % 12 == 0) {
                    return 12;
                }
                return i2;
            case 12:
                return this.f6418b;
            case 13:
                byte b2 = this.f6418b;
                if (b2 == 0) {
                    return 24;
                }
                return b2;
            case 14:
                return this.f6418b / 12;
            default:
                throw new n(a.d("Unsupported field: ", jVar));
        }
    }

    /* renamed from: S */
    public g s(long j, m mVar) {
        if (!(mVar instanceof b)) {
            return (g) mVar.f(this, j);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return V(j);
            case 1:
                return V((j % 86400000000L) * 1000);
            case 2:
                return V((j % 86400000) * 1000000);
            case 3:
                return W(j);
            case 4:
                return U(j);
            case 5:
                return T(j);
            case 6:
                return T((j % 2) * 12);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public g T(long j) {
        return j == 0 ? this : B(((((int) (j % 24)) + this.f6418b) + 24) % 24, this.f6419c, this.f6420d, this.f6421e);
    }

    public g U(long j) {
        if (j == 0) {
            return this;
        }
        int i2 = (this.f6418b * 60) + this.f6419c;
        int i3 = ((((int) (j % 1440)) + i2) + 1440) % 1440;
        return i2 == i3 ? this : B(i3 / 60, i3 % 60, this.f6420d, this.f6421e);
    }

    public g V(long j) {
        if (j == 0) {
            return this;
        }
        long Y = Y();
        long j2 = (((j % 86400000000000L) + Y) + 86400000000000L) % 86400000000000L;
        return Y == j2 ? this : B((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
    }

    public g W(long j) {
        if (j == 0) {
            return this;
        }
        int i2 = (this.f6419c * 60) + (this.f6418b * 3600) + this.f6420d;
        int i3 = ((((int) (j % 86400)) + i2) + Strategy.TTL_SECONDS_MAX) % Strategy.TTL_SECONDS_MAX;
        return i2 == i3 ? this : B(i3 / 3600, (i3 / 60) % 60, i3 % 60, this.f6421e);
    }

    public long Y() {
        return (((long) this.f6420d) * 1000000000) + (((long) this.f6419c) * 60000000000L) + (((long) this.f6418b) * 3600000000000L) + ((long) this.f6421e);
    }

    public int Z() {
        return (this.f6419c * 60) + (this.f6418b * 3600) + this.f6420d;
    }

    /* renamed from: a0 */
    public g r(j jVar, long j) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return (g) jVar.f(this, j);
        }
        g.b.a.w.a aVar = (g.b.a.w.a) jVar;
        aVar.f6633c.b(j, aVar);
        switch (aVar.ordinal()) {
            case 0:
                return c0((int) j);
            case 1:
                return P(j);
            case 2:
                return c0(((int) j) * 1000);
            case 3:
                return P(j * 1000);
            case 4:
                return c0(((int) j) * 1000000);
            case 5:
                return P(j * 1000000);
            case 6:
                int i2 = (int) j;
                if (this.f6420d == i2) {
                    return this;
                }
                g.b.a.w.a aVar2 = g.b.a.w.a.SECOND_OF_MINUTE;
                aVar2.f6633c.b((long) i2, aVar2);
                return B(this.f6418b, this.f6419c, i2, this.f6421e);
            case 7:
                return W(j - ((long) Z()));
            case 8:
                int i3 = (int) j;
                if (this.f6419c == i3) {
                    return this;
                }
                g.b.a.w.a aVar3 = g.b.a.w.a.MINUTE_OF_HOUR;
                aVar3.f6633c.b((long) i3, aVar3);
                return B(this.f6418b, i3, this.f6420d, this.f6421e);
            case 9:
                return U(j - ((long) ((this.f6418b * 60) + this.f6419c)));
            case 10:
                return T(j - ((long) (this.f6418b % 12)));
            case 11:
                if (j == 12) {
                    j = 0;
                }
                return T(j - ((long) (this.f6418b % 12)));
            case 12:
                return b0((int) j);
            case 13:
                if (j == 24) {
                    j = 0;
                }
                return b0((int) j);
            case 14:
                return T((j - ((long) (this.f6418b / 12))) * 12);
            default:
                throw new n(a.d("Unsupported field: ", jVar));
        }
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        return super.b(jVar);
    }

    public g b0(int i2) {
        if (this.f6418b == i2) {
            return this;
        }
        g.b.a.w.a aVar = g.b.a.w.a.HOUR_OF_DAY;
        aVar.f6633c.b((long) i2, aVar);
        return B(i2, this.f6419c, this.f6420d, this.f6421e);
    }

    public g c0(int i2) {
        if (this.f6421e == i2) {
            return this;
        }
        g.b.a.w.a aVar = g.b.a.w.a.NANO_OF_SECOND;
        aVar.f6633c.b((long) i2, aVar);
        return B(this.f6418b, this.f6419c, this.f6420d, i2);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        return jVar instanceof g.b.a.w.a ? F(jVar) : super.d(jVar);
    }

    public void d0(DataOutput dataOutput) {
        byte b2;
        if (this.f6421e == 0) {
            if (this.f6420d != 0) {
                dataOutput.writeByte(this.f6418b);
                dataOutput.writeByte(this.f6419c);
                b2 = this.f6420d;
            } else if (this.f6419c == 0) {
                b2 = this.f6418b;
            } else {
                dataOutput.writeByte(this.f6418b);
                b2 = this.f6419c;
            }
            dataOutput.writeByte(~b2);
            return;
        }
        dataOutput.writeByte(this.f6418b);
        dataOutput.writeByte(this.f6419c);
        dataOutput.writeByte(this.f6420d);
        dataOutput.writeInt(this.f6421e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f6418b == gVar.f6418b && this.f6419c == gVar.f6419c && this.f6420d == gVar.f6420d && this.f6421e == gVar.f6421e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: g.b.a.g */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6658c) {
            return (R) b.NANOS;
        }
        if (lVar == k.f6662g) {
            return this;
        }
        if (lVar == k.f6657b || lVar == k.f6656a || lVar == k.f6659d || lVar == k.f6660e || lVar == k.f6661f) {
            return null;
        }
        return lVar.a(this);
    }

    public int hashCode() {
        long Y = Y();
        return (int) (Y ^ (Y >>> 32));
    }

    @Override // g.b.a.w.d
    public d i(f fVar) {
        boolean z = fVar instanceof g;
        d dVar = fVar;
        if (!z) {
            dVar = ((e) fVar).t(this);
        }
        return (g) dVar;
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar.n() : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.d
    public d m(long j, m mVar) {
        return j == Long.MIN_VALUE ? s(Long.MAX_VALUE, mVar).s(1, mVar) : s(-j, mVar);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar == g.b.a.w.a.NANO_OF_DAY ? Y() : jVar == g.b.a.w.a.MICRO_OF_DAY ? Y() / 1000 : (long) F(jVar) : jVar.k(this);
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        return dVar.r(g.b.a.w.a.NANO_OF_DAY, Y());
    }

    public String toString() {
        int i2;
        StringBuilder sb = new StringBuilder(18);
        byte b2 = this.f6418b;
        byte b3 = this.f6419c;
        byte b4 = this.f6420d;
        int i3 = this.f6421e;
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

    @Override // g.b.a.w.d
    public long y(d dVar, m mVar) {
        long j;
        g D = D(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, D);
        }
        long Y = D.Y() - Y();
        switch (((b) mVar).ordinal()) {
            case 0:
                return Y;
            case 1:
                j = 1000;
                break;
            case 2:
                j = 1000000;
                break;
            case 3:
                j = 1000000000;
                break;
            case 4:
                j = 60000000000L;
                break;
            case 5:
                j = 3600000000000L;
                break;
            case 6:
                j = 43200000000000L;
                break;
            default:
                throw new n("Unsupported unit: " + mVar);
        }
        return Y / j;
    }
}
