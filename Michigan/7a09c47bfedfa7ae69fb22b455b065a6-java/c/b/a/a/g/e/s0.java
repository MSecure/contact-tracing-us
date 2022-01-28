package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class s0 implements Parcelable.Creator<o0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final o0 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        String str = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = t.s2(parcel, readInt);
            } else if (i != 2) {
                t.O2(parcel, readInt);
            } else {
                str = t.b0(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new o0(iBinder, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o0[] newArray(int i) {
        return new o0[i];
    }
}
