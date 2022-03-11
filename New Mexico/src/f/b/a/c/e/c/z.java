package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
/* loaded from: classes.dex */
public final class z implements Parcelable.Creator<y> {
    @Override // android.os.Parcelable.Creator
    public final y createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        IBinder iBinder = null;
        DailySummariesConfig dailySummariesConfig = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.e.q1(parcel, readInt);
            } else if (i2 != 2) {
                m.e.K1(parcel, readInt);
            } else {
                dailySummariesConfig = (DailySummariesConfig) m.e.M(parcel, readInt, DailySummariesConfig.CREATOR);
            }
        }
        m.e.W(parcel, W1);
        return new y(iBinder, dailySummariesConfig);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ y[] newArray(int i2) {
        return new y[i2];
    }
}
