package f.b.a.c.h.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class b implements Parcelable.Creator<c> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        int i2 = 0;
        Intent intent = null;
        int i3 = 0;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = m.h.Z0(parcel, readInt);
            } else if (i4 == 2) {
                i3 = m.h.Z0(parcel, readInt);
            } else if (i4 != 3) {
                m.h.q1(parcel, readInt);
            } else {
                intent = (Intent) m.h.J(parcel, readInt, Intent.CREATOR);
            }
        }
        m.h.T(parcel, B1);
        return new c(i2, i3, intent);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i2) {
        return new c[i2];
    }
}
