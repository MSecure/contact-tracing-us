package f.b.a.c.b.l;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.b.a;

public final class n implements Parcelable.Creator<Status> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Status createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        a aVar = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i3 = m.h.Z0(parcel, readInt);
            } else if (i4 == 2) {
                str = m.h.M(parcel, readInt);
            } else if (i4 == 3) {
                pendingIntent = (PendingIntent) m.h.J(parcel, readInt, PendingIntent.CREATOR);
            } else if (i4 == 4) {
                aVar = (a) m.h.J(parcel, readInt, a.CREATOR);
            } else if (i4 != 1000) {
                m.h.q1(parcel, readInt);
            } else {
                i2 = m.h.Z0(parcel, readInt);
            }
        }
        m.h.T(parcel, B1);
        return new Status(i2, i3, str, pendingIntent, aVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i2) {
        return new Status[i2];
    }
}
