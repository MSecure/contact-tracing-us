package f.b.a.c.b.l;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import e.b.a.m;
/* loaded from: classes.dex */
public final class m implements Parcelable.Creator<Scope> {
    @Override // android.os.Parcelable.Creator
    public final Scope createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i3 != 2) {
                m.e.K1(parcel, readInt);
            } else {
                str = m.e.P(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new Scope(i2, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i2) {
        return new Scope[i2];
    }
}
