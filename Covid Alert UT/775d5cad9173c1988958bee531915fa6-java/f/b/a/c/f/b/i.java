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
        int O1 = m.e.O1(parcel);
        ArrayList arrayList = null;
        DailySummary.ExposureSummaryData exposureSummaryData = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.e.l1(parcel, readInt);
            } else if (i3 == 2) {
                arrayList = m.e.Q(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            } else if (i3 == 3) {
                exposureSummaryData = (DailySummary.ExposureSummaryData) m.e.L(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            } else if (i3 != 4) {
                m.e.C1(parcel, readInt);
            } else {
                str = m.e.O(parcel, readInt);
            }
        }
        m.e.V(parcel, O1);
        return new DailySummary(i2, arrayList, exposureSummaryData, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DailySummary[] newArray(int i2) {
        return new DailySummary[i2];
    }
}
