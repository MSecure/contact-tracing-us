package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;

public final class g0 implements Parcelable.Creator<c0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final c0 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        DailySummariesConfig dailySummariesConfig = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = i.j.Q0(parcel, readInt);
            } else if (i != 2) {
                i.j.g1(parcel, readInt);
            } else {
                dailySummariesConfig = (DailySummariesConfig) i.j.O(parcel, readInt, DailySummariesConfig.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new c0(iBinder, dailySummariesConfig);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c0[] newArray(int i) {
        return new c0[i];
    }
}
