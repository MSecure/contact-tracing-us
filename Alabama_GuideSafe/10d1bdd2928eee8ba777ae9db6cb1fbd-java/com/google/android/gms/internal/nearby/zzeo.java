package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzeo implements Parcelable.Creator<zzen> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzen createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        IBinder iBinder = null;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = ReactYogaConfigProvider.readIBinder(parcel, readInt);
            } else if (i != 2) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) ReactYogaConfigProvider.createParcelable(parcel, readInt, DiagnosisKeysDataMapping.CREATOR);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zzen(iBinder, diagnosisKeysDataMapping);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzen[] newArray(int i) {
        return new zzen[i];
    }
}
