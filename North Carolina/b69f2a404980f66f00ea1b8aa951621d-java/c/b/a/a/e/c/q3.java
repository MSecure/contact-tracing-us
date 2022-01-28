package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class q3 implements Parcelable.Creator<p3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final p3 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        byte[] bArr = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = i.j.Q0(parcel, readInt);
            } else if (i == 2) {
                iBinder2 = i.j.Q0(parcel, readInt);
            } else if (i == 3) {
                str = i.j.Q(parcel, readInt);
            } else if (i == 4) {
                bArr = i.j.F(parcel, readInt);
            } else if (i != 5) {
                i.j.g1(parcel, readInt);
            } else {
                iBinder3 = i.j.Q0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new p3(iBinder, iBinder2, str, bArr, iBinder3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p3[] newArray(int i) {
        return new p3[i];
    }
}
