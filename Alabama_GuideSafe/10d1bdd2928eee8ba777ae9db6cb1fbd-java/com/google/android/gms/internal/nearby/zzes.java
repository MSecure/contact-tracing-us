package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzes implements Parcelable.Creator<zzer> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzer createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        IBinder iBinder = null;
        ExposureConfiguration exposureConfiguration = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 3) {
                iBinder = ReactYogaConfigProvider.readIBinder(parcel, readInt);
            } else if (i != 4) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                exposureConfiguration = (ExposureConfiguration) ReactYogaConfigProvider.createParcelable(parcel, readInt, ExposureConfiguration.CREATOR);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zzer(iBinder, exposureConfiguration);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzer[] newArray(int i) {
        return new zzer[i];
    }
}
