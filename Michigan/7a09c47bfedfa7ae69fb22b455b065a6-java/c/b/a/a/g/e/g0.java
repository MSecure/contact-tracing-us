package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;

public final class g0 implements Parcelable.Creator<c0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final c0 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        DailySummariesConfig dailySummariesConfig = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = t.s2(parcel, readInt);
            } else if (i != 2) {
                t.O2(parcel, readInt);
            } else {
                dailySummariesConfig = (DailySummariesConfig) t.a0(parcel, readInt, DailySummariesConfig.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new c0(iBinder, dailySummariesConfig);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c0[] newArray(int i) {
        return new c0[i];
    }
}
