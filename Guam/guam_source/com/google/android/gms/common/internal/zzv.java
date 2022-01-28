package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzv implements Parcelable.Creator<RootTelemetryConfiguration> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final RootTelemetryConfiguration createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i4 == 2) {
                z = ReactYogaConfigProvider.readBoolean(parcel, readInt);
            } else if (i4 == 3) {
                z2 = ReactYogaConfigProvider.readBoolean(parcel, readInt);
            } else if (i4 == 4) {
                i2 = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i4 != 5) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                i3 = ReactYogaConfigProvider.readInt(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new RootTelemetryConfiguration(i, z, z2, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RootTelemetryConfiguration[] newArray(int i) {
        return new RootTelemetryConfiguration[i];
    }
}
