package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class y7 implements Parcelable.Creator<z7> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final z7 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        boolean z = false;
        boolean z2 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 2:
                    str2 = i.j.Q(parcel, readInt);
                    break;
                case 3:
                    str3 = i.j.Q(parcel, readInt);
                    break;
                case 4:
                    z = i.j.N0(parcel, readInt);
                    break;
                case 5:
                    bArr = i.j.F(parcel, readInt);
                    break;
                case 6:
                    bArr2 = i.j.F(parcel, readInt);
                    break;
                case 7:
                    bArr3 = i.j.F(parcel, readInt);
                    break;
                case 8:
                    z2 = i.j.N0(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new z7(str, str2, str3, z, bArr, bArr2, bArr3, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z7[] newArray(int i) {
        return new z7[i];
    }
}
