package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class t3 implements Parcelable.Creator<s3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final s3 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        long j = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = t.s2(parcel, readInt);
            } else if (i != 2) {
                t.O2(parcel, readInt);
            } else {
                j = t.u2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new s3(iBinder, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s3[] newArray(int i) {
        return new s3[i];
    }
}
