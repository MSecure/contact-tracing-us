package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.b.m.v;

public final class n extends a {
    public static final Parcelable.Creator<n> CREATOR = new m();
    public final int b;
    public final f.b.a.c.b.a c;

    /* renamed from: d  reason: collision with root package name */
    public final v f2540d;

    public n() {
        f.b.a.c.b.a aVar = new f.b.a.c.b.a(8, null);
        this.b = 1;
        this.c = aVar;
        this.f2540d = null;
    }

    public n(int i2, f.b.a.c.b.a aVar, v vVar) {
        this.b = i2;
        this.c = aVar;
        this.f2540d = vVar;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        int i3 = this.b;
        m.h.L1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.D1(parcel, 2, this.c, i2, false);
        m.h.D1(parcel, 3, this.f2540d, i2, false);
        m.h.M1(parcel, H1);
    }
}
