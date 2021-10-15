package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class i9 implements Parcelable.Creator<d9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final d9 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        w8 w8Var = null;
        boolean z = false;
        String[] strArr = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = t.s2(parcel, readInt);
            } else if (i == 2) {
                strArr = t.c0(parcel, readInt);
            } else if (i == 3) {
                w8Var = (w8) t.a0(parcel, readInt, w8.CREATOR);
            } else if (i != 4) {
                t.O2(parcel, readInt);
            } else {
                z = t.q2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new d9(iBinder, strArr, w8Var, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d9[] newArray(int i) {
        return new d9[i];
    }
}
