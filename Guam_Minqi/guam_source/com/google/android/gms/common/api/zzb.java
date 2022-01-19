package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzb implements Parcelable.Creator<Status> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Status createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i3 == 2) {
                str = ReactYogaConfigProvider.createString(parcel, readInt);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) ReactYogaConfigProvider.createParcelable(parcel, readInt, PendingIntent.CREATOR);
            } else if (i3 == 4) {
                connectionResult = (ConnectionResult) ReactYogaConfigProvider.createParcelable(parcel, readInt, ConnectionResult.CREATOR);
            } else if (i3 != 1000) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new Status(i, i2, str, pendingIntent, connectionResult);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }
}
