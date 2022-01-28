package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class z9 implements Parcelable.Creator<ba> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ba createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        boolean z = false;
        byte[] bArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = t.t2(parcel, readInt);
            } else if (i3 == 2) {
                bArr = t.R(parcel, readInt);
            } else if (i3 == 3) {
                z = t.q2(parcel, readInt);
            } else if (i3 != 1000) {
                t.O2(parcel, readInt);
            } else {
                i = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new ba(i, i2, bArr, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ba[] newArray(int i) {
        return new ba[i];
    }
}
