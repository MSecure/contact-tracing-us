package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.connection.zzo;

public final class e8 implements Parcelable.Creator<f8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final f8 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        int i = 0;
        zzo zzo = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = i.j.Q(parcel, readInt);
            } else if (i2 == 2) {
                i = i.j.R0(parcel, readInt);
            } else if (i2 != 3) {
                i.j.g1(parcel, readInt);
            } else {
                zzo = (zzo) i.j.O(parcel, readInt, zzo.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new f8(str, i, zzo);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f8[] newArray(int i) {
        return new f8[i];
    }
}
