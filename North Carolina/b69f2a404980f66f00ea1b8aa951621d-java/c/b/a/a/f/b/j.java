package c.b.a.a.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import java.util.ArrayList;

public final class j implements Parcelable.Creator<h> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final h createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                int T0 = i.j.T0(parcel, readInt);
                int dataPosition = parcel.dataPosition();
                if (T0 == 0) {
                    arrayList = null;
                } else {
                    ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    parcel.setDataPosition(dataPosition + T0);
                    arrayList = createStringArrayList;
                }
            } else if (i != 2) {
                i.j.g1(parcel, readInt);
            } else {
                str = i.j.Q(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new h(arrayList, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h[] newArray(int i) {
        return new h[i];
    }
}
