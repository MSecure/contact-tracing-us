package c.b.a.a.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class h5 implements Parcelable.Creator<g5> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final g5 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z2 = true;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = t.b0(parcel, readInt);
                    break;
                case 3:
                    i = t.t2(parcel, readInt);
                    break;
                case 4:
                    i2 = t.t2(parcel, readInt);
                    break;
                case 5:
                    str2 = t.b0(parcel, readInt);
                    break;
                case 6:
                    str3 = t.b0(parcel, readInt);
                    break;
                case 7:
                    z2 = t.q2(parcel, readInt);
                    break;
                case 8:
                    str4 = t.b0(parcel, readInt);
                    break;
                case 9:
                    z = t.q2(parcel, readInt);
                    break;
                case 10:
                    i3 = t.t2(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new g5(str, i, i2, str2, str3, z2, str4, z, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g5[] newArray(int i) {
        return new g5[i];
    }
}
