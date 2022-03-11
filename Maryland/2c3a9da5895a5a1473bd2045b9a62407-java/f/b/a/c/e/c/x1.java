package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.b.a.m;
import f.b.a.c.f.b.b;
import java.util.ArrayList;

public final class x1 implements Parcelable.Creator<w1> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final w1 createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        ArrayList arrayList = null;
        IBinder iBinder = null;
        ArrayList arrayList2 = null;
        b bVar = null;
        String str = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = m.h.N(parcel, readInt, TemporaryExposureKey.CREATOR);
                    break;
                case 2:
                    iBinder = m.h.S0(parcel, readInt);
                    break;
                case 3:
                    arrayList2 = m.h.N(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 4:
                    bVar = (b) m.h.I(parcel, readInt, b.CREATOR);
                    break;
                case 5:
                    str = m.h.L(parcel, readInt);
                    break;
                case 6:
                    iBinder2 = m.h.S0(parcel, readInt);
                    break;
                default:
                    m.h.k1(parcel, readInt);
                    break;
            }
        }
        m.h.T(parcel, v1);
        return new w1(arrayList, iBinder, arrayList2, bVar, str, iBinder2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ w1[] newArray(int i2) {
        return new w1[i2];
    }
}
