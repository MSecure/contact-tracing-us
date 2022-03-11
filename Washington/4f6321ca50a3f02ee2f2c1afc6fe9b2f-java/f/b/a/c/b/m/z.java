package f.b.a.c.b.m;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.c;
import f.b.a.c.b.m.n.a;

public final class z extends a {
    public static final Parcelable.Creator<z> CREATOR = new y();
    public Bundle b;
    public c[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f2494d;

    public z() {
    }

    public z(Bundle bundle, c[] cVarArr, int i2) {
        this.b = bundle;
        this.c = cVarArr;
        this.f2494d = i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.y1(parcel, 1, this.b, false);
        m.h.G1(parcel, 2, this.c, i2, false);
        int i3 = this.f2494d;
        m.h.M1(parcel, 3, 4);
        parcel.writeInt(i3);
        m.h.E1(parcel, 4, null, i2, false);
        m.h.N1(parcel, I1);
    }
}
