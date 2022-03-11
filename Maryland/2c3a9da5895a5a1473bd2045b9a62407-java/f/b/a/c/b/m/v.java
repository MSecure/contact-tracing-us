package f.b.a.c.b.m;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.h;
import f.b.a.c.b.m.n.a;

public final class v extends a {
    public static final Parcelable.Creator<v> CREATOR = new x();
    public final int b;
    public IBinder c;

    /* renamed from: d  reason: collision with root package name */
    public f.b.a.c.b.a f2571d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2572e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2573f;

    public v(int i2, IBinder iBinder, f.b.a.c.b.a aVar, boolean z, boolean z2) {
        this.b = i2;
        this.c = iBinder;
        this.f2571d = aVar;
        this.f2572e = z;
        this.f2573f = z2;
    }

    public final h d() {
        IBinder iBinder = this.c;
        if (iBinder == null) {
            return null;
        }
        return h.a.m(iBinder);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f2571d.equals(vVar.f2571d) && m.h.U(d(), vVar.d());
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        int i3 = this.b;
        m.h.M1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.B1(parcel, 2, this.c, false);
        m.h.E1(parcel, 3, this.f2571d, i2, false);
        boolean z = this.f2572e;
        m.h.M1(parcel, 4, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.f2573f;
        m.h.M1(parcel, 5, 4);
        parcel.writeInt(z2 ? 1 : 0);
        m.h.N1(parcel, I1);
    }
}
