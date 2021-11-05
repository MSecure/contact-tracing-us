package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import java.util.ArrayList;

public final class zzb implements Parcelable.Creator<DailySummary> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummary createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        ArrayList arrayList = null;
        int i = 0;
        DailySummary.ExposureSummaryData exposureSummaryData = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i2 == 2) {
                arrayList = t.e0(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            } else if (i2 != 3) {
                t.O2(parcel, readInt);
            } else {
                exposureSummaryData = (DailySummary.ExposureSummaryData) t.a0(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new DailySummary(i, arrayList, exposureSummaryData);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummary[] newArray(int i) {
        return new DailySummary[i];
    }
}
