package c.b.a.a.c.k;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.common.api.Scope;

public final class q implements Parcelable.Creator<Scope> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Scope createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i2 != 2) {
                i.j.g1(parcel, readInt);
            } else {
                str = i.j.Q(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new Scope(i, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i) {
        return new Scope[i];
    }
}
