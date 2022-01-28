package f.b.a.c.f.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class o implements Parcelable.Creator<f> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final f createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                m.h.q1(parcel, readInt);
            } else {
                bundle = m.h.A(parcel, readInt);
            }
        }
        m.h.T(parcel, B1);
        return new f(bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ f[] newArray(int i2) {
        return new f[i2];
    }
}
