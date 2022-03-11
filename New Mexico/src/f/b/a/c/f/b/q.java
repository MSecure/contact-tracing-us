package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.b.a.m;
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator<TemporaryExposureKey> {
    @Override // android.os.Parcelable.Creator
    public final TemporaryExposureKey createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    bArr = m.e.F(parcel, readInt);
                    break;
                case 2:
                    i2 = m.e.r1(parcel, readInt);
                    break;
                case 3:
                    i3 = m.e.r1(parcel, readInt);
                    break;
                case 4:
                    i4 = m.e.r1(parcel, readInt);
                    break;
                case 5:
                    i5 = m.e.r1(parcel, readInt);
                    break;
                case 6:
                    i6 = m.e.r1(parcel, readInt);
                    break;
                case 7:
                    i7 = m.e.r1(parcel, readInt);
                    break;
                default:
                    m.e.K1(parcel, readInt);
                    break;
            }
        }
        m.e.W(parcel, W1);
        return new TemporaryExposureKey(bArr, i2, i3, i4, i5, i6, i7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TemporaryExposureKey[] newArray(int i2) {
        return new TemporaryExposureKey[i2];
    }
}
