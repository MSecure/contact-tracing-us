package f.b.a.c.b;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable.Creator
    public final a createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        int i2 = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i4 == 2) {
                i3 = m.e.r1(parcel, readInt);
            } else if (i4 == 3) {
                pendingIntent = (PendingIntent) m.e.M(parcel, readInt, PendingIntent.CREATOR);
            } else if (i4 != 4) {
                m.e.K1(parcel, readInt);
            } else {
                str = m.e.P(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new a(i2, i3, pendingIntent, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i2) {
        return new a[i2];
    }
}
