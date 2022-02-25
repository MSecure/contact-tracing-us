package f.b.a.c.b.l;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import e.b.a.m;

public final class m implements Parcelable.Creator<Scope> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Scope createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.h.T0(parcel, readInt);
            } else if (i3 != 2) {
                m.h.k1(parcel, readInt);
            } else {
                str = m.h.L(parcel, readInt);
            }
        }
        m.h.T(parcel, v1);
        return new Scope(i2, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i2) {
        return new Scope[i2];
    }
}
