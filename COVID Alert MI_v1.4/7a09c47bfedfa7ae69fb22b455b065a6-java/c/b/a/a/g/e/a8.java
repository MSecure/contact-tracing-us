package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class a8 implements Parcelable.Creator<b8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final b8 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = t.b0(parcel, readInt);
            } else if (i2 == 2) {
                i = t.t2(parcel, readInt);
            } else if (i2 != 3) {
                t.O2(parcel, readInt);
            } else {
                bArr = t.R(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new b8(str, i, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b8[] newArray(int i) {
        return new b8[i];
    }
}
