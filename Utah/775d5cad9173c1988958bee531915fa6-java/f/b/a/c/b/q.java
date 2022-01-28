package f.b.a.c.b;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class q implements Parcelable.Creator<a> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final a createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        int i2 = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = m.e.l1(parcel, readInt);
            } else if (i4 == 2) {
                i3 = m.e.l1(parcel, readInt);
            } else if (i4 == 3) {
                pendingIntent = (PendingIntent) m.e.L(parcel, readInt, PendingIntent.CREATOR);
            } else if (i4 != 4) {
                m.e.C1(parcel, readInt);
            } else {
                str = m.e.O(parcel, readInt);
            }
        }
        m.e.V(parcel, O1);
        return new a(i2, i3, pendingIntent, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i2) {
        return new a[i2];
    }
}
