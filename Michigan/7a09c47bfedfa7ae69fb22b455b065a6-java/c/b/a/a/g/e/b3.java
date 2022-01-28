package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.ArrayList;

public final class b3 implements Parcelable.Creator<a3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final a3 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        ArrayList arrayList = null;
        IBinder iBinder = null;
        ArrayList arrayList2 = null;
        ExposureConfiguration exposureConfiguration = null;
        String str = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = t.e0(parcel, readInt, TemporaryExposureKey.CREATOR);
                    break;
                case 2:
                    iBinder = t.s2(parcel, readInt);
                    break;
                case 3:
                    arrayList2 = t.e0(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 4:
                    exposureConfiguration = (ExposureConfiguration) t.a0(parcel, readInt, ExposureConfiguration.CREATOR);
                    break;
                case 5:
                    str = t.b0(parcel, readInt);
                    break;
                case 6:
                    iBinder2 = t.s2(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new a3(arrayList, iBinder, arrayList2, exposureConfiguration, str, iBinder2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a3[] newArray(int i) {
        return new a3[i];
    }
}
