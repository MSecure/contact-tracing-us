package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.f.b.b;
/* loaded from: classes.dex */
public final class l2 implements Parcelable.Creator<k2> {
    @Override // android.os.Parcelable.Creator
    public final k2 createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        IBinder iBinder = null;
        b bVar = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 3) {
                iBinder = m.e.q1(parcel, readInt);
            } else if (i2 != 4) {
                m.e.K1(parcel, readInt);
            } else {
                bVar = (b) m.e.M(parcel, readInt, b.CREATOR);
            }
        }
        m.e.W(parcel, W1);
        return new k2(iBinder, bVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k2[] newArray(int i2) {
        return new k2[i2];
    }
}
