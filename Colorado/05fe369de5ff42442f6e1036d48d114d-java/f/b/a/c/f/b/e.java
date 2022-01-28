package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.e.c.a3;
import java.util.Arrays;
import java.util.List;

public final class e extends a {
    public static final Parcelable.Creator<e> CREATOR = new n();
    public long b;
    public final List<g> c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2720d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2721e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2722f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2723g;

    public e(long j2, List<g> list, int i2, int i3, int i4, String str) {
        this.b = j2;
        this.c = a3.q(list);
        this.f2720d = i2;
        this.f2721e = i3;
        this.f2722f = i4;
        this.f2723g = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            return this.f2720d == eVar.f2720d && this.b == eVar.b && this.c.equals(eVar.c) && this.f2721e == eVar.f2721e && this.f2722f == eVar.f2722f && m.h.U(this.f2723g, eVar.f2723g);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.b), this.c, Integer.valueOf(this.f2720d), Integer.valueOf(this.f2721e), Integer.valueOf(this.f2722f), this.f2723g});
    }

    public String toString() {
        long j2 = this.b;
        int i2 = this.f2720d;
        String valueOf = String.valueOf(this.c);
        int i3 = this.f2721e;
        int i4 = this.f2722f;
        String str = this.f2723g;
        StringBuilder sb = new StringBuilder(valueOf.length() + 173 + String.valueOf(str).length());
        sb.append("ExposureWindow{dateMillisSinceEpoch=");
        sb.append(j2);
        sb.append(", reportType=");
        sb.append(i2);
        sb.append(", scanInstances=");
        sb.append(valueOf);
        sb.append(", infectiousness=");
        sb.append(i3);
        sb.append(", calibrationConfidence=");
        sb.append(i4);
        sb.append(", deviceName=");
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int O1 = m.h.O1(parcel, 20293);
        long j2 = this.b;
        m.h.S1(parcel, 1, 8);
        parcel.writeLong(j2);
        m.h.N1(parcel, 2, this.c, false);
        int i3 = this.f2720d;
        m.h.S1(parcel, 3, 4);
        parcel.writeInt(i3);
        int i4 = this.f2721e;
        m.h.S1(parcel, 4, 4);
        parcel.writeInt(i4);
        int i5 = this.f2722f;
        m.h.S1(parcel, 5, 4);
        parcel.writeInt(i5);
        m.h.L1(parcel, 6, this.f2723g, false);
        m.h.T1(parcel, O1);
    }
}
