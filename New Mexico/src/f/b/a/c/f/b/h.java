package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class h implements Parcelable.Creator<DailySummariesConfig> {
    @Override // android.os.Parcelable.Creator
    public final DailySummariesConfig createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        ArrayList<Double> arrayList = null;
        double d2 = 0.0d;
        ArrayList<Double> arrayList2 = null;
        ArrayList<Integer> arrayList3 = null;
        ArrayList<Double> arrayList4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = m.e.G(parcel, readInt);
                    break;
                case 2:
                    arrayList2 = m.e.G(parcel, readInt);
                    break;
                case 3:
                    arrayList3 = m.e.I(parcel, readInt);
                    break;
                case 4:
                    arrayList4 = m.e.G(parcel, readInt);
                    break;
                case 5:
                    i2 = m.e.r1(parcel, readInt);
                    break;
                case 6:
                    d2 = m.e.p1(parcel, readInt);
                    break;
                default:
                    m.e.K1(parcel, readInt);
                    break;
            }
        }
        m.e.W(parcel, W1);
        return new DailySummariesConfig(arrayList, arrayList2, arrayList3, arrayList4, i2, d2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummariesConfig[] newArray(int i2) {
        return new DailySummariesConfig[i2];
    }
}
