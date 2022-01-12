package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

public final class zze implements Parcelable.Creator<zzd> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzd createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        int i = 0;
        boolean z = false;
        long j = 0;
        HarmfulAppsData[] harmfulAppsDataArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                j = ReactYogaConfigProvider.readLong(parcel, readInt);
            } else if (i2 == 3) {
                harmfulAppsDataArr = (HarmfulAppsData[]) ReactYogaConfigProvider.createTypedArray(parcel, readInt, HarmfulAppsData.CREATOR);
            } else if (i2 == 4) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i2 != 5) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                z = ReactYogaConfigProvider.readBoolean(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zzd(j, harmfulAppsDataArr, i, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd[] newArray(int i) {
        return new zzd[i];
    }
}
