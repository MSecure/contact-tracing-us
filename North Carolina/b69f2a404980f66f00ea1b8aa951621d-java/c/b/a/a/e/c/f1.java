package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class f1 implements Parcelable.Creator<b1> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final b1 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                i.j.g1(parcel, readInt);
            } else {
                iBinder = i.j.Q0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new b1(iBinder);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b1[] newArray(int i) {
        return new b1[i];
    }
}
