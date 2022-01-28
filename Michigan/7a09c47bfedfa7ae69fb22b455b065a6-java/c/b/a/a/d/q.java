package c.b.a.a.d;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class q implements Parcelable.Creator<a> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final a createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        PendingIntent pendingIntent = null;
        int i = 0;
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i3 == 2) {
                i2 = t.t2(parcel, readInt);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) t.a0(parcel, readInt, PendingIntent.CREATOR);
            } else if (i3 != 4) {
                t.O2(parcel, readInt);
            } else {
                str = t.b0(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new a(i, i2, pendingIntent, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i) {
        return new a[i];
    }
}
