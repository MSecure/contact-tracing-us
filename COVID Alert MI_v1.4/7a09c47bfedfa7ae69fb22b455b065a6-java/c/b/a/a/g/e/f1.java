package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class f1 implements Parcelable.Creator<b1> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final b1 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                t.O2(parcel, readInt);
            } else {
                iBinder = t.s2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new b1(iBinder);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b1[] newArray(int i) {
        return new b1[i];
    }
}
