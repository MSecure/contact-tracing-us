package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzb implements Parcelable.Creator<DailySummary> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummary createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        int i = 0;
        DailySummary.ExposureSummaryData exposureSummaryData = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i2 == 2) {
                arrayList = ReactYogaConfigProvider.createTypedList(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            } else if (i2 != 3) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                exposureSummaryData = (DailySummary.ExposureSummaryData) ReactYogaConfigProvider.createParcelable(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new DailySummary(i, arrayList, exposureSummaryData);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummary[] newArray(int i) {
        return new DailySummary[i];
    }
}
