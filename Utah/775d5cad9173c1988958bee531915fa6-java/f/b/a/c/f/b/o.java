package f.b.a.c.f.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class o implements Parcelable.Creator<f> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final f createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                m.e.C1(parcel, readInt);
            } else {
                bundle = m.e.E(parcel, readInt);
            }
        }
        m.e.V(parcel, O1);
        return new f(bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ f[] newArray(int i2) {
        return new f[i2];
    }
}
