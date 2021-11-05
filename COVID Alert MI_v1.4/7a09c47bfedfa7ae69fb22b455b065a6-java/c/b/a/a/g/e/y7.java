package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class y7 implements Parcelable.Creator<z7> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final z7 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        boolean z = false;
        boolean z2 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = t.b0(parcel, readInt);
                    break;
                case 2:
                    str2 = t.b0(parcel, readInt);
                    break;
                case 3:
                    str3 = t.b0(parcel, readInt);
                    break;
                case 4:
                    z = t.q2(parcel, readInt);
                    break;
                case 5:
                    bArr = t.R(parcel, readInt);
                    break;
                case 6:
                    bArr2 = t.R(parcel, readInt);
                    break;
                case 7:
                    bArr3 = t.R(parcel, readInt);
                    break;
                case 8:
                    z2 = t.q2(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new z7(str, str2, str3, z, bArr, bArr2, bArr3, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z7[] newArray(int i) {
        return new z7[i];
    }
}
