package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.e.c.k2;
import java.util.Arrays;
import java.util.List;

public final class d extends a {
    public static final Parcelable.Creator<d> CREATOR = new m();
    public long b;
    public final List<f> c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2523d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2524e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2525f;

    public d(long j2, List<f> list, int i2, int i3, int i4) {
        this.b = j2;
        this.c = k2.p(list);
        this.f2523d = i2;
        this.f2524e = i3;
        this.f2525f = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            return this.f2523d == dVar.f2523d && this.b == dVar.b && this.c.equals(dVar.c) && this.f2524e == dVar.f2524e && this.f2525f == dVar.f2525f;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.b), this.c, Integer.valueOf(this.f2523d), Integer.valueOf(this.f2524e), Integer.valueOf(this.f2525f)});
    }

    public final String toString() {
        long j2 = this.b;
        int i2 = this.f2523d;
        String valueOf = String.valueOf(this.c);
        int i3 = this.f2524e;
        int i4 = this.f2525f;
        StringBuilder sb = new StringBuilder(valueOf.length() + 160);
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
        sb.append('}');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        long j2 = this.b;
        m.h.L1(parcel, 1, 8);
        parcel.writeLong(j2);
        m.h.G1(parcel, 2, this.c, false);
        int i3 = this.f2523d;
        m.h.L1(parcel, 3, 4);
        parcel.writeInt(i3);
        int i4 = this.f2524e;
        m.h.L1(parcel, 4, 4);
        parcel.writeInt(i4);
        int i5 = this.f2525f;
        m.h.L1(parcel, 5, 4);
        parcel.writeInt(i5);
        m.h.M1(parcel, H1);
    }
}
