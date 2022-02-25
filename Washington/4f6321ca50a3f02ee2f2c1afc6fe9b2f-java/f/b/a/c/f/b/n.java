package f.b.a.c.f.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class n implements Parcelable.Creator<e> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final e createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                m.h.k1(parcel, readInt);
            } else {
                bundle = m.h.A(parcel, readInt);
            }
        }
        m.h.T(parcel, v1);
        return new e(bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e[] newArray(int i2) {
        return new e[i2];
    }
}
