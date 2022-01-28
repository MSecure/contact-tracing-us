package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class t3 implements Parcelable.Creator<s3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final s3 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        long j = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = i.j.Q0(parcel, readInt);
            } else if (i != 2) {
                i.j.g1(parcel, readInt);
            } else {
                j = i.j.S0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new s3(iBinder, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s3[] newArray(int i) {
        return new s3[i];
    }
}
