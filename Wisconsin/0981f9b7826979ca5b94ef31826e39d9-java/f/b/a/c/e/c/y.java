package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;

public final class y implements Parcelable.Creator<v> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final v createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        IBinder iBinder = null;
        DailySummariesConfig dailySummariesConfig = null;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.h.R0(parcel, readInt);
            } else if (i2 != 2) {
                m.h.j1(parcel, readInt);
            } else {
                dailySummariesConfig = (DailySummariesConfig) m.h.I(parcel, readInt, DailySummariesConfig.CREATOR);
            }
        }
        m.h.T(parcel, u1);
        return new v(iBinder, dailySummariesConfig);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v[] newArray(int i2) {
        return new v[i2];
    }
}
