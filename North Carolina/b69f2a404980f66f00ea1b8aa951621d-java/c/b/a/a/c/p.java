package c.b.a.a.c;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class p implements Parcelable.Creator<a> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final a createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        PendingIntent pendingIntent = null;
        int i = 0;
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i3 == 2) {
                i2 = i.j.R0(parcel, readInt);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) i.j.O(parcel, readInt, PendingIntent.CREATOR);
            } else if (i3 != 4) {
                i.j.g1(parcel, readInt);
            } else {
                str = i.j.Q(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new a(i, i2, pendingIntent, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i) {
        return new a[i];
    }
}
