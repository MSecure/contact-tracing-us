package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zza implements Parcelable.Creator<ConnectionResult> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ConnectionResult createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        PendingIntent pendingIntent = null;
        int i = 0;
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i3 == 2) {
                i2 = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) ReactYogaConfigProvider.createParcelable(parcel, readInt, PendingIntent.CREATOR);
            } else if (i3 != 4) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                str = ReactYogaConfigProvider.createString(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new ConnectionResult(i, i2, pendingIntent, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
