package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.connection.zzo;

public final class e8 implements Parcelable.Creator<f8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final f8 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        int i = 0;
        zzo zzo = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = t.b0(parcel, readInt);
            } else if (i2 == 2) {
                i = t.t2(parcel, readInt);
            } else if (i2 != 3) {
                t.O2(parcel, readInt);
            } else {
                zzo = (zzo) t.a0(parcel, readInt, zzo.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new f8(str, i, zzo);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f8[] newArray(int i) {
        return new f8[i];
    }
}
