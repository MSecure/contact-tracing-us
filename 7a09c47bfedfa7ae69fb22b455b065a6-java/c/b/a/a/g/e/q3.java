package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class q3 implements Parcelable.Creator<p3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final p3 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        byte[] bArr = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = t.s2(parcel, readInt);
            } else if (i == 2) {
                iBinder2 = t.s2(parcel, readInt);
            } else if (i == 3) {
                str = t.b0(parcel, readInt);
            } else if (i == 4) {
                bArr = t.R(parcel, readInt);
            } else if (i != 5) {
                t.O2(parcel, readInt);
            } else {
                iBinder3 = t.s2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new p3(iBinder, iBinder2, str, bArr, iBinder3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p3[] newArray(int i) {
        return new p3[i];
    }
}
