package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import java.util.ArrayList;

public final class zzl implements Parcelable.Creator<ExposureWindow> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ExposureWindow createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                j = t.u2(parcel, readInt);
            } else if (i4 == 2) {
                arrayList = t.e0(parcel, readInt, ScanInstance.CREATOR);
            } else if (i4 == 3) {
                i = t.t2(parcel, readInt);
            } else if (i4 == 4) {
                i2 = t.t2(parcel, readInt);
            } else if (i4 != 5) {
                t.O2(parcel, readInt);
            } else {
                i3 = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new ExposureWindow(j, arrayList, i, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExposureWindow[] newArray(int i) {
        return new ExposureWindow[i];
    }
}
