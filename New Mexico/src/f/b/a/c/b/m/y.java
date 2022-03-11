package f.b.a.c.b.m;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.c;
/* loaded from: classes.dex */
public final class y implements Parcelable.Creator<z> {
    @Override // android.os.Parcelable.Creator
    public final z createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        Bundle bundle = null;
        c[] cVarArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                bundle = m.e.E(parcel, readInt);
            } else if (i3 == 2) {
                cVarArr = (c[]) m.e.Q(parcel, readInt, c.CREATOR);
            } else if (i3 == 3) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i3 != 4) {
                m.e.K1(parcel, readInt);
            } else {
                d dVar = (d) m.e.M(parcel, readInt, d.CREATOR);
            }
        }
        m.e.W(parcel, W1);
        return new z(bundle, cVarArr, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z[] newArray(int i2) {
        return new z[i2];
    }
}
