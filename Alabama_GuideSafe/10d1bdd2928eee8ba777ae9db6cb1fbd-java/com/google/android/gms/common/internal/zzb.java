package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzb implements Parcelable.Creator<zzc> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzc createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        Bundle bundle = null;
        int i = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                bundle = ReactYogaConfigProvider.createBundle(parcel, readInt);
            } else if (i2 == 2) {
                featureArr = (Feature[]) ReactYogaConfigProvider.createTypedArray(parcel, readInt, Feature.CREATOR);
            } else if (i2 == 3) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i2 != 4) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) ReactYogaConfigProvider.createParcelable(parcel, readInt, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zzc(bundle, featureArr, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i) {
        return new zzc[i];
    }
}
