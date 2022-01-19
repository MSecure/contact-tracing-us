package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzb implements Parcelable.Creator<Feature> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Feature createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = ReactYogaConfigProvider.createString(parcel, readInt);
            } else if (i2 == 2) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i2 != 3) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                j = ReactYogaConfigProvider.readLong(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new Feature(str, i, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature[] newArray(int i) {
        return new Feature[i];
    }
}
