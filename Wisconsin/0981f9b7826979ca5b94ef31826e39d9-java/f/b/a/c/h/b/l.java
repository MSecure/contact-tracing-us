package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.b.m.u;

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

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        int i3 = this.b;
        m.h.L1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.D1(parcel, 2, this.c, i2, false);
        m.h.M1(parcel, H1);
    }
}
