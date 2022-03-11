package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.a;
import f.b.a.c.b.m.v;
/* loaded from: classes.dex */
public final class m implements Parcelable.Creator<n> {
    @Override // android.os.Parcelable.Creator
    public final n createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        a aVar = null;
        v vVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i3 == 2) {
                aVar = (a) m.e.M(parcel, readInt, a.CREATOR);
            } else if (i3 != 3) {
                m.e.K1(parcel, readInt);
            } else {
                vVar = (v) m.e.M(parcel, readInt, v.CREATOR);
            }
        }
        m.e.W(parcel, W1);
        return new n(i2, aVar, vVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n[] newArray(int i2) {
        return new n[i2];
    }
}
