package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class c8 implements Parcelable.Creator<d8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final d8 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                t.O2(parcel, readInt);
            } else {
                str = t.b0(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new d8(str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d8[] newArray(int i) {
        return new d8[i];
    }
}
