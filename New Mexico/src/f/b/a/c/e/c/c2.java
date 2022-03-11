package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class c2 implements Parcelable.Creator<b2> {
    @Override // android.os.Parcelable.Creator
    public final b2 createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        IBinder iBinder = null;
        boolean z = false;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.e.q1(parcel, readInt);
            } else if (i2 != 2) {
                m.e.K1(parcel, readInt);
            } else {
                z = m.e.n1(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new b2(iBinder, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b2[] newArray(int i2) {
        return new b2[i2];
    }
}
