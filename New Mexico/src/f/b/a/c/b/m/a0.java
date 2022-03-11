package f.b.a.c.b.m;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class a0 implements Parcelable.Creator<d> {
    @Override // android.os.Parcelable.Creator
    public final d createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        m mVar = null;
        int[] iArr = null;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                mVar = (m) m.e.M(parcel, readInt, m.CREATOR);
            } else if (i3 == 2) {
                z = m.e.n1(parcel, readInt);
            } else if (i3 == 3) {
                z2 = m.e.n1(parcel, readInt);
            } else if (i3 == 4) {
                iArr = m.e.H(parcel, readInt);
            } else if (i3 != 5) {
                m.e.K1(parcel, readInt);
            } else {
                i2 = m.e.r1(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new d(mVar, z, z2, iArr, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d[] newArray(int i2) {
        return new d[i2];
    }
}
