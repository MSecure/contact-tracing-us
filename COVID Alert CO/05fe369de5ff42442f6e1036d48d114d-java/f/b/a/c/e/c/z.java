package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;

public final class z implements Parcelable.Creator<y> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final y createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        IBinder iBinder = null;
        DailySummariesConfig dailySummariesConfig = null;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.h.Y0(parcel, readInt);
            } else if (i2 != 2) {
                m.h.q1(parcel, readInt);
            } else {
                dailySummariesConfig = (DailySummariesConfig) m.h.J(parcel, readInt, DailySummariesConfig.CREATOR);
            }
        }
        m.h.T(parcel, B1);
        return new y(iBinder, dailySummariesConfig);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ y[] newArray(int i2) {
        return new y[i2];
    }
}
