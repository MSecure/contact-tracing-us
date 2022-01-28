package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzc implements Parcelable.Creator<DiagnosisKeysDataMapping> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DiagnosisKeysDataMapping createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        int i = 0;
        ArrayList<Integer> arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                arrayList = ReactYogaConfigProvider.createIntegerList(parcel, readInt);
            } else if (i3 == 2) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i3 != 3) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                i2 = ReactYogaConfigProvider.readInt(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new DiagnosisKeysDataMapping(arrayList, i, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DiagnosisKeysDataMapping[] newArray(int i) {
        return new DiagnosisKeysDataMapping[i];
    }
}
