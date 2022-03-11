package f.b.a.c.b.m;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.h;
import f.b.a.c.b.m.n.a;
/* loaded from: classes.dex */
public final class v extends a {
    public static final Parcelable.Creator<v> CREATOR = new x();
    public final int b;
    public IBinder c;

    /* renamed from: d */
    public f.b.a.c.b.a f2755d;

    /* renamed from: e */
    public boolean f2756e;

    /* renamed from: f */
    public boolean f2757f;

    public v(int i2, IBinder iBinder, f.b.a.c.b.a aVar, boolean z, boolean z2) {
        this.b = i2;
        this.c = iBinder;
        this.f2755d = aVar;
        this.f2756e = z;
        this.f2757f = z2;
    }

    public final h d() {
        IBinder iBinder = this.c;
        if (iBinder == null) {
            return null;
        }
        return h.a.z(iBinder);
    }

    @Override // java.lang.Object
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
        return this.f2755d.equals(vVar.f2755d) && m.e.X(d(), vVar.d());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        m.e.c2(parcel, 2, this.c, false);
        m.e.f2(parcel, 3, this.f2755d, i2, false);
        boolean z = this.f2756e;
        m.e.n2(parcel, 4, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.f2757f;
        m.e.n2(parcel, 5, 4);
        parcel.writeInt(z2 ? 1 : 0);
        m.e.o2(parcel, j2);
    }
}
