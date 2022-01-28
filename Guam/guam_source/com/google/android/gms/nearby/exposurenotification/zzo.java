package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzo implements Parcelable.Creator<TemporaryExposureKey> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final TemporaryExposureKey createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    bArr = ReactYogaConfigProvider.createByteArray(parcel, readInt);
                    break;
                case 2:
                    i = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                case 3:
                    i2 = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                case 4:
                    i3 = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                case 5:
                    i4 = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                case 6:
                    i5 = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                default:
                    ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new TemporaryExposureKey(bArr, i, i2, i3, i4, i5);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TemporaryExposureKey[] newArray(int i) {
        return new TemporaryExposureKey[i];
    }
}
