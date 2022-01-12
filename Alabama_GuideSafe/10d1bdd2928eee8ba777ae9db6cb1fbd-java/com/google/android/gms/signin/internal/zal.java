package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zas;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zal implements Parcelable.Creator<zam> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zam createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        ConnectionResult connectionResult = null;
        int i = 0;
        zas zas = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i2 == 2) {
                connectionResult = (ConnectionResult) ReactYogaConfigProvider.createParcelable(parcel, readInt, ConnectionResult.CREATOR);
            } else if (i2 != 3) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                zas = (zas) ReactYogaConfigProvider.createParcelable(parcel, readInt, zas.CREATOR);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zam(i, connectionResult, zas);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zam[] newArray(int i) {
        return new zam[i];
    }
}
