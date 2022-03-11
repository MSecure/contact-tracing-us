package f.b.a.c.b.m;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.a;
/* loaded from: classes.dex */
public final class x implements Parcelable.Creator<v> {
    @Override // android.os.Parcelable.Creator
    public final v createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        IBinder iBinder = null;
        a aVar = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i3 == 2) {
                iBinder = m.e.q1(parcel, readInt);
            } else if (i3 == 3) {
                aVar = (a) m.e.M(parcel, readInt, a.CREATOR);
            } else if (i3 == 4) {
                z = m.e.n1(parcel, readInt);
            } else if (i3 != 5) {
                m.e.K1(parcel, readInt);
            } else {
                z2 = m.e.n1(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new v(i2, iBinder, aVar, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v[] newArray(int i2) {
        return new v[i2];
    }
}
