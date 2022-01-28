package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.connection.ConnectionOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzjo implements Parcelable.Creator<zzjn> {
    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjn[] newArray(int i) {
        return new zzjn[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjn createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        IBinder iBinder4 = null;
        byte[] bArr2 = null;
        ConnectionOptions connectionOptions = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 2:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 3:
                    iBinder3 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 7:
                    iBinder4 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 8:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 9:
                    connectionOptions = (ConnectionOptions) SafeParcelReader.createParcelable(parcel, readHeader, ConnectionOptions.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzjn(iBinder, iBinder2, iBinder3, str, str2, bArr, iBinder4, bArr2, connectionOptions);
    }
}
