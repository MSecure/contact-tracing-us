package f.b.a.c.h.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        int i2 = 0;
        Intent intent = null;
        int i3 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i4 == 2) {
                i3 = m.e.r1(parcel, readInt);
            } else if (i4 != 3) {
                m.e.K1(parcel, readInt);
            } else {
                intent = (Intent) m.e.M(parcel, readInt, Intent.CREATOR);
            }
        }
        m.e.W(parcel, W1);
        return new c(i2, i3, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i2) {
        return new c[i2];
    }
}
