package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class j implements Parcelable.Creator<h> {
    @Override // android.os.Parcelable.Creator
    public final h createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                int t1 = m.e.t1(parcel, readInt);
                int dataPosition = parcel.dataPosition();
                if (t1 == 0) {
                    arrayList = null;
                } else {
                    arrayList = parcel.createStringArrayList();
                    parcel.setDataPosition(dataPosition + t1);
                }
            } else if (i2 != 2) {
                m.e.K1(parcel, readInt);
            } else {
                str = m.e.P(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new h(arrayList, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h[] newArray(int i2) {
        return new h[i2];
    }
}
