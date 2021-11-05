package c.b.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.g.b.g5;
import c.b.a.a.h.a;

public final class g implements Parcelable.Creator<f> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final f createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        g5 g5Var = null;
        byte[] bArr = null;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[][] bArr2 = null;
        a[] aVarArr = null;
        boolean z = true;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    g5Var = (g5) t.a0(parcel, readInt, g5.CREATOR);
                    break;
                case 3:
                    bArr = t.R(parcel, readInt);
                    break;
                case 4:
                    iArr = t.W(parcel, readInt);
                    break;
                case 5:
                    strArr = t.c0(parcel, readInt);
                    break;
                case 6:
                    iArr2 = t.W(parcel, readInt);
                    break;
                case 7:
                    bArr2 = t.S(parcel, readInt);
                    break;
                case 8:
                    z = t.q2(parcel, readInt);
                    break;
                case 9:
                    aVarArr = (a[]) t.d0(parcel, readInt, a.CREATOR);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new f(g5Var, bArr, iArr, strArr, iArr2, bArr2, z, aVarArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f[] newArray(int i) {
        return new f[i];
    }
}
