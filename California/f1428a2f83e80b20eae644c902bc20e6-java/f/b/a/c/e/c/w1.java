package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.b.a.m;
import f.b.a.c.f.b.b;
import java.util.ArrayList;

public final class w1 implements Parcelable.Creator<v1> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final v1 createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        ArrayList arrayList = null;
        IBinder iBinder = null;
        ArrayList arrayList2 = null;
        b bVar = null;
        String str = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = m.h.N(parcel, readInt, TemporaryExposureKey.CREATOR);
                    break;
                case 2:
                    iBinder = m.h.R0(parcel, readInt);
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
                    iBinder2 = m.h.R0(parcel, readInt);
                    break;
                default:
                    m.h.j1(parcel, readInt);
                    break;
            }
        }
        m.h.T(parcel, u1);
        return new v1(arrayList, iBinder, arrayList2, bVar, str, iBinder2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v1[] newArray(int i2) {
        return new v1[i2];
    }
}
