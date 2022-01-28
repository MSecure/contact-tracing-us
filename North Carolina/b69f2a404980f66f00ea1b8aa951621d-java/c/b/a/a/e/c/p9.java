package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class p9 implements Parcelable.Creator<n9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final n9 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        while (parcel.dataPosition() < m1) {
            i.j.g1(parcel, parcel.readInt());
        }
        i.j.W(parcel, m1);
        return new n9();
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n9[] newArray(int i) {
        return new n9[i];
    }
}
