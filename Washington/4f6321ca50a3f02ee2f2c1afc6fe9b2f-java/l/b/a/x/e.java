package l.b.a.x;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Objects;
import l.b.a.b;
import l.b.a.g;
import l.b.a.h;
import l.b.a.q;

public final class e implements Serializable {
    public final h b;
    public final byte c;

    /* renamed from: d  reason: collision with root package name */
    public final b f4233d;

    /* renamed from: e  reason: collision with root package name */
    public final g f4234e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4235f;

    /* renamed from: g  reason: collision with root package name */
    public final a f4236g;

    /* renamed from: h  reason: collision with root package name */
    public final q f4237h;

    /* renamed from: i  reason: collision with root package name */
    public final q f4238i;

    /* renamed from: j  reason: collision with root package name */
    public final q f4239j;

    public enum a {
        UTC,
        WALL,
        STANDARD
    }

    public e(h hVar, int i2, b bVar, g gVar, int i3, a aVar, q qVar, q qVar2, q qVar3) {
        this.b = hVar;
        this.c = (byte) i2;
        this.f4233d = bVar;
        this.f4234e = gVar;
        this.f4235f = i3;
        this.f4236g = aVar;
        this.f4237h = qVar;
        this.f4238i = qVar2;
        this.f4239j = qVar3;
    }

    public static e a(DataInput dataInput) {
        q qVar;
        q qVar2;
        int readInt = dataInput.readInt();
        h u = h.u(readInt >>> 28);
        int i2 = ((264241152 & readInt) >>> 22) - 32;
        int i3 = (3670016 & readInt) >>> 19;
        b r = i3 == 0 ? null : b.r(i3);
        int i4 = (507904 & readInt) >>> 14;
        a aVar = a.values()[(readInt & 12288) >>> 12];
        int i5 = (readInt & 4080) >>> 4;
        int i6 = (readInt & 12) >>> 2;
        int i7 = readInt & 3;
        int readInt2 = i4 == 31 ? dataInput.readInt() : i4 * 3600;
        q z = q.z(i5 == 255 ? dataInput.readInt() : (i5 - 128) * 900);
        if (i6 == 3) {
            qVar = q.z(dataInput.readInt());
        } else {
            qVar = q.z((i6 * 1800) + z.c);
        }
        if (i7 == 3) {
            qVar2 = q.z(dataInput.readInt());
        } else {
            qVar2 = q.z((i7 * 1800) + z.c);
        }
        if (i2 < -28 || i2 > 31 || i2 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        return new e(u, i2, r, g.x((long) f.b.a.c.b.o.b.E0(readInt2, 86400)), readInt2 >= 0 ? readInt2 / 86400 : ((readInt2 + 1) / 86400) - 1, aVar, z, qVar, qVar2);
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public void b(DataOutput dataOutput) {
        byte b2;
        int F = (this.f4235f * 86400) + this.f4234e.F();
        int i2 = this.f4237h.c;
        int i3 = this.f4238i.c - i2;
        int i4 = this.f4239j.c - i2;
        if (F % 3600 != 0 || F > 86400) {
            b2 = 31;
        } else {
            b2 = F == 86400 ? 24 : this.f4234e.b;
        }
        int i5 = i2 % 900 == 0 ? (i2 / 900) + 128 : 255;
        int i6 = (i3 == 0 || i3 == 1800 || i3 == 3600) ? i3 / 1800 : 3;
        int i7 = (i4 == 0 || i4 == 1800 || i4 == 3600) ? i4 / 1800 : 3;
        b bVar = this.f4233d;
        dataOutput.writeInt((this.b.r() << 28) + ((this.c + 32) << 22) + ((bVar == null ? 0 : bVar.q()) << 19) + (b2 << 14) + (this.f4236g.ordinal() << 12) + (i5 << 4) + (i6 << 2) + i7);
        if (b2 == 31) {
            dataOutput.writeInt(F);
        }
        if (i5 == 255) {
            dataOutput.writeInt(i2);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.f4238i.c);
        }
        if (i7 == 3) {
            dataOutput.writeInt(this.f4239j.c);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.b == eVar.b && this.c == eVar.c && this.f4233d == eVar.f4233d && this.f4236g == eVar.f4236g && this.f4235f == eVar.f4235f && this.f4234e.equals(eVar.f4234e) && this.f4237h.equals(eVar.f4237h) && this.f4238i.equals(eVar.f4238i) && this.f4239j.equals(eVar.f4239j);
    }

    public int hashCode() {
        int F = ((this.f4234e.F() + this.f4235f) << 15) + (this.b.ordinal() << 11) + ((this.c + 32) << 5);
        b bVar = this.f4233d;
        return ((this.f4237h.c ^ (this.f4236g.ordinal() + (F + ((bVar == null ? 7 : bVar.ordinal()) << 2)))) ^ this.f4238i.c) ^ this.f4239j.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0087  */
    public String toString() {
        String str;
        StringBuilder h2 = f.a.a.a.a.h("TransitionRule[");
        q qVar = this.f4238i;
        q qVar2 = this.f4239j;
        Objects.requireNonNull(qVar);
        h2.append(qVar2.c - qVar.c > 0 ? "Gap " : "Overlap ");
        h2.append(this.f4238i);
        h2.append(" to ");
        h2.append(this.f4239j);
        h2.append(", ");
        b bVar = this.f4233d;
        if (bVar != null) {
            byte b2 = this.c;
            h2.append(bVar.name());
            if (b2 == -1) {
                str = " on or before last day of ";
            } else if (b2 < 0) {
                h2.append(" on or before last day minus ");
                h2.append((-this.c) - 1);
                str = " of ";
            } else {
                h2.append(" on or after ");
            }
            h2.append(str);
            h2.append(this.b.name());
            h2.append(" at ");
            if (this.f4235f != 0) {
                h2.append(this.f4234e);
            } else {
                long F = (long) ((this.f4235f * 24 * 60) + (this.f4234e.F() / 60));
                long B0 = f.b.a.c.b.o.b.B0(F, 60);
                if (B0 < 10) {
                    h2.append(0);
                }
                h2.append(B0);
                h2.append(':');
                long C0 = (long) f.b.a.c.b.o.b.C0(F, 60);
                if (C0 < 10) {
                    h2.append(0);
                }
                h2.append(C0);
            }
            h2.append(" ");
            h2.append(this.f4236g);
            h2.append(", standard offset ");
            h2.append(this.f4237h);
            h2.append(']');
            return h2.toString();
        }
        h2.append(this.b.name());
        h2.append(' ');
        h2.append((int) this.c);
        h2.append(" at ");
        if (this.f4235f != 0) {
        }
        h2.append(" ");
        h2.append(this.f4236g);
        h2.append(", standard offset ");
        h2.append(this.f4237h);
        h2.append(']');
        return h2.toString();
    }
}
