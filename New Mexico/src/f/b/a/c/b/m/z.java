package f.b.a.c.b.m;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.c;
import f.b.a.c.b.m.n.a;
/* loaded from: classes.dex */
public final class z extends a {
    public static final Parcelable.Creator<z> CREATOR = new y();
    public Bundle b;
    public c[] c;

    /* renamed from: d */
    public int f2758d;

    public z() {
    }

    public z(Bundle bundle, c[] cVarArr, int i2) {
        this.b = bundle;
        this.c = cVarArr;
        this.f2758d = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.Z1(parcel, 1, this.b, false);
        m.e.h2(parcel, 2, this.c, i2, false);
        int i3 = this.f2758d;
        m.e.n2(parcel, 3, 4);
        parcel.writeInt(i3);
        m.e.f2(parcel, 4, null, i2, false);
        m.e.o2(parcel, j2);
    }
}
