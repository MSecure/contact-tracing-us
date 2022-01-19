package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zav implements Parcelable.Creator<zas> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zas createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i2 == 2) {
                iBinder = ReactYogaConfigProvider.readIBinder(parcel, readInt);
            } else if (i2 == 3) {
                connectionResult = (ConnectionResult) ReactYogaConfigProvider.createParcelable(parcel, readInt, ConnectionResult.CREATOR);
            } else if (i2 == 4) {
                z = ReactYogaConfigProvider.readBoolean(parcel, readInt);
            } else if (i2 != 5) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                z2 = ReactYogaConfigProvider.readBoolean(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zas(i, iBinder, connectionResult, z, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zas[] newArray(int i) {
        return new zas[i];
    }
}
