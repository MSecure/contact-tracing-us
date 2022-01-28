package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.b.a.m;
import f.b.a.c.f.b.b;
import java.util.ArrayList;

public final class z1 implements Parcelable.Creator<y1> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final y1 createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        ArrayList arrayList = null;
        IBinder iBinder = null;
        ArrayList arrayList2 = null;
        b bVar = null;
        String str = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = m.h.O(parcel, readInt, TemporaryExposureKey.CREATOR);
                    break;
                case 2:
                    iBinder = m.h.Y0(parcel, readInt);
                    break;
                case 3:
                    arrayList2 = m.h.O(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 4:
                    bVar = (b) m.h.J(parcel, readInt, b.CREATOR);
                    break;
                case 5:
                    str = m.h.M(parcel, readInt);
                    break;
                case 6:
                    iBinder2 = m.h.Y0(parcel, readInt);
                    break;
                default:
                    m.h.q1(parcel, readInt);
                    break;
            }
        }
        m.h.T(parcel, B1);
        return new y1(arrayList, iBinder, arrayList2, bVar, str, iBinder2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ y1[] newArray(int i2) {
        return new y1[i2];
    }
}
