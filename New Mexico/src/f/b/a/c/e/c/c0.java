package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class c0 implements Parcelable.Creator<b0> {
    @Override // android.os.Parcelable.Creator
    public final b0 createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        IBinder iBinder = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                m.e.K1(parcel, readInt);
            } else {
                iBinder = m.e.q1(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new b0(iBinder);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b0[] newArray(int i2) {
        return new b0[i2];
    }
}
