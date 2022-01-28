package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzn implements Parcelable.Creator<ScanInstance> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ScanInstance createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i4 == 2) {
                i2 = t.t2(parcel, readInt);
            } else if (i4 != 3) {
                t.O2(parcel, readInt);
            } else {
                i3 = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new ScanInstance(i, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ScanInstance[] newArray(int i) {
        return new ScanInstance[i];
    }
}
