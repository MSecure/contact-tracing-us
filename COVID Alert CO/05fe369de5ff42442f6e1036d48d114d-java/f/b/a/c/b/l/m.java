package f.b.a.c.b.l;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import e.b.a.m;

public final class m implements Parcelable.Creator<Scope> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Scope createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.h.Z0(parcel, readInt);
            } else if (i3 != 2) {
                m.h.q1(parcel, readInt);
            } else {
                str = m.h.M(parcel, readInt);
            }
        }
        m.h.T(parcel, B1);
        return new Scope(i2, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i2) {
        return new Scope[i2];
    }
}
