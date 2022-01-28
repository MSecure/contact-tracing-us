package g.b.a.x;

import androidx.recyclerview.widget.RecyclerView;
import b.x.t;
import com.google.android.gms.nearby.messages.Strategy;
import g.b.a.b;
import g.b.a.g;
import g.b.a.h;
import g.b.a.q;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;

public final class e implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final h f6696b;

    /* renamed from: c  reason: collision with root package name */
    public final byte f6697c;

    /* renamed from: d  reason: collision with root package name */
    public final b f6698d;

    /* renamed from: e  reason: collision with root package name */
    public final g f6699e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6700f;

    /* renamed from: g  reason: collision with root package name */
    public final a f6701g;
    public final q h;
    public final q i;
    public final q j;

    public enum a {
        UTC,
        WALL,
        STANDARD
    }

    public e(h hVar, int i2, b bVar, g gVar, int i3, a aVar, q qVar, q qVar2, q qVar3) {
        this.f6696b = hVar;
        this.f6697c = (byte) i2;
        this.f6698d = bVar;
        this.f6699e = gVar;
        this.f6700f = i3;
        this.f6701g = aVar;
        this.h = qVar;
        this.i = qVar2;
        this.j = qVar3;
    }

    public static e a(DataInput dataInput) {
        q qVar;
        q qVar2;
        int readInt = dataInput.readInt();
        h D = h.D(readInt >>> 28);
        int i2 = ((264241152 & readInt) >>> 22) - 32;
        int i3 = (3670016 & readInt) >>> 19;
        b x = i3 == 0 ? null : b.x(i3);
        int i4 = (507904 & readInt) >>> 14;
        a aVar = a.values()[(readInt & 12288) >>> 12];
        int i5 = (readInt & 4080) >>> 4;
        int i6 = (readInt & 12) >>> 2;
        int i7 = readInt & 3;
        int readInt2 = i4 == 31 ? dataInput.readInt() : i4 * 3600;
        q R = q.R(i5 == 255 ? dataInput.readInt() : (i5 - 128) * BuildConfig.ATTENUATION_THRESHOLD);
        if (i6 == 3) {
            qVar = q.R(dataInput.readInt());
        } else {
            qVar = q.R((i6 * 1800) + R.f6447c);
        }
        if (i7 == 3) {
            qVar2 = q.R(dataInput.readInt());
        } else {
            qVar2 = q.R((i7 * 1800) + R.f6447c);
        }
        if (i2 < -28 || i2 > 31 || i2 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        return new e(D, i2, x, g.Q((long) t.u1(readInt2, Strategy.TTL_SECONDS_MAX)), readInt2 >= 0 ? readInt2 / Strategy.TTL_SECONDS_MAX : ((readInt2 + 1) / Strategy.TTL_SECONDS_MAX) - 1, aVar, R, qVar, qVar2);
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public void b(DataOutput dataOutput) {
        byte b2;
        int Z = (this.f6700f * Strategy.TTL_SECONDS_MAX) + this.f6699e.Z();
        int i2 = this.h.f6447c;
        int i3 = this.i.f6447c - i2;
        int i4 = this.j.f6447c - i2;
        if (Z % 3600 != 0 || Z > 86400) {
            b2 = 31;
        } else {
            b2 = Z == 86400 ? 24 : this.f6699e.f6418b;
        }
        int i5 = i2 % BuildConfig.ATTENUATION_THRESHOLD == 0 ? (i2 / BuildConfig.ATTENUATION_THRESHOLD) + RecyclerView.a0.FLAG_IGNORE : 255;
        int i6 = (i3 == 0 || i3 == 1800 || i3 == 3600) ? i3 / 1800 : 3;
        int i7 = (i4 == 0 || i4 == 1800 || i4 == 3600) ? i4 / 1800 : 3;
        b bVar = this.f6698d;
        dataOutput.writeInt((this.f6696b.x() << 28) + ((this.f6697c + 32) << 22) + ((bVar == null ? 0 : bVar.p()) << 19) + (b2 << 14) + (this.f6701g.ordinal() << 12) + (i5 << 4) + (i6 << 2) + i7);
        if (b2 == 31) {
            dataOutput.writeInt(Z);
        }
        if (i5 == 255) {
            dataOutput.writeInt(i2);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.i.f6447c);
        }
        if (i7 == 3) {
            dataOutput.writeInt(this.j.f6447c);
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
        return this.f6696b == eVar.f6696b && this.f6697c == eVar.f6697c && this.f6698d == eVar.f6698d && this.f6701g == eVar.f6701g && this.f6700f == eVar.f6700f && this.f6699e.equals(eVar.f6699e) && this.h.equals(eVar.h) && this.i.equals(eVar.i) && this.j.equals(eVar.j);
    }

    public int hashCode() {
        int Z = ((this.f6699e.Z() + this.f6700f) << 15) + (this.f6696b.ordinal() << 11) + ((this.f6697c + 32) << 5);
        b bVar = this.f6698d;
        return ((this.h.f6447c ^ (this.f6701g.ordinal() + (Z + ((bVar == null ? 7 : bVar.ordinal()) << 2)))) ^ this.i.f6447c) ^ this.j.f6447c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
    public String toString() {
        String str;
        StringBuilder h2 = c.a.a.a.a.h("TransitionRule[");
        q qVar = this.i;
        q qVar2 = this.j;
        if (qVar != null) {
            h2.append(qVar2.f6447c - qVar.f6447c > 0 ? "Gap " : "Overlap ");
            h2.append(this.i);
            h2.append(" to ");
            h2.append(this.j);
            h2.append(", ");
            b bVar = this.f6698d;
            if (bVar != null) {
                byte b2 = this.f6697c;
                h2.append(bVar.name());
                if (b2 == -1) {
                    str = " on or before last day of ";
                } else if (b2 < 0) {
                    h2.append(" on or before last day minus ");
                    h2.append((-this.f6697c) - 1);
                    str = " of ";
                } else {
                    h2.append(" on or after ");
                }
                h2.append(str);
                h2.append(this.f6696b.name());
                h2.append(" at ");
                if (this.f6700f != 0) {
                    h2.append(this.f6699e);
                } else {
                    long Z = (long) ((this.f6700f * 24 * 60) + (this.f6699e.Z() / 60));
                    long t1 = t.t1(Z, 60);
                    if (t1 < 10) {
                        h2.append(0);
                    }
                    h2.append(t1);
                    h2.append(':');
                    long v1 = (long) t.v1(Z, 60);
                    if (v1 < 10) {
                        h2.append(0);
                    }
                    h2.append(v1);
                }
                h2.append(" ");
                h2.append(this.f6701g);
                h2.append(", standard offset ");
                h2.append(this.h);
                h2.append(']');
                return h2.toString();
            }
            h2.append(this.f6696b.name());
            h2.append(' ');
            h2.append((int) this.f6697c);
            h2.append(" at ");
            if (this.f6700f != 0) {
            }
            h2.append(" ");
            h2.append(this.f6701g);
            h2.append(", standard offset ");
            h2.append(this.h);
            h2.append(']');
            return h2.toString();
        }
        throw null;
    }
}
