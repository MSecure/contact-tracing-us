package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
/* loaded from: classes.dex */
public final class k implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    public final b createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
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
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = m.e.r1(parcel, readInt);
                    break;
                case 2:
                    iArr = m.e.H(parcel, readInt);
                    break;
                case 3:
                    i3 = m.e.r1(parcel, readInt);
                    break;
                case 4:
                    iArr2 = m.e.H(parcel, readInt);
                    break;
                case 5:
                    i4 = m.e.r1(parcel, readInt);
                    break;
                case 6:
                    iArr3 = m.e.H(parcel, readInt);
                    break;
                case 7:
                    i5 = m.e.r1(parcel, readInt);
                    break;
                case 8:
                    iArr4 = m.e.H(parcel, readInt);
                    break;
                case 9:
                    i6 = m.e.r1(parcel, readInt);
                    break;
                case 10:
                    iArr5 = m.e.H(parcel, readInt);
                    break;
                default:
                    m.e.K1(parcel, readInt);
                    break;
            }
        }
        m.e.W(parcel, W1);
        return new b(i2, iArr, i3, iArr2, i4, iArr3, i5, iArr4, i6, iArr5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b[] newArray(int i2) {
        return new b[i2];
    }
}
