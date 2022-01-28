package c.b.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class c implements Parcelable.Creator<a> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final a createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        byte[] bArr = null;
        byte[][] bArr2 = null;
        byte[][] bArr3 = null;
        byte[][] bArr4 = null;
        byte[][] bArr5 = null;
        int[] iArr = null;
        byte[][] bArr6 = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = t.b0(parcel, readInt);
                    break;
                case 3:
                    bArr = t.R(parcel, readInt);
                    break;
                case 4:
                    bArr2 = t.S(parcel, readInt);
                    break;
                case 5:
                    bArr3 = t.S(parcel, readInt);
                    break;
                case 6:
                    bArr4 = t.S(parcel, readInt);
                    break;
                case 7:
                    bArr5 = t.S(parcel, readInt);
                    break;
                case 8:
                    iArr = t.W(parcel, readInt);
                    break;
                case 9:
                    bArr6 = t.S(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new a(str, bArr, bArr2, bArr3, bArr4, bArr5, iArr, bArr6);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i) {
        return new a[i];
    }
}
