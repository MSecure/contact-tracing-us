package e.c.a;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.nearby.messages.Strategy;
import e.c.a.v.c;
import e.c.a.w.a;
import e.c.a.w.b;
import e.c.a.w.d;
import e.c.a.w.e;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.m;
import e.c.a.w.n;
import e.c.a.w.o;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class g extends c implements d, f, Comparable<g>, Serializable {
    public static final g f;
    public static final g g = new g(23, 59, 59, 999999999);
    public static final g h;
    public static final g[] i = new g[24];

    /* renamed from: b  reason: collision with root package name */
    public final byte f4977b;

    /* renamed from: c  reason: collision with root package name */
    public final byte f4978c;

    /* renamed from: d  reason: collision with root package name */
    public final byte f4979d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4980e;

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
                f = gVarArr[0];
                return;
            }
        }
    }

    public g(int i2, int i3, int i4, int i5) {
        this.f4977b = (byte) i2;
        this.f4978c = (byte) i3;
        this.f4979d = (byte) i4;
        this.f4980e = i5;
    }

    public static g A(long j) {
        a aVar = a.SECOND_OF_DAY;
        aVar.f5158c.b(j, aVar);
        int i2 = (int) (j / 3600);
        long j2 = j - ((long) (i2 * 3600));
        int i3 = (int) (j2 / 60);
        return t(i2, i3, (int) (j2 - ((long) (i3 * 60))), 0);
    }

    public static g B(long j, int i2) {
        a aVar = a.SECOND_OF_DAY;
        aVar.f5158c.b(j, aVar);
        a aVar2 = a.NANO_OF_SECOND;
        aVar2.f5158c.b((long) i2, aVar2);
        int i3 = (int) (j / 3600);
        long j2 = j - ((long) (i3 * 3600));
        int i4 = (int) (j2 / 60);
        return t(i3, i4, (int) (j2 - ((long) (i4 * 60))), i2);
    }

    public static g H(DataInput dataInput) {
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
        return y(readByte, i4, i2, i3);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static g t(int i2, int i3, int i4, int i5) {
        return ((i3 | i4) | i5) == 0 ? i[i2] : new g(i2, i3, i4, i5);
    }

    public static g u(e eVar) {
        g gVar = (g) eVar.f(k.g);
        if (gVar != null) {
            return gVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to obtain LocalTime from TemporalAccessor: ");
        sb.append(eVar);
        sb.append(", type ");
        throw new a(c.a.a.a.a.d(eVar, sb));
    }

    public static g w(int i2, int i3) {
        a aVar = a.HOUR_OF_DAY;
        aVar.f5158c.b((long) i2, aVar);
        if (i3 == 0) {
            return i[i2];
        }
        a aVar2 = a.MINUTE_OF_HOUR;
        aVar2.f5158c.b((long) i3, aVar2);
        return new g(i2, i3, 0, 0);
    }

    private Object writeReplace() {
        return new m((byte) 5, this);
    }

    public static g x(int i2, int i3, int i4) {
        a aVar = a.HOUR_OF_DAY;
        aVar.f5158c.b((long) i2, aVar);
        if ((i3 | i4) == 0) {
            return i[i2];
        }
        a aVar2 = a.MINUTE_OF_HOUR;
        aVar2.f5158c.b((long) i3, aVar2);
        a aVar3 = a.SECOND_OF_MINUTE;
        aVar3.f5158c.b((long) i4, aVar3);
        return new g(i2, i3, i4, 0);
    }

    public static g y(int i2, int i3, int i4, int i5) {
        a aVar = a.HOUR_OF_DAY;
        aVar.f5158c.b((long) i2, aVar);
        a aVar2 = a.MINUTE_OF_HOUR;
        aVar2.f5158c.b((long) i3, aVar2);
        a aVar3 = a.SECOND_OF_MINUTE;
        aVar3.f5158c.b((long) i4, aVar3);
        a aVar4 = a.NANO_OF_SECOND;
        aVar4.f5158c.b((long) i5, aVar4);
        return t(i2, i3, i4, i5);
    }

    public static g z(long j) {
        a aVar = a.NANO_OF_DAY;
        aVar.f5158c.b(j, aVar);
        int i2 = (int) (j / 3600000000000L);
        long j2 = j - (((long) i2) * 3600000000000L);
        int i3 = (int) (j2 / 60000000000L);
        long j3 = j2 - (((long) i3) * 60000000000L);
        int i4 = (int) (j3 / 1000000000);
        return t(i2, i3, i4, (int) (j3 - (((long) i4) * 1000000000)));
    }

    /* renamed from: C */
    public g o(long j, m mVar) {
        if (!(mVar instanceof b)) {
            return (g) mVar.f(this, j);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return F(j);
            case 1:
                return F((j % 86400000000L) * 1000);
            case 2:
                return F((j % 86400000) * 1000000);
            case 3:
                return G(j);
            case 4:
                return E(j);
            case 5:
                return D(j);
            case 6:
                return D((j % 2) * 12);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public g D(long j) {
        return j == 0 ? this : t(((((int) (j % 24)) + this.f4977b) + 24) % 24, this.f4978c, this.f4979d, this.f4980e);
    }

    public g E(long j) {
        if (j == 0) {
            return this;
        }
        int i2 = (this.f4977b * 60) + this.f4978c;
        int i3 = ((((int) (j % 1440)) + i2) + 1440) % 1440;
        return i2 == i3 ? this : t(i3 / 60, i3 % 60, this.f4979d, this.f4980e);
    }

    public g F(long j) {
        if (j == 0) {
            return this;
        }
        long I = I();
        long j2 = (((j % 86400000000000L) + I) + 86400000000000L) % 86400000000000L;
        return I == j2 ? this : t((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
    }

    public g G(long j) {
        if (j == 0) {
            return this;
        }
        int i2 = (this.f4978c * 60) + (this.f4977b * 3600) + this.f4979d;
        int i3 = ((((int) (j % 86400)) + i2) + Strategy.TTL_SECONDS_MAX) % Strategy.TTL_SECONDS_MAX;
        return i2 == i3 ? this : t(i3 / 3600, (i3 / 60) % 60, i3 % 60, this.f4980e);
    }

    public long I() {
        return (((long) this.f4979d) * 1000000000) + (((long) this.f4978c) * 60000000000L) + (((long) this.f4977b) * 3600000000000L) + ((long) this.f4980e);
    }

    public int J() {
        return (this.f4978c * 60) + (this.f4977b * 3600) + this.f4979d;
    }

    /* renamed from: K */
    public g n(j jVar, long j) {
        if (!(jVar instanceof a)) {
            return (g) jVar.f(this, j);
        }
        a aVar = (a) jVar;
        aVar.f5158c.b(j, aVar);
        switch (aVar.ordinal()) {
            case 0:
                return M((int) j);
            case 1:
                return z(j);
            case 2:
                return M(((int) j) * 1000);
            case 3:
                return z(j * 1000);
            case 4:
                return M(((int) j) * 1000000);
            case 5:
                return z(j * 1000000);
            case 6:
                int i2 = (int) j;
                if (this.f4979d == i2) {
                    return this;
                }
                a aVar2 = a.SECOND_OF_MINUTE;
                aVar2.f5158c.b((long) i2, aVar2);
                return t(this.f4977b, this.f4978c, i2, this.f4980e);
            case 7:
                return G(j - ((long) J()));
            case 8:
                int i3 = (int) j;
                if (this.f4978c == i3) {
                    return this;
                }
                a aVar3 = a.MINUTE_OF_HOUR;
                aVar3.f5158c.b((long) i3, aVar3);
                return t(this.f4977b, i3, this.f4979d, this.f4980e);
            case 9:
                return E(j - ((long) ((this.f4977b * 60) + this.f4978c)));
            case 10:
                return D(j - ((long) (this.f4977b % 12)));
            case 11:
                if (j == 12) {
                    j = 0;
                }
                return D(j - ((long) (this.f4977b % 12)));
            case 12:
                return L((int) j);
            case 13:
                if (j == 24) {
                    j = 0;
                }
                return L((int) j);
            case 14:
                return D((j - ((long) (this.f4977b / 12))) * 12);
            default:
                throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }
    }

    public g L(int i2) {
        if (this.f4977b == i2) {
            return this;
        }
        a aVar = a.HOUR_OF_DAY;
        aVar.f5158c.b((long) i2, aVar);
        return t(i2, this.f4978c, this.f4979d, this.f4980e);
    }

    public g M(int i2) {
        if (this.f4980e == i2) {
            return this;
        }
        a aVar = a.NANO_OF_SECOND;
        aVar.f5158c.b((long) i2, aVar);
        return t(this.f4977b, this.f4978c, this.f4979d, i2);
    }

    public void N(DataOutput dataOutput) {
        byte b2;
        if (this.f4980e == 0) {
            if (this.f4979d != 0) {
                dataOutput.writeByte(this.f4977b);
                dataOutput.writeByte(this.f4978c);
                b2 = this.f4979d;
            } else if (this.f4978c == 0) {
                b2 = this.f4977b;
            } else {
                dataOutput.writeByte(this.f4977b);
                b2 = this.f4978c;
            }
            dataOutput.writeByte(~b2);
            return;
        }
        dataOutput.writeByte(this.f4977b);
        dataOutput.writeByte(this.f4978c);
        dataOutput.writeByte(this.f4979d);
        dataOutput.writeInt(this.f4980e);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        return super.b(jVar);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        return jVar instanceof a ? v(jVar) : super.d(jVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f4977b == gVar.f4977b && this.f4978c == gVar.f4978c && this.f4979d == gVar.f4979d && this.f4980e == gVar.f4980e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: e.c.a.g */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5179c) {
            return (R) b.NANOS;
        }
        if (lVar == k.g) {
            return this;
        }
        if (lVar == k.f5178b || lVar == k.f5177a || lVar == k.f5180d || lVar == k.f5181e || lVar == k.f) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // e.c.a.w.d
    public d g(f fVar) {
        boolean z = fVar instanceof g;
        d dVar = fVar;
        if (!z) {
            dVar = ((e) fVar).p(this);
        }
        return (g) dVar;
    }

    public int hashCode() {
        long I = I();
        return (int) (I ^ (I >>> 32));
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof a ? jVar.l() : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.d
    public d k(long j, m mVar) {
        return j == Long.MIN_VALUE ? o(RecyclerView.FOREVER_NS, mVar).o(1, mVar) : o(-j, mVar);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        return jVar instanceof a ? jVar == a.NANO_OF_DAY ? I() : jVar == a.MICRO_OF_DAY ? I() / 1000 : (long) v(jVar) : jVar.i(this);
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        return dVar.n(a.NANO_OF_DAY, I());
    }

    @Override // e.c.a.w.d
    public long q(d dVar, m mVar) {
        long j;
        g u = u(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, u);
        }
        long I = u.I() - I();
        switch (((b) mVar).ordinal()) {
            case 0:
                return I;
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
        return I / j;
    }

    /* renamed from: s */
    public int compareTo(g gVar) {
        int z = c.b.a.a.c.n.c.z(this.f4977b, gVar.f4977b);
        if (z != 0) {
            return z;
        }
        int z2 = c.b.a.a.c.n.c.z(this.f4978c, gVar.f4978c);
        if (z2 != 0) {
            return z2;
        }
        int z3 = c.b.a.a.c.n.c.z(this.f4979d, gVar.f4979d);
        return z3 == 0 ? c.b.a.a.c.n.c.z(this.f4980e, gVar.f4980e) : z3;
    }

    public String toString() {
        int i2;
        StringBuilder sb = new StringBuilder(18);
        byte b2 = this.f4977b;
        byte b3 = this.f4978c;
        byte b4 = this.f4979d;
        int i3 = this.f4980e;
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

    public final int v(j jVar) {
        switch (((a) jVar).ordinal()) {
            case 0:
                return this.f4980e;
            case 1:
                throw new a(c.a.a.a.a.c("Field too large for an int: ", jVar));
            case 2:
                return this.f4980e / 1000;
            case 3:
                throw new a(c.a.a.a.a.c("Field too large for an int: ", jVar));
            case 4:
                return this.f4980e / 1000000;
            case 5:
                return (int) (I() / 1000000);
            case 6:
                return this.f4979d;
            case 7:
                return J();
            case 8:
                return this.f4978c;
            case 9:
                return (this.f4977b * 60) + this.f4978c;
            case 10:
                return this.f4977b % 12;
            case 11:
                int i2 = this.f4977b % 12;
                if (i2 % 12 == 0) {
                    return 12;
                }
                return i2;
            case 12:
                return this.f4977b;
            case 13:
                byte b2 = this.f4977b;
                if (b2 == 0) {
                    return 24;
                }
                return b2;
            case 14:
                return this.f4977b / 12;
            default:
                throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }
    }
}
