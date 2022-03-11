package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class p implements Parcelable.Creator<g> {
    @Override // android.os.Parcelable.Creator
    public final g createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i5 = 65535 & readInt;
            if (i5 == 1) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i5 == 2) {
                i3 = m.e.r1(parcel, readInt);
            } else if (i5 != 3) {
                m.e.K1(parcel, readInt);
            } else {
                i4 = m.e.r1(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new g(i2, i3, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g[] newArray(int i2) {
        return new g[i2];
    }
}
