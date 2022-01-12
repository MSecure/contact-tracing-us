package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.data.DataHolder;

public final class zzj implements Parcelable.Creator<SafeBrowsingData> {
    public static void zza(SafeBrowsingData safeBrowsingData, Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeString(parcel, 2, safeBrowsingData.zzm, false);
        ReactYogaConfigProvider.writeParcelable(parcel, 3, safeBrowsingData.zzn, i, false);
        ReactYogaConfigProvider.writeParcelable(parcel, 4, safeBrowsingData.zzo, i, false);
        ReactYogaConfigProvider.writeLong(parcel, 5, safeBrowsingData.zzp);
        ReactYogaConfigProvider.writeByteArray(parcel, 6, safeBrowsingData.zzq, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final SafeBrowsingData createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        String str = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArr = null;
        long j = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 2) {
                str = ReactYogaConfigProvider.createString(parcel, readInt);
            } else if (i == 3) {
                dataHolder = (DataHolder) ReactYogaConfigProvider.createParcelable(parcel, readInt, DataHolder.CREATOR);
            } else if (i == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) ReactYogaConfigProvider.createParcelable(parcel, readInt, ParcelFileDescriptor.CREATOR);
            } else if (i == 5) {
                j = ReactYogaConfigProvider.readLong(parcel, readInt);
            } else if (i != 6) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                bArr = ReactYogaConfigProvider.createByteArray(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new SafeBrowsingData(str, dataHolder, parcelFileDescriptor, j, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeBrowsingData[] newArray(int i) {
        return new SafeBrowsingData[i];
    }
}
