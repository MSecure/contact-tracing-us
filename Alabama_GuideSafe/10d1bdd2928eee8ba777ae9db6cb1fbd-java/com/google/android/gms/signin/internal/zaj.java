package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.zar;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaj implements Parcelable.Creator<zak> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zak createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        int i = 0;
        zar zar = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i2 != 2) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                zar = (zar) ReactYogaConfigProvider.createParcelable(parcel, readInt, zar.CREATOR);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zak(i, zar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak[] newArray(int i) {
        return new zak[i];
    }
}
