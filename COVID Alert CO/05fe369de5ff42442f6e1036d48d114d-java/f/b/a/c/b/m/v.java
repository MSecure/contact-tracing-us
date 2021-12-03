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
    public f.b.a.c.b.a f2660d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2661e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2662f;

    public v(int i2, IBinder iBinder, f.b.a.c.b.a aVar, boolean z, boolean z2) {
        this.b = i2;
        this.c = iBinder;
        this.f2660d = aVar;
        this.f2661e = z;
        this.f2662f = z2;
    }

    public final h d() {
        IBinder iBinder = this.c;
        if (iBinder == null) {
            return null;
        }
        return h.a.q(iBinder);
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
        return this.f2660d.equals(vVar.f2660d) && m.h.U(d(), vVar.d());
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int O1 = m.h.O1(parcel, 20293);
        int i3 = this.b;
        m.h.S1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.H1(parcel, 2, this.c, false);
        m.h.K1(parcel, 3, this.f2660d, i2, false);
        boolean z = this.f2661e;
        m.h.S1(parcel, 4, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.f2662f;
        m.h.S1(parcel, 5, 4);
        parcel.writeInt(z2 ? 1 : 0);
        m.h.T1(parcel, O1);
    }
}
