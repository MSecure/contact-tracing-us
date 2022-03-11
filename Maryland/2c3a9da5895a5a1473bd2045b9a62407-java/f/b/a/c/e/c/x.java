package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;

public final class x implements Parcelable.Creator<w> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final w createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        IBinder iBinder = null;
        DailySummariesConfig dailySummariesConfig = null;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.h.S0(parcel, readInt);
            } else if (i2 != 2) {
                m.h.k1(parcel, readInt);
            } else {
                dailySummariesConfig = (DailySummariesConfig) m.h.I(parcel, readInt, DailySummariesConfig.CREATOR);
            }
        }
        m.h.T(parcel, v1);
        return new w(iBinder, dailySummariesConfig);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ w[] newArray(int i2) {
        return new w[i2];
    }
}
