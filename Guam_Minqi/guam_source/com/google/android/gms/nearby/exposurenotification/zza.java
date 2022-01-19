package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zza implements Parcelable.Creator<DailySummariesConfig> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummariesConfig createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        ArrayList<Double> arrayList = null;
        ArrayList<Double> arrayList2 = null;
        ArrayList<Integer> arrayList3 = null;
        ArrayList<Double> arrayList4 = null;
        int i = 0;
        double d = 0.0d;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = ReactYogaConfigProvider.createDoubleList(parcel, readInt);
                    break;
                case 2:
                    arrayList2 = ReactYogaConfigProvider.createDoubleList(parcel, readInt);
                    break;
                case 3:
                    arrayList3 = ReactYogaConfigProvider.createIntegerList(parcel, readInt);
                    break;
                case 4:
                    arrayList4 = ReactYogaConfigProvider.createDoubleList(parcel, readInt);
                    break;
                case 5:
                    i = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                case 6:
                    d = ReactYogaConfigProvider.readDouble(parcel, readInt);
                    break;
                default:
                    ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new DailySummariesConfig(arrayList, arrayList2, arrayList3, arrayList4, i, d);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummariesConfig[] newArray(int i) {
        return new DailySummariesConfig[i];
    }
}
