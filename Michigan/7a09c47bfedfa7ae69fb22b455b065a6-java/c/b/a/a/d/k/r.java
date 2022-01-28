package c.b.a.a.d.k;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.a;
import com.google.android.gms.common.api.Status;

public final class r implements Parcelable.Creator<Status> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Status createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        a aVar = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = t.t2(parcel, readInt);
            } else if (i3 == 2) {
                str = t.b0(parcel, readInt);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) t.a0(parcel, readInt, PendingIntent.CREATOR);
            } else if (i3 == 4) {
                aVar = (a) t.a0(parcel, readInt, a.CREATOR);
            } else if (i3 != 1000) {
                t.O2(parcel, readInt);
            } else {
                i = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new Status(i, i2, str, pendingIntent, aVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }
}
