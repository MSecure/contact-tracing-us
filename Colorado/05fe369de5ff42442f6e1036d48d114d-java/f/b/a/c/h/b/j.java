package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import java.util.ArrayList;

public final class j implements Parcelable.Creator<h> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final h createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                int b1 = m.h.b1(parcel, readInt);
                int dataPosition = parcel.dataPosition();
                if (b1 == 0) {
                    arrayList = null;
                } else {
                    ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    parcel.setDataPosition(dataPosition + b1);
                    arrayList = createStringArrayList;
                }
            } else if (i2 != 2) {
                m.h.q1(parcel, readInt);
            } else {
                str = m.h.M(parcel, readInt);
            }
        }
        m.h.T(parcel, B1);
        return new h(arrayList, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h[] newArray(int i2) {
        return new h[i2];
    }
}
