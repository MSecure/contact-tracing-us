package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.exposurenotification.DailySummary;

public final class zzj implements Parcelable.Creator<DailySummary.ExposureSummaryData> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummary.ExposureSummaryData createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                d2 = i.j.P0(parcel, readInt);
            } else if (i == 2) {
                d3 = i.j.P0(parcel, readInt);
            } else if (i != 3) {
                i.j.g1(parcel, readInt);
            } else {
                d4 = i.j.P0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new DailySummary.ExposureSummaryData(d2, d3, d4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummary.ExposureSummaryData[] newArray(int i) {
        return new DailySummary.ExposureSummaryData[i];
    }
}
