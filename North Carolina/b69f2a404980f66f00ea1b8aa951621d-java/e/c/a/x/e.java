package e.c.a.x;

import androidx.recyclerview.widget.RecyclerView;
import c.b.a.a.c.n.c;
import com.google.android.gms.nearby.messages.Strategy;
import e.c.a.b;
import e.c.a.g;
import e.c.a.h;
import e.c.a.q;
import gov.nc.dhhs.exposurenotification.BuildConfig;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;

public final class e implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final h f5209b;

    /* renamed from: c  reason: collision with root package name */
    public final byte f5210c;

    /* renamed from: d  reason: collision with root package name */
    public final b f5211d;

    /* renamed from: e  reason: collision with root package name */
    public final g f5212e;
    public final int f;
    public final a g;
    public final q h;
    public final q i;
    public final q j;

    public enum a {
        UTC,
        WALL,
        STANDARD
    }

    public e(h hVar, int i2, b bVar, g gVar, int i3, a aVar, q qVar, q qVar2, q qVar3) {
        this.f5209b = hVar;
        this.f5210c = (byte) i2;
        this.f5211d = bVar;
        this.f5212e = gVar;
        this.f = i3;
        this.g = aVar;
        this.h = qVar;
        this.i = qVar2;
        this.j = qVar3;
    }

    public static e a(DataInput dataInput) {
        q qVar;
        q qVar2;
        int readInt = dataInput.readInt();
        h w = h.w(readInt >>> 28);
        int i2 = ((264241152 & readInt) >>> 22) - 32;
        int i3 = (3670016 & readInt) >>> 19;
        b t = i3 == 0 ? null : b.t(i3);
        int i4 = (507904 & readInt) >>> 14;
        a aVar = a.values()[(readInt & 12288) >>> 12];
        int i5 = (readInt & 4080) >>> 4;
        int i6 = (readInt & 12) >>> 2;
        int i7 = readInt & 3;
        int readInt2 = i4 == 31 ? dataInput.readInt() : i4 * 3600;
        q C = q.C(i5 == 255 ? dataInput.readInt() : (i5 - 128) * BuildConfig.ATTENUATION_THRESHOLD);
        if (i6 == 3) {
            qVar = q.C(dataInput.readInt());
        } else {
            qVar = q.C((i6 * 1800) + C.f5002b);
        }
        if (i7 == 3) {
            qVar2 = q.C(dataInput.readInt());
        } else {
            qVar2 = q.C((i7 * 1800) + C.f5002b);
        }
        if (i2 < -28 || i2 > 31 || i2 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        return new e(w, i2, t, g.A((long) c.S0(readInt2, Strategy.TTL_SECONDS_MAX)), readInt2 >= 0 ? readInt2 / Strategy.TTL_SECONDS_MAX : ((readInt2 + 1) / Strategy.TTL_SECONDS_MAX) - 1, aVar, C, qVar, qVar2);
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public void b(DataOutput dataOutput) {
        byte b2;
        int J = (this.f * Strategy.TTL_SECONDS_MAX) + this.f5212e.J();
        int i2 = this.h.f5002b;
        int i3 = this.i.f5002b - i2;
        int i4 = this.j.f5002b - i2;
        if (J % 3600 != 0 || J > 86400) {
            b2 = 31;
        } else {
            b2 = J == 86400 ? 24 : this.f5212e.f4977b;
        }
        int i5 = i2 % BuildConfig.ATTENUATION_THRESHOLD == 0 ? (i2 / BuildConfig.ATTENUATION_THRESHOLD) + RecyclerView.d0.FLAG_IGNORE : 255;
        int i6 = (i3 == 0 || i3 == 1800 || i3 == 3600) ? i3 / 1800 : 3;
        int i7 = (i4 == 0 || i4 == 1800 || i4 == 3600) ? i4 / 1800 : 3;
        b bVar = this.f5211d;
        dataOutput.writeInt((this.f5209b.t() << 28) + ((this.f5210c + 32) << 22) + ((bVar == null ? 0 : bVar.s()) << 19) + (b2 << 14) + (this.g.ordinal() << 12) + (i5 << 4) + (i6 << 2) + i7);
        if (b2 == 31) {
            dataOutput.writeInt(J);
        }
        if (i5 == 255) {
            dataOutput.writeInt(i2);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.i.f5002b);
        }
        if (i7 == 3) {
            dataOutput.writeInt(this.j.f5002b);
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
        return this.f5209b == eVar.f5209b && this.f5210c == eVar.f5210c && this.f5211d == eVar.f5211d && this.g == eVar.g && this.f == eVar.f && this.f5212e.equals(eVar.f5212e) && this.h.equals(eVar.h) && this.i.equals(eVar.i) && this.j.equals(eVar.j);
    }

    public int hashCode() {
        int J = ((this.f5212e.J() + this.f) << 15) + (this.f5209b.ordinal() << 11) + ((this.f5210c + 32) << 5);
        b bVar = this.f5211d;
        return ((this.h.f5002b ^ (this.g.ordinal() + (J + ((bVar == null ? 7 : bVar.ordinal()) << 2)))) ^ this.i.f5002b) ^ this.j.f5002b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
    public String toString() {
        String str;
        StringBuilder g2 = c.a.a.a.a.g("TransitionRule[");
        q qVar = this.i;
        q qVar2 = this.j;
        if (qVar != null) {
            g2.append(qVar2.f5002b - qVar.f5002b > 0 ? "Gap " : "Overlap ");
            g2.append(this.i);
            g2.append(" to ");
            g2.append(this.j);
            g2.append(", ");
            b bVar = this.f5211d;
            if (bVar != null) {
                byte b2 = this.f5210c;
                g2.append(bVar.name());
                if (b2 == -1) {
                    str = " on or before last day of ";
                } else if (b2 < 0) {
                    g2.append(" on or before last day minus ");
                    g2.append((-this.f5210c) - 1);
                    str = " of ";
                } else {
                    g2.append(" on or after ");
                }
                g2.append(str);
                g2.append(this.f5209b.name());
                g2.append(" at ");
                if (this.f != 0) {
                    g2.append(this.f5212e);
                } else {
                    long J = (long) ((this.f * 24 * 60) + (this.f5212e.J() / 60));
                    long R0 = c.R0(J, 60);
                    if (R0 < 10) {
                        g2.append(0);
                    }
                    g2.append(R0);
                    g2.append(':');
                    long T0 = (long) c.T0(J, 60);
                    if (T0 < 10) {
                        g2.append(0);
                    }
                    g2.append(T0);
                }
                g2.append(" ");
                g2.append(this.g);
                g2.append(", standard offset ");
                g2.append(this.h);
                g2.append(']');
                return g2.toString();
            }
            g2.append(this.f5209b.name());
            g2.append(' ');
            g2.append((int) this.f5210c);
            g2.append(" at ");
            if (this.f != 0) {
            }
            g2.append(" ");
            g2.append(this.g);
            g2.append(", standard offset ");
            g2.append(this.h);
            g2.append(']');
            return g2.toString();
        }
        throw null;
    }
}
