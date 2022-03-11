package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import e.b.a.m;

public final class m implements Parcelable.Creator<DailySummary.ExposureSummaryData> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummary.ExposureSummaryData createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                d2 = m.h.R0(parcel, readInt);
            } else if (i2 == 2) {
                d3 = m.h.R0(parcel, readInt);
            } else if (i2 != 3) {
                m.h.k1(parcel, readInt);
            } else {
                d4 = m.h.R0(parcel, readInt);
            }
        }
        m.h.T(parcel, v1);
        return new DailySummary.ExposureSummaryData(d2, d3, d4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DailySummary.ExposureSummaryData[] newArray(int i2) {
        return new DailySummary.ExposureSummaryData[i2];
    }
}
