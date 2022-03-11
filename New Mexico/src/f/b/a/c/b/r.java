package f.b.a.c.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class r implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        String str = null;
        int i2 = 0;
        long j2 = -1;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                str = m.e.P(parcel, readInt);
            } else if (i3 == 2) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i3 != 3) {
                m.e.K1(parcel, readInt);
            } else {
                j2 = m.e.s1(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new c(str, i2, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i2) {
        return new c[i2];
    }
}
