package c.b.a.a.f.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class b implements Parcelable.Creator<c> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i3 == 2) {
                i2 = i.j.R0(parcel, readInt);
            } else if (i3 != 3) {
                i.j.g1(parcel, readInt);
            } else {
                intent = (Intent) i.j.O(parcel, readInt, Intent.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new c(i, i2, intent);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }
}
