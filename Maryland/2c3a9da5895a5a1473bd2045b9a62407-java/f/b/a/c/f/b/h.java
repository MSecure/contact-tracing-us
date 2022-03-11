package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import java.util.ArrayList;

public final class h implements Parcelable.Creator<DailySummariesConfig> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummariesConfig createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        ArrayList<Double> arrayList = null;
        ArrayList<Double> arrayList2 = null;
        ArrayList<Integer> arrayList3 = null;
        ArrayList<Double> arrayList4 = null;
        double d2 = 0.0d;
        int i2 = 0;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = m.h.C(parcel, readInt);
                    break;
                case 2:
                    arrayList2 = m.h.C(parcel, readInt);
                    break;
                case 3:
                    arrayList3 = m.h.G(parcel, readInt);
                    break;
                case 4:
                    arrayList4 = m.h.C(parcel, readInt);
                    break;
                case 5:
                    i2 = m.h.T0(parcel, readInt);
                    break;
                case 6:
                    d2 = m.h.R0(parcel, readInt);
                    break;
                default:
                    m.h.k1(parcel, readInt);
                    break;
            }
        }
        m.h.T(parcel, v1);
        return new DailySummariesConfig(arrayList, arrayList2, arrayList3, arrayList4, i2, d2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DailySummariesConfig[] newArray(int i2) {
        return new DailySummariesConfig[i2];
    }
}
