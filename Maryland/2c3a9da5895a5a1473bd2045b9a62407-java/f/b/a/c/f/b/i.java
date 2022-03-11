package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import e.b.a.m;
import java.util.ArrayList;

public final class i implements Parcelable.Creator<DailySummary> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummary createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        ArrayList arrayList = null;
        DailySummary.ExposureSummaryData exposureSummaryData = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.h.T0(parcel, readInt);
            } else if (i3 == 2) {
                arrayList = m.h.N(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            } else if (i3 == 3) {
                exposureSummaryData = (DailySummary.ExposureSummaryData) m.h.I(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            } else if (i3 != 4) {
                m.h.k1(parcel, readInt);
            } else {
                str = m.h.L(parcel, readInt);
            }
        }
        m.h.T(parcel, v1);
        return new DailySummary(i2, arrayList, exposureSummaryData, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DailySummary[] newArray(int i2) {
        return new DailySummary[i2];
    }
}
