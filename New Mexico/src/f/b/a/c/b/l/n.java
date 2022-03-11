package f.b.a.c.b.l;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.b.a;
/* loaded from: classes.dex */
public final class n implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final Status createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        a aVar = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i3 = m.e.r1(parcel, readInt);
            } else if (i4 == 2) {
                str = m.e.P(parcel, readInt);
            } else if (i4 == 3) {
                pendingIntent = (PendingIntent) m.e.M(parcel, readInt, PendingIntent.CREATOR);
            } else if (i4 == 4) {
                aVar = (a) m.e.M(parcel, readInt, a.CREATOR);
            } else if (i4 != 1000) {
                m.e.K1(parcel, readInt);
            } else {
                i2 = m.e.r1(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new Status(i2, i3, str, pendingIntent, aVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i2) {
        return new Status[i2];
    }
}
