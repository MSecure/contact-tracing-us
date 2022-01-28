package c.b.a.a.i.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.w;

public final class k implements Parcelable.Creator<l> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final l createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        w wVar = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i2 != 2) {
                t.O2(parcel, readInt);
            } else {
                wVar = (w) t.a0(parcel, readInt, w.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new l(i, wVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i) {
        return new l[i];
    }
}
