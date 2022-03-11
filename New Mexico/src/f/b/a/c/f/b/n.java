package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class n implements Parcelable.Creator<e> {
    @Override // android.os.Parcelable.Creator
    public final e createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        ArrayList arrayList = null;
        long j2 = 0;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j2 = m.e.s1(parcel, readInt);
                    break;
                case 2:
                    arrayList = m.e.R(parcel, readInt, g.CREATOR);
                    break;
                case 3:
                    i2 = m.e.r1(parcel, readInt);
                    break;
                case 4:
                    i3 = m.e.r1(parcel, readInt);
                    break;
                case 5:
                    i4 = m.e.r1(parcel, readInt);
                    break;
                case 6:
                    str = m.e.P(parcel, readInt);
                    break;
                case 7:
                    i5 = m.e.r1(parcel, readInt);
                    break;
                default:
                    m.e.K1(parcel, readInt);
                    break;
            }
        }
        m.e.W(parcel, W1);
        return new e(j2, arrayList, i2, i3, i4, str, i5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e[] newArray(int i2) {
        return new e[i2];
    }
}
