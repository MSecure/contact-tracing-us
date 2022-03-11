package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class f0 implements Parcelable.Creator<e0> {
    @Override // android.os.Parcelable.Creator
    public final e0 createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        IBinder iBinder = null;
        String str = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.e.q1(parcel, readInt);
            } else if (i2 != 2) {
                m.e.K1(parcel, readInt);
            } else {
                str = m.e.P(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new e0(iBinder, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e0[] newArray(int i2) {
        return new e0[i2];
    }
}
