package c.b.a.a.i.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class b implements Parcelable.Creator<c> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i3 == 2) {
                i2 = t.t2(parcel, readInt);
            } else if (i3 != 3) {
                t.O2(parcel, readInt);
            } else {
                intent = (Intent) t.a0(parcel, readInt, Intent.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new c(i, i2, intent);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }
}
