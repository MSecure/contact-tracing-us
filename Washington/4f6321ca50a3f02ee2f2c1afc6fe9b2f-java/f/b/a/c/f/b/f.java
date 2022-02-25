package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class f extends a {
    public static final Parcelable.Creator<f> CREATOR = new o();
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f2534d;

    public f(int i2, int i3, int i4) {
        this.b = i2;
        this.c = i3;
        this.f2534d = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            return this.b == fVar.b && this.c == fVar.c && this.f2534d == fVar.f2534d;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.f2534d)});
    }

    public final String toString() {
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.f2534d;
        StringBuilder sb = new StringBuilder(110);
        sb.append("ScanInstance{typicalAttenuationDb=");
        sb.append(i2);
        sb.append(", minAttenuationDb=");
        sb.append(i3);
        sb.append(", secondsSinceLastScan=");
        sb.append(i4);
        sb.append('}');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        int i3 = this.b;
        m.h.M1(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = this.c;
        m.h.M1(parcel, 2, 4);
        parcel.writeInt(i4);
        int i5 = this.f2534d;
        m.h.M1(parcel, 3, 4);
        parcel.writeInt(i5);
        m.h.N1(parcel, I1);
    }
}
