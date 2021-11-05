package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import b.b.k.i;

public final class w9 implements Parcelable.Creator<u9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final u9 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        int i2 = 0;
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = null;
        ParcelUuid parcelUuid3 = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 != 1) {
                switch (i3) {
                    case 4:
                        parcelUuid = (ParcelUuid) i.j.O(parcel, readInt, ParcelUuid.CREATOR);
                        continue;
                    case 5:
                        parcelUuid2 = (ParcelUuid) i.j.O(parcel, readInt, ParcelUuid.CREATOR);
                        continue;
                    case 6:
                        parcelUuid3 = (ParcelUuid) i.j.O(parcel, readInt, ParcelUuid.CREATOR);
                        continue;
                    case 7:
                        bArr = i.j.F(parcel, readInt);
                        continue;
                    case 8:
                        bArr2 = i.j.F(parcel, readInt);
                        continue;
                    case 9:
                        i2 = i.j.R0(parcel, readInt);
                        continue;
                    case 10:
                        bArr3 = i.j.F(parcel, readInt);
                        continue;
                    case 11:
                        bArr4 = i.j.F(parcel, readInt);
                        continue;
                    default:
                        i.j.g1(parcel, readInt);
                        continue;
                }
            } else {
                i = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new u9(i, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i2, bArr3, bArr4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u9[] newArray(int i) {
        return new u9[i];
    }
}
