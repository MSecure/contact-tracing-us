package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import e.b.a.m;
/* loaded from: classes.dex */
public final class m implements Parcelable.Creator<DailySummary.ExposureSummaryData> {
    @Override // android.os.Parcelable.Creator
    public final DailySummary.ExposureSummaryData createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                d2 = m.e.p1(parcel, readInt);
            } else if (i2 == 2) {
                d3 = m.e.p1(parcel, readInt);
            } else if (i2 != 3) {
                m.e.K1(parcel, readInt);
            } else {
                d4 = m.e.p1(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new DailySummary.ExposureSummaryData(d2, d3, d4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummary.ExposureSummaryData[] newArray(int i2) {
        return new DailySummary.ExposureSummaryData[i2];
    }
}
