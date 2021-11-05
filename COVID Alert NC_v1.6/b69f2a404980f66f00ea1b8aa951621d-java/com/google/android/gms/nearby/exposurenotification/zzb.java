package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import java.util.ArrayList;

public final class zzb implements Parcelable.Creator<DailySummary> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummary createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        ArrayList arrayList = null;
        int i = 0;
        DailySummary.ExposureSummaryData exposureSummaryData = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i2 == 2) {
                arrayList = i.j.S(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            } else if (i2 != 3) {
                i.j.g1(parcel, readInt);
            } else {
                exposureSummaryData = (DailySummary.ExposureSummaryData) i.j.O(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new DailySummary(i, arrayList, exposureSummaryData);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummary[] newArray(int i) {
        return new DailySummary[i];
    }
}
