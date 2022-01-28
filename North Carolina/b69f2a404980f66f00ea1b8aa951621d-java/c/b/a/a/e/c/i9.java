package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class i9 implements Parcelable.Creator<d9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final d9 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        boolean z = false;
        IBinder iBinder = null;
        String[] strArr = null;
        w8 w8Var = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = i.j.Q0(parcel, readInt);
            } else if (i == 2) {
                int T0 = i.j.T0(parcel, readInt);
                int dataPosition = parcel.dataPosition();
                if (T0 == 0) {
                    strArr = null;
                } else {
                    String[] createStringArray = parcel.createStringArray();
                    parcel.setDataPosition(dataPosition + T0);
                    strArr = createStringArray;
                }
            } else if (i == 3) {
                w8Var = (w8) i.j.O(parcel, readInt, w8.CREATOR);
            } else if (i != 4) {
                i.j.g1(parcel, readInt);
            } else {
                z = i.j.N0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new d9(iBinder, strArr, w8Var, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d9[] newArray(int i) {
        return new d9[i];
    }
}
