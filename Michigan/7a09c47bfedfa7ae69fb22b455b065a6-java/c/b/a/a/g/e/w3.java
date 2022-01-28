package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class w3 implements Parcelable.Creator<u3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final u3 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        while (parcel.dataPosition() < f3) {
            t.O2(parcel, parcel.readInt());
        }
        t.i1(parcel, f3);
        return new u3();
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u3[] newArray(int i) {
        return new u3[i];
    }
}
