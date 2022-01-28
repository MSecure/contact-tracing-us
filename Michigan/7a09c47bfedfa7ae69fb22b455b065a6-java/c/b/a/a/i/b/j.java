package c.b.a.a.i.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import java.util.ArrayList;

public final class j implements Parcelable.Creator<h> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final h createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                int v2 = t.v2(parcel, readInt);
                int dataPosition = parcel.dataPosition();
                if (v2 == 0) {
                    arrayList = null;
                } else {
                    ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    parcel.setDataPosition(dataPosition + v2);
                    arrayList = createStringArrayList;
                }
            } else if (i != 2) {
                t.O2(parcel, readInt);
            } else {
                str = t.b0(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new h(arrayList, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h[] newArray(int i) {
        return new h[i];
    }
}
