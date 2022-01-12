package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

public final class zzc implements Parcelable.Creator<HarmfulAppsData> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final HarmfulAppsData createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        String str = null;
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                str = ReactYogaConfigProvider.createString(parcel, readInt);
            } else if (i2 == 3) {
                bArr = ReactYogaConfigProvider.createByteArray(parcel, readInt);
            } else if (i2 != 4) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new HarmfulAppsData(str, bArr, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HarmfulAppsData[] newArray(int i) {
        return new HarmfulAppsData[i];
    }
}
