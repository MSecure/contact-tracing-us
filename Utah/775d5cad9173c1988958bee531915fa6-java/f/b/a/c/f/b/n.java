package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import java.util.ArrayList;

public final class n implements Parcelable.Creator<e> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final e createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        ArrayList arrayList = null;
        String str = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j2 = m.e.m1(parcel, readInt);
                    break;
                case 2:
                    arrayList = m.e.Q(parcel, readInt, g.CREATOR);
                    break;
                case 3:
                    i2 = m.e.l1(parcel, readInt);
                    break;
                case 4:
                    i3 = m.e.l1(parcel, readInt);
                    break;
                case 5:
                    i4 = m.e.l1(parcel, readInt);
                    break;
                case 6:
                    str = m.e.O(parcel, readInt);
                    break;
                default:
                    m.e.C1(parcel, readInt);
                    break;
            }
        }
        m.e.V(parcel, O1);
        return new e(j2, arrayList, i2, i3, i4, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ e[] newArray(int i2) {
        return new e[i2];
    }
}
