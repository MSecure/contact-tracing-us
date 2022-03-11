package f.b.a.c.f.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class o implements Parcelable.Creator<f> {
    @Override // android.os.Parcelable.Creator
    public final f createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                m.e.K1(parcel, readInt);
            } else {
                bundle = m.e.E(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new f(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f[] newArray(int i2) {
        return new f[i2];
    }
}
