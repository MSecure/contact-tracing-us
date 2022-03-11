package l.b.a.y;

import g.b.a.c.c.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Objects;
import l.b.a.c;
import l.b.a.h;
import l.b.a.i;
import l.b.a.r;
/* loaded from: classes.dex */
public final class e implements Serializable {
    public final i b;
    public final byte c;

    /* renamed from: d  reason: collision with root package name */
    public final c f4804d;

    /* renamed from: e  reason: collision with root package name */
    public final h f4805e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4806f;

    /* renamed from: g  reason: collision with root package name */
    public final a f4807g;

    /* renamed from: h  reason: collision with root package name */
    public final r f4808h;

    /* renamed from: i  reason: collision with root package name */
    public final r f4809i;

    /* renamed from: j  reason: collision with root package name */
    public final r f4810j;

    /* loaded from: classes.dex */
    public enum a {
        UTC,
        WALL,
        STANDARD
    }

    public e(i iVar, int i2, c cVar, h hVar, int i3, a aVar, r rVar, r rVar2, r rVar3) {
        this.b = iVar;
        this.c = (byte) i2;
        this.f4804d = cVar;
        this.f4805e = hVar;
        this.f4806f = i3;
        this.f4807g = aVar;
        this.f4808h = rVar;
        this.f4809i = rVar2;
        this.f4810j = rVar3;
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
        return new e(u, i2, r, h.x((long) d.j(readInt2, 86400)), readInt2 >= 0 ? readInt2 / 86400 : ((readInt2 + 1) / 86400) - 1, aVar, z, rVar, rVar2);
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public void b(DataOutput dataOutput) {
        int F = (this.f4806f * 86400) + this.f4805e.F();
        int i2 = this.f4808h.c;
        int i3 = this.f4809i.c - i2;
        int i4 = this.f4810j.c - i2;
        byte b = (F % 3600 != 0 || F > 86400) ? 31 : F == 86400 ? 24 : this.f4805e.b;
        int i5 = i2 % 900 == 0 ? (i2 / 900) + 128 : 255;
        int i6 = (i3 == 0 || i3 == 1800 || i3 == 3600) ? i3 / 1800 : 3;
        int i7 = (i4 == 0 || i4 == 1800 || i4 == 3600) ? i4 / 1800 : 3;
        c cVar = this.f4804d;
        dataOutput.writeInt((this.b.r() << 28) + ((this.c + 32) << 22) + ((cVar == null ? 0 : cVar.q()) << 19) + (b << 14) + (this.f4807g.ordinal() << 12) + (i5 << 4) + (i6 << 2) + i7);
        if (b == 31) {
            dataOutput.writeInt(F);
        }
        if (i5 == 255) {
            dataOutput.writeInt(i2);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.f4809i.c);
        }
        if (i7 == 3) {
            dataOutput.writeInt(this.f4810j.c);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.b == eVar.b && this.c == eVar.c && this.f4804d == eVar.f4804d && this.f4807g == eVar.f4807g && this.f4806f == eVar.f4806f && this.f4805e.equals(eVar.f4805e) && this.f4808h.equals(eVar.f4808h) && this.f4809i.equals(eVar.f4809i) && this.f4810j.equals(eVar.f4810j);
    }

    @Override // java.lang.Object
    public int hashCode() {
        int F = ((this.f4805e.F() + this.f4806f) << 15) + (this.b.ordinal() << 11) + ((this.c + 32) << 5);
        c cVar = this.f4804d;
        return ((this.f4808h.c ^ (this.f4807g.ordinal() + (F + ((cVar == null ? 7 : cVar.ordinal()) << 2)))) ^ this.f4809i.c) ^ this.f4810j.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
    @Override // java.lang.Object
    /* Code decompiled incorrectly, please refer to instructions dump */
    public String toString() {
        String str;
        StringBuilder h2 = f.a.a.a.a.h("TransitionRule[");
        r rVar = this.f4809i;
        r rVar2 = this.f4810j;
        Objects.requireNonNull(rVar);
        h2.append(rVar2.c - rVar.c > 0 ? "Gap " : "Overlap ");
        h2.append(this.f4809i);
        h2.append(" to ");
        h2.append(this.f4810j);
        h2.append(", ");
        c cVar = this.f4804d;
        if (cVar != null) {
            byte b = this.c;
            h2.append(cVar.name());
            if (b == -1) {
                str = " on or before last day of ";
            } else if (b < 0) {
                h2.append(" on or before last day minus ");
                h2.append((-this.c) - 1);
                str = " of ";
            } else {
                h2.append(" on or after ");
            }
            h2.append(str);
            h2.append(this.b.name());
            h2.append(" at ");
            if (this.f4806f != 0) {
                h2.append(this.f4805e);
            } else {
                long F = (long) ((this.f4806f * 24 * 60) + (this.f4805e.F() / 60));
                long i2 = d.i(F, 60);
                if (i2 < 10) {
                    h2.append(0);
                }
                h2.append(i2);
                h2.append(':');
                long k2 = (long) d.k(F, 60);
                if (k2 < 10) {
                    h2.append(0);
                }
                h2.append(k2);
            }
            h2.append(" ");
            h2.append(this.f4807g);
            h2.append(", standard offset ");
            h2.append(this.f4808h);
            h2.append(']');
            return h2.toString();
        }
        h2.append(this.b.name());
        h2.append(' ');
        h2.append((int) this.c);
        h2.append(" at ");
        if (this.f4806f != 0) {
        }
        h2.append(" ");
        h2.append(this.f4807g);
        h2.append(", standard offset ");
        h2.append(this.f4808h);
        h2.append(']');
        return h2.toString();
    }
}
