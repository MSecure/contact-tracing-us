package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class g extends a {
    public static final Parcelable.Creator<g> CREATOR = new p();
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f2778d;

    public g(int i2, int i3, int i4) {
        this.b = i2;
        this.c = i3;
        this.f2778d = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            g gVar = (g) obj;
            return this.b == gVar.b && this.c == gVar.c && this.f2778d == gVar.f2778d;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.f2778d)});
    }

    public String toString() {
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.f2778d;
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

    public void writeToParcel(Parcel parcel, int i2) {
        int b2 = m.e.b2(parcel, 20293);
        int i3 = this.b;
        m.e.f2(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = this.c;
        m.e.f2(parcel, 2, 4);
        parcel.writeInt(i4);
        int i5 = this.f2778d;
        m.e.f2(parcel, 3, 4);
        parcel.writeInt(i5);
        m.e.g2(parcel, b2);
    }
}
