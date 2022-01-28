package l.b.a.y;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Objects;
import l.b.a.c;
import l.b.a.h;
import l.b.a.i;
import l.b.a.r;

public final class e implements Serializable {
    public final i b;
    public final byte c;

    /* renamed from: d  reason: collision with root package name */
    public final c f4484d;

    /* renamed from: e  reason: collision with root package name */
    public final h f4485e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4486f;

    /* renamed from: g  reason: collision with root package name */
    public final a f4487g;

    /* renamed from: h  reason: collision with root package name */
    public final r f4488h;

    /* renamed from: i  reason: collision with root package name */
    public final r f4489i;

    /* renamed from: j  reason: collision with root package name */
    public final r f4490j;

    public enum a {
        UTC,
        WALL,
        STANDARD
    }

    public e(i iVar, int i2, c cVar, h hVar, int i3, a aVar, r rVar, r rVar2, r rVar3) {
        this.b = iVar;
        this.c = (byte) i2;
        this.f4484d = cVar;
        this.f4485e = hVar;
        this.f4486f = i3;
        this.f4487g = aVar;
        this.f4488h = rVar;
        this.f4489i = rVar2;
        this.f4490j = rVar3;
    }

    public static e a(DataInput dataInput) {
        r rVar;
        r rVar2;
        int readInt = dataInput.readInt();
        i u = i.u(readInt >>> 28);
        int i2 = ((264241152 & readInt) >>> 22) - 32;
        int i3 = (3670016 & readInt) >>> 19;
        c r = i3 == 0 ? null : c.r(i3);
        int i4 = (507904 & readInt) >>> 14;
        a aVar = a.values()[(readInt & 12288) >>> 12];
        int i5 = (readInt & 4080) >>> 4;
        int i6 = (readInt & 12) >>> 2;
        int i7 = readInt & 3;
        int readInt2 = i4 == 31 ? dataInput.readInt() : i4 * 3600;
        r z = r.z(i5 == 255 ? dataInput.readInt() : (i5 - 128) * 900);
        if (i6 == 3) {
            rVar = r.z(dataInput.readInt());
        } else {
            rVar = r.z((i6 * 1800) + z.c);
        }
        if (i7 == 3) {
            rVar2 = r.z(dataInput.readInt());
        } else {
            rVar2 = r.z((i7 * 1800) + z.c);
        }
        if (i2 < -28 || i2 > 31 || i2 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        return new e(u, i2, r, h.x((long) g.b.a.c.c.c.j(readInt2, 86400)), readInt2 >= 0 ? readInt2 / 86400 : ((readInt2 + 1) / 86400) - 1, aVar, z, rVar, rVar2);
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public void b(DataOutput dataOutput) {
        byte b2;
        int F = (this.f4486f * 86400) + this.f4485e.F();
        int i2 = this.f4488h.c;
        int i3 = this.f4489i.c - i2;
        int i4 = this.f4490j.c - i2;
        if (F % 3600 != 0 || F > 86400) {
            b2 = 31;
        } else {
            b2 = F == 86400 ? 24 : this.f4485e.b;
        }
        int i5 = i2 % 900 == 0 ? (i2 / 900) + 128 : 255;
        int i6 = (i3 == 0 || i3 == 1800 || i3 == 3600) ? i3 / 1800 : 3;
        int i7 = (i4 == 0 || i4 == 1800 || i4 == 3600) ? i4 / 1800 : 3;
        c cVar = this.f4484d;
        dataOutput.writeInt((this.b.r() << 28) + ((this.c + 32) << 22) + ((cVar == null ? 0 : cVar.q()) << 19) + (b2 << 14) + (this.f4487g.ordinal() << 12) + (i5 << 4) + (i6 << 2) + i7);
        if (b2 == 31) {
            dataOutput.writeInt(F);
        }
        if (i5 == 255) {
            dataOutput.writeInt(i2);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.f4489i.c);
        }
        if (i7 == 3) {
            dataOutput.writeInt(this.f4490j.c);
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
        return this.b == eVar.b && this.c == eVar.c && this.f4484d == eVar.f4484d && this.f4487g == eVar.f4487g && this.f4486f == eVar.f4486f && this.f4485e.equals(eVar.f4485e) && this.f4488h.equals(eVar.f4488h) && this.f4489i.equals(eVar.f4489i) && this.f4490j.equals(eVar.f4490j);
    }

    public int hashCode() {
        int F = ((this.f4485e.F() + this.f4486f) << 15) + (this.b.ordinal() << 11) + ((this.c + 32) << 5);
        c cVar = this.f4484d;
        return ((this.f4488h.c ^ (this.f4487g.ordinal() + (F + ((cVar == null ? 7 : cVar.ordinal()) << 2)))) ^ this.f4489i.c) ^ this.f4490j.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0087  */
    public String toString() {
        String str;
        StringBuilder i2 = f.a.a.a.a.i("TransitionRule[");
        r rVar = this.f4489i;
        r rVar2 = this.f4490j;
        Objects.requireNonNull(rVar);
        i2.append(rVar2.c - rVar.c > 0 ? "Gap " : "Overlap ");
        i2.append(this.f4489i);
        i2.append(" to ");
        i2.append(this.f4490j);
        i2.append(", ");
        c cVar = this.f4484d;
        if (cVar != null) {
            byte b2 = this.c;
            i2.append(cVar.name());
            if (b2 == -1) {
                str = " on or before last day of ";
            } else if (b2 < 0) {
                i2.append(" on or before last day minus ");
                i2.append((-this.c) - 1);
                str = " of ";
            } else {
                i2.append(" on or after ");
            }
            i2.append(str);
            i2.append(this.b.name());
            i2.append(" at ");
            if (this.f4486f != 0) {
                i2.append(this.f4485e);
            } else {
                long F = (long) ((this.f4486f * 24 * 60) + (this.f4485e.F() / 60));
                long i3 = g.b.a.c.c.c.i(F, 60);
                if (i3 < 10) {
                    i2.append(0);
                }
                i2.append(i3);
                i2.append(':');
                long k2 = (long) g.b.a.c.c.c.k(F, 60);
                if (k2 < 10) {
                    i2.append(0);
                }
                i2.append(k2);
            }
            i2.append(" ");
            i2.append(this.f4487g);
            i2.append(", standard offset ");
            i2.append(this.f4488h);
            i2.append(']');
            return i2.toString();
        }
        i2.append(this.b.name());
        i2.append(' ');
        i2.append((int) this.c);
        i2.append(" at ");
        if (this.f4486f != 0) {
        }
        i2.append(" ");
        i2.append(this.f4487g);
        i2.append(", standard offset ");
        i2.append(this.f4488h);
        i2.append(']');
        return i2.toString();
    }
}
