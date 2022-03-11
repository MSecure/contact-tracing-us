package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.u;
/* loaded from: classes.dex */
public final class k implements Parcelable.Creator<l> {
    @Override // android.os.Parcelable.Creator
    public final l createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        int i2 = 0;
        u uVar = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i3 != 2) {
                m.e.K1(parcel, readInt);
            } else {
                uVar = (u) m.e.M(parcel, readInt, u.CREATOR);
            }
        }
        m.e.W(parcel, W1);
        return new l(i2, uVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i2) {
        return new l[i2];
    }
}
