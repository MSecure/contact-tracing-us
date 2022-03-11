package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.e.c.a3;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class e extends a {
    public static final Parcelable.Creator<e> CREATOR = new n();
    public long b;
    public final List<g> c;

    /* renamed from: d */
    public final int f2815d;

    /* renamed from: e */
    public final int f2816e;

    /* renamed from: f */
    public final int f2817f;

    /* renamed from: g */
    public final String f2818g;

    /* renamed from: h */
    public final int f2819h;

    public e(long j2, List<g> list, int i2, int i3, int i4, String str, int i5) {
        this.b = j2;
        this.c = a3.q(list);
        this.f2815d = i2;
        this.f2816e = i3;
        this.f2817f = i4;
        this.f2818g = str;
        this.f2819h = i5;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (this.f2815d == eVar.f2815d && this.b == eVar.b && this.c.equals(eVar.c) && this.f2816e == eVar.f2816e && this.f2817f == eVar.f2817f && m.e.X(this.f2818g, eVar.f2818g) && this.f2819h == eVar.f2819h) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.b), this.c, Integer.valueOf(this.f2815d), Integer.valueOf(this.f2816e), Integer.valueOf(this.f2817f), this.f2818g, Integer.valueOf(this.f2819h)});
    }

    @Override // java.lang.Object
    public String toString() {
        long j2 = this.b;
        int i2 = this.f2815d;
        String valueOf = String.valueOf(this.c);
        int i3 = this.f2816e;
        int i4 = this.f2817f;
        String str = this.f2818g;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        long j3 = this.b;
        m.e.n2(parcel, 1, 8);
        parcel.writeLong(j3);
        m.e.i2(parcel, 2, this.c, false);
        int i3 = this.f2815d;
        m.e.n2(parcel, 3, 4);
        parcel.writeInt(i3);
        int i4 = this.f2816e;
        m.e.n2(parcel, 4, 4);
        parcel.writeInt(i4);
        int i5 = this.f2817f;
        m.e.n2(parcel, 5, 4);
        parcel.writeInt(i5);
        m.e.g2(parcel, 6, this.f2818g, false);
        int i6 = this.f2819h;
        m.e.n2(parcel, 7, 4);
        parcel.writeInt(i6);
        m.e.o2(parcel, j2);
    }
}
