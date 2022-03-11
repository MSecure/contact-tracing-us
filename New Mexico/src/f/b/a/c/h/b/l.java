package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.b.m.u;
/* loaded from: classes.dex */
public final class l extends a {
    public static final Parcelable.Creator<l> CREATOR = new k();
    public final int b;
    public final u c;

    public l(int i2, u uVar) {
        this.b = i2;
        this.c = uVar;
    }

    public l(u uVar) {
        this.b = 1;
        this.c = uVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        m.e.f2(parcel, 2, this.c, i2, false);
        m.e.o2(parcel, j2);
    }
}
