package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import b.x.t;

public final class w9 implements Parcelable.Creator<u9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final u9 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = null;
        ParcelUuid parcelUuid3 = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 != 1) {
                switch (i3) {
                    case 4:
                        parcelUuid = (ParcelUuid) t.a0(parcel, readInt, ParcelUuid.CREATOR);
                        continue;
                    case 5:
                        parcelUuid2 = (ParcelUuid) t.a0(parcel, readInt, ParcelUuid.CREATOR);
                        continue;
                    case 6:
                        parcelUuid3 = (ParcelUuid) t.a0(parcel, readInt, ParcelUuid.CREATOR);
                        continue;
                    case 7:
                        bArr = t.R(parcel, readInt);
                        continue;
                    case 8:
                        bArr2 = t.R(parcel, readInt);
                        continue;
                    case 9:
                        i2 = t.t2(parcel, readInt);
                        continue;
                    case 10:
                        bArr3 = t.R(parcel, readInt);
                        continue;
                    case 11:
                        bArr4 = t.R(parcel, readInt);
                        continue;
                    default:
                        t.O2(parcel, readInt);
                        continue;
                }
            } else {
                i = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new u9(i, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i2, bArr3, bArr4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u9[] newArray(int i) {
        return new u9[i];
    }
}
