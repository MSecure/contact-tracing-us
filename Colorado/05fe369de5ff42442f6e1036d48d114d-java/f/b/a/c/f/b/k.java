package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class k implements Parcelable.Creator<b> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final b createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        int[] iArr = null;
        int[] iArr2 = null;
        int[] iArr3 = null;
        int[] iArr4 = null;
        int[] iArr5 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = m.h.Z0(parcel, readInt);
                    break;
                case 2:
                    iArr = m.h.F(parcel, readInt);
                    break;
                case 3:
                    i3 = m.h.Z0(parcel, readInt);
                    break;
                case 4:
                    iArr2 = m.h.F(parcel, readInt);
                    break;
                case 5:
                    i4 = m.h.Z0(parcel, readInt);
                    break;
                case 6:
                    iArr3 = m.h.F(parcel, readInt);
                    break;
                case 7:
                    i5 = m.h.Z0(parcel, readInt);
                    break;
                case 8:
                    iArr4 = m.h.F(parcel, readInt);
                    break;
                case 9:
                    i6 = m.h.Z0(parcel, readInt);
                    break;
                case 10:
                    iArr5 = m.h.F(parcel, readInt);
                    break;
                default:
                    m.h.q1(parcel, readInt);
                    break;
            }
        }
        m.h.T(parcel, B1);
        return new b(i2, iArr, i3, iArr2, i4, iArr3, i5, iArr4, i6, iArr5);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ b[] newArray(int i2) {
        return new b[i2];
    }
}
