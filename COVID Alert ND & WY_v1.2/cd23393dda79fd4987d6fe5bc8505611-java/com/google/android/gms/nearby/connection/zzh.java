package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzh implements Parcelable.Creator<ConnectionOptions> {
    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionOptions[] newArray(int i) {
        return new ConnectionOptions[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionOptions createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        byte[] bArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 2:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 10:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ConnectionOptions(z, z3, z4, z5, z6, z7, z8, z9, bArr, z2);
    }
}
