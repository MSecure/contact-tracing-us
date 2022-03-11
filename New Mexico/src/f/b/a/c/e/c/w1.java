package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class w1 implements Parcelable.Creator<v1> {
    @Override // android.os.Parcelable.Creator
    public final v1 createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.e.q1(parcel, readInt);
            } else if (i2 != 2) {
                m.e.K1(parcel, readInt);
            } else {
                iBinder2 = m.e.q1(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new v1(iBinder, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v1[] newArray(int i2) {
        return new v1[i2];
    }
}
