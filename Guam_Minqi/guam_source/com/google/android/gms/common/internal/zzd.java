package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzd implements Parcelable.Creator<ConnectionTelemetryConfiguration> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ConnectionTelemetryConfiguration createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArr = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                rootTelemetryConfiguration = (RootTelemetryConfiguration) ReactYogaConfigProvider.createParcelable(parcel, readInt, RootTelemetryConfiguration.CREATOR);
            } else if (i2 == 2) {
                z = ReactYogaConfigProvider.readBoolean(parcel, readInt);
            } else if (i2 == 3) {
                z2 = ReactYogaConfigProvider.readBoolean(parcel, readInt);
            } else if (i2 == 4) {
                iArr = ReactYogaConfigProvider.createIntArray(parcel, readInt);
            } else if (i2 != 5) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z, z2, iArr, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionTelemetryConfiguration[] newArray(int i) {
        return new ConnectionTelemetryConfiguration[i];
    }
}
