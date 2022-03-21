package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import e.b.a.m;
import java.util.ArrayList;

public final class h implements Parcelable.Creator<DailySummary> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummary createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        ArrayList arrayList = null;
        DailySummary.ExposureSummaryData exposureSummaryData = null;
        int i2 = 0;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.h.S0(parcel, readInt);
            } else if (i3 == 2) {
                arrayList = m.h.N(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            } else if (i3 != 3) {
                m.h.j1(parcel, readInt);
            } else {
                exposureSummaryData = (DailySummary.ExposureSummaryData) m.h.I(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            }
        }
        m.h.T(parcel, u1);
        return new DailySummary(i2, arrayList, exposureSummaryData);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummary[] newArray(int i2) {
        return new DailySummary[i2];
    }
}
