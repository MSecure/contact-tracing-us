package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.e.c.r2;
import java.util.Arrays;
import java.util.List;

public final class e extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<e> CREATOR = new n();
    public long b;
    public final List<g> c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2630d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2631e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2632f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2633g;

    public e(long j2, List<g> list, int i2, int i3, int i4, String str) {
        this.b = j2;
        this.c = r2.p(list);
        this.f2630d = i2;
        this.f2631e = i3;
        this.f2632f = i4;
        this.f2633g = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            return this.f2630d == eVar.f2630d && this.b == eVar.b && this.c.equals(eVar.c) && this.f2631e == eVar.f2631e && this.f2632f == eVar.f2632f && m.h.U(this.f2633g, eVar.f2633g);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.b), this.c, Integer.valueOf(this.f2630d), Integer.valueOf(this.f2631e), Integer.valueOf(this.f2632f), this.f2633g});
    }

    @RecentlyNonNull
    public String toString() {
        long j2 = this.b;
        int i2 = this.f2630d;
        String valueOf = String.valueOf(this.c);
        int i3 = this.f2631e;
        int i4 = this.f2632f;
        String str = this.f2633g;
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

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        long j2 = this.b;
        m.h.M1(parcel, 1, 8);
        parcel.writeLong(j2);
        m.h.H1(parcel, 2, this.c, false);
        int i3 = this.f2630d;
        m.h.M1(parcel, 3, 4);
        parcel.writeInt(i3);
        int i4 = this.f2631e;
        m.h.M1(parcel, 4, 4);
        parcel.writeInt(i4);
        int i5 = this.f2632f;
        m.h.M1(parcel, 5, 4);
        parcel.writeInt(i5);
        m.h.F1(parcel, 6, this.f2633g, false);
        m.h.N1(parcel, I1);
    }
}
