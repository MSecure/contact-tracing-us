package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import e.b.a.m;

public final class l implements Parcelable.Creator<DailySummary.ExposureSummaryData> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummary.ExposureSummaryData createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                d2 = m.h.Q0(parcel, readInt);
            } else if (i2 == 2) {
                d3 = m.h.Q0(parcel, readInt);
            } else if (i2 != 3) {
                m.h.j1(parcel, readInt);
            } else {
                d4 = m.h.Q0(parcel, readInt);
            }
        }
        m.h.T(parcel, u1);
        return new DailySummary.ExposureSummaryData(d2, d3, d4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummary.ExposureSummaryData[] newArray(int i2) {
        return new DailySummary.ExposureSummaryData[i2];
    }
}
