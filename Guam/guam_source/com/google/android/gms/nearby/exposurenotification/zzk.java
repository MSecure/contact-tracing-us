package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.nearby.exposurenotification.DailySummary;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzk implements Parcelable.Creator<DailySummary.ExposureSummaryData> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummary.ExposureSummaryData createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                d = ReactYogaConfigProvider.readDouble(parcel, readInt);
            } else if (i == 2) {
                d2 = ReactYogaConfigProvider.readDouble(parcel, readInt);
            } else if (i != 3) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                d3 = ReactYogaConfigProvider.readDouble(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new DailySummary.ExposureSummaryData(d, d2, d3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummary.ExposureSummaryData[] newArray(int i) {
        return new DailySummary.ExposureSummaryData[i];
    }
}
