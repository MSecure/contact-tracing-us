package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class w7 implements Parcelable.Creator<x7> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final x7 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = t.b0(parcel, readInt);
            } else if (i2 != 2) {
                t.O2(parcel, readInt);
            } else {
                i = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new x7(str, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x7[] newArray(int i) {
        return new x7[i];
    }
}
