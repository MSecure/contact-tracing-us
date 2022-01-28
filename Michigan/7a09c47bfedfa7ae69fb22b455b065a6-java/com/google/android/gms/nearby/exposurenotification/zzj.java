package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.exposurenotification.DailySummary;

public final class zzj implements Parcelable.Creator<DailySummary.ExposureSummaryData> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummary.ExposureSummaryData createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                d2 = t.r2(parcel, readInt);
            } else if (i == 2) {
                d3 = t.r2(parcel, readInt);
            } else if (i != 3) {
                t.O2(parcel, readInt);
            } else {
                d4 = t.r2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new DailySummary.ExposureSummaryData(d2, d3, d4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummary.ExposureSummaryData[] newArray(int i) {
        return new DailySummary.ExposureSummaryData[i];
    }
}
