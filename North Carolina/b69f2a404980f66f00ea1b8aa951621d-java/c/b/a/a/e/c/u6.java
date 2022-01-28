package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class u6 implements Parcelable.Creator<q6> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final q6 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                i.j.g1(parcel, readInt);
            } else {
                str = i.j.Q(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new q6(str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q6[] newArray(int i) {
        return new q6[i];
    }
}
