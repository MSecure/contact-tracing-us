package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import e.b.a.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class i implements Parcelable.Creator<DailySummary> {
    @Override // android.os.Parcelable.Creator
    public final DailySummary createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        ArrayList arrayList = null;
        DailySummary.ExposureSummaryData exposureSummaryData = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i3 == 2) {
                arrayList = m.e.R(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            } else if (i3 == 3) {
                exposureSummaryData = (DailySummary.ExposureSummaryData) m.e.M(parcel, readInt, DailySummary.ExposureSummaryData.CREATOR);
            } else if (i3 != 4) {
                m.e.K1(parcel, readInt);
            } else {
                str = m.e.P(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new DailySummary(i2, arrayList, exposureSummaryData, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummary[] newArray(int i2) {
        return new DailySummary[i2];
    }
}
