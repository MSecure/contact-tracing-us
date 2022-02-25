package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.b.a.m;

public final class p implements Parcelable.Creator<TemporaryExposureKey> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final TemporaryExposureKey createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    bArr = m.h.B(parcel, readInt);
                    break;
                case 2:
                    i2 = m.h.T0(parcel, readInt);
                    break;
                case 3:
                    i3 = m.h.T0(parcel, readInt);
                    break;
                case 4:
                    i4 = m.h.T0(parcel, readInt);
                    break;
                case 5:
                    i5 = m.h.T0(parcel, readInt);
                    break;
                case 6:
                    i6 = m.h.T0(parcel, readInt);
                    break;
                default:
                    m.h.k1(parcel, readInt);
                    break;
            }
        }
        m.h.T(parcel, v1);
        return new TemporaryExposureKey(bArr, i2, i3, i4, i5, i6);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TemporaryExposureKey[] newArray(int i2) {
        return new TemporaryExposureKey[i2];
    }
}
