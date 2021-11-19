package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzb implements Parcelable.Creator<AdvertisingOptions> {
    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdvertisingOptions[] newArray(int i) {
        return new AdvertisingOptions[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdvertisingOptions createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Strategy strategy = null;
        byte[] bArr = null;
        ParcelUuid parcelUuid = null;
        byte[] bArr2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i = 0;
        int i2 = 0;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        boolean z10 = true;
        boolean z11 = true;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    strategy = (Strategy) SafeParcelReader.createParcelable(parcel, readHeader, Strategy.CREATOR);
                    break;
                case 2:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 7:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    parcelUuid = (ParcelUuid) SafeParcelReader.createParcelable(parcel, readHeader, ParcelUuid.CREATOR);
                    break;
                case 9:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 12:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 13:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 14:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 15:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 16:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 17:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new AdvertisingOptions(strategy, z5, z6, z7, z8, bArr, z, parcelUuid, z9, z10, z11, z2, z3, z4, i, i2, bArr2);
    }
}
